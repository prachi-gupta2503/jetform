<%@page import="com.adjecti.pis.liferay.form.constants.PISFormConstant"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeAddress"%>
<%@page import="org.apache.commons.collections.CollectionUtils"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeWorkstation"%>
<%@page import="com.adjecti.pis.liferay.constant.PISUserRole"%>
<%@page import="com.adjecti.pis.liferay.util.PISUserUtil"%>
<%@page import="com.adjecti.jetform.liferay.service.JetFormBuilderLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeBiodataLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeBiodata"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeOrganizationLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeOrganization"%>
<%@page import="com.adjecti.common.util.FormEntityCache"%>
<%@page import="com.adjecti.mdm.liferay.service.OrganizationDetailLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.model.OrganizationDetail"%>
<%@page import="com.adjecti.mdm.liferay.service.PostOrganizationLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.model.PostOrganization"%>
<%@page import="com.adjecti.mdm.liferay.service.QualificationLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.model.Qualification"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="com.liferay.document.library.kernel.model.DLFileEntry"%>
<%@page import="com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.Date"%>
<%@page import="com.adjecti.common.util.ReflectionUtil"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeWorkstationLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.WorkStationLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.PostLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeePostLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeePost"%>
<%@page import="com.adjecti.mdm.liferay.model.Post"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeExperienceLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeExperience"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeQualificationLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeQualification"%>
<%@page import="java.util.List"%>
<%@page import="com.adjecti.pis.liferay.service.PeopleLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeReportingLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeReporting"%>
<%@page import="com.adjecti.pis.liferay.model.Employee"%>
<%@page import="com.adjecti.pis.liferay.model.People"%>
<%@page import="com.adjecti.pis.liferay.service.ContactLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeContactLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeContact"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeAddressLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.service.AddressLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.model.Address"%>
<%@page import="com.adjecti.mdm.liferay.service.GenderLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.model.Gender"%>
<%@page import="com.liferay.portal.kernel.service.OrganizationLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Organization"%>
<%@page import="com.adjecti.mdm.liferay.service.TradeLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.model.Trade"%>
<%@page import="com.adjecti.mdm.liferay.service.GradeLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.model.Grade"%>
<%@page import="com.adjecti.mdm.liferay.service.DesignationLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.model.Designation"%>
<%@ include file="/init.jsp"%>
<%-----employee object is defined in employee_profile.jsp --%>
<%	
	//JetFormBuilderLocalServiceUtil.removeCachedForm("EmployeeForm_123456");
	//JetFormBuilderLocalServiceUtil.removeCachedForm("EmployeePersonalInfo_123456");
	boolean profileEditor=false;
	boolean self=false;
	profileEditor=(PISUserUtil.isAdmin(user.getUserId()) || PISUserUtil.isCreater(user.getUserId()) || PISUserUtil.isApprover(user.getUserId()) || request.isUserInRole(PISUserRole.POWER_USER.name()) || request.isUserInRole("administrator"));
	self=StringUtils.equalsIgnoreCase(employee.getLoginId(), user.getScreenName());
	
	
	
	
	
	//JetFormBuilderLocalServiceUtil.removeCachedForm("EmployeeBiodataForm_123456");	
	Designation designation = null;
	try {
		designation = DesignationLocalServiceUtil.getDesignation(employee.getDesignationId());
	} catch (Exception e) {
		designation = DesignationLocalServiceUtil.createDesignation(0);
	}

	Grade grade = null;
	try {
		grade = GradeLocalServiceUtil.getGrade(employee.getGradeId());
	} catch (Exception e) {
		grade = GradeLocalServiceUtil.createGrade(0);
	}

	Trade trade = null;
	try {
		trade = TradeLocalServiceUtil.getTrade(employee.getTradeId());
	} catch (Exception e) {
		trade = TradeLocalServiceUtil.createTrade(0);
	}

	OrganizationDetail organization = null;
	try {
		organization = OrganizationDetailLocalServiceUtil.getOrganizationDetail(employee.getOrganizationId());
	} catch (Exception e) {
		organization = OrganizationDetailLocalServiceUtil.createOrganizationDetail(0);
	}
	String division="";
	try{
	 division=OrganizationDetailLocalServiceUtil.getOrganizationDetail(organization.getParentId()).getShortName();
	}catch(Exception e){
		
	}	
	OrganizationDetail subOrganization = null;
	try {
		subOrganization = OrganizationDetailLocalServiceUtil.getOrganizationDetail(employee.getSubOrganizationId());
	} catch (Exception e) {
		subOrganization = OrganizationDetailLocalServiceUtil.createOrganizationDetail(0);
	}
	
	Gender gender = null;
	try {
		gender = GenderLocalServiceUtil.getGender(people.getGenderId());
	} catch (Exception e) {
		gender = GenderLocalServiceUtil.createGender(0);
	}

	Address address = null;
	try {
		
		 EmployeeAddress employeeAddress = EmployeeAddressLocalServiceUtil.getEmployeeAddressByEmpId(employee.getEmployeeId())
				 														  .stream()
				 														  .filter(emp->emp.getStatus()==1)
				 														  .findFirst().get();
		
		address = AddressLocalServiceUtil.getAddress(employeeAddress.getAddressId());
	} catch (Exception e) {}

	if(address==null){
		address = AddressLocalServiceUtil.createAddress(0);
	}
	
	EmployeeContact employeeContact=null;
	
	try {
		employeeContact = EmployeeContactLocalServiceUtil.getEmployeeContactByEmployeeId(employee.getEmployeeId());
	} catch (Exception e) {}
	
	if(employeeContact==null){
		employeeContact = EmployeeContactLocalServiceUtil.createEmployeeContact(0);
	}
	
	com.adjecti.pis.liferay.model.Contact empContact = null;
	try {
		empContact = ContactLocalServiceUtil.getContact(employeeContact.getContactId());
	} catch (Exception e) {}
	
	if(empContact==null){
		empContact = ContactLocalServiceUtil.createContact(0);
	}
	People reporteePeople = null;
	Employee reporteeEmployee = null;
	try {
		List<EmployeeReporting> reportings=EmployeeReportingLocalServiceUtil.getByEmployeeId(employee.getEmployeeId())
																			.stream()
																			.filter(empqua->empqua.getStatus()==1)
																			.collect(Collectors.toList());
		EmployeeReporting reporting = reportings.get(reportings.size()-1); 
		reporteeEmployee = EmployeeLocalServiceUtil.getEmployee(reporting.getReportingToId());
		reporteePeople = PeopleLocalServiceUtil.getPeople(reporteeEmployee.getPeopleId());
	} catch (Exception e) {}
	
	if (reporteeEmployee == null) {
		reporteeEmployee = EmployeeLocalServiceUtil.createEmployee(0);
	}
	if (reporteePeople == null) {
		reporteePeople = PeopleLocalServiceUtil.createPeople(0);
	}
	
	List<EmployeeQualification> qualifications = EmployeeQualificationLocalServiceUtil.getEmployeeQualificationByEmployeeId(employee.getEmployeeId())
																					.stream()
																					.filter(empqua->empqua.getStatus()==1)
																					.collect(Collectors.toList());
	List<EmployeeExperience> experiences = EmployeeExperienceLocalServiceUtil.getByEmployeeId(employee.getEmployeeId())
																			 .stream()
																			 .filter(empExp->empExp.getStatus()==1)
																			 .collect(Collectors.toList());
	
	Post post=null;
	EmployeePost empPost=null;
	try{
		empPost=EmployeePostLocalServiceUtil.getByEmployeeId(employee.getEmployeeId()).get(0);
		post= PostLocalServiceUtil.getPost(empPost.getPostId());
	} catch (Exception e) {}
	
	if(empPost==null){
		empPost=EmployeePostLocalServiceUtil.createEmployeePost(0);
	}
	
	if(post==null){
		post=PostLocalServiceUtil.createPost(0);
	}
	List<EmployeePost> posts = EmployeePostLocalServiceUtil.getByEmployeeId(employee.getEmployeeId()).stream().filter(empPo->empPo.getStatus()==1).collect(Collectors.toList());;
	
	EmployeeWorkstation employeeWorkStation=null; 
	try{
		List<EmployeeWorkstation> employeeWorkStationList=EmployeeWorkstationLocalServiceUtil.getByEmployeeId(employee.getEmployeeId())
																							 .stream()
																							 .filter(empWs->empWs.getStatus()==1)
																							 .collect(Collectors.toList());
		if(CollectionUtils.isNotEmpty(employeeWorkStationList)){
			employeeWorkStation = employeeWorkStationList.get(0);
		}
	} catch (Exception e) {}
	
	if(employeeWorkStation==null){
		employeeWorkStation=EmployeeWorkstationLocalServiceUtil.createEmployeeWorkstation(0);
	}
	//EmployeeQualification qualification= EmployeeQualificationLocalServiceUtil.get
	//EmployeeQualification qualification=QualificationLocalServiceUtil.getByEmployeeId(employee.getEmployeeId());
	
	EmployeeBiodata biodata=null;
	try{
		biodata=EmployeeBiodataLocalServiceUtil.getEmployeeBiodataByEmployeeId(employee.getEmployeeId()); 
	} catch (Exception e) {}
	
	if(biodata==null){
		biodata=EmployeeBiodataLocalServiceUtil.createEmployeeBiodata(0);
	}
	
	//EmployeeQualification qualification= EmployeeQualificationLocalServiceUtil.get
	//EmployeeQualification qualification=QualificationLocalServiceUtil.getByEmployeeId(employee.getEmployeeId());
