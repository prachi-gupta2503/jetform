<%@page import="com.liferay.portal.kernel.service.OrganizationLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Organization"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeReportingLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.model.EmployeeReporting"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeContactLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.service.ContactLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.service.AddressLocalServiceUtil"%>
<%@page import="com.adjecti.pis.liferay.service.EmployeeAddressLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.service.GenderLocalServiceUtil"%>
<%@page import="com.adjecti.mdm.liferay.model.Gender"%>
<%@page import="com.adjecti.pis.liferay.model.Address"%>
<%@page import="com.adjecti.mdm.liferay.model.WorkStation"%>
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
<%!
private static final Log LOGGER = LogFactoryUtil.getLog("org.apache.jsp.components.employee_profile_jsp");
%>
<%
long employeeId=ParamUtil.getLong(request, "employeeId", 0);

Employee employee=null;
try{
	employee=EmployeeLocalServiceUtil.getEmployee(employeeId);
}catch(Exception e){}

People people=null;
try{
	people=PeopleLocalServiceUtil.getPeople(employee.getPeopleId());
}catch(Exception e){}

Designation designation=null;
try{
	designation=DesignationLocalServiceUtil.getDesignation(employee.getDesignationId());
}catch(Exception e){
	designation=DesignationLocalServiceUtil.createDesignation(0);
}

Organization organization=null;
try{
	organization=OrganizationLocalServiceUtil.getOrganization(employee.getOrganizationId());
}catch(Exception e){
	organization=OrganizationLocalServiceUtil.createOrganization(0);
}

Gender gender =null;
try{
	gender=GenderLocalServiceUtil.getGender(people.getGenderId());
}catch(Exception e){
	gender=GenderLocalServiceUtil.createGender(0);
}

Address address=null;
try{
	address=AddressLocalServiceUtil.getAddress(EmployeeAddressLocalServiceUtil.getEmployeeAddressByEmpId(employee.getEmployeeId()).get(0).getAddressId());
}catch(Exception e){
	address=AddressLocalServiceUtil.createAddress(0);
}

com.adjecti.pis.liferay.model.Contact empContact=null;
try{
	empContact=ContactLocalServiceUtil.getContact(EmployeeContactLocalServiceUtil.getEmployeeContactByEmployeeId(employee.getEmployeeId()).getContactId());
}catch(Exception e){
	empContact=ContactLocalServiceUtil.createContact(0);
}
People reporteePeople=null;
Employee reporteeEmployee=null;
try{
	EmployeeReporting reporting=EmployeeReportingLocalServiceUtil.getByEmployeeId(employee.getEmployeeId()).get(0);
	reporteeEmployee=EmployeeLocalServiceUtil.getEmployee(reporteeEmployee.getEmployeeId());
	reporteePeople=PeopleLocalServiceUtil.getPeople(reporteeEmployee.getPeopleId());
}catch(Exception e){
	if(reporteeEmployee==null){
		reporteeEmployee=EmployeeLocalServiceUtil.createEmployee(0);
	}
	if(reporteePeople==null){
		reporteePeople=PeopleLocalServiceUtil.createPeople(0);
	}
}
//EmployeeQualification qualification= EmployeeQualificationLocalServiceUtil.get
//EmployeeQualification qualification=QualificationLocalServiceUtil.getByEmployeeId(employee.getEmployeeId());
LOGGER.info("employeeId : "+employeeId);
%>
<%--<div class="card form-card m-4">
<div class="card-header bg-primary text-white">
	<div class="row">
		<div class="col-md-4">
			<h5>Employee Profile</h5>
		</div>
		<div class="col-md-8">
			<h5><%=employee.getPersonalNo() %> - <%=people.getName_En().toUpperCase()%></h5>
		</div>
	</div>
</div>
<div class="card-body"> --%>
<%--<div class="container">
	<div class="row">
		<div class="col-md-12" style="background-image: url(&#39;images/bg-color.png&#39;); padding-top: 15px;">
			<h6>PIS / Employee / <%=employee.getPersonalNo() %></h6>
		</div>

	</div> --%>
	<div class="mt-1"></div>
<%--	<div class="row">
		<div class="col-md-4">
			<div class="card-header bg-primary text-center text-white">
				<h4><%=employee.getPersonalNo() %></h4>
			</div>
		</div>
		<div class="col-md-8">
			<div class="card-header bg-primary text-center text-white">
				<h4><%=people.getName_En()%></h4>
			</div>
		</div>
	</div> --%>
