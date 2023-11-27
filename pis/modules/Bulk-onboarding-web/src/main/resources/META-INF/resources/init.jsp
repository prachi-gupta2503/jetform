<%@page import="com.adjecti.onboarding.web.config.BulkOnboardingWebPortletConfig"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="java.util.List" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>

<%-- All Models Initialization --%>
<%@page import= "com.adjecti.pis.model.RegistrationRequest"%>
<%@page import= "com.adjecti.pis.dto.RegistrationRequestDTO"%>
<%@ page import="com.adjecti.mdm.liferay.model.Gender" %>
<%@ page import="com.adjecti.mdm.liferay.model.Designation" %>
<%@ page import="com.adjecti.mdm.liferay.model.Trade" %>
<%@ page import="com.adjecti.mdm.liferay.model.Grade" %>
<%@ page import="com.adjecti.mdm.liferay.model.CasteCategory" %>

<%-- All Service Initialization --%>
<%@page import= "com.adjecti.pis.service.RegistrationRequestLocalService"%>
<%@page import="com.adjecti.pis.service.RegistrationRequestLocalServiceUtil"%>
<%@page import= "com.adjecti.mdm.liferay.service.GenderLocalService"%>
<%@page import= "com.adjecti.mdm.liferay.service.DesignationLocalService"%>
<%@page import= "com.adjecti.mdm.liferay.service.TradeLocalService"%>
<%@page import= "com.adjecti.mdm.liferay.service.GradeLocalService"%>
<%@page import= "com.adjecti.mdm.liferay.service.CasteCategoryLocalService"%>
<%@page import="com.adjecti.mdm.liferay.service.CasteCategoryLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.GradeLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.TradeLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.DesignationLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.GenderLocalServiceUtil"%>


<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
	BulkOnboardingWebPortletConfig portletConfiguration=(BulkOnboardingWebPortletConfig)renderRequest.getAttribute(BulkOnboardingWebPortletConfig.class.getName());
%>