%>

	
<div class="card mb-0">
	<div class="card-body">
		<div class="row">
			<div class="col-md-12">
				<div class="profile-view">
					<div class="profile-img-wrap">
						<div class="profile-img">
							<portlet:renderURL var="editProfileImageURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
								<portlet:param name="mvcPath" value="/components/form/form-add.jsp" />
								<portlet:param name="formClass" value="<%=PISFormConstant.PROFILEIMAGEFORM%>" />
								<portlet:param name="formClassPK" value="<%=String.valueOf(people.getPeopleId())%>" />
								<portlet:param name="dialogMode" value="true" />
							</portlet:renderURL>
							<%
							String profileImageUrl=request.getContextPath()+"/images/black-employee-image.png";
							if(people.getProfileImageId()>0){
								try{
								DLFileEntry fileEntry=DLFileEntryLocalServiceUtil.getDLFileEntry(people.getProfileImageId());
									profileImageUrl="/documents/"+fileEntry.getRepositoryId()+"/"+fileEntry.getFolderId()+"/"+URLEncoder.encode(fileEntry.getFileName());
								}catch(Exception e){}
							}
							%>
							<img alt="Profile Image" src="<%=profileImageUrl%>"/>
							<div class="overlay">
<%
	if(profileEditor || self){
%>							
							    <div class="text"><a class="" id="<portlet:namespace/>editProfileImage" style="z-index:99999;"><i class="fas fa-pencil-alt"></i><%--<img src="<%=request.getContextPath() %>/images/edit-icon.png" style="width:40px; height:40px;"> --%></a></div>
<%
	}
