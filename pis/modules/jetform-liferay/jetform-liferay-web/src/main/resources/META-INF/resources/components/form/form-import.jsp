<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.security.RandomUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>

<%@ include file="/init.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jetform-custom.js"></script>

<%
//HtmlElementWrapper htmlElement=(HtmlElementWrapper)pageContext.getAttribute("htmlElement");
String formClass = ParamUtil.getString(request, "formClass");
String progressBarId = "progressbar_".concat(String.valueOf(new Date().getTime()));
%>

<portlet:actionURL name="importData" var="importActionURL">
	<portlet:param name="formClass" value="<%=formClass%>" />
	<portlet:param name="mvcPath" value="/components/list/form-list.jsp" />
</portlet:actionURL>

<aui:form action="<%=importActionURL%>" enctype="multipart/form-data">
<div class="card form-card" style="width:60%; margin-left:45px;">
	<div class="card-header header-primary">
		Import - <%=formClass.substring(formClass.lastIndexOf(".")+1) %>
	</div>	
	
	<div class="card-body">
		<%--<div class="input-group">
			<label class="form-control" id="<portlet:namespace />Import_document">
				<span id="<portlet:namespace />Import_fileName">Upload an excel file to import</span>
				<a id="<portlet:namespace />Import_uploadBtn" style="float: right;"><i class="fa fa-upload"></i></a>
				<a id="<portlet:namespace />Import_clearBtn" style="float: right; display:none;"><i class="fa fa-close"></i></a>
			</label>
			<input type="hidden" name="<portlet:namespace />Import" id="<portlet:namespace/>Import">
			<input type="file" name="<portlet:namespace/>Import_file" id="<portlet:namespace/>Import_file" style="width:0px;"> 
		</div>
		<liferay-ui:upload-progress id="<%=progressBarId%>" message="uploading" height="5" />
		 --%>
		 <div class="input-group">
			<label class="form-control" id="<portlet:namespace />Import_document">
				<span id="<portlet:namespace />Import_fileName">Upload an excel file to import</span>
				<a id="<portlet:namespace />Import_uploadBtn" style="float: right;"><i class="fa fa-upload"></i></a>
				<a id="<portlet:namespace />Import_clearBtn" style="float: right; display:none;"><i class="fa fa-close"></i></a>
			</label>
			<input type="file" name="uploadedFile" id="<portlet:namespace/>Import_file" style="width:0px;"> 
		</div>
	</div>
	<div class="card-footer">
		<div class="btn-group">
			<div class="btn-group-item">
				<aui:button cssClass="btn btn-primary" type="submit" name="<portlet:namespace/>submit" value="Import"/>
			</div>
			
			<div class="btn-group-item">
				<aui:button cssClass="btn btn-primary" type="button" name="<portlet:namespace/>cancel" value="Cancel" onClick="renderFormList()"/>
			</div>
		</div>
	</div>
</div>
</aui:form>
<aui:script use="aui-base, liferay-preview, liferay-util-window">
	A.one('#<portlet:namespace />Import_uploadBtn').on('click', function(event) {
	
		<%--var el = document.getElementById("<portlet:namespace/>Import_file");
	    if (el) {
	        el.click();  
	    }--%> 
		$('#<portlet:namespace/>Import_file').trigger('click');
	});
	
	A.one('#<portlet:namespace />Import_fileName').on('click', function(event) {
		$('#<portlet:namespace/>Import_file').trigger('click');
	});
	
<%--	A.one('#<portlet:namespace/>Import_file').on('change', function(event) {
		uploadFile($('#<portlet:namespace/>Import_file'), <%=progressBarId%>, <portlet:namespace />Import_uploadFileOnSuccess);
	}); --%>
	
	A.one('#<portlet:namespace />Import_clearBtn').on('click', function(event) {
		$('#<portlet:namespace/>Import').val('');
		$('#<portlet:namespace/>Import_fileName').html('Browse a document');
		$('#<portlet:namespace />Import_uploadBtn').css("display", "block");
		$('#<portlet:namespace />Import_clearBtn').css("display", "none");
	});

	function <portlet:namespace />Import_uploadFileOnSuccess(response){
		$('#<portlet:namespace/>Import').val(response.fileEntryId);
		$('#<portlet:namespace/>Import_fileName').html(response.fileName);
		$('#<portlet:namespace />Import_uploadBtn').css("display", "none");
		$('#<portlet:namespace />Import_clearBtn').css("display", "block");
		console.log(<%=progressBarId%>);
	}		
<%--
	$(document).ready(function() {
		$('#<portlet:namespace />Import_uploadBtn').on('click', function(event) {
			$('#<portlet:namespace/>Import_file').trigger('click');
		});
		
	});
 --%>
</aui:script>

<%--
<div class="custom-file">
	<input type="file" class="custom-file-input" onchange="uploadFile('<portlet:namespace/>Import', <%=progressBarId%>)" name="<portlet:namespace/><%=htmlElement.getName()+"_file"%>" id="<portlet:namespace/><%=htmlElement.getName()+"_file"%>">
	<label class="custom-file-label" for="customFile">Upload a file</label>
	<input type="hidden" name="<portlet:namespace/>Import" id="<portlet:namespace/>Import">
</div> 
<liferay-ui:upload-progress id="<%=progressBarId%>" message="uploading" height="5" />
--%>
