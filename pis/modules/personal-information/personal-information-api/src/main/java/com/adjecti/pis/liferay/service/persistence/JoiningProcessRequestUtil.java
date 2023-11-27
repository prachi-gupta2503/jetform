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

import com.adjecti.pis.liferay.model.JoiningProcessRequest;

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
 * The persistence utility for the joining process request service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.JoiningProcessRequestPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JoiningProcessRequestPersistence
 * @generated
 */
public class JoiningProcessRequestUtil {

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
	public static void clearCache(JoiningProcessRequest joiningProcessRequest) {
		getPersistence().clearCache(joiningProcessRequest);
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
	public static Map<Serializable, JoiningProcessRequest> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<JoiningProcessRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<JoiningProcessRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<JoiningProcessRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<JoiningProcessRequest> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static JoiningProcessRequest update(
		JoiningProcessRequest joiningProcessRequest) {

		return getPersistence().update(joiningProcessRequest);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static JoiningProcessRequest update(
		JoiningProcessRequest joiningProcessRequest,
		ServiceContext serviceContext) {

		return getPersistence().update(joiningProcessRequest, serviceContext);
	}

	/**
	 * Returns all the joining process requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching joining process requests
	 */
	public static List<JoiningProcessRequest> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the joining process requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of joining process requests
	 * @param end the upper bound of the range of joining process requests (not inclusive)
	 * @return the range of matching joining process requests
	 */
	public static List<JoiningProcessRequest> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the joining process requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of joining process requests
	 * @param end the upper bound of the range of joining process requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching joining process requests
	 */
	public static List<JoiningProcessRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<JoiningProcessRequest> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the joining process requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of joining process requests
	 * @param end the upper bound of the range of joining process requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching joining process requests
	 */
	public static List<JoiningProcessRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<JoiningProcessRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first joining process request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching joining process request
	 * @throws NoSuchJoiningProcessRequestException if a matching joining process request could not be found
	 */
	public static JoiningProcessRequest findByUuid_First(
			String uuid,
			OrderByComparator<JoiningProcessRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchJoiningProcessRequestException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first joining process request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching joining process request, or <code>null</code> if a matching joining process request could not be found
	 */
	public static JoiningProcessRequest fetchByUuid_First(
		String uuid,
		OrderByComparator<JoiningProcessRequest> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last joining process request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching joining process request
	 * @throws NoSuchJoiningProcessRequestException if a matching joining process request could not be found
	 */
	public static JoiningProcessRequest findByUuid_Last(
			String uuid,
			OrderByComparator<JoiningProcessRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchJoiningProcessRequestException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last joining process request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching joining process request, or <code>null</code> if a matching joining process request could not be found
	 */
	public static JoiningProcessRequest fetchByUuid_Last(
		String uuid,
		OrderByComparator<JoiningProcessRequest> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the joining process requests before and after the current joining process request in the ordered set where uuid = &#63;.
	 *
	 * @param joiningProcessRequestId the primary key of the current joining process request
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next joining process request
	 * @throws NoSuchJoiningProcessRequestException if a joining process request with the primary key could not be found
	 */
	public static JoiningProcessRequest[] findByUuid_PrevAndNext(
			long joiningProcessRequestId, String uuid,
			OrderByComparator<JoiningProcessRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchJoiningProcessRequestException {

		return getPersistence().findByUuid_PrevAndNext(
			joiningProcessRequestId, uuid, orderByComparator);
	}

	/**
	 * Removes all the joining process requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of joining process requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching joining process requests
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the joining process request where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchJoiningProcessRequestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching joining process request
	 * @throws NoSuchJoiningProcessRequestException if a matching joining process request could not be found
	 */
	public static JoiningProcessRequest findByUUID_G(String uuid, long groupId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchJoiningProcessRequestException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the joining process request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching joining process request, or <code>null</code> if a matching joining process request could not be found
	 */
	public static JoiningProcessRequest fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the joining process request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching joining process request, or <code>null</code> if a matching joining process request could not be found
	 */
	public static JoiningProcessRequest fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the joining process request where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the joining process request that was removed
	 */
	public static JoiningProcessRequest removeByUUID_G(
			String uuid, long groupId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchJoiningProcessRequestException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of joining process requests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching joining process requests
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the joining process requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching joining process requests
	 */
	public static List<JoiningProcessRequest> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the joining process requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of joining process requests
	 * @param end the upper bound of the range of joining process requests (not inclusive)
	 * @return the range of matching joining process requests
	 */
	public static List<JoiningProcessRequest> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the joining process requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of joining process requests
	 * @param end the upper bound of the range of joining process requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching joining process requests
	 */
	public static List<JoiningProcessRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<JoiningProcessRequest> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the joining process requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of joining process requests
	 * @param end the upper bound of the range of joining process requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching joining process requests
	 */
	public static List<JoiningProcessRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<JoiningProcessRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first joining process request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching joining process request
	 * @throws NoSuchJoiningProcessRequestException if a matching joining process request could not be found
	 */
	public static JoiningProcessRequest findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<JoiningProcessRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchJoiningProcessRequestException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first joining process request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching joining process request, or <code>null</code> if a matching joining process request could not be found
	 */
	public static JoiningProcessRequest fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<JoiningProcessRequest> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last joining process request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching joining process request
	 * @throws NoSuchJoiningProcessRequestException if a matching joining process request could not be found
	 */
	public static JoiningProcessRequest findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<JoiningProcessRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchJoiningProcessRequestException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last joining process request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching joining process request, or <code>null</code> if a matching joining process request could not be found
	 */
	public static JoiningProcessRequest fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<JoiningProcessRequest> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the joining process requests before and after the current joining process request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param joiningProcessRequestId the primary key of the current joining process request
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next joining process request
	 * @throws NoSuchJoiningProcessRequestException if a joining process request with the primary key could not be found
	 */
	public static JoiningProcessRequest[] findByUuid_C_PrevAndNext(
			long joiningProcessRequestId, String uuid, long companyId,
			OrderByComparator<JoiningProcessRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchJoiningProcessRequestException {

		return getPersistence().findByUuid_C_PrevAndNext(
			joiningProcessRequestId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the joining process requests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of joining process requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching joining process requests
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the joining process request in the entity cache if it is enabled.
	 *
	 * @param joiningProcessRequest the joining process request
	 */
	public static void cacheResult(
		JoiningProcessRequest joiningProcessRequest) {

		getPersistence().cacheResult(joiningProcessRequest);
	}

	/**
	 * Caches the joining process requests in the entity cache if it is enabled.
	 *
	 * @param joiningProcessRequests the joining process requests
	 */
	public static void cacheResult(
		List<JoiningProcessRequest> joiningProcessRequests) {

		getPersistence().cacheResult(joiningProcessRequests);
	}

	/**
	 * Creates a new joining process request with the primary key. Does not add the joining process request to the database.
	 *
	 * @param joiningProcessRequestId the primary key for the new joining process request
	 * @return the new joining process request
	 */
	public static JoiningProcessRequest create(long joiningProcessRequestId) {
		return getPersistence().create(joiningProcessRequestId);
	}

	/**
	 * Removes the joining process request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param joiningProcessRequestId the primary key of the joining process request
	 * @return the joining process request that was removed
	 * @throws NoSuchJoiningProcessRequestException if a joining process request with the primary key could not be found
	 */
	public static JoiningProcessRequest remove(long joiningProcessRequestId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchJoiningProcessRequestException {

		return getPersistence().remove(joiningProcessRequestId);
	}

	public static JoiningProcessRequest updateImpl(
		JoiningProcessRequest joiningProcessRequest) {

		return getPersistence().updateImpl(joiningProcessRequest);
	}

	/**
	 * Returns the joining process request with the primary key or throws a <code>NoSuchJoiningProcessRequestException</code> if it could not be found.
	 *
	 * @param joiningProcessRequestId the primary key of the joining process request
	 * @return the joining process request
	 * @throws NoSuchJoiningProcessRequestException if a joining process request with the primary key could not be found
	 */
	public static JoiningProcessRequest findByPrimaryKey(
			long joiningProcessRequestId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchJoiningProcessRequestException {

		return getPersistence().findByPrimaryKey(joiningProcessRequestId);
	}

	/**
	 * Returns the joining process request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param joiningProcessRequestId the primary key of the joining process request
	 * @return the joining process request, or <code>null</code> if a joining process request with the primary key could not be found
	 */
	public static JoiningProcessRequest fetchByPrimaryKey(
		long joiningProcessRequestId) {

		return getPersistence().fetchByPrimaryKey(joiningProcessRequestId);
	}

	/**
	 * Returns all the joining process requests.
	 *
	 * @return the joining process requests
	 */
	public static List<JoiningProcessRequest> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the joining process requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of joining process requests
	 * @param end the upper bound of the range of joining process requests (not inclusive)
	 * @return the range of joining process requests
	 */
	public static List<JoiningProcessRequest> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the joining process requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of joining process requests
	 * @param end the upper bound of the range of joining process requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of joining process requests
	 */
	public static List<JoiningProcessRequest> findAll(
		int start, int end,
		OrderByComparator<JoiningProcessRequest> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the joining process requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of joining process requests
	 * @param end the upper bound of the range of joining process requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of joining process requests
	 */
	public static List<JoiningProcessRequest> findAll(
		int start, int end,
		OrderByComparator<JoiningProcessRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the joining process requests from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of joining process requests.
	 *
	 * @return the number of joining process requests
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static JoiningProcessRequestPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<JoiningProcessRequestPersistence, JoiningProcessRequestPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			JoiningProcessRequestPersistence.class);

		ServiceTracker
			<JoiningProcessRequestPersistence, JoiningProcessRequestPersistence>
				serviceTracker =
					new ServiceTracker
						<JoiningProcessRequestPersistence,
						 JoiningProcessRequestPersistence>(
							 bundle.getBundleContext(),
							 JoiningProcessRequestPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}