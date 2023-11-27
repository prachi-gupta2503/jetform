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

import com.adjecti.pis.liferay.model.EmployeeDsc;

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
 * The persistence utility for the employee dsc service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.EmployeeDscPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDscPersistence
 * @generated
 */
public class EmployeeDscUtil {

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
	public static void clearCache(EmployeeDsc employeeDsc) {
		getPersistence().clearCache(employeeDsc);
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
	public static Map<Serializable, EmployeeDsc> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeDsc> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeDsc> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeDsc> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeDsc> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeDsc update(EmployeeDsc employeeDsc) {
		return getPersistence().update(employeeDsc);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeDsc update(
		EmployeeDsc employeeDsc, ServiceContext serviceContext) {

		return getPersistence().update(employeeDsc, serviceContext);
	}

	/**
	 * Returns all the employee dscs where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee dscs
	 */
	public static List<EmployeeDsc> findByEmployeeId(long employeeId) {
		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns a range of all the employee dscs where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDscModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee dscs
	 * @param end the upper bound of the range of employee dscs (not inclusive)
	 * @return the range of matching employee dscs
	 */
	public static List<EmployeeDsc> findByEmployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee dscs where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDscModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee dscs
	 * @param end the upper bound of the range of employee dscs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee dscs
	 */
	public static List<EmployeeDsc> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeDsc> orderByComparator) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee dscs where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDscModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee dscs
	 * @param end the upper bound of the range of employee dscs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee dscs
	 */
	public static List<EmployeeDsc> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeDsc> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee dsc in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee dsc
	 * @throws NoSuchEmployeeDscException if a matching employee dsc could not be found
	 */
	public static EmployeeDsc findByEmployeeId_First(
			long employeeId, OrderByComparator<EmployeeDsc> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeDscException {

		return getPersistence().findByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first employee dsc in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee dsc, or <code>null</code> if a matching employee dsc could not be found
	 */
	public static EmployeeDsc fetchByEmployeeId_First(
		long employeeId, OrderByComparator<EmployeeDsc> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee dsc in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee dsc
	 * @throws NoSuchEmployeeDscException if a matching employee dsc could not be found
	 */
	public static EmployeeDsc findByEmployeeId_Last(
			long employeeId, OrderByComparator<EmployeeDsc> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeDscException {

		return getPersistence().findByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee dsc in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee dsc, or <code>null</code> if a matching employee dsc could not be found
	 */
	public static EmployeeDsc fetchByEmployeeId_Last(
		long employeeId, OrderByComparator<EmployeeDsc> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the employee dscs before and after the current employee dsc in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeDscId the primary key of the current employee dsc
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee dsc
	 * @throws NoSuchEmployeeDscException if a employee dsc with the primary key could not be found
	 */
	public static EmployeeDsc[] findByEmployeeId_PrevAndNext(
			long employeeDscId, long employeeId,
			OrderByComparator<EmployeeDsc> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeDscException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			employeeDscId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the employee dscs where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of employee dscs where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee dscs
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Returns all the employee dscs where cid = &#63;.
	 *
	 * @param cid the cid
	 * @return the matching employee dscs
	 */
	public static List<EmployeeDsc> findByCid(String cid) {
		return getPersistence().findByCid(cid);
	}

	/**
	 * Returns a range of all the employee dscs where cid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDscModelImpl</code>.
	 * </p>
	 *
	 * @param cid the cid
	 * @param start the lower bound of the range of employee dscs
	 * @param end the upper bound of the range of employee dscs (not inclusive)
	 * @return the range of matching employee dscs
	 */
	public static List<EmployeeDsc> findByCid(String cid, int start, int end) {
		return getPersistence().findByCid(cid, start, end);
	}

	/**
	 * Returns an ordered range of all the employee dscs where cid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDscModelImpl</code>.
	 * </p>
	 *
	 * @param cid the cid
	 * @param start the lower bound of the range of employee dscs
	 * @param end the upper bound of the range of employee dscs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee dscs
	 */
	public static List<EmployeeDsc> findByCid(
		String cid, int start, int end,
		OrderByComparator<EmployeeDsc> orderByComparator) {

		return getPersistence().findByCid(cid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee dscs where cid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDscModelImpl</code>.
	 * </p>
	 *
	 * @param cid the cid
	 * @param start the lower bound of the range of employee dscs
	 * @param end the upper bound of the range of employee dscs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee dscs
	 */
	public static List<EmployeeDsc> findByCid(
		String cid, int start, int end,
		OrderByComparator<EmployeeDsc> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCid(
			cid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee dsc in the ordered set where cid = &#63;.
	 *
	 * @param cid the cid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee dsc
	 * @throws NoSuchEmployeeDscException if a matching employee dsc could not be found
	 */
	public static EmployeeDsc findByCid_First(
			String cid, OrderByComparator<EmployeeDsc> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeDscException {

		return getPersistence().findByCid_First(cid, orderByComparator);
	}

	/**
	 * Returns the first employee dsc in the ordered set where cid = &#63;.
	 *
	 * @param cid the cid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee dsc, or <code>null</code> if a matching employee dsc could not be found
	 */
	public static EmployeeDsc fetchByCid_First(
		String cid, OrderByComparator<EmployeeDsc> orderByComparator) {

		return getPersistence().fetchByCid_First(cid, orderByComparator);
	}

	/**
	 * Returns the last employee dsc in the ordered set where cid = &#63;.
	 *
	 * @param cid the cid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee dsc
	 * @throws NoSuchEmployeeDscException if a matching employee dsc could not be found
	 */
	public static EmployeeDsc findByCid_Last(
			String cid, OrderByComparator<EmployeeDsc> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeDscException {

		return getPersistence().findByCid_Last(cid, orderByComparator);
	}

	/**
	 * Returns the last employee dsc in the ordered set where cid = &#63;.
	 *
	 * @param cid the cid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee dsc, or <code>null</code> if a matching employee dsc could not be found
	 */
	public static EmployeeDsc fetchByCid_Last(
		String cid, OrderByComparator<EmployeeDsc> orderByComparator) {

		return getPersistence().fetchByCid_Last(cid, orderByComparator);
	}

	/**
	 * Returns the employee dscs before and after the current employee dsc in the ordered set where cid = &#63;.
	 *
	 * @param employeeDscId the primary key of the current employee dsc
	 * @param cid the cid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee dsc
	 * @throws NoSuchEmployeeDscException if a employee dsc with the primary key could not be found
	 */
	public static EmployeeDsc[] findByCid_PrevAndNext(
			long employeeDscId, String cid,
			OrderByComparator<EmployeeDsc> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeDscException {

		return getPersistence().findByCid_PrevAndNext(
			employeeDscId, cid, orderByComparator);
	}

	/**
	 * Removes all the employee dscs where cid = &#63; from the database.
	 *
	 * @param cid the cid
	 */
	public static void removeByCid(String cid) {
		getPersistence().removeByCid(cid);
	}

	/**
	 * Returns the number of employee dscs where cid = &#63;.
	 *
	 * @param cid the cid
	 * @return the number of matching employee dscs
	 */
	public static int countByCid(String cid) {
		return getPersistence().countByCid(cid);
	}

	/**
	 * Caches the employee dsc in the entity cache if it is enabled.
	 *
	 * @param employeeDsc the employee dsc
	 */
	public static void cacheResult(EmployeeDsc employeeDsc) {
		getPersistence().cacheResult(employeeDsc);
	}

	/**
	 * Caches the employee dscs in the entity cache if it is enabled.
	 *
	 * @param employeeDscs the employee dscs
	 */
	public static void cacheResult(List<EmployeeDsc> employeeDscs) {
		getPersistence().cacheResult(employeeDscs);
	}

	/**
	 * Creates a new employee dsc with the primary key. Does not add the employee dsc to the database.
	 *
	 * @param employeeDscId the primary key for the new employee dsc
	 * @return the new employee dsc
	 */
	public static EmployeeDsc create(long employeeDscId) {
		return getPersistence().create(employeeDscId);
	}

	/**
	 * Removes the employee dsc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeDscId the primary key of the employee dsc
	 * @return the employee dsc that was removed
	 * @throws NoSuchEmployeeDscException if a employee dsc with the primary key could not be found
	 */
	public static EmployeeDsc remove(long employeeDscId)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeDscException {

		return getPersistence().remove(employeeDscId);
	}

	public static EmployeeDsc updateImpl(EmployeeDsc employeeDsc) {
		return getPersistence().updateImpl(employeeDsc);
	}

	/**
	 * Returns the employee dsc with the primary key or throws a <code>NoSuchEmployeeDscException</code> if it could not be found.
	 *
	 * @param employeeDscId the primary key of the employee dsc
	 * @return the employee dsc
	 * @throws NoSuchEmployeeDscException if a employee dsc with the primary key could not be found
	 */
	public static EmployeeDsc findByPrimaryKey(long employeeDscId)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeDscException {

		return getPersistence().findByPrimaryKey(employeeDscId);
	}

	/**
	 * Returns the employee dsc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeDscId the primary key of the employee dsc
	 * @return the employee dsc, or <code>null</code> if a employee dsc with the primary key could not be found
	 */
	public static EmployeeDsc fetchByPrimaryKey(long employeeDscId) {
		return getPersistence().fetchByPrimaryKey(employeeDscId);
	}

	/**
	 * Returns all the employee dscs.
	 *
	 * @return the employee dscs
	 */
	public static List<EmployeeDsc> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employee dscs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDscModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee dscs
	 * @param end the upper bound of the range of employee dscs (not inclusive)
	 * @return the range of employee dscs
	 */
	public static List<EmployeeDsc> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employee dscs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDscModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee dscs
	 * @param end the upper bound of the range of employee dscs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee dscs
	 */
	public static List<EmployeeDsc> findAll(
		int start, int end, OrderByComparator<EmployeeDsc> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee dscs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDscModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee dscs
	 * @param end the upper bound of the range of employee dscs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee dscs
	 */
	public static List<EmployeeDsc> findAll(
		int start, int end, OrderByComparator<EmployeeDsc> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee dscs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee dscs.
	 *
	 * @return the number of employee dscs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeDscPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeeDscPersistence, EmployeeDscPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EmployeeDscPersistence.class);

		ServiceTracker<EmployeeDscPersistence, EmployeeDscPersistence>
			serviceTracker =
				new ServiceTracker
					<EmployeeDscPersistence, EmployeeDscPersistence>(
						bundle.getBundleContext(), EmployeeDscPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}