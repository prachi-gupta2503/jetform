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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for EmployeeAddress. This utility wraps
 * <code>com.adjecti.pis.liferay.service.impl.EmployeeAddressLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeAddressLocalService
 * @generated
 */
public class EmployeeAddressLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.pis.liferay.service.impl.EmployeeAddressLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static com.adjecti.pis.liferay.model.EmployeeAddress
		addEmployeeAddress(
			com.adjecti.pis.liferay.model.EmployeeAddress employeeAddress) {

		return getService().addEmployeeAddress(employeeAddress);
	}

	public static com.adjecti.pis.liferay.model.EmployeeAddress
			addEmployeeAddress(long employeeId, long addressId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addEmployeeAddress(employeeId, addressId);
	}

	/**
	 * Creates a new employee address with the primary key. Does not add the employee address to the database.
	 *
	 * @param employeeAddressId the primary key for the new employee address
	 * @return the new employee address
	 */
	public static com.adjecti.pis.liferay.model.EmployeeAddress
		createEmployeeAddress(long employeeAddressId) {

		return getService().createEmployeeAddress(employeeAddressId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			createPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static com.adjecti.pis.liferay.model.EmployeeAddress
		deleteEmployeeAddress(
			com.adjecti.pis.liferay.model.EmployeeAddress employeeAddress) {

		return getService().deleteEmployeeAddress(employeeAddress);
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
	public static com.adjecti.pis.liferay.model.EmployeeAddress
			deleteEmployeeAddress(long employeeAddressId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteEmployeeAddress(employeeAddressId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.adjecti.pis.liferay.model.EmployeeAddress
		fetchEmployeeAddress(long employeeAddressId) {

		return getService().fetchEmployeeAddress(employeeAddressId);
	}

	public static java.util.List<com.adjecti.pis.liferay.model.EmployeeAddress>
		getAccomodationTypeByAccomodationTypeId(long accomodationTypeId) {

		return getService().getAccomodationTypeByAccomodationTypeId(
			accomodationTypeId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<com.adjecti.pis.liferay.model.EmployeeAddress>
		getByDistrictId(long districtId) {

		return getService().getByDistrictId(districtId);
	}

	public static java.util.List<com.adjecti.pis.liferay.model.EmployeeAddress>
		getByPersonalNo(String personalNo) {

		return getService().getByPersonalNo(personalNo);
	}

	public static java.util.List<com.adjecti.pis.liferay.model.EmployeeAddress>
		getByStateId(long stateId) {

		return getService().getByStateId(stateId);
	}

	public static void getData() {
		getService().getData();
	}

	/**
	 * Returns the employee address with the primary key.
	 *
	 * @param employeeAddressId the primary key of the employee address
	 * @return the employee address
	 * @throws PortalException if a employee address with the primary key could not be found
	 */
	public static com.adjecti.pis.liferay.model.EmployeeAddress
			getEmployeeAddress(long employeeAddressId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getEmployeeAddress(employeeAddressId);
	}

	public static java.util.List<com.adjecti.pis.liferay.model.EmployeeAddress>
		getEmployeeAddressByEmpId(long employeeId) {

		return getService().getEmployeeAddressByEmpId(employeeId);
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
	public static java.util.List<com.adjecti.pis.liferay.model.EmployeeAddress>
		getEmployeeAddresses(int start, int end) {

		return getService().getEmployeeAddresses(start, end);
	}

	/**
	 * Returns the number of employee addresses.
	 *
	 * @return the number of employee addresses
	 */
	public static int getEmployeeAddressesCount() {
		return getService().getEmployeeAddressesCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
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
	public static com.adjecti.pis.liferay.model.EmployeeAddress
		updateEmployeeAddress(
			com.adjecti.pis.liferay.model.EmployeeAddress employeeAddress) {

		return getService().updateEmployeeAddress(employeeAddress);
	}

	public static EmployeeAddressLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeeAddressLocalService, EmployeeAddressLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EmployeeAddressLocalService.class);

		ServiceTracker<EmployeeAddressLocalService, EmployeeAddressLocalService>
			serviceTracker =
				new ServiceTracker
					<EmployeeAddressLocalService, EmployeeAddressLocalService>(
						bundle.getBundleContext(),
						EmployeeAddressLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}