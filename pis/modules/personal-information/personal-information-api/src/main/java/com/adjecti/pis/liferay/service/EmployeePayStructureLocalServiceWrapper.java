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
 * Provides a wrapper for {@link EmployeePayStructureLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeePayStructureLocalService
 * @generated
 */
public class EmployeePayStructureLocalServiceWrapper
	implements EmployeePayStructureLocalService,
			   ServiceWrapper<EmployeePayStructureLocalService> {

	public EmployeePayStructureLocalServiceWrapper(
		EmployeePayStructureLocalService employeePayStructureLocalService) {

		_employeePayStructureLocalService = employeePayStructureLocalService;
	}

	/**
	 * Adds the employee pay structure to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeePayStructureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeePayStructure the employee pay structure
	 * @return the employee pay structure that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeePayStructure
		addEmployeePayStructure(
			com.adjecti.pis.liferay.model.EmployeePayStructure
				employeePayStructure) {

		return _employeePayStructureLocalService.addEmployeePayStructure(
			employeePayStructure);
	}

	/**
	 * Creates a new employee pay structure with the primary key. Does not add the employee pay structure to the database.
	 *
	 * @param employeePayStructureId the primary key for the new employee pay structure
	 * @return the new employee pay structure
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeePayStructure
		createEmployeePayStructure(long employeePayStructureId) {

		return _employeePayStructureLocalService.createEmployeePayStructure(
			employeePayStructureId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeePayStructureLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the employee pay structure from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeePayStructureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeePayStructure the employee pay structure
	 * @return the employee pay structure that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeePayStructure
		deleteEmployeePayStructure(
			com.adjecti.pis.liferay.model.EmployeePayStructure
				employeePayStructure) {

		return _employeePayStructureLocalService.deleteEmployeePayStructure(
			employeePayStructure);
	}

	/**
	 * Deletes the employee pay structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeePayStructureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeePayStructureId the primary key of the employee pay structure
	 * @return the employee pay structure that was removed
	 * @throws PortalException if a employee pay structure with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeePayStructure
			deleteEmployeePayStructure(long employeePayStructureId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeePayStructureLocalService.deleteEmployeePayStructure(
			employeePayStructureId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeePayStructureLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeePayStructureLocalService.dynamicQuery();
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

		return _employeePayStructureLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeePayStructureModelImpl</code>.
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

		return _employeePayStructureLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeePayStructureModelImpl</code>.
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

		return _employeePayStructureLocalService.dynamicQuery(
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

		return _employeePayStructureLocalService.dynamicQueryCount(
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

		return _employeePayStructureLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeePayStructure
		fetchEmployeePayStructure(long employeePayStructureId) {

		return _employeePayStructureLocalService.fetchEmployeePayStructure(
			employeePayStructureId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeePayStructureLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeePayStructure>
		getByEmployeeId(long employeeId) {

		return _employeePayStructureLocalService.getByEmployeeId(employeeId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeePayStructure>
		getByPersonalNo(String personalNo) {

		return _employeePayStructureLocalService.getByPersonalNo(personalNo);
	}

	/**
	 * Returns the employee pay structure with the primary key.
	 *
	 * @param employeePayStructureId the primary key of the employee pay structure
	 * @return the employee pay structure
	 * @throws PortalException if a employee pay structure with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeePayStructure
			getEmployeePayStructure(long employeePayStructureId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeePayStructureLocalService.getEmployeePayStructure(
			employeePayStructureId);
	}

	/**
	 * Returns a range of all the employee pay structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeePayStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee pay structures
	 * @param end the upper bound of the range of employee pay structures (not inclusive)
	 * @return the range of employee pay structures
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeePayStructure>
		getEmployeePayStructures(int start, int end) {

		return _employeePayStructureLocalService.getEmployeePayStructures(
			start, end);
	}

	/**
	 * Returns the number of employee pay structures.
	 *
	 * @return the number of employee pay structures
	 */
	@Override
	public int getEmployeePayStructuresCount() {
		return _employeePayStructureLocalService.
			getEmployeePayStructuresCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeePayStructureLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeePayStructureLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeePayStructureLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the employee pay structure in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeePayStructureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeePayStructure the employee pay structure
	 * @return the employee pay structure that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeePayStructure
		updateEmployeePayStructure(
			com.adjecti.pis.liferay.model.EmployeePayStructure
				employeePayStructure) {

		return _employeePayStructureLocalService.updateEmployeePayStructure(
			employeePayStructure);
	}

	@Override
	public EmployeePayStructureLocalService getWrappedService() {
		return _employeePayStructureLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeePayStructureLocalService employeePayStructureLocalService) {

		_employeePayStructureLocalService = employeePayStructureLocalService;
	}

	private EmployeePayStructureLocalService _employeePayStructureLocalService;

}