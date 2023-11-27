<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@ include file="/init.jsp" %>
<%
String formId = ParamUtil.getString(request, "formId");
String formClass = ParamUtil.getString(request, "formClass");
String redirectPage = ParamUtil.getString(request, "redirectPage");

%>
<div class="page-wrapper">
	<div class="content container-fluid">
		<liferay-util:include page="/components/form/form-add.jsp" servletContext="<%=application%>">
		<liferay-util:param name="formClass" value="<%=formClass%>" />
		<liferay-util:param name="redirectPage" value="<%=redirectPage%>" />
		</liferay-util:include>
	</div>
</div>

<aui:script>
$(document).ready(function(){
	$("#<portlet:namespace /><%=formId%>serviceRequestTypeId").attr('disabled', true);
	document.getElementById("<portlet:namespace /><%=formId%>status").options[1] = null;
})
</aui:script>