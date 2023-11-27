<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.security.auth.PrincipalThreadLocal"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.document.library.kernel.model.DLFileEntryConstants"%>
<%@page import="com.liferay.portal.kernel.util.PropsKeys"%>
<%@page import="com.liferay.portal.kernel.util.PrefsPropsUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.DecimalFormatSymbols"%>
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

<style>
	.aui-tree-file .aui-tree-icon {
    width: 0px;
}
</style>

<%!private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.document-005fadder_jsp");%>

<style>
	.upload-document label {
		position: relative;
	}
	
	.help-text {
		position: absolute;
		left: 90px;
		top: 0px;
	}
	
	.nav-item{
		border: 1px solid transparent !important;
	}
    .inputDnD .form-control-file {
      position: relative;
      width: 100%;
      /*height: 100%;*/
      min-height: 7em;
      outline: none;
      visibility: hidden;
      cursor: pointer;
      background-color: #c61c23;
      box-shadow: 0 0 5px solid currentColor;
    }
    .inputDnD .form-control-file:before {
      content: attr(data-title);
      position: absolute;
      top: 0.5em;
      left: 0;
      width: 100%;
      min-height: 6em;
      line-height: 2em;
      padding-top: 1.5em;
      opacity: 1;
      visibility: visible;
      text-align: center;
      /*border: 0.25em dashed currentColor;*/
      border: 3px dashed currentColor;
      -webkit-transition: all 0.3s cubic-bezier(0.25, 0.8, 0.25, 1);
      transition: all 0.3s cubic-bezier(0.25, 0.8, 0.25, 1);
      overflow: hidden;
    }
    .inputDnD .form-control-file:hover:before {
      border-style: solid;
      /*box-shadow: inset 0px 0px 0px 0.25em currentColor;*/
      box-shadow: inset 0px 0px 0px 2px currentColor;
    }

    .m-b-1 {
      background-color: #f7f7f9;
    }
    
    .progress-bar{
    	border-radius: 0px !important;
    } 
    
    .upload-button{
    	margin-top:20px;
    }
    
    .btn-ok{
    	padding-left:20px; 
    	padding-right:20px;
    }
    .tab-pane{
    	padding-top:10px;
    }
    
    .input-group{
		padding:10px;
		margin: auto;
		text-align: center;
	}
</style>
<!-- --------Load the assets from DMS----------- -->
<%
	String uploadProgressBarId = PwdGenerator.getPassword(PwdGenerator.KEY3, 4);
	
	long repositoryId = themeDisplay.getScopeGroupId();
	long rootFolderId = 75205;//DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
	
	String idField=ParamUtil.get(request, "documentElement", "");
	String labelField=idField+"_fileName";
	String source=ParamUtil.get(request, "souce", "");
	//User user=UserLocalServiceUtil.getUser(PrincipalThreadLocal.getUserId());
%>

<div class="container" style="max-width: 100%;">
	<div class="row">
		<div class="col-md-12">
			<ul class="nav nav-tabs toobar-backg id="loadDocumentTab" role="tablist">
<%
				if(StringUtils.isEmpty(source) || StringUtils.equalsIgnoreCase(source, "upload")){
%>				
				<li class="nav-item"><a class="nav-link active" id="localDir-tab" data-toggle="tab" href="#localDir" role="tab" aria-controls="localDir" aria-selected="true">Local System</a></li>
<%
				}
				
				if(StringUtils.isEmpty(source) || StringUtils.equalsIgnoreCase(source, "dml")){
%>				
				<li class="nav-item"><a class="nav-link" id="dms-tab" data-toggle="tab" href="#dms" role="tab" aria-controls="dms" aria-selected="false">Document & Media</a></li>
<%
				}
				
				if(StringUtils.isEmpty(source) || StringUtils.equalsIgnoreCase(source, "scan")){
%>				
				<li class="nav-item"><a class="nav-link" id="scanner-tab" data-toggle="tab" href="#scanner" role="tab" aria-controls="scanner" aria-selected="false" onClick="loadScanners();">Scan
						Document</a></li>
<%
				}
%>
			</ul>
		</div>
	</div>

	<div class="row">
		<div class="col-md-12 tab-content content-body">
