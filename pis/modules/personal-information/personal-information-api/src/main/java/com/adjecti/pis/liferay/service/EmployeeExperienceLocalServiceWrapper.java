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
 * Provides a wrapper for {@link EmployeeExperienceLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeExperienceLocalService
 * @generated
 */
public class EmployeeExperienceLocalServiceWrapper
	implements EmployeeExperienceLocalService,
			   ServiceWrapper<EmployeeExperienceLocalService> {

	public EmployeeExperienceLocalServiceWrapper(
		EmployeeExperienceLocalService employeeExperienceLocalService) {

		_employeeExperienceLocalService = employeeExperienceLocalService;
	}

	/**
	 * Adds the employee experience to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeExperienceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeExperience the employee experience
	 * @return the employee experience that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeExperience
		addEmployeeExperience(
			com.adjecti.pis.liferay.model.EmployeeExperience
				employeeExperience) {

		return _employeeExperienceLocalService.addEmployeeExperience(
			employeeExperience);
	}

	/**
	 * Creates a new employee experience with the primary key. Does not add the employee experience to the database.
	 *
	 * @param employeeExperienceId the primary key for the new employee experience
	 * @return the new employee experience
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeExperience
		createEmployeeExperience(long employeeExperienceId) {

		return _employeeExperienceLocalService.createEmployeeExperience(
			employeeExperienceId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeExperienceLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the employee experience from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeExperienceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeExperience the employee experience
	 * @return the employee experience that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeExperience
		deleteEmployeeExperience(
			com.adjecti.pis.liferay.model.EmployeeExperience
				employeeExperience) {

		return _employeeExperienceLocalService.deleteEmployeeExperience(
			employeeExperience);
	}

	/**
	 * Deletes the employee experience with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeExperienceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeExperienceId the primary key of the employee experience
	 * @return the employee experience that was removed
	 * @throws PortalException if a employee experience with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeExperience
			deleteEmployeeExperience(long employeeExperienceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeExperienceLocalService.deleteEmployeeExperience(
			employeeExperienceId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeExperienceLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeExperienceLocalService.dynamicQuery();
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

		return _employeeExperienceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeExperienceModelImpl</code>.
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

		return _employeeExperienceLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeExperienceModelImpl</code>.
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

		return _employeeExperienceLocalService.dynamicQuery(
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

		return _employeeExperienceLocalService.dynamicQueryCount(dynamicQuery);
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

		return _employeeExperienceLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeeExperience
		fetchEmployeeExperience(long employeeExperienceId) {

		return _employeeExperienceLocalService.fetchEmployeeExperience(
			employeeExperienceId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeExperienceLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeExperience>
		getByEmployeeId(long employeeId) {

		return _employeeExperienceLocalService.getByEmployeeId(employeeId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeExperience>
		getByPersonalNo(String personalNo) {

		return _employeeExperienceLocalService.getByPersonalNo(personalNo);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeExperience>
		getByUnitId(long organizationId) {

		return _employeeExperienceLocalService.getByUnitId(organizationId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeExperience>
		getByWorkAreaMajorId(long workAreaMajorId) {

		return _employeeExperienceLocalService.getByWorkAreaMajorId(
			workAreaMajorId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeExperience>
		getByWorkAreaMinorId(long workAreaMinorId) {

		return _employeeExperienceLocalService.getByWorkAreaMinorId(
			workAreaMinorId);
	}

	/**
	 * Returns the employee experience with the primary key.
	 *
	 * @param employeeExperienceId the primary key of the employee experience
	 * @return the employee experience
	 * @throws PortalException if a employee experience with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeExperience
			getEmployeeExperience(long employeeExperienceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeExperienceLocalService.getEmployeeExperience(
			employeeExperienceId);
	}

	/**
	 * Returns a range of all the employee experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @return the range of employee experiences
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeExperience>
		getEmployeeExperiences(int start, int end) {

		return _employeeExperienceLocalService.getEmployeeExperiences(
			start, end);
	}

	/**
	 * Returns the number of employee experiences.
	 *
	 * @return the number of employee experiences
	 */
	@Override
	public int getEmployeeExperiencesCount() {
		return _employeeExperienceLocalService.getEmployeeExperiencesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeExperienceLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeExperienceLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeExperienceLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the employee experience in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeExperienceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeExperience the employee experience
	 * @return the employee experience that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeExperience
		updateEmployeeExperience(
			com.adjecti.pis.liferay.model.EmployeeExperience
				employeeExperience) {

		return _employeeExperienceLocalService.updateEmployeeExperience(
			employeeExperience);
	}

	@Override
	public EmployeeExperienceLocalService getWrappedService() {
		return _employeeExperienceLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeExperienceLocalService employeeExperienceLocalService) {

		_employeeExperienceLocalService = employeeExperienceLocalService;
	}

	private EmployeeExperienceLocalService _employeeExperienceLocalService;

}