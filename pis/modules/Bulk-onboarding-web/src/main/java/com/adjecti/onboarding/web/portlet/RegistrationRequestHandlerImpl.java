package com.adjecti.onboarding.web.portlet;

import com.adjecti.mdm.liferay.model.CasteCategory;
import com.adjecti.mdm.liferay.model.Designation;
import com.adjecti.mdm.liferay.model.Gender;
import com.adjecti.mdm.liferay.model.Grade;
import com.adjecti.mdm.liferay.model.OrganizationDetail;
import com.adjecti.mdm.liferay.model.Trade;
import com.adjecti.mdm.liferay.service.CasteCategoryLocalServiceUtil;
import com.adjecti.mdm.liferay.service.DesignationLocalServiceUtil;
import com.adjecti.mdm.liferay.service.GenderLocalServiceUtil;
import com.adjecti.mdm.liferay.service.GradeLocalServiceUtil;
import com.adjecti.mdm.liferay.service.OrganizationDetailLocalServiceUtil;
import com.adjecti.mdm.liferay.service.TradeLocalServiceUtil;
import com.adjecti.onboarding.web.dto.RegistrationRecord;
import com.adjecti.onboarding.web.portlet.helper.BulkOnboardingViewHelper;
import com.adjecti.pis.constant.OnboardingUserRole;
import com.adjecti.pis.dto.RegistrationRequestDTO;
import com.adjecti.pis.model.BulkOnbordingFile;
import com.adjecti.pis.model.RegistrationRequest;
import com.adjecti.pis.service.BulkOnbordingFileLocalServiceUtil;
import com.adjecti.pis.service.RegistrationRequestLocalServiceUtil;
import com.adjecti.pis.util.OnboardingUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.osgi.service.component.annotations.Component;

@Component
public class RegistrationRequestHandlerImpl implements RegistrationRequestHandler {

	private static Log LOGGER = LogFactoryUtil.getLog(RegistrationRequestHandlerImpl.class);
	
	@Override
	public RegistrationRequestDTO findByRequestId(long requestId) {
		try {
			return RegistrationRequestLocalServiceUtil.getRegistration(requestId);
		} catch (PortalException e) {
			LOGGER.error(e);
			return null;
		}
	}

	@Override
	public void performWorkflowAction(long requestId, String action, String remarks, long taskId, long userId)
			throws PortalException {
		
		RegistrationRequestLocalServiceUtil.performWorkFlowACtion(requestId, action, remarks, taskId, userId);

	}

