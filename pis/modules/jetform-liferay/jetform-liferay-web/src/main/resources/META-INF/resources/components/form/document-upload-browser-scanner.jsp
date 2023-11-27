<%@page import="com.liferay.portal.kernel.util.PwdGenerator"%>
<%@page import="java.util.UUID"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.adjecti.jetform.liferay.service.DocumentLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.document.library.kernel.model.DLFolderConstants"%>
<%@page import="com.adjecti.jetform.liferay.constants.MVCCommandNames"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@ include file="/init.jsp"%>

<%!private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.file_005fbrowser_jsp");%>

<portlet:actionURL name="<%=MVCCommandNames.ADD_DOCUMENT%>" var="addDocumentURL" />

<style>
.upload-document label {
	position: relative;
}

.help-text {
	position: absolute;
	left: 90px;
	top: 0px;
}
</style>
<style>   
    .inputDnD .form-control-file {
      position: relative;
      width: 100%;
      height: 100%;
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
      border: 0.25em dashed currentColor;
      -webkit-transition: all 0.3s cubic-bezier(0.25, 0.8, 0.25, 1);
      transition: all 0.3s cubic-bezier(0.25, 0.8, 0.25, 1);
      overflow: hidden;
    }
    .inputDnD .form-control-file:hover:before {
      border-style: solid;
      box-shadow: inset 0px 0px 0px 0.25em currentColor;
    }

    .m-b-1 {
      background-color: #f7f7f9;
    }
</style>
<!-- --------Load the assets from DMS----------- -->
<%
	String uploadProgressBarId = PwdGenerator.getPassword(PwdGenerator.KEY3, 4);
	
	long repositoryId = themeDisplay.getScopeGroupId();
	long rootFolderId = 75205; //DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
	LOGGER.info("repositoryId:rootFolderId # " + repositoryId + ":" + rootFolderId);
	JSONArray treeJsonArray = DocumentLocalServiceUtil.getTree(repositoryId, rootFolderId);
	pageContext.setAttribute("repositoryId", repositoryId);
	pageContext.setAttribute("data", treeJsonArray);
	
%>

