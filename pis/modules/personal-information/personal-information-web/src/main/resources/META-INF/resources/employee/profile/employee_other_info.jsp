<%@page import="com.adjecti.pis.liferay.form.constants.PISFormConstant"%>
<%@page import="com.adjecti.pis.liferay.constant.PISUserRole"%>
<%@page import="com.adjecti.pis.liferay.util.PISUserUtil"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeOrganization"%>
<%@page import="com.adjecti.common.util.FormEntityCache"%>
<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeVerification"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeFamily"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.adjecti.common.util.AnnotationUtil"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeWorkstation"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeTraining"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeTransfer"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeReporting"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeePromotion"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeePost"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeePastExperience"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeJoining"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeExperience"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeDeputation"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeConfirmation"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeBenefitScheme"%>
<%@page import="com.adjecti.mdm.liferay.model.BenefitScheme"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeApplication"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeAddress"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeQualificationLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.QualificationLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.model.Qualification"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeQualification"%>
<%@page import="com.adjecti.pis.liferay.model.People"%>
<%@page import="com.adjecti.mdm.liferay.service.DesignationLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.model.Designation"%>
<%@page import="com.adjecti.pis.liferay.service.PeopleLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.model.Employee"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ include file="/init.jsp"%>

<style>

.modal-header {
	background-color: #0b5fff !important;
	color: #fff !important;
	height: 3rem !important;
}
.modal-title {
	font-size: 1rem !important; 
}
.close .lexicon-icon{
	color: #fff;
}

</style>
<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.employee_profile_other_info_jsp");%>
<%
	//JetFormBuilderLocalServiceUtil.removeCachedForm("SectionMappingForm_123456");
	FormEntityCache.registerFormClass(EmployeeOrganization.class);
	long employeeId = ParamUtil.getLong(request, "employeeId", 0);

	Employee employee = null;
	try {
		if(employeeId>0){
			employee = EmployeeLocalServiceUtil.getEmployee(employeeId);
		}else{
			employee=EmployeeLocalServiceUtil.getEmployeeByEmailId(user.getEmailAddress());
			employeeId=employee.getEmployeeId();
		}
	} catch (Exception e) {
		LOGGER.info("Error : "+e.getMessage());
	}

	People people = null;
	try {
		people = PeopleLocalServiceUtil.getPeople(employee.getPeopleId());
	} catch (Exception e) {
	}

	Designation designation = null;
	try {
		designation = DesignationLocalServiceUtil.getDesignation(employee.getDesignationId());
	} catch (Exception e) {
	}

	Map<String, String> otherInfoClasses=new LinkedHashMap<String, String>();
	
	otherInfoClasses.put("Address",PISFormConstant.EMPLOYEEADDRESSFORM);
	 otherInfoClasses.put("Benefit Scheme", PISFormConstant.EMPLOYEEBEBEFITSCHEMEFORM);
	otherInfoClasses.put("Confirmation", PISFormConstant.EMPLOYEECONFIRMATIONFORM);
	otherInfoClasses.put("Deputation", PISFormConstant.EMPLOYEEDEPUTATIONFORM);
	otherInfoClasses.put("Experience", PISFormConstant.EMPLOYEEEXPERIENCEFORM);
	otherInfoClasses.put("Family", PISFormConstant.EMPLOYEEFAMILYFORM);
	otherInfoClasses.put("Joining", PISFormConstant.EMPLOYEEJOININGFORM);
	otherInfoClasses.put("Past Experience", PISFormConstant.EMPLOYEEPASTEXPERIENCEFORM);
	otherInfoClasses.put("Additional Sections", PISFormConstant.EMPLOYEEORGANIZATIONFORM);
	
	otherInfoClasses.put("Promotion", PISFormConstant.EMPLOYEEPROMOTIONFORM);
	otherInfoClasses.put("Qualification", PISFormConstant.EMPLOYEEQUALIFICATIONFORM);
	otherInfoClasses.put("Reporting", PISFormConstant.EMPLOYEEREPORTINGFORM);
	otherInfoClasses.put("Training", PISFormConstant.EMPLOYEETRAININGFORMFORM);
	otherInfoClasses.put("Transfer", PISFormConstant.EMPLOYEETRANSFERFORM);
	 
	
	
	
	otherInfoClasses.put("Workstation", PISFormConstant.EMPLOYEEWORKSTATIONFORM);
				
	//EmployeeQualification qualification= EmployeeQualificationLocalServiceUtil.get
	//EmployeeQualification qualification=QualificationLocalServiceUtil.getByEmployeeId(employee.getEmployeeId());
	LOGGER.info("employeeId : "+employeeId+", "+user.getEmailAddress());
%>
	<div class="row">
		<div class="col-md-12 section-content other-info-accordion">
			<!--Accordion wrapper-->
			<!--div class="accordion md-accordion" id="accordionEx" role="tablist" aria-multiselectable="true"-->
			<div class="card-header bg-primary">
				<h5 class="text-white">
					<i class="fa fa-cogs mr-1" aria-hidden="true"></i>Other Information
				</h5>
			</div>

			<div class="mt-1"></div>
			<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist" style="margin-bottom: 0px !important;">

				<!-- Accordion card -->