	@Override
	public RegistrationRequest addRegistrationRequest(RegistrationRequestDTO registrationRequestDTO, ServiceContext serviceContext) {
		try {
			registrationRequestDTO.setErrorMessage(checkError(registrationRequestDTO));
			return RegistrationRequestLocalServiceUtil.addRegistrationRequest(registrationRequestDTO, serviceContext);
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return null;
	}

	@Override
	public void performWorkflowAction(String[] requestIds, String action, String remarks, long userId) {
		try {
			RegistrationRequestLocalServiceUtil.selectedProcessed(requestIds, action, remarks, userId);
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	@Override
	public List<RegistrationRequestDTO> findByStatus(String status) {
		try {
			return RegistrationRequestLocalServiceUtil.findByStatus(status);
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return null;
	}

	public List<RegistrationRequestDTO> findByStatusAndOnboardingId(String status, long onboardingId) {
		try {
			return RegistrationRequestLocalServiceUtil.findByStatusAndOnboardingId(status, onboardingId);
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return null;
	}

	@Override
	public int processActionAll(String actionTask, String remarks, User user) throws PortalException {
		LOGGER.info("Strat processActionAll");
		List<RegistrationRequestDTO> registrationRequestList = BulkOnboardingViewHelper
				.getRegistrationRequestList(user);
		int recordProcessed = 0;
		for (RegistrationRequestDTO registrationRequest : registrationRequestList) {
			for (String action : registrationRequest.getActions()) {
				if (actionTask.equals(action)) {
					if ((registrationRequest.getErrorMessage().isEmpty())) {
						RegistrationRequestLocalServiceUtil.performWorkFlowACtion(
								registrationRequest.getRegistrationRequestId(), action, remarks, 0, user.getUserId());
						recordProcessed++;
					}
				}

			}
		}
		LOGGER.info("Records submitted for action- " + recordProcessed);

		return recordProcessed;
	}

	@Override
	public int processActionAllById(String actionTask, String remarks, long bulkOnbordingFileId, User user)
			throws PortalException {
		LOGGER.info("Strat processActionAll");

		List<RegistrationRequestDTO> registrationRequestList = RegistrationRequestLocalServiceUtil
				.getRegistrationRequestsByOnboardingId(bulkOnbordingFileId);
		int recordProcessed = 0;
		for (RegistrationRequestDTO registrationRequest : registrationRequestList) {
			for (String action : registrationRequest.getActions()) {
				if (actionTask.equals(action)) {
					if ((registrationRequest.getErrorMessage().isEmpty())) {
						RegistrationRequestLocalServiceUtil.performWorkFlowACtion(
								registrationRequest.getRegistrationRequestId(), action, remarks, 0, user.getUserId());
						recordProcessed++;
					}
				}

			}
		}
		LOGGER.info("Records submitted for action- " + recordProcessed);

		return recordProcessed;
	}

	@Override
	public RegistrationRequest deleteRequest(long requestId) {
		try {
			return RegistrationRequestLocalServiceUtil.deleteRegistrationRequest(requestId);
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return null;
	}

	@Override
	public void deleteAll(User user, long bulkOnbordingFileId) throws PortalException {

		if (bulkOnbordingFileId > 0) {
			BulkOnboardingViewHelper.getRegistrationRequestList(user).stream()
					.filter(request -> (request.getBulkOnbordingFileId() == bulkOnbordingFileId
							&& (request.getStatus().equalsIgnoreCase("DRAFT")
									|| request.getStatus().equalsIgnoreCase("PENDING")
									|| request.getStatus().equalsIgnoreCase("Processing"))))
					.forEach(request -> {

						this.deleteRequest(request.getRegistrationRequestId());
					});
		} else {
			BulkOnboardingViewHelper.getRegistrationRequestList(user).stream()
					.filter(request -> (request.getStatus().equalsIgnoreCase("DRAFT")
							|| request.getStatus().equalsIgnoreCase("PENDING")
							|| request.getStatus().equalsIgnoreCase("Processing")))
					.forEach(request -> {

						this.deleteRequest(request.getRegistrationRequestId());
					});
		}
	}

	@Override
	public void validateAndUploadDocument(OrganizationDetail organizationDetail, List<RegistrationRecord> recordList, long fileEntryId, ServiceContext serviceContext) {
		for (RegistrationRecord record : recordList) {
			try {
				RegistrationRequestDTO registrationDto = createRegistrationRequestDTO(organizationDetail, record);
				registrationDto.setFileEntryId(fileEntryId);

				this.addRegistrationRequest(registrationDto, serviceContext);
			} catch (Exception e) {
				LOGGER.error(e);
			}
		}

	}

	@Override
	public void updateRequest(RegistrationRequestDTO registrationRequestDTO, ServiceContext serviceContext) {
		try {

			updateFields(registrationRequestDTO);
			registrationRequestDTO.setErrorMessage(checkError(registrationRequestDTO));

			RegistrationRequestLocalServiceUtil.updateRegistrationRequest(registrationRequestDTO, serviceContext);
		} catch (Exception e) {
		}
	}

	private void updateFields(RegistrationRequestDTO registrationRequestDTO) {
		LOGGER.info("registrationRequestDTO.getSectionId() - "+registrationRequestDTO.getSectionId());
		if (registrationRequestDTO.getSectionId() != 0) {
			
				OrganizationDetail section = OrganizationDetailLocalServiceUtil.getOrganizationDetailByOrganizationId(registrationRequestDTO.getSectionId());
				LOGGER.info("Section "+section);
				if(section !=null) {
					registrationRequestDTO.setSection(section.getShortName());
					registrationRequestDTO.setSectionCode(section.getOrganizationCode());
				}else {
					registrationRequestDTO.setSection(registrationRequestDTO.getSectionCode());
					registrationRequestDTO.setSectionCode(registrationRequestDTO.getSectionCode());
				}
		}
		if (registrationRequestDTO.getGenderName() != null) {
			List<Gender> genders = GenderLocalServiceUtil.getGenderByName(registrationRequestDTO.getGenderName());
			if (CollectionUtils.isNotEmpty(genders)) {
				registrationRequestDTO.setGenderName(genders.get(0).getName());
				registrationRequestDTO.setGenderId(genders.get(0).getGenderId());
			}
		}

		if (registrationRequestDTO.getGradeId() != 0) {
			try {
				Grade grade = GradeLocalServiceUtil.getGrade(registrationRequestDTO.getGradeId());
				registrationRequestDTO.setGrade(grade.getName());
				registrationRequestDTO.setGradeCode(grade.getCode());
				
			} catch (PortalException e) {
				registrationRequestDTO.setGradeId(0);
			}
		}

		if (registrationRequestDTO.getTradeId() != 0) {
			try {
				Trade trade = TradeLocalServiceUtil.getTrade(registrationRequestDTO.getTradeId());
				registrationRequestDTO.setTrade(trade.getName());
				registrationRequestDTO.setTradeCode(trade.getCode());
			}catch (PortalException e) {
				registrationRequestDTO.setTradeId(0);
			}

		}
		
		if (registrationRequestDTO.getDesignationId() != 0) {
			try {
				Designation designation = DesignationLocalServiceUtil.getDesignation(registrationRequestDTO.getDesignationId());
				registrationRequestDTO.setDesignationName(designation.getName_En());
				registrationRequestDTO.setDesignationCode(designation.getCode());
			}catch (PortalException e) {
				registrationRequestDTO.setDesignationId(0);
			}

		}

		if (registrationRequestDTO.getCastCategory() != null) {
			List<CasteCategory> castCategories = CasteCategoryLocalServiceUtil
					.getCastCategoryByName(registrationRequestDTO.getCastCategory());
			if (CollectionUtils.isNotEmpty(castCategories)) {
				registrationRequestDTO.setCastCategory(castCategories.get(0).getName());
				registrationRequestDTO.setCasteCategoryId(castCategories.get(0).getCasteCategoryId());
			}

		}

	}

	private RegistrationRequestDTO createRegistrationRequestDTO(OrganizationDetail organizationDetail, RegistrationRecord record) {
		
		RegistrationRequestDTO pisDto = new RegistrationRequestDTO();

		pisDto.setUnitId(organizationDetail.getOrganizationId());
		pisDto.setUnit(organizationDetail.getShortName());
		pisDto.setPersonalNo(record.getPersonalNo());
		pisDto.setRecordNo(record.getEmployeeNumber());
		pisDto.setFirstName(record.getFirstName());
		pisDto.setMiddleName(record.getMiddleName());
		pisDto.setLastName(record.getLastName());
		
		if (record.getGender() != null) {
			pisDto.setGenderName(record.getGender());
			List<Gender> genders = GenderLocalServiceUtil.getGenderByName(record.getGender());
			if (CollectionUtils.isNotEmpty(genders)) {
				pisDto.setGenderName(genders.get(0).getName());
				pisDto.setGenderId(genders.get(0).getGenderId());
			}
		}

		Designation designation = DesignationLocalServiceUtil.getDesignationByCode(record.getDesignation());
		if (designation != null) {
			pisDto.setDesignationName(designation.getName_En());
			pisDto.setDesignationId(designation.getDesignationId());
			pisDto.setDesignationCode(designation.getCode());
		}else {
			pisDto.setDesignationName(record.getDesignation());
			pisDto.setDesignationCode(record.getDesignation());
		}

		Trade trade = TradeLocalServiceUtil.getTradeByCode(record.getTrade());
		if (trade !=null) {
			pisDto.setTrade(trade.getName());
			pisDto.setTradeId(trade.getTradeId());
			pisDto.setTradeCode(trade.getCode());
		}else {
			pisDto.setTrade(record.getTrade());
			pisDto.setTradeCode(record.getTrade());
		}

		
		Grade grade = GradeLocalServiceUtil.getGradeByCode(record.getGrade());
		if (grade != null) {
			pisDto.setGrade(grade.getName());
			pisDto.setGradeId(grade.getGradeId());
			pisDto.setGradeCode(grade.getCode());
		}else {
			pisDto.setGrade(record.getGrade());
			pisDto.setGradeCode(record.getGrade());
		}

		pisDto.setCastCategory(record.getCastCategory());
		List<CasteCategory> castCategories = CasteCategoryLocalServiceUtil.getCastCategoryByName(record.getCastCategory());
		if (CollectionUtils.isNotEmpty(castCategories)) {
			pisDto.setCastCategory(castCategories.get(0).getName());
		}

		pisDto.setDateOfBirth(record.getDateOfBirth());
		pisDto.setDateOfJoiningOrganization(record.getDateOfJoiningUnit());

		pisDto.setMobile(record.getMobile());
		pisDto.setEmailAddress(record.getEmailId());
		pisDto.setDateOfJoiningUnit(record.getDateOfJoiningUnit());
		pisDto.setGpfnpsType(record.getGpfNpsType());
		pisDto.setGpfnpsNumber(record.getGpfNpsNumber());
		List<OrganizationDetail> sectionList = OrganizationDetailLocalServiceUtil.getOrganizationDetailByParentIdAndOrganizationCode(organizationDetail.getOrganizationId(),record.getSection());
		OrganizationDetail section = null;
		for(OrganizationDetail sec:sectionList) {
			if("Section".equalsIgnoreCase(sec.getType())) {
				section = sec;
				break;
			}
		}
		
		if(section != null) {
			pisDto.setSectionCode(record.getSection());
			pisDto.setSectionId(section.getOrganizationId());
			pisDto.setSection(section.getShortName());
		}else {
			pisDto.setSectionCode(record.getSection());
			pisDto.setSection(record.getSection());
		}

		pisDto.setPostBox(record.getPostBox());
		pisDto.setRank(record.getRank());
		
		pisDto.setIdamUser(isTrue(record.getIdamUser()));

		pisDto.setEmailAccess(isTrue(record.getEmailAccess()));

		pisDto.setDigitalSigning(isTrue(record.getDigitalSigning()));

		pisDto.seteGovAccess(isTrue(record.geteGovAccess()));

		pisDto.setPisAccess(isTrue(record.getPisAccess()));

		return pisDto;
	}

	private boolean isTrue(String str) {
		return ("true".equalsIgnoreCase(str) 
					|| "yes".equalsIgnoreCase(str) 
					|| "y".equalsIgnoreCase(str));
	}
	@Override
	public boolean isAdmin() throws PortalException {
		return RegistrationRequestLocalServiceUtil.isAdmin();
	}

	@Override
	public boolean isAdmin(User user) throws PortalException {
		return RegistrationRequestLocalServiceUtil.isAdmin();
	}

	@Override
	public boolean isUploader(User user) throws PortalException {
		return RegistrationRequestLocalServiceUtil.isCreater(user.getUserId());
	}

	@Override
	public boolean isApprover(User user) throws PortalException {
		return RegistrationRequestLocalServiceUtil.isApprover(user.getUserId());
	}
	
	public boolean isValidDesignation(RegistrationRequestDTO registrationRequestDTO) {
		String code = registrationRequestDTO.getDesignationCode();
		
		if (StringUtils.isBlank(code)) {
			return false;
		} else {
			try {
				Designation designation = DesignationLocalServiceUtil.getDesignationByCode(code);
				if (designation != null) {
					return true;
				} else {
					return false;
				}
			} catch (Exception e) {
				return false;
			}

		}
	}
	
	public boolean isValidTrade(RegistrationRequestDTO registrationRequestDTO) {
		String code = registrationRequestDTO.getTradeCode();
		
		if (StringUtils.isBlank(code)) {
			return false;
		} else
			try {
				Trade  trade = TradeLocalServiceUtil.getTradeByCode(code);
				if (trade != null) {
					return true;
				} else {
					return false;
				}
			} catch (Exception e) {
				return false;
			}

	}
	
	private boolean isValidGrade(RegistrationRequestDTO registrationRequestDTO) {
		String code = registrationRequestDTO.getGradeCode();
		
		if (StringUtils.isBlank(code)) {
			
			
			LOGGER.info("invalid entry");
			return false;
		} else {
			try {
				Grade grade = GradeLocalServiceUtil.getGradeByCode(code);
				if (grade !=null) {
					return true;
				} else {
					return false;
				}
			} catch (Exception e) {
				return false;
			}
		}
	}

	private boolean isValidGender(String genderName) {
		if (genderName == null || genderName.isEmpty()) {
			LOGGER.info("invalid entry");
			return false;
		} else {
			try {
				List<Gender> gender = GenderLocalServiceUtil.getGenderByName(genderName);
				if (!gender.isEmpty()) {
					return true;
				} else {
					return false;
				}
			} catch (Exception e) {
				return false;
			}

		}

	}


	public boolean isValidCasteCategory(String casteName) {
		if (casteName == null || casteName.isEmpty()) {
			return false;
		} else {
			try {
				List<CasteCategory> casteList = CasteCategoryLocalServiceUtil.getCastCategoryByName(casteName);
				if (CollectionUtils.isNotEmpty(casteList)) {
					return true;
				} else {
					return false;
				}
			} catch (Exception e) {
				return false;
			}

		}
	}

	public boolean isValidDateOfJoining(Date dateofBirth, Date dateOfJoining) {
		try {
			if (dateofBirth != null && dateOfJoining != null) {
			SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");

			if (dateofBirth.after(dateFormatter.parse("31-12-1925")) && dateOfJoining.after(dateofBirth)) {
				return true;
			}
			}
		} catch (ParseException e) {
			LOGGER.warn(""+e);
			return false;
		}
		return false;

	}

	public boolean isValidAgeDifference(Date dateofBirth, Date dateOfJoining) {
		try {
			if (dateofBirth != null && dateOfJoining != null) {
				LocalDate date = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(dateofBirth));
				LocalDate date1 = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(dateOfJoining));

				LocalDate birthDate = LocalDate.of(date.getYear(), date.getMonthValue(), date.getDayOfMonth());
				LocalDate joiningDate = LocalDate.of(date1.getYear(), date1.getMonthValue(), date1.getDayOfMonth());
				long yearDiff = ChronoUnit.YEARS.between(birthDate, joiningDate);
				if (yearDiff >= 14) {
					return true;
				}
			}
		} catch (Exception e) {
			LOGGER.error(e);
			return false;
		}
		return false;
	}

	public boolean isValidDateOfBirth(Date dateOfBirth) {
		if (dateOfBirth == null)
			return false;
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
		Date currentDate;
		try {
			currentDate = dateFormatter.parse(dateFormatter.format(new Date()));
			Date date = dateFormatter.parse("31-12-1925");
			if (dateOfBirth.after(date) && dateOfBirth.before(currentDate)) {
				return true;

			}

		} catch (ParseException e) {
			LOGGER.error(e);
		}

		return false;
	}

	public String checkError(RegistrationRequestDTO registrationRequestDTO) {

		String errorMessage = "";
		if (!isValidFirstName(registrationRequestDTO.getFirstName()))
			errorMessage = getConcatedMessage(errorMessage,
					"FirstName:Invalid First Name - " + registrationRequestDTO.getFirstName());

		if (!isValidLastName(registrationRequestDTO.getLastName()))
			errorMessage = getConcatedMessage(errorMessage,
					"LastName:Invalid Last Name - " + registrationRequestDTO.getLastName());

		if (!isValidMiddleName(registrationRequestDTO.getMiddleName()))
			errorMessage = getConcatedMessage(errorMessage,
					"MiddleName:Invalid Middle Name - " + registrationRequestDTO.getMiddleName());

		if(!isValidSection(registrationRequestDTO.getSectionCode(),registrationRequestDTO.getUnitId())) {
			LOGGER.info("invalid Section - "+registrationRequestDTO.getSectionCode() +" Unit id- "+registrationRequestDTO.getUnitId());
			errorMessage = getConcatedMessage(errorMessage, "Section:Invalid Section - "+registrationRequestDTO.getSection());
		}
		
		 if (!isValidEmail(registrationRequestDTO.getEmailAddress(), registrationRequestDTO.getRegistrationRequestId()))
			errorMessage = getConcatedMessage(errorMessage,
					"EmailAddress:Invalid or Duplicate EmailAddress - " + registrationRequestDTO.getEmailAddress());

		if (!isValidCasteCategory(registrationRequestDTO.getCastCategory())) {
			errorMessage = getConcatedMessage(errorMessage,
					"CasteCategory:Invalid Caste Category - " + registrationRequestDTO.getCastCategory());
		}
		
		if (!isValidGender(registrationRequestDTO.getGenderName())) {
			errorMessage = getConcatedMessage(errorMessage,
					"Gender:Invalid Gender - " + registrationRequestDTO.getGenderName());
		}
		
		if (!isValidDesignation(registrationRequestDTO)) {
			errorMessage = getConcatedMessage(errorMessage,	"Designation:Invalid Designation - " + registrationRequestDTO.getDesignationCode());
		}

		if (!isValidGrade(registrationRequestDTO)) {
			errorMessage = getConcatedMessage(errorMessage, "Grade:Invalid Grade - " + registrationRequestDTO.getGradeCode());
		}
		
		if (!isValidTrade(registrationRequestDTO)) {
			errorMessage = getConcatedMessage(errorMessage, "Trade:Invalid Trade - " + registrationRequestDTO.getTrade());
		}
		
		if (!isValidPersonalNo(registrationRequestDTO.getPersonalNo())) {
			errorMessage = getConcatedMessage(errorMessage,	"PersonalNo:Invalid Personal No - " + registrationRequestDTO.getPersonalNo());
		}
		boolean isValidDate = true;
		if (!isValidDateOfBirth(registrationRequestDTO.getDateOfBirth())) {
			errorMessage = getConcatedMessage(errorMessage, "DateOfBirth:Invalid Date Of Birth");
			isValidDate = false;
		}
		if (!isValidDateOfJoining(registrationRequestDTO.getDateOfBirth(),registrationRequestDTO.getDateOfJoiningUnit())) {
			errorMessage = getConcatedMessage(errorMessage, "DateOfJoining:Invalid Joining Date");
			isValidDate = false;
		}
		if (isValidDate && !isValidAgeDifference(registrationRequestDTO.getDateOfBirth(),registrationRequestDTO.getDateOfJoiningUnit())) {
			errorMessage = getConcatedMessage(errorMessage, "DateOfBirth:Invalid Date of Birth or Date of Joining");
		}
		if (!isValidGPFNPFType(registrationRequestDTO.getGpfnpsType())) {
			errorMessage = getConcatedMessage(errorMessage,	"GpfnpsType:Invalid GPF/NPS Type - " + registrationRequestDTO.getGpfnpsType());
		} else {
			if (!isValidGPFNPFNo(registrationRequestDTO.getGpfnpsNumber())) {
				errorMessage = getConcatedMessage(errorMessage,"GpfnpsNumber:GPF/NPS Number Should Not Be Greater than 16 Digits  - "
								+ registrationRequestDTO.getGpfnpsNumber());
			}
		}
		if (isPersonalNumberExists(registrationRequestDTO.getPersonalNo(), registrationRequestDTO.getRegistrationRequestId(), registrationRequestDTO.getUnitId())) {
			errorMessage = getConcatedMessage(errorMessage, "PersonalNo:Duplicate Personal No");
		}

		return errorMessage;

	}


	private String getConcatedMessage(String errorMessage, String validationMessage) {
		return (StringUtils.isNotBlank(errorMessage)) ? errorMessage + " # " + validationMessage
				:validationMessage;
	}

	public boolean isActionAllowed(long registrationRequestId, String action) {

		try {
			RegistrationRequestDTO dto = RegistrationRequestLocalServiceUtil.getRegistration(registrationRequestId);
			return dto.hasAction(action);
		} catch (Exception e) {

			LOGGER.info(""+e);
			return false;
		}

	}

	public boolean isValidFirstName(String firstName) {
		if (StringUtils.isBlank(firstName)) {
			return false;
		}
		
		return isValidName(firstName);//Validator.isName(firstName);
	}

	public boolean isValidMiddleName(String middleName) {
		if (StringUtils.isBlank(middleName)) {
			return true;
		} else {
			return isValidName(middleName);
		}
	}

	public boolean isValidLastName(String lastName) {
		if (StringUtils.isBlank(lastName)) {
			return true;
		} else {
			return isValidName(lastName);
		}
	}
	
	private boolean isValidName(String str) {
		String regx = "^[A-Za-z\\s]+$";//"^[A-Za-z\\s]+$";
		Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str);
		return matcher.find();
	}
	public boolean isValidUnit(String unit) {
		return Validator.isAlphanumericName(unit);
	}

	public boolean isValidSection(String sectionCode, long unitId) {
			
		List<OrganizationDetail> sectionList = OrganizationDetailLocalServiceUtil.getOrganizationDetailByParentIdAndOrganizationCode(unitId,sectionCode);
			for(OrganizationDetail sec:sectionList) {
				if("Section".equalsIgnoreCase(sec.getType())) {
					return true;
				}
			}
			return false;
	}

	public boolean isValidEmail(String emailAddress, long requestId) {
		if(StringUtils.isBlank(emailAddress))
			return true;
		
		if (Validator.isEmailAddress(emailAddress)) {
			return true;
		}
		return false;
	}

	public boolean isValidPersonalNo(Long personalNo) {
		if (personalNo > 0)
			return true;
		else
			return false;
	}

	public boolean isValidGPFNPFNo(long gpfNpfNo) {
		if (gpfNpfNo > 0) {
			long length = (long) (Math.log10(gpfNpfNo) + 1);
			if (length <= 16)
				return true;
			else
				return false;
		} else
			return true;
	}

	public boolean isValidGPFNPFType(String gpfnpsType) {
		if (gpfnpsType != null)
			if ("GPF".equalsIgnoreCase(gpfnpsType) || "NPS".equalsIgnoreCase(gpfnpsType))
				return true;
			else
				return false;
		else
			return false;
	}
	
	@Override
	public boolean canUploadUnitData(long userId, long unitId) throws PortalException {
		Organization unit =  OrganizationLocalServiceUtil.getOrganization(unitId);
		if ( OnboardingUtil.hasRoleInUnit(userId, unit, OnboardingUserRole.valueOf(OnboardingUserRole.ADMIN_ROLE))) {
			return true;
		}else if ( OnboardingUtil.hasRoleInUnit(userId, unit, OnboardingUserRole.valueOf(OnboardingUserRole.CREATER_ROLE))) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean validateDocumentForOrg(long userId, Set<String> organizationList) throws PortalException {
		List<Role> roleList = UserLocalServiceUtil.getUser(userId).getRoles();
		List<Organization> orgList = new ArrayList<Organization>();
		if (roleList.stream().anyMatch(
				role -> role.getName().equalsIgnoreCase(OnboardingUserRole.valueOf(OnboardingUserRole.ADMIN_ROLE)))) {

			orgList.addAll(OrganizationLocalServiceUtil.getOrganizations(QueryUtil.ALL_POS, QueryUtil.ALL_POS));
		} else {
			orgList.addAll(
					OrganizationLocalServiceUtil.getOrganizations(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null));
			List<Organization> subOrgs = OrganizationLocalServiceUtil.getSuborganizations(orgList);
			orgList.addAll(subOrgs);
		}

		for (String organizationName : organizationList) {
			if (!orgList.stream().anyMatch(org -> org.getName().equalsIgnoreCase(organizationName)))
				return false;
		}
		return true;
	}
	
	private int countDigit(long n){
		return (int)Math.floor(Math.log10(n) + 1);
	}
	
	@Override
	public boolean validateRecordList(List<RegistrationRecord> recordList) {
		try {
			for(RegistrationRecord registrationRecord : recordList) {
				
				if(registrationRecord.getFirstName().length()>75) {
					LOGGER.info("Character length issue- registrationRecord.getFirstName()-"+registrationRecord.getFirstName());
					return false;
				}
				if(countDigit(registrationRecord.getPersonalNo()) >16) {
					LOGGER.info("Character length issue- registrationRecord.getPersonalNo()-"+registrationRecord.getPersonalNo());
					return false;
				}
				
				if(countDigit(registrationRecord.getMobile()) > 10) {
					LOGGER.info("Character length issue- registrationRecord.getMobile()-"+registrationRecord.getMobile());
					return false;
				}
				if(countDigit(registrationRecord.getGpfNpsNumber()) > 16) {
					LOGGER.info("Character length issue- registrationRecord.getGpfNpsNumber()-"+registrationRecord.getGpfNpsNumber());
					return false;
				}
			}
		}catch (Exception e) {
			return false;
		}
		return true;
		
	}
	@Override
	public boolean	validateRequiredRecordField(List<RegistrationRecord> recordList) {
          for(RegistrationRecord registrationRecord : recordList) {
			
			if(!StringUtils.isNotEmpty(registrationRecord.getFirstName())) {
				return false;
			}
			LOGGER.info(Long.toString(registrationRecord.getPersonalNo()));
			if(registrationRecord.getPersonalNo()==0) {
				return false;
			}
			if(!StringUtils.isNotEmpty(registrationRecord.getGender())) {
				return false;
			}
			if(!StringUtils.isNotEmpty(registrationRecord.getDesignation())) {
				return false;
			}
			
			if( registrationRecord.getDateOfBirth()==null) {
				LOGGER.info("inside date");
				return false;
			}
			if(! StringUtils.isNotEmpty(registrationRecord.getGpfNpsType()) ){
				return false;
			}
			if( !StringUtils.isNotEmpty(registrationRecord.getCastCategory()) ) {
				return false;
			}
			
		}
		return true;
		
	}

	public boolean isPersonalNumberExists(long personalnumber, long requestId, long unitId) {
		return RegistrationRequestLocalServiceUtil.isPersonalNumberExists(personalnumber, requestId, unitId);
	}

	@Override
	public BulkOnbordingFile saveFileDetails(long unitId, long fileEntryId, String fileName, String title,
			String remark, int size) {
		try {
			BulkOnbordingFile bulkOnbordingFile = BulkOnbordingFileLocalServiceUtil
					.createBulkOnbordingFile(CounterLocalServiceUtil.increment());
			ServiceContext context = ServiceContextThreadLocal.getServiceContext();
			User user = UserLocalServiceUtil.getUser(context.getUserId());
			bulkOnbordingFile.setUnitId(unitId);
			bulkOnbordingFile.setFileEntryId(fileEntryId);
			bulkOnbordingFile.setFileName(fileName);
			bulkOnbordingFile.setRemarks(remark);
			bulkOnbordingFile.setTitle(title);
			bulkOnbordingFile.setTotalRecords((long) size);
			bulkOnbordingFile.setUserId(context.getUserId());
			bulkOnbordingFile.setUserName(user.getFullName());
			return BulkOnbordingFileLocalServiceUtil.addBulkOnbordingFile(bulkOnbordingFile);

		} catch (Exception e) {
			LOGGER.info("issue while saving file");
			LOGGER.error(""+e);
			return null;
		}
	}

	@Override
	public Organization getOrganizationByName(String orgName) throws PortalException {
		ServiceContext context = ServiceContextThreadLocal.getServiceContext();
		return OrganizationLocalServiceUtil.getOrganization(context.getCompanyId(), orgName);
	}

	@Override
	public boolean validateFieldLength(String fieldName, int fieldLenght) {
		
	   if(fieldName !=null && (fieldName.length() > fieldLenght)) {
		   return false;
	   }
		return true;
	}

}
