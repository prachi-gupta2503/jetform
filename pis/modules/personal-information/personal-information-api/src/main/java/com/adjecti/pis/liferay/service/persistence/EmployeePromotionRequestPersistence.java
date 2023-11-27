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

import com.adjecti.pis.liferay.exception.NoSuchEmployeePromotionRequestException;
import com.adjecti.pis.liferay.model.EmployeePromotionRequest;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee promotion request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeePromotionRequestUtil
 * @generated
 */
@ProviderType
public interface EmployeePromotionRequestPersistence
	extends BasePersistence<EmployeePromotionRequest> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeePromotionRequestUtil} to access the employee promotion request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee promotion requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee promotion requests
	 */
	public java.util.List<EmployeePromotionRequest> findByUuid(String uuid);

	/**
	 * Returns a range of all the employee promotion requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee promotion requests
	 * @param end the upper bound of the range of employee promotion requests (not inclusive)
	 * @return the range of matching employee promotion requests
	 */
	public java.util.List<EmployeePromotionRequest> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the employee promotion requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee promotion requests
	 * @param end the upper bound of the range of employee promotion requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee promotion requests
	 */
	public java.util.List<EmployeePromotionRequest> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeePromotionRequest> orderByComparator);

	/**
	 * Returns an ordered range of all the employee promotion requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee promotion requests
	 * @param end the upper bound of the range of employee promotion requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee promotion requests
	 */
	public java.util.List<EmployeePromotionRequest> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeePromotionRequest> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee promotion request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee promotion request
	 * @throws NoSuchEmployeePromotionRequestException if a matching employee promotion request could not be found
	 */
	public EmployeePromotionRequest findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeePromotionRequest> orderByComparator)
		throws NoSuchEmployeePromotionRequestException;

	/**
	 * Returns the first employee promotion request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee promotion request, or <code>null</code> if a matching employee promotion request could not be found
	 */
	public EmployeePromotionRequest fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeePromotionRequest> orderByComparator);

	/**
	 * Returns the last employee promotion request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee promotion request
	 * @throws NoSuchEmployeePromotionRequestException if a matching employee promotion request could not be found
	 */
	public EmployeePromotionRequest findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeePromotionRequest> orderByComparator)
		throws NoSuchEmployeePromotionRequestException;

	/**
	 * Returns the last employee promotion request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee promotion request, or <code>null</code> if a matching employee promotion request could not be found
	 */
	public EmployeePromotionRequest fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeePromotionRequest> orderByComparator);

	/**
	 * Returns the employee promotion requests before and after the current employee promotion request in the ordered set where uuid = &#63;.
	 *
	 * @param employeePromotionRequestId the primary key of the current employee promotion request
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee promotion request
	 * @throws NoSuchEmployeePromotionRequestException if a employee promotion request with the primary key could not be found
	 */
	public EmployeePromotionRequest[] findByUuid_PrevAndNext(
			long employeePromotionRequestId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeePromotionRequest> orderByComparator)
		throws NoSuchEmployeePromotionRequestException;

	/**
	 * Removes all the employee promotion requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of employee promotion requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee promotion requests
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the employee promotion request where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeePromotionRequestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee promotion request
	 * @throws NoSuchEmployeePromotionRequestException if a matching employee promotion request could not be found
	 */
	public EmployeePromotionRequest findByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeePromotionRequestException;

	/**
	 * Returns the employee promotion request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee promotion request, or <code>null</code> if a matching employee promotion request could not be found
	 */
	public EmployeePromotionRequest fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the employee promotion request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee promotion request, or <code>null</code> if a matching employee promotion request could not be found
	 */
	public EmployeePromotionRequest fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the employee promotion request where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee promotion request that was removed
	 */
	public EmployeePromotionRequest removeByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeePromotionRequestException;

	/**
	 * Returns the number of employee promotion requests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee promotion requests
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the employee promotion requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee promotion requests
	 */
	public java.util.List<EmployeePromotionRequest> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the employee promotion requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee promotion requests
	 * @param end the upper bound of the range of employee promotion requests (not inclusive)
	 * @return the range of matching employee promotion requests
	 */
	public java.util.List<EmployeePromotionRequest> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the employee promotion requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee promotion requests
	 * @param end the upper bound of the range of employee promotion requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee promotion requests
	 */
	public java.util.List<EmployeePromotionRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeePromotionRequest> orderByComparator);

	/**
	 * Returns an ordered range of all the employee promotion requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee promotion requests
	 * @param end the upper bound of the range of employee promotion requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee promotion requests
	 */
	public java.util.List<EmployeePromotionRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeePromotionRequest> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee promotion request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee promotion request
	 * @throws NoSuchEmployeePromotionRequestException if a matching employee promotion request could not be found
	 */
	public EmployeePromotionRequest findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeePromotionRequest> orderByComparator)
		throws NoSuchEmployeePromotionRequestException;

	/**
	 * Returns the first employee promotion request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee promotion request, or <code>null</code> if a matching employee promotion request could not be found
	 */
	public EmployeePromotionRequest fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeePromotionRequest> orderByComparator);

	/**
	 * Returns the last employee promotion request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee promotion request
	 * @throws NoSuchEmployeePromotionRequestException if a matching employee promotion request could not be found
	 */
	public EmployeePromotionRequest findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeePromotionRequest> orderByComparator)
		throws NoSuchEmployeePromotionRequestException;

	/**
	 * Returns the last employee promotion request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee promotion request, or <code>null</code> if a matching employee promotion request could not be found
	 */
	public EmployeePromotionRequest fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeePromotionRequest> orderByComparator);

	/**
	 * Returns the employee promotion requests before and after the current employee promotion request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param employeePromotionRequestId the primary key of the current employee promotion request
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee promotion request
	 * @throws NoSuchEmployeePromotionRequestException if a employee promotion request with the primary key could not be found
	 */
	public EmployeePromotionRequest[] findByUuid_C_PrevAndNext(
			long employeePromotionRequestId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeePromotionRequest> orderByComparator)
		throws NoSuchEmployeePromotionRequestException;

	/**
	 * Removes all the employee promotion requests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of employee promotion requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee promotion requests
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the employee promotion request in the entity cache if it is enabled.
	 *
	 * @param employeePromotionRequest the employee promotion request
	 */
	public void cacheResult(EmployeePromotionRequest employeePromotionRequest);

	/**
	 * Caches the employee promotion requests in the entity cache if it is enabled.
	 *
	 * @param employeePromotionRequests the employee promotion requests
	 */
	public void cacheResult(
		java.util.List<EmployeePromotionRequest> employeePromotionRequests);

	/**
	 * Creates a new employee promotion request with the primary key. Does not add the employee promotion request to the database.
	 *
	 * @param employeePromotionRequestId the primary key for the new employee promotion request
	 * @return the new employee promotion request
	 */
	public EmployeePromotionRequest create(long employeePromotionRequestId);

	/**
	 * Removes the employee promotion request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeePromotionRequestId the primary key of the employee promotion request
	 * @return the employee promotion request that was removed
	 * @throws NoSuchEmployeePromotionRequestException if a employee promotion request with the primary key could not be found
	 */
	public EmployeePromotionRequest remove(long employeePromotionRequestId)
		throws NoSuchEmployeePromotionRequestException;

	public EmployeePromotionRequest updateImpl(
		EmployeePromotionRequest employeePromotionRequest);

	/**
	 * Returns the employee promotion request with the primary key or throws a <code>NoSuchEmployeePromotionRequestException</code> if it could not be found.
	 *
	 * @param employeePromotionRequestId the primary key of the employee promotion request
	 * @return the employee promotion request
	 * @throws NoSuchEmployeePromotionRequestException if a employee promotion request with the primary key could not be found
	 */
	public EmployeePromotionRequest findByPrimaryKey(
			long employeePromotionRequestId)
		throws NoSuchEmployeePromotionRequestException;

	/**
	 * Returns the employee promotion request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeePromotionRequestId the primary key of the employee promotion request
	 * @return the employee promotion request, or <code>null</code> if a employee promotion request with the primary key could not be found
	 */
	public EmployeePromotionRequest fetchByPrimaryKey(
		long employeePromotionRequestId);

	/**
	 * Returns all the employee promotion requests.
	 *
	 * @return the employee promotion requests
	 */
	public java.util.List<EmployeePromotionRequest> findAll();

	/**
	 * Returns a range of all the employee promotion requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee promotion requests
	 * @param end the upper bound of the range of employee promotion requests (not inclusive)
	 * @return the range of employee promotion requests
	 */
	public java.util.List<EmployeePromotionRequest> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee promotion requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee promotion requests
	 * @param end the upper bound of the range of employee promotion requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee promotion requests
	 */
	public java.util.List<EmployeePromotionRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeePromotionRequest> orderByComparator);

	/**
	 * Returns an ordered range of all the employee promotion requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee promotion requests
	 * @param end the upper bound of the range of employee promotion requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee promotion requests
	 */
	public java.util.List<EmployeePromotionRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeePromotionRequest> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee promotion requests from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee promotion requests.
	 *
	 * @return the number of employee promotion requests
	 */
	public int countAll();

}