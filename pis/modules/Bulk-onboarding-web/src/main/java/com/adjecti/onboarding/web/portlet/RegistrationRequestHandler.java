package com.adjecti.onboarding.web.portlet;

import com.adjecti.mdm.liferay.model.OrganizationDetail;
import com.adjecti.onboarding.web.dto.RegistrationRecord;
import com.adjecti.pis.dto.RegistrationRequestDTO;
import com.adjecti.pis.model.BulkOnbordingFile;
import com.adjecti.pis.model.RegistrationRequest;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.List;
import java.util.Set;

public interface RegistrationRequestHandler {

	
	public void performWorkflowAction(long requestId, String action, String remarks, long taskId, long userId) throws PortalException;

	public void performWorkflowAction(String[] requestIds, String action, String remarks, long userId);

	public RegistrationRequest addRegistrationRequest(RegistrationRequestDTO registrationRequestDTO, ServiceContext serviceContext);

	public void deleteAll(User user, long bulkOnbordingFileId) throws PortalException;

	public RegistrationRequest deleteRequest(long requestId);

	public List<RegistrationRequestDTO> findByStatus(String status);
	public List<RegistrationRequestDTO> findByStatusAndOnboardingId(String status, long onboardingId);
	public boolean isAdmin() throws PortalException;

	public void validateAndUploadDocument(OrganizationDetail organizationDetail, List<RegistrationRecord> recordList, long fileEntryId, ServiceContext serviceContext);

	public void updateRequest(RegistrationRequestDTO registrationRequestDTO, ServiceContext serviceContext);

	public int processActionAll(String action, String remarks, User user) throws PortalException;
	
	public int processActionAllById(String action, String remarks, long bulkOnbordingFileId, User user)throws PortalException;

	public RegistrationRequestDTO findByRequestId(long requestId);

	public boolean canUploadUnitData(long userId, long unitId) throws PortalException;
	
	public boolean validateDocumentForOrg(long userId, Set<String> orgList) throws PortalException;
	
	public boolean validateRecordList(List<RegistrationRecord> recordList);
	public boolean validateRequiredRecordField(List<RegistrationRecord> recordList);
	
	public boolean validateFieldLength(String fieldName,int fieldLenght);

	public boolean isPersonalNumberExists(long personalnumber, long requestId, long unitId);

	public BulkOnbordingFile saveFileDetails(long unitId, long fileEntryId, String name, String title, String remark, int size);

	public boolean isUploader(User user)throws PortalException;

	public boolean isApprover(User user)throws PortalException;

	public boolean isAdmin(User user) throws PortalException;

	public Organization getOrganizationByName(String string) throws PortalException;

	
}