<div class="container">
	<div class="row">
		<div class="col-md-12">
			<ul class="nav nav-tabs" id="loadDocumentTab" role="tablist">
				<li class="nav-item"><a class="nav-link active" id="localDir-tab" data-toggle="tab" href="#localDir" role="tab" aria-controls="localDir" aria-selected="true">Local System</a></li>
				<li class="nav-item"><a class="nav-link" id="dms-tab" data-toggle="tab" href="#dms" role="tab" aria-controls="dms" aria-selected="false">Document & Media</a></li>
				<li class="nav-item"><a class="nav-link" id="scanner-tab" data-toggle="tab" href="#scanner" role="tab" aria-controls="scanner" aria-selected="false" onClick="loadScanners();">Scan
						Document</a></li>
			</ul>
		</div>
	</div>

	<div class="row">
		<div class="col-md-12 content-body">
			<%--<div class="tab-content" id="myTabContent">--%>
				<div class="tab-pane fade show active" id="localDir" role="tabpanel" aria-labelledby="localDir-tab">
					<form id="uploadForm" method="post" enctype="multipart/form-data">
						<input type="hidden" name="repositoryId" id="repositoryId" value="20123">
						<input type="hidden" name="folderId" id="folderId" value="75823">
						<input type="hidden" name="sourceFileName" id="sourceFileName" value="sourceFileName">
						<input type="hidden" name="mimeType" id="mimeType" value="">
						<input type="hidden" name="title" id="title" value="sourceFileName">
						<input type="hidden" name="description" id="description" value="sourceFileName">
						<input type="hidden" name="changeLog" id="changeLog" value="sourceFileName">
										
						<div class="upload-document modal-body-height scroller" id="modal-body-height">
							<div class="container">
								<div class="row m-b-1">
								    <div class="col-md-12">
								    	<div class="form-group inputDnD" style="width:100%; padding-top:20px;">
								    		<div>
								      			<button type="button" class="btn btn-primary btn-block" onclick="document.getElementById('fileInput').click()" >Browse</button>
								      		</div>
								        	<label class="sr-only" for="inputFile">File Upload</label>
								        	<input type="file" class="form-control-file text-primary font-weight-bold" id="fileInput" name="fileInput" onchange="readFileUrl(this)" style="margin-bottom:20px;" data-title="Browse or Drag &amp; drop a file">
								      	</div>
								    </div>
								</div>
								<div class="row">
									<div class="col-md-12" style="padding-top:20px;">
								    	<liferay-ui:upload-progress id="<%=uploadProgressBarId%>" message="uploading"/>
								    </div>
								</div>
								<div class="row">
								    <div class="col-md-12" style="padding-top:20px;">
								    	<button type="button" class="btn btn-primary btn-sm" id="uploadButton">Upload</button>
								    </div>
								</div>
							</div>
						</div>
					</form>
				</div>

				<div class="tab-pane fade" id="dms" role="tabpanel" aria-labelledby="dms-tab">
					<aui:form id="dmsDocForm" action="<%=addDocumentURL%>">
						<div class="upload-document p-3 modal-body-height scroller" id="modal-body-height">
							<div class="upload-title mb-2">
								<h4>Document & Media</h4>
							</div>
							<div id="mynewTreeView" class="custom-tree"></div>
							<div class="form-group">
								<aui:input type="hidden" name="fileEntryId" id="fileEntryId" />
								<span id="rctValidator" style="color: red;"></span>
							</div>
						</div>
						<footer class="sheet-footer dialog-footer">
							<div class="px-3">
								<button type="submit" class="btn btn-primary btn-sm" name="<portlet:namespace/>docType" id="<portlet:namespace/>docType" value="dmsDocument">Submit</button>
							</div>
						</footer>
					</aui:form>
				</div>

				<div class="tab-pane fade" id="scanner" role="tabpanel" aria-labelledby="scanner-tab">
					<form>
						<div class="form-row">
							<div class="col-md-12">
								<label for="printerlist">Select Scanner</label>
								<div class="input-group">
									<div class="input-group-prepend">
										<select class="form-control" id="source"></select>
									</div>
									<button onclick="AcquireImage();" class="btn btn-sm btn-primary rounded-0">Scan</button>
								</div>
							</div>
						</div>
					</form>
					<div class="scansubmit">
						<aui:form id="scannedDocForm" name="scannedDocForm" action="<%=addDocumentURL%>" method="post" enctype="multipart/form-data">
							<div class="form-group">
								<aui:input type="hidden" name="uploadedFileId" id="uploadedFileId" />
								<span id="rctValidator" style="color: red;"></span>
								<aui:input type="hidden" name="docType" id="docType" value="uploadedDocument" />
							</div>
		
							<footer class="sheet-footer dialog-footer">
								<button type="submit" class="btn btn-primary btn-sm" onclick="event.preventDefault();saveScannedImage();">Add Document</button>
		
							</footer>
						</aui:form>
		
					</div>
					<div id="dwtcontrolContainer"></div>
				</div>
			</div>
		</div>
	</div>
</div>

<aui:script use="aui-base, aui-io-request, liferay-portlet-url">
	$(document).ready(function() {
		$('#mynewTreeView').html('');
		$('#mynewTreeView').html('');
		YUI().use('aui-tree-view',function(Y) {
			var children = JSON.parse('${data}');
			var treeview = new Y.TreeView({
				boundingBox : '#mynewTreeView',
				children : children,
				after : {
					'*:expandedChange' : function(e) {
						
						addChildren(treeview, e);
					}
				}
			}).render();
	
			treeview.after("lastSelectedChange",function(e) {
				var id = e.newVal.get('id');
				$('#<portlet:namespace/>fileEntryId').val(id);
			});
		});
		
		A.one("#uploadButton").on("click", function(event){
			uploadFile(<%=uploadProgressBarId%>);
	    });
	});

	function addChildren(treeview, e) {
		var id = e.details[0].currentTarget.get('id');
		var ROOT = treeview.getNodeById(id);
	
		Liferay.Service('/eprocess.document/get-tree',
		{
			repositoryId : '${repositoryId}',
			folderId : id
		},
		function(childNodes) {
			var children = ROOT.getChildren();
			for (var i = 0; i < children.length; i++) {
				ROOT.removeChild(children[i]);
			}
			for (var i = 0; i < childNodes.length; i++) {
				var addChild = ROOT.createNode(childNodes[i]);
				ROOT.appendChild(addChild);
			}
		});
	}
	
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
	 			//alert("addFileEntryWithBytes");
	 			callBack(response);
	 		}
 		);
	}	
