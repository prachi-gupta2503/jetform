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

import com.adj.userportlet.model.UserPortlet;

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
 * The persistence utility for the user portlet service. This utility wraps <code>com.adj.userportlet.service.persistence.impl.UserPortletPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserPortletPersistence
 * @generated
 */
public class UserPortletUtil {

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
	public static void clearCache(UserPortlet userPortlet) {
		getPersistence().clearCache(userPortlet);
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
	public static Map<Serializable, UserPortlet> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserPortlet> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserPortlet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserPortlet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserPortlet> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserPortlet update(UserPortlet userPortlet) {
		return getPersistence().update(userPortlet);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserPortlet update(
		UserPortlet userPortlet, ServiceContext serviceContext) {

		return getPersistence().update(userPortlet, serviceContext);
	}

	/**
	 * Returns all the user portlets where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user portlets
	 */
	public static List<UserPortlet> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<UserPortlet> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<UserPortlet> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserPortlet> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<UserPortlet> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserPortlet> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first user portlet in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user portlet
	 * @throws NoSuchUserPortletException if a matching user portlet could not be found
	 */
	public static UserPortlet findByUuid_First(
			String uuid, OrderByComparator<UserPortlet> orderByComparator)
		throws com.adj.userportlet.exception.NoSuchUserPortletException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first user portlet in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user portlet, or <code>null</code> if a matching user portlet could not be found
	 */
	public static UserPortlet fetchByUuid_First(
		String uuid, OrderByComparator<UserPortlet> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last user portlet in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user portlet
	 * @throws NoSuchUserPortletException if a matching user portlet could not be found
	 */
	public static UserPortlet findByUuid_Last(
			String uuid, OrderByComparator<UserPortlet> orderByComparator)
		throws com.adj.userportlet.exception.NoSuchUserPortletException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last user portlet in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user portlet, or <code>null</code> if a matching user portlet could not be found
	 */
	public static UserPortlet fetchByUuid_Last(
		String uuid, OrderByComparator<UserPortlet> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the user portlets before and after the current user portlet in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current user portlet
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user portlet
	 * @throws NoSuchUserPortletException if a user portlet with the primary key could not be found
	 */
	public static UserPortlet[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<UserPortlet> orderByComparator)
		throws com.adj.userportlet.exception.NoSuchUserPortletException {

		return getPersistence().findByUuid_PrevAndNext(
			id, uuid, orderByComparator);
	}

	/**
	 * Removes all the user portlets where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of user portlets where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user portlets
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the user portlet where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchUserPortletException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching user portlet
	 * @throws NoSuchUserPortletException if a matching user portlet could not be found
	 */
	public static UserPortlet findByUUID_G(String uuid, long groupId)
		throws com.adj.userportlet.exception.NoSuchUserPortletException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the user portlet where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching user portlet, or <code>null</code> if a matching user portlet could not be found
	 */
	public static UserPortlet fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the user portlet where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user portlet, or <code>null</code> if a matching user portlet could not be found
	 */
	public static UserPortlet fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the user portlet where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the user portlet that was removed
	 */
	public static UserPortlet removeByUUID_G(String uuid, long groupId)
		throws com.adj.userportlet.exception.NoSuchUserPortletException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of user portlets where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching user portlets
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the user portlets where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching user portlets
	 */
	public static List<UserPortlet> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<UserPortlet> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<UserPortlet> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UserPortlet> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<UserPortlet> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UserPortlet> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first user portlet in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user portlet
	 * @throws NoSuchUserPortletException if a matching user portlet could not be found
	 */
	public static UserPortlet findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<UserPortlet> orderByComparator)
		throws com.adj.userportlet.exception.NoSuchUserPortletException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first user portlet in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user portlet, or <code>null</code> if a matching user portlet could not be found
	 */
	public static UserPortlet fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<UserPortlet> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last user portlet in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user portlet
	 * @throws NoSuchUserPortletException if a matching user portlet could not be found
	 */
	public static UserPortlet findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<UserPortlet> orderByComparator)
		throws com.adj.userportlet.exception.NoSuchUserPortletException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last user portlet in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user portlet, or <code>null</code> if a matching user portlet could not be found
	 */
	public static UserPortlet fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<UserPortlet> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static UserPortlet[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			OrderByComparator<UserPortlet> orderByComparator)
		throws com.adj.userportlet.exception.NoSuchUserPortletException {

		return getPersistence().findByUuid_C_PrevAndNext(
			id, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the user portlets where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of user portlets where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching user portlets
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the user portlet where portletId = &#63; or throws a <code>NoSuchUserPortletException</code> if it could not be found.
	 *
	 * @param portletId the portlet ID
	 * @return the matching user portlet
	 * @throws NoSuchUserPortletException if a matching user portlet could not be found
	 */
	public static UserPortlet findByPortletId(String portletId)
		throws com.adj.userportlet.exception.NoSuchUserPortletException {

		return getPersistence().findByPortletId(portletId);
	}

	/**
	 * Returns the user portlet where portletId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param portletId the portlet ID
	 * @return the matching user portlet, or <code>null</code> if a matching user portlet could not be found
	 */
	public static UserPortlet fetchByPortletId(String portletId) {
		return getPersistence().fetchByPortletId(portletId);
	}

	/**
	 * Returns the user portlet where portletId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param portletId the portlet ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user portlet, or <code>null</code> if a matching user portlet could not be found
	 */
	public static UserPortlet fetchByPortletId(
		String portletId, boolean useFinderCache) {

		return getPersistence().fetchByPortletId(portletId, useFinderCache);
	}

	/**
	 * Removes the user portlet where portletId = &#63; from the database.
	 *
	 * @param portletId the portlet ID
	 * @return the user portlet that was removed
	 */
	public static UserPortlet removeByPortletId(String portletId)
		throws com.adj.userportlet.exception.NoSuchUserPortletException {

		return getPersistence().removeByPortletId(portletId);
	}

	/**
	 * Returns the number of user portlets where portletId = &#63;.
	 *
	 * @param portletId the portlet ID
	 * @return the number of matching user portlets
	 */
	public static int countByPortletId(String portletId) {
		return getPersistence().countByPortletId(portletId);
	}

	/**
	 * Caches the user portlet in the entity cache if it is enabled.
	 *
	 * @param userPortlet the user portlet
	 */
	public static void cacheResult(UserPortlet userPortlet) {
		getPersistence().cacheResult(userPortlet);
	}

	/**
	 * Caches the user portlets in the entity cache if it is enabled.
	 *
	 * @param userPortlets the user portlets
	 */
	public static void cacheResult(List<UserPortlet> userPortlets) {
		getPersistence().cacheResult(userPortlets);
	}

	/**
	 * Creates a new user portlet with the primary key. Does not add the user portlet to the database.
	 *
	 * @param id the primary key for the new user portlet
	 * @return the new user portlet
	 */
	public static UserPortlet create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the user portlet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the user portlet
	 * @return the user portlet that was removed
	 * @throws NoSuchUserPortletException if a user portlet with the primary key could not be found
	 */
	public static UserPortlet remove(long id)
		throws com.adj.userportlet.exception.NoSuchUserPortletException {

		return getPersistence().remove(id);
	}

	public static UserPortlet updateImpl(UserPortlet userPortlet) {
		return getPersistence().updateImpl(userPortlet);
	}

	/**
	 * Returns the user portlet with the primary key or throws a <code>NoSuchUserPortletException</code> if it could not be found.
	 *
	 * @param id the primary key of the user portlet
	 * @return the user portlet
	 * @throws NoSuchUserPortletException if a user portlet with the primary key could not be found
	 */
	public static UserPortlet findByPrimaryKey(long id)
		throws com.adj.userportlet.exception.NoSuchUserPortletException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the user portlet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the user portlet
	 * @return the user portlet, or <code>null</code> if a user portlet with the primary key could not be found
	 */
	public static UserPortlet fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the user portlets.
	 *
	 * @return the user portlets
	 */
	public static List<UserPortlet> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<UserPortlet> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<UserPortlet> findAll(
		int start, int end, OrderByComparator<UserPortlet> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<UserPortlet> findAll(
		int start, int end, OrderByComparator<UserPortlet> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the user portlets from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of user portlets.
	 *
	 * @return the number of user portlets
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static UserPortletPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<UserPortletPersistence, UserPortletPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(UserPortletPersistence.class);

		ServiceTracker<UserPortletPersistence, UserPortletPersistence>
			serviceTracker =
				new ServiceTracker
					<UserPortletPersistence, UserPortletPersistence>(
						bundle.getBundleContext(), UserPortletPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}