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

import com.adjecti.pis.liferay.model.EmployeeBiodata;

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
 * The persistence utility for the employee biodata service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.EmployeeBiodataPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeBiodataPersistence
 * @generated
 */
public class EmployeeBiodataUtil {

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
	public static void clearCache(EmployeeBiodata employeeBiodata) {
		getPersistence().clearCache(employeeBiodata);
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
	public static Map<Serializable, EmployeeBiodata> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeBiodata> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeBiodata> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeBiodata> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeBiodata> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeBiodata update(EmployeeBiodata employeeBiodata) {
		return getPersistence().update(employeeBiodata);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeBiodata update(
		EmployeeBiodata employeeBiodata, ServiceContext serviceContext) {

		return getPersistence().update(employeeBiodata, serviceContext);
	}

	/**
	 * Returns all the employee biodatas where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee biodatas
	 */
	public static List<EmployeeBiodata> findByEmployeeId(long employeeId) {
		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns a range of all the employee biodatas where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBiodataModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee biodatas
	 * @param end the upper bound of the range of employee biodatas (not inclusive)
	 * @return the range of matching employee biodatas
	 */
	public static List<EmployeeBiodata> findByEmployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee biodatas where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBiodataModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee biodatas
	 * @param end the upper bound of the range of employee biodatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee biodatas
	 */
	public static List<EmployeeBiodata> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeBiodata> orderByComparator) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee biodatas where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBiodataModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee biodatas
	 * @param end the upper bound of the range of employee biodatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee biodatas
	 */
	public static List<EmployeeBiodata> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeBiodata> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee biodata in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee biodata
	 * @throws NoSuchEmployeeBiodataException if a matching employee biodata could not be found
	 */
	public static EmployeeBiodata findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeBiodata> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeBiodataException {

		return getPersistence().findByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first employee biodata in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee biodata, or <code>null</code> if a matching employee biodata could not be found
	 */
	public static EmployeeBiodata fetchByEmployeeId_First(
		long employeeId, OrderByComparator<EmployeeBiodata> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee biodata in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee biodata
	 * @throws NoSuchEmployeeBiodataException if a matching employee biodata could not be found
	 */
	public static EmployeeBiodata findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeBiodata> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeBiodataException {

		return getPersistence().findByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee biodata in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee biodata, or <code>null</code> if a matching employee biodata could not be found
	 */
	public static EmployeeBiodata fetchByEmployeeId_Last(
		long employeeId, OrderByComparator<EmployeeBiodata> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the employee biodatas before and after the current employee biodata in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeBiodataId the primary key of the current employee biodata
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee biodata
	 * @throws NoSuchEmployeeBiodataException if a employee biodata with the primary key could not be found
	 */
	public static EmployeeBiodata[] findByEmployeeId_PrevAndNext(
			long employeeBiodataId, long employeeId,
			OrderByComparator<EmployeeBiodata> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeBiodataException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			employeeBiodataId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the employee biodatas where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of employee biodatas where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee biodatas
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Caches the employee biodata in the entity cache if it is enabled.
	 *
	 * @param employeeBiodata the employee biodata
	 */
	public static void cacheResult(EmployeeBiodata employeeBiodata) {
		getPersistence().cacheResult(employeeBiodata);
	}

	/**
	 * Caches the employee biodatas in the entity cache if it is enabled.
	 *
	 * @param employeeBiodatas the employee biodatas
	 */
	public static void cacheResult(List<EmployeeBiodata> employeeBiodatas) {
		getPersistence().cacheResult(employeeBiodatas);
	}

	/**
	 * Creates a new employee biodata with the primary key. Does not add the employee biodata to the database.
	 *
	 * @param employeeBiodataId the primary key for the new employee biodata
	 * @return the new employee biodata
	 */
	public static EmployeeBiodata create(long employeeBiodataId) {
		return getPersistence().create(employeeBiodataId);
	}

	/**
	 * Removes the employee biodata with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeBiodataId the primary key of the employee biodata
	 * @return the employee biodata that was removed
	 * @throws NoSuchEmployeeBiodataException if a employee biodata with the primary key could not be found
	 */
	public static EmployeeBiodata remove(long employeeBiodataId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeBiodataException {

		return getPersistence().remove(employeeBiodataId);
	}

	public static EmployeeBiodata updateImpl(EmployeeBiodata employeeBiodata) {
		return getPersistence().updateImpl(employeeBiodata);
	}

	/**
	 * Returns the employee biodata with the primary key or throws a <code>NoSuchEmployeeBiodataException</code> if it could not be found.
	 *
	 * @param employeeBiodataId the primary key of the employee biodata
	 * @return the employee biodata
	 * @throws NoSuchEmployeeBiodataException if a employee biodata with the primary key could not be found
	 */
	public static EmployeeBiodata findByPrimaryKey(long employeeBiodataId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeBiodataException {

		return getPersistence().findByPrimaryKey(employeeBiodataId);
	}

	/**
	 * Returns the employee biodata with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeBiodataId the primary key of the employee biodata
	 * @return the employee biodata, or <code>null</code> if a employee biodata with the primary key could not be found
	 */
	public static EmployeeBiodata fetchByPrimaryKey(long employeeBiodataId) {
		return getPersistence().fetchByPrimaryKey(employeeBiodataId);
	}

	/**
	 * Returns all the employee biodatas.
	 *
	 * @return the employee biodatas
	 */
	public static List<EmployeeBiodata> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employee biodatas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBiodataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee biodatas
	 * @param end the upper bound of the range of employee biodatas (not inclusive)
	 * @return the range of employee biodatas
	 */
	public static List<EmployeeBiodata> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employee biodatas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBiodataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee biodatas
	 * @param end the upper bound of the range of employee biodatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee biodatas
	 */
	public static List<EmployeeBiodata> findAll(
		int start, int end,
		OrderByComparator<EmployeeBiodata> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee biodatas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBiodataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee biodatas
	 * @param end the upper bound of the range of employee biodatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee biodatas
	 */
	public static List<EmployeeBiodata> findAll(
		int start, int end,
		OrderByComparator<EmployeeBiodata> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee biodatas from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee biodatas.
	 *
	 * @return the number of employee biodatas
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeBiodataPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeeBiodataPersistence, EmployeeBiodataPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EmployeeBiodataPersistence.class);

		ServiceTracker<EmployeeBiodataPersistence, EmployeeBiodataPersistence>
			serviceTracker =
				new ServiceTracker
					<EmployeeBiodataPersistence, EmployeeBiodataPersistence>(
						bundle.getBundleContext(),
						EmployeeBiodataPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}