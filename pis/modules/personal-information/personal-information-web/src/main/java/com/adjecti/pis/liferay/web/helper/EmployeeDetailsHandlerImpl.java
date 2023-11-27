package com.adjecti.pis.liferay.web.helper;

import com.adjecti.mdm.liferay.model.Appellation;
import com.adjecti.mdm.liferay.model.Designation;
import com.adjecti.mdm.liferay.model.DocumentType;
import com.adjecti.mdm.liferay.service.BloodGroupLocalService;
import com.adjecti.mdm.liferay.service.CasteCategoryLocalService;
import com.adjecti.mdm.liferay.service.DesignationLocalService;
import com.adjecti.mdm.liferay.service.DocumentLocalService;
import com.adjecti.mdm.liferay.service.DocumentTypeLocalService;
import com.adjecti.mdm.liferay.service.GenderLocalService;
import com.adjecti.mdm.liferay.service.GradeLocalService;
import com.adjecti.mdm.liferay.service.MaritalStatusLocalService;
import com.adjecti.mdm.liferay.service.PayLevelLocalService;
import com.adjecti.mdm.liferay.service.PhTypeLocalService;
import com.adjecti.mdm.liferay.service.PostReportingLocalService;
import com.adjecti.mdm.liferay.service.QualificationLevelLocalService;
import com.adjecti.mdm.liferay.service.QualificationLocalService;
import com.adjecti.mdm.liferay.service.ReligionLocalService;
import com.adjecti.mdm.liferay.service.StateLocalService;
import com.adjecti.mdm.liferay.service.StateLocalServiceUtil;
import com.adjecti.mdm.liferay.service.TradeLocalService;
import com.adjecti.mdm.liferay.util.MDMUtils;
import com.adjecti.pis.liferay.exception.NoSuchEmployeeContactException;
import com.adjecti.pis.liferay.model.Address;
import com.adjecti.pis.liferay.model.Contact;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.liferay.model.EmployeeAddress;
import com.adjecti.pis.liferay.model.EmployeeContact;
import com.adjecti.pis.liferay.model.EmployeeDocument;
import com.adjecti.pis.liferay.model.EmployeeJoining;
import com.adjecti.pis.liferay.model.People;
import com.adjecti.pis.liferay.service.AddressLocalService;
import com.adjecti.pis.liferay.service.ContactLocalService;
import com.adjecti.pis.liferay.service.EmployeeAddressLocalService;
import com.adjecti.pis.liferay.service.EmployeeContactLocalService;
import com.adjecti.pis.liferay.service.EmployeeDocumentLocalService;
import com.adjecti.pis.liferay.service.EmployeeJoiningLocalServiceUtil;
import com.adjecti.pis.liferay.service.EmployeeLocalService;
import com.adjecti.pis.liferay.service.EmployeeQualificationLocalService;
import com.adjecti.pis.liferay.service.EmployeeReportingLocalService;
import com.adjecti.pis.liferay.service.PeopleLocalService;
import com.adjecti.pis.liferay.web.model.AddressListViewModel;
import com.adjecti.pis.liferay.web.model.AddressViewModel;
import com.adjecti.pis.liferay.web.model.ApplicationAccessListViewModel;
import com.adjecti.pis.liferay.web.model.BenefitSchemeListViewModel;
import com.adjecti.pis.liferay.web.model.ConfirmationListViewModel;
import com.adjecti.pis.liferay.web.model.ContactViewModel;
import com.adjecti.pis.liferay.web.model.DeputationListViewModel;
import com.adjecti.pis.liferay.web.model.EmployeeDetailsData;
import com.adjecti.pis.liferay.web.model.EmployeeViewModel;
import com.adjecti.pis.liferay.web.model.ExperienceListViewModel;
import com.adjecti.pis.liferay.web.model.JoiningListViewModel;
import com.adjecti.pis.liferay.web.model.JoiningProcessListViewModel;
import com.adjecti.pis.liferay.web.model.OfficialViewModel;
import com.adjecti.pis.liferay.web.model.PersonalViewModel;
import com.adjecti.pis.liferay.web.model.PostListViewModel;
import com.adjecti.pis.liferay.web.model.PromotionListViewModel;
import com.adjecti.pis.liferay.web.model.QualificationListViewModel;
import com.adjecti.pis.liferay.web.model.QualificationViewModel;
import com.adjecti.pis.liferay.web.model.ReportingListViewModel;
import com.adjecti.pis.liferay.web.model.SeniorityListViewModel;
import com.adjecti.pis.liferay.web.model.TrainingListViewModel;
import com.adjecti.pis.liferay.web.model.TransferListViewModel;
import com.adjecti.pis.liferay.web.model.TransferProcessListViewModel;
import com.adjecti.pis.liferay.web.model.UserViewModel;
import com.adjecti.pis.liferay.web.model.VerificationListViewModel;
import com.adjecti.pis.liferay.web.model.WorkstationListViewModel;
import com.adjecti.pis.liferay.web.model.WorkstationViewModel;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoTable;
import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.expando.kernel.service.ExpandoColumnLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoTableLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.service.CountryService;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component
public class EmployeeDetailsHandlerImpl implements EmployeeDetailsHandler {

