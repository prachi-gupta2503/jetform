<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp"%>

<% 
  final  Log log = LogFactoryUtil.getLog("org.apache.jsp.components.form_002dlist_restful_jsp");

boolean isSuperAdmin=request.isUserInRole("SUPER ADMIN")|| request.isUserInRole("administrator")||request.isUserInRole("Power User");
%>
<div class="page-wrapper">
	<div class="content container-fluid">
		<liferay-util:include page="/components/list/form-list-restful.jsp" servletContext="<%=application%>">
			<liferay-util:param name="top.header.template" value="/master_list_header.jsp" />
			<liferay-util:param name="top.action.template" value="/master_list_top_actions.jsp" />
			<liferay-util:param name="action.redirect.url" value="/master_list.jsp" />
		</liferay-util:include>
	</div>
</div>
<%
HtmlFormWrapper form = (HtmlFormWrapper)request.getAttribute("form");
log.info("form :"+form);
%>
<portlet:renderURL var="approveMaster" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/master_approve.jsp" />
	<portlet:param name="formClass" value="<%=form.getFormClass()%>" />
	<portlet:param name="formId" value="<%=form.getId()%>" />
</portlet:renderURL>

<portlet:renderURL var="activeRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/components/form/form-active.jsp" />
	<portlet:param name="formClass" value="<%=form.getFormClass()%>" />
	<portlet:param name="dialogMode" value="true" />
</portlet:renderURL>

<aui:script>
var idamFailedCount=0;
function <%=form.getId()%>beforeDocumentOnReady(){
  
 Liferay.Service(
  '/pis.idamfailedtransaction/get-idam-failed-transaction-count',
  function(idamFailedCount) {
      idamFailedCount= idamFailedCount;
      
  }
);
}


function <%=form.getId()%>beforeInitRowActions(){
 
 if(idamFailedCount > 0 || !isSuperAdmin ){
          
     var editLink=$("a[name='<portlet:namespace/><%=form.getId()%>edit']");
	//editLink.removeClass("active");
	editLink.children("i").addClass("inactive");
	
	var deleteLink=$("a[name='<portlet:namespace/><%=form.getId()%>delete']");
	//deleteLink.removeClass("active");
	deleteLink.children("i").addClass("inactive");
	
	var approveLink=$("a[name='<portlet:namespace/><%=form.getId()%>approve']");
	//approveLink.removeClass("active");
	approveLink.children("i").addClass("inactive");
    return false;
    
   }
 else {
 	return true;
 }
     	
   
	
} 

function <%=form.getId()%>afterInitAddAction(){

if(idamFailedCount > 0 || !isSuperAdmin ){
	var addLink=$("#<portlet:namespace/><%=form.getId()%>add");
	console.log(addLink);
	$("#<portlet:namespace/><%=form.getId()%>add").hide();
	
	return false;
  
  }
  else{
  	return true;
  }
}


function <portlet:namespace/><%=form.getId()%>approveHandleOnClick(actionSource){
	console.log($(actionSource).attr("data-key"));
	var dialogId='<portlet:namespace/><%=form.getId()%>openDialog';
	var closeFunc='<portlet:namespace /><%=form.getId()%>closeDialog';
	var url= '<%=approveMaster.toString()%>&<portlet:namespace/>formClassPK='+$(actionSource).attr("data-key");
	url+='&<portlet:namespace/>dialogId='+dialogId;
	url+='&<portlet:namespace/>closeFunc='+closeFunc;
	var title ='Approve <%=form.getTitle()%>';
	var width = 640;
	LiferayUtilOpenWindow(dialogId, title, url, true, 320, true, width);
}


Liferay.provide(window, '<portlet:namespace/><%=form.getId()%>activeHandleOnClick',function(actionSource){
	var dialogId='<portlet:namespace/><%=form.getId()%>openDialog';
	var closeFunc='<portlet:namespace /><%=form.getId()%>closeDialog';
	var url= '<%=activeRenderURL.toString() %>&<portlet:namespace/>formClassPK='+$(actionSource).attr("data-key")+'&<portlet:namespace/>formId=<%=form.getId()%>';
	url+='&<portlet:namespace/>dialogId='+dialogId;
	url+='&<portlet:namespace/>closeFunc='+closeFunc;
	
	var title ='<%="Active " + form.getTitle() %>';
	var width = 640;
	LiferayUtilOpenWindow(dialogId, title, url, true, 240, true, width);
});

Liferay.provide(
	window,
	'<portlet:namespace />approveMaster_closeDialog',
	function(data) {
		if(data){
			console.log(data);	
		}
		var dialog;
		if(data.dialogId){
			alert("inside this?");
			dialog = Liferay.Util.Window.getById(data.dialogId);
		}else{
			dialog = Liferay.Util.Window.getById('<portlet:namespace/>approveMaster_openDialog');
		}
		
		dialog.destroy();
		
		//Update table has been temporarily commented due to slowness issue
		//IDAMUserForm_123456updateTable();
	},
	['liferay-util-window']
);
</aui:script>