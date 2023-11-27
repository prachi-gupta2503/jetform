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

package com.adjecti.pis.liferay.service.persistence;

import com.adjecti.pis.liferay.model.MonthlySalaryComponent;

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
 * The persistence utility for the monthly salary component service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.MonthlySalaryComponentPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MonthlySalaryComponentPersistence
 * @generated
 */
public class MonthlySalaryComponentUtil {

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
	public static void clearCache(
		MonthlySalaryComponent monthlySalaryComponent) {

		getPersistence().clearCache(monthlySalaryComponent);
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
	public static Map<Serializable, MonthlySalaryComponent> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MonthlySalaryComponent> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MonthlySalaryComponent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MonthlySalaryComponent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MonthlySalaryComponent> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MonthlySalaryComponent update(
		MonthlySalaryComponent monthlySalaryComponent) {

		return getPersistence().update(monthlySalaryComponent);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MonthlySalaryComponent update(
		MonthlySalaryComponent monthlySalaryComponent,
		ServiceContext serviceContext) {

		return getPersistence().update(monthlySalaryComponent, serviceContext);
	}

	/**
	 * Caches the monthly salary component in the entity cache if it is enabled.
	 *
	 * @param monthlySalaryComponent the monthly salary component
	 */
	public static void cacheResult(
		MonthlySalaryComponent monthlySalaryComponent) {

		getPersistence().cacheResult(monthlySalaryComponent);
	}

	/**
	 * Caches the monthly salary components in the entity cache if it is enabled.
	 *
	 * @param monthlySalaryComponents the monthly salary components
	 */
	public static void cacheResult(
		List<MonthlySalaryComponent> monthlySalaryComponents) {

		getPersistence().cacheResult(monthlySalaryComponents);
	}

	/**
	 * Creates a new monthly salary component with the primary key. Does not add the monthly salary component to the database.
	 *
	 * @param monthlySalaryComponentId the primary key for the new monthly salary component
	 * @return the new monthly salary component
	 */
	public static MonthlySalaryComponent create(long monthlySalaryComponentId) {
		return getPersistence().create(monthlySalaryComponentId);
	}

	/**
	 * Removes the monthly salary component with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param monthlySalaryComponentId the primary key of the monthly salary component
	 * @return the monthly salary component that was removed
	 * @throws NoSuchMonthlySalaryComponentException if a monthly salary component with the primary key could not be found
	 */
	public static MonthlySalaryComponent remove(long monthlySalaryComponentId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchMonthlySalaryComponentException {

		return getPersistence().remove(monthlySalaryComponentId);
	}

	public static MonthlySalaryComponent updateImpl(
		MonthlySalaryComponent monthlySalaryComponent) {

		return getPersistence().updateImpl(monthlySalaryComponent);
	}

	/**
	 * Returns the monthly salary component with the primary key or throws a <code>NoSuchMonthlySalaryComponentException</code> if it could not be found.
	 *
	 * @param monthlySalaryComponentId the primary key of the monthly salary component
	 * @return the monthly salary component
	 * @throws NoSuchMonthlySalaryComponentException if a monthly salary component with the primary key could not be found
	 */
	public static MonthlySalaryComponent findByPrimaryKey(
			long monthlySalaryComponentId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchMonthlySalaryComponentException {

		return getPersistence().findByPrimaryKey(monthlySalaryComponentId);
	}

	/**
	 * Returns the monthly salary component with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param monthlySalaryComponentId the primary key of the monthly salary component
	 * @return the monthly salary component, or <code>null</code> if a monthly salary component with the primary key could not be found
	 */
	public static MonthlySalaryComponent fetchByPrimaryKey(
		long monthlySalaryComponentId) {

		return getPersistence().fetchByPrimaryKey(monthlySalaryComponentId);
	}

	/**
	 * Returns all the monthly salary components.
	 *
	 * @return the monthly salary components
	 */
	public static List<MonthlySalaryComponent> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the monthly salary components.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MonthlySalaryComponentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of monthly salary components
	 * @param end the upper bound of the range of monthly salary components (not inclusive)
	 * @return the range of monthly salary components
	 */
	public static List<MonthlySalaryComponent> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the monthly salary components.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MonthlySalaryComponentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of monthly salary components
	 * @param end the upper bound of the range of monthly salary components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of monthly salary components
	 */
	public static List<MonthlySalaryComponent> findAll(
		int start, int end,
		OrderByComparator<MonthlySalaryComponent> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the monthly salary components.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MonthlySalaryComponentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of monthly salary components
	 * @param end the upper bound of the range of monthly salary components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of monthly salary components
	 */
	public static List<MonthlySalaryComponent> findAll(
		int start, int end,
		OrderByComparator<MonthlySalaryComponent> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the monthly salary components from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of monthly salary components.
	 *
	 * @return the number of monthly salary components
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MonthlySalaryComponentPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<MonthlySalaryComponentPersistence, MonthlySalaryComponentPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			MonthlySalaryComponentPersistence.class);

		ServiceTracker
			<MonthlySalaryComponentPersistence,
			 MonthlySalaryComponentPersistence> serviceTracker =
				new ServiceTracker
					<MonthlySalaryComponentPersistence,
					 MonthlySalaryComponentPersistence>(
						 bundle.getBundleContext(),
						 MonthlySalaryComponentPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}