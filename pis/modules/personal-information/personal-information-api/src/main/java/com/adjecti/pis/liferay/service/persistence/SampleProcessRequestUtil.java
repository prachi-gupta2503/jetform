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

import com.adjecti.pis.liferay.model.SampleProcessRequest;

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
 * The persistence utility for the sample process request service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.SampleProcessRequestPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SampleProcessRequestPersistence
 * @generated
 */
public class SampleProcessRequestUtil {

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
	public static void clearCache(SampleProcessRequest sampleProcessRequest) {
		getPersistence().clearCache(sampleProcessRequest);
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
	public static Map<Serializable, SampleProcessRequest> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SampleProcessRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SampleProcessRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SampleProcessRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SampleProcessRequest> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SampleProcessRequest update(
		SampleProcessRequest sampleProcessRequest) {

		return getPersistence().update(sampleProcessRequest);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SampleProcessRequest update(
		SampleProcessRequest sampleProcessRequest,
		ServiceContext serviceContext) {

		return getPersistence().update(sampleProcessRequest, serviceContext);
	}

	/**
	 * Returns all the sample process requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching sample process requests
	 */
	public static List<SampleProcessRequest> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the sample process requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sample process requests
	 * @param end the upper bound of the range of sample process requests (not inclusive)
	 * @return the range of matching sample process requests
	 */
	public static List<SampleProcessRequest> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the sample process requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sample process requests
	 * @param end the upper bound of the range of sample process requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample process requests
	 */
	public static List<SampleProcessRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SampleProcessRequest> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sample process requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sample process requests
	 * @param end the upper bound of the range of sample process requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sample process requests
	 */
	public static List<SampleProcessRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SampleProcessRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sample process request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample process request
	 * @throws NoSuchSampleProcessRequestException if a matching sample process request could not be found
	 */
	public static SampleProcessRequest findByUuid_First(
			String uuid,
			OrderByComparator<SampleProcessRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSampleProcessRequestException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first sample process request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample process request, or <code>null</code> if a matching sample process request could not be found
	 */
	public static SampleProcessRequest fetchByUuid_First(
		String uuid,
		OrderByComparator<SampleProcessRequest> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last sample process request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample process request
	 * @throws NoSuchSampleProcessRequestException if a matching sample process request could not be found
	 */
	public static SampleProcessRequest findByUuid_Last(
			String uuid,
			OrderByComparator<SampleProcessRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSampleProcessRequestException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last sample process request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample process request, or <code>null</code> if a matching sample process request could not be found
	 */
	public static SampleProcessRequest fetchByUuid_Last(
		String uuid,
		OrderByComparator<SampleProcessRequest> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the sample process requests before and after the current sample process request in the ordered set where uuid = &#63;.
	 *
	 * @param sampleProcessRequestId the primary key of the current sample process request
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample process request
	 * @throws NoSuchSampleProcessRequestException if a sample process request with the primary key could not be found
	 */
	public static SampleProcessRequest[] findByUuid_PrevAndNext(
			long sampleProcessRequestId, String uuid,
			OrderByComparator<SampleProcessRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSampleProcessRequestException {

		return getPersistence().findByUuid_PrevAndNext(
			sampleProcessRequestId, uuid, orderByComparator);
	}

	/**
	 * Removes all the sample process requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of sample process requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching sample process requests
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the sample process request where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSampleProcessRequestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sample process request
	 * @throws NoSuchSampleProcessRequestException if a matching sample process request could not be found
	 */
	public static SampleProcessRequest findByUUID_G(String uuid, long groupId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSampleProcessRequestException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the sample process request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sample process request, or <code>null</code> if a matching sample process request could not be found
	 */
	public static SampleProcessRequest fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the sample process request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sample process request, or <code>null</code> if a matching sample process request could not be found
	 */
	public static SampleProcessRequest fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the sample process request where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the sample process request that was removed
	 */
	public static SampleProcessRequest removeByUUID_G(String uuid, long groupId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSampleProcessRequestException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of sample process requests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching sample process requests
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the sample process requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching sample process requests
	 */
	public static List<SampleProcessRequest> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the sample process requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of sample process requests
	 * @param end the upper bound of the range of sample process requests (not inclusive)
	 * @return the range of matching sample process requests
	 */
	public static List<SampleProcessRequest> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the sample process requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of sample process requests
	 * @param end the upper bound of the range of sample process requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample process requests
	 */
	public static List<SampleProcessRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SampleProcessRequest> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sample process requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of sample process requests
	 * @param end the upper bound of the range of sample process requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sample process requests
	 */
	public static List<SampleProcessRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SampleProcessRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sample process request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample process request
	 * @throws NoSuchSampleProcessRequestException if a matching sample process request could not be found
	 */
	public static SampleProcessRequest findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<SampleProcessRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSampleProcessRequestException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first sample process request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample process request, or <code>null</code> if a matching sample process request could not be found
	 */
	public static SampleProcessRequest fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<SampleProcessRequest> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last sample process request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample process request
	 * @throws NoSuchSampleProcessRequestException if a matching sample process request could not be found
	 */
	public static SampleProcessRequest findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<SampleProcessRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSampleProcessRequestException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last sample process request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample process request, or <code>null</code> if a matching sample process request could not be found
	 */
	public static SampleProcessRequest fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<SampleProcessRequest> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the sample process requests before and after the current sample process request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param sampleProcessRequestId the primary key of the current sample process request
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample process request
	 * @throws NoSuchSampleProcessRequestException if a sample process request with the primary key could not be found
	 */
	public static SampleProcessRequest[] findByUuid_C_PrevAndNext(
			long sampleProcessRequestId, String uuid, long companyId,
			OrderByComparator<SampleProcessRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSampleProcessRequestException {

		return getPersistence().findByUuid_C_PrevAndNext(
			sampleProcessRequestId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the sample process requests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of sample process requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching sample process requests
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the sample process requests where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @return the matching sample process requests
	 */
	public static List<SampleProcessRequest> findByReviewerUserId(
		long reviewerUserId) {

		return getPersistence().findByReviewerUserId(reviewerUserId);
	}

	/**
	 * Returns a range of all the sample process requests where reviewerUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param start the lower bound of the range of sample process requests
	 * @param end the upper bound of the range of sample process requests (not inclusive)
	 * @return the range of matching sample process requests
	 */
	public static List<SampleProcessRequest> findByReviewerUserId(
		long reviewerUserId, int start, int end) {

		return getPersistence().findByReviewerUserId(
			reviewerUserId, start, end);
	}

	/**
	 * Returns an ordered range of all the sample process requests where reviewerUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param start the lower bound of the range of sample process requests
	 * @param end the upper bound of the range of sample process requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample process requests
	 */
	public static List<SampleProcessRequest> findByReviewerUserId(
		long reviewerUserId, int start, int end,
		OrderByComparator<SampleProcessRequest> orderByComparator) {

		return getPersistence().findByReviewerUserId(
			reviewerUserId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sample process requests where reviewerUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param start the lower bound of the range of sample process requests
	 * @param end the upper bound of the range of sample process requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sample process requests
	 */
	public static List<SampleProcessRequest> findByReviewerUserId(
		long reviewerUserId, int start, int end,
		OrderByComparator<SampleProcessRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByReviewerUserId(
			reviewerUserId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sample process request in the ordered set where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample process request
	 * @throws NoSuchSampleProcessRequestException if a matching sample process request could not be found
	 */
	public static SampleProcessRequest findByReviewerUserId_First(
			long reviewerUserId,
			OrderByComparator<SampleProcessRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSampleProcessRequestException {

		return getPersistence().findByReviewerUserId_First(
			reviewerUserId, orderByComparator);
	}

	/**
	 * Returns the first sample process request in the ordered set where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample process request, or <code>null</code> if a matching sample process request could not be found
	 */
	public static SampleProcessRequest fetchByReviewerUserId_First(
		long reviewerUserId,
		OrderByComparator<SampleProcessRequest> orderByComparator) {

		return getPersistence().fetchByReviewerUserId_First(
			reviewerUserId, orderByComparator);
	}

	/**
	 * Returns the last sample process request in the ordered set where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample process request
	 * @throws NoSuchSampleProcessRequestException if a matching sample process request could not be found
	 */
	public static SampleProcessRequest findByReviewerUserId_Last(
			long reviewerUserId,
			OrderByComparator<SampleProcessRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSampleProcessRequestException {

		return getPersistence().findByReviewerUserId_Last(
			reviewerUserId, orderByComparator);
	}

	/**
	 * Returns the last sample process request in the ordered set where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample process request, or <code>null</code> if a matching sample process request could not be found
	 */
	public static SampleProcessRequest fetchByReviewerUserId_Last(
		long reviewerUserId,
		OrderByComparator<SampleProcessRequest> orderByComparator) {

		return getPersistence().fetchByReviewerUserId_Last(
			reviewerUserId, orderByComparator);
	}

	/**
	 * Returns the sample process requests before and after the current sample process request in the ordered set where reviewerUserId = &#63;.
	 *
	 * @param sampleProcessRequestId the primary key of the current sample process request
	 * @param reviewerUserId the reviewer user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample process request
	 * @throws NoSuchSampleProcessRequestException if a sample process request with the primary key could not be found
	 */
	public static SampleProcessRequest[] findByReviewerUserId_PrevAndNext(
			long sampleProcessRequestId, long reviewerUserId,
			OrderByComparator<SampleProcessRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSampleProcessRequestException {

		return getPersistence().findByReviewerUserId_PrevAndNext(
			sampleProcessRequestId, reviewerUserId, orderByComparator);
	}

	/**
	 * Removes all the sample process requests where reviewerUserId = &#63; from the database.
	 *
	 * @param reviewerUserId the reviewer user ID
	 */
	public static void removeByReviewerUserId(long reviewerUserId) {
		getPersistence().removeByReviewerUserId(reviewerUserId);
	}

	/**
	 * Returns the number of sample process requests where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @return the number of matching sample process requests
	 */
	public static int countByReviewerUserId(long reviewerUserId) {
		return getPersistence().countByReviewerUserId(reviewerUserId);
	}

	/**
	 * Returns all the sample process requests where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @return the matching sample process requests
	 */
	public static List<SampleProcessRequest> findByApproverUserId(
		long approverUserId) {

		return getPersistence().findByApproverUserId(approverUserId);
	}

	/**
	 * Returns a range of all the sample process requests where approverUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param approverUserId the approver user ID
	 * @param start the lower bound of the range of sample process requests
	 * @param end the upper bound of the range of sample process requests (not inclusive)
	 * @return the range of matching sample process requests
	 */
	public static List<SampleProcessRequest> findByApproverUserId(
		long approverUserId, int start, int end) {

		return getPersistence().findByApproverUserId(
			approverUserId, start, end);
	}

	/**
	 * Returns an ordered range of all the sample process requests where approverUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param approverUserId the approver user ID
	 * @param start the lower bound of the range of sample process requests
	 * @param end the upper bound of the range of sample process requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample process requests
	 */
	public static List<SampleProcessRequest> findByApproverUserId(
		long approverUserId, int start, int end,
		OrderByComparator<SampleProcessRequest> orderByComparator) {

		return getPersistence().findByApproverUserId(
			approverUserId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sample process requests where approverUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param approverUserId the approver user ID
	 * @param start the lower bound of the range of sample process requests
	 * @param end the upper bound of the range of sample process requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sample process requests
	 */
	public static List<SampleProcessRequest> findByApproverUserId(
		long approverUserId, int start, int end,
		OrderByComparator<SampleProcessRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByApproverUserId(
			approverUserId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sample process request in the ordered set where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample process request
	 * @throws NoSuchSampleProcessRequestException if a matching sample process request could not be found
	 */
	public static SampleProcessRequest findByApproverUserId_First(
			long approverUserId,
			OrderByComparator<SampleProcessRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSampleProcessRequestException {

		return getPersistence().findByApproverUserId_First(
			approverUserId, orderByComparator);
	}

	/**
	 * Returns the first sample process request in the ordered set where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample process request, or <code>null</code> if a matching sample process request could not be found
	 */
	public static SampleProcessRequest fetchByApproverUserId_First(
		long approverUserId,
		OrderByComparator<SampleProcessRequest> orderByComparator) {

		return getPersistence().fetchByApproverUserId_First(
			approverUserId, orderByComparator);
	}

	/**
	 * Returns the last sample process request in the ordered set where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample process request
	 * @throws NoSuchSampleProcessRequestException if a matching sample process request could not be found
	 */
	public static SampleProcessRequest findByApproverUserId_Last(
			long approverUserId,
			OrderByComparator<SampleProcessRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSampleProcessRequestException {

		return getPersistence().findByApproverUserId_Last(
			approverUserId, orderByComparator);
	}

	/**
	 * Returns the last sample process request in the ordered set where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample process request, or <code>null</code> if a matching sample process request could not be found
	 */
	public static SampleProcessRequest fetchByApproverUserId_Last(
		long approverUserId,
		OrderByComparator<SampleProcessRequest> orderByComparator) {

		return getPersistence().fetchByApproverUserId_Last(
			approverUserId, orderByComparator);
	}

	/**
	 * Returns the sample process requests before and after the current sample process request in the ordered set where approverUserId = &#63;.
	 *
	 * @param sampleProcessRequestId the primary key of the current sample process request
	 * @param approverUserId the approver user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample process request
	 * @throws NoSuchSampleProcessRequestException if a sample process request with the primary key could not be found
	 */
	public static SampleProcessRequest[] findByApproverUserId_PrevAndNext(
			long sampleProcessRequestId, long approverUserId,
			OrderByComparator<SampleProcessRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSampleProcessRequestException {

		return getPersistence().findByApproverUserId_PrevAndNext(
			sampleProcessRequestId, approverUserId, orderByComparator);
	}

	/**
	 * Removes all the sample process requests where approverUserId = &#63; from the database.
	 *
	 * @param approverUserId the approver user ID
	 */
	public static void removeByApproverUserId(long approverUserId) {
		getPersistence().removeByApproverUserId(approverUserId);
	}

	/**
	 * Returns the number of sample process requests where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @return the number of matching sample process requests
	 */
	public static int countByApproverUserId(long approverUserId) {
		return getPersistence().countByApproverUserId(approverUserId);
	}

	/**
	 * Caches the sample process request in the entity cache if it is enabled.
	 *
	 * @param sampleProcessRequest the sample process request
	 */
	public static void cacheResult(SampleProcessRequest sampleProcessRequest) {
		getPersistence().cacheResult(sampleProcessRequest);
	}

	/**
	 * Caches the sample process requests in the entity cache if it is enabled.
	 *
	 * @param sampleProcessRequests the sample process requests
	 */
	public static void cacheResult(
		List<SampleProcessRequest> sampleProcessRequests) {

		getPersistence().cacheResult(sampleProcessRequests);
	}

	/**
	 * Creates a new sample process request with the primary key. Does not add the sample process request to the database.
	 *
	 * @param sampleProcessRequestId the primary key for the new sample process request
	 * @return the new sample process request
	 */
	public static SampleProcessRequest create(long sampleProcessRequestId) {
		return getPersistence().create(sampleProcessRequestId);
	}

	/**
	 * Removes the sample process request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sampleProcessRequestId the primary key of the sample process request
	 * @return the sample process request that was removed
	 * @throws NoSuchSampleProcessRequestException if a sample process request with the primary key could not be found
	 */
	public static SampleProcessRequest remove(long sampleProcessRequestId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSampleProcessRequestException {

		return getPersistence().remove(sampleProcessRequestId);
	}

	public static SampleProcessRequest updateImpl(
		SampleProcessRequest sampleProcessRequest) {

		return getPersistence().updateImpl(sampleProcessRequest);
	}

	/**
	 * Returns the sample process request with the primary key or throws a <code>NoSuchSampleProcessRequestException</code> if it could not be found.
	 *
	 * @param sampleProcessRequestId the primary key of the sample process request
	 * @return the sample process request
	 * @throws NoSuchSampleProcessRequestException if a sample process request with the primary key could not be found
	 */
	public static SampleProcessRequest findByPrimaryKey(
			long sampleProcessRequestId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSampleProcessRequestException {

		return getPersistence().findByPrimaryKey(sampleProcessRequestId);
	}

	/**
	 * Returns the sample process request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sampleProcessRequestId the primary key of the sample process request
	 * @return the sample process request, or <code>null</code> if a sample process request with the primary key could not be found
	 */
	public static SampleProcessRequest fetchByPrimaryKey(
		long sampleProcessRequestId) {

		return getPersistence().fetchByPrimaryKey(sampleProcessRequestId);
	}

	/**
	 * Returns all the sample process requests.
	 *
	 * @return the sample process requests
	 */
	public static List<SampleProcessRequest> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the sample process requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sample process requests
	 * @param end the upper bound of the range of sample process requests (not inclusive)
	 * @return the range of sample process requests
	 */
	public static List<SampleProcessRequest> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the sample process requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sample process requests
	 * @param end the upper bound of the range of sample process requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sample process requests
	 */
	public static List<SampleProcessRequest> findAll(
		int start, int end,
		OrderByComparator<SampleProcessRequest> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sample process requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sample process requests
	 * @param end the upper bound of the range of sample process requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sample process requests
	 */
	public static List<SampleProcessRequest> findAll(
		int start, int end,
		OrderByComparator<SampleProcessRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the sample process requests from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of sample process requests.
	 *
	 * @return the number of sample process requests
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SampleProcessRequestPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<SampleProcessRequestPersistence, SampleProcessRequestPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			SampleProcessRequestPersistence.class);

		ServiceTracker
			<SampleProcessRequestPersistence, SampleProcessRequestPersistence>
				serviceTracker =
					new ServiceTracker
						<SampleProcessRequestPersistence,
						 SampleProcessRequestPersistence>(
							 bundle.getBundleContext(),
							 SampleProcessRequestPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}