<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.liferay.petra.string.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="net.ayudh.portal.employee.web.config.ViewConfiguration"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>



<liferay-theme:defineObjects />

<portlet:defineObjects />
<%--<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.5.1.min.js"></script> --%>

<%
	ViewConfiguration viewConfigurations = (ViewConfiguration) renderRequest
			.getAttribute(ViewConfiguration.class.getName());
	String portletView = StringPool.BLANK;
	String baseUrl = StringPool.BLANK;
	String gradeId = null;
	
	
	if (Validator.isNotNull(viewConfigurations)) {
		portletView = portletPreferences.getValue("portletView",viewConfigurations.portletView());
		baseUrl=portletPreferences.getValue("baseUrl", viewConfigurations.baseUrl());
		gradeId=portletPreferences.getValue("gradeId", viewConfigurations.gradeId());
		
		
	}
%>