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

import com.adjecti.pis.liferay.exception.NoSuchSampleProcessRequestException;
import com.adjecti.pis.liferay.model.SampleProcessRequest;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the sample process request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SampleProcessRequestUtil
 * @generated
 */
@ProviderType
public interface SampleProcessRequestPersistence
	extends BasePersistence<SampleProcessRequest> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SampleProcessRequestUtil} to access the sample process request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the sample process requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching sample process requests
	 */
	public java.util.List<SampleProcessRequest> findByUuid(String uuid);

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
	public java.util.List<SampleProcessRequest> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<SampleProcessRequest> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleProcessRequest>
			orderByComparator);

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
	public java.util.List<SampleProcessRequest> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleProcessRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sample process request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample process request
	 * @throws NoSuchSampleProcessRequestException if a matching sample process request could not be found
	 */
	public SampleProcessRequest findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<SampleProcessRequest> orderByComparator)
		throws NoSuchSampleProcessRequestException;

	/**
	 * Returns the first sample process request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample process request, or <code>null</code> if a matching sample process request could not be found
	 */
	public SampleProcessRequest fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SampleProcessRequest>
			orderByComparator);

	/**
	 * Returns the last sample process request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample process request
	 * @throws NoSuchSampleProcessRequestException if a matching sample process request could not be found
	 */
	public SampleProcessRequest findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<SampleProcessRequest> orderByComparator)
		throws NoSuchSampleProcessRequestException;

	/**
	 * Returns the last sample process request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample process request, or <code>null</code> if a matching sample process request could not be found
	 */
	public SampleProcessRequest fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SampleProcessRequest>
			orderByComparator);

	/**
	 * Returns the sample process requests before and after the current sample process request in the ordered set where uuid = &#63;.
	 *
	 * @param sampleProcessRequestId the primary key of the current sample process request
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample process request
	 * @throws NoSuchSampleProcessRequestException if a sample process request with the primary key could not be found
	 */
	public SampleProcessRequest[] findByUuid_PrevAndNext(
			long sampleProcessRequestId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<SampleProcessRequest> orderByComparator)
		throws NoSuchSampleProcessRequestException;

	/**
	 * Removes all the sample process requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of sample process requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching sample process requests
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the sample process request where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSampleProcessRequestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sample process request
	 * @throws NoSuchSampleProcessRequestException if a matching sample process request could not be found
	 */
	public SampleProcessRequest findByUUID_G(String uuid, long groupId)
		throws NoSuchSampleProcessRequestException;

	/**
	 * Returns the sample process request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sample process request, or <code>null</code> if a matching sample process request could not be found
	 */
	public SampleProcessRequest fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the sample process request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sample process request, or <code>null</code> if a matching sample process request could not be found
	 */
	public SampleProcessRequest fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the sample process request where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the sample process request that was removed
	 */
	public SampleProcessRequest removeByUUID_G(String uuid, long groupId)
		throws NoSuchSampleProcessRequestException;

	/**
	 * Returns the number of sample process requests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching sample process requests
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the sample process requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching sample process requests
	 */
	public java.util.List<SampleProcessRequest> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<SampleProcessRequest> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<SampleProcessRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleProcessRequest>
			orderByComparator);

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
	public java.util.List<SampleProcessRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleProcessRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sample process request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample process request
	 * @throws NoSuchSampleProcessRequestException if a matching sample process request could not be found
	 */
	public SampleProcessRequest findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SampleProcessRequest> orderByComparator)
		throws NoSuchSampleProcessRequestException;

	/**
	 * Returns the first sample process request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample process request, or <code>null</code> if a matching sample process request could not be found
	 */
	public SampleProcessRequest fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SampleProcessRequest>
			orderByComparator);

	/**
	 * Returns the last sample process request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample process request
	 * @throws NoSuchSampleProcessRequestException if a matching sample process request could not be found
	 */
	public SampleProcessRequest findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SampleProcessRequest> orderByComparator)
		throws NoSuchSampleProcessRequestException;

	/**
	 * Returns the last sample process request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample process request, or <code>null</code> if a matching sample process request could not be found
	 */
	public SampleProcessRequest fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SampleProcessRequest>
			orderByComparator);

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
	public SampleProcessRequest[] findByUuid_C_PrevAndNext(
			long sampleProcessRequestId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SampleProcessRequest> orderByComparator)
		throws NoSuchSampleProcessRequestException;

	/**
	 * Removes all the sample process requests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of sample process requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching sample process requests
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the sample process requests where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @return the matching sample process requests
	 */
	public java.util.List<SampleProcessRequest> findByReviewerUserId(
		long reviewerUserId);

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
	public java.util.List<SampleProcessRequest> findByReviewerUserId(
		long reviewerUserId, int start, int end);

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
	public java.util.List<SampleProcessRequest> findByReviewerUserId(
		long reviewerUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleProcessRequest>
			orderByComparator);

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
	public java.util.List<SampleProcessRequest> findByReviewerUserId(
		long reviewerUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleProcessRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sample process request in the ordered set where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample process request
	 * @throws NoSuchSampleProcessRequestException if a matching sample process request could not be found
	 */
	public SampleProcessRequest findByReviewerUserId_First(
			long reviewerUserId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SampleProcessRequest> orderByComparator)
		throws NoSuchSampleProcessRequestException;

	/**
	 * Returns the first sample process request in the ordered set where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample process request, or <code>null</code> if a matching sample process request could not be found
	 */
	public SampleProcessRequest fetchByReviewerUserId_First(
		long reviewerUserId,
		com.liferay.portal.kernel.util.OrderByComparator<SampleProcessRequest>
			orderByComparator);

	/**
	 * Returns the last sample process request in the ordered set where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample process request
	 * @throws NoSuchSampleProcessRequestException if a matching sample process request could not be found
	 */
	public SampleProcessRequest findByReviewerUserId_Last(
			long reviewerUserId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SampleProcessRequest> orderByComparator)
		throws NoSuchSampleProcessRequestException;

	/**
	 * Returns the last sample process request in the ordered set where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample process request, or <code>null</code> if a matching sample process request could not be found
	 */
	public SampleProcessRequest fetchByReviewerUserId_Last(
		long reviewerUserId,
		com.liferay.portal.kernel.util.OrderByComparator<SampleProcessRequest>
			orderByComparator);

	/**
	 * Returns the sample process requests before and after the current sample process request in the ordered set where reviewerUserId = &#63;.
	 *
	 * @param sampleProcessRequestId the primary key of the current sample process request
	 * @param reviewerUserId the reviewer user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample process request
	 * @throws NoSuchSampleProcessRequestException if a sample process request with the primary key could not be found
	 */
	public SampleProcessRequest[] findByReviewerUserId_PrevAndNext(
			long sampleProcessRequestId, long reviewerUserId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SampleProcessRequest> orderByComparator)
		throws NoSuchSampleProcessRequestException;

	/**
	 * Removes all the sample process requests where reviewerUserId = &#63; from the database.
	 *
	 * @param reviewerUserId the reviewer user ID
	 */
	public void removeByReviewerUserId(long reviewerUserId);

	/**
	 * Returns the number of sample process requests where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @return the number of matching sample process requests
	 */
	public int countByReviewerUserId(long reviewerUserId);

	/**
	 * Returns all the sample process requests where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @return the matching sample process requests
	 */
	public java.util.List<SampleProcessRequest> findByApproverUserId(
		long approverUserId);

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
	public java.util.List<SampleProcessRequest> findByApproverUserId(
		long approverUserId, int start, int end);

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
	public java.util.List<SampleProcessRequest> findByApproverUserId(
		long approverUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleProcessRequest>
			orderByComparator);

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
	public java.util.List<SampleProcessRequest> findByApproverUserId(
		long approverUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleProcessRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sample process request in the ordered set where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample process request
	 * @throws NoSuchSampleProcessRequestException if a matching sample process request could not be found
	 */
	public SampleProcessRequest findByApproverUserId_First(
			long approverUserId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SampleProcessRequest> orderByComparator)
		throws NoSuchSampleProcessRequestException;

	/**
	 * Returns the first sample process request in the ordered set where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample process request, or <code>null</code> if a matching sample process request could not be found
	 */
	public SampleProcessRequest fetchByApproverUserId_First(
		long approverUserId,
		com.liferay.portal.kernel.util.OrderByComparator<SampleProcessRequest>
			orderByComparator);

	/**
	 * Returns the last sample process request in the ordered set where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample process request
	 * @throws NoSuchSampleProcessRequestException if a matching sample process request could not be found
	 */
	public SampleProcessRequest findByApproverUserId_Last(
			long approverUserId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SampleProcessRequest> orderByComparator)
		throws NoSuchSampleProcessRequestException;

	/**
	 * Returns the last sample process request in the ordered set where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample process request, or <code>null</code> if a matching sample process request could not be found
	 */
	public SampleProcessRequest fetchByApproverUserId_Last(
		long approverUserId,
		com.liferay.portal.kernel.util.OrderByComparator<SampleProcessRequest>
			orderByComparator);

	/**
	 * Returns the sample process requests before and after the current sample process request in the ordered set where approverUserId = &#63;.
	 *
	 * @param sampleProcessRequestId the primary key of the current sample process request
	 * @param approverUserId the approver user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample process request
	 * @throws NoSuchSampleProcessRequestException if a sample process request with the primary key could not be found
	 */
	public SampleProcessRequest[] findByApproverUserId_PrevAndNext(
			long sampleProcessRequestId, long approverUserId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SampleProcessRequest> orderByComparator)
		throws NoSuchSampleProcessRequestException;

	/**
	 * Removes all the sample process requests where approverUserId = &#63; from the database.
	 *
	 * @param approverUserId the approver user ID
	 */
	public void removeByApproverUserId(long approverUserId);

	/**
	 * Returns the number of sample process requests where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @return the number of matching sample process requests
	 */
	public int countByApproverUserId(long approverUserId);

	/**
	 * Caches the sample process request in the entity cache if it is enabled.
	 *
	 * @param sampleProcessRequest the sample process request
	 */
	public void cacheResult(SampleProcessRequest sampleProcessRequest);

	/**
	 * Caches the sample process requests in the entity cache if it is enabled.
	 *
	 * @param sampleProcessRequests the sample process requests
	 */
	public void cacheResult(
		java.util.List<SampleProcessRequest> sampleProcessRequests);

	/**
	 * Creates a new sample process request with the primary key. Does not add the sample process request to the database.
	 *
	 * @param sampleProcessRequestId the primary key for the new sample process request
	 * @return the new sample process request
	 */
	public SampleProcessRequest create(long sampleProcessRequestId);

	/**
	 * Removes the sample process request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sampleProcessRequestId the primary key of the sample process request
	 * @return the sample process request that was removed
	 * @throws NoSuchSampleProcessRequestException if a sample process request with the primary key could not be found
	 */
	public SampleProcessRequest remove(long sampleProcessRequestId)
		throws NoSuchSampleProcessRequestException;

	public SampleProcessRequest updateImpl(
		SampleProcessRequest sampleProcessRequest);

	/**
	 * Returns the sample process request with the primary key or throws a <code>NoSuchSampleProcessRequestException</code> if it could not be found.
	 *
	 * @param sampleProcessRequestId the primary key of the sample process request
	 * @return the sample process request
	 * @throws NoSuchSampleProcessRequestException if a sample process request with the primary key could not be found
	 */
	public SampleProcessRequest findByPrimaryKey(long sampleProcessRequestId)
		throws NoSuchSampleProcessRequestException;

	/**
	 * Returns the sample process request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sampleProcessRequestId the primary key of the sample process request
	 * @return the sample process request, or <code>null</code> if a sample process request with the primary key could not be found
	 */
	public SampleProcessRequest fetchByPrimaryKey(long sampleProcessRequestId);

	/**
	 * Returns all the sample process requests.
	 *
	 * @return the sample process requests
	 */
	public java.util.List<SampleProcessRequest> findAll();

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
	public java.util.List<SampleProcessRequest> findAll(int start, int end);

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
	public java.util.List<SampleProcessRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleProcessRequest>
			orderByComparator);

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
	public java.util.List<SampleProcessRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleProcessRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the sample process requests from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of sample process requests.
	 *
	 * @return the number of sample process requests
	 */
	public int countAll();

}