<%@page import="org.apache.commons.collections.CollectionUtils"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.adjecti.dashboard.widget.model.DashboardWidget"%>
<%@page import="com.liferay.document.library.kernel.model.DLFileEntry"%>
<%@page import="com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.document.library.kernel.exception.FileEntryLockException"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.model.Layout"%>
<%@page
	import="com.liferay.portal.kernel.service.LayoutLocalServiceUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="org.osgi.framework.Bundle"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.portlet.AddPortletProvider"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.util.PortletKeys"%>
<%@page import="java.util.Locale"%>
<%@page
	import="com.liferay.journal.service.JournalArticleLocalServiceUtil"%>
<%@page import="com.liferay.journal.model.JournalArticle"%>
<%@ include file="/init.jsp"%>
<div class="bg-dark h-50 text-white font-weight-bold">&nbsp;&nbsp;Dashboard Widgets 
	<span id="application-widget-close" style="float:right;cursor:pointer;" class="font-weight-bold">
		<i class="fa fa-window-close mr-2" aria-hidden="true" style="color:white"></i>
	</span>
</div>
<portlet:resourceURL id="removeWidgetFromPage" var="removeWidgetURL"></portlet:resourceURL>
<table id="portlet_view"
	class="table table-bordered">
	<tbody>
			<tr>
				<td>
					<c:if test="${permissionChecker.isOmniadmin()}">
						<a href="<%=portalUrl %>/group<%=siteName%>/manage-dashboard" class="float-left" title="Add/Remove Widgets"><i class="fa fa-tasks" aria-hidden="true"></i></a>
					</c:if>
					<a href="#" class="float-right" title="Reload Widgets" onClick="realodPage();"><i class="fa fa-refresh" aria-hidden="true"></i></a>
				</td>
			</tr>
		<%
		boolean isPortletAdded=false;
		if(null!=request.getAttribute("isPortletAdded")){
			isPortletAdded = (Boolean)request.getAttribute("isPortletAdded");
		}
		request.removeAttribute("isPortletAdded");
		List<DashboardWidget> dashboardWidgets  = (List<DashboardWidget>)request.getAttribute("dashboardWidgets");
			if(CollectionUtils.isEmpty(dashboardWidgets)){
			%>
			<tr><td>No More Widgets Available.</td></tr>
			<%
			}
			for (DashboardWidget dashboardWidget : dashboardWidgets) {
				String fileEntryId = dashboardWidget.getThumbnail();
				String url="";
				if(StringUtils.isNotBlank(fileEntryId)){
					DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(Long.parseLong(fileEntryId));
					url = portalUrl + "/c/document_library/get_file?uuid=" + dlFileEntry.getUuid() + "&amp;groupId=" + dlFileEntry.getGroupId();
				}
				String imageTitle = dashboardWidget.getPortletName().substring(dashboardWidget.getPortletName().lastIndexOf("_")+1, dashboardWidget.getPortletName().length());
				
		%>
		<portlet:actionURL name="addWidgetToPage" var="addPortletUrl">
			<portlet:param name="porletName" value="<%=dashboardWidget.getPortletName()%>"></portlet:param>
		</portlet:actionURL>
		<tr>
			<td><a href="<%=addPortletUrl%>" title="<%=imageTitle%>" class="d-flex justify-content-center">
				<%
					if(StringUtils.isNotBlank(fileEntryId)){
				%>
						<img src="<%=url %>" class="w-100" style="height: 150px;" />
				<%
					} else {
				%>
						<img src="data:image/png;base64,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" data-atf="1" data-frt="0">
				<%
					} 
				%>
				</a>
			</td>
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
function realodPage(){
	//window.location.reload(true);
	Liferay.Portlet.refresh('#com_adjecti_dashboard_widget_web_DashboardWidgetPortlet_INSTANCE_application');
}
function removeWidget(element){
	if (confirm("Are you sure you want to remove this component?") == true) {
		var parentId = $(element).parent().attr("id");
		AUI().use('aui-base','io','aui-io-request', function(A){
		      var ajaxURL = '<%=removeWidgetURL%>';
		      ajaxURL =ajaxURL+"&<portlet:namespace />widgetName="+parentId;
			   A.io.request(ajaxURL, {
		              method: 'GET',
		              sync: true,
		              on: {
		                  complete: function(data) {
		                	 window.top.location.reload();
		                  }
		              }
		          });

	        });
	  } 
}
</script>
