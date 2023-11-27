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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeSeparationRequestException;
import com.adjecti.pis.liferay.model.EmployeeSeparationRequest;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee separation request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeSeparationRequestUtil
 * @generated
 */
@ProviderType
public interface EmployeeSeparationRequestPersistence
	extends BasePersistence<EmployeeSeparationRequest> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeSeparationRequestUtil} to access the employee separation request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee separation requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee separation requests
	 */
	public java.util.List<EmployeeSeparationRequest> findByUuid(String uuid);

	/**
	 * Returns a range of all the employee separation requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSeparationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee separation requests
	 * @param end the upper bound of the range of employee separation requests (not inclusive)
	 * @return the range of matching employee separation requests
	 */
	public java.util.List<EmployeeSeparationRequest> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the employee separation requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSeparationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee separation requests
	 * @param end the upper bound of the range of employee separation requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee separation requests
	 */
	public java.util.List<EmployeeSeparationRequest> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeSeparationRequest> orderByComparator);

	/**
	 * Returns an ordered range of all the employee separation requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSeparationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee separation requests
	 * @param end the upper bound of the range of employee separation requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee separation requests
	 */
	public java.util.List<EmployeeSeparationRequest> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeSeparationRequest> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee separation request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee separation request
	 * @throws NoSuchEmployeeSeparationRequestException if a matching employee separation request could not be found
	 */
	public EmployeeSeparationRequest findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeSeparationRequest> orderByComparator)
		throws NoSuchEmployeeSeparationRequestException;

	/**
	 * Returns the first employee separation request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee separation request, or <code>null</code> if a matching employee separation request could not be found
	 */
	public EmployeeSeparationRequest fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeSeparationRequest> orderByComparator);

	/**
	 * Returns the last employee separation request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee separation request
	 * @throws NoSuchEmployeeSeparationRequestException if a matching employee separation request could not be found
	 */
	public EmployeeSeparationRequest findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeSeparationRequest> orderByComparator)
		throws NoSuchEmployeeSeparationRequestException;

	/**
	 * Returns the last employee separation request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee separation request, or <code>null</code> if a matching employee separation request could not be found
	 */
	public EmployeeSeparationRequest fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeSeparationRequest> orderByComparator);

	/**
	 * Returns the employee separation requests before and after the current employee separation request in the ordered set where uuid = &#63;.
	 *
	 * @param employeeSeparationRequestId the primary key of the current employee separation request
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee separation request
	 * @throws NoSuchEmployeeSeparationRequestException if a employee separation request with the primary key could not be found
	 */
	public EmployeeSeparationRequest[] findByUuid_PrevAndNext(
			long employeeSeparationRequestId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeSeparationRequest> orderByComparator)
		throws NoSuchEmployeeSeparationRequestException;

	/**
	 * Removes all the employee separation requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of employee separation requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee separation requests
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the employee separation request where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeeSeparationRequestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee separation request
	 * @throws NoSuchEmployeeSeparationRequestException if a matching employee separation request could not be found
	 */
	public EmployeeSeparationRequest findByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeSeparationRequestException;

	/**
	 * Returns the employee separation request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee separation request, or <code>null</code> if a matching employee separation request could not be found
	 */
	public EmployeeSeparationRequest fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the employee separation request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee separation request, or <code>null</code> if a matching employee separation request could not be found
	 */
	public EmployeeSeparationRequest fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the employee separation request where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee separation request that was removed
	 */
	public EmployeeSeparationRequest removeByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeSeparationRequestException;

	/**
	 * Returns the number of employee separation requests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee separation requests
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the employee separation requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee separation requests
	 */
	public java.util.List<EmployeeSeparationRequest> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the employee separation requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSeparationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee separation requests
	 * @param end the upper bound of the range of employee separation requests (not inclusive)
	 * @return the range of matching employee separation requests
	 */
	public java.util.List<EmployeeSeparationRequest> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the employee separation requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSeparationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee separation requests
	 * @param end the upper bound of the range of employee separation requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee separation requests
	 */
	public java.util.List<EmployeeSeparationRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeSeparationRequest> orderByComparator);

	/**
	 * Returns an ordered range of all the employee separation requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSeparationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee separation requests
	 * @param end the upper bound of the range of employee separation requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee separation requests
	 */
	public java.util.List<EmployeeSeparationRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeSeparationRequest> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee separation request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee separation request
	 * @throws NoSuchEmployeeSeparationRequestException if a matching employee separation request could not be found
	 */
	public EmployeeSeparationRequest findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeSeparationRequest> orderByComparator)
		throws NoSuchEmployeeSeparationRequestException;

	/**
	 * Returns the first employee separation request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee separation request, or <code>null</code> if a matching employee separation request could not be found
	 */
	public EmployeeSeparationRequest fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeSeparationRequest> orderByComparator);

	/**
	 * Returns the last employee separation request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee separation request
	 * @throws NoSuchEmployeeSeparationRequestException if a matching employee separation request could not be found
	 */
	public EmployeeSeparationRequest findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeSeparationRequest> orderByComparator)
		throws NoSuchEmployeeSeparationRequestException;

	/**
	 * Returns the last employee separation request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee separation request, or <code>null</code> if a matching employee separation request could not be found
	 */
	public EmployeeSeparationRequest fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeSeparationRequest> orderByComparator);

	/**
	 * Returns the employee separation requests before and after the current employee separation request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param employeeSeparationRequestId the primary key of the current employee separation request
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee separation request
	 * @throws NoSuchEmployeeSeparationRequestException if a employee separation request with the primary key could not be found
	 */
	public EmployeeSeparationRequest[] findByUuid_C_PrevAndNext(
			long employeeSeparationRequestId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeSeparationRequest> orderByComparator)
		throws NoSuchEmployeeSeparationRequestException;

	/**
	 * Removes all the employee separation requests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of employee separation requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee separation requests
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the employee separation request in the entity cache if it is enabled.
	 *
	 * @param employeeSeparationRequest the employee separation request
	 */
	public void cacheResult(
		EmployeeSeparationRequest employeeSeparationRequest);

	/**
	 * Caches the employee separation requests in the entity cache if it is enabled.
	 *
	 * @param employeeSeparationRequests the employee separation requests
	 */
	public void cacheResult(
		java.util.List<EmployeeSeparationRequest> employeeSeparationRequests);

	/**
	 * Creates a new employee separation request with the primary key. Does not add the employee separation request to the database.
	 *
	 * @param employeeSeparationRequestId the primary key for the new employee separation request
	 * @return the new employee separation request
	 */
	public EmployeeSeparationRequest create(long employeeSeparationRequestId);

	/**
	 * Removes the employee separation request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeSeparationRequestId the primary key of the employee separation request
	 * @return the employee separation request that was removed
	 * @throws NoSuchEmployeeSeparationRequestException if a employee separation request with the primary key could not be found
	 */
	public EmployeeSeparationRequest remove(long employeeSeparationRequestId)
		throws NoSuchEmployeeSeparationRequestException;

	public EmployeeSeparationRequest updateImpl(
		EmployeeSeparationRequest employeeSeparationRequest);

	/**
	 * Returns the employee separation request with the primary key or throws a <code>NoSuchEmployeeSeparationRequestException</code> if it could not be found.
	 *
	 * @param employeeSeparationRequestId the primary key of the employee separation request
	 * @return the employee separation request
	 * @throws NoSuchEmployeeSeparationRequestException if a employee separation request with the primary key could not be found
	 */
	public EmployeeSeparationRequest findByPrimaryKey(
			long employeeSeparationRequestId)
		throws NoSuchEmployeeSeparationRequestException;

	/**
	 * Returns the employee separation request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeSeparationRequestId the primary key of the employee separation request
	 * @return the employee separation request, or <code>null</code> if a employee separation request with the primary key could not be found
	 */
	public EmployeeSeparationRequest fetchByPrimaryKey(
		long employeeSeparationRequestId);

	/**
	 * Returns all the employee separation requests.
	 *
	 * @return the employee separation requests
	 */
	public java.util.List<EmployeeSeparationRequest> findAll();

	/**
	 * Returns a range of all the employee separation requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSeparationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee separation requests
	 * @param end the upper bound of the range of employee separation requests (not inclusive)
	 * @return the range of employee separation requests
	 */
	public java.util.List<EmployeeSeparationRequest> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the employee separation requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSeparationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee separation requests
	 * @param end the upper bound of the range of employee separation requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee separation requests
	 */
	public java.util.List<EmployeeSeparationRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeSeparationRequest> orderByComparator);

	/**
	 * Returns an ordered range of all the employee separation requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSeparationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee separation requests
	 * @param end the upper bound of the range of employee separation requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee separation requests
	 */
	public java.util.List<EmployeeSeparationRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<EmployeeSeparationRequest> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee separation requests from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee separation requests.
	 *
	 * @return the number of employee separation requests
	 */
	public int countAll();

}