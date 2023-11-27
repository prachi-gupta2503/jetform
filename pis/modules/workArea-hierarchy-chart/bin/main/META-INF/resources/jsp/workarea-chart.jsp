<%@page import="com.adjecti.mdm.liferay.model.WorkArea"%>
<%@page import="com.adjecti.mdm.liferay.service.WorkAreaLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.util.MDMUtils"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONSerializer"%>
<%@page import="com.adjecti.liferay.workarea.hierarchy.modelview.Node"%>
<%@page import="java.util.List"%>
<%@page import="com.adjecti.liferay.workarea.hierarchy.util.WorkAreaTreeNodes"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.adjecti.liferay.workarea.hierarchy.constants.MVCCommandNames"%>
<%@ include file="/init.jsp" %>

<portlet:resourceURL id="<%= MVCCommandNames.WORKAREA_SEARCH%>" var="searchWorkArea">
</portlet:resourceURL>
<portlet:renderURL var="addWorkAreaURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/jsp/addWorkArea.jsp" />
</portlet:renderURL>
 <%!
    JSONSerializer jsonSerializer = JSONFactoryUtil.createJSONSerializer();
    %>
<%
List<Node> nodeList = new WorkAreaTreeNodes().getNodes(); 
String testData= JSONFactoryUtil.looseSerializeDeep(nodeList);
%>


<div id="container" class="row">
<div id="myTreeView" class="col-sm-4">
</div>
<div id="subtreeView"class="col-sm-8"></div>
</div>
<script type="text/javascript">

 var treeData=<%=testData%>
 
function addWorkAreaNode(parentId){
	$('.actionspan').remove();

	var url="<%=addWorkAreaURL%>&<portlet:namespace />parentId="+parentId;
  	Liferay.Util.openWindow({
  	    dialog: {
  	        centered: true,
  	        height: 600,
  	        modal: true,
  	        width: 800,
  	        cssClass: "ui-model",
  	        destroyOnHide: true,
              resizable: false,
              
  	    },
  	    id: "<portlet:namespace />dialogId",
  	    title: "Add WorkArea",
  	    uri: url
  	}); 
    Liferay.provide(window, '<portlet:namespace />closePopup', function(popUpId) {
        Liferay.Util.Window.getById(popUpId).destroy();
        location.reload();
    },
    ['liferay-util-window']
    );

  }
  
function editWorkAreaNode(workAreaId){
	$('.actionspan').remove();
  	 var url="<%=addWorkAreaURL%>&<portlet:namespace />workAreaId="+workAreaId;
  	Liferay.Util.openWindow({
  	    dialog: {
  	        centered: true,
  	        height: 600,
  	        modal: true,
  	        width: 800,
  	        cssClass: "ui-model",
  	        destroyOnHide: true,
              resizable: false,             
  	    },
  	    id: "<portlet:namespace />dialogId",
  	    title: "Edit WorkArea",
  	    uri: url
  	}); 
    Liferay.provide(window, '<portlet:namespace />closePopup', function(popUpId) {
        Liferay.Util.Window.getById(popUpId).destroy();
        location.reload();
    },
    ['liferay-util-window']
    ); 

  } 

 function removeWorkAreaNode(id){
        $('.actionspan').remove();
         Liferay.Service(
		             '/mdm.workarea/check-subwork-area',
		              {
		                  workAreaId: id
		              },
		  function(obj) {
			if(obj==false)
		       {
			  Liferay.Service(
					  '/mdm.workarea/delete-work-area',
					  {
					    workAreaId: id
					  },
					  function(obj) {
					    location.reload();
					  }
					);		  
		  }
		       else{
			       alert("Delete It's SubWorkAreas First");  
		           }
		       }		  
		);
}

/*  $(document).ready(function(){ */
	 
		setTimeout(function(){ 
			
			$('.tree-label').click(function(){
				
				$(this).after(function() {
					 var nodeId = $(this).closest("li").attr("id");
					 myFunction(nodeId);
					 $('.actionspan').remove();
					 return "<span class='actionspan'>&nbsp;&nbsp;<a onClick='addWorkAreaNode("+nodeId+")'>ADD</a>&nbsp;&nbsp;<a onClick='removeWorkAreaNode("+nodeId+")'>Remove</a>&nbsp;&nbsp;<a onClick='editWorkAreaNode("+nodeId+")'>Edit</a></span>";
					});				
			});
			}, 1000);
	 
/* }); */	
 
 function myFunction(nId){	
	 $('.nID').remove();

    $.ajax({
           url:"<%=searchWorkArea%>&<portlet:namespace />id="+nId,
           type: 'GET',
           datatype:'json',
           sync: true,
           success: function(response){	
    	            treeData=JSON.parse(response);
                    $('#subtreeView').append('<div name=nId id=' +nId+ ' class=nID><ul id="list"></ul></div>');
                    for(var i=0;i<treeData.length;i++){
                               $('#list').append('<li><div><span class=tree-label style=user-select:none;>'+treeData[i].name+'</div></span></li>');
                       }
                  }
         });   
 }

YUI().use(
		  'aui-tree-view',
		  function(Y) {
		    var treeview = new Y.TreeView(
		      {
		        boundingBox: '#myTreeView',
		        children: treeData
		  
		      }
		    ).render();
		  }
		); 
</script>

			
<aui:script use="aui-base">
AUI().ready(function(){
Liferay.Util.getOpener().<portlet:namespace/>closePopup(
				'<portlet:namespace/>dialogId');
})

	Liferay.provide(window, '<portlet:namespace />closePopUp',
			function(dialog) {
				<!-- var dial = Liferay.Util.Window.getById(dialog); -->
				var dial = Liferay.Util.getWindow(dialog);
				dial.destroy();
			}, [ 'liferay-util-window' ]);
</aui:script>
	