<%
		if(StringUtils.isEmpty(source) || StringUtils.equalsIgnoreCase(source, "upload")){
%>		
			<div class="tab-pane fade show active" id="localDir" role="tabpanel" aria-labelledby="localDir-tab">
				<div class="container" style="max-width: 100%;">
					<div class="row">
						<div class="col-md-6" style="height:480px; border: 1px solid #f1f1f1; display:flex; justify-content:center; align-items:center;">
					    	<div class="form-group inputDnD" style="width:90%;"><%-- style="height:400px; width:100%; margin-top:20px; padding-top:20px;"> --%>
					    		<div style="text-align: center;">
					      			<button type="button" class="btn btn-default" onclick="document.getElementById('fileInput').click()" style="margin-bottom:10px;">Browse</button>
					      			<p>or</p>
					      		</div>
					        	<label class="sr-only" for="inputFile">File Upload</label>
					        	<input type="file" class="form-control-file text-primary font-weight-bold" id="<%=idField%>_file" name="<%=idField%>_file" onChange="readFileUrl('<%=idField%>_file')" data-title="Drag and drop a file here to upload!">
					        	<div>
					      			<liferay-ui:upload-progress id="<%=uploadProgressBarId%>" message="uploading"/>
					      		</div>
					    		<div>
					    			<button type="button" class="btn btn-default upload-button" id="uploadButton" onClick="uploadFile('<%=idField%>_file', <%=uploadProgressBarId%>, '<%=idField%>', '<%=labelField%>')">Upload</button>
					    		</div>
					      	</div>
		      			</div>
		      			<div class="col-md-6" style="height:480px; border: 1px solid #f1f1f1; display:flex; justify-content:center; align-items:center;">
		    			</div>
		      		</div>
		      	</div>
			</div>
<%
		}

		if(StringUtils.isEmpty(source) || StringUtils.equalsIgnoreCase(source, "dml")){
%>			
			<div class="tab-pane fade" id="dms" role="tabpanel" aria-labelledby="dms-tab">
				<div class="container" style="max-width: 100%;">
					<div class="row">
						<div class="col-md-6" style="height:480px; border:1px solid #e7e7ed; padding:10px; overflow: scroll;">
							<div id="dlTreeView" class="custom-tree" style=""></div>
						</div>
						<div class="col-md-6" style="height:480px; border:1px solid #e7e7ed; padding:10px; overflow: scroll;">
						
						</div>
					</div>
				</div>
			</div>
<%
		}

		if(StringUtils.isEmpty(source) || StringUtils.equalsIgnoreCase(source, "scan")){
%>
			<div class="tab-pane fade" id="scanner" role="tabpanel" aria-labelledby="scanner-tab">
				<%--
				<div class="form-group inputDnD" style="height:400px; width:100%; margin-top:20px;  padding-top:20px;">
					<label for="printerlist">Select Scanner</label>
					<div class="input-group">
						<div class="input-group-prepend">
							<select class="form-control" id="scannerSource">
								<option>Select Scanner</option>
							</select>
						</div>
						<button onclick="AcquireImage();" class="btn btn-sm btn-primary rounded-0">Scan</button>
					</div>
				</div>
				<div id="dwtcontrolContainer"></div>
				--%>
				<div class="container" style="max-width: 100%;">
					<div class="row">
						<div class="col-md-6" style="height:480px; border: 1px solid #f1f1f1; display:flex; justify-content:center; align-items:center;">
							<div style="text-align: center; width:200px; margin: 0 auto;">
								<div class="input-group">
									<select class="form-control" id="scannerSource" style="margin: 0 auto;">
										<option>Select Scanner</option>
									</select>
								</div>
								<div class="input-group">
									<button type="button" style="margin: 0 auto; width:200px" onclick="AcquireImage('scannerSource');" class="btn btn-primary btn-sm">Scan</button>
								</div>
								<div class="input-group">
									<button type="button" style="margin: 0 auto; width:200px" onclick="AcquireImage('scannerSource');" class="btn btn-default btn-sm">Save</button>
								</div>
							</div>
						</div>
						<div class="col-md-6" style="height:480px; border: 1px solid #f1f1f1;">
							<div id="dwtcontrolContainer"></div>
						</div>
					</div>
				</div>
			</div>
<%
		}
