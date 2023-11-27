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

import com.adjecti.pis.liferay.model.EmployeeWorkstation;

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
 * The persistence utility for the employee workstation service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.EmployeeWorkstationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeWorkstationPersistence
 * @generated
 */
public class EmployeeWorkstationUtil {

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
	public static void clearCache(EmployeeWorkstation employeeWorkstation) {
		getPersistence().clearCache(employeeWorkstation);
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
	public static Map<Serializable, EmployeeWorkstation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeWorkstation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeWorkstation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeWorkstation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeWorkstation> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeWorkstation update(
		EmployeeWorkstation employeeWorkstation) {

		return getPersistence().update(employeeWorkstation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeWorkstation update(
		EmployeeWorkstation employeeWorkstation,
		ServiceContext serviceContext) {

		return getPersistence().update(employeeWorkstation, serviceContext);
	}

	/**
	 * Returns all the employee workstations where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee workstations
	 */
	public static List<EmployeeWorkstation> findByEmployeeId(long employeeId) {
		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns a range of all the employee workstations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkstationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee workstations
	 * @param end the upper bound of the range of employee workstations (not inclusive)
	 * @return the range of matching employee workstations
	 */
	public static List<EmployeeWorkstation> findByEmployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee workstations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkstationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee workstations
	 * @param end the upper bound of the range of employee workstations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee workstations
	 */
	public static List<EmployeeWorkstation> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeWorkstation> orderByComparator) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee workstations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkstationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee workstations
	 * @param end the upper bound of the range of employee workstations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee workstations
	 */
	public static List<EmployeeWorkstation> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeWorkstation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee workstation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee workstation
	 * @throws NoSuchEmployeeWorkstationException if a matching employee workstation could not be found
	 */
	public static EmployeeWorkstation findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeWorkstation> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeWorkstationException {

		return getPersistence().findByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first employee workstation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee workstation, or <code>null</code> if a matching employee workstation could not be found
	 */
	public static EmployeeWorkstation fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<EmployeeWorkstation> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee workstation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee workstation
	 * @throws NoSuchEmployeeWorkstationException if a matching employee workstation could not be found
	 */
	public static EmployeeWorkstation findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeWorkstation> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeWorkstationException {

		return getPersistence().findByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee workstation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee workstation, or <code>null</code> if a matching employee workstation could not be found
	 */
	public static EmployeeWorkstation fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<EmployeeWorkstation> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the employee workstations before and after the current employee workstation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeWorkstationId the primary key of the current employee workstation
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee workstation
	 * @throws NoSuchEmployeeWorkstationException if a employee workstation with the primary key could not be found
	 */
	public static EmployeeWorkstation[] findByEmployeeId_PrevAndNext(
			long employeeWorkstationId, long employeeId,
			OrderByComparator<EmployeeWorkstation> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeWorkstationException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			employeeWorkstationId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the employee workstations where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of employee workstations where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee workstations
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Caches the employee workstation in the entity cache if it is enabled.
	 *
	 * @param employeeWorkstation the employee workstation
	 */
	public static void cacheResult(EmployeeWorkstation employeeWorkstation) {
		getPersistence().cacheResult(employeeWorkstation);
	}

	/**
	 * Caches the employee workstations in the entity cache if it is enabled.
	 *
	 * @param employeeWorkstations the employee workstations
	 */
	public static void cacheResult(
		List<EmployeeWorkstation> employeeWorkstations) {

		getPersistence().cacheResult(employeeWorkstations);
	}

	/**
	 * Creates a new employee workstation with the primary key. Does not add the employee workstation to the database.
	 *
	 * @param employeeWorkstationId the primary key for the new employee workstation
	 * @return the new employee workstation
	 */
	public static EmployeeWorkstation create(long employeeWorkstationId) {
		return getPersistence().create(employeeWorkstationId);
	}

	/**
	 * Removes the employee workstation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeWorkstationId the primary key of the employee workstation
	 * @return the employee workstation that was removed
	 * @throws NoSuchEmployeeWorkstationException if a employee workstation with the primary key could not be found
	 */
	public static EmployeeWorkstation remove(long employeeWorkstationId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeWorkstationException {

		return getPersistence().remove(employeeWorkstationId);
	}

	public static EmployeeWorkstation updateImpl(
		EmployeeWorkstation employeeWorkstation) {

		return getPersistence().updateImpl(employeeWorkstation);
	}

	/**
	 * Returns the employee workstation with the primary key or throws a <code>NoSuchEmployeeWorkstationException</code> if it could not be found.
	 *
	 * @param employeeWorkstationId the primary key of the employee workstation
	 * @return the employee workstation
	 * @throws NoSuchEmployeeWorkstationException if a employee workstation with the primary key could not be found
	 */
	public static EmployeeWorkstation findByPrimaryKey(
			long employeeWorkstationId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeWorkstationException {

		return getPersistence().findByPrimaryKey(employeeWorkstationId);
	}

	/**
	 * Returns the employee workstation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeWorkstationId the primary key of the employee workstation
	 * @return the employee workstation, or <code>null</code> if a employee workstation with the primary key could not be found
	 */
	public static EmployeeWorkstation fetchByPrimaryKey(
		long employeeWorkstationId) {

		return getPersistence().fetchByPrimaryKey(employeeWorkstationId);
	}

	/**
	 * Returns all the employee workstations.
	 *
	 * @return the employee workstations
	 */
	public static List<EmployeeWorkstation> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employee workstations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkstationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee workstations
	 * @param end the upper bound of the range of employee workstations (not inclusive)
	 * @return the range of employee workstations
	 */
	public static List<EmployeeWorkstation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employee workstations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkstationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee workstations
	 * @param end the upper bound of the range of employee workstations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee workstations
	 */
	public static List<EmployeeWorkstation> findAll(
		int start, int end,
		OrderByComparator<EmployeeWorkstation> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee workstations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkstationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee workstations
	 * @param end the upper bound of the range of employee workstations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee workstations
	 */
	public static List<EmployeeWorkstation> findAll(
		int start, int end,
		OrderByComparator<EmployeeWorkstation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee workstations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee workstations.
	 *
	 * @return the number of employee workstations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeWorkstationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeeWorkstationPersistence, EmployeeWorkstationPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EmployeeWorkstationPersistence.class);

		ServiceTracker
			<EmployeeWorkstationPersistence, EmployeeWorkstationPersistence>
				serviceTracker =
					new ServiceTracker
						<EmployeeWorkstationPersistence,
						 EmployeeWorkstationPersistence>(
							 bundle.getBundleContext(),
							 EmployeeWorkstationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}