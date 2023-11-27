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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeDeputationRequestException;
import com.adjecti.pis.liferay.model.EmployeeDeputationRequest;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee deputation request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDeputationRequestUtil
 * @generated
 */
@ProviderType
public interface EmployeeDeputationRequestPersistence
	extends BasePersistence<EmployeeDeputationRequest> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeDeputationRequestUtil} to access the employee deputation request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee deputation requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee deputation requests
	 */
	public java.util.List<EmployeeDeputationRequest> findByUuid(String uuid);

	/**
	 * Returns a range of all the employee deputation requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDeputationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee deputation requests
	 * @param end the upper bound of the range of employee deputation requests (not inclusive)
	 * @return the range of matching employee deputation requests
	 */
	public java.util.List<EmployeeDeputationRequest> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the employee deputation requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDeputationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee deputation requests
	 * @param end the upper bound of the range of employee deputation requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee deputation requests
	 */
	public java.util.List<EmployeeDeputationRequest> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeDeputationRequest> orderByComparator);

	/**
	 * Returns an ordered range of all the employee deputation requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDeputationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee deputation requests
	 * @param end the upper bound of the range of employee deputation requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee deputation requests
	 */
	public java.util.List<EmployeeDeputationRequest> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeDeputationRequest> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee deputation request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee deputation request
	 * @throws NoSuchEmployeeDeputationRequestException if a matching employee deputation request could not be found
	 */
	public EmployeeDeputationRequest findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeDeputationRequest> orderByComparator)
		throws NoSuchEmployeeDeputationRequestException;

	/**
	 * Returns the first employee deputation request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee deputation request, or <code>null</code> if a matching employee deputation request could not be found
	 */
	public EmployeeDeputationRequest fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeDeputationRequest> orderByComparator);

	/**
	 * Returns the last employee deputation request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee deputation request
	 * @throws NoSuchEmployeeDeputationRequestException if a matching employee deputation request could not be found
	 */
	public EmployeeDeputationRequest findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeDeputationRequest> orderByComparator)
		throws NoSuchEmployeeDeputationRequestException;

	/**
	 * Returns the last employee deputation request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee deputation request, or <code>null</code> if a matching employee deputation request could not be found
	 */
	public EmployeeDeputationRequest fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeDeputationRequest> orderByComparator);

	/**
	 * Returns the employee deputation requests before and after the current employee deputation request in the ordered set where uuid = &#63;.
	 *
	 * @param employeeDeputationRequestId the primary key of the current employee deputation request
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee deputation request
	 * @throws NoSuchEmployeeDeputationRequestException if a employee deputation request with the primary key could not be found
	 */
	public EmployeeDeputationRequest[] findByUuid_PrevAndNext(
			long employeeDeputationRequestId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeDeputationRequest> orderByComparator)
		throws NoSuchEmployeeDeputationRequestException;

	/**
	 * Removes all the employee deputation requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of employee deputation requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee deputation requests
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the employee deputation request where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeeDeputationRequestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee deputation request
	 * @throws NoSuchEmployeeDeputationRequestException if a matching employee deputation request could not be found
	 */
	public EmployeeDeputationRequest findByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeDeputationRequestException;

	/**
	 * Returns the employee deputation request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee deputation request, or <code>null</code> if a matching employee deputation request could not be found
	 */
	public EmployeeDeputationRequest fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the employee deputation request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee deputation request, or <code>null</code> if a matching employee deputation request could not be found
	 */
	public EmployeeDeputationRequest fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the employee deputation request where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee deputation request that was removed
	 */
	public EmployeeDeputationRequest removeByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeDeputationRequestException;

	/**
	 * Returns the number of employee deputation requests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee deputation requests
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the employee deputation requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee deputation requests
	 */
	public java.util.List<EmployeeDeputationRequest> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the employee deputation requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDeputationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee deputation requests
	 * @param end the upper bound of the range of employee deputation requests (not inclusive)
	 * @return the range of matching employee deputation requests
	 */
	public java.util.List<EmployeeDeputationRequest> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the employee deputation requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDeputationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee deputation requests
	 * @param end the upper bound of the range of employee deputation requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee deputation requests
	 */
	public java.util.List<EmployeeDeputationRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeDeputationRequest> orderByComparator);

	/**
	 * Returns an ordered range of all the employee deputation requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDeputationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee deputation requests
	 * @param end the upper bound of the range of employee deputation requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee deputation requests
	 */
	public java.util.List<EmployeeDeputationRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeDeputationRequest> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee deputation request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee deputation request
	 * @throws NoSuchEmployeeDeputationRequestException if a matching employee deputation request could not be found
	 */
	public EmployeeDeputationRequest findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeDeputationRequest> orderByComparator)
		throws NoSuchEmployeeDeputationRequestException;

	/**
	 * Returns the first employee deputation request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee deputation request, or <code>null</code> if a matching employee deputation request could not be found
	 */
	public EmployeeDeputationRequest fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeDeputationRequest> orderByComparator);

	/**
	 * Returns the last employee deputation request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee deputation request
	 * @throws NoSuchEmployeeDeputationRequestException if a matching employee deputation request could not be found
	 */
	public EmployeeDeputationRequest findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeDeputationRequest> orderByComparator)
		throws NoSuchEmployeeDeputationRequestException;

	/**
	 * Returns the last employee deputation request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee deputation request, or <code>null</code> if a matching employee deputation request could not be found
	 */
	public EmployeeDeputationRequest fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeDeputationRequest> orderByComparator);

	/**
	 * Returns the employee deputation requests before and after the current employee deputation request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param employeeDeputationRequestId the primary key of the current employee deputation request
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee deputation request
	 * @throws NoSuchEmployeeDeputationRequestException if a employee deputation request with the primary key could not be found
	 */
	public EmployeeDeputationRequest[] findByUuid_C_PrevAndNext(
			long employeeDeputationRequestId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeDeputationRequest> orderByComparator)
		throws NoSuchEmployeeDeputationRequestException;

	/**
	 * Removes all the employee deputation requests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of employee deputation requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee deputation requests
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the employee deputation request in the entity cache if it is enabled.
	 *
	 * @param employeeDeputationRequest the employee deputation request
	 */
	public void cacheResult(
		EmployeeDeputationRequest employeeDeputationRequest);

	/**
	 * Caches the employee deputation requests in the entity cache if it is enabled.
	 *
	 * @param employeeDeputationRequests the employee deputation requests
	 */
	public void cacheResult(
		java.util.List<EmployeeDeputationRequest> employeeDeputationRequests);

	/**
	 * Creates a new employee deputation request with the primary key. Does not add the employee deputation request to the database.
	 *
	 * @param employeeDeputationRequestId the primary key for the new employee deputation request
	 * @return the new employee deputation request
	 */
	public EmployeeDeputationRequest create(long employeeDeputationRequestId);

	/**
	 * Removes the employee deputation request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeDeputationRequestId the primary key of the employee deputation request
	 * @return the employee deputation request that was removed
	 * @throws NoSuchEmployeeDeputationRequestException if a employee deputation request with the primary key could not be found
	 */
	public EmployeeDeputationRequest remove(long employeeDeputationRequestId)
		throws NoSuchEmployeeDeputationRequestException;

	public EmployeeDeputationRequest updateImpl(
		EmployeeDeputationRequest employeeDeputationRequest);

	/**
	 * Returns the employee deputation request with the primary key or throws a <code>NoSuchEmployeeDeputationRequestException</code> if it could not be found.
	 *
	 * @param employeeDeputationRequestId the primary key of the employee deputation request
	 * @return the employee deputation request
	 * @throws NoSuchEmployeeDeputationRequestException if a employee deputation request with the primary key could not be found
	 */
	public EmployeeDeputationRequest findByPrimaryKey(
			long employeeDeputationRequestId)
		throws NoSuchEmployeeDeputationRequestException;

	/**
	 * Returns the employee deputation request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeDeputationRequestId the primary key of the employee deputation request
	 * @return the employee deputation request, or <code>null</code> if a employee deputation request with the primary key could not be found
	 */
	public EmployeeDeputationRequest fetchByPrimaryKey(
		long employeeDeputationRequestId);

	/**
	 * Returns all the employee deputation requests.
	 *
	 * @return the employee deputation requests
	 */
	public java.util.List<EmployeeDeputationRequest> findAll();

	/**
	 * Returns a range of all the employee deputation requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDeputationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee deputation requests
	 * @param end the upper bound of the range of employee deputation requests (not inclusive)
	 * @return the range of employee deputation requests
	 */
	public java.util.List<EmployeeDeputationRequest> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the employee deputation requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDeputationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee deputation requests
	 * @param end the upper bound of the range of employee deputation requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee deputation requests
	 */
	public java.util.List<EmployeeDeputationRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeDeputationRequest> orderByComparator);

	/**
	 * Returns an ordered range of all the employee deputation requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDeputationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee deputation requests
	 * @param end the upper bound of the range of employee deputation requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee deputation requests
	 */
	public java.util.List<EmployeeDeputationRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeDeputationRequest> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee deputation requests from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee deputation requests.
	 *
	 * @return the number of employee deputation requests
	 */
	public int countAll();

}