%>			
		</div>
	</div>
	<div class="row" style="padding:10px;">
		<div class="col-md-12">
			<aui:input type="hidden" name="<%=idField%>"/>
			<aui:input type="hidden" name="<%=labelField%>"/>
			<div style="float: right;" >
				<button type="button" class="btn btn-default" style="margin-right:10px;" name="<portlet:namespace />cancel" id="<portlet:namespace />cancel" value="Cancel">Cancel</button>
				<button type="button" class="btn btn-primary btn-ok" name="<portlet:namespace />add" id="<portlet:namespace />ok" value="OK">OK</button>
			</div>
		</div>
	</div>
</div>
<%--
<script type="text/javascript">
<!--
var repositoryId=<%=repositoryId%>;
var rootFolderId=<%=rootFolderId%>;
var fileFolderStatus=0;
var includeMountFolders=true;
var treeView;
//-->
</script>
<aui:script use="aui-base, aui-io-request, liferay-portlet-url">

	$(document).ready(function() {
<%
		if(StringUtils.isEmpty(source) || StringUtils.equalsIgnoreCase(source, "dml")){
%>			
			initTree();
<%
		}

		if(StringUtils.isEmpty(source) || StringUtils.equalsIgnoreCase(source, "upload")){
%>		
			A.one("#uploadButton").on("click", function(event){
				uploadFile(<%=uploadProgressBarId%>);
	    	});
<%
		}
%>	    
	});

<%
	if(StringUtils.isEmpty(source) || StringUtils.equalsIgnoreCase(source, "dml")){
%>	
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
		
			console.log(e);
			var parentNodeId = e.details[0].currentTarget.get('id');
			var parentNode = treeView.getNodeById(parentNodeId);
			
			alert(parentNodeId+" - "+parentNode);
			
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
			console.log(e);
			var id = e.newVal.get('id');
			var label = e.newVal.get('label');
			console.log(id+" ============= "+label);
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
<%
	}
