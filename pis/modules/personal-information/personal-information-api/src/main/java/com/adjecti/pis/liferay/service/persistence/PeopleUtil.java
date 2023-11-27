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

import com.adjecti.pis.liferay.model.People;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the people service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.PeoplePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PeoplePersistence
 * @generated
 */
public class PeopleUtil {

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
	public static void clearCache(People people) {
		getPersistence().clearCache(people);
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
	public static Map<Serializable, People> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<People> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<People> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<People> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<People> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static People update(People people) {
		return getPersistence().update(people);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static People update(People people, ServiceContext serviceContext) {
		return getPersistence().update(people, serviceContext);
	}

	/**
	 * Returns all the peoples where dateOfBirth = &#63;.
	 *
	 * @param dateOfBirth the date of birth
	 * @return the matching peoples
	 */
	public static List<People> findByDateOfBirth(Date dateOfBirth) {
		return getPersistence().findByDateOfBirth(dateOfBirth);
	}

	/**
	 * Returns a range of all the peoples where dateOfBirth = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param dateOfBirth the date of birth
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @return the range of matching peoples
	 */
	public static List<People> findByDateOfBirth(
		Date dateOfBirth, int start, int end) {

		return getPersistence().findByDateOfBirth(dateOfBirth, start, end);
	}

	/**
	 * Returns an ordered range of all the peoples where dateOfBirth = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param dateOfBirth the date of birth
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching peoples
	 */
	public static List<People> findByDateOfBirth(
		Date dateOfBirth, int start, int end,
		OrderByComparator<People> orderByComparator) {

		return getPersistence().findByDateOfBirth(
			dateOfBirth, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the peoples where dateOfBirth = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param dateOfBirth the date of birth
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching peoples
	 */
	public static List<People> findByDateOfBirth(
		Date dateOfBirth, int start, int end,
		OrderByComparator<People> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByDateOfBirth(
			dateOfBirth, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first people in the ordered set where dateOfBirth = &#63;.
	 *
	 * @param dateOfBirth the date of birth
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	public static People findByDateOfBirth_First(
			Date dateOfBirth, OrderByComparator<People> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchPeopleException {

		return getPersistence().findByDateOfBirth_First(
			dateOfBirth, orderByComparator);
	}

	/**
	 * Returns the first people in the ordered set where dateOfBirth = &#63;.
	 *
	 * @param dateOfBirth the date of birth
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people, or <code>null</code> if a matching people could not be found
	 */
	public static People fetchByDateOfBirth_First(
		Date dateOfBirth, OrderByComparator<People> orderByComparator) {

		return getPersistence().fetchByDateOfBirth_First(
			dateOfBirth, orderByComparator);
	}

	/**
	 * Returns the last people in the ordered set where dateOfBirth = &#63;.
	 *
	 * @param dateOfBirth the date of birth
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	public static People findByDateOfBirth_Last(
			Date dateOfBirth, OrderByComparator<People> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchPeopleException {

		return getPersistence().findByDateOfBirth_Last(
			dateOfBirth, orderByComparator);
	}

	/**
	 * Returns the last people in the ordered set where dateOfBirth = &#63;.
	 *
	 * @param dateOfBirth the date of birth
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people, or <code>null</code> if a matching people could not be found
	 */
	public static People fetchByDateOfBirth_Last(
		Date dateOfBirth, OrderByComparator<People> orderByComparator) {

		return getPersistence().fetchByDateOfBirth_Last(
			dateOfBirth, orderByComparator);
	}

	/**
	 * Returns the peoples before and after the current people in the ordered set where dateOfBirth = &#63;.
	 *
	 * @param peopleId the primary key of the current people
	 * @param dateOfBirth the date of birth
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next people
	 * @throws NoSuchPeopleException if a people with the primary key could not be found
	 */
	public static People[] findByDateOfBirth_PrevAndNext(
			long peopleId, Date dateOfBirth,
			OrderByComparator<People> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchPeopleException {

		return getPersistence().findByDateOfBirth_PrevAndNext(
			peopleId, dateOfBirth, orderByComparator);
	}

	/**
	 * Removes all the peoples where dateOfBirth = &#63; from the database.
	 *
	 * @param dateOfBirth the date of birth
	 */
	public static void removeByDateOfBirth(Date dateOfBirth) {
		getPersistence().removeByDateOfBirth(dateOfBirth);
	}

	/**
	 * Returns the number of peoples where dateOfBirth = &#63;.
	 *
	 * @param dateOfBirth the date of birth
	 * @return the number of matching peoples
	 */
	public static int countByDateOfBirth(Date dateOfBirth) {
		return getPersistence().countByDateOfBirth(dateOfBirth);
	}

	/**
	 * Returns all the peoples where appellationId = &#63;.
	 *
	 * @param appellationId the appellation ID
	 * @return the matching peoples
	 */
	public static List<People> findByAppellationId(long appellationId) {
		return getPersistence().findByAppellationId(appellationId);
	}

	/**
	 * Returns a range of all the peoples where appellationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param appellationId the appellation ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @return the range of matching peoples
	 */
	public static List<People> findByAppellationId(
		long appellationId, int start, int end) {

		return getPersistence().findByAppellationId(appellationId, start, end);
	}

	/**
	 * Returns an ordered range of all the peoples where appellationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param appellationId the appellation ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching peoples
	 */
	public static List<People> findByAppellationId(
		long appellationId, int start, int end,
		OrderByComparator<People> orderByComparator) {

		return getPersistence().findByAppellationId(
			appellationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the peoples where appellationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param appellationId the appellation ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching peoples
	 */
	public static List<People> findByAppellationId(
		long appellationId, int start, int end,
		OrderByComparator<People> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByAppellationId(
			appellationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first people in the ordered set where appellationId = &#63;.
	 *
	 * @param appellationId the appellation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	public static People findByAppellationId_First(
			long appellationId, OrderByComparator<People> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchPeopleException {

		return getPersistence().findByAppellationId_First(
			appellationId, orderByComparator);
	}

	/**
	 * Returns the first people in the ordered set where appellationId = &#63;.
	 *
	 * @param appellationId the appellation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people, or <code>null</code> if a matching people could not be found
	 */
	public static People fetchByAppellationId_First(
		long appellationId, OrderByComparator<People> orderByComparator) {

		return getPersistence().fetchByAppellationId_First(
			appellationId, orderByComparator);
	}

	/**
	 * Returns the last people in the ordered set where appellationId = &#63;.
	 *
	 * @param appellationId the appellation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	public static People findByAppellationId_Last(
			long appellationId, OrderByComparator<People> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchPeopleException {

		return getPersistence().findByAppellationId_Last(
			appellationId, orderByComparator);
	}

	/**
	 * Returns the last people in the ordered set where appellationId = &#63;.
	 *
	 * @param appellationId the appellation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people, or <code>null</code> if a matching people could not be found
	 */
	public static People fetchByAppellationId_Last(
		long appellationId, OrderByComparator<People> orderByComparator) {

		return getPersistence().fetchByAppellationId_Last(
			appellationId, orderByComparator);
	}

	/**
	 * Returns the peoples before and after the current people in the ordered set where appellationId = &#63;.
	 *
	 * @param peopleId the primary key of the current people
	 * @param appellationId the appellation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next people
	 * @throws NoSuchPeopleException if a people with the primary key could not be found
	 */
	public static People[] findByAppellationId_PrevAndNext(
			long peopleId, long appellationId,
			OrderByComparator<People> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchPeopleException {

		return getPersistence().findByAppellationId_PrevAndNext(
			peopleId, appellationId, orderByComparator);
	}

	/**
	 * Removes all the peoples where appellationId = &#63; from the database.
	 *
	 * @param appellationId the appellation ID
	 */
	public static void removeByAppellationId(long appellationId) {
		getPersistence().removeByAppellationId(appellationId);
	}

	/**
	 * Returns the number of peoples where appellationId = &#63;.
	 *
	 * @param appellationId the appellation ID
	 * @return the number of matching peoples
	 */
	public static int countByAppellationId(long appellationId) {
		return getPersistence().countByAppellationId(appellationId);
	}

	/**
	 * Returns all the peoples where genderId = &#63;.
	 *
	 * @param genderId the gender ID
	 * @return the matching peoples
	 */
	public static List<People> findByGenderId(long genderId) {
		return getPersistence().findByGenderId(genderId);
	}

	/**
	 * Returns a range of all the peoples where genderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param genderId the gender ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @return the range of matching peoples
	 */
	public static List<People> findByGenderId(
		long genderId, int start, int end) {

		return getPersistence().findByGenderId(genderId, start, end);
	}

	/**
	 * Returns an ordered range of all the peoples where genderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param genderId the gender ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching peoples
	 */
	public static List<People> findByGenderId(
		long genderId, int start, int end,
		OrderByComparator<People> orderByComparator) {

		return getPersistence().findByGenderId(
			genderId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the peoples where genderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param genderId the gender ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching peoples
	 */
	public static List<People> findByGenderId(
		long genderId, int start, int end,
		OrderByComparator<People> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGenderId(
			genderId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first people in the ordered set where genderId = &#63;.
	 *
	 * @param genderId the gender ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	public static People findByGenderId_First(
			long genderId, OrderByComparator<People> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchPeopleException {

		return getPersistence().findByGenderId_First(
			genderId, orderByComparator);
	}

	/**
	 * Returns the first people in the ordered set where genderId = &#63;.
	 *
	 * @param genderId the gender ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people, or <code>null</code> if a matching people could not be found
	 */
	public static People fetchByGenderId_First(
		long genderId, OrderByComparator<People> orderByComparator) {

		return getPersistence().fetchByGenderId_First(
			genderId, orderByComparator);
	}

	/**
	 * Returns the last people in the ordered set where genderId = &#63;.
	 *
	 * @param genderId the gender ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	public static People findByGenderId_Last(
			long genderId, OrderByComparator<People> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchPeopleException {

		return getPersistence().findByGenderId_Last(
			genderId, orderByComparator);
	}

	/**
	 * Returns the last people in the ordered set where genderId = &#63;.
	 *
	 * @param genderId the gender ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people, or <code>null</code> if a matching people could not be found
	 */
	public static People fetchByGenderId_Last(
		long genderId, OrderByComparator<People> orderByComparator) {

		return getPersistence().fetchByGenderId_Last(
			genderId, orderByComparator);
	}

	/**
	 * Returns the peoples before and after the current people in the ordered set where genderId = &#63;.
	 *
	 * @param peopleId the primary key of the current people
	 * @param genderId the gender ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next people
	 * @throws NoSuchPeopleException if a people with the primary key could not be found
	 */
	public static People[] findByGenderId_PrevAndNext(
			long peopleId, long genderId,
			OrderByComparator<People> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchPeopleException {

		return getPersistence().findByGenderId_PrevAndNext(
			peopleId, genderId, orderByComparator);
	}

	/**
	 * Removes all the peoples where genderId = &#63; from the database.
	 *
	 * @param genderId the gender ID
	 */
	public static void removeByGenderId(long genderId) {
		getPersistence().removeByGenderId(genderId);
	}

	/**
	 * Returns the number of peoples where genderId = &#63;.
	 *
	 * @param genderId the gender ID
	 * @return the number of matching peoples
	 */
	public static int countByGenderId(long genderId) {
		return getPersistence().countByGenderId(genderId);
	}

	/**
	 * Returns all the peoples where maritalStatusId = &#63;.
	 *
	 * @param maritalStatusId the marital status ID
	 * @return the matching peoples
	 */
	public static List<People> findByMaritalStatusId(long maritalStatusId) {
		return getPersistence().findByMaritalStatusId(maritalStatusId);
	}

	/**
	 * Returns a range of all the peoples where maritalStatusId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param maritalStatusId the marital status ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @return the range of matching peoples
	 */
	public static List<People> findByMaritalStatusId(
		long maritalStatusId, int start, int end) {

		return getPersistence().findByMaritalStatusId(
			maritalStatusId, start, end);
	}

	/**
	 * Returns an ordered range of all the peoples where maritalStatusId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param maritalStatusId the marital status ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching peoples
	 */
	public static List<People> findByMaritalStatusId(
		long maritalStatusId, int start, int end,
		OrderByComparator<People> orderByComparator) {

		return getPersistence().findByMaritalStatusId(
			maritalStatusId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the peoples where maritalStatusId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param maritalStatusId the marital status ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching peoples
	 */
	public static List<People> findByMaritalStatusId(
		long maritalStatusId, int start, int end,
		OrderByComparator<People> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByMaritalStatusId(
			maritalStatusId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first people in the ordered set where maritalStatusId = &#63;.
	 *
	 * @param maritalStatusId the marital status ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	public static People findByMaritalStatusId_First(
			long maritalStatusId, OrderByComparator<People> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchPeopleException {

		return getPersistence().findByMaritalStatusId_First(
			maritalStatusId, orderByComparator);
	}

	/**
	 * Returns the first people in the ordered set where maritalStatusId = &#63;.
	 *
	 * @param maritalStatusId the marital status ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people, or <code>null</code> if a matching people could not be found
	 */
	public static People fetchByMaritalStatusId_First(
		long maritalStatusId, OrderByComparator<People> orderByComparator) {

		return getPersistence().fetchByMaritalStatusId_First(
			maritalStatusId, orderByComparator);
	}

	/**
	 * Returns the last people in the ordered set where maritalStatusId = &#63;.
	 *
	 * @param maritalStatusId the marital status ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	public static People findByMaritalStatusId_Last(
			long maritalStatusId, OrderByComparator<People> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchPeopleException {

		return getPersistence().findByMaritalStatusId_Last(
			maritalStatusId, orderByComparator);
	}

	/**
	 * Returns the last people in the ordered set where maritalStatusId = &#63;.
	 *
	 * @param maritalStatusId the marital status ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people, or <code>null</code> if a matching people could not be found
	 */
	public static People fetchByMaritalStatusId_Last(
		long maritalStatusId, OrderByComparator<People> orderByComparator) {

		return getPersistence().fetchByMaritalStatusId_Last(
			maritalStatusId, orderByComparator);
	}

	/**
	 * Returns the peoples before and after the current people in the ordered set where maritalStatusId = &#63;.
	 *
	 * @param peopleId the primary key of the current people
	 * @param maritalStatusId the marital status ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next people
	 * @throws NoSuchPeopleException if a people with the primary key could not be found
	 */
	public static People[] findByMaritalStatusId_PrevAndNext(
			long peopleId, long maritalStatusId,
			OrderByComparator<People> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchPeopleException {

		return getPersistence().findByMaritalStatusId_PrevAndNext(
			peopleId, maritalStatusId, orderByComparator);
	}

	/**
	 * Removes all the peoples where maritalStatusId = &#63; from the database.
	 *
	 * @param maritalStatusId the marital status ID
	 */
	public static void removeByMaritalStatusId(long maritalStatusId) {
		getPersistence().removeByMaritalStatusId(maritalStatusId);
	}

	/**
	 * Returns the number of peoples where maritalStatusId = &#63;.
	 *
	 * @param maritalStatusId the marital status ID
	 * @return the number of matching peoples
	 */
	public static int countByMaritalStatusId(long maritalStatusId) {
		return getPersistence().countByMaritalStatusId(maritalStatusId);
	}

	/**
	 * Returns all the peoples where casteCategoryId = &#63;.
	 *
	 * @param casteCategoryId the caste category ID
	 * @return the matching peoples
	 */
	public static List<People> findByCasteCategoryId(long casteCategoryId) {
		return getPersistence().findByCasteCategoryId(casteCategoryId);
	}

	/**
	 * Returns a range of all the peoples where casteCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param casteCategoryId the caste category ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @return the range of matching peoples
	 */
	public static List<People> findByCasteCategoryId(
		long casteCategoryId, int start, int end) {

		return getPersistence().findByCasteCategoryId(
			casteCategoryId, start, end);
	}

	/**
	 * Returns an ordered range of all the peoples where casteCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param casteCategoryId the caste category ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching peoples
	 */
	public static List<People> findByCasteCategoryId(
		long casteCategoryId, int start, int end,
		OrderByComparator<People> orderByComparator) {

		return getPersistence().findByCasteCategoryId(
			casteCategoryId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the peoples where casteCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param casteCategoryId the caste category ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching peoples
	 */
	public static List<People> findByCasteCategoryId(
		long casteCategoryId, int start, int end,
		OrderByComparator<People> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCasteCategoryId(
			casteCategoryId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first people in the ordered set where casteCategoryId = &#63;.
	 *
	 * @param casteCategoryId the caste category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	public static People findByCasteCategoryId_First(
			long casteCategoryId, OrderByComparator<People> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchPeopleException {

		return getPersistence().findByCasteCategoryId_First(
			casteCategoryId, orderByComparator);
	}

	/**
	 * Returns the first people in the ordered set where casteCategoryId = &#63;.
	 *
	 * @param casteCategoryId the caste category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people, or <code>null</code> if a matching people could not be found
	 */
	public static People fetchByCasteCategoryId_First(
		long casteCategoryId, OrderByComparator<People> orderByComparator) {

		return getPersistence().fetchByCasteCategoryId_First(
			casteCategoryId, orderByComparator);
	}

	/**
	 * Returns the last people in the ordered set where casteCategoryId = &#63;.
	 *
	 * @param casteCategoryId the caste category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	public static People findByCasteCategoryId_Last(
			long casteCategoryId, OrderByComparator<People> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchPeopleException {

		return getPersistence().findByCasteCategoryId_Last(
			casteCategoryId, orderByComparator);
	}

	/**
	 * Returns the last people in the ordered set where casteCategoryId = &#63;.
	 *
	 * @param casteCategoryId the caste category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people, or <code>null</code> if a matching people could not be found
	 */
	public static People fetchByCasteCategoryId_Last(
		long casteCategoryId, OrderByComparator<People> orderByComparator) {

		return getPersistence().fetchByCasteCategoryId_Last(
			casteCategoryId, orderByComparator);
	}

	/**
	 * Returns the peoples before and after the current people in the ordered set where casteCategoryId = &#63;.
	 *
	 * @param peopleId the primary key of the current people
	 * @param casteCategoryId the caste category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next people
	 * @throws NoSuchPeopleException if a people with the primary key could not be found
	 */
	public static People[] findByCasteCategoryId_PrevAndNext(
			long peopleId, long casteCategoryId,
			OrderByComparator<People> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchPeopleException {

		return getPersistence().findByCasteCategoryId_PrevAndNext(
			peopleId, casteCategoryId, orderByComparator);
	}

	/**
	 * Removes all the peoples where casteCategoryId = &#63; from the database.
	 *
	 * @param casteCategoryId the caste category ID
	 */
	public static void removeByCasteCategoryId(long casteCategoryId) {
		getPersistence().removeByCasteCategoryId(casteCategoryId);
	}

	/**
	 * Returns the number of peoples where casteCategoryId = &#63;.
	 *
	 * @param casteCategoryId the caste category ID
	 * @return the number of matching peoples
	 */
	public static int countByCasteCategoryId(long casteCategoryId) {
		return getPersistence().countByCasteCategoryId(casteCategoryId);
	}

	/**
	 * Returns all the peoples where bloodGroupId = &#63;.
	 *
	 * @param bloodGroupId the blood group ID
	 * @return the matching peoples
	 */
	public static List<People> findByBloodGroupId(long bloodGroupId) {
		return getPersistence().findByBloodGroupId(bloodGroupId);
	}

	/**
	 * Returns a range of all the peoples where bloodGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param bloodGroupId the blood group ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @return the range of matching peoples
	 */
	public static List<People> findByBloodGroupId(
		long bloodGroupId, int start, int end) {

		return getPersistence().findByBloodGroupId(bloodGroupId, start, end);
	}

	/**
	 * Returns an ordered range of all the peoples where bloodGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param bloodGroupId the blood group ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching peoples
	 */
	public static List<People> findByBloodGroupId(
		long bloodGroupId, int start, int end,
		OrderByComparator<People> orderByComparator) {

		return getPersistence().findByBloodGroupId(
			bloodGroupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the peoples where bloodGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param bloodGroupId the blood group ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching peoples
	 */
	public static List<People> findByBloodGroupId(
		long bloodGroupId, int start, int end,
		OrderByComparator<People> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByBloodGroupId(
			bloodGroupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first people in the ordered set where bloodGroupId = &#63;.
	 *
	 * @param bloodGroupId the blood group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	public static People findByBloodGroupId_First(
			long bloodGroupId, OrderByComparator<People> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchPeopleException {

		return getPersistence().findByBloodGroupId_First(
			bloodGroupId, orderByComparator);
	}

	/**
	 * Returns the first people in the ordered set where bloodGroupId = &#63;.
	 *
	 * @param bloodGroupId the blood group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people, or <code>null</code> if a matching people could not be found
	 */
	public static People fetchByBloodGroupId_First(
		long bloodGroupId, OrderByComparator<People> orderByComparator) {

		return getPersistence().fetchByBloodGroupId_First(
			bloodGroupId, orderByComparator);
	}

	/**
	 * Returns the last people in the ordered set where bloodGroupId = &#63;.
	 *
	 * @param bloodGroupId the blood group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	public static People findByBloodGroupId_Last(
			long bloodGroupId, OrderByComparator<People> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchPeopleException {

		return getPersistence().findByBloodGroupId_Last(
			bloodGroupId, orderByComparator);
	}

	/**
	 * Returns the last people in the ordered set where bloodGroupId = &#63;.
	 *
	 * @param bloodGroupId the blood group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people, or <code>null</code> if a matching people could not be found
	 */
	public static People fetchByBloodGroupId_Last(
		long bloodGroupId, OrderByComparator<People> orderByComparator) {

		return getPersistence().fetchByBloodGroupId_Last(
			bloodGroupId, orderByComparator);
	}

	/**
	 * Returns the peoples before and after the current people in the ordered set where bloodGroupId = &#63;.
	 *
	 * @param peopleId the primary key of the current people
	 * @param bloodGroupId the blood group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next people
	 * @throws NoSuchPeopleException if a people with the primary key could not be found
	 */
	public static People[] findByBloodGroupId_PrevAndNext(
			long peopleId, long bloodGroupId,
			OrderByComparator<People> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchPeopleException {

		return getPersistence().findByBloodGroupId_PrevAndNext(
			peopleId, bloodGroupId, orderByComparator);
	}

	/**
	 * Removes all the peoples where bloodGroupId = &#63; from the database.
	 *
	 * @param bloodGroupId the blood group ID
	 */
	public static void removeByBloodGroupId(long bloodGroupId) {
		getPersistence().removeByBloodGroupId(bloodGroupId);
	}

	/**
	 * Returns the number of peoples where bloodGroupId = &#63;.
	 *
	 * @param bloodGroupId the blood group ID
	 * @return the number of matching peoples
	 */
	public static int countByBloodGroupId(long bloodGroupId) {
		return getPersistence().countByBloodGroupId(bloodGroupId);
	}

	/**
	 * Returns all the peoples where citizenshipId = &#63;.
	 *
	 * @param citizenshipId the citizenship ID
	 * @return the matching peoples
	 */
	public static List<People> findByCitizenshipId(long citizenshipId) {
		return getPersistence().findByCitizenshipId(citizenshipId);
	}

	/**
	 * Returns a range of all the peoples where citizenshipId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param citizenshipId the citizenship ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @return the range of matching peoples
	 */
	public static List<People> findByCitizenshipId(
		long citizenshipId, int start, int end) {

		return getPersistence().findByCitizenshipId(citizenshipId, start, end);
	}

	/**
	 * Returns an ordered range of all the peoples where citizenshipId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param citizenshipId the citizenship ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching peoples
	 */
	public static List<People> findByCitizenshipId(
		long citizenshipId, int start, int end,
		OrderByComparator<People> orderByComparator) {

		return getPersistence().findByCitizenshipId(
			citizenshipId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the peoples where citizenshipId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param citizenshipId the citizenship ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching peoples
	 */
	public static List<People> findByCitizenshipId(
		long citizenshipId, int start, int end,
		OrderByComparator<People> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCitizenshipId(
			citizenshipId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first people in the ordered set where citizenshipId = &#63;.
	 *
	 * @param citizenshipId the citizenship ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	public static People findByCitizenshipId_First(
			long citizenshipId, OrderByComparator<People> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchPeopleException {

		return getPersistence().findByCitizenshipId_First(
			citizenshipId, orderByComparator);
	}

	/**
	 * Returns the first people in the ordered set where citizenshipId = &#63;.
	 *
	 * @param citizenshipId the citizenship ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people, or <code>null</code> if a matching people could not be found
	 */
	public static People fetchByCitizenshipId_First(
		long citizenshipId, OrderByComparator<People> orderByComparator) {

		return getPersistence().fetchByCitizenshipId_First(
			citizenshipId, orderByComparator);
	}

	/**
	 * Returns the last people in the ordered set where citizenshipId = &#63;.
	 *
	 * @param citizenshipId the citizenship ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	public static People findByCitizenshipId_Last(
			long citizenshipId, OrderByComparator<People> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchPeopleException {

		return getPersistence().findByCitizenshipId_Last(
			citizenshipId, orderByComparator);
	}

	/**
	 * Returns the last people in the ordered set where citizenshipId = &#63;.
	 *
	 * @param citizenshipId the citizenship ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people, or <code>null</code> if a matching people could not be found
	 */
	public static People fetchByCitizenshipId_Last(
		long citizenshipId, OrderByComparator<People> orderByComparator) {

		return getPersistence().fetchByCitizenshipId_Last(
			citizenshipId, orderByComparator);
	}

	/**
	 * Returns the peoples before and after the current people in the ordered set where citizenshipId = &#63;.
	 *
	 * @param peopleId the primary key of the current people
	 * @param citizenshipId the citizenship ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next people
	 * @throws NoSuchPeopleException if a people with the primary key could not be found
	 */
	public static People[] findByCitizenshipId_PrevAndNext(
			long peopleId, long citizenshipId,
			OrderByComparator<People> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchPeopleException {

		return getPersistence().findByCitizenshipId_PrevAndNext(
			peopleId, citizenshipId, orderByComparator);
	}

	/**
	 * Removes all the peoples where citizenshipId = &#63; from the database.
	 *
	 * @param citizenshipId the citizenship ID
	 */
	public static void removeByCitizenshipId(long citizenshipId) {
		getPersistence().removeByCitizenshipId(citizenshipId);
	}

	/**
	 * Returns the number of peoples where citizenshipId = &#63;.
	 *
	 * @param citizenshipId the citizenship ID
	 * @return the number of matching peoples
	 */
	public static int countByCitizenshipId(long citizenshipId) {
		return getPersistence().countByCitizenshipId(citizenshipId);
	}

	/**
	 * Returns all the peoples where phTypeId = &#63;.
	 *
	 * @param phTypeId the ph type ID
	 * @return the matching peoples
	 */
	public static List<People> findByPhTypeId(long phTypeId) {
		return getPersistence().findByPhTypeId(phTypeId);
	}

	/**
	 * Returns a range of all the peoples where phTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param phTypeId the ph type ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @return the range of matching peoples
	 */
	public static List<People> findByPhTypeId(
		long phTypeId, int start, int end) {

		return getPersistence().findByPhTypeId(phTypeId, start, end);
	}

	/**
	 * Returns an ordered range of all the peoples where phTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param phTypeId the ph type ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching peoples
	 */
	public static List<People> findByPhTypeId(
		long phTypeId, int start, int end,
		OrderByComparator<People> orderByComparator) {

		return getPersistence().findByPhTypeId(
			phTypeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the peoples where phTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param phTypeId the ph type ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching peoples
	 */
	public static List<People> findByPhTypeId(
		long phTypeId, int start, int end,
		OrderByComparator<People> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByPhTypeId(
			phTypeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first people in the ordered set where phTypeId = &#63;.
	 *
	 * @param phTypeId the ph type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	public static People findByPhTypeId_First(
			long phTypeId, OrderByComparator<People> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchPeopleException {

		return getPersistence().findByPhTypeId_First(
			phTypeId, orderByComparator);
	}

	/**
	 * Returns the first people in the ordered set where phTypeId = &#63;.
	 *
	 * @param phTypeId the ph type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people, or <code>null</code> if a matching people could not be found
	 */
	public static People fetchByPhTypeId_First(
		long phTypeId, OrderByComparator<People> orderByComparator) {

		return getPersistence().fetchByPhTypeId_First(
			phTypeId, orderByComparator);
	}

	/**
	 * Returns the last people in the ordered set where phTypeId = &#63;.
	 *
	 * @param phTypeId the ph type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	public static People findByPhTypeId_Last(
			long phTypeId, OrderByComparator<People> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchPeopleException {

		return getPersistence().findByPhTypeId_Last(
			phTypeId, orderByComparator);
	}

	/**
	 * Returns the last people in the ordered set where phTypeId = &#63;.
	 *
	 * @param phTypeId the ph type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people, or <code>null</code> if a matching people could not be found
	 */
	public static People fetchByPhTypeId_Last(
		long phTypeId, OrderByComparator<People> orderByComparator) {

		return getPersistence().fetchByPhTypeId_Last(
			phTypeId, orderByComparator);
	}

	/**
	 * Returns the peoples before and after the current people in the ordered set where phTypeId = &#63;.
	 *
	 * @param peopleId the primary key of the current people
	 * @param phTypeId the ph type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next people
	 * @throws NoSuchPeopleException if a people with the primary key could not be found
	 */
	public static People[] findByPhTypeId_PrevAndNext(
			long peopleId, long phTypeId,
			OrderByComparator<People> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchPeopleException {

		return getPersistence().findByPhTypeId_PrevAndNext(
			peopleId, phTypeId, orderByComparator);
	}

	/**
	 * Removes all the peoples where phTypeId = &#63; from the database.
	 *
	 * @param phTypeId the ph type ID
	 */
	public static void removeByPhTypeId(long phTypeId) {
		getPersistence().removeByPhTypeId(phTypeId);
	}

	/**
	 * Returns the number of peoples where phTypeId = &#63;.
	 *
	 * @param phTypeId the ph type ID
	 * @return the number of matching peoples
	 */
	public static int countByPhTypeId(long phTypeId) {
		return getPersistence().countByPhTypeId(phTypeId);
	}

	/**
	 * Returns all the peoples where religionId = &#63;.
	 *
	 * @param religionId the religion ID
	 * @return the matching peoples
	 */
	public static List<People> findByReligionId(long religionId) {
		return getPersistence().findByReligionId(religionId);
	}

	/**
	 * Returns a range of all the peoples where religionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param religionId the religion ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @return the range of matching peoples
	 */
	public static List<People> findByReligionId(
		long religionId, int start, int end) {

		return getPersistence().findByReligionId(religionId, start, end);
	}

	/**
	 * Returns an ordered range of all the peoples where religionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param religionId the religion ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching peoples
	 */
	public static List<People> findByReligionId(
		long religionId, int start, int end,
		OrderByComparator<People> orderByComparator) {

		return getPersistence().findByReligionId(
			religionId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the peoples where religionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param religionId the religion ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching peoples
	 */
	public static List<People> findByReligionId(
		long religionId, int start, int end,
		OrderByComparator<People> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByReligionId(
			religionId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first people in the ordered set where religionId = &#63;.
	 *
	 * @param religionId the religion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	public static People findByReligionId_First(
			long religionId, OrderByComparator<People> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchPeopleException {

		return getPersistence().findByReligionId_First(
			religionId, orderByComparator);
	}

	/**
	 * Returns the first people in the ordered set where religionId = &#63;.
	 *
	 * @param religionId the religion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people, or <code>null</code> if a matching people could not be found
	 */
	public static People fetchByReligionId_First(
		long religionId, OrderByComparator<People> orderByComparator) {

		return getPersistence().fetchByReligionId_First(
			religionId, orderByComparator);
	}

	/**
	 * Returns the last people in the ordered set where religionId = &#63;.
	 *
	 * @param religionId the religion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	public static People findByReligionId_Last(
			long religionId, OrderByComparator<People> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchPeopleException {

		return getPersistence().findByReligionId_Last(
			religionId, orderByComparator);
	}

	/**
	 * Returns the last people in the ordered set where religionId = &#63;.
	 *
	 * @param religionId the religion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people, or <code>null</code> if a matching people could not be found
	 */
	public static People fetchByReligionId_Last(
		long religionId, OrderByComparator<People> orderByComparator) {

		return getPersistence().fetchByReligionId_Last(
			religionId, orderByComparator);
	}

	/**
	 * Returns the peoples before and after the current people in the ordered set where religionId = &#63;.
	 *
	 * @param peopleId the primary key of the current people
	 * @param religionId the religion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next people
	 * @throws NoSuchPeopleException if a people with the primary key could not be found
	 */
	public static People[] findByReligionId_PrevAndNext(
			long peopleId, long religionId,
			OrderByComparator<People> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchPeopleException {

		return getPersistence().findByReligionId_PrevAndNext(
			peopleId, religionId, orderByComparator);
	}

	/**
	 * Removes all the peoples where religionId = &#63; from the database.
	 *
	 * @param religionId the religion ID
	 */
	public static void removeByReligionId(long religionId) {
		getPersistence().removeByReligionId(religionId);
	}

	/**
	 * Returns the number of peoples where religionId = &#63;.
	 *
	 * @param religionId the religion ID
	 * @return the number of matching peoples
	 */
	public static int countByReligionId(long religionId) {
		return getPersistence().countByReligionId(religionId);
	}

	/**
	 * Returns all the peoples where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the matching peoples
	 */
	public static List<People> findByJoiningProcessId(long joiningProcessId) {
		return getPersistence().findByJoiningProcessId(joiningProcessId);
	}

	/**
	 * Returns a range of all the peoples where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @return the range of matching peoples
	 */
	public static List<People> findByJoiningProcessId(
		long joiningProcessId, int start, int end) {

		return getPersistence().findByJoiningProcessId(
			joiningProcessId, start, end);
	}

	/**
	 * Returns an ordered range of all the peoples where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching peoples
	 */
	public static List<People> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		OrderByComparator<People> orderByComparator) {

		return getPersistence().findByJoiningProcessId(
			joiningProcessId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the peoples where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching peoples
	 */
	public static List<People> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		OrderByComparator<People> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByJoiningProcessId(
			joiningProcessId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first people in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	public static People findByJoiningProcessId_First(
			long joiningProcessId, OrderByComparator<People> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchPeopleException {

		return getPersistence().findByJoiningProcessId_First(
			joiningProcessId, orderByComparator);
	}

	/**
	 * Returns the first people in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people, or <code>null</code> if a matching people could not be found
	 */
	public static People fetchByJoiningProcessId_First(
		long joiningProcessId, OrderByComparator<People> orderByComparator) {

		return getPersistence().fetchByJoiningProcessId_First(
			joiningProcessId, orderByComparator);
	}

	/**
	 * Returns the last people in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	public static People findByJoiningProcessId_Last(
			long joiningProcessId, OrderByComparator<People> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchPeopleException {

		return getPersistence().findByJoiningProcessId_Last(
			joiningProcessId, orderByComparator);
	}

	/**
	 * Returns the last people in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people, or <code>null</code> if a matching people could not be found
	 */
	public static People fetchByJoiningProcessId_Last(
		long joiningProcessId, OrderByComparator<People> orderByComparator) {

		return getPersistence().fetchByJoiningProcessId_Last(
			joiningProcessId, orderByComparator);
	}

	/**
	 * Returns the peoples before and after the current people in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param peopleId the primary key of the current people
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next people
	 * @throws NoSuchPeopleException if a people with the primary key could not be found
	 */
	public static People[] findByJoiningProcessId_PrevAndNext(
			long peopleId, long joiningProcessId,
			OrderByComparator<People> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchPeopleException {

		return getPersistence().findByJoiningProcessId_PrevAndNext(
			peopleId, joiningProcessId, orderByComparator);
	}

	/**
	 * Removes all the peoples where joiningProcessId = &#63; from the database.
	 *
	 * @param joiningProcessId the joining process ID
	 */
	public static void removeByJoiningProcessId(long joiningProcessId) {
		getPersistence().removeByJoiningProcessId(joiningProcessId);
	}

	/**
	 * Returns the number of peoples where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the number of matching peoples
	 */
	public static int countByJoiningProcessId(long joiningProcessId) {
		return getPersistence().countByJoiningProcessId(joiningProcessId);
	}

	/**
	 * Caches the people in the entity cache if it is enabled.
	 *
	 * @param people the people
	 */
	public static void cacheResult(People people) {
		getPersistence().cacheResult(people);
	}

	/**
	 * Caches the peoples in the entity cache if it is enabled.
	 *
	 * @param peoples the peoples
	 */
	public static void cacheResult(List<People> peoples) {
		getPersistence().cacheResult(peoples);
	}

	/**
	 * Creates a new people with the primary key. Does not add the people to the database.
	 *
	 * @param peopleId the primary key for the new people
	 * @return the new people
	 */
	public static People create(long peopleId) {
		return getPersistence().create(peopleId);
	}

	/**
	 * Removes the people with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param peopleId the primary key of the people
	 * @return the people that was removed
	 * @throws NoSuchPeopleException if a people with the primary key could not be found
	 */
	public static People remove(long peopleId)
		throws com.adjecti.pis.liferay.exception.NoSuchPeopleException {

		return getPersistence().remove(peopleId);
	}

	public static People updateImpl(People people) {
		return getPersistence().updateImpl(people);
	}

	/**
	 * Returns the people with the primary key or throws a <code>NoSuchPeopleException</code> if it could not be found.
	 *
	 * @param peopleId the primary key of the people
	 * @return the people
	 * @throws NoSuchPeopleException if a people with the primary key could not be found
	 */
	public static People findByPrimaryKey(long peopleId)
		throws com.adjecti.pis.liferay.exception.NoSuchPeopleException {

		return getPersistence().findByPrimaryKey(peopleId);
	}

	/**
	 * Returns the people with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param peopleId the primary key of the people
	 * @return the people, or <code>null</code> if a people with the primary key could not be found
	 */
	public static People fetchByPrimaryKey(long peopleId) {
		return getPersistence().fetchByPrimaryKey(peopleId);
	}

	/**
	 * Returns all the peoples.
	 *
	 * @return the peoples
	 */
	public static List<People> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the peoples.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @return the range of peoples
	 */
	public static List<People> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the peoples.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of peoples
	 */
	public static List<People> findAll(
		int start, int end, OrderByComparator<People> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the peoples.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of peoples
	 */
	public static List<People> findAll(
		int start, int end, OrderByComparator<People> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the peoples from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of peoples.
	 *
	 * @return the number of peoples
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PeoplePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PeoplePersistence, PeoplePersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PeoplePersistence.class);

		ServiceTracker<PeoplePersistence, PeoplePersistence> serviceTracker =
			new ServiceTracker<PeoplePersistence, PeoplePersistence>(
				bundle.getBundleContext(), PeoplePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}