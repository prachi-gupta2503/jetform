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
 * Provides the local service utility for EmployeeConfirmation. This utility wraps
 * <code>com.adjecti.pis.liferay.service.impl.EmployeeConfirmationLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeConfirmationLocalService
 * @generated
 */
public class EmployeeConfirmationLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.pis.liferay.service.impl.EmployeeConfirmationLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the employee confirmation to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeConfirmationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeConfirmation the employee confirmation
	 * @return the employee confirmation that was added
	 */
	public static com.adjecti.pis.liferay.model.EmployeeConfirmation
		addEmployeeConfirmation(
			com.adjecti.pis.liferay.model.EmployeeConfirmation
				employeeConfirmation) {

		return getService().addEmployeeConfirmation(employeeConfirmation);
	}

	/**
	 * Creates a new employee confirmation with the primary key. Does not add the employee confirmation to the database.
	 *
	 * @param employeeConfirmationId the primary key for the new employee confirmation
	 * @return the new employee confirmation
	 */
	public static com.adjecti.pis.liferay.model.EmployeeConfirmation
		createEmployeeConfirmation(long employeeConfirmationId) {

		return getService().createEmployeeConfirmation(employeeConfirmationId);
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
	 * Deletes the employee confirmation from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeConfirmationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeConfirmation the employee confirmation
	 * @return the employee confirmation that was removed
	 */
	public static com.adjecti.pis.liferay.model.EmployeeConfirmation
		deleteEmployeeConfirmation(
			com.adjecti.pis.liferay.model.EmployeeConfirmation
				employeeConfirmation) {

		return getService().deleteEmployeeConfirmation(employeeConfirmation);
	}

	/**
	 * Deletes the employee confirmation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeConfirmationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeConfirmationId the primary key of the employee confirmation
	 * @return the employee confirmation that was removed
	 * @throws PortalException if a employee confirmation with the primary key could not be found
	 */
	public static com.adjecti.pis.liferay.model.EmployeeConfirmation
			deleteEmployeeConfirmation(long employeeConfirmationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteEmployeeConfirmation(employeeConfirmationId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeConfirmationModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeConfirmationModelImpl</code>.
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

	public static com.adjecti.pis.liferay.model.EmployeeConfirmation
		fetchEmployeeConfirmation(long employeeConfirmationId) {

		return getService().fetchEmployeeConfirmation(employeeConfirmationId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeeConfirmation> getByEmployeeId(
			long employeeId) {

		return getService().getByEmployeeId(employeeId);
	}

	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeeConfirmation>
			getByOrganizationId(long organizationId) {

		return getService().getByOrganizationId(organizationId);
	}

	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeeConfirmation> getByPersonalNo(
			String personalNo) {

		return getService().getByPersonalNo(personalNo);
	}

	/**
	 * Returns the employee confirmation with the primary key.
	 *
	 * @param employeeConfirmationId the primary key of the employee confirmation
	 * @return the employee confirmation
	 * @throws PortalException if a employee confirmation with the primary key could not be found
	 */
	public static com.adjecti.pis.liferay.model.EmployeeConfirmation
			getEmployeeConfirmation(long employeeConfirmationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getEmployeeConfirmation(employeeConfirmationId);
	}

	/**
	 * Returns a range of all the employee confirmations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeConfirmationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee confirmations
	 * @param end the upper bound of the range of employee confirmations (not inclusive)
	 * @return the range of employee confirmations
	 */
	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeeConfirmation>
			getEmployeeConfirmations(int start, int end) {

		return getService().getEmployeeConfirmations(start, end);
	}

	/**
	 * Returns the number of employee confirmations.
	 *
	 * @return the number of employee confirmations
	 */
	public static int getEmployeeConfirmationsCount() {
		return getService().getEmployeeConfirmationsCount();
	}

	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeeConfirmation>
			getGradeModeByGradeModeId(long gradeModeId) {

		return getService().getGradeModeByGradeModeId(gradeModeId);
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
	 * Updates the employee confirmation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeConfirmationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeConfirmation the employee confirmation
	 * @return the employee confirmation that was updated
	 */
	public static com.adjecti.pis.liferay.model.EmployeeConfirmation
		updateEmployeeConfirmation(
			com.adjecti.pis.liferay.model.EmployeeConfirmation
				employeeConfirmation) {

		return getService().updateEmployeeConfirmation(employeeConfirmation);
	}

	public static EmployeeConfirmationLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeeConfirmationLocalService, EmployeeConfirmationLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EmployeeConfirmationLocalService.class);

		ServiceTracker
			<EmployeeConfirmationLocalService, EmployeeConfirmationLocalService>
				serviceTracker =
					new ServiceTracker
						<EmployeeConfirmationLocalService,
						 EmployeeConfirmationLocalService>(
							 bundle.getBundleContext(),
							 EmployeeConfirmationLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}