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
 * Provides a wrapper for {@link EmployeeConfirmationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeConfirmationLocalService
 * @generated
 */
public class EmployeeConfirmationLocalServiceWrapper
	implements EmployeeConfirmationLocalService,
			   ServiceWrapper<EmployeeConfirmationLocalService> {

	public EmployeeConfirmationLocalServiceWrapper(
		EmployeeConfirmationLocalService employeeConfirmationLocalService) {

		_employeeConfirmationLocalService = employeeConfirmationLocalService;
	}

	/**
	 * Adds the employee confirmation to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeConfirmationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeConfirmation the employee confirmation
	 * @return the employee confirmation that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeConfirmation
		addEmployeeConfirmation(
			com.adjecti.pis.liferay.model.EmployeeConfirmation
				employeeConfirmation) {

		return _employeeConfirmationLocalService.addEmployeeConfirmation(
			employeeConfirmation);
	}

	/**
	 * Creates a new employee confirmation with the primary key. Does not add the employee confirmation to the database.
	 *
	 * @param employeeConfirmationId the primary key for the new employee confirmation
	 * @return the new employee confirmation
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeConfirmation
		createEmployeeConfirmation(long employeeConfirmationId) {

		return _employeeConfirmationLocalService.createEmployeeConfirmation(
			employeeConfirmationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeConfirmationLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the employee confirmation from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeConfirmationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeConfirmation the employee confirmation
	 * @return the employee confirmation that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeConfirmation
		deleteEmployeeConfirmation(
			com.adjecti.pis.liferay.model.EmployeeConfirmation
				employeeConfirmation) {

		return _employeeConfirmationLocalService.deleteEmployeeConfirmation(
			employeeConfirmation);
	}

	/**
	 * Deletes the employee confirmation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeConfirmationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeConfirmationId the primary key of the employee confirmation
	 * @return the employee confirmation that was removed
	 * @throws PortalException if a employee confirmation with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeConfirmation
			deleteEmployeeConfirmation(long employeeConfirmationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeConfirmationLocalService.deleteEmployeeConfirmation(
			employeeConfirmationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeConfirmationLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeConfirmationLocalService.dynamicQuery();
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

		return _employeeConfirmationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeConfirmationModelImpl</code>.
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

		return _employeeConfirmationLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeConfirmationModelImpl</code>.
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

		return _employeeConfirmationLocalService.dynamicQuery(
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

		return _employeeConfirmationLocalService.dynamicQueryCount(
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

		return _employeeConfirmationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeeConfirmation
		fetchEmployeeConfirmation(long employeeConfirmationId) {

		return _employeeConfirmationLocalService.fetchEmployeeConfirmation(
			employeeConfirmationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeConfirmationLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeConfirmation>
		getByEmployeeId(long employeeId) {

		return _employeeConfirmationLocalService.getByEmployeeId(employeeId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeConfirmation>
		getByOrganizationId(long organizationId) {

		return _employeeConfirmationLocalService.getByOrganizationId(
			organizationId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeConfirmation>
		getByPersonalNo(String personalNo) {

		return _employeeConfirmationLocalService.getByPersonalNo(personalNo);
	}

	/**
	 * Returns the employee confirmation with the primary key.
	 *
	 * @param employeeConfirmationId the primary key of the employee confirmation
	 * @return the employee confirmation
	 * @throws PortalException if a employee confirmation with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeConfirmation
			getEmployeeConfirmation(long employeeConfirmationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeConfirmationLocalService.getEmployeeConfirmation(
			employeeConfirmationId);
	}

	/**
	 * Returns a range of all the employee confirmations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeConfirmationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee confirmations
	 * @param end the upper bound of the range of employee confirmations (not inclusive)
	 * @return the range of employee confirmations
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeConfirmation>
		getEmployeeConfirmations(int start, int end) {

		return _employeeConfirmationLocalService.getEmployeeConfirmations(
			start, end);
	}

	/**
	 * Returns the number of employee confirmations.
	 *
	 * @return the number of employee confirmations
	 */
	@Override
	public int getEmployeeConfirmationsCount() {
		return _employeeConfirmationLocalService.
			getEmployeeConfirmationsCount();
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeConfirmation>
		getGradeModeByGradeModeId(long gradeModeId) {

		return _employeeConfirmationLocalService.getGradeModeByGradeModeId(
			gradeModeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeConfirmationLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeConfirmationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeConfirmationLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the employee confirmation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeConfirmationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeConfirmation the employee confirmation
	 * @return the employee confirmation that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeConfirmation
		updateEmployeeConfirmation(
			com.adjecti.pis.liferay.model.EmployeeConfirmation
				employeeConfirmation) {

		return _employeeConfirmationLocalService.updateEmployeeConfirmation(
			employeeConfirmation);
	}

	@Override
	public EmployeeConfirmationLocalService getWrappedService() {
		return _employeeConfirmationLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeConfirmationLocalService employeeConfirmationLocalService) {

		_employeeConfirmationLocalService = employeeConfirmationLocalService;
	}

	private EmployeeConfirmationLocalService _employeeConfirmationLocalService;

}