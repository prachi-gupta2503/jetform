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

import com.adjecti.pis.liferay.model.EmployeeApplication;

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
 * The persistence utility for the employee application service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.EmployeeApplicationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeApplicationPersistence
 * @generated
 */
public class EmployeeApplicationUtil {

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
	public static void clearCache(EmployeeApplication employeeApplication) {
		getPersistence().clearCache(employeeApplication);
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
	public static Map<Serializable, EmployeeApplication> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeApplication> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeApplication> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeApplication> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeApplication> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeApplication update(
		EmployeeApplication employeeApplication) {

		return getPersistence().update(employeeApplication);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeApplication update(
		EmployeeApplication employeeApplication,
		ServiceContext serviceContext) {

		return getPersistence().update(employeeApplication, serviceContext);
	}

	/**
	 * Returns all the employee applications where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee applications
	 */
	public static List<EmployeeApplication> findByEmployeeId(long employeeId) {
		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns a range of all the employee applications where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee applications
	 * @param end the upper bound of the range of employee applications (not inclusive)
	 * @return the range of matching employee applications
	 */
	public static List<EmployeeApplication> findByEmployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee applications where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee applications
	 * @param end the upper bound of the range of employee applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee applications
	 */
	public static List<EmployeeApplication> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeApplication> orderByComparator) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee applications where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee applications
	 * @param end the upper bound of the range of employee applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee applications
	 */
	public static List<EmployeeApplication> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeApplication> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee application in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee application
	 * @throws NoSuchEmployeeApplicationException if a matching employee application could not be found
	 */
	public static EmployeeApplication findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeApplication> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeApplicationException {

		return getPersistence().findByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first employee application in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee application, or <code>null</code> if a matching employee application could not be found
	 */
	public static EmployeeApplication fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<EmployeeApplication> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee application in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee application
	 * @throws NoSuchEmployeeApplicationException if a matching employee application could not be found
	 */
	public static EmployeeApplication findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeApplication> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeApplicationException {

		return getPersistence().findByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee application in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee application, or <code>null</code> if a matching employee application could not be found
	 */
	public static EmployeeApplication fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<EmployeeApplication> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the employee applications before and after the current employee application in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeApplicationId the primary key of the current employee application
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee application
	 * @throws NoSuchEmployeeApplicationException if a employee application with the primary key could not be found
	 */
	public static EmployeeApplication[] findByEmployeeId_PrevAndNext(
			long employeeApplicationId, long employeeId,
			OrderByComparator<EmployeeApplication> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeApplicationException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			employeeApplicationId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the employee applications where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of employee applications where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee applications
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Caches the employee application in the entity cache if it is enabled.
	 *
	 * @param employeeApplication the employee application
	 */
	public static void cacheResult(EmployeeApplication employeeApplication) {
		getPersistence().cacheResult(employeeApplication);
	}

	/**
	 * Caches the employee applications in the entity cache if it is enabled.
	 *
	 * @param employeeApplications the employee applications
	 */
	public static void cacheResult(
		List<EmployeeApplication> employeeApplications) {

		getPersistence().cacheResult(employeeApplications);
	}

	/**
	 * Creates a new employee application with the primary key. Does not add the employee application to the database.
	 *
	 * @param employeeApplicationId the primary key for the new employee application
	 * @return the new employee application
	 */
	public static EmployeeApplication create(long employeeApplicationId) {
		return getPersistence().create(employeeApplicationId);
	}

	/**
	 * Removes the employee application with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeApplicationId the primary key of the employee application
	 * @return the employee application that was removed
	 * @throws NoSuchEmployeeApplicationException if a employee application with the primary key could not be found
	 */
	public static EmployeeApplication remove(long employeeApplicationId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeApplicationException {

		return getPersistence().remove(employeeApplicationId);
	}

	public static EmployeeApplication updateImpl(
		EmployeeApplication employeeApplication) {

		return getPersistence().updateImpl(employeeApplication);
	}

	/**
	 * Returns the employee application with the primary key or throws a <code>NoSuchEmployeeApplicationException</code> if it could not be found.
	 *
	 * @param employeeApplicationId the primary key of the employee application
	 * @return the employee application
	 * @throws NoSuchEmployeeApplicationException if a employee application with the primary key could not be found
	 */
	public static EmployeeApplication findByPrimaryKey(
			long employeeApplicationId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeApplicationException {

		return getPersistence().findByPrimaryKey(employeeApplicationId);
	}

	/**
	 * Returns the employee application with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeApplicationId the primary key of the employee application
	 * @return the employee application, or <code>null</code> if a employee application with the primary key could not be found
	 */
	public static EmployeeApplication fetchByPrimaryKey(
		long employeeApplicationId) {

		return getPersistence().fetchByPrimaryKey(employeeApplicationId);
	}

	/**
	 * Returns all the employee applications.
	 *
	 * @return the employee applications
	 */
	public static List<EmployeeApplication> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employee applications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee applications
	 * @param end the upper bound of the range of employee applications (not inclusive)
	 * @return the range of employee applications
	 */
	public static List<EmployeeApplication> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employee applications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee applications
	 * @param end the upper bound of the range of employee applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee applications
	 */
	public static List<EmployeeApplication> findAll(
		int start, int end,
		OrderByComparator<EmployeeApplication> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee applications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee applications
	 * @param end the upper bound of the range of employee applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee applications
	 */
	public static List<EmployeeApplication> findAll(
		int start, int end,
		OrderByComparator<EmployeeApplication> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee applications from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee applications.
	 *
	 * @return the number of employee applications
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeApplicationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeeApplicationPersistence, EmployeeApplicationPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EmployeeApplicationPersistence.class);

		ServiceTracker
			<EmployeeApplicationPersistence, EmployeeApplicationPersistence>
				serviceTracker =
					new ServiceTracker
						<EmployeeApplicationPersistence,
						 EmployeeApplicationPersistence>(
							 bundle.getBundleContext(),
							 EmployeeApplicationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}