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
 * Provides the local service utility for EmployeeFamily. This utility wraps
 * <code>com.adjecti.pis.liferay.service.impl.EmployeeFamilyLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeFamilyLocalService
 * @generated
 */
public class EmployeeFamilyLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.pis.liferay.service.impl.EmployeeFamilyLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the employee family to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeFamilyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeFamily the employee family
	 * @return the employee family that was added
	 */
	public static com.adjecti.pis.liferay.model.EmployeeFamily
		addEmployeeFamily(
			com.adjecti.pis.liferay.model.EmployeeFamily employeeFamily) {

		return getService().addEmployeeFamily(employeeFamily);
	}

	/**
	 * Creates a new employee family with the primary key. Does not add the employee family to the database.
	 *
	 * @param employeeFamilyId the primary key for the new employee family
	 * @return the new employee family
	 */
	public static com.adjecti.pis.liferay.model.EmployeeFamily
		createEmployeeFamily(long employeeFamilyId) {

		return getService().createEmployeeFamily(employeeFamilyId);
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
	 * Deletes the employee family from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeFamilyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeFamily the employee family
	 * @return the employee family that was removed
	 */
	public static com.adjecti.pis.liferay.model.EmployeeFamily
		deleteEmployeeFamily(
			com.adjecti.pis.liferay.model.EmployeeFamily employeeFamily) {

		return getService().deleteEmployeeFamily(employeeFamily);
	}

	/**
	 * Deletes the employee family with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeFamilyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeFamilyId the primary key of the employee family
	 * @return the employee family that was removed
	 * @throws PortalException if a employee family with the primary key could not be found
	 */
	public static com.adjecti.pis.liferay.model.EmployeeFamily
			deleteEmployeeFamily(long employeeFamilyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteEmployeeFamily(employeeFamilyId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeFamilyModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeFamilyModelImpl</code>.
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

	public static com.adjecti.pis.liferay.model.EmployeeFamily
		fetchEmployeeFamily(long employeeFamilyId) {

		return getService().fetchEmployeeFamily(employeeFamilyId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<com.adjecti.pis.liferay.model.EmployeeFamily>
		getByEmployeeId(long employeeId) {

		return getService().getByEmployeeId(employeeId);
	}

	public static java.util.List<com.adjecti.pis.liferay.model.EmployeeFamily>
		getByPersonalNo(String personalNo) {

		return getService().getByPersonalNo(personalNo);
	}

	/**
	 * Returns a range of all the employee families.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeFamilyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee families
	 * @param end the upper bound of the range of employee families (not inclusive)
	 * @return the range of employee families
	 */
	public static java.util.List<com.adjecti.pis.liferay.model.EmployeeFamily>
		getEmployeeFamilies(int start, int end) {

		return getService().getEmployeeFamilies(start, end);
	}

	/**
	 * Returns the number of employee families.
	 *
	 * @return the number of employee families
	 */
	public static int getEmployeeFamiliesCount() {
		return getService().getEmployeeFamiliesCount();
	}

	/**
	 * Returns the employee family with the primary key.
	 *
	 * @param employeeFamilyId the primary key of the employee family
	 * @return the employee family
	 * @throws PortalException if a employee family with the primary key could not be found
	 */
	public static com.adjecti.pis.liferay.model.EmployeeFamily
			getEmployeeFamily(long employeeFamilyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getEmployeeFamily(employeeFamilyId);
	}

	public static int getEmployeeFamilyCountByOccupationId(long occupationId) {
		return getService().getEmployeeFamilyCountByOccupationId(occupationId);
	}

	public static int getEmployeeFamilyCountByRelationId(long relationId) {
		return getService().getEmployeeFamilyCountByRelationId(relationId);
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
	 * Updates the employee family in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeFamilyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeFamily the employee family
	 * @return the employee family that was updated
	 */
	public static com.adjecti.pis.liferay.model.EmployeeFamily
		updateEmployeeFamily(
			com.adjecti.pis.liferay.model.EmployeeFamily employeeFamily) {

		return getService().updateEmployeeFamily(employeeFamily);
	}

	public static EmployeeFamilyLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeeFamilyLocalService, EmployeeFamilyLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EmployeeFamilyLocalService.class);

		ServiceTracker<EmployeeFamilyLocalService, EmployeeFamilyLocalService>
			serviceTracker =
				new ServiceTracker
					<EmployeeFamilyLocalService, EmployeeFamilyLocalService>(
						bundle.getBundleContext(),
						EmployeeFamilyLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}