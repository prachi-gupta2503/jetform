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

import com.adjecti.pis.liferay.model.MonthlySalary;

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
 * The persistence utility for the monthly salary service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.MonthlySalaryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MonthlySalaryPersistence
 * @generated
 */
public class MonthlySalaryUtil {

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
	public static void clearCache(MonthlySalary monthlySalary) {
		getPersistence().clearCache(monthlySalary);
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
	public static Map<Serializable, MonthlySalary> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MonthlySalary> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MonthlySalary> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MonthlySalary> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MonthlySalary> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MonthlySalary update(MonthlySalary monthlySalary) {
		return getPersistence().update(monthlySalary);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MonthlySalary update(
		MonthlySalary monthlySalary, ServiceContext serviceContext) {

		return getPersistence().update(monthlySalary, serviceContext);
	}

	/**
	 * Caches the monthly salary in the entity cache if it is enabled.
	 *
	 * @param monthlySalary the monthly salary
	 */
	public static void cacheResult(MonthlySalary monthlySalary) {
		getPersistence().cacheResult(monthlySalary);
	}

	/**
	 * Caches the monthly salaries in the entity cache if it is enabled.
	 *
	 * @param monthlySalaries the monthly salaries
	 */
	public static void cacheResult(List<MonthlySalary> monthlySalaries) {
		getPersistence().cacheResult(monthlySalaries);
	}

	/**
	 * Creates a new monthly salary with the primary key. Does not add the monthly salary to the database.
	 *
	 * @param monthlySalaryId the primary key for the new monthly salary
	 * @return the new monthly salary
	 */
	public static MonthlySalary create(long monthlySalaryId) {
		return getPersistence().create(monthlySalaryId);
	}

	/**
	 * Removes the monthly salary with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param monthlySalaryId the primary key of the monthly salary
	 * @return the monthly salary that was removed
	 * @throws NoSuchMonthlySalaryException if a monthly salary with the primary key could not be found
	 */
	public static MonthlySalary remove(long monthlySalaryId)
		throws com.adjecti.pis.liferay.exception.NoSuchMonthlySalaryException {

		return getPersistence().remove(monthlySalaryId);
	}

	public static MonthlySalary updateImpl(MonthlySalary monthlySalary) {
		return getPersistence().updateImpl(monthlySalary);
	}

	/**
	 * Returns the monthly salary with the primary key or throws a <code>NoSuchMonthlySalaryException</code> if it could not be found.
	 *
	 * @param monthlySalaryId the primary key of the monthly salary
	 * @return the monthly salary
	 * @throws NoSuchMonthlySalaryException if a monthly salary with the primary key could not be found
	 */
	public static MonthlySalary findByPrimaryKey(long monthlySalaryId)
		throws com.adjecti.pis.liferay.exception.NoSuchMonthlySalaryException {

		return getPersistence().findByPrimaryKey(monthlySalaryId);
	}

	/**
	 * Returns the monthly salary with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param monthlySalaryId the primary key of the monthly salary
	 * @return the monthly salary, or <code>null</code> if a monthly salary with the primary key could not be found
	 */
	public static MonthlySalary fetchByPrimaryKey(long monthlySalaryId) {
		return getPersistence().fetchByPrimaryKey(monthlySalaryId);
	}

	/**
	 * Returns all the monthly salaries.
	 *
	 * @return the monthly salaries
	 */
	public static List<MonthlySalary> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the monthly salaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MonthlySalaryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of monthly salaries
	 * @param end the upper bound of the range of monthly salaries (not inclusive)
	 * @return the range of monthly salaries
	 */
	public static List<MonthlySalary> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the monthly salaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MonthlySalaryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of monthly salaries
	 * @param end the upper bound of the range of monthly salaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of monthly salaries
	 */
	public static List<MonthlySalary> findAll(
		int start, int end,
		OrderByComparator<MonthlySalary> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the monthly salaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MonthlySalaryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of monthly salaries
	 * @param end the upper bound of the range of monthly salaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of monthly salaries
	 */
	public static List<MonthlySalary> findAll(
		int start, int end, OrderByComparator<MonthlySalary> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the monthly salaries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of monthly salaries.
	 *
	 * @return the number of monthly salaries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MonthlySalaryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<MonthlySalaryPersistence, MonthlySalaryPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MonthlySalaryPersistence.class);

		ServiceTracker<MonthlySalaryPersistence, MonthlySalaryPersistence>
			serviceTracker =
				new ServiceTracker
					<MonthlySalaryPersistence, MonthlySalaryPersistence>(
						bundle.getBundleContext(),
						MonthlySalaryPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}