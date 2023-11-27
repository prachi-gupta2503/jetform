<%@page import="java.util.Collection"%>
<%@page import="java.util.stream.Collectors"%>
<%@ include file="/init.jsp"%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.model.Layout"%>
<%@page
	import="com.liferay.portal.kernel.service.LayoutLocalServiceUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.adj.userportlet.model.UserPortlet"%>
<%@page import="com.adj.userportlet.service.UserPortletLocalServiceUtil"%>
<%@page import="org.osgi.framework.Bundle"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.portlet.AddPortletProvider"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.adj.application.constants.ApplicationPortletKeys"%>
<%@page import="com.liferay.portal.kernel.util.PortletKeys"%>
<%@page import="java.util.Locale"%>
<%@page
	import="com.liferay.journal.service.JournalArticleLocalServiceUtil"%>
<%@page import="com.liferay.journal.model.JournalArticle"%>

<div class="bg-dark h-50 text-white font-weight-bold">&nbsp;&nbsp;Dashboard Widgets 
	<span id="application-widget-close" style="float:right;cursor:pointer;" class="font-weight-bold">
		<i class="fa fa-window-close mr-2" aria-hidden="true" style="color:white"></i>
	</span>
</div>
<table id="portlet_view"
	class="table table-bordered">
	<tbody>

		<%
		boolean isPortletAdded=false;
		if(null!=request.getAttribute("isPortletAdded")){
			isPortletAdded = (Boolean)request.getAttribute("isPortletAdded");
		}
		request.removeAttribute("isPortletAdded");
		String portalUrl = themeDisplay.getURLPortal();
		List<String> userPortlets  = (List<String>)request.getAttribute("userPortlets");
		Map<String,String> portletNameAndThumbnailMap = (Map<String,String>)request.getAttribute("portletNameAndThumbnailMap");
			for (String userPortlet : userPortlets) {
		%>
		<portlet:actionURL name="addPortlet" var="addPortletUrl1">
			<portlet:param name="porletId" value="<%=userPortlet%>"></portlet:param>
		</portlet:actionURL>
		<tr>
			<td><a href="<%=addPortletUrl1%>"><img
					src="<%=portalUrl %>/<%=portletNameAndThumbnailMap.get(userPortlet)%>"
					class="w-100" style="height: 150px;" /></td>
		<tr>

			<%
				}
			%>
		
	</tbody>
</table>
<script>
$(document).ready(function(){
	var isPortletAdded = <%=isPortletAdded%>;
	if(isPortletAdded){
		window.location.reload(true);
	}
})
</script>
