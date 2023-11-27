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
 * Provides a wrapper for {@link EmployeeSavingSchemeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeSavingSchemeLocalService
 * @generated
 */
public class EmployeeSavingSchemeLocalServiceWrapper
	implements EmployeeSavingSchemeLocalService,
			   ServiceWrapper<EmployeeSavingSchemeLocalService> {

	public EmployeeSavingSchemeLocalServiceWrapper(
		EmployeeSavingSchemeLocalService employeeSavingSchemeLocalService) {

		_employeeSavingSchemeLocalService = employeeSavingSchemeLocalService;
	}

	/**
	 * Adds the employee saving scheme to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeSavingSchemeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeSavingScheme the employee saving scheme
	 * @return the employee saving scheme that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeSavingScheme
		addEmployeeSavingScheme(
			com.adjecti.pis.liferay.model.EmployeeSavingScheme
				employeeSavingScheme) {

		return _employeeSavingSchemeLocalService.addEmployeeSavingScheme(
			employeeSavingScheme);
	}

	/**
	 * Creates a new employee saving scheme with the primary key. Does not add the employee saving scheme to the database.
	 *
	 * @param employeeSavingSchemeId the primary key for the new employee saving scheme
	 * @return the new employee saving scheme
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeSavingScheme
		createEmployeeSavingScheme(long employeeSavingSchemeId) {

		return _employeeSavingSchemeLocalService.createEmployeeSavingScheme(
			employeeSavingSchemeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeSavingSchemeLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the employee saving scheme from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeSavingSchemeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeSavingScheme the employee saving scheme
	 * @return the employee saving scheme that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeSavingScheme
		deleteEmployeeSavingScheme(
			com.adjecti.pis.liferay.model.EmployeeSavingScheme
				employeeSavingScheme) {

		return _employeeSavingSchemeLocalService.deleteEmployeeSavingScheme(
			employeeSavingScheme);
	}

	/**
	 * Deletes the employee saving scheme with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeSavingSchemeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeSavingSchemeId the primary key of the employee saving scheme
	 * @return the employee saving scheme that was removed
	 * @throws PortalException if a employee saving scheme with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeSavingScheme
			deleteEmployeeSavingScheme(long employeeSavingSchemeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeSavingSchemeLocalService.deleteEmployeeSavingScheme(
			employeeSavingSchemeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeSavingSchemeLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeSavingSchemeLocalService.dynamicQuery();
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

		return _employeeSavingSchemeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeSavingSchemeModelImpl</code>.
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

		return _employeeSavingSchemeLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeSavingSchemeModelImpl</code>.
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

		return _employeeSavingSchemeLocalService.dynamicQuery(
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

		return _employeeSavingSchemeLocalService.dynamicQueryCount(
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

		return _employeeSavingSchemeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeeSavingScheme
		fetchEmployeeSavingScheme(long employeeSavingSchemeId) {

		return _employeeSavingSchemeLocalService.fetchEmployeeSavingScheme(
			employeeSavingSchemeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeSavingSchemeLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeSavingScheme>
		getByEmployeeId(long employeeId) {

		return _employeeSavingSchemeLocalService.getByEmployeeId(employeeId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeSavingScheme>
		getByPersonalNo(String personalNo) {

		return _employeeSavingSchemeLocalService.getByPersonalNo(personalNo);
	}

	/**
	 * Returns the employee saving scheme with the primary key.
	 *
	 * @param employeeSavingSchemeId the primary key of the employee saving scheme
	 * @return the employee saving scheme
	 * @throws PortalException if a employee saving scheme with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeSavingScheme
			getEmployeeSavingScheme(long employeeSavingSchemeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeSavingSchemeLocalService.getEmployeeSavingScheme(
			employeeSavingSchemeId);
	}

	/**
	 * Returns a range of all the employee saving schemes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeSavingSchemeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee saving schemes
	 * @param end the upper bound of the range of employee saving schemes (not inclusive)
	 * @return the range of employee saving schemes
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeSavingScheme>
		getEmployeeSavingSchemes(int start, int end) {

		return _employeeSavingSchemeLocalService.getEmployeeSavingSchemes(
			start, end);
	}

	/**
	 * Returns the number of employee saving schemes.
	 *
	 * @return the number of employee saving schemes
	 */
	@Override
	public int getEmployeeSavingSchemesCount() {
		return _employeeSavingSchemeLocalService.
			getEmployeeSavingSchemesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeSavingSchemeLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeSavingSchemeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeSavingSchemeLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the employee saving scheme in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeSavingSchemeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeSavingScheme the employee saving scheme
	 * @return the employee saving scheme that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeSavingScheme
		updateEmployeeSavingScheme(
			com.adjecti.pis.liferay.model.EmployeeSavingScheme
				employeeSavingScheme) {

		return _employeeSavingSchemeLocalService.updateEmployeeSavingScheme(
			employeeSavingScheme);
	}

	@Override
	public EmployeeSavingSchemeLocalService getWrappedService() {
		return _employeeSavingSchemeLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeSavingSchemeLocalService employeeSavingSchemeLocalService) {

		_employeeSavingSchemeLocalService = employeeSavingSchemeLocalService;
	}

	private EmployeeSavingSchemeLocalService _employeeSavingSchemeLocalService;

}