<%@page import="com.adjecti.mdm.liferay.model.AccomodationType"%>
<%@ include file="/init.jsp"%>

<%
//List<Employee> employees=EmployeeLocalServiceUtil.getEmployees(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
//request.setAttribute("list", employees);
%>

<liferay-util:include page="/components/list/form-list-restful.jsp" servletContext="<%=application%>">
	<liferay-util:param name="formClass" value="<%=AccomodationType.class.getName()%>" />
</liferay-util:include>