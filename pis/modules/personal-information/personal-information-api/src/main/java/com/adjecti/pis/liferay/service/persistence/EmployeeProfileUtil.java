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

import com.adjecti.pis.liferay.model.EmployeeProfile;

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
 * The persistence utility for the employee profile service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.EmployeeProfilePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeProfilePersistence
 * @generated
 */
public class EmployeeProfileUtil {

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
	public static void clearCache(EmployeeProfile employeeProfile) {
		getPersistence().clearCache(employeeProfile);
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
	public static Map<Serializable, EmployeeProfile> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeProfile> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeProfile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeProfile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeProfile> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeProfile update(EmployeeProfile employeeProfile) {
		return getPersistence().update(employeeProfile);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeProfile update(
		EmployeeProfile employeeProfile, ServiceContext serviceContext) {

		return getPersistence().update(employeeProfile, serviceContext);
	}

	/**
	 * Caches the employee profile in the entity cache if it is enabled.
	 *
	 * @param employeeProfile the employee profile
	 */
	public static void cacheResult(EmployeeProfile employeeProfile) {
		getPersistence().cacheResult(employeeProfile);
	}

	/**
	 * Caches the employee profiles in the entity cache if it is enabled.
	 *
	 * @param employeeProfiles the employee profiles
	 */
	public static void cacheResult(List<EmployeeProfile> employeeProfiles) {
		getPersistence().cacheResult(employeeProfiles);
	}

	/**
	 * Creates a new employee profile with the primary key. Does not add the employee profile to the database.
	 *
	 * @param employeeProfileId the primary key for the new employee profile
	 * @return the new employee profile
	 */
	public static EmployeeProfile create(long employeeProfileId) {
		return getPersistence().create(employeeProfileId);
	}

	/**
	 * Removes the employee profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeProfileId the primary key of the employee profile
	 * @return the employee profile that was removed
	 * @throws NoSuchEmployeeProfileException if a employee profile with the primary key could not be found
	 */
	public static EmployeeProfile remove(long employeeProfileId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeProfileException {

		return getPersistence().remove(employeeProfileId);
	}

	public static EmployeeProfile updateImpl(EmployeeProfile employeeProfile) {
		return getPersistence().updateImpl(employeeProfile);
	}

	/**
	 * Returns the employee profile with the primary key or throws a <code>NoSuchEmployeeProfileException</code> if it could not be found.
	 *
	 * @param employeeProfileId the primary key of the employee profile
	 * @return the employee profile
	 * @throws NoSuchEmployeeProfileException if a employee profile with the primary key could not be found
	 */
	public static EmployeeProfile findByPrimaryKey(long employeeProfileId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeProfileException {

		return getPersistence().findByPrimaryKey(employeeProfileId);
	}

	/**
	 * Returns the employee profile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeProfileId the primary key of the employee profile
	 * @return the employee profile, or <code>null</code> if a employee profile with the primary key could not be found
	 */
	public static EmployeeProfile fetchByPrimaryKey(long employeeProfileId) {
		return getPersistence().fetchByPrimaryKey(employeeProfileId);
	}

	/**
	 * Returns all the employee profiles.
	 *
	 * @return the employee profiles
	 */
	public static List<EmployeeProfile> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employee profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeProfileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee profiles
	 * @param end the upper bound of the range of employee profiles (not inclusive)
	 * @return the range of employee profiles
	 */
	public static List<EmployeeProfile> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employee profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeProfileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee profiles
	 * @param end the upper bound of the range of employee profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee profiles
	 */
	public static List<EmployeeProfile> findAll(
		int start, int end,
		OrderByComparator<EmployeeProfile> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeProfileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee profiles
	 * @param end the upper bound of the range of employee profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee profiles
	 */
	public static List<EmployeeProfile> findAll(
		int start, int end,
		OrderByComparator<EmployeeProfile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee profiles from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee profiles.
	 *
	 * @return the number of employee profiles
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeProfilePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeeProfilePersistence, EmployeeProfilePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EmployeeProfilePersistence.class);

		ServiceTracker<EmployeeProfilePersistence, EmployeeProfilePersistence>
			serviceTracker =
				new ServiceTracker
					<EmployeeProfilePersistence, EmployeeProfilePersistence>(
						bundle.getBundleContext(),
						EmployeeProfilePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}