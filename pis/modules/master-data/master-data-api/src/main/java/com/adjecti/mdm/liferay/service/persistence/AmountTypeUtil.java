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

import com.adjecti.mdm.liferay.model.AmountType;

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
 * The persistence utility for the amount type service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.AmountTypePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AmountTypePersistence
 * @generated
 */
public class AmountTypeUtil {

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
	public static void clearCache(AmountType amountType) {
		getPersistence().clearCache(amountType);
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
	public static Map<Serializable, AmountType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AmountType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AmountType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AmountType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AmountType> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AmountType update(AmountType amountType) {
		return getPersistence().update(amountType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AmountType update(
		AmountType amountType, ServiceContext serviceContext) {

		return getPersistence().update(amountType, serviceContext);
	}

	/**
	 * Caches the amount type in the entity cache if it is enabled.
	 *
	 * @param amountType the amount type
	 */
	public static void cacheResult(AmountType amountType) {
		getPersistence().cacheResult(amountType);
	}

	/**
	 * Caches the amount types in the entity cache if it is enabled.
	 *
	 * @param amountTypes the amount types
	 */
	public static void cacheResult(List<AmountType> amountTypes) {
		getPersistence().cacheResult(amountTypes);
	}

	/**
	 * Creates a new amount type with the primary key. Does not add the amount type to the database.
	 *
	 * @param amountTypeId the primary key for the new amount type
	 * @return the new amount type
	 */
	public static AmountType create(long amountTypeId) {
		return getPersistence().create(amountTypeId);
	}

	/**
	 * Removes the amount type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amountTypeId the primary key of the amount type
	 * @return the amount type that was removed
	 * @throws NoSuchAmountTypeException if a amount type with the primary key could not be found
	 */
	public static AmountType remove(long amountTypeId)
		throws com.adjecti.mdm.liferay.exception.NoSuchAmountTypeException {

		return getPersistence().remove(amountTypeId);
	}

	public static AmountType updateImpl(AmountType amountType) {
		return getPersistence().updateImpl(amountType);
	}

	/**
	 * Returns the amount type with the primary key or throws a <code>NoSuchAmountTypeException</code> if it could not be found.
	 *
	 * @param amountTypeId the primary key of the amount type
	 * @return the amount type
	 * @throws NoSuchAmountTypeException if a amount type with the primary key could not be found
	 */
	public static AmountType findByPrimaryKey(long amountTypeId)
		throws com.adjecti.mdm.liferay.exception.NoSuchAmountTypeException {

		return getPersistence().findByPrimaryKey(amountTypeId);
	}

	/**
	 * Returns the amount type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param amountTypeId the primary key of the amount type
	 * @return the amount type, or <code>null</code> if a amount type with the primary key could not be found
	 */
	public static AmountType fetchByPrimaryKey(long amountTypeId) {
		return getPersistence().fetchByPrimaryKey(amountTypeId);
	}

	/**
	 * Returns all the amount types.
	 *
	 * @return the amount types
	 */
	public static List<AmountType> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the amount types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmountTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amount types
	 * @param end the upper bound of the range of amount types (not inclusive)
	 * @return the range of amount types
	 */
	public static List<AmountType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the amount types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmountTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amount types
	 * @param end the upper bound of the range of amount types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of amount types
	 */
	public static List<AmountType> findAll(
		int start, int end, OrderByComparator<AmountType> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the amount types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmountTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amount types
	 * @param end the upper bound of the range of amount types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of amount types
	 */
	public static List<AmountType> findAll(
		int start, int end, OrderByComparator<AmountType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the amount types from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of amount types.
	 *
	 * @return the number of amount types
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AmountTypePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AmountTypePersistence, AmountTypePersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AmountTypePersistence.class);

		ServiceTracker<AmountTypePersistence, AmountTypePersistence>
			serviceTracker =
				new ServiceTracker
					<AmountTypePersistence, AmountTypePersistence>(
						bundle.getBundleContext(), AmountTypePersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}