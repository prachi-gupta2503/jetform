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

import com.adjecti.pis.liferay.exception.NoSuchJoiningProcessRequestException;
import com.adjecti.pis.liferay.model.JoiningProcessRequest;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the joining process request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JoiningProcessRequestUtil
 * @generated
 */
@ProviderType
public interface JoiningProcessRequestPersistence
	extends BasePersistence<JoiningProcessRequest> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link JoiningProcessRequestUtil} to access the joining process request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the joining process requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching joining process requests
	 */
	public java.util.List<JoiningProcessRequest> findByUuid(String uuid);

	/**
	 * Returns a range of all the joining process requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of joining process requests
	 * @param end the upper bound of the range of joining process requests (not inclusive)
	 * @return the range of matching joining process requests
	 */
	public java.util.List<JoiningProcessRequest> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the joining process requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of joining process requests
	 * @param end the upper bound of the range of joining process requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching joining process requests
	 */
	public java.util.List<JoiningProcessRequest> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JoiningProcessRequest>
			orderByComparator);

	/**
	 * Returns an ordered range of all the joining process requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of joining process requests
	 * @param end the upper bound of the range of joining process requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching joining process requests
	 */
	public java.util.List<JoiningProcessRequest> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JoiningProcessRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first joining process request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching joining process request
	 * @throws NoSuchJoiningProcessRequestException if a matching joining process request could not be found
	 */
	public JoiningProcessRequest findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<JoiningProcessRequest> orderByComparator)
		throws NoSuchJoiningProcessRequestException;

	/**
	 * Returns the first joining process request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching joining process request, or <code>null</code> if a matching joining process request could not be found
	 */
	public JoiningProcessRequest fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<JoiningProcessRequest>
			orderByComparator);

	/**
	 * Returns the last joining process request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching joining process request
	 * @throws NoSuchJoiningProcessRequestException if a matching joining process request could not be found
	 */
	public JoiningProcessRequest findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<JoiningProcessRequest> orderByComparator)
		throws NoSuchJoiningProcessRequestException;

	/**
	 * Returns the last joining process request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching joining process request, or <code>null</code> if a matching joining process request could not be found
	 */
	public JoiningProcessRequest fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<JoiningProcessRequest>
			orderByComparator);

	/**
	 * Returns the joining process requests before and after the current joining process request in the ordered set where uuid = &#63;.
	 *
	 * @param joiningProcessRequestId the primary key of the current joining process request
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next joining process request
	 * @throws NoSuchJoiningProcessRequestException if a joining process request with the primary key could not be found
	 */
	public JoiningProcessRequest[] findByUuid_PrevAndNext(
			long joiningProcessRequestId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<JoiningProcessRequest> orderByComparator)
		throws NoSuchJoiningProcessRequestException;

	/**
	 * Removes all the joining process requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of joining process requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching joining process requests
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the joining process request where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchJoiningProcessRequestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching joining process request
	 * @throws NoSuchJoiningProcessRequestException if a matching joining process request could not be found
	 */
	public JoiningProcessRequest findByUUID_G(String uuid, long groupId)
		throws NoSuchJoiningProcessRequestException;

	/**
	 * Returns the joining process request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching joining process request, or <code>null</code> if a matching joining process request could not be found
	 */
	public JoiningProcessRequest fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the joining process request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching joining process request, or <code>null</code> if a matching joining process request could not be found
	 */
	public JoiningProcessRequest fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the joining process request where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the joining process request that was removed
	 */
	public JoiningProcessRequest removeByUUID_G(String uuid, long groupId)
		throws NoSuchJoiningProcessRequestException;

	/**
	 * Returns the number of joining process requests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching joining process requests
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the joining process requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching joining process requests
	 */
	public java.util.List<JoiningProcessRequest> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the joining process requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of joining process requests
	 * @param end the upper bound of the range of joining process requests (not inclusive)
	 * @return the range of matching joining process requests
	 */
	public java.util.List<JoiningProcessRequest> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the joining process requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of joining process requests
	 * @param end the upper bound of the range of joining process requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching joining process requests
	 */
	public java.util.List<JoiningProcessRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JoiningProcessRequest>
			orderByComparator);

	/**
	 * Returns an ordered range of all the joining process requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of joining process requests
	 * @param end the upper bound of the range of joining process requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching joining process requests
	 */
	public java.util.List<JoiningProcessRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JoiningProcessRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first joining process request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching joining process request
	 * @throws NoSuchJoiningProcessRequestException if a matching joining process request could not be found
	 */
	public JoiningProcessRequest findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<JoiningProcessRequest> orderByComparator)
		throws NoSuchJoiningProcessRequestException;

	/**
	 * Returns the first joining process request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching joining process request, or <code>null</code> if a matching joining process request could not be found
	 */
	public JoiningProcessRequest fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<JoiningProcessRequest>
			orderByComparator);

	/**
	 * Returns the last joining process request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching joining process request
	 * @throws NoSuchJoiningProcessRequestException if a matching joining process request could not be found
	 */
	public JoiningProcessRequest findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<JoiningProcessRequest> orderByComparator)
		throws NoSuchJoiningProcessRequestException;

	/**
	 * Returns the last joining process request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching joining process request, or <code>null</code> if a matching joining process request could not be found
	 */
	public JoiningProcessRequest fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<JoiningProcessRequest>
			orderByComparator);

	/**
	 * Returns the joining process requests before and after the current joining process request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param joiningProcessRequestId the primary key of the current joining process request
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next joining process request
	 * @throws NoSuchJoiningProcessRequestException if a joining process request with the primary key could not be found
	 */
	public JoiningProcessRequest[] findByUuid_C_PrevAndNext(
			long joiningProcessRequestId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<JoiningProcessRequest> orderByComparator)
		throws NoSuchJoiningProcessRequestException;

	/**
	 * Removes all the joining process requests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of joining process requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching joining process requests
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the joining process request in the entity cache if it is enabled.
	 *
	 * @param joiningProcessRequest the joining process request
	 */
	public void cacheResult(JoiningProcessRequest joiningProcessRequest);

	/**
	 * Caches the joining process requests in the entity cache if it is enabled.
	 *
	 * @param joiningProcessRequests the joining process requests
	 */
	public void cacheResult(
		java.util.List<JoiningProcessRequest> joiningProcessRequests);

	/**
	 * Creates a new joining process request with the primary key. Does not add the joining process request to the database.
	 *
	 * @param joiningProcessRequestId the primary key for the new joining process request
	 * @return the new joining process request
	 */
	public JoiningProcessRequest create(long joiningProcessRequestId);

	/**
	 * Removes the joining process request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param joiningProcessRequestId the primary key of the joining process request
	 * @return the joining process request that was removed
	 * @throws NoSuchJoiningProcessRequestException if a joining process request with the primary key could not be found
	 */
	public JoiningProcessRequest remove(long joiningProcessRequestId)
		throws NoSuchJoiningProcessRequestException;

	public JoiningProcessRequest updateImpl(
		JoiningProcessRequest joiningProcessRequest);

	/**
	 * Returns the joining process request with the primary key or throws a <code>NoSuchJoiningProcessRequestException</code> if it could not be found.
	 *
	 * @param joiningProcessRequestId the primary key of the joining process request
	 * @return the joining process request
	 * @throws NoSuchJoiningProcessRequestException if a joining process request with the primary key could not be found
	 */
	public JoiningProcessRequest findByPrimaryKey(long joiningProcessRequestId)
		throws NoSuchJoiningProcessRequestException;

	/**
	 * Returns the joining process request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param joiningProcessRequestId the primary key of the joining process request
	 * @return the joining process request, or <code>null</code> if a joining process request with the primary key could not be found
	 */
	public JoiningProcessRequest fetchByPrimaryKey(
		long joiningProcessRequestId);

	/**
	 * Returns all the joining process requests.
	 *
	 * @return the joining process requests
	 */
	public java.util.List<JoiningProcessRequest> findAll();

	/**
	 * Returns a range of all the joining process requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of joining process requests
	 * @param end the upper bound of the range of joining process requests (not inclusive)
	 * @return the range of joining process requests
	 */
	public java.util.List<JoiningProcessRequest> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the joining process requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of joining process requests
	 * @param end the upper bound of the range of joining process requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of joining process requests
	 */
	public java.util.List<JoiningProcessRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JoiningProcessRequest>
			orderByComparator);

	/**
	 * Returns an ordered range of all the joining process requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of joining process requests
	 * @param end the upper bound of the range of joining process requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of joining process requests
	 */
	public java.util.List<JoiningProcessRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JoiningProcessRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the joining process requests from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of joining process requests.
	 *
	 * @return the number of joining process requests
	 */
	public int countAll();

}