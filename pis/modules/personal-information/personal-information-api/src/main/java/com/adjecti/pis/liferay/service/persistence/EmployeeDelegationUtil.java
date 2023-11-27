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

import com.adjecti.pis.liferay.model.EmployeeDelegation;

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
 * The persistence utility for the employee delegation service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.EmployeeDelegationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDelegationPersistence
 * @generated
 */
public class EmployeeDelegationUtil {

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
	public static void clearCache(EmployeeDelegation employeeDelegation) {
		getPersistence().clearCache(employeeDelegation);
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
	public static Map<Serializable, EmployeeDelegation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeDelegation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeDelegation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeDelegation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeDelegation> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeDelegation update(
		EmployeeDelegation employeeDelegation) {

		return getPersistence().update(employeeDelegation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeDelegation update(
		EmployeeDelegation employeeDelegation, ServiceContext serviceContext) {

		return getPersistence().update(employeeDelegation, serviceContext);
	}

	/**
	 * Returns all the employee delegations where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee delegations
	 */
	public static List<EmployeeDelegation> findByEmployeeId(long employeeId) {
		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns a range of all the employee delegations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDelegationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee delegations
	 * @param end the upper bound of the range of employee delegations (not inclusive)
	 * @return the range of matching employee delegations
	 */
	public static List<EmployeeDelegation> findByEmployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee delegations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDelegationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee delegations
	 * @param end the upper bound of the range of employee delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee delegations
	 */
	public static List<EmployeeDelegation> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeDelegation> orderByComparator) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee delegations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDelegationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee delegations
	 * @param end the upper bound of the range of employee delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee delegations
	 */
	public static List<EmployeeDelegation> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeDelegation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee delegation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee delegation
	 * @throws NoSuchEmployeeDelegationException if a matching employee delegation could not be found
	 */
	public static EmployeeDelegation findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeDelegation> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeDelegationException {

		return getPersistence().findByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first employee delegation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee delegation, or <code>null</code> if a matching employee delegation could not be found
	 */
	public static EmployeeDelegation fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<EmployeeDelegation> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee delegation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee delegation
	 * @throws NoSuchEmployeeDelegationException if a matching employee delegation could not be found
	 */
	public static EmployeeDelegation findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeDelegation> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeDelegationException {

		return getPersistence().findByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee delegation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee delegation, or <code>null</code> if a matching employee delegation could not be found
	 */
	public static EmployeeDelegation fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<EmployeeDelegation> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the employee delegations before and after the current employee delegation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeDelegationId the primary key of the current employee delegation
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee delegation
	 * @throws NoSuchEmployeeDelegationException if a employee delegation with the primary key could not be found
	 */
	public static EmployeeDelegation[] findByEmployeeId_PrevAndNext(
			long employeeDelegationId, long employeeId,
			OrderByComparator<EmployeeDelegation> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeDelegationException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			employeeDelegationId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the employee delegations where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of employee delegations where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee delegations
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Caches the employee delegation in the entity cache if it is enabled.
	 *
	 * @param employeeDelegation the employee delegation
	 */
	public static void cacheResult(EmployeeDelegation employeeDelegation) {
		getPersistence().cacheResult(employeeDelegation);
	}

	/**
	 * Caches the employee delegations in the entity cache if it is enabled.
	 *
	 * @param employeeDelegations the employee delegations
	 */
	public static void cacheResult(
		List<EmployeeDelegation> employeeDelegations) {

		getPersistence().cacheResult(employeeDelegations);
	}

	/**
	 * Creates a new employee delegation with the primary key. Does not add the employee delegation to the database.
	 *
	 * @param employeeDelegationId the primary key for the new employee delegation
	 * @return the new employee delegation
	 */
	public static EmployeeDelegation create(long employeeDelegationId) {
		return getPersistence().create(employeeDelegationId);
	}

	/**
	 * Removes the employee delegation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeDelegationId the primary key of the employee delegation
	 * @return the employee delegation that was removed
	 * @throws NoSuchEmployeeDelegationException if a employee delegation with the primary key could not be found
	 */
	public static EmployeeDelegation remove(long employeeDelegationId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeDelegationException {

		return getPersistence().remove(employeeDelegationId);
	}

	public static EmployeeDelegation updateImpl(
		EmployeeDelegation employeeDelegation) {

		return getPersistence().updateImpl(employeeDelegation);
	}

	/**
	 * Returns the employee delegation with the primary key or throws a <code>NoSuchEmployeeDelegationException</code> if it could not be found.
	 *
	 * @param employeeDelegationId the primary key of the employee delegation
	 * @return the employee delegation
	 * @throws NoSuchEmployeeDelegationException if a employee delegation with the primary key could not be found
	 */
	public static EmployeeDelegation findByPrimaryKey(long employeeDelegationId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeDelegationException {

		return getPersistence().findByPrimaryKey(employeeDelegationId);
	}

	/**
	 * Returns the employee delegation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeDelegationId the primary key of the employee delegation
	 * @return the employee delegation, or <code>null</code> if a employee delegation with the primary key could not be found
	 */
	public static EmployeeDelegation fetchByPrimaryKey(
		long employeeDelegationId) {

		return getPersistence().fetchByPrimaryKey(employeeDelegationId);
	}

	/**
	 * Returns all the employee delegations.
	 *
	 * @return the employee delegations
	 */
	public static List<EmployeeDelegation> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employee delegations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDelegationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee delegations
	 * @param end the upper bound of the range of employee delegations (not inclusive)
	 * @return the range of employee delegations
	 */
	public static List<EmployeeDelegation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employee delegations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDelegationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee delegations
	 * @param end the upper bound of the range of employee delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee delegations
	 */
	public static List<EmployeeDelegation> findAll(
		int start, int end,
		OrderByComparator<EmployeeDelegation> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee delegations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDelegationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee delegations
	 * @param end the upper bound of the range of employee delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee delegations
	 */
	public static List<EmployeeDelegation> findAll(
		int start, int end,
		OrderByComparator<EmployeeDelegation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee delegations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee delegations.
	 *
	 * @return the number of employee delegations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeDelegationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeeDelegationPersistence, EmployeeDelegationPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EmployeeDelegationPersistence.class);

		ServiceTracker
			<EmployeeDelegationPersistence, EmployeeDelegationPersistence>
				serviceTracker =
					new ServiceTracker
						<EmployeeDelegationPersistence,
						 EmployeeDelegationPersistence>(
							 bundle.getBundleContext(),
							 EmployeeDelegationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}