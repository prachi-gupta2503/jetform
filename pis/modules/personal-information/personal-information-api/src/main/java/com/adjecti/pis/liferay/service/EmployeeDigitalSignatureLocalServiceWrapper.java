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
 * Provides a wrapper for {@link EmployeeDigitalSignatureLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDigitalSignatureLocalService
 * @generated
 */
public class EmployeeDigitalSignatureLocalServiceWrapper
	implements EmployeeDigitalSignatureLocalService,
			   ServiceWrapper<EmployeeDigitalSignatureLocalService> {

	public EmployeeDigitalSignatureLocalServiceWrapper(
		EmployeeDigitalSignatureLocalService
			employeeDigitalSignatureLocalService) {

		_employeeDigitalSignatureLocalService =
			employeeDigitalSignatureLocalService;
	}

	/**
	 * Adds the employee digital signature to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDigitalSignatureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDigitalSignature the employee digital signature
	 * @return the employee digital signature that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeDigitalSignature
		addEmployeeDigitalSignature(
			com.adjecti.pis.liferay.model.EmployeeDigitalSignature
				employeeDigitalSignature) {

		return _employeeDigitalSignatureLocalService.
			addEmployeeDigitalSignature(employeeDigitalSignature);
	}

	/**
	 * Creates a new employee digital signature with the primary key. Does not add the employee digital signature to the database.
	 *
	 * @param employeeDigitalSignatureId the primary key for the new employee digital signature
	 * @return the new employee digital signature
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeDigitalSignature
		createEmployeeDigitalSignature(long employeeDigitalSignatureId) {

		return _employeeDigitalSignatureLocalService.
			createEmployeeDigitalSignature(employeeDigitalSignatureId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDigitalSignatureLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the employee digital signature from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDigitalSignatureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDigitalSignature the employee digital signature
	 * @return the employee digital signature that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeDigitalSignature
		deleteEmployeeDigitalSignature(
			com.adjecti.pis.liferay.model.EmployeeDigitalSignature
				employeeDigitalSignature) {

		return _employeeDigitalSignatureLocalService.
			deleteEmployeeDigitalSignature(employeeDigitalSignature);
	}

	/**
	 * Deletes the employee digital signature with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDigitalSignatureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDigitalSignatureId the primary key of the employee digital signature
	 * @return the employee digital signature that was removed
	 * @throws PortalException if a employee digital signature with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeDigitalSignature
			deleteEmployeeDigitalSignature(long employeeDigitalSignatureId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDigitalSignatureLocalService.
			deleteEmployeeDigitalSignature(employeeDigitalSignatureId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDigitalSignatureLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeDigitalSignatureLocalService.dynamicQuery();
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

		return _employeeDigitalSignatureLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeDigitalSignatureModelImpl</code>.
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

		return _employeeDigitalSignatureLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeDigitalSignatureModelImpl</code>.
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

		return _employeeDigitalSignatureLocalService.dynamicQuery(
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

		return _employeeDigitalSignatureLocalService.dynamicQueryCount(
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

		return _employeeDigitalSignatureLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeeDigitalSignature
		fetchEmployeeDigitalSignature(long employeeDigitalSignatureId) {

		return _employeeDigitalSignatureLocalService.
			fetchEmployeeDigitalSignature(employeeDigitalSignatureId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeDigitalSignatureLocalService.
			getActionableDynamicQuery();
	}

	/**
	 * Returns the employee digital signature with the primary key.
	 *
	 * @param employeeDigitalSignatureId the primary key of the employee digital signature
	 * @return the employee digital signature
	 * @throws PortalException if a employee digital signature with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeDigitalSignature
			getEmployeeDigitalSignature(long employeeDigitalSignatureId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDigitalSignatureLocalService.
			getEmployeeDigitalSignature(employeeDigitalSignatureId);
	}

	/**
	 * Returns a range of all the employee digital signatures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeDigitalSignatureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee digital signatures
	 * @param end the upper bound of the range of employee digital signatures (not inclusive)
	 * @return the range of employee digital signatures
	 */
	@Override
	public java.util.List
		<com.adjecti.pis.liferay.model.EmployeeDigitalSignature>
			getEmployeeDigitalSignatures(int start, int end) {

		return _employeeDigitalSignatureLocalService.
			getEmployeeDigitalSignatures(start, end);
	}

	/**
	 * Returns the number of employee digital signatures.
	 *
	 * @return the number of employee digital signatures
	 */
	@Override
	public int getEmployeeDigitalSignaturesCount() {
		return _employeeDigitalSignatureLocalService.
			getEmployeeDigitalSignaturesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeDigitalSignatureLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeDigitalSignatureLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDigitalSignatureLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the employee digital signature in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDigitalSignatureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDigitalSignature the employee digital signature
	 * @return the employee digital signature that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeDigitalSignature
		updateEmployeeDigitalSignature(
			com.adjecti.pis.liferay.model.EmployeeDigitalSignature
				employeeDigitalSignature) {

		return _employeeDigitalSignatureLocalService.
			updateEmployeeDigitalSignature(employeeDigitalSignature);
	}

	@Override
	public EmployeeDigitalSignatureLocalService getWrappedService() {
		return _employeeDigitalSignatureLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeDigitalSignatureLocalService
			employeeDigitalSignatureLocalService) {

		_employeeDigitalSignatureLocalService =
			employeeDigitalSignatureLocalService;
	}

	private EmployeeDigitalSignatureLocalService
		_employeeDigitalSignatureLocalService;

}