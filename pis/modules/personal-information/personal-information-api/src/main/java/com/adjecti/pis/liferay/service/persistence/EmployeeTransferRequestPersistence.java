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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeTransferRequestException;
import com.adjecti.pis.liferay.model.EmployeeTransferRequest;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee transfer request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeTransferRequestUtil
 * @generated
 */
@ProviderType
public interface EmployeeTransferRequestPersistence
	extends BasePersistence<EmployeeTransferRequest> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeTransferRequestUtil} to access the employee transfer request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee transfer requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee transfer requests
	 */
	public java.util.List<EmployeeTransferRequest> findByUuid(String uuid);

	/**
	 * Returns a range of all the employee transfer requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee transfer requests
	 * @param end the upper bound of the range of employee transfer requests (not inclusive)
	 * @return the range of matching employee transfer requests
	 */
	public java.util.List<EmployeeTransferRequest> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the employee transfer requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee transfer requests
	 * @param end the upper bound of the range of employee transfer requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee transfer requests
	 */
	public java.util.List<EmployeeTransferRequest> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeTransferRequest> orderByComparator);

	/**
	 * Returns an ordered range of all the employee transfer requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee transfer requests
	 * @param end the upper bound of the range of employee transfer requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee transfer requests
	 */
	public java.util.List<EmployeeTransferRequest> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeTransferRequest> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee transfer request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee transfer request
	 * @throws NoSuchEmployeeTransferRequestException if a matching employee transfer request could not be found
	 */
	public EmployeeTransferRequest findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeTransferRequest> orderByComparator)
		throws NoSuchEmployeeTransferRequestException;

	/**
	 * Returns the first employee transfer request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee transfer request, or <code>null</code> if a matching employee transfer request could not be found
	 */
	public EmployeeTransferRequest fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeTransferRequest> orderByComparator);

	/**
	 * Returns the last employee transfer request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee transfer request
	 * @throws NoSuchEmployeeTransferRequestException if a matching employee transfer request could not be found
	 */
	public EmployeeTransferRequest findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeTransferRequest> orderByComparator)
		throws NoSuchEmployeeTransferRequestException;

	/**
	 * Returns the last employee transfer request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee transfer request, or <code>null</code> if a matching employee transfer request could not be found
	 */
	public EmployeeTransferRequest fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeTransferRequest> orderByComparator);

	/**
	 * Returns the employee transfer requests before and after the current employee transfer request in the ordered set where uuid = &#63;.
	 *
	 * @param employeeTransferRequestId the primary key of the current employee transfer request
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee transfer request
	 * @throws NoSuchEmployeeTransferRequestException if a employee transfer request with the primary key could not be found
	 */
	public EmployeeTransferRequest[] findByUuid_PrevAndNext(
			long employeeTransferRequestId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeTransferRequest> orderByComparator)
		throws NoSuchEmployeeTransferRequestException;

	/**
	 * Removes all the employee transfer requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of employee transfer requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee transfer requests
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the employee transfer request where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeeTransferRequestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee transfer request
	 * @throws NoSuchEmployeeTransferRequestException if a matching employee transfer request could not be found
	 */
	public EmployeeTransferRequest findByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeTransferRequestException;

	/**
	 * Returns the employee transfer request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee transfer request, or <code>null</code> if a matching employee transfer request could not be found
	 */
	public EmployeeTransferRequest fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the employee transfer request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee transfer request, or <code>null</code> if a matching employee transfer request could not be found
	 */
	public EmployeeTransferRequest fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the employee transfer request where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee transfer request that was removed
	 */
	public EmployeeTransferRequest removeByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeTransferRequestException;

	/**
	 * Returns the number of employee transfer requests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee transfer requests
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the employee transfer requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee transfer requests
	 */
	public java.util.List<EmployeeTransferRequest> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the employee transfer requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee transfer requests
	 * @param end the upper bound of the range of employee transfer requests (not inclusive)
	 * @return the range of matching employee transfer requests
	 */
	public java.util.List<EmployeeTransferRequest> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the employee transfer requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee transfer requests
	 * @param end the upper bound of the range of employee transfer requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee transfer requests
	 */
	public java.util.List<EmployeeTransferRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeTransferRequest> orderByComparator);

	/**
	 * Returns an ordered range of all the employee transfer requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee transfer requests
	 * @param end the upper bound of the range of employee transfer requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee transfer requests
	 */
	public java.util.List<EmployeeTransferRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeTransferRequest> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee transfer request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee transfer request
	 * @throws NoSuchEmployeeTransferRequestException if a matching employee transfer request could not be found
	 */
	public EmployeeTransferRequest findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeTransferRequest> orderByComparator)
		throws NoSuchEmployeeTransferRequestException;

	/**
	 * Returns the first employee transfer request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee transfer request, or <code>null</code> if a matching employee transfer request could not be found
	 */
	public EmployeeTransferRequest fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeTransferRequest> orderByComparator);

	/**
	 * Returns the last employee transfer request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee transfer request
	 * @throws NoSuchEmployeeTransferRequestException if a matching employee transfer request could not be found
	 */
	public EmployeeTransferRequest findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeTransferRequest> orderByComparator)
		throws NoSuchEmployeeTransferRequestException;

	/**
	 * Returns the last employee transfer request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee transfer request, or <code>null</code> if a matching employee transfer request could not be found
	 */
	public EmployeeTransferRequest fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeTransferRequest> orderByComparator);

	/**
	 * Returns the employee transfer requests before and after the current employee transfer request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param employeeTransferRequestId the primary key of the current employee transfer request
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee transfer request
	 * @throws NoSuchEmployeeTransferRequestException if a employee transfer request with the primary key could not be found
	 */
	public EmployeeTransferRequest[] findByUuid_C_PrevAndNext(
			long employeeTransferRequestId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeTransferRequest> orderByComparator)
		throws NoSuchEmployeeTransferRequestException;

	/**
	 * Removes all the employee transfer requests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of employee transfer requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee transfer requests
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the employee transfer request in the entity cache if it is enabled.
	 *
	 * @param employeeTransferRequest the employee transfer request
	 */
	public void cacheResult(EmployeeTransferRequest employeeTransferRequest);

	/**
	 * Caches the employee transfer requests in the entity cache if it is enabled.
	 *
	 * @param employeeTransferRequests the employee transfer requests
	 */
	public void cacheResult(
		java.util.List<EmployeeTransferRequest> employeeTransferRequests);

	/**
	 * Creates a new employee transfer request with the primary key. Does not add the employee transfer request to the database.
	 *
	 * @param employeeTransferRequestId the primary key for the new employee transfer request
	 * @return the new employee transfer request
	 */
	public EmployeeTransferRequest create(long employeeTransferRequestId);

	/**
	 * Removes the employee transfer request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeTransferRequestId the primary key of the employee transfer request
	 * @return the employee transfer request that was removed
	 * @throws NoSuchEmployeeTransferRequestException if a employee transfer request with the primary key could not be found
	 */
	public EmployeeTransferRequest remove(long employeeTransferRequestId)
		throws NoSuchEmployeeTransferRequestException;

	public EmployeeTransferRequest updateImpl(
		EmployeeTransferRequest employeeTransferRequest);

	/**
	 * Returns the employee transfer request with the primary key or throws a <code>NoSuchEmployeeTransferRequestException</code> if it could not be found.
	 *
	 * @param employeeTransferRequestId the primary key of the employee transfer request
	 * @return the employee transfer request
	 * @throws NoSuchEmployeeTransferRequestException if a employee transfer request with the primary key could not be found
	 */
	public EmployeeTransferRequest findByPrimaryKey(
			long employeeTransferRequestId)
		throws NoSuchEmployeeTransferRequestException;

	/**
	 * Returns the employee transfer request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeTransferRequestId the primary key of the employee transfer request
	 * @return the employee transfer request, or <code>null</code> if a employee transfer request with the primary key could not be found
	 */
	public EmployeeTransferRequest fetchByPrimaryKey(
		long employeeTransferRequestId);

	/**
	 * Returns all the employee transfer requests.
	 *
	 * @return the employee transfer requests
	 */
	public java.util.List<EmployeeTransferRequest> findAll();

	/**
	 * Returns a range of all the employee transfer requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee transfer requests
	 * @param end the upper bound of the range of employee transfer requests (not inclusive)
	 * @return the range of employee transfer requests
	 */
	public java.util.List<EmployeeTransferRequest> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee transfer requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee transfer requests
	 * @param end the upper bound of the range of employee transfer requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee transfer requests
	 */
	public java.util.List<EmployeeTransferRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeTransferRequest> orderByComparator);

	/**
	 * Returns an ordered range of all the employee transfer requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee transfer requests
	 * @param end the upper bound of the range of employee transfer requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee transfer requests
	 */
	public java.util.List<EmployeeTransferRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeTransferRequest> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee transfer requests from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee transfer requests.
	 *
	 * @return the number of employee transfer requests
	 */
	public int countAll();

}