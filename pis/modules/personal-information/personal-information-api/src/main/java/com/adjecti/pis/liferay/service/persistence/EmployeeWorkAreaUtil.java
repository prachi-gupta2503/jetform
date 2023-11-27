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

import com.adjecti.pis.liferay.model.EmployeeWorkArea;

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
 * The persistence utility for the employee work area service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.EmployeeWorkAreaPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeWorkAreaPersistence
 * @generated
 */
public class EmployeeWorkAreaUtil {

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
	public static void clearCache(EmployeeWorkArea employeeWorkArea) {
		getPersistence().clearCache(employeeWorkArea);
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
	public static Map<Serializable, EmployeeWorkArea> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeWorkArea> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeWorkArea> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeWorkArea> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeWorkArea> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeWorkArea update(EmployeeWorkArea employeeWorkArea) {
		return getPersistence().update(employeeWorkArea);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeWorkArea update(
		EmployeeWorkArea employeeWorkArea, ServiceContext serviceContext) {

		return getPersistence().update(employeeWorkArea, serviceContext);
	}

	/**
	 * Returns all the employee work areas where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee work areas
	 */
	public static List<EmployeeWorkArea> findByEmployeeId(long employeeId) {
		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns a range of all the employee work areas where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee work areas
	 * @param end the upper bound of the range of employee work areas (not inclusive)
	 * @return the range of matching employee work areas
	 */
	public static List<EmployeeWorkArea> findByEmployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee work areas where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee work areas
	 * @param end the upper bound of the range of employee work areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee work areas
	 */
	public static List<EmployeeWorkArea> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeWorkArea> orderByComparator) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee work areas where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee work areas
	 * @param end the upper bound of the range of employee work areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee work areas
	 */
	public static List<EmployeeWorkArea> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeWorkArea> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee work area in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee work area
	 * @throws NoSuchEmployeeWorkAreaException if a matching employee work area could not be found
	 */
	public static EmployeeWorkArea findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeWorkArea> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeWorkAreaException {

		return getPersistence().findByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first employee work area in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee work area, or <code>null</code> if a matching employee work area could not be found
	 */
	public static EmployeeWorkArea fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<EmployeeWorkArea> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee work area in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee work area
	 * @throws NoSuchEmployeeWorkAreaException if a matching employee work area could not be found
	 */
	public static EmployeeWorkArea findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeWorkArea> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeWorkAreaException {

		return getPersistence().findByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee work area in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee work area, or <code>null</code> if a matching employee work area could not be found
	 */
	public static EmployeeWorkArea fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<EmployeeWorkArea> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the employee work areas before and after the current employee work area in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeWorkAreaId the primary key of the current employee work area
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee work area
	 * @throws NoSuchEmployeeWorkAreaException if a employee work area with the primary key could not be found
	 */
	public static EmployeeWorkArea[] findByEmployeeId_PrevAndNext(
			long employeeWorkAreaId, long employeeId,
			OrderByComparator<EmployeeWorkArea> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeWorkAreaException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			employeeWorkAreaId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the employee work areas where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of employee work areas where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee work areas
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Returns all the employee work areas where workAreaMajorId = &#63;.
	 *
	 * @param workAreaMajorId the work area major ID
	 * @return the matching employee work areas
	 */
	public static List<EmployeeWorkArea> findByWorkAreaMajorId(
		long workAreaMajorId) {

		return getPersistence().findByWorkAreaMajorId(workAreaMajorId);
	}

	/**
	 * Returns a range of all the employee work areas where workAreaMajorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param start the lower bound of the range of employee work areas
	 * @param end the upper bound of the range of employee work areas (not inclusive)
	 * @return the range of matching employee work areas
	 */
	public static List<EmployeeWorkArea> findByWorkAreaMajorId(
		long workAreaMajorId, int start, int end) {

		return getPersistence().findByWorkAreaMajorId(
			workAreaMajorId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee work areas where workAreaMajorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param start the lower bound of the range of employee work areas
	 * @param end the upper bound of the range of employee work areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee work areas
	 */
	public static List<EmployeeWorkArea> findByWorkAreaMajorId(
		long workAreaMajorId, int start, int end,
		OrderByComparator<EmployeeWorkArea> orderByComparator) {

		return getPersistence().findByWorkAreaMajorId(
			workAreaMajorId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee work areas where workAreaMajorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param start the lower bound of the range of employee work areas
	 * @param end the upper bound of the range of employee work areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee work areas
	 */
	public static List<EmployeeWorkArea> findByWorkAreaMajorId(
		long workAreaMajorId, int start, int end,
		OrderByComparator<EmployeeWorkArea> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByWorkAreaMajorId(
			workAreaMajorId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee work area in the ordered set where workAreaMajorId = &#63;.
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee work area
	 * @throws NoSuchEmployeeWorkAreaException if a matching employee work area could not be found
	 */
	public static EmployeeWorkArea findByWorkAreaMajorId_First(
			long workAreaMajorId,
			OrderByComparator<EmployeeWorkArea> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeWorkAreaException {

		return getPersistence().findByWorkAreaMajorId_First(
			workAreaMajorId, orderByComparator);
	}

	/**
	 * Returns the first employee work area in the ordered set where workAreaMajorId = &#63;.
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee work area, or <code>null</code> if a matching employee work area could not be found
	 */
	public static EmployeeWorkArea fetchByWorkAreaMajorId_First(
		long workAreaMajorId,
		OrderByComparator<EmployeeWorkArea> orderByComparator) {

		return getPersistence().fetchByWorkAreaMajorId_First(
			workAreaMajorId, orderByComparator);
	}

	/**
	 * Returns the last employee work area in the ordered set where workAreaMajorId = &#63;.
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee work area
	 * @throws NoSuchEmployeeWorkAreaException if a matching employee work area could not be found
	 */
	public static EmployeeWorkArea findByWorkAreaMajorId_Last(
			long workAreaMajorId,
			OrderByComparator<EmployeeWorkArea> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeWorkAreaException {

		return getPersistence().findByWorkAreaMajorId_Last(
			workAreaMajorId, orderByComparator);
	}

	/**
	 * Returns the last employee work area in the ordered set where workAreaMajorId = &#63;.
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee work area, or <code>null</code> if a matching employee work area could not be found
	 */
	public static EmployeeWorkArea fetchByWorkAreaMajorId_Last(
		long workAreaMajorId,
		OrderByComparator<EmployeeWorkArea> orderByComparator) {

		return getPersistence().fetchByWorkAreaMajorId_Last(
			workAreaMajorId, orderByComparator);
	}

	/**
	 * Returns the employee work areas before and after the current employee work area in the ordered set where workAreaMajorId = &#63;.
	 *
	 * @param employeeWorkAreaId the primary key of the current employee work area
	 * @param workAreaMajorId the work area major ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee work area
	 * @throws NoSuchEmployeeWorkAreaException if a employee work area with the primary key could not be found
	 */
	public static EmployeeWorkArea[] findByWorkAreaMajorId_PrevAndNext(
			long employeeWorkAreaId, long workAreaMajorId,
			OrderByComparator<EmployeeWorkArea> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeWorkAreaException {

		return getPersistence().findByWorkAreaMajorId_PrevAndNext(
			employeeWorkAreaId, workAreaMajorId, orderByComparator);
	}

	/**
	 * Removes all the employee work areas where workAreaMajorId = &#63; from the database.
	 *
	 * @param workAreaMajorId the work area major ID
	 */
	public static void removeByWorkAreaMajorId(long workAreaMajorId) {
		getPersistence().removeByWorkAreaMajorId(workAreaMajorId);
	}

	/**
	 * Returns the number of employee work areas where workAreaMajorId = &#63;.
	 *
	 * @param workAreaMajorId the work area major ID
	 * @return the number of matching employee work areas
	 */
	public static int countByWorkAreaMajorId(long workAreaMajorId) {
		return getPersistence().countByWorkAreaMajorId(workAreaMajorId);
	}

	/**
	 * Caches the employee work area in the entity cache if it is enabled.
	 *
	 * @param employeeWorkArea the employee work area
	 */
	public static void cacheResult(EmployeeWorkArea employeeWorkArea) {
		getPersistence().cacheResult(employeeWorkArea);
	}

	/**
	 * Caches the employee work areas in the entity cache if it is enabled.
	 *
	 * @param employeeWorkAreas the employee work areas
	 */
	public static void cacheResult(List<EmployeeWorkArea> employeeWorkAreas) {
		getPersistence().cacheResult(employeeWorkAreas);
	}

	/**
	 * Creates a new employee work area with the primary key. Does not add the employee work area to the database.
	 *
	 * @param employeeWorkAreaId the primary key for the new employee work area
	 * @return the new employee work area
	 */
	public static EmployeeWorkArea create(long employeeWorkAreaId) {
		return getPersistence().create(employeeWorkAreaId);
	}

	/**
	 * Removes the employee work area with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeWorkAreaId the primary key of the employee work area
	 * @return the employee work area that was removed
	 * @throws NoSuchEmployeeWorkAreaException if a employee work area with the primary key could not be found
	 */
	public static EmployeeWorkArea remove(long employeeWorkAreaId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeWorkAreaException {

		return getPersistence().remove(employeeWorkAreaId);
	}

	public static EmployeeWorkArea updateImpl(
		EmployeeWorkArea employeeWorkArea) {

		return getPersistence().updateImpl(employeeWorkArea);
	}

	/**
	 * Returns the employee work area with the primary key or throws a <code>NoSuchEmployeeWorkAreaException</code> if it could not be found.
	 *
	 * @param employeeWorkAreaId the primary key of the employee work area
	 * @return the employee work area
	 * @throws NoSuchEmployeeWorkAreaException if a employee work area with the primary key could not be found
	 */
	public static EmployeeWorkArea findByPrimaryKey(long employeeWorkAreaId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeWorkAreaException {

		return getPersistence().findByPrimaryKey(employeeWorkAreaId);
	}

	/**
	 * Returns the employee work area with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeWorkAreaId the primary key of the employee work area
	 * @return the employee work area, or <code>null</code> if a employee work area with the primary key could not be found
	 */
	public static EmployeeWorkArea fetchByPrimaryKey(long employeeWorkAreaId) {
		return getPersistence().fetchByPrimaryKey(employeeWorkAreaId);
	}

	/**
	 * Returns all the employee work areas.
	 *
	 * @return the employee work areas
	 */
	public static List<EmployeeWorkArea> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employee work areas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee work areas
	 * @param end the upper bound of the range of employee work areas (not inclusive)
	 * @return the range of employee work areas
	 */
	public static List<EmployeeWorkArea> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employee work areas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee work areas
	 * @param end the upper bound of the range of employee work areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee work areas
	 */
	public static List<EmployeeWorkArea> findAll(
		int start, int end,
		OrderByComparator<EmployeeWorkArea> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee work areas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee work areas
	 * @param end the upper bound of the range of employee work areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee work areas
	 */
	public static List<EmployeeWorkArea> findAll(
		int start, int end,
		OrderByComparator<EmployeeWorkArea> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee work areas from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee work areas.
	 *
	 * @return the number of employee work areas
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeWorkAreaPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeeWorkAreaPersistence, EmployeeWorkAreaPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EmployeeWorkAreaPersistence.class);

		ServiceTracker<EmployeeWorkAreaPersistence, EmployeeWorkAreaPersistence>
			serviceTracker =
				new ServiceTracker
					<EmployeeWorkAreaPersistence, EmployeeWorkAreaPersistence>(
						bundle.getBundleContext(),
						EmployeeWorkAreaPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}