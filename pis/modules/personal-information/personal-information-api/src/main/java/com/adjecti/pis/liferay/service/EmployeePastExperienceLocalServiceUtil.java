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
 * Provides the local service utility for EmployeePastExperience. This utility wraps
 * <code>com.adjecti.pis.liferay.service.impl.EmployeePastExperienceLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeePastExperienceLocalService
 * @generated
 */
public class EmployeePastExperienceLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.pis.liferay.service.impl.EmployeePastExperienceLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the employee past experience to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeePastExperienceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeePastExperience the employee past experience
	 * @return the employee past experience that was added
	 */
	public static com.adjecti.pis.liferay.model.EmployeePastExperience
		addEmployeePastExperience(
			com.adjecti.pis.liferay.model.EmployeePastExperience
				employeePastExperience) {

		return getService().addEmployeePastExperience(employeePastExperience);
	}

	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeePastExperience>
				addPastExperiences(
					java.util.List
						<com.adjecti.pis.liferay.model.EmployeePastExperience>
							employeeExperiences)
			throws com.adjecti.pis.liferay.exception.
				EmployeePastExperienceException,
				   com.liferay.portal.kernel.exception.PortalException {

		return getService().addPastExperiences(employeeExperiences);
	}

	/**
	 * Creates a new employee past experience with the primary key. Does not add the employee past experience to the database.
	 *
	 * @param employeePastExperienceId the primary key for the new employee past experience
	 * @return the new employee past experience
	 */
	public static com.adjecti.pis.liferay.model.EmployeePastExperience
		createEmployeePastExperience(long employeePastExperienceId) {

		return getService().createEmployeePastExperience(
			employeePastExperienceId);
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
	 * Deletes the employee past experience from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeePastExperienceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeePastExperience the employee past experience
	 * @return the employee past experience that was removed
	 */
	public static com.adjecti.pis.liferay.model.EmployeePastExperience
		deleteEmployeePastExperience(
			com.adjecti.pis.liferay.model.EmployeePastExperience
				employeePastExperience) {

		return getService().deleteEmployeePastExperience(
			employeePastExperience);
	}

	/**
	 * Deletes the employee past experience with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeePastExperienceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeePastExperienceId the primary key of the employee past experience
	 * @return the employee past experience that was removed
	 * @throws PortalException if a employee past experience with the primary key could not be found
	 */
	public static com.adjecti.pis.liferay.model.EmployeePastExperience
			deleteEmployeePastExperience(long employeePastExperienceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteEmployeePastExperience(
			employeePastExperienceId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeePastExperienceModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeePastExperienceModelImpl</code>.
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

	public static com.adjecti.pis.liferay.model.EmployeePastExperience
		fetchEmployeePastExperience(long employeePastExperienceId) {

		return getService().fetchEmployeePastExperience(
			employeePastExperienceId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeePastExperience> getByEmployeeId(
			long employeeId) {

		return getService().getByEmployeeId(employeeId);
	}

	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeePastExperience> getByPersonalNo(
			String personalNo) {

		return getService().getByPersonalNo(personalNo);
	}

	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeePastExperience>
			getByWorkAreaMajorId(long workAreaMajorId) {

		return getService().getByWorkAreaMajorId(workAreaMajorId);
	}

	/**
	 * Returns the employee past experience with the primary key.
	 *
	 * @param employeePastExperienceId the primary key of the employee past experience
	 * @return the employee past experience
	 * @throws PortalException if a employee past experience with the primary key could not be found
	 */
	public static com.adjecti.pis.liferay.model.EmployeePastExperience
			getEmployeePastExperience(long employeePastExperienceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getEmployeePastExperience(employeePastExperienceId);
	}

	/**
	 * Returns a range of all the employee past experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeePastExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee past experiences
	 * @param end the upper bound of the range of employee past experiences (not inclusive)
	 * @return the range of employee past experiences
	 */
	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeePastExperience>
			getEmployeePastExperiences(int start, int end) {

		return getService().getEmployeePastExperiences(start, end);
	}

	public static java.util.List
		<com.adjecti.pis.liferay.model.EmployeePastExperience>
			getEmployeePastExperiencesByJoiningProcessId(
				long joiningProcessId) {

		return getService().getEmployeePastExperiencesByJoiningProcessId(
			joiningProcessId);
	}

	/**
	 * Returns the number of employee past experiences.
	 *
	 * @return the number of employee past experiences
	 */
	public static int getEmployeePastExperiencesCount() {
		return getService().getEmployeePastExperiencesCount();
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
	 * Updates the employee past experience in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeePastExperienceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeePastExperience the employee past experience
	 * @return the employee past experience that was updated
	 */
	public static com.adjecti.pis.liferay.model.EmployeePastExperience
		updateEmployeePastExperience(
			com.adjecti.pis.liferay.model.EmployeePastExperience
				employeePastExperience) {

		return getService().updateEmployeePastExperience(
			employeePastExperience);
	}

	public static EmployeePastExperienceLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeePastExperienceLocalService, EmployeePastExperienceLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EmployeePastExperienceLocalService.class);

		ServiceTracker
			<EmployeePastExperienceLocalService,
			 EmployeePastExperienceLocalService> serviceTracker =
				new ServiceTracker
					<EmployeePastExperienceLocalService,
					 EmployeePastExperienceLocalService>(
						 bundle.getBundleContext(),
						 EmployeePastExperienceLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}