%>	
	function addFileEntryWithBytes(repositoryId, folderId, sourceFileName, mimeType, title, description, changeLog, bytes, callBack) {

        Liferay.Service('/dlapp/add-file-entry',
			{
        		p_auth : Liferay.authToken,
        		repositoryId: repositoryId,
	 		    folderId: folderId,
	 		    sourceFileName: sourceFileName,
	 		    mimeType: mimeType,
	 		    title: title,
	 		    description: description,
	 		    changeLog: changeLog,
	 		    bytes: bytes
	 		},
	 		function(response) {
	 			alert("addFileEntryWithBytes");
	 			callBack(response);
	 		}
 		);
	}
	
	A.one('#<portlet:namespace/>ok').on('click', function(event) {
		var fileEntryId=$('#<portlet:namespace /><%=idField%>').val();
		var fileName=$('#<portlet:namespace /><%=labelField%>').val();
		alert(fileEntryId+" -- "+fileName);
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

<%
	if(StringUtils.isEmpty(source) || StringUtils.equalsIgnoreCase(source, "scan")){
%>	
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/dynamsoft/dynamsoft.webtwain.config.js"></script>
	<script type="text/javascript">

	/*	
		var doc = window['document'];
		var temp = function (){	
			docElement = doc && doc.documentElement,
			head = doc.getElementsByTagName('head')[0] || docElement,
			scriptOnload = doc.createElement('script').readyState ?
			function (node, callback) {
		          var oldCallback = node.onreadystatechange;
			  node.onreadystatechange = function () {
			     var rs = node.readyState;
				if (rs === 'loaded' || rs === 'complete') {
					node.onreadystatechange = null;
					oldCallback && oldCallback();
					callback.call(this);
					}
				};
			} :
			function (node, callback) {
				node.addEventListener('load', callback, false);
				node.addEventListener('error', callback, false);
			};
		}
		
		temp.prototype.getScript = function(url, isAsync, callback) {
			var node, u;
			if (!(callback && typeof (callback) === 'function')) {
					callback = function () { };
				}
			
				node = doc.createElement('script');
			
				u = ['', url].join("");
				node.src = u;
			
				if (isAsync)
				node.async = true;
				node.charset = 'utf-8';
				scriptOnload(node, callback);
				head.insertBefore(node, head.firstChild);
			return node;
		}
	*/	             
		var DWObject;
	        
	    function AcquireImage(scannerSource) {
	        if (DWObject) {
				var OnAcquireImageSuccess, OnAcquireImageFailure;
				OnAcquireImageSuccess = OnAcquireImageFailure = function (){
					DWObject.CloseSource();
				};
				
	            DWObject.SelectSourceByIndex(document.getElementById(scannerSource).selectedIndex);
	            DWObject.OpenSource();
	            DWObject.IfDisableSourceAfterAcquire = true;	// Scanner source will be disabled/closed automatically after the scan.
	            DWObject.AcquireImage(OnAcquireImageSuccess, OnAcquireImageFailure);
	        }
	    }
	    
		function saveScannedImage() {
			var pages = [];
			if (DWObject) {
	
				// If no image in buffer, return the function
				if (DWObject.HowManyImagesInBuffer == 0)
					return;
				else {
					for (var i = 0; i < DWObject.HowManyImagesInBuffer; i++) {
						pages.push(i);
					}
					DWObject.ConvertToBase64(pages, EnumDWT_ImageType.IT_PDF,
							scanningSuccessFunc, scanningFailureFunc);
				}
			}
		}
	
		function scanningSuccessFunc(result) {
			var bytes = result.getData(0, length).toString();
	        var sourceFileName=(new Date().getTime())+".pdf";
	        var mimeType='';
	        var title=sourceFileName;
	        var description="Scanned file";
	        var changeLog=description;
	        
	        addFileEntryWithBytes(repositoryId, rootFolderId, sourceFileName, mimeType, title, description, changeLog, bytes, uploadCallBack);
		}
		
	    function scanningFailureFunc (errorCode, errorString) {
	    	console.log("ErrorCode: "+errorCode +"\r"+"ErrorString:"+ errorString);
		}
	
		function loadScanners(scannerSource){
		 	var _temp = new temp();
		    _temp.getScript("<%=request.getContextPath() %>/js/dynamsoft/dynamsoft.webtwain.initiate.js",true, function(){ 
		    	Dynamsoft.WebTwainEnv.RegisterEvent('OnWebTwainReady', Dynamsoft_OnReady); 
			});
		     
			Dynamsoft.WebTwainEnv.RegisterEvent('OnWebTwainReady', Dynamsoft_OnReady); // Register OnWebTwainReady event. This event fires as soon as Dynamic Web TWAIN is initialized and ready to be used
			function Dynamsoft_OnReady() {
			    DWObject = Dynamsoft.WebTwainEnv.GetWebTwain('dwtcontrolContainer'); // Get the Dynamic Web TWAIN object that is embeded in the div with id 'dwtcontrolContainer'
			    if (DWObject) {
			        var count = DWObject.SourceCount; // Populate how many sources are installed in the system
			        if(count == 0 && Dynamsoft.Lib.env.bMac){
						DWObject.CloseSourceManager();
						DWObject.ImageCaptureDriverType = 0;
						DWObject.OpenSourceManager();
						count = DWObject.SourceCount;
					}
			
					var scannerSourceList=document.getElementById(scannerSource); 
					for (var i = 0; i < count; i++){
						scannerSourceList.options.add(new Option(DWObject.GetSourceNameItems(i), i+1));  // Add the sources in a drop-down list
					}
				}
			}
		}           
<%
}

if(StringUtils.isEmpty(source) || StringUtils.equalsIgnoreCase(source, "scan")){
%>
   	/***--####### File upload Code #######--***/
   	 
	function readFileUrl(fileInput) {
		alert("readFileUrl(fileInput) : "+fileInput);
		var fileElement=$('#'+fileInput);
		alert("readFileUrl(fileElement) : "+fileElement);
		if(!$(fileElement) || !$(fileElement).prop('files') || $(fileElement).prop('files').length<1){
			return null;
		}

		alert("readFileUrl($(fileElement).prop('files').length) : "+($(fileElement).prop('files').length));
		
		var fileSelected = $(fileElement).prop('files')[0];
	    //if (input.files && input.files[0]) {
	    if(fileSelected){	
	    	
			$(fileElement).attr("data-title", fileSelected.name);
			console.log(fileSelected);
			
			let reader = new FileReader();
			reader.onload = e => {
				let imgData = e.target.result;
				console.log(e.target.result);
			};

			return fileSelected;
		}else{
			return null;
		}
	}
	
	function uploadFile(fileInput, uploadProgressBar, fileIdField, fileNameField){
		
		var fileSelected=readFileUrl(fileInput);
		
		if(!fileSelected){
			return false;
		}
	
        var mimeType='';
        var description="Scanned file";
        var changeLog=description;
        
		if(uploadProgressBar){
			uploadProgressBar.startProgress();
		}
		
		addFileEntryWithFile(repositoryId, rootFolderId, description, fileSelected, function(response){
			uploadCallBack(response, fileIdField, fileNameField);
		});
	}
	
	function addFileEntryWithFile(repositoryId, folderId, description, file, callBack){
		var form = new FormData();
		form.append("file", file, file.name);
		form.append("repositoryId", repositoryId);
		form.append("folderId", folderId);
		form.append("sourceFileName", file.name);
		form.append("mimeType", file.type);
		form.append("title", file.name);
		form.append("description", description);
		form.append("changeLog", "Uploaded file");
		form.append("p_auth", Liferay.authToken);
		
		var settings = {
			"url": "/api/jsonws/dlapp/add-file-entry",
			"method": "POST",
			"timeout": 0,
			"headers": {},
			"processData": false,
			"mimeType": "multipart/form-data",
			"contentType": false,
			"data": form
		};
		
		$.ajax(settings).done(function (response) {
			console.log("addFileEntryWithFile");
			callBack(JSON.parse(response));
			//var resp=JSON.parse(response);
			//alert(resp.fileEntryId);
		});
	}
	
	function uploadCallBack(response, fileIdField, fileNameField){
		console.log(response);

		$('#'+fileIdField).val(response.fileEntryId);
		$('#'+fileNameField).val(response.fileName);
	}
<%
}
%>
</script>
 --%>
<%--
<aui:script use="liferay-upload">
new Liferay.Upload(
        {
            boundingBox: '#<portlet:namespace />fileUpload',
            deleteFile: '<liferay-portlet:actionURL doAsUserId="<%=user.getUserId() %>"><portlet:param name="struts_action" value="/document_library/edit_file_entry" /><portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE_TEMP %>" /><portlet:param name="folderId" value="<%= String.valueOf(rootFolderId) %>" /></liferay-portlet:actionURL>&ticketKey=<%="fdsdsdsds"%><liferay-ui:input-permissions-params modelName="<%= DLFileEntryConstants.getClassName() %>" />',
            fileDescription: '<%= StringUtil.merge(PrefsPropsUtil.getStringArray(PropsKeys.DL_FILE_EXTENSIONS, StringPool.COMMA)) %>',
            maxFileSize: '<%= PrefsPropsUtil.getLong(PropsKeys.DL_FILE_MAX_SIZE) %> B',
            metadataContainer: '#<portlet:namespace />commonFileMetadataContainer',
            metadataExplanationContainer: '#<portlet:namespace />metadataExplanationContainer',
            namespace: '<portlet:namespace />',
            tempFileURL: {
                method: Liferay.Service.bind('/dlapp/get-temp-file-entry-names'),
                params: {
                    groupId: <%= repositoryId %>,
                    folderId: <%= rootFolderId %>,
                    tempFolderName: 'com.liferay.portlet.documentlibrary.action.EditFileEntryAction'
                }
            },
            tempRandomSuffix: '<%= "43345332" %>',
            uploadFile: '<liferay-portlet:actionURL doAsUserId="<%= user.getUserId() %>"><portlet:param name="struts_action" value="/document_library/edit_file_entry" /><portlet:param name="<%= Constants.CMD %>" value="<%= Constants.ADD_TEMP %>" /><portlet:param name="folderId" value="<%= String.valueOf(rootFolderId) %>" /></liferay-portlet:actionURL>&ticketKey=<%= "fdsdsdsds" %><liferay-ui:input-permissions-params modelName="<%= DLFileEntryConstants.getClassName() %>" />'
        }
    );
</aui:script>
--%>