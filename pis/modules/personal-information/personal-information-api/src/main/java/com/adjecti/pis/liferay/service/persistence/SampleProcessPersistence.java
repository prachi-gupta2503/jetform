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

import com.adjecti.pis.liferay.exception.NoSuchSampleProcessException;
import com.adjecti.pis.liferay.model.SampleProcess;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the sample process service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SampleProcessUtil
 * @generated
 */
@ProviderType
public interface SampleProcessPersistence
	extends BasePersistence<SampleProcess> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SampleProcessUtil} to access the sample process persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the sample processes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching sample processes
	 */
	public java.util.List<SampleProcess> findByUuid(String uuid);

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
	public java.util.List<SampleProcess> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<SampleProcess> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleProcess>
			orderByComparator);

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
	public java.util.List<SampleProcess> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleProcess>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sample process in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample process
	 * @throws NoSuchSampleProcessException if a matching sample process could not be found
	 */
	public SampleProcess findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SampleProcess>
				orderByComparator)
		throws NoSuchSampleProcessException;

	/**
	 * Returns the first sample process in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample process, or <code>null</code> if a matching sample process could not be found
	 */
	public SampleProcess fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SampleProcess>
			orderByComparator);

	/**
	 * Returns the last sample process in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample process
	 * @throws NoSuchSampleProcessException if a matching sample process could not be found
	 */
	public SampleProcess findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SampleProcess>
				orderByComparator)
		throws NoSuchSampleProcessException;

	/**
	 * Returns the last sample process in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample process, or <code>null</code> if a matching sample process could not be found
	 */
	public SampleProcess fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SampleProcess>
			orderByComparator);

	/**
	 * Returns the sample processes before and after the current sample process in the ordered set where uuid = &#63;.
	 *
	 * @param sampleProcessId the primary key of the current sample process
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample process
	 * @throws NoSuchSampleProcessException if a sample process with the primary key could not be found
	 */
	public SampleProcess[] findByUuid_PrevAndNext(
			long sampleProcessId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SampleProcess>
				orderByComparator)
		throws NoSuchSampleProcessException;

	/**
	 * Removes all the sample processes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of sample processes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching sample processes
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the sample process where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSampleProcessException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sample process
	 * @throws NoSuchSampleProcessException if a matching sample process could not be found
	 */
	public SampleProcess findByUUID_G(String uuid, long groupId)
		throws NoSuchSampleProcessException;

	/**
	 * Returns the sample process where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sample process, or <code>null</code> if a matching sample process could not be found
	 */
	public SampleProcess fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the sample process where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sample process, or <code>null</code> if a matching sample process could not be found
	 */
	public SampleProcess fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the sample process where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the sample process that was removed
	 */
	public SampleProcess removeByUUID_G(String uuid, long groupId)
		throws NoSuchSampleProcessException;

	/**
	 * Returns the number of sample processes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching sample processes
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the sample processes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching sample processes
	 */
	public java.util.List<SampleProcess> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<SampleProcess> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<SampleProcess> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleProcess>
			orderByComparator);

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
	public java.util.List<SampleProcess> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleProcess>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sample process in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample process
	 * @throws NoSuchSampleProcessException if a matching sample process could not be found
	 */
	public SampleProcess findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SampleProcess>
				orderByComparator)
		throws NoSuchSampleProcessException;

	/**
	 * Returns the first sample process in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample process, or <code>null</code> if a matching sample process could not be found
	 */
	public SampleProcess fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SampleProcess>
			orderByComparator);

	/**
	 * Returns the last sample process in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample process
	 * @throws NoSuchSampleProcessException if a matching sample process could not be found
	 */
	public SampleProcess findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SampleProcess>
				orderByComparator)
		throws NoSuchSampleProcessException;

	/**
	 * Returns the last sample process in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample process, or <code>null</code> if a matching sample process could not be found
	 */
	public SampleProcess fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SampleProcess>
			orderByComparator);

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
	public SampleProcess[] findByUuid_C_PrevAndNext(
			long sampleProcessId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SampleProcess>
				orderByComparator)
		throws NoSuchSampleProcessException;

	/**
	 * Removes all the sample processes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of sample processes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching sample processes
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the sample processes where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @return the matching sample processes
	 */
	public java.util.List<SampleProcess> findByReviewerUserId(
		long reviewerUserId);

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
	public java.util.List<SampleProcess> findByReviewerUserId(
		long reviewerUserId, int start, int end);

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
	public java.util.List<SampleProcess> findByReviewerUserId(
		long reviewerUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleProcess>
			orderByComparator);

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
	public java.util.List<SampleProcess> findByReviewerUserId(
		long reviewerUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleProcess>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sample process in the ordered set where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample process
	 * @throws NoSuchSampleProcessException if a matching sample process could not be found
	 */
	public SampleProcess findByReviewerUserId_First(
			long reviewerUserId,
			com.liferay.portal.kernel.util.OrderByComparator<SampleProcess>
				orderByComparator)
		throws NoSuchSampleProcessException;

	/**
	 * Returns the first sample process in the ordered set where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample process, or <code>null</code> if a matching sample process could not be found
	 */
	public SampleProcess fetchByReviewerUserId_First(
		long reviewerUserId,
		com.liferay.portal.kernel.util.OrderByComparator<SampleProcess>
			orderByComparator);

	/**
	 * Returns the last sample process in the ordered set where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample process
	 * @throws NoSuchSampleProcessException if a matching sample process could not be found
	 */
	public SampleProcess findByReviewerUserId_Last(
			long reviewerUserId,
			com.liferay.portal.kernel.util.OrderByComparator<SampleProcess>
				orderByComparator)
		throws NoSuchSampleProcessException;

	/**
	 * Returns the last sample process in the ordered set where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample process, or <code>null</code> if a matching sample process could not be found
	 */
	public SampleProcess fetchByReviewerUserId_Last(
		long reviewerUserId,
		com.liferay.portal.kernel.util.OrderByComparator<SampleProcess>
			orderByComparator);

	/**
	 * Returns the sample processes before and after the current sample process in the ordered set where reviewerUserId = &#63;.
	 *
	 * @param sampleProcessId the primary key of the current sample process
	 * @param reviewerUserId the reviewer user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample process
	 * @throws NoSuchSampleProcessException if a sample process with the primary key could not be found
	 */
	public SampleProcess[] findByReviewerUserId_PrevAndNext(
			long sampleProcessId, long reviewerUserId,
			com.liferay.portal.kernel.util.OrderByComparator<SampleProcess>
				orderByComparator)
		throws NoSuchSampleProcessException;

	/**
	 * Removes all the sample processes where reviewerUserId = &#63; from the database.
	 *
	 * @param reviewerUserId the reviewer user ID
	 */
	public void removeByReviewerUserId(long reviewerUserId);

	/**
	 * Returns the number of sample processes where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @return the number of matching sample processes
	 */
	public int countByReviewerUserId(long reviewerUserId);

	/**
	 * Returns all the sample processes where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @return the matching sample processes
	 */
	public java.util.List<SampleProcess> findByApproverUserId(
		long approverUserId);

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
	public java.util.List<SampleProcess> findByApproverUserId(
		long approverUserId, int start, int end);

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
	public java.util.List<SampleProcess> findByApproverUserId(
		long approverUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleProcess>
			orderByComparator);

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
	public java.util.List<SampleProcess> findByApproverUserId(
		long approverUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleProcess>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sample process in the ordered set where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample process
	 * @throws NoSuchSampleProcessException if a matching sample process could not be found
	 */
	public SampleProcess findByApproverUserId_First(
			long approverUserId,
			com.liferay.portal.kernel.util.OrderByComparator<SampleProcess>
				orderByComparator)
		throws NoSuchSampleProcessException;

	/**
	 * Returns the first sample process in the ordered set where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample process, or <code>null</code> if a matching sample process could not be found
	 */
	public SampleProcess fetchByApproverUserId_First(
		long approverUserId,
		com.liferay.portal.kernel.util.OrderByComparator<SampleProcess>
			orderByComparator);

	/**
	 * Returns the last sample process in the ordered set where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample process
	 * @throws NoSuchSampleProcessException if a matching sample process could not be found
	 */
	public SampleProcess findByApproverUserId_Last(
			long approverUserId,
			com.liferay.portal.kernel.util.OrderByComparator<SampleProcess>
				orderByComparator)
		throws NoSuchSampleProcessException;

	/**
	 * Returns the last sample process in the ordered set where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample process, or <code>null</code> if a matching sample process could not be found
	 */
	public SampleProcess fetchByApproverUserId_Last(
		long approverUserId,
		com.liferay.portal.kernel.util.OrderByComparator<SampleProcess>
			orderByComparator);

	/**
	 * Returns the sample processes before and after the current sample process in the ordered set where approverUserId = &#63;.
	 *
	 * @param sampleProcessId the primary key of the current sample process
	 * @param approverUserId the approver user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample process
	 * @throws NoSuchSampleProcessException if a sample process with the primary key could not be found
	 */
	public SampleProcess[] findByApproverUserId_PrevAndNext(
			long sampleProcessId, long approverUserId,
			com.liferay.portal.kernel.util.OrderByComparator<SampleProcess>
				orderByComparator)
		throws NoSuchSampleProcessException;

	/**
	 * Removes all the sample processes where approverUserId = &#63; from the database.
	 *
	 * @param approverUserId the approver user ID
	 */
	public void removeByApproverUserId(long approverUserId);

	/**
	 * Returns the number of sample processes where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @return the number of matching sample processes
	 */
	public int countByApproverUserId(long approverUserId);

	/**
	 * Caches the sample process in the entity cache if it is enabled.
	 *
	 * @param sampleProcess the sample process
	 */
	public void cacheResult(SampleProcess sampleProcess);

	/**
	 * Caches the sample processes in the entity cache if it is enabled.
	 *
	 * @param sampleProcesses the sample processes
	 */
	public void cacheResult(java.util.List<SampleProcess> sampleProcesses);

	/**
	 * Creates a new sample process with the primary key. Does not add the sample process to the database.
	 *
	 * @param sampleProcessId the primary key for the new sample process
	 * @return the new sample process
	 */
	public SampleProcess create(long sampleProcessId);

	/**
	 * Removes the sample process with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sampleProcessId the primary key of the sample process
	 * @return the sample process that was removed
	 * @throws NoSuchSampleProcessException if a sample process with the primary key could not be found
	 */
	public SampleProcess remove(long sampleProcessId)
		throws NoSuchSampleProcessException;

	public SampleProcess updateImpl(SampleProcess sampleProcess);

	/**
	 * Returns the sample process with the primary key or throws a <code>NoSuchSampleProcessException</code> if it could not be found.
	 *
	 * @param sampleProcessId the primary key of the sample process
	 * @return the sample process
	 * @throws NoSuchSampleProcessException if a sample process with the primary key could not be found
	 */
	public SampleProcess findByPrimaryKey(long sampleProcessId)
		throws NoSuchSampleProcessException;

	/**
	 * Returns the sample process with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sampleProcessId the primary key of the sample process
	 * @return the sample process, or <code>null</code> if a sample process with the primary key could not be found
	 */
	public SampleProcess fetchByPrimaryKey(long sampleProcessId);

	/**
	 * Returns all the sample processes.
	 *
	 * @return the sample processes
	 */
	public java.util.List<SampleProcess> findAll();

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
	public java.util.List<SampleProcess> findAll(int start, int end);

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
	public java.util.List<SampleProcess> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleProcess>
			orderByComparator);

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
	public java.util.List<SampleProcess> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SampleProcess>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the sample processes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of sample processes.
	 *
	 * @return the number of sample processes
	 */
	public int countAll();

}