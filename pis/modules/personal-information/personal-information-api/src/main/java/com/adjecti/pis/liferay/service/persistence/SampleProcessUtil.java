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

import com.adjecti.pis.liferay.model.SampleProcess;

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
 * The persistence utility for the sample process service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.SampleProcessPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SampleProcessPersistence
 * @generated
 */
public class SampleProcessUtil {

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
	public static void clearCache(SampleProcess sampleProcess) {
		getPersistence().clearCache(sampleProcess);
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
	public static Map<Serializable, SampleProcess> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SampleProcess> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SampleProcess> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SampleProcess> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SampleProcess> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SampleProcess update(SampleProcess sampleProcess) {
		return getPersistence().update(sampleProcess);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SampleProcess update(
		SampleProcess sampleProcess, ServiceContext serviceContext) {

		return getPersistence().update(sampleProcess, serviceContext);
	}

	/**
	 * Returns all the sample processes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching sample processes
	 */
	public static List<SampleProcess> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the sample processes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sample processes
	 * @param end the upper bound of the range of sample processes (not inclusive)
	 * @return the range of matching sample processes
	 */
	public static List<SampleProcess> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the sample processes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sample processes
	 * @param end the upper bound of the range of sample processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample processes
	 */
	public static List<SampleProcess> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SampleProcess> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sample processes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sample processes
	 * @param end the upper bound of the range of sample processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sample processes
	 */
	public static List<SampleProcess> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SampleProcess> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sample process in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample process
	 * @throws NoSuchSampleProcessException if a matching sample process could not be found
	 */
	public static SampleProcess findByUuid_First(
			String uuid, OrderByComparator<SampleProcess> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchSampleProcessException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first sample process in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample process, or <code>null</code> if a matching sample process could not be found
	 */
	public static SampleProcess fetchByUuid_First(
		String uuid, OrderByComparator<SampleProcess> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last sample process in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample process
	 * @throws NoSuchSampleProcessException if a matching sample process could not be found
	 */
	public static SampleProcess findByUuid_Last(
			String uuid, OrderByComparator<SampleProcess> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchSampleProcessException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last sample process in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample process, or <code>null</code> if a matching sample process could not be found
	 */
	public static SampleProcess fetchByUuid_Last(
		String uuid, OrderByComparator<SampleProcess> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the sample processes before and after the current sample process in the ordered set where uuid = &#63;.
	 *
	 * @param sampleProcessId the primary key of the current sample process
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample process
	 * @throws NoSuchSampleProcessException if a sample process with the primary key could not be found
	 */
	public static SampleProcess[] findByUuid_PrevAndNext(
			long sampleProcessId, String uuid,
			OrderByComparator<SampleProcess> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchSampleProcessException {

		return getPersistence().findByUuid_PrevAndNext(
			sampleProcessId, uuid, orderByComparator);
	}

	/**
	 * Removes all the sample processes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of sample processes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching sample processes
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the sample process where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSampleProcessException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sample process
	 * @throws NoSuchSampleProcessException if a matching sample process could not be found
	 */
	public static SampleProcess findByUUID_G(String uuid, long groupId)
		throws com.adjecti.pis.liferay.exception.NoSuchSampleProcessException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the sample process where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sample process, or <code>null</code> if a matching sample process could not be found
	 */
	public static SampleProcess fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the sample process where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sample process, or <code>null</code> if a matching sample process could not be found
	 */
	public static SampleProcess fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the sample process where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the sample process that was removed
	 */
	public static SampleProcess removeByUUID_G(String uuid, long groupId)
		throws com.adjecti.pis.liferay.exception.NoSuchSampleProcessException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of sample processes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching sample processes
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the sample processes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching sample processes
	 */
	public static List<SampleProcess> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the sample processes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of sample processes
	 * @param end the upper bound of the range of sample processes (not inclusive)
	 * @return the range of matching sample processes
	 */
	public static List<SampleProcess> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the sample processes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of sample processes
	 * @param end the upper bound of the range of sample processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample processes
	 */
	public static List<SampleProcess> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SampleProcess> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sample processes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of sample processes
	 * @param end the upper bound of the range of sample processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sample processes
	 */
	public static List<SampleProcess> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SampleProcess> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sample process in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample process
	 * @throws NoSuchSampleProcessException if a matching sample process could not be found
	 */
	public static SampleProcess findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<SampleProcess> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchSampleProcessException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first sample process in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample process, or <code>null</code> if a matching sample process could not be found
	 */
	public static SampleProcess fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<SampleProcess> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last sample process in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample process
	 * @throws NoSuchSampleProcessException if a matching sample process could not be found
	 */
	public static SampleProcess findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<SampleProcess> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchSampleProcessException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last sample process in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample process, or <code>null</code> if a matching sample process could not be found
	 */
	public static SampleProcess fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<SampleProcess> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the sample processes before and after the current sample process in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param sampleProcessId the primary key of the current sample process
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample process
	 * @throws NoSuchSampleProcessException if a sample process with the primary key could not be found
	 */
	public static SampleProcess[] findByUuid_C_PrevAndNext(
			long sampleProcessId, String uuid, long companyId,
			OrderByComparator<SampleProcess> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchSampleProcessException {

		return getPersistence().findByUuid_C_PrevAndNext(
			sampleProcessId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the sample processes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of sample processes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching sample processes
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the sample processes where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @return the matching sample processes
	 */
	public static List<SampleProcess> findByReviewerUserId(
		long reviewerUserId) {

		return getPersistence().findByReviewerUserId(reviewerUserId);
	}

	/**
	 * Returns a range of all the sample processes where reviewerUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessModelImpl</code>.
	 * </p>
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param start the lower bound of the range of sample processes
	 * @param end the upper bound of the range of sample processes (not inclusive)
	 * @return the range of matching sample processes
	 */
	public static List<SampleProcess> findByReviewerUserId(
		long reviewerUserId, int start, int end) {

		return getPersistence().findByReviewerUserId(
			reviewerUserId, start, end);
	}

	/**
	 * Returns an ordered range of all the sample processes where reviewerUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessModelImpl</code>.
	 * </p>
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param start the lower bound of the range of sample processes
	 * @param end the upper bound of the range of sample processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample processes
	 */
	public static List<SampleProcess> findByReviewerUserId(
		long reviewerUserId, int start, int end,
		OrderByComparator<SampleProcess> orderByComparator) {

		return getPersistence().findByReviewerUserId(
			reviewerUserId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sample processes where reviewerUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessModelImpl</code>.
	 * </p>
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param start the lower bound of the range of sample processes
	 * @param end the upper bound of the range of sample processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sample processes
	 */
	public static List<SampleProcess> findByReviewerUserId(
		long reviewerUserId, int start, int end,
		OrderByComparator<SampleProcess> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByReviewerUserId(
			reviewerUserId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sample process in the ordered set where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample process
	 * @throws NoSuchSampleProcessException if a matching sample process could not be found
	 */
	public static SampleProcess findByReviewerUserId_First(
			long reviewerUserId,
			OrderByComparator<SampleProcess> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchSampleProcessException {

		return getPersistence().findByReviewerUserId_First(
			reviewerUserId, orderByComparator);
	}

	/**
	 * Returns the first sample process in the ordered set where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample process, or <code>null</code> if a matching sample process could not be found
	 */
	public static SampleProcess fetchByReviewerUserId_First(
		long reviewerUserId,
		OrderByComparator<SampleProcess> orderByComparator) {

		return getPersistence().fetchByReviewerUserId_First(
			reviewerUserId, orderByComparator);
	}

	/**
	 * Returns the last sample process in the ordered set where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample process
	 * @throws NoSuchSampleProcessException if a matching sample process could not be found
	 */
	public static SampleProcess findByReviewerUserId_Last(
			long reviewerUserId,
			OrderByComparator<SampleProcess> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchSampleProcessException {

		return getPersistence().findByReviewerUserId_Last(
			reviewerUserId, orderByComparator);
	}

	/**
	 * Returns the last sample process in the ordered set where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample process, or <code>null</code> if a matching sample process could not be found
	 */
	public static SampleProcess fetchByReviewerUserId_Last(
		long reviewerUserId,
		OrderByComparator<SampleProcess> orderByComparator) {

		return getPersistence().fetchByReviewerUserId_Last(
			reviewerUserId, orderByComparator);
	}

	/**
	 * Returns the sample processes before and after the current sample process in the ordered set where reviewerUserId = &#63;.
	 *
	 * @param sampleProcessId the primary key of the current sample process
	 * @param reviewerUserId the reviewer user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample process
	 * @throws NoSuchSampleProcessException if a sample process with the primary key could not be found
	 */
	public static SampleProcess[] findByReviewerUserId_PrevAndNext(
			long sampleProcessId, long reviewerUserId,
			OrderByComparator<SampleProcess> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchSampleProcessException {

		return getPersistence().findByReviewerUserId_PrevAndNext(
			sampleProcessId, reviewerUserId, orderByComparator);
	}

	/**
	 * Removes all the sample processes where reviewerUserId = &#63; from the database.
	 *
	 * @param reviewerUserId the reviewer user ID
	 */
	public static void removeByReviewerUserId(long reviewerUserId) {
		getPersistence().removeByReviewerUserId(reviewerUserId);
	}

	/**
	 * Returns the number of sample processes where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @return the number of matching sample processes
	 */
	public static int countByReviewerUserId(long reviewerUserId) {
		return getPersistence().countByReviewerUserId(reviewerUserId);
	}

	/**
	 * Returns all the sample processes where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @return the matching sample processes
	 */
	public static List<SampleProcess> findByApproverUserId(
		long approverUserId) {

		return getPersistence().findByApproverUserId(approverUserId);
	}

	/**
	 * Returns a range of all the sample processes where approverUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessModelImpl</code>.
	 * </p>
	 *
	 * @param approverUserId the approver user ID
	 * @param start the lower bound of the range of sample processes
	 * @param end the upper bound of the range of sample processes (not inclusive)
	 * @return the range of matching sample processes
	 */
	public static List<SampleProcess> findByApproverUserId(
		long approverUserId, int start, int end) {

		return getPersistence().findByApproverUserId(
			approverUserId, start, end);
	}

	/**
	 * Returns an ordered range of all the sample processes where approverUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessModelImpl</code>.
	 * </p>
	 *
	 * @param approverUserId the approver user ID
	 * @param start the lower bound of the range of sample processes
	 * @param end the upper bound of the range of sample processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample processes
	 */
	public static List<SampleProcess> findByApproverUserId(
		long approverUserId, int start, int end,
		OrderByComparator<SampleProcess> orderByComparator) {

		return getPersistence().findByApproverUserId(
			approverUserId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sample processes where approverUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessModelImpl</code>.
	 * </p>
	 *
	 * @param approverUserId the approver user ID
	 * @param start the lower bound of the range of sample processes
	 * @param end the upper bound of the range of sample processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sample processes
	 */
	public static List<SampleProcess> findByApproverUserId(
		long approverUserId, int start, int end,
		OrderByComparator<SampleProcess> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByApproverUserId(
			approverUserId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sample process in the ordered set where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample process
	 * @throws NoSuchSampleProcessException if a matching sample process could not be found
	 */
	public static SampleProcess findByApproverUserId_First(
			long approverUserId,
			OrderByComparator<SampleProcess> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchSampleProcessException {

		return getPersistence().findByApproverUserId_First(
			approverUserId, orderByComparator);
	}

	/**
	 * Returns the first sample process in the ordered set where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample process, or <code>null</code> if a matching sample process could not be found
	 */
	public static SampleProcess fetchByApproverUserId_First(
		long approverUserId,
		OrderByComparator<SampleProcess> orderByComparator) {

		return getPersistence().fetchByApproverUserId_First(
			approverUserId, orderByComparator);
	}

	/**
	 * Returns the last sample process in the ordered set where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample process
	 * @throws NoSuchSampleProcessException if a matching sample process could not be found
	 */
	public static SampleProcess findByApproverUserId_Last(
			long approverUserId,
			OrderByComparator<SampleProcess> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchSampleProcessException {

		return getPersistence().findByApproverUserId_Last(
			approverUserId, orderByComparator);
	}

	/**
	 * Returns the last sample process in the ordered set where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample process, or <code>null</code> if a matching sample process could not be found
	 */
	public static SampleProcess fetchByApproverUserId_Last(
		long approverUserId,
		OrderByComparator<SampleProcess> orderByComparator) {

		return getPersistence().fetchByApproverUserId_Last(
			approverUserId, orderByComparator);
	}

	/**
	 * Returns the sample processes before and after the current sample process in the ordered set where approverUserId = &#63;.
	 *
	 * @param sampleProcessId the primary key of the current sample process
	 * @param approverUserId the approver user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample process
	 * @throws NoSuchSampleProcessException if a sample process with the primary key could not be found
	 */
	public static SampleProcess[] findByApproverUserId_PrevAndNext(
			long sampleProcessId, long approverUserId,
			OrderByComparator<SampleProcess> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchSampleProcessException {

		return getPersistence().findByApproverUserId_PrevAndNext(
			sampleProcessId, approverUserId, orderByComparator);
	}

	/**
	 * Removes all the sample processes where approverUserId = &#63; from the database.
	 *
	 * @param approverUserId the approver user ID
	 */
	public static void removeByApproverUserId(long approverUserId) {
		getPersistence().removeByApproverUserId(approverUserId);
	}

	/**
	 * Returns the number of sample processes where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @return the number of matching sample processes
	 */
	public static int countByApproverUserId(long approverUserId) {
		return getPersistence().countByApproverUserId(approverUserId);
	}

	/**
	 * Caches the sample process in the entity cache if it is enabled.
	 *
	 * @param sampleProcess the sample process
	 */
	public static void cacheResult(SampleProcess sampleProcess) {
		getPersistence().cacheResult(sampleProcess);
	}

	/**
	 * Caches the sample processes in the entity cache if it is enabled.
	 *
	 * @param sampleProcesses the sample processes
	 */
	public static void cacheResult(List<SampleProcess> sampleProcesses) {
		getPersistence().cacheResult(sampleProcesses);
	}

	/**
	 * Creates a new sample process with the primary key. Does not add the sample process to the database.
	 *
	 * @param sampleProcessId the primary key for the new sample process
	 * @return the new sample process
	 */
	public static SampleProcess create(long sampleProcessId) {
		return getPersistence().create(sampleProcessId);
	}

	/**
	 * Removes the sample process with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sampleProcessId the primary key of the sample process
	 * @return the sample process that was removed
	 * @throws NoSuchSampleProcessException if a sample process with the primary key could not be found
	 */
	public static SampleProcess remove(long sampleProcessId)
		throws com.adjecti.pis.liferay.exception.NoSuchSampleProcessException {

		return getPersistence().remove(sampleProcessId);
	}

	public static SampleProcess updateImpl(SampleProcess sampleProcess) {
		return getPersistence().updateImpl(sampleProcess);
	}

	/**
	 * Returns the sample process with the primary key or throws a <code>NoSuchSampleProcessException</code> if it could not be found.
	 *
	 * @param sampleProcessId the primary key of the sample process
	 * @return the sample process
	 * @throws NoSuchSampleProcessException if a sample process with the primary key could not be found
	 */
	public static SampleProcess findByPrimaryKey(long sampleProcessId)
		throws com.adjecti.pis.liferay.exception.NoSuchSampleProcessException {

		return getPersistence().findByPrimaryKey(sampleProcessId);
	}

	/**
	 * Returns the sample process with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sampleProcessId the primary key of the sample process
	 * @return the sample process, or <code>null</code> if a sample process with the primary key could not be found
	 */
	public static SampleProcess fetchByPrimaryKey(long sampleProcessId) {
		return getPersistence().fetchByPrimaryKey(sampleProcessId);
	}

	/**
	 * Returns all the sample processes.
	 *
	 * @return the sample processes
	 */
	public static List<SampleProcess> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the sample processes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sample processes
	 * @param end the upper bound of the range of sample processes (not inclusive)
	 * @return the range of sample processes
	 */
	public static List<SampleProcess> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the sample processes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sample processes
	 * @param end the upper bound of the range of sample processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sample processes
	 */
	public static List<SampleProcess> findAll(
		int start, int end,
		OrderByComparator<SampleProcess> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sample processes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SampleProcessModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sample processes
	 * @param end the upper bound of the range of sample processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sample processes
	 */
	public static List<SampleProcess> findAll(
		int start, int end, OrderByComparator<SampleProcess> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the sample processes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of sample processes.
	 *
	 * @return the number of sample processes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SampleProcessPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<SampleProcessPersistence, SampleProcessPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SampleProcessPersistence.class);

		ServiceTracker<SampleProcessPersistence, SampleProcessPersistence>
			serviceTracker =
				new ServiceTracker
					<SampleProcessPersistence, SampleProcessPersistence>(
						bundle.getBundleContext(),
						SampleProcessPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}