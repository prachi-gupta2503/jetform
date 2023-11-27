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
 * Provides the local service utility for EmployeeQualification. This utility wraps
 * <code>com.adjecti.pis.liferay.service.impl.EmployeeQualificationLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeQualificationLocalService
 * @generated
 */
public class EmployeeQualificationLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.pis.liferay.service.impl.EmployeeQualificationLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the employee qualification to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeQualificationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeQualification the employee qualification
	 * @return the employee qualification that was added
	 */
	public static com.adjecti.pis.liferay.model.EmployeeQualification
		addEmployeeQualification(
			com.adjecti.pis.liferay.model.EmployeeQualification
				employeeQualification) {

		return getService().addEmployeeQualification(employeeQualification);
	}

	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeeQualification>
				addEmployeeQualification(
					java.util.List
						<com.adjecti.pis.liferay.model.EmployeeQualification>
							empQualification)
			throws com.adjecti.pis.liferay.exception.
				EmployeeQualificationException,
				   com.liferay.portal.kernel.exception.PortalException {

		return getService().addEmployeeQualification(empQualification);
	}

	/**
	 * Creates a new employee qualification with the primary key. Does not add the employee qualification to the database.
	 *
	 * @param employeeQualificationId the primary key for the new employee qualification
	 * @return the new employee qualification
	 */
	public static com.adjecti.pis.liferay.model.EmployeeQualification
		createEmployeeQualification(long employeeQualificationId) {

		return getService().createEmployeeQualification(
			employeeQualificationId);
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
	 * Deletes the employee qualification from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeQualificationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeQualification the employee qualification
	 * @return the employee qualification that was removed
	 */
	public static com.adjecti.pis.liferay.model.EmployeeQualification
		deleteEmployeeQualification(
			com.adjecti.pis.liferay.model.EmployeeQualification
				employeeQualification) {

		return getService().deleteEmployeeQualification(employeeQualification);
	}

	/**
	 * Deletes the employee qualification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeQualificationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeQualificationId the primary key of the employee qualification
	 * @return the employee qualification that was removed
	 * @throws PortalException if a employee qualification with the primary key could not be found
	 */
	public static com.adjecti.pis.liferay.model.EmployeeQualification
			deleteEmployeeQualification(long employeeQualificationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteEmployeeQualification(
			employeeQualificationId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeQualificationModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeQualificationModelImpl</code>.
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

	public static com.adjecti.pis.liferay.model.EmployeeQualification
		fetchEmployeeQualification(long employeeQualificationId) {

		return getService().fetchEmployeeQualification(employeeQualificationId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the employee qualification with the primary key.
	 *
	 * @param employeeQualificationId the primary key of the employee qualification
	 * @return the employee qualification
	 * @throws PortalException if a employee qualification with the primary key could not be found
	 */
	public static com.adjecti.pis.liferay.model.EmployeeQualification
			getEmployeeQualification(long employeeQualificationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getEmployeeQualification(employeeQualificationId);
	}

	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeeQualification>
			getEmployeeQualificationByEmployeeId(long employeeId) {

		return getService().getEmployeeQualificationByEmployeeId(employeeId);
	}

	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeeQualification>
			getEmployeeQualificationByPersonalNo(String personalNo) {

		return getService().getEmployeeQualificationByPersonalNo(personalNo);
	}

	public static int getEmployeeQualificationCountByEmployeeId(
		long employeeId) {

		return getService().getEmployeeQualificationCountByEmployeeId(
			employeeId);
	}

	public static int getEmployeeQualificationCountByQualificationId(
		long qualificationId) {

		return getService().getEmployeeQualificationCountByQualificationId(
			qualificationId);
	}

	public static int getEmployeeQualificationCountBySpecializationId(
		long specializationId) {

		return getService().getEmployeeQualificationCountBySpecializationId(
			specializationId);
	}

	/**
	 * Returns a range of all the employee qualifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @return the range of employee qualifications
	 */
	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeeQualification>
			getEmployeeQualifications(int start, int end) {

		return getService().getEmployeeQualifications(start, end);
	}

	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeeQualification>
			getEmployeeQualificationsByJoiningProcessId(long joiningProcessId) {

		return getService().getEmployeeQualificationsByJoiningProcessId(
			joiningProcessId);
	}

	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeeQualification>
			getEmployeeQualificationsByQualificationLevelId(
				long qualificationLevelId) {

		return getService().getEmployeeQualificationsByQualificationLevelId(
			qualificationLevelId);
	}

	/**
	 * Returns the number of employee qualifications.
	 *
	 * @return the number of employee qualifications
	 */
	public static int getEmployeeQualificationsCount() {
		return getService().getEmployeeQualificationsCount();
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
	 * Updates the employee qualification in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeQualificationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeQualification the employee qualification
	 * @return the employee qualification that was updated
	 */
	public static com.adjecti.pis.liferay.model.EmployeeQualification
		updateEmployeeQualification(
			com.adjecti.pis.liferay.model.EmployeeQualification
				employeeQualification) {

		return getService().updateEmployeeQualification(employeeQualification);
	}

	public static EmployeeQualificationLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeeQualificationLocalService, EmployeeQualificationLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EmployeeQualificationLocalService.class);

		ServiceTracker
			<EmployeeQualificationLocalService,
			 EmployeeQualificationLocalService> serviceTracker =
				new ServiceTracker
					<EmployeeQualificationLocalService,
					 EmployeeQualificationLocalService>(
						 bundle.getBundleContext(),
						 EmployeeQualificationLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}