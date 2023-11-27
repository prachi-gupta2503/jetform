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

import com.adjecti.pis.liferay.model.EmployeeDeputationRequest;

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
 * The persistence utility for the employee deputation request service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.EmployeeDeputationRequestPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDeputationRequestPersistence
 * @generated
 */
public class EmployeeDeputationRequestUtil {

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
	public static void clearCache(
		EmployeeDeputationRequest employeeDeputationRequest) {

		getPersistence().clearCache(employeeDeputationRequest);
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
	public static Map<Serializable, EmployeeDeputationRequest>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeDeputationRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeDeputationRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeDeputationRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeDeputationRequest> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeDeputationRequest update(
		EmployeeDeputationRequest employeeDeputationRequest) {

		return getPersistence().update(employeeDeputationRequest);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeDeputationRequest update(
		EmployeeDeputationRequest employeeDeputationRequest,
		ServiceContext serviceContext) {

		return getPersistence().update(
			employeeDeputationRequest, serviceContext);
	}

	/**
	 * Returns all the employee deputation requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee deputation requests
	 */
	public static List<EmployeeDeputationRequest> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<EmployeeDeputationRequest> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<EmployeeDeputationRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeDeputationRequest> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<EmployeeDeputationRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeeDeputationRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee deputation request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee deputation request
	 * @throws NoSuchEmployeeDeputationRequestException if a matching employee deputation request could not be found
	 */
	public static EmployeeDeputationRequest findByUuid_First(
			String uuid,
			OrderByComparator<EmployeeDeputationRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeDeputationRequestException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first employee deputation request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee deputation request, or <code>null</code> if a matching employee deputation request could not be found
	 */
	public static EmployeeDeputationRequest fetchByUuid_First(
		String uuid,
		OrderByComparator<EmployeeDeputationRequest> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last employee deputation request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee deputation request
	 * @throws NoSuchEmployeeDeputationRequestException if a matching employee deputation request could not be found
	 */
	public static EmployeeDeputationRequest findByUuid_Last(
			String uuid,
			OrderByComparator<EmployeeDeputationRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeDeputationRequestException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last employee deputation request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee deputation request, or <code>null</code> if a matching employee deputation request could not be found
	 */
	public static EmployeeDeputationRequest fetchByUuid_Last(
		String uuid,
		OrderByComparator<EmployeeDeputationRequest> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the employee deputation requests before and after the current employee deputation request in the ordered set where uuid = &#63;.
	 *
	 * @param employeeDeputationRequestId the primary key of the current employee deputation request
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee deputation request
	 * @throws NoSuchEmployeeDeputationRequestException if a employee deputation request with the primary key could not be found
	 */
	public static EmployeeDeputationRequest[] findByUuid_PrevAndNext(
			long employeeDeputationRequestId, String uuid,
			OrderByComparator<EmployeeDeputationRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeDeputationRequestException {

		return getPersistence().findByUuid_PrevAndNext(
			employeeDeputationRequestId, uuid, orderByComparator);
	}

	/**
	 * Removes all the employee deputation requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of employee deputation requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee deputation requests
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the employee deputation request where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeeDeputationRequestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee deputation request
	 * @throws NoSuchEmployeeDeputationRequestException if a matching employee deputation request could not be found
	 */
	public static EmployeeDeputationRequest findByUUID_G(
			String uuid, long groupId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeDeputationRequestException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the employee deputation request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee deputation request, or <code>null</code> if a matching employee deputation request could not be found
	 */
	public static EmployeeDeputationRequest fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the employee deputation request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee deputation request, or <code>null</code> if a matching employee deputation request could not be found
	 */
	public static EmployeeDeputationRequest fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the employee deputation request where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee deputation request that was removed
	 */
	public static EmployeeDeputationRequest removeByUUID_G(
			String uuid, long groupId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeDeputationRequestException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of employee deputation requests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee deputation requests
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the employee deputation requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee deputation requests
	 */
	public static List<EmployeeDeputationRequest> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<EmployeeDeputationRequest> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<EmployeeDeputationRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeDeputationRequest> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<EmployeeDeputationRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeDeputationRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee deputation request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee deputation request
	 * @throws NoSuchEmployeeDeputationRequestException if a matching employee deputation request could not be found
	 */
	public static EmployeeDeputationRequest findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EmployeeDeputationRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeDeputationRequestException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first employee deputation request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee deputation request, or <code>null</code> if a matching employee deputation request could not be found
	 */
	public static EmployeeDeputationRequest fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EmployeeDeputationRequest> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last employee deputation request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee deputation request
	 * @throws NoSuchEmployeeDeputationRequestException if a matching employee deputation request could not be found
	 */
	public static EmployeeDeputationRequest findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EmployeeDeputationRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeDeputationRequestException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last employee deputation request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee deputation request, or <code>null</code> if a matching employee deputation request could not be found
	 */
	public static EmployeeDeputationRequest fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EmployeeDeputationRequest> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static EmployeeDeputationRequest[] findByUuid_C_PrevAndNext(
			long employeeDeputationRequestId, String uuid, long companyId,
			OrderByComparator<EmployeeDeputationRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeDeputationRequestException {

		return getPersistence().findByUuid_C_PrevAndNext(
			employeeDeputationRequestId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the employee deputation requests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of employee deputation requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee deputation requests
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the employee deputation request in the entity cache if it is enabled.
	 *
	 * @param employeeDeputationRequest the employee deputation request
	 */
	public static void cacheResult(
		EmployeeDeputationRequest employeeDeputationRequest) {

		getPersistence().cacheResult(employeeDeputationRequest);
	}

	/**
	 * Caches the employee deputation requests in the entity cache if it is enabled.
	 *
	 * @param employeeDeputationRequests the employee deputation requests
	 */
	public static void cacheResult(
		List<EmployeeDeputationRequest> employeeDeputationRequests) {

		getPersistence().cacheResult(employeeDeputationRequests);
	}

	/**
	 * Creates a new employee deputation request with the primary key. Does not add the employee deputation request to the database.
	 *
	 * @param employeeDeputationRequestId the primary key for the new employee deputation request
	 * @return the new employee deputation request
	 */
	public static EmployeeDeputationRequest create(
		long employeeDeputationRequestId) {

		return getPersistence().create(employeeDeputationRequestId);
	}

	/**
	 * Removes the employee deputation request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeDeputationRequestId the primary key of the employee deputation request
	 * @return the employee deputation request that was removed
	 * @throws NoSuchEmployeeDeputationRequestException if a employee deputation request with the primary key could not be found
	 */
	public static EmployeeDeputationRequest remove(
			long employeeDeputationRequestId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeDeputationRequestException {

		return getPersistence().remove(employeeDeputationRequestId);
	}

	public static EmployeeDeputationRequest updateImpl(
		EmployeeDeputationRequest employeeDeputationRequest) {

		return getPersistence().updateImpl(employeeDeputationRequest);
	}

	/**
	 * Returns the employee deputation request with the primary key or throws a <code>NoSuchEmployeeDeputationRequestException</code> if it could not be found.
	 *
	 * @param employeeDeputationRequestId the primary key of the employee deputation request
	 * @return the employee deputation request
	 * @throws NoSuchEmployeeDeputationRequestException if a employee deputation request with the primary key could not be found
	 */
	public static EmployeeDeputationRequest findByPrimaryKey(
			long employeeDeputationRequestId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeDeputationRequestException {

		return getPersistence().findByPrimaryKey(employeeDeputationRequestId);
	}

	/**
	 * Returns the employee deputation request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeDeputationRequestId the primary key of the employee deputation request
	 * @return the employee deputation request, or <code>null</code> if a employee deputation request with the primary key could not be found
	 */
	public static EmployeeDeputationRequest fetchByPrimaryKey(
		long employeeDeputationRequestId) {

		return getPersistence().fetchByPrimaryKey(employeeDeputationRequestId);
	}

	/**
	 * Returns all the employee deputation requests.
	 *
	 * @return the employee deputation requests
	 */
	public static List<EmployeeDeputationRequest> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<EmployeeDeputationRequest> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<EmployeeDeputationRequest> findAll(
		int start, int end,
		OrderByComparator<EmployeeDeputationRequest> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<EmployeeDeputationRequest> findAll(
		int start, int end,
		OrderByComparator<EmployeeDeputationRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee deputation requests from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee deputation requests.
	 *
	 * @return the number of employee deputation requests
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeDeputationRequestPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeeDeputationRequestPersistence,
		 EmployeeDeputationRequestPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EmployeeDeputationRequestPersistence.class);

		ServiceTracker
			<EmployeeDeputationRequestPersistence,
			 EmployeeDeputationRequestPersistence> serviceTracker =
				new ServiceTracker
					<EmployeeDeputationRequestPersistence,
					 EmployeeDeputationRequestPersistence>(
						 bundle.getBundleContext(),
						 EmployeeDeputationRequestPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}