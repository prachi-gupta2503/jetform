<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="net.ofb.comnet2.dashboard.birthday.portlet.configuration.BirthdayConfiguration"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@ include file="/init.jsp"%> 

<%
BirthdayConfiguration viewConfigurations = (BirthdayConfiguration) renderRequest.getAttribute(BirthdayConfiguration.class.getName());
String selectGroup="";
if (Validator.isNotNull(viewConfigurations)) {
	selectGroup = portletPreferences.getValue("selectGroup",viewConfigurations.selectGroup());
	
}
%>
<liferay-portlet:actionURL portletConfiguration="<%=true%>"
	var="configurationActionURL" />
<liferay-portlet:renderURL portletConfiguration="<%=true%>"
	var="configurationRenderURL" />
<aui:form action="${configurationActionURL}" method="post" name="fm">

	<aui:input name="<%=Constants.CMD%>" type="hidden"
		value="<%=Constants.UPDATE%>" />

	<aui:input name="redirect" type="hidden"
		value="${configurationRenderURL}" />
	<aui:fieldset>
		<aui:select name="selectGroup" label="Select View Type" value="<%=selectGroup %>">
			<aui:option value="-1">Select Group</aui:option>
			<aui:option value="A">Group A</aui:option>
			<aui:option value="B">Group B</aui:option>
			<aui:option value="C">Group C</aui:option>
		</aui:select>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit"></aui:button>
	</aui:button-row>
</aui:form>
	