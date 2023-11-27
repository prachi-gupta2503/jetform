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

import com.adjecti.mdm.liferay.model.AccomodationType;

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
 * The persistence utility for the accomodation type service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.AccomodationTypePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AccomodationTypePersistence
 * @generated
 */
public class AccomodationTypeUtil {

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
	public static void clearCache(AccomodationType accomodationType) {
		getPersistence().clearCache(accomodationType);
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
	public static Map<Serializable, AccomodationType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AccomodationType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AccomodationType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AccomodationType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AccomodationType> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AccomodationType update(AccomodationType accomodationType) {
		return getPersistence().update(accomodationType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AccomodationType update(
		AccomodationType accomodationType, ServiceContext serviceContext) {

		return getPersistence().update(accomodationType, serviceContext);
	}

	/**
	 * Caches the accomodation type in the entity cache if it is enabled.
	 *
	 * @param accomodationType the accomodation type
	 */
	public static void cacheResult(AccomodationType accomodationType) {
		getPersistence().cacheResult(accomodationType);
	}

	/**
	 * Caches the accomodation types in the entity cache if it is enabled.
	 *
	 * @param accomodationTypes the accomodation types
	 */
	public static void cacheResult(List<AccomodationType> accomodationTypes) {
		getPersistence().cacheResult(accomodationTypes);
	}

	/**
	 * Creates a new accomodation type with the primary key. Does not add the accomodation type to the database.
	 *
	 * @param accomodationTypeId the primary key for the new accomodation type
	 * @return the new accomodation type
	 */
	public static AccomodationType create(long accomodationTypeId) {
		return getPersistence().create(accomodationTypeId);
	}

	/**
	 * Removes the accomodation type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param accomodationTypeId the primary key of the accomodation type
	 * @return the accomodation type that was removed
	 * @throws NoSuchAccomodationTypeException if a accomodation type with the primary key could not be found
	 */
	public static AccomodationType remove(long accomodationTypeId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchAccomodationTypeException {

		return getPersistence().remove(accomodationTypeId);
	}

	public static AccomodationType updateImpl(
		AccomodationType accomodationType) {

		return getPersistence().updateImpl(accomodationType);
	}

	/**
	 * Returns the accomodation type with the primary key or throws a <code>NoSuchAccomodationTypeException</code> if it could not be found.
	 *
	 * @param accomodationTypeId the primary key of the accomodation type
	 * @return the accomodation type
	 * @throws NoSuchAccomodationTypeException if a accomodation type with the primary key could not be found
	 */
	public static AccomodationType findByPrimaryKey(long accomodationTypeId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchAccomodationTypeException {

		return getPersistence().findByPrimaryKey(accomodationTypeId);
	}

	/**
	 * Returns the accomodation type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param accomodationTypeId the primary key of the accomodation type
	 * @return the accomodation type, or <code>null</code> if a accomodation type with the primary key could not be found
	 */
	public static AccomodationType fetchByPrimaryKey(long accomodationTypeId) {
		return getPersistence().fetchByPrimaryKey(accomodationTypeId);
	}

	/**
	 * Returns all the accomodation types.
	 *
	 * @return the accomodation types
	 */
	public static List<AccomodationType> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the accomodation types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccomodationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of accomodation types
	 * @param end the upper bound of the range of accomodation types (not inclusive)
	 * @return the range of accomodation types
	 */
	public static List<AccomodationType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the accomodation types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccomodationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of accomodation types
	 * @param end the upper bound of the range of accomodation types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of accomodation types
	 */
	public static List<AccomodationType> findAll(
		int start, int end,
		OrderByComparator<AccomodationType> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the accomodation types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccomodationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of accomodation types
	 * @param end the upper bound of the range of accomodation types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of accomodation types
	 */
	public static List<AccomodationType> findAll(
		int start, int end,
		OrderByComparator<AccomodationType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the accomodation types from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of accomodation types.
	 *
	 * @return the number of accomodation types
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AccomodationTypePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<AccomodationTypePersistence, AccomodationTypePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			AccomodationTypePersistence.class);

		ServiceTracker<AccomodationTypePersistence, AccomodationTypePersistence>
			serviceTracker =
				new ServiceTracker
					<AccomodationTypePersistence, AccomodationTypePersistence>(
						bundle.getBundleContext(),
						AccomodationTypePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}