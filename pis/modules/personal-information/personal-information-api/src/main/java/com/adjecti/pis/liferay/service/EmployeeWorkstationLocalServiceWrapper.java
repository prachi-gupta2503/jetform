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
 * Provides a wrapper for {@link EmployeeWorkstationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeWorkstationLocalService
 * @generated
 */
public class EmployeeWorkstationLocalServiceWrapper
	implements EmployeeWorkstationLocalService,
			   ServiceWrapper<EmployeeWorkstationLocalService> {

	public EmployeeWorkstationLocalServiceWrapper(
		EmployeeWorkstationLocalService employeeWorkstationLocalService) {

		_employeeWorkstationLocalService = employeeWorkstationLocalService;
	}

	/**
	 * Adds the employee workstation to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeWorkstationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeWorkstation the employee workstation
	 * @return the employee workstation that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeWorkstation
		addEmployeeWorkstation(
			com.adjecti.pis.liferay.model.EmployeeWorkstation
				employeeWorkstation) {

		return _employeeWorkstationLocalService.addEmployeeWorkstation(
			employeeWorkstation);
	}

	/**
	 * Creates a new employee workstation with the primary key. Does not add the employee workstation to the database.
	 *
	 * @param employeeWorkstationId the primary key for the new employee workstation
	 * @return the new employee workstation
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeWorkstation
		createEmployeeWorkstation(long employeeWorkstationId) {

		return _employeeWorkstationLocalService.createEmployeeWorkstation(
			employeeWorkstationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeWorkstationLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the employee workstation from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeWorkstationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeWorkstation the employee workstation
	 * @return the employee workstation that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeWorkstation
		deleteEmployeeWorkstation(
			com.adjecti.pis.liferay.model.EmployeeWorkstation
				employeeWorkstation) {

		return _employeeWorkstationLocalService.deleteEmployeeWorkstation(
			employeeWorkstation);
	}

	/**
	 * Deletes the employee workstation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeWorkstationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeWorkstationId the primary key of the employee workstation
	 * @return the employee workstation that was removed
	 * @throws PortalException if a employee workstation with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeWorkstation
			deleteEmployeeWorkstation(long employeeWorkstationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeWorkstationLocalService.deleteEmployeeWorkstation(
			employeeWorkstationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeWorkstationLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeWorkstationLocalService.dynamicQuery();
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

		return _employeeWorkstationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeWorkstationModelImpl</code>.
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

		return _employeeWorkstationLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeWorkstationModelImpl</code>.
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

		return _employeeWorkstationLocalService.dynamicQuery(
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

		return _employeeWorkstationLocalService.dynamicQueryCount(dynamicQuery);
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

		return _employeeWorkstationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeeWorkstation
		fetchEmployeeWorkstation(long employeeWorkstationId) {

		return _employeeWorkstationLocalService.fetchEmployeeWorkstation(
			employeeWorkstationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeWorkstationLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeWorkstation>
		getByEmployeeId(long employeeId) {

		return _employeeWorkstationLocalService.getByEmployeeId(employeeId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeWorkstation>
		getByPersonalNo(String personalNo) {

		return _employeeWorkstationLocalService.getByPersonalNo(personalNo);
	}

	/**
	 * Returns the employee workstation with the primary key.
	 *
	 * @param employeeWorkstationId the primary key of the employee workstation
	 * @return the employee workstation
	 * @throws PortalException if a employee workstation with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeWorkstation
			getEmployeeWorkstation(long employeeWorkstationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeWorkstationLocalService.getEmployeeWorkstation(
			employeeWorkstationId);
	}

	/**
	 * Returns a range of all the employee workstations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeWorkstationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee workstations
	 * @param end the upper bound of the range of employee workstations (not inclusive)
	 * @return the range of employee workstations
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeWorkstation>
		getEmployeeWorkstations(int start, int end) {

		return _employeeWorkstationLocalService.getEmployeeWorkstations(
			start, end);
	}

	/**
	 * Returns the number of employee workstations.
	 *
	 * @return the number of employee workstations
	 */
	@Override
	public int getEmployeeWorkstationsCount() {
		return _employeeWorkstationLocalService.getEmployeeWorkstationsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeWorkstationLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeWorkstationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeWorkstationLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the employee workstation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeWorkstationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeWorkstation the employee workstation
	 * @return the employee workstation that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeWorkstation
		updateEmployeeWorkstation(
			com.adjecti.pis.liferay.model.EmployeeWorkstation
				employeeWorkstation) {

		return _employeeWorkstationLocalService.updateEmployeeWorkstation(
			employeeWorkstation);
	}

	@Override
	public EmployeeWorkstationLocalService getWrappedService() {
		return _employeeWorkstationLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeWorkstationLocalService employeeWorkstationLocalService) {

		_employeeWorkstationLocalService = employeeWorkstationLocalService;
	}

	private EmployeeWorkstationLocalService _employeeWorkstationLocalService;

}