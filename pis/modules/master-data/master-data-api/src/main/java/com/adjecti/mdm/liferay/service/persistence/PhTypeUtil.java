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

import com.adjecti.mdm.liferay.model.PhType;

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
 * The persistence utility for the ph type service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.PhTypePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PhTypePersistence
 * @generated
 */
public class PhTypeUtil {

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
	public static void clearCache(PhType phType) {
		getPersistence().clearCache(phType);
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
	public static Map<Serializable, PhType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PhType> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PhType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PhType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PhType> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PhType update(PhType phType) {
		return getPersistence().update(phType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PhType update(PhType phType, ServiceContext serviceContext) {
		return getPersistence().update(phType, serviceContext);
	}

	/**
	 * Caches the ph type in the entity cache if it is enabled.
	 *
	 * @param phType the ph type
	 */
	public static void cacheResult(PhType phType) {
		getPersistence().cacheResult(phType);
	}

	/**
	 * Caches the ph types in the entity cache if it is enabled.
	 *
	 * @param phTypes the ph types
	 */
	public static void cacheResult(List<PhType> phTypes) {
		getPersistence().cacheResult(phTypes);
	}

	/**
	 * Creates a new ph type with the primary key. Does not add the ph type to the database.
	 *
	 * @param phTypeId the primary key for the new ph type
	 * @return the new ph type
	 */
	public static PhType create(long phTypeId) {
		return getPersistence().create(phTypeId);
	}

	/**
	 * Removes the ph type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param phTypeId the primary key of the ph type
	 * @return the ph type that was removed
	 * @throws NoSuchPhTypeException if a ph type with the primary key could not be found
	 */
	public static PhType remove(long phTypeId)
		throws com.adjecti.mdm.liferay.exception.NoSuchPhTypeException {

		return getPersistence().remove(phTypeId);
	}

	public static PhType updateImpl(PhType phType) {
		return getPersistence().updateImpl(phType);
	}

	/**
	 * Returns the ph type with the primary key or throws a <code>NoSuchPhTypeException</code> if it could not be found.
	 *
	 * @param phTypeId the primary key of the ph type
	 * @return the ph type
	 * @throws NoSuchPhTypeException if a ph type with the primary key could not be found
	 */
	public static PhType findByPrimaryKey(long phTypeId)
		throws com.adjecti.mdm.liferay.exception.NoSuchPhTypeException {

		return getPersistence().findByPrimaryKey(phTypeId);
	}

	/**
	 * Returns the ph type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param phTypeId the primary key of the ph type
	 * @return the ph type, or <code>null</code> if a ph type with the primary key could not be found
	 */
	public static PhType fetchByPrimaryKey(long phTypeId) {
		return getPersistence().fetchByPrimaryKey(phTypeId);
	}

	/**
	 * Returns all the ph types.
	 *
	 * @return the ph types
	 */
	public static List<PhType> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the ph types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ph types
	 * @param end the upper bound of the range of ph types (not inclusive)
	 * @return the range of ph types
	 */
	public static List<PhType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the ph types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ph types
	 * @param end the upper bound of the range of ph types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ph types
	 */
	public static List<PhType> findAll(
		int start, int end, OrderByComparator<PhType> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ph types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ph types
	 * @param end the upper bound of the range of ph types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ph types
	 */
	public static List<PhType> findAll(
		int start, int end, OrderByComparator<PhType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the ph types from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of ph types.
	 *
	 * @return the number of ph types
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PhTypePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PhTypePersistence, PhTypePersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PhTypePersistence.class);

		ServiceTracker<PhTypePersistence, PhTypePersistence> serviceTracker =
			new ServiceTracker<PhTypePersistence, PhTypePersistence>(
				bundle.getBundleContext(), PhTypePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}