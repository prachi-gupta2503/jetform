<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.security.RandomUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<style>
	.input-dnd .form-control-file {
	    position: relative;
	    width: 100%;
	    /*width: 100%;
	    height: 100%;*/
	    min-height: 15em;
	    outline: none;
	    visibility: hidden;
	    cursor: pointer;
	    background-color: #c61c23;
	    box-shadow: 0 0 5px solid currentColor;
	}
	
  	.input-dnd .form-control-file:before {
	    content: attr(data-title);
	    position: absolute;
	    top: 0.5em;
	    left: 0;
	    width: 100%;
	    /*width: 100%;*/
	    min-height:14em;
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
  	
  	.input-dnd .form-control-file:hover:before {
    	border-style: solid;
    	/*box-shadow: inset 0px 0px 0px 0.25em currentColor;*/
    	box-shadow: inset 0px 0px 0px 2px currentColor;
  	}
  
	.progress{
		border-radius: 0px !important;
  	}
   
  	.progress-bar{
    	border-radius: 0px !important;
   	} 
   	.progress-bar p{
    	line-height: 50px !important;
    	margin-top: auto !important;
    	margin-bottom: auto !important;
   	} 
   	
   	.file-title{
   		text-align: center;
   		margin-top:100px;
   		margin-bottom: -140px;
   		z-index: 9999;
   	}
   	.input-group{
   		text-align: center;
   		display: block !important;
   	}
   	.close-viewer{
   		float: right;
   	}
   	.close-viewer .fa-close{
   		padding: 1px 4px;
   		border: 1px solid black;
   	}
   	.document-adder-container{
   		text-align: center; 
   		border: 1px solid #f1f1f1; 
   		height:600px;
   		padding: 50px;
   	}
   	.viewer-container{
   		text-align: center; 
   		border: 1px solid #f1f1f1; 
   		height:600px; 
   		display:none;
   	}
   	.document-viewer{
   		height:100%;
   	}
   	.image-viewer{
   		max-width: 100%; 
   		padding:10px; 
   		position: absolute;
  		top: 0;
  		bottom: 0;
  		left: 0;
  		right: 0;
  		margin: auto; 
  		vertical-align: middle; 
  		display:none;
   	}
   	.pdf-viewer{
   		width:100%; 
   		height:100%;
   		display:none;
   	}
</style>
<%
HtmlElementWrapper htmlElement=(HtmlElementWrapper)pageContext.getAttribute("htmlElement");
String placeHolder="<i class=\"fa fa-download\" aria-hidden=\"true\"></i><br>Drag a file here or click to upload!";
String progressBarId = htmlElement.getName().concat("_progressbar");
%>

<div id="<portlet:namespace /><%=htmlElement.getName()%>-document-adder" class="form-group document-adder-container">
	<div class="input-dnd">
		<div class="file-title">
			<span id="<portlet:namespace /><%=htmlElement.getName()%>_fileTitle"><%=placeHolder%></span>
		</div>
		<input type="file" class="form-control-file text-primary font-weight-bold" id="<portlet:namespace /><%=htmlElement.getName()+"_file"%>" name="<portlet:namespace /><%=htmlElement.getName()+"_file"%>" data-title="">
		<liferay-ui:upload-progress id="<%=progressBarId%>" message="uploading"/>
	</div>
	<div>
		<p>or</p>
	</div>
	<div class="input-group mb-3">
		<button class="btn btn-primary" id="<portlet:namespace /><%=htmlElement.getName()+"_scanBtn"%>">
			Scan a Document&nbsp;&nbsp;<i class="fa fa-print"></i>
			<%--<a id="<portlet:namespace /><%=htmlElement.getName()+"_clearBtn"%>" style="float: right; display:none;"><i class="fa fa-close"></i></a> --%>
		</button>
	</div>
	<div>
		<p>or</p>
	</div>
	<div class="input-group mb-3">
		<button class="btn btn-primary" id="<portlet:namespace /><%=htmlElement.getName()+"_browseBtn"%>">
			Browse Document &amp; Media&nbsp;&nbsp;<i class="fa fa-folder-open"></i>
		</button>
	</div>
</div>

<div id="<portlet:namespace /><%=htmlElement.getName()%>-viewer-container" class="viewer-container">
	<input type="hidden" id="<portlet:namespace />previewURLID" value="" /> 
	<input type="hidden" id="<portlet:namespace />previewURLCount" value="1" /> 
	<input type="hidden" name="<portlet:namespace /><%=htmlElement.getName()%>_fileName" id="<portlet:namespace /><%=htmlElement.getName()%>_fileName">
	<input type="hidden" name="<portlet:namespace /><%=htmlElement.getName()%>" id="<portlet:namespace/><%=htmlElement.getName()%>">
	<div class="input-group mb-3">
		<a id="<portlet:namespace /><%=htmlElement.getName()+"_clearBtn"%>" class="close-viewer" title="Remove document"><i class="fa fa-close"></i>&nbsp;Remove</a>
	</div>
	<div id="<portlet:namespace /><%=htmlElement.getName()%>document-viewer" class="input-group mb-3 document-viewer" style="">   
    	<object id="<portlet:namespace /><%=htmlElement.getName()%>-pdf-viewer" class="pdf-viewer" style=""></object>
        <img id="<portlet:namespace /><%=htmlElement.getName()%>-image-viewer" class="image-viewer" style="">
    </div>
                        
<%-- 
	<div class="lfr-preview-file" id="<portlet:namespace />previewFile">
		<div class="lfr-preview-file-content" id="<portlet:namespace />previewFileContent">
			<div class="lfr-preview-file-image-current-column">
				<div class="lfr-preview-file-image-container">
					<img class="lfr-preview-file-image-current" id="<portlet:namespace />previewFileImage" src="" />
				</div>
				<span class="lfr-preview-file-actions aui-helper-hidden" id="<portlet:namespace />previewFileActions"> 
				<span class="lfr-preview-file-toolbar" id="<portlet:namespace />previewToolbar"></span> 
				<span class="lfr-preview-file-info"> 
					<span class="lfr-preview-file-index" id="<portlet:namespace />previewFileIndex">1</span> of <span class="lfr-preview-file-count" id="lfr-preview-file-count-id"></span> 
				</span>
				</span>
			</div>

			<div class="lfr-preview-file-images" id="<portlet:namespace />previewImagesContent">
				<div class="lfr-preview-file-images-content"></div>
			</div>
		</div>
	</div>
--%>
</div>

<aui:script use="aui-base, liferay-preview, liferay-util-window">
	
	A.one('#<portlet:namespace/><%=htmlElement.getName()%>_file').on('change', function(event) {
		var fileElement=$('#<portlet:namespace/><%=htmlElement.getName()%>_file');
		<portlet:namespace /><%=htmlElement.getName()%>readFileUrl(fileElement);
		uploadFile(fileElement, <%=progressBarId%>, <portlet:namespace /><%=htmlElement.getName()%>uploadFileOnSuccess);
	});
	
	A.one('#<portlet:namespace /><%=htmlElement.getName()%>_scanBtn').on('click', function(event) {
		open_<portlet:namespace /><%=htmlElement.getName()%>_dialog('scan', 'Scan a Document');
	});
	
	A.one('#<portlet:namespace /><%=htmlElement.getName()%>_browseBtn').on('click', function(event) {
		open_<portlet:namespace /><%=htmlElement.getName()%>_dialog('dml', 'Browse a Document');
	});
	
<%--	A.one('#<portlet:namespace /><%=htmlElement.getName()%>_clearBtn').on('click', function(event) {
		alert('ok');
		$('#<portlet:namespace/><%=htmlElement.getName()%>').val('');
		$('#<portlet:namespace/><%=htmlElement.getName()%>_fileName').html('Upload or browse or scan a document');
		$('#<portlet:namespace /><%=htmlElement.getName()+"_addBtn"%>').css("display", "block");
		$('#<portlet:namespace /><%=htmlElement.getName()+"_clearBtn"%>').css("display", "none");
		
	});
 --%>	
	function open_<portlet:namespace /><%=htmlElement.getName()%>_dialog(source, title){
		Liferay.Util.openWindow({ dialog: 
			{ 
				centered: true, 
				height: 720, 
				width: 1080,
				modal: true,
				destroyOnHide: true
			}, 
			id: '<portlet:namespace /><%=htmlElement.getName()%>_dialog',
			title: title, 
			uri: '<%=documentAdderURL.toString()%>&<portlet:namespace />documentElement=<%=htmlElement.getName()%>&<portlet:namespace />source='+source 
		});
	}
	
	Liferay.provide(
		window,
		'<portlet:namespace /><%=htmlElement.getName()%>_closeDialog',
		function(data) {
			if(data){
				console.log(data);
				
				$('#<portlet:namespace/><%=htmlElement.getName()%>').val(data.fileEntryId);
				$('#<portlet:namespace/><%=htmlElement.getName()%>_fileName').html(data.fileName);
				$('#<portlet:namespace /><%=htmlElement.getName()+"_clearBtn"%>').css("display", "block");
				$('#<portlet:namespace /><%=htmlElement.getName()+"_addBtn"%>').css("display", "none");
				
				<portlet:namespace /><%=htmlElement.getName()%>previewDocument(data);
			}
			var dialog = Liferay.Util.Window.getById('<portlet:namespace /><%=htmlElement.getName()%>_dialog');
			dialog.destroy();
		},
		['liferay-util-window']
	);
	
	function <portlet:namespace /><%=htmlElement.getName()%>uploadFileOnSuccess(response){
		
		$('#<portlet:namespace/><%=htmlElement.getName()%>_file').attr("data-title", '');
		$('#<portlet:namespace/><%=htmlElement.getName()%>').val(response.fileEntryId);
		$('#<portlet:namespace/><%=htmlElement.getName()%>_fileName').html(response.fileName);
		$('#<portlet:namespace /><%=htmlElement.getName()%>_uploadBtn').css("display", "none");
		$('#<portlet:namespace /><%=htmlElement.getName()%>_clearBtn').css("display", "block");
		<portlet:namespace /><%=htmlElement.getName()%>previewDocument(response);
		console.log(<%=progressBarId%>);
	}	
	
	function <portlet:namespace /><%=htmlElement.getName()%>readFileUrl(fileElement) {
		
		if(!$(fileElement) || !$(fileElement).prop('files') || $(fileElement).prop('files').length<1){
			return null;
		}

		var fileSelected = $(fileElement).prop('files')[0];

	    if(fileSelected){
	    	//alert(fileSelected.name)	;
			$(fileElement).attr("data-title", fileSelected.name);
			$('#<portlet:namespace/><%=htmlElement.getName()%>_fileTitle').html('');
			return fileSelected;
		}else{
			return null;
		}
	}
	
	function <portlet:namespace /><%=htmlElement.getName()%>previewDocument(fileEntry){	
		console.log(fileEntry);
		var url=<portlet:namespace /><%=htmlElement.getName()%>getPreviewURL(fileEntry);
		if(fileEntry.extension.toLowerCase()=='pdf'){
			viewer=$('#<portlet:namespace /><%=htmlElement.getName()%>-pdf-viewer');
			$(viewer).attr('data', url+'#toolbar=1');
		}else if(fileEntry.mimeType.indexOf("image/")==0){
			viewer=$('#<portlet:namespace /><%=htmlElement.getName()%>-image-viewer');
			$(viewer).attr('src', url);
		}
		$(viewer).css('display','block');
		
		$('#<portlet:namespace /><%=htmlElement.getName()%>-viewer-container').css('display','block');
		$('#<portlet:namespace /><%=htmlElement.getName()%>-document-adder').css('display','none');
	}
		
	A.one('#<portlet:namespace /><%=htmlElement.getName()%>_clearBtn').on('click', function(event) {
		if(!confirm('Are you sure you want to remove the document')){
			return;
		}
		
		deleteFileEntry($('#<portlet:namespace/><%=htmlElement.getName()%>').val(), function(response){
			$('#<portlet:namespace/><%=htmlElement.getName()%>').val('');
			$('#<portlet:namespace/><%=htmlElement.getName()%>_fileName').val('');
			$('#<portlet:namespace /><%=htmlElement.getName()%>_fileTitle').html('<%=placeHolder%>');
			$('#<portlet:namespace /><%=htmlElement.getName()+"_addBtn"%>').css("display", "block");
			$('#<portlet:namespace /><%=htmlElement.getName()+"_clearBtn"%>').css("display", "none");
			
			$('#<portlet:namespace /><%=htmlElement.getName()%>-pdf-viewer').attr('data','');
			$('#<portlet:namespace /><%=htmlElement.getName()%>-image-viewer').attr('src','');
			
			$('#<%=progressBarId%>Bar').html('');
			
			$('#<portlet:namespace /><%=htmlElement.getName()%>-viewer-container').css('display','none');
			$('#<portlet:namespace /><%=htmlElement.getName()%>-document-adder').css('display','block');
		})
	});
	
	function <portlet:namespace /><%=htmlElement.getName()%>getPreviewURL(fileEntry){
		var SLASH="<%=StringPool.SLASH%>";
		var url="";
		
		url=Liferay.ThemeDisplay.getPortalURL();
		url+=Liferay.ThemeDisplay.getPathContext();
		url+="/documents/";
		url+=fileEntry.repositoryId;
		url+=SLASH;
		url+=fileEntry.folderId;
		url+=SLASH;
		url+=encodeURI(escape(fileEntry.fileName));
		url+=SLASH;
		url+=encodeURI(fileEntry.uuid);
		url+="?t=";
		url+=fileEntry.modifiedDate;
		url+=";jsessionid=";
		url+=Liferay.ThemeDisplay.getSessionId();
		
		return url;
	}
 						
</aui:script>

