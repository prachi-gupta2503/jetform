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

import com.adjecti.mdm.liferay.model.Appellation;

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
 * The persistence utility for the appellation service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.AppellationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AppellationPersistence
 * @generated
 */
public class AppellationUtil {

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
	public static void clearCache(Appellation appellation) {
		getPersistence().clearCache(appellation);
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
	public static Map<Serializable, Appellation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Appellation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Appellation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Appellation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Appellation> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Appellation update(Appellation appellation) {
		return getPersistence().update(appellation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Appellation update(
		Appellation appellation, ServiceContext serviceContext) {

		return getPersistence().update(appellation, serviceContext);
	}

	/**
	 * Caches the appellation in the entity cache if it is enabled.
	 *
	 * @param appellation the appellation
	 */
	public static void cacheResult(Appellation appellation) {
		getPersistence().cacheResult(appellation);
	}

	/**
	 * Caches the appellations in the entity cache if it is enabled.
	 *
	 * @param appellations the appellations
	 */
	public static void cacheResult(List<Appellation> appellations) {
		getPersistence().cacheResult(appellations);
	}

	/**
	 * Creates a new appellation with the primary key. Does not add the appellation to the database.
	 *
	 * @param appellationId the primary key for the new appellation
	 * @return the new appellation
	 */
	public static Appellation create(long appellationId) {
		return getPersistence().create(appellationId);
	}

	/**
	 * Removes the appellation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appellationId the primary key of the appellation
	 * @return the appellation that was removed
	 * @throws NoSuchAppellationException if a appellation with the primary key could not be found
	 */
	public static Appellation remove(long appellationId)
		throws com.adjecti.mdm.liferay.exception.NoSuchAppellationException {

		return getPersistence().remove(appellationId);
	}

	public static Appellation updateImpl(Appellation appellation) {
		return getPersistence().updateImpl(appellation);
	}

	/**
	 * Returns the appellation with the primary key or throws a <code>NoSuchAppellationException</code> if it could not be found.
	 *
	 * @param appellationId the primary key of the appellation
	 * @return the appellation
	 * @throws NoSuchAppellationException if a appellation with the primary key could not be found
	 */
	public static Appellation findByPrimaryKey(long appellationId)
		throws com.adjecti.mdm.liferay.exception.NoSuchAppellationException {

		return getPersistence().findByPrimaryKey(appellationId);
	}

	/**
	 * Returns the appellation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appellationId the primary key of the appellation
	 * @return the appellation, or <code>null</code> if a appellation with the primary key could not be found
	 */
	public static Appellation fetchByPrimaryKey(long appellationId) {
		return getPersistence().fetchByPrimaryKey(appellationId);
	}

	/**
	 * Returns all the appellations.
	 *
	 * @return the appellations
	 */
	public static List<Appellation> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the appellations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppellationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appellations
	 * @param end the upper bound of the range of appellations (not inclusive)
	 * @return the range of appellations
	 */
	public static List<Appellation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the appellations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppellationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appellations
	 * @param end the upper bound of the range of appellations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of appellations
	 */
	public static List<Appellation> findAll(
		int start, int end, OrderByComparator<Appellation> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the appellations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppellationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appellations
	 * @param end the upper bound of the range of appellations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of appellations
	 */
	public static List<Appellation> findAll(
		int start, int end, OrderByComparator<Appellation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the appellations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of appellations.
	 *
	 * @return the number of appellations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AppellationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<AppellationPersistence, AppellationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AppellationPersistence.class);

		ServiceTracker<AppellationPersistence, AppellationPersistence>
			serviceTracker =
				new ServiceTracker
					<AppellationPersistence, AppellationPersistence>(
						bundle.getBundleContext(), AppellationPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}