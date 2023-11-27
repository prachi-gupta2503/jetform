<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormAction"%>
<%@page import="com.adjecti.common.util.FormEntityCache"%>
<%@page import="com.adjecti.pis.liferay.model.Employee"%>
<%@ include file="/init.jsp"%>



<liferay-util:include page="/components/list/form-list.jsp" servletContext="<%=application%>">
	<liferay-util:param name="formClass" value="<%=Employee.class.getName()%>" />
</liferay-util:include>

								
<script>
	window.location.href='<%=employeeListRenderURL.toString()%>';
</script>
	
OR

<portlet:renderURL id="listEmployee" var="employeeListRenderURL">
	<portlet:param name="formClass" value="<%=Employee.class.getName()%>" />
	<portlet:param name="mvcPath" value="/components/list/form-list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="addEntityRenderURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/components/form/form-add.jsp" />
	<portlet:param name="formClass" value="<%=Employee.class.getName()%>" />
	<portlet:param name="formClassPK" value="<%=1024%>" />
	<portlet:param name="formAction" value="<%=HtmlFormAction.ACTION_ADD%>" />
</portlet:renderURL>
