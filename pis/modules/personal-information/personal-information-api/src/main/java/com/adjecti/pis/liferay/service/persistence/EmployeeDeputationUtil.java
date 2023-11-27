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

import com.adjecti.pis.liferay.model.EmployeeDeputation;

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
 * The persistence utility for the employee deputation service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.EmployeeDeputationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDeputationPersistence
 * @generated
 */
public class EmployeeDeputationUtil {

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
	public static void clearCache(EmployeeDeputation employeeDeputation) {
		getPersistence().clearCache(employeeDeputation);
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
	public static Map<Serializable, EmployeeDeputation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeDeputation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeDeputation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeDeputation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeDeputation> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeDeputation update(
		EmployeeDeputation employeeDeputation) {

		return getPersistence().update(employeeDeputation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeDeputation update(
		EmployeeDeputation employeeDeputation, ServiceContext serviceContext) {

		return getPersistence().update(employeeDeputation, serviceContext);
	}

	/**
	 * Returns all the employee deputations where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee deputations
	 */
	public static List<EmployeeDeputation> findByEmployeeId(long employeeId) {
		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns a range of all the employee deputations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDeputationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee deputations
	 * @param end the upper bound of the range of employee deputations (not inclusive)
	 * @return the range of matching employee deputations
	 */
	public static List<EmployeeDeputation> findByEmployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee deputations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDeputationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee deputations
	 * @param end the upper bound of the range of employee deputations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee deputations
	 */
	public static List<EmployeeDeputation> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeDeputation> orderByComparator) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee deputations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDeputationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee deputations
	 * @param end the upper bound of the range of employee deputations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee deputations
	 */
	public static List<EmployeeDeputation> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeDeputation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee deputation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee deputation
	 * @throws NoSuchEmployeeDeputationException if a matching employee deputation could not be found
	 */
	public static EmployeeDeputation findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeDeputation> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeDeputationException {

		return getPersistence().findByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first employee deputation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee deputation, or <code>null</code> if a matching employee deputation could not be found
	 */
	public static EmployeeDeputation fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<EmployeeDeputation> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee deputation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee deputation
	 * @throws NoSuchEmployeeDeputationException if a matching employee deputation could not be found
	 */
	public static EmployeeDeputation findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeDeputation> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeDeputationException {

		return getPersistence().findByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee deputation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee deputation, or <code>null</code> if a matching employee deputation could not be found
	 */
	public static EmployeeDeputation fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<EmployeeDeputation> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the employee deputations before and after the current employee deputation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeDeputationId the primary key of the current employee deputation
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee deputation
	 * @throws NoSuchEmployeeDeputationException if a employee deputation with the primary key could not be found
	 */
	public static EmployeeDeputation[] findByEmployeeId_PrevAndNext(
			long employeeDeputationId, long employeeId,
			OrderByComparator<EmployeeDeputation> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeDeputationException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			employeeDeputationId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the employee deputations where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of employee deputations where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee deputations
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Caches the employee deputation in the entity cache if it is enabled.
	 *
	 * @param employeeDeputation the employee deputation
	 */
	public static void cacheResult(EmployeeDeputation employeeDeputation) {
		getPersistence().cacheResult(employeeDeputation);
	}

	/**
	 * Caches the employee deputations in the entity cache if it is enabled.
	 *
	 * @param employeeDeputations the employee deputations
	 */
	public static void cacheResult(
		List<EmployeeDeputation> employeeDeputations) {

		getPersistence().cacheResult(employeeDeputations);
	}

	/**
	 * Creates a new employee deputation with the primary key. Does not add the employee deputation to the database.
	 *
	 * @param employeeDeputationId the primary key for the new employee deputation
	 * @return the new employee deputation
	 */
	public static EmployeeDeputation create(long employeeDeputationId) {
		return getPersistence().create(employeeDeputationId);
	}

	/**
	 * Removes the employee deputation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeDeputationId the primary key of the employee deputation
	 * @return the employee deputation that was removed
	 * @throws NoSuchEmployeeDeputationException if a employee deputation with the primary key could not be found
	 */
	public static EmployeeDeputation remove(long employeeDeputationId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeDeputationException {

		return getPersistence().remove(employeeDeputationId);
	}

	public static EmployeeDeputation updateImpl(
		EmployeeDeputation employeeDeputation) {

		return getPersistence().updateImpl(employeeDeputation);
	}

	/**
	 * Returns the employee deputation with the primary key or throws a <code>NoSuchEmployeeDeputationException</code> if it could not be found.
	 *
	 * @param employeeDeputationId the primary key of the employee deputation
	 * @return the employee deputation
	 * @throws NoSuchEmployeeDeputationException if a employee deputation with the primary key could not be found
	 */
	public static EmployeeDeputation findByPrimaryKey(long employeeDeputationId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeDeputationException {

		return getPersistence().findByPrimaryKey(employeeDeputationId);
	}

	/**
	 * Returns the employee deputation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeDeputationId the primary key of the employee deputation
	 * @return the employee deputation, or <code>null</code> if a employee deputation with the primary key could not be found
	 */
	public static EmployeeDeputation fetchByPrimaryKey(
		long employeeDeputationId) {

		return getPersistence().fetchByPrimaryKey(employeeDeputationId);
	}

	/**
	 * Returns all the employee deputations.
	 *
	 * @return the employee deputations
	 */
	public static List<EmployeeDeputation> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employee deputations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDeputationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee deputations
	 * @param end the upper bound of the range of employee deputations (not inclusive)
	 * @return the range of employee deputations
	 */
	public static List<EmployeeDeputation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employee deputations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDeputationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee deputations
	 * @param end the upper bound of the range of employee deputations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee deputations
	 */
	public static List<EmployeeDeputation> findAll(
		int start, int end,
		OrderByComparator<EmployeeDeputation> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee deputations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDeputationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee deputations
	 * @param end the upper bound of the range of employee deputations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee deputations
	 */
	public static List<EmployeeDeputation> findAll(
		int start, int end,
		OrderByComparator<EmployeeDeputation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee deputations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee deputations.
	 *
	 * @return the number of employee deputations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeDeputationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeeDeputationPersistence, EmployeeDeputationPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EmployeeDeputationPersistence.class);

		ServiceTracker
			<EmployeeDeputationPersistence, EmployeeDeputationPersistence>
				serviceTracker =
					new ServiceTracker
						<EmployeeDeputationPersistence,
						 EmployeeDeputationPersistence>(
							 bundle.getBundleContext(),
							 EmployeeDeputationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}