<%@page import="com.adjecti.pis.joining.liferay.constants.MVCCommandNames"%>
<%@page import="com.liferay.portal.kernel.model.Organization"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.GradeLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.TradeLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.DesignationLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.service.OrganizationLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.model.Grade"%>
<%@page import="com.adjecti.mdm.liferay.model.Trade"%>
<%@page import="com.adjecti.mdm.liferay.model.Designation"%>

<%@page import="com.adjecti.pis.liferay.dto.EmployeeDTO"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.service.ServiceContext"%>
<%@page import="com.liferay.portal.kernel.service.ServiceContextThreadLocal"%>
<%@page import="com.liferay.portal.kernel.model.UserGroupRole"%>
<%@page import="com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp"%>

<link href="<%=request.getContextPath()%>/css/hrms-style.css" rel="stylesheet">

<style>
.round_image_avatar {
	border-radius: 50%;
	width: 50px;
	height: 50px;
}

.emptydiv {
	margin-top: 10px;
}

.table-avatar{
	align-items: center;
    display: inline-flex;
    font-size: inherit;
    font-weight: 400;
    margin: 0;
    padding: 0;
    vertical-align: middle;
    white-space: nowrap;
}    
</style>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/jquery.dataTables.min.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.dataTables.min.js"></script>
	
<%
	ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
	List<UserGroupRole> userGroupRoles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(serviceContext.getUserId());
	
	boolean isApprover = false;
	boolean isCreater = false;
	for (UserGroupRole role : userGroupRoles) {
		if (role.getRole().getName().equalsIgnoreCase("PIS_GR_A_Approver"))
			isApprover = true;
		if (role.getRole().getName().equalsIgnoreCase("PIS_GR_A_Entry"))
			isCreater = true;
	}
	
%>

<portlet:renderURL var="addJoiningProcessRenderUrl">
	<portlet:param name="mvcPath" value="/jsp/joiningProcess.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editJoiningProcessRenderUrl">
	<portlet:param name="mvcPath" value="/jsp/joiningProcess.jsp" />
</portlet:renderURL>

<portlet:renderURL var="searchRenderUrl">
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.SEARCH_EMPLOYEE%>" />
</portlet:renderURL>

<div class="page-wrapper">
	<div class="content container-fluid">
		<div class="page-header">
			<div class="row align-items-center">
				<div class="col">
					<h3 class="page-title">Employees</h3>
					<ul class="breadcrumb">
						<li class="breadcrumb-item"><a href="/group/comnet2/mdm">Employees</a></li>
						<li class="breadcrumb-item active"><%=(employeePortletView.equalsIgnoreCase("employee")?"All Employees":"New Joinings")%></li>
					</ul>
				</div>
				<div class="col-auto float-right ml-auto">
<% 
			if(!employeePortletView.equalsIgnoreCase("employee") && isCreater){	
%>					
					<a class="btn bg-primary float-right text-white" href="${addJoiningProcessRenderUrl}"><i class="fas fa-plus mr-1" style="color: #fff;" aria-hidden="true"></i>New Joining</a>
<%
			}
%>
				</div>
			</div>
		</div>
		<%@include file="/joining_list.jsp"%>
		<div id="employeeContent"></div>
	</div>
</div>