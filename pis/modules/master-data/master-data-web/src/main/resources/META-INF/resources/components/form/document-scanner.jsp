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

<%!private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.file_005fbrowser_jsp");%>

<style>
.upload-document label {
	position: relative;
}

.help-text {
	position: absolute;
	left: 90px;
	top: 0px;
}
.btn-ok{
   	padding-left:20px; 
   	padding-right:20px;
}
.btn{
	width:100px;
}
.input-group{
	padding:10px;
	margin: auto;
	text-align: center;
}
</style>
<%
long repositoryId = themeDisplay.getScopeGroupId();
long rootFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
String idField=ParamUtil.get(request, "documentElement", "");
String labelField=idField+"_fileName";
%>
<div class="container" style="margin:10px;">
	<div class="row">
		<div class="col-md-9" style="border: 1px solid #f1f1f1; height:530px;">
			<div id="dwtcontrolContainer"></div>
		</div>
		<div class="col-md-3" style="height:530px; position: relative; ">
			<div style="padding:100px 10px 100px 10px;border: 1px solid #f1f1f1; width:250px; text-align: center;">
				<div class="input-group">
					<select class="form-control" id="scannerSource" style="margin: 0 auto; width:200px">
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
			<div style="width:250px; bottom:0; position: absolute; text-align: center;">
				<div class="input-group">
					<button type="button" class="btn btn-default btn-sm" style="margin-right:10px;" name="<portlet:namespace />cancel" id="<portlet:namespace />cancel" value="Cancel">Cancel</button>
					<button type="button" class="btn btn-primary btn-sm btn-ok" name="<portlet:namespace />ok" id="<portlet:namespace />ok" value="Select">OK</button>
				</div>
			</div>
		</div>
	</div>
</div>
<%--
	<div class="row" style="padding:20px;">	
		<div class="col-md-12" style="padding:20px 0px 20px 20px; border: 1px solid #f1f1f1;">
			<div id="dwtcontrolContainer" style="width:100%;"></div>
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
	 --%>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/dynamsoft/dynamsoft.webtwain.config.js"></script>
<script type="text/javascript">
/*
	Dynamsoft.WebTwainEnv.ResourcesPath = 'js/dynamsoft';
	var DWObject;
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
						scanningSuccessCallback, scanningFailureCallback);
			}
		}
	}

	function scanningSuccessCallback(result) {
		var length = result.getLength();
		var bytes = result.getData(0, length).toString();
        var repositoryId = <%=repositoryId%>;
        var folderId = <%=rootFolderId%>;
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
	
    function scanningFailureCallback(errorCode, errorString) {
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
				//scannerElement.options.add(new Option("Select Scanner", 0)); 
				
				for (var i = 0; i < count; i++){
					scannerSourceList.options.add(new Option(DWObject.GetSourceNameItems(i), i+1));  // Add the sources in a drop-down list
				}
			}
		}
	}           

	function uploadCallBack(response){
		console.log(response);
		$('#<portlet:namespace /><%=idField%>').val(response.fileEntryId);
		$('#<portlet:namespace /><%=labelField%>').val(response.fileName);
		//console.log(obj);
	}
	
	$( document ).ready(function() {
		loadScanners("sourceScanner");
	});

</script>
<aui:script use="aui-base, liferay-portlet-url">
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