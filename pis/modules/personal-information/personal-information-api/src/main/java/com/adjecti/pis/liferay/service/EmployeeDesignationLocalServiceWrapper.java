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
 * Provides a wrapper for {@link EmployeeDesignationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDesignationLocalService
 * @generated
 */
public class EmployeeDesignationLocalServiceWrapper
	implements EmployeeDesignationLocalService,
			   ServiceWrapper<EmployeeDesignationLocalService> {

	public EmployeeDesignationLocalServiceWrapper(
		EmployeeDesignationLocalService employeeDesignationLocalService) {

		_employeeDesignationLocalService = employeeDesignationLocalService;
	}

	/**
	 * Adds the employee designation to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDesignationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDesignation the employee designation
	 * @return the employee designation that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeDesignation
		addEmployeeDesignation(
			com.adjecti.pis.liferay.model.EmployeeDesignation
				employeeDesignation) {

		return _employeeDesignationLocalService.addEmployeeDesignation(
			employeeDesignation);
	}

	/**
	 * Creates a new employee designation with the primary key. Does not add the employee designation to the database.
	 *
	 * @param employeeDesignationId the primary key for the new employee designation
	 * @return the new employee designation
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeDesignation
		createEmployeeDesignation(long employeeDesignationId) {

		return _employeeDesignationLocalService.createEmployeeDesignation(
			employeeDesignationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDesignationLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the employee designation from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDesignationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDesignation the employee designation
	 * @return the employee designation that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeDesignation
		deleteEmployeeDesignation(
			com.adjecti.pis.liferay.model.EmployeeDesignation
				employeeDesignation) {

		return _employeeDesignationLocalService.deleteEmployeeDesignation(
			employeeDesignation);
	}

	/**
	 * Deletes the employee designation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDesignationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDesignationId the primary key of the employee designation
	 * @return the employee designation that was removed
	 * @throws PortalException if a employee designation with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeDesignation
			deleteEmployeeDesignation(long employeeDesignationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDesignationLocalService.deleteEmployeeDesignation(
			employeeDesignationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDesignationLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeDesignationLocalService.dynamicQuery();
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

		return _employeeDesignationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeDesignationModelImpl</code>.
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

		return _employeeDesignationLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeDesignationModelImpl</code>.
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

		return _employeeDesignationLocalService.dynamicQuery(
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

		return _employeeDesignationLocalService.dynamicQueryCount(dynamicQuery);
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

		return _employeeDesignationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeeDesignation
		fetchEmployeeDesignation(long employeeDesignationId) {

		return _employeeDesignationLocalService.fetchEmployeeDesignation(
			employeeDesignationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeDesignationLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeDesignation>
		getByEmployeeId(long employeeId) {

		return _employeeDesignationLocalService.getByEmployeeId(employeeId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeDesignation>
		getByPersonalNo(String personalNo) {

		return _employeeDesignationLocalService.getByPersonalNo(personalNo);
	}

	/**
	 * Returns the employee designation with the primary key.
	 *
	 * @param employeeDesignationId the primary key of the employee designation
	 * @return the employee designation
	 * @throws PortalException if a employee designation with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeDesignation
			getEmployeeDesignation(long employeeDesignationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDesignationLocalService.getEmployeeDesignation(
			employeeDesignationId);
	}

	/**
	 * Returns a range of all the employee designations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee designations
	 * @param end the upper bound of the range of employee designations (not inclusive)
	 * @return the range of employee designations
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeDesignation>
		getEmployeeDesignations(int start, int end) {

		return _employeeDesignationLocalService.getEmployeeDesignations(
			start, end);
	}

	/**
	 * Returns the number of employee designations.
	 *
	 * @return the number of employee designations
	 */
	@Override
	public int getEmployeeDesignationsCount() {
		return _employeeDesignationLocalService.getEmployeeDesignationsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeDesignationLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeDesignationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDesignationLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public boolean updateByEmployeeId(long employeeId, long designationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDesignationLocalService.updateByEmployeeId(
			employeeId, designationId);
	}

	/**
	 * Updates the employee designation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDesignationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDesignation the employee designation
	 * @return the employee designation that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeDesignation
		updateEmployeeDesignation(
			com.adjecti.pis.liferay.model.EmployeeDesignation
				employeeDesignation) {

		return _employeeDesignationLocalService.updateEmployeeDesignation(
			employeeDesignation);
	}

	@Override
	public EmployeeDesignationLocalService getWrappedService() {
		return _employeeDesignationLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeDesignationLocalService employeeDesignationLocalService) {

		_employeeDesignationLocalService = employeeDesignationLocalService;
	}

	private EmployeeDesignationLocalService _employeeDesignationLocalService;

}