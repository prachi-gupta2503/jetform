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
 * Provides a wrapper for {@link EmployeeDelegationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDelegationLocalService
 * @generated
 */
public class EmployeeDelegationLocalServiceWrapper
	implements EmployeeDelegationLocalService,
			   ServiceWrapper<EmployeeDelegationLocalService> {

	public EmployeeDelegationLocalServiceWrapper(
		EmployeeDelegationLocalService employeeDelegationLocalService) {

		_employeeDelegationLocalService = employeeDelegationLocalService;
	}

	/**
	 * Adds the employee delegation to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDelegationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDelegation the employee delegation
	 * @return the employee delegation that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeDelegation
		addEmployeeDelegation(
			com.adjecti.pis.liferay.model.EmployeeDelegation
				employeeDelegation) {

		return _employeeDelegationLocalService.addEmployeeDelegation(
			employeeDelegation);
	}

	/**
	 * Creates a new employee delegation with the primary key. Does not add the employee delegation to the database.
	 *
	 * @param employeeDelegationId the primary key for the new employee delegation
	 * @return the new employee delegation
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeDelegation
		createEmployeeDelegation(long employeeDelegationId) {

		return _employeeDelegationLocalService.createEmployeeDelegation(
			employeeDelegationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDelegationLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the employee delegation from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDelegationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDelegation the employee delegation
	 * @return the employee delegation that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeDelegation
		deleteEmployeeDelegation(
			com.adjecti.pis.liferay.model.EmployeeDelegation
				employeeDelegation) {

		return _employeeDelegationLocalService.deleteEmployeeDelegation(
			employeeDelegation);
	}

	/**
	 * Deletes the employee delegation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDelegationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDelegationId the primary key of the employee delegation
	 * @return the employee delegation that was removed
	 * @throws PortalException if a employee delegation with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeDelegation
			deleteEmployeeDelegation(long employeeDelegationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDelegationLocalService.deleteEmployeeDelegation(
			employeeDelegationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDelegationLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeDelegationLocalService.dynamicQuery();
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

		return _employeeDelegationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeDelegationModelImpl</code>.
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

		return _employeeDelegationLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeDelegationModelImpl</code>.
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

		return _employeeDelegationLocalService.dynamicQuery(
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

		return _employeeDelegationLocalService.dynamicQueryCount(dynamicQuery);
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

		return _employeeDelegationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeeDelegation
		fetchEmployeeDelegation(long employeeDelegationId) {

		return _employeeDelegationLocalService.fetchEmployeeDelegation(
			employeeDelegationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeDelegationLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeDelegation>
		getByEmployeeId(long employeeId) {

		return _employeeDelegationLocalService.getByEmployeeId(employeeId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeDelegation>
		getByPersonalNo(String personalNo) {

		return _employeeDelegationLocalService.getByPersonalNo(personalNo);
	}

	/**
	 * Returns the employee delegation with the primary key.
	 *
	 * @param employeeDelegationId the primary key of the employee delegation
	 * @return the employee delegation
	 * @throws PortalException if a employee delegation with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeDelegation
			getEmployeeDelegation(long employeeDelegationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDelegationLocalService.getEmployeeDelegation(
			employeeDelegationId);
	}

	/**
	 * Returns a range of all the employee delegations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeDelegationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee delegations
	 * @param end the upper bound of the range of employee delegations (not inclusive)
	 * @return the range of employee delegations
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeDelegation>
		getEmployeeDelegations(int start, int end) {

		return _employeeDelegationLocalService.getEmployeeDelegations(
			start, end);
	}

	/**
	 * Returns the number of employee delegations.
	 *
	 * @return the number of employee delegations
	 */
	@Override
	public int getEmployeeDelegationsCount() {
		return _employeeDelegationLocalService.getEmployeeDelegationsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeDelegationLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeDelegationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDelegationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the employee delegation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDelegationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDelegation the employee delegation
	 * @return the employee delegation that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeDelegation
		updateEmployeeDelegation(
			com.adjecti.pis.liferay.model.EmployeeDelegation
				employeeDelegation) {

		return _employeeDelegationLocalService.updateEmployeeDelegation(
			employeeDelegation);
	}

	@Override
	public EmployeeDelegationLocalService getWrappedService() {
		return _employeeDelegationLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeDelegationLocalService employeeDelegationLocalService) {

		_employeeDelegationLocalService = employeeDelegationLocalService;
	}

	private EmployeeDelegationLocalService _employeeDelegationLocalService;

}