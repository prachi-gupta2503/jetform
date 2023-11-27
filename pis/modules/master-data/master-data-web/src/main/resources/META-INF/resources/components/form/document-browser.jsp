<%@page import="com.liferay.portal.kernel.util.PwdGenerator"%>
<%@page import="java.util.UUID"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.adjecti.jetform.liferay.service.DocumentLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.document.library.kernel.model.DLFolderConstants"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@ include file="/init.jsp"%>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
<style>
.aui-tree-file .aui-tree-icon {
    width: 0px;
}
.btn-ok{
   	padding-left:20px; 
   	padding-right:20px;
}
</style>
<%!private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.file_005fbrowser_jsp");%>
<%---------Load the assets from DMS--------%>
<%
	long repositoryId = themeDisplay.getScopeGroupId();
	long rootFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
	String idField=ParamUtil.get(request, "documentElement", "");
	String labelField=idField+"_fileName";
	/*JSONArray treeJsonArray = 
	pageContext.setAttribute("repositoryId", repositoryId);
	pageContext.setAttribute("data", treeJsonArray);*/
%>

<div class="container" style="margin: 0 10px 0px 10px;">
	<div class="row" style="width: 1000px !important; margin: 0px; padding-top: 20px !important;">
		<div class="col-md-6" style="padding:20px 0px 20px 20px; border: 1px solid #f1f1f1;">
			<div style="height:450px !important; overflow: scroll !important;">
				<div id="dlTreeView" class="custom-tree" style=""></div>
			</div>
		</div>
		<div class="col-md-6" style="padding:20px;  border: 1px solid #f1f1f1;">
			<div style="height:450px !important; background-color: #f7f8f9; "></div>
		</div>
	</div>
	<div class="row" style="padding:20px;">
		<div class="col-md-12">
			<aui:input type="hidden" name="<%=idField%>"/>
			<aui:input type="hidden" name="<%=labelField%>"/>
			<div style="float: right;" >
				<button type="button" class="btn btn-default" style="margin-right:20px;" name="<portlet:namespace />cancel" id="<portlet:namespace />cancel" value="Cancel">Cancel</button>
				<button type="button" class="btn btn-primary btn-ok" name="<portlet:namespace />ok" id="<portlet:namespace />ok" value="Select">OK</button>
			</div>
		</div>
	</div>
</div>

<aui:script use="aui-base, liferay-portlet-url">
	var repositoryId=<%=repositoryId%>;
	var rootFolderId=<%=rootFolderId%>;
	var fileFolderStatus=0;
	var includeMountFolders=true;
	var treeView;
	$(document).ready(function() {
		
		initTree();
	
	});

	function initTree(){
		
		$('#dlTreeView').html('');
		
		YUI().ready('aui-tree-view','io-xdr','aui-button','node', function(Y) {
			
			getFoldersAndFiles(repositoryId, rootFolderId, fileFolderStatus, includeMountFolders, function(data){
			//getFolders(repositoryId, rootFolderId, includeMountFolders, function(data){
				
				var treeData = toTreeData(data, rootFolderId);
				
				var children = {
                        cache :false,
                        label :'/',
                        id :rootFolderId,
                        leaf:false,
                        draggable :false,
                        expanded: true,
                        children: treeData
                    };
                    
				treeView = new Y.TreeView({
			
					boundingBox : '#dlTreeView',
					children : [children],

				}).render();
				
				treeView.on("*:expandedChange",function(e) {
					console.log('*:expandedChange');
					console.log(e);
					addChildren(treeView, e);
				});
				
				treeView.after("lastSelectedChange",function(e) {
					lastSelectedChange(e);
				});
			});
		});
	}
	
	function addChildren(treeView, e) {
		
		var parentNodeId = e.details[0].currentTarget.get('id');
		var parentNode = treeView.getNodeById(parentNodeId);
		
		//alert(parentNodeId+" - "+parentNode);
		
		if(parentNode.getChildren() && parentNode.getChildren().length>0){
			return false;
		}
		
		getFoldersAndFiles(repositoryId, parentNodeId, fileFolderStatus, includeMountFolders, function(data){
		//getFolders(repositoryId, parentNodeId,includeMountFolders, function(data){
			var children = toTreeData(data, parentNodeId);
		
			$.each(children, function( index, item ) {
		
				var child = parentNode.createNode(item);
				parentNode.appendChild(child);
		
			});
		});
	}
	
	function lastSelectedChange(e){
		console.log('lastSelectedChange');
		console.log(e);
		var id = e.newVal.get('id');
		var label = e.newVal.get('label');
		//alert(id+" ============= "+label);
		$('#<portlet:namespace /><%=idField%>').val(id);
		$('#<portlet:namespace /><%=labelField%>').val(label);
	}
	
	function getFoldersAndFiles(repositoryId, folderId, status, includeMountFolders, callback) {
		
		Liferay.Service('/dlapp/get-folders-and-file-entries-and-file-shortcuts',
		{
		    repositoryId: repositoryId,
		    folderId: folderId,
		    status: status,
		    includeMountFolders: includeMountFolders,
		    start: -1,
		    end: -1
		},
		function(response) {
		    callback(response);
		});
	}
	
	function getFolders(repositoryId, folderId, includeMountFolders, callback) {
		
		Liferay.Service('/dlapp/get-folders',
		{
		    repositoryId: repositoryId,
		    parentFolderId: folderId,
		    includeMountFolders: includeMountFolders
		},
		function(response) {
		    callback(response);
		});
	}
		
	function toTreeData(data, parentFolderId){
		var result=[];
		var i=0;
		
		$.each(data, function( index, item ) {
	
			if(item.fileEntryId && item.fileEntryId!=''){
				result[i++]={id:item.fileEntryId, label:item.fileName, type:'node', leaf:true};
			}else if(!item.fileShortcutId && item.folderId!=parentFolderId){
				result[i++]={id:item.folderId, label:item.name, type:'node', leaf:false};
			}
	
		});
		
		return result;
	}

	<!-- For Closing Dialog-->
	A.one('#<portlet:namespace/>ok').on('click', function(event) {
		var fileEntryId=$('#<portlet:namespace /><%=idField%>').val();
		var fileName=$('#<portlet:namespace /><%=labelField%>').val();
		//alert(fileEntryId+" -- "+fileName);
	    var data = {
	    	fileEntryId:fileEntryId, 
	    	fileName: fileName
	    };
		Liferay.Util.getOpener().<portlet:namespace/><%=idField%>_closeDialog(data);
	});
	
	A.one('#<portlet:namespace/>cancel').on('click', function(event) {
		Liferay.Util.getOpener().<portlet:namespace/><%=idField%>_closeDialog();
	});	
</aui:script>