%>							    
							  </div>
						</div>
					</div>
					
					<div class="profile-basic">
						<div class="row">
							<div class="col-md-5">
								<portlet:renderURL var="editEmployeeURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
									<portlet:param name="mvcPath" value="/components/form/form-add.jsp" />
									<portlet:param name="formClass" value="<%=PISFormConstant.EMPLOYEEFORM%>" />
									<portlet:param name="formClassPK" value="<%=String.valueOf(employee.getEmployeeId())%>" />
									<portlet:param name="unitElementName" value="organizationId" />
									<portlet:param name="dialogMode" value="true" />
								</portlet:renderURL>

								<portlet:renderURL var="editBiodataURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
									<portlet:param name="mvcPath" value="/components/form/form-add.jsp" />
									<portlet:param name="formClass" value="<%=PISFormConstant.EMPLOYEEBIODATAFORM%>" />
									<portlet:param name="formClassPK" value="<%=String.valueOf(employee.getEmployeeId())%>" />
									<portlet:param name="dialogMode" value="true" />
								</portlet:renderURL>
	
								<div class="profile-info-left">
									<h3 class="user-name m-t-0 mb-0"><%=people.getName_En()%></h3>
									<h4 class="text-muted"><%=designation != null ? designation.getName_En() : "--"%></h4>
									<h4 class="text">Division/Unit/Section : <%=division %>/<%=organization.getShortName()%>/<%= subOrganization.getShortName()%></h4>
									<div class="text-muted">
										Personal No : <%=employee.getPersonalNo()%>
									</div>
									<div class="text">
										Post Box : <%=employee.getPostName()%>
									</div>
									
									<div class="text-muted">
										Joining Date : <%=ReflectionUtil.formatValue(employee.getDateOfJoining(), Date.class)%>
									</div>
									<div class="text">
										Grade : <%=grade.getName() %>
									</div>
									<div class="text-muted">
										Trade : <%=trade.getName() %>
									</div>
									<div class="staff-msg">
