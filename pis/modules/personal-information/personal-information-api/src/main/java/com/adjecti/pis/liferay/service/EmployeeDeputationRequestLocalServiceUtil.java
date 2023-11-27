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

package com.adjecti.pis.liferay.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for EmployeeDeputationRequest. This utility wraps
 * <code>com.adjecti.pis.liferay.service.impl.EmployeeDeputationRequestLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDeputationRequestLocalService
 * @generated
 */
public class EmployeeDeputationRequestLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.pis.liferay.service.impl.EmployeeDeputationRequestLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the employee deputation request to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDeputationRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDeputationRequest the employee deputation request
	 * @return the employee deputation request that was added
	 */
	public static com.adjecti.pis.liferay.model.EmployeeDeputationRequest
		addEmployeeDeputationRequest(
			com.adjecti.pis.liferay.model.EmployeeDeputationRequest
				employeeDeputationRequest) {

		return getService().addEmployeeDeputationRequest(
			employeeDeputationRequest);
	}

	/**
	 * Creates a new employee deputation request with the primary key. Does not add the employee deputation request to the database.
	 *
	 * @param employeeDeputationRequestId the primary key for the new employee deputation request
	 * @return the new employee deputation request
	 */
	public static com.adjecti.pis.liferay.model.EmployeeDeputationRequest
		createEmployeeDeputationRequest(long employeeDeputationRequestId) {

		return getService().createEmployeeDeputationRequest(
			employeeDeputationRequestId);
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
	 * Deletes the employee deputation request from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDeputationRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDeputationRequest the employee deputation request
	 * @return the employee deputation request that was removed
	 */
	public static com.adjecti.pis.liferay.model.EmployeeDeputationRequest
		deleteEmployeeDeputationRequest(
			com.adjecti.pis.liferay.model.EmployeeDeputationRequest
				employeeDeputationRequest) {

		return getService().deleteEmployeeDeputationRequest(
			employeeDeputationRequest);
	}

	/**
	 * Deletes the employee deputation request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDeputationRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDeputationRequestId the primary key of the employee deputation request
	 * @return the employee deputation request that was removed
	 * @throws PortalException if a employee deputation request with the primary key could not be found
	 */
	public static com.adjecti.pis.liferay.model.EmployeeDeputationRequest
			deleteEmployeeDeputationRequest(long employeeDeputationRequestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteEmployeeDeputationRequest(
			employeeDeputationRequestId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeDeputationRequestModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeDeputationRequestModelImpl</code>.
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

	public static com.adjecti.pis.liferay.model.EmployeeDeputationRequest
		fetchEmployeeDeputationRequest(long employeeDeputationRequestId) {

		return getService().fetchEmployeeDeputationRequest(
			employeeDeputationRequestId);
	}

	/**
	 * Returns the employee deputation request matching the UUID and group.
	 *
	 * @param uuid the employee deputation request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee deputation request, or <code>null</code> if a matching employee deputation request could not be found
	 */
	public static com.adjecti.pis.liferay.model.EmployeeDeputationRequest
		fetchEmployeeDeputationRequestByUuidAndGroupId(
			String uuid, long groupId) {

		return getService().fetchEmployeeDeputationRequestByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the employee deputation request with the primary key.
	 *
	 * @param employeeDeputationRequestId the primary key of the employee deputation request
	 * @return the employee deputation request
	 * @throws PortalException if a employee deputation request with the primary key could not be found
	 */
	public static com.adjecti.pis.liferay.model.EmployeeDeputationRequest
			getEmployeeDeputationRequest(long employeeDeputationRequestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getEmployeeDeputationRequest(
			employeeDeputationRequestId);
	}

	/**
	 * Returns the employee deputation request matching the UUID and group.
	 *
	 * @param uuid the employee deputation request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee deputation request
	 * @throws PortalException if a matching employee deputation request could not be found
	 */
	public static com.adjecti.pis.liferay.model.EmployeeDeputationRequest
			getEmployeeDeputationRequestByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getEmployeeDeputationRequestByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the employee deputation requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeDeputationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee deputation requests
	 * @param end the upper bound of the range of employee deputation requests (not inclusive)
	 * @return the range of employee deputation requests
	 */
	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeeDeputationRequest>
			getEmployeeDeputationRequests(int start, int end) {

		return getService().getEmployeeDeputationRequests(start, end);
	}

	/**
	 * Returns all the employee deputation requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee deputation requests
	 * @param companyId the primary key of the company
	 * @return the matching employee deputation requests, or an empty list if no matches were found
	 */
	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeeDeputationRequest>
			getEmployeeDeputationRequestsByUuidAndCompanyId(
				String uuid, long companyId) {

		return getService().getEmployeeDeputationRequestsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of employee deputation requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee deputation requests
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of employee deputation requests
	 * @param end the upper bound of the range of employee deputation requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching employee deputation requests, or an empty list if no matches were found
	 */
	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeeDeputationRequest>
			getEmployeeDeputationRequestsByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.adjecti.pis.liferay.model.EmployeeDeputationRequest>
						orderByComparator) {

		return getService().getEmployeeDeputationRequestsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of employee deputation requests.
	 *
	 * @return the number of employee deputation requests
	 */
	public static int getEmployeeDeputationRequestsCount() {
		return getService().getEmployeeDeputationRequestsCount();
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

	/**
	 * Updates the employee deputation request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDeputationRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDeputationRequest the employee deputation request
	 * @return the employee deputation request that was updated
	 */
	public static com.adjecti.pis.liferay.model.EmployeeDeputationRequest
		updateEmployeeDeputationRequest(
			com.adjecti.pis.liferay.model.EmployeeDeputationRequest
				employeeDeputationRequest) {

		return getService().updateEmployeeDeputationRequest(
			employeeDeputationRequest);
	}

	public static EmployeeDeputationRequestLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeeDeputationRequestLocalService,
		 EmployeeDeputationRequestLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EmployeeDeputationRequestLocalService.class);

		ServiceTracker
			<EmployeeDeputationRequestLocalService,
			 EmployeeDeputationRequestLocalService> serviceTracker =
				new ServiceTracker
					<EmployeeDeputationRequestLocalService,
					 EmployeeDeputationRequestLocalService>(
						 bundle.getBundleContext(),
						 EmployeeDeputationRequestLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}