<%----####################################################################-----%>
<div class="card mb-0">
    <div class="card-body">
        <div class="row">
            <div class="col-md-12">
                <div class="profile-view">
                    <div class="profile-img-wrap">
                        <div class="profile-img">
                            <a href="#"><img alt="" src="<%=request.getContextPath()%>/images/black-employee-image.png" /></a>
                        </div>
                    </div>
                    <div class="profile-basic">
                        <div class="row">
                            <div class="col-md-5">
                                <div class="profile-info-left">
                                    <h3 class="user-name m-t-0 mb-0"><%=people.getName_En()%></h3>
                                    <h6 class="text-muted"><%=designation!=null?designation.getName_En():"--" %></h6>
                                    <small class="text-muted"><%=organization.getName() %></small>
                                    <div class="staff-id">Personal No : <%=employee.getPersonalNo() %></div>
                                    <div class="small doj text-muted">Joining Date : <%=employee.getCurrentDesignationDate() %></div>
                                    <div class="staff-msg"><a class="btn btn-custom" href="chat.html">Send Message</a></div>
                                </div>
                            </div>
                            <div class="col-md-7">
                                <ul class="personal-info">
                                    <li>
                                        <div class="title">Phone:</div>
                                        <div class="text"><a href=""><%=empContact.getMobile() %></a></div>
                                    </li>
                                    <li>
                                        <div class="title">Email:</div>
                                        <div class="text"><a href=""><%=employee.getEmailId() %></a></div>
                                    </li>
                                    <li>
                                        <div class="title">Birthday:</div>
                                        <div class="text"><%=people.getDateOfBirth() %></div>
                                    </li>
                                    <li>
                                        <div class="title">Address:</div>
                                        <div class="text"><%=address.getFullAddress() %></div>
                                    </li>
                                    <li>
                                        <div class="title">Gender:</div>
                                        <div class="text"><%=gender.getName() %></div>
                                    </li>
                                    <li>
                                        <div class="title">Reports to:</div>
                                        <div class="text">
                                            <div class="avatar-box">
                                                <div class="avatar avatar-xs">
                                                    <img src="<%=request.getContextPath()%>/images/black-employee-image.png" alt="" />
                                                </div>
                                            </div>
                                            <a href="profile.html">
                                                <%=reporteeEmployee.getFullName_En()%>
                                            </a>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="pro-edit">
                        <a data-target="#profile_info" data-toggle="modal" class="edit-icon" href="#"><i class="fa fa-pencil"></i></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%-----##################################### --%>
	<div class="row">
		<div class="col-md-4">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="card info-card mb-2 mt-2"  style="background-color: #8b8bff; ">
							
							<div class="card-body">
								<div style="padding-bottom: 20px;">
									
									<div class="text-center" style="width: 100%; padding-top: 20px;">
										<img src="<%=request.getContextPath()%>/images/profile_photo.png" style="width: 50%;">
									</div>
									<div style="width: 100%; text-align: center;">
										<label style="font-weight: bold;"><%=people.getName_En()%></label>
										<p class="data"><%=employee.getPersonalNo() %></p>
										<p class="data"><%=designation!=null?designation.getName_En():"--" %></p>
										<p class="data"><%=employee.getEmailId() %></p>
									</div>
								</div>
							</div>
						</div>
						<liferay-util:include page="/components/form/info-card.jsp" servletContext="<%=application%>">
							<%-- <liferay-util:param name="formClass" value="<%=EmployeeInfoForm.class.getName()%>" /> --%>
							<liferay-util:param name="formClassPK" value="<%=String.valueOf(employeeId) %>" />
						</liferay-util:include>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-8" style="padding-left: 0px;">
			<div class="container">
				<div class="row">
					<div class="col-md-6">
						<div class="section-content">
							<liferay-util:include page="/components/form/info-card.jsp" servletContext="<%=application%>">
								<%-- <liferay-util:param name="formClass" value="<%=PersonalInfoForm.class.getName()%>" /> --%>
								<liferay-util:param name="formClassPK" value="<%=String.valueOf(employee.getPeopleId()) %>" />
							</liferay-util:include>
						</div>
						
						<div class="section-content">
							<liferay-util:include page="/components/form/info-card.jsp" servletContext="<%=application%>">
								<%-- <liferay-util:param name="formClass" value="<%=EmployeeQualificationForm.class.getName()%>" /> --%>
								<liferay-util:param name="formClassPK" value="<%=String.valueOf(employeeId) %>" />
							</liferay-util:include>

						</div>
					</div>
					<div class="col-md-6">
						<div class="section-content">
							<liferay-util:include page="/components/form/address-info-card.jsp" servletContext="<%=application%>">
								<liferay-util:param name="formClass" value="<%=Address.class.getName()%>" />
								<liferay-util:param name="formClassPK" value="<%=String.valueOf(employeeId) %>" />
							</liferay-util:include>

						</div>
						<div class="section-content">
							<liferay-util:include page="/components/form/info-card.jsp" servletContext="<%=application%>">
								<liferay-util:param name="formClass" value="<%=com.adjecti.pis.liferay.model.Contact.class.getName()%>" />
								<liferay-util:param name="formClassPK" value="<%=String.valueOf(employeeId) %>" />
							</liferay-util:include>

						</div>
						<div class="section-content">
							<liferay-util:include page="/components/form/info-card.jsp" servletContext="<%=application%>">
								<liferay-util:param name="formClass" value="<%=WorkStation.class.getName()%>" />
								<liferay-util:param name="formClassPK" value="<%=String.valueOf(employeeId) %>" />
							</liferay-util:include>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<liferay-util:include page="/employee/employee_other_info.jsp" servletContext="<%=application%>">
		<%--<liferay-util:param name="employeeId" value="<%=String.valueOf(employeeId)%>" /> --%>
	</liferay-util:include>
</div>