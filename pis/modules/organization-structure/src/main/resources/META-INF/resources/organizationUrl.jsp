<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@include file="/init.jsp" %>

<portlet:renderURL var="addOrganizationURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/addOrganization.jsp" />
</portlet:renderURL>

<portlet:renderURL var="updateOrganizationURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/addOrganization.jsp" />
</portlet:renderURL>
