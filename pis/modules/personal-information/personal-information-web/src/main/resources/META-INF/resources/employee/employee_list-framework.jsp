
<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.form.constants.PISFormConstant"%>
<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalService"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>


<%@ include file="/init.jsp"%>

<%
HtmlFormWrapper form = null;
//JetFormBuilderLocalService jetFormBuilderLocalService=(JetFormBuilderLocalService) request.getAttribute("jetFormBuilderLocalService");
form =JetFormBuilderLocalServiceUtil.rendererForm(PISFormConstant.EMPLOYEEFORM);
request.setAttribute("form"+PISFormConstant.EMPLOYEEFORM, form);
%>
<portlet:renderURL var="employeeViewRenderURL">
	<portlet:param name="mvcPath" value="/employee/employee_profile.jsp" />
</portlet:renderURL>

<liferay-util:include page="/components/list/form-list-restful.jsp" servletContext="<%=application%>">
	<liferay-util:param name="formClass" value="<%=PISFormConstant.EMPLOYEEFORM%>" />
</liferay-util:include>

<script>
function <portlet:namespace/><%=form.getId()%>viewBeforeOnClick(actionSource){
	alert ("<portlet:namespace/><%=form.getId()%>viewBeforeOnClick("+$(actionSource).attr("data-key")+")");
	window.location.href='<%=employeeViewRenderURL.toString()%>&<portlet:namespace/>employeeId='+$(actionSource).attr("data-key");
	return false;
}
</script>
