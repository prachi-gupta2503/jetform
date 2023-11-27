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

import com.adjecti.pis.liferay.model.Address;

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
 * The persistence utility for the address service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.AddressPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AddressPersistence
 * @generated
 */
public class AddressUtil {

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
	public static void clearCache(Address address) {
		getPersistence().clearCache(address);
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
	public static Map<Serializable, Address> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Address> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Address> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Address> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Address> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Address update(Address address) {
		return getPersistence().update(address);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Address update(
		Address address, ServiceContext serviceContext) {

		return getPersistence().update(address, serviceContext);
	}

	/**
	 * Returns all the addresses where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the matching addresses
	 */
	public static List<Address> findByJoiningProcessId(long joiningProcessId) {
		return getPersistence().findByJoiningProcessId(joiningProcessId);
	}

	/**
	 * Returns a range of all the addresses where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @return the range of matching addresses
	 */
	public static List<Address> findByJoiningProcessId(
		long joiningProcessId, int start, int end) {

		return getPersistence().findByJoiningProcessId(
			joiningProcessId, start, end);
	}

	/**
	 * Returns an ordered range of all the addresses where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching addresses
	 */
	public static List<Address> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		OrderByComparator<Address> orderByComparator) {

		return getPersistence().findByJoiningProcessId(
			joiningProcessId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the addresses where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching addresses
	 */
	public static List<Address> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		OrderByComparator<Address> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByJoiningProcessId(
			joiningProcessId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first address in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	public static Address findByJoiningProcessId_First(
			long joiningProcessId, OrderByComparator<Address> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchAddressException {

		return getPersistence().findByJoiningProcessId_First(
			joiningProcessId, orderByComparator);
	}

	/**
	 * Returns the first address in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address, or <code>null</code> if a matching address could not be found
	 */
	public static Address fetchByJoiningProcessId_First(
		long joiningProcessId, OrderByComparator<Address> orderByComparator) {

		return getPersistence().fetchByJoiningProcessId_First(
			joiningProcessId, orderByComparator);
	}

	/**
	 * Returns the last address in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	public static Address findByJoiningProcessId_Last(
			long joiningProcessId, OrderByComparator<Address> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchAddressException {

		return getPersistence().findByJoiningProcessId_Last(
			joiningProcessId, orderByComparator);
	}

	/**
	 * Returns the last address in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address, or <code>null</code> if a matching address could not be found
	 */
	public static Address fetchByJoiningProcessId_Last(
		long joiningProcessId, OrderByComparator<Address> orderByComparator) {

		return getPersistence().fetchByJoiningProcessId_Last(
			joiningProcessId, orderByComparator);
	}

	/**
	 * Returns the addresses before and after the current address in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param addressId the primary key of the current address
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next address
	 * @throws NoSuchAddressException if a address with the primary key could not be found
	 */
	public static Address[] findByJoiningProcessId_PrevAndNext(
			long addressId, long joiningProcessId,
			OrderByComparator<Address> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchAddressException {

		return getPersistence().findByJoiningProcessId_PrevAndNext(
			addressId, joiningProcessId, orderByComparator);
	}

	/**
	 * Removes all the addresses where joiningProcessId = &#63; from the database.
	 *
	 * @param joiningProcessId the joining process ID
	 */
	public static void removeByJoiningProcessId(long joiningProcessId) {
		getPersistence().removeByJoiningProcessId(joiningProcessId);
	}

	/**
	 * Returns the number of addresses where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the number of matching addresses
	 */
	public static int countByJoiningProcessId(long joiningProcessId) {
		return getPersistence().countByJoiningProcessId(joiningProcessId);
	}

	/**
	 * Returns all the addresses where accomodationTypeId = &#63;.
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @return the matching addresses
	 */
	public static List<Address> findByAccomodationTypeId(
		long accomodationTypeId) {

		return getPersistence().findByAccomodationTypeId(accomodationTypeId);
	}

	/**
	 * Returns a range of all the addresses where accomodationTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @return the range of matching addresses
	 */
	public static List<Address> findByAccomodationTypeId(
		long accomodationTypeId, int start, int end) {

		return getPersistence().findByAccomodationTypeId(
			accomodationTypeId, start, end);
	}

	/**
	 * Returns an ordered range of all the addresses where accomodationTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching addresses
	 */
	public static List<Address> findByAccomodationTypeId(
		long accomodationTypeId, int start, int end,
		OrderByComparator<Address> orderByComparator) {

		return getPersistence().findByAccomodationTypeId(
			accomodationTypeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the addresses where accomodationTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching addresses
	 */
	public static List<Address> findByAccomodationTypeId(
		long accomodationTypeId, int start, int end,
		OrderByComparator<Address> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByAccomodationTypeId(
			accomodationTypeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first address in the ordered set where accomodationTypeId = &#63;.
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	public static Address findByAccomodationTypeId_First(
			long accomodationTypeId,
			OrderByComparator<Address> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchAddressException {

		return getPersistence().findByAccomodationTypeId_First(
			accomodationTypeId, orderByComparator);
	}

	/**
	 * Returns the first address in the ordered set where accomodationTypeId = &#63;.
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address, or <code>null</code> if a matching address could not be found
	 */
	public static Address fetchByAccomodationTypeId_First(
		long accomodationTypeId, OrderByComparator<Address> orderByComparator) {

		return getPersistence().fetchByAccomodationTypeId_First(
			accomodationTypeId, orderByComparator);
	}

	/**
	 * Returns the last address in the ordered set where accomodationTypeId = &#63;.
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	public static Address findByAccomodationTypeId_Last(
			long accomodationTypeId,
			OrderByComparator<Address> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchAddressException {

		return getPersistence().findByAccomodationTypeId_Last(
			accomodationTypeId, orderByComparator);
	}

	/**
	 * Returns the last address in the ordered set where accomodationTypeId = &#63;.
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address, or <code>null</code> if a matching address could not be found
	 */
	public static Address fetchByAccomodationTypeId_Last(
		long accomodationTypeId, OrderByComparator<Address> orderByComparator) {

		return getPersistence().fetchByAccomodationTypeId_Last(
			accomodationTypeId, orderByComparator);
	}

	/**
	 * Returns the addresses before and after the current address in the ordered set where accomodationTypeId = &#63;.
	 *
	 * @param addressId the primary key of the current address
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next address
	 * @throws NoSuchAddressException if a address with the primary key could not be found
	 */
	public static Address[] findByAccomodationTypeId_PrevAndNext(
			long addressId, long accomodationTypeId,
			OrderByComparator<Address> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchAddressException {

		return getPersistence().findByAccomodationTypeId_PrevAndNext(
			addressId, accomodationTypeId, orderByComparator);
	}

	/**
	 * Removes all the addresses where accomodationTypeId = &#63; from the database.
	 *
	 * @param accomodationTypeId the accomodation type ID
	 */
	public static void removeByAccomodationTypeId(long accomodationTypeId) {
		getPersistence().removeByAccomodationTypeId(accomodationTypeId);
	}

	/**
	 * Returns the number of addresses where accomodationTypeId = &#63;.
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @return the number of matching addresses
	 */
	public static int countByAccomodationTypeId(long accomodationTypeId) {
		return getPersistence().countByAccomodationTypeId(accomodationTypeId);
	}

	/**
	 * Returns all the addresses where joiningProcessId = &#63; and accomodationTypeId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param accomodationTypeId the accomodation type ID
	 * @return the matching addresses
	 */
	public static List<Address> findByJoiningProcessIdAndAccomodationTypeId(
		long joiningProcessId, long accomodationTypeId) {

		return getPersistence().findByJoiningProcessIdAndAccomodationTypeId(
			joiningProcessId, accomodationTypeId);
	}

	/**
	 * Returns a range of all the addresses where joiningProcessId = &#63; and accomodationTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param accomodationTypeId the accomodation type ID
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @return the range of matching addresses
	 */
	public static List<Address> findByJoiningProcessIdAndAccomodationTypeId(
		long joiningProcessId, long accomodationTypeId, int start, int end) {

		return getPersistence().findByJoiningProcessIdAndAccomodationTypeId(
			joiningProcessId, accomodationTypeId, start, end);
	}

	/**
	 * Returns an ordered range of all the addresses where joiningProcessId = &#63; and accomodationTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param accomodationTypeId the accomodation type ID
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching addresses
	 */
	public static List<Address> findByJoiningProcessIdAndAccomodationTypeId(
		long joiningProcessId, long accomodationTypeId, int start, int end,
		OrderByComparator<Address> orderByComparator) {

		return getPersistence().findByJoiningProcessIdAndAccomodationTypeId(
			joiningProcessId, accomodationTypeId, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the addresses where joiningProcessId = &#63; and accomodationTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param accomodationTypeId the accomodation type ID
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching addresses
	 */
	public static List<Address> findByJoiningProcessIdAndAccomodationTypeId(
		long joiningProcessId, long accomodationTypeId, int start, int end,
		OrderByComparator<Address> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByJoiningProcessIdAndAccomodationTypeId(
			joiningProcessId, accomodationTypeId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first address in the ordered set where joiningProcessId = &#63; and accomodationTypeId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	public static Address findByJoiningProcessIdAndAccomodationTypeId_First(
			long joiningProcessId, long accomodationTypeId,
			OrderByComparator<Address> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchAddressException {

		return getPersistence().
			findByJoiningProcessIdAndAccomodationTypeId_First(
				joiningProcessId, accomodationTypeId, orderByComparator);
	}

	/**
	 * Returns the first address in the ordered set where joiningProcessId = &#63; and accomodationTypeId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address, or <code>null</code> if a matching address could not be found
	 */
	public static Address fetchByJoiningProcessIdAndAccomodationTypeId_First(
		long joiningProcessId, long accomodationTypeId,
		OrderByComparator<Address> orderByComparator) {

		return getPersistence().
			fetchByJoiningProcessIdAndAccomodationTypeId_First(
				joiningProcessId, accomodationTypeId, orderByComparator);
	}

	/**
	 * Returns the last address in the ordered set where joiningProcessId = &#63; and accomodationTypeId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	public static Address findByJoiningProcessIdAndAccomodationTypeId_Last(
			long joiningProcessId, long accomodationTypeId,
			OrderByComparator<Address> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchAddressException {

		return getPersistence().
			findByJoiningProcessIdAndAccomodationTypeId_Last(
				joiningProcessId, accomodationTypeId, orderByComparator);
	}

	/**
	 * Returns the last address in the ordered set where joiningProcessId = &#63; and accomodationTypeId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address, or <code>null</code> if a matching address could not be found
	 */
	public static Address fetchByJoiningProcessIdAndAccomodationTypeId_Last(
		long joiningProcessId, long accomodationTypeId,
		OrderByComparator<Address> orderByComparator) {

		return getPersistence().
			fetchByJoiningProcessIdAndAccomodationTypeId_Last(
				joiningProcessId, accomodationTypeId, orderByComparator);
	}

	/**
	 * Returns the addresses before and after the current address in the ordered set where joiningProcessId = &#63; and accomodationTypeId = &#63;.
	 *
	 * @param addressId the primary key of the current address
	 * @param joiningProcessId the joining process ID
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next address
	 * @throws NoSuchAddressException if a address with the primary key could not be found
	 */
	public static Address[]
			findByJoiningProcessIdAndAccomodationTypeId_PrevAndNext(
				long addressId, long joiningProcessId, long accomodationTypeId,
				OrderByComparator<Address> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchAddressException {

		return getPersistence().
			findByJoiningProcessIdAndAccomodationTypeId_PrevAndNext(
				addressId, joiningProcessId, accomodationTypeId,
				orderByComparator);
	}

	/**
	 * Removes all the addresses where joiningProcessId = &#63; and accomodationTypeId = &#63; from the database.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param accomodationTypeId the accomodation type ID
	 */
	public static void removeByJoiningProcessIdAndAccomodationTypeId(
		long joiningProcessId, long accomodationTypeId) {

		getPersistence().removeByJoiningProcessIdAndAccomodationTypeId(
			joiningProcessId, accomodationTypeId);
	}

	/**
	 * Returns the number of addresses where joiningProcessId = &#63; and accomodationTypeId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param accomodationTypeId the accomodation type ID
	 * @return the number of matching addresses
	 */
	public static int countByJoiningProcessIdAndAccomodationTypeId(
		long joiningProcessId, long accomodationTypeId) {

		return getPersistence().countByJoiningProcessIdAndAccomodationTypeId(
			joiningProcessId, accomodationTypeId);
	}

	/**
	 * Returns all the addresses where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @return the matching addresses
	 */
	public static List<Address> findByDistrictId(long districtId) {
		return getPersistence().findByDistrictId(districtId);
	}

	/**
	 * Returns a range of all the addresses where districtId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param districtId the district ID
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @return the range of matching addresses
	 */
	public static List<Address> findByDistrictId(
		long districtId, int start, int end) {

		return getPersistence().findByDistrictId(districtId, start, end);
	}

	/**
	 * Returns an ordered range of all the addresses where districtId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param districtId the district ID
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching addresses
	 */
	public static List<Address> findByDistrictId(
		long districtId, int start, int end,
		OrderByComparator<Address> orderByComparator) {

		return getPersistence().findByDistrictId(
			districtId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the addresses where districtId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param districtId the district ID
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching addresses
	 */
	public static List<Address> findByDistrictId(
		long districtId, int start, int end,
		OrderByComparator<Address> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByDistrictId(
			districtId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first address in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	public static Address findByDistrictId_First(
			long districtId, OrderByComparator<Address> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchAddressException {

		return getPersistence().findByDistrictId_First(
			districtId, orderByComparator);
	}

	/**
	 * Returns the first address in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address, or <code>null</code> if a matching address could not be found
	 */
	public static Address fetchByDistrictId_First(
		long districtId, OrderByComparator<Address> orderByComparator) {

		return getPersistence().fetchByDistrictId_First(
			districtId, orderByComparator);
	}

	/**
	 * Returns the last address in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	public static Address findByDistrictId_Last(
			long districtId, OrderByComparator<Address> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchAddressException {

		return getPersistence().findByDistrictId_Last(
			districtId, orderByComparator);
	}

	/**
	 * Returns the last address in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address, or <code>null</code> if a matching address could not be found
	 */
	public static Address fetchByDistrictId_Last(
		long districtId, OrderByComparator<Address> orderByComparator) {

		return getPersistence().fetchByDistrictId_Last(
			districtId, orderByComparator);
	}

	/**
	 * Returns the addresses before and after the current address in the ordered set where districtId = &#63;.
	 *
	 * @param addressId the primary key of the current address
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next address
	 * @throws NoSuchAddressException if a address with the primary key could not be found
	 */
	public static Address[] findByDistrictId_PrevAndNext(
			long addressId, long districtId,
			OrderByComparator<Address> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchAddressException {

		return getPersistence().findByDistrictId_PrevAndNext(
			addressId, districtId, orderByComparator);
	}

	/**
	 * Removes all the addresses where districtId = &#63; from the database.
	 *
	 * @param districtId the district ID
	 */
	public static void removeByDistrictId(long districtId) {
		getPersistence().removeByDistrictId(districtId);
	}

	/**
	 * Returns the number of addresses where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @return the number of matching addresses
	 */
	public static int countByDistrictId(long districtId) {
		return getPersistence().countByDistrictId(districtId);
	}

	/**
	 * Returns all the addresses where addressId = &#63;.
	 *
	 * @param addressId the address ID
	 * @return the matching addresses
	 */
	public static List<Address> findByAddressId(long addressId) {
		return getPersistence().findByAddressId(addressId);
	}

	/**
	 * Returns a range of all the addresses where addressId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param addressId the address ID
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @return the range of matching addresses
	 */
	public static List<Address> findByAddressId(
		long addressId, int start, int end) {

		return getPersistence().findByAddressId(addressId, start, end);
	}

	/**
	 * Returns an ordered range of all the addresses where addressId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param addressId the address ID
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching addresses
	 */
	public static List<Address> findByAddressId(
		long addressId, int start, int end,
		OrderByComparator<Address> orderByComparator) {

		return getPersistence().findByAddressId(
			addressId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the addresses where addressId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param addressId the address ID
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching addresses
	 */
	public static List<Address> findByAddressId(
		long addressId, int start, int end,
		OrderByComparator<Address> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByAddressId(
			addressId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first address in the ordered set where addressId = &#63;.
	 *
	 * @param addressId the address ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	public static Address findByAddressId_First(
			long addressId, OrderByComparator<Address> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchAddressException {

		return getPersistence().findByAddressId_First(
			addressId, orderByComparator);
	}

	/**
	 * Returns the first address in the ordered set where addressId = &#63;.
	 *
	 * @param addressId the address ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address, or <code>null</code> if a matching address could not be found
	 */
	public static Address fetchByAddressId_First(
		long addressId, OrderByComparator<Address> orderByComparator) {

		return getPersistence().fetchByAddressId_First(
			addressId, orderByComparator);
	}

	/**
	 * Returns the last address in the ordered set where addressId = &#63;.
	 *
	 * @param addressId the address ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	public static Address findByAddressId_Last(
			long addressId, OrderByComparator<Address> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchAddressException {

		return getPersistence().findByAddressId_Last(
			addressId, orderByComparator);
	}

	/**
	 * Returns the last address in the ordered set where addressId = &#63;.
	 *
	 * @param addressId the address ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address, or <code>null</code> if a matching address could not be found
	 */
	public static Address fetchByAddressId_Last(
		long addressId, OrderByComparator<Address> orderByComparator) {

		return getPersistence().fetchByAddressId_Last(
			addressId, orderByComparator);
	}

	/**
	 * Removes all the addresses where addressId = &#63; from the database.
	 *
	 * @param addressId the address ID
	 */
	public static void removeByAddressId(long addressId) {
		getPersistence().removeByAddressId(addressId);
	}

	/**
	 * Returns the number of addresses where addressId = &#63;.
	 *
	 * @param addressId the address ID
	 * @return the number of matching addresses
	 */
	public static int countByAddressId(long addressId) {
		return getPersistence().countByAddressId(addressId);
	}

	/**
	 * Returns all the addresses where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @return the matching addresses
	 */
	public static List<Address> findByStateId(long stateId) {
		return getPersistence().findByStateId(stateId);
	}

	/**
	 * Returns a range of all the addresses where stateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param stateId the state ID
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @return the range of matching addresses
	 */
	public static List<Address> findByStateId(
		long stateId, int start, int end) {

		return getPersistence().findByStateId(stateId, start, end);
	}

	/**
	 * Returns an ordered range of all the addresses where stateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param stateId the state ID
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching addresses
	 */
	public static List<Address> findByStateId(
		long stateId, int start, int end,
		OrderByComparator<Address> orderByComparator) {

		return getPersistence().findByStateId(
			stateId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the addresses where stateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param stateId the state ID
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching addresses
	 */
	public static List<Address> findByStateId(
		long stateId, int start, int end,
		OrderByComparator<Address> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByStateId(
			stateId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first address in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	public static Address findByStateId_First(
			long stateId, OrderByComparator<Address> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchAddressException {

		return getPersistence().findByStateId_First(stateId, orderByComparator);
	}

	/**
	 * Returns the first address in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address, or <code>null</code> if a matching address could not be found
	 */
	public static Address fetchByStateId_First(
		long stateId, OrderByComparator<Address> orderByComparator) {

		return getPersistence().fetchByStateId_First(
			stateId, orderByComparator);
	}

	/**
	 * Returns the last address in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	public static Address findByStateId_Last(
			long stateId, OrderByComparator<Address> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchAddressException {

		return getPersistence().findByStateId_Last(stateId, orderByComparator);
	}

	/**
	 * Returns the last address in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address, or <code>null</code> if a matching address could not be found
	 */
	public static Address fetchByStateId_Last(
		long stateId, OrderByComparator<Address> orderByComparator) {

		return getPersistence().fetchByStateId_Last(stateId, orderByComparator);
	}

	/**
	 * Returns the addresses before and after the current address in the ordered set where stateId = &#63;.
	 *
	 * @param addressId the primary key of the current address
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next address
	 * @throws NoSuchAddressException if a address with the primary key could not be found
	 */
	public static Address[] findByStateId_PrevAndNext(
			long addressId, long stateId,
			OrderByComparator<Address> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchAddressException {

		return getPersistence().findByStateId_PrevAndNext(
			addressId, stateId, orderByComparator);
	}

	/**
	 * Removes all the addresses where stateId = &#63; from the database.
	 *
	 * @param stateId the state ID
	 */
	public static void removeByStateId(long stateId) {
		getPersistence().removeByStateId(stateId);
	}

	/**
	 * Returns the number of addresses where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @return the number of matching addresses
	 */
	public static int countByStateId(long stateId) {
		return getPersistence().countByStateId(stateId);
	}

	/**
	 * Caches the address in the entity cache if it is enabled.
	 *
	 * @param address the address
	 */
	public static void cacheResult(Address address) {
		getPersistence().cacheResult(address);
	}

	/**
	 * Caches the addresses in the entity cache if it is enabled.
	 *
	 * @param addresses the addresses
	 */
	public static void cacheResult(List<Address> addresses) {
		getPersistence().cacheResult(addresses);
	}

	/**
	 * Creates a new address with the primary key. Does not add the address to the database.
	 *
	 * @param addressId the primary key for the new address
	 * @return the new address
	 */
	public static Address create(long addressId) {
		return getPersistence().create(addressId);
	}

	/**
	 * Removes the address with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param addressId the primary key of the address
	 * @return the address that was removed
	 * @throws NoSuchAddressException if a address with the primary key could not be found
	 */
	public static Address remove(long addressId)
		throws com.adjecti.pis.liferay.exception.NoSuchAddressException {

		return getPersistence().remove(addressId);
	}

	public static Address updateImpl(Address address) {
		return getPersistence().updateImpl(address);
	}

	/**
	 * Returns the address with the primary key or throws a <code>NoSuchAddressException</code> if it could not be found.
	 *
	 * @param addressId the primary key of the address
	 * @return the address
	 * @throws NoSuchAddressException if a address with the primary key could not be found
	 */
	public static Address findByPrimaryKey(long addressId)
		throws com.adjecti.pis.liferay.exception.NoSuchAddressException {

		return getPersistence().findByPrimaryKey(addressId);
	}

	/**
	 * Returns the address with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param addressId the primary key of the address
	 * @return the address, or <code>null</code> if a address with the primary key could not be found
	 */
	public static Address fetchByPrimaryKey(long addressId) {
		return getPersistence().fetchByPrimaryKey(addressId);
	}

	/**
	 * Returns all the addresses.
	 *
	 * @return the addresses
	 */
	public static List<Address> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @return the range of addresses
	 */
	public static List<Address> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of addresses
	 */
	public static List<Address> findAll(
		int start, int end, OrderByComparator<Address> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of addresses
	 * @param end the upper bound of the range of addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of addresses
	 */
	public static List<Address> findAll(
		int start, int end, OrderByComparator<Address> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the addresses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of addresses.
	 *
	 * @return the number of addresses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AddressPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AddressPersistence, AddressPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AddressPersistence.class);

		ServiceTracker<AddressPersistence, AddressPersistence> serviceTracker =
			new ServiceTracker<AddressPersistence, AddressPersistence>(
				bundle.getBundleContext(), AddressPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}