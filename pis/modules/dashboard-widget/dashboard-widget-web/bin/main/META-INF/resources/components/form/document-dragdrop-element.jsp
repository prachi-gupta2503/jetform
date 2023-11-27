<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.liferay.portal.kernel.util.PwdGenerator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.security.RandomUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<style>
	.input-dnd .form-control-file {
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
	
  	.input-dnd .form-control-file:before {
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
   		margin-top:50px;
   		margin-bottom: -70px;
   		z-index: 9999;
   	}
</style>

<%
String elementName = ParamUtil.getString(request, "elementName");
if(StringUtils.isEmpty(elementName)){
	elementName=(String)pageContext.getAttribute("elementName");
}
String progressBarId = PwdGenerator.getPassword(PwdGenerator.KEY3, 4).concat("_progressbar");
String placeHolder="<i class=\"fa fa-download\" aria-hidden=\"true\"></i><br>Drag a file here or click to upload!";
%>
<div class="input-dnd">
		<%--<button type="button" class="btn btn-default browse-btn" id="<portlet:namespace /><%=elementName+"_browseBtn"%>" style="margin-bottom:10px;">Browse</button>
		<p>or</p> --%>
		<div class="file-title">
			<span id="<portlet:namespace /><%=elementName%>_fileName"><%=placeHolder%></span>
			<a id="<portlet:namespace /><%=elementName%>_clearBtn" style="display:none;"><i class="fa fa-close"></i></a>
		</div>
		<input type="file" class="form-control-file text-primary font-weight-bold" id="<portlet:namespace /><%=elementName+"_file"%>" name="<portlet:namespace /><%=elementName+"_file"%>" data-title="">
		<liferay-ui:upload-progress id="<%=progressBarId%>" message="uploading"/>
		<input type="hidden" name="<portlet:namespace /><%=elementName%>" id="<portlet:namespace/><%=elementName%>">
		
		
<%--		<button type="button" class="btn btn-default upload-button" id="<portlet:namespace /><%=elementName+"_uploadBtn"%>">Upload</button>
	<label class="form-control" id="<portlet:namespace /><%=elementName+"_document"%>">
		<span id="<portlet:namespace /><%=elementName+"_fileName"%>">Upload a document</span>
		<a id="<portlet:namespace /><%=elementName+"_uploadBtn"%>" style="float: right;"><i class="fa fa-upload"></i></a>
		<a id="<portlet:namespace /><%=elementName+"_clearBtn"%>" style="float: right; display:none;"><i class="fa fa-close"></i></a>
	</label>
	<input type="hidden" name="<portlet:namespace /><%=elementName%>" id="<portlet:namespace/><%=elementName%>">
	<input type="file" name="<portlet:namespace/><%=elementName+"_file"%>" id="<portlet:namespace/><%=elementName+"_file"%>" style="width:0px;">
 --%>
</div>
<%--<liferay-ui:upload-progress id="<%=progressBarId%>" message="uploading" height="5" /> --%>

<aui:script use="aui-base, liferay-preview, liferay-util-window">
	<%--A.one('#<portlet:namespace /><%=elementName%>_browseBtn').on('click', function(event) {
		$('#<portlet:namespace/><%=elementName%>_file').trigger('click');
	}); 
	
	A.one('#<portlet:namespace /><%=elementName%>_fileName').on('click', function(event) {
		$('#<portlet:namespace/><%=elementName%>_file').trigger('click');
	});--%>
	
	A.one('#<portlet:namespace/><%=elementName%>_file').on('change', function(event) {
		var fileElement=$('#<portlet:namespace/><%=elementName%>_file');
		<portlet:namespace /><%=elementName%>_readFileUrl(fileElement);
		uploadFile(fileElement, <%=progressBarId%>, <portlet:namespace /><%=elementName%>_uploadFileOnSuccess);
	});
<%--	
	A.one('#<portlet:namespace/><%=elementName%>_uploadBtn').on('click', function(event) {
		uploadFile($('#<portlet:namespace/><%=elementName%>_file'), <%=progressBarId%>, <portlet:namespace /><%=elementName%>_uploadFileOnSuccess);
	});
--%>	
	A.one('#<portlet:namespace /><%=elementName%>_clearBtn').on('click', function(event) {
		$('#<portlet:namespace/><%=elementName%>').val('');
		$('#<portlet:namespace/><%=elementName%>_fileName').html('<%=placeHolder%>');
		$('#<portlet:namespace /><%=elementName%>_uploadBtn').css("display", "block");
		$('#<portlet:namespace /><%=elementName%>_clearBtn').css("display", "none");
	});
 
	function <portlet:namespace /><%=elementName%>_uploadFileOnSuccess(response){
		$('#<portlet:namespace/><%=elementName%>_file').attr("data-title", '');
		$('#<portlet:namespace/><%=elementName%>').val(response.fileEntryId);
		$('#<portlet:namespace/><%=elementName%>_fileName').html(response.fileName);
		$('#<portlet:namespace /><%=elementName%>_uploadBtn').css("display", "none");
		$('#<portlet:namespace /><%=elementName%>_clearBtn').css("display", "block");
		console.log(<%=progressBarId%>);
	}	
	
	function <portlet:namespace /><%=elementName%>_readFileUrl(fileElement) {
		
		if(!$(fileElement) || !$(fileElement).prop('files') || $(fileElement).prop('files').length<1){
			return null;
		}

		var fileSelected = $(fileElement).prop('files')[0];

	    if(fileSelected){
	    	alert(fileSelected.name)	;
			$(fileElement).attr("data-title", fileSelected.name);
			$('#<portlet:namespace/><%=elementName%>_fileName').html('');
			return fileSelected;
		}else{
			return null;
		}
	}
		
</aui:script>
<%--
<div class="custom-file">
	<input type="file" class="custom-file-input" onchange="uploadFile('<portlet:namespace/><%=elementName%>', <%=progressBarId%>)" name="<portlet:namespace/><%=elementName+"_file"%>" id="<portlet:namespace/><%=elementName+"_file"%>">
	<label class="custom-file-label" for="customFile">Upload a file</label>
	<input type="hidden" name="<portlet:namespace/><%=elementName%>" id="<portlet:namespace/><%=elementName%>">
</div> 
<liferay-ui:upload-progress id="<%=progressBarId%>" message="uploading" height="5" />
--%>
