<%@page import="java.net.URLEncoder"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.liferay.portal.kernel.util.GroupThreadLocal"%>
<%@page import="com.liferay.portal.kernel.service.ServiceContext"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>
<%@page import="com.liferay.document.library.kernel.model.DLFolder"%>
<%@page import="com.liferay.document.library.kernel.model.DLFileEntry"%>
<%@page import="com.liferay.portal.kernel.security.auth.PrincipalThreadLocal"%>
<%@page import="com.liferay.document.library.kernel.model.DLFolderConstants"%>
<%@page import="com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil"%>
<%@page import="com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil"%>

<%@ include file="/init.jsp"%>

<%!
	private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.document_upload_005felement_jsp");
%>
<%
long groupId = themeDisplay.getScopeGroupId();
long repositoryId = groupId;

long folderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

ServiceContext serviceContext = new ServiceContext();
serviceContext.setScopeGroupId(groupId);

boolean viewOnlyMode= false;
if(request.getAttribute("viewOnlyMode")!=null){
	viewOnlyMode=(Boolean)request.getAttribute("viewOnlyMode");
}

boolean childForm=false;
String formId=(String)request.getAttribute("childFormId");
if(StringUtils.isBlank(formId)){
	formId=(String)request.getAttribute("formId");
}else{
	childForm=true;
}

String childFormNamespace="";
if(childForm){
	childFormNamespace=(String)request.getAttribute("childFormNamespace");
}

String elementName=(String)request.getAttribute(childFormNamespace+"elementName");

HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formId);

HtmlElementWrapper htmlElement=(HtmlElementWrapper)request.getAttribute(childFormNamespace+"htmlElement_"+elementName);
String savedValue=StringUtils.trim((String)request.getAttribute(childFormNamespace+elementName+ "_savedValue"));
String defaultImageSrc=request.getContextPath()+htmlElement.getValue();

String folder=htmlElement.getFolder();
if(StringUtils.isNotBlank(folder) && StringUtils.indexOf(folder,"/")>=0 && !StringUtils.equals(folder, StringPool.FORWARD_SLASH)){
	String[] folderNames=folder.split("/");
	
	for(String folderName:folderNames){
		//LOGGER.info("Searching folder for : "+folderName +" under parentID : "+folderId);
		DLFolder dlFolder=null;
		try{
			dlFolder=DLFolderLocalServiceUtil.getFolder(groupId, folderId, folderName);
		}catch(Exception e){
			try{
				dlFolder=DLFolderLocalServiceUtil.addFolder(PrincipalThreadLocal.getUserId(), groupId, repositoryId, false, folderId, folderName, folderName, false, serviceContext);
			}catch(Exception e1){}
		}
		if(dlFolder!=null){
			folderId=dlFolder.getFolderId();
		}
	}
}

//LOGGER.info("Final folderID : "+folderId);

String nonElementNameSpace=form.getId();
if(StringUtils.isNotEmpty(nonElementNameSpace)){
	nonElementNameSpace=nonElementNameSpace.replace(".", "_");
}
String idPrefix=nonElementNameSpace+htmlElement.getName();
String namePrefix=childFormNamespace+htmlElement.getName();

String progressBarId = idPrefix.concat("_progressbar");

String filePath="";
String iconClass="fa-file";
DLFileEntry fileEntry=null;
if(StringUtils.isNotEmpty(savedValue)){
	try{
		fileEntry=DLFileEntryLocalServiceUtil.getDLFileEntry(Long.parseLong(savedValue));
		filePath="/documents/"+fileEntry.getRepositoryId()+"/"+fileEntry.getFolderId()+"/"+URLEncoder.encode(fileEntry.getFileName());
		
		String mimeType=fileEntry.getMimeType();
		if(mimeType.equalsIgnoreCase("application/pdf")){
			iconClass="fa-file-pdf";
		}else if(mimeType.equalsIgnoreCase("application/vnd.openxmlformats-officedocument.wordprocessingml.document")){	
			iconClass="fa-file-word";
		}else if(mimeType.equalsIgnoreCase("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")){	
			iconClass="fa-file-excel";
		}else if(mimeType.equalsIgnoreCase("application/vnd.openxmlformats-officedocument.presentationml.presentation")){	
			iconClass="fa-file-powerpoint";
		}else if(mimeType.startsWith("image/")){
			iconClass="fa-file-image";
		}else if(mimeType.equalsIgnoreCase("video/")){
			iconClass="fa-file-video";
		}else if(mimeType.equalsIgnoreCase("audio/")){
			iconClass="fa-file-audio";
		}else if(mimeType.endsWith("/zip") || mimeType.endsWith("/x-7z-compressed") || mimeType.endsWith("/x-tar")  || mimeType.endsWith("/vnd.rar")  || mimeType.endsWith("/gzip")  || mimeType.endsWith("/java-archive")){
			iconClass="fa-file-archive";
		}else{
			iconClass="fa-file";
		}
		
	}catch(Exception exc){}
}

