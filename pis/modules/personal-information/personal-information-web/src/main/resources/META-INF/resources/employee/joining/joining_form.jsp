<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp" %>
<% 
String formClass = ParamUtil.getString(request, "formClass");
String formId = ParamUtil.getString(request, "formId");
long joningId = ParamUtil.getLong(request, "classPK",0);
User loginuser = themeDisplay.getUser();

boolean isApprover=loginuser.getRoles().stream().anyMatch(r->r.getName().equalsIgnoreCase("PIS Approver-Regular"));

%>

<div class="page-wrapper">
	<div class="content container-fluid">
		<liferay-util:include page="/components/form/form-add.jsp" servletContext="<%=application%>">
		<liferay-util:param name="formClass" value="<%=formClass%>" />
		<liferay-util:param name="classPK" value="<%=String.valueOf(joningId) %>" />
		</liferay-util:include>
	</div>
</div>
<script>

<%if(isApprover){%>
$("#<portlet:namespace/><%=formId%>save").hide();
$("#<portlet:namespace/><%=formId%>cancel").hide();

<%}%>
</script>