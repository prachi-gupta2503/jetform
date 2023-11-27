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

import com.adjecti.pis.liferay.exception.NoSuchProcessFileException;
import com.adjecti.pis.liferay.model.ProcessFile;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the process file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProcessFileUtil
 * @generated
 */
@ProviderType
public interface ProcessFilePersistence extends BasePersistence<ProcessFile> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProcessFileUtil} to access the process file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the process files where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching process files
	 */
	public java.util.List<ProcessFile> findByUuid(String uuid);

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
	public java.util.List<ProcessFile> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<ProcessFile> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProcessFile>
			orderByComparator);

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
	public java.util.List<ProcessFile> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProcessFile>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first process file in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching process file
	 * @throws NoSuchProcessFileException if a matching process file could not be found
	 */
	public ProcessFile findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProcessFile>
				orderByComparator)
		throws NoSuchProcessFileException;

	/**
	 * Returns the first process file in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching process file, or <code>null</code> if a matching process file could not be found
	 */
	public ProcessFile fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProcessFile>
			orderByComparator);

	/**
	 * Returns the last process file in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching process file
	 * @throws NoSuchProcessFileException if a matching process file could not be found
	 */
	public ProcessFile findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProcessFile>
				orderByComparator)
		throws NoSuchProcessFileException;

	/**
	 * Returns the last process file in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching process file, or <code>null</code> if a matching process file could not be found
	 */
	public ProcessFile fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProcessFile>
			orderByComparator);

	/**
	 * Returns the process files before and after the current process file in the ordered set where uuid = &#63;.
	 *
	 * @param processFileId the primary key of the current process file
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next process file
	 * @throws NoSuchProcessFileException if a process file with the primary key could not be found
	 */
	public ProcessFile[] findByUuid_PrevAndNext(
			long processFileId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProcessFile>
				orderByComparator)
		throws NoSuchProcessFileException;

	/**
	 * Removes all the process files where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of process files where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching process files
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the process file where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProcessFileException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching process file
	 * @throws NoSuchProcessFileException if a matching process file could not be found
	 */
	public ProcessFile findByUUID_G(String uuid, long groupId)
		throws NoSuchProcessFileException;

	/**
	 * Returns the process file where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching process file, or <code>null</code> if a matching process file could not be found
	 */
	public ProcessFile fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the process file where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching process file, or <code>null</code> if a matching process file could not be found
	 */
	public ProcessFile fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the process file where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the process file that was removed
	 */
	public ProcessFile removeByUUID_G(String uuid, long groupId)
		throws NoSuchProcessFileException;

	/**
	 * Returns the number of process files where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching process files
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the process files where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching process files
	 */
	public java.util.List<ProcessFile> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<ProcessFile> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<ProcessFile> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProcessFile>
			orderByComparator);

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
	public java.util.List<ProcessFile> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProcessFile>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first process file in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching process file
	 * @throws NoSuchProcessFileException if a matching process file could not be found
	 */
	public ProcessFile findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProcessFile>
				orderByComparator)
		throws NoSuchProcessFileException;

	/**
	 * Returns the first process file in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching process file, or <code>null</code> if a matching process file could not be found
	 */
	public ProcessFile fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProcessFile>
			orderByComparator);

	/**
	 * Returns the last process file in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching process file
	 * @throws NoSuchProcessFileException if a matching process file could not be found
	 */
	public ProcessFile findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProcessFile>
				orderByComparator)
		throws NoSuchProcessFileException;

	/**
	 * Returns the last process file in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching process file, or <code>null</code> if a matching process file could not be found
	 */
	public ProcessFile fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProcessFile>
			orderByComparator);

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
	public ProcessFile[] findByUuid_C_PrevAndNext(
			long processFileId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProcessFile>
				orderByComparator)
		throws NoSuchProcessFileException;

	/**
	 * Removes all the process files where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of process files where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching process files
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the process files where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching process files
	 */
	public java.util.List<ProcessFile> findByEmployeeId(long employeeId);

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
	public java.util.List<ProcessFile> findByEmployeeId(
		long employeeId, int start, int end);

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
	public java.util.List<ProcessFile> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProcessFile>
			orderByComparator);

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
	public java.util.List<ProcessFile> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProcessFile>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first process file in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching process file
	 * @throws NoSuchProcessFileException if a matching process file could not be found
	 */
	public ProcessFile findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<ProcessFile>
				orderByComparator)
		throws NoSuchProcessFileException;

	/**
	 * Returns the first process file in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching process file, or <code>null</code> if a matching process file could not be found
	 */
	public ProcessFile fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<ProcessFile>
			orderByComparator);

	/**
	 * Returns the last process file in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching process file
	 * @throws NoSuchProcessFileException if a matching process file could not be found
	 */
	public ProcessFile findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<ProcessFile>
				orderByComparator)
		throws NoSuchProcessFileException;

	/**
	 * Returns the last process file in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching process file, or <code>null</code> if a matching process file could not be found
	 */
	public ProcessFile fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<ProcessFile>
			orderByComparator);

	/**
	 * Returns the process files before and after the current process file in the ordered set where employeeId = &#63;.
	 *
	 * @param processFileId the primary key of the current process file
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next process file
	 * @throws NoSuchProcessFileException if a process file with the primary key could not be found
	 */
	public ProcessFile[] findByEmployeeId_PrevAndNext(
			long processFileId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<ProcessFile>
				orderByComparator)
		throws NoSuchProcessFileException;

	/**
	 * Removes all the process files where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of process files where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching process files
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Returns all the process files where processFileNo = &#63;.
	 *
	 * @param processFileNo the process file no
	 * @return the matching process files
	 */
	public java.util.List<ProcessFile> findByProcessFileNo(long processFileNo);

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
	public java.util.List<ProcessFile> findByProcessFileNo(
		long processFileNo, int start, int end);

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
	public java.util.List<ProcessFile> findByProcessFileNo(
		long processFileNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProcessFile>
			orderByComparator);

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
	public java.util.List<ProcessFile> findByProcessFileNo(
		long processFileNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProcessFile>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first process file in the ordered set where processFileNo = &#63;.
	 *
	 * @param processFileNo the process file no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching process file
	 * @throws NoSuchProcessFileException if a matching process file could not be found
	 */
	public ProcessFile findByProcessFileNo_First(
			long processFileNo,
			com.liferay.portal.kernel.util.OrderByComparator<ProcessFile>
				orderByComparator)
		throws NoSuchProcessFileException;

	/**
	 * Returns the first process file in the ordered set where processFileNo = &#63;.
	 *
	 * @param processFileNo the process file no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching process file, or <code>null</code> if a matching process file could not be found
	 */
	public ProcessFile fetchByProcessFileNo_First(
		long processFileNo,
		com.liferay.portal.kernel.util.OrderByComparator<ProcessFile>
			orderByComparator);

	/**
	 * Returns the last process file in the ordered set where processFileNo = &#63;.
	 *
	 * @param processFileNo the process file no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching process file
	 * @throws NoSuchProcessFileException if a matching process file could not be found
	 */
	public ProcessFile findByProcessFileNo_Last(
			long processFileNo,
			com.liferay.portal.kernel.util.OrderByComparator<ProcessFile>
				orderByComparator)
		throws NoSuchProcessFileException;

	/**
	 * Returns the last process file in the ordered set where processFileNo = &#63;.
	 *
	 * @param processFileNo the process file no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching process file, or <code>null</code> if a matching process file could not be found
	 */
	public ProcessFile fetchByProcessFileNo_Last(
		long processFileNo,
		com.liferay.portal.kernel.util.OrderByComparator<ProcessFile>
			orderByComparator);

	/**
	 * Returns the process files before and after the current process file in the ordered set where processFileNo = &#63;.
	 *
	 * @param processFileId the primary key of the current process file
	 * @param processFileNo the process file no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next process file
	 * @throws NoSuchProcessFileException if a process file with the primary key could not be found
	 */
	public ProcessFile[] findByProcessFileNo_PrevAndNext(
			long processFileId, long processFileNo,
			com.liferay.portal.kernel.util.OrderByComparator<ProcessFile>
				orderByComparator)
		throws NoSuchProcessFileException;

	/**
	 * Removes all the process files where processFileNo = &#63; from the database.
	 *
	 * @param processFileNo the process file no
	 */
	public void removeByProcessFileNo(long processFileNo);

	/**
	 * Returns the number of process files where processFileNo = &#63;.
	 *
	 * @param processFileNo the process file no
	 * @return the number of matching process files
	 */
	public int countByProcessFileNo(long processFileNo);

	/**
	 * Caches the process file in the entity cache if it is enabled.
	 *
	 * @param processFile the process file
	 */
	public void cacheResult(ProcessFile processFile);

	/**
	 * Caches the process files in the entity cache if it is enabled.
	 *
	 * @param processFiles the process files
	 */
	public void cacheResult(java.util.List<ProcessFile> processFiles);

	/**
	 * Creates a new process file with the primary key. Does not add the process file to the database.
	 *
	 * @param processFileId the primary key for the new process file
	 * @return the new process file
	 */
	public ProcessFile create(long processFileId);

	/**
	 * Removes the process file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param processFileId the primary key of the process file
	 * @return the process file that was removed
	 * @throws NoSuchProcessFileException if a process file with the primary key could not be found
	 */
	public ProcessFile remove(long processFileId)
		throws NoSuchProcessFileException;

	public ProcessFile updateImpl(ProcessFile processFile);

	/**
	 * Returns the process file with the primary key or throws a <code>NoSuchProcessFileException</code> if it could not be found.
	 *
	 * @param processFileId the primary key of the process file
	 * @return the process file
	 * @throws NoSuchProcessFileException if a process file with the primary key could not be found
	 */
	public ProcessFile findByPrimaryKey(long processFileId)
		throws NoSuchProcessFileException;

	/**
	 * Returns the process file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param processFileId the primary key of the process file
	 * @return the process file, or <code>null</code> if a process file with the primary key could not be found
	 */
	public ProcessFile fetchByPrimaryKey(long processFileId);

	/**
	 * Returns all the process files.
	 *
	 * @return the process files
	 */
	public java.util.List<ProcessFile> findAll();

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
	public java.util.List<ProcessFile> findAll(int start, int end);

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
	public java.util.List<ProcessFile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProcessFile>
			orderByComparator);

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
	public java.util.List<ProcessFile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProcessFile>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the process files from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of process files.
	 *
	 * @return the number of process files
	 */
	public int countAll();

}