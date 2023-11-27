<%@page import="com.adjecti.pis.liferay.util.PISUserUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.adjecti.pis.liferay.config.PISMVCPortletConfig"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="org.apache.commons.lang.ClassUtils"%>
<%@page import="com.adjecti.common.util.FormEntityCache"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.MasterEntityLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.model.MasterEntity"%>
<%@page import="java.util.List"%>
<%@page import="com.fasterxml.jackson.core.type.TypeReference"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@ include file="/init.jsp"%>
<%!private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.pis.view_jsp");%>

<%
String portletView = portletPreferences.getValue(PISMVCPortletConfig.PORTLET_VIEW, PISMVCPortletConfig.MENU);
//PISUserUtil.setIdamAPIEndPoint("http://172.20.115.26:8095/user");
LOGGER.info("portletView : ######################### "+ portletView);	
	if(StringUtils.isEmpty(portletView) || portletView.equals(PISMVCPortletConfig.MENU)){
%>
	<liferay-util:include page="/menu.jsp" servletContext="<%=application%>">
	</liferay-util:include>
<%
	}else if(portletView.equals(PISMVCPortletConfig.EMPLOYEE_LIST)){
%>
	<liferay-util:include page="/employee/list/employee_list.jsp" servletContext="<%=application%>">
	</liferay-util:include>
<%
	}
	else if(portletView.equals(PISMVCPortletConfig.DSC_VIEW)){
		%>
			<liferay-util:include page="/dsc/employee-dsc.jsp" servletContext="<%=application%>">
			</liferay-util:include>
		<%
			}
	else if(portletView.equals(PISMVCPortletConfig.PROFILE_VIEW)){
%>
	<liferay-util:include page="/employee/profile/employee_profile.jsp" servletContext="<%=application%>">
	</liferay-util:include>
<%--
	}else if(portletView.equals(PISMVCPortletConfig.PROFILE_CHANGE_REQUEST)){
%>
	<%@ include file="/employee_profile_request.jsp"--%>
<%
	}
%>
<%--
<portlet:renderURL var="defaultViewRenderURL"/>
<%
	HttpServletRequest hsRequest=PortalUtil.getOriginalServletRequest(request);
	String view=hsRequest.getParameter("view");
	String employeeId=null;
	if(view==null){
		view="";
	}
	if(view.equalsIgnoreCase("profile")){
		employeeId=hsRequest.getParameter("employeeId");
		view="/employee/employee_profile.jsp";
	}else{
		view="/view_static_links.jsp";
	}
%>
<script type="text/javascript">
<!--
var url="<%=defaultViewRenderURL.toString()%>&<portlet:namespace/>mvcPath=<%=view%>";
<%
	if(employeeId!=null){
%>
		url=url+"&<portlet:namespace/>employeeId=<%=employeeId%>";
<%
	}
%>
window.location.href=url;
//-->
</script>		

 --%>