	// -----Liferay-----//
	private OrganizationLocalServiceUtil organizationLocalService;
	private ExpandoValueLocalServiceUtil expandoValueLocalService;
	// ----------------//
	// ----Employee-----//
	@Reference
	private EmployeeLocalService employeeLocalService;
	@Reference
	private PeopleLocalService peopleLocalService;
	@Reference
	private EmployeeAddressLocalService employeeAddressLocalService;
	@Reference
	private AddressLocalService addressLocalServiceUtil;
	@Reference
	private EmployeeQualificationLocalService employeeQualificationLocalServiceUtil;
	@Reference
	private ContactLocalService contactLocalServiceUtil;
	@Reference
	private EmployeeContactLocalService employeeContactLocalServiceUtil;
	@Reference
	private EmployeeReportingLocalService employeeReportingLocalService;
	@Reference
	private EmployeeDocumentLocalService employeeDocumentLocalService;
	// ----------------//

	// --------MDM-------//
	@Reference
	private DesignationLocalService designationLocalService;
	@Reference
	private GradeLocalService gradeLocalService;
	@Reference
	private TradeLocalService tradeLocalService;
	@Reference
	private PayLevelLocalService payLevelLocalService;
	@Reference
	private PostReportingLocalService postReportingLocalService;
	@Reference
	private GenderLocalService genderLocalService;
	@Reference
	private MaritalStatusLocalService maritalStatusLocalService;
	@Reference
	private CasteCategoryLocalService casteCategoryLocalService;
	@Reference
	private ReligionLocalService religionLocalService;
	@Reference
	private BloodGroupLocalService bloodGroupLocalService;
	@Reference
	private StateLocalService localServiceUtil;
	@Reference
	private CountryService countryServiceUtil;
	@Reference
	private PhTypeLocalService phTypeLocalServiceUtil;
	@Reference
	private QualificationLocalService qualificationLocalServiceUtil;
	@Reference
	private QualificationLevelLocalService levelLocalServiceUtil;
	@Reference
	private DocumentLocalService documentLocalService;
	@Reference
	private DocumentTypeLocalService documentTypeLocalService;

	// ------------------//
	@Override
	public EmployeeDetailsData getEmployeeAllDetails(long employeeId) throws PortalException {
		/*
		 * ServiceContext serviceContext=ServiceContextThreadLocal.getServiceContext();
		 * User user=UserLocalServiceUtil.getUser(serviceContext.getUserId());
		 * List<Organization>
		 * organizations=OrganizationLocalServiceUtil.getOrganizations(user.);
		 */
		EmployeeDetailsData detailsData = new EmployeeDetailsData();
		Employee employee = employeeLocalService.getEmployee(employeeId);
		People people = peopleLocalService.getPeople(employee.getPeopleId());
		try {
			detailsData.setUserViewModel(getUser(employee, people));
			detailsData.setOfficialViewModel(getOfficial(employee));
			detailsData.setPersonalViewModel(getPersonal(people));
			detailsData.setQualificationViewModel(getQualification(employee));
			detailsData.setAddressViewModel(getAddress(employee));
			detailsData.setContactViewModel(getContact(employee));
			detailsData.setWorkstationViewModel(getWorkstation(employee));
			detailsData.setAddressListViewModels(getAllAddressList(employee));

		} catch (PortalException e) {

			System.out.println(e.getMessage());
		}
		return detailsData;

	}



