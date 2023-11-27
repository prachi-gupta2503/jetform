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
 * Provides a wrapper for {@link EmployeeWorkAreaLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeWorkAreaLocalService
 * @generated
 */
public class EmployeeWorkAreaLocalServiceWrapper
	implements EmployeeWorkAreaLocalService,
			   ServiceWrapper<EmployeeWorkAreaLocalService> {

	public EmployeeWorkAreaLocalServiceWrapper(
		EmployeeWorkAreaLocalService employeeWorkAreaLocalService) {

		_employeeWorkAreaLocalService = employeeWorkAreaLocalService;
	}

	/**
	 * Adds the employee work area to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeWorkAreaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeWorkArea the employee work area
	 * @return the employee work area that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeWorkArea addEmployeeWorkArea(
		com.adjecti.pis.liferay.model.EmployeeWorkArea employeeWorkArea) {

		return _employeeWorkAreaLocalService.addEmployeeWorkArea(
			employeeWorkArea);
	}

	/**
	 * Creates a new employee work area with the primary key. Does not add the employee work area to the database.
	 *
	 * @param employeeWorkAreaId the primary key for the new employee work area
	 * @return the new employee work area
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeWorkArea
		createEmployeeWorkArea(long employeeWorkAreaId) {

		return _employeeWorkAreaLocalService.createEmployeeWorkArea(
			employeeWorkAreaId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeWorkAreaLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the employee work area from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeWorkAreaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeWorkArea the employee work area
	 * @return the employee work area that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeWorkArea
		deleteEmployeeWorkArea(
			com.adjecti.pis.liferay.model.EmployeeWorkArea employeeWorkArea) {

		return _employeeWorkAreaLocalService.deleteEmployeeWorkArea(
			employeeWorkArea);
	}

	/**
	 * Deletes the employee work area with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeWorkAreaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeWorkAreaId the primary key of the employee work area
	 * @return the employee work area that was removed
	 * @throws PortalException if a employee work area with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeWorkArea
			deleteEmployeeWorkArea(long employeeWorkAreaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeWorkAreaLocalService.deleteEmployeeWorkArea(
			employeeWorkAreaId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeWorkAreaLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeWorkAreaLocalService.dynamicQuery();
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

		return _employeeWorkAreaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeWorkAreaModelImpl</code>.
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

		return _employeeWorkAreaLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeWorkAreaModelImpl</code>.
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

		return _employeeWorkAreaLocalService.dynamicQuery(
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

		return _employeeWorkAreaLocalService.dynamicQueryCount(dynamicQuery);
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

		return _employeeWorkAreaLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeeWorkArea fetchEmployeeWorkArea(
		long employeeWorkAreaId) {

		return _employeeWorkAreaLocalService.fetchEmployeeWorkArea(
			employeeWorkAreaId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeWorkArea>
		findByWorkAreaId(long workAreaId) {

		return _employeeWorkAreaLocalService.findByWorkAreaId(workAreaId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeWorkAreaLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeWorkArea>
		getByEmployeeId(long employeeId) {

		return _employeeWorkAreaLocalService.getByEmployeeId(employeeId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeWorkArea>
		getByPersonalNo(String personalNo) {

		return _employeeWorkAreaLocalService.getByPersonalNo(personalNo);
	}

	/**
	 * Returns the employee work area with the primary key.
	 *
	 * @param employeeWorkAreaId the primary key of the employee work area
	 * @return the employee work area
	 * @throws PortalException if a employee work area with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeWorkArea getEmployeeWorkArea(
			long employeeWorkAreaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeWorkAreaLocalService.getEmployeeWorkArea(
			employeeWorkAreaId);
	}

	/**
	 * Returns a range of all the employee work areas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeWorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee work areas
	 * @param end the upper bound of the range of employee work areas (not inclusive)
	 * @return the range of employee work areas
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeWorkArea>
		getEmployeeWorkAreas(int start, int end) {

		return _employeeWorkAreaLocalService.getEmployeeWorkAreas(start, end);
	}

	/**
	 * Returns the number of employee work areas.
	 *
	 * @return the number of employee work areas
	 */
	@Override
	public int getEmployeeWorkAreasCount() {
		return _employeeWorkAreaLocalService.getEmployeeWorkAreasCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeWorkAreaLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeWorkAreaLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeWorkAreaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the employee work area in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeWorkAreaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeWorkArea the employee work area
	 * @return the employee work area that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeWorkArea
		updateEmployeeWorkArea(
			com.adjecti.pis.liferay.model.EmployeeWorkArea employeeWorkArea) {

		return _employeeWorkAreaLocalService.updateEmployeeWorkArea(
			employeeWorkArea);
	}

	@Override
	public EmployeeWorkAreaLocalService getWrappedService() {
		return _employeeWorkAreaLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeWorkAreaLocalService employeeWorkAreaLocalService) {

		_employeeWorkAreaLocalService = employeeWorkAreaLocalService;
	}

	private EmployeeWorkAreaLocalService _employeeWorkAreaLocalService;

}