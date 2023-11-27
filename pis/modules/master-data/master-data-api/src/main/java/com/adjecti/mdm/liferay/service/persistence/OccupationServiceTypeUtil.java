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

import com.adjecti.mdm.liferay.model.OccupationServiceType;

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
 * The persistence utility for the occupation service type service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.OccupationServiceTypePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OccupationServiceTypePersistence
 * @generated
 */
public class OccupationServiceTypeUtil {

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
	public static void clearCache(OccupationServiceType occupationServiceType) {
		getPersistence().clearCache(occupationServiceType);
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
	public static Map<Serializable, OccupationServiceType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<OccupationServiceType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OccupationServiceType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OccupationServiceType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<OccupationServiceType> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static OccupationServiceType update(
		OccupationServiceType occupationServiceType) {

		return getPersistence().update(occupationServiceType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static OccupationServiceType update(
		OccupationServiceType occupationServiceType,
		ServiceContext serviceContext) {

		return getPersistence().update(occupationServiceType, serviceContext);
	}

	/**
	 * Caches the occupation service type in the entity cache if it is enabled.
	 *
	 * @param occupationServiceType the occupation service type
	 */
	public static void cacheResult(
		OccupationServiceType occupationServiceType) {

		getPersistence().cacheResult(occupationServiceType);
	}

	/**
	 * Caches the occupation service types in the entity cache if it is enabled.
	 *
	 * @param occupationServiceTypes the occupation service types
	 */
	public static void cacheResult(
		List<OccupationServiceType> occupationServiceTypes) {

		getPersistence().cacheResult(occupationServiceTypes);
	}

	/**
	 * Creates a new occupation service type with the primary key. Does not add the occupation service type to the database.
	 *
	 * @param occupationServiceTypeId the primary key for the new occupation service type
	 * @return the new occupation service type
	 */
	public static OccupationServiceType create(long occupationServiceTypeId) {
		return getPersistence().create(occupationServiceTypeId);
	}

	/**
	 * Removes the occupation service type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param occupationServiceTypeId the primary key of the occupation service type
	 * @return the occupation service type that was removed
	 * @throws NoSuchOccupationServiceTypeException if a occupation service type with the primary key could not be found
	 */
	public static OccupationServiceType remove(long occupationServiceTypeId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOccupationServiceTypeException {

		return getPersistence().remove(occupationServiceTypeId);
	}

	public static OccupationServiceType updateImpl(
		OccupationServiceType occupationServiceType) {

		return getPersistence().updateImpl(occupationServiceType);
	}

	/**
	 * Returns the occupation service type with the primary key or throws a <code>NoSuchOccupationServiceTypeException</code> if it could not be found.
	 *
	 * @param occupationServiceTypeId the primary key of the occupation service type
	 * @return the occupation service type
	 * @throws NoSuchOccupationServiceTypeException if a occupation service type with the primary key could not be found
	 */
	public static OccupationServiceType findByPrimaryKey(
			long occupationServiceTypeId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOccupationServiceTypeException {

		return getPersistence().findByPrimaryKey(occupationServiceTypeId);
	}

	/**
	 * Returns the occupation service type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param occupationServiceTypeId the primary key of the occupation service type
	 * @return the occupation service type, or <code>null</code> if a occupation service type with the primary key could not be found
	 */
	public static OccupationServiceType fetchByPrimaryKey(
		long occupationServiceTypeId) {

		return getPersistence().fetchByPrimaryKey(occupationServiceTypeId);
	}

	/**
	 * Returns all the occupation service types.
	 *
	 * @return the occupation service types
	 */
	public static List<OccupationServiceType> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the occupation service types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OccupationServiceTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of occupation service types
	 * @param end the upper bound of the range of occupation service types (not inclusive)
	 * @return the range of occupation service types
	 */
	public static List<OccupationServiceType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the occupation service types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OccupationServiceTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of occupation service types
	 * @param end the upper bound of the range of occupation service types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of occupation service types
	 */
	public static List<OccupationServiceType> findAll(
		int start, int end,
		OrderByComparator<OccupationServiceType> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the occupation service types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OccupationServiceTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of occupation service types
	 * @param end the upper bound of the range of occupation service types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of occupation service types
	 */
	public static List<OccupationServiceType> findAll(
		int start, int end,
		OrderByComparator<OccupationServiceType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the occupation service types from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of occupation service types.
	 *
	 * @return the number of occupation service types
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static OccupationServiceTypePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<OccupationServiceTypePersistence, OccupationServiceTypePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			OccupationServiceTypePersistence.class);

		ServiceTracker
			<OccupationServiceTypePersistence, OccupationServiceTypePersistence>
				serviceTracker =
					new ServiceTracker
						<OccupationServiceTypePersistence,
						 OccupationServiceTypePersistence>(
							 bundle.getBundleContext(),
							 OccupationServiceTypePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}