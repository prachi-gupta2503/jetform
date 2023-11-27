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

import com.adjecti.mdm.liferay.model.PayHeadType;

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
 * The persistence utility for the pay head type service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.PayHeadTypePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PayHeadTypePersistence
 * @generated
 */
public class PayHeadTypeUtil {

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
	public static void clearCache(PayHeadType payHeadType) {
		getPersistence().clearCache(payHeadType);
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
	public static Map<Serializable, PayHeadType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PayHeadType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PayHeadType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PayHeadType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PayHeadType> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PayHeadType update(PayHeadType payHeadType) {
		return getPersistence().update(payHeadType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PayHeadType update(
		PayHeadType payHeadType, ServiceContext serviceContext) {

		return getPersistence().update(payHeadType, serviceContext);
	}

	/**
	 * Caches the pay head type in the entity cache if it is enabled.
	 *
	 * @param payHeadType the pay head type
	 */
	public static void cacheResult(PayHeadType payHeadType) {
		getPersistence().cacheResult(payHeadType);
	}

	/**
	 * Caches the pay head types in the entity cache if it is enabled.
	 *
	 * @param payHeadTypes the pay head types
	 */
	public static void cacheResult(List<PayHeadType> payHeadTypes) {
		getPersistence().cacheResult(payHeadTypes);
	}

	/**
	 * Creates a new pay head type with the primary key. Does not add the pay head type to the database.
	 *
	 * @param payHeadTypeId the primary key for the new pay head type
	 * @return the new pay head type
	 */
	public static PayHeadType create(long payHeadTypeId) {
		return getPersistence().create(payHeadTypeId);
	}

	/**
	 * Removes the pay head type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param payHeadTypeId the primary key of the pay head type
	 * @return the pay head type that was removed
	 * @throws NoSuchPayHeadTypeException if a pay head type with the primary key could not be found
	 */
	public static PayHeadType remove(long payHeadTypeId)
		throws com.adjecti.mdm.liferay.exception.NoSuchPayHeadTypeException {

		return getPersistence().remove(payHeadTypeId);
	}

	public static PayHeadType updateImpl(PayHeadType payHeadType) {
		return getPersistence().updateImpl(payHeadType);
	}

	/**
	 * Returns the pay head type with the primary key or throws a <code>NoSuchPayHeadTypeException</code> if it could not be found.
	 *
	 * @param payHeadTypeId the primary key of the pay head type
	 * @return the pay head type
	 * @throws NoSuchPayHeadTypeException if a pay head type with the primary key could not be found
	 */
	public static PayHeadType findByPrimaryKey(long payHeadTypeId)
		throws com.adjecti.mdm.liferay.exception.NoSuchPayHeadTypeException {

		return getPersistence().findByPrimaryKey(payHeadTypeId);
	}

	/**
	 * Returns the pay head type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param payHeadTypeId the primary key of the pay head type
	 * @return the pay head type, or <code>null</code> if a pay head type with the primary key could not be found
	 */
	public static PayHeadType fetchByPrimaryKey(long payHeadTypeId) {
		return getPersistence().fetchByPrimaryKey(payHeadTypeId);
	}

	/**
	 * Returns all the pay head types.
	 *
	 * @return the pay head types
	 */
	public static List<PayHeadType> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the pay head types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayHeadTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay head types
	 * @param end the upper bound of the range of pay head types (not inclusive)
	 * @return the range of pay head types
	 */
	public static List<PayHeadType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the pay head types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayHeadTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay head types
	 * @param end the upper bound of the range of pay head types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pay head types
	 */
	public static List<PayHeadType> findAll(
		int start, int end, OrderByComparator<PayHeadType> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pay head types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayHeadTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay head types
	 * @param end the upper bound of the range of pay head types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pay head types
	 */
	public static List<PayHeadType> findAll(
		int start, int end, OrderByComparator<PayHeadType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the pay head types from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of pay head types.
	 *
	 * @return the number of pay head types
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PayHeadTypePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PayHeadTypePersistence, PayHeadTypePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PayHeadTypePersistence.class);

		ServiceTracker<PayHeadTypePersistence, PayHeadTypePersistence>
			serviceTracker =
				new ServiceTracker
					<PayHeadTypePersistence, PayHeadTypePersistence>(
						bundle.getBundleContext(), PayHeadTypePersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}