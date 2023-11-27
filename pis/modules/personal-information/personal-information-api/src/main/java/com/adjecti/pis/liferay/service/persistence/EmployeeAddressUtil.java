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

package com.adjecti.pis.liferay.service.persistence;

import com.adjecti.pis.liferay.model.EmployeeAddress;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the employee address service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.EmployeeAddressPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeAddressPersistence
 * @generated
 */
public class EmployeeAddressUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(EmployeeAddress employeeAddress) {
		getPersistence().clearCache(employeeAddress);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, EmployeeAddress> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeAddress> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeAddress> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeAddress> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeAddress> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeAddress update(EmployeeAddress employeeAddress) {
		return getPersistence().update(employeeAddress);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeAddress update(
		EmployeeAddress employeeAddress, ServiceContext serviceContext) {

		return getPersistence().update(employeeAddress, serviceContext);
	}

	/**
	 * Returns all the employee addresses where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @return the matching employee addresses
	 */
	public static List<EmployeeAddress> findByDistrictId(long districtId) {
		return getPersistence().findByDistrictId(districtId);
	}

	/**
	 * Returns a range of all the employee addresses where districtId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param districtId the district ID
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @return the range of matching employee addresses
	 */
	public static List<EmployeeAddress> findByDistrictId(
		long districtId, int start, int end) {

		return getPersistence().findByDistrictId(districtId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee addresses where districtId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param districtId the district ID
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee addresses
	 */
	public static List<EmployeeAddress> findByDistrictId(
		long districtId, int start, int end,
		OrderByComparator<EmployeeAddress> orderByComparator) {

		return getPersistence().findByDistrictId(
			districtId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee addresses where districtId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param districtId the district ID
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee addresses
	 */
	public static List<EmployeeAddress> findByDistrictId(
		long districtId, int start, int end,
		OrderByComparator<EmployeeAddress> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDistrictId(
			districtId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee address in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee address
	 * @throws NoSuchEmployeeAddressException if a matching employee address could not be found
	 */
	public static EmployeeAddress findByDistrictId_First(
			long districtId,
			OrderByComparator<EmployeeAddress> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeAddressException {

		return getPersistence().findByDistrictId_First(
			districtId, orderByComparator);
	}

	/**
	 * Returns the first employee address in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee address, or <code>null</code> if a matching employee address could not be found
	 */
	public static EmployeeAddress fetchByDistrictId_First(
		long districtId, OrderByComparator<EmployeeAddress> orderByComparator) {

		return getPersistence().fetchByDistrictId_First(
			districtId, orderByComparator);
	}

	/**
	 * Returns the last employee address in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee address
	 * @throws NoSuchEmployeeAddressException if a matching employee address could not be found
	 */
	public static EmployeeAddress findByDistrictId_Last(
			long districtId,
			OrderByComparator<EmployeeAddress> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeAddressException {

		return getPersistence().findByDistrictId_Last(
			districtId, orderByComparator);
	}

	/**
	 * Returns the last employee address in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee address, or <code>null</code> if a matching employee address could not be found
	 */
	public static EmployeeAddress fetchByDistrictId_Last(
		long districtId, OrderByComparator<EmployeeAddress> orderByComparator) {

		return getPersistence().fetchByDistrictId_Last(
			districtId, orderByComparator);
	}

	/**
	 * Returns the employee addresses before and after the current employee address in the ordered set where districtId = &#63;.
	 *
	 * @param employeeAddressId the primary key of the current employee address
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee address
	 * @throws NoSuchEmployeeAddressException if a employee address with the primary key could not be found
	 */
	public static EmployeeAddress[] findByDistrictId_PrevAndNext(
			long employeeAddressId, long districtId,
			OrderByComparator<EmployeeAddress> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeAddressException {

		return getPersistence().findByDistrictId_PrevAndNext(
			employeeAddressId, districtId, orderByComparator);
	}

	/**
	 * Removes all the employee addresses where districtId = &#63; from the database.
	 *
	 * @param districtId the district ID
	 */
	public static void removeByDistrictId(long districtId) {
		getPersistence().removeByDistrictId(districtId);
	}

	/**
	 * Returns the number of employee addresses where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @return the number of matching employee addresses
	 */
	public static int countByDistrictId(long districtId) {
		return getPersistence().countByDistrictId(districtId);
	}

	/**
	 * Returns all the employee addresses where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @return the matching employee addresses
	 */
	public static List<EmployeeAddress> findByStateId(long stateId) {
		return getPersistence().findByStateId(stateId);
	}

	/**
	 * Returns a range of all the employee addresses where stateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param stateId the state ID
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @return the range of matching employee addresses
	 */
	public static List<EmployeeAddress> findByStateId(
		long stateId, int start, int end) {

		return getPersistence().findByStateId(stateId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee addresses where stateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param stateId the state ID
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee addresses
	 */
	public static List<EmployeeAddress> findByStateId(
		long stateId, int start, int end,
		OrderByComparator<EmployeeAddress> orderByComparator) {

		return getPersistence().findByStateId(
			stateId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee addresses where stateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param stateId the state ID
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee addresses
	 */
	public static List<EmployeeAddress> findByStateId(
		long stateId, int start, int end,
		OrderByComparator<EmployeeAddress> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStateId(
			stateId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee address in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee address
	 * @throws NoSuchEmployeeAddressException if a matching employee address could not be found
	 */
	public static EmployeeAddress findByStateId_First(
			long stateId, OrderByComparator<EmployeeAddress> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeAddressException {

		return getPersistence().findByStateId_First(stateId, orderByComparator);
	}

	/**
	 * Returns the first employee address in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee address, or <code>null</code> if a matching employee address could not be found
	 */
	public static EmployeeAddress fetchByStateId_First(
		long stateId, OrderByComparator<EmployeeAddress> orderByComparator) {

		return getPersistence().fetchByStateId_First(
			stateId, orderByComparator);
	}

	/**
	 * Returns the last employee address in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee address
	 * @throws NoSuchEmployeeAddressException if a matching employee address could not be found
	 */
	public static EmployeeAddress findByStateId_Last(
			long stateId, OrderByComparator<EmployeeAddress> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeAddressException {

		return getPersistence().findByStateId_Last(stateId, orderByComparator);
	}

	/**
	 * Returns the last employee address in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee address, or <code>null</code> if a matching employee address could not be found
	 */
	public static EmployeeAddress fetchByStateId_Last(
		long stateId, OrderByComparator<EmployeeAddress> orderByComparator) {

		return getPersistence().fetchByStateId_Last(stateId, orderByComparator);
	}

	/**
	 * Returns the employee addresses before and after the current employee address in the ordered set where stateId = &#63;.
	 *
	 * @param employeeAddressId the primary key of the current employee address
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee address
	 * @throws NoSuchEmployeeAddressException if a employee address with the primary key could not be found
	 */
	public static EmployeeAddress[] findByStateId_PrevAndNext(
			long employeeAddressId, long stateId,
			OrderByComparator<EmployeeAddress> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeAddressException {

		return getPersistence().findByStateId_PrevAndNext(
			employeeAddressId, stateId, orderByComparator);
	}

	/**
	 * Removes all the employee addresses where stateId = &#63; from the database.
	 *
	 * @param stateId the state ID
	 */
	public static void removeByStateId(long stateId) {
		getPersistence().removeByStateId(stateId);
	}

	/**
	 * Returns the number of employee addresses where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @return the number of matching employee addresses
	 */
	public static int countByStateId(long stateId) {
		return getPersistence().countByStateId(stateId);
	}

	/**
	 * Returns all the employee addresses where accomodationTypeId = &#63;.
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @return the matching employee addresses
	 */
	public static List<EmployeeAddress> findByAccomodationTypeId(
		long accomodationTypeId) {

		return getPersistence().findByAccomodationTypeId(accomodationTypeId);
	}

	/**
	 * Returns a range of all the employee addresses where accomodationTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @return the range of matching employee addresses
	 */
	public static List<EmployeeAddress> findByAccomodationTypeId(
		long accomodationTypeId, int start, int end) {

		return getPersistence().findByAccomodationTypeId(
			accomodationTypeId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee addresses where accomodationTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee addresses
	 */
	public static List<EmployeeAddress> findByAccomodationTypeId(
		long accomodationTypeId, int start, int end,
		OrderByComparator<EmployeeAddress> orderByComparator) {

		return getPersistence().findByAccomodationTypeId(
			accomodationTypeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee addresses where accomodationTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee addresses
	 */
	public static List<EmployeeAddress> findByAccomodationTypeId(
		long accomodationTypeId, int start, int end,
		OrderByComparator<EmployeeAddress> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByAccomodationTypeId(
			accomodationTypeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee address in the ordered set where accomodationTypeId = &#63;.
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee address
	 * @throws NoSuchEmployeeAddressException if a matching employee address could not be found
	 */
	public static EmployeeAddress findByAccomodationTypeId_First(
			long accomodationTypeId,
			OrderByComparator<EmployeeAddress> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeAddressException {

		return getPersistence().findByAccomodationTypeId_First(
			accomodationTypeId, orderByComparator);
	}

	/**
	 * Returns the first employee address in the ordered set where accomodationTypeId = &#63;.
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee address, or <code>null</code> if a matching employee address could not be found
	 */
	public static EmployeeAddress fetchByAccomodationTypeId_First(
		long accomodationTypeId,
		OrderByComparator<EmployeeAddress> orderByComparator) {

		return getPersistence().fetchByAccomodationTypeId_First(
			accomodationTypeId, orderByComparator);
	}

	/**
	 * Returns the last employee address in the ordered set where accomodationTypeId = &#63;.
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee address
	 * @throws NoSuchEmployeeAddressException if a matching employee address could not be found
	 */
	public static EmployeeAddress findByAccomodationTypeId_Last(
			long accomodationTypeId,
			OrderByComparator<EmployeeAddress> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeAddressException {

		return getPersistence().findByAccomodationTypeId_Last(
			accomodationTypeId, orderByComparator);
	}

	/**
	 * Returns the last employee address in the ordered set where accomodationTypeId = &#63;.
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee address, or <code>null</code> if a matching employee address could not be found
	 */
	public static EmployeeAddress fetchByAccomodationTypeId_Last(
		long accomodationTypeId,
		OrderByComparator<EmployeeAddress> orderByComparator) {

		return getPersistence().fetchByAccomodationTypeId_Last(
			accomodationTypeId, orderByComparator);
	}

	/**
	 * Returns the employee addresses before and after the current employee address in the ordered set where accomodationTypeId = &#63;.
	 *
	 * @param employeeAddressId the primary key of the current employee address
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee address
	 * @throws NoSuchEmployeeAddressException if a employee address with the primary key could not be found
	 */
	public static EmployeeAddress[] findByAccomodationTypeId_PrevAndNext(
			long employeeAddressId, long accomodationTypeId,
			OrderByComparator<EmployeeAddress> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeAddressException {

		return getPersistence().findByAccomodationTypeId_PrevAndNext(
			employeeAddressId, accomodationTypeId, orderByComparator);
	}

	/**
	 * Removes all the employee addresses where accomodationTypeId = &#63; from the database.
	 *
	 * @param accomodationTypeId the accomodation type ID
	 */
	public static void removeByAccomodationTypeId(long accomodationTypeId) {
		getPersistence().removeByAccomodationTypeId(accomodationTypeId);
	}

	/**
	 * Returns the number of employee addresses where accomodationTypeId = &#63;.
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @return the number of matching employee addresses
	 */
	public static int countByAccomodationTypeId(long accomodationTypeId) {
		return getPersistence().countByAccomodationTypeId(accomodationTypeId);
	}

	/**
	 * Returns all the employee addresses where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee addresses
	 */
	public static List<EmployeeAddress> findByEmployeeId(long employeeId) {
		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns a range of all the employee addresses where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @return the range of matching employee addresses
	 */
	public static List<EmployeeAddress> findByEmployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee addresses where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee addresses
	 */
	public static List<EmployeeAddress> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeAddress> orderByComparator) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee addresses where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee addresses
	 */
	public static List<EmployeeAddress> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeAddress> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee address in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee address
	 * @throws NoSuchEmployeeAddressException if a matching employee address could not be found
	 */
	public static EmployeeAddress findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeAddress> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeAddressException {

		return getPersistence().findByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first employee address in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee address, or <code>null</code> if a matching employee address could not be found
	 */
	public static EmployeeAddress fetchByEmployeeId_First(
		long employeeId, OrderByComparator<EmployeeAddress> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee address in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee address
	 * @throws NoSuchEmployeeAddressException if a matching employee address could not be found
	 */
	public static EmployeeAddress findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeAddress> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeAddressException {

		return getPersistence().findByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee address in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee address, or <code>null</code> if a matching employee address could not be found
	 */
	public static EmployeeAddress fetchByEmployeeId_Last(
		long employeeId, OrderByComparator<EmployeeAddress> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the employee addresses before and after the current employee address in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeAddressId the primary key of the current employee address
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee address
	 * @throws NoSuchEmployeeAddressException if a employee address with the primary key could not be found
	 */
	public static EmployeeAddress[] findByEmployeeId_PrevAndNext(
			long employeeAddressId, long employeeId,
			OrderByComparator<EmployeeAddress> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeAddressException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			employeeAddressId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the employee addresses where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of employee addresses where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee addresses
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Caches the employee address in the entity cache if it is enabled.
	 *
	 * @param employeeAddress the employee address
	 */
	public static void cacheResult(EmployeeAddress employeeAddress) {
		getPersistence().cacheResult(employeeAddress);
	}

	/**
	 * Caches the employee addresses in the entity cache if it is enabled.
	 *
	 * @param employeeAddresses the employee addresses
	 */
	public static void cacheResult(List<EmployeeAddress> employeeAddresses) {
		getPersistence().cacheResult(employeeAddresses);
	}

	/**
	 * Creates a new employee address with the primary key. Does not add the employee address to the database.
	 *
	 * @param employeeAddressId the primary key for the new employee address
	 * @return the new employee address
	 */
	public static EmployeeAddress create(long employeeAddressId) {
		return getPersistence().create(employeeAddressId);
	}

	/**
	 * Removes the employee address with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeAddressId the primary key of the employee address
	 * @return the employee address that was removed
	 * @throws NoSuchEmployeeAddressException if a employee address with the primary key could not be found
	 */
	public static EmployeeAddress remove(long employeeAddressId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeAddressException {

		return getPersistence().remove(employeeAddressId);
	}

	public static EmployeeAddress updateImpl(EmployeeAddress employeeAddress) {
		return getPersistence().updateImpl(employeeAddress);
	}

	/**
	 * Returns the employee address with the primary key or throws a <code>NoSuchEmployeeAddressException</code> if it could not be found.
	 *
	 * @param employeeAddressId the primary key of the employee address
	 * @return the employee address
	 * @throws NoSuchEmployeeAddressException if a employee address with the primary key could not be found
	 */
	public static EmployeeAddress findByPrimaryKey(long employeeAddressId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeAddressException {

		return getPersistence().findByPrimaryKey(employeeAddressId);
	}

	/**
	 * Returns the employee address with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeAddressId the primary key of the employee address
	 * @return the employee address, or <code>null</code> if a employee address with the primary key could not be found
	 */
	public static EmployeeAddress fetchByPrimaryKey(long employeeAddressId) {
		return getPersistence().fetchByPrimaryKey(employeeAddressId);
	}

	/**
	 * Returns all the employee addresses.
	 *
	 * @return the employee addresses
	 */
	public static List<EmployeeAddress> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employee addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @return the range of employee addresses
	 */
	public static List<EmployeeAddress> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employee addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee addresses
	 */
	public static List<EmployeeAddress> findAll(
		int start, int end,
		OrderByComparator<EmployeeAddress> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeAddressModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee addresses
	 * @param end the upper bound of the range of employee addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee addresses
	 */
	public static List<EmployeeAddress> findAll(
		int start, int end,
		OrderByComparator<EmployeeAddress> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee addresses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee addresses.
	 *
	 * @return the number of employee addresses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeAddressPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeeAddressPersistence, EmployeeAddressPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EmployeeAddressPersistence.class);

		ServiceTracker<EmployeeAddressPersistence, EmployeeAddressPersistence>
			serviceTracker =
				new ServiceTracker
					<EmployeeAddressPersistence, EmployeeAddressPersistence>(
						bundle.getBundleContext(),
						EmployeeAddressPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}