if(!htmlElement.isThumbnail()){
%>
	<span id="<portlet:namespace/><%=idPrefix%>_fileViewContainer" style="<%=fileEntry==null?"display:none;":""%>">
		<%--
		<span id="<portlet:namespace/><%=idPrefix+"_fileName"%>"><%=StringUtils.isNotBlank(htmlElement.getPlaceHolder())?htmlElement.getPlaceHolder():"Choose a file"%></span>
		<span style="font-style: italic;">
		 --%>
		
		<i class="fa <%=iconClass%> mr-1" aria-hidden="true"></i><span id="<portlet:namespace/><%=idPrefix+"_fileDisplayName"%>" style="font-style: italic;"><%=fileEntry!=null?fileEntry.getTitle():""%></span>
		<a id="<portlet:namespace/><%=idPrefix%>_viewDocumentBtn"><i class="fa fa-download"></i></a>
<%
	if(!viewOnlyMode){
%>
		<a id="<portlet:namespace/><%=idPrefix%>_clearBtn" style="color:red;"><i class="fa fa-remove"></i> </a>
<%
	}
%>
	</span>
	<liferay-ui:upload-progress id="<%=progressBarId%>" message="uploading" height="5"/>
<%
}
%>
<%
	if(!htmlElement.isThumbnail()){
		if(!viewOnlyMode){
%>		
	<div class="input-group" id="<portlet:namespace/><%=idPrefix%>_inputContainer" style="<%=fileEntry!=null?"display:none;":""%>">
		<label class="form-control" id="<portlet:namespace/><%=idPrefix%>_documentControl">
			<span><%=StringUtils.isNotBlank(htmlElement.getPlaceHolder())?htmlElement.getPlaceHolder():"Choose a file"%></span>
		
		<%--	
		<span id="<portlet:namespace/><%=idPrefix+"_fileName"%>"><%=StringUtils.isNotBlank(htmlElement.getPlaceHolder())?htmlElement.getPlaceHolder():"Choose a file"%></span>
		 --%>	
			<a id="<portlet:namespace/><%=idPrefix+"_uploadBtn"%>" style="float: right;"><i class="fa fa-upload"></i></a>
			<%--
			<a id="<portlet:namespace/><%=idPrefix+"_clearBtn"%>" style="float: right; display:none;color:red;"><i class="fa fa-close"></i></a>
			 --%>
		</label>
	</div>	
<%
		}
	}else{
		String imgSrc=request.getContextPath()+htmlElement.getValue();
		String containerWhStyle="";
		String thumbnailWhStyle="";
		
		if(StringUtils.isNotBlank(filePath)){
			imgSrc=filePath;
		}
		int width=htmlElement.getWidth();
		int height=htmlElement.getHeight();
		thumbnailWhStyle=(width>0?"width:"+width+"px;":"").concat(height>0?"height:"+height+"px;":"");
		containerWhStyle=(width>0?"width:"+(width+6)+"px;":"").concat(height>0?"height:"+(height+6)+"px;":"");
		String btnLeftStyle=(width>0?"left:"+((width+6-39)/2)+"px;":"40%");
%>
	<div id="<portlet:namespace/><%=idPrefix%>_thumbnailContainer" style="<%=containerWhStyle%>padding:2px; border:2px solid #e7e7ed;text-align:center;">
		<img id="<portlet:namespace/><%=idPrefix%>_thumbnail" src="<%=imgSrc%>" style="<%=thumbnailWhStyle%>" />
		<%--
		<span id="<portlet:namespace/><%=idPrefix+"_fileName"%>" style="display:none;"><%=StringUtils.isNotBlank(htmlElement.getPlaceHolder())?htmlElement.getPlaceHolder():"Choose a file"%></span>
		 --%>
<%
		if(!viewOnlyMode){
%>		 
			<a id="<portlet:namespace/><%=idPrefix+"_uploadBtn"%>" style="<%=fileEntry!=null?"display:none;":""%>position:absolute; bottom:30px;<%=btnLeftStyle%>"><i class="fa fa-upload" style="padding:10px; border:1px solid #0b5fff; border-radius: 20px;"></i></a>
			<a id="<portlet:namespace/><%=idPrefix+"_clearBtn"%>" style="<%=fileEntry==null?"display:none;":""%>position:absolute; bottom:30px;<%=btnLeftStyle%>"><i class="fa fa-close" style="color:red; padding:10px; border:1px solid red; border-radius: 20px;"></i></a>
<%
		}
%>		
	</div>
<%
	}
	
	String acceptTypes=(StringUtils.isNotBlank(htmlElement.getAccept())?"accept=\""+htmlElement.getAccept()+"\"":"");
	
	if(!viewOnlyMode){
%>
		<input type="file" name="<portlet:namespace/><%=idPrefix+"_file"%>" id="<portlet:namespace/><%=idPrefix%>_file" style="width:0px;" <%=acceptTypes%>>
		<aui:input type="hidden" name="<%=namePrefix%>" id="<%=idPrefix%>" value="<%=!savedValue.equals("0")?savedValue:""%>">
<%
		if(htmlElement.isRequired()){
%>	
			<aui:validator name="required" errorMessage="Uploading of a file is required!"/>
<%
		}
%>
		</aui:input>
<%
	}
