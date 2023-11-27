package com.adjecti.pis.ext.listener;

import com.adjecti.mdm.liferay.model.CadreDesignation;
import com.adjecti.mdm.liferay.model.Designation;
import com.adjecti.mdm.liferay.model.DesignationGroup;
import com.adjecti.mdm.liferay.model.Grade;
import com.adjecti.mdm.liferay.model.OrganizationDetail;
import com.adjecti.mdm.liferay.service.CadreDesignationLocalServiceUtil;
import com.adjecti.mdm.liferay.service.CasteCategoryLocalServiceUtil;
import com.adjecti.mdm.liferay.service.DesignationGroupLocalServiceUtil;
import com.adjecti.mdm.liferay.service.DesignationLocalServiceUtil;
import com.adjecti.mdm.liferay.service.GenderLocalServiceUtil;
import com.adjecti.mdm.liferay.service.GradeLocalServiceUtil;
import com.adjecti.mdm.liferay.service.OrganizationDetailLocalServiceUtil;
import com.adjecti.mdm.liferay.service.TradeLocalServiceUtil;
import com.adjecti.pis.configuration.OnBoardingConfig;
import com.adjecti.pis.liferay.exception.NoSuchEmployeePermissionException;
import com.adjecti.pis.liferay.model.Contact;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.model.EmployeeContact;
import com.adjecti.pis.liferay.model.EmployeeEmail;
import com.adjecti.pis.liferay.model.EmployeeJoining;
import com.adjecti.pis.liferay.model.EmployeePermission;
import com.adjecti.pis.liferay.model.People;
import com.adjecti.pis.liferay.model.SingleUserOnboarding;
import com.adjecti.pis.liferay.service.ContactLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeContactLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeEmailLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeJoiningLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeePermissionLocalServiceUtil;
import com.adjecti.pis.liferay.service.PeopleLocalServiceUtil;
import com.adjecti.pis.liferay.service.persistence.SingleUserOnboardingUtil;
import com.adjecti.pis.util.BulkOnboardUtils;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.ModelListener;
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
import com.liferay.portal.kernel.service.UserServiceUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = ModelListener.class)
public class SingleUserOnboardingModelListener extends BaseModelListener<SingleUserOnboarding> {

	@Reference
	OnBoardingConfig boardingConfig;

	final static Log LOGGER = LogFactoryUtil.getLog(SingleUserOnboardingModelListener.class.getName());

	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

//	EmployeePermission employeePermission=null;


	@Override
	public void onAfterCreate(SingleUserOnboarding model) throws ModelListenerException {
		LOGGER.info("SingleUserOnboardingListener:onAfterCreate called");

	}

