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
 * Provides a wrapper for {@link EmployeeFamilyLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeFamilyLocalService
 * @generated
 */
public class EmployeeFamilyLocalServiceWrapper
	implements EmployeeFamilyLocalService,
			   ServiceWrapper<EmployeeFamilyLocalService> {

	public EmployeeFamilyLocalServiceWrapper(
		EmployeeFamilyLocalService employeeFamilyLocalService) {

		_employeeFamilyLocalService = employeeFamilyLocalService;
	}

	/**
	 * Adds the employee family to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeFamilyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeFamily the employee family
	 * @return the employee family that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeFamily addEmployeeFamily(
		com.adjecti.pis.liferay.model.EmployeeFamily employeeFamily) {

		return _employeeFamilyLocalService.addEmployeeFamily(employeeFamily);
	}

	/**
	 * Creates a new employee family with the primary key. Does not add the employee family to the database.
	 *
	 * @param employeeFamilyId the primary key for the new employee family
	 * @return the new employee family
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeFamily createEmployeeFamily(
		long employeeFamilyId) {

		return _employeeFamilyLocalService.createEmployeeFamily(
			employeeFamilyId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeFamilyLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the employee family from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeFamilyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeFamily the employee family
	 * @return the employee family that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeFamily deleteEmployeeFamily(
		com.adjecti.pis.liferay.model.EmployeeFamily employeeFamily) {

		return _employeeFamilyLocalService.deleteEmployeeFamily(employeeFamily);
	}

	/**
	 * Deletes the employee family with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeFamilyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeFamilyId the primary key of the employee family
	 * @return the employee family that was removed
	 * @throws PortalException if a employee family with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeFamily deleteEmployeeFamily(
			long employeeFamilyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeFamilyLocalService.deleteEmployeeFamily(
			employeeFamilyId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeFamilyLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeFamilyLocalService.dynamicQuery();
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

		return _employeeFamilyLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeFamilyModelImpl</code>.
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

		return _employeeFamilyLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeFamilyModelImpl</code>.
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

		return _employeeFamilyLocalService.dynamicQuery(
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

		return _employeeFamilyLocalService.dynamicQueryCount(dynamicQuery);
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

		return _employeeFamilyLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeeFamily fetchEmployeeFamily(
		long employeeFamilyId) {

		return _employeeFamilyLocalService.fetchEmployeeFamily(
			employeeFamilyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeFamilyLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeFamily>
		getByEmployeeId(long employeeId) {

		return _employeeFamilyLocalService.getByEmployeeId(employeeId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeFamily>
		getByPersonalNo(String personalNo) {

		return _employeeFamilyLocalService.getByPersonalNo(personalNo);
	}

	/**
	 * Returns a range of all the employee families.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeFamilyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee families
	 * @param end the upper bound of the range of employee families (not inclusive)
	 * @return the range of employee families
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeFamily>
		getEmployeeFamilies(int start, int end) {

		return _employeeFamilyLocalService.getEmployeeFamilies(start, end);
	}

	/**
	 * Returns the number of employee families.
	 *
	 * @return the number of employee families
	 */
	@Override
	public int getEmployeeFamiliesCount() {
		return _employeeFamilyLocalService.getEmployeeFamiliesCount();
	}

	/**
	 * Returns the employee family with the primary key.
	 *
	 * @param employeeFamilyId the primary key of the employee family
	 * @return the employee family
	 * @throws PortalException if a employee family with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeFamily getEmployeeFamily(
			long employeeFamilyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeFamilyLocalService.getEmployeeFamily(employeeFamilyId);
	}

	@Override
	public int getEmployeeFamilyCountByOccupationId(long occupationId) {
		return _employeeFamilyLocalService.getEmployeeFamilyCountByOccupationId(
			occupationId);
	}

	@Override
	public int getEmployeeFamilyCountByRelationId(long relationId) {
		return _employeeFamilyLocalService.getEmployeeFamilyCountByRelationId(
			relationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeFamilyLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeFamilyLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeFamilyLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the employee family in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeFamilyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeFamily the employee family
	 * @return the employee family that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeFamily updateEmployeeFamily(
		com.adjecti.pis.liferay.model.EmployeeFamily employeeFamily) {

		return _employeeFamilyLocalService.updateEmployeeFamily(employeeFamily);
	}

	@Override
	public EmployeeFamilyLocalService getWrappedService() {
		return _employeeFamilyLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeFamilyLocalService employeeFamilyLocalService) {

		_employeeFamilyLocalService = employeeFamilyLocalService;
	}

	private EmployeeFamilyLocalService _employeeFamilyLocalService;

}