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
 * Provides a wrapper for {@link EmployeeVerificationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeVerificationLocalService
 * @generated
 */
public class EmployeeVerificationLocalServiceWrapper
	implements EmployeeVerificationLocalService,
			   ServiceWrapper<EmployeeVerificationLocalService> {

	public EmployeeVerificationLocalServiceWrapper(
		EmployeeVerificationLocalService employeeVerificationLocalService) {

		_employeeVerificationLocalService = employeeVerificationLocalService;
	}

	/**
	 * Adds the employee verification to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeVerificationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeVerification the employee verification
	 * @return the employee verification that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeVerification
		addEmployeeVerification(
			com.adjecti.pis.liferay.model.EmployeeVerification
				employeeVerification) {

		return _employeeVerificationLocalService.addEmployeeVerification(
			employeeVerification);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeVerification>
			addEmployeeVerifications(
				java.util.List
					<com.adjecti.pis.liferay.model.EmployeeVerification>
						employeeVerifications)
		throws com.adjecti.pis.liferay.exception.EmployeeAddressException,
			   com.liferay.portal.kernel.exception.PortalException {

		return _employeeVerificationLocalService.addEmployeeVerifications(
			employeeVerifications);
	}

	/**
	 * Creates a new employee verification with the primary key. Does not add the employee verification to the database.
	 *
	 * @param employeeVerificationId the primary key for the new employee verification
	 * @return the new employee verification
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeVerification
		createEmployeeVerification(long employeeVerificationId) {

		return _employeeVerificationLocalService.createEmployeeVerification(
			employeeVerificationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeVerificationLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the employee verification from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeVerificationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeVerification the employee verification
	 * @return the employee verification that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeVerification
		deleteEmployeeVerification(
			com.adjecti.pis.liferay.model.EmployeeVerification
				employeeVerification) {

		return _employeeVerificationLocalService.deleteEmployeeVerification(
			employeeVerification);
	}

	/**
	 * Deletes the employee verification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeVerificationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeVerificationId the primary key of the employee verification
	 * @return the employee verification that was removed
	 * @throws PortalException if a employee verification with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeVerification
			deleteEmployeeVerification(long employeeVerificationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeVerificationLocalService.deleteEmployeeVerification(
			employeeVerificationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeVerificationLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeVerificationLocalService.dynamicQuery();
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

		return _employeeVerificationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeVerificationModelImpl</code>.
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

		return _employeeVerificationLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeVerificationModelImpl</code>.
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

		return _employeeVerificationLocalService.dynamicQuery(
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

		return _employeeVerificationLocalService.dynamicQueryCount(
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

		return _employeeVerificationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeeVerification
		fetchEmployeeVerification(long employeeVerificationId) {

		return _employeeVerificationLocalService.fetchEmployeeVerification(
			employeeVerificationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeVerificationLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeVerification>
		getByEmployeeId(long employeeId) {

		return _employeeVerificationLocalService.getByEmployeeId(employeeId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeVerification>
		getByPersonalNo(String personalNo) {

		return _employeeVerificationLocalService.getByPersonalNo(personalNo);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeVerification>
		getByUnitId(long organizationId) {

		return _employeeVerificationLocalService.getByUnitId(organizationId);
	}

	/**
	 * Returns the employee verification with the primary key.
	 *
	 * @param employeeVerificationId the primary key of the employee verification
	 * @return the employee verification
	 * @throws PortalException if a employee verification with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeVerification
			getEmployeeVerification(long employeeVerificationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeVerificationLocalService.getEmployeeVerification(
			employeeVerificationId);
	}

	/**
	 * Returns a range of all the employee verifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee verifications
	 * @param end the upper bound of the range of employee verifications (not inclusive)
	 * @return the range of employee verifications
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeVerification>
		getEmployeeVerifications(int start, int end) {

		return _employeeVerificationLocalService.getEmployeeVerifications(
			start, end);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeVerification>
		getEmployeeVerificationsByJoiningProcessId(long joiningProcessId) {

		return _employeeVerificationLocalService.
			getEmployeeVerificationsByJoiningProcessId(joiningProcessId);
	}

	/**
	 * Returns the number of employee verifications.
	 *
	 * @return the number of employee verifications
	 */
	@Override
	public int getEmployeeVerificationsCount() {
		return _employeeVerificationLocalService.
			getEmployeeVerificationsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeVerificationLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeVerificationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeVerificationLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the employee verification in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeVerificationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeVerification the employee verification
	 * @return the employee verification that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeVerification
		updateEmployeeVerification(
			com.adjecti.pis.liferay.model.EmployeeVerification
				employeeVerification) {

		return _employeeVerificationLocalService.updateEmployeeVerification(
			employeeVerification);
	}

	@Override
	public EmployeeVerificationLocalService getWrappedService() {
		return _employeeVerificationLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeVerificationLocalService employeeVerificationLocalService) {

		_employeeVerificationLocalService = employeeVerificationLocalService;
	}

	private EmployeeVerificationLocalService _employeeVerificationLocalService;

}