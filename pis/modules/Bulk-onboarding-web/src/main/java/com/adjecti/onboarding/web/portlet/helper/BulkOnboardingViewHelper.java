package com.adjecti.onboarding.web.portlet.helper;

import com.adjecti.onboarding.web.dto.BulkOnboardingRecordDTO;
import com.adjecti.onboarding.web.dto.UnitOnboardingSummary;
import com.adjecti.pis.dto.RegistrationRequestDTO;
import com.adjecti.pis.dto.RegistrationRequestSearchParameter;
import com.adjecti.pis.model.BulkOnbordingFile;
import com.adjecti.pis.model.RegistrationRequest;
import com.adjecti.pis.service.BulkOnbordingFileLocalServiceUtil;
import com.adjecti.pis.service.RegistrationRequestLocalServiceUtil;
import com.adjecti.pis.util.OnboardingUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

public class BulkOnboardingViewHelper {
	
	private static Log LOGGER = LogFactoryUtil.getLog(BulkOnboardingViewHelper.class);

	public static List<RegistrationRequestDTO> getRegistrationRequestList(User user) throws PortalException {
		return RegistrationRequestLocalServiceUtil.getAllRegistrations();
	}
	
	public static List<RegistrationRequestDTO> getRegistrationRequestList(User user, RegistrationRequestSearchParameter registrationRequestSearchParameter) throws PortalException {
		return RegistrationRequestLocalServiceUtil.findBySearchParameter(user, registrationRequestSearchParameter);
	}
	
	
	public static List<RegistrationRequestDTO> getRegistrationRequestsByOnboardingId(long bulkOnbordingFileId) throws PortalException {
		return RegistrationRequestLocalServiceUtil.getRegistrationRequestsByOnboardingId(bulkOnbordingFileId);
	}
	
	public static List<String> getRecordsViewStates(User user){
		
		List<String> approverStates = new ArrayList<String>(Arrays.asList(new String[]{"APPROVED","REJECTED","APPROVAL PENDING"}));
		
		List<String> uploaderStates = new ArrayList<String>(Arrays.asList(new String[]{"PENDING","APPROVED","REJECTED","APPROVAL PENDING"}));
		
		List<String> adminStates = new ArrayList<String>(Arrays.asList(new String[]{"PENDING","APPROVED"}));
		
		List<String> states = new ArrayList<String>();
		
		try {
			if(OnboardingUtil.isAdmin(user.getUserId())) {
				states = adminStates;
			}else if(OnboardingUtil.isUploader(user.getUserId())) {
				states = uploaderStates;
			}else if(OnboardingUtil.isApprover(user.getUserId())) {
				states = approverStates;
			}
		}catch (PortalException e) {
			LOGGER.error("Error - "+e.getMessage());
		}
		
		return states;
	}
	
	public static List<String> getAllowedActions(User user){
		
		List<String> approverActions = new ArrayList<String>(Arrays.asList(new String[]{"Approve","Reject"}));
		
		List<String> uploaderActions = new ArrayList<String>(Arrays.asList(new String[]{"Submit"}));
		
		List<String> adminActions = new ArrayList<String>(Arrays.asList(new String[]{"Confirm"}));
		
		List<String> actions = new ArrayList<String>();
		
		try {
			if(OnboardingUtil.isAdmin(user.getUserId())) {
				actions = adminActions;
			}else if(OnboardingUtil.isUploader(user.getUserId())) {
				actions = uploaderActions;
			}else if(OnboardingUtil.isApprover(user.getUserId())) {
				actions = approverActions;
			}
		}catch (PortalException e) {
			LOGGER.error("Error - "+e.getMessage());
		}
		
		return actions;
		
	}	
	
