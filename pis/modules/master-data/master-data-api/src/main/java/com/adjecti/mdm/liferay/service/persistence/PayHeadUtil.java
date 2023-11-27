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

import com.adjecti.mdm.liferay.model.PayHead;

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
 * The persistence utility for the pay head service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.PayHeadPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PayHeadPersistence
 * @generated
 */
public class PayHeadUtil {

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
	public static void clearCache(PayHead payHead) {
		getPersistence().clearCache(payHead);
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
	public static Map<Serializable, PayHead> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PayHead> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PayHead> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PayHead> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PayHead> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PayHead update(PayHead payHead) {
		return getPersistence().update(payHead);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PayHead update(
		PayHead payHead, ServiceContext serviceContext) {

		return getPersistence().update(payHead, serviceContext);
	}

	/**
	 * Caches the pay head in the entity cache if it is enabled.
	 *
	 * @param payHead the pay head
	 */
	public static void cacheResult(PayHead payHead) {
		getPersistence().cacheResult(payHead);
	}

	/**
	 * Caches the pay heads in the entity cache if it is enabled.
	 *
	 * @param payHeads the pay heads
	 */
	public static void cacheResult(List<PayHead> payHeads) {
		getPersistence().cacheResult(payHeads);
	}

	/**
	 * Creates a new pay head with the primary key. Does not add the pay head to the database.
	 *
	 * @param payHeadId the primary key for the new pay head
	 * @return the new pay head
	 */
	public static PayHead create(long payHeadId) {
		return getPersistence().create(payHeadId);
	}

	/**
	 * Removes the pay head with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param payHeadId the primary key of the pay head
	 * @return the pay head that was removed
	 * @throws NoSuchPayHeadException if a pay head with the primary key could not be found
	 */
	public static PayHead remove(long payHeadId)
		throws com.adjecti.mdm.liferay.exception.NoSuchPayHeadException {

		return getPersistence().remove(payHeadId);
	}

	public static PayHead updateImpl(PayHead payHead) {
		return getPersistence().updateImpl(payHead);
	}

	/**
	 * Returns the pay head with the primary key or throws a <code>NoSuchPayHeadException</code> if it could not be found.
	 *
	 * @param payHeadId the primary key of the pay head
	 * @return the pay head
	 * @throws NoSuchPayHeadException if a pay head with the primary key could not be found
	 */
	public static PayHead findByPrimaryKey(long payHeadId)
		throws com.adjecti.mdm.liferay.exception.NoSuchPayHeadException {

		return getPersistence().findByPrimaryKey(payHeadId);
	}

	/**
	 * Returns the pay head with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param payHeadId the primary key of the pay head
	 * @return the pay head, or <code>null</code> if a pay head with the primary key could not be found
	 */
	public static PayHead fetchByPrimaryKey(long payHeadId) {
		return getPersistence().fetchByPrimaryKey(payHeadId);
	}

	/**
	 * Returns all the pay heads.
	 *
	 * @return the pay heads
	 */
	public static List<PayHead> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the pay heads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayHeadModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay heads
	 * @param end the upper bound of the range of pay heads (not inclusive)
	 * @return the range of pay heads
	 */
	public static List<PayHead> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the pay heads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayHeadModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay heads
	 * @param end the upper bound of the range of pay heads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pay heads
	 */
	public static List<PayHead> findAll(
		int start, int end, OrderByComparator<PayHead> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pay heads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayHeadModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay heads
	 * @param end the upper bound of the range of pay heads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pay heads
	 */
	public static List<PayHead> findAll(
		int start, int end, OrderByComparator<PayHead> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the pay heads from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of pay heads.
	 *
	 * @return the number of pay heads
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PayHeadPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PayHeadPersistence, PayHeadPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PayHeadPersistence.class);

		ServiceTracker<PayHeadPersistence, PayHeadPersistence> serviceTracker =
			new ServiceTracker<PayHeadPersistence, PayHeadPersistence>(
				bundle.getBundleContext(), PayHeadPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}