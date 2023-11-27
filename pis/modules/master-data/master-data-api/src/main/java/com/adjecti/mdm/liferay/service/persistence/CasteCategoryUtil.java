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

import com.adjecti.mdm.liferay.model.CasteCategory;

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
 * The persistence utility for the caste category service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.CasteCategoryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CasteCategoryPersistence
 * @generated
 */
public class CasteCategoryUtil {

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
	public static void clearCache(CasteCategory casteCategory) {
		getPersistence().clearCache(casteCategory);
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
	public static Map<Serializable, CasteCategory> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CasteCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CasteCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CasteCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CasteCategory> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CasteCategory update(CasteCategory casteCategory) {
		return getPersistence().update(casteCategory);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CasteCategory update(
		CasteCategory casteCategory, ServiceContext serviceContext) {

		return getPersistence().update(casteCategory, serviceContext);
	}

	/**
	 * Returns all the caste categories where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching caste categories
	 */
	public static List<CasteCategory> findByName(String name) {
		return getPersistence().findByName(name);
	}

	/**
	 * Returns a range of all the caste categories where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasteCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of caste categories
	 * @param end the upper bound of the range of caste categories (not inclusive)
	 * @return the range of matching caste categories
	 */
	public static List<CasteCategory> findByName(
		String name, int start, int end) {

		return getPersistence().findByName(name, start, end);
	}

	/**
	 * Returns an ordered range of all the caste categories where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasteCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of caste categories
	 * @param end the upper bound of the range of caste categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching caste categories
	 */
	public static List<CasteCategory> findByName(
		String name, int start, int end,
		OrderByComparator<CasteCategory> orderByComparator) {

		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the caste categories where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasteCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of caste categories
	 * @param end the upper bound of the range of caste categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching caste categories
	 */
	public static List<CasteCategory> findByName(
		String name, int start, int end,
		OrderByComparator<CasteCategory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByName(
			name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first caste category in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching caste category
	 * @throws NoSuchCasteCategoryException if a matching caste category could not be found
	 */
	public static CasteCategory findByName_First(
			String name, OrderByComparator<CasteCategory> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchCasteCategoryException {

		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	 * Returns the first caste category in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching caste category, or <code>null</code> if a matching caste category could not be found
	 */
	public static CasteCategory fetchByName_First(
		String name, OrderByComparator<CasteCategory> orderByComparator) {

		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	 * Returns the last caste category in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching caste category
	 * @throws NoSuchCasteCategoryException if a matching caste category could not be found
	 */
	public static CasteCategory findByName_Last(
			String name, OrderByComparator<CasteCategory> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchCasteCategoryException {

		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the last caste category in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching caste category, or <code>null</code> if a matching caste category could not be found
	 */
	public static CasteCategory fetchByName_Last(
		String name, OrderByComparator<CasteCategory> orderByComparator) {

		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the caste categories before and after the current caste category in the ordered set where name = &#63;.
	 *
	 * @param casteCategoryId the primary key of the current caste category
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next caste category
	 * @throws NoSuchCasteCategoryException if a caste category with the primary key could not be found
	 */
	public static CasteCategory[] findByName_PrevAndNext(
			long casteCategoryId, String name,
			OrderByComparator<CasteCategory> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchCasteCategoryException {

		return getPersistence().findByName_PrevAndNext(
			casteCategoryId, name, orderByComparator);
	}

	/**
	 * Removes all the caste categories where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeByName(String name) {
		getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of caste categories where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching caste categories
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Caches the caste category in the entity cache if it is enabled.
	 *
	 * @param casteCategory the caste category
	 */
	public static void cacheResult(CasteCategory casteCategory) {
		getPersistence().cacheResult(casteCategory);
	}

	/**
	 * Caches the caste categories in the entity cache if it is enabled.
	 *
	 * @param casteCategories the caste categories
	 */
	public static void cacheResult(List<CasteCategory> casteCategories) {
		getPersistence().cacheResult(casteCategories);
	}

	/**
	 * Creates a new caste category with the primary key. Does not add the caste category to the database.
	 *
	 * @param casteCategoryId the primary key for the new caste category
	 * @return the new caste category
	 */
	public static CasteCategory create(long casteCategoryId) {
		return getPersistence().create(casteCategoryId);
	}

	/**
	 * Removes the caste category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param casteCategoryId the primary key of the caste category
	 * @return the caste category that was removed
	 * @throws NoSuchCasteCategoryException if a caste category with the primary key could not be found
	 */
	public static CasteCategory remove(long casteCategoryId)
		throws com.adjecti.mdm.liferay.exception.NoSuchCasteCategoryException {

		return getPersistence().remove(casteCategoryId);
	}

	public static CasteCategory updateImpl(CasteCategory casteCategory) {
		return getPersistence().updateImpl(casteCategory);
	}

	/**
	 * Returns the caste category with the primary key or throws a <code>NoSuchCasteCategoryException</code> if it could not be found.
	 *
	 * @param casteCategoryId the primary key of the caste category
	 * @return the caste category
	 * @throws NoSuchCasteCategoryException if a caste category with the primary key could not be found
	 */
	public static CasteCategory findByPrimaryKey(long casteCategoryId)
		throws com.adjecti.mdm.liferay.exception.NoSuchCasteCategoryException {

		return getPersistence().findByPrimaryKey(casteCategoryId);
	}

	/**
	 * Returns the caste category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param casteCategoryId the primary key of the caste category
	 * @return the caste category, or <code>null</code> if a caste category with the primary key could not be found
	 */
	public static CasteCategory fetchByPrimaryKey(long casteCategoryId) {
		return getPersistence().fetchByPrimaryKey(casteCategoryId);
	}

	/**
	 * Returns all the caste categories.
	 *
	 * @return the caste categories
	 */
	public static List<CasteCategory> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the caste categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasteCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of caste categories
	 * @param end the upper bound of the range of caste categories (not inclusive)
	 * @return the range of caste categories
	 */
	public static List<CasteCategory> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the caste categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasteCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of caste categories
	 * @param end the upper bound of the range of caste categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of caste categories
	 */
	public static List<CasteCategory> findAll(
		int start, int end,
		OrderByComparator<CasteCategory> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the caste categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasteCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of caste categories
	 * @param end the upper bound of the range of caste categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of caste categories
	 */
	public static List<CasteCategory> findAll(
		int start, int end, OrderByComparator<CasteCategory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the caste categories from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of caste categories.
	 *
	 * @return the number of caste categories
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CasteCategoryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CasteCategoryPersistence, CasteCategoryPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CasteCategoryPersistence.class);

		ServiceTracker<CasteCategoryPersistence, CasteCategoryPersistence>
			serviceTracker =
				new ServiceTracker
					<CasteCategoryPersistence, CasteCategoryPersistence>(
						bundle.getBundleContext(),
						CasteCategoryPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}