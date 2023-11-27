<%@page import="com.adjecti.pis.liferay.model.EmployeePermission"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeVerification"%>
<%@page import="com.adjecti.pis.liferay.dto.TransferProcessRequestDTO"%>
<%@page import="com.adjecti.pis.liferay.model.ProcessFile"%>
<%@page import="com.adjecti.pis.liferay.model.JoiningProcess"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeBiodata"%>
<%@page import="com.adjecti.pis.liferay.form.constants.PISFormConstant"%>
<%@page import="com.adjecti.mdm.liferay.model.DeputationType"%>
<%@page import="com.adjecti.pis.liferay.model.Address"%>
<%@page import="com.adjecti.pis.liferay.model.Contact"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeContact"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeProfile"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeTransfer"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeePromotion"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeConfirmation"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeDeputation"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeJoining"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeReporting"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeQualification"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeFamily"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeTraining"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeePastExperience"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeExperience"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeBenefitScheme"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeWorkstation"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.adjecti.pis.liferay.service.ServiceRequestLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.model.IDAMFailedTransaction"%>
<%@page import="com.adjecti.pis.model.RegistrationRequest"%>
<%@page import="com.liferay.portal.kernel.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.service.UserGroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.constant.PISUserRole"%>
<%@page import="com.adjecti.pis.liferay.util.PISUserUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeOrganization"%>
<%@page import="com.adjecti.pis.liferay.model.OrganizationAssignment"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.adjecti.mdm.liferay.model.OrganizationDetail"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeAddress"%>
<%@page import="com.adjecti.pis.liferay.model.ServiceRequest"%>
<%@page import="com.adjecti.pis.liferay.constants.PISMVCPortletKeys"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeSeparationRequest"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeePromotionRequest"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeDeputationRequest"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeTransferRequest"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeDsc"%>

<%@page import="com.adjecti.pis.liferay.model.Employee"%>
<%@page import="com.adjecti.pis.liferay.model.People"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.MasterEntityLocalServiceUtil"%>
<%@page import="org.apache.commons.lang.ClassUtils"%>
<%@page import="com.adjecti.common.util.FormEntityCache"%>
<%@page import="com.adjecti.mdm.liferay.model.MasterEntity"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp"%>
<style>
<!--
.has-search .form-control {
    padding-left: 2.375rem;
}

.has-search .form-control-feedback {
    position: absolute;
    z-index: 2;
    display: block;
    width: 2.375rem;
    height: 2.375rem;
    line-height: 2.375rem;
    text-align: center;
    pointer-events: none;
    color: #aaa;
}
-->
</style>
<%!
private static final Log LOGGER = LogFactoryUtil.getLog("menu.jsp");
%>
<%
/* boolean isApprover=PISUserUtil.isApprover(user.getUserId()) || PISUserUtil.isPISAdmin(user.getUserId()); */
long employeeId=0;
long pendingServiceRequest=0;
try{
	Employee employee =  EmployeeLocalServiceUtil.getEmployeeByEmailId(user.getEmailAddress());
	if(employee!=null){
	employeeId=employee.getEmployeeId();
	pendingServiceRequest=ServiceRequestLocalServiceUtil.getServiceRequestByStatusAndOrganization(1, employee.getOrganizationId()).stream().count();
	}
}catch(Exception e){
	LOGGER.info(e.getMessage());
}
boolean employeeEditor=false;
employeeEditor=(PISUserUtil.isAdmin(user.getUserId()) || PISUserUtil.isCreater(user.getUserId()) || PISUserUtil.isApprover(user.getUserId()) || request.isUserInRole(PISUserRole.POWER_USER.name()) || request.isUserInRole("administrator"));



%>
	<div class="row">
		<div class="col-md-12">
			<div id="ajaxGetUserServletResponse"></div>
			
			<div class="search-container" style="margin-top:50px;">
				<div class="form-group has-search">
					<span class="fa fa-search form-control-feedback"></span>
					<input type="text" class="form-control" id="txt-search"
						placeholder="Search an option">
				</div>
			</div>
		</div>
	</div>

	<div id="filter-records" class="row" style="text-align: center">
		<%--  Place holder for links--%>
		No options avaliable.
	</div>
	<%--<a href="<%=createUserRenderURL.toString()%>">Create User</a>  --%>


<portlet:renderURL var="singleUserOnboardingListRenderURL">
	<portlet:param name="mvcPath" value="/user/user_onboarding_list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="manageIDAMUserURL">
	<portlet:param name="mvcPath" value="/user/recreate_user_list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="employeeListRenderURL">
	<portlet:param name="mvcPath" value="/employee/list/employee_list.jsp" />
