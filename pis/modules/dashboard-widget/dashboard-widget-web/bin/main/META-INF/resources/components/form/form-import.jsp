<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="org.apache.commons.lang.ClassUtils"%>
<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalService"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.liferay.document.library.kernel.model.DLFolderConstants"%>
<%@page import="com.adjecti.common.util.AnnotationUtil"%>
<%@page import="com.adjecti.common.util.ReflectionUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.security.RandomUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>

<%@ include file="/init.jsp"%>
<%--<script type="text/javascript" src="<%=request.getContextPath()%>/js/jetform-custom.js"></script> --%>

<%
//HtmlElementWrapper htmlElement=(HtmlElementWrapper)pageContext.getAttribute("htmlElement");
long repositoryId = themeDisplay.getScopeGroupId();
long folderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
String formClass = ParamUtil.getString(request, "formClass");
String progressBarId = "progressbar_".concat(String.valueOf(new Date().getTime()));

HtmlFormWrapper form=null;
if(StringUtils.isNotEmpty(formClass)){
	JetFormBuilderLocalService jetFormBuilderLocalService=(JetFormBuilderLocalService) request.getAttribute("jetFormBuilderLocalService");
	form = jetFormBuilderLocalService.getHtmlFormByClass(ClassUtils.getClass(formClass));
}

%>

<portlet:actionURL name="importData" var="importActionURL">
	<portlet:param name="formClass" value="<%=formClass%>" />
	<portlet:param name="mvcPath" value="/components/list/form-list.jsp" />
</portlet:actionURL>

<aui:form>
	<div class="card form-card" style="width:60%; margin-left:45px;">
		<div class="card-header header-primary">
			<%=form!=null?form.getTitle():formClass.substring(formClass.lastIndexOf(".")+1) %>
		</div>	
		<div class="card-body">
			<div class="input-group">
				<label class="form-control">
					<span id="<portlet:namespace />Import_fileName">Upload a document</span>
					<a id="<portlet:namespace />Import_uploadBtn" style="float: right;"><i class="fa fa-upload"></i></a>
					<a id="<portlet:namespace />Import_clearBtn" style="float: right; display:none;color:red;"><i class="fa fa-close"></i></a>
				</label>
				<input type="file" name="<portlet:namespace/>Import_file" id="<portlet:namespace/>Import_file" style="width:0px;" accept=".xls,.xlsx, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/vnd.ms-excel">
				<input type="hidden" name="<portlet:namespace/>Import_fileEntryId" id="<portlet:namespace/>Import_fileEntryId" value=""/> 
			</div>
		
			<liferay-ui:upload-progress id="<%=progressBarId%>" message="uploading" height="5"/>
		</div>
		<div class="card-footer">
			<div class="btn-group">
				<div class="btn-group-item">
					<aui:button cssClass="btn btn-primary" type="button" name="Import_importBtn" value="Import"/>
				</div>
				
				<div class="btn-group-item">
					<aui:button cssClass="btn btn-primary" type="button" name="Import_cancelBtn" value="Cancel" onClick="history.go(-1)"/>
				</div>
			</div>
		</div>
	</div>
