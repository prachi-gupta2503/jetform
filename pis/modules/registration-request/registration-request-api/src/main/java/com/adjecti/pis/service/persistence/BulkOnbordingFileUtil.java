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

import com.adjecti.pis.model.BulkOnbordingFile;

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
 * The persistence utility for the bulk onbording file service. This utility wraps <code>com.adjecti.pis.service.persistence.impl.BulkOnbordingFilePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BulkOnbordingFilePersistence
 * @generated
 */
public class BulkOnbordingFileUtil {

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
	public static void clearCache(BulkOnbordingFile bulkOnbordingFile) {
		getPersistence().clearCache(bulkOnbordingFile);
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
	public static Map<Serializable, BulkOnbordingFile> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<BulkOnbordingFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BulkOnbordingFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BulkOnbordingFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<BulkOnbordingFile> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static BulkOnbordingFile update(
		BulkOnbordingFile bulkOnbordingFile) {

		return getPersistence().update(bulkOnbordingFile);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static BulkOnbordingFile update(
		BulkOnbordingFile bulkOnbordingFile, ServiceContext serviceContext) {

		return getPersistence().update(bulkOnbordingFile, serviceContext);
	}

	/**
	 * Returns all the bulk onbording files where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching bulk onbording files
	 */
	public static List<BulkOnbordingFile> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the bulk onbording files where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BulkOnbordingFileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bulk onbording files
	 * @param end the upper bound of the range of bulk onbording files (not inclusive)
	 * @return the range of matching bulk onbording files
	 */
	public static List<BulkOnbordingFile> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the bulk onbording files where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BulkOnbordingFileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bulk onbording files
	 * @param end the upper bound of the range of bulk onbording files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bulk onbording files
	 */
	public static List<BulkOnbordingFile> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BulkOnbordingFile> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the bulk onbording files where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BulkOnbordingFileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bulk onbording files
	 * @param end the upper bound of the range of bulk onbording files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching bulk onbording files
	 */
	public static List<BulkOnbordingFile> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BulkOnbordingFile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first bulk onbording file in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a matching bulk onbording file could not be found
	 */
	public static BulkOnbordingFile findByUuid_First(
			String uuid, OrderByComparator<BulkOnbordingFile> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchBulkOnbordingFileException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first bulk onbording file in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bulk onbording file, or <code>null</code> if a matching bulk onbording file could not be found
	 */
	public static BulkOnbordingFile fetchByUuid_First(
		String uuid, OrderByComparator<BulkOnbordingFile> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last bulk onbording file in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a matching bulk onbording file could not be found
	 */
	public static BulkOnbordingFile findByUuid_Last(
			String uuid, OrderByComparator<BulkOnbordingFile> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchBulkOnbordingFileException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last bulk onbording file in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bulk onbording file, or <code>null</code> if a matching bulk onbording file could not be found
	 */
	public static BulkOnbordingFile fetchByUuid_Last(
		String uuid, OrderByComparator<BulkOnbordingFile> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the bulk onbording files before and after the current bulk onbording file in the ordered set where uuid = &#63;.
	 *
	 * @param bulkOnbordingFileId the primary key of the current bulk onbording file
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a bulk onbording file with the primary key could not be found
	 */
	public static BulkOnbordingFile[] findByUuid_PrevAndNext(
			long bulkOnbordingFileId, String uuid,
			OrderByComparator<BulkOnbordingFile> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchBulkOnbordingFileException {

		return getPersistence().findByUuid_PrevAndNext(
			bulkOnbordingFileId, uuid, orderByComparator);
	}

	/**
	 * Removes all the bulk onbording files where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of bulk onbording files where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching bulk onbording files
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the bulk onbording file where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchBulkOnbordingFileException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a matching bulk onbording file could not be found
	 */
	public static BulkOnbordingFile findByUUID_G(String uuid, long groupId)
		throws com.adjecti.pis.exception.NoSuchBulkOnbordingFileException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the bulk onbording file where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching bulk onbording file, or <code>null</code> if a matching bulk onbording file could not be found
	 */
	public static BulkOnbordingFile fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the bulk onbording file where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching bulk onbording file, or <code>null</code> if a matching bulk onbording file could not be found
	 */
	public static BulkOnbordingFile fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the bulk onbording file where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the bulk onbording file that was removed
	 */
	public static BulkOnbordingFile removeByUUID_G(String uuid, long groupId)
		throws com.adjecti.pis.exception.NoSuchBulkOnbordingFileException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of bulk onbording files where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching bulk onbording files
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the bulk onbording files where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching bulk onbording files
	 */
	public static List<BulkOnbordingFile> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the bulk onbording files where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BulkOnbordingFileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of bulk onbording files
	 * @param end the upper bound of the range of bulk onbording files (not inclusive)
	 * @return the range of matching bulk onbording files
	 */
	public static List<BulkOnbordingFile> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the bulk onbording files where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BulkOnbordingFileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of bulk onbording files
	 * @param end the upper bound of the range of bulk onbording files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bulk onbording files
	 */
	public static List<BulkOnbordingFile> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BulkOnbordingFile> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the bulk onbording files where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BulkOnbordingFileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of bulk onbording files
	 * @param end the upper bound of the range of bulk onbording files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching bulk onbording files
	 */
	public static List<BulkOnbordingFile> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BulkOnbordingFile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first bulk onbording file in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a matching bulk onbording file could not be found
	 */
	public static BulkOnbordingFile findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<BulkOnbordingFile> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchBulkOnbordingFileException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first bulk onbording file in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bulk onbording file, or <code>null</code> if a matching bulk onbording file could not be found
	 */
	public static BulkOnbordingFile fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<BulkOnbordingFile> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last bulk onbording file in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a matching bulk onbording file could not be found
	 */
	public static BulkOnbordingFile findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<BulkOnbordingFile> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchBulkOnbordingFileException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last bulk onbording file in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bulk onbording file, or <code>null</code> if a matching bulk onbording file could not be found
	 */
	public static BulkOnbordingFile fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<BulkOnbordingFile> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the bulk onbording files before and after the current bulk onbording file in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param bulkOnbordingFileId the primary key of the current bulk onbording file
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a bulk onbording file with the primary key could not be found
	 */
	public static BulkOnbordingFile[] findByUuid_C_PrevAndNext(
			long bulkOnbordingFileId, String uuid, long companyId,
			OrderByComparator<BulkOnbordingFile> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchBulkOnbordingFileException {

		return getPersistence().findByUuid_C_PrevAndNext(
			bulkOnbordingFileId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the bulk onbording files where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of bulk onbording files where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching bulk onbording files
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the bulk onbording files where bulkOnbordingFileId = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @return the matching bulk onbording files
	 */
	public static List<BulkOnbordingFile> findByfileId(
		long bulkOnbordingFileId) {

		return getPersistence().findByfileId(bulkOnbordingFileId);
	}

	/**
	 * Returns a range of all the bulk onbording files where bulkOnbordingFileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BulkOnbordingFileModelImpl</code>.
	 * </p>
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param start the lower bound of the range of bulk onbording files
	 * @param end the upper bound of the range of bulk onbording files (not inclusive)
	 * @return the range of matching bulk onbording files
	 */
	public static List<BulkOnbordingFile> findByfileId(
		long bulkOnbordingFileId, int start, int end) {

		return getPersistence().findByfileId(bulkOnbordingFileId, start, end);
	}

	/**
	 * Returns an ordered range of all the bulk onbording files where bulkOnbordingFileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BulkOnbordingFileModelImpl</code>.
	 * </p>
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param start the lower bound of the range of bulk onbording files
	 * @param end the upper bound of the range of bulk onbording files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bulk onbording files
	 */
	public static List<BulkOnbordingFile> findByfileId(
		long bulkOnbordingFileId, int start, int end,
		OrderByComparator<BulkOnbordingFile> orderByComparator) {

		return getPersistence().findByfileId(
			bulkOnbordingFileId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the bulk onbording files where bulkOnbordingFileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BulkOnbordingFileModelImpl</code>.
	 * </p>
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param start the lower bound of the range of bulk onbording files
	 * @param end the upper bound of the range of bulk onbording files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching bulk onbording files
	 */
	public static List<BulkOnbordingFile> findByfileId(
		long bulkOnbordingFileId, int start, int end,
		OrderByComparator<BulkOnbordingFile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByfileId(
			bulkOnbordingFileId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first bulk onbording file in the ordered set where bulkOnbordingFileId = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a matching bulk onbording file could not be found
	 */
	public static BulkOnbordingFile findByfileId_First(
			long bulkOnbordingFileId,
			OrderByComparator<BulkOnbordingFile> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchBulkOnbordingFileException {

		return getPersistence().findByfileId_First(
			bulkOnbordingFileId, orderByComparator);
	}

	/**
	 * Returns the first bulk onbording file in the ordered set where bulkOnbordingFileId = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bulk onbording file, or <code>null</code> if a matching bulk onbording file could not be found
	 */
	public static BulkOnbordingFile fetchByfileId_First(
		long bulkOnbordingFileId,
		OrderByComparator<BulkOnbordingFile> orderByComparator) {

		return getPersistence().fetchByfileId_First(
			bulkOnbordingFileId, orderByComparator);
	}

	/**
	 * Returns the last bulk onbording file in the ordered set where bulkOnbordingFileId = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a matching bulk onbording file could not be found
	 */
	public static BulkOnbordingFile findByfileId_Last(
			long bulkOnbordingFileId,
			OrderByComparator<BulkOnbordingFile> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchBulkOnbordingFileException {

		return getPersistence().findByfileId_Last(
			bulkOnbordingFileId, orderByComparator);
	}

	/**
	 * Returns the last bulk onbording file in the ordered set where bulkOnbordingFileId = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bulk onbording file, or <code>null</code> if a matching bulk onbording file could not be found
	 */
	public static BulkOnbordingFile fetchByfileId_Last(
		long bulkOnbordingFileId,
		OrderByComparator<BulkOnbordingFile> orderByComparator) {

		return getPersistence().fetchByfileId_Last(
			bulkOnbordingFileId, orderByComparator);
	}

	/**
	 * Removes all the bulk onbording files where bulkOnbordingFileId = &#63; from the database.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 */
	public static void removeByfileId(long bulkOnbordingFileId) {
		getPersistence().removeByfileId(bulkOnbordingFileId);
	}

	/**
	 * Returns the number of bulk onbording files where bulkOnbordingFileId = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @return the number of matching bulk onbording files
	 */
	public static int countByfileId(long bulkOnbordingFileId) {
		return getPersistence().countByfileId(bulkOnbordingFileId);
	}

	/**
	 * Returns all the bulk onbording files where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching bulk onbording files
	 */
	public static List<BulkOnbordingFile> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the bulk onbording files where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BulkOnbordingFileModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of bulk onbording files
	 * @param end the upper bound of the range of bulk onbording files (not inclusive)
	 * @return the range of matching bulk onbording files
	 */
	public static List<BulkOnbordingFile> findByUserId(
		long userId, int start, int end) {

		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the bulk onbording files where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BulkOnbordingFileModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of bulk onbording files
	 * @param end the upper bound of the range of bulk onbording files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bulk onbording files
	 */
	public static List<BulkOnbordingFile> findByUserId(
		long userId, int start, int end,
		OrderByComparator<BulkOnbordingFile> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the bulk onbording files where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BulkOnbordingFileModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of bulk onbording files
	 * @param end the upper bound of the range of bulk onbording files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching bulk onbording files
	 */
	public static List<BulkOnbordingFile> findByUserId(
		long userId, int start, int end,
		OrderByComparator<BulkOnbordingFile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first bulk onbording file in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a matching bulk onbording file could not be found
	 */
	public static BulkOnbordingFile findByUserId_First(
			long userId, OrderByComparator<BulkOnbordingFile> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchBulkOnbordingFileException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first bulk onbording file in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bulk onbording file, or <code>null</code> if a matching bulk onbording file could not be found
	 */
	public static BulkOnbordingFile fetchByUserId_First(
		long userId, OrderByComparator<BulkOnbordingFile> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last bulk onbording file in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a matching bulk onbording file could not be found
	 */
	public static BulkOnbordingFile findByUserId_Last(
			long userId, OrderByComparator<BulkOnbordingFile> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchBulkOnbordingFileException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last bulk onbording file in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bulk onbording file, or <code>null</code> if a matching bulk onbording file could not be found
	 */
	public static BulkOnbordingFile fetchByUserId_Last(
		long userId, OrderByComparator<BulkOnbordingFile> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the bulk onbording files before and after the current bulk onbording file in the ordered set where userId = &#63;.
	 *
	 * @param bulkOnbordingFileId the primary key of the current bulk onbording file
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a bulk onbording file with the primary key could not be found
	 */
	public static BulkOnbordingFile[] findByUserId_PrevAndNext(
			long bulkOnbordingFileId, long userId,
			OrderByComparator<BulkOnbordingFile> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchBulkOnbordingFileException {

		return getPersistence().findByUserId_PrevAndNext(
			bulkOnbordingFileId, userId, orderByComparator);
	}

	/**
	 * Removes all the bulk onbording files where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of bulk onbording files where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching bulk onbording files
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Returns all the bulk onbording files where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @return the matching bulk onbording files
	 */
	public static List<BulkOnbordingFile> findByUnitId(Long unitId) {
		return getPersistence().findByUnitId(unitId);
	}

	/**
	 * Returns a range of all the bulk onbording files where unitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BulkOnbordingFileModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param start the lower bound of the range of bulk onbording files
	 * @param end the upper bound of the range of bulk onbording files (not inclusive)
	 * @return the range of matching bulk onbording files
	 */
	public static List<BulkOnbordingFile> findByUnitId(
		Long unitId, int start, int end) {

		return getPersistence().findByUnitId(unitId, start, end);
	}

	/**
	 * Returns an ordered range of all the bulk onbording files where unitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BulkOnbordingFileModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param start the lower bound of the range of bulk onbording files
	 * @param end the upper bound of the range of bulk onbording files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bulk onbording files
	 */
	public static List<BulkOnbordingFile> findByUnitId(
		Long unitId, int start, int end,
		OrderByComparator<BulkOnbordingFile> orderByComparator) {

		return getPersistence().findByUnitId(
			unitId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the bulk onbording files where unitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BulkOnbordingFileModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param start the lower bound of the range of bulk onbording files
	 * @param end the upper bound of the range of bulk onbording files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching bulk onbording files
	 */
	public static List<BulkOnbordingFile> findByUnitId(
		Long unitId, int start, int end,
		OrderByComparator<BulkOnbordingFile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUnitId(
			unitId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first bulk onbording file in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a matching bulk onbording file could not be found
	 */
	public static BulkOnbordingFile findByUnitId_First(
			Long unitId, OrderByComparator<BulkOnbordingFile> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchBulkOnbordingFileException {

		return getPersistence().findByUnitId_First(unitId, orderByComparator);
	}

	/**
	 * Returns the first bulk onbording file in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bulk onbording file, or <code>null</code> if a matching bulk onbording file could not be found
	 */
	public static BulkOnbordingFile fetchByUnitId_First(
		Long unitId, OrderByComparator<BulkOnbordingFile> orderByComparator) {

		return getPersistence().fetchByUnitId_First(unitId, orderByComparator);
	}

	/**
	 * Returns the last bulk onbording file in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a matching bulk onbording file could not be found
	 */
	public static BulkOnbordingFile findByUnitId_Last(
			Long unitId, OrderByComparator<BulkOnbordingFile> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchBulkOnbordingFileException {

		return getPersistence().findByUnitId_Last(unitId, orderByComparator);
	}

	/**
	 * Returns the last bulk onbording file in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bulk onbording file, or <code>null</code> if a matching bulk onbording file could not be found
	 */
	public static BulkOnbordingFile fetchByUnitId_Last(
		Long unitId, OrderByComparator<BulkOnbordingFile> orderByComparator) {

		return getPersistence().fetchByUnitId_Last(unitId, orderByComparator);
	}

	/**
	 * Returns the bulk onbording files before and after the current bulk onbording file in the ordered set where unitId = &#63;.
	 *
	 * @param bulkOnbordingFileId the primary key of the current bulk onbording file
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a bulk onbording file with the primary key could not be found
	 */
	public static BulkOnbordingFile[] findByUnitId_PrevAndNext(
			long bulkOnbordingFileId, Long unitId,
			OrderByComparator<BulkOnbordingFile> orderByComparator)
		throws com.adjecti.pis.exception.NoSuchBulkOnbordingFileException {

		return getPersistence().findByUnitId_PrevAndNext(
			bulkOnbordingFileId, unitId, orderByComparator);
	}

	/**
	 * Removes all the bulk onbording files where unitId = &#63; from the database.
	 *
	 * @param unitId the unit ID
	 */
	public static void removeByUnitId(Long unitId) {
		getPersistence().removeByUnitId(unitId);
	}

	/**
	 * Returns the number of bulk onbording files where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @return the number of matching bulk onbording files
	 */
	public static int countByUnitId(Long unitId) {
		return getPersistence().countByUnitId(unitId);
	}

	/**
	 * Caches the bulk onbording file in the entity cache if it is enabled.
	 *
	 * @param bulkOnbordingFile the bulk onbording file
	 */
	public static void cacheResult(BulkOnbordingFile bulkOnbordingFile) {
		getPersistence().cacheResult(bulkOnbordingFile);
	}

	/**
	 * Caches the bulk onbording files in the entity cache if it is enabled.
	 *
	 * @param bulkOnbordingFiles the bulk onbording files
	 */
	public static void cacheResult(List<BulkOnbordingFile> bulkOnbordingFiles) {
		getPersistence().cacheResult(bulkOnbordingFiles);
	}

	/**
	 * Creates a new bulk onbording file with the primary key. Does not add the bulk onbording file to the database.
	 *
	 * @param bulkOnbordingFileId the primary key for the new bulk onbording file
	 * @return the new bulk onbording file
	 */
	public static BulkOnbordingFile create(long bulkOnbordingFileId) {
		return getPersistence().create(bulkOnbordingFileId);
	}

	/**
	 * Removes the bulk onbording file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bulkOnbordingFileId the primary key of the bulk onbording file
	 * @return the bulk onbording file that was removed
	 * @throws NoSuchBulkOnbordingFileException if a bulk onbording file with the primary key could not be found
	 */
	public static BulkOnbordingFile remove(long bulkOnbordingFileId)
		throws com.adjecti.pis.exception.NoSuchBulkOnbordingFileException {

		return getPersistence().remove(bulkOnbordingFileId);
	}

	public static BulkOnbordingFile updateImpl(
		BulkOnbordingFile bulkOnbordingFile) {

		return getPersistence().updateImpl(bulkOnbordingFile);
	}

	/**
	 * Returns the bulk onbording file with the primary key or throws a <code>NoSuchBulkOnbordingFileException</code> if it could not be found.
	 *
	 * @param bulkOnbordingFileId the primary key of the bulk onbording file
	 * @return the bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a bulk onbording file with the primary key could not be found
	 */
	public static BulkOnbordingFile findByPrimaryKey(long bulkOnbordingFileId)
		throws com.adjecti.pis.exception.NoSuchBulkOnbordingFileException {

		return getPersistence().findByPrimaryKey(bulkOnbordingFileId);
	}

	/**
	 * Returns the bulk onbording file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bulkOnbordingFileId the primary key of the bulk onbording file
	 * @return the bulk onbording file, or <code>null</code> if a bulk onbording file with the primary key could not be found
	 */
	public static BulkOnbordingFile fetchByPrimaryKey(
		long bulkOnbordingFileId) {

		return getPersistence().fetchByPrimaryKey(bulkOnbordingFileId);
	}

	/**
	 * Returns all the bulk onbording files.
	 *
	 * @return the bulk onbording files
	 */
	public static List<BulkOnbordingFile> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the bulk onbording files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BulkOnbordingFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bulk onbording files
	 * @param end the upper bound of the range of bulk onbording files (not inclusive)
	 * @return the range of bulk onbording files
	 */
	public static List<BulkOnbordingFile> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the bulk onbording files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BulkOnbordingFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bulk onbording files
	 * @param end the upper bound of the range of bulk onbording files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bulk onbording files
	 */
	public static List<BulkOnbordingFile> findAll(
		int start, int end,
		OrderByComparator<BulkOnbordingFile> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the bulk onbording files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BulkOnbordingFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bulk onbording files
	 * @param end the upper bound of the range of bulk onbording files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of bulk onbording files
	 */
	public static List<BulkOnbordingFile> findAll(
		int start, int end,
		OrderByComparator<BulkOnbordingFile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the bulk onbording files from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of bulk onbording files.
	 *
	 * @return the number of bulk onbording files
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BulkOnbordingFilePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<BulkOnbordingFilePersistence, BulkOnbordingFilePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			BulkOnbordingFilePersistence.class);

		ServiceTracker
			<BulkOnbordingFilePersistence, BulkOnbordingFilePersistence>
				serviceTracker =
					new ServiceTracker
						<BulkOnbordingFilePersistence,
						 BulkOnbordingFilePersistence>(
							 bundle.getBundleContext(),
							 BulkOnbordingFilePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}