</portlet:renderURL>

<%--<portlet:renderURL var="employeeListRenderURL">
	<portlet:param name="mvcRenderCommandName" value="<%=PISMVCPortletKeys.EMPLOYEE_LIST%>"/>
	<portlet:param name="listViewType" value="<%=PISMVCPortletKeys.LIST_DETAIL_VIEW%>"/>
</portlet:renderURL>
 --%>
<portlet:renderURL var="employeeAddressRenderURL">
	<portlet:param name="mvcPath" value="/employee/employeeAddressForm.jsp" />
</portlet:renderURL>

<portlet:renderURL var="peopleListRenderURL">
	<portlet:param name="mvcPath" value="/employee/people_list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="employeeJoiningListRenderURL">
	<portlet:param name="mvcPath" value="/employee/joining/joining_list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="employeeTransferRenderURL">
	<portlet:param name="mvcPath" value="/employee/transferProcessList.jsp" />
</portlet:renderURL>

<portlet:renderURL var="employeeDeputationRenderURL">
	<portlet:param name="mvcPath" value="/employee/deputationProcess.jsp" />
</portlet:renderURL>

<portlet:renderURL var="formListRenderURL">
	<portlet:param name="mvcPath" value="/master_list.jsp" />
</portlet:renderURL>

<portlet:renderURL var="employeeInfoRenderURL">
	<portlet:param name="mvcPath" value="/employee/employee_profile.jsp" />
</portlet:renderURL>

<portlet:renderURL var="importSectionRenderURL">
	<portlet:param name="mvcPath" value="/components/form/form-import.jsp" />
	<portlet:param name="formClass" value="<%=PISFormConstant.SECTIONIMPORTFORM%>" />
</portlet:renderURL>

<portlet:renderURL var="importSectionMappingRenderURL">
	<portlet:param name="mvcPath" value="/components/form/form-import.jsp" />
	<portlet:param name="formClass" value="<%=PISFormConstant.SECTIONMAPPINGIMPORTFORM%>" />
</portlet:renderURL>
<portlet:renderURL var="sectionMappingRenderURL">
	<portlet:param name="mvcPath" value="/components/list/form-list.jsp" />
	<portlet:param name="formClass" value="<%=PISFormConstant.SECTIONMAPPINGFORM%>" />
</portlet:renderURL>

<portlet:renderURL var="employeeAddressRenderURL">
	<portlet:param name="mvcPath" value="/components/list/form-list-restful.jsp" />
	<portlet:param name="formClass" value="<%=PISFormConstant.EMPLOYEEADDRESSFORM%>" />
</portlet:renderURL>
<portlet:renderURL var="divisionListURL">
	<portlet:param name="mvcPath" value="/mdm/division_master_list.jsp" />
	<portlet:param name="formClass" value="<%=PISFormConstant.DIVISIONFORM%>" />
</portlet:renderURL>

<portlet:renderURL var="unitListURL">
	<portlet:param name="mvcPath" value="/mdm/unit_master_list.jsp" />
	<portlet:param name="formClass" value="<%=PISFormConstant.UNITFORM%>" />
</portlet:renderURL> 

<portlet:renderURL var="sectionListURL">
	<portlet:param name="mvcPath" value="/mdm/section_master_list.jsp" />
	<portlet:param name="formClass" value="<%=PISFormConstant.SECTIONFORM%>" />
</portlet:renderURL>

<portlet:renderURL var="idamFailedTransactionListUrl">
	<portlet:param name="mvcPath" value="/idam/idam-failed-transaction-list.jsp" />
	<portlet:param name="formClass" value="<%=PISFormConstant.IDAMFAILEDTRANSACTIONFORM%>" />
</portlet:renderURL>

<portlet:renderURL var="myRequestListUrl">
	<portlet:param name="mvcPath" value="/service_request/myrequest-list.jsp" />
	<portlet:param name="formClass" value="<%=PISFormConstant.MYREQUESTFORM%>" />
</portlet:renderURL>

<portlet:renderURL var="approvalListUrl">
	<portlet:param name="mvcPath" value="/service_request/myapproval-list.jsp" />
	<portlet:param name="formClass" value="<%=PISFormConstant.MYAPPROVALFORM%>" />
</portlet:renderURL>

<portlet:renderURL var="profileViewRenderURL">
	<portlet:param name="mvcPath" value="/employee/profile/employee_profile.jsp" />
