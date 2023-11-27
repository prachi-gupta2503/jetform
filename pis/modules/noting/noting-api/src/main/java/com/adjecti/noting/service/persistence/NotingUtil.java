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

package com.adjecti.noting.service.persistence;

import com.adjecti.noting.model.Noting;

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
 * The persistence utility for the noting service. This utility wraps <code>com.adjecti.noting.service.persistence.impl.NotingPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NotingPersistence
 * @generated
 */
public class NotingUtil {

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
	public static void clearCache(Noting noting) {
		getPersistence().clearCache(noting);
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
	public static Map<Serializable, Noting> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Noting> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Noting> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Noting> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Noting> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Noting update(Noting noting) {
		return getPersistence().update(noting);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Noting update(Noting noting, ServiceContext serviceContext) {
		return getPersistence().update(noting, serviceContext);
	}

	/**
	 * Returns all the notings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching notings
	 */
	public static List<Noting> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the notings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of notings
	 * @param end the upper bound of the range of notings (not inclusive)
	 * @return the range of matching notings
	 */
	public static List<Noting> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the notings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of notings
	 * @param end the upper bound of the range of notings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notings
	 */
	public static List<Noting> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Noting> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the notings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of notings
	 * @param end the upper bound of the range of notings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching notings
	 */
	public static List<Noting> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Noting> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first noting in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching noting
	 * @throws NoSuchNotingException if a matching noting could not be found
	 */
	public static Noting findByUuid_First(
			String uuid, OrderByComparator<Noting> orderByComparator)
		throws com.adjecti.noting.exception.NoSuchNotingException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first noting in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching noting, or <code>null</code> if a matching noting could not be found
	 */
	public static Noting fetchByUuid_First(
		String uuid, OrderByComparator<Noting> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last noting in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching noting
	 * @throws NoSuchNotingException if a matching noting could not be found
	 */
	public static Noting findByUuid_Last(
			String uuid, OrderByComparator<Noting> orderByComparator)
		throws com.adjecti.noting.exception.NoSuchNotingException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last noting in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching noting, or <code>null</code> if a matching noting could not be found
	 */
	public static Noting fetchByUuid_Last(
		String uuid, OrderByComparator<Noting> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the notings before and after the current noting in the ordered set where uuid = &#63;.
	 *
	 * @param noteId the primary key of the current noting
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next noting
	 * @throws NoSuchNotingException if a noting with the primary key could not be found
	 */
	public static Noting[] findByUuid_PrevAndNext(
			long noteId, String uuid,
			OrderByComparator<Noting> orderByComparator)
		throws com.adjecti.noting.exception.NoSuchNotingException {

		return getPersistence().findByUuid_PrevAndNext(
			noteId, uuid, orderByComparator);
	}

	/**
	 * Removes all the notings where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of notings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching notings
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the noting where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchNotingException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching noting
	 * @throws NoSuchNotingException if a matching noting could not be found
	 */
	public static Noting findByUUID_G(String uuid, long groupId)
		throws com.adjecti.noting.exception.NoSuchNotingException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the noting where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching noting, or <code>null</code> if a matching noting could not be found
	 */
	public static Noting fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the noting where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching noting, or <code>null</code> if a matching noting could not be found
	 */
	public static Noting fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the noting where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the noting that was removed
	 */
	public static Noting removeByUUID_G(String uuid, long groupId)
		throws com.adjecti.noting.exception.NoSuchNotingException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of notings where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching notings
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the notings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching notings
	 */
	public static List<Noting> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the notings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of notings
	 * @param end the upper bound of the range of notings (not inclusive)
	 * @return the range of matching notings
	 */
	public static List<Noting> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the notings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of notings
	 * @param end the upper bound of the range of notings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notings
	 */
	public static List<Noting> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Noting> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the notings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of notings
	 * @param end the upper bound of the range of notings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching notings
	 */
	public static List<Noting> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Noting> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first noting in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching noting
	 * @throws NoSuchNotingException if a matching noting could not be found
	 */
	public static Noting findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Noting> orderByComparator)
		throws com.adjecti.noting.exception.NoSuchNotingException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first noting in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching noting, or <code>null</code> if a matching noting could not be found
	 */
	public static Noting fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Noting> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last noting in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching noting
	 * @throws NoSuchNotingException if a matching noting could not be found
	 */
	public static Noting findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Noting> orderByComparator)
		throws com.adjecti.noting.exception.NoSuchNotingException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last noting in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching noting, or <code>null</code> if a matching noting could not be found
	 */
	public static Noting fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Noting> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the notings before and after the current noting in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param noteId the primary key of the current noting
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next noting
	 * @throws NoSuchNotingException if a noting with the primary key could not be found
	 */
	public static Noting[] findByUuid_C_PrevAndNext(
			long noteId, String uuid, long companyId,
			OrderByComparator<Noting> orderByComparator)
		throws com.adjecti.noting.exception.NoSuchNotingException {

		return getPersistence().findByUuid_C_PrevAndNext(
			noteId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the notings where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of notings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching notings
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the noting in the entity cache if it is enabled.
	 *
	 * @param noting the noting
	 */
	public static void cacheResult(Noting noting) {
		getPersistence().cacheResult(noting);
	}

	/**
	 * Caches the notings in the entity cache if it is enabled.
	 *
	 * @param notings the notings
	 */
	public static void cacheResult(List<Noting> notings) {
		getPersistence().cacheResult(notings);
	}

	/**
	 * Creates a new noting with the primary key. Does not add the noting to the database.
	 *
	 * @param noteId the primary key for the new noting
	 * @return the new noting
	 */
	public static Noting create(long noteId) {
		return getPersistence().create(noteId);
	}

	/**
	 * Removes the noting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param noteId the primary key of the noting
	 * @return the noting that was removed
	 * @throws NoSuchNotingException if a noting with the primary key could not be found
	 */
	public static Noting remove(long noteId)
		throws com.adjecti.noting.exception.NoSuchNotingException {

		return getPersistence().remove(noteId);
	}

	public static Noting updateImpl(Noting noting) {
		return getPersistence().updateImpl(noting);
	}

	/**
	 * Returns the noting with the primary key or throws a <code>NoSuchNotingException</code> if it could not be found.
	 *
	 * @param noteId the primary key of the noting
	 * @return the noting
	 * @throws NoSuchNotingException if a noting with the primary key could not be found
	 */
	public static Noting findByPrimaryKey(long noteId)
		throws com.adjecti.noting.exception.NoSuchNotingException {

		return getPersistence().findByPrimaryKey(noteId);
	}

	/**
	 * Returns the noting with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param noteId the primary key of the noting
	 * @return the noting, or <code>null</code> if a noting with the primary key could not be found
	 */
	public static Noting fetchByPrimaryKey(long noteId) {
		return getPersistence().fetchByPrimaryKey(noteId);
	}

	/**
	 * Returns all the notings.
	 *
	 * @return the notings
	 */
	public static List<Noting> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the notings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of notings
	 * @param end the upper bound of the range of notings (not inclusive)
	 * @return the range of notings
	 */
	public static List<Noting> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the notings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of notings
	 * @param end the upper bound of the range of notings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of notings
	 */
	public static List<Noting> findAll(
		int start, int end, OrderByComparator<Noting> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the notings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of notings
	 * @param end the upper bound of the range of notings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of notings
	 */
	public static List<Noting> findAll(
		int start, int end, OrderByComparator<Noting> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the notings from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of notings.
	 *
	 * @return the number of notings
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static NotingPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<NotingPersistence, NotingPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(NotingPersistence.class);

		ServiceTracker<NotingPersistence, NotingPersistence> serviceTracker =
			new ServiceTracker<NotingPersistence, NotingPersistence>(
				bundle.getBundleContext(), NotingPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}