</aui:form>
<aui:script use="aui-base, liferay-preview, liferay-util-window">
<%--	A.one('#<portlet:namespace /><%=htmlElement.getName()%>_uploadBtn').on('click', function(event) {
	
		var el = document.getElementById("<portlet:namespace/><%=htmlElement.getName()%>_file");
	    if (el) {
	        el.click();  
	    }
		A.one('#<portlet:namespace/><%=htmlElement.getName()%>_file').trigger('click');
	}); --%>
	$(document).ready(function() {
		$('#<portlet:namespace />Import_fileName').on('click', function(event) {
			//alert('#<portlet:namespace />Import_fileName_click');
			$('#<portlet:namespace/>Import_file').trigger('click');
		});
		
		$('#<portlet:namespace/>Import_file').on('change', function(event) {
			//alert('#<portlet:namespace />Import_file_change');
			uploadFile($('#<portlet:namespace/>Import_file'), <%=progressBarId%>, <portlet:namespace />Import_uploadFileOnSuccess);
		});
		
		$('#<portlet:namespace />Import_clearBtn').on('click', function(event) {
			//alert('#<portlet:namespace />Import_clearBtn_click');
			$('#<portlet:namespace/>Import_fileEntryId').val('');
			$('#<portlet:namespace/>Import_fileName').html('Browse a document');
			$('#<portlet:namespace />Import_uploadBtn').css("display", "block");
			$('#<portlet:namespace />Import_clearBtn').css("display", "none");
		});
	
		function <portlet:namespace />Import_uploadFileOnSuccess(response){
			//alert('<portlet:namespace />Import_uploadFileOnSuccess');
			$('#<portlet:namespace/>Import_fileEntryId').val(response.fileEntryId);
			$('#<portlet:namespace/>Import_fileName').html(response.fileName);
			$('#<portlet:namespace />Import_uploadBtn').css("display", "none");
			$('#<portlet:namespace />Import_clearBtn').css("display", "block");
			console.log(<%=progressBarId%>);
		}		
	
		$('#<portlet:namespace />Import_uploadBtn').on('click', function(event) {
			//alert('<portlet:namespace />Import_uploadBtn_click');
			$('#<portlet:namespace/>Import_file').trigger('click');
		});
		
		$('#<portlet:namespace/>Import_importBtn').on('click', function(event) {
			//alert('<portlet:namespace/>Import_importBtn_click');
			
			invokeImport();
		});
	});
	
	function invokeImport(){
		var fileEntryId=$('#<portlet:namespace/>Import_fileEntryId').val();
		//alert(fileEntryId);
		if(fileEntryId==''){
			alert('Please select a valid excel(xlsx) file to import!');
			return;
		}
		AUI().use('aui-base', function(A){
			Liferay.Service('/jetform.jetformbuilder/import-excel', 
		 		{
		 			'formClass':'<%=formClass%>',
		 			'fileEntryId': fileEntryId
		 		},
				function(response) {
					alert('Data imported successfully for '+response+' records.');
					console.log(response);
					$('#<portlet:namespace/>Import_importBtn').prop("disabled", true);
				}
		 	);
	 	});
 	}
 	
	function uploadFile(fileElement, progressBar, callback){
		//alert("uploadFile(fileElement, progressBar, callback)");
		var fileSelected=readFileUrl(fileElement);
		
		if(!fileSelected){
			return false;
		}
	
		var repositoryId = <%=repositoryId%>;
        var folderId = <%=folderId%>;
        var mimeType='';
        var description="Import file for <%=formClass %>";
        var changeLog=description;
        
		if(progressBar){
			progressBar.startProgress();
		}
		
		//alert("Before addFileEntry(repositoryId, folderId, description, fileSelected, callback)");
		addFileEntry(repositoryId, folderId, description, fileSelected, callback);
			//callback(fileElement, response);
		//});
		
		return fileSelected;
	}
	
	function addFileEntry(repositoryId, folderId, description, file, callback){
		//alert("In addFileEntry(repositoryId, folderId, description, fileSelected, callback)");
		var title = file.name;
		var primaryName = title.substr(0, title.lastIndexOf('.'));
		var fileExt = title.substr(title.lastIndexOf('.') + 1);
		title=primaryName+Date.now()+"."+fileExt;
		
		var form = new FormData();
		form.append("file", file, file.name);
		form.append("repositoryId", repositoryId);
		form.append("folderId", folderId);
		form.append("sourceFileName", file.name);
		form.append("mimeType", file.type);
		//form.append("title", file.name);
		form.append("title", title);
		form.append("description", description);
		form.append("changeLog", "Import for <%=formClass.substring(formClass.lastIndexOf(".")+1) %>");
		form.append("p_auth", Liferay.authToken);
		
		console.log(form);
		
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
			console.log("addFileEntry : " + response);
			console.log("addFileEntry");
			callback(JSON.parse(response));
		}).fail(function (xhr, status, error) { 
			console.log("addFileEntry fail errorThrown : "+error+" - "+status);
			console.log(xhr.responseText);
			var err=xhr.responseText;
			if(err.indexOf(".DuplicateFileEntryException")>0){
				alert("Aleady a file with same name has been imported. Please choose a different file.")
			}
			//var err = eval("(" + xhr.responseText + ")");
  			//alert(err.Message); 
		});
	}
</aui:script>
<script>
<%--function <%=htmlElement.getName()%>_clearFile(){
	var yn=confirm("Are you sure you want to clear the currently selected files?");
	if(yn){
		$('#<portlet:namespace />Import_clearBtn').trigger('click');
		$('#<%=htmlElement.getName()%>_fileViewContainer').css('display','none');
		$('#<%=htmlElement.getName()%>_container').css('display','block');
	}
}--%>
</script>