<%
	if(profileEditor){
%>										
										<a class="btn btn-custom" id="<portlet:namespace/>editBiodata">View/Edit Biodata</a>
<%
	}
%>									
									</div>
								</div>
								<div class="pro-edit">
<%
	if(profileEditor){
%>									
									<a class="edit-icon" id="<portlet:namespace/>editEmployee" style="z-index:99999;"><i class="fas fa-pencil-alt"></i></a>
<%
	}
%>
								</div>
							</div>
							<div class="col-md-7">
								<ul class="personal-info">
									<li>
										<div class="title">Phone:</div>
										<div class="text">
											<a href=""><%=(StringUtils.isNotEmpty(empContact.getMobile())?empContact.getMobile():"-")%></a>
										</div>
									</li>
									<li>
										<div class="title">Email:</div>
										<div class="text">
											<a href=""><%=employee.getEmailId()%></a>
										</div>
									</li>
									<li>
										<div class="title">Date of Birth:</div>
										<div class="text"><%=ReflectionUtil.formatValue(people.getDateOfBirth(), Date.class)%></div>
									</li>
									<li>
										<div class="title">Address:</div>
										<div class="text"><%=address.getFullAddress()%></div>
									</li>
									<li>
										<div class="title">Gender:</div>
										<div class="text"><%=gender.getName()%></div>
									</li>
									<li>
										<div class="title">Reports to:</div>
										<div class="text">
											<%--
											<div class="avatar-box">
												<div class="avatar avatar-xs">
													<img src="<%=request.getContextPath()%>/images/black-employee-image.png" alt="" />
												</div>
											</div>
											<a href="profile.html"> 
											<%=reporteeEmployee.getFullName_En()!=null?reporteeEmployee.getFullName_En():""%>
											</a> 
											--%>
											<%=reporteeEmployee.getFullName_En()!=null?reporteeEmployee.getFullName_En():""%>
										</div>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<%--<div class="pro-edit">
						<a data-target="#profile_info" data-toggle="modal" class="edit-icon" href="#"><i class="fas fa-pencil-alt"></i></a>
					</div> --%>
				</div>
			</div>
		</div>
	</div>
</div>
<%-----##################################### --%>