	@Override
	public void onAfterUpdate(SingleUserOnboarding model) throws ModelListenerException {


		if(model.getStatus()!=2) {
			return;
		}

		EmployeePermission employeePermission=null;
		employeePermission=checkingEmployeePermissionExistOrNot(model);

		User userCreatedOrNot=employeePermission.getUserCreated()?null:createUser(model, boardingConfig,employeePermission);
		Employee employeeCreatedOrNot=employeePermission.getEmployeeCreated()?null:createEmployee(model, boardingConfig,employeePermission);

		String userMsg=userCreatedOrNot==null?"User already exist with given loginId":"User created Successfully";
		String employeeMsg=employeeCreatedOrNot==null?"Employee already exist with given loginId":"Employee created Successfully";

		LOGGER.info(userMsg);
		LOGGER.info(employeeMsg);

		if (model.getIdamUser()) {

			User user = null;

			try {

				user = UserLocalServiceUtil.getUser(ServiceContextThreadLocal.getServiceContext().getUserId());
				createIDAMUser(model, boardingConfig, user,employeePermission);

			} catch (PortalException | IOException e1) {

				e1.printStackTrace();

			} 
		}
		LOGGER.info("SingleUserOnboardingListener:onAfterUpdate called");
	}

	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		LOGGER.info("SingleUserOnboardingListener:onAfterAddAssociation called");
	}

	@Override
	public void onAfterRemove(SingleUserOnboarding model) throws ModelListenerException {
		LOGGER.info("SingleUserOnboardingListener:onAfterRemove called");

	}

	@Override
	public void onAfterRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		LOGGER.info("SingleUserOnboardingListener:onAfterRemoveAssociation called");
	}

	@Override
	public void onBeforeCreate(SingleUserOnboarding model) throws ModelListenerException {
		try {
            model.setFirstName(model.getFirstName().toUpperCase());
            model.setMiddleName(model.getMiddleName().toUpperCase());
            model.setLastName(model.getLastName().toUpperCase());
			String loginId = model.getLoginId();

			if(StringUtils.isBlank(loginId)){
				loginId = generateLoginId(model.getFirstName(),model.getMiddleName(),model.getLastName());

				loginId = loginId.replaceAll("[^a-zA-Z0-9._]", "");  

				loginId = StringUtils.lowerCase(loginId);
				String nextLoginId = getAvailableLoginId(loginId);
				model.setLoginId(nextLoginId);
			}

            model.setPisAccess(true);

			if(model.getGenderId()!=0) {

				model.setGender(GenderLocalServiceUtil.getGender(model.getGenderId()).getName());	

			}

			if(model.getDesignationId()!=0) {

				model.setDesignationCode(DesignationLocalServiceUtil.getDesignation(model.getDesignationId()).getCode());	
				model.setDesignation(DesignationLocalServiceUtil.getDesignation(model.getDesignationId()).getName_En());
			}

			if(model.getGradeId()!=0) {

				model.setGradeCode(GradeLocalServiceUtil.getGrade(model.getGradeId()).getCode());
				model.setGrade(GradeLocalServiceUtil.getGrade(model.getGradeId()).getName());

			}
			if(model.getTradeId()!=0) {

				model.setTradeCode(TradeLocalServiceUtil.getTrade(model.getTradeId()).getCode());
				model.setTrade(TradeLocalServiceUtil.getTrade(model.getTradeId()).getName());

			}

			if(model.getCasteCategoryId()!=0) {

				model.setCasteCategory(CasteCategoryLocalServiceUtil.getCasteCategory(model.getCasteCategoryId()).getName());

			}
			if(model.getUnitId()!=0 && OrganizationDetailLocalServiceUtil.getOrganizationDetail(model.getUnitId())!=null) {

				model.setUnit(OrganizationDetailLocalServiceUtil.getOrganizationDetail(model.getUnitId()).getShortName());

			}
			if(model.getSectionId()!=0 && OrganizationDetailLocalServiceUtil.getOrganizationDetail(model.getSectionId())!=null) {

				model.setSection(OrganizationDetailLocalServiceUtil.getOrganizationDetail(model.getUnitId()).getShortName());
				model.setSectionCode(OrganizationDetailLocalServiceUtil.getOrganizationDetail(model.getUnitId()).getOrganizationCode());

			}
		} catch (PortalException e) {

			e.printStackTrace();
		}	
		LOGGER.info("SingleUserOnboardingListener:onBeforeCreate called");
	}

	@Override
	public void onBeforeRemove(SingleUserOnboarding model) throws ModelListenerException {
		LOGGER.info("SingleUserOnboardingListener:onBeforeRemove called");
	
		if(model.getStatus()==1) {
			throw new ModelListenerException("During pending can't delete by user");
		}
		
	}
	

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		LOGGER.info("SingleUserOnboardingListener:onBeforeRemoveAssociation called");
	}

	@Override
	public void onBeforeUpdate(SingleUserOnboarding model) throws ModelListenerException {
		LOGGER.info("SingleUserOnboardingListener:onBeforeUpdate called");
		 model.setFirstName(model.getFirstName().toUpperCase());
         model.setMiddleName(model.getMiddleName().toUpperCase());
         model.setLastName(model.getLastName().toUpperCase());
		
	}

	public  User createUser(SingleUserOnboarding singleUserOnboarding, OnBoardingConfig boardingConfig,EmployeePermission employeePermission) {
		try {

			long companyId = CompanyThreadLocal.getCompanyId();

			Group group = GroupLocalServiceUtil.getGroup(companyId, boardingConfig.getGroup());

			Role empRole = RoleLocalServiceUtil.getRole(companyId, boardingConfig.getEmployeeRole());

			Role userRole = RoleLocalServiceUtil.getRole(companyId, boardingConfig.getUserRole());

			UserGroup userGroup = UserGroupLocalServiceUtil.getUserGroup(companyId, boardingConfig.getUserGroup());

			Calendar birthDate = Calendar.getInstance();
			birthDate.setTime(singleUserOnboarding.getDateOfBirth());
			ServiceContext serviceContext = new ServiceContext();

			// Personal No is set to ScreenName and user created in unit

			String lastName = StringUtils.isBlank(singleUserOnboarding.getLastName()) ? "."
					: singleUserOnboarding.getLastName();

			String loginId = singleUserOnboarding.getLoginId();
			
//			if(StringUtils.isBlank(loginId)){
				loginId = generateLoginId(singleUserOnboarding.getFirstName(),singleUserOnboarding.getMiddleName(),singleUserOnboarding.getLastName());

				loginId = loginId.replaceAll("[^a-zA-Z0-9._]", "");  

				loginId = StringUtils.lowerCase(loginId);
				String nextLoginId = getAvailableLoginId(loginId);
				singleUserOnboarding.setLoginId(nextLoginId);
				
//			}
			LOGGER.info("singleUserOnboarding"+singleUserOnboarding);
			User user = UserLocalServiceUtil.addUser(PrincipalThreadLocal.getUserId(), companyId, false,
					boardingConfig.getPassword(), boardingConfig.getPassword(), false, singleUserOnboarding.getLoginId(), singleUserOnboarding.getLoginId() + "@ayudh.net",
					Locale.getDefault(), singleUserOnboarding.getFirstName(), singleUserOnboarding.getMiddleName(),
					lastName, 0, 0, true, birthDate.get(Calendar.MONTH), birthDate.get(Calendar.DAY_OF_MONTH),
					birthDate.get(Calendar.YEAR), singleUserOnboarding.getDesignation(),
					new long[] { group.getGroupId() }, new long[] { singleUserOnboarding.getUnitId() },
					new long[] { empRole.getRoleId(), userRole.getRoleId() }, new long[] { userGroup.getUserGroupId() },
					false, serviceContext);
			LOGGER.info("createAppUser : User is created sucessfully for " + singleUserOnboarding.getLoginId() + " / "
					+ singleUserOnboarding.getLoginId() + "@ayudh.net");

			employeePermission.setUserCreated(true);
			EmployeePermissionLocalServiceUtil.updateEmployeePermission(employeePermission);

			return user;
		} catch (Exception e) {
			LOGGER.info("createAppUser : User is already existed with  for " + singleUserOnboarding.getLoginId() + " / "
					+ singleUserOnboarding.getLoginId() + "@ayudh.net");
		}
		return null;
	}

	public  Employee createEmployee(SingleUserOnboarding singleUserOnboarding, OnBoardingConfig boardingConfig,EmployeePermission employeePermission) {

		long companyId = CompanyThreadLocal.getCompanyId();

		Organization orgUnit = null;
		try {

			orgUnit = OrganizationLocalServiceUtil.getOrganization(companyId, OrganizationDetailLocalServiceUtil
					.getOrganizationDetail(singleUserOnboarding.getUnitId()).getShortName());
		} catch (Exception e) {
			LOGGER.error("No organization(unit) exists with name " + singleUserOnboarding.getUnit());
		}

		DesignationGroup desigGroup = null;
		try {

			Designation desig = DesignationLocalServiceUtil.getDesignation(singleUserOnboarding.getDesignationId());
			desigGroup = DesignationGroupLocalServiceUtil.getDesignationGroup(desig.getDesignationGroupId());
		} catch (Exception e) {
			LOGGER.error(e);
			LOGGER.error("No Designation exists with id " + singleUserOnboarding.getDesignationId());
			desigGroup = DesignationGroupLocalServiceUtil.createDesignationGroup(0);
		}

		Organization orgSection = null;
		if (singleUserOnboarding.getSectionId() > 0) {
			try {
				orgSection = OrganizationLocalServiceUtil.getOrganization(singleUserOnboarding.getSectionId());
			} catch (Exception e) {
				LOGGER.error("No organization(section) exists with name " + singleUserOnboarding.getSection());
			}
		}

		String fullName = singleUserOnboarding.getFirstName()
				.concat(StringUtils.isNotEmpty(singleUserOnboarding.getMiddleName())
						? " ".concat(singleUserOnboarding.getMiddleName())
								: "")
				.concat(StringUtils.isNotEmpty(singleUserOnboarding.getLastName())
						? " ".concat(singleUserOnboarding.getLastName())
								: "");

		// Saving the people/personal information
		People people = null;
		if (singleUserOnboarding != null) {
			try {
				long peopleId = CounterLocalServiceUtil.increment(People.class.getName());
				people = PeopleLocalServiceUtil.createPeople(peopleId);
				people.setFirstName_En(singleUserOnboarding.getFirstName());
				people.setMiddleName_En(singleUserOnboarding.getMiddleName());
				people.setLastName_En(singleUserOnboarding.getLastName());
				people.setGenderId(singleUserOnboarding.getGenderId());
				people.setCasteCategoryId(singleUserOnboarding.getCasteCategoryId());
				people.setDateOfBirth(singleUserOnboarding.getDateOfBirth());

				PeopleLocalServiceUtil.updatePeople(people);

				LOGGER.info("createEmployee : people is created successfully with " + people.getFirstName_En() + " "
						+ people.getLastName_En());
			} catch (Exception e) {
				LOGGER.error(e);
			}
		}

		Date retirementDate = null;
		try {
			retirementDate = calculateRetirementDate(singleUserOnboarding.getDateOfBirth());
		} catch (Exception e) {
		}

		// Saving the employee record
		Employee employee = null;
		if (people != null) {
			try {
				long employeeId = CounterLocalServiceUtil.increment(Employee.class.getName());
				employee = EmployeeLocalServiceUtil.createEmployee(employeeId);
				employee.setPersonalNo(String.valueOf(singleUserOnboarding.getPersonalNo()));
				employee.setEmailId(singleUserOnboarding.getLoginId() + "@ayudh.net");
				employee.setPeopleId(people.getPeopleId());
				employee.setDesignationId(singleUserOnboarding.getDesignationId());
				List<CadreDesignation> cadreDesignations = CadreDesignationLocalServiceUtil
						.getCadreDesignationsByDesignationId(singleUserOnboarding.getDesignationId());
				if (CollectionUtils.isNotEmpty(cadreDesignations)) {
					employee.setCadreId(cadreDesignations.get(0).getCadreId());
				}
				employee.setDesignationGroupId(desigGroup.getDesignationGroupId());
				employee.setGradeId(singleUserOnboarding.getGradeId());
				employee.setTradeId(singleUserOnboarding.getTradeId());
				employee.setOrganizationId((orgUnit != null ? orgUnit.getOrganizationId() : 0));
				employee.setSubOrganizationId((orgSection != null ? orgSection.getOrganizationId() : 0));
				employee.setLoginId(singleUserOnboarding.getLoginId());
				employee.setDateOfJoining(singleUserOnboarding.getDateOfJoiningOrganization());
				employee.setRank((int)singleUserOnboarding.getRank());
				employee.setPostName(singleUserOnboarding.getPostBox());
				employee.setGpfNps(singleUserOnboarding.getGpfnpsType());
				employee.setGpfNpsNo(String.valueOf(singleUserOnboarding.getGpfnpsNumber()));
				employee.setStatus(1);
				// Added on 11-Jan-2022
				employee.setRetirementDate(retirementDate);

				EmployeeLocalServiceUtil.updateEmployee(employee);
				LOGGER.info(
						"createEmployee : employee was created with personal no " + singleUserOnboarding.getPersonalNo()
						+ ", email id: " + singleUserOnboarding.getLoginId() + "@ayudh.net");
			} catch (Exception e) {
				LOGGER.info(
						"createEmployee : employee was already existed with personal no " + singleUserOnboarding.getPersonalNo()
						+ ", email id: " + singleUserOnboarding.getLoginId() + "@ayudh.net");
				LOGGER.error(e);
			}
		}

		// Saving the employee joining details
		EmployeeJoining joining = null;
		if (employee != null) {
			try {
				long employeeJoiningId = CounterLocalServiceUtil.increment(EmployeeJoining.class.getName());
				joining = EmployeeJoiningLocalServiceUtil.createEmployeeJoining(employeeJoiningId);
				joining.setEmployeeId(employee.getEmployeeId());
				joining.setDesignationId(employee.getDesignationId());
				joining.setEmailAddress(singleUserOnboarding.getLoginId() + "@ayudh.net");
				joining.setGradeId(singleUserOnboarding.getGradeId());
				joining.setOrganizationId(employee.getOrganizationId());
				joining.setDateOfJoining(singleUserOnboarding.getDateOfJoiningOrganization());

				EmployeeJoiningLocalServiceUtil.updateEmployeeJoining(joining);
				LOGGER.info("createEmployee : EmployeeJoining is created for " + singleUserOnboarding.getLoginId()
				+ "@ayudh.net");
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			}
		}

		// Saving the email address to employee email table

		String secondaryEmail = StringUtils.lowerCase(singleUserOnboarding.getEmailAddress());
		boolean officialSecondaryEmail = (secondaryEmail.contains("nic") || secondaryEmail.contains("ayudh")
				|| secondaryEmail.contains("ofb"));

		if (employee != null && StringUtils.isNotEmpty(secondaryEmail)) {
			try {
				if (officialSecondaryEmail) {
					long employeeEmailId = CounterLocalServiceUtil.increment(EmployeeEmail.class.getName());
					EmployeeEmail employeeEmail = EmployeeEmailLocalServiceUtil.createEmployeeEmail(employeeEmailId);
					employeeEmail.setEmployeeId(employee.getEmployeeId());
					employeeEmail.setEmailAddress(singleUserOnboarding.getEmailAddress());
					EmployeeEmailLocalServiceUtil.updateEmployeeEmail(employeeEmail);
					LOGGER.info("createEmployee : EmployeeEmail is created with :"
							+ singleUserOnboarding.getEmailAddress());
				}
			} catch (Exception e) {
				LOGGER.info(e.getMessage());
			}
		}
		if (employee != null && (StringUtils.isNotEmpty(secondaryEmail) || singleUserOnboarding.getMobile() > 1)) {
			try {
				long contactId = CounterLocalServiceUtil.increment(Contact.class.getName());
				Contact contact = ContactLocalServiceUtil.createContact(contactId);
				if (!officialSecondaryEmail) {
					contact.setAltEmailAddress(secondaryEmail);
				}
				contact.setMobile(String.valueOf(singleUserOnboarding.getMobile()));
				ContactLocalServiceUtil.updateContact(contact);

				long employeeContactId = CounterLocalServiceUtil.increment(EmployeeContact.class.getName());
				EmployeeContact employeeContact = EmployeeContactLocalServiceUtil
						.createEmployeeContact(employeeContactId);
				employeeContact.setEmployeeId(employee.getEmployeeId());
				employeeContact.setContactId(contactId);
				EmployeeContactLocalServiceUtil.updateEmployeeContact(employeeContact);

				LOGGER.info("createEmployee : employeeContact is created with mobile :"
						+ singleUserOnboarding.getMobile() + "/" + singleUserOnboarding.getEmailAddress());
			} catch (Exception e) {
				LOGGER.info(e.getMessage());
			}
			/*
			 * Map<String, Boolean> applications = new HashMap<String, Boolean>();
			 * applications.put("DMS", singleUserOnboarding.getEGovAccess());
			 * applications.put("ZIMBRA", singleUserOnboarding.getEmailAccess());
			 * applications.put("LIFERAY", singleUserOnboarding.getPisAccess());
			 * applications.put("EGOV", singleUserOnboarding.getEGovAccess());
			 * applications.put("DSC", singleUserOnboarding.getDigitalSigning());
			 * 
			 * try { for (Map.Entry<String, Boolean> entry : applications.entrySet()) {
			 * Boolean value = entry.getValue(); if (value == null || !value.booleanValue())
			 * { continue; }
			 * 
			 * OEM oem = null; Application app = null;
			 * 
			 * try { oem = OEMLocalServiceUtil.getOEMByName(entry.getKey()).get(0); } catch
			 * (Exception e) { }
			 * 
			 * if (oem == null) { oem =
			 * OEMLocalServiceUtil.createOEM(CounterLocalServiceUtil.increment(OEM.class.
			 * getName())); oem.setName(entry.getKey()); OEMLocalServiceUtil.updateOEM(oem);
			 * 
			 * app = ApplicationLocalServiceUtil
			 * .createApplication(CounterLocalServiceUtil.increment(Application.class.
			 * getName())); app.setOemId(oem.getOemId()); app.setName(entry.getKey());
			 * ApplicationLocalServiceUtil.updateApplication(app);
			 * 
			 * EmployeeApplication empApp =
			 * EmployeeApplicationLocalServiceUtil.createEmployeeApplication(
			 * CounterLocalServiceUtil.increment(EmployeeApplication.class.getName()));
			 * empApp.setApplicationId(app.getApplicationId());
			 * empApp.setEmployeeId(employee.getEmployeeId());
			 * EmployeeApplicationLocalServiceUtil.updateEmployeeApplication(empApp);
			 * 
			 * continue; }
			 * 
			 * try { app =
			 * ApplicationLocalServiceUtil.getApplicationByName(entry.getKey()).get(0); }
			 * catch (Exception e) { }
			 * 
			 * if (app == null) { app = ApplicationLocalServiceUtil
			 * .createApplication(CounterLocalServiceUtil.increment(Application.class.
			 * getName())); app.setOemId(oem.getOemId()); app.setName(entry.getKey());
			 * ApplicationLocalServiceUtil.updateApplication(app);
			 * 
			 * EmployeeApplication empApp =
			 * EmployeeApplicationLocalServiceUtil.createEmployeeApplication(
			 * CounterLocalServiceUtil.increment(EmployeeApplication.class.getName()));
			 * empApp.setApplicationId(app.getApplicationId());
			 * empApp.setEmployeeId(employee.getEmployeeId());
			 * EmployeeApplicationLocalServiceUtil.updateEmployeeApplication(empApp); } } }
			 * catch (Exception e) { LOGGER.error(e); }
			 */
		}

		if(employee!=null && employeePermission!=null){
			employeePermission.setEmployeeCreated(true);
			EmployeePermissionLocalServiceUtil.updateEmployeePermission(employeePermission);

		}
		return employee;
	}

	private static Date calculateRetirementDate(Date dateOfBirth) {
		Calendar calDateOfBirth = Calendar.getInstance();
		Calendar calDateOfRetirement = Calendar.getInstance();
		calDateOfBirth.setTime(dateOfBirth);
		calDateOfRetirement.setTime(dateOfBirth);
		calDateOfRetirement.add(Calendar.YEAR, 60);

		int DAY_OF_MONTH = calDateOfBirth.get(Calendar.DAY_OF_MONTH);
		if (DAY_OF_MONTH == 1) {
			calDateOfRetirement.add(Calendar.MONTH, -1);
		}
		calDateOfRetirement.set(Calendar.DAY_OF_MONTH, calDateOfRetirement.getActualMaximum(Calendar.DAY_OF_MONTH));
		return calDateOfRetirement.getTime();
	}

	public  boolean createIDAMUser(SingleUserOnboarding singleUserOnboarding,OnBoardingConfig boardingConfig, User approver,EmployeePermission employeePermission) throws IOException { 
		LOGGER.info("Mehtod calling Idam User : create Idam User ");
		String orgDivCode = null; 
		String orgDivName = null; 
		String orgDivLongName = null; 
		Organization orgDiv = null; 
		Organization orgUnit = null;

		try {
			orgUnit=OrganizationLocalServiceUtil.getOrganization(singleUserOnboarding.getUnitId()); 
			orgDiv=OrganizationLocalServiceUtil.getOrganization(orgUnit.getParentOrganizationId()); 
			orgDivName=orgDiv.getName();

			orgDivCode=ExpandoValueLocalServiceUtil.getData(orgDiv.getCompanyId(),Organization.class.getName(), "CUSTOM_FIELDS", "code",orgDiv.getOrganizationId(), "");
			orgDivLongName=ExpandoValueLocalServiceUtil.getData(orgDiv.getCompanyId(),Organization.class.getName(), "CUSTOM_FIELDS", "longName",orgDiv.getOrganizationId(), "");

		}catch(Exception e) {
			LOGGER.error("No organization(unit) exists with name "+singleUserOnboarding.getUnit()); 
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
			OrganizationDetail ouDetail=OrganizationDetailLocalServiceUtil.getOrganizationDetail(singleUserOnboarding.getUnitId()); 
			unitDescription=ouDetail.getLongName();
			unitName=ouDetail.getShortName(); 
			unitCode=ouDetail.getOrganizationCode();
			unitAddress=ouDetail.getAddress1()+", "+ouDetail.getAddress2()+", "+ouDetail. getAddress3()+", "+ouDetail.getCity()+", "+ouDetail.getPin();

		}catch(Exception e) {

			LOGGER.error("No organization(unit) exists with name "+singleUserOnboarding.getUnit()); 

		}

		String sectionDescription= "";
		String sectionCode=""; 
		String sectionName="";

		try { 
			OrganizationDetail ouDetail=OrganizationDetailLocalServiceUtil.getOrganizationDetail(singleUserOnboarding.getSectionId()); 
			sectionName=ouDetail.getShortName();
			sectionDescription=ouDetail.getLongName();
			sectionCode=ouDetail.getOrganizationCode(); 
		}catch(Exception e) {
			LOGGER.error("No organization(section) exists with id "+singleUserOnboarding.getSectionId()); 
		}

		String desigGrpName=""; 
		String desigDesc=""; 
		try { 
			Designation desig=DesignationLocalServiceUtil.getDesignation(singleUserOnboarding.getDesignationId()); 
			desigDesc=desig.getLongName(); 
			DesignationGroup desGrp=DesignationGroupLocalServiceUtil.getDesignationGroup(desig.getDesignationGroupId()); 
			desigGrpName=desGrp.getName();

		}catch(Exception e) {}

		String gradeDesc=""; 
		try {
			Grade grade=GradeLocalServiceUtil.getGrade(singleUserOnboarding.getGradeId());
			gradeDesc=grade.getDescription();

		}catch(Exception e) {}

		String fullName=singleUserOnboarding.getFirstName().concat(StringUtils.isNotEmpty(singleUserOnboarding.getMiddleName())?" ".concat(singleUserOnboarding.getMiddleName()):"").concat(StringUtils.isNotEmpty(singleUserOnboarding. getLastName())?" ".concat(singleUserOnboarding.getLastName()):""); String
		gpfnpsType = singleUserOnboarding.getGpfnpsType().equalsIgnoreCase("GPF") ?"GPF" : "NPS"; 
		long getGpfnpsNumber=(singleUserOnboarding.getGpfnpsNumber()>0 ? singleUserOnboarding.getGpfnpsNumber(): 0);


		String idamUserLocation=PropsUtil.get("idam.user.location");
		if(StringUtils.isEmpty(idamUserLocation) && boardingConfig!=null) {

			idamUserLocation=boardingConfig.getIdamUserLocation();
		}

		String idamUserMailQuota=PropsUtil.get("idam.user.mail.quota");
		if(StringUtils.isEmpty(idamUserMailQuota) && boardingConfig!=null) {

			idamUserMailQuota=String.valueOf(boardingConfig.getMailQuata()); 
		}

		String idamUserAPIEndPoint=PropsUtil.get("idam.user.api.endpoint");
		if(StringUtils.isEmpty(idamUserAPIEndPoint) && boardingConfig!=null)
		{
			idamUserAPIEndPoint=boardingConfig.getIdamUserServiceURL(); 
		}

		JSONObject jsonObject=JSONFactoryUtil.createJSONObject();

		jsonObject.put("fullname", fullName);
		jsonObject.put("firstname",singleUserOnboarding.getFirstName()); 
		jsonObject.put("middlename",singleUserOnboarding.getMiddleName()); 
		jsonObject.put("lastname",StringUtils.isBlank(singleUserOnboarding.getLastName())?".":singleUserOnboarding.getLastName()); 
		jsonObject.put("email",singleUserOnboarding.getLoginId()+"@ayudh.net"); 
		jsonObject.put("location",idamUserLocation); 
		jsonObject.put("mobile",String.valueOf(singleUserOnboarding.getMobile()));
		jsonObject.put("accountno", singleUserOnboarding.getPersonalNo());
		jsonObject.put("divisioncode", orgDivCode); 
		jsonObject.put("division",orgDivName); 
		jsonObject.put("divisiondescription", orgDivLongName);
		jsonObject.put("unit", unitName); 
		jsonObject.put("designation",singleUserOnboarding.getDesignation()); 
		jsonObject.put("grade",singleUserOnboarding.getGrade()); 
		jsonObject.put("trade",singleUserOnboarding.getTrade()); 
		jsonObject.put("dateOfJoiningUnit",DATE_FORMAT.format(singleUserOnboarding.getDateOfJoiningUnit()));
		jsonObject.put("gender", singleUserOnboarding.getGender());
		jsonObject.put("dateOfBirth",DATE_FORMAT.format(singleUserOnboarding.getDateOfBirth()));
		jsonObject.put("castCategory", singleUserOnboarding.getCasteCategory());
		jsonObject.put("gpfNps", gpfnpsType); jsonObject.put("gpfNpsNo",String.valueOf(getGpfnpsNumber)); 
		jsonObject.put("section", sectionName);

		jsonObject.put("mailquota", idamUserMailQuota);
		jsonObject.put("emailpre",singleUserOnboarding.getLoginId());

		jsonObject.put("loginid",singleUserOnboarding.getLoginId());
		jsonObject.put("DMS", (singleUserOnboarding.getEGovAccess()?"Y":"N"));

		jsonObject.put("zimbra", (singleUserOnboarding.getEmailAccess()?"Y":"N"));
		jsonObject.put("liferay", (singleUserOnboarding.getPisAccess()?"Y":"N"));

		//#########New Attribtes ############// 
		jsonObject.put("EGOV",(singleUserOnboarding.getEGovAccess()?"Y":"N")); 
		jsonObject.put("DSC",(singleUserOnboarding.getDigitalSigning()?"Y":"N"));
		jsonObject.put("unitcode",unitCode);
		jsonObject.put("sectioncode",sectionCode);
		jsonObject.put("designationcode",singleUserOnboarding.getDesignationCode());
		jsonObject.put("gradecode",singleUserOnboarding.getGradeCode());
		jsonObject.put("gradedescription",gradeDesc);
		jsonObject.put("tradecode",singleUserOnboarding.getTradeCode());
		jsonObject.put("unitdescription",unitDescription);
		jsonObject.put("sectiondescription",sectionDescription);
		jsonObject.put("unitaddress",unitAddress);
		jsonObject.put("designationgroup",desigGrpName);
		jsonObject.put("designationdescription",desigDesc);

		jsonObject.put("postbox",singleUserOnboarding.getPostBox());
		jsonObject.put("rank",singleUserOnboarding.getRank()); 
		if(approver!=null) {
			jsonObject.put("approveremail",approver.getEmailAddress());

			LOGGER.info(singleUserOnboarding.getLoginId() +" - Approved by - "+approver.getEmailAddress()); 

		} 
		//#########New Attributes end #########//

		String jsonData=jsonObject.toJSONString();


		LOGGER.info(jsonData);
		LOGGER.info("createIDAMUser: calling idamUserAPIEndPoint : " +idamUserAPIEndPoint);

		boolean createIDAMUserBySingleUserOnboarding =  BulkOnboardUtils.createIDAMUserBySingleUserOnboarding(jsonData, idamUserAPIEndPoint); 
		if(createIDAMUserBySingleUserOnboarding) {
			employeePermission.setIdamUserCreated(true);
			EmployeePermissionLocalServiceUtil.updateEmployeePermission(employeePermission);
		}
		return createIDAMUserBySingleUserOnboarding;

	} 
	private String generateLoginId(String firstName, String middleName, String lastName) {
		LOGGER.info("Generate  Login   Id");

		String loginId =null;

		if(firstName == null) {
			firstName ="";
		}
		if(middleName == null) {
			middleName ="";
		}
		if(lastName == null) {
			lastName ="";
		}

		firstName = firstName.replaceAll("[^a-zA-Z0-9_]", "").toLowerCase();  
		middleName = middleName.replaceAll("[^a-zA-Z0-9_]", "").toLowerCase();  
		lastName = lastName.replaceAll("[^a-zA-Z0-9_]", "").toLowerCase(); 

		int firstNameLength = StringUtils.length(firstName);  
		int middleNameLength = StringUtils.length(middleName);  
		int lastNameLength = StringUtils.length(lastName); 

		if(middleNameLength>0) {
			if(lastNameLength>0){
				if(firstNameLength > 2) {
					loginId = firstName+"."+lastName;
				}else { //firstNameLength <=2
					loginId = firstName+middleName+"."+lastName;
				}
			}else {
				if(firstNameLength > 2) {
					loginId = firstName;
				}else { //firstNameLength <=2
					loginId = firstName+middleName;
				}
			}
		}else {
			if(lastNameLength>0){
				loginId = firstName+"."+lastName;
			}else {
				loginId = firstName;
			}
		}
		return loginId;
	}
	private String getAvailableLoginId(String loginId) {

		if(isLoginIdAvailable(loginId)) {
			
			return loginId;
		}
		LOGGER.info("Login Id:   "+loginId);
		String nextId = loginId;
		StringBuilder sbDigits = new StringBuilder();
		for (int i = loginId.length() - 1; i >= 0; i --) {
			char c = loginId.charAt(i);
			if (Character.isDigit(c)) {
				sbDigits.insert(0, c);
			} else {
				break;
			}
		}

		if(sbDigits.length()==0) {
			nextId=nextId+"1";
		}else {
			nextId = loginId.replaceAll(sbDigits.toString()+"$", "");
			StringBuilder newDigits = new StringBuilder();
			int nextNumber = Integer.parseInt(sbDigits.toString())+1;
			newDigits.append(nextNumber);
			while(newDigits.length()<sbDigits.length()) {
				newDigits.insert(0,0);
			}
			nextId = nextId+newDigits.toString();
		}
		return getAvailableLoginId(nextId);
	}


	private boolean isLoginIdAvailable(String loginId) {
		//verify in approved records Liferay Users  and Employee
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		List<SingleUserOnboarding> singleUserOnboardingList= SingleUserOnboardingUtil.findByLoginIdAndStatus(loginId, WorkflowConstants.STATUS_APPROVED);
		Employee employeeByLoginId = EmployeeLocalServiceUtil.getEmployeeByLoginId(loginId);
		
		if(employeeByLoginId!=null || !singleUserOnboardingList.isEmpty()  ) {
			return false;
		}

		try {
			User user = UserServiceUtil.getUserByScreenName(serviceContext.getCompanyId(), loginId);
			if(user!=null)
				return false;
		} catch (PortalException e) {
			LOGGER.debug(e.getMessage());
		}

		return true;
	} 
	private EmployeePermission checkingEmployeePermissionExistOrNot(SingleUserOnboarding model) {
		EmployeePermission employeePermission=null;
		try {
			employeePermission=EmployeePermissionLocalServiceUtil.getEmployeePermissionsBySingleUserOnboardingId(model.getSingleUserRegistrationId());

		} catch (NoSuchEmployeePermissionException e2) {
			LOGGER.info(" NO EmployeePermission found  with this singleUserOnboardingId "+model.getSingleUserRegistrationId());
			employeePermission = createEmployeePermission(model);
		}
		return employeePermission;


	}

	private EmployeePermission createEmployeePermission(SingleUserOnboarding model) {
		EmployeePermission employeePermission=null;
		if(employeePermission==null) {
			try {
				employeePermission = EmployeePermissionLocalServiceUtil.createEmployeePermission(CounterLocalServiceUtil.increment());
				employeePermission.setDigitalSigning(model.getDigitalSigning());
				employeePermission.setEGovAccess(model.getEGovAccess());
				employeePermission.setEmailAccess(model.getEmailAccess());
				employeePermission.setIdamUser(model.getIdamUser());
				employeePermission.setPisAccess(model.getPisAccess());
				employeePermission.setPersonalNo(model.getPersonalNo());
				employeePermission.setFirstName(model.getFirstName());
				employeePermission.setLastName(model.getLastName());
				employeePermission.setForm("SingleUserOnboarding");
				employeePermission.setSingleUserOnboardingId(model.getSingleUserRegistrationId());
				employeePermission.setDesignationId(model.getDesignationId());
				employeePermission.setEmailAddress(model.getEmailAddress());
				employeePermission.setCurrentState("Approved");
				employeePermission = EmployeePermissionLocalServiceUtil.updateEmployeePermission(employeePermission);
				LOGGER.info("EmployeePermission created successfully with singleUserOnboardingId "+model.getSingleUserRegistrationId());
				
			} catch(Exception e) {
				LOGGER.info("EmployeePermission creation failed with singleUserOnboardingId "+model.getSingleUserRegistrationId());
				
			}
		}
		return employeePermission;
	}

}