	@Override
	public OfficialViewModel getOfficial(Employee employee) throws PortalException {
		OfficialViewModel officialViewModel = new OfficialViewModel();
		try {
			officialViewModel
					.setDesignation(designationLocalService.getDesignation(employee.getDesignationId()).getName_En());
			officialViewModel.setGrade(gradeLocalService.getGrade(employee.getGradeId()).getName());
			officialViewModel.setTrade(tradeLocalService.getTrade(employee.getTradeId()).getName());
			officialViewModel.setPayLevel(payLevelLocalService.getPayLevel(employee.getPayLevelId()).getName());
			officialViewModel.setUnit(organizationLocalService.getOrganization(employee.getOrganizationId()).getName()); // orgnization
			// ---TODO---
			// officialViewModel.setBatch(batch);
			//officialViewModel.setReportingTo();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return officialViewModel;
	}

	@Override
	public PersonalViewModel getPersonal(People people) throws PortalException {

		PersonalViewModel personalViewModel = new PersonalViewModel();
		try {
			String pattern = "dd-MM-yyyy";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			String date = simpleDateFormat.format(people.getDateOfBirth());
			personalViewModel.setDob(date);
			personalViewModel.setGender(genderLocalService.getGender(people.getGenderId()).getName());
			personalViewModel.setMaritalStatus(
					maritalStatusLocalService.getMaritalStatus(people.getMaritalStatusId()).getName());
			personalViewModel.setFatherName(people.getFatherName_En());
			personalViewModel
					.setCaste(casteCategoryLocalService.getCasteCategory(people.getCasteCategoryId()).getName());
			personalViewModel.setReligion(religionLocalService.getReligion(people.getReligionId()).getName());
			personalViewModel.setBloodGroup(bloodGroupLocalService.getBloodGroup(people.getBloodGroupId()).getName());
			personalViewModel.setAadhaarNumber(people.getAadhaarNo());
			personalViewModel.setHandicap(phTypeLocalServiceUtil.getPhType(people.getPhTypeId()).getName());
			if (people.getExServiceMan()) {
				personalViewModel.setExServiceMan("Yes");
			} else {
				personalViewModel.setExServiceMan("No");
			}

			personalViewModel.setPanNo(people.getPanNo());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return personalViewModel;
	}

	@Override
	public QualificationViewModel getQualification(Employee employee) throws PortalException {
		QualificationViewModel qualificationViewModel = new QualificationViewModel();

		try {
			qualificationViewModel.setDegree(
							qualificationLocalServiceUtil
									.getQualification(employeeQualificationLocalServiceUtil
											.getEmployeeQualificationByEmployeeId(employee.getEmployeeId()).get(0).getQualificationId())
									.getName());
			qualificationViewModel
					.setLevel(levelLocalServiceUtil.getQualificationLevel(employeeQualificationLocalServiceUtil
							.getEmployeeQualificationByEmployeeId(employee.getEmployeeId()).get(0).getLevelId()).getName());
			// ---TODO---
			// qualificationViewModel.setSubject(subject);
			qualificationViewModel.setPassingYear(Integer.toString(employeeQualificationLocalServiceUtil
					.getEmployeeQualificationByEmployeeId(employee.getEmployeeId()).get(0).getToYear()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return qualificationViewModel;
	}

	@Override
	public AddressViewModel getAddress(Employee employee) throws PortalException {
		AddressViewModel addressViewModel = new AddressViewModel();
		try {
			
			List<EmployeeAddress> empAddress = employeeAddressLocalService.getEmployeeAddressByEmpId(employee.getEmployeeId());
			for(EmployeeAddress employeeAdd:empAddress) {
				if(employeeAdd.isPermanent()) {
				Address address=addressLocalServiceUtil.getAddress(employeeAdd.getAddressId());	
				addressViewModel.setAddress(address.getAddressLine1());
				addressViewModel.setCity(address.getCity());
				addressViewModel.setState(StateLocalServiceUtil.getState(address.getStateId()).getName());
				addressViewModel.setCountry(countryServiceUtil.getCountry(address.getCountryId()).getName());
				addressViewModel.setPin(address.getPinCode());
			
				}
			}	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return addressViewModel;
	}

	@Override
	public ContactViewModel getContact(Employee employee) throws PortalException {
		ContactViewModel contactViewModel = new ContactViewModel();

		try {
			Contact contact= contactLocalServiceUtil.getContact(employeeContactLocalServiceUtil.getEmployeeContactByEmployeeId(employee.getEmployeeId()).getContactId());
			contactViewModel.setAlternateEmail(contact.getAltEmailAddress());
			contactViewModel.setLandLine(contact.getLandline());
			contactViewModel.setMobile(contact.getMobile());
			contactViewModel.setEmergency(contact.getEmergencyMobile());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return contactViewModel;
	}

	@Override
	public WorkstationViewModel getWorkstation(Employee employee) throws NoSuchEmployeeContactException {
		WorkstationViewModel workstationViewModel = new WorkstationViewModel();

		try {
			EmployeeContact employeeContact=employeeContactLocalServiceUtil.getEmployeeContactByEmployeeId(employee.getEmployeeId());
			workstationViewModel.setDeskNo(employeeContact.getDeskNo());
			workstationViewModel.setDirectNo(employeeContact.getDirectNo());
			workstationViewModel.setDeskPhoneNo(employeeContact.getPhoneNo());
			workstationViewModel.setExtensionNo(employeeContact.getExtn());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return workstationViewModel;
	}
	
	@Override
	public UserViewModel getUser(Employee employee, People people) throws PortalException {
		UserViewModel userViewModel = new UserViewModel();
		// ---TODO---
		userViewModel.setImage(getImagePath(employee.getEmployeeId()));
		userViewModel.setFirstName(people.getFirstName_En());
		userViewModel.setMiddleName(people.getMiddleName_En());
		userViewModel.setLastName(people.getLastName_En());
		userViewModel.setEmployeeNo(employee.getEmployeeId());
		userViewModel.setDesignation(designationLocalService.getDesignation(employee.getDesignationId()).getName_En());
		userViewModel.setEmail(employee.getEmailId());
		
		return userViewModel;

	}
	
	public EmployeeViewModel convertEmployeeToEmployeeViewModel(Employee employee) throws PortalException{
		EmployeeViewModel employeeViewModel = new EmployeeViewModel();

		Designation designation=MDMUtils.getDesignationById(employee.getDesignationId());
		People people=peopleLocalService.getPeople(employee.getPeopleId());
		Appellation appellation=MDMUtils.getAppellationById(people.getAppellationId());
		String fullName=(appellation!=null? appellation.getName():"")+" "+ (people!=null?people.getFirstName_En():"")+" "+(people!=null?people.getLastName_En():" ");
		employeeViewModel.setImage(getImagePath(employee.getEmployeeId()));
		employeeViewModel.setPersonalNo(employee.getPersonalNo());
		employeeViewModel.setName(fullName);
		employeeViewModel.setDesignation(designation!=null?designation.getName_En():"");
		employeeViewModel.setDivision(getOrgnizationByType(employee.getOrganizationId(), "Division"));
		employeeViewModel.setFactorySaction(getOrgnizationByType(employee.getOrganizationId(), "Factory") + " "
				+ getOrgnizationByType(employee.getOrganizationId(), "Section"));
		employeeViewModel.setEmail(employee.getEmailId());
		employeeViewModel.setEmployeeId(employee.getEmployeeId());
		
		return employeeViewModel;
		
	}
	
	public List<EmployeeViewModel> convertEmployeeToEmployeeViewModel(List<Employee> employees) throws PortalException{
		List<EmployeeViewModel> employeesViewModel = new ArrayList<EmployeeViewModel>();
		for (Employee emp : employees) {
//			EmployeeViewModel employee = new EmployeeViewModel();
//
//			employee.setImage(getImagePath(emp.getEmployeeId()));
//			employee.setPersonalNo(emp.getPersonalNo());
//			employee.setName(peopleLocalService.getPeople(emp.getPeopleId()).getFirstName_En() + " "+ peopleLocalService.getPeople(emp.getPeopleId()).getLastName_En());
////			employee.setDesignation(designationLocalService.getDesignation(emp.getDesignationId()).getName_En());
//			
//			employee.setDesignation(MDMUtils.getDesignationById(emp.getDesignationId()).getName_En());
//			employee.setDivision(getOrgnizationByType(emp.getOrganizationId(), "Division"));
//			employee.setFactorySaction(getOrgnizationByType(emp.getOrganizationId(), "Factory") + " "
//					+ getOrgnizationByType(emp.getOrganizationId(), "Section"));
//			employee.setEmail(emp.getEmailId());
//			employee.setEmployeeId(emp.getEmployeeId());
			employeesViewModel.add(convertEmployeeToEmployeeViewModel(emp));

		}
		return employeesViewModel;
	}

	@Override
	public List<EmployeeViewModel> getAllEmployee() throws PortalException {

//		List<EmployeeViewModel> employees = new ArrayList<EmployeeViewModel>();
//		for (Employee emp : employeeLocalService.getEmployees(QueryUtil.ALL_POS, QueryUtil.ALL_POS)) {
//			EmployeeViewModel employee = new EmployeeViewModel();
//
//			employee.setImage(getImagePath(emp.getEmployeeId()));
//			employee.setPersonalNo(emp.getPersonalNo());
//			employee.setName(peopleLocalService.getPeople(emp.getPeopleId()).getFirstName_En() + " "+ peopleLocalService.getPeople(emp.getPeopleId()).getLastName_En());
//			employee.setDesignation(designationLocalService.getDesignation(emp.getDesignationId()).getName_En());
//			employee.setDivision(getOrgnizationByType(emp.getOrganizationId(), "Division"));
//			employee.setFactorySaction(getOrgnizationByType(emp.getOrganizationId(), "Factory") + " "
//					+ getOrgnizationByType(emp.getOrganizationId(), "Section"));
//			employee.setEmail(emp.getEmailId());
//			employee.setEmployeeId(emp.getEmployeeId());
//			employees.add(employee);
//
//		}

//		return employees;
		return convertEmployeeToEmployeeViewModel(employeeLocalService.getEmployees(QueryUtil.ALL_POS, QueryUtil.ALL_POS));
	}

	private FileEntry getImagePath(long employeeId) {
		try {
			
			List<EmployeeDocument> empDocuments = employeeDocumentLocalService.getEmployeeDocumentByEmpId(employeeId);
			
			for (EmployeeDocument empDoc : empDocuments) {
				FileEntry dlFileEntry=DLAppServiceUtil.getFileEntry(empDoc.getDocumentId());
				DocumentType documentType = documentTypeLocalService.getDocumentType(empDoc.getDocumentTypeId());
				if (documentType.getName().equals("photograph")) {
					return dlFileEntry;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	@Override
	public String getOrgnizationByType(long organizationId, String orgType) {

		try {
			Organization organization = organizationLocalService.getOrganization(organizationId);

			if (expandoValueIsSame(organization, orgType)) {
				return organization.getName();
			} else {
				if (organization.getAncestors().size() > 0) {
					List<Organization> list = organization.getAncestors();
					for (Organization org : list) {
						if (expandoValueIsSame(org, orgType)) {
							return org.getName();
						}
					}
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "-";
	}

	private boolean expandoValueIsSame(Organization organization, String str) {
		long classNameId = ClassNameLocalServiceUtil.getClassNameId(Organization.class.getName());
		try {
			ExpandoTable expandoTableData = ExpandoTableLocalServiceUtil.getTable(organization.getCompanyId(),
					classNameId, "CUSTOM_FIELDS");
			ExpandoColumn expandoColumnData = ExpandoColumnLocalServiceUtil.getColumn(organization.getCompanyId(),
					classNameId, expandoTableData.getName(), "Organization type");
			ExpandoValue expandoValueData = expandoValueLocalService.getValue(expandoTableData.getTableId(),
					expandoColumnData.getColumnId(), organization.getOrganizationId());
			if (str.equals(expandoValueData.getData())) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	@Override
	public List<AddressListViewModel> getAllAddressList(Employee employee){
		List<AddressListViewModel> addressList=new ArrayList<AddressListViewModel>();
		try {
		for(EmployeeAddress employeeAddress:employeeAddressLocalService.getEmployeeAddressByEmpId(employee.getEmployeeId())) {
		
			Address address=addressLocalServiceUtil.getAddress(employeeAddress.getAddressId());	
			AddressListViewModel addressListData=new AddressListViewModel();
			addressListData.setsNo(Long.toString(address.getAddressId()));
			//addressViewModel.setType();
			addressListData.setAddress(address.getAddressLine1());
			addressListData.setState(StateLocalServiceUtil.getState(address.getStateId()).getName());
			addressListData.setCountry(countryServiceUtil.getCountry(address.getCountryId()).getName());
			addressListData.setPin(address.getPinCode());
			addressList.add(addressListData);
		}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return addressList;
	}
	public List<ApplicationAccessListViewModel> getAllApplicationAccessList(Employee employee){
		List<ApplicationAccessListViewModel> applicationAccessList=new ArrayList<ApplicationAccessListViewModel>();
		ApplicationAccessListViewModel applicationAccess=new ApplicationAccessListViewModel();
		
		return applicationAccessList;
	}
	public List<BenefitSchemeListViewModel> getAllBenefitSchemeList(Employee employee){
		List<BenefitSchemeListViewModel> benefitScheme=new ArrayList<BenefitSchemeListViewModel>();
		return benefitScheme;
	}
	public List<ConfirmationListViewModel> getAllConfirmationList(Employee employee){
		List<ConfirmationListViewModel> confirmation=new ArrayList<ConfirmationListViewModel>();
		return confirmation;
	}
	public List<DeputationListViewModel> getAllDeputationList(Employee employee){
		List<DeputationListViewModel> deputation =new ArrayList<DeputationListViewModel>();
		return deputation;
	}
	public List<ExperienceListViewModel> getAllExperienceList(Employee employee){
		List<ExperienceListViewModel> experience=new ArrayList<ExperienceListViewModel>();
		return experience;
	}
	public List<JoiningListViewModel> getAllJoiningList(Employee employee){
		//Todo
		List<JoiningListViewModel> joiningList=new ArrayList<JoiningListViewModel>();
		for(EmployeeJoining employeeJoining:EmployeeJoiningLocalServiceUtil.getJoiningByEmployeeId(employee.getEmployeeId())) {
			try {
			JoiningListViewModel joining=new JoiningListViewModel();
			//joining.setsNo(employeeJoining.get);
			//joining.setUnit(employeeJoining.get);
			joining.setDesignation(designationLocalService.getDesignation(employeeJoining.getEmployeeId()).getName_En());
			joining.setGrade(gradeLocalService.getGrade(employeeJoining.getGradeId()).getName());
			joining.setTrade(tradeLocalService.getTrade(employeeJoining.getTradeId()).getName());
			//joining.setMode();
			joining.setFromDate(employeeJoining.getFromDate().toString());
			joining.setToDate(employeeJoining.getToDate().toString());
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}

			
		}
		return joiningList;
	}
	public List<JoiningProcessListViewModel> getAllJoiningProcessList(Employee employee){
		List<JoiningProcessListViewModel> joiningProcess=new ArrayList<JoiningProcessListViewModel>();
		return joiningProcess;
	}
//	public List<PastExperienceListViewModal> getAllPastExperienceList(Employee employee){
//		//Todo
//		List<PastExperienceListViewModal> pastExperienceList=new ArrayList<PastExperienceListViewModal>();
//		for(EmployeePastExperience pastExperience:EmployeePastExperienceUtil.findByEmployeeId(employee.getEmployeeId()) ) {
//			EmployeePastExperience employeePastExperience=new EmployeePastExperience();
//			
//		}
//		return pastExperienceList;
//	}
	public List<PostListViewModel> getAllPostList(Employee employee){
		List<PostListViewModel> post=new ArrayList<PostListViewModel>();
		return post;
	}
	public List<PromotionListViewModel> getAllPromotionList(){
		List<PromotionListViewModel> promotion=new ArrayList<PromotionListViewModel>();
		return promotion;
	}
	public List<QualificationListViewModel> getAllQualificationList(){
		//Todo
		List<QualificationListViewModel> qualification=new ArrayList<QualificationListViewModel>();
		return qualification;
	}
	public List<ReportingListViewModel> getAllReportingList(){
		List<ReportingListViewModel> reporting=new ArrayList<ReportingListViewModel>();
		return reporting;
	}
	public List<SeniorityListViewModel> getAllSeniorityList(){
		List<SeniorityListViewModel> seniority=new ArrayList<SeniorityListViewModel>();
		return seniority;
	}
	public List<TrainingListViewModel> getAllTrainingList(){
		List<TrainingListViewModel> training=new ArrayList<TrainingListViewModel>();
		return training;
	}
	public List<TransferListViewModel> getAllTransferList(){
		List<TransferListViewModel> transfer=new ArrayList<TransferListViewModel>();
		return transfer;
	}
	public List<TransferProcessListViewModel> getAllTransferProcessList(){
		List<TransferProcessListViewModel> transferProcess=new ArrayList<TransferProcessListViewModel>();
		return transferProcess;
	}
	public List<VerificationListViewModel> getAllVerificationList(){
		//Todo
		List<VerificationListViewModel> verification=new ArrayList<VerificationListViewModel>();
		return verification;
	}
	public List<WorkstationListViewModel> getAllWorkstationList(){
		List<WorkstationListViewModel> workstation=new ArrayList<WorkstationListViewModel>();
		return workstation;
	}
	
}