<div class="tab-content">

	<div id="emp_profile" class="pro-overview tab-pane fade show active">
		<div class="row">
			<div class="col-md-8 d-flex">
				<liferay-util:include page="/components/form/info-card.jsp" servletContext="<%=application%>">
					<liferay-util:param name="formClass" value="<%=PISFormConstant.EMPLOYEEPERSONALINFO%>" />
					<liferay-util:param name="formClassPK" value="<%=String.valueOf(people.getPeopleId())%>" />
					<liferay-util:param name="employeeId" value="<%=String.valueOf(employeeId)%>" />
				</liferay-util:include>
			</div>
			<div class="col-md-4 d-flex">
				<liferay-util:include page="/components/form/info-card.jsp" servletContext="<%=application%>">
					<%--<liferay-util:param name="formClass" value="<%=EmployeeContactInfo.class.getName()%>" />
					<liferay-util:param name="formClassPK" value="<%=String.valueOf(empContact.getContactId())%>" /> --%>
					<liferay-util:param name="formClass" value="<%=PISFormConstant.EMPLOYEECONTACTFORM%>" />
					<liferay-util:param name="formClassPK" value="<%=String.valueOf(employeeContact.getEmployeeContactId())%>" />
					<liferay-util:param name="employeeId" value="<%=String.valueOf(employeeId)%>" />
					<liferay-util:param name="childFormElement" value="contact" />
				</liferay-util:include>
			</div>
		</div>

		<div class="row">
			<div class="col-md-6 d-flex">
				<div class="card profile-box flex-fill">
					<div class="card-body">
						<h3 class="card-title">
							Qualification <%--<a href="#" class="edit-icon" data-toggle="modal" data-target="#education_info"><i class="fas fa-pencil-alt"></i></a> --%>
						</h3>
						<div class="experience-box">
							<ul class="experience-list">
								<%
									for (EmployeeQualification eq : qualifications) {
										try{
											Qualification q = QualificationLocalServiceUtil.getQualification(eq.getQualificationId());
								%>
								<li>
									<div class="experience-user">
										<div class="before-circle"></div>
									</div>
									<div class="experience-content">
										<div class="timeline-content">
											<a href="#/" class="name"><%=eq.getInstitution()%></a>
											<div><%=q.getName()%></div>
											<span class="time"><%=eq.getFromYear()%> - <%=eq.getToYear()%></span>
										</div>
									</div>
								</li>
								<%
										}catch(Exception qe){}
									}
								%>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-6 d-flex">
				<div class="card profile-box flex-fill">
					<div class="card-body">
						<h3 class="card-title">
							Experience <%--<a href="#" class="edit-icon" data-toggle="modal" data-target="#experience_info"><i class="fas fa-pencil-alt"></i></a> --%>
						</h3>
						<div class="experience-box">
							<ul class="experience-list">
								<%
									for (EmployeeExperience ee : experiences) {
										try{
										//Experience e = ExperienceLocalServiceUtil.getExperience(ee.getExperienceId());
										Designation expDesig = DesignationLocalServiceUtil.getDesignation(ee.getDesignationId());
										Organization org = OrganizationLocalServiceUtil.getOrganization(ee.getOrganizationId());
								%>
								<li>
									<div class="experience-user">
										<div class="before-circle"></div>
									</div>
									<div class="experience-content">
										<div class="timeline-content">
											<a href="#/" class="name"><%=expDesig.getName_En()%> at <%=org.getName()%></a> <span class="time"><%=ReflectionUtil.formatValue(ee.getFromDate(), Date.class)%> - <%=ReflectionUtil.formatValue(ee.getToDate(), Date.class)%></span>
										</div>
									</div>
								</li>
								<%
										}catch(Exception eee){}
									}
								%>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6 d-flex">
				<div class="card profile-box flex-fill">
					<div class="card-body">
						<h3 class="card-title">
							Post Box/Sections <%--<a href="#" class="edit-icon" data-toggle="modal" data-target="#education_info"><i class="fas fa-pencil-alt"></i></a> --%>
						</h3>
						
						<ul class="personal-info">
							<%
								
								List<String> strOrgs=new ArrayList<String>();
								List<EmployeeOrganization> pos=EmployeeOrganizationLocalServiceUtil.getEmployeeOrganizationsByEmployeeId(employee.getEmployeeId())
																									.stream()
																									.filter(empOrg->empOrg.getStatus()==1)
																									.collect(Collectors.toList());
								for(EmployeeOrganization po:pos){
									try{
										OrganizationDetail org=OrganizationDetailLocalServiceUtil.getOrganizationDetail(po.getOrganizationId());
										OrganizationDetail subOrg=OrganizationDetailLocalServiceUtil.getOrganizationDetail(po.getSubOrganizationId());
										strOrgs.add(org.getShortName()+"/"+subOrg.getShortName());
									}catch(Exception poe){}
								}
							%>
							<li>
								<div class="title">Post Box</div>
								<div class="text"><%=employee.getPostName()%></div>
							</li>
							<li>
								<div class="title">Unit/Section</div>
								<div class="text">
							<%
								int ctrStrOrg=1;
								for(String strOrg:strOrgs){		
							%>
								<p><%=ctrStrOrg++%>. <%=strOrg%></p>
							<%
								}
							%>
								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-md-6 d-flex">
				<div class="card profile-box flex-fill">
					<div class="card-body">
						<h3 class="card-title">
							Workstation <%--<a href="#" class="edit-icon" data-toggle="modal" data-target="#experience_info"><i class="fas fa-pencil-alt"></i></a> --%>
						</h3>
						<ul class="personal-info">
							<li>
								<div class="title">Desk No</div>
								<div class="text"><%=employeeWorkStation.getDeskNo()%></div>
							</li>
							<%-- <li>
								<div class="title">Cabin/Floor</div>
								<div class="text"><%=employeeWorkStation.getCabinNo()%>/<%=employeeWorkStation.getFloorNo()%></div>
							</li> --%>
							<li>
								<div class="title">Direct No</div>
								<div class="text"><%=employeeWorkStation.getDirectNo()%></div>
							</li>
							<li>
								<div class="title">Extn.</div>
								<div class="text"><%=employeeWorkStation.getExtnNo()%></div>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<liferay-util:include page="/employee/profile/employee_other_info.jsp" servletContext="<%=application%>">