<%
	int i=0;
	for(Map.Entry<String, String> entry:otherInfoClasses.entrySet()){
		String tabLabel=entry.getKey();
		i++;
%>
				<li class="nav-item"><a class="nav-link <%=i==1?"active":""%>" id="pills-<%=i%>-tab" data-toggle="pill"
					href="#pills-<%=i%>" role="tab" aria-controls="pills-<%=i%>"
					aria-selected="true"><%=AnnotationUtil.getItemLabel(tabLabel)%></a></li>
<%
	}
%>

			</ul>
			<div class="tab-content" id="pills-tabContent" style="padding-top: 0px !important;">
				<!-- Card body -->
<%
boolean isAdmin=false;
boolean dialogModeTrue=true;
boolean profileEditor=false;
profileEditor=(PISUserUtil.isAdmin(user.getUserId()) || PISUserUtil.isCreater(user.getUserId()) || PISUserUtil.isApprover(user.getUserId()) || request.isUserInRole(PISUserRole.POWER_USER.name()) || request.isUserInRole("administrator"));

isAdmin=(PISUserUtil.isAdmin(user.getUserId()) || PISUserUtil.isCreater(user.getUserId()) || PISUserUtil.isApprover(user.getUserId()) || request.isUserInRole(PISUserRole.POWER_USER.name()) || request.isUserInRole("administrator"));

	i=0;
	for(Map.Entry<String, String> entry:otherInfoClasses.entrySet()){
		String className=entry.getKey();
		String oic=entry.getValue();
		
		i++;
		
		boolean hideRowActions=false;
		boolean hideSubmitAction=false;
		if(oic.equalsIgnoreCase(PISFormConstant.EMPLOYEEJOININGFORM)){
			hideRowActions=true;
		}
		if(oic.equalsIgnoreCase(PISFormConstant.EMPLOYEECONFIRMATIONFORM) ||oic.equalsIgnoreCase(PISFormConstant.EMPLOYEEDEPUTATIONFORM)||oic.equalsIgnoreCase(PISFormConstant.EMPLOYEETRANSFERFORM)||oic.equalsIgnoreCase(PISFormConstant.EMPLOYEEPROMOTIONFORM) ){
			hideSubmitAction=true;
		}
		
%>				
				<div class="tab-pane fade <%=i==1?"active show":""%>" id="pills-<%=i%>" role="tabpanel" aria-labelledby="pills-<%=i%>-tab">
<%--					<i class="fa fa-plus-square float-right btn-add admin-role" style="color: #007bff !important; font-size: 24px;"
						aria-hidden="true" data-toggle="modal" data-target="#EmployeeAddressModal"></i> --%>
					<%
					if(isAdmin) {
						
					%>
					<liferay-util:include page="/employee/profile/employee_other_info-list-restful.jsp" servletContext="<%=application%>">
						<liferay-util:param name="formClass" value="<%=oic%>" />
						<liferay-util:param name="top.header.template" value="/employee/profile/employee_other_info_list_header.jsp" />
						<liferay-util:param name="titleBar" value="false" />
						<liferay-util:param name="className" value="<%=className %>" />
						<liferay-util:param name="searchFilter[employeeId]" value="<%=String.valueOf(employeeId)%>"/>
						<liferay-util:param name="dialogMode" value="true" />
						<liferay-util:param name="hideRowActions" value="<%=String.valueOf(hideRowActions)%>" />
						<liferay-util:param name="hideSubmitAction" value="<%=String.valueOf(hideSubmitAction)%>" />
						
						<liferay-util:param name="redirectPage" value="/employee/profile/employee_other_info-list-restful.jsp" />
					
<%
						if(oic.equalsIgnoreCase(PISFormConstant.EMPLOYEEORGANIZATIONFORM)){
%>		
							<portlet:param name="searchFilter[organizationId]" value="<%=String.valueOf(employee.getOrganizationId())%>" />
							
					
<%
	}
%>		
					</liferay-util:include>
					<%
					}else {
						if(!profileEditor){
							hideRowActions=true;
						}
						
					%>
					<liferay-util:include page="/employee/profile/employee_other_info-list-restful.jsp" servletContext="<%=application%>">
						<liferay-util:param name="formClass" value="<%=oic%>" />
						<liferay-util:param name="top.header.template" value="/employee/profile/employee_other_info_list_header.jsp" />
						<liferay-util:param name="titleBar" value="false" />
						<liferay-util:param name="searchFilter[status]" value="<%=String.valueOf(1)%>"/>
						<liferay-util:param name="searchFilter[employeeId]" value="<%=String.valueOf(employeeId)%>"/>
						<liferay-util:param name="dialogMode" value="true" />
						<liferay-util:param name="hideRowActions" value="<%=String.valueOf(hideRowActions)%>" />
						<liferay-util:param name="hideSubmitAction" value="<%=String.valueOf(hideSubmitAction)%>" />
						
						<liferay-util:param name="redirectPage" value="/employee/profile/employee_other_info-list-restful.jsp" />
						
					</liferay-util:include>
					<% 
					}
					%>
				</div>
<%
	}
%>
			</div>
		</div>
	</div>
