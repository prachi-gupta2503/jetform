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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RegistrationRequestLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see RegistrationRequestLocalService
 * @generated
 */
public class RegistrationRequestLocalServiceWrapper
	implements RegistrationRequestLocalService,
			   ServiceWrapper<RegistrationRequestLocalService> {

	public RegistrationRequestLocalServiceWrapper(
		RegistrationRequestLocalService registrationRequestLocalService) {

		_registrationRequestLocalService = registrationRequestLocalService;
	}

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
	@Override
	public com.adjecti.pis.model.RegistrationRequest addRegistrationRequest(
		com.adjecti.pis.model.RegistrationRequest registrationRequest) {

		return _registrationRequestLocalService.addRegistrationRequest(
			registrationRequest);
	}

	@Override
	public com.adjecti.pis.model.RegistrationRequest addRegistrationRequest(
			com.adjecti.pis.dto.RegistrationRequestDTO registrationRequestDto,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registrationRequestLocalService.addRegistrationRequest(
			registrationRequestDto, serviceContext);
	}

	@Override
	public boolean afterUpdateRegistrationRequest(
		com.adjecti.pis.model.RegistrationRequest entity,
		java.util.Map<String, String[]> paramMap) {

		return _registrationRequestLocalService.afterUpdateRegistrationRequest(
			entity, paramMap);
	}

	@Override
	public boolean beforeUpdateRegistrationRequest(
		Object entity, java.util.Map<String, String[]> paramMap) {

		return _registrationRequestLocalService.beforeUpdateRegistrationRequest(
			entity, paramMap);
	}

	@Override
	public void confirmRegistration(
		java.util.Map<String, java.io.Serializable> workflowContext) {

		_registrationRequestLocalService.confirmRegistration(workflowContext);
	}

	@Override
	public com.liferay.portal.kernel.model.User createAppUser(
		long requestId, long employeeId) {

		return _registrationRequestLocalService.createAppUser(
			requestId, employeeId);
	}

	@Override
	public com.adjecti.pis.liferay.model.Employee createEmployee(
		long requestId) {

		return _registrationRequestLocalService.createEmployee(requestId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registrationRequestLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new registration request with the primary key. Does not add the registration request to the database.
	 *
	 * @param registrationRequestId the primary key for the new registration request
	 * @return the new registration request
	 */
	@Override
	public com.adjecti.pis.model.RegistrationRequest createRegistrationRequest(
		long registrationRequestId) {

		return _registrationRequestLocalService.createRegistrationRequest(
			registrationRequestId);
	}

	@Override
	public String createUser(long registrationRequestId) {
		return _registrationRequestLocalService.createUser(
			registrationRequestId);
	}

	@Override
	public String createUser(com.adjecti.pis.model.RegistrationRequest record) {
		return _registrationRequestLocalService.createUser(record);
	}

	@Override
	public String createUserWithPermission(
			long registrationRequestId, boolean emailAccess,
			boolean digitalSigning, boolean eGovAccess, boolean pisAccess)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return _registrationRequestLocalService.createUserWithPermission(
			registrationRequestId, emailAccess, digitalSigning, eGovAccess,
			pisAccess);
	}

	@Override
	public java.util.Map<String, java.util.List<String>> deduplicateLoginIds(
		String duplicateLoginIds) {

		return _registrationRequestLocalService.deduplicateLoginIds(
			duplicateLoginIds);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registrationRequestLocalService.deletePersistedModel(
			persistedModel);
	}

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
	@Override
	public com.adjecti.pis.model.RegistrationRequest deleteRegistrationRequest(
			long registrationRequestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registrationRequestLocalService.deleteRegistrationRequest(
			registrationRequestId);
	}

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
	@Override
	public com.adjecti.pis.model.RegistrationRequest deleteRegistrationRequest(
		com.adjecti.pis.model.RegistrationRequest registrationRequest) {

		return _registrationRequestLocalService.deleteRegistrationRequest(
			registrationRequest);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _registrationRequestLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _registrationRequestLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _registrationRequestLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _registrationRequestLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _registrationRequestLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _registrationRequestLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public java.util.List<com.adjecti.pis.dto.RegistrationRequestDTO>
			entityToDto(
				java.util.List<com.adjecti.pis.model.RegistrationRequest>
					requestList,
				long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registrationRequestLocalService.entityToDto(
			requestList, userId);
	}

	@Override
	public com.adjecti.pis.model.RegistrationRequest fetchRegistrationRequest(
		long registrationRequestId) {

		return _registrationRequestLocalService.fetchRegistrationRequest(
			registrationRequestId);
	}

	/**
	 * Returns the registration request matching the UUID and group.
	 *
	 * @param uuid the registration request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	@Override
	public com.adjecti.pis.model.RegistrationRequest
		fetchRegistrationRequestByUuidAndGroupId(String uuid, long groupId) {

		return _registrationRequestLocalService.
			fetchRegistrationRequestByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<com.adjecti.pis.dto.RegistrationRequestDTO>
			findBySearchParameter(
				com.adjecti.pis.dto.RegistrationRequestSearchParameter
					registrationRequestSearchParameter)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registrationRequestLocalService.findBySearchParameter(
			registrationRequestSearchParameter);
	}

	@Override
	public java.util.List<com.adjecti.pis.dto.RegistrationRequestDTO>
			findBySearchParameter(
				com.liferay.portal.kernel.model.User user,
				com.adjecti.pis.dto.RegistrationRequestSearchParameter
					registrationRequestSearchParameter)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registrationRequestLocalService.findBySearchParameter(
			user, registrationRequestSearchParameter);
	}

	@Override
	public java.util.List<com.adjecti.pis.dto.RegistrationRequestDTO>
			findByStatus(String status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registrationRequestLocalService.findByStatus(status);
	}

	@Override
	public java.util.List<com.adjecti.pis.dto.RegistrationRequestDTO>
			findByStatusAndOnboardingId(String status, long bulkOnbordingFileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registrationRequestLocalService.findByStatusAndOnboardingId(
			status, bulkOnbordingFileId);
	}

	@Override
	public java.util.List<com.adjecti.pis.dto.RegistrationRequestDTO>
			findByUnitId(long unitId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registrationRequestLocalService.findByUnitId(unitId);
	}

	@Override
	public java.util.List<com.adjecti.pis.model.RegistrationRequest>
			findByUnitIdsAndStatusList(long[] unitIds, int[] statuses)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registrationRequestLocalService.findByUnitIdsAndStatusList(
			unitIds, statuses);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _registrationRequestLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.adjecti.pis.dto.RegistrationRequestDTO>
			getAllRegistrations()
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registrationRequestLocalService.getAllRegistrations();
	}

	@Override
	public java.util.List<com.adjecti.pis.dto.RegistrationRequestDTO>
			getAllRegistrations(com.liferay.portal.kernel.model.User user)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registrationRequestLocalService.getAllRegistrations(user);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _registrationRequestLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _registrationRequestLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _registrationRequestLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registrationRequestLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public com.adjecti.pis.dto.RegistrationRequestDTO getRegistration(
			long registrationRequestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registrationRequestLocalService.getRegistration(
			registrationRequestId);
	}

	/**
	 * Returns the registration request with the primary key.
	 *
	 * @param registrationRequestId the primary key of the registration request
	 * @return the registration request
	 * @throws PortalException if a registration request with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.model.RegistrationRequest getRegistrationRequest(
			long registrationRequestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registrationRequestLocalService.getRegistrationRequest(
			registrationRequestId);
	}

	@Override
	public com.adjecti.pis.model.RegistrationRequest getRegistrationRequestById(
			long registrationRequestId)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return _registrationRequestLocalService.getRegistrationRequestById(
			registrationRequestId);
	}

	@Override
	public com.adjecti.pis.model.RegistrationRequest
		getRegistrationRequestByPersonalNo(Long personalNo) {

		return _registrationRequestLocalService.
			getRegistrationRequestByPersonalNo(personalNo);
	}

	/**
	 * Returns the registration request matching the UUID and group.
	 *
	 * @param uuid the registration request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching registration request
	 * @throws PortalException if a matching registration request could not be found
	 */
	@Override
	public com.adjecti.pis.model.RegistrationRequest
			getRegistrationRequestByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registrationRequestLocalService.
			getRegistrationRequestByUuidAndGroupId(uuid, groupId);
	}

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
	@Override
	public java.util.List<com.adjecti.pis.model.RegistrationRequest>
		getRegistrationRequests(int start, int end) {

		return _registrationRequestLocalService.getRegistrationRequests(
			start, end);
	}

	@Override
	public java.util.List<com.adjecti.pis.model.RegistrationRequest>
		getRegistrationRequests(long groupId) {

		return _registrationRequestLocalService.getRegistrationRequests(
			groupId);
	}

	@Override
	public java.util.List<com.adjecti.pis.model.RegistrationRequest>
			getRegistrationRequests(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _registrationRequestLocalService.getRegistrationRequests(
			groupId, status);
	}

	@Override
	public java.util.List<com.adjecti.pis.model.RegistrationRequest>
		getRegistrationRequests(long groupId, int start, int end) {

		return _registrationRequestLocalService.getRegistrationRequests(
			groupId, start, end);
	}

	@Override
	public java.util.List<com.adjecti.pis.model.RegistrationRequest>
		getRegistrationRequests(
			long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.adjecti.pis.model.RegistrationRequest> obc) {

		return _registrationRequestLocalService.getRegistrationRequests(
			groupId, start, end, obc);
	}

	@Override
	public java.util.List<com.adjecti.pis.dto.RegistrationRequestDTO>
			getRegistrationRequestsByOnboardingId(long bulkOnbordingFileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registrationRequestLocalService.
			getRegistrationRequestsByOnboardingId(bulkOnbordingFileId);
	}

	/**
	 * Returns all the registration requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the registration requests
	 * @param companyId the primary key of the company
	 * @return the matching registration requests, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.adjecti.pis.model.RegistrationRequest>
		getRegistrationRequestsByUuidAndCompanyId(String uuid, long companyId) {

		return _registrationRequestLocalService.
			getRegistrationRequestsByUuidAndCompanyId(uuid, companyId);
	}

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
	@Override
	public java.util.List<com.adjecti.pis.model.RegistrationRequest>
		getRegistrationRequestsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.adjecti.pis.model.RegistrationRequest> orderByComparator) {

		return _registrationRequestLocalService.
			getRegistrationRequestsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of registration requests.
	 *
	 * @return the number of registration requests
	 */
	@Override
	public int getRegistrationRequestsCount() {
		return _registrationRequestLocalService.getRegistrationRequestsCount();
	}

	@Override
	public int getRegistrationRequestsCount(long groupId) {
		return _registrationRequestLocalService.getRegistrationRequestsCount(
			groupId);
	}

	@Override
	public java.util.List<com.adjecti.pis.dto.RegistrationRequestDTO>
			getRegistrationsByStatus(String status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registrationRequestLocalService.getRegistrationsByStatus(
			status);
	}

	@Override
	public long getTotalApprovalPendingCount(long bulkOnbordingFileId) {
		return _registrationRequestLocalService.getTotalApprovalPendingCount(
			bulkOnbordingFileId);
	}

	@Override
	public long getTotalApprovedCount(long bulkOnbordingFileId) {
		return _registrationRequestLocalService.getTotalApprovedCount(
			bulkOnbordingFileId);
	}

	@Override
	public long getTotalCount(long bulkOnbordingFileId) {
		return _registrationRequestLocalService.getTotalCount(
			bulkOnbordingFileId);
	}

	@Override
	public int getTotalCountByUnit(String unit) {
		return _registrationRequestLocalService.getTotalCountByUnit(unit);
	}

	@Override
	public int getTotalCountByUnitAndStatus(String unit, int status) {
		return _registrationRequestLocalService.getTotalCountByUnitAndStatus(
			unit, status);
	}

	@Override
	public long getTotalDraftCount(long bulkOnbordingFileId) {
		return _registrationRequestLocalService.getTotalDraftCount(
			bulkOnbordingFileId);
	}

	@Override
	public long getTotalIncompleteCount(long bulkOnbordingFileId) {
		return _registrationRequestLocalService.getTotalIncompleteCount(
			bulkOnbordingFileId);
	}

	@Override
	public long getTotalPendingCount(long bulkOnbordingFileId) {
		return _registrationRequestLocalService.getTotalPendingCount(
			bulkOnbordingFileId);
	}

	@Override
	public long getTotalRejectedCount(long bulkOnbordingFileId) {
		return _registrationRequestLocalService.getTotalRejectedCount(
			bulkOnbordingFileId);
	}

	@Override
	public boolean hasOwnerRole(long userId, long companyId) {
		return _registrationRequestLocalService.hasOwnerRole(userId, companyId);
	}

	@Override
	public boolean isActionCompleted(
		com.adjecti.pis.model.RegistrationRequest registration) {

		return _registrationRequestLocalService.isActionCompleted(registration);
	}

	@Override
	public boolean isActiontaken(
			com.adjecti.pis.model.RegistrationRequest registration, long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registrationRequestLocalService.isActiontaken(
			registration, userId);
	}

	@Override
	public boolean isAdmin()
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registrationRequestLocalService.isAdmin();
	}

	@Override
	public boolean isAdmin(long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registrationRequestLocalService.isAdmin(userId);
	}

	@Override
	public boolean isApprover(long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registrationRequestLocalService.isApprover(userId);
	}

	@Override
	public boolean isAssignableOrCompleted(
		com.adjecti.pis.model.RegistrationRequest registration, long userId) {

		return _registrationRequestLocalService.isAssignableOrCompleted(
			registration, userId);
	}

	@Override
	public boolean isCreater(long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _registrationRequestLocalService.isCreater(userId);
	}

	@Override
	public boolean isEmailAddressExists(String emailAddress, long requestId) {
		return _registrationRequestLocalService.isEmailAddressExists(
			emailAddress, requestId);
	}

	@Override
	public boolean isPersonalNumberExists(
		long personalnumber, long requestId, long unitId) {

		return _registrationRequestLocalService.isPersonalNumberExists(
			personalnumber, requestId, unitId);
	}

	@Override
	public boolean isRecordNumberExists(long recordNo, long requestId) {
		return _registrationRequestLocalService.isRecordNumberExists(
			recordNo, requestId);
	}

	@Override
	public void performWorkFlowACtion(
			long pisId, String action, String remarks, long workflowTaskId,
			long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_registrationRequestLocalService.performWorkFlowACtion(
			pisId, action, remarks, workflowTaskId, userId);
	}

	@Override
	public java.util.List<com.adjecti.pis.model.RegistrationRequest>
		searchRegistrationRequests(java.util.Map<String, String> searchFilter) {

		return _registrationRequestLocalService.searchRegistrationRequests(
			searchFilter);
	}

	@Override
	public void selectedProcessed(
			String[] requestIds, String action, String remarks, long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_registrationRequestLocalService.selectedProcessed(
			requestIds, action, remarks, userId);
	}

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
	@Override
	public com.adjecti.pis.model.RegistrationRequest updateRegistrationRequest(
		com.adjecti.pis.model.RegistrationRequest registrationRequest) {

		return _registrationRequestLocalService.updateRegistrationRequest(
			registrationRequest);
	}

	@Override
	public com.adjecti.pis.model.RegistrationRequest updateRegistrationRequest(
			com.adjecti.pis.dto.RegistrationRequestDTO requestDto,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _registrationRequestLocalService.updateRegistrationRequest(
			requestDto, serviceContext);
	}

	@Override
	public com.adjecti.pis.model.RegistrationRequest updateStatus(
			long userId, long requestId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _registrationRequestLocalService.updateStatus(
			userId, requestId, status, serviceContext);
	}

	@Override
	public RegistrationRequestLocalService getWrappedService() {
		return _registrationRequestLocalService;
	}

	@Override
	public void setWrappedService(
		RegistrationRequestLocalService registrationRequestLocalService) {

		_registrationRequestLocalService = registrationRequestLocalService;
	}

	private RegistrationRequestLocalService _registrationRequestLocalService;

}