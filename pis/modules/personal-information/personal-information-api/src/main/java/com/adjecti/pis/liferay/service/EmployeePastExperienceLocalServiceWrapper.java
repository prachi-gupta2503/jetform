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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EmployeePastExperienceLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeePastExperienceLocalService
 * @generated
 */
public class EmployeePastExperienceLocalServiceWrapper
	implements EmployeePastExperienceLocalService,
			   ServiceWrapper<EmployeePastExperienceLocalService> {

	public EmployeePastExperienceLocalServiceWrapper(
		EmployeePastExperienceLocalService employeePastExperienceLocalService) {

		_employeePastExperienceLocalService =
			employeePastExperienceLocalService;
	}

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
	@Override
	public com.adjecti.pis.liferay.model.EmployeePastExperience
		addEmployeePastExperience(
			com.adjecti.pis.liferay.model.EmployeePastExperience
				employeePastExperience) {

		return _employeePastExperienceLocalService.addEmployeePastExperience(
			employeePastExperience);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeePastExperience>
			addPastExperiences(
				java.util.List
					<com.adjecti.pis.liferay.model.EmployeePastExperience>
						employeeExperiences)
		throws com.adjecti.pis.liferay.exception.
			EmployeePastExperienceException,
			   com.liferay.portal.kernel.exception.PortalException {

		return _employeePastExperienceLocalService.addPastExperiences(
			employeeExperiences);
	}

	/**
	 * Creates a new employee past experience with the primary key. Does not add the employee past experience to the database.
	 *
	 * @param employeePastExperienceId the primary key for the new employee past experience
	 * @return the new employee past experience
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeePastExperience
		createEmployeePastExperience(long employeePastExperienceId) {

		return _employeePastExperienceLocalService.createEmployeePastExperience(
			employeePastExperienceId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeePastExperienceLocalService.createPersistedModel(
			primaryKeyObj);
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
	@Override
	public com.adjecti.pis.liferay.model.EmployeePastExperience
		deleteEmployeePastExperience(
			com.adjecti.pis.liferay.model.EmployeePastExperience
				employeePastExperience) {

		return _employeePastExperienceLocalService.deleteEmployeePastExperience(
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
	@Override
	public com.adjecti.pis.liferay.model.EmployeePastExperience
			deleteEmployeePastExperience(long employeePastExperienceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeePastExperienceLocalService.deleteEmployeePastExperience(
			employeePastExperienceId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeePastExperienceLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeePastExperienceLocalService.dynamicQuery();
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

		return _employeePastExperienceLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _employeePastExperienceLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _employeePastExperienceLocalService.dynamicQuery(
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

		return _employeePastExperienceLocalService.dynamicQueryCount(
			dynamicQuery);
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

		return _employeePastExperienceLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeePastExperience
		fetchEmployeePastExperience(long employeePastExperienceId) {

		return _employeePastExperienceLocalService.fetchEmployeePastExperience(
			employeePastExperienceId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeePastExperienceLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeePastExperience>
		getByEmployeeId(long employeeId) {

		return _employeePastExperienceLocalService.getByEmployeeId(employeeId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeePastExperience>
		getByPersonalNo(String personalNo) {

		return _employeePastExperienceLocalService.getByPersonalNo(personalNo);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeePastExperience>
		getByWorkAreaMajorId(long workAreaMajorId) {

		return _employeePastExperienceLocalService.getByWorkAreaMajorId(
			workAreaMajorId);
	}

	/**
	 * Returns the employee past experience with the primary key.
	 *
	 * @param employeePastExperienceId the primary key of the employee past experience
	 * @return the employee past experience
	 * @throws PortalException if a employee past experience with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeePastExperience
			getEmployeePastExperience(long employeePastExperienceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeePastExperienceLocalService.getEmployeePastExperience(
			employeePastExperienceId);
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
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeePastExperience>
		getEmployeePastExperiences(int start, int end) {

		return _employeePastExperienceLocalService.getEmployeePastExperiences(
			start, end);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeePastExperience>
		getEmployeePastExperiencesByJoiningProcessId(long joiningProcessId) {

		return _employeePastExperienceLocalService.
			getEmployeePastExperiencesByJoiningProcessId(joiningProcessId);
	}

	/**
	 * Returns the number of employee past experiences.
	 *
	 * @return the number of employee past experiences
	 */
	@Override
	public int getEmployeePastExperiencesCount() {
		return _employeePastExperienceLocalService.
			getEmployeePastExperiencesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeePastExperienceLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeePastExperienceLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeePastExperienceLocalService.getPersistedModel(
			primaryKeyObj);
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
	@Override
	public com.adjecti.pis.liferay.model.EmployeePastExperience
		updateEmployeePastExperience(
			com.adjecti.pis.liferay.model.EmployeePastExperience
				employeePastExperience) {

		return _employeePastExperienceLocalService.updateEmployeePastExperience(
			employeePastExperience);
	}

	@Override
	public EmployeePastExperienceLocalService getWrappedService() {
		return _employeePastExperienceLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeePastExperienceLocalService employeePastExperienceLocalService) {

		_employeePastExperienceLocalService =
			employeePastExperienceLocalService;
	}

	private EmployeePastExperienceLocalService
		_employeePastExperienceLocalService;

}