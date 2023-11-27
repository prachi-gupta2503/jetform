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

import com.adjecti.pis.liferay.model.JoiningProcess;

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
 * The persistence utility for the joining process service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.JoiningProcessPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JoiningProcessPersistence
 * @generated
 */
public class JoiningProcessUtil {

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
	public static void clearCache(JoiningProcess joiningProcess) {
		getPersistence().clearCache(joiningProcess);
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
	public static Map<Serializable, JoiningProcess> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<JoiningProcess> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<JoiningProcess> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<JoiningProcess> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<JoiningProcess> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static JoiningProcess update(JoiningProcess joiningProcess) {
		return getPersistence().update(joiningProcess);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static JoiningProcess update(
		JoiningProcess joiningProcess, ServiceContext serviceContext) {

		return getPersistence().update(joiningProcess, serviceContext);
	}

	/**
	 * Returns all the joining processes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching joining processes
	 */
	public static List<JoiningProcess> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the joining processes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of joining processes
	 * @param end the upper bound of the range of joining processes (not inclusive)
	 * @return the range of matching joining processes
	 */
	public static List<JoiningProcess> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the joining processes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of joining processes
	 * @param end the upper bound of the range of joining processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching joining processes
	 */
	public static List<JoiningProcess> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<JoiningProcess> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the joining processes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of joining processes
	 * @param end the upper bound of the range of joining processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching joining processes
	 */
	public static List<JoiningProcess> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<JoiningProcess> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first joining process in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching joining process
	 * @throws NoSuchJoiningProcessException if a matching joining process could not be found
	 */
	public static JoiningProcess findByUuid_First(
			String uuid, OrderByComparator<JoiningProcess> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchJoiningProcessException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first joining process in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching joining process, or <code>null</code> if a matching joining process could not be found
	 */
	public static JoiningProcess fetchByUuid_First(
		String uuid, OrderByComparator<JoiningProcess> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last joining process in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching joining process
	 * @throws NoSuchJoiningProcessException if a matching joining process could not be found
	 */
	public static JoiningProcess findByUuid_Last(
			String uuid, OrderByComparator<JoiningProcess> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchJoiningProcessException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last joining process in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching joining process, or <code>null</code> if a matching joining process could not be found
	 */
	public static JoiningProcess fetchByUuid_Last(
		String uuid, OrderByComparator<JoiningProcess> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the joining processes before and after the current joining process in the ordered set where uuid = &#63;.
	 *
	 * @param joiningProcessId the primary key of the current joining process
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next joining process
	 * @throws NoSuchJoiningProcessException if a joining process with the primary key could not be found
	 */
	public static JoiningProcess[] findByUuid_PrevAndNext(
			long joiningProcessId, String uuid,
			OrderByComparator<JoiningProcess> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchJoiningProcessException {

		return getPersistence().findByUuid_PrevAndNext(
			joiningProcessId, uuid, orderByComparator);
	}

	/**
	 * Removes all the joining processes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of joining processes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching joining processes
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the joining process where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchJoiningProcessException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching joining process
	 * @throws NoSuchJoiningProcessException if a matching joining process could not be found
	 */
	public static JoiningProcess findByUUID_G(String uuid, long groupId)
		throws com.adjecti.pis.liferay.exception.NoSuchJoiningProcessException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the joining process where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching joining process, or <code>null</code> if a matching joining process could not be found
	 */
	public static JoiningProcess fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the joining process where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching joining process, or <code>null</code> if a matching joining process could not be found
	 */
	public static JoiningProcess fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the joining process where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the joining process that was removed
	 */
	public static JoiningProcess removeByUUID_G(String uuid, long groupId)
		throws com.adjecti.pis.liferay.exception.NoSuchJoiningProcessException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of joining processes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching joining processes
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the joining processes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching joining processes
	 */
	public static List<JoiningProcess> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the joining processes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of joining processes
	 * @param end the upper bound of the range of joining processes (not inclusive)
	 * @return the range of matching joining processes
	 */
	public static List<JoiningProcess> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the joining processes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of joining processes
	 * @param end the upper bound of the range of joining processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching joining processes
	 */
	public static List<JoiningProcess> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<JoiningProcess> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the joining processes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of joining processes
	 * @param end the upper bound of the range of joining processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching joining processes
	 */
	public static List<JoiningProcess> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<JoiningProcess> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first joining process in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching joining process
	 * @throws NoSuchJoiningProcessException if a matching joining process could not be found
	 */
	public static JoiningProcess findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<JoiningProcess> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchJoiningProcessException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first joining process in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching joining process, or <code>null</code> if a matching joining process could not be found
	 */
	public static JoiningProcess fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<JoiningProcess> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last joining process in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching joining process
	 * @throws NoSuchJoiningProcessException if a matching joining process could not be found
	 */
	public static JoiningProcess findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<JoiningProcess> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchJoiningProcessException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last joining process in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching joining process, or <code>null</code> if a matching joining process could not be found
	 */
	public static JoiningProcess fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<JoiningProcess> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the joining processes before and after the current joining process in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param joiningProcessId the primary key of the current joining process
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next joining process
	 * @throws NoSuchJoiningProcessException if a joining process with the primary key could not be found
	 */
	public static JoiningProcess[] findByUuid_C_PrevAndNext(
			long joiningProcessId, String uuid, long companyId,
			OrderByComparator<JoiningProcess> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchJoiningProcessException {

		return getPersistence().findByUuid_C_PrevAndNext(
			joiningProcessId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the joining processes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of joining processes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching joining processes
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the joining processes where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @return the matching joining processes
	 */
	public static List<JoiningProcess> findByReviewerUserId(
		long reviewerUserId) {

		return getPersistence().findByReviewerUserId(reviewerUserId);
	}

	/**
	 * Returns a range of all the joining processes where reviewerUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessModelImpl</code>.
	 * </p>
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param start the lower bound of the range of joining processes
	 * @param end the upper bound of the range of joining processes (not inclusive)
	 * @return the range of matching joining processes
	 */
	public static List<JoiningProcess> findByReviewerUserId(
		long reviewerUserId, int start, int end) {

		return getPersistence().findByReviewerUserId(
			reviewerUserId, start, end);
	}

	/**
	 * Returns an ordered range of all the joining processes where reviewerUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessModelImpl</code>.
	 * </p>
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param start the lower bound of the range of joining processes
	 * @param end the upper bound of the range of joining processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching joining processes
	 */
	public static List<JoiningProcess> findByReviewerUserId(
		long reviewerUserId, int start, int end,
		OrderByComparator<JoiningProcess> orderByComparator) {

		return getPersistence().findByReviewerUserId(
			reviewerUserId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the joining processes where reviewerUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessModelImpl</code>.
	 * </p>
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param start the lower bound of the range of joining processes
	 * @param end the upper bound of the range of joining processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching joining processes
	 */
	public static List<JoiningProcess> findByReviewerUserId(
		long reviewerUserId, int start, int end,
		OrderByComparator<JoiningProcess> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByReviewerUserId(
			reviewerUserId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first joining process in the ordered set where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching joining process
	 * @throws NoSuchJoiningProcessException if a matching joining process could not be found
	 */
	public static JoiningProcess findByReviewerUserId_First(
			long reviewerUserId,
			OrderByComparator<JoiningProcess> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchJoiningProcessException {

		return getPersistence().findByReviewerUserId_First(
			reviewerUserId, orderByComparator);
	}

	/**
	 * Returns the first joining process in the ordered set where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching joining process, or <code>null</code> if a matching joining process could not be found
	 */
	public static JoiningProcess fetchByReviewerUserId_First(
		long reviewerUserId,
		OrderByComparator<JoiningProcess> orderByComparator) {

		return getPersistence().fetchByReviewerUserId_First(
			reviewerUserId, orderByComparator);
	}

	/**
	 * Returns the last joining process in the ordered set where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching joining process
	 * @throws NoSuchJoiningProcessException if a matching joining process could not be found
	 */
	public static JoiningProcess findByReviewerUserId_Last(
			long reviewerUserId,
			OrderByComparator<JoiningProcess> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchJoiningProcessException {

		return getPersistence().findByReviewerUserId_Last(
			reviewerUserId, orderByComparator);
	}

	/**
	 * Returns the last joining process in the ordered set where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching joining process, or <code>null</code> if a matching joining process could not be found
	 */
	public static JoiningProcess fetchByReviewerUserId_Last(
		long reviewerUserId,
		OrderByComparator<JoiningProcess> orderByComparator) {

		return getPersistence().fetchByReviewerUserId_Last(
			reviewerUserId, orderByComparator);
	}

	/**
	 * Returns the joining processes before and after the current joining process in the ordered set where reviewerUserId = &#63;.
	 *
	 * @param joiningProcessId the primary key of the current joining process
	 * @param reviewerUserId the reviewer user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next joining process
	 * @throws NoSuchJoiningProcessException if a joining process with the primary key could not be found
	 */
	public static JoiningProcess[] findByReviewerUserId_PrevAndNext(
			long joiningProcessId, long reviewerUserId,
			OrderByComparator<JoiningProcess> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchJoiningProcessException {

		return getPersistence().findByReviewerUserId_PrevAndNext(
			joiningProcessId, reviewerUserId, orderByComparator);
	}

	/**
	 * Removes all the joining processes where reviewerUserId = &#63; from the database.
	 *
	 * @param reviewerUserId the reviewer user ID
	 */
	public static void removeByReviewerUserId(long reviewerUserId) {
		getPersistence().removeByReviewerUserId(reviewerUserId);
	}

	/**
	 * Returns the number of joining processes where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @return the number of matching joining processes
	 */
	public static int countByReviewerUserId(long reviewerUserId) {
		return getPersistence().countByReviewerUserId(reviewerUserId);
	}

	/**
	 * Returns all the joining processes where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @return the matching joining processes
	 */
	public static List<JoiningProcess> findByUnitId(long unitId) {
		return getPersistence().findByUnitId(unitId);
	}

	/**
	 * Returns a range of all the joining processes where unitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param start the lower bound of the range of joining processes
	 * @param end the upper bound of the range of joining processes (not inclusive)
	 * @return the range of matching joining processes
	 */
	public static List<JoiningProcess> findByUnitId(
		long unitId, int start, int end) {

		return getPersistence().findByUnitId(unitId, start, end);
	}

	/**
	 * Returns an ordered range of all the joining processes where unitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param start the lower bound of the range of joining processes
	 * @param end the upper bound of the range of joining processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching joining processes
	 */
	public static List<JoiningProcess> findByUnitId(
		long unitId, int start, int end,
		OrderByComparator<JoiningProcess> orderByComparator) {

		return getPersistence().findByUnitId(
			unitId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the joining processes where unitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param start the lower bound of the range of joining processes
	 * @param end the upper bound of the range of joining processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching joining processes
	 */
	public static List<JoiningProcess> findByUnitId(
		long unitId, int start, int end,
		OrderByComparator<JoiningProcess> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUnitId(
			unitId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first joining process in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching joining process
	 * @throws NoSuchJoiningProcessException if a matching joining process could not be found
	 */
	public static JoiningProcess findByUnitId_First(
			long unitId, OrderByComparator<JoiningProcess> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchJoiningProcessException {

		return getPersistence().findByUnitId_First(unitId, orderByComparator);
	}

	/**
	 * Returns the first joining process in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching joining process, or <code>null</code> if a matching joining process could not be found
	 */
	public static JoiningProcess fetchByUnitId_First(
		long unitId, OrderByComparator<JoiningProcess> orderByComparator) {

		return getPersistence().fetchByUnitId_First(unitId, orderByComparator);
	}

	/**
	 * Returns the last joining process in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching joining process
	 * @throws NoSuchJoiningProcessException if a matching joining process could not be found
	 */
	public static JoiningProcess findByUnitId_Last(
			long unitId, OrderByComparator<JoiningProcess> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchJoiningProcessException {

		return getPersistence().findByUnitId_Last(unitId, orderByComparator);
	}

	/**
	 * Returns the last joining process in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching joining process, or <code>null</code> if a matching joining process could not be found
	 */
	public static JoiningProcess fetchByUnitId_Last(
		long unitId, OrderByComparator<JoiningProcess> orderByComparator) {

		return getPersistence().fetchByUnitId_Last(unitId, orderByComparator);
	}

	/**
	 * Returns the joining processes before and after the current joining process in the ordered set where unitId = &#63;.
	 *
	 * @param joiningProcessId the primary key of the current joining process
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next joining process
	 * @throws NoSuchJoiningProcessException if a joining process with the primary key could not be found
	 */
	public static JoiningProcess[] findByUnitId_PrevAndNext(
			long joiningProcessId, long unitId,
			OrderByComparator<JoiningProcess> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchJoiningProcessException {

		return getPersistence().findByUnitId_PrevAndNext(
			joiningProcessId, unitId, orderByComparator);
	}

	/**
	 * Removes all the joining processes where unitId = &#63; from the database.
	 *
	 * @param unitId the unit ID
	 */
	public static void removeByUnitId(long unitId) {
		getPersistence().removeByUnitId(unitId);
	}

	/**
	 * Returns the number of joining processes where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @return the number of matching joining processes
	 */
	public static int countByUnitId(long unitId) {
		return getPersistence().countByUnitId(unitId);
	}

	/**
	 * Returns all the joining processes where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @return the matching joining processes
	 */
	public static List<JoiningProcess> findByApproverUserId(
		long approverUserId) {

		return getPersistence().findByApproverUserId(approverUserId);
	}

	/**
	 * Returns a range of all the joining processes where approverUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessModelImpl</code>.
	 * </p>
	 *
	 * @param approverUserId the approver user ID
	 * @param start the lower bound of the range of joining processes
	 * @param end the upper bound of the range of joining processes (not inclusive)
	 * @return the range of matching joining processes
	 */
	public static List<JoiningProcess> findByApproverUserId(
		long approverUserId, int start, int end) {

		return getPersistence().findByApproverUserId(
			approverUserId, start, end);
	}

	/**
	 * Returns an ordered range of all the joining processes where approverUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessModelImpl</code>.
	 * </p>
	 *
	 * @param approverUserId the approver user ID
	 * @param start the lower bound of the range of joining processes
	 * @param end the upper bound of the range of joining processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching joining processes
	 */
	public static List<JoiningProcess> findByApproverUserId(
		long approverUserId, int start, int end,
		OrderByComparator<JoiningProcess> orderByComparator) {

		return getPersistence().findByApproverUserId(
			approverUserId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the joining processes where approverUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessModelImpl</code>.
	 * </p>
	 *
	 * @param approverUserId the approver user ID
	 * @param start the lower bound of the range of joining processes
	 * @param end the upper bound of the range of joining processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching joining processes
	 */
	public static List<JoiningProcess> findByApproverUserId(
		long approverUserId, int start, int end,
		OrderByComparator<JoiningProcess> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByApproverUserId(
			approverUserId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first joining process in the ordered set where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching joining process
	 * @throws NoSuchJoiningProcessException if a matching joining process could not be found
	 */
	public static JoiningProcess findByApproverUserId_First(
			long approverUserId,
			OrderByComparator<JoiningProcess> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchJoiningProcessException {

		return getPersistence().findByApproverUserId_First(
			approverUserId, orderByComparator);
	}

	/**
	 * Returns the first joining process in the ordered set where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching joining process, or <code>null</code> if a matching joining process could not be found
	 */
	public static JoiningProcess fetchByApproverUserId_First(
		long approverUserId,
		OrderByComparator<JoiningProcess> orderByComparator) {

		return getPersistence().fetchByApproverUserId_First(
			approverUserId, orderByComparator);
	}

	/**
	 * Returns the last joining process in the ordered set where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching joining process
	 * @throws NoSuchJoiningProcessException if a matching joining process could not be found
	 */
	public static JoiningProcess findByApproverUserId_Last(
			long approverUserId,
			OrderByComparator<JoiningProcess> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchJoiningProcessException {

		return getPersistence().findByApproverUserId_Last(
			approverUserId, orderByComparator);
	}

	/**
	 * Returns the last joining process in the ordered set where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching joining process, or <code>null</code> if a matching joining process could not be found
	 */
	public static JoiningProcess fetchByApproverUserId_Last(
		long approverUserId,
		OrderByComparator<JoiningProcess> orderByComparator) {

		return getPersistence().fetchByApproverUserId_Last(
			approverUserId, orderByComparator);
	}

	/**
	 * Returns the joining processes before and after the current joining process in the ordered set where approverUserId = &#63;.
	 *
	 * @param joiningProcessId the primary key of the current joining process
	 * @param approverUserId the approver user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next joining process
	 * @throws NoSuchJoiningProcessException if a joining process with the primary key could not be found
	 */
	public static JoiningProcess[] findByApproverUserId_PrevAndNext(
			long joiningProcessId, long approverUserId,
			OrderByComparator<JoiningProcess> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchJoiningProcessException {

		return getPersistence().findByApproverUserId_PrevAndNext(
			joiningProcessId, approverUserId, orderByComparator);
	}

	/**
	 * Removes all the joining processes where approverUserId = &#63; from the database.
	 *
	 * @param approverUserId the approver user ID
	 */
	public static void removeByApproverUserId(long approverUserId) {
		getPersistence().removeByApproverUserId(approverUserId);
	}

	/**
	 * Returns the number of joining processes where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @return the number of matching joining processes
	 */
	public static int countByApproverUserId(long approverUserId) {
		return getPersistence().countByApproverUserId(approverUserId);
	}

	/**
	 * Caches the joining process in the entity cache if it is enabled.
	 *
	 * @param joiningProcess the joining process
	 */
	public static void cacheResult(JoiningProcess joiningProcess) {
		getPersistence().cacheResult(joiningProcess);
	}

	/**
	 * Caches the joining processes in the entity cache if it is enabled.
	 *
	 * @param joiningProcesses the joining processes
	 */
	public static void cacheResult(List<JoiningProcess> joiningProcesses) {
		getPersistence().cacheResult(joiningProcesses);
	}

	/**
	 * Creates a new joining process with the primary key. Does not add the joining process to the database.
	 *
	 * @param joiningProcessId the primary key for the new joining process
	 * @return the new joining process
	 */
	public static JoiningProcess create(long joiningProcessId) {
		return getPersistence().create(joiningProcessId);
	}

	/**
	 * Removes the joining process with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param joiningProcessId the primary key of the joining process
	 * @return the joining process that was removed
	 * @throws NoSuchJoiningProcessException if a joining process with the primary key could not be found
	 */
	public static JoiningProcess remove(long joiningProcessId)
		throws com.adjecti.pis.liferay.exception.NoSuchJoiningProcessException {

		return getPersistence().remove(joiningProcessId);
	}

	public static JoiningProcess updateImpl(JoiningProcess joiningProcess) {
		return getPersistence().updateImpl(joiningProcess);
	}

	/**
	 * Returns the joining process with the primary key or throws a <code>NoSuchJoiningProcessException</code> if it could not be found.
	 *
	 * @param joiningProcessId the primary key of the joining process
	 * @return the joining process
	 * @throws NoSuchJoiningProcessException if a joining process with the primary key could not be found
	 */
	public static JoiningProcess findByPrimaryKey(long joiningProcessId)
		throws com.adjecti.pis.liferay.exception.NoSuchJoiningProcessException {

		return getPersistence().findByPrimaryKey(joiningProcessId);
	}

	/**
	 * Returns the joining process with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param joiningProcessId the primary key of the joining process
	 * @return the joining process, or <code>null</code> if a joining process with the primary key could not be found
	 */
	public static JoiningProcess fetchByPrimaryKey(long joiningProcessId) {
		return getPersistence().fetchByPrimaryKey(joiningProcessId);
	}

	/**
	 * Returns all the joining processes.
	 *
	 * @return the joining processes
	 */
	public static List<JoiningProcess> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the joining processes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of joining processes
	 * @param end the upper bound of the range of joining processes (not inclusive)
	 * @return the range of joining processes
	 */
	public static List<JoiningProcess> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the joining processes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of joining processes
	 * @param end the upper bound of the range of joining processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of joining processes
	 */
	public static List<JoiningProcess> findAll(
		int start, int end,
		OrderByComparator<JoiningProcess> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the joining processes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of joining processes
	 * @param end the upper bound of the range of joining processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of joining processes
	 */
	public static List<JoiningProcess> findAll(
		int start, int end, OrderByComparator<JoiningProcess> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the joining processes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of joining processes.
	 *
	 * @return the number of joining processes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static JoiningProcessPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<JoiningProcessPersistence, JoiningProcessPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			JoiningProcessPersistence.class);

		ServiceTracker<JoiningProcessPersistence, JoiningProcessPersistence>
			serviceTracker =
				new ServiceTracker
					<JoiningProcessPersistence, JoiningProcessPersistence>(
						bundle.getBundleContext(),
						JoiningProcessPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}