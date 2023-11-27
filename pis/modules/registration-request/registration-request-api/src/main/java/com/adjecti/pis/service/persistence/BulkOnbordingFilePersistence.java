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

import com.adjecti.pis.exception.NoSuchBulkOnbordingFileException;
import com.adjecti.pis.model.BulkOnbordingFile;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the bulk onbording file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BulkOnbordingFileUtil
 * @generated
 */
@ProviderType
public interface BulkOnbordingFilePersistence
	extends BasePersistence<BulkOnbordingFile> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BulkOnbordingFileUtil} to access the bulk onbording file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the bulk onbording files where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching bulk onbording files
	 */
	public java.util.List<BulkOnbordingFile> findByUuid(String uuid);

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
	public java.util.List<BulkOnbordingFile> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<BulkOnbordingFile> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BulkOnbordingFile>
			orderByComparator);

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
	public java.util.List<BulkOnbordingFile> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BulkOnbordingFile>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first bulk onbording file in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a matching bulk onbording file could not be found
	 */
	public BulkOnbordingFile findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<BulkOnbordingFile>
				orderByComparator)
		throws NoSuchBulkOnbordingFileException;

	/**
	 * Returns the first bulk onbording file in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bulk onbording file, or <code>null</code> if a matching bulk onbording file could not be found
	 */
	public BulkOnbordingFile fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<BulkOnbordingFile>
			orderByComparator);

	/**
	 * Returns the last bulk onbording file in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a matching bulk onbording file could not be found
	 */
	public BulkOnbordingFile findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<BulkOnbordingFile>
				orderByComparator)
		throws NoSuchBulkOnbordingFileException;

	/**
	 * Returns the last bulk onbording file in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bulk onbording file, or <code>null</code> if a matching bulk onbording file could not be found
	 */
	public BulkOnbordingFile fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<BulkOnbordingFile>
			orderByComparator);

	/**
	 * Returns the bulk onbording files before and after the current bulk onbording file in the ordered set where uuid = &#63;.
	 *
	 * @param bulkOnbordingFileId the primary key of the current bulk onbording file
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a bulk onbording file with the primary key could not be found
	 */
	public BulkOnbordingFile[] findByUuid_PrevAndNext(
			long bulkOnbordingFileId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<BulkOnbordingFile>
				orderByComparator)
		throws NoSuchBulkOnbordingFileException;

	/**
	 * Removes all the bulk onbording files where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of bulk onbording files where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching bulk onbording files
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the bulk onbording file where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchBulkOnbordingFileException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a matching bulk onbording file could not be found
	 */
	public BulkOnbordingFile findByUUID_G(String uuid, long groupId)
		throws NoSuchBulkOnbordingFileException;

	/**
	 * Returns the bulk onbording file where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching bulk onbording file, or <code>null</code> if a matching bulk onbording file could not be found
	 */
	public BulkOnbordingFile fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the bulk onbording file where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching bulk onbording file, or <code>null</code> if a matching bulk onbording file could not be found
	 */
	public BulkOnbordingFile fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the bulk onbording file where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the bulk onbording file that was removed
	 */
	public BulkOnbordingFile removeByUUID_G(String uuid, long groupId)
		throws NoSuchBulkOnbordingFileException;

	/**
	 * Returns the number of bulk onbording files where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching bulk onbording files
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the bulk onbording files where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching bulk onbording files
	 */
	public java.util.List<BulkOnbordingFile> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<BulkOnbordingFile> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<BulkOnbordingFile> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BulkOnbordingFile>
			orderByComparator);

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
	public java.util.List<BulkOnbordingFile> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BulkOnbordingFile>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first bulk onbording file in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a matching bulk onbording file could not be found
	 */
	public BulkOnbordingFile findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<BulkOnbordingFile>
				orderByComparator)
		throws NoSuchBulkOnbordingFileException;

	/**
	 * Returns the first bulk onbording file in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bulk onbording file, or <code>null</code> if a matching bulk onbording file could not be found
	 */
	public BulkOnbordingFile fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<BulkOnbordingFile>
			orderByComparator);

	/**
	 * Returns the last bulk onbording file in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a matching bulk onbording file could not be found
	 */
	public BulkOnbordingFile findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<BulkOnbordingFile>
				orderByComparator)
		throws NoSuchBulkOnbordingFileException;

	/**
	 * Returns the last bulk onbording file in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bulk onbording file, or <code>null</code> if a matching bulk onbording file could not be found
	 */
	public BulkOnbordingFile fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<BulkOnbordingFile>
			orderByComparator);

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
	public BulkOnbordingFile[] findByUuid_C_PrevAndNext(
			long bulkOnbordingFileId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<BulkOnbordingFile>
				orderByComparator)
		throws NoSuchBulkOnbordingFileException;

	/**
	 * Removes all the bulk onbording files where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of bulk onbording files where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching bulk onbording files
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the bulk onbording files where bulkOnbordingFileId = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @return the matching bulk onbording files
	 */
	public java.util.List<BulkOnbordingFile> findByfileId(
		long bulkOnbordingFileId);

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
	public java.util.List<BulkOnbordingFile> findByfileId(
		long bulkOnbordingFileId, int start, int end);

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
	public java.util.List<BulkOnbordingFile> findByfileId(
		long bulkOnbordingFileId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BulkOnbordingFile>
			orderByComparator);

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
	public java.util.List<BulkOnbordingFile> findByfileId(
		long bulkOnbordingFileId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BulkOnbordingFile>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first bulk onbording file in the ordered set where bulkOnbordingFileId = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a matching bulk onbording file could not be found
	 */
	public BulkOnbordingFile findByfileId_First(
			long bulkOnbordingFileId,
			com.liferay.portal.kernel.util.OrderByComparator<BulkOnbordingFile>
				orderByComparator)
		throws NoSuchBulkOnbordingFileException;

	/**
	 * Returns the first bulk onbording file in the ordered set where bulkOnbordingFileId = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bulk onbording file, or <code>null</code> if a matching bulk onbording file could not be found
	 */
	public BulkOnbordingFile fetchByfileId_First(
		long bulkOnbordingFileId,
		com.liferay.portal.kernel.util.OrderByComparator<BulkOnbordingFile>
			orderByComparator);

	/**
	 * Returns the last bulk onbording file in the ordered set where bulkOnbordingFileId = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a matching bulk onbording file could not be found
	 */
	public BulkOnbordingFile findByfileId_Last(
			long bulkOnbordingFileId,
			com.liferay.portal.kernel.util.OrderByComparator<BulkOnbordingFile>
				orderByComparator)
		throws NoSuchBulkOnbordingFileException;

	/**
	 * Returns the last bulk onbording file in the ordered set where bulkOnbordingFileId = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bulk onbording file, or <code>null</code> if a matching bulk onbording file could not be found
	 */
	public BulkOnbordingFile fetchByfileId_Last(
		long bulkOnbordingFileId,
		com.liferay.portal.kernel.util.OrderByComparator<BulkOnbordingFile>
			orderByComparator);

	/**
	 * Removes all the bulk onbording files where bulkOnbordingFileId = &#63; from the database.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 */
	public void removeByfileId(long bulkOnbordingFileId);

	/**
	 * Returns the number of bulk onbording files where bulkOnbordingFileId = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @return the number of matching bulk onbording files
	 */
	public int countByfileId(long bulkOnbordingFileId);

	/**
	 * Returns all the bulk onbording files where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching bulk onbording files
	 */
	public java.util.List<BulkOnbordingFile> findByUserId(long userId);

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
	public java.util.List<BulkOnbordingFile> findByUserId(
		long userId, int start, int end);

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
	public java.util.List<BulkOnbordingFile> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BulkOnbordingFile>
			orderByComparator);

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
	public java.util.List<BulkOnbordingFile> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BulkOnbordingFile>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first bulk onbording file in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a matching bulk onbording file could not be found
	 */
	public BulkOnbordingFile findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<BulkOnbordingFile>
				orderByComparator)
		throws NoSuchBulkOnbordingFileException;

	/**
	 * Returns the first bulk onbording file in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bulk onbording file, or <code>null</code> if a matching bulk onbording file could not be found
	 */
	public BulkOnbordingFile fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<BulkOnbordingFile>
			orderByComparator);

	/**
	 * Returns the last bulk onbording file in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a matching bulk onbording file could not be found
	 */
	public BulkOnbordingFile findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<BulkOnbordingFile>
				orderByComparator)
		throws NoSuchBulkOnbordingFileException;

	/**
	 * Returns the last bulk onbording file in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bulk onbording file, or <code>null</code> if a matching bulk onbording file could not be found
	 */
	public BulkOnbordingFile fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<BulkOnbordingFile>
			orderByComparator);

	/**
	 * Returns the bulk onbording files before and after the current bulk onbording file in the ordered set where userId = &#63;.
	 *
	 * @param bulkOnbordingFileId the primary key of the current bulk onbording file
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a bulk onbording file with the primary key could not be found
	 */
	public BulkOnbordingFile[] findByUserId_PrevAndNext(
			long bulkOnbordingFileId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<BulkOnbordingFile>
				orderByComparator)
		throws NoSuchBulkOnbordingFileException;

	/**
	 * Removes all the bulk onbording files where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of bulk onbording files where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching bulk onbording files
	 */
	public int countByUserId(long userId);

	/**
	 * Returns all the bulk onbording files where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @return the matching bulk onbording files
	 */
	public java.util.List<BulkOnbordingFile> findByUnitId(Long unitId);

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
	public java.util.List<BulkOnbordingFile> findByUnitId(
		Long unitId, int start, int end);

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
	public java.util.List<BulkOnbordingFile> findByUnitId(
		Long unitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BulkOnbordingFile>
			orderByComparator);

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
	public java.util.List<BulkOnbordingFile> findByUnitId(
		Long unitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BulkOnbordingFile>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first bulk onbording file in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a matching bulk onbording file could not be found
	 */
	public BulkOnbordingFile findByUnitId_First(
			Long unitId,
			com.liferay.portal.kernel.util.OrderByComparator<BulkOnbordingFile>
				orderByComparator)
		throws NoSuchBulkOnbordingFileException;

	/**
	 * Returns the first bulk onbording file in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bulk onbording file, or <code>null</code> if a matching bulk onbording file could not be found
	 */
	public BulkOnbordingFile fetchByUnitId_First(
		Long unitId,
		com.liferay.portal.kernel.util.OrderByComparator<BulkOnbordingFile>
			orderByComparator);

	/**
	 * Returns the last bulk onbording file in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a matching bulk onbording file could not be found
	 */
	public BulkOnbordingFile findByUnitId_Last(
			Long unitId,
			com.liferay.portal.kernel.util.OrderByComparator<BulkOnbordingFile>
				orderByComparator)
		throws NoSuchBulkOnbordingFileException;

	/**
	 * Returns the last bulk onbording file in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bulk onbording file, or <code>null</code> if a matching bulk onbording file could not be found
	 */
	public BulkOnbordingFile fetchByUnitId_Last(
		Long unitId,
		com.liferay.portal.kernel.util.OrderByComparator<BulkOnbordingFile>
			orderByComparator);

	/**
	 * Returns the bulk onbording files before and after the current bulk onbording file in the ordered set where unitId = &#63;.
	 *
	 * @param bulkOnbordingFileId the primary key of the current bulk onbording file
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a bulk onbording file with the primary key could not be found
	 */
	public BulkOnbordingFile[] findByUnitId_PrevAndNext(
			long bulkOnbordingFileId, Long unitId,
			com.liferay.portal.kernel.util.OrderByComparator<BulkOnbordingFile>
				orderByComparator)
		throws NoSuchBulkOnbordingFileException;

	/**
	 * Removes all the bulk onbording files where unitId = &#63; from the database.
	 *
	 * @param unitId the unit ID
	 */
	public void removeByUnitId(Long unitId);

	/**
	 * Returns the number of bulk onbording files where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @return the number of matching bulk onbording files
	 */
	public int countByUnitId(Long unitId);

	/**
	 * Caches the bulk onbording file in the entity cache if it is enabled.
	 *
	 * @param bulkOnbordingFile the bulk onbording file
	 */
	public void cacheResult(BulkOnbordingFile bulkOnbordingFile);

	/**
	 * Caches the bulk onbording files in the entity cache if it is enabled.
	 *
	 * @param bulkOnbordingFiles the bulk onbording files
	 */
	public void cacheResult(
		java.util.List<BulkOnbordingFile> bulkOnbordingFiles);

	/**
	 * Creates a new bulk onbording file with the primary key. Does not add the bulk onbording file to the database.
	 *
	 * @param bulkOnbordingFileId the primary key for the new bulk onbording file
	 * @return the new bulk onbording file
	 */
	public BulkOnbordingFile create(long bulkOnbordingFileId);

	/**
	 * Removes the bulk onbording file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bulkOnbordingFileId the primary key of the bulk onbording file
	 * @return the bulk onbording file that was removed
	 * @throws NoSuchBulkOnbordingFileException if a bulk onbording file with the primary key could not be found
	 */
	public BulkOnbordingFile remove(long bulkOnbordingFileId)
		throws NoSuchBulkOnbordingFileException;

	public BulkOnbordingFile updateImpl(BulkOnbordingFile bulkOnbordingFile);

	/**
	 * Returns the bulk onbording file with the primary key or throws a <code>NoSuchBulkOnbordingFileException</code> if it could not be found.
	 *
	 * @param bulkOnbordingFileId the primary key of the bulk onbording file
	 * @return the bulk onbording file
	 * @throws NoSuchBulkOnbordingFileException if a bulk onbording file with the primary key could not be found
	 */
	public BulkOnbordingFile findByPrimaryKey(long bulkOnbordingFileId)
		throws NoSuchBulkOnbordingFileException;

	/**
	 * Returns the bulk onbording file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bulkOnbordingFileId the primary key of the bulk onbording file
	 * @return the bulk onbording file, or <code>null</code> if a bulk onbording file with the primary key could not be found
	 */
	public BulkOnbordingFile fetchByPrimaryKey(long bulkOnbordingFileId);

	/**
	 * Returns all the bulk onbording files.
	 *
	 * @return the bulk onbording files
	 */
	public java.util.List<BulkOnbordingFile> findAll();

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
	public java.util.List<BulkOnbordingFile> findAll(int start, int end);

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
	public java.util.List<BulkOnbordingFile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BulkOnbordingFile>
			orderByComparator);

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
	public java.util.List<BulkOnbordingFile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BulkOnbordingFile>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the bulk onbording files from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of bulk onbording files.
	 *
	 * @return the number of bulk onbording files
	 */
	public int countAll();

}