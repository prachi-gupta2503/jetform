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

import com.adjecti.pis.liferay.exception.NoSuchAddressException;
import com.adjecti.pis.liferay.model.Address;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the address service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AddressUtil
 * @generated
 */
@ProviderType
public interface AddressPersistence extends BasePersistence<Address> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AddressUtil} to access the address persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the addresses where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the matching addresses
	 */
	public java.util.List<Address> findByJoiningProcessId(
		long joiningProcessId);

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
	public java.util.List<Address> findByJoiningProcessId(
		long joiningProcessId, int start, int end);

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
	public java.util.List<Address> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Address>
			orderByComparator);

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
	public java.util.List<Address> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Address>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first address in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	public Address findByJoiningProcessId_First(
			long joiningProcessId,
			com.liferay.portal.kernel.util.OrderByComparator<Address>
				orderByComparator)
		throws NoSuchAddressException;

	/**
	 * Returns the first address in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address, or <code>null</code> if a matching address could not be found
	 */
	public Address fetchByJoiningProcessId_First(
		long joiningProcessId,
		com.liferay.portal.kernel.util.OrderByComparator<Address>
			orderByComparator);

	/**
	 * Returns the last address in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	public Address findByJoiningProcessId_Last(
			long joiningProcessId,
			com.liferay.portal.kernel.util.OrderByComparator<Address>
				orderByComparator)
		throws NoSuchAddressException;

	/**
	 * Returns the last address in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address, or <code>null</code> if a matching address could not be found
	 */
	public Address fetchByJoiningProcessId_Last(
		long joiningProcessId,
		com.liferay.portal.kernel.util.OrderByComparator<Address>
			orderByComparator);

	/**
	 * Returns the addresses before and after the current address in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param addressId the primary key of the current address
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next address
	 * @throws NoSuchAddressException if a address with the primary key could not be found
	 */
	public Address[] findByJoiningProcessId_PrevAndNext(
			long addressId, long joiningProcessId,
			com.liferay.portal.kernel.util.OrderByComparator<Address>
				orderByComparator)
		throws NoSuchAddressException;

	/**
	 * Removes all the addresses where joiningProcessId = &#63; from the database.
	 *
	 * @param joiningProcessId the joining process ID
	 */
	public void removeByJoiningProcessId(long joiningProcessId);

	/**
	 * Returns the number of addresses where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the number of matching addresses
	 */
	public int countByJoiningProcessId(long joiningProcessId);

	/**
	 * Returns all the addresses where accomodationTypeId = &#63;.
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @return the matching addresses
	 */
	public java.util.List<Address> findByAccomodationTypeId(
		long accomodationTypeId);

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
	public java.util.List<Address> findByAccomodationTypeId(
		long accomodationTypeId, int start, int end);

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
	public java.util.List<Address> findByAccomodationTypeId(
		long accomodationTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Address>
			orderByComparator);

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
	public java.util.List<Address> findByAccomodationTypeId(
		long accomodationTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Address>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first address in the ordered set where accomodationTypeId = &#63;.
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	public Address findByAccomodationTypeId_First(
			long accomodationTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<Address>
				orderByComparator)
		throws NoSuchAddressException;

	/**
	 * Returns the first address in the ordered set where accomodationTypeId = &#63;.
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address, or <code>null</code> if a matching address could not be found
	 */
	public Address fetchByAccomodationTypeId_First(
		long accomodationTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<Address>
			orderByComparator);

	/**
	 * Returns the last address in the ordered set where accomodationTypeId = &#63;.
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	public Address findByAccomodationTypeId_Last(
			long accomodationTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<Address>
				orderByComparator)
		throws NoSuchAddressException;

	/**
	 * Returns the last address in the ordered set where accomodationTypeId = &#63;.
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address, or <code>null</code> if a matching address could not be found
	 */
	public Address fetchByAccomodationTypeId_Last(
		long accomodationTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<Address>
			orderByComparator);

	/**
	 * Returns the addresses before and after the current address in the ordered set where accomodationTypeId = &#63;.
	 *
	 * @param addressId the primary key of the current address
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next address
	 * @throws NoSuchAddressException if a address with the primary key could not be found
	 */
	public Address[] findByAccomodationTypeId_PrevAndNext(
			long addressId, long accomodationTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<Address>
				orderByComparator)
		throws NoSuchAddressException;

	/**
	 * Removes all the addresses where accomodationTypeId = &#63; from the database.
	 *
	 * @param accomodationTypeId the accomodation type ID
	 */
	public void removeByAccomodationTypeId(long accomodationTypeId);

	/**
	 * Returns the number of addresses where accomodationTypeId = &#63;.
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @return the number of matching addresses
	 */
	public int countByAccomodationTypeId(long accomodationTypeId);

	/**
	 * Returns all the addresses where joiningProcessId = &#63; and accomodationTypeId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param accomodationTypeId the accomodation type ID
	 * @return the matching addresses
	 */
	public java.util.List<Address> findByJoiningProcessIdAndAccomodationTypeId(
		long joiningProcessId, long accomodationTypeId);

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
	public java.util.List<Address> findByJoiningProcessIdAndAccomodationTypeId(
		long joiningProcessId, long accomodationTypeId, int start, int end);

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
	public java.util.List<Address> findByJoiningProcessIdAndAccomodationTypeId(
		long joiningProcessId, long accomodationTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Address>
			orderByComparator);

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
	public java.util.List<Address> findByJoiningProcessIdAndAccomodationTypeId(
		long joiningProcessId, long accomodationTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Address>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first address in the ordered set where joiningProcessId = &#63; and accomodationTypeId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	public Address findByJoiningProcessIdAndAccomodationTypeId_First(
			long joiningProcessId, long accomodationTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<Address>
				orderByComparator)
		throws NoSuchAddressException;

	/**
	 * Returns the first address in the ordered set where joiningProcessId = &#63; and accomodationTypeId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address, or <code>null</code> if a matching address could not be found
	 */
	public Address fetchByJoiningProcessIdAndAccomodationTypeId_First(
		long joiningProcessId, long accomodationTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<Address>
			orderByComparator);

	/**
	 * Returns the last address in the ordered set where joiningProcessId = &#63; and accomodationTypeId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	public Address findByJoiningProcessIdAndAccomodationTypeId_Last(
			long joiningProcessId, long accomodationTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<Address>
				orderByComparator)
		throws NoSuchAddressException;

	/**
	 * Returns the last address in the ordered set where joiningProcessId = &#63; and accomodationTypeId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address, or <code>null</code> if a matching address could not be found
	 */
	public Address fetchByJoiningProcessIdAndAccomodationTypeId_Last(
		long joiningProcessId, long accomodationTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<Address>
			orderByComparator);

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
	public Address[] findByJoiningProcessIdAndAccomodationTypeId_PrevAndNext(
			long addressId, long joiningProcessId, long accomodationTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<Address>
				orderByComparator)
		throws NoSuchAddressException;

	/**
	 * Removes all the addresses where joiningProcessId = &#63; and accomodationTypeId = &#63; from the database.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param accomodationTypeId the accomodation type ID
	 */
	public void removeByJoiningProcessIdAndAccomodationTypeId(
		long joiningProcessId, long accomodationTypeId);

	/**
	 * Returns the number of addresses where joiningProcessId = &#63; and accomodationTypeId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param accomodationTypeId the accomodation type ID
	 * @return the number of matching addresses
	 */
	public int countByJoiningProcessIdAndAccomodationTypeId(
		long joiningProcessId, long accomodationTypeId);

	/**
	 * Returns all the addresses where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @return the matching addresses
	 */
	public java.util.List<Address> findByDistrictId(long districtId);

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
	public java.util.List<Address> findByDistrictId(
		long districtId, int start, int end);

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
	public java.util.List<Address> findByDistrictId(
		long districtId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Address>
			orderByComparator);

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
	public java.util.List<Address> findByDistrictId(
		long districtId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Address>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first address in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	public Address findByDistrictId_First(
			long districtId,
			com.liferay.portal.kernel.util.OrderByComparator<Address>
				orderByComparator)
		throws NoSuchAddressException;

	/**
	 * Returns the first address in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address, or <code>null</code> if a matching address could not be found
	 */
	public Address fetchByDistrictId_First(
		long districtId,
		com.liferay.portal.kernel.util.OrderByComparator<Address>
			orderByComparator);

	/**
	 * Returns the last address in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	public Address findByDistrictId_Last(
			long districtId,
			com.liferay.portal.kernel.util.OrderByComparator<Address>
				orderByComparator)
		throws NoSuchAddressException;

	/**
	 * Returns the last address in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address, or <code>null</code> if a matching address could not be found
	 */
	public Address fetchByDistrictId_Last(
		long districtId,
		com.liferay.portal.kernel.util.OrderByComparator<Address>
			orderByComparator);

	/**
	 * Returns the addresses before and after the current address in the ordered set where districtId = &#63;.
	 *
	 * @param addressId the primary key of the current address
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next address
	 * @throws NoSuchAddressException if a address with the primary key could not be found
	 */
	public Address[] findByDistrictId_PrevAndNext(
			long addressId, long districtId,
			com.liferay.portal.kernel.util.OrderByComparator<Address>
				orderByComparator)
		throws NoSuchAddressException;

	/**
	 * Removes all the addresses where districtId = &#63; from the database.
	 *
	 * @param districtId the district ID
	 */
	public void removeByDistrictId(long districtId);

	/**
	 * Returns the number of addresses where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @return the number of matching addresses
	 */
	public int countByDistrictId(long districtId);

	/**
	 * Returns all the addresses where addressId = &#63;.
	 *
	 * @param addressId the address ID
	 * @return the matching addresses
	 */
	public java.util.List<Address> findByAddressId(long addressId);

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
	public java.util.List<Address> findByAddressId(
		long addressId, int start, int end);

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
	public java.util.List<Address> findByAddressId(
		long addressId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Address>
			orderByComparator);

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
	public java.util.List<Address> findByAddressId(
		long addressId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Address>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first address in the ordered set where addressId = &#63;.
	 *
	 * @param addressId the address ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	public Address findByAddressId_First(
			long addressId,
			com.liferay.portal.kernel.util.OrderByComparator<Address>
				orderByComparator)
		throws NoSuchAddressException;

	/**
	 * Returns the first address in the ordered set where addressId = &#63;.
	 *
	 * @param addressId the address ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address, or <code>null</code> if a matching address could not be found
	 */
	public Address fetchByAddressId_First(
		long addressId,
		com.liferay.portal.kernel.util.OrderByComparator<Address>
			orderByComparator);

	/**
	 * Returns the last address in the ordered set where addressId = &#63;.
	 *
	 * @param addressId the address ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	public Address findByAddressId_Last(
			long addressId,
			com.liferay.portal.kernel.util.OrderByComparator<Address>
				orderByComparator)
		throws NoSuchAddressException;

	/**
	 * Returns the last address in the ordered set where addressId = &#63;.
	 *
	 * @param addressId the address ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address, or <code>null</code> if a matching address could not be found
	 */
	public Address fetchByAddressId_Last(
		long addressId,
		com.liferay.portal.kernel.util.OrderByComparator<Address>
			orderByComparator);

	/**
	 * Removes all the addresses where addressId = &#63; from the database.
	 *
	 * @param addressId the address ID
	 */
	public void removeByAddressId(long addressId);

	/**
	 * Returns the number of addresses where addressId = &#63;.
	 *
	 * @param addressId the address ID
	 * @return the number of matching addresses
	 */
	public int countByAddressId(long addressId);

	/**
	 * Returns all the addresses where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @return the matching addresses
	 */
	public java.util.List<Address> findByStateId(long stateId);

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
	public java.util.List<Address> findByStateId(
		long stateId, int start, int end);

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
	public java.util.List<Address> findByStateId(
		long stateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Address>
			orderByComparator);

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
	public java.util.List<Address> findByStateId(
		long stateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Address>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first address in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	public Address findByStateId_First(
			long stateId,
			com.liferay.portal.kernel.util.OrderByComparator<Address>
				orderByComparator)
		throws NoSuchAddressException;

	/**
	 * Returns the first address in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching address, or <code>null</code> if a matching address could not be found
	 */
	public Address fetchByStateId_First(
		long stateId,
		com.liferay.portal.kernel.util.OrderByComparator<Address>
			orderByComparator);

	/**
	 * Returns the last address in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address
	 * @throws NoSuchAddressException if a matching address could not be found
	 */
	public Address findByStateId_Last(
			long stateId,
			com.liferay.portal.kernel.util.OrderByComparator<Address>
				orderByComparator)
		throws NoSuchAddressException;

	/**
	 * Returns the last address in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching address, or <code>null</code> if a matching address could not be found
	 */
	public Address fetchByStateId_Last(
		long stateId,
		com.liferay.portal.kernel.util.OrderByComparator<Address>
			orderByComparator);

	/**
	 * Returns the addresses before and after the current address in the ordered set where stateId = &#63;.
	 *
	 * @param addressId the primary key of the current address
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next address
	 * @throws NoSuchAddressException if a address with the primary key could not be found
	 */
	public Address[] findByStateId_PrevAndNext(
			long addressId, long stateId,
			com.liferay.portal.kernel.util.OrderByComparator<Address>
				orderByComparator)
		throws NoSuchAddressException;

	/**
	 * Removes all the addresses where stateId = &#63; from the database.
	 *
	 * @param stateId the state ID
	 */
	public void removeByStateId(long stateId);

	/**
	 * Returns the number of addresses where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @return the number of matching addresses
	 */
	public int countByStateId(long stateId);

	/**
	 * Caches the address in the entity cache if it is enabled.
	 *
	 * @param address the address
	 */
	public void cacheResult(Address address);

	/**
	 * Caches the addresses in the entity cache if it is enabled.
	 *
	 * @param addresses the addresses
	 */
	public void cacheResult(java.util.List<Address> addresses);

	/**
	 * Creates a new address with the primary key. Does not add the address to the database.
	 *
	 * @param addressId the primary key for the new address
	 * @return the new address
	 */
	public Address create(long addressId);

	/**
	 * Removes the address with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param addressId the primary key of the address
	 * @return the address that was removed
	 * @throws NoSuchAddressException if a address with the primary key could not be found
	 */
	public Address remove(long addressId) throws NoSuchAddressException;

	public Address updateImpl(Address address);

	/**
	 * Returns the address with the primary key or throws a <code>NoSuchAddressException</code> if it could not be found.
	 *
	 * @param addressId the primary key of the address
	 * @return the address
	 * @throws NoSuchAddressException if a address with the primary key could not be found
	 */
	public Address findByPrimaryKey(long addressId)
		throws NoSuchAddressException;

	/**
	 * Returns the address with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param addressId the primary key of the address
	 * @return the address, or <code>null</code> if a address with the primary key could not be found
	 */
	public Address fetchByPrimaryKey(long addressId);

	/**
	 * Returns all the addresses.
	 *
	 * @return the addresses
	 */
	public java.util.List<Address> findAll();

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
	public java.util.List<Address> findAll(int start, int end);

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
	public java.util.List<Address> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Address>
			orderByComparator);

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
	public java.util.List<Address> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Address>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the addresses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of addresses.
	 *
	 * @return the number of addresses
	 */
	public int countAll();

}