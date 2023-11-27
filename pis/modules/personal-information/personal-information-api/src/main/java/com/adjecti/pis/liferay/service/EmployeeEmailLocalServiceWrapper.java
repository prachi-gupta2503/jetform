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
 * Provides a wrapper for {@link EmployeeEmailLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeEmailLocalService
 * @generated
 */
public class EmployeeEmailLocalServiceWrapper
	implements EmployeeEmailLocalService,
			   ServiceWrapper<EmployeeEmailLocalService> {

	public EmployeeEmailLocalServiceWrapper(
		EmployeeEmailLocalService employeeEmailLocalService) {

		_employeeEmailLocalService = employeeEmailLocalService;
	}

	/**
	 * Adds the employee email to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeEmailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeEmail the employee email
	 * @return the employee email that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeEmail addEmployeeEmail(
		com.adjecti.pis.liferay.model.EmployeeEmail employeeEmail) {

		return _employeeEmailLocalService.addEmployeeEmail(employeeEmail);
	}

	/**
	 * Creates a new employee email with the primary key. Does not add the employee email to the database.
	 *
	 * @param employeeEmailId the primary key for the new employee email
	 * @return the new employee email
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeEmail createEmployeeEmail(
		long employeeEmailId) {

		return _employeeEmailLocalService.createEmployeeEmail(employeeEmailId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeEmailLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the employee email from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeEmailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeEmail the employee email
	 * @return the employee email that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeEmail deleteEmployeeEmail(
		com.adjecti.pis.liferay.model.EmployeeEmail employeeEmail) {

		return _employeeEmailLocalService.deleteEmployeeEmail(employeeEmail);
	}

	/**
	 * Deletes the employee email with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeEmailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeEmailId the primary key of the employee email
	 * @return the employee email that was removed
	 * @throws PortalException if a employee email with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeEmail deleteEmployeeEmail(
			long employeeEmailId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeEmailLocalService.deleteEmployeeEmail(employeeEmailId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeEmailLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeEmailLocalService.dynamicQuery();
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

		return _employeeEmailLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeEmailModelImpl</code>.
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

		return _employeeEmailLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeEmailModelImpl</code>.
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

		return _employeeEmailLocalService.dynamicQuery(
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

		return _employeeEmailLocalService.dynamicQueryCount(dynamicQuery);
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

		return _employeeEmailLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeeEmail fetchEmployeeEmail(
		long employeeEmailId) {

		return _employeeEmailLocalService.fetchEmployeeEmail(employeeEmailId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeEmailLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the employee email with the primary key.
	 *
	 * @param employeeEmailId the primary key of the employee email
	 * @return the employee email
	 * @throws PortalException if a employee email with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeEmail getEmployeeEmail(
			long employeeEmailId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeEmailLocalService.getEmployeeEmail(employeeEmailId);
	}

	/**
	 * Returns a range of all the employee emails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeEmailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee emails
	 * @param end the upper bound of the range of employee emails (not inclusive)
	 * @return the range of employee emails
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeEmail>
		getEmployeeEmails(int start, int end) {

		return _employeeEmailLocalService.getEmployeeEmails(start, end);
	}

	/**
	 * Returns the number of employee emails.
	 *
	 * @return the number of employee emails
	 */
	@Override
	public int getEmployeeEmailsCount() {
		return _employeeEmailLocalService.getEmployeeEmailsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeEmailLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeEmailLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeEmailLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the employee email in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeEmailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeEmail the employee email
	 * @return the employee email that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeEmail updateEmployeeEmail(
		com.adjecti.pis.liferay.model.EmployeeEmail employeeEmail) {

		return _employeeEmailLocalService.updateEmployeeEmail(employeeEmail);
	}

	@Override
	public EmployeeEmailLocalService getWrappedService() {
		return _employeeEmailLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeEmailLocalService employeeEmailLocalService) {

		_employeeEmailLocalService = employeeEmailLocalService;
	}

	private EmployeeEmailLocalService _employeeEmailLocalService;

}