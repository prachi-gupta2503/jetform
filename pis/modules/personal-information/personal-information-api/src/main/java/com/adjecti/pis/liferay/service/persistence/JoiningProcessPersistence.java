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

import com.adjecti.pis.liferay.exception.NoSuchJoiningProcessException;
import com.adjecti.pis.liferay.model.JoiningProcess;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the joining process service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JoiningProcessUtil
 * @generated
 */
@ProviderType
public interface JoiningProcessPersistence
	extends BasePersistence<JoiningProcess> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link JoiningProcessUtil} to access the joining process persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the joining processes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching joining processes
	 */
	public java.util.List<JoiningProcess> findByUuid(String uuid);

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
	public java.util.List<JoiningProcess> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<JoiningProcess> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JoiningProcess>
			orderByComparator);

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
	public java.util.List<JoiningProcess> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JoiningProcess>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first joining process in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching joining process
	 * @throws NoSuchJoiningProcessException if a matching joining process could not be found
	 */
	public JoiningProcess findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<JoiningProcess>
				orderByComparator)
		throws NoSuchJoiningProcessException;

	/**
	 * Returns the first joining process in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching joining process, or <code>null</code> if a matching joining process could not be found
	 */
	public JoiningProcess fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<JoiningProcess>
			orderByComparator);

	/**
	 * Returns the last joining process in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching joining process
	 * @throws NoSuchJoiningProcessException if a matching joining process could not be found
	 */
	public JoiningProcess findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<JoiningProcess>
				orderByComparator)
		throws NoSuchJoiningProcessException;

	/**
	 * Returns the last joining process in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching joining process, or <code>null</code> if a matching joining process could not be found
	 */
	public JoiningProcess fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<JoiningProcess>
			orderByComparator);

	/**
	 * Returns the joining processes before and after the current joining process in the ordered set where uuid = &#63;.
	 *
	 * @param joiningProcessId the primary key of the current joining process
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next joining process
	 * @throws NoSuchJoiningProcessException if a joining process with the primary key could not be found
	 */
	public JoiningProcess[] findByUuid_PrevAndNext(
			long joiningProcessId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<JoiningProcess>
				orderByComparator)
		throws NoSuchJoiningProcessException;

	/**
	 * Removes all the joining processes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of joining processes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching joining processes
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the joining process where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchJoiningProcessException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching joining process
	 * @throws NoSuchJoiningProcessException if a matching joining process could not be found
	 */
	public JoiningProcess findByUUID_G(String uuid, long groupId)
		throws NoSuchJoiningProcessException;

	/**
	 * Returns the joining process where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching joining process, or <code>null</code> if a matching joining process could not be found
	 */
	public JoiningProcess fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the joining process where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching joining process, or <code>null</code> if a matching joining process could not be found
	 */
	public JoiningProcess fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the joining process where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the joining process that was removed
	 */
	public JoiningProcess removeByUUID_G(String uuid, long groupId)
		throws NoSuchJoiningProcessException;

	/**
	 * Returns the number of joining processes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching joining processes
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the joining processes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching joining processes
	 */
	public java.util.List<JoiningProcess> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<JoiningProcess> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<JoiningProcess> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JoiningProcess>
			orderByComparator);

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
	public java.util.List<JoiningProcess> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JoiningProcess>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first joining process in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching joining process
	 * @throws NoSuchJoiningProcessException if a matching joining process could not be found
	 */
	public JoiningProcess findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<JoiningProcess>
				orderByComparator)
		throws NoSuchJoiningProcessException;

	/**
	 * Returns the first joining process in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching joining process, or <code>null</code> if a matching joining process could not be found
	 */
	public JoiningProcess fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<JoiningProcess>
			orderByComparator);

	/**
	 * Returns the last joining process in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching joining process
	 * @throws NoSuchJoiningProcessException if a matching joining process could not be found
	 */
	public JoiningProcess findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<JoiningProcess>
				orderByComparator)
		throws NoSuchJoiningProcessException;

	/**
	 * Returns the last joining process in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching joining process, or <code>null</code> if a matching joining process could not be found
	 */
	public JoiningProcess fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<JoiningProcess>
			orderByComparator);

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
	public JoiningProcess[] findByUuid_C_PrevAndNext(
			long joiningProcessId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<JoiningProcess>
				orderByComparator)
		throws NoSuchJoiningProcessException;

	/**
	 * Removes all the joining processes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of joining processes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching joining processes
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the joining processes where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @return the matching joining processes
	 */
	public java.util.List<JoiningProcess> findByReviewerUserId(
		long reviewerUserId);

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
	public java.util.List<JoiningProcess> findByReviewerUserId(
		long reviewerUserId, int start, int end);

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
	public java.util.List<JoiningProcess> findByReviewerUserId(
		long reviewerUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JoiningProcess>
			orderByComparator);

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
	public java.util.List<JoiningProcess> findByReviewerUserId(
		long reviewerUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JoiningProcess>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first joining process in the ordered set where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching joining process
	 * @throws NoSuchJoiningProcessException if a matching joining process could not be found
	 */
	public JoiningProcess findByReviewerUserId_First(
			long reviewerUserId,
			com.liferay.portal.kernel.util.OrderByComparator<JoiningProcess>
				orderByComparator)
		throws NoSuchJoiningProcessException;

	/**
	 * Returns the first joining process in the ordered set where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching joining process, or <code>null</code> if a matching joining process could not be found
	 */
	public JoiningProcess fetchByReviewerUserId_First(
		long reviewerUserId,
		com.liferay.portal.kernel.util.OrderByComparator<JoiningProcess>
			orderByComparator);

	/**
	 * Returns the last joining process in the ordered set where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching joining process
	 * @throws NoSuchJoiningProcessException if a matching joining process could not be found
	 */
	public JoiningProcess findByReviewerUserId_Last(
			long reviewerUserId,
			com.liferay.portal.kernel.util.OrderByComparator<JoiningProcess>
				orderByComparator)
		throws NoSuchJoiningProcessException;

	/**
	 * Returns the last joining process in the ordered set where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching joining process, or <code>null</code> if a matching joining process could not be found
	 */
	public JoiningProcess fetchByReviewerUserId_Last(
		long reviewerUserId,
		com.liferay.portal.kernel.util.OrderByComparator<JoiningProcess>
			orderByComparator);

	/**
	 * Returns the joining processes before and after the current joining process in the ordered set where reviewerUserId = &#63;.
	 *
	 * @param joiningProcessId the primary key of the current joining process
	 * @param reviewerUserId the reviewer user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next joining process
	 * @throws NoSuchJoiningProcessException if a joining process with the primary key could not be found
	 */
	public JoiningProcess[] findByReviewerUserId_PrevAndNext(
			long joiningProcessId, long reviewerUserId,
			com.liferay.portal.kernel.util.OrderByComparator<JoiningProcess>
				orderByComparator)
		throws NoSuchJoiningProcessException;

	/**
	 * Removes all the joining processes where reviewerUserId = &#63; from the database.
	 *
	 * @param reviewerUserId the reviewer user ID
	 */
	public void removeByReviewerUserId(long reviewerUserId);

	/**
	 * Returns the number of joining processes where reviewerUserId = &#63;.
	 *
	 * @param reviewerUserId the reviewer user ID
	 * @return the number of matching joining processes
	 */
	public int countByReviewerUserId(long reviewerUserId);

	/**
	 * Returns all the joining processes where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @return the matching joining processes
	 */
	public java.util.List<JoiningProcess> findByUnitId(long unitId);

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
	public java.util.List<JoiningProcess> findByUnitId(
		long unitId, int start, int end);

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
	public java.util.List<JoiningProcess> findByUnitId(
		long unitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JoiningProcess>
			orderByComparator);

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
	public java.util.List<JoiningProcess> findByUnitId(
		long unitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JoiningProcess>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first joining process in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching joining process
	 * @throws NoSuchJoiningProcessException if a matching joining process could not be found
	 */
	public JoiningProcess findByUnitId_First(
			long unitId,
			com.liferay.portal.kernel.util.OrderByComparator<JoiningProcess>
				orderByComparator)
		throws NoSuchJoiningProcessException;

	/**
	 * Returns the first joining process in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching joining process, or <code>null</code> if a matching joining process could not be found
	 */
	public JoiningProcess fetchByUnitId_First(
		long unitId,
		com.liferay.portal.kernel.util.OrderByComparator<JoiningProcess>
			orderByComparator);

	/**
	 * Returns the last joining process in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching joining process
	 * @throws NoSuchJoiningProcessException if a matching joining process could not be found
	 */
	public JoiningProcess findByUnitId_Last(
			long unitId,
			com.liferay.portal.kernel.util.OrderByComparator<JoiningProcess>
				orderByComparator)
		throws NoSuchJoiningProcessException;

	/**
	 * Returns the last joining process in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching joining process, or <code>null</code> if a matching joining process could not be found
	 */
	public JoiningProcess fetchByUnitId_Last(
		long unitId,
		com.liferay.portal.kernel.util.OrderByComparator<JoiningProcess>
			orderByComparator);

	/**
	 * Returns the joining processes before and after the current joining process in the ordered set where unitId = &#63;.
	 *
	 * @param joiningProcessId the primary key of the current joining process
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next joining process
	 * @throws NoSuchJoiningProcessException if a joining process with the primary key could not be found
	 */
	public JoiningProcess[] findByUnitId_PrevAndNext(
			long joiningProcessId, long unitId,
			com.liferay.portal.kernel.util.OrderByComparator<JoiningProcess>
				orderByComparator)
		throws NoSuchJoiningProcessException;

	/**
	 * Removes all the joining processes where unitId = &#63; from the database.
	 *
	 * @param unitId the unit ID
	 */
	public void removeByUnitId(long unitId);

	/**
	 * Returns the number of joining processes where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @return the number of matching joining processes
	 */
	public int countByUnitId(long unitId);

	/**
	 * Returns all the joining processes where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @return the matching joining processes
	 */
	public java.util.List<JoiningProcess> findByApproverUserId(
		long approverUserId);

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
	public java.util.List<JoiningProcess> findByApproverUserId(
		long approverUserId, int start, int end);

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
	public java.util.List<JoiningProcess> findByApproverUserId(
		long approverUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JoiningProcess>
			orderByComparator);

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
	public java.util.List<JoiningProcess> findByApproverUserId(
		long approverUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JoiningProcess>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first joining process in the ordered set where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching joining process
	 * @throws NoSuchJoiningProcessException if a matching joining process could not be found
	 */
	public JoiningProcess findByApproverUserId_First(
			long approverUserId,
			com.liferay.portal.kernel.util.OrderByComparator<JoiningProcess>
				orderByComparator)
		throws NoSuchJoiningProcessException;

	/**
	 * Returns the first joining process in the ordered set where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching joining process, or <code>null</code> if a matching joining process could not be found
	 */
	public JoiningProcess fetchByApproverUserId_First(
		long approverUserId,
		com.liferay.portal.kernel.util.OrderByComparator<JoiningProcess>
			orderByComparator);

	/**
	 * Returns the last joining process in the ordered set where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching joining process
	 * @throws NoSuchJoiningProcessException if a matching joining process could not be found
	 */
	public JoiningProcess findByApproverUserId_Last(
			long approverUserId,
			com.liferay.portal.kernel.util.OrderByComparator<JoiningProcess>
				orderByComparator)
		throws NoSuchJoiningProcessException;

	/**
	 * Returns the last joining process in the ordered set where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching joining process, or <code>null</code> if a matching joining process could not be found
	 */
	public JoiningProcess fetchByApproverUserId_Last(
		long approverUserId,
		com.liferay.portal.kernel.util.OrderByComparator<JoiningProcess>
			orderByComparator);

	/**
	 * Returns the joining processes before and after the current joining process in the ordered set where approverUserId = &#63;.
	 *
	 * @param joiningProcessId the primary key of the current joining process
	 * @param approverUserId the approver user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next joining process
	 * @throws NoSuchJoiningProcessException if a joining process with the primary key could not be found
	 */
	public JoiningProcess[] findByApproverUserId_PrevAndNext(
			long joiningProcessId, long approverUserId,
			com.liferay.portal.kernel.util.OrderByComparator<JoiningProcess>
				orderByComparator)
		throws NoSuchJoiningProcessException;

	/**
	 * Removes all the joining processes where approverUserId = &#63; from the database.
	 *
	 * @param approverUserId the approver user ID
	 */
	public void removeByApproverUserId(long approverUserId);

	/**
	 * Returns the number of joining processes where approverUserId = &#63;.
	 *
	 * @param approverUserId the approver user ID
	 * @return the number of matching joining processes
	 */
	public int countByApproverUserId(long approverUserId);

	/**
	 * Caches the joining process in the entity cache if it is enabled.
	 *
	 * @param joiningProcess the joining process
	 */
	public void cacheResult(JoiningProcess joiningProcess);

	/**
	 * Caches the joining processes in the entity cache if it is enabled.
	 *
	 * @param joiningProcesses the joining processes
	 */
	public void cacheResult(java.util.List<JoiningProcess> joiningProcesses);

	/**
	 * Creates a new joining process with the primary key. Does not add the joining process to the database.
	 *
	 * @param joiningProcessId the primary key for the new joining process
	 * @return the new joining process
	 */
	public JoiningProcess create(long joiningProcessId);

	/**
	 * Removes the joining process with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param joiningProcessId the primary key of the joining process
	 * @return the joining process that was removed
	 * @throws NoSuchJoiningProcessException if a joining process with the primary key could not be found
	 */
	public JoiningProcess remove(long joiningProcessId)
		throws NoSuchJoiningProcessException;

	public JoiningProcess updateImpl(JoiningProcess joiningProcess);

	/**
	 * Returns the joining process with the primary key or throws a <code>NoSuchJoiningProcessException</code> if it could not be found.
	 *
	 * @param joiningProcessId the primary key of the joining process
	 * @return the joining process
	 * @throws NoSuchJoiningProcessException if a joining process with the primary key could not be found
	 */
	public JoiningProcess findByPrimaryKey(long joiningProcessId)
		throws NoSuchJoiningProcessException;

	/**
	 * Returns the joining process with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param joiningProcessId the primary key of the joining process
	 * @return the joining process, or <code>null</code> if a joining process with the primary key could not be found
	 */
	public JoiningProcess fetchByPrimaryKey(long joiningProcessId);

	/**
	 * Returns all the joining processes.
	 *
	 * @return the joining processes
	 */
	public java.util.List<JoiningProcess> findAll();

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
	public java.util.List<JoiningProcess> findAll(int start, int end);

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
	public java.util.List<JoiningProcess> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JoiningProcess>
			orderByComparator);

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
	public java.util.List<JoiningProcess> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JoiningProcess>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the joining processes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of joining processes.
	 *
	 * @return the number of joining processes
	 */
	public int countAll();

}