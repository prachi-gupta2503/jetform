<%@page import="com.adjecti.pis.liferay.form.constants.PISFormConstant"%>
<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.security.auth.PrincipalThreadLocal"%>
<%@page import="com.adjecti.pis.liferay.util.PISUserUtil"%>
<%@page import="com.liferay.portal.kernel.model.Organization"%>
<%@page import="java.util.List"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormWrapper"%>
<%@page import="com.adjecti.jetform.annotation.HtmlFormAction"%>
<%@page import="com.adjecti.pis.liferay.constants.PISMVCPortletKeys"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ include file="/init.jsp"%>
<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.employee.list.employee_002dlist_jsp");
%>
<%
	//JetFormBuilderLocalServiceUtil.removeCachedForm("EmployeeForm_123456");
	String listViewType=ParamUtil.getString(request, "listViewType", PISMVCPortletKeys.LIST_DETAIL_VIEW);
	List<Organization> organizations=PISUserUtil.getUnitByRoles(PrincipalThreadLocal.getUserId());
	
	String organizationId="-1";
	for(Organization o:organizations){
		organizationId+=","+o.getOrganizationId();
	}
	//organizationId="123002,26";
	LOGGER.info("organizationId : "+organizationId);
%>
 <!-- div class="page-wrapper">
	<div class="content container-fluid"> -->
		<liferay-util:include page="/components/list/form-list-restful.jsp" servletContext="<%=application%>">
			<liferay-util:param name="formClass" value="<%=PISFormConstant.EMPLOYEEFORM%>" />
			<liferay-util:param name="top.header.template" value="/employee/list/employee_list_header.jsp" />
			<liferay-util:param name="top.action.template" value="/employee/list/employee_list_top_actions.jsp" />
			<liferay-util:param name="search.template" value="/employee/list/employee_list_search.jsp" />
			<liferay-util:param name="action.redirect.url" value="/employee/list/employee_list.jsp" />
			<liferay-util:param name="searchFilter[organizationId]" value="<%=organizationId%>" />
		</liferay-util:include>
<!-- 	</div>
</div> -->
<%
String formId=(String)request.getAttribute("formId");
HtmlFormWrapper form=(HtmlFormWrapper)request.getAttribute(formId);
%>
<portlet:renderURL var="profileViewRenderURL">
	<portlet:param name="mvcPath" value="/employee/profile/employee_profile.jsp" />
</portlet:renderURL>

<script>
 $(document).ready(function(){
	 $('#<portlet:namespace/>doSearchBtn').click(function(){
		 <portlet:namespace/>search();
	})
	
	$('#<portlet:namespace/>clearSearchBtn').click(function(){
		<portlet:namespace/>clearSearch();
	})
 })
 
 function <portlet:namespace/><%=form.getId()%><%=HtmlFormAction.ACTION_VIEW%>HandleOnClick(actionSource){
	 var employeeId=$(actionSource).attr("data-key");
	 window.location.href="<%=profileViewRenderURL.toString()%>&<portlet:namespace/>employeeId="+employeeId;
 }
 
 function <portlet:namespace/><%=form.getId()%>fullName_EnOnClick(employeeId){
	 console.log(employeeId);
	 window.location.href="<%=profileViewRenderURL.toString()%>&<portlet:namespace/>employeeId="+employeeId;
 }
 
 function <portlet:namespace/>search(){
	var searchParams={};
	var paramCtr=0;
	searchParams['objectClass']=$('#<portlet:namespace/>objectClass').val();
	if($('#<portlet:namespace/>organizationId').val()!=''){
		searchParams['organizationId']=$('#<portlet:namespace/>organizationId').val();
		paramCtr++;
	}
	if($('#<portlet:namespace/>designationId').val()!=''){
		searchParams['designationId']=$('#<portlet:namespace/>designationId').val();
		paramCtr++;
	}
	if($('#<portlet:namespace/>gradeId').val()!=''){
		searchParams['gradeId']=$('#<portlet:namespace/>gradeId').val();
		paramCtr++;
	}
	if($('#<portlet:namespace/>tradeId').val()!=''){
		searchParams['tradeId']=$('#<portlet:namespace/>tradeId').val();
		paramCtr++;
	}
	if(paramCtr<1){
		//alert("Please select atleast one option to search.")
		Liferay.Util.openWindow({
			dialog: {
				bodyContent: "Please select atleast one option to search.",
				headerContent: 'Search Employee',
				centered: true,
				modal: true,
				close: true,
				height: 160,
				width: 400
			},
			id: "alert-dialog",
			title: "Search Employee",
			//uri: "#"
		});
		
		return;
	}
	<portlet:namespace/>propagateSearch(searchParams);
	$('#<portlet:namespace/>doSearchBtn').hide();
	$('#<portlet:namespace/>clearSearchBtn').show();
}
 
function <portlet:namespace/>clearSearch(){
	var searchParams={};
	searchParams['objectClass']=$('#<portlet:namespace/>objectClass').val();
	<portlet:namespace/>propagateSearch(searchParams);
	$('#<portlet:namespace/>searchForm').trigger("reset");
	$('#<portlet:namespace/>doSearchBtn').show();
	$('#<portlet:namespace/>clearSearchBtn').hide();
}
</script>
