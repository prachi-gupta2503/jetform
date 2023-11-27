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
 * Provides a wrapper for {@link EmployeeTrainingLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeTrainingLocalService
 * @generated
 */
public class EmployeeTrainingLocalServiceWrapper
	implements EmployeeTrainingLocalService,
			   ServiceWrapper<EmployeeTrainingLocalService> {

	public EmployeeTrainingLocalServiceWrapper(
		EmployeeTrainingLocalService employeeTrainingLocalService) {

		_employeeTrainingLocalService = employeeTrainingLocalService;
	}

	/**
	 * Adds the employee training to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeTrainingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeTraining the employee training
	 * @return the employee training that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeTraining addEmployeeTraining(
		com.adjecti.pis.liferay.model.EmployeeTraining employeeTraining) {

		return _employeeTrainingLocalService.addEmployeeTraining(
			employeeTraining);
	}

	/**
	 * Creates a new employee training with the primary key. Does not add the employee training to the database.
	 *
	 * @param employeeTrainingId the primary key for the new employee training
	 * @return the new employee training
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeTraining
		createEmployeeTraining(long employeeTrainingId) {

		return _employeeTrainingLocalService.createEmployeeTraining(
			employeeTrainingId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeTrainingLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the employee training from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeTrainingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeTraining the employee training
	 * @return the employee training that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeTraining
		deleteEmployeeTraining(
			com.adjecti.pis.liferay.model.EmployeeTraining employeeTraining) {

		return _employeeTrainingLocalService.deleteEmployeeTraining(
			employeeTraining);
	}

	/**
	 * Deletes the employee training with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeTrainingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeTrainingId the primary key of the employee training
	 * @return the employee training that was removed
	 * @throws PortalException if a employee training with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeTraining
			deleteEmployeeTraining(long employeeTrainingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeTrainingLocalService.deleteEmployeeTraining(
			employeeTrainingId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeTrainingLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeTrainingLocalService.dynamicQuery();
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

		return _employeeTrainingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeTrainingModelImpl</code>.
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

		return _employeeTrainingLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeTrainingModelImpl</code>.
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

		return _employeeTrainingLocalService.dynamicQuery(
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

		return _employeeTrainingLocalService.dynamicQueryCount(dynamicQuery);
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

		return _employeeTrainingLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeeTraining fetchEmployeeTraining(
		long employeeTrainingId) {

		return _employeeTrainingLocalService.fetchEmployeeTraining(
			employeeTrainingId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeTraining>
		findByInstituteId(long instituteId) {

		return _employeeTrainingLocalService.findByInstituteId(instituteId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeTraining>
		findByOrganizationID(long organizationId) {

		return _employeeTrainingLocalService.findByOrganizationID(
			organizationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeTrainingLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeTraining>
		getByEmployeeId(long employeeId) {

		return _employeeTrainingLocalService.getByEmployeeId(employeeId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeTraining>
		getByPersonalNo(String personalNo) {

		return _employeeTrainingLocalService.getByPersonalNo(personalNo);
	}

	/**
	 * Returns the employee training with the primary key.
	 *
	 * @param employeeTrainingId the primary key of the employee training
	 * @return the employee training
	 * @throws PortalException if a employee training with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeTraining getEmployeeTraining(
			long employeeTrainingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeTrainingLocalService.getEmployeeTraining(
			employeeTrainingId);
	}

	/**
	 * Returns a range of all the employee trainings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee trainings
	 * @param end the upper bound of the range of employee trainings (not inclusive)
	 * @return the range of employee trainings
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeTraining>
		getEmployeeTrainings(int start, int end) {

		return _employeeTrainingLocalService.getEmployeeTrainings(start, end);
	}

	/**
	 * Returns the number of employee trainings.
	 *
	 * @return the number of employee trainings
	 */
	@Override
	public int getEmployeeTrainingsCount() {
		return _employeeTrainingLocalService.getEmployeeTrainingsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeTrainingLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeTrainingLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeTrainingLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the employee training in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeTrainingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeTraining the employee training
	 * @return the employee training that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeTraining
		updateEmployeeTraining(
			com.adjecti.pis.liferay.model.EmployeeTraining employeeTraining) {

		return _employeeTrainingLocalService.updateEmployeeTraining(
			employeeTraining);
	}

	@Override
	public EmployeeTrainingLocalService getWrappedService() {
		return _employeeTrainingLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeTrainingLocalService employeeTrainingLocalService) {

		_employeeTrainingLocalService = employeeTrainingLocalService;
	}

	private EmployeeTrainingLocalService _employeeTrainingLocalService;

}