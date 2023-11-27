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

$("#<portlet:namespace /><%=formId%>organizationId").attr('disabled', true);
$("#<portlet:namespace />comments").attr('disabled', true);
$("#<portlet:namespace /><%=formId%>parentId").attr('disabled', true);
$("#<portlet:namespace />organizationCode").attr('disabled', true);
$("#<portlet:namespace />shortName").attr('disabled', true);
$("#<portlet:namespace />longName").attr('disabled', true);
$("#<portlet:namespace /><%=formId%>save").hide();
$("#<portlet:namespace /><%=formId%>cancel").hide();

})
</aui:script>
