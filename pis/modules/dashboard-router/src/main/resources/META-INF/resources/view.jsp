<%@page import="com.liferay.portal.kernel.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Layout"%>
<%@page import="dashboard.router.portlet.DashboardRouterPortlet"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@ include file="/init.jsp"%>
<%! public static Log log = LogFactoryUtil.getLog(DashboardRouterPortlet.class); %>
<%
String dashboardUrl = portalUrl+"/group"+siteName+"/dashboard-template";
long groupId = themeDisplay.getScopeGroupId(); 
long userId = themeDisplay.getUserId(); 
try{ 
	Layout userDashboardLayout = LayoutLocalServiceUtil.getLayoutByFriendlyURL(groupId, true, "/dashboard-template_"+userId);
	 
	if(userDashboardLayout!=null){ 
		dashboardUrl = portalUrl+"/group"+siteName+"/dashboard-template_"+userId;
	}else{
		log.info("No customized dashboard found, redirecting to defaut dashboard");
	}
}catch(Exception e){
	log.info("No customized dashboard found, redirecting to defaut dashboard");
} 
%>


<script>
$(function() {
	if(<%=!currentUrl.contains("dashboard-template")%>){
		window.location.href="<%=dashboardUrl %>";
	}
});
</script>