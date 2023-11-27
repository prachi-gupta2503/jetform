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

package com.adjecti.mdm.liferay.service.persistence;

import com.adjecti.mdm.liferay.model.Religion;

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
 * The persistence utility for the religion service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.ReligionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReligionPersistence
 * @generated
 */
public class ReligionUtil {

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
	public static void clearCache(Religion religion) {
		getPersistence().clearCache(religion);
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
	public static Map<Serializable, Religion> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Religion> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Religion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Religion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Religion> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Religion update(Religion religion) {
		return getPersistence().update(religion);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Religion update(
		Religion religion, ServiceContext serviceContext) {

		return getPersistence().update(religion, serviceContext);
	}

	/**
	 * Returns all the religions where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching religions
	 */
	public static List<Religion> findByCode(String code) {
		return getPersistence().findByCode(code);
	}

	/**
	 * Returns a range of all the religions where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReligionModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of religions
	 * @param end the upper bound of the range of religions (not inclusive)
	 * @return the range of matching religions
	 */
	public static List<Religion> findByCode(String code, int start, int end) {
		return getPersistence().findByCode(code, start, end);
	}

	/**
	 * Returns an ordered range of all the religions where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReligionModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of religions
	 * @param end the upper bound of the range of religions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching religions
	 */
	public static List<Religion> findByCode(
		String code, int start, int end,
		OrderByComparator<Religion> orderByComparator) {

		return getPersistence().findByCode(code, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the religions where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReligionModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of religions
	 * @param end the upper bound of the range of religions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching religions
	 */
	public static List<Religion> findByCode(
		String code, int start, int end,
		OrderByComparator<Religion> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCode(
			code, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first religion in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching religion
	 * @throws NoSuchReligionException if a matching religion could not be found
	 */
	public static Religion findByCode_First(
			String code, OrderByComparator<Religion> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchReligionException {

		return getPersistence().findByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the first religion in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching religion, or <code>null</code> if a matching religion could not be found
	 */
	public static Religion fetchByCode_First(
		String code, OrderByComparator<Religion> orderByComparator) {

		return getPersistence().fetchByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the last religion in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching religion
	 * @throws NoSuchReligionException if a matching religion could not be found
	 */
	public static Religion findByCode_Last(
			String code, OrderByComparator<Religion> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchReligionException {

		return getPersistence().findByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the last religion in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching religion, or <code>null</code> if a matching religion could not be found
	 */
	public static Religion fetchByCode_Last(
		String code, OrderByComparator<Religion> orderByComparator) {

		return getPersistence().fetchByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the religions before and after the current religion in the ordered set where code = &#63;.
	 *
	 * @param religionId the primary key of the current religion
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next religion
	 * @throws NoSuchReligionException if a religion with the primary key could not be found
	 */
	public static Religion[] findByCode_PrevAndNext(
			long religionId, String code,
			OrderByComparator<Religion> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchReligionException {

		return getPersistence().findByCode_PrevAndNext(
			religionId, code, orderByComparator);
	}

	/**
	 * Removes all the religions where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public static void removeByCode(String code) {
		getPersistence().removeByCode(code);
	}

	/**
	 * Returns the number of religions where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching religions
	 */
	public static int countByCode(String code) {
		return getPersistence().countByCode(code);
	}

	/**
	 * Returns all the religions where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching religions
	 */
	public static List<Religion> findByName(String name) {
		return getPersistence().findByName(name);
	}

	/**
	 * Returns a range of all the religions where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReligionModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of religions
	 * @param end the upper bound of the range of religions (not inclusive)
	 * @return the range of matching religions
	 */
	public static List<Religion> findByName(String name, int start, int end) {
		return getPersistence().findByName(name, start, end);
	}

	/**
	 * Returns an ordered range of all the religions where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReligionModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of religions
	 * @param end the upper bound of the range of religions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching religions
	 */
	public static List<Religion> findByName(
		String name, int start, int end,
		OrderByComparator<Religion> orderByComparator) {

		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the religions where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReligionModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of religions
	 * @param end the upper bound of the range of religions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching religions
	 */
	public static List<Religion> findByName(
		String name, int start, int end,
		OrderByComparator<Religion> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByName(
			name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first religion in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching religion
	 * @throws NoSuchReligionException if a matching religion could not be found
	 */
	public static Religion findByName_First(
			String name, OrderByComparator<Religion> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchReligionException {

		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	 * Returns the first religion in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching religion, or <code>null</code> if a matching religion could not be found
	 */
	public static Religion fetchByName_First(
		String name, OrderByComparator<Religion> orderByComparator) {

		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	 * Returns the last religion in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching religion
	 * @throws NoSuchReligionException if a matching religion could not be found
	 */
	public static Religion findByName_Last(
			String name, OrderByComparator<Religion> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchReligionException {

		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the last religion in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching religion, or <code>null</code> if a matching religion could not be found
	 */
	public static Religion fetchByName_Last(
		String name, OrderByComparator<Religion> orderByComparator) {

		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the religions before and after the current religion in the ordered set where name = &#63;.
	 *
	 * @param religionId the primary key of the current religion
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next religion
	 * @throws NoSuchReligionException if a religion with the primary key could not be found
	 */
	public static Religion[] findByName_PrevAndNext(
			long religionId, String name,
			OrderByComparator<Religion> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchReligionException {

		return getPersistence().findByName_PrevAndNext(
			religionId, name, orderByComparator);
	}

	/**
	 * Removes all the religions where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeByName(String name) {
		getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of religions where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching religions
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Caches the religion in the entity cache if it is enabled.
	 *
	 * @param religion the religion
	 */
	public static void cacheResult(Religion religion) {
		getPersistence().cacheResult(religion);
	}

	/**
	 * Caches the religions in the entity cache if it is enabled.
	 *
	 * @param religions the religions
	 */
	public static void cacheResult(List<Religion> religions) {
		getPersistence().cacheResult(religions);
	}

	/**
	 * Creates a new religion with the primary key. Does not add the religion to the database.
	 *
	 * @param religionId the primary key for the new religion
	 * @return the new religion
	 */
	public static Religion create(long religionId) {
		return getPersistence().create(religionId);
	}

	/**
	 * Removes the religion with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param religionId the primary key of the religion
	 * @return the religion that was removed
	 * @throws NoSuchReligionException if a religion with the primary key could not be found
	 */
	public static Religion remove(long religionId)
		throws com.adjecti.mdm.liferay.exception.NoSuchReligionException {

		return getPersistence().remove(religionId);
	}

	public static Religion updateImpl(Religion religion) {
		return getPersistence().updateImpl(religion);
	}

	/**
	 * Returns the religion with the primary key or throws a <code>NoSuchReligionException</code> if it could not be found.
	 *
	 * @param religionId the primary key of the religion
	 * @return the religion
	 * @throws NoSuchReligionException if a religion with the primary key could not be found
	 */
	public static Religion findByPrimaryKey(long religionId)
		throws com.adjecti.mdm.liferay.exception.NoSuchReligionException {

		return getPersistence().findByPrimaryKey(religionId);
	}

	/**
	 * Returns the religion with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param religionId the primary key of the religion
	 * @return the religion, or <code>null</code> if a religion with the primary key could not be found
	 */
	public static Religion fetchByPrimaryKey(long religionId) {
		return getPersistence().fetchByPrimaryKey(religionId);
	}

	/**
	 * Returns all the religions.
	 *
	 * @return the religions
	 */
	public static List<Religion> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the religions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReligionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of religions
	 * @param end the upper bound of the range of religions (not inclusive)
	 * @return the range of religions
	 */
	public static List<Religion> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the religions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReligionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of religions
	 * @param end the upper bound of the range of religions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of religions
	 */
	public static List<Religion> findAll(
		int start, int end, OrderByComparator<Religion> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the religions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReligionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of religions
	 * @param end the upper bound of the range of religions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of religions
	 */
	public static List<Religion> findAll(
		int start, int end, OrderByComparator<Religion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the religions from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of religions.
	 *
	 * @return the number of religions
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ReligionPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ReligionPersistence, ReligionPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ReligionPersistence.class);

		ServiceTracker<ReligionPersistence, ReligionPersistence>
			serviceTracker =
				new ServiceTracker<ReligionPersistence, ReligionPersistence>(
					bundle.getBundleContext(), ReligionPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}