%>	
<%--	<input type="file" name="<portlet:namespace/><%=namePrefix+"_file"%>" id="<portlet:namespace/><%=idPrefix+"_file"%>">--%>

<%--
	if(htmlElement.isRequired()){
%>	
	<aui:input type="hidden" name="<%=idPrefix+"_fileName"%>">
		<aui:validator name="required" errorMessage="Upload a file is required!"/>
	</aui:input> 
<%
	}
--%>


<aui:script use="aui-base, liferay-preview, liferay-util-window">
	var thumbnail=<%=htmlElement.isThumbnail()%>;
	<%--	
		A.one('#<portlet:namespace /><%=htmlElement.getName()%>_uploadBtn').on('click', function(event) {
		
			var el = document.getElementById("<portlet:namespace/><%=htmlElement.getName()%>_file");
		    if (el) {
		        el.click();  
		    }
			A.one('#<portlet:namespace/><%=htmlElement.getName()%>_file').trigger('click');
		}); 
	--%>
	
	function <portlet:namespace/><%=idPrefix%>_uploadFile(){
		if(!thumbnail){
			uploadFile('<%=repositoryId%>', '<%=folderId%>', $('#<portlet:namespace/><%=idPrefix%>_file'), <%=progressBarId%>, <portlet:namespace /><%=idPrefix%>_uploadFileOnSuccess);
		}else{
			uploadFile('<%=repositoryId%>', '<%=folderId%>', $('#<portlet:namespace/><%=idPrefix%>_file'), "null", <portlet:namespace /><%=idPrefix%>_uploadFileOnSuccess);
		}
	}

	function <portlet:namespace/><%=idPrefix%>_uploadFileOnSuccess(response){
		console.log(response);
		$('#<portlet:namespace/><%=idPrefix%>').val(response.fileEntryId);
		
		try{
			$('#<portlet:namespace/><%=idPrefix%>_fileName').val('');
		}catch(e){}
		
		try{
			console.log("Before hiding <portlet:namespace/><%=idPrefix%>_documentControl");
			$('#<portlet:namespace/><%=idPrefix%>_inputContainer').hide();
		}catch(e){
			console.log(e);
		}
		try{
			$('#<portlet:namespace/><%=idPrefix%>_fileDisplayName').html(response.fileName);
			console.log("Before hiding <portlet:namespace/><%=idPrefix%>_fileViewContainer");
			$('#<portlet:namespace/><%=idPrefix%>_fileViewContainer').show();
		}catch(e){}
		
		
		if(thumbnail){
			var previewUrl="/documents/"+response.repositoryId+"/"+response.folderId+"/"+encodeURI(response.fileName);
			try{
				$('#<portlet:namespace/><%=idPrefix%>_thumbnail').attr('src', previewUrl);
				$('#<portlet:namespace/><%=idPrefix%>_uploadBtn').css("display", "none");
				$('#<portlet:namespace/><%=idPrefix%>_clearBtn').css("display", "block");
			}catch(e){}
		}
		
		try{
			$('.progress > .progress-bar').css("width", "0px");
			$('.progress').css("background", "none");
		}catch(e){}
	}		
	
	function <portlet:namespace/><%=idPrefix%>_deleteFile(){
		var yn=confirm("Are you sure you want to clear the currently selected files?");
		if(yn){
			deleteFileEntry($('#<portlet:namespace/><%=idPrefix%>').val(), <portlet:namespace/><%=idPrefix%>_deleteFileOnSuccess);
		}
	}
	
	function <portlet:namespace/><%=idPrefix%>_deleteFileOnSuccess(){
		//alert("<portlet:namespace /><%=idPrefix%>_deleteFileOnSuccess called");
		$('#<portlet:namespace/><%=idPrefix%>').val('');
		$('#<portlet:namespace/><%=idPrefix%>_file').val(null);
		
		try{
			$('#<portlet:namespace/><%=idPrefix%>_fileName').val('');
		}catch(e){}
		
		try{
			$('.progress > .progress-bar').css("width", "0px");
			$('.progress').css("background", "none");
		}catch(e){}
		
		try{
			$('#<portlet:namespace/><%=idPrefix%>_fileDisplayName').html('');
			$('#<portlet:namespace/><%=idPrefix%>_fileViewContainer').hide();
		}catch(e){}
		
		if(thumbnail){	
			try{
				$('#<portlet:namespace/><%=idPrefix%>_thumbnail').attr('src', '<%=defaultImageSrc%>');
				$('#<portlet:namespace/><%=idPrefix%>_uploadBtn').css("display", "block");
				$('#<portlet:namespace/><%=idPrefix%>_clearBtn').css("display", "none");
			}catch(e){}
		}else{
			try{
				$('#<portlet:namespace/><%=idPrefix%>_inputContainer').show();
			}catch(e){}
			
		}		
	}
	
	function <portlet:namespace /><%=idPrefix%>_viewDocument() {
		var url="<%=filePath%>";
		var extn=url.substring(url.lastIndexOf(".")+1).toLowerCase();
		if(extn=="pdf" || extn=="jpg" || extn=="jpeg" || extn=="png"){
			var dialogId="<portlet:namespace /><%=idPrefix%><%=htmlElement.getName()%>viewer";
			var title="<%=htmlElement.getLabel() %>";
			LiferayUtilOpenWindow(dialogId, title, url, true, 700, true, 800);
		}else{
			window.open(url, '_blank');
		}
	}
	
	$(document).ready(function() {
		$('#<portlet:namespace /><%=idPrefix%>_uploadBtn').on('click', function(event) {
			$('#<portlet:namespace/><%=idPrefix%>_file').trigger('click');
		});
		
		$('#<portlet:namespace /><%=idPrefix%>_fileName').on('click', function(event) {
			$('#<portlet:namespace/><%=idPrefix%>_file').trigger('click');
		});
		
		$('#<portlet:namespace/><%=idPrefix%>_file').on('change', function(event) {
			<portlet:namespace /><%=idPrefix%>_uploadFile();
		});
		
		$('#<portlet:namespace /><%=idPrefix%>_clearBtn').on('click', function(event) {
			<portlet:namespace /><%=idPrefix%>_deleteFile();
		});
		
		$('#<portlet:namespace /><%=idPrefix%>_clearFileBtn').on('click', function(event) {
			$('#<portlet:namespace/><%=idPrefix%>_clearBtn').trigger('click');
		});
		
		$('#<portlet:namespace /><%=idPrefix%>_viewDocumentBtn').on('click', function(event) {
			<portlet:namespace /><%=idPrefix%>_viewDocument();
		});
	});
</aui:script>

<%--
<div class="custom-file">
	<input type="file" class="custom-file-input" onchange="uploadFile('<portlet:namespace/><%=htmlElement.getName()%>', <%=progressBarId%>)" name="<portlet:namespace/><%=htmlElement.getName()+"_file"%>" id="<portlet:namespace/><%=htmlElement.getName()+"_file"%>">
	<label class="custom-file-label" for="customFile">Upload a file</label>
	<input type="hidden" name="<portlet:namespace/><%=htmlElement.getName()%>" id="<portlet:namespace/><%=htmlElement.getName()%>">
</div> 
<liferay-ui:upload-progress id="<%=progressBarId%>" message="uploading" height="5" />
--%>
