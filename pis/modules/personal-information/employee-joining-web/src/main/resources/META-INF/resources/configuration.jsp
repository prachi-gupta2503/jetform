<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@ include file="/init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="<%= true %>"
    var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="<%= true %>"
    var="configurationRenderURL" />

<aui:form action="<%= configurationActionURL %>" method="post" name="fm">

	<aui:input name="<%= Constants.CMD %>" type="hidden"
        value="<%= Constants.UPDATE %>" /> 

    <aui:input name="redirect" type="hidden"
        value="<%= configurationRenderURL %>" /> 
    
    <aui:fieldset>
        <aui:select name="employeePortletView" label="Select View Type" value="<%= employeePortletView %>" >
            	<aui:option value="Select View Types">Choose View Type</aui:option>
            	<aui:option value="employee">Employee</aui:option>
            	<aui:option value="newJoining">New Joining</aui:option>
        </aui:select>
    </aui:fieldset>
    <aui:button-row>
        <aui:button type="submit"></aui:button>
    </aui:button-row>
</aui:form>