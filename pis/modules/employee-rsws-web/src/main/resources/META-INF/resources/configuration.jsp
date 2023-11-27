<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@ include file="/init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="<%= true %>"
    var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="<%= true %>"
    var="configurationRenderURL" />

<div class="p-5">
<aui:form action="<%= configurationActionURL %>" method="post" name="fm">

	<aui:input name="<%= Constants.CMD %>" type="hidden"
        value="<%= Constants.UPDATE %>" /> 

    <aui:input name="redirect" type="hidden"
        value="<%= configurationRenderURL %>" /> 
    <aui:fieldset>
        <aui:input label="Base Url"name="baseUrl" value="<%=baseUrl %>" type="text" />
        <aui:input label="Grade"name="gradeId" value="<%=gradeId %>" type="text" />
    </aui:fieldset>
    <aui:fieldset>
        <aui:select name="portletView" label="Select View Type" value="<%= portletView %>" >
            	<aui:option value="Select View Types">Choose View Type</aui:option>
            	<aui:option value="view">List View</aui:option>
            	<aui:option value="appex">Appex View</aui:option>
            	<aui:option value="whoisWho">Who's Who View</aui:option>
        </aui:select>
    </aui:fieldset>
    <aui:button-row>
        <aui:button type="submit"></aui:button>
    </aui:button-row>
</aui:form>
</div>