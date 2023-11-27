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

import com.adjecti.mdm.liferay.model.DeputationType;

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
 * The persistence utility for the deputation type service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.DeputationTypePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DeputationTypePersistence
 * @generated
 */
public class DeputationTypeUtil {

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
	public static void clearCache(DeputationType deputationType) {
		getPersistence().clearCache(deputationType);
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
	public static Map<Serializable, DeputationType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DeputationType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DeputationType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DeputationType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DeputationType> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DeputationType update(DeputationType deputationType) {
		return getPersistence().update(deputationType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DeputationType update(
		DeputationType deputationType, ServiceContext serviceContext) {

		return getPersistence().update(deputationType, serviceContext);
	}

	/**
	 * Caches the deputation type in the entity cache if it is enabled.
	 *
	 * @param deputationType the deputation type
	 */
	public static void cacheResult(DeputationType deputationType) {
		getPersistence().cacheResult(deputationType);
	}

	/**
	 * Caches the deputation types in the entity cache if it is enabled.
	 *
	 * @param deputationTypes the deputation types
	 */
	public static void cacheResult(List<DeputationType> deputationTypes) {
		getPersistence().cacheResult(deputationTypes);
	}

	/**
	 * Creates a new deputation type with the primary key. Does not add the deputation type to the database.
	 *
	 * @param deputationTypeId the primary key for the new deputation type
	 * @return the new deputation type
	 */
	public static DeputationType create(long deputationTypeId) {
		return getPersistence().create(deputationTypeId);
	}

	/**
	 * Removes the deputation type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param deputationTypeId the primary key of the deputation type
	 * @return the deputation type that was removed
	 * @throws NoSuchDeputationTypeException if a deputation type with the primary key could not be found
	 */
	public static DeputationType remove(long deputationTypeId)
		throws com.adjecti.mdm.liferay.exception.NoSuchDeputationTypeException {

		return getPersistence().remove(deputationTypeId);
	}

	public static DeputationType updateImpl(DeputationType deputationType) {
		return getPersistence().updateImpl(deputationType);
	}

	/**
	 * Returns the deputation type with the primary key or throws a <code>NoSuchDeputationTypeException</code> if it could not be found.
	 *
	 * @param deputationTypeId the primary key of the deputation type
	 * @return the deputation type
	 * @throws NoSuchDeputationTypeException if a deputation type with the primary key could not be found
	 */
	public static DeputationType findByPrimaryKey(long deputationTypeId)
		throws com.adjecti.mdm.liferay.exception.NoSuchDeputationTypeException {

		return getPersistence().findByPrimaryKey(deputationTypeId);
	}

	/**
	 * Returns the deputation type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param deputationTypeId the primary key of the deputation type
	 * @return the deputation type, or <code>null</code> if a deputation type with the primary key could not be found
	 */
	public static DeputationType fetchByPrimaryKey(long deputationTypeId) {
		return getPersistence().fetchByPrimaryKey(deputationTypeId);
	}

	/**
	 * Returns all the deputation types.
	 *
	 * @return the deputation types
	 */
	public static List<DeputationType> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the deputation types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeputationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of deputation types
	 * @param end the upper bound of the range of deputation types (not inclusive)
	 * @return the range of deputation types
	 */
	public static List<DeputationType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the deputation types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeputationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of deputation types
	 * @param end the upper bound of the range of deputation types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of deputation types
	 */
	public static List<DeputationType> findAll(
		int start, int end,
		OrderByComparator<DeputationType> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the deputation types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeputationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of deputation types
	 * @param end the upper bound of the range of deputation types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of deputation types
	 */
	public static List<DeputationType> findAll(
		int start, int end, OrderByComparator<DeputationType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the deputation types from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of deputation types.
	 *
	 * @return the number of deputation types
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DeputationTypePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<DeputationTypePersistence, DeputationTypePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			DeputationTypePersistence.class);

		ServiceTracker<DeputationTypePersistence, DeputationTypePersistence>
			serviceTracker =
				new ServiceTracker
					<DeputationTypePersistence, DeputationTypePersistence>(
						bundle.getBundleContext(),
						DeputationTypePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}