</portlet:renderURL>
<%-- 
 <portlet:renderURL var="organizationListURL">
	<portlet:param name="mvcPath" value="/organization/organization_detail_list.jsp" />
	
</portlet:renderURL> 
 --%>
<portlet:renderURL var="instituteListURL">
    <portlet:param name="mvcPath" value="/mdm/institute_master_list.jsp" />
    <portlet:param name="formClass" value="<%=PISFormConstant.INSTITUTEFORM%>" />
    </portlet:renderURL>
<script>
//const Handlebars = require("handlebars");

$(document).ready(function(){
	//console.log("$(document).ready(function()");
	var menuItems =[
<%if(employeeEditor){%>
		{"name":"Employees","icon":"fas fa-id-card","description":"Add or manage Employees","link":"<%=employeeListRenderURL.toString()%>"},
		{"name":"Bulk Onboarding","icon":"fas fa-users-cog","description":"Manage bulk onboarding of large number of employees.","link":"/group/comnet2/pis/bulk-onboarding"},
        {"name":"Institute","icon":"fas fa-building","description":"List of Institute","link":"<%=instituteListURL.toString()%>"},
		{"name":"Manage SSO/NON-SSO User","icon":"fas fa-user-edit","description":"Add or manage and recreate SSO/NON-SSO Users","link":"<%=manageIDAMUserURL.toString()%>"},
		{"name":"Division","icon":"fas fa-building","description":"List of Divisions","link":"<%=divisionListURL.toString()%>"},
		
		{"name":"Units","icon":"fas fa-building","description":"List of Units","link":"<%=unitListURL.toString()%>"},
		{"name":"Sections","icon":"fas fa-building","description":"List of Sections","link":"<%=sectionListURL.toString()%>"},
		{"name":"User Onboarding","icon":"fas fa-building","description":"Add or manage Single user","link":"<%=singleUserOnboardingListRenderURL.toString()%>"},
		<%--{"name":"My Requests","icon":"fas fa-random","description":"Raising requests for updating profile information","link":"<%=formListRenderURL%>&<portlet:namespace/>formClass=<%=ServiceRequestForm.class.getName()%>"},
		--%>
		{"name":"New Joining","icon":"fas fa-user-edit","description":"Add or manage new employee joining","link":"<%=employeeJoiningListRenderURL.toString()%>"},
		{"name":"Idam Failed Transaction","icon":"fa fa-ban","description":"","link":"<%=idamFailedTransactionListUrl.toString()%>&<portlet:namespace/>formClass=<%=PISFormConstant.IDAMFAILEDTRANSACTIONFORM%>"},
		{"name":"Approval Requests(" + '<%=pendingServiceRequest%>'+")" ,"icon":"fas fa-tasks","description":"You have(" + '<%=pendingServiceRequest%>'+") request for approval","link":"<%=approvalListUrl.toString()%>"},
			
<%	
	}
%>
		{"name":"My Profile","icon":"fas fa-user","description":"View request for update self profile.","link":"<%=profileViewRenderURL%>"},
		{"name":"My Requests","icon":"fas fa-chalkboard-teacher","description":"Raising requests for updating profile information","link":"<%=myRequestListUrl.toString()%>"},
		
		<%--{"name":"Employee Address","icon":"fas fa-random","description":"Raising requests for updating profile information","link":"<%=employeeAddressRenderURL.toString()%>"},
		{"name":"Import Section","icon":"fas fa-random","description":"Import sections from excel.","link":"<%=importSectionRenderURL.toString()%>"},
		{"name":"Import Section Mapping","icon":"fas fa-random","description":"Import sections mapping from excel.","link":"<%=importSectionMappingRenderURL.toString()%>"},
		{"name":"Section Mapping","icon":"fas fa-random","description":"Sections mapping from excel.","link":"<%=sectionMappingRenderURL.toString()%>"},--%>
		<%--{"name":"Employee Address","icon":"<i class='fas fa-random fa-3x'></i>","description":"Raising requests for updating employee address","link":"<%=employeeAddressRenderURL.toString()%>"},
		{"name":"Transfers","icon":"<i class='fas fa-random fa-3x'></i>","description":"Add or manage transfer of employees","link":"<%=employeeTransferRenderURL.toString()%>"},
		{"name":"Deputations","icon":"<i class='fas fa-recycle fa-3x'></i>","description":"Add or manage deputation of employees","link":"<%=employeeDeputationRenderURL.toString()%>"},
		{"name":"Promotions","icon":"<i class='fas fa-project-diagram fa-3x'></i>","description":"Add or manage employee","link":"<%=formListRenderURL%>&<portlet:namespace/>formClass=<%=EmployeePromotionRequestForm.class.getName()%>"},
		{"name":"Separations","icon":"<i class='fas fa-project-diagram fa-3x'></i>","description":"Add or manage employee","link":"<%=formListRenderURL%>&<portlet:namespace/>formClass=<%=EmployeeSeparationRequestForm.class.getName()%>"},
		
		{"name":"Peoples","icon":"<i class='fas fa-project-diagram fa-3x'></i>","description":"Add or manage people","link":"<%=peopleListRenderURL.toString()%>"},
		{"name":"Employee","icon":"<i class='fas fa-project-diagram fa-3x'></i>","description":"Add or manage employee","link":"<%=formListRenderURL%>&<portlet:namespace/>formClass=<%=EmployeeForm.class.getName()%>"},
		
		{"name":"Peoples","icon":"<i class='fas fa-project-diagram fa-3x'></i>","description":"Add or manage people","link":"<%=peopleListRenderURL.toString()%>"},
		{"name":"Employee","icon":"<i class='fas fa-project-diagram fa-3x'></i>","description":"Add or manage employee","link":"<%=formListRenderURL%>&<portlet:namespace/>formClass=<%=EmployeeForm.class.getName()%>"},
		{"name":"Employee Information","icon":"<i class='fas fa-project-diagram fa-3x'></i>","description":"View employee profile.","link":"<%=employeeInfoRenderURL%>"},
		{"name":"Employee Transfer","icon":"<i class='fas fa-project-diagram fa-3x'></i>","description":"Add or manage employee","link":"<%=formListRenderURL%>&<portlet:namespace/>formClass=<%=EmployeeTransferRequestForm.class.getName()%>"},
		{"name":"Employee Deputation","icon":"<i class='fas fa-project-diagram fa-3x'></i>","description":"Add or manage employee","link":"<%=formListRenderURL%>&<portlet:namespace/>formClass=<%=EmployeeDeputationRequestForm.class.getName()%>"},
		{"name":"Employee Promotion","icon":"<i class='fas fa-project-diagram fa-3x'></i>","description":"Add or manage employee","link":"<%=formListRenderURL%>&<portlet:namespace/>formClass=<%=EmployeePromotionRequestForm.class.getName()%>"},
		{"name":"Employee Separation","icon":"<i class='fas fa-project-diagram fa-3x'></i>","description":"Add or manage employee","link":"<%=formListRenderURL%>&<portlet:namespace/>formClass=<%=EmployeeSeparationRequestForm.class.getName()%>"}--%>
		];
	
	$('#txt-search').keyup(function(){
		
        let searchField = $(this).val();
        let regex = new RegExp(searchField, "i");
		if(searchField === '')  {
			renderMenu(menuItems);
			return;
		}

		var menuFilterList=[]; 
		var ctr=0;
		$.each(menuItems, function(index, item){
				  
			if (((item.name.search(regex) != -1))) {
				menuFilterList[ctr++]=item;
			}
		});
		renderMenu(menuFilterList);
    });
	renderMenu(menuItems);
<%-- <%
	int reloadedPage=ParamUtil.getInteger(request, "reloaded", 0);	
	if(reloadedPage==0){
%>
		reloadPage();
<%
	}
%> --%>
});

function renderMenu(menuRenderList){

	var source = $('#menu-cta-template').html();
	var template = Handlebars.compile(source);
	var resultHtml = template(menuRenderList);

	$("#filter-records").html(resultHtml);
}

/* function reloadPage(){
	var loc=window.location.href;
	if(loc.indexOf("<portlet:namespace/>reloaded=1")>0){
		return;
	}
	if(loc.indexOf("&")>0){
		window.location.href=window.location.href+"&<portlet:namespace/>reloaded=1";
	}else{
		window.location.href=window.location.href+"?<portlet:namespace/>reloaded=1";
	}
} */
</script>

<script type="text/x-handlebars-template" id="menu-cta-template">
	{{#each []}}
		<div class="c-m">
			<div class="col">
			
				<a href="{{link}}" class="mdm-anchor">
					<p class="text-primary">
						<i class='{{icon}} fa-3x'></i>
					</p>
					<h4>{{name}}</h4>
					<p>{{description}}</p>
				</a>
			</div>
		</div>
	{{/each}}
</script>