	public static  List<RegistrationRequestDTO> getPendingApprovalList(User user){
		int[] statusList = {WorkflowConstants.STATUS_SCHEDULED};
		long[] unitIds = null;
		
		List<RegistrationRequestDTO> requestDtoList = new ArrayList<RegistrationRequestDTO>();
		
		try {
			List<Organization> orgList = OnboardingUtil.getUnitByRoles(user.getUserId());
			unitIds = orgList.stream().mapToLong(org -> org.getOrganizationId()).toArray();
			
			List<RegistrationRequest> requestList = RegistrationRequestLocalServiceUtil.findByUnitIdsAndStatusList(unitIds, statusList );
			
			for(RegistrationRequest request:requestList) {
				requestDtoList.add(entityToDto(request));
			}
			
		} catch (PortalException e) {
			LOGGER.error(e);
		}
		
		
		return requestDtoList;
	}
	
	public static List<BulkOnboardingRecordDTO> getBulkOnboardingRecords() throws PortalException {
		List<BulkOnboardingRecordDTO> bulkOnboardingList = new ArrayList<BulkOnboardingRecordDTO>();
		List<BulkOnbordingFile> bulkOnbordingFiles = BulkOnbordingFileLocalServiceUtil
				.getBulkOnbordingFiles(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		LOGGER.info("no of records"+bulkOnbordingFiles.size() );

		for (BulkOnbordingFile bulkOnbordingFile : bulkOnbordingFiles) {
			BulkOnboardingRecordDTO bulkOnboardingDTO = getBulkOnboardingDTO(bulkOnbordingFile);
			bulkOnboardingList.add(bulkOnboardingDTO);

		}

		return bulkOnboardingList;

	}

	public  static List<BulkOnboardingRecordDTO> getBulkOnboardingRecordsByUserId(long userId) throws PortalException {
		List<BulkOnboardingRecordDTO> bulkOnboardingList = new ArrayList<BulkOnboardingRecordDTO>();
		List<BulkOnbordingFile> bulkOnbordingFiles=BulkOnbordingFileLocalServiceUtil.getBulkOnboardingRecordsByUserId(userId);
		
		for (BulkOnbordingFile bulkOnbordingFile : bulkOnbordingFiles) {
			BulkOnboardingRecordDTO bulkOnboardingDTO = getBulkOnboardingDTO(bulkOnbordingFile);
			bulkOnboardingList.add(bulkOnboardingDTO);

		}
		return bulkOnboardingList;
		
	}
	
	public static List<BulkOnboardingRecordDTO> getBulkOnboardingRecordsByUnitId(long userId, long unitId) throws PortalException {
		List<BulkOnboardingRecordDTO> bulkOnboardingList = new ArrayList<BulkOnboardingRecordDTO>();
		List<BulkOnbordingFile> bulkOnbordingFiles=BulkOnbordingFileLocalServiceUtil.getBulkOnboardingRecords(userId,unitId);
		
		for (BulkOnbordingFile bulkOnbordingFile : bulkOnbordingFiles) {
			BulkOnboardingRecordDTO bulkOnboardingDTO = getBulkOnboardingDTO(bulkOnbordingFile);
			bulkOnboardingList.add(bulkOnboardingDTO);
		}
		return bulkOnboardingList;
		
	}
	
	public static List<UnitOnboardingSummary> getOnboardingSummary(long userId) throws PortalException {
		List<UnitOnboardingSummary> bulkOnboardingList = new ArrayList<UnitOnboardingSummary>();
		
		List<Organization> unitList = getUnits();
		
		for(Organization unit : unitList) {
			
			UnitOnboardingSummary unitOnboardingSummary = new UnitOnboardingSummary();
			
			
			unitOnboardingSummary.setUnitId(unit.getOrganizationId());
			unitOnboardingSummary.setUnitName(unit.getName());
			
			unitOnboardingSummary.setTotalUploads(BulkOnbordingFileLocalServiceUtil.getBulkOnbordingFilesCount(unit.getOrganizationId()));
			
			int totalUploadedRecords = BulkOnbordingFileLocalServiceUtil.getUploadedRecordsCount(unit.getOrganizationId());
			int totalAvailableRecords = RegistrationRequestLocalServiceUtil.getTotalCountByUnit(unit.getName());
			
			unitOnboardingSummary.setTotalRecords(totalUploadedRecords);
			
			unitOnboardingSummary.setTotalDeletedRecords(totalUploadedRecords-totalAvailableRecords);
			
			unitOnboardingSummary.setTotalApprovedRecords(RegistrationRequestLocalServiceUtil.getTotalCountByUnitAndStatus(unit.getName(), WorkflowConstants.STATUS_APPROVED));		
			
			int pendingCount = RegistrationRequestLocalServiceUtil.getTotalCountByUnitAndStatus(unit.getName(), WorkflowConstants.STATUS_DRAFT)
					+ RegistrationRequestLocalServiceUtil.getTotalCountByUnitAndStatus(unit.getName(), WorkflowConstants.STATUS_PENDING)
					+ RegistrationRequestLocalServiceUtil.getTotalCountByUnitAndStatus(unit.getName(), WorkflowConstants.STATUS_SCHEDULED)
					+RegistrationRequestLocalServiceUtil.getTotalCountByUnitAndStatus(unit.getName(), WorkflowConstants.STATUS_INCOMPLETE);
			
			unitOnboardingSummary.setTotalPendingRecords(pendingCount);
			
			unitOnboardingSummary.setTotalRejectedRecords(RegistrationRequestLocalServiceUtil.getTotalCountByUnitAndStatus(unit.getName(), WorkflowConstants.STATUS_DENIED));
			
			bulkOnboardingList.add(unitOnboardingSummary);
		}
		
		return bulkOnboardingList;
		
	}
	
	private static List<Organization> getUnits() {
		
		List<Organization> unitList = OrganizationLocalServiceUtil.getOrganizations(QueryUtil.ALL_POS, QueryUtil.ALL_POS)
										.stream()
										.filter(org->org.getType().equalsIgnoreCase("unit"))
										.map(unit->unit).collect(Collectors.toList());
		return unitList;
	}

	private static BulkOnboardingRecordDTO getBulkOnboardingDTO(BulkOnbordingFile bulkOnbordingFile)
			throws SystemException, PortalException {
		BulkOnboardingRecordDTO bulkOnboardingRecordDTO = new BulkOnboardingRecordDTO();
		bulkOnboardingRecordDTO.setUserId(bulkOnbordingFile.getUserId());
		bulkOnboardingRecordDTO.setOnboardingId(bulkOnbordingFile.getBulkOnbordingFileId());
		bulkOnboardingRecordDTO.setUnitId(bulkOnbordingFile.getUnitId());
		bulkOnboardingRecordDTO.setFileEntryId(bulkOnbordingFile.getFileEntryId());
		bulkOnboardingRecordDTO.setFileName(bulkOnbordingFile.getFileName());
		bulkOnboardingRecordDTO.setRemarks(bulkOnbordingFile.getRemarks());
		bulkOnboardingRecordDTO.setTittle(bulkOnbordingFile.getTitle());
		bulkOnboardingRecordDTO.setUserName(bulkOnbordingFile.getUserName());
		
		bulkOnboardingRecordDTO.setCreateDate(bulkOnbordingFile.getCreateDate());
		
		long totalRecords=bulkOnbordingFile.getTotalRecords();
		bulkOnboardingRecordDTO.setTotalRecords(totalRecords);
		
		long existingRecords=RegistrationRequestLocalServiceUtil.getTotalCount(bulkOnbordingFile.getBulkOnbordingFileId());
		long deletedCount = totalRecords-existingRecords;
		
		bulkOnboardingRecordDTO.setTotalDeletedRecords(deletedCount);
		
		long approvedCount = RegistrationRequestLocalServiceUtil.getTotalApprovedCount(bulkOnbordingFile.getBulkOnbordingFileId());
		bulkOnboardingRecordDTO.setTotalApprovedRecords(approvedCount);
        
		long pendingCount=RegistrationRequestLocalServiceUtil.getTotalPendingCount(bulkOnbordingFile.getBulkOnbordingFileId());
		long draftCount=RegistrationRequestLocalServiceUtil.getTotalDraftCount(bulkOnbordingFile.getBulkOnbordingFileId());
		
		long approvalPendingCount=RegistrationRequestLocalServiceUtil.getTotalApprovalPendingCount(bulkOnbordingFile.getBulkOnbordingFileId());
		
		long incompleteCount=RegistrationRequestLocalServiceUtil.getTotalIncompleteCount(bulkOnbordingFile.getBulkOnbordingFileId());
		
		bulkOnboardingRecordDTO.setTotalPendingRecords(pendingCount+draftCount+approvalPendingCount+incompleteCount);
		
		long rejectedCount=RegistrationRequestLocalServiceUtil.getTotalRejectedCount(bulkOnbordingFile.getBulkOnbordingFileId());
		bulkOnboardingRecordDTO.setTotalRejectedRecords(rejectedCount);
		
		return bulkOnboardingRecordDTO;
	}

	public static long totalRecordsCount(List<BulkOnboardingRecordDTO> bulkOnboardingRecords) {
		return bulkOnboardingRecords.stream().mapToLong(x -> x.getTotalRecords()).sum();
	}
	
	public static long totalApprovedCount(List<BulkOnboardingRecordDTO> bulkOnboardingRecords) {
		return bulkOnboardingRecords.stream().mapToLong(x -> x.getTotalApprovedRecords()).sum();
	}
	
	public static long totalRejectedCount(List<BulkOnboardingRecordDTO> bulkOnboardingRecords) {
		return bulkOnboardingRecords.stream().mapToLong(x -> x.getTotalRejectedRecords()).sum();
	}
	
	public static long totalPendingCount(List<BulkOnboardingRecordDTO> bulkOnboardingRecords) {
		return  bulkOnboardingRecords.stream().mapToLong(x -> x.getTotalPendingRecords()).sum();
	}
	
	public static long totalDeletedCount(List<BulkOnboardingRecordDTO> bulkOnboardingRecords) {
		return  bulkOnboardingRecords.stream().mapToLong(x -> x.getTotalDeletedRecords()).sum();
	}
	
	private static RegistrationRequestDTO entityToDto(RegistrationRequest request) throws PortalException {

		RegistrationRequestDTO requestDto = new RegistrationRequestDTO();

		requestDto.setRegistrationRequestId(request.getRegistrationRequestId());
		requestDto.setUnitId(request.getUnitId());
		requestDto.setUnit(request.getUnit());
		requestDto.setRecordNo(request.getRecordNo());
		requestDto.setPersonalNo(request.getPersonalNo());
		requestDto.setFirstName(request.getFirstName());
		requestDto.setMiddleName(request.getMiddleName());
		requestDto.setLastName(request.getLastName());
		requestDto.setGenderId(request.getGenderId());
		requestDto.setDesignationName(request.getDesignation());
		requestDto.setDesignationId(request.getDesignationId());
		requestDto.setTradeId(request.getTradeId());
		requestDto.setTrade(request.getTrade());
		requestDto.setGradeId(request.getGradeId());
		requestDto.setGrade(request.getGrade());
		requestDto.setDateOfBirth(request.getDateOfBirth());
		requestDto.setDateOfJoiningOrganization(request.getDateOfJoiningOrganization());
		requestDto.setCasteCategoryId(request.getCasteCategoryId());
		requestDto.setCastCategory(request.getCasteCategory());
		requestDto.setMobile(request.getMobile());
		requestDto.setEmailAddress(request.getEmailAddress());
		requestDto.setDateOfJoiningUnit(request.getDateOfJoiningUnit());
		requestDto.setGpfnpsType(request.getGpfnpsType());
		requestDto.setGpfnpsNumber(request.getGpfnpsNumber());
		requestDto.setSection(request.getSection());
		requestDto.setLoginId(request.getLoginId());
		requestDto.setBulkOnbordingFileId(request.getBulkOnbordingFileId());
		requestDto.setModifiedDate(request.getModifiedDate());
		requestDto.setIdamUser(request.getIdamUser());
		requestDto.setDigitalSigning(request.getDigitalSigning());
		requestDto.setEmailAccess(request.getEmailAccess());
		requestDto.seteGovAccess(request.getEGovAccess());
		requestDto.setPisAccess(request.getPisAccess());

		requestDto.setStatus(request.getStatus());
		requestDto.setErrorMessage(request.getErrorMessage());

		return requestDto;
	}
	public List<RegistrationRequestDTO> findBySearch(RegistrationRequestSearchParameter registrationRequestSearchParameter) throws PortalException{
		return RegistrationRequestLocalServiceUtil.findBySearchParameter(registrationRequestSearchParameter);
	}
	
	public static RegistrationRequestSearchParameter getSearchParameter(HttpServletRequest request) {
		
		RegistrationRequestSearchParameter searchParam = new RegistrationRequestSearchParameter();
		long currentOrganization = ParamUtil.getLong(request, "currentOrganization");
		long designation = ParamUtil.getLong(request, "designation");
		long grade = ParamUtil.getLong(request, "grade");
		long trade =  ParamUtil.getLong(request, "trade");
		String status = ParamUtil.getString(request, "status");
		long bulkOnbordingFileId = ParamUtil.getLong(request, "bulkOnbordingFileId");
				
		if(currentOrganization>0)
			searchParam.setUnitIds(new long []{currentOrganization});
		
		searchParam.setBulkOnbordingFileId(bulkOnbordingFileId);
		searchParam.setDesignationId(designation);
		searchParam.setGradeId(grade);
		searchParam.setTradeId(trade);
		searchParam.setTargetAction( ParamUtil.getString(request, "targetAction"));
		String targetAction = ParamUtil.getString(request, "targetAction");
		searchParam.setStatuses(getStatuses(status,targetAction));
		searchParam.setExcludeInvalid(StringUtils.isNotBlank(targetAction));
		
		return searchParam;
	}

	private static int [] getStatuses(String status, String targetAction) {
		LOGGER.info("targetAction - "+targetAction);
		if(StringUtils.isNotBlank(targetAction)) {
			if("Approve".equalsIgnoreCase(targetAction))
				return new int[] {WorkflowConstants.STATUS_SCHEDULED};
			else if("Reject".equalsIgnoreCase(targetAction)) 
					return new int[] {WorkflowConstants.STATUS_SCHEDULED};
			else if ("Confirm".equalsIgnoreCase(targetAction))
				return new int[] {WorkflowConstants.STATUS_PENDING};
			else if ("Submit".equalsIgnoreCase(targetAction))
				return new int[] {WorkflowConstants.STATUS_PENDING};
		}else if(StringUtils.isNotBlank(status)) {
			if("PENDING".equalsIgnoreCase(status))
					return new int[] {WorkflowConstants.STATUS_DRAFT,WorkflowConstants.STATUS_INCOMPLETE,WorkflowConstants.STATUS_PENDING};
			else if("APPROVED".equalsIgnoreCase(status)) 
					return new int[] {WorkflowConstants.STATUS_APPROVED};
			else if ("REJECTED".equalsIgnoreCase(status))
				return new int[] {WorkflowConstants.STATUS_DENIED};
			else if ("APPROVAL PENDING".equalsIgnoreCase(status))
				return new int[] {WorkflowConstants.STATUS_SCHEDULED};
		}
		
		return null;
	}
	

}
