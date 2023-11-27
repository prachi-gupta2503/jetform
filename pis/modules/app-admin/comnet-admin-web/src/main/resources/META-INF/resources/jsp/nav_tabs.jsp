<%@page import="net.ayudh.comnet.admin.constants.MVCCommandNames"%>
<%@include file="/init.jsp" %>
    
<portlet:renderURL var="listApplicationUser">
	<portlet:param name="mvcRenderCommandName"  value="<%=MVCCommandNames.APPLICATION_USER_LIST %>" />
</portlet:renderURL>
<portlet:renderURL var="uploaders">
	<portlet:param name="mvcRenderCommandName"  value="<%=MVCCommandNames.UPLOADER_ROLE_LIST %>" />
</portlet:renderURL>
<portlet:renderURL var="approvers">
	<portlet:param name="mvcRenderCommandName"  value="<%=MVCCommandNames.APPROVER_ROLE_LIST %>" />
</portlet:renderURL>
<aui:button onClick="<%=listApplicationUser%>" value="User Access" />
<%-- <aui:button onClick="<%=uploaders%>" value="Uploaders" />
<aui:button onClick="<%=approvers%>" value="Approvers" />
 --%>
