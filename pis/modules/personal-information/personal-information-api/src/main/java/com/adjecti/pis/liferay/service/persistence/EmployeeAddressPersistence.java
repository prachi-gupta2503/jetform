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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeAddressException;
import com.adjecti.pis.liferay.model.EmployeeAddress;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee address service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeAddressUtil
 * @generated
 */
@ProviderType
public interface EmployeeAddressPersistence
	extends BasePersistence<EmployeeAddress> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeAddressUtil} to access the employee address persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee addresses where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @return the matching employee addresses
	 */
	public java.util.List<EmployeeAddress> findByDistrictId(long districtId);

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
	public java.util.List<EmployeeAddress> findByDistrictId(
		long districtId, int start, int end);

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
	public java.util.List<EmployeeAddress> findByDistrictId(
		long districtId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
			orderByComparator);

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
	public java.util.List<EmployeeAddress> findByDistrictId(
		long districtId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee address in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee address
	 * @throws NoSuchEmployeeAddressException if a matching employee address could not be found
	 */
	public EmployeeAddress findByDistrictId_First(
			long districtId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
				orderByComparator)
		throws NoSuchEmployeeAddressException;

	/**
	 * Returns the first employee address in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee address, or <code>null</code> if a matching employee address could not be found
	 */
	public EmployeeAddress fetchByDistrictId_First(
		long districtId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
			orderByComparator);

	/**
	 * Returns the last employee address in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee address
	 * @throws NoSuchEmployeeAddressException if a matching employee address could not be found
	 */
	public EmployeeAddress findByDistrictId_Last(
			long districtId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
				orderByComparator)
		throws NoSuchEmployeeAddressException;

	/**
	 * Returns the last employee address in the ordered set where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee address, or <code>null</code> if a matching employee address could not be found
	 */
	public EmployeeAddress fetchByDistrictId_Last(
		long districtId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
			orderByComparator);

	/**
	 * Returns the employee addresses before and after the current employee address in the ordered set where districtId = &#63;.
	 *
	 * @param employeeAddressId the primary key of the current employee address
	 * @param districtId the district ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee address
	 * @throws NoSuchEmployeeAddressException if a employee address with the primary key could not be found
	 */
	public EmployeeAddress[] findByDistrictId_PrevAndNext(
			long employeeAddressId, long districtId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
				orderByComparator)
		throws NoSuchEmployeeAddressException;

	/**
	 * Removes all the employee addresses where districtId = &#63; from the database.
	 *
	 * @param districtId the district ID
	 */
	public void removeByDistrictId(long districtId);

	/**
	 * Returns the number of employee addresses where districtId = &#63;.
	 *
	 * @param districtId the district ID
	 * @return the number of matching employee addresses
	 */
	public int countByDistrictId(long districtId);

	/**
	 * Returns all the employee addresses where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @return the matching employee addresses
	 */
	public java.util.List<EmployeeAddress> findByStateId(long stateId);

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
	public java.util.List<EmployeeAddress> findByStateId(
		long stateId, int start, int end);

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
	public java.util.List<EmployeeAddress> findByStateId(
		long stateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
			orderByComparator);

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
	public java.util.List<EmployeeAddress> findByStateId(
		long stateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee address in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee address
	 * @throws NoSuchEmployeeAddressException if a matching employee address could not be found
	 */
	public EmployeeAddress findByStateId_First(
			long stateId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
				orderByComparator)
		throws NoSuchEmployeeAddressException;

	/**
	 * Returns the first employee address in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee address, or <code>null</code> if a matching employee address could not be found
	 */
	public EmployeeAddress fetchByStateId_First(
		long stateId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
			orderByComparator);

	/**
	 * Returns the last employee address in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee address
	 * @throws NoSuchEmployeeAddressException if a matching employee address could not be found
	 */
	public EmployeeAddress findByStateId_Last(
			long stateId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
				orderByComparator)
		throws NoSuchEmployeeAddressException;

	/**
	 * Returns the last employee address in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee address, or <code>null</code> if a matching employee address could not be found
	 */
	public EmployeeAddress fetchByStateId_Last(
		long stateId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
			orderByComparator);

	/**
	 * Returns the employee addresses before and after the current employee address in the ordered set where stateId = &#63;.
	 *
	 * @param employeeAddressId the primary key of the current employee address
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee address
	 * @throws NoSuchEmployeeAddressException if a employee address with the primary key could not be found
	 */
	public EmployeeAddress[] findByStateId_PrevAndNext(
			long employeeAddressId, long stateId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
				orderByComparator)
		throws NoSuchEmployeeAddressException;

	/**
	 * Removes all the employee addresses where stateId = &#63; from the database.
	 *
	 * @param stateId the state ID
	 */
	public void removeByStateId(long stateId);

	/**
	 * Returns the number of employee addresses where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @return the number of matching employee addresses
	 */
	public int countByStateId(long stateId);

	/**
	 * Returns all the employee addresses where accomodationTypeId = &#63;.
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @return the matching employee addresses
	 */
	public java.util.List<EmployeeAddress> findByAccomodationTypeId(
		long accomodationTypeId);

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
	public java.util.List<EmployeeAddress> findByAccomodationTypeId(
		long accomodationTypeId, int start, int end);

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
	public java.util.List<EmployeeAddress> findByAccomodationTypeId(
		long accomodationTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
			orderByComparator);

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
	public java.util.List<EmployeeAddress> findByAccomodationTypeId(
		long accomodationTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee address in the ordered set where accomodationTypeId = &#63;.
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee address
	 * @throws NoSuchEmployeeAddressException if a matching employee address could not be found
	 */
	public EmployeeAddress findByAccomodationTypeId_First(
			long accomodationTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
				orderByComparator)
		throws NoSuchEmployeeAddressException;

	/**
	 * Returns the first employee address in the ordered set where accomodationTypeId = &#63;.
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee address, or <code>null</code> if a matching employee address could not be found
	 */
	public EmployeeAddress fetchByAccomodationTypeId_First(
		long accomodationTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
			orderByComparator);

	/**
	 * Returns the last employee address in the ordered set where accomodationTypeId = &#63;.
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee address
	 * @throws NoSuchEmployeeAddressException if a matching employee address could not be found
	 */
	public EmployeeAddress findByAccomodationTypeId_Last(
			long accomodationTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
				orderByComparator)
		throws NoSuchEmployeeAddressException;

	/**
	 * Returns the last employee address in the ordered set where accomodationTypeId = &#63;.
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee address, or <code>null</code> if a matching employee address could not be found
	 */
	public EmployeeAddress fetchByAccomodationTypeId_Last(
		long accomodationTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
			orderByComparator);

	/**
	 * Returns the employee addresses before and after the current employee address in the ordered set where accomodationTypeId = &#63;.
	 *
	 * @param employeeAddressId the primary key of the current employee address
	 * @param accomodationTypeId the accomodation type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee address
	 * @throws NoSuchEmployeeAddressException if a employee address with the primary key could not be found
	 */
	public EmployeeAddress[] findByAccomodationTypeId_PrevAndNext(
			long employeeAddressId, long accomodationTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
				orderByComparator)
		throws NoSuchEmployeeAddressException;

	/**
	 * Removes all the employee addresses where accomodationTypeId = &#63; from the database.
	 *
	 * @param accomodationTypeId the accomodation type ID
	 */
	public void removeByAccomodationTypeId(long accomodationTypeId);

	/**
	 * Returns the number of employee addresses where accomodationTypeId = &#63;.
	 *
	 * @param accomodationTypeId the accomodation type ID
	 * @return the number of matching employee addresses
	 */
	public int countByAccomodationTypeId(long accomodationTypeId);

	/**
	 * Returns all the employee addresses where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee addresses
	 */
	public java.util.List<EmployeeAddress> findByEmployeeId(long employeeId);

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
	public java.util.List<EmployeeAddress> findByEmployeeId(
		long employeeId, int start, int end);

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
	public java.util.List<EmployeeAddress> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
			orderByComparator);

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
	public java.util.List<EmployeeAddress> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee address in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee address
	 * @throws NoSuchEmployeeAddressException if a matching employee address could not be found
	 */
	public EmployeeAddress findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
				orderByComparator)
		throws NoSuchEmployeeAddressException;

	/**
	 * Returns the first employee address in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee address, or <code>null</code> if a matching employee address could not be found
	 */
	public EmployeeAddress fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
			orderByComparator);

	/**
	 * Returns the last employee address in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee address
	 * @throws NoSuchEmployeeAddressException if a matching employee address could not be found
	 */
	public EmployeeAddress findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
				orderByComparator)
		throws NoSuchEmployeeAddressException;

	/**
	 * Returns the last employee address in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee address, or <code>null</code> if a matching employee address could not be found
	 */
	public EmployeeAddress fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
			orderByComparator);

	/**
	 * Returns the employee addresses before and after the current employee address in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeAddressId the primary key of the current employee address
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee address
	 * @throws NoSuchEmployeeAddressException if a employee address with the primary key could not be found
	 */
	public EmployeeAddress[] findByEmployeeId_PrevAndNext(
			long employeeAddressId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
				orderByComparator)
		throws NoSuchEmployeeAddressException;

	/**
	 * Removes all the employee addresses where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of employee addresses where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee addresses
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Caches the employee address in the entity cache if it is enabled.
	 *
	 * @param employeeAddress the employee address
	 */
	public void cacheResult(EmployeeAddress employeeAddress);

	/**
	 * Caches the employee addresses in the entity cache if it is enabled.
	 *
	 * @param employeeAddresses the employee addresses
	 */
	public void cacheResult(java.util.List<EmployeeAddress> employeeAddresses);

	/**
	 * Creates a new employee address with the primary key. Does not add the employee address to the database.
	 *
	 * @param employeeAddressId the primary key for the new employee address
	 * @return the new employee address
	 */
	public EmployeeAddress create(long employeeAddressId);

	/**
	 * Removes the employee address with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeAddressId the primary key of the employee address
	 * @return the employee address that was removed
	 * @throws NoSuchEmployeeAddressException if a employee address with the primary key could not be found
	 */
	public EmployeeAddress remove(long employeeAddressId)
		throws NoSuchEmployeeAddressException;

	public EmployeeAddress updateImpl(EmployeeAddress employeeAddress);

	/**
	 * Returns the employee address with the primary key or throws a <code>NoSuchEmployeeAddressException</code> if it could not be found.
	 *
	 * @param employeeAddressId the primary key of the employee address
	 * @return the employee address
	 * @throws NoSuchEmployeeAddressException if a employee address with the primary key could not be found
	 */
	public EmployeeAddress findByPrimaryKey(long employeeAddressId)
		throws NoSuchEmployeeAddressException;

	/**
	 * Returns the employee address with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeAddressId the primary key of the employee address
	 * @return the employee address, or <code>null</code> if a employee address with the primary key could not be found
	 */
	public EmployeeAddress fetchByPrimaryKey(long employeeAddressId);

	/**
	 * Returns all the employee addresses.
	 *
	 * @return the employee addresses
	 */
	public java.util.List<EmployeeAddress> findAll();

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
	public java.util.List<EmployeeAddress> findAll(int start, int end);

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
	public java.util.List<EmployeeAddress> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
			orderByComparator);

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
	public java.util.List<EmployeeAddress> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeAddress>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee addresses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee addresses.
	 *
	 * @return the number of employee addresses
	 */
	public int countAll();

}