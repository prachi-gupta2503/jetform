<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@page import="com.adjecti.liferay.chart.config.ChartConfiguration"%>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@page import="com.liferay.portal.kernel.util.Validator"%>



<liferay-theme:defineObjects />

<portlet:defineObjects />


<%
	ChartConfiguration chartConfiguration = (ChartConfiguration) renderRequest
	.getAttribute(ChartConfiguration.class.getName());

	String chart = "";
	String labels = "";
	String values = "";
	String name = "";

	if (Validator.isNotNull(chartConfiguration)) {
		chart = portletPreferences.getValue("chart", chartConfiguration.chart());
		labels = portletPreferences.getValue("labels", chartConfiguration.labels());
		values = portletPreferences.getValue("values", chartConfiguration.values());
		name = portletPreferences.getValue("name", chartConfiguration.name());
	}
%>

