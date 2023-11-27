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

import com.adjecti.pis.liferay.model.EmployeePromotionRequest;

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
 * The persistence utility for the employee promotion request service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.EmployeePromotionRequestPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeePromotionRequestPersistence
 * @generated
 */
public class EmployeePromotionRequestUtil {

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
		EmployeePromotionRequest employeePromotionRequest) {

		getPersistence().clearCache(employeePromotionRequest);
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
	public static Map<Serializable, EmployeePromotionRequest>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeePromotionRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeePromotionRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeePromotionRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeePromotionRequest> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeePromotionRequest update(
		EmployeePromotionRequest employeePromotionRequest) {

		return getPersistence().update(employeePromotionRequest);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeePromotionRequest update(
		EmployeePromotionRequest employeePromotionRequest,
		ServiceContext serviceContext) {

		return getPersistence().update(
			employeePromotionRequest, serviceContext);
	}

	/**
	 * Returns all the employee promotion requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee promotion requests
	 */
	public static List<EmployeePromotionRequest> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<EmployeePromotionRequest> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<EmployeePromotionRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeePromotionRequest> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<EmployeePromotionRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmployeePromotionRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee promotion request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee promotion request
	 * @throws NoSuchEmployeePromotionRequestException if a matching employee promotion request could not be found
	 */
	public static EmployeePromotionRequest findByUuid_First(
			String uuid,
			OrderByComparator<EmployeePromotionRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePromotionRequestException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first employee promotion request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee promotion request, or <code>null</code> if a matching employee promotion request could not be found
	 */
	public static EmployeePromotionRequest fetchByUuid_First(
		String uuid,
		OrderByComparator<EmployeePromotionRequest> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last employee promotion request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee promotion request
	 * @throws NoSuchEmployeePromotionRequestException if a matching employee promotion request could not be found
	 */
	public static EmployeePromotionRequest findByUuid_Last(
			String uuid,
			OrderByComparator<EmployeePromotionRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePromotionRequestException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last employee promotion request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee promotion request, or <code>null</code> if a matching employee promotion request could not be found
	 */
	public static EmployeePromotionRequest fetchByUuid_Last(
		String uuid,
		OrderByComparator<EmployeePromotionRequest> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the employee promotion requests before and after the current employee promotion request in the ordered set where uuid = &#63;.
	 *
	 * @param employeePromotionRequestId the primary key of the current employee promotion request
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee promotion request
	 * @throws NoSuchEmployeePromotionRequestException if a employee promotion request with the primary key could not be found
	 */
	public static EmployeePromotionRequest[] findByUuid_PrevAndNext(
			long employeePromotionRequestId, String uuid,
			OrderByComparator<EmployeePromotionRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePromotionRequestException {

		return getPersistence().findByUuid_PrevAndNext(
			employeePromotionRequestId, uuid, orderByComparator);
	}

	/**
	 * Removes all the employee promotion requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of employee promotion requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee promotion requests
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the employee promotion request where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeePromotionRequestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee promotion request
	 * @throws NoSuchEmployeePromotionRequestException if a matching employee promotion request could not be found
	 */
	public static EmployeePromotionRequest findByUUID_G(
			String uuid, long groupId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePromotionRequestException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the employee promotion request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee promotion request, or <code>null</code> if a matching employee promotion request could not be found
	 */
	public static EmployeePromotionRequest fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the employee promotion request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee promotion request, or <code>null</code> if a matching employee promotion request could not be found
	 */
	public static EmployeePromotionRequest fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the employee promotion request where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee promotion request that was removed
	 */
	public static EmployeePromotionRequest removeByUUID_G(
			String uuid, long groupId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePromotionRequestException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of employee promotion requests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee promotion requests
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the employee promotion requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee promotion requests
	 */
	public static List<EmployeePromotionRequest> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<EmployeePromotionRequest> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<EmployeePromotionRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeePromotionRequest> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<EmployeePromotionRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeePromotionRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee promotion request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee promotion request
	 * @throws NoSuchEmployeePromotionRequestException if a matching employee promotion request could not be found
	 */
	public static EmployeePromotionRequest findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EmployeePromotionRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePromotionRequestException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first employee promotion request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee promotion request, or <code>null</code> if a matching employee promotion request could not be found
	 */
	public static EmployeePromotionRequest fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EmployeePromotionRequest> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last employee promotion request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee promotion request
	 * @throws NoSuchEmployeePromotionRequestException if a matching employee promotion request could not be found
	 */
	public static EmployeePromotionRequest findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EmployeePromotionRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePromotionRequestException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last employee promotion request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee promotion request, or <code>null</code> if a matching employee promotion request could not be found
	 */
	public static EmployeePromotionRequest fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EmployeePromotionRequest> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static EmployeePromotionRequest[] findByUuid_C_PrevAndNext(
			long employeePromotionRequestId, String uuid, long companyId,
			OrderByComparator<EmployeePromotionRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePromotionRequestException {

		return getPersistence().findByUuid_C_PrevAndNext(
			employeePromotionRequestId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the employee promotion requests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of employee promotion requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee promotion requests
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the employee promotion request in the entity cache if it is enabled.
	 *
	 * @param employeePromotionRequest the employee promotion request
	 */
	public static void cacheResult(
		EmployeePromotionRequest employeePromotionRequest) {

		getPersistence().cacheResult(employeePromotionRequest);
	}

	/**
	 * Caches the employee promotion requests in the entity cache if it is enabled.
	 *
	 * @param employeePromotionRequests the employee promotion requests
	 */
	public static void cacheResult(
		List<EmployeePromotionRequest> employeePromotionRequests) {

		getPersistence().cacheResult(employeePromotionRequests);
	}

	/**
	 * Creates a new employee promotion request with the primary key. Does not add the employee promotion request to the database.
	 *
	 * @param employeePromotionRequestId the primary key for the new employee promotion request
	 * @return the new employee promotion request
	 */
	public static EmployeePromotionRequest create(
		long employeePromotionRequestId) {

		return getPersistence().create(employeePromotionRequestId);
	}

	/**
	 * Removes the employee promotion request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeePromotionRequestId the primary key of the employee promotion request
	 * @return the employee promotion request that was removed
	 * @throws NoSuchEmployeePromotionRequestException if a employee promotion request with the primary key could not be found
	 */
	public static EmployeePromotionRequest remove(
			long employeePromotionRequestId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePromotionRequestException {

		return getPersistence().remove(employeePromotionRequestId);
	}

	public static EmployeePromotionRequest updateImpl(
		EmployeePromotionRequest employeePromotionRequest) {

		return getPersistence().updateImpl(employeePromotionRequest);
	}

	/**
	 * Returns the employee promotion request with the primary key or throws a <code>NoSuchEmployeePromotionRequestException</code> if it could not be found.
	 *
	 * @param employeePromotionRequestId the primary key of the employee promotion request
	 * @return the employee promotion request
	 * @throws NoSuchEmployeePromotionRequestException if a employee promotion request with the primary key could not be found
	 */
	public static EmployeePromotionRequest findByPrimaryKey(
			long employeePromotionRequestId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePromotionRequestException {

		return getPersistence().findByPrimaryKey(employeePromotionRequestId);
	}

	/**
	 * Returns the employee promotion request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeePromotionRequestId the primary key of the employee promotion request
	 * @return the employee promotion request, or <code>null</code> if a employee promotion request with the primary key could not be found
	 */
	public static EmployeePromotionRequest fetchByPrimaryKey(
		long employeePromotionRequestId) {

		return getPersistence().fetchByPrimaryKey(employeePromotionRequestId);
	}

	/**
	 * Returns all the employee promotion requests.
	 *
	 * @return the employee promotion requests
	 */
	public static List<EmployeePromotionRequest> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<EmployeePromotionRequest> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<EmployeePromotionRequest> findAll(
		int start, int end,
		OrderByComparator<EmployeePromotionRequest> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<EmployeePromotionRequest> findAll(
		int start, int end,
		OrderByComparator<EmployeePromotionRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee promotion requests from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee promotion requests.
	 *
	 * @return the number of employee promotion requests
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeePromotionRequestPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeePromotionRequestPersistence,
		 EmployeePromotionRequestPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EmployeePromotionRequestPersistence.class);

		ServiceTracker
			<EmployeePromotionRequestPersistence,
			 EmployeePromotionRequestPersistence> serviceTracker =
				new ServiceTracker
					<EmployeePromotionRequestPersistence,
					 EmployeePromotionRequestPersistence>(
						 bundle.getBundleContext(),
						 EmployeePromotionRequestPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}