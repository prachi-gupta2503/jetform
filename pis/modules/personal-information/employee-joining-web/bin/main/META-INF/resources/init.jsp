<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.adjecti.pis.joining.liferay.web.config.EmployeeViewConfiguration"%>
<%@page import="com.adjecti.pis.liferay.dto.EmployeeDTO"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib prefix="clay" uri="http://liferay.com/tld/clay" %>
<%@ taglib prefix="liferay-ddm" uri="http://liferay.com/tld/ddm" %>
<%@ taglib prefix="liferay-item-selector" uri="http://liferay.com/tld/item-selector" %>
<%@ taglib prefix="liferay-frontend" uri="http://liferay.com/tld/frontend" %>
<%@ taglib prefix="liferay-security" uri="http://liferay.com/tld/security" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<liferay-frontend:defineObjects />
<liferay-theme:defineObjects />

<portlet:defineObjects />
<link href="<%=request.getContextPath()%>/css/multistep.form.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<%-- <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/popper.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script> --%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/multistep.form.js"></script>


<%
	EmployeeViewConfiguration employeeViewConfiguration = (EmployeeViewConfiguration) renderRequest.getAttribute(EmployeeViewConfiguration.class.getName());
	
	String employeePortletView = StringPool.BLANK;
	
	
	if (Validator.isNotNull(employeeViewConfiguration)) {
		employeePortletView = portletPreferences.getValue("employeePortletView",employeeViewConfiguration.employeePortletView());
	}
%>