</liferay-util:include>
</div>
</div>
<aui:script use="liferay-util-window">
$(document).ready(function(){
	$('#<portlet:namespace/>editProfileImage').click(function(){
		<portlet:namespace/>editProfileImageHandleOnClick(this);
	});
	
	$('#<portlet:namespace/>editEmployee').click(function(){
		<portlet:namespace/>editEmployeeHandleOnClick(this);
	});
	try{
		$('#<portlet:namespace/>editBiodata').click(function(){
			<portlet:namespace/>editBiodataHandleOnClick(this);
		});
	}catch(e){}
	
<%--	$('#<portlet:namespace/>editBiodata').click(function(){
		<portlet:namespace/>editBiodataHandleOnClick(this);
	}); --%>
	
	
});

var dialogId="<portlet:namespace/>editOpenDialog";
var extraParam="<portlet:namespace/>dialogId="+dialogId+"&<portlet:namespace/>closeFunc=<portlet:namespace />EmployeeProfile_closeDialog";

function <portlet:namespace/>editProfileImageHandleOnClick(actionSource){
	
	var url="<%=editProfileImageURL%>&"+extraParam;
	var title ='<%="Edit Profile Image"%>';
	var width = 460;
	var height = 340;
	LiferayUtilOpenWindow(dialogId, title, url, true, height, true, width);
}

function <portlet:namespace/>editEmployeeHandleOnClick(actionSource){
	//var dialogId='<portlet:namespace/>editOpenDialog';
	var url="<%=editEmployeeURL%>&"+extraParam;
	var title ='<%="Edit Employment Information"%>';
	var width = 840;
	var height = 640;
	LiferayUtilOpenWindow(dialogId, title, url, true, height, true, width);
}

function <portlet:namespace/>editBiodataHandleOnClick(actionSource){
	//var dialogId='<portlet:namespace/>editOpenDialog';
	var url="<%=editBiodataURL%>&"+extraParam;
	var title ='<%="Edit Biodata"%>';
	var width = 1024;
	var height = 768;
	LiferayUtilOpenWindow(dialogId, title, url, true, height, true, width);
}

function LiferayUtilOpenWindow(id, title, uri, centered, height, modal, width){
	Liferay.Util.openWindow({
		dialog: {
			centered: centered,
			height: height,
			modal: modal,
			width: width
		},
		id: id,
		title: title,
		uri: uri
	});
}

<%--Liferay.provide(
	window,
	'<portlet:namespace />PeopleForm_123456addeditcloseDialog',
	function(data) {
		//alert("after close : "+data);
		if(data){
			console.log(data);	
		}
		var dialog = Liferay.Util.Window.getById('<portlet:namespace/>editOpenDialog');
		dialog.destroy();
		if(data.refresh){
			window.location.reload();
		}
	},
	['liferay-util-window']
);

Liferay.provide(
	window,
	'<portlet:namespace />EmployeeForm_123456addeditcloseDialog',
	function(data) {
		//alert("after close : "+data);
		if(data){
			console.log(data);	
		}
		var dialog = Liferay.Util.Window.getById('<portlet:namespace/>editOpenDialog');
		dialog.destroy();
		if(data.refresh){
			window.location.reload();
		}
	},
	['liferay-util-window']
);

Liferay.provide(
	window,
	'<portlet:namespace />EmployeeBiodataForm_123456addeditcloseDialog',
	function(data) {
		//alert("after close : "+data);
		if(data){
			console.log(data);	
		}
		var dialog = Liferay.Util.Window.getById('<portlet:namespace/>editOpenDialog');
		dialog.destroy();
		if(data.refresh){
			window.location.reload();
		}
	},
	['liferay-util-window']
);
--%>
<%--Liferay.provide(
	window,
	'<portlet:namespace />EmployeeContactForm_123456addeditcloseDialog',
	function(data) {
		//alert("after close : "+data);
		if(data){
			console.log(data);	
		}
		var dialog = Liferay.Util.Window.getById('<portlet:namespace/>editOpenDialog');
		dialog.destroy();
		window.location.reload();
	},
	['liferay-util-window']
); 
--%>

Liferay.provide(
	window,
	'<portlet:namespace />EmployeeProfile_closeDialog',
	function(data) {
		//alert("after close : "+data);
		if(data){
			console.log(data);	
		}
		var dialog = Liferay.Util.Window.getById(data.dialogId);
		dialog.destroy();
		if(data.refresh){
			window.location.reload();
		}
	},
	['liferay-util-window']
);

</aui:script>