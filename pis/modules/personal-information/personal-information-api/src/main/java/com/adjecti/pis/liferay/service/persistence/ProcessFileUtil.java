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

import com.adjecti.pis.liferay.model.ProcessFile;

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
 * The persistence utility for the process file service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.ProcessFilePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProcessFilePersistence
 * @generated
 */
public class ProcessFileUtil {

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
	public static void clearCache(ProcessFile processFile) {
		getPersistence().clearCache(processFile);
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
	public static Map<Serializable, ProcessFile> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProcessFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProcessFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProcessFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProcessFile> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProcessFile update(ProcessFile processFile) {
		return getPersistence().update(processFile);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProcessFile update(
		ProcessFile processFile, ServiceContext serviceContext) {

		return getPersistence().update(processFile, serviceContext);
	}

	/**
	 * Returns all the process files where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching process files
	 */
	public static List<ProcessFile> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the process files where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessFileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of process files
	 * @param end the upper bound of the range of process files (not inclusive)
	 * @return the range of matching process files
	 */
	public static List<ProcessFile> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the process files where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessFileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of process files
	 * @param end the upper bound of the range of process files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching process files
	 */
	public static List<ProcessFile> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProcessFile> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the process files where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessFileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of process files
	 * @param end the upper bound of the range of process files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching process files
	 */
	public static List<ProcessFile> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProcessFile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first process file in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching process file
	 * @throws NoSuchProcessFileException if a matching process file could not be found
	 */
	public static ProcessFile findByUuid_First(
			String uuid, OrderByComparator<ProcessFile> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchProcessFileException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first process file in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching process file, or <code>null</code> if a matching process file could not be found
	 */
	public static ProcessFile fetchByUuid_First(
		String uuid, OrderByComparator<ProcessFile> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last process file in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching process file
	 * @throws NoSuchProcessFileException if a matching process file could not be found
	 */
	public static ProcessFile findByUuid_Last(
			String uuid, OrderByComparator<ProcessFile> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchProcessFileException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last process file in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching process file, or <code>null</code> if a matching process file could not be found
	 */
	public static ProcessFile fetchByUuid_Last(
		String uuid, OrderByComparator<ProcessFile> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the process files before and after the current process file in the ordered set where uuid = &#63;.
	 *
	 * @param processFileId the primary key of the current process file
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next process file
	 * @throws NoSuchProcessFileException if a process file with the primary key could not be found
	 */
	public static ProcessFile[] findByUuid_PrevAndNext(
			long processFileId, String uuid,
			OrderByComparator<ProcessFile> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchProcessFileException {

		return getPersistence().findByUuid_PrevAndNext(
			processFileId, uuid, orderByComparator);
	}

	/**
	 * Removes all the process files where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of process files where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching process files
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the process file where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProcessFileException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching process file
	 * @throws NoSuchProcessFileException if a matching process file could not be found
	 */
	public static ProcessFile findByUUID_G(String uuid, long groupId)
		throws com.adjecti.pis.liferay.exception.NoSuchProcessFileException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the process file where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching process file, or <code>null</code> if a matching process file could not be found
	 */
	public static ProcessFile fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the process file where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching process file, or <code>null</code> if a matching process file could not be found
	 */
	public static ProcessFile fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the process file where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the process file that was removed
	 */
	public static ProcessFile removeByUUID_G(String uuid, long groupId)
		throws com.adjecti.pis.liferay.exception.NoSuchProcessFileException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of process files where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching process files
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the process files where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching process files
	 */
	public static List<ProcessFile> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the process files where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessFileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of process files
	 * @param end the upper bound of the range of process files (not inclusive)
	 * @return the range of matching process files
	 */
	public static List<ProcessFile> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the process files where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessFileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of process files
	 * @param end the upper bound of the range of process files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching process files
	 */
	public static List<ProcessFile> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProcessFile> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the process files where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessFileModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of process files
	 * @param end the upper bound of the range of process files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching process files
	 */
	public static List<ProcessFile> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProcessFile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first process file in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching process file
	 * @throws NoSuchProcessFileException if a matching process file could not be found
	 */
	public static ProcessFile findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProcessFile> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchProcessFileException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first process file in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching process file, or <code>null</code> if a matching process file could not be found
	 */
	public static ProcessFile fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProcessFile> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last process file in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching process file
	 * @throws NoSuchProcessFileException if a matching process file could not be found
	 */
	public static ProcessFile findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProcessFile> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchProcessFileException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last process file in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching process file, or <code>null</code> if a matching process file could not be found
	 */
	public static ProcessFile fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProcessFile> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the process files before and after the current process file in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param processFileId the primary key of the current process file
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next process file
	 * @throws NoSuchProcessFileException if a process file with the primary key could not be found
	 */
	public static ProcessFile[] findByUuid_C_PrevAndNext(
			long processFileId, String uuid, long companyId,
			OrderByComparator<ProcessFile> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchProcessFileException {

		return getPersistence().findByUuid_C_PrevAndNext(
			processFileId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the process files where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of process files where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching process files
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the process files where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching process files
	 */
	public static List<ProcessFile> findByEmployeeId(long employeeId) {
		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns a range of all the process files where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessFileModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of process files
	 * @param end the upper bound of the range of process files (not inclusive)
	 * @return the range of matching process files
	 */
	public static List<ProcessFile> findByEmployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the process files where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessFileModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of process files
	 * @param end the upper bound of the range of process files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching process files
	 */
	public static List<ProcessFile> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<ProcessFile> orderByComparator) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the process files where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessFileModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of process files
	 * @param end the upper bound of the range of process files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching process files
	 */
	public static List<ProcessFile> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<ProcessFile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first process file in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching process file
	 * @throws NoSuchProcessFileException if a matching process file could not be found
	 */
	public static ProcessFile findByEmployeeId_First(
			long employeeId, OrderByComparator<ProcessFile> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchProcessFileException {

		return getPersistence().findByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first process file in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching process file, or <code>null</code> if a matching process file could not be found
	 */
	public static ProcessFile fetchByEmployeeId_First(
		long employeeId, OrderByComparator<ProcessFile> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last process file in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching process file
	 * @throws NoSuchProcessFileException if a matching process file could not be found
	 */
	public static ProcessFile findByEmployeeId_Last(
			long employeeId, OrderByComparator<ProcessFile> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchProcessFileException {

		return getPersistence().findByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last process file in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching process file, or <code>null</code> if a matching process file could not be found
	 */
	public static ProcessFile fetchByEmployeeId_Last(
		long employeeId, OrderByComparator<ProcessFile> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the process files before and after the current process file in the ordered set where employeeId = &#63;.
	 *
	 * @param processFileId the primary key of the current process file
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next process file
	 * @throws NoSuchProcessFileException if a process file with the primary key could not be found
	 */
	public static ProcessFile[] findByEmployeeId_PrevAndNext(
			long processFileId, long employeeId,
			OrderByComparator<ProcessFile> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchProcessFileException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			processFileId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the process files where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of process files where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching process files
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Returns all the process files where processFileNo = &#63;.
	 *
	 * @param processFileNo the process file no
	 * @return the matching process files
	 */
	public static List<ProcessFile> findByProcessFileNo(long processFileNo) {
		return getPersistence().findByProcessFileNo(processFileNo);
	}

	/**
	 * Returns a range of all the process files where processFileNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessFileModelImpl</code>.
	 * </p>
	 *
	 * @param processFileNo the process file no
	 * @param start the lower bound of the range of process files
	 * @param end the upper bound of the range of process files (not inclusive)
	 * @return the range of matching process files
	 */
	public static List<ProcessFile> findByProcessFileNo(
		long processFileNo, int start, int end) {

		return getPersistence().findByProcessFileNo(processFileNo, start, end);
	}

	/**
	 * Returns an ordered range of all the process files where processFileNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessFileModelImpl</code>.
	 * </p>
	 *
	 * @param processFileNo the process file no
	 * @param start the lower bound of the range of process files
	 * @param end the upper bound of the range of process files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching process files
	 */
	public static List<ProcessFile> findByProcessFileNo(
		long processFileNo, int start, int end,
		OrderByComparator<ProcessFile> orderByComparator) {

		return getPersistence().findByProcessFileNo(
			processFileNo, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the process files where processFileNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessFileModelImpl</code>.
	 * </p>
	 *
	 * @param processFileNo the process file no
	 * @param start the lower bound of the range of process files
	 * @param end the upper bound of the range of process files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching process files
	 */
	public static List<ProcessFile> findByProcessFileNo(
		long processFileNo, int start, int end,
		OrderByComparator<ProcessFile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProcessFileNo(
			processFileNo, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first process file in the ordered set where processFileNo = &#63;.
	 *
	 * @param processFileNo the process file no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching process file
	 * @throws NoSuchProcessFileException if a matching process file could not be found
	 */
	public static ProcessFile findByProcessFileNo_First(
			long processFileNo,
			OrderByComparator<ProcessFile> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchProcessFileException {

		return getPersistence().findByProcessFileNo_First(
			processFileNo, orderByComparator);
	}

	/**
	 * Returns the first process file in the ordered set where processFileNo = &#63;.
	 *
	 * @param processFileNo the process file no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching process file, or <code>null</code> if a matching process file could not be found
	 */
	public static ProcessFile fetchByProcessFileNo_First(
		long processFileNo, OrderByComparator<ProcessFile> orderByComparator) {

		return getPersistence().fetchByProcessFileNo_First(
			processFileNo, orderByComparator);
	}

	/**
	 * Returns the last process file in the ordered set where processFileNo = &#63;.
	 *
	 * @param processFileNo the process file no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching process file
	 * @throws NoSuchProcessFileException if a matching process file could not be found
	 */
	public static ProcessFile findByProcessFileNo_Last(
			long processFileNo,
			OrderByComparator<ProcessFile> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchProcessFileException {

		return getPersistence().findByProcessFileNo_Last(
			processFileNo, orderByComparator);
	}

	/**
	 * Returns the last process file in the ordered set where processFileNo = &#63;.
	 *
	 * @param processFileNo the process file no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching process file, or <code>null</code> if a matching process file could not be found
	 */
	public static ProcessFile fetchByProcessFileNo_Last(
		long processFileNo, OrderByComparator<ProcessFile> orderByComparator) {

		return getPersistence().fetchByProcessFileNo_Last(
			processFileNo, orderByComparator);
	}

	/**
	 * Returns the process files before and after the current process file in the ordered set where processFileNo = &#63;.
	 *
	 * @param processFileId the primary key of the current process file
	 * @param processFileNo the process file no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next process file
	 * @throws NoSuchProcessFileException if a process file with the primary key could not be found
	 */
	public static ProcessFile[] findByProcessFileNo_PrevAndNext(
			long processFileId, long processFileNo,
			OrderByComparator<ProcessFile> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchProcessFileException {

		return getPersistence().findByProcessFileNo_PrevAndNext(
			processFileId, processFileNo, orderByComparator);
	}

	/**
	 * Removes all the process files where processFileNo = &#63; from the database.
	 *
	 * @param processFileNo the process file no
	 */
	public static void removeByProcessFileNo(long processFileNo) {
		getPersistence().removeByProcessFileNo(processFileNo);
	}

	/**
	 * Returns the number of process files where processFileNo = &#63;.
	 *
	 * @param processFileNo the process file no
	 * @return the number of matching process files
	 */
	public static int countByProcessFileNo(long processFileNo) {
		return getPersistence().countByProcessFileNo(processFileNo);
	}

	/**
	 * Caches the process file in the entity cache if it is enabled.
	 *
	 * @param processFile the process file
	 */
	public static void cacheResult(ProcessFile processFile) {
		getPersistence().cacheResult(processFile);
	}

	/**
	 * Caches the process files in the entity cache if it is enabled.
	 *
	 * @param processFiles the process files
	 */
	public static void cacheResult(List<ProcessFile> processFiles) {
		getPersistence().cacheResult(processFiles);
	}

	/**
	 * Creates a new process file with the primary key. Does not add the process file to the database.
	 *
	 * @param processFileId the primary key for the new process file
	 * @return the new process file
	 */
	public static ProcessFile create(long processFileId) {
		return getPersistence().create(processFileId);
	}

	/**
	 * Removes the process file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param processFileId the primary key of the process file
	 * @return the process file that was removed
	 * @throws NoSuchProcessFileException if a process file with the primary key could not be found
	 */
	public static ProcessFile remove(long processFileId)
		throws com.adjecti.pis.liferay.exception.NoSuchProcessFileException {

		return getPersistence().remove(processFileId);
	}

	public static ProcessFile updateImpl(ProcessFile processFile) {
		return getPersistence().updateImpl(processFile);
	}

	/**
	 * Returns the process file with the primary key or throws a <code>NoSuchProcessFileException</code> if it could not be found.
	 *
	 * @param processFileId the primary key of the process file
	 * @return the process file
	 * @throws NoSuchProcessFileException if a process file with the primary key could not be found
	 */
	public static ProcessFile findByPrimaryKey(long processFileId)
		throws com.adjecti.pis.liferay.exception.NoSuchProcessFileException {

		return getPersistence().findByPrimaryKey(processFileId);
	}

	/**
	 * Returns the process file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param processFileId the primary key of the process file
	 * @return the process file, or <code>null</code> if a process file with the primary key could not be found
	 */
	public static ProcessFile fetchByPrimaryKey(long processFileId) {
		return getPersistence().fetchByPrimaryKey(processFileId);
	}

	/**
	 * Returns all the process files.
	 *
	 * @return the process files
	 */
	public static List<ProcessFile> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the process files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of process files
	 * @param end the upper bound of the range of process files (not inclusive)
	 * @return the range of process files
	 */
	public static List<ProcessFile> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the process files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of process files
	 * @param end the upper bound of the range of process files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of process files
	 */
	public static List<ProcessFile> findAll(
		int start, int end, OrderByComparator<ProcessFile> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the process files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcessFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of process files
	 * @param end the upper bound of the range of process files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of process files
	 */
	public static List<ProcessFile> findAll(
		int start, int end, OrderByComparator<ProcessFile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the process files from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of process files.
	 *
	 * @return the number of process files
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProcessFilePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ProcessFilePersistence, ProcessFilePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ProcessFilePersistence.class);

		ServiceTracker<ProcessFilePersistence, ProcessFilePersistence>
			serviceTracker =
				new ServiceTracker
					<ProcessFilePersistence, ProcessFilePersistence>(
						bundle.getBundleContext(), ProcessFilePersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}