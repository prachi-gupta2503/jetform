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

import com.adjecti.mdm.liferay.model.Occupation;

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
 * The persistence utility for the occupation service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.OccupationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OccupationPersistence
 * @generated
 */
public class OccupationUtil {

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
	public static void clearCache(Occupation occupation) {
		getPersistence().clearCache(occupation);
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
	public static Map<Serializable, Occupation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Occupation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Occupation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Occupation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Occupation> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Occupation update(Occupation occupation) {
		return getPersistence().update(occupation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Occupation update(
		Occupation occupation, ServiceContext serviceContext) {

		return getPersistence().update(occupation, serviceContext);
	}

	/**
	 * Caches the occupation in the entity cache if it is enabled.
	 *
	 * @param occupation the occupation
	 */
	public static void cacheResult(Occupation occupation) {
		getPersistence().cacheResult(occupation);
	}

	/**
	 * Caches the occupations in the entity cache if it is enabled.
	 *
	 * @param occupations the occupations
	 */
	public static void cacheResult(List<Occupation> occupations) {
		getPersistence().cacheResult(occupations);
	}

	/**
	 * Creates a new occupation with the primary key. Does not add the occupation to the database.
	 *
	 * @param occupationId the primary key for the new occupation
	 * @return the new occupation
	 */
	public static Occupation create(long occupationId) {
		return getPersistence().create(occupationId);
	}

	/**
	 * Removes the occupation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param occupationId the primary key of the occupation
	 * @return the occupation that was removed
	 * @throws NoSuchOccupationException if a occupation with the primary key could not be found
	 */
	public static Occupation remove(long occupationId)
		throws com.adjecti.mdm.liferay.exception.NoSuchOccupationException {

		return getPersistence().remove(occupationId);
	}

	public static Occupation updateImpl(Occupation occupation) {
		return getPersistence().updateImpl(occupation);
	}

	/**
	 * Returns the occupation with the primary key or throws a <code>NoSuchOccupationException</code> if it could not be found.
	 *
	 * @param occupationId the primary key of the occupation
	 * @return the occupation
	 * @throws NoSuchOccupationException if a occupation with the primary key could not be found
	 */
	public static Occupation findByPrimaryKey(long occupationId)
		throws com.adjecti.mdm.liferay.exception.NoSuchOccupationException {

		return getPersistence().findByPrimaryKey(occupationId);
	}

	/**
	 * Returns the occupation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param occupationId the primary key of the occupation
	 * @return the occupation, or <code>null</code> if a occupation with the primary key could not be found
	 */
	public static Occupation fetchByPrimaryKey(long occupationId) {
		return getPersistence().fetchByPrimaryKey(occupationId);
	}

	/**
	 * Returns all the occupations.
	 *
	 * @return the occupations
	 */
	public static List<Occupation> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the occupations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OccupationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of occupations
	 * @param end the upper bound of the range of occupations (not inclusive)
	 * @return the range of occupations
	 */
	public static List<Occupation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the occupations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OccupationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of occupations
	 * @param end the upper bound of the range of occupations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of occupations
	 */
	public static List<Occupation> findAll(
		int start, int end, OrderByComparator<Occupation> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the occupations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OccupationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of occupations
	 * @param end the upper bound of the range of occupations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of occupations
	 */
	public static List<Occupation> findAll(
		int start, int end, OrderByComparator<Occupation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the occupations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of occupations.
	 *
	 * @return the number of occupations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static OccupationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<OccupationPersistence, OccupationPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(OccupationPersistence.class);

		ServiceTracker<OccupationPersistence, OccupationPersistence>
			serviceTracker =
				new ServiceTracker
					<OccupationPersistence, OccupationPersistence>(
						bundle.getBundleContext(), OccupationPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}