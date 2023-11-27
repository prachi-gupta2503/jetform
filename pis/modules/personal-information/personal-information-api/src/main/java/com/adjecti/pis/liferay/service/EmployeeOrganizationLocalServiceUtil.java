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
 * Provides the local service utility for EmployeeOrganization. This utility wraps
 * <code>com.adjecti.pis.liferay.service.impl.EmployeeOrganizationLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeOrganizationLocalService
 * @generated
 */
public class EmployeeOrganizationLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.pis.liferay.service.impl.EmployeeOrganizationLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the employee organization to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeOrganizationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeOrganization the employee organization
	 * @return the employee organization that was added
	 */
	public static com.adjecti.pis.liferay.model.EmployeeOrganization
		addEmployeeOrganization(
			com.adjecti.pis.liferay.model.EmployeeOrganization
				employeeOrganization) {

		return getService().addEmployeeOrganization(employeeOrganization);
	}

	public static boolean beforeDeleteEmployeeOrganization(
			com.adjecti.pis.liferay.model.EmployeeOrganization entity,
			boolean logical)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().beforeDeleteEmployeeOrganization(entity, logical);
	}

	public static boolean beforeDeleteEmployeeOrganization(
			Object entity, boolean logical)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().beforeDeleteEmployeeOrganization(entity, logical);
	}

	public static boolean beforeUpdateEmployeeOrganization(
			com.adjecti.pis.liferay.model.EmployeeOrganization entity,
			java.util.Map<String, String[]> fieldValues)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().beforeUpdateEmployeeOrganization(
			entity, fieldValues);
	}

	public static boolean beforeUpdateEmployeeOrganization(
			Object entity, java.util.Map<String, String[]> fieldValues)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().beforeUpdateEmployeeOrganization(
			entity, fieldValues);
	}

	/**
	 * Creates a new employee organization with the primary key. Does not add the employee organization to the database.
	 *
	 * @param employeeOrganizationId the primary key for the new employee organization
	 * @return the new employee organization
	 */
	public static com.adjecti.pis.liferay.model.EmployeeOrganization
		createEmployeeOrganization(long employeeOrganizationId) {

		return getService().createEmployeeOrganization(employeeOrganizationId);
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
	 * Deletes the employee organization from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeOrganizationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeOrganization the employee organization
	 * @return the employee organization that was removed
	 */
	public static com.adjecti.pis.liferay.model.EmployeeOrganization
		deleteEmployeeOrganization(
			com.adjecti.pis.liferay.model.EmployeeOrganization
				employeeOrganization) {

		return getService().deleteEmployeeOrganization(employeeOrganization);
	}

	/**
	 * Deletes the employee organization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeOrganizationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeOrganizationId the primary key of the employee organization
	 * @return the employee organization that was removed
	 * @throws PortalException if a employee organization with the primary key could not be found
	 */
	public static com.adjecti.pis.liferay.model.EmployeeOrganization
			deleteEmployeeOrganization(long employeeOrganizationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteEmployeeOrganization(employeeOrganizationId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeOrganizationModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeOrganizationModelImpl</code>.
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

	public static boolean existsEmployeeOrganization(
		long employeeId, long organizationId) {

		return getService().existsEmployeeOrganization(
			employeeId, organizationId);
	}

	public static boolean existsEmployeeSubOrganization(
		long employeeId, long subOrganizationId) {

		return getService().existsEmployeeSubOrganization(
			employeeId, subOrganizationId);
	}

	public static com.adjecti.pis.liferay.model.EmployeeOrganization
		fetchEmployeeOrganization(long employeeOrganizationId) {

		return getService().fetchEmployeeOrganization(employeeOrganizationId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeeOrganization>
			getByEmployeeIdAndOrganizationId(
				long employeeId, long organizationId) {

		return getService().getByEmployeeIdAndOrganizationId(
			employeeId, organizationId);
	}

	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeeOrganization>
			getByEmployeeIdAndSubOrganizationId(
				long employeeId, long subOrganizationId) {

		return getService().getByEmployeeIdAndSubOrganizationId(
			employeeId, subOrganizationId);
	}

	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeeOrganization>
			getByOrganizationId(long organizationId) {

		return getService().getByOrganizationId(organizationId);
	}

	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeeOrganization>
			getBySubOrganizationIdAndActive(
				long subOrganizationId, boolean active) {

		return getService().getBySubOrganizationIdAndActive(
			subOrganizationId, active);
	}

	/**
	 * Returns the employee organization with the primary key.
	 *
	 * @param employeeOrganizationId the primary key of the employee organization
	 * @return the employee organization
	 * @throws PortalException if a employee organization with the primary key could not be found
	 */
	public static com.adjecti.pis.liferay.model.EmployeeOrganization
			getEmployeeOrganization(long employeeOrganizationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getEmployeeOrganization(employeeOrganizationId);
	}

	public static int getEmployeeOrganizationCountByEmployeeIdAndOrganizationId(
		long employeeId, long organizationId) {

		return getService().
			getEmployeeOrganizationCountByEmployeeIdAndOrganizationId(
				employeeId, organizationId);
	}

	public static int
		getEmployeeOrganizationCountByEmployeeIdAndSubOrganizationId(
			long employeeId, long subOrganizationId) {

		return getService().
			getEmployeeOrganizationCountByEmployeeIdAndSubOrganizationId(
				employeeId, subOrganizationId);
	}

	/**
	 * Returns a range of all the employee organizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @return the range of employee organizations
	 */
	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeeOrganization>
			getEmployeeOrganizations(int start, int end) {

		return getService().getEmployeeOrganizations(start, end);
	}

	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeeOrganization>
			getEmployeeOrganizationsByEmployeeId(long employeeId) {

		return getService().getEmployeeOrganizationsByEmployeeId(employeeId);
	}

	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeeOrganization>
			getEmployeeOrganizationsByPersonalNo(String personalNo) {

		return getService().getEmployeeOrganizationsByPersonalNo(personalNo);
	}

	/**
	 * Returns the number of employee organizations.
	 *
	 * @return the number of employee organizations
	 */
	public static int getEmployeeOrganizationsCount() {
		return getService().getEmployeeOrganizationsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static java.util.List<com.liferay.portal.kernel.model.Organization>
		getNonAssignedOrganizationsOfEmployee(
			long parentId, String type, long employeeId) {

		return getService().getNonAssignedOrganizationsOfEmployee(
			parentId, type, employeeId);
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

	public static java.util.Map<String, String> importEmployeeOrganization(
		java.util.List<java.util.Map<String, String[]>> records) {

		return getService().importEmployeeOrganization(records);
	}

	/**
	 * Updates the employee organization in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeOrganizationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeOrganization the employee organization
	 * @return the employee organization that was updated
	 */
	public static com.adjecti.pis.liferay.model.EmployeeOrganization
		updateEmployeeOrganization(
			com.adjecti.pis.liferay.model.EmployeeOrganization
				employeeOrganization) {

		return getService().updateEmployeeOrganization(employeeOrganization);
	}

	public static String updateOrganization(
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay,
		String status, long organizationId) {

		return getService().updateOrganization(
			themeDisplay, status, organizationId);
	}

	public static EmployeeOrganizationLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeeOrganizationLocalService, EmployeeOrganizationLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EmployeeOrganizationLocalService.class);

		ServiceTracker
			<EmployeeOrganizationLocalService, EmployeeOrganizationLocalService>
				serviceTracker =
					new ServiceTracker
						<EmployeeOrganizationLocalService,
						 EmployeeOrganizationLocalService>(
							 bundle.getBundleContext(),
							 EmployeeOrganizationLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}