</aui:script>
	
<script type="text/javascript" src="<%=request.getContextPath() %>/js/dynamsoft/dynamsoft.webtwain.config.js"></script>
<script type="text/javascript">
	
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
	             
	var DWObject;
        
    function AcquireImage() {
        if (DWObject) {
			var OnAcquireImageSuccess, OnAcquireImageFailure;
			OnAcquireImageSuccess = OnAcquireImageFailure = function (){
				DWObject.CloseSource();
			};
			
            DWObject.SelectSourceByIndex(document.getElementById("source").selectedIndex);
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
        var repositoryId = <%=repositoryId%>;
        var folderId = <%=folderId%>;
        var sourceFileName=(new Date().getTime())+".pdf";
        var mimeType='';
        var title=sourceFileName;
        var description="Scanned file";
        var changeLog=description;
        
        addFileEntryWithBytes(repositoryId, folderId, sourceFileName, mimeType, title, description, changeLog, bytes, uploadCallBack);

<%---      
 		var length = result.getLength();
		var fileContent = result.getData(0, length).toString();
		var userId =<%= request.getUserPrincipal()%>;
        var repositoryId = <%=repositoryId%>;
        
        $.ajax({
			url: '/api/jsonws/eprocess.processdocument/add-scanned-document',
			dataType: "json",
			data:{
				userId: userId,
				fileContent: fileContent,
				repositoryId : repositoryId,
				p_auth : Liferay.authToken
			},
        	type: "post",
            success: function(data){ 
	        	console.log("Document uploaded successfully..");
	        	$('#<portlet:namespace/>uploadedFileId').val(data['fileEntryId']);                    	
	        	document.getElementById('<portlet:namespace />scannedDocForm').submit();
             },
             error: function(error){
             	console.log("error"+ error);
             }
		});
--%>   
	}
	
    function scanningFailureFunc (errorCode, errorString) {
    	console.log("ErrorCode: "+errorCode +"\r"+"ErrorString:"+ errorString);
	}

	function loadScanners(){
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
		
				document.getElementById("source").options.add(new Option("Select Printer", 0)); 
				for (var i = 0; i < count; i++){
					document.getElementById("source").options.add(new Option(DWObject.GetSourceNameItems(i), i+1));  // Add the sources in a drop-down list
				}
			}
		}
	}           

   	<%--####### File upload Code #######--%>
   	 
	function readFileUrl(input) {
	    if (input.files && input.files[0]) {
			let reader = new FileReader();
			reader.onload = e => {
				let imgData = e.target.result;
				let imgName = input.files[0].name;
				input.setAttribute("data-title", imgName);
				console.log(e.target.result);
			};
			reader.readAsDataURL(input.files[0]);
		}
	}
	
	function uploadFile(uploadProgressBar){
		var repositoryId = <%=repositoryId%>;
        var folderId = <%=folderId%>;
        var mimeType='';
        var description="Scanned file";
        var changeLog=description;
        
		//var fileSelected = document.getElementById('fileInput').files[0];
		var fileSelected=$('#fileInput').prop('files')[0];
		
		uploadProgressBar.startProgress();
		
		addFileEntryWithFile(repositoryId, folderId, description, fileSelected, uploadCallBack);

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

	function uploadCallBack(response){
		console.log(response);
		//console.log(obj);
	}	
</script>