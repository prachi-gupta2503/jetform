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
 * Provides the local service utility for EmployeeApplication. This utility wraps
 * <code>com.adjecti.pis.liferay.service.impl.EmployeeApplicationLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeApplicationLocalService
 * @generated
 */
public class EmployeeApplicationLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.pis.liferay.service.impl.EmployeeApplicationLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the employee application to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeApplicationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeApplication the employee application
	 * @return the employee application that was added
	 */
	public static com.adjecti.pis.liferay.model.EmployeeApplication
		addEmployeeApplication(
			com.adjecti.pis.liferay.model.EmployeeApplication
				employeeApplication) {

		return getService().addEmployeeApplication(employeeApplication);
	}

	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeeApplication>
				addEmployeeApplications(
					java.util.List
						<com.adjecti.pis.liferay.model.EmployeeApplication>
							employeeApplications)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addEmployeeApplications(employeeApplications);
	}

	/**
	 * Creates a new employee application with the primary key. Does not add the employee application to the database.
	 *
	 * @param employeeApplicationId the primary key for the new employee application
	 * @return the new employee application
	 */
	public static com.adjecti.pis.liferay.model.EmployeeApplication
		createEmployeeApplication(long employeeApplicationId) {

		return getService().createEmployeeApplication(employeeApplicationId);
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
	 * Deletes the employee application from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeApplicationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeApplication the employee application
	 * @return the employee application that was removed
	 */
	public static com.adjecti.pis.liferay.model.EmployeeApplication
		deleteEmployeeApplication(
			com.adjecti.pis.liferay.model.EmployeeApplication
				employeeApplication) {

		return getService().deleteEmployeeApplication(employeeApplication);
	}

	/**
	 * Deletes the employee application with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeApplicationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeApplicationId the primary key of the employee application
	 * @return the employee application that was removed
	 * @throws PortalException if a employee application with the primary key could not be found
	 */
	public static com.adjecti.pis.liferay.model.EmployeeApplication
			deleteEmployeeApplication(long employeeApplicationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteEmployeeApplication(employeeApplicationId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeApplicationModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeApplicationModelImpl</code>.
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

	public static com.adjecti.pis.liferay.model.EmployeeApplication
		fetchEmployeeApplication(long employeeApplicationId) {

		return getService().fetchEmployeeApplication(employeeApplicationId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeeApplication> getByEmployeeId(
			long employeeId) {

		return getService().getByEmployeeId(employeeId);
	}

	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeeApplication> getByPersonaNo(
			String personalNo) {

		return getService().getByPersonaNo(personalNo);
	}

	/**
	 * Returns the employee application with the primary key.
	 *
	 * @param employeeApplicationId the primary key of the employee application
	 * @return the employee application
	 * @throws PortalException if a employee application with the primary key could not be found
	 */
	public static com.adjecti.pis.liferay.model.EmployeeApplication
			getEmployeeApplication(long employeeApplicationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getEmployeeApplication(employeeApplicationId);
	}

	/**
	 * Returns a range of all the employee applications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee applications
	 * @param end the upper bound of the range of employee applications (not inclusive)
	 * @return the range of employee applications
	 */
	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeeApplication>
			getEmployeeApplications(int start, int end) {

		return getService().getEmployeeApplications(start, end);
	}

	/**
	 * Returns the number of employee applications.
	 *
	 * @return the number of employee applications
	 */
	public static int getEmployeeApplicationsCount() {
		return getService().getEmployeeApplicationsCount();
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
	 * Updates the employee application in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeApplicationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeApplication the employee application
	 * @return the employee application that was updated
	 */
	public static com.adjecti.pis.liferay.model.EmployeeApplication
		updateEmployeeApplication(
			com.adjecti.pis.liferay.model.EmployeeApplication
				employeeApplication) {

		return getService().updateEmployeeApplication(employeeApplication);
	}

	public static EmployeeApplicationLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeeApplicationLocalService, EmployeeApplicationLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EmployeeApplicationLocalService.class);

		ServiceTracker
			<EmployeeApplicationLocalService, EmployeeApplicationLocalService>
				serviceTracker =
					new ServiceTracker
						<EmployeeApplicationLocalService,
						 EmployeeApplicationLocalService>(
							 bundle.getBundleContext(),
							 EmployeeApplicationLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}