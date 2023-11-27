/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.adjecti.pis.service;

import com.adjecti.pis.dto.RegistrationRequestDTO;
import com.adjecti.pis.dto.RegistrationRequestSearchParameter;
import com.adjecti.pis.exception.NoSuchRegistrationRequestException;
import com.adjecti.pis.liferay.model.Employee;
import com.adjecti.pis.model.RegistrationRequest;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for RegistrationRequest. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see RegistrationRequestLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface RegistrationRequestLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.adjecti.pis.service.impl.RegistrationRequestLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the registration request local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link RegistrationRequestLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the registration request to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RegistrationRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param registrationRequest the registration request
	 * @return the registration request that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public RegistrationRequest addRegistrationRequest(
		RegistrationRequest registrationRequest);

	@Indexable(type = IndexableType.REINDEX)
	public RegistrationRequest addRegistrationRequest(
			RegistrationRequestDTO registrationRequestDto,
			ServiceContext serviceContext)
		throws PortalException;

	public boolean afterUpdateRegistrationRequest(
		RegistrationRequest entity, Map<String, String[]> paramMap);

	public boolean beforeUpdateRegistrationRequest(
		Object entity, Map<String, String[]> paramMap);

	public void confirmRegistration(Map<String, Serializable> workflowContext);

	public User createAppUser(long requestId, long employeeId);

	public Employee createEmployee(long requestId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new registration request with the primary key. Does not add the registration request to the database.
	 *
	 * @param registrationRequestId the primary key for the new registration request
	 * @return the new registration request
	 */
	@Transactional(enabled = false)
	public RegistrationRequest createRegistrationRequest(
		long registrationRequestId);

	public String createUser(long registrationRequestId);

	public String createUser(RegistrationRequest record);

	public String createUserWithPermission(
			long registrationRequestId, boolean emailAccess,
			boolean digitalSigning, boolean eGovAccess, boolean pisAccess)
		throws NoSuchRegistrationRequestException;

	public Map<String, List<String>> deduplicateLoginIds(
		String duplicateLoginIds);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the registration request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RegistrationRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param registrationRequestId the primary key of the registration request
	 * @return the registration request that was removed
	 * @throws PortalException if a registration request with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public RegistrationRequest deleteRegistrationRequest(
			long registrationRequestId)
		throws PortalException;

	/**
	 * Deletes the registration request from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RegistrationRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param registrationRequest the registration request
	 * @return the registration request that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public RegistrationRequest deleteRegistrationRequest(
		RegistrationRequest registrationRequest);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.model.impl.RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.model.impl.RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	public List<RegistrationRequestDTO> entityToDto(
			List<RegistrationRequest> requestList, long userId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public RegistrationRequest fetchRegistrationRequest(
		long registrationRequestId);

	/**
	 * Returns the registration request matching the UUID and group.
	 *
	 * @param uuid the registration request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public RegistrationRequest fetchRegistrationRequestByUuidAndGroupId(
		String uuid, long groupId);

	public List<RegistrationRequestDTO> findBySearchParameter(
			RegistrationRequestSearchParameter
				registrationRequestSearchParameter)
		throws PortalException;

	public List<RegistrationRequestDTO> findBySearchParameter(
			User user,
			RegistrationRequestSearchParameter
				registrationRequestSearchParameter)
		throws PortalException;

	public List<RegistrationRequestDTO> findByStatus(String status)
		throws PortalException;

	public List<RegistrationRequestDTO> findByStatusAndOnboardingId(
			String status, long bulkOnbordingFileId)
		throws PortalException;

	public List<RegistrationRequestDTO> findByUnitId(long unitId)
		throws PortalException;

	public List<RegistrationRequest> findByUnitIdsAndStatusList(
			long[] unitIds, int[] statuses)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RegistrationRequestDTO> getAllRegistrations()
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RegistrationRequestDTO> getAllRegistrations(User user)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public RegistrationRequestDTO getRegistration(long registrationRequestId)
		throws PortalException;

	/**
	 * Returns the registration request with the primary key.
	 *
	 * @param registrationRequestId the primary key of the registration request
	 * @return the registration request
	 * @throws PortalException if a registration request with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public RegistrationRequest getRegistrationRequest(
			long registrationRequestId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public RegistrationRequest getRegistrationRequestById(
			long registrationRequestId)
		throws NoSuchRegistrationRequestException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public RegistrationRequest getRegistrationRequestByPersonalNo(
		Long personalNo);

	/**
	 * Returns the registration request matching the UUID and group.
	 *
	 * @param uuid the registration request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching registration request
	 * @throws PortalException if a matching registration request could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public RegistrationRequest getRegistrationRequestByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the registration requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.model.impl.RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of registration requests
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RegistrationRequest> getRegistrationRequests(
		int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RegistrationRequest> getRegistrationRequests(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RegistrationRequest> getRegistrationRequests(
			long groupId, int status)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RegistrationRequest> getRegistrationRequests(
		long groupId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RegistrationRequest> getRegistrationRequests(
		long groupId, int start, int end,
		OrderByComparator<RegistrationRequest> obc);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RegistrationRequestDTO> getRegistrationRequestsByOnboardingId(
			long bulkOnbordingFileId)
		throws PortalException;

	/**
	 * Returns all the registration requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the registration requests
	 * @param companyId the primary key of the company
	 * @return the matching registration requests, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RegistrationRequest> getRegistrationRequestsByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of registration requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the registration requests
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching registration requests, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RegistrationRequest> getRegistrationRequestsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator);

	/**
	 * Returns the number of registration requests.
	 *
	 * @return the number of registration requests
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getRegistrationRequestsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getRegistrationRequestsCount(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RegistrationRequestDTO> getRegistrationsByStatus(String status)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getTotalApprovalPendingCount(long bulkOnbordingFileId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getTotalApprovedCount(long bulkOnbordingFileId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getTotalCount(long bulkOnbordingFileId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTotalCountByUnit(String unit);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTotalCountByUnitAndStatus(String unit, int status);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getTotalDraftCount(long bulkOnbordingFileId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getTotalIncompleteCount(long bulkOnbordingFileId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getTotalPendingCount(long bulkOnbordingFileId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getTotalRejectedCount(long bulkOnbordingFileId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasOwnerRole(long userId, long companyId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isActionCompleted(RegistrationRequest registration);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isActiontaken(RegistrationRequest registration, long userId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isAdmin() throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isAdmin(long userId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isApprover(long userId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isAssignableOrCompleted(
		RegistrationRequest registration, long userId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isCreater(long userId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isEmailAddressExists(String emailAddress, long requestId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isPersonalNumberExists(
		long personalnumber, long requestId, long unitId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isRecordNumberExists(long recordNo, long requestId);

	public void performWorkFlowACtion(
			long pisId, String action, String remarks, long workflowTaskId,
			long userId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RegistrationRequest> searchRegistrationRequests(
		Map<String, String> searchFilter);

	public void selectedProcessed(
			String[] requestIds, String action, String remarks, long userId)
		throws PortalException;

	/**
	 * Updates the registration request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RegistrationRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param registrationRequest the registration request
	 * @return the registration request that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public RegistrationRequest updateRegistrationRequest(
		RegistrationRequest registrationRequest);

	@Indexable(type = IndexableType.REINDEX)
	public RegistrationRequest updateRegistrationRequest(
			RegistrationRequestDTO requestDto, ServiceContext serviceContext)
		throws PortalException, SystemException;

	public RegistrationRequest updateStatus(
			long userId, long requestId, int status,
			ServiceContext serviceContext)
		throws PortalException, SystemException;

}