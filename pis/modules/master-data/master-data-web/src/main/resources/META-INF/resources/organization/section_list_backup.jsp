<%@page import="java.net.URLEncoder"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.adjecti.mdm.liferay.service.OrganizationDetailLocalServiceUtil"%>
<%@ include file="/init.jsp"%>

<portlet:renderURL var="orgHierarchyURL">
	<portlet:param name="mvcPath" value="/organization/organizationChart.jsp" />
</portlet:renderURL>

<%
	String portalUrl = themeDisplay.getURLPortal(); // "http://localhost:8080"
	String currentUrl = themeDisplay.getURLCurrent(); // "/web/ordnance-factory-board/downloads"
	String siteName = layout.getGroup().getFriendlyURL(); // "/ofb"
	long groupId = layout.getGroup().getGroupId();
	
	String encodedPortalUrl = URLEncoder.encode(portalUrl);
	String encodedCurrentUrl = URLEncoder.encode(currentUrl);
	String encodedSiteName = URLEncoder.encode(siteName); 	

	JSONArray organizations=OrganizationDetailLocalServiceUtil.getOrganizationsByType("Section");
	request.setAttribute("list", organizations);
	
	String addOrgUrl="/group/control_panel/manage?p_p_id=com_liferay_users_admin_web_portlet_UsersAdminPortlet&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&_com_liferay_users_admin_web_portlet_UsersAdminPortlet_mvcRenderCommandName=%2Fusers_admin%2Fedit_organization&_com_liferay_users_admin_web_portlet_UsersAdminPortlet_type=organization";
	addOrgUrl+="&_com_liferay_users_admin_web_portlet_UsersAdminPortlet_redirect="+encodedCurrentUrl;

%>
<div class="page-wrapper">
	<div class="content container-fluid">
		<div class="page-header">
			<div class="row align-items-center">
				<div class="col">
					<h3 class="page-title">Organization</h3>
					<ul class="breadcrumb">
						<li class="breadcrumb-item"><a href="/group/comnet2/mdm">Master Data</a></li>
						<li class="breadcrumb-item active">Organization</li>
					</ul>
				</div>
				<div class="col-auto float-right ml-auto">
					<a class="btn btn-primary" title="Hierarchy" id="<portlet:namespace/>treeAction" href="<%=orgHierarchyURL.toString()%>">
						<i class="fa fa-sitemap mr-2" aria-hidden="true"></i>Hierarchy
					</a>
					<a class="btn btn-primary" title="Add" id="<portlet:namespace/>addAction" href="<%=addOrgUrl%>">
						<i class="fa fa-plus mr-2" aria-hidden="true"></i>Add Organization
					</a>
				</div>
			</div>
		</div>
		<liferay-util:include page="/components/list/json-data-list.jsp" servletContext="<%=application%>">
			<liferay-util:param name="apiUrl" value="/mdm.organizationdetail/get-organizations" />
			<liferay-util:param name="excludeAttributes" value="comments,description,logourl,parentorganizationid" />
		</liferay-util:include>
	</div>
</div>
