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

import com.adjecti.pis.exception.NoSuchRegistrationRequestException;
import com.adjecti.pis.model.RegistrationRequest;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the registration request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RegistrationRequestUtil
 * @generated
 */
@ProviderType
public interface RegistrationRequestPersistence
	extends BasePersistence<RegistrationRequest> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RegistrationRequestUtil} to access the registration request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the registration requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching registration requests
	 */
	public java.util.List<RegistrationRequest> findByUuid(String uuid);

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
	public java.util.List<RegistrationRequest> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<RegistrationRequest> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

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
	public java.util.List<RegistrationRequest> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first registration request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public RegistrationRequest findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns the first registration request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public RegistrationRequest fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

	/**
	 * Returns the last registration request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public RegistrationRequest findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns the last registration request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public RegistrationRequest fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where uuid = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	public RegistrationRequest[] findByUuid_PrevAndNext(
			long registrationRequestId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Removes all the registration requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of registration requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching registration requests
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the registration request where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchRegistrationRequestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public RegistrationRequest findByUUID_G(String uuid, long groupId)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns the registration request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public RegistrationRequest fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the registration request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public RegistrationRequest fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the registration request where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the registration request that was removed
	 */
	public RegistrationRequest removeByUUID_G(String uuid, long groupId)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns the number of registration requests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching registration requests
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the registration requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching registration requests
	 */
	public java.util.List<RegistrationRequest> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<RegistrationRequest> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<RegistrationRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

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
	public java.util.List<RegistrationRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first registration request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public RegistrationRequest findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns the first registration request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public RegistrationRequest fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

	/**
	 * Returns the last registration request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public RegistrationRequest findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns the last registration request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public RegistrationRequest fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

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
	public RegistrationRequest[] findByUuid_C_PrevAndNext(
			long registrationRequestId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Removes all the registration requests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of registration requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching registration requests
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the registration requests where bulkOnbordingFileId = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @return the matching registration requests
	 */
	public java.util.List<RegistrationRequest> findByBulkOnbordingFileId(
		long bulkOnbordingFileId);

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
	public java.util.List<RegistrationRequest> findByBulkOnbordingFileId(
		long bulkOnbordingFileId, int start, int end);

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
	public java.util.List<RegistrationRequest> findByBulkOnbordingFileId(
		long bulkOnbordingFileId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

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
	public java.util.List<RegistrationRequest> findByBulkOnbordingFileId(
		long bulkOnbordingFileId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first registration request in the ordered set where bulkOnbordingFileId = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public RegistrationRequest findByBulkOnbordingFileId_First(
			long bulkOnbordingFileId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns the first registration request in the ordered set where bulkOnbordingFileId = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public RegistrationRequest fetchByBulkOnbordingFileId_First(
		long bulkOnbordingFileId,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

	/**
	 * Returns the last registration request in the ordered set where bulkOnbordingFileId = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public RegistrationRequest findByBulkOnbordingFileId_Last(
			long bulkOnbordingFileId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns the last registration request in the ordered set where bulkOnbordingFileId = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public RegistrationRequest fetchByBulkOnbordingFileId_Last(
		long bulkOnbordingFileId,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where bulkOnbordingFileId = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	public RegistrationRequest[] findByBulkOnbordingFileId_PrevAndNext(
			long registrationRequestId, long bulkOnbordingFileId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Removes all the registration requests where bulkOnbordingFileId = &#63; from the database.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 */
	public void removeByBulkOnbordingFileId(long bulkOnbordingFileId);

	/**
	 * Returns the number of registration requests where bulkOnbordingFileId = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @return the number of matching registration requests
	 */
	public int countByBulkOnbordingFileId(long bulkOnbordingFileId);

	/**
	 * Returns all the registration requests where bulkOnbordingFileId = &#63; and status = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param status the status
	 * @return the matching registration requests
	 */
	public java.util.List<RegistrationRequest>
		findByBulkOnbordingFileIdAndStatus(
			long bulkOnbordingFileId, int status);

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
	public java.util.List<RegistrationRequest>
		findByBulkOnbordingFileIdAndStatus(
			long bulkOnbordingFileId, int status, int start, int end);

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
	public java.util.List<RegistrationRequest>
		findByBulkOnbordingFileIdAndStatus(
			long bulkOnbordingFileId, int status, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator);

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
	public java.util.List<RegistrationRequest>
		findByBulkOnbordingFileIdAndStatus(
			long bulkOnbordingFileId, int status, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first registration request in the ordered set where bulkOnbordingFileId = &#63; and status = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public RegistrationRequest findByBulkOnbordingFileIdAndStatus_First(
			long bulkOnbordingFileId, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns the first registration request in the ordered set where bulkOnbordingFileId = &#63; and status = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public RegistrationRequest fetchByBulkOnbordingFileIdAndStatus_First(
		long bulkOnbordingFileId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

	/**
	 * Returns the last registration request in the ordered set where bulkOnbordingFileId = &#63; and status = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public RegistrationRequest findByBulkOnbordingFileIdAndStatus_Last(
			long bulkOnbordingFileId, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns the last registration request in the ordered set where bulkOnbordingFileId = &#63; and status = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public RegistrationRequest fetchByBulkOnbordingFileIdAndStatus_Last(
		long bulkOnbordingFileId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

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
	public RegistrationRequest[] findByBulkOnbordingFileIdAndStatus_PrevAndNext(
			long registrationRequestId, long bulkOnbordingFileId, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Removes all the registration requests where bulkOnbordingFileId = &#63; and status = &#63; from the database.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param status the status
	 */
	public void removeByBulkOnbordingFileIdAndStatus(
		long bulkOnbordingFileId, int status);

	/**
	 * Returns the number of registration requests where bulkOnbordingFileId = &#63; and status = &#63;.
	 *
	 * @param bulkOnbordingFileId the bulk onbording file ID
	 * @param status the status
	 * @return the number of matching registration requests
	 */
	public int countByBulkOnbordingFileIdAndStatus(
		long bulkOnbordingFileId, int status);

	/**
	 * Returns all the registration requests where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching registration requests
	 */
	public java.util.List<RegistrationRequest> findByStatus(int status);

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
	public java.util.List<RegistrationRequest> findByStatus(
		int status, int start, int end);

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
	public java.util.List<RegistrationRequest> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

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
	public java.util.List<RegistrationRequest> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first registration request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public RegistrationRequest findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns the first registration request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public RegistrationRequest fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

	/**
	 * Returns the last registration request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public RegistrationRequest findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns the last registration request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public RegistrationRequest fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where status = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	public RegistrationRequest[] findByStatus_PrevAndNext(
			long registrationRequestId, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Removes all the registration requests where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of registration requests where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching registration requests
	 */
	public int countByStatus(int status);

	/**
	 * Returns all the registration requests where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @return the matching registration requests
	 */
	public java.util.List<RegistrationRequest> findByUnitId(long unitId);

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
	public java.util.List<RegistrationRequest> findByUnitId(
		long unitId, int start, int end);

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
	public java.util.List<RegistrationRequest> findByUnitId(
		long unitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

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
	public java.util.List<RegistrationRequest> findByUnitId(
		long unitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first registration request in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public RegistrationRequest findByUnitId_First(
			long unitId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns the first registration request in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public RegistrationRequest fetchByUnitId_First(
		long unitId,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

	/**
	 * Returns the last registration request in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public RegistrationRequest findByUnitId_Last(
			long unitId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns the last registration request in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public RegistrationRequest fetchByUnitId_Last(
		long unitId,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where unitId = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	public RegistrationRequest[] findByUnitId_PrevAndNext(
			long registrationRequestId, long unitId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Removes all the registration requests where unitId = &#63; from the database.
	 *
	 * @param unitId the unit ID
	 */
	public void removeByUnitId(long unitId);

	/**
	 * Returns the number of registration requests where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @return the number of matching registration requests
	 */
	public int countByUnitId(long unitId);

	/**
	 * Returns all the registration requests where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @return the matching registration requests
	 */
	public java.util.List<RegistrationRequest> findByUnitIdAndStatus(
		long unitId, int status);

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
	public java.util.List<RegistrationRequest> findByUnitIdAndStatus(
		long unitId, int status, int start, int end);

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
	public java.util.List<RegistrationRequest> findByUnitIdAndStatus(
		long unitId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

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
	public java.util.List<RegistrationRequest> findByUnitIdAndStatus(
		long unitId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first registration request in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public RegistrationRequest findByUnitIdAndStatus_First(
			long unitId, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns the first registration request in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public RegistrationRequest fetchByUnitIdAndStatus_First(
		long unitId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

	/**
	 * Returns the last registration request in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public RegistrationRequest findByUnitIdAndStatus_Last(
			long unitId, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns the last registration request in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public RegistrationRequest fetchByUnitIdAndStatus_Last(
		long unitId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

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
	public RegistrationRequest[] findByUnitIdAndStatus_PrevAndNext(
			long registrationRequestId, long unitId, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Removes all the registration requests where unitId = &#63; and status = &#63; from the database.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 */
	public void removeByUnitIdAndStatus(long unitId, int status);

	/**
	 * Returns the number of registration requests where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @return the number of matching registration requests
	 */
	public int countByUnitIdAndStatus(long unitId, int status);

	/**
	 * Returns all the registration requests where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @return the matching registration requests
	 */
	public java.util.List<RegistrationRequest> findByUnitIdsAndStatusList(
		long unitId, int status);

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
	public java.util.List<RegistrationRequest> findByUnitIdsAndStatusList(
		long unitId, int status, int start, int end);

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
	public java.util.List<RegistrationRequest> findByUnitIdsAndStatusList(
		long unitId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

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
	public java.util.List<RegistrationRequest> findByUnitIdsAndStatusList(
		long unitId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first registration request in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public RegistrationRequest findByUnitIdsAndStatusList_First(
			long unitId, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns the first registration request in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public RegistrationRequest fetchByUnitIdsAndStatusList_First(
		long unitId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

	/**
	 * Returns the last registration request in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public RegistrationRequest findByUnitIdsAndStatusList_Last(
			long unitId, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns the last registration request in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public RegistrationRequest fetchByUnitIdsAndStatusList_Last(
		long unitId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

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
	public RegistrationRequest[] findByUnitIdsAndStatusList_PrevAndNext(
			long registrationRequestId, long unitId, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

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
	public java.util.List<RegistrationRequest> findByUnitIdsAndStatusList(
		long[] unitIds, int[] statuses);

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
	public java.util.List<RegistrationRequest> findByUnitIdsAndStatusList(
		long[] unitIds, int[] statuses, int start, int end);

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
	public java.util.List<RegistrationRequest> findByUnitIdsAndStatusList(
		long[] unitIds, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

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
	public java.util.List<RegistrationRequest> findByUnitIdsAndStatusList(
		long[] unitIds, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the registration requests where unitId = &#63; and status = &#63; from the database.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 */
	public void removeByUnitIdsAndStatusList(long unitId, int status);

	/**
	 * Returns the number of registration requests where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @return the number of matching registration requests
	 */
	public int countByUnitIdsAndStatusList(long unitId, int status);

	/**
	 * Returns the number of registration requests where unitId = any &#63; and status = any &#63;.
	 *
	 * @param unitIds the unit IDs
	 * @param statuses the statuses
	 * @return the number of matching registration requests
	 */
	public int countByUnitIdsAndStatusList(long[] unitIds, int[] statuses);

	/**
	 * Returns all the registration requests where unitId = &#63; and state = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @return the matching registration requests
	 */
	public java.util.List<RegistrationRequest> findByUnitIdAndState(
		long unitId, String state);

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
	public java.util.List<RegistrationRequest> findByUnitIdAndState(
		long unitId, String state, int start, int end);

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
	public java.util.List<RegistrationRequest> findByUnitIdAndState(
		long unitId, String state, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

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
	public java.util.List<RegistrationRequest> findByUnitIdAndState(
		long unitId, String state, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first registration request in the ordered set where unitId = &#63; and state = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public RegistrationRequest findByUnitIdAndState_First(
			long unitId, String state,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns the first registration request in the ordered set where unitId = &#63; and state = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public RegistrationRequest fetchByUnitIdAndState_First(
		long unitId, String state,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

	/**
	 * Returns the last registration request in the ordered set where unitId = &#63; and state = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public RegistrationRequest findByUnitIdAndState_Last(
			long unitId, String state,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns the last registration request in the ordered set where unitId = &#63; and state = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public RegistrationRequest fetchByUnitIdAndState_Last(
		long unitId, String state,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

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
	public RegistrationRequest[] findByUnitIdAndState_PrevAndNext(
			long registrationRequestId, long unitId, String state,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Removes all the registration requests where unitId = &#63; and state = &#63; from the database.
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 */
	public void removeByUnitIdAndState(long unitId, String state);

	/**
	 * Returns the number of registration requests where unitId = &#63; and state = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @return the number of matching registration requests
	 */
	public int countByUnitIdAndState(long unitId, String state);

	/**
	 * Returns all the registration requests where unit = &#63;.
	 *
	 * @param unit the unit
	 * @return the matching registration requests
	 */
	public java.util.List<RegistrationRequest> findByUnit(String unit);

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
	public java.util.List<RegistrationRequest> findByUnit(
		String unit, int start, int end);

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
	public java.util.List<RegistrationRequest> findByUnit(
		String unit, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

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
	public java.util.List<RegistrationRequest> findByUnit(
		String unit, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first registration request in the ordered set where unit = &#63;.
	 *
	 * @param unit the unit
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public RegistrationRequest findByUnit_First(
			String unit,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns the first registration request in the ordered set where unit = &#63;.
	 *
	 * @param unit the unit
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public RegistrationRequest fetchByUnit_First(
		String unit,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

	/**
	 * Returns the last registration request in the ordered set where unit = &#63;.
	 *
	 * @param unit the unit
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public RegistrationRequest findByUnit_Last(
			String unit,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns the last registration request in the ordered set where unit = &#63;.
	 *
	 * @param unit the unit
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public RegistrationRequest fetchByUnit_Last(
		String unit,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where unit = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param unit the unit
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	public RegistrationRequest[] findByUnit_PrevAndNext(
			long registrationRequestId, String unit,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Removes all the registration requests where unit = &#63; from the database.
	 *
	 * @param unit the unit
	 */
	public void removeByUnit(String unit);

	/**
	 * Returns the number of registration requests where unit = &#63;.
	 *
	 * @param unit the unit
	 * @return the number of matching registration requests
	 */
	public int countByUnit(String unit);

	/**
	 * Returns all the registration requests where unit = &#63; and status = &#63;.
	 *
	 * @param unit the unit
	 * @param status the status
	 * @return the matching registration requests
	 */
	public java.util.List<RegistrationRequest> findByUnitAndStatus(
		String unit, int status);

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
	public java.util.List<RegistrationRequest> findByUnitAndStatus(
		String unit, int status, int start, int end);

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
	public java.util.List<RegistrationRequest> findByUnitAndStatus(
		String unit, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

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
	public java.util.List<RegistrationRequest> findByUnitAndStatus(
		String unit, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first registration request in the ordered set where unit = &#63; and status = &#63;.
	 *
	 * @param unit the unit
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public RegistrationRequest findByUnitAndStatus_First(
			String unit, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns the first registration request in the ordered set where unit = &#63; and status = &#63;.
	 *
	 * @param unit the unit
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public RegistrationRequest fetchByUnitAndStatus_First(
		String unit, int status,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

	/**
	 * Returns the last registration request in the ordered set where unit = &#63; and status = &#63;.
	 *
	 * @param unit the unit
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public RegistrationRequest findByUnitAndStatus_Last(
			String unit, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns the last registration request in the ordered set where unit = &#63; and status = &#63;.
	 *
	 * @param unit the unit
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public RegistrationRequest fetchByUnitAndStatus_Last(
		String unit, int status,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

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
	public RegistrationRequest[] findByUnitAndStatus_PrevAndNext(
			long registrationRequestId, String unit, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Removes all the registration requests where unit = &#63; and status = &#63; from the database.
	 *
	 * @param unit the unit
	 * @param status the status
	 */
	public void removeByUnitAndStatus(String unit, int status);

	/**
	 * Returns the number of registration requests where unit = &#63; and status = &#63;.
	 *
	 * @param unit the unit
	 * @param status the status
	 * @return the number of matching registration requests
	 */
	public int countByUnitAndStatus(String unit, int status);

	/**
	 * Returns all the registration requests where unit = &#63; and state = &#63;.
	 *
	 * @param unit the unit
	 * @param state the state
	 * @return the matching registration requests
	 */
	public java.util.List<RegistrationRequest> findByUnitAndState(
		String unit, String state);

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
	public java.util.List<RegistrationRequest> findByUnitAndState(
		String unit, String state, int start, int end);

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
	public java.util.List<RegistrationRequest> findByUnitAndState(
		String unit, String state, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

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
	public java.util.List<RegistrationRequest> findByUnitAndState(
		String unit, String state, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first registration request in the ordered set where unit = &#63; and state = &#63;.
	 *
	 * @param unit the unit
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public RegistrationRequest findByUnitAndState_First(
			String unit, String state,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns the first registration request in the ordered set where unit = &#63; and state = &#63;.
	 *
	 * @param unit the unit
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public RegistrationRequest fetchByUnitAndState_First(
		String unit, String state,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

	/**
	 * Returns the last registration request in the ordered set where unit = &#63; and state = &#63;.
	 *
	 * @param unit the unit
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public RegistrationRequest findByUnitAndState_Last(
			String unit, String state,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns the last registration request in the ordered set where unit = &#63; and state = &#63;.
	 *
	 * @param unit the unit
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public RegistrationRequest fetchByUnitAndState_Last(
		String unit, String state,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

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
	public RegistrationRequest[] findByUnitAndState_PrevAndNext(
			long registrationRequestId, String unit, String state,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Removes all the registration requests where unit = &#63; and state = &#63; from the database.
	 *
	 * @param unit the unit
	 * @param state the state
	 */
	public void removeByUnitAndState(String unit, String state);

	/**
	 * Returns the number of registration requests where unit = &#63; and state = &#63;.
	 *
	 * @param unit the unit
	 * @param state the state
	 * @return the number of matching registration requests
	 */
	public int countByUnitAndState(String unit, String state);

	/**
	 * Returns all the registration requests where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching registration requests
	 */
	public java.util.List<RegistrationRequest> findByG_S(
		long groupId, int status);

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
	public java.util.List<RegistrationRequest> findByG_S(
		long groupId, int status, int start, int end);

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
	public java.util.List<RegistrationRequest> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

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
	public java.util.List<RegistrationRequest> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first registration request in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public RegistrationRequest findByG_S_First(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns the first registration request in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public RegistrationRequest fetchByG_S_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

	/**
	 * Returns the last registration request in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public RegistrationRequest findByG_S_Last(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns the last registration request in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public RegistrationRequest fetchByG_S_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

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
	public RegistrationRequest[] findByG_S_PrevAndNext(
			long registrationRequestId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns all the registration requests that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching registration requests that the user has permission to view
	 */
	public java.util.List<RegistrationRequest> filterFindByG_S(
		long groupId, int status);

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
	public java.util.List<RegistrationRequest> filterFindByG_S(
		long groupId, int status, int start, int end);

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
	public java.util.List<RegistrationRequest> filterFindByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

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
	public RegistrationRequest[] filterFindByG_S_PrevAndNext(
			long registrationRequestId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Removes all the registration requests where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public void removeByG_S(long groupId, int status);

	/**
	 * Returns the number of registration requests where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching registration requests
	 */
	public int countByG_S(long groupId, int status);

	/**
	 * Returns the number of registration requests that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching registration requests that the user has permission to view
	 */
	public int filterCountByG_S(long groupId, int status);

	/**
	 * Returns all the registration requests where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching registration requests
	 */
	public java.util.List<RegistrationRequest> findByGroupId(long groupId);

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
	public java.util.List<RegistrationRequest> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<RegistrationRequest> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

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
	public java.util.List<RegistrationRequest> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first registration request in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public RegistrationRequest findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns the first registration request in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public RegistrationRequest fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

	/**
	 * Returns the last registration request in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public RegistrationRequest findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns the last registration request in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public RegistrationRequest fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where groupId = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	public RegistrationRequest[] findByGroupId_PrevAndNext(
			long registrationRequestId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns all the registration requests that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching registration requests that the user has permission to view
	 */
	public java.util.List<RegistrationRequest> filterFindByGroupId(
		long groupId);

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
	public java.util.List<RegistrationRequest> filterFindByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<RegistrationRequest> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set of registration requests that the user has permission to view where groupId = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	public RegistrationRequest[] filterFindByGroupId_PrevAndNext(
			long registrationRequestId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Removes all the registration requests where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of registration requests where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching registration requests
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the number of registration requests that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching registration requests that the user has permission to view
	 */
	public int filterCountByGroupId(long groupId);

	/**
	 * Returns all the registration requests where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching registration requests
	 */
	public java.util.List<RegistrationRequest> findByUserId(long userId);

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
	public java.util.List<RegistrationRequest> findByUserId(
		long userId, int start, int end);

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
	public java.util.List<RegistrationRequest> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

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
	public java.util.List<RegistrationRequest> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first registration request in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public RegistrationRequest findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns the first registration request in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public RegistrationRequest fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

	/**
	 * Returns the last registration request in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public RegistrationRequest findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns the last registration request in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public RegistrationRequest fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where userId = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	public RegistrationRequest[] findByUserId_PrevAndNext(
			long registrationRequestId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Removes all the registration requests where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of registration requests where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching registration requests
	 */
	public int countByUserId(long userId);

	/**
	 * Returns all the registration requests where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @return the matching registration requests
	 */
	public java.util.List<RegistrationRequest> findByPersonalNo(
		long personalNo);

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
	public java.util.List<RegistrationRequest> findByPersonalNo(
		long personalNo, int start, int end);

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
	public java.util.List<RegistrationRequest> findByPersonalNo(
		long personalNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

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
	public java.util.List<RegistrationRequest> findByPersonalNo(
		long personalNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first registration request in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public RegistrationRequest findByPersonalNo_First(
			long personalNo,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns the first registration request in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public RegistrationRequest fetchByPersonalNo_First(
		long personalNo,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

	/**
	 * Returns the last registration request in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public RegistrationRequest findByPersonalNo_Last(
			long personalNo,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns the last registration request in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public RegistrationRequest fetchByPersonalNo_Last(
		long personalNo,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where personalNo = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	public RegistrationRequest[] findByPersonalNo_PrevAndNext(
			long registrationRequestId, long personalNo,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Removes all the registration requests where personalNo = &#63; from the database.
	 *
	 * @param personalNo the personal no
	 */
	public void removeByPersonalNo(long personalNo);

	/**
	 * Returns the number of registration requests where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @return the number of matching registration requests
	 */
	public int countByPersonalNo(long personalNo);

	/**
	 * Returns all the registration requests where recordNo = &#63;.
	 *
	 * @param recordNo the record no
	 * @return the matching registration requests
	 */
	public java.util.List<RegistrationRequest> findByRecordNo(long recordNo);

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
	public java.util.List<RegistrationRequest> findByRecordNo(
		long recordNo, int start, int end);

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
	public java.util.List<RegistrationRequest> findByRecordNo(
		long recordNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

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
	public java.util.List<RegistrationRequest> findByRecordNo(
		long recordNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first registration request in the ordered set where recordNo = &#63;.
	 *
	 * @param recordNo the record no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public RegistrationRequest findByRecordNo_First(
			long recordNo,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns the first registration request in the ordered set where recordNo = &#63;.
	 *
	 * @param recordNo the record no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public RegistrationRequest fetchByRecordNo_First(
		long recordNo,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

	/**
	 * Returns the last registration request in the ordered set where recordNo = &#63;.
	 *
	 * @param recordNo the record no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public RegistrationRequest findByRecordNo_Last(
			long recordNo,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns the last registration request in the ordered set where recordNo = &#63;.
	 *
	 * @param recordNo the record no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public RegistrationRequest fetchByRecordNo_Last(
		long recordNo,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where recordNo = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param recordNo the record no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	public RegistrationRequest[] findByRecordNo_PrevAndNext(
			long registrationRequestId, long recordNo,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Removes all the registration requests where recordNo = &#63; from the database.
	 *
	 * @param recordNo the record no
	 */
	public void removeByRecordNo(long recordNo);

	/**
	 * Returns the number of registration requests where recordNo = &#63;.
	 *
	 * @param recordNo the record no
	 * @return the number of matching registration requests
	 */
	public int countByRecordNo(long recordNo);

	/**
	 * Returns all the registration requests where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the matching registration requests
	 */
	public java.util.List<RegistrationRequest> findByEmailAddress(
		String emailAddress);

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
	public java.util.List<RegistrationRequest> findByEmailAddress(
		String emailAddress, int start, int end);

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
	public java.util.List<RegistrationRequest> findByEmailAddress(
		String emailAddress, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

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
	public java.util.List<RegistrationRequest> findByEmailAddress(
		String emailAddress, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first registration request in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public RegistrationRequest findByEmailAddress_First(
			String emailAddress,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns the first registration request in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public RegistrationRequest fetchByEmailAddress_First(
		String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

	/**
	 * Returns the last registration request in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public RegistrationRequest findByEmailAddress_Last(
			String emailAddress,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns the last registration request in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public RegistrationRequest fetchByEmailAddress_Last(
		String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

	/**
	 * Returns the registration requests before and after the current registration request in the ordered set where emailAddress = &#63;.
	 *
	 * @param registrationRequestId the primary key of the current registration request
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	public RegistrationRequest[] findByEmailAddress_PrevAndNext(
			long registrationRequestId, String emailAddress,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Removes all the registration requests where emailAddress = &#63; from the database.
	 *
	 * @param emailAddress the email address
	 */
	public void removeByEmailAddress(String emailAddress);

	/**
	 * Returns the number of registration requests where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the number of matching registration requests
	 */
	public int countByEmailAddress(String emailAddress);

	/**
	 * Returns all the registration requests where loginId = &#63; and status = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @return the matching registration requests
	 */
	public java.util.List<RegistrationRequest> findByLoginIdAndStatus(
		String loginId, int status);

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
	public java.util.List<RegistrationRequest> findByLoginIdAndStatus(
		String loginId, int status, int start, int end);

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
	public java.util.List<RegistrationRequest> findByLoginIdAndStatus(
		String loginId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

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
	public java.util.List<RegistrationRequest> findByLoginIdAndStatus(
		String loginId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first registration request in the ordered set where loginId = &#63; and status = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public RegistrationRequest findByLoginIdAndStatus_First(
			String loginId, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns the first registration request in the ordered set where loginId = &#63; and status = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public RegistrationRequest fetchByLoginIdAndStatus_First(
		String loginId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

	/**
	 * Returns the last registration request in the ordered set where loginId = &#63; and status = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request
	 * @throws NoSuchRegistrationRequestException if a matching registration request could not be found
	 */
	public RegistrationRequest findByLoginIdAndStatus_Last(
			String loginId, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns the last registration request in the ordered set where loginId = &#63; and status = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching registration request, or <code>null</code> if a matching registration request could not be found
	 */
	public RegistrationRequest fetchByLoginIdAndStatus_Last(
		String loginId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

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
	public RegistrationRequest[] findByLoginIdAndStatus_PrevAndNext(
			long registrationRequestId, String loginId, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Removes all the registration requests where loginId = &#63; and status = &#63; from the database.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 */
	public void removeByLoginIdAndStatus(String loginId, int status);

	/**
	 * Returns the number of registration requests where loginId = &#63; and status = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @return the number of matching registration requests
	 */
	public int countByLoginIdAndStatus(String loginId, int status);

	/**
	 * Returns all the registration requests where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @return the matching registration requests
	 */
	public java.util.List<RegistrationRequest>
		findByLoginIdStatusStateAndIdamUserCreated(
			String loginId, int status, String state, boolean idamUserCreated);

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
	public java.util.List<RegistrationRequest>
		findByLoginIdStatusStateAndIdamUserCreated(
			String loginId, int status, String state, boolean idamUserCreated,
			int start, int end);

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
	public java.util.List<RegistrationRequest>
		findByLoginIdStatusStateAndIdamUserCreated(
			String loginId, int status, String state, boolean idamUserCreated,
			int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator);

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
	public java.util.List<RegistrationRequest>
		findByLoginIdStatusStateAndIdamUserCreated(
			String loginId, int status, String state, boolean idamUserCreated,
			int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator,
			boolean useFinderCache);

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
	public RegistrationRequest findByLoginIdStatusStateAndIdamUserCreated_First(
			String loginId, int status, String state, boolean idamUserCreated,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

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
	public RegistrationRequest
		fetchByLoginIdStatusStateAndIdamUserCreated_First(
			String loginId, int status, String state, boolean idamUserCreated,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator);

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
	public RegistrationRequest findByLoginIdStatusStateAndIdamUserCreated_Last(
			String loginId, int status, String state, boolean idamUserCreated,
			com.liferay.portal.kernel.util.OrderByComparator
				<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

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
	public RegistrationRequest fetchByLoginIdStatusStateAndIdamUserCreated_Last(
		String loginId, int status, String state, boolean idamUserCreated,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

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
	public RegistrationRequest[]
			findByLoginIdStatusStateAndIdamUserCreated_PrevAndNext(
				long registrationRequestId, String loginId, int status,
				String state, boolean idamUserCreated,
				com.liferay.portal.kernel.util.OrderByComparator
					<RegistrationRequest> orderByComparator)
		throws NoSuchRegistrationRequestException;

	/**
	 * Removes all the registration requests where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63; from the database.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 */
	public void removeByLoginIdStatusStateAndIdamUserCreated(
		String loginId, int status, String state, boolean idamUserCreated);

	/**
	 * Returns the number of registration requests where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @return the number of matching registration requests
	 */
	public int countByLoginIdStatusStateAndIdamUserCreated(
		String loginId, int status, String state, boolean idamUserCreated);

	/**
	 * Caches the registration request in the entity cache if it is enabled.
	 *
	 * @param registrationRequest the registration request
	 */
	public void cacheResult(RegistrationRequest registrationRequest);

	/**
	 * Caches the registration requests in the entity cache if it is enabled.
	 *
	 * @param registrationRequests the registration requests
	 */
	public void cacheResult(
		java.util.List<RegistrationRequest> registrationRequests);

	/**
	 * Creates a new registration request with the primary key. Does not add the registration request to the database.
	 *
	 * @param registrationRequestId the primary key for the new registration request
	 * @return the new registration request
	 */
	public RegistrationRequest create(long registrationRequestId);

	/**
	 * Removes the registration request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param registrationRequestId the primary key of the registration request
	 * @return the registration request that was removed
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	public RegistrationRequest remove(long registrationRequestId)
		throws NoSuchRegistrationRequestException;

	public RegistrationRequest updateImpl(
		RegistrationRequest registrationRequest);

	/**
	 * Returns the registration request with the primary key or throws a <code>NoSuchRegistrationRequestException</code> if it could not be found.
	 *
	 * @param registrationRequestId the primary key of the registration request
	 * @return the registration request
	 * @throws NoSuchRegistrationRequestException if a registration request with the primary key could not be found
	 */
	public RegistrationRequest findByPrimaryKey(long registrationRequestId)
		throws NoSuchRegistrationRequestException;

	/**
	 * Returns the registration request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param registrationRequestId the primary key of the registration request
	 * @return the registration request, or <code>null</code> if a registration request with the primary key could not be found
	 */
	public RegistrationRequest fetchByPrimaryKey(long registrationRequestId);

	/**
	 * Returns all the registration requests.
	 *
	 * @return the registration requests
	 */
	public java.util.List<RegistrationRequest> findAll();

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
	public java.util.List<RegistrationRequest> findAll(int start, int end);

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
	public java.util.List<RegistrationRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator);

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
	public java.util.List<RegistrationRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RegistrationRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the registration requests from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of registration requests.
	 *
	 * @return the number of registration requests
	 */
	public int countAll();

}