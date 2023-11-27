<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.security.RandomUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlElementWrapper"%>

<%

HtmlElementWrapper htmlElement=(HtmlElementWrapper)pageContext.getAttribute("htmlElement");
String progressBarId = htmlElement.getName().concat("_progressbar");

%>

<div class="input-group">
	<label class="form-control" id="<portlet:namespace /><%=htmlElement.getName()+"_document"%>">
		<span id="<portlet:namespace /><%=htmlElement.getName()+"_fileName"%>">Upload a document</span>
		<a id="<portlet:namespace /><%=htmlElement.getName()+"_uploadBtn"%>" style="float: right;"><i class="fa fa-upload"></i></a>
		<a id="<portlet:namespace /><%=htmlElement.getName()+"_clearBtn"%>" style="float: right; display:none;"><i class="fa fa-close"></i></a>
	</label>
	<input type="hidden" name="<portlet:namespace /><%=htmlElement.getName()%>" id="<portlet:namespace/><%=htmlElement.getName()%>">
<%--	<input type="file" name="<portlet:namespace/><%=htmlElement.getName()+"_file"%>" id="<portlet:namespace/><%=htmlElement.getName()+"_file"%>">--%>
	<input type="file" name="<portlet:namespace/><%=htmlElement.getName()+"_file"%>" id="<portlet:namespace/><%=htmlElement.getName()+"_file"%>" style="width:0px;"> 
</div>
<liferay-ui:upload-progress id="<%=progressBarId%>" message="uploading" height="5" />

<aui:script use="aui-base, liferay-preview, liferay-util-window">
<%--	A.one('#<portlet:namespace /><%=htmlElement.getName()%>_uploadBtn').on('click', function(event) {
	
		var el = document.getElementById("<portlet:namespace/><%=htmlElement.getName()%>_file");
	    if (el) {
	        el.click();  
	    }
		A.one('#<portlet:namespace/><%=htmlElement.getName()%>_file').trigger('click');
	}); 
--%>
	
	A.one('#<portlet:namespace /><%=htmlElement.getName()%>_fileName').on('click', function(event) {
		$('#<portlet:namespace/><%=htmlElement.getName()%>_file').trigger('click');
	});
	
	A.one('#<portlet:namespace/><%=htmlElement.getName()%>_file').on('change', function(event) {
		uploadFile($('#<portlet:namespace/><%=htmlElement.getName()%>_file'), <%=progressBarId%>, <portlet:namespace /><%=htmlElement.getName()%>_uploadFileOnSuccess);
	});
	
	A.one('#<portlet:namespace /><%=htmlElement.getName()%>_clearBtn').on('click', function(event) {
		$('#<portlet:namespace /><%=htmlElement.getName()%>').val('');
		$('#<portlet:namespace /><%=htmlElement.getName()%>_fileName').html('Browse a document');
		$('#<portlet:namespace /><%=htmlElement.getName()%>_uploadBtn').css("display", "block");
		$('#<portlet:namespace /><%=htmlElement.getName()%>_clearBtn').css("display", "none");
	});

	function <portlet:namespace /><%=htmlElement.getName()%>_uploadFileOnSuccess(response){
		$('#<portlet:namespace/><%=htmlElement.getName()%>').val(response.fileEntryId);
		$('#<portlet:namespace/><%=htmlElement.getName()%>_fileName').html(response.fileName);
		$('#<portlet:namespace /><%=htmlElement.getName()%>_uploadBtn').css("display", "none");
		$('#<portlet:namespace /><%=htmlElement.getName()%>_clearBtn').css("display", "block");
		console.log(<%=progressBarId%>);
	}		

	$(document).ready(function() {
		$('#<portlet:namespace /><%=htmlElement.getName()%>_uploadBtn').on('click', function(event) {
			alert("<portlet:namespace /><%=htmlElement.getName()%>_uploadBtn).on(click, function(event)");
			
			$('#<portlet:namespace/><%=htmlElement.getName()%>_file').trigger('click');
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
