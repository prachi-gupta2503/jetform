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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for RegistrationRequest. This utility wraps
 * <code>com.adjecti.pis.service.impl.RegistrationRequestLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see RegistrationRequestLocalService
 * @generated
 */
public class RegistrationRequestLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.pis.service.impl.RegistrationRequestLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
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
	public static com.adjecti.pis.model.RegistrationRequest
		addRegistrationRequest(
			com.adjecti.pis.model.RegistrationRequest registrationRequest) {

		return getService().addRegistrationRequest(registrationRequest);
	}

	public static com.adjecti.pis.model.RegistrationRequest
			addRegistrationRequest(
				com.adjecti.pis.dto.RegistrationRequestDTO
					registrationRequestDto,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addRegistrationRequest(
			registrationRequestDto, serviceContext);
	}

	public static boolean afterUpdateRegistrationRequest(
		com.adjecti.pis.model.RegistrationRequest entity,
		java.util.Map<String, String[]> paramMap) {

		return getService().afterUpdateRegistrationRequest(entity, paramMap);
	}

	public static boolean beforeUpdateRegistrationRequest(
		Object entity, java.util.Map<String, String[]> paramMap) {

		return getService().beforeUpdateRegistrationRequest(entity, paramMap);
	}

	public static void confirmRegistration(
		java.util.Map<String, java.io.Serializable> workflowContext) {

		getService().confirmRegistration(workflowContext);
	}

	public static com.liferay.portal.kernel.model.User createAppUser(
		long requestId, long employeeId) {

		return getService().createAppUser(requestId, employeeId);
	}

	public static com.adjecti.pis.liferay.model.Employee createEmployee(
		long requestId) {

		return getService().createEmployee(requestId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			createPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new registration request with the primary key. Does not add the registration request to the database.
	 *
	 * @param registrationRequestId the primary key for the new registration request
	 * @return the new registration request
	 */
	public static com.adjecti.pis.model.RegistrationRequest
		createRegistrationRequest(long registrationRequestId) {

		return getService().createRegistrationRequest(registrationRequestId);
	}

	public static String createUser(long registrationRequestId) {
		return getService().createUser(registrationRequestId);
	}

	public static String createUser(
		com.adjecti.pis.model.RegistrationRequest record) {

		return getService().createUser(record);
	}

	public static String createUserWithPermission(
			long registrationRequestId, boolean emailAccess,
			boolean digitalSigning, boolean eGovAccess, boolean pisAccess)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getService().createUserWithPermission(
			registrationRequestId, emailAccess, digitalSigning, eGovAccess,
			pisAccess);
	}

	public static java.util.Map<String, java.util.List<String>>
		deduplicateLoginIds(String duplicateLoginIds) {

		return getService().deduplicateLoginIds(duplicateLoginIds);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	public static com.adjecti.pis.model.RegistrationRequest
			deleteRegistrationRequest(long registrationRequestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteRegistrationRequest(registrationRequestId);
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
	public static com.adjecti.pis.model.RegistrationRequest
		deleteRegistrationRequest(
			com.adjecti.pis.model.RegistrationRequest registrationRequest) {

		return getService().deleteRegistrationRequest(registrationRequest);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static java.util.List<com.adjecti.pis.dto.RegistrationRequestDTO>
			entityToDto(
				java.util.List<com.adjecti.pis.model.RegistrationRequest>
					requestList,
				long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().entityToDto(requestList, userId);
	}

	public static com.adjecti.pis.model.RegistrationRequest
		fetchRegistrationRequest(long registrationRequestId) {

		return getService().fetchRegistrationRequest(registrationRequestId);
	}

	/**
	 * Returns the registration request matching the UUID and group.
	 *
	 * @param uuid the registration request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static com.adjecti.pis.model.RegistrationRequest
		fetchRegistrationRequestByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchRegistrationRequestByUuidAndGroupId(
			uuid, groupId);
	}

	public static java.util.List<com.adjecti.pis.dto.RegistrationRequestDTO>
			findBySearchParameter(
				com.adjecti.pis.dto.RegistrationRequestSearchParameter
					registrationRequestSearchParameter)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().findBySearchParameter(
			registrationRequestSearchParameter);
	}

	public static java.util.List<com.adjecti.pis.dto.RegistrationRequestDTO>
			findBySearchParameter(
				com.liferay.portal.kernel.model.User user,
				com.adjecti.pis.dto.RegistrationRequestSearchParameter
					registrationRequestSearchParameter)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().findBySearchParameter(
			user, registrationRequestSearchParameter);
	}

	public static java.util.List<com.adjecti.pis.dto.RegistrationRequestDTO>
			findByStatus(String status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().findByStatus(status);
	}

	public static java.util.List<com.adjecti.pis.dto.RegistrationRequestDTO>
			findByStatusAndOnboardingId(String status, long bulkOnbordingFileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().findByStatusAndOnboardingId(
			status, bulkOnbordingFileId);
	}

	public static java.util.List<com.adjecti.pis.dto.RegistrationRequestDTO>
			findByUnitId(long unitId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().findByUnitId(unitId);
	}

	public static java.util.List<com.adjecti.pis.model.RegistrationRequest>
			findByUnitIdsAndStatusList(long[] unitIds, int[] statuses)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().findByUnitIdsAndStatusList(unitIds, statuses);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<com.adjecti.pis.dto.RegistrationRequestDTO>
			getAllRegistrations()
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAllRegistrations();
	}

	public static java.util.List<com.adjecti.pis.dto.RegistrationRequestDTO>
			getAllRegistrations(com.liferay.portal.kernel.model.User user)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAllRegistrations(user);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static com.adjecti.pis.dto.RegistrationRequestDTO getRegistration(
			long registrationRequestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getRegistration(registrationRequestId);
	}

	/**
	 * Returns the registration request with the primary key.
	 *
	 * @param registrationRequestId the primary key of the registration request
	 * @return the registration request
	 * @throws PortalException if a registration request with the primary key could not be found
	 */
	public static com.adjecti.pis.model.RegistrationRequest
			getRegistrationRequest(long registrationRequestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getRegistrationRequest(registrationRequestId);
	}

	public static com.adjecti.pis.model.RegistrationRequest
			getRegistrationRequestById(long registrationRequestId)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getService().getRegistrationRequestById(registrationRequestId);
	}

	public static com.adjecti.pis.model.RegistrationRequest
		getRegistrationRequestByPersonalNo(Long personalNo) {

		return getService().getRegistrationRequestByPersonalNo(personalNo);
	}

	/**
	 * Returns the registration request matching the UUID and group.
	 *
	 * @param uuid the registration request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching registration request
	 * @throws PortalException if a matching registration request could not be found
	 */
	public static com.adjecti.pis.model.RegistrationRequest
			getRegistrationRequestByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getRegistrationRequestByUuidAndGroupId(
			uuid, groupId);
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
	public static java.util.List<com.adjecti.pis.model.RegistrationRequest>
		getRegistrationRequests(int start, int end) {

		return getService().getRegistrationRequests(start, end);
	}

	public static java.util.List<com.adjecti.pis.model.RegistrationRequest>
		getRegistrationRequests(long groupId) {

		return getService().getRegistrationRequests(groupId);
	}

	public static java.util.List<com.adjecti.pis.model.RegistrationRequest>
			getRegistrationRequests(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getRegistrationRequests(groupId, status);
	}

	public static java.util.List<com.adjecti.pis.model.RegistrationRequest>
		getRegistrationRequests(long groupId, int start, int end) {

		return getService().getRegistrationRequests(groupId, start, end);
	}

	public static java.util.List<com.adjecti.pis.model.RegistrationRequest>
		getRegistrationRequests(
			long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.adjecti.pis.model.RegistrationRequest> obc) {

		return getService().getRegistrationRequests(groupId, start, end, obc);
	}

	public static java.util.List<com.adjecti.pis.dto.RegistrationRequestDTO>
			getRegistrationRequestsByOnboardingId(long bulkOnbordingFileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getRegistrationRequestsByOnboardingId(
			bulkOnbordingFileId);
	}

	/**
	 * Returns all the registration requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the registration requests
	 * @param companyId the primary key of the company
	 * @return the matching registration requests, or an empty list if no matches were found
	 */
	public static java.util.List<com.adjecti.pis.model.RegistrationRequest>
		getRegistrationRequestsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getRegistrationRequestsByUuidAndCompanyId(
			uuid, companyId);
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
	public static java.util.List<com.adjecti.pis.model.RegistrationRequest>
		getRegistrationRequestsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.adjecti.pis.model.RegistrationRequest> orderByComparator) {

		return getService().getRegistrationRequestsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of registration requests.
	 *
	 * @return the number of registration requests
	 */
	public static int getRegistrationRequestsCount() {
		return getService().getRegistrationRequestsCount();
	}

	public static int getRegistrationRequestsCount(long groupId) {
		return getService().getRegistrationRequestsCount(groupId);
	}

	public static java.util.List<com.adjecti.pis.dto.RegistrationRequestDTO>
			getRegistrationsByStatus(String status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getRegistrationsByStatus(status);
	}

	public static long getTotalApprovalPendingCount(long bulkOnbordingFileId) {
		return getService().getTotalApprovalPendingCount(bulkOnbordingFileId);
	}

	public static long getTotalApprovedCount(long bulkOnbordingFileId) {
		return getService().getTotalApprovedCount(bulkOnbordingFileId);
	}

	public static long getTotalCount(long bulkOnbordingFileId) {
		return getService().getTotalCount(bulkOnbordingFileId);
	}

	public static int getTotalCountByUnit(String unit) {
		return getService().getTotalCountByUnit(unit);
	}

	public static int getTotalCountByUnitAndStatus(String unit, int status) {
		return getService().getTotalCountByUnitAndStatus(unit, status);
	}

	public static long getTotalDraftCount(long bulkOnbordingFileId) {
		return getService().getTotalDraftCount(bulkOnbordingFileId);
	}

	public static long getTotalIncompleteCount(long bulkOnbordingFileId) {
		return getService().getTotalIncompleteCount(bulkOnbordingFileId);
	}

	public static long getTotalPendingCount(long bulkOnbordingFileId) {
		return getService().getTotalPendingCount(bulkOnbordingFileId);
	}

	public static long getTotalRejectedCount(long bulkOnbordingFileId) {
		return getService().getTotalRejectedCount(bulkOnbordingFileId);
	}

	public static boolean hasOwnerRole(long userId, long companyId) {
		return getService().hasOwnerRole(userId, companyId);
	}

	public static boolean isActionCompleted(
		com.adjecti.pis.model.RegistrationRequest registration) {

		return getService().isActionCompleted(registration);
	}

	public static boolean isActiontaken(
			com.adjecti.pis.model.RegistrationRequest registration, long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().isActiontaken(registration, userId);
	}

	public static boolean isAdmin()
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().isAdmin();
	}

	public static boolean isAdmin(long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().isAdmin(userId);
	}

	public static boolean isApprover(long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().isApprover(userId);
	}

	public static boolean isAssignableOrCompleted(
		com.adjecti.pis.model.RegistrationRequest registration, long userId) {

		return getService().isAssignableOrCompleted(registration, userId);
	}

	public static boolean isCreater(long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().isCreater(userId);
	}

	public static boolean isEmailAddressExists(
		String emailAddress, long requestId) {

		return getService().isEmailAddressExists(emailAddress, requestId);
	}

	public static boolean isPersonalNumberExists(
		long personalnumber, long requestId, long unitId) {

		return getService().isPersonalNumberExists(
			personalnumber, requestId, unitId);
	}

	public static boolean isRecordNumberExists(long recordNo, long requestId) {
		return getService().isRecordNumberExists(recordNo, requestId);
	}

	public static void performWorkFlowACtion(
			long pisId, String action, String remarks, long workflowTaskId,
			long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().performWorkFlowACtion(
			pisId, action, remarks, workflowTaskId, userId);
	}

	public static java.util.List<com.adjecti.pis.model.RegistrationRequest>
		searchRegistrationRequests(java.util.Map<String, String> searchFilter) {

		return getService().searchRegistrationRequests(searchFilter);
	}

	public static void selectedProcessed(
			String[] requestIds, String action, String remarks, long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().selectedProcessed(requestIds, action, remarks, userId);
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
	public static com.adjecti.pis.model.RegistrationRequest
		updateRegistrationRequest(
			com.adjecti.pis.model.RegistrationRequest registrationRequest) {

		return getService().updateRegistrationRequest(registrationRequest);
	}

	public static com.adjecti.pis.model.RegistrationRequest
			updateRegistrationRequest(
				com.adjecti.pis.dto.RegistrationRequestDTO requestDto,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().updateRegistrationRequest(
			requestDto, serviceContext);
	}

	public static com.adjecti.pis.model.RegistrationRequest updateStatus(
			long userId, long requestId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().updateStatus(
			userId, requestId, status, serviceContext);
	}

	public static RegistrationRequestLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<RegistrationRequestLocalService, RegistrationRequestLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			RegistrationRequestLocalService.class);

		ServiceTracker
			<RegistrationRequestLocalService, RegistrationRequestLocalService>
				serviceTracker =
					new ServiceTracker
						<RegistrationRequestLocalService,
						 RegistrationRequestLocalService>(
							 bundle.getBundleContext(),
							 RegistrationRequestLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}