package com.adjecti.pis.ext.listener;

import com.adjecti.mdm.liferay.model.CadreDesignation;
import com.adjecti.mdm.liferay.model.CasteCategory;
import com.adjecti.mdm.liferay.model.Designation;
import com.adjecti.mdm.liferay.model.DesignationGroup;
import com.adjecti.mdm.liferay.model.Gender;
import com.adjecti.mdm.liferay.model.Grade;
import com.adjecti.mdm.liferay.model.OrganizationDetail;
import com.adjecti.mdm.liferay.model.Trade;
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
import com.adjecti.pis.liferay.model.Address;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.model.EmployeeAddress;
import com.adjecti.pis.liferay.model.EmployeeEmail;
import com.adjecti.pis.liferay.model.EmployeeJoining;
import com.adjecti.pis.liferay.model.EmployeePastExperience;
import com.adjecti.pis.liferay.model.EmployeePermission;
import com.adjecti.pis.liferay.model.EmployeeQualification;
import com.adjecti.pis.liferay.model.EmployeeVerification;
import com.adjecti.pis.liferay.model.JoiningProcess;
import com.adjecti.pis.liferay.model.People;
import com.adjecti.pis.liferay.model.SingleUserOnboarding;
import com.adjecti.pis.liferay.model.JoiningProcess;
import com.adjecti.pis.liferay.service.AddressLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeAddressLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeEmailLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeJoiningLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeePastExperienceLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeePermissionLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeQualificationLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeVerificationLocalServiceUtil;
import com.adjecti.pis.liferay.service.JoiningProcessLocalServiceUtil;
import com.adjecti.pis.liferay.service.PeopleLocalServiceUtil;
import com.adjecti.pis.liferay.service.persistence.EmployeeVerificationPersistence;
import com.adjecti.pis.liferay.service.persistence.SingleUserOnboardingUtil;
import com.adjecti.pis.model.RegistrationRequest;
import com.adjecti.pis.service.persistence.RegistrationRequestUtil;
import com.adjecti.pis.util.BulkOnboardUtils;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.repository.cmis.Session;
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
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = ModelListener.class)
public class JoiningProcessModelListener extends BaseModelListener<JoiningProcess> {

	static final Log LOGGER = LogFactoryUtil.getLog(JoiningProcessModelListener.class.getName());

	@Reference
	OnBoardingConfig boardingConfig;

	String loginId = "";
	private final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

	EmployeePermission employeePermission=null;
	@Override
	public void onAfterCreate(JoiningProcess model) throws ModelListenerException {
		LOGGER.info("*********** JoiningProcessEntityListener:onAfterCreate");
		

	}

	@Override
	public void onAfterUpdate(JoiningProcess model) throws ModelListenerException {
		LOGGER.info("*********** JoiningProcessEntityListener:onAfterUpdate ");
		

		if (model.getProcessStatus() != 2) {
			return;
		}
		
		try {
			employeePermission=EmployeePermissionLocalServiceUtil.getEmployeePermissionsByJoiningProcessId(model.getJoiningProcessId()).get(0);
			employeePermission.setCurrentState("Approved");
		} catch (Exception e) {
			
			 LOGGER.info("No Employee Permission found by JoiningProcessId "+model.getJoiningProcessId());
		}
		
		
		People people = null;
		EmployeeJoining employeeJoining = null;
		try {
			employeeJoining = EmployeeJoiningLocalServiceUtil.findByjoiningProcessId(model.getJoiningProcessId());

		} catch (Exception e) {
			LOGGER.error(" No EmployeeJoining exists with joiningProcessId " + model.getJoiningProcessId());
		}

		try {
			people = PeopleLocalServiceUtil.getPeoplesByJoiningProcessId(model.getJoiningProcessId()).get(0);
		} catch (Exception e) {
			LOGGER.error(" No people exists with joiningProcessId " + model.getJoiningProcessId());
		}

		User userApprover = null;
		try {
			userApprover = UserLocalServiceUtil.getUser(ServiceContextThreadLocal.getServiceContext().getUserId());
		} catch (PortalException e1) {
			LOGGER.error(" exception in getting current user  ");

		}
		Employee employee = null;

		if (employeeJoining != null && people != null && employeePermission !=null) {
			
			 String employeeMsg =employeePermission.getEmployeeCreated()?"Employee already exist with given loginId":"Employee created Successfully";
			 
			  employee=employeePermission.getEmployeeCreated()?null:createEmployee(employeeJoining, people, model.getPersonalNo());
			  LOGGER.info(employeeMsg);

			 

		}
		if (employee != null) {
			EmployeeAddress employeeAddress = null;
			try {
				List<Address> addressList = AddressLocalServiceUtil
						.getAddressesByJoiningProcessId(model.getJoiningProcessId());
				for (Address address : addressList) {
					long employeeAddressId = CounterLocalServiceUtil.increment(EmployeeAddress.class.getName());
					employeeAddress = EmployeeAddressLocalServiceUtil.createEmployeeAddress(employeeAddressId);
					employeeAddress.setAccomodationTypeId(address.getAddressTypeId());
					employeeAddress.setAddressId(address.getAddressId());
					employeeAddress.setEmployeeId(employee.getEmployeeId());
					employeeAddress.setCompanyId(address.getCompanyId());
					employeeAddress.setCreateDate(address.getCreateDate());
					employeeAddress.setModifiedDate(address.getModifiedDate());
					employeeAddress.setAddressLine1(address.getAddressLine1());
					employeeAddress.setAddressLine2(address.getAddressLine2());
					employeeAddress.setAddressLine3(address.getAddressLine3());
					employeeAddress.setCity(address.getCity());
					employeeAddress.setCountryId(address.getCountryId());
					employeeAddress.setDistrictId(address.getDistrictId());
					employeeAddress.setStateId(address.getStateId());
					
					EmployeeAddressLocalServiceUtil.updateEmployeeAddress(employeeAddress);
				}
			} catch (Exception e) {
				LOGGER.error(" No address exists with joiningProcessId " + model.getJoiningProcessId());
			}

			try {
				EmployeeVerification employeeVerification = EmployeeVerificationLocalServiceUtil
						.getEmployeeVerificationsByJoiningProcessId(model.getJoiningProcessId()).get(0);
				employeeVerification.setEmployeeId(employee.getEmployeeId());
				EmployeeVerificationLocalServiceUtil.updateEmployeeVerification(employeeVerification);
			} catch (Exception e) {
				LOGGER.error(" No employeeVerification exists with joiningProcessId " + model.getJoiningProcessId());
			}

			try {
				EmployeeQualification employeeQualification = EmployeeQualificationLocalServiceUtil
						.getEmployeeQualificationsByJoiningProcessId(model.getJoiningProcessId()).get(0);
				employeeQualification.setEmployeeId(employee.getEmployeeId());
				EmployeeQualificationLocalServiceUtil.updateEmployeeQualification(employeeQualification);
			} catch (Exception e) {
				LOGGER.error(" No employeeQualification exists with joiningProcessId " + model.getJoiningProcessId());
			}

			try {
				EmployeePastExperience employeePastExperience = EmployeePastExperienceLocalServiceUtil
						.getEmployeePastExperiencesByJoiningProcessId(model.getJoiningProcessId()).get(0);
				employeePastExperience.setEmployeeId(employee.getEmployeeId());
				EmployeePastExperienceLocalServiceUtil.updateEmployeePastExperience(employeePastExperience);
			} catch (Exception e) {
				LOGGER.error("No employeePastExperience exists with joiningProcessId " + model.getJoiningProcessId());
			}

			try {
				
				    employeePermission.setEmployeeId(employee.getEmployeeId());
					employeePermission.setPersonalNo(model.getPersonalNo());
					employeePermission.setFirstName(people.getFirstName_En());
					employeePermission.setLastName(people.getLastName_En());
					employeePermission.setForm("New Joining");
					employeePermission.setDesignationId(employeeJoining.getDesignationId());
					employeePermission.setEmailAddress(employee.getEmailId());
					employeePermission.setEmployeeCreated(true);
					EmployeePermissionLocalServiceUtil.updateEmployeePermission(employeePermission);
			} catch (Exception e) {
				LOGGER.error("No employeePermission exists with  joiningProcessId " + model.getJoiningProcessId());
			}

			if (employeeJoining != null && people != null && employeePermission != null) {
				 String userMsg=employeePermission.getUserCreated()?"User already exist with given loginId":"User Created Successfully";
				User user=employeePermission.getUserCreated()?null:createUser(employeeJoining, people, boardingConfig);

				  LOGGER.info(userMsg);

				if (employeePermission.getIdamUser()) {

					try {
						createIDAMUser(employeeJoining, people, userApprover, model.getPersonalNo(), employeePermission,
								boardingConfig);
						 
					} catch (IOException e) {
						LOGGER.error("Idam user creation failed");

					}
				}
			}
			try {
				employeeJoining = EmployeeJoiningLocalServiceUtil.findByjoiningProcessId(model.getJoiningProcessId());
				employeeJoining.setEmployeeId(employee.getEmployeeId());
				EmployeeJoiningLocalServiceUtil.updateEmployeeJoining(employeeJoining);
			} catch (Exception e) {
				LOGGER.error("No EmployeeJoining exists with  joiningProcessId " + model.getJoiningProcessId());
			}
		}else  if(employeePermission.getUserCreated() && employeePermission.getEmployeeCreated()){
			
				try {
					createIDAMUser(employeeJoining, people, userApprover, model.getPersonalNo(), employeePermission,
							boardingConfig);
					 
				} catch (IOException e) {
					LOGGER.error("Idam user creation failed");

				}
			
		}

	}

	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		LOGGER.info("*********** JoiningProcessEntityListener:onAfterAddAssociation");
	}

	@Override
	public void onAfterRemove(JoiningProcess model) throws ModelListenerException {
		LOGGER.info("*********** JoiningProcessEntityListener:onAfterRemove");
	}

	@Override
	public void onAfterRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		LOGGER.info("*********** JoiningProcessEntityListener:onAfterRemoveAssociation");
	}

	@Override
	public void onBeforeCreate(JoiningProcess model) throws ModelListenerException {
		LOGGER.info("***********1. JoiningProcessEntityListener:onBeforeCreate");

	}

	@Override
	public void onBeforeRemove(JoiningProcess model) throws ModelListenerException {
		LOGGER.info("*********** JoiningProcessEntityListener:onAfterRemoveAssociation");
	}

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		LOGGER.info("*********** JoiningProcessEntityListener:onBeforeRemoveAssociation");
	}

	@Override
	public void onBeforeUpdate(JoiningProcess model) throws ModelListenerException {
		LOGGER.info("JoiningProcessEntityListener:onBeforeUpdate");
	}

	public Employee createEmployee(EmployeeJoining employeeJoining, People people, long personalNumber) {

		loginId = generateLoginId(people.getFirstName_En(), people.getMiddleName_En(), people.getLastName_En());

		loginId = loginId.replaceAll("[^a-zA-Z0-9._]", "");

		loginId = StringUtils.lowerCase(loginId);
		String nextLoginId = getAvailableLoginId(loginId);
		loginId = nextLoginId;

		long companyId = CompanyThreadLocal.getCompanyId();

		Organization orgUnit = null;
		try {

			orgUnit = OrganizationLocalServiceUtil.getOrganization(companyId, OrganizationDetailLocalServiceUtil
					.getOrganizationDetail(employeeJoining.getOrganizationId()).getShortName());
		} catch (Exception e) {
			LOGGER.error("No organization(unit) exists with name " + employeeJoining.getOrganizationId());
		}

		DesignationGroup desigGroup = null;
		try {

			Designation desig = DesignationLocalServiceUtil.getDesignation(employeeJoining.getDesignationId());
			desigGroup = DesignationGroupLocalServiceUtil.getDesignationGroup(desig.getDesignationGroupId());
		} catch (Exception e) {
			LOGGER.error(e);
			LOGGER.error("No Designation exists with id " + employeeJoining.getDesignationId());
			desigGroup = DesignationGroupLocalServiceUtil.createDesignationGroup(0);
		}

		Organization orgSection = null;
		if (employeeJoining.getSubOrganizationId() > 0) {
			try {
				orgSection = OrganizationLocalServiceUtil.getOrganization(employeeJoining.getSubOrganizationId());
			} catch (Exception e) {
				LOGGER.error("No organization(section) exists with name " + employeeJoining.getSubOrganizationId());
			}
		}

		String fullName = people.getFirstName_En()
				.concat(StringUtils.isNotEmpty(people.getMiddleName_En()) ? " ".concat(people.getMiddleName_En()) : "")
				.concat(StringUtils.isNotEmpty(people.getLastName_En()) ? " ".concat(people.getLastName_En()) : "");

		Date retirementDate = null;
		try {
			retirementDate = calculateRetirementDate(people.getDateOfBirth());
		} catch (Exception e) {
		}

		// Saving the employee record
		Employee employee = null;
		if (people != null) {
			try {
				long employeeId = CounterLocalServiceUtil.increment(Employee.class.getName());
				employee = EmployeeLocalServiceUtil.createEmployee(employeeId);
				employee.setPersonalNo(String.valueOf(personalNumber));
				employee.setEmailId(loginId + "@ayudh.net");
				employee.setPeopleId(people.getPeopleId());
				employee.setDesignationId(employeeJoining.getDesignationId());
				List<CadreDesignation> cadreDesignations = CadreDesignationLocalServiceUtil
						.getCadreDesignationsByDesignationId(employeeJoining.getDesignationId());
				if (CollectionUtils.isNotEmpty(cadreDesignations)) {
					employee.setCadreId(cadreDesignations.get(0).getCadreId());
				}
				employee.setDesignationGroupId(desigGroup.getDesignationGroupId());
				employee.setGradeId(employeeJoining.getGradeId());
				employee.setTradeId(employeeJoining.getTradeId());
				employee.setOrganizationId((orgUnit != null ? orgUnit.getOrganizationId() : 0));
				employee.setSubOrganizationId((orgSection != null ? orgSection.getOrganizationId() : 0));
				employee.setLoginId(loginId);
				employee.setDateOfJoining(employeeJoining.getDateOfJoining());
                employee.setStatus(1);
				employee.setRetirementDate(retirementDate);
                employee.setPostName(employeeJoining.getPostBox());
				EmployeeLocalServiceUtil.updateEmployee(employee);

				LOGGER.info("createEmployee : employee was created with personal no " + personalNumber + ", email id: "
						+ loginId + "@ayudh.net");
				
	
			} catch (Exception e) {
				LOGGER.info("createEmployee : employee  creation failed with personal no " + personalNumber + ", email id: "
						+ loginId + "@ayudh.net");
				
			}
		}

		// Saving the email address to employee email table

		String secondaryEmail = StringUtils.lowerCase(employeeJoining.getEmailAddress());
		boolean officialSecondaryEmail = (secondaryEmail.contains("nic") || secondaryEmail.contains("ayudh")
				|| secondaryEmail.contains("ofb"));

		if (employee != null && StringUtils.isNotEmpty(secondaryEmail)) {
			try {
				if (officialSecondaryEmail) {
					long employeeEmailId = CounterLocalServiceUtil.increment(EmployeeEmail.class.getName());
					EmployeeEmail employeeEmail = EmployeeEmailLocalServiceUtil.createEmployeeEmail(employeeEmailId);
					employeeEmail.setEmployeeId(employee.getEmployeeId());
					employeeEmail.setEmailAddress(employeeJoining.getEmailAddress());
					EmployeeEmailLocalServiceUtil.updateEmployeeEmail(employeeEmail);
					LOGGER.info("createEmployee : EmployeeEmail is created with :" + employeeJoining.getEmailAddress());
				}
			} catch (Exception e) {
				LOGGER.info(e.getMessage());
			}
		}

		return employee;
	}

	private Date calculateRetirementDate(Date dateOfBirth) {
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

	private String generateLoginId(String firstName, String middleName, String lastName) {
		LOGGER.info("Generate  Login   Id");

		String loginId = null;

		if (firstName == null) {
			firstName = "";
		}
		if (middleName == null) {
			middleName = "";
		}
		if (lastName == null) {
			lastName = "";
		}

		firstName = firstName.replaceAll("[^a-zA-Z0-9_]", "").toLowerCase();
		middleName = middleName.replaceAll("[^a-zA-Z0-9_]", "").toLowerCase();
		lastName = lastName.replaceAll("[^a-zA-Z0-9_]", "").toLowerCase();

		int firstNameLength = StringUtils.length(firstName);
		int middleNameLength = StringUtils.length(middleName);
		int lastNameLength = StringUtils.length(lastName);

		if (middleNameLength > 0) {
			if (lastNameLength > 0) {
				if (firstNameLength > 2) {
					loginId = firstName + "." + lastName;
				} else { // firstNameLength <=2
					loginId = firstName + middleName + "." + lastName;
				}
			} else {
				if (firstNameLength > 2) {
					loginId = firstName;
				} else { // firstNameLength <=2
					loginId = firstName + middleName;
				}
			}
		} else {
			if (lastNameLength > 0) {
				loginId = firstName + "." + lastName;
			} else {
				loginId = firstName;
			}
		}
		return loginId;
	}

	private String getAvailableLoginId(String loginId) {

		if (isLoginIdAvailable(loginId)) {
			return loginId;
		}

		String nextId = loginId;
		StringBuilder sbDigits = new StringBuilder();
		for (int i = loginId.length() - 1; i >= 0; i--) {
			char c = loginId.charAt(i);
			if (Character.isDigit(c)) {
				sbDigits.insert(0, c);
			} else {
				break;
			}
		}

		if (sbDigits.length() == 0) {
			nextId = nextId + "1";
		} else {
			nextId = loginId.replaceAll(sbDigits.toString() + "$", "");
			StringBuilder newDigits = new StringBuilder();
			int nextNumber = Integer.parseInt(sbDigits.toString()) + 1;
			newDigits.append(nextNumber);
			while (newDigits.length() < sbDigits.length()) {
				newDigits.insert(0, 0);
			}
			nextId = nextId + newDigits.toString();
		}
		return getAvailableLoginId(nextId);
	}

	private boolean isLoginIdAvailable(String loginId) {
		// verify in approved records Liferay Users and Employee
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		List<RegistrationRequest> registrationRequestList = RegistrationRequestUtil.findByLoginIdAndStatus(loginId,
				WorkflowConstants.STATUS_APPROVED);
		Employee employeeByLoginId = EmployeeLocalServiceUtil.getEmployeeByLoginId(loginId);
		if (employeeByLoginId!=null || !registrationRequestList.isEmpty()) {
			return false;
		}

		try {
			User user = UserServiceUtil.getUserByScreenName(serviceContext.getCompanyId(), loginId);
			
			if (user != null)
				return false;
		} catch (PortalException e) {
			LOGGER.debug(e.getMessage());
		}

		return true;
	}

	public User createUser(EmployeeJoining employeeJoining, People people, OnBoardingConfig boardingConfig) {

		try {
			long companyId = CompanyThreadLocal.getCompanyId();
			Group group = null;
			Role empRole = null;
			Role userRole = null;
			UserGroup userGroup = null;
			try {
				group = GroupLocalServiceUtil.getGroup(companyId, boardingConfig.getGroup());
			} catch (Exception e) {
				LOGGER.error(" No Group found  ");
			}

			try {
				empRole = RoleLocalServiceUtil.getRole(companyId, boardingConfig.getEmployeeRole());
			} catch (Exception e) {
				LOGGER.error(" No EmployeeRole found ");
			}

			try {
				userRole = RoleLocalServiceUtil.getRole(companyId, boardingConfig.getUserRole());
			} catch (Exception e) {
				LOGGER.error(" No UserRole found ");
			}

			try {
				userGroup = UserGroupLocalServiceUtil.getUserGroup(companyId, boardingConfig.getUserGroup());
			} catch (Exception e) {
				LOGGER.error(" No UserGroup found ");
			}

			Calendar birthDate = Calendar.getInstance();
			birthDate.setTime(people.getDateOfBirth());
			ServiceContext serviceContext = new ServiceContext();
			String designationName = "";
			try {
				Designation designation = DesignationLocalServiceUtil
						.getDesignation(employeeJoining.getDesignationId());
				designationName = designation.getName_En();
			} catch (Exception e) {
				LOGGER.error(" No designation exists with designationId " + employeeJoining.getDesignationId());
			}

			String lastName = StringUtils.isBlank(people.getLastName_En()) ? "." : people.getLastName_En();
			String middleName = StringUtils.isBlank(people.getMiddleName_En()) ? "." : people.getMiddleName_En();
                      User user=null;
			
					try {
					user=UserLocalServiceUtil.getUserByScreenName(companyId, loginId);
					LOGGER.info("AppUser : User already exist with  "+loginId +" / "+ loginId+"@ayudh.net"); 
					}catch(Exception e) {
						LOGGER.info(e);
					}
					
					
					if(user==null) {
			
			 user = UserLocalServiceUtil.addUser(PrincipalThreadLocal.getUserId(), companyId, false,
					boardingConfig.getPassword(), boardingConfig.getPassword(), false, loginId, loginId + "@ayudh.net",
					Locale.getDefault(), people.getFirstName_En(), middleName, lastName, 0, 0, true,
					birthDate.get(Calendar.MONTH), birthDate.get(Calendar.DAY_OF_MONTH), birthDate.get(Calendar.YEAR),
					designationName, new long[] { group.getGroupId() },
					new long[] { employeeJoining.getOrganizationId() },
					new long[] { empRole.getRoleId(), userRole.getRoleId() }, new long[] { userGroup.getUserGroupId() },
					false, serviceContext);
			LOGGER.info("createAppUser : User is created sucessfully for " + loginId + " / " + loginId + "@ayudh.net");
			
			employeePermission.setUserCreated(true);
			EmployeePermissionLocalServiceUtil.updateEmployeePermission(employeePermission);
					}
			return user;
		} catch (Exception e) {
			LOGGER.error(" User not Created "+e);
		}
		return null;
	}

	public boolean createIDAMUser(EmployeeJoining employeeJoining, People people, User approver, long personalNumber,
			EmployeePermission employeePermission, OnBoardingConfig boardingConfig) throws IOException {
		LOGGER.info("Mehtod calling Idam User : create Idam User ");
		String orgDivCode = null;
		String orgDivName = null;
		String orgDivLongName = null;
		Organization orgDiv = null;
		Organization orgUnit = null;

		try {
			orgUnit = OrganizationLocalServiceUtil.getOrganization(employeeJoining.getOrganizationId());
			orgDiv = OrganizationLocalServiceUtil.getOrganization(orgUnit.getParentOrganizationId());
			orgDivName = orgDiv.getName();

			orgDivCode = ExpandoValueLocalServiceUtil.getData(orgDiv.getCompanyId(), Organization.class.getName(),
					"CUSTOM_FIELDS", "code", orgDiv.getOrganizationId(), "");
			orgDivLongName = ExpandoValueLocalServiceUtil.getData(orgDiv.getCompanyId(), Organization.class.getName(),
					"CUSTOM_FIELDS", "longName", orgDiv.getOrganizationId(), "");

		} catch (Exception e) {
			LOGGER.error("No organization(unit) exists with name " + employeeJoining.getOrganizationId());
		}

		LOGGER.info(
				"orgDivName : " + orgDivName + ", orgDivCode : " + orgDivCode + ", orgDivLongName : " + orgDivLongName);

		if (orgDivCode == null) {
			orgDivCode = "";
		}

		if (orgDivName == null) {
			orgDivName = "";
		}

		String unitDescription = "";
		String unitName = "";
		String unitAddress = "";
		String unitCode = "";
		try {
			OrganizationDetail ouDetail = OrganizationDetailLocalServiceUtil
					.getOrganizationDetail(employeeJoining.getOrganizationId());
			unitDescription = ouDetail.getLongName();
			unitName = ouDetail.getShortName();
			unitCode = ouDetail.getOrganizationCode();
			unitAddress = ouDetail.getAddress1() + ", " + ouDetail.getAddress2() + ", " + ouDetail.getAddress3() + ", "
					+ ouDetail.getCity() + ", " + ouDetail.getPin();

		} catch (Exception e) {

			LOGGER.error("No organization(unit) exists with name " + employeeJoining.getOrganizationId());

		}

		String sectionDescription = "";
		String sectionCode = "";
		String sectionName = "";

		try {
			OrganizationDetail ouDetail = OrganizationDetailLocalServiceUtil
					.getOrganizationDetail(employeeJoining.getSubOrganizationId());
			sectionName = ouDetail.getShortName();
			sectionDescription = ouDetail.getLongName();
			sectionCode = ouDetail.getOrganizationCode();
		} catch (Exception e) {
			LOGGER.error("No organization(section) exists with id " + employeeJoining.getSubOrganizationId());
		}

		String desigGrpName = "";
		String desigDesc = "";
		String desigName = "";
		String desigCode = "";
		try {
			Designation desig = DesignationLocalServiceUtil.getDesignation(employeeJoining.getDesignationId());
			desigDesc = desig.getLongName();
			desigName = desig.getName_En();
			desigCode = desig.getCode();
			DesignationGroup desGrp = DesignationGroupLocalServiceUtil
					.getDesignationGroup(desig.getDesignationGroupId());
			desigGrpName = desGrp.getName();

		} catch (Exception e) {
		}

		String gradeDesc = "";
		try {
			Grade grade = GradeLocalServiceUtil.getGrade(employeeJoining.getGradeId());
			gradeDesc = grade.getDescription();

		} catch (Exception e) {
		}

		String gradeCode = "";
		String gradeName = "";
		try {
			Grade grade = GradeLocalServiceUtil.getGrade(employeeJoining.getGradeId());
			gradeName = grade.getName();
			gradeCode = grade.getCode();

		} catch (Exception e) {
		}

		String tradeCode = "";
		String tradeName = "";
		try {
			Trade trade = TradeLocalServiceUtil.getTrade(employeeJoining.getTradeId());
			tradeCode = trade.getCode();
			tradeName = trade.getName();

		} catch (Exception e) {
		}

		String genderName = "";

		try {
			Gender gender = GenderLocalServiceUtil.getGender(people.getGenderId());
			genderName = gender.getName();

		} catch (Exception e) {
		}

		String casteCategoryName = "";

		try {
			CasteCategory casteCategory = CasteCategoryLocalServiceUtil.getCasteCategory(people.getCasteCategoryId());
			casteCategoryName = casteCategory.getName();

		} catch (Exception e) {
		}

		String fullName = people.getFirstName_En()
				.concat(StringUtils.isNotEmpty(people.getMiddleName_En()) ? " ".concat(people.getMiddleName_En()) : "")
				.concat(StringUtils.isNotEmpty(people.getLastName_En()) ? " ".concat(people.getLastName_En()) : "");
		// String gpfnpsType =
		// singleUserOnboarding.getGpfnpsType().equalsIgnoreCase("GPF") ?"GPF" : "NPS";
		// long getGpfnpsNumber=(singleUserOnboarding.getGpfnpsNumber()>0 ?
		// singleUserOnboarding.getGpfnpsNumber(): 0);

		String idamUserLocation = PropsUtil.get("idam.user.location");
		if (StringUtils.isEmpty(idamUserLocation) && boardingConfig != null) {

			idamUserLocation = boardingConfig.getIdamUserLocation();
		}

		String idamUserMailQuota = PropsUtil.get("idam.user.mail.quota");
		if (StringUtils.isEmpty(idamUserMailQuota) && boardingConfig != null) {

			idamUserMailQuota = String.valueOf(boardingConfig.getMailQuata());
		}

		String idamUserAPIEndPoint = PropsUtil.get("idam.user.api.endpoint");
		if (StringUtils.isEmpty(idamUserAPIEndPoint) && boardingConfig != null) {
			idamUserAPIEndPoint = boardingConfig.getIdamUserServiceURL();
		}

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("fullname", fullName);
		jsonObject.put("firstname", people.getFirstName_En());
		jsonObject.put("middlename", people.getMiddleName_En());
		jsonObject.put("lastname", StringUtils.isBlank(people.getLastName_En()) ? "." : people.getLastName_En());
		jsonObject.put("email", loginId + "@ayudh.net");
		jsonObject.put("location", idamUserLocation);
		jsonObject.put("mobile", String.valueOf(0));
		jsonObject.put("accountno", personalNumber);
		jsonObject.put("divisioncode", orgDivCode);
		jsonObject.put("division", orgDivName);
		jsonObject.put("divisiondescription", orgDivLongName);
		jsonObject.put("unit", unitName);
		jsonObject.put("designation", desigName);
		jsonObject.put("grade", gradeName);
		jsonObject.put("trade", tradeName);
		jsonObject.put("dateOfJoiningUnit", DATE_FORMAT.format(employeeJoining.getDateOfJoining()));
		jsonObject.put("gender", genderName);
		jsonObject.put("dateOfBirth", DATE_FORMAT.format(people.getDateOfBirth()));
		jsonObject.put("castCategory", casteCategoryName);
		jsonObject.put("gpfNps", "");
		jsonObject.put("gpfNpsNo", String.valueOf(0));
		jsonObject.put("section", sectionName);

		jsonObject.put("mailquota", idamUserMailQuota);
		jsonObject.put("emailpre", loginId);

		jsonObject.put("loginid", loginId);
		jsonObject.put("DMS", (employeePermission.getEGovAccess() ? "Y" : "N"));

		jsonObject.put("zimbra", (employeePermission.getEmailAccess() ? "Y" : "N"));
		jsonObject.put("liferay", (employeePermission.getPisAccess() ? "Y" : "N"));

		// #########New Attribtes ############//
		jsonObject.put("EGOV", (employeePermission.getEGovAccess() ? "Y" : "N"));
		jsonObject.put("DSC", (employeePermission.getDigitalSigning() ? "Y" : "N"));
		jsonObject.put("unitcode", unitCode);
		jsonObject.put("sectioncode", sectionCode);
		jsonObject.put("designationcode", desigCode);
		jsonObject.put("gradecode", gradeCode);
		jsonObject.put("gradedescription", gradeDesc);
		jsonObject.put("tradecode", tradeCode);
		jsonObject.put("unitdescription", unitDescription);
		jsonObject.put("sectiondescription", sectionDescription);
		jsonObject.put("unitaddress", unitAddress);
		jsonObject.put("designationgroup", desigGrpName);
		jsonObject.put("designationdescription", desigDesc);

		jsonObject.put("postbox", employeeJoining.getPostBox());
		jsonObject.put("rank", employeeJoining.getRank());
		if (approver != null) {
			jsonObject.put("approveremail", approver.getEmailAddress());

			LOGGER.info(loginId + " - Approved by - " + approver.getEmailAddress());

		}
		// #########New Attributes end #########//

		String jsonData = jsonObject.toJSONString();

		LOGGER.info(jsonData);
		LOGGER.info("createIDAMUser: calling idamUserAPIEndPoint : " + idamUserAPIEndPoint);

		boolean createIDAMUserBySingleUserOnboarding = BulkOnboardUtils.createIDAMUserBySingleUserOnboarding(jsonData,
				idamUserAPIEndPoint);
		
		if(createIDAMUserBySingleUserOnboarding) {
			employeePermission.setIdamUserCreated(true);
			EmployeePermissionLocalServiceUtil.updateEmployeePermission(employeePermission);
		}
		return createIDAMUserBySingleUserOnboarding;

	}

}
