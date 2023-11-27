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
 * Provides a wrapper for {@link EmployeeDeputationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDeputationLocalService
 * @generated
 */
public class EmployeeDeputationLocalServiceWrapper
	implements EmployeeDeputationLocalService,
			   ServiceWrapper<EmployeeDeputationLocalService> {

	public EmployeeDeputationLocalServiceWrapper(
		EmployeeDeputationLocalService employeeDeputationLocalService) {

		_employeeDeputationLocalService = employeeDeputationLocalService;
	}

	/**
	 * Adds the employee deputation to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDeputationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDeputation the employee deputation
	 * @return the employee deputation that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeDeputation
		addEmployeeDeputation(
			com.adjecti.pis.liferay.model.EmployeeDeputation
				employeeDeputation) {

		return _employeeDeputationLocalService.addEmployeeDeputation(
			employeeDeputation);
	}

	/**
	 * Creates a new employee deputation with the primary key. Does not add the employee deputation to the database.
	 *
	 * @param employeeDeputationId the primary key for the new employee deputation
	 * @return the new employee deputation
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeDeputation
		createEmployeeDeputation(long employeeDeputationId) {

		return _employeeDeputationLocalService.createEmployeeDeputation(
			employeeDeputationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDeputationLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the employee deputation from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDeputationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDeputation the employee deputation
	 * @return the employee deputation that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeDeputation
		deleteEmployeeDeputation(
			com.adjecti.pis.liferay.model.EmployeeDeputation
				employeeDeputation) {

		return _employeeDeputationLocalService.deleteEmployeeDeputation(
			employeeDeputation);
	}

	/**
	 * Deletes the employee deputation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDeputationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDeputationId the primary key of the employee deputation
	 * @return the employee deputation that was removed
	 * @throws PortalException if a employee deputation with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeDeputation
			deleteEmployeeDeputation(long employeeDeputationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDeputationLocalService.deleteEmployeeDeputation(
			employeeDeputationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDeputationLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeDeputationLocalService.dynamicQuery();
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

		return _employeeDeputationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeDeputationModelImpl</code>.
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

		return _employeeDeputationLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeDeputationModelImpl</code>.
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

		return _employeeDeputationLocalService.dynamicQuery(
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

		return _employeeDeputationLocalService.dynamicQueryCount(dynamicQuery);
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

		return _employeeDeputationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeeDeputation
		fetchEmployeeDeputation(long employeeDeputationId) {

		return _employeeDeputationLocalService.fetchEmployeeDeputation(
			employeeDeputationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeDeputationLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeDeputation>
		getByEmployeeId(long employeeId) {

		return _employeeDeputationLocalService.getByEmployeeId(employeeId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeDeputation>
		getByPersonaNo(String personalNo) {

		return _employeeDeputationLocalService.getByPersonaNo(personalNo);
	}

	/**
	 * Returns the employee deputation with the primary key.
	 *
	 * @param employeeDeputationId the primary key of the employee deputation
	 * @return the employee deputation
	 * @throws PortalException if a employee deputation with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeDeputation
			getEmployeeDeputation(long employeeDeputationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDeputationLocalService.getEmployeeDeputation(
			employeeDeputationId);
	}

	/**
	 * Returns a range of all the employee deputations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeDeputationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee deputations
	 * @param end the upper bound of the range of employee deputations (not inclusive)
	 * @return the range of employee deputations
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeDeputation>
		getEmployeeDeputations(int start, int end) {

		return _employeeDeputationLocalService.getEmployeeDeputations(
			start, end);
	}

	/**
	 * Returns the number of employee deputations.
	 *
	 * @return the number of employee deputations
	 */
	@Override
	public int getEmployeeDeputationsCount() {
		return _employeeDeputationLocalService.getEmployeeDeputationsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeDeputationLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeDeputationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDeputationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the employee deputation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDeputationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDeputation the employee deputation
	 * @return the employee deputation that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeDeputation
		updateEmployeeDeputation(
			com.adjecti.pis.liferay.model.EmployeeDeputation
				employeeDeputation) {

		return _employeeDeputationLocalService.updateEmployeeDeputation(
			employeeDeputation);
	}

	@Override
	public EmployeeDeputationLocalService getWrappedService() {
		return _employeeDeputationLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeDeputationLocalService employeeDeputationLocalService) {

		_employeeDeputationLocalService = employeeDeputationLocalService;
	}

	private EmployeeDeputationLocalService _employeeDeputationLocalService;

}