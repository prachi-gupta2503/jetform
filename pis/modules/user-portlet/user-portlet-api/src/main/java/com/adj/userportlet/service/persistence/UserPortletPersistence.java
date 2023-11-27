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

package com.adj.userportlet.service.persistence;

import com.adj.userportlet.exception.NoSuchUserPortletException;
import com.adj.userportlet.model.UserPortlet;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the user portlet service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserPortletUtil
 * @generated
 */
@ProviderType
public interface UserPortletPersistence extends BasePersistence<UserPortlet> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserPortletUtil} to access the user portlet persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the user portlets where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user portlets
	 */
	public java.util.List<UserPortlet> findByUuid(String uuid);

	/**
	 * Returns a range of all the user portlets where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserPortletModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user portlets
	 * @param end the upper bound of the range of user portlets (not inclusive)
	 * @return the range of matching user portlets
	 */
	public java.util.List<UserPortlet> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the user portlets where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserPortletModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user portlets
	 * @param end the upper bound of the range of user portlets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user portlets
	 */
	public java.util.List<UserPortlet> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserPortlet>
			orderByComparator);

	/**
	 * Returns an ordered range of all the user portlets where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserPortletModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user portlets
	 * @param end the upper bound of the range of user portlets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user portlets
	 */
	public java.util.List<UserPortlet> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserPortlet>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user portlet in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user portlet
	 * @throws NoSuchUserPortletException if a matching user portlet could not be found
	 */
	public UserPortlet findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<UserPortlet>
				orderByComparator)
		throws NoSuchUserPortletException;

	/**
	 * Returns the first user portlet in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user portlet, or <code>null</code> if a matching user portlet could not be found
	 */
	public UserPortlet fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserPortlet>
			orderByComparator);

	/**
	 * Returns the last user portlet in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user portlet
	 * @throws NoSuchUserPortletException if a matching user portlet could not be found
	 */
	public UserPortlet findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<UserPortlet>
				orderByComparator)
		throws NoSuchUserPortletException;

	/**
	 * Returns the last user portlet in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user portlet, or <code>null</code> if a matching user portlet could not be found
	 */
	public UserPortlet fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserPortlet>
			orderByComparator);

	/**
	 * Returns the user portlets before and after the current user portlet in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current user portlet
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user portlet
	 * @throws NoSuchUserPortletException if a user portlet with the primary key could not be found
	 */
	public UserPortlet[] findByUuid_PrevAndNext(
			long id, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<UserPortlet>
				orderByComparator)
		throws NoSuchUserPortletException;

	/**
	 * Removes all the user portlets where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of user portlets where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user portlets
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the user portlet where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchUserPortletException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching user portlet
	 * @throws NoSuchUserPortletException if a matching user portlet could not be found
	 */
	public UserPortlet findByUUID_G(String uuid, long groupId)
		throws NoSuchUserPortletException;

	/**
	 * Returns the user portlet where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching user portlet, or <code>null</code> if a matching user portlet could not be found
	 */
	public UserPortlet fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the user portlet where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user portlet, or <code>null</code> if a matching user portlet could not be found
	 */
	public UserPortlet fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the user portlet where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the user portlet that was removed
	 */
	public UserPortlet removeByUUID_G(String uuid, long groupId)
		throws NoSuchUserPortletException;

	/**
	 * Returns the number of user portlets where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching user portlets
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the user portlets where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching user portlets
	 */
	public java.util.List<UserPortlet> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the user portlets where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserPortletModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user portlets
	 * @param end the upper bound of the range of user portlets (not inclusive)
	 * @return the range of matching user portlets
	 */
	public java.util.List<UserPortlet> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the user portlets where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserPortletModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user portlets
	 * @param end the upper bound of the range of user portlets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user portlets
	 */
	public java.util.List<UserPortlet> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserPortlet>
			orderByComparator);

	/**
	 * Returns an ordered range of all the user portlets where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserPortletModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user portlets
	 * @param end the upper bound of the range of user portlets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user portlets
	 */
	public java.util.List<UserPortlet> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserPortlet>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user portlet in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user portlet
	 * @throws NoSuchUserPortletException if a matching user portlet could not be found
	 */
	public UserPortlet findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<UserPortlet>
				orderByComparator)
		throws NoSuchUserPortletException;

	/**
	 * Returns the first user portlet in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user portlet, or <code>null</code> if a matching user portlet could not be found
	 */
	public UserPortlet fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<UserPortlet>
			orderByComparator);

	/**
	 * Returns the last user portlet in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user portlet
	 * @throws NoSuchUserPortletException if a matching user portlet could not be found
	 */
	public UserPortlet findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<UserPortlet>
				orderByComparator)
		throws NoSuchUserPortletException;

	/**
	 * Returns the last user portlet in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user portlet, or <code>null</code> if a matching user portlet could not be found
	 */
	public UserPortlet fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<UserPortlet>
			orderByComparator);

	/**
	 * Returns the user portlets before and after the current user portlet in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param id the primary key of the current user portlet
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user portlet
	 * @throws NoSuchUserPortletException if a user portlet with the primary key could not be found
	 */
	public UserPortlet[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<UserPortlet>
				orderByComparator)
		throws NoSuchUserPortletException;

	/**
	 * Removes all the user portlets where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of user portlets where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching user portlets
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the user portlet where portletId = &#63; or throws a <code>NoSuchUserPortletException</code> if it could not be found.
	 *
	 * @param portletId the portlet ID
	 * @return the matching user portlet
	 * @throws NoSuchUserPortletException if a matching user portlet could not be found
	 */
	public UserPortlet findByPortletId(String portletId)
		throws NoSuchUserPortletException;

	/**
	 * Returns the user portlet where portletId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param portletId the portlet ID
	 * @return the matching user portlet, or <code>null</code> if a matching user portlet could not be found
	 */
	public UserPortlet fetchByPortletId(String portletId);

	/**
	 * Returns the user portlet where portletId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param portletId the portlet ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user portlet, or <code>null</code> if a matching user portlet could not be found
	 */
	public UserPortlet fetchByPortletId(
		String portletId, boolean useFinderCache);

	/**
	 * Removes the user portlet where portletId = &#63; from the database.
	 *
	 * @param portletId the portlet ID
	 * @return the user portlet that was removed
	 */
	public UserPortlet removeByPortletId(String portletId)
		throws NoSuchUserPortletException;

	/**
	 * Returns the number of user portlets where portletId = &#63;.
	 *
	 * @param portletId the portlet ID
	 * @return the number of matching user portlets
	 */
	public int countByPortletId(String portletId);

	/**
	 * Caches the user portlet in the entity cache if it is enabled.
	 *
	 * @param userPortlet the user portlet
	 */
	public void cacheResult(UserPortlet userPortlet);

	/**
	 * Caches the user portlets in the entity cache if it is enabled.
	 *
	 * @param userPortlets the user portlets
	 */
	public void cacheResult(java.util.List<UserPortlet> userPortlets);

	/**
	 * Creates a new user portlet with the primary key. Does not add the user portlet to the database.
	 *
	 * @param id the primary key for the new user portlet
	 * @return the new user portlet
	 */
	public UserPortlet create(long id);

	/**
	 * Removes the user portlet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the user portlet
	 * @return the user portlet that was removed
	 * @throws NoSuchUserPortletException if a user portlet with the primary key could not be found
	 */
	public UserPortlet remove(long id) throws NoSuchUserPortletException;

	public UserPortlet updateImpl(UserPortlet userPortlet);

	/**
	 * Returns the user portlet with the primary key or throws a <code>NoSuchUserPortletException</code> if it could not be found.
	 *
	 * @param id the primary key of the user portlet
	 * @return the user portlet
	 * @throws NoSuchUserPortletException if a user portlet with the primary key could not be found
	 */
	public UserPortlet findByPrimaryKey(long id)
		throws NoSuchUserPortletException;

	/**
	 * Returns the user portlet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the user portlet
	 * @return the user portlet, or <code>null</code> if a user portlet with the primary key could not be found
	 */
	public UserPortlet fetchByPrimaryKey(long id);

	/**
	 * Returns all the user portlets.
	 *
	 * @return the user portlets
	 */
	public java.util.List<UserPortlet> findAll();

	/**
	 * Returns a range of all the user portlets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserPortletModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user portlets
	 * @param end the upper bound of the range of user portlets (not inclusive)
	 * @return the range of user portlets
	 */
	public java.util.List<UserPortlet> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the user portlets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserPortletModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user portlets
	 * @param end the upper bound of the range of user portlets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user portlets
	 */
	public java.util.List<UserPortlet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserPortlet>
			orderByComparator);

	/**
	 * Returns an ordered range of all the user portlets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserPortletModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user portlets
	 * @param end the upper bound of the range of user portlets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user portlets
	 */
	public java.util.List<UserPortlet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserPortlet>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the user portlets from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of user portlets.
	 *
	 * @return the number of user portlets
	 */
	public int countAll();

}