package com.adjecti.pis.util;

import com.adjecti.common.util.DateUtils;
import com.adjecti.mdm.liferay.model.Application;
import com.adjecti.mdm.liferay.model.CadreDesignation;
import com.adjecti.mdm.liferay.model.Designation;
import com.adjecti.mdm.liferay.model.DesignationGroup;
import com.adjecti.mdm.liferay.model.Grade;
import com.adjecti.mdm.liferay.model.OEM;
import com.adjecti.mdm.liferay.model.OrganizationDetail;
import com.adjecti.mdm.liferay.model.Trade;
import com.adjecti.mdm.liferay.service.ApplicationLocalServiceUtil;
import com.adjecti.mdm.liferay.service.CadreDesignationLocalServiceUtil;
import com.adjecti.mdm.liferay.service.DesignationGroupLocalServiceUtil;
import com.adjecti.mdm.liferay.service.DesignationLocalServiceUtil;
import com.adjecti.mdm.liferay.service.GradeLocalServiceUtil;
import com.adjecti.mdm.liferay.service.OEMLocalServiceUtil;
import com.adjecti.mdm.liferay.service.OrganizationDetailLocalServiceUtil;
import com.adjecti.mdm.liferay.service.TradeLocalServiceUtil;
import com.adjecti.pis.configuration.OnBoardingConfig;
import com.adjecti.pis.liferay.model.Contact;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.model.EmployeeApplication;
import com.adjecti.pis.liferay.model.EmployeeContact;
import com.adjecti.pis.liferay.model.EmployeeEmail;
import com.adjecti.pis.liferay.model.EmployeeJoining;
import com.adjecti.pis.liferay.model.People;
import com.adjecti.pis.liferay.service.ContactLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeApplicationLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeContactLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeEmailLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeJoiningLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil;
import com.adjecti.pis.liferay.service.PeopleLocalServiceUtil;
import com.adjecti.pis.liferay.util.PISUserUtil;
import com.adjecti.pis.model.RegistrationRequest;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PropsUtil;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class BulkOnboardUtils {
	private static final Log LOGGER = LogFactoryUtil.getLog(BulkOnboardUtils.class.getName());
	
	private static final DateFormat DATE_FORMAT=new SimpleDateFormat("yyyy-MM-dd");
	
	public static void onboardEmployee(RegistrationRequest request,OnBoardingConfig  boardingConfig, User approver) throws IOException {
		
		LOGGER.info("onboardEmployee # boardingConfig.createIdamUser("+boardingConfig.createIdamUser()+"), "+
		"boardingConfig.createEmployee("+boardingConfig.createEmployee()+"),"+
		"boardingConfig.createAppUser("+boardingConfig.createAppUser()+")");
		
		LOGGER.info("onboardEmployee # request.isIdamUser("+request.isIdamUser()+"), "+
				"request.isPisAccess("+request.isPisAccess()+")");
		
		boolean idamUserCreated = false;
		if (boardingConfig.createIdamUser()) {
			try {
				if(request.isIdamUser()) {
					idamUserCreated=createIDAMUser(request,boardingConfig,approver);
					request.setIdamUserCreated(idamUserCreated);
				}
			
			if(idamUserCreated) {
				LOGGER.info("IDAM User created for "+request.getPersonalNo()+" "+request.getFirstName()+" "+request.getLastName());
			}else {
				LOGGER.info("IDAM User NOT created for "+request.getPersonalNo()+" "+request.getFirstName()+" "+request.getLastName());
			}
			}catch(Exception e) {
				LOGGER.info(e);
			}
		}
		
		Employee employee  = null;
		if (boardingConfig.createEmployee()) {
			employee =createEmployee(request,boardingConfig);
		}
		
		if(employee!=null) {
			request.setEmployeeCreated(true);
			LOGGER.info("Employee created "+employee.getEmployeeId()+" -- "+employee.getPersonalNo());
		}else {
			LOGGER.info("Employee NOT created for "+request.getPersonalNo()+" "+request.getFirstName()+" "+request.getLastName());
		}

		if (boardingConfig.createAppUser()) {
			if(employee!=null && request.isPisAccess()) {
				LOGGER.info("Creating app user");
				User user = createAppUser(request, employee,boardingConfig);
				if(user!=null) {
					request.setAppUserCreated(true);
					LOGGER.info("User created "+user.getUuid()+" -- "+user.getScreenName()+" -- "+user.getFirstName()+" "+user.getLastName());
				}else {
					LOGGER.info("User NOT created for "+request.getPersonalNo()+" "+request.getFirstName()+" "+request.getLastName());
				}
			}
		}
	}

	public static boolean createIDAMUser(RegistrationRequest reg,OnBoardingConfig  boardingConfig, User approver) throws IOException {
		String orgDivCode = null;
		String orgDivName = null;
		String orgDivLongName = null;
		Organization orgDiv = null;
		Organization orgUnit = null;
		
		try {
			orgUnit=OrganizationLocalServiceUtil.getOrganization(reg.getUnitId());
			orgDiv=OrganizationLocalServiceUtil.getOrganization(orgUnit.getParentOrganizationId());
			orgDivName=orgDiv.getName();
			
			orgDivCode=ExpandoValueLocalServiceUtil.getData(orgDiv.getCompanyId(),Organization.class.getName(), "CUSTOM_FIELDS", "code", orgDiv.getOrganizationId(), "");
			orgDivLongName=ExpandoValueLocalServiceUtil.getData(orgDiv.getCompanyId(),Organization.class.getName(), "CUSTOM_FIELDS", "longName", orgDiv.getOrganizationId(), "");
		
		}catch(Exception e) {
			LOGGER.error("No organization(unit) exists with name "+reg.getUnit());
		}

		LOGGER.info("orgDivName : "+orgDivName+", orgDivCode : "+orgDivCode+", orgDivLongName : "+orgDivLongName);
		
		if(orgDivCode==null) {
			orgDivCode="";
		}
		
		if(orgDivName==null) {
			orgDivName="";
		}
		
		String unitDescription= "";
		String unitName= "";
		String unitAddress= "";
		String unitCode= "";
		try {
			OrganizationDetail ouDetail=OrganizationDetailLocalServiceUtil.getOrganizationDetail(reg.getUnitId());
			unitDescription=ouDetail.getLongName();
			unitName=ouDetail.getShortName();
			unitCode=ouDetail.getOrganizationCode();
			unitAddress=ouDetail.getAddress1()+", "+ouDetail.getAddress2()+", "+ouDetail.getAddress3()+", "+ouDetail.getCity()+", "+ouDetail.getPin();
		}catch(Exception e) {
			LOGGER.error("No organization(unit) exists with name "+reg.getUnit());
		}
		
		String sectionDescription= "";
		String sectionCode="";
		String sectionName="";
		try {
			OrganizationDetail ouDetail=OrganizationDetailLocalServiceUtil.getOrganizationDetail(reg.getSectionId());
			sectionName=ouDetail.getShortName();
			sectionDescription=ouDetail.getLongName();
			sectionCode=ouDetail.getOrganizationCode();
		}catch(Exception e) {
			LOGGER.error("No organization(section) exists with id "+reg.getSectionId());
		}
		
		String desigGrpName="";
		String desigDesc="";
		try {
			Designation desig=DesignationLocalServiceUtil.getDesignation(reg.getDesignationId());
			desigDesc=desig.getLongName();
			DesignationGroup desGrp=DesignationGroupLocalServiceUtil.getDesignationGroup(desig.getDesignationGroupId());
			desigGrpName=desGrp.getName();
			
		}catch(Exception e) {}
		
		String gradeDesc="";
		try {
			Grade grade=GradeLocalServiceUtil.getGrade(reg.getGradeId());
			gradeDesc=grade.getDescription();
			
		}catch(Exception e) {}
		
		String fullName=reg.getFirstName().concat(StringUtils.isNotEmpty(reg.getMiddleName())?" ".concat(reg.getMiddleName()):"").concat(StringUtils.isNotEmpty(reg.getLastName())?" ".concat(reg.getLastName()):"");
		String gpfnpsType = reg.getGpfnpsType().equalsIgnoreCase("GPF") ? "GPF" : "NPS";
		long getGpfnpsNumber=(reg.getGpfnpsNumber() >0 ? reg.getGpfnpsNumber(): 0);
		
		
		String idamUserLocation=PropsUtil.get("idam.user.location");
		if(StringUtils.isEmpty(idamUserLocation) && boardingConfig!=null) {
			idamUserLocation=boardingConfig.getIdamUserLocation();
		}
		
		String idamUserMailQuota=PropsUtil.get("idam.user.mail.quota");
		if(StringUtils.isEmpty(idamUserMailQuota) && boardingConfig!=null) {
			idamUserMailQuota=String.valueOf(boardingConfig.getMailQuata());
		}
		
		String idamUserAPIEndPoint=PropsUtil.get("idam.user.api.endpoint");
		if(StringUtils.isEmpty(idamUserAPIEndPoint) && boardingConfig!=null) {
			idamUserAPIEndPoint=boardingConfig.getIdamUserServiceURL();
		}
		
		JSONObject jsonObject=JSONFactoryUtil.createJSONObject();
		jsonObject.put("fullname", fullName);
		jsonObject.put("firstname", reg.getFirstName());
		jsonObject.put("middlename", reg.getMiddleName());
		jsonObject.put("lastname", StringUtils.isBlank(reg.getLastName())?".":reg.getLastName());
		jsonObject.put("email", reg.getLoginId()+"@ayudh.net");
		jsonObject.put("location", idamUserLocation);
		jsonObject.put("mobile", String.valueOf(reg.getMobile()));
		jsonObject.put("accountno", reg.getPersonalNo());
		jsonObject.put("divisioncode", orgDivCode);
		jsonObject.put("division", orgDivName);
		jsonObject.put("divisiondescription", orgDivLongName);
		jsonObject.put("unit", unitName);
		jsonObject.put("designation", reg.getDesignation());
		jsonObject.put("grade", reg.getGrade());
		jsonObject.put("trade", reg.getTrade());
		jsonObject.put("dateOfJoiningUnit", DATE_FORMAT.format(reg.getDateOfJoiningUnit()));
		jsonObject.put("gender", reg.getGender());
		jsonObject.put("dateOfBirth", DATE_FORMAT.format(reg.getDateOfBirth()));
		jsonObject.put("castCategory", reg.getCasteCategory());
		jsonObject.put("gpfNps", gpfnpsType);
		jsonObject.put("gpfNpsNo", String.valueOf(getGpfnpsNumber));
		jsonObject.put("section", sectionName);
		
		jsonObject.put("mailquota", idamUserMailQuota);
		jsonObject.put("emailpre",reg.getLoginId());
		
		jsonObject.put("loginid",reg.getLoginId());
		jsonObject.put("DMS", (reg.getEGovAccess()?"Y":"N"));
		jsonObject.put("zimbra", (reg.getEmailAccess()?"Y":"N"));
		jsonObject.put("liferay", (reg.getPisAccess()?"Y":"N"));
		
		//#########New Attribtes ############//
		jsonObject.put("EGOV", (reg.getEGovAccess()?"Y":"N"));
		jsonObject.put("DSC", (reg.getDigitalSigning()?"Y":"N"));
		jsonObject.put("unitcode",unitCode);
		jsonObject.put("sectioncode",sectionCode);
		jsonObject.put("designationcode",reg.getDesignationCode());
		jsonObject.put("gradecode",reg.getGradeCode());
		jsonObject.put("gradedescription",gradeDesc);
		jsonObject.put("tradecode",reg.getTradeCode());
		jsonObject.put("unitdescription",unitDescription);
		jsonObject.put("sectiondescription",sectionDescription);
		jsonObject.put("unitaddress",unitAddress);
		jsonObject.put("designationgroup",desigGrpName);
		jsonObject.put("designationdescription",desigDesc);
		
		jsonObject.put("postbox",reg.getPostBox());
		jsonObject.put("rank",reg.getRank());
		if(approver!=null) {
			jsonObject.put("approveremail",approver.getEmailAddress());

			LOGGER.info(reg.getLoginId() +" - Approved by - "+approver.getEmailAddress());
		}
		//#########New Attributes end #########//
		
		String jsonData=jsonObject.toJSONString();
		
		
		LOGGER.info(jsonData);
		LOGGER.info("createIDAMUser: calling idamUserAPIEndPoint : "+idamUserAPIEndPoint);
		
		try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
			HttpPost httpPost = new HttpPost(idamUserAPIEndPoint);
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-type", "application/json");
			StringEntity stringEntity = new StringEntity(jsonData);
			httpPost.setEntity(stringEntity);
			
			String endPointURL=idamUserAPIEndPoint;
			
			ResponseHandler<Integer> responseHandler = response -> {
				int status = response.getStatusLine().getStatusCode();
				
				LOGGER.info(status+" - received from "+endPointURL);
				if (status >= 200 && status < 300) {
					return status;
				} else {
					throw new ClientProtocolException("Unexpected response status: " + status);
				}
			};
			int responseBody = httpclient.execute(httpPost, responseHandler);
			LOGGER.info(responseBody);
			
			if (responseBody >= 200 && responseBody < 300) {	
				return true;
			}else {
				throw new IOException("User creation failed by the end point system.");
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new IOException(e);
		}
	}
	
	public static User createAppUser(RegistrationRequest reg, Employee employee,OnBoardingConfig  boardingConfig) {
		try {
			
			long companyId=CompanyThreadLocal.getCompanyId();
			
			Group group=GroupLocalServiceUtil.getGroup(companyId,boardingConfig.getGroup() );
			
		
			
			Role empRole= RoleLocalServiceUtil.getRole(companyId, boardingConfig.getEmployeeRole());
			Role userRole= RoleLocalServiceUtil.getRole(companyId, boardingConfig.getUserRole());
			UserGroup userGroup = UserGroupLocalServiceUtil.getUserGroup(companyId, boardingConfig.getUserGroup());
			
			Calendar birthDate= Calendar.getInstance();
			birthDate.setTime(reg.getDateOfBirth());
			ServiceContext serviceContext=new ServiceContext();
			
			User user=null;
			
			try {
			user=UserLocalServiceUtil.getUserByScreenName(companyId, reg.getLoginId());
			LOGGER.info("AppUser : User already exist with  "+reg.getLoginId() +" / "+ reg.getLoginId()+"@ayudh.net"); 
			}catch(Exception e) {
				LOGGER.info(e);
			}
			
			
			if(user==null) {
			//Personal No is set to ScreenName and user created in unit
			String lastName = StringUtils.isBlank(reg.getLastName())?".":reg.getLastName();
			 user= UserLocalServiceUtil.addUser(PrincipalThreadLocal.getUserId(), companyId, false, boardingConfig.getPassword(), boardingConfig.getPassword(), false, 
					reg.getLoginId(), reg.getLoginId()+"@ayudh.net", Locale.getDefault(), reg.getFirstName() , reg.getMiddleName(), lastName, 
					0, 0, true, birthDate.get(Calendar.MONTH), birthDate.get(Calendar.DAY_OF_MONTH), birthDate.get(Calendar.YEAR), 
					reg.getDesignation(), new long[]{group.getGroupId()}, new long[]{reg.getUnitId()}, 
					new long[]{empRole.getRoleId(), userRole.getRoleId()}, new long[]{userGroup.getUserGroupId()}, false, serviceContext);
			LOGGER.info("createAppUser : User is created sucessfully for "+reg.getLoginId() +" / "+ reg.getLoginId()+"@ayudh.net");
			}
			
			
			return user;
		}catch(Exception e) {
			LOGGER.info(e);
		}
		return null;
	}

	public static Employee createEmployee(RegistrationRequest reg,OnBoardingConfig  boardingConfig) {
		
		long companyId=CompanyThreadLocal.getCompanyId();
		
		Organization orgUnit = null;
		try {
			
			orgUnit=OrganizationLocalServiceUtil.getOrganization(companyId, reg.getUnit());
		}catch(Exception e) {
			LOGGER.error("No organization(unit) exists with name "+reg.getUnit());
		}
		
		DesignationGroup desigGroup=null;
		try {
			
			Designation desig=DesignationLocalServiceUtil.getDesignation(reg.getDesignationId());
			desigGroup=DesignationGroupLocalServiceUtil.getDesignationGroup(desig.getDesignationGroupId());
		}catch(Exception e) {
			LOGGER.error(e);
			LOGGER.error("No Designation exists with id "+reg.getDesignationId());
			desigGroup=DesignationGroupLocalServiceUtil.createDesignationGroup(0);
		}
		
		Organization orgSection = null;
		if(reg.getSectionId()>0) {
			try {
				orgSection=OrganizationLocalServiceUtil.getOrganization(reg.getSectionId());
			}catch(Exception e) {
				LOGGER.error("No organization(section) exists with name "+reg.getSection());
			}
		}
		
		String fullName=reg.getFirstName().concat(StringUtils.isNotEmpty(reg.getMiddleName())?" ".concat(reg.getMiddleName()):"").concat(StringUtils.isNotEmpty(reg.getLastName())?" ".concat(reg.getLastName()):"");
		
		//Saving the people/personal information
		People people=null;
		if(reg!=null) {
			try {
				long peopleId = CounterLocalServiceUtil.increment(People.class.getName());
				people=PeopleLocalServiceUtil.createPeople(peopleId);
				people.setFirstName_En(reg.getFirstName());
				people.setMiddleName_En(reg.getMiddleName());
				people.setLastName_En(reg.getLastName());
				people.setGenderId(reg.getGenderId());
				people.setCasteCategoryId(reg.getCasteCategoryId());
				people.setDateOfBirth(reg.getDateOfBirth());
				
				PeopleLocalServiceUtil.updatePeople(people);
				
				LOGGER.info("createEmployee : people is created successfully with "+people.getFirstName_En()+" "+people.getLastName_En());
			}catch(Exception e) {
				LOGGER.error(e);
			}
		}
		
		Date retirementDate=null;
		try {
			retirementDate=calculateRetirementDate(reg.getDateOfBirth());
		}catch(Exception e) {}
		
		//Saving the employee record
		Employee employee=null;
		if(people!=null) {
			try {
				long employeeId= CounterLocalServiceUtil.increment(Employee.class.getName());
				employee=EmployeeLocalServiceUtil.createEmployee(employeeId);
				employee.setPersonalNo(String.valueOf(reg.getPersonalNo()));
				employee.setEmailId(reg.getLoginId()+"@ayudh.net");
				employee.setPeopleId(people.getPeopleId());
				employee.setDesignationId(reg.getDesignationId());
				List<CadreDesignation> cadreDesignations = CadreDesignationLocalServiceUtil.getCadreDesignationsByDesignationId(reg.getDesignationId());
				if(CollectionUtils.isNotEmpty(cadreDesignations)) {
					employee.setCadreId(cadreDesignations.get(0).getCadreId());
				}
				employee.setDesignationGroupId(desigGroup.getDesignationGroupId());
				employee.setGradeId(reg.getGradeId());
				employee.setTradeId(reg.getTradeId());
				employee.setOrganizationId((orgUnit!=null?orgUnit.getOrganizationId():0));
				employee.setSubOrganizationId((orgSection!=null?orgSection.getOrganizationId():0));
				employee.setLoginId(reg.getLoginId());
				employee.setDateOfJoining(reg.getDateOfJoiningOrganization());
				employee.setRank((int)reg.getRank());
				employee.setPostName(reg.getPostBox());
				employee.setGpfNps(reg.getGpfnpsType());
				employee.setGpfNpsNo(String.valueOf(reg.getGpfnpsNumber()));
				employee.setStatus(1);
				//Added on 11-Jan-2022
				employee.setRetirementDate(retirementDate);
				
				EmployeeLocalServiceUtil.updateEmployee(employee);
				
				LOGGER.info("createEmployee : employee was created with personal no "+reg.getPersonalNo()+", email id: "+reg.getLoginId()+"@ayudh.net");
			}catch(Exception e) {
				//LOGGER.error(e.getMessage());
				LOGGER.error(e);
			}
		}
		
		//Saving the employee joining details
		EmployeeJoining joining=null;
		if(employee!=null) {
			try {
				long employeeJoiningId=CounterLocalServiceUtil.increment(EmployeeJoining.class.getName());
				joining=EmployeeJoiningLocalServiceUtil.createEmployeeJoining(employeeJoiningId);
				joining.setEmployeeId(employee.getEmployeeId());
				joining.setDesignationId(employee.getDesignationId());
				joining.setEmailAddress(reg.getLoginId()+"@ayudh.net");
				joining.setGradeId(reg.getGradeId());
				joining.setOrganizationId(employee.getOrganizationId());
				joining.setDateOfJoining(reg.getDateOfJoiningOrganization());
				
				EmployeeJoiningLocalServiceUtil.updateEmployeeJoining(joining);
				LOGGER.info("createEmployee : EmployeeJoining is created for "+reg.getLoginId()+"@ayudh.net");
			}catch(Exception e) {
				LOGGER.error(e.getMessage());
			}
		}
		
		//Saving the email address to employee email table
		
		String secondaryEmail= StringUtils.lowerCase(reg.getEmailAddress());
		boolean officialSecondaryEmail=(secondaryEmail.contains("nic") || secondaryEmail.contains("ayudh") || secondaryEmail.contains("ofb"));
		
		if(employee!=null && StringUtils.isNotEmpty(secondaryEmail)){
			try {
				if(officialSecondaryEmail) {
					long employeeEmailId=CounterLocalServiceUtil.increment(EmployeeEmail.class.getName());
					EmployeeEmail employeeEmail=EmployeeEmailLocalServiceUtil.createEmployeeEmail(employeeEmailId);
					employeeEmail.setEmployeeId(employee.getEmployeeId());
					employeeEmail.setEmailAddress(reg.getEmailAddress());
					EmployeeEmailLocalServiceUtil.updateEmployeeEmail(employeeEmail);
					LOGGER.info("createEmployee : EmployeeEmail is created with :"+reg.getEmailAddress());
				}
			}catch(Exception e) {LOGGER.info(e.getMessage());}
		}
		if(employee!=null && (StringUtils.isNotEmpty(secondaryEmail) || reg.getMobile()>1)){
			try {
				long contactId=CounterLocalServiceUtil.increment(Contact.class.getName());
				Contact contact=ContactLocalServiceUtil.createContact(contactId);
				if(!officialSecondaryEmail) {
					contact.setAltEmailAddress(secondaryEmail);
				}
				contact.setMobile(String.valueOf(reg.getMobile()));
				ContactLocalServiceUtil.updateContact(contact);
				
				long employeeContactId=CounterLocalServiceUtil.increment(EmployeeContact.class.getName());
				EmployeeContact employeeContact=EmployeeContactLocalServiceUtil.createEmployeeContact(employeeContactId);
				employeeContact.setEmployeeId(employee.getEmployeeId());
				employeeContact.setContactId(contactId);
				EmployeeContactLocalServiceUtil.updateEmployeeContact(employeeContact);
				
				LOGGER.info("createEmployee : employeeContact is created with mobile :"+reg.getMobile()+"/"+reg.getEmailAddress());
			}catch(Exception e) {
				LOGGER.info(e.getMessage());
			}
		}
		
		Map<String, Boolean> applications=new HashMap<String, Boolean>();
		applications.put("DMS", reg.getEGovAccess());
		applications.put("ZIMBRA", reg.getEmailAccess());
		applications.put("LIFERAY", reg.getPisAccess());
		applications.put("EGOV", reg.getEGovAccess());
		applications.put("DSC", reg.getDigitalSigning());
		
		try {
			for(Map.Entry<String, Boolean> entry:applications.entrySet()) {
				Boolean value=entry.getValue();
				if(value==null || !value.booleanValue()) {
					continue;
				}
				
				OEM oem=null;
				Application app=null;
				
				try{
					oem=OEMLocalServiceUtil.getOEMByName(entry.getKey()).get(0);
				}catch(Exception e) {
				}
				
				if(oem==null) {
					oem=OEMLocalServiceUtil.createOEM(CounterLocalServiceUtil.increment(OEM.class.getName()));
					oem.setName(entry.getKey());
					OEMLocalServiceUtil.updateOEM(oem);
					
					app=ApplicationLocalServiceUtil.createApplication(CounterLocalServiceUtil.increment(Application.class.getName()));
					app.setOemId(oem.getOemId());
					app.setName(entry.getKey());
					ApplicationLocalServiceUtil.updateApplication(app);
					
					EmployeeApplication empApp=EmployeeApplicationLocalServiceUtil.createEmployeeApplication(CounterLocalServiceUtil.increment(EmployeeApplication.class.getName()));
					empApp.setApplicationId(app.getApplicationId());
					empApp.setEmployeeId(employee.getEmployeeId());
					EmployeeApplicationLocalServiceUtil.updateEmployeeApplication(empApp);
					
					continue;
				}
				
				try {
					app=ApplicationLocalServiceUtil.getApplicationByName(entry.getKey()).get(0);
				}catch(Exception e) {
				}
				
				if(app==null) {
					app=ApplicationLocalServiceUtil.createApplication(CounterLocalServiceUtil.increment(Application.class.getName()));
					app.setOemId(oem.getOemId());
					app.setName(entry.getKey());
					ApplicationLocalServiceUtil.updateApplication(app);
					
					EmployeeApplication empApp=EmployeeApplicationLocalServiceUtil.createEmployeeApplication(CounterLocalServiceUtil.increment(EmployeeApplication.class.getName()));
					empApp.setApplicationId(app.getApplicationId());
					empApp.setEmployeeId(employee.getEmployeeId());
					EmployeeApplicationLocalServiceUtil.updateEmployeeApplication(empApp);
				}
			}
		}catch(Exception e) {
			LOGGER.error(e);
		}
		
		return employee;
	}
	
	private static Date calculateRetirementDate(Date dateOfBirth) {
		Calendar calDateOfBirth=Calendar.getInstance();
		Calendar calDateOfRetirement=Calendar.getInstance();
		calDateOfBirth.setTime(dateOfBirth);
		calDateOfRetirement.setTime(dateOfBirth);
		calDateOfRetirement.add(Calendar.YEAR, 60);
		
		int DAY_OF_MONTH = calDateOfBirth.get(Calendar.DAY_OF_MONTH);
		if(DAY_OF_MONTH==1) {
			calDateOfRetirement.add(Calendar.MONTH, -1);
		}
		calDateOfRetirement.set(Calendar.DAY_OF_MONTH, calDateOfRetirement.getActualMaximum(Calendar.DAY_OF_MONTH));
		return calDateOfRetirement.getTime();
	}

	public static boolean updateIDAMUser(OnBoardingConfig  boardingConfig, String loginId, String attribute, String oldValue, String newValue) {
		JSONObject jsonObject=JSONFactoryUtil.createJSONObject();
		JSONArray arrayOps=JSONFactoryUtil.createJSONArray();
		
		JSONObject jsonRemove=JSONFactoryUtil.createJSONObject();
		JSONArray jsonRemoveArray=JSONFactoryUtil.createJSONArray();
		jsonRemoveArray.put(oldValue);
		jsonRemove.put("remove", jsonRemoveArray);
		
		JSONObject jsonAdd=JSONFactoryUtil.createJSONObject();
		JSONArray jsonAddArray=JSONFactoryUtil.createJSONArray();
		jsonAddArray.put(newValue);
		jsonAdd.put("add", jsonAddArray);
		
		arrayOps.put(jsonRemove);
		arrayOps.put(jsonAdd);
		jsonObject.put(attribute, arrayOps);
		
		String jsonData=jsonObject.toJSONString();
		
		LOGGER.info(jsonData);
		String endPointURL=boardingConfig.getIdamUserServiceURL()+"/"+loginId;
		LOGGER.info("updateIDAMUser: Calling "+boardingConfig.getIdamUserServiceURL()+"/"+loginId);
		try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
			HttpPost httpPost = new HttpPost(endPointURL);
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-type", "application/json");
			StringEntity stringEntity = new StringEntity(jsonData);
			httpPost.setEntity(stringEntity);
			ResponseHandler<String> responseHandler = response -> {
				int status = response.getStatusLine().getStatusCode();
				
				LOGGER.info(status+" - received from "+endPointURL);
				if (status >= 200 && status < 300) {
					HttpEntity entity = response.getEntity();
					return entity != null ? EntityUtils.toString(entity) : null;
				} else {
					throw new ClientProtocolException("Unexpected response status: " + status);
				}
			};
			
			String responseBody = httpclient.execute(httpPost, responseHandler);
			
			LOGGER.info(responseBody);
			if(responseBody.toLowerCase().contains("error") || responseBody.toLowerCase().contains("fail")) {
				return true;
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		
		return false;
	}
	
	public static String recreateIDAMUser(RegistrationRequest record, OnBoardingConfig boardingConfig) {
		String message=null;
		User user = null;
		long userId=0;
		try {
			ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
			userId = serviceContext.getUserId();
			
			user = UserLocalServiceUtil.getUserById(userId);
		}catch(Exception e) {
			message="Error: Approver user not found with id "+userId;
			LOGGER.error(e);
		}
		
		boolean userCreated=false;
		if(record==null) {
			return "Error: User creation failed due to registration not found.";
		}
		
		try {
			userCreated = BulkOnboardUtils.createIDAMUser(record, boardingConfig, user);
			
			record.setIdamUserCreated(userCreated);
			
			LOGGER.info("RegistrationRequest updated ......... "+userCreated);
		}catch(Exception e) {
			
			message="Error: User creation failed "+e.getMessage();
			LOGGER.error(e);
		}
		
		
		Employee employee  = null;
		
		boolean employeeExists=false;
		if (boardingConfig.createEmployee()) {
			try{
				List<Employee> employees=EmployeeLocalServiceUtil.getEmployeesByOrganizationIdAndPersonalNo(record.getUnitId(), String.valueOf(record.getPersonalNo()));
				String regFullName=record.getFirstName().concat(StringUtils.isNotEmpty(record.getMiddleName())?" ".concat(record.getMiddleName()):"").concat(StringUtils.isNotEmpty(record.getLastName())?" ".concat(record.getLastName()):"");
				regFullName=StringUtils.trim(regFullName);
				for(Employee e:employees) {
					if(regFullName.equalsIgnoreCase(StringUtils.trim(e.getFullName_En()))){
						employee=e;
						break;
					}
				}
				if(employee==null) {
					employee = BulkOnboardUtils.createEmployee(record,boardingConfig);
					record.setEmployeeCreated(true);
				}else{
					employee.setLoginId(record.getLoginId());
					employee.setEmailId(record.getLoginId()+"@ayudh.net");
					EmployeeLocalServiceUtil.updateEmployee(employee);
					employeeExists=true;
				}
				
				List<EmployeeJoining> joinings=EmployeeJoiningLocalServiceUtil.getJoiningByEmployeeId(employee.getEmployeeId());
				if(joinings!=null && !joinings.isEmpty()) {
					EmployeeJoining joining=joinings.get(0);
					joining.setEmailAddress(record.getLoginId()+"@ayudh.net");
					EmployeeJoiningLocalServiceUtil.updateEmployeeJoining(joining);
				}
				
			}catch(Exception e) {
				message="Error: Employee creation failed "+record.getPersonalNo()+" "+record.getFirstName()+" "+record.getLastName();
				LOGGER.error(e);
			}
		}
		
		if (boardingConfig.createAppUser()) {
			if(employee!=null && record.isPisAccess()) {
				User appUser = BulkOnboardUtils.createAppUser(record, employee,boardingConfig);
				if(appUser!=null) {
					record.setAppUserCreated(true);
				LOGGER.info("User created "+appUser.getUuid()+" -- "+appUser.getScreenName()+" -- "+appUser.getFirstName()+" "+appUser.getLastName());
				}else {
					message="Error: App User creation failed "+record.getPersonalNo()+" "+record.getFirstName()+" "+record.getLastName();
					LOGGER.error("User NOT created for "+record.getPersonalNo()+" "+record.getFirstName()+" "+record.getLastName());
				}
			}
		}
		if(employeeExists) {
			try {
				updateIDAMEmployeeInfo(record, employee);
			}catch(Exception e) {
				LOGGER.error(e);
			}
		}
		return message;
	}
	
	private static boolean updateIDAMEmployeeInfo(RegistrationRequest record, Employee employee) {
		List<String> attributes=new ArrayList<String>();
		List<String> oldValues=new ArrayList<String>();
		List<String> newValues=new ArrayList<String>();
		
		LOGGER.info("Before personalNo......");
		String personalNo=null;
		
		try {
			String oldPersonalNo=StringUtils.trim(String.valueOf(record.getPersonalNo()));
			LOGGER.info("oldPersonalNo : "+oldPersonalNo);
			personalNo = StringUtils.trim(employee.getPersonalNo());
			LOGGER.info("newPersonalNo : "+personalNo);
			if(!StringUtils.isBlank(oldPersonalNo) || !StringUtils.isBlank(personalNo)) {
				if(StringUtils.equals(oldPersonalNo, personalNo)) {
					attributes.add("accountno");
					oldValues.add(oldPersonalNo);
					newValues.add(personalNo);
				}
			}
		}catch(Exception e) {
			LOGGER.error(e.getMessage());
		}
		
		LOGGER.info("Before emailId......");
		
		try {
			String oldEmailId=StringUtils.trim(record.getEmailAddress());
			LOGGER.info("oldEmailId : "+oldEmailId);
			String newEmailId = StringUtils.trim(employee.getEmailId());
			LOGGER.info("newemailId : "+newEmailId);
			if(!StringUtils.isBlank(oldEmailId) || !StringUtils.isBlank(newEmailId)) {
				if(!StringUtils.equals(oldEmailId,newEmailId)) {
					attributes.add("email");
					oldValues.add(oldEmailId);
					newValues.add(newEmailId);
				}
			}
		}catch(Exception e) {
			LOGGER.error(e);
		}
		
		LOGGER.info("Before organization......");
		
		try {
			long oldId=record.getUnitId();
			LOGGER.info("oldOrganizationId : "+oldId);
			long newId = employee.getOrganizationId();
			LOGGER.info("newOrganizationId : "+newId);
			
			if(oldId!=newId) {
				
				String oldName=null;
				String oldCode=null;
				String oldLongName=null;
				String oldUnitAddress=null;
				
				String newName=null;
				String newCode=null;
				String newLongName=null;
				String newUnitAddress=null;
				
				if(oldId!=0) {
					Organization oldObject = OrganizationLocalServiceUtil.getOrganization(record.getUnitId());
	
					oldName=oldObject.getName();
					oldCode=ExpandoValueLocalServiceUtil.getData(oldObject.getCompanyId(), Organization.class.getName(), "CUSTOM_FIELDS", "code", oldObject.getOrganizationId(), (String)null);
					oldLongName=ExpandoValueLocalServiceUtil.getData(oldObject.getCompanyId(), Organization.class.getName(), "CUSTOM_FIELDS", "longName", oldObject.getOrganizationId(), (String)null);
			
					Address oldAddress= oldObject.getAddress();
					if(oldAddress!=null) {
						oldUnitAddress=oldAddress.getStreet1()+", "+oldAddress.getStreet2()+", "+oldAddress.getStreet3()+", "+oldAddress.getCity()+", "+oldAddress.getZip();
						oldValues.add(oldUnitAddress);
					}
				}
				
				if(newId!=0) {
					Organization newObject = OrganizationLocalServiceUtil.getOrganization(employee.getOrganizationId());
	
					newName=newObject.getName();
					newCode=ExpandoValueLocalServiceUtil.getData(newObject.getCompanyId(), Organization.class.getName(), "CUSTOM_FIELDS", "code", newObject.getOrganizationId(), (String)null);
					newLongName=ExpandoValueLocalServiceUtil.getData(newObject.getCompanyId(), Organization.class.getName(), "CUSTOM_FIELDS", "longName", newObject.getOrganizationId(), (String)null);
					
				
					Address newAddress= newObject.getAddress();
					if(newAddress!=null) {
						newUnitAddress=newAddress.getStreet1()+", "+newAddress.getStreet2()+", "+newAddress.getStreet3()+", "+newAddress.getCity()+", "+newAddress.getZip();
						newValues.add(newUnitAddress);
					}
				}
				
				attributes.add("unit");
				attributes.add("unitcode");
				attributes.add("unitdescription");
				attributes.add("unitaddress");
				
				oldValues.add(oldName);
				oldValues.add(oldCode);
				oldValues.add(oldLongName);
				oldValues.add(oldUnitAddress);
				
				newValues.add(newName);
				newValues.add(newCode);
				newValues.add(newLongName);
				newValues.add(newUnitAddress);
			}
			
		}catch(Exception e) {
			LOGGER.error(e);
		}
		
		LOGGER.info("Before subOrganization......");
		
		try {
			long oldId=record.getSectionId();
			LOGGER.info("oldSubOrganizationId : "+oldId);
			long newId = employee.getSubOrganizationId();
			LOGGER.info("newSubOrganizationId : "+newId);
			
			if(oldId!=newId) {
				String oldName=null;
				String oldCode=null;
				String oldLongName=null;
				String newName=null;
				String newCode=null;
				String newLongName=null;
				
				if(oldId!=0) {
					Organization oldObject = OrganizationLocalServiceUtil.getOrganization(record.getSectionId());

					oldName=oldObject.getName();
					oldCode=ExpandoValueLocalServiceUtil.getData(oldObject.getCompanyId(), Organization.class.getName(), "CUSTOM_FIELDS", "code", oldObject.getOrganizationId(), (String)null);
					oldLongName=ExpandoValueLocalServiceUtil.getData(oldObject.getCompanyId(), Organization.class.getName(), "CUSTOM_FIELDS", "longName", oldObject.getOrganizationId(), (String)null);
				}
				
				if(newId!=0) {
					Organization newObject = OrganizationLocalServiceUtil.getOrganization(employee.getSubOrganizationId());
	
					newName=newObject.getName();
					newCode=ExpandoValueLocalServiceUtil.getData(newObject.getCompanyId(), Organization.class.getName(), "CUSTOM_FIELDS", "code", newObject.getOrganizationId(), (String)null);
					newLongName=ExpandoValueLocalServiceUtil.getData(newObject.getCompanyId(), Organization.class.getName(), "CUSTOM_FIELDS", "longName", newObject.getOrganizationId(), (String)null);
				}
				
				attributes.add("section");
				attributes.add("sectioncode");
				attributes.add("sectiondescription");
				
				oldValues.add(oldName);
				oldValues.add(oldCode);
				oldValues.add(oldLongName);
				
				newValues.add(newName);
				newValues.add(newCode);
				newValues.add(newLongName);
			}
		}catch(Exception e) {
			LOGGER.error(e);
		}
		
		LOGGER.info("Before designation......");
		
		try {
			long oldDesignationId=record.getDesignationId();
			LOGGER.info("oldDesignationId : "+oldDesignationId);
			long designationId = employee.getDesignationId();
			
			LOGGER.info("newDesignationId : "+designationId);
			if(oldDesignationId != designationId) {
				
				String oldName=null;
				String oldCode=null;
				String oldLongName=null;
				String newName=null;
				String newCode=null;
				String newLongName=null;
				
				long oldDesignationGroupId=0;
				if(oldDesignationId!=0) {
					Designation oldDesignation=DesignationLocalServiceUtil.getDesignation(oldDesignationId);
					oldName=oldDesignation.getName_En();
					oldCode=oldDesignation.getCode();
					oldLongName=oldDesignation.getLongName();
					oldDesignationGroupId=oldDesignation.getDesignationGroupId();
				}
				long newDesignationGroupId=0;
				if(designationId!=0) {
					Designation newDesignation=DesignationLocalServiceUtil.getDesignation(designationId);
					newName=newDesignation.getName_En();
					newCode=newDesignation.getCode();
					newLongName=newDesignation.getLongName();
					newDesignationGroupId=newDesignation.getDesignationGroupId();
				}
				if(oldDesignationGroupId!=newDesignationGroupId) {
					String oldDesGrpName=null;
					String newDesGrpName=null;
					if(oldDesignationGroupId!=0) {
						DesignationGroup oldDesGrp=DesignationGroupLocalServiceUtil.getDesignationGroup(oldDesignationGroupId);
						oldDesGrpName=oldDesGrp.getName();
					}
					if(newDesignationGroupId!=0) {
						DesignationGroup newDesGrp=DesignationGroupLocalServiceUtil.getDesignationGroup(newDesignationGroupId);
						newDesGrpName=newDesGrp.getName();
					}
					attributes.add("designationgroup");
					oldValues.add(oldDesGrpName);
					newValues.add(newDesGrpName);
				}
				
				attributes.add("designation");
				attributes.add("designationcode");
				attributes.add("designationdescription");
				
				oldValues.add(oldName);
				oldValues.add(oldCode);
				oldValues.add(oldLongName);
				
				newValues.add(newName);
				newValues.add(newCode);
				newValues.add(newLongName);
				
			}
		}catch(Exception e) {
			LOGGER.error(e);
		}
				
		LOGGER.info("Before grade......");
		long gradeId=0;
		try {
			long oldGradeId=record.getGradeId();
			LOGGER.info("oldGradeId......"+oldGradeId);
			gradeId = employee.getGradeId();
			LOGGER.info("newGradeId......"+gradeId);
			if(oldGradeId!=gradeId) {
				Grade oldGrade=GradeLocalServiceUtil.getGrade(oldGradeId);
				Grade newGrade=GradeLocalServiceUtil.getGrade(gradeId);
				attributes.add("grade");
				oldValues.add(oldGrade.getName());
				newValues.add(newGrade.getName());
				
				attributes.add("gradecode");
				oldValues.add(oldGrade.getCode());
				newValues.add(newGrade.getCode());
				
				attributes.add("gradedescription");
				oldValues.add(oldGrade.getDescription());
				newValues.add(newGrade.getDescription());
			}
		}catch(Exception e) {
			LOGGER.error(e);
		}
		
		LOGGER.info("Before trade......");
		try {
			long oldTradeId=record.getTradeId();
			LOGGER.info("oldTradeId......"+oldTradeId);
			long newTradeId = employee.getTradeId();
			LOGGER.info("newTradeId......"+newTradeId);
			
			if(oldTradeId!=0 && newTradeId!=0 && oldTradeId!=newTradeId) {
				Trade oldTrade=TradeLocalServiceUtil.getTrade(oldTradeId);
				Trade newTrade=TradeLocalServiceUtil.getTrade(newTradeId);
				attributes.add("trade");
				oldValues.add(oldTrade.getName());
				newValues.add(newTrade.getName());
				
				attributes.add("tradecode");
				oldValues.add(oldTrade.getCode());
				newValues.add(newTrade.getCode());
				
				attributes.add("tradedescription");
				oldValues.add(oldTrade.getDescription());
				newValues.add(newTrade.getDescription());
				
			}
		}catch(Exception e) {
			LOGGER.error(e);
		}
		
		LOGGER.info("Before postName......");
		try {
			String oldPostName=StringUtils.trim(record.getPostBox());
			LOGGER.info("oldPostName......"+oldPostName);
			String newPostName = StringUtils.trim(employee.getPostName());
			LOGGER.info("newPostName......"+newPostName);
			if(!StringUtils.equals(oldPostName, newPostName)) {
				attributes.add("postbox");
				oldValues.add(oldPostName);
				newValues.add(newPostName);
			}
		}catch(Exception e) {
			LOGGER.error(e);
		}
		
		LOGGER.info("Before dateOfJoiningUnit......");
		try {
			String oldDoj=DateUtils.format(record.getDateOfJoiningUnit(), DateUtils.YYYY_MM_DD) ;
			LOGGER.info("oldDoj......"+oldDoj);
			String newDoj = DateUtils.format(employee.getDateOfJoining(), DateUtils.YYYY_MM_DD);
			LOGGER.info("newDoj......"+newDoj);
			if(!StringUtils.equals(oldDoj, newDoj)) {
				attributes.add("dateOfJoiningUnit");
				oldValues.add(oldDoj);
				newValues.add(newDoj);
			}
		}catch(Exception e) {
			LOGGER.error(e);
		}
		
		
		LOGGER.info("attributes.size()......"+attributes.size());
		if(attributes.isEmpty()) {
			return true;
		}
		return PISUserUtil.updateIDAMUser(record.getLoginId(), attributes, oldValues, newValues);

	}

	public static void main(String[] s) {
		Calendar calendar=Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 30);
		calendar.set(Calendar.YEAR, 2011);
		LOGGER.info(calculateRetirementDate(calendar.getTime()));
		
	}
	public static boolean createIDAMUserBySingleUserOnboarding( String jsonData,String idamUserAPIEndPoint) throws IOException {
		try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
			HttpPost httpPost = new HttpPost(idamUserAPIEndPoint);
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-type", "application/json");
			StringEntity stringEntity = new StringEntity(jsonData);
			httpPost.setEntity(stringEntity);
			
			String endPointURL=idamUserAPIEndPoint;
			
			ResponseHandler<Integer> responseHandler = response -> {
				int status = response.getStatusLine().getStatusCode();
				
				LOGGER.info(status+" - received from "+endPointURL);
				if (status >= 200 && status < 300) {
					return status;
				} else {
					throw new ClientProtocolException("Unexpected response status: " + status);
				}
			};
			int responseBody = httpclient.execute(httpPost, responseHandler);
			LOGGER.info(responseBody);
			
			if (responseBody >= 200 && responseBody < 300) {	
				return true;
			}else {
				throw new IOException("User creation failed by the end point system.");
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new IOException(e);
		}
	}
}
