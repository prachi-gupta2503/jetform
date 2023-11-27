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

import com.adjecti.mdm.liferay.model.Location;

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
 * The persistence utility for the location service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.LocationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LocationPersistence
 * @generated
 */
public class LocationUtil {

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
	public static void clearCache(Location location) {
		getPersistence().clearCache(location);
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
	public static Map<Serializable, Location> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Location> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Location> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Location> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Location> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Location update(Location location) {
		return getPersistence().update(location);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Location update(
		Location location, ServiceContext serviceContext) {

		return getPersistence().update(location, serviceContext);
	}

	/**
	 * Caches the location in the entity cache if it is enabled.
	 *
	 * @param location the location
	 */
	public static void cacheResult(Location location) {
		getPersistence().cacheResult(location);
	}

	/**
	 * Caches the locations in the entity cache if it is enabled.
	 *
	 * @param locations the locations
	 */
	public static void cacheResult(List<Location> locations) {
		getPersistence().cacheResult(locations);
	}

	/**
	 * Creates a new location with the primary key. Does not add the location to the database.
	 *
	 * @param locationId the primary key for the new location
	 * @return the new location
	 */
	public static Location create(long locationId) {
		return getPersistence().create(locationId);
	}

	/**
	 * Removes the location with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param locationId the primary key of the location
	 * @return the location that was removed
	 * @throws NoSuchLocationException if a location with the primary key could not be found
	 */
	public static Location remove(long locationId)
		throws com.adjecti.mdm.liferay.exception.NoSuchLocationException {

		return getPersistence().remove(locationId);
	}

	public static Location updateImpl(Location location) {
		return getPersistence().updateImpl(location);
	}

	/**
	 * Returns the location with the primary key or throws a <code>NoSuchLocationException</code> if it could not be found.
	 *
	 * @param locationId the primary key of the location
	 * @return the location
	 * @throws NoSuchLocationException if a location with the primary key could not be found
	 */
	public static Location findByPrimaryKey(long locationId)
		throws com.adjecti.mdm.liferay.exception.NoSuchLocationException {

		return getPersistence().findByPrimaryKey(locationId);
	}

	/**
	 * Returns the location with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param locationId the primary key of the location
	 * @return the location, or <code>null</code> if a location with the primary key could not be found
	 */
	public static Location fetchByPrimaryKey(long locationId) {
		return getPersistence().fetchByPrimaryKey(locationId);
	}

	/**
	 * Returns all the locations.
	 *
	 * @return the locations
	 */
	public static List<Location> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the locations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of locations
	 * @param end the upper bound of the range of locations (not inclusive)
	 * @return the range of locations
	 */
	public static List<Location> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the locations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of locations
	 * @param end the upper bound of the range of locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of locations
	 */
	public static List<Location> findAll(
		int start, int end, OrderByComparator<Location> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the locations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of locations
	 * @param end the upper bound of the range of locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of locations
	 */
	public static List<Location> findAll(
		int start, int end, OrderByComparator<Location> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the locations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of locations.
	 *
	 * @return the number of locations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LocationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LocationPersistence, LocationPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LocationPersistence.class);

		ServiceTracker<LocationPersistence, LocationPersistence>
			serviceTracker =
				new ServiceTracker<LocationPersistence, LocationPersistence>(
					bundle.getBundleContext(), LocationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}