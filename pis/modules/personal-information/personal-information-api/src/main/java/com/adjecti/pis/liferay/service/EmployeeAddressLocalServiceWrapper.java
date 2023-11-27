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
 * Provides a wrapper for {@link EmployeeAddressLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeAddressLocalService
 * @generated
 */
public class EmployeeAddressLocalServiceWrapper
	implements EmployeeAddressLocalService,
			   ServiceWrapper<EmployeeAddressLocalService> {

	public EmployeeAddressLocalServiceWrapper(
		EmployeeAddressLocalService employeeAddressLocalService) {

		_employeeAddressLocalService = employeeAddressLocalService;
	}

	/**
	 * Adds the employee address to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeAddressLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeAddress the employee address
	 * @return the employee address that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeAddress addEmployeeAddress(
		com.adjecti.pis.liferay.model.EmployeeAddress employeeAddress) {

		return _employeeAddressLocalService.addEmployeeAddress(employeeAddress);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeeAddress addEmployeeAddress(
			long employeeId, long addressId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeAddressLocalService.addEmployeeAddress(
			employeeId, addressId);
	}

	/**
	 * Creates a new employee address with the primary key. Does not add the employee address to the database.
	 *
	 * @param employeeAddressId the primary key for the new employee address
	 * @return the new employee address
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeAddress createEmployeeAddress(
		long employeeAddressId) {

		return _employeeAddressLocalService.createEmployeeAddress(
			employeeAddressId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeAddressLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the employee address from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeAddressLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeAddress the employee address
	 * @return the employee address that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeAddress deleteEmployeeAddress(
		com.adjecti.pis.liferay.model.EmployeeAddress employeeAddress) {

		return _employeeAddressLocalService.deleteEmployeeAddress(
			employeeAddress);
	}

	/**
	 * Deletes the employee address with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeAddressLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeAddressId the primary key of the employee address
	 * @return the employee address that was removed
	 * @throws PortalException if a employee address with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeAddress deleteEmployeeAddress(
			long employeeAddressId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeAddressLocalService.deleteEmployeeAddress(
			employeeAddressId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeAddressLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeAddressLocalService.dynamicQuery();
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

		return _employeeAddressLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeAddressModelImpl</code>.
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

		return _employeeAddressLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeAddressModelImpl</code>.
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

		return _employeeAddressLocalService.dynamicQuery(
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

		return _employeeAddressLocalService.dynamicQueryCount(dynamicQuery);
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

		return _employeeAddressLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeeAddress fetchEmployeeAddress(
		long employeeAddressId) {

		return _employeeAddressLocalService.fetchEmployeeAddress(
			employeeAddressId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeAddress>
		getAccomodationTypeByAccomodationTypeId(long accomodationTypeId) {

		return _employeeAddressLocalService.
			getAccomodationTypeByAccomodationTypeId(accomodationTypeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeAddressLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeAddress>
		getByDistrictId(long districtId) {

		return _employeeAddressLocalService.getByDistrictId(districtId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeAddress>
		getByPersonalNo(String personalNo) {

		return _employeeAddressLocalService.getByPersonalNo(personalNo);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeAddress>
		getByStateId(long stateId) {

		return _employeeAddressLocalService.getByStateId(stateId);
	}

	@Override
	public void getData() {
		_employeeAddressLocalService.getData();
	}

	/**
	 * Returns the employee address with the primary key.
	 *
	 * @param employeeAddressId the primary key of the employee address
	 * @return the employee address
	 * @throws PortalException if a employee address with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeAddress getEmployeeAddress(
			long employeeAddressId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeAddressLocalService.getEmployeeAddress(
			employeeAddressId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeAddress>
		getEmployeeAddressByEmpId(long employeeId) {

		return _employeeAddressLocalService.getEmployeeAddressByEmpId(
			employeeId);
	}

	/**
	 * Returns a range of all the employee addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @return the range of employee addresses
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeAddress>
		getEmployeeAddresses(int start, int end) {

		return _employeeAddressLocalService.getEmployeeAddresses(start, end);
	}

	/**
	 * Returns the number of employee addresses.
	 *
	 * @return the number of employee addresses
	 */
	@Override
	public int getEmployeeAddressesCount() {
		return _employeeAddressLocalService.getEmployeeAddressesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeAddressLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeAddressLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeAddressLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the employee address in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeAddressLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeAddress the employee address
	 * @return the employee address that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeAddress updateEmployeeAddress(
		com.adjecti.pis.liferay.model.EmployeeAddress employeeAddress) {

		return _employeeAddressLocalService.updateEmployeeAddress(
			employeeAddress);
	}

	@Override
	public EmployeeAddressLocalService getWrappedService() {
		return _employeeAddressLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeAddressLocalService employeeAddressLocalService) {

		_employeeAddressLocalService = employeeAddressLocalService;
	}

	private EmployeeAddressLocalService _employeeAddressLocalService;

}