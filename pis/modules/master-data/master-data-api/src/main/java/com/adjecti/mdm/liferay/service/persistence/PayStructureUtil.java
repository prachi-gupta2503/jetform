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

import com.adjecti.mdm.liferay.model.PayStructure;

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
 * The persistence utility for the pay structure service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.PayStructurePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PayStructurePersistence
 * @generated
 */
public class PayStructureUtil {

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
	public static void clearCache(PayStructure payStructure) {
		getPersistence().clearCache(payStructure);
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
	public static Map<Serializable, PayStructure> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PayStructure> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PayStructure> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PayStructure> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PayStructure> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PayStructure update(PayStructure payStructure) {
		return getPersistence().update(payStructure);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PayStructure update(
		PayStructure payStructure, ServiceContext serviceContext) {

		return getPersistence().update(payStructure, serviceContext);
	}

	/**
	 * Caches the pay structure in the entity cache if it is enabled.
	 *
	 * @param payStructure the pay structure
	 */
	public static void cacheResult(PayStructure payStructure) {
		getPersistence().cacheResult(payStructure);
	}

	/**
	 * Caches the pay structures in the entity cache if it is enabled.
	 *
	 * @param payStructures the pay structures
	 */
	public static void cacheResult(List<PayStructure> payStructures) {
		getPersistence().cacheResult(payStructures);
	}

	/**
	 * Creates a new pay structure with the primary key. Does not add the pay structure to the database.
	 *
	 * @param payStructureId the primary key for the new pay structure
	 * @return the new pay structure
	 */
	public static PayStructure create(long payStructureId) {
		return getPersistence().create(payStructureId);
	}

	/**
	 * Removes the pay structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param payStructureId the primary key of the pay structure
	 * @return the pay structure that was removed
	 * @throws NoSuchPayStructureException if a pay structure with the primary key could not be found
	 */
	public static PayStructure remove(long payStructureId)
		throws com.adjecti.mdm.liferay.exception.NoSuchPayStructureException {

		return getPersistence().remove(payStructureId);
	}

	public static PayStructure updateImpl(PayStructure payStructure) {
		return getPersistence().updateImpl(payStructure);
	}

	/**
	 * Returns the pay structure with the primary key or throws a <code>NoSuchPayStructureException</code> if it could not be found.
	 *
	 * @param payStructureId the primary key of the pay structure
	 * @return the pay structure
	 * @throws NoSuchPayStructureException if a pay structure with the primary key could not be found
	 */
	public static PayStructure findByPrimaryKey(long payStructureId)
		throws com.adjecti.mdm.liferay.exception.NoSuchPayStructureException {

		return getPersistence().findByPrimaryKey(payStructureId);
	}

	/**
	 * Returns the pay structure with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param payStructureId the primary key of the pay structure
	 * @return the pay structure, or <code>null</code> if a pay structure with the primary key could not be found
	 */
	public static PayStructure fetchByPrimaryKey(long payStructureId) {
		return getPersistence().fetchByPrimaryKey(payStructureId);
	}

	/**
	 * Returns all the pay structures.
	 *
	 * @return the pay structures
	 */
	public static List<PayStructure> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the pay structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay structures
	 * @param end the upper bound of the range of pay structures (not inclusive)
	 * @return the range of pay structures
	 */
	public static List<PayStructure> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the pay structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay structures
	 * @param end the upper bound of the range of pay structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pay structures
	 */
	public static List<PayStructure> findAll(
		int start, int end, OrderByComparator<PayStructure> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pay structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay structures
	 * @param end the upper bound of the range of pay structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pay structures
	 */
	public static List<PayStructure> findAll(
		int start, int end, OrderByComparator<PayStructure> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the pay structures from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of pay structures.
	 *
	 * @return the number of pay structures
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PayStructurePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PayStructurePersistence, PayStructurePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PayStructurePersistence.class);

		ServiceTracker<PayStructurePersistence, PayStructurePersistence>
			serviceTracker =
				new ServiceTracker
					<PayStructurePersistence, PayStructurePersistence>(
						bundle.getBundleContext(),
						PayStructurePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}