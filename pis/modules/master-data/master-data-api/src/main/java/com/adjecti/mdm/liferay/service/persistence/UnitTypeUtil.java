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

import com.adjecti.mdm.liferay.model.UnitType;

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
 * The persistence utility for the unit type service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.UnitTypePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UnitTypePersistence
 * @generated
 */
public class UnitTypeUtil {

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
	public static void clearCache(UnitType unitType) {
		getPersistence().clearCache(unitType);
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
	public static Map<Serializable, UnitType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UnitType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UnitType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UnitType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UnitType> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UnitType update(UnitType unitType) {
		return getPersistence().update(unitType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UnitType update(
		UnitType unitType, ServiceContext serviceContext) {

		return getPersistence().update(unitType, serviceContext);
	}

	/**
	 * Caches the unit type in the entity cache if it is enabled.
	 *
	 * @param unitType the unit type
	 */
	public static void cacheResult(UnitType unitType) {
		getPersistence().cacheResult(unitType);
	}

	/**
	 * Caches the unit types in the entity cache if it is enabled.
	 *
	 * @param unitTypes the unit types
	 */
	public static void cacheResult(List<UnitType> unitTypes) {
		getPersistence().cacheResult(unitTypes);
	}

	/**
	 * Creates a new unit type with the primary key. Does not add the unit type to the database.
	 *
	 * @param unitTypeId the primary key for the new unit type
	 * @return the new unit type
	 */
	public static UnitType create(long unitTypeId) {
		return getPersistence().create(unitTypeId);
	}

	/**
	 * Removes the unit type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param unitTypeId the primary key of the unit type
	 * @return the unit type that was removed
	 * @throws NoSuchUnitTypeException if a unit type with the primary key could not be found
	 */
	public static UnitType remove(long unitTypeId)
		throws com.adjecti.mdm.liferay.exception.NoSuchUnitTypeException {

		return getPersistence().remove(unitTypeId);
	}

	public static UnitType updateImpl(UnitType unitType) {
		return getPersistence().updateImpl(unitType);
	}

	/**
	 * Returns the unit type with the primary key or throws a <code>NoSuchUnitTypeException</code> if it could not be found.
	 *
	 * @param unitTypeId the primary key of the unit type
	 * @return the unit type
	 * @throws NoSuchUnitTypeException if a unit type with the primary key could not be found
	 */
	public static UnitType findByPrimaryKey(long unitTypeId)
		throws com.adjecti.mdm.liferay.exception.NoSuchUnitTypeException {

		return getPersistence().findByPrimaryKey(unitTypeId);
	}

	/**
	 * Returns the unit type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param unitTypeId the primary key of the unit type
	 * @return the unit type, or <code>null</code> if a unit type with the primary key could not be found
	 */
	public static UnitType fetchByPrimaryKey(long unitTypeId) {
		return getPersistence().fetchByPrimaryKey(unitTypeId);
	}

	/**
	 * Returns all the unit types.
	 *
	 * @return the unit types
	 */
	public static List<UnitType> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the unit types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UnitTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of unit types
	 * @param end the upper bound of the range of unit types (not inclusive)
	 * @return the range of unit types
	 */
	public static List<UnitType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the unit types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UnitTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of unit types
	 * @param end the upper bound of the range of unit types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of unit types
	 */
	public static List<UnitType> findAll(
		int start, int end, OrderByComparator<UnitType> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the unit types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UnitTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of unit types
	 * @param end the upper bound of the range of unit types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of unit types
	 */
	public static List<UnitType> findAll(
		int start, int end, OrderByComparator<UnitType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the unit types from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of unit types.
	 *
	 * @return the number of unit types
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static UnitTypePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UnitTypePersistence, UnitTypePersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(UnitTypePersistence.class);

		ServiceTracker<UnitTypePersistence, UnitTypePersistence>
			serviceTracker =
				new ServiceTracker<UnitTypePersistence, UnitTypePersistence>(
					bundle.getBundleContext(), UnitTypePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}