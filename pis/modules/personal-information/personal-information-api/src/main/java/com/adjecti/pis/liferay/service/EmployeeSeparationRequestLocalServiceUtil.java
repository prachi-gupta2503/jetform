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
 * Provides the local service utility for EmployeeSeparationRequest. This utility wraps
 * <code>com.adjecti.pis.liferay.service.impl.EmployeeSeparationRequestLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeSeparationRequestLocalService
 * @generated
 */
public class EmployeeSeparationRequestLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.pis.liferay.service.impl.EmployeeSeparationRequestLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the employee separation request to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeSeparationRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeSeparationRequest the employee separation request
	 * @return the employee separation request that was added
	 */
	public static com.adjecti.pis.liferay.model.EmployeeSeparationRequest
		addEmployeeSeparationRequest(
			com.adjecti.pis.liferay.model.EmployeeSeparationRequest
				employeeSeparationRequest) {

		return getService().addEmployeeSeparationRequest(
			employeeSeparationRequest);
	}

	/**
	 * Creates a new employee separation request with the primary key. Does not add the employee separation request to the database.
	 *
	 * @param employeeSeparationRequestId the primary key for the new employee separation request
	 * @return the new employee separation request
	 */
	public static com.adjecti.pis.liferay.model.EmployeeSeparationRequest
		createEmployeeSeparationRequest(long employeeSeparationRequestId) {

		return getService().createEmployeeSeparationRequest(
			employeeSeparationRequestId);
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
	 * Deletes the employee separation request from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeSeparationRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeSeparationRequest the employee separation request
	 * @return the employee separation request that was removed
	 */
	public static com.adjecti.pis.liferay.model.EmployeeSeparationRequest
		deleteEmployeeSeparationRequest(
			com.adjecti.pis.liferay.model.EmployeeSeparationRequest
				employeeSeparationRequest) {

		return getService().deleteEmployeeSeparationRequest(
			employeeSeparationRequest);
	}

	/**
	 * Deletes the employee separation request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeSeparationRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeSeparationRequestId the primary key of the employee separation request
	 * @return the employee separation request that was removed
	 * @throws PortalException if a employee separation request with the primary key could not be found
	 */
	public static com.adjecti.pis.liferay.model.EmployeeSeparationRequest
			deleteEmployeeSeparationRequest(long employeeSeparationRequestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteEmployeeSeparationRequest(
			employeeSeparationRequestId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeSeparationRequestModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeSeparationRequestModelImpl</code>.
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

	public static com.adjecti.pis.liferay.model.EmployeeSeparationRequest
		fetchEmployeeSeparationRequest(long employeeSeparationRequestId) {

		return getService().fetchEmployeeSeparationRequest(
			employeeSeparationRequestId);
	}

	/**
	 * Returns the employee separation request matching the UUID and group.
	 *
	 * @param uuid the employee separation request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee separation request, or <code>null</code> if a matching employee separation request could not be found
	 */
	public static com.adjecti.pis.liferay.model.EmployeeSeparationRequest
		fetchEmployeeSeparationRequestByUuidAndGroupId(
			String uuid, long groupId) {

		return getService().fetchEmployeeSeparationRequestByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the employee separation request with the primary key.
	 *
	 * @param employeeSeparationRequestId the primary key of the employee separation request
	 * @return the employee separation request
	 * @throws PortalException if a employee separation request with the primary key could not be found
	 */
	public static com.adjecti.pis.liferay.model.EmployeeSeparationRequest
			getEmployeeSeparationRequest(long employeeSeparationRequestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getEmployeeSeparationRequest(
			employeeSeparationRequestId);
	}

	/**
	 * Returns the employee separation request matching the UUID and group.
	 *
	 * @param uuid the employee separation request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee separation request
	 * @throws PortalException if a matching employee separation request could not be found
	 */
	public static com.adjecti.pis.liferay.model.EmployeeSeparationRequest
			getEmployeeSeparationRequestByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getEmployeeSeparationRequestByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the employee separation requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeSeparationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee separation requests
	 * @param end the upper bound of the range of employee separation requests (not inclusive)
	 * @return the range of employee separation requests
	 */
	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeeSeparationRequest>
			getEmployeeSeparationRequests(int start, int end) {

		return getService().getEmployeeSeparationRequests(start, end);
	}

	/**
	 * Returns all the employee separation requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee separation requests
	 * @param companyId the primary key of the company
	 * @return the matching employee separation requests, or an empty list if no matches were found
	 */
	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeeSeparationRequest>
			getEmployeeSeparationRequestsByUuidAndCompanyId(
				String uuid, long companyId) {

		return getService().getEmployeeSeparationRequestsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of employee separation requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee separation requests
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of employee separation requests
	 * @param end the upper bound of the range of employee separation requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching employee separation requests, or an empty list if no matches were found
	 */
	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeeSeparationRequest>
			getEmployeeSeparationRequestsByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.adjecti.pis.liferay.model.EmployeeSeparationRequest>
						orderByComparator) {

		return getService().getEmployeeSeparationRequestsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of employee separation requests.
	 *
	 * @return the number of employee separation requests
	 */
	public static int getEmployeeSeparationRequestsCount() {
		return getService().getEmployeeSeparationRequestsCount();
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
	 * Updates the employee separation request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeSeparationRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeSeparationRequest the employee separation request
	 * @return the employee separation request that was updated
	 */
	public static com.adjecti.pis.liferay.model.EmployeeSeparationRequest
		updateEmployeeSeparationRequest(
			com.adjecti.pis.liferay.model.EmployeeSeparationRequest
				employeeSeparationRequest) {

		return getService().updateEmployeeSeparationRequest(
			employeeSeparationRequest);
	}

	public static EmployeeSeparationRequestLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeeSeparationRequestLocalService,
		 EmployeeSeparationRequestLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EmployeeSeparationRequestLocalService.class);

		ServiceTracker
			<EmployeeSeparationRequestLocalService,
			 EmployeeSeparationRequestLocalService> serviceTracker =
				new ServiceTracker
					<EmployeeSeparationRequestLocalService,
					 EmployeeSeparationRequestLocalService>(
						 bundle.getBundleContext(),
						 EmployeeSeparationRequestLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}