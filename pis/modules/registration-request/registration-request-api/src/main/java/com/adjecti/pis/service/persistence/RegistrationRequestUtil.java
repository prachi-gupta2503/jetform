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

package com.adjecti.pis.service.persistence;

import com.adjecti.pis.model.RegistrationRequest;

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
 * The persistence utility for the registration request service. This utility wraps <code>com.adjecti.pis.service.persistence.impl.RegistrationRequestPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RegistrationRequestPersistence
 * @generated
 */
public class RegistrationRequestUtil {

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
	public static void clearCache(RegistrationRequest registrationRequest) {
		getPersistence().clearCache(registrationRequest);
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
	public static Map<Serializable, RegistrationRequest> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RegistrationRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RegistrationRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RegistrationRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RegistrationRequest update(
		RegistrationRequest registrationRequest) {

		return getPersistence().update(registrationRequest);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RegistrationRequest update(
		RegistrationRequest registrationRequest,
		ServiceContext serviceContext) {

		return getPersistence().update(registrationRequest, serviceContext);
	}

	/**
	 * Returns all the registration requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching registration requests
	 */
	public static List<RegistrationRequest> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the registration requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests
	 */
	public static List<RegistrationRequest> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the registration requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests
	 */
	public static List<RegistrationRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the registration requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration requests
	 */
	public static List<RegistrationRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first registration request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public static RegistrationRequest findByUuid_First(
			String uuid,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first registration request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static RegistrationRequest fetchByUuid_First(
		String uuid, OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last registration request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public static RegistrationRequest findByUuid_Last(
			String uuid,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last registration request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static RegistrationRequest fetchByUuid_Last(
		String uuid, OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where uuid = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	public static RegistrationRequest[] findByUuid_PrevAndNext(
			long registrationRequestId, String uuid,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByUuid_PrevAndNext(
			registrationRequestId, uuid, orderByComparator);
	}

	/**
	 * Removes all the registration requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of registration requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching registration requests
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the registration request where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchRegistrationRequestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public static RegistrationRequest findByUUID_G(String uuid, long groupId)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the registration request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static RegistrationRequest fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the registration request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static RegistrationRequest fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the registration request where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the registration request that was removed
	 */
	public static RegistrationRequest removeByUUID_G(String uuid, long groupId)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of registration requests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching registration requests
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the registration requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching registration requests
	 */
	public static List<RegistrationRequest> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the registration requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests
	 */
	public static List<RegistrationRequest> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the registration requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests
	 */
	public static List<RegistrationRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the registration requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration requests
	 */
	public static List<RegistrationRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first registration request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public static RegistrationRequest findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first registration request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static RegistrationRequest fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last registration request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public static RegistrationRequest findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last registration request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static RegistrationRequest fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	public static RegistrationRequest[] findByUuid_C_PrevAndNext(
			long registrationRequestId, String uuid, long companyId,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByUuid_C_PrevAndNext(
			registrationRequestId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the registration requests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of registration requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching registration requests
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the registration requests where bulkOnbordingFileId = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @return the matching registration requests
	 */
	public static List<RegistrationRequest> findByBulkOnbordingFileId(
		long bulkOnbordingFileId) {

		return getPersistence().findByBulkOnbordingFileId(bulkOnbordingFileId);
	}

	/**
	 * Returns a range of all the registration requests where bulkOnbordingFileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests
	 */
	public static List<RegistrationRequest> findByBulkOnbordingFileId(
		long bulkOnbordingFileId, int start, int end) {

		return getPersistence().findByBulkOnbordingFileId(
			bulkOnbordingFileId, start, end);
	}

	/**
	 * Returns an ordered range of all the registration requests where bulkOnbordingFileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests
	 */
	public static List<RegistrationRequest> findByBulkOnbordingFileId(
		long bulkOnbordingFileId, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().findByBulkOnbordingFileId(
			bulkOnbordingFileId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the registration requests where bulkOnbordingFileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration requests
	 */
	public static List<RegistrationRequest> findByBulkOnbordingFileId(
		long bulkOnbordingFileId, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByBulkOnbordingFileId(
			bulkOnbordingFileId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first registration request in the ordered set where bulkOnbordingFileId = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public static RegistrationRequest findByBulkOnbordingFileId_First(
			long bulkOnbordingFileId,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByBulkOnbordingFileId_First(
			bulkOnbordingFileId, orderByComparator);
	}

	/**
	 * Returns the first registration request in the ordered set where bulkOnbordingFileId = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static RegistrationRequest fetchByBulkOnbordingFileId_First(
		long bulkOnbordingFileId,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().fetchByBulkOnbordingFileId_First(
			bulkOnbordingFileId, orderByComparator);
	}

	/**
	 * Returns the last registration request in the ordered set where bulkOnbordingFileId = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public static RegistrationRequest findByBulkOnbordingFileId_Last(
			long bulkOnbordingFileId,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByBulkOnbordingFileId_Last(
			bulkOnbordingFileId, orderByComparator);
	}

	/**
	 * Returns the last registration request in the ordered set where bulkOnbordingFileId = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static RegistrationRequest fetchByBulkOnbordingFileId_Last(
		long bulkOnbordingFileId,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().fetchByBulkOnbordingFileId_Last(
			bulkOnbordingFileId, orderByComparator);
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where bulkOnbordingFileId = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	public static RegistrationRequest[] findByBulkOnbordingFileId_PrevAndNext(
			long registrationRequestId, long bulkOnbordingFileId,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByBulkOnbordingFileId_PrevAndNext(
			registrationRequestId, bulkOnbordingFileId, orderByComparator);
	}

	/**
	 * Removes all the registration requests where bulkOnbordingFileId = &#63; from the database.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 */
	public static void removeByBulkOnbordingFileId(long bulkOnbordingFileId) {
		getPersistence().removeByBulkOnbordingFileId(bulkOnbordingFileId);
	}

	/**
	 * Returns the number of registration requests where bulkOnbordingFileId = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @return the number of matching registration requests
	 */
	public static int countByBulkOnbordingFileId(long bulkOnbordingFileId) {
		return getPersistence().countByBulkOnbordingFileId(bulkOnbordingFileId);
	}

	/**
	 * Returns all the registration requests where bulkOnbordingFileId = &#63; and status = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param status the status
	 * @return the matching registration requests
	 */
	public static List<RegistrationRequest> findByBulkOnbordingFileIdAndStatus(
		long bulkOnbordingFileId, int status) {

		return getPersistence().findByBulkOnbordingFileIdAndStatus(
			bulkOnbordingFileId, status);
	}

	/**
	 * Returns a range of all the registration requests where bulkOnbordingFileId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests
	 */
	public static List<RegistrationRequest> findByBulkOnbordingFileIdAndStatus(
		long bulkOnbordingFileId, int status, int start, int end) {

		return getPersistence().findByBulkOnbordingFileIdAndStatus(
			bulkOnbordingFileId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the registration requests where bulkOnbordingFileId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests
	 */
	public static List<RegistrationRequest> findByBulkOnbordingFileIdAndStatus(
		long bulkOnbordingFileId, int status, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().findByBulkOnbordingFileIdAndStatus(
			bulkOnbordingFileId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the registration requests where bulkOnbordingFileId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration requests
	 */
	public static List<RegistrationRequest> findByBulkOnbordingFileIdAndStatus(
		long bulkOnbordingFileId, int status, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByBulkOnbordingFileIdAndStatus(
			bulkOnbordingFileId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first registration request in the ordered set where bulkOnbordingFileId = &#63; and status = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public static RegistrationRequest findByBulkOnbordingFileIdAndStatus_First(
			long bulkOnbordingFileId, int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByBulkOnbordingFileIdAndStatus_First(
			bulkOnbordingFileId, status, orderByComparator);
	}

	/**
	 * Returns the first registration request in the ordered set where bulkOnbordingFileId = &#63; and status = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static RegistrationRequest fetchByBulkOnbordingFileIdAndStatus_First(
		long bulkOnbordingFileId, int status,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().fetchByBulkOnbordingFileIdAndStatus_First(
			bulkOnbordingFileId, status, orderByComparator);
	}

	/**
	 * Returns the last registration request in the ordered set where bulkOnbordingFileId = &#63; and status = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public static RegistrationRequest findByBulkOnbordingFileIdAndStatus_Last(
			long bulkOnbordingFileId, int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByBulkOnbordingFileIdAndStatus_Last(
			bulkOnbordingFileId, status, orderByComparator);
	}

	/**
	 * Returns the last registration request in the ordered set where bulkOnbordingFileId = &#63; and status = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static RegistrationRequest fetchByBulkOnbordingFileIdAndStatus_Last(
		long bulkOnbordingFileId, int status,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().fetchByBulkOnbordingFileIdAndStatus_Last(
			bulkOnbordingFileId, status, orderByComparator);
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where bulkOnbordingFileId = &#63; and status = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	public static RegistrationRequest[]
			findByBulkOnbordingFileIdAndStatus_PrevAndNext(
				long registrationRequestId, long bulkOnbordingFileId,
				int status,
				OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByBulkOnbordingFileIdAndStatus_PrevAndNext(
			registrationRequestId, bulkOnbordingFileId, status,
			orderByComparator);
	}

	/**
	 * Removes all the registration requests where bulkOnbordingFileId = &#63; and status = &#63; from the database.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param status the status
	 */
	public static void removeByBulkOnbordingFileIdAndStatus(
		long bulkOnbordingFileId, int status) {

		getPersistence().removeByBulkOnbordingFileIdAndStatus(
			bulkOnbordingFileId, status);
	}

	/**
	 * Returns the number of registration requests where bulkOnbordingFileId = &#63; and status = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param status the status
	 * @return the number of matching registration requests
	 */
	public static int countByBulkOnbordingFileIdAndStatus(
		long bulkOnbordingFileId, int status) {

		return getPersistence().countByBulkOnbordingFileIdAndStatus(
			bulkOnbordingFileId, status);
	}

	/**
	 * Returns all the registration requests where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching registration requests
	 */
	public static List<RegistrationRequest> findByStatus(int status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the registration requests where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests
	 */
	public static List<RegistrationRequest> findByStatus(
		int status, int start, int end) {

		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the registration requests where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests
	 */
	public static List<RegistrationRequest> findByStatus(
		int status, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the registration requests where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration requests
	 */
	public static List<RegistrationRequest> findByStatus(
		int status, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first registration request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public static RegistrationRequest findByStatus_First(
			int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first registration request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static RegistrationRequest fetchByStatus_First(
		int status, OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last registration request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public static RegistrationRequest findByStatus_Last(
			int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last registration request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static RegistrationRequest fetchByStatus_Last(
		int status, OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where status = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	public static RegistrationRequest[] findByStatus_PrevAndNext(
			long registrationRequestId, int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByStatus_PrevAndNext(
			registrationRequestId, status, orderByComparator);
	}

	/**
	 * Removes all the registration requests where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of registration requests where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching registration requests
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns all the registration requests where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @return the matching registration requests
	 */
	public static List<RegistrationRequest> findByUnitId(long unitId) {
		return getPersistence().findByUnitId(unitId);
	}

	/**
	 * Returns a range of all the registration requests where unitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests
	 */
	public static List<RegistrationRequest> findByUnitId(
		long unitId, int start, int end) {

		return getPersistence().findByUnitId(unitId, start, end);
	}

	/**
	 * Returns an ordered range of all the registration requests where unitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests
	 */
	public static List<RegistrationRequest> findByUnitId(
		long unitId, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().findByUnitId(
			unitId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the registration requests where unitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration requests
	 */
	public static List<RegistrationRequest> findByUnitId(
		long unitId, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUnitId(
			unitId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first registration request in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public static RegistrationRequest findByUnitId_First(
			long unitId,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByUnitId_First(unitId, orderByComparator);
	}

	/**
	 * Returns the first registration request in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static RegistrationRequest fetchByUnitId_First(
		long unitId, OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().fetchByUnitId_First(unitId, orderByComparator);
	}

	/**
	 * Returns the last registration request in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public static RegistrationRequest findByUnitId_Last(
			long unitId,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByUnitId_Last(unitId, orderByComparator);
	}

	/**
	 * Returns the last registration request in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static RegistrationRequest fetchByUnitId_Last(
		long unitId, OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().fetchByUnitId_Last(unitId, orderByComparator);
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where unitId = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	public static RegistrationRequest[] findByUnitId_PrevAndNext(
			long registrationRequestId, long unitId,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByUnitId_PrevAndNext(
			registrationRequestId, unitId, orderByComparator);
	}

	/**
	 * Removes all the registration requests where unitId = &#63; from the database.
	 *
	 * @param unitId the unit ID
	 */
	public static void removeByUnitId(long unitId) {
		getPersistence().removeByUnitId(unitId);
	}

	/**
	 * Returns the number of registration requests where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @return the number of matching registration requests
	 */
	public static int countByUnitId(long unitId) {
		return getPersistence().countByUnitId(unitId);
	}

	/**
	 * Returns all the registration requests where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @return the matching registration requests
	 */
	public static List<RegistrationRequest> findByUnitIdAndStatus(
		long unitId, int status) {

		return getPersistence().findByUnitIdAndStatus(unitId, status);
	}

	/**
	 * Returns a range of all the registration requests where unitId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests
	 */
	public static List<RegistrationRequest> findByUnitIdAndStatus(
		long unitId, int status, int start, int end) {

		return getPersistence().findByUnitIdAndStatus(
			unitId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the registration requests where unitId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests
	 */
	public static List<RegistrationRequest> findByUnitIdAndStatus(
		long unitId, int status, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().findByUnitIdAndStatus(
			unitId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the registration requests where unitId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration requests
	 */
	public static List<RegistrationRequest> findByUnitIdAndStatus(
		long unitId, int status, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUnitIdAndStatus(
			unitId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first registration request in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public static RegistrationRequest findByUnitIdAndStatus_First(
			long unitId, int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByUnitIdAndStatus_First(
			unitId, status, orderByComparator);
	}

	/**
	 * Returns the first registration request in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static RegistrationRequest fetchByUnitIdAndStatus_First(
		long unitId, int status,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().fetchByUnitIdAndStatus_First(
			unitId, status, orderByComparator);
	}

	/**
	 * Returns the last registration request in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public static RegistrationRequest findByUnitIdAndStatus_Last(
			long unitId, int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByUnitIdAndStatus_Last(
			unitId, status, orderByComparator);
	}

	/**
	 * Returns the last registration request in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static RegistrationRequest fetchByUnitIdAndStatus_Last(
		long unitId, int status,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().fetchByUnitIdAndStatus_Last(
			unitId, status, orderByComparator);
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	public static RegistrationRequest[] findByUnitIdAndStatus_PrevAndNext(
			long registrationRequestId, long unitId, int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByUnitIdAndStatus_PrevAndNext(
			registrationRequestId, unitId, status, orderByComparator);
	}

	/**
	 * Removes all the registration requests where unitId = &#63; and status = &#63; from the database.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 */
	public static void removeByUnitIdAndStatus(long unitId, int status) {
		getPersistence().removeByUnitIdAndStatus(unitId, status);
	}

	/**
	 * Returns the number of registration requests where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @return the number of matching registration requests
	 */
	public static int countByUnitIdAndStatus(long unitId, int status) {
		return getPersistence().countByUnitIdAndStatus(unitId, status);
	}

	/**
	 * Returns all the registration requests where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @return the matching registration requests
	 */
	public static List<RegistrationRequest> findByUnitIdsAndStatusList(
		long unitId, int status) {

		return getPersistence().findByUnitIdsAndStatusList(unitId, status);
	}

	/**
	 * Returns a range of all the registration requests where unitId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests
	 */
	public static List<RegistrationRequest> findByUnitIdsAndStatusList(
		long unitId, int status, int start, int end) {

		return getPersistence().findByUnitIdsAndStatusList(
			unitId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the registration requests where unitId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests
	 */
	public static List<RegistrationRequest> findByUnitIdsAndStatusList(
		long unitId, int status, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().findByUnitIdsAndStatusList(
			unitId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the registration requests where unitId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration requests
	 */
	public static List<RegistrationRequest> findByUnitIdsAndStatusList(
		long unitId, int status, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUnitIdsAndStatusList(
			unitId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first registration request in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public static RegistrationRequest findByUnitIdsAndStatusList_First(
			long unitId, int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByUnitIdsAndStatusList_First(
			unitId, status, orderByComparator);
	}

	/**
	 * Returns the first registration request in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static RegistrationRequest fetchByUnitIdsAndStatusList_First(
		long unitId, int status,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().fetchByUnitIdsAndStatusList_First(
			unitId, status, orderByComparator);
	}

	/**
	 * Returns the last registration request in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public static RegistrationRequest findByUnitIdsAndStatusList_Last(
			long unitId, int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByUnitIdsAndStatusList_Last(
			unitId, status, orderByComparator);
	}

	/**
	 * Returns the last registration request in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static RegistrationRequest fetchByUnitIdsAndStatusList_Last(
		long unitId, int status,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().fetchByUnitIdsAndStatusList_Last(
			unitId, status, orderByComparator);
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	public static RegistrationRequest[] findByUnitIdsAndStatusList_PrevAndNext(
			long registrationRequestId, long unitId, int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByUnitIdsAndStatusList_PrevAndNext(
			registrationRequestId, unitId, status, orderByComparator);
	}

	/**
	 * Returns all the registration requests where unitId = any &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unitIds the unit IDs
	 * @param statuses the statuses
	 * @return the matching registration requests
	 */
	public static List<RegistrationRequest> findByUnitIdsAndStatusList(
		long[] unitIds, int[] statuses) {

		return getPersistence().findByUnitIdsAndStatusList(unitIds, statuses);
	}

	/**
	 * Returns a range of all the registration requests where unitId = any &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unitIds the unit IDs
	 * @param statuses the statuses
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests
	 */
	public static List<RegistrationRequest> findByUnitIdsAndStatusList(
		long[] unitIds, int[] statuses, int start, int end) {

		return getPersistence().findByUnitIdsAndStatusList(
			unitIds, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the registration requests where unitId = any &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unitIds the unit IDs
	 * @param statuses the statuses
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests
	 */
	public static List<RegistrationRequest> findByUnitIdsAndStatusList(
		long[] unitIds, int[] statuses, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().findByUnitIdsAndStatusList(
			unitIds, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the registration requests where unitId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration requests
	 */
	public static List<RegistrationRequest> findByUnitIdsAndStatusList(
		long[] unitIds, int[] statuses, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUnitIdsAndStatusList(
			unitIds, statuses, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the registration requests where unitId = &#63; and status = &#63; from the database.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 */
	public static void removeByUnitIdsAndStatusList(long unitId, int status) {
		getPersistence().removeByUnitIdsAndStatusList(unitId, status);
	}

	/**
	 * Returns the number of registration requests where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @return the number of matching registration requests
	 */
	public static int countByUnitIdsAndStatusList(long unitId, int status) {
		return getPersistence().countByUnitIdsAndStatusList(unitId, status);
	}

	/**
	 * Returns the number of registration requests where unitId = any &#63; and status = any &#63;.
	 *
	 * @param unitIds the unit IDs
	 * @param statuses the statuses
	 * @return the number of matching registration requests
	 */
	public static int countByUnitIdsAndStatusList(
		long[] unitIds, int[] statuses) {

		return getPersistence().countByUnitIdsAndStatusList(unitIds, statuses);
	}

	/**
	 * Returns all the registration requests where unitId = &#63; and state = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @return the matching registration requests
	 */
	public static List<RegistrationRequest> findByUnitIdAndState(
		long unitId, String state) {

		return getPersistence().findByUnitIdAndState(unitId, state);
	}

	/**
	 * Returns a range of all the registration requests where unitId = &#63; and state = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests
	 */
	public static List<RegistrationRequest> findByUnitIdAndState(
		long unitId, String state, int start, int end) {

		return getPersistence().findByUnitIdAndState(unitId, state, start, end);
	}

	/**
	 * Returns an ordered range of all the registration requests where unitId = &#63; and state = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests
	 */
	public static List<RegistrationRequest> findByUnitIdAndState(
		long unitId, String state, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().findByUnitIdAndState(
			unitId, state, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the registration requests where unitId = &#63; and state = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration requests
	 */
	public static List<RegistrationRequest> findByUnitIdAndState(
		long unitId, String state, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUnitIdAndState(
			unitId, state, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first registration request in the ordered set where unitId = &#63; and state = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public static RegistrationRequest findByUnitIdAndState_First(
			long unitId, String state,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByUnitIdAndState_First(
			unitId, state, orderByComparator);
	}

	/**
	 * Returns the first registration request in the ordered set where unitId = &#63; and state = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static RegistrationRequest fetchByUnitIdAndState_First(
		long unitId, String state,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().fetchByUnitIdAndState_First(
			unitId, state, orderByComparator);
	}

	/**
	 * Returns the last registration request in the ordered set where unitId = &#63; and state = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public static RegistrationRequest findByUnitIdAndState_Last(
			long unitId, String state,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByUnitIdAndState_Last(
			unitId, state, orderByComparator);
	}

	/**
	 * Returns the last registration request in the ordered set where unitId = &#63; and state = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static RegistrationRequest fetchByUnitIdAndState_Last(
		long unitId, String state,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().fetchByUnitIdAndState_Last(
			unitId, state, orderByComparator);
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where unitId = &#63; and state = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param unitId the unit ID
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	public static RegistrationRequest[] findByUnitIdAndState_PrevAndNext(
			long registrationRequestId, long unitId, String state,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByUnitIdAndState_PrevAndNext(
			registrationRequestId, unitId, state, orderByComparator);
	}

	/**
	 * Removes all the registration requests where unitId = &#63; and state = &#63; from the database.
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 */
	public static void removeByUnitIdAndState(long unitId, String state) {
		getPersistence().removeByUnitIdAndState(unitId, state);
	}

	/**
	 * Returns the number of registration requests where unitId = &#63; and state = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @return the number of matching registration requests
	 */
	public static int countByUnitIdAndState(long unitId, String state) {
		return getPersistence().countByUnitIdAndState(unitId, state);
	}

	/**
	 * Returns all the registration requests where unit = &#63;.
	 *
	 * @param unit the unit
	 * @return the matching registration requests
	 */
	public static List<RegistrationRequest> findByUnit(String unit) {
		return getPersistence().findByUnit(unit);
	}

	/**
	 * Returns a range of all the registration requests where unit = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unit the unit
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests
	 */
	public static List<RegistrationRequest> findByUnit(
		String unit, int start, int end) {

		return getPersistence().findByUnit(unit, start, end);
	}

	/**
	 * Returns an ordered range of all the registration requests where unit = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unit the unit
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests
	 */
	public static List<RegistrationRequest> findByUnit(
		String unit, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().findByUnit(unit, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the registration requests where unit = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unit the unit
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration requests
	 */
	public static List<RegistrationRequest> findByUnit(
		String unit, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUnit(
			unit, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first registration request in the ordered set where unit = &#63;.
	 *
	 * @param unit the unit
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public static RegistrationRequest findByUnit_First(
			String unit,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByUnit_First(unit, orderByComparator);
	}

	/**
	 * Returns the first registration request in the ordered set where unit = &#63;.
	 *
	 * @param unit the unit
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static RegistrationRequest fetchByUnit_First(
		String unit, OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().fetchByUnit_First(unit, orderByComparator);
	}

	/**
	 * Returns the last registration request in the ordered set where unit = &#63;.
	 *
	 * @param unit the unit
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public static RegistrationRequest findByUnit_Last(
			String unit,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByUnit_Last(unit, orderByComparator);
	}

	/**
	 * Returns the last registration request in the ordered set where unit = &#63;.
	 *
	 * @param unit the unit
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static RegistrationRequest fetchByUnit_Last(
		String unit, OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().fetchByUnit_Last(unit, orderByComparator);
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where unit = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param unit the unit
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	public static RegistrationRequest[] findByUnit_PrevAndNext(
			long registrationRequestId, String unit,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByUnit_PrevAndNext(
			registrationRequestId, unit, orderByComparator);
	}

	/**
	 * Removes all the registration requests where unit = &#63; from the database.
	 *
	 * @param unit the unit
	 */
	public static void removeByUnit(String unit) {
		getPersistence().removeByUnit(unit);
	}

	/**
	 * Returns the number of registration requests where unit = &#63;.
	 *
	 * @param unit the unit
	 * @return the number of matching registration requests
	 */
	public static int countByUnit(String unit) {
		return getPersistence().countByUnit(unit);
	}

	/**
	 * Returns all the registration requests where unit = &#63; and status = &#63;.
	 *
	 * @param unit the unit
	 * @param status the status
	 * @return the matching registration requests
	 */
	public static List<RegistrationRequest> findByUnitAndStatus(
		String unit, int status) {

		return getPersistence().findByUnitAndStatus(unit, status);
	}

	/**
	 * Returns a range of all the registration requests where unit = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unit the unit
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests
	 */
	public static List<RegistrationRequest> findByUnitAndStatus(
		String unit, int status, int start, int end) {

		return getPersistence().findByUnitAndStatus(unit, status, start, end);
	}

	/**
	 * Returns an ordered range of all the registration requests where unit = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unit the unit
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests
	 */
	public static List<RegistrationRequest> findByUnitAndStatus(
		String unit, int status, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().findByUnitAndStatus(
			unit, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the registration requests where unit = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unit the unit
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration requests
	 */
	public static List<RegistrationRequest> findByUnitAndStatus(
		String unit, int status, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUnitAndStatus(
			unit, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first registration request in the ordered set where unit = &#63; and status = &#63;.
	 *
	 * @param unit the unit
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public static RegistrationRequest findByUnitAndStatus_First(
			String unit, int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByUnitAndStatus_First(
			unit, status, orderByComparator);
	}

	/**
	 * Returns the first registration request in the ordered set where unit = &#63; and status = &#63;.
	 *
	 * @param unit the unit
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static RegistrationRequest fetchByUnitAndStatus_First(
		String unit, int status,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().fetchByUnitAndStatus_First(
			unit, status, orderByComparator);
	}

	/**
	 * Returns the last registration request in the ordered set where unit = &#63; and status = &#63;.
	 *
	 * @param unit the unit
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public static RegistrationRequest findByUnitAndStatus_Last(
			String unit, int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByUnitAndStatus_Last(
			unit, status, orderByComparator);
	}

	/**
	 * Returns the last registration request in the ordered set where unit = &#63; and status = &#63;.
	 *
	 * @param unit the unit
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static RegistrationRequest fetchByUnitAndStatus_Last(
		String unit, int status,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().fetchByUnitAndStatus_Last(
			unit, status, orderByComparator);
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where unit = &#63; and status = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param unit the unit
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	public static RegistrationRequest[] findByUnitAndStatus_PrevAndNext(
			long registrationRequestId, String unit, int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByUnitAndStatus_PrevAndNext(
			registrationRequestId, unit, status, orderByComparator);
	}

	/**
	 * Removes all the registration requests where unit = &#63; and status = &#63; from the database.
	 *
	 * @param unit the unit
	 * @param status the status
	 */
	public static void removeByUnitAndStatus(String unit, int status) {
		getPersistence().removeByUnitAndStatus(unit, status);
	}

	/**
	 * Returns the number of registration requests where unit = &#63; and status = &#63;.
	 *
	 * @param unit the unit
	 * @param status the status
	 * @return the number of matching registration requests
	 */
	public static int countByUnitAndStatus(String unit, int status) {
		return getPersistence().countByUnitAndStatus(unit, status);
	}

	/**
	 * Returns all the registration requests where unit = &#63; and state = &#63;.
	 *
	 * @param unit the unit
	 * @param state the state
	 * @return the matching registration requests
	 */
	public static List<RegistrationRequest> findByUnitAndState(
		String unit, String state) {

		return getPersistence().findByUnitAndState(unit, state);
	}

	/**
	 * Returns a range of all the registration requests where unit = &#63; and state = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unit the unit
	 * @param state the state
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests
	 */
	public static List<RegistrationRequest> findByUnitAndState(
		String unit, String state, int start, int end) {

		return getPersistence().findByUnitAndState(unit, state, start, end);
	}

	/**
	 * Returns an ordered range of all the registration requests where unit = &#63; and state = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unit the unit
	 * @param state the state
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests
	 */
	public static List<RegistrationRequest> findByUnitAndState(
		String unit, String state, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().findByUnitAndState(
			unit, state, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the registration requests where unit = &#63; and state = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param unit the unit
	 * @param state the state
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration requests
	 */
	public static List<RegistrationRequest> findByUnitAndState(
		String unit, String state, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUnitAndState(
			unit, state, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first registration request in the ordered set where unit = &#63; and state = &#63;.
	 *
	 * @param unit the unit
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public static RegistrationRequest findByUnitAndState_First(
			String unit, String state,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByUnitAndState_First(
			unit, state, orderByComparator);
	}

	/**
	 * Returns the first registration request in the ordered set where unit = &#63; and state = &#63;.
	 *
	 * @param unit the unit
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static RegistrationRequest fetchByUnitAndState_First(
		String unit, String state,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().fetchByUnitAndState_First(
			unit, state, orderByComparator);
	}

	/**
	 * Returns the last registration request in the ordered set where unit = &#63; and state = &#63;.
	 *
	 * @param unit the unit
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public static RegistrationRequest findByUnitAndState_Last(
			String unit, String state,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByUnitAndState_Last(
			unit, state, orderByComparator);
	}

	/**
	 * Returns the last registration request in the ordered set where unit = &#63; and state = &#63;.
	 *
	 * @param unit the unit
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static RegistrationRequest fetchByUnitAndState_Last(
		String unit, String state,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().fetchByUnitAndState_Last(
			unit, state, orderByComparator);
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where unit = &#63; and state = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param unit the unit
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	public static RegistrationRequest[] findByUnitAndState_PrevAndNext(
			long registrationRequestId, String unit, String state,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByUnitAndState_PrevAndNext(
			registrationRequestId, unit, state, orderByComparator);
	}

	/**
	 * Removes all the registration requests where unit = &#63; and state = &#63; from the database.
	 *
	 * @param unit the unit
	 * @param state the state
	 */
	public static void removeByUnitAndState(String unit, String state) {
		getPersistence().removeByUnitAndState(unit, state);
	}

	/**
	 * Returns the number of registration requests where unit = &#63; and state = &#63;.
	 *
	 * @param unit the unit
	 * @param state the state
	 * @return the number of matching registration requests
	 */
	public static int countByUnitAndState(String unit, String state) {
		return getPersistence().countByUnitAndState(unit, state);
	}

	/**
	 * Returns all the registration requests where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching registration requests
	 */
	public static List<RegistrationRequest> findByG_S(
		long groupId, int status) {

		return getPersistence().findByG_S(groupId, status);
	}

	/**
	 * Returns a range of all the registration requests where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests
	 */
	public static List<RegistrationRequest> findByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().findByG_S(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the registration requests where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests
	 */
	public static List<RegistrationRequest> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the registration requests where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration requests
	 */
	public static List<RegistrationRequest> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first registration request in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public static RegistrationRequest findByG_S_First(
			long groupId, int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the first registration request in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static RegistrationRequest fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().fetchByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last registration request in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public static RegistrationRequest findByG_S_Last(
			long groupId, int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last registration request in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static RegistrationRequest fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().fetchByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	public static RegistrationRequest[] findByG_S_PrevAndNext(
			long registrationRequestId, long groupId, int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByG_S_PrevAndNext(
			registrationRequestId, groupId, status, orderByComparator);
	}

	/**
	 * Returns all the registration requests that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching registration requests that the user has permission to view
	 */
	public static List<RegistrationRequest> filterFindByG_S(
		long groupId, int status) {

		return getPersistence().filterFindByG_S(groupId, status);
	}

	/**
	 * Returns a range of all the registration requests that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests that the user has permission to view
	 */
	public static List<RegistrationRequest> filterFindByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().filterFindByG_S(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the registration requests that the user has permissions to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests that the user has permission to view
	 */
	public static List<RegistrationRequest> filterFindByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().filterFindByG_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set of registration requests that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	public static RegistrationRequest[] filterFindByG_S_PrevAndNext(
			long registrationRequestId, long groupId, int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().filterFindByG_S_PrevAndNext(
			registrationRequestId, groupId, status, orderByComparator);
	}

	/**
	 * Removes all the registration requests where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByG_S(long groupId, int status) {
		getPersistence().removeByG_S(groupId, status);
	}

	/**
	 * Returns the number of registration requests where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching registration requests
	 */
	public static int countByG_S(long groupId, int status) {
		return getPersistence().countByG_S(groupId, status);
	}

	/**
	 * Returns the number of registration requests that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching registration requests that the user has permission to view
	 */
	public static int filterCountByG_S(long groupId, int status) {
		return getPersistence().filterCountByG_S(groupId, status);
	}

	/**
	 * Returns all the registration requests where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching registration requests
	 */
	public static List<RegistrationRequest> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the registration requests where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests
	 */
	public static List<RegistrationRequest> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the registration requests where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests
	 */
	public static List<RegistrationRequest> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the registration requests where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration requests
	 */
	public static List<RegistrationRequest> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first registration request in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public static RegistrationRequest findByGroupId_First(
			long groupId,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first registration request in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static RegistrationRequest fetchByGroupId_First(
		long groupId,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last registration request in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public static RegistrationRequest findByGroupId_Last(
			long groupId,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last registration request in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static RegistrationRequest fetchByGroupId_Last(
		long groupId,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where groupId = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	public static RegistrationRequest[] findByGroupId_PrevAndNext(
			long registrationRequestId, long groupId,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByGroupId_PrevAndNext(
			registrationRequestId, groupId, orderByComparator);
	}

	/**
	 * Returns all the registration requests that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching registration requests that the user has permission to view
	 */
	public static List<RegistrationRequest> filterFindByGroupId(long groupId) {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	 * Returns a range of all the registration requests that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests that the user has permission to view
	 */
	public static List<RegistrationRequest> filterFindByGroupId(
		long groupId, int start, int end) {

		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the registration requests that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests that the user has permission to view
	 */
	public static List<RegistrationRequest> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().filterFindByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set of registration requests that the user has permission to view where groupId = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	public static RegistrationRequest[] filterFindByGroupId_PrevAndNext(
			long registrationRequestId, long groupId,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().filterFindByGroupId_PrevAndNext(
			registrationRequestId, groupId, orderByComparator);
	}

	/**
	 * Removes all the registration requests where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of registration requests where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching registration requests
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns the number of registration requests that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching registration requests that the user has permission to view
	 */
	public static int filterCountByGroupId(long groupId) {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	 * Returns all the registration requests where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching registration requests
	 */
	public static List<RegistrationRequest> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the registration requests where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests
	 */
	public static List<RegistrationRequest> findByUserId(
		long userId, int start, int end) {

		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the registration requests where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests
	 */
	public static List<RegistrationRequest> findByUserId(
		long userId, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the registration requests where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration requests
	 */
	public static List<RegistrationRequest> findByUserId(
		long userId, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first registration request in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public static RegistrationRequest findByUserId_First(
			long userId,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first registration request in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static RegistrationRequest fetchByUserId_First(
		long userId, OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last registration request in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public static RegistrationRequest findByUserId_Last(
			long userId,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last registration request in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static RegistrationRequest fetchByUserId_Last(
		long userId, OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where userId = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	public static RegistrationRequest[] findByUserId_PrevAndNext(
			long registrationRequestId, long userId,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByUserId_PrevAndNext(
			registrationRequestId, userId, orderByComparator);
	}

	/**
	 * Removes all the registration requests where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of registration requests where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching registration requests
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Returns all the registration requests where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @return the matching registration requests
	 */
	public static List<RegistrationRequest> findByPersonalNo(long personalNo) {
		return getPersistence().findByPersonalNo(personalNo);
	}

	/**
	 * Returns a range of all the registration requests where personalNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param personalNo the personal no
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests
	 */
	public static List<RegistrationRequest> findByPersonalNo(
		long personalNo, int start, int end) {

		return getPersistence().findByPersonalNo(personalNo, start, end);
	}

	/**
	 * Returns an ordered range of all the registration requests where personalNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param personalNo the personal no
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests
	 */
	public static List<RegistrationRequest> findByPersonalNo(
		long personalNo, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().findByPersonalNo(
			personalNo, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the registration requests where personalNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param personalNo the personal no
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration requests
	 */
	public static List<RegistrationRequest> findByPersonalNo(
		long personalNo, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPersonalNo(
			personalNo, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first registration request in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public static RegistrationRequest findByPersonalNo_First(
			long personalNo,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByPersonalNo_First(
			personalNo, orderByComparator);
	}

	/**
	 * Returns the first registration request in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static RegistrationRequest fetchByPersonalNo_First(
		long personalNo,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().fetchByPersonalNo_First(
			personalNo, orderByComparator);
	}

	/**
	 * Returns the last registration request in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public static RegistrationRequest findByPersonalNo_Last(
			long personalNo,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByPersonalNo_Last(
			personalNo, orderByComparator);
	}

	/**
	 * Returns the last registration request in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static RegistrationRequest fetchByPersonalNo_Last(
		long personalNo,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().fetchByPersonalNo_Last(
			personalNo, orderByComparator);
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where personalNo = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	public static RegistrationRequest[] findByPersonalNo_PrevAndNext(
			long registrationRequestId, long personalNo,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByPersonalNo_PrevAndNext(
			registrationRequestId, personalNo, orderByComparator);
	}

	/**
	 * Removes all the registration requests where personalNo = &#63; from the database.
	 *
	 * @param personalNo the personal no
	 */
	public static void removeByPersonalNo(long personalNo) {
		getPersistence().removeByPersonalNo(personalNo);
	}

	/**
	 * Returns the number of registration requests where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @return the number of matching registration requests
	 */
	public static int countByPersonalNo(long personalNo) {
		return getPersistence().countByPersonalNo(personalNo);
	}

	/**
	 * Returns all the registration requests where recordNo = &#63;.
	 *
	 * @param recordNo the record no
	 * @return the matching registration requests
	 */
	public static List<RegistrationRequest> findByRecordNo(long recordNo) {
		return getPersistence().findByRecordNo(recordNo);
	}

	/**
	 * Returns a range of all the registration requests where recordNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param recordNo the record no
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests
	 */
	public static List<RegistrationRequest> findByRecordNo(
		long recordNo, int start, int end) {

		return getPersistence().findByRecordNo(recordNo, start, end);
	}

	/**
	 * Returns an ordered range of all the registration requests where recordNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param recordNo the record no
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests
	 */
	public static List<RegistrationRequest> findByRecordNo(
		long recordNo, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().findByRecordNo(
			recordNo, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the registration requests where recordNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param recordNo the record no
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration requests
	 */
	public static List<RegistrationRequest> findByRecordNo(
		long recordNo, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRecordNo(
			recordNo, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first registration request in the ordered set where recordNo = &#63;.
	 *
	 * @param recordNo the record no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public static RegistrationRequest findByRecordNo_First(
			long recordNo,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByRecordNo_First(
			recordNo, orderByComparator);
	}

	/**
	 * Returns the first registration request in the ordered set where recordNo = &#63;.
	 *
	 * @param recordNo the record no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static RegistrationRequest fetchByRecordNo_First(
		long recordNo,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().fetchByRecordNo_First(
			recordNo, orderByComparator);
	}

	/**
	 * Returns the last registration request in the ordered set where recordNo = &#63;.
	 *
	 * @param recordNo the record no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public static RegistrationRequest findByRecordNo_Last(
			long recordNo,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByRecordNo_Last(
			recordNo, orderByComparator);
	}

	/**
	 * Returns the last registration request in the ordered set where recordNo = &#63;.
	 *
	 * @param recordNo the record no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static RegistrationRequest fetchByRecordNo_Last(
		long recordNo,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().fetchByRecordNo_Last(
			recordNo, orderByComparator);
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where recordNo = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param recordNo the record no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	public static RegistrationRequest[] findByRecordNo_PrevAndNext(
			long registrationRequestId, long recordNo,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByRecordNo_PrevAndNext(
			registrationRequestId, recordNo, orderByComparator);
	}

	/**
	 * Removes all the registration requests where recordNo = &#63; from the database.
	 *
	 * @param recordNo the record no
	 */
	public static void removeByRecordNo(long recordNo) {
		getPersistence().removeByRecordNo(recordNo);
	}

	/**
	 * Returns the number of registration requests where recordNo = &#63;.
	 *
	 * @param recordNo the record no
	 * @return the number of matching registration requests
	 */
	public static int countByRecordNo(long recordNo) {
		return getPersistence().countByRecordNo(recordNo);
	}

	/**
	 * Returns all the registration requests where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the matching registration requests
	 */
	public static List<RegistrationRequest> findByEmailAddress(
		String emailAddress) {

		return getPersistence().findByEmailAddress(emailAddress);
	}

	/**
	 * Returns a range of all the registration requests where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests
	 */
	public static List<RegistrationRequest> findByEmailAddress(
		String emailAddress, int start, int end) {

		return getPersistence().findByEmailAddress(emailAddress, start, end);
	}

	/**
	 * Returns an ordered range of all the registration requests where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests
	 */
	public static List<RegistrationRequest> findByEmailAddress(
		String emailAddress, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().findByEmailAddress(
			emailAddress, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the registration requests where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration requests
	 */
	public static List<RegistrationRequest> findByEmailAddress(
		String emailAddress, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmailAddress(
			emailAddress, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first registration request in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public static RegistrationRequest findByEmailAddress_First(
			String emailAddress,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByEmailAddress_First(
			emailAddress, orderByComparator);
	}

	/**
	 * Returns the first registration request in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static RegistrationRequest fetchByEmailAddress_First(
		String emailAddress,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().fetchByEmailAddress_First(
			emailAddress, orderByComparator);
	}

	/**
	 * Returns the last registration request in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public static RegistrationRequest findByEmailAddress_Last(
			String emailAddress,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByEmailAddress_Last(
			emailAddress, orderByComparator);
	}

	/**
	 * Returns the last registration request in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static RegistrationRequest fetchByEmailAddress_Last(
		String emailAddress,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().fetchByEmailAddress_Last(
			emailAddress, orderByComparator);
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where emailAddress = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	public static RegistrationRequest[] findByEmailAddress_PrevAndNext(
			long registrationRequestId, String emailAddress,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByEmailAddress_PrevAndNext(
			registrationRequestId, emailAddress, orderByComparator);
	}

	/**
	 * Removes all the registration requests where emailAddress = &#63; from the database.
	 *
	 * @param emailAddress the email address
	 */
	public static void removeByEmailAddress(String emailAddress) {
		getPersistence().removeByEmailAddress(emailAddress);
	}

	/**
	 * Returns the number of registration requests where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the number of matching registration requests
	 */
	public static int countByEmailAddress(String emailAddress) {
		return getPersistence().countByEmailAddress(emailAddress);
	}

	/**
	 * Returns all the registration requests where loginId = &#63; and status = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @return the matching registration requests
	 */
	public static List<RegistrationRequest> findByLoginIdAndStatus(
		String loginId, int status) {

		return getPersistence().findByLoginIdAndStatus(loginId, status);
	}

	/**
	 * Returns a range of all the registration requests where loginId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests
	 */
	public static List<RegistrationRequest> findByLoginIdAndStatus(
		String loginId, int status, int start, int end) {

		return getPersistence().findByLoginIdAndStatus(
			loginId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the registration requests where loginId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests
	 */
	public static List<RegistrationRequest> findByLoginIdAndStatus(
		String loginId, int status, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().findByLoginIdAndStatus(
			loginId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the registration requests where loginId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration requests
	 */
	public static List<RegistrationRequest> findByLoginIdAndStatus(
		String loginId, int status, int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByLoginIdAndStatus(
			loginId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first registration request in the ordered set where loginId = &#63; and status = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public static RegistrationRequest findByLoginIdAndStatus_First(
			String loginId, int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByLoginIdAndStatus_First(
			loginId, status, orderByComparator);
	}

	/**
	 * Returns the first registration request in the ordered set where loginId = &#63; and status = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static RegistrationRequest fetchByLoginIdAndStatus_First(
		String loginId, int status,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().fetchByLoginIdAndStatus_First(
			loginId, status, orderByComparator);
	}

	/**
	 * Returns the last registration request in the ordered set where loginId = &#63; and status = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public static RegistrationRequest findByLoginIdAndStatus_Last(
			String loginId, int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByLoginIdAndStatus_Last(
			loginId, status, orderByComparator);
	}

	/**
	 * Returns the last registration request in the ordered set where loginId = &#63; and status = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static RegistrationRequest fetchByLoginIdAndStatus_Last(
		String loginId, int status,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().fetchByLoginIdAndStatus_Last(
			loginId, status, orderByComparator);
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where loginId = &#63; and status = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param loginId the login ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	public static RegistrationRequest[] findByLoginIdAndStatus_PrevAndNext(
			long registrationRequestId, String loginId, int status,
			OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByLoginIdAndStatus_PrevAndNext(
			registrationRequestId, loginId, status, orderByComparator);
	}

	/**
	 * Removes all the registration requests where loginId = &#63; and status = &#63; from the database.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 */
	public static void removeByLoginIdAndStatus(String loginId, int status) {
		getPersistence().removeByLoginIdAndStatus(loginId, status);
	}

	/**
	 * Returns the number of registration requests where loginId = &#63; and status = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @return the number of matching registration requests
	 */
	public static int countByLoginIdAndStatus(String loginId, int status) {
		return getPersistence().countByLoginIdAndStatus(loginId, status);
	}

	/**
	 * Returns all the registration requests where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @return the matching registration requests
	 */
	public static List<RegistrationRequest>
		findByLoginIdStatusStateAndIdamUserCreated(
			String loginId, int status, String state, boolean idamUserCreated) {

		return getPersistence().findByLoginIdStatusStateAndIdamUserCreated(
			loginId, status, state, idamUserCreated);
	}

	/**
	 * Returns a range of all the registration requests where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of matching registration requests
	 */
	public static List<RegistrationRequest>
		findByLoginIdStatusStateAndIdamUserCreated(
			String loginId, int status, String state, boolean idamUserCreated,
			int start, int end) {

		return getPersistence().findByLoginIdStatusStateAndIdamUserCreated(
			loginId, status, state, idamUserCreated, start, end);
	}

	/**
	 * Returns an ordered range of all the registration requests where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching registration requests
	 */
	public static List<RegistrationRequest>
		findByLoginIdStatusStateAndIdamUserCreated(
			String loginId, int status, String state, boolean idamUserCreated,
			int start, int end,
			OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().findByLoginIdStatusStateAndIdamUserCreated(
			loginId, status, state, idamUserCreated, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the registration requests where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching registration requests
	 */
	public static List<RegistrationRequest>
		findByLoginIdStatusStateAndIdamUserCreated(
			String loginId, int status, String state, boolean idamUserCreated,
			int start, int end,
			OrderByComparator<RegistrationRequest> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByLoginIdStatusStateAndIdamUserCreated(
			loginId, status, state, idamUserCreated, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first registration request in the ordered set where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public static RegistrationRequest
			findByLoginIdStatusStateAndIdamUserCreated_First(
				String loginId, int status, String state,
				boolean idamUserCreated,
				OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().
			findByLoginIdStatusStateAndIdamUserCreated_First(
				loginId, status, state, idamUserCreated, orderByComparator);
	}

	/**
	 * Returns the first registration request in the ordered set where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static RegistrationRequest
		fetchByLoginIdStatusStateAndIdamUserCreated_First(
			String loginId, int status, String state, boolean idamUserCreated,
			OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().
			fetchByLoginIdStatusStateAndIdamUserCreated_First(
				loginId, status, state, idamUserCreated, orderByComparator);
	}

	/**
	 * Returns the last registration request in the ordered set where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public static RegistrationRequest
			findByLoginIdStatusStateAndIdamUserCreated_Last(
				String loginId, int status, String state,
				boolean idamUserCreated,
				OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByLoginIdStatusStateAndIdamUserCreated_Last(
			loginId, status, state, idamUserCreated, orderByComparator);
	}

	/**
	 * Returns the last registration request in the ordered set where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public static RegistrationRequest
		fetchByLoginIdStatusStateAndIdamUserCreated_Last(
			String loginId, int status, String state, boolean idamUserCreated,
			OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().
			fetchByLoginIdStatusStateAndIdamUserCreated_Last(
				loginId, status, state, idamUserCreated, orderByComparator);
	}

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	public static RegistrationRequest[]
			findByLoginIdStatusStateAndIdamUserCreated_PrevAndNext(
				long registrationRequestId, String loginId, int status,
				String state, boolean idamUserCreated,
				OrderByComparator<RegistrationRequest> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().
			findByLoginIdStatusStateAndIdamUserCreated_PrevAndNext(
				registrationRequestId, loginId, status, state, idamUserCreated,
				orderByComparator);
	}

	/**
	 * Removes all the registration requests where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63; from the database.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 */
	public static void removeByLoginIdStatusStateAndIdamUserCreated(
		String loginId, int status, String state, boolean idamUserCreated) {

		getPersistence().removeByLoginIdStatusStateAndIdamUserCreated(
			loginId, status, state, idamUserCreated);
	}

	/**
	 * Returns the number of registration requests where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @return the number of matching registration requests
	 */
	public static int countByLoginIdStatusStateAndIdamUserCreated(
		String loginId, int status, String state, boolean idamUserCreated) {

		return getPersistence().countByLoginIdStatusStateAndIdamUserCreated(
			loginId, status, state, idamUserCreated);
	}

	/**
	 * Caches the registration request in the entity cache if it is enabled.
	 *
	 * @param registrationRequest the registration request
	 */
	public static void cacheResult(RegistrationRequest registrationRequest) {
		getPersistence().cacheResult(registrationRequest);
	}

	/**
	 * Caches the registration requests in the entity cache if it is enabled.
	 *
	 * @param registrationRequests the registration requests
	 */
	public static void cacheResult(
		List<RegistrationRequest> registrationRequests) {

		getPersistence().cacheResult(registrationRequests);
	}

	/**
	 * Creates a new registration request with the primary key. Does not add the registration request to the database.
	 *
	 * @param registrationRequestId the primary key for the new registration request
	 * @return the new registration request
	 */
	public static RegistrationRequest create(long registrationRequestId) {
		return getPersistence().create(registrationRequestId);
	}

	/**
	 * Removes the registration request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param registrationRequestId the primary key of the registration request
	 * @return the registration request that was removed
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	public static RegistrationRequest remove(long registrationRequestId)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().remove(registrationRequestId);
	}

	public static RegistrationRequest updateImpl(
		RegistrationRequest registrationRequest) {

		return getPersistence().updateImpl(registrationRequest);
	}

	/**
	 * Returns the registration request with the primary key or throws a <code>NoSuchRegistrationRequestException</code> if it could not be found.
	 *
	 * @param registrationRequestId the primary key of the registration request
	 * @return the registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	public static RegistrationRequest findByPrimaryKey(
			long registrationRequestId)
		throws com.adjecti.pis.exception.NoSuchRegistrationRequestException {

		return getPersistence().findByPrimaryKey(registrationRequestId);
	}

	/**
	 * Returns the registration request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param registrationRequestId the primary key of the registration request
	 * @return the registration request, or <code>null</code> if a registration request with the primary key could not be found
	 */
	public static RegistrationRequest fetchByPrimaryKey(
		long registrationRequestId) {

		return getPersistence().fetchByPrimaryKey(registrationRequestId);
	}

	/**
	 * Returns all the registration requests.
	 *
	 * @return the registration requests
	 */
	public static List<RegistrationRequest> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the registration requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @return the range of registration requests
	 */
	public static List<RegistrationRequest> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the registration requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of registration requests
	 */
	public static List<RegistrationRequest> findAll(
		int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the registration requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RegistrationRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of registration requests
	 * @param end the upper bound of the range of registration requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of registration requests
	 */
	public static List<RegistrationRequest> findAll(
		int start, int end,
		OrderByComparator<RegistrationRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the registration requests from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of registration requests.
	 *
	 * @return the number of registration requests
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RegistrationRequestPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<RegistrationRequestPersistence, RegistrationRequestPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			RegistrationRequestPersistence.class);

		ServiceTracker
			<RegistrationRequestPersistence, RegistrationRequestPersistence>
				serviceTracker =
					new ServiceTracker
						<RegistrationRequestPersistence,
						 RegistrationRequestPersistence>(
							 bundle.getBundleContext(),
							 RegistrationRequestPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}