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

import com.adjecti.pis.liferay.model.EmployeePayStructure;

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
 * The persistence utility for the employee pay structure service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.EmployeePayStructurePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeePayStructurePersistence
 * @generated
 */
public class EmployeePayStructureUtil {

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
	public static void clearCache(EmployeePayStructure employeePayStructure) {
		getPersistence().clearCache(employeePayStructure);
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
	public static Map<Serializable, EmployeePayStructure> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeePayStructure> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeePayStructure> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeePayStructure> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeePayStructure> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeePayStructure update(
		EmployeePayStructure employeePayStructure) {

		return getPersistence().update(employeePayStructure);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeePayStructure update(
		EmployeePayStructure employeePayStructure,
		ServiceContext serviceContext) {

		return getPersistence().update(employeePayStructure, serviceContext);
	}

	/**
	 * Returns all the employee pay structures where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee pay structures
	 */
	public static List<EmployeePayStructure> findByEmployeeId(long employeeId) {
		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns a range of all the employee pay structures where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePayStructureModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee pay structures
	 * @param end the upper bound of the range of employee pay structures (not inclusive)
	 * @return the range of matching employee pay structures
	 */
	public static List<EmployeePayStructure> findByEmployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee pay structures where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePayStructureModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee pay structures
	 * @param end the upper bound of the range of employee pay structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee pay structures
	 */
	public static List<EmployeePayStructure> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeePayStructure> orderByComparator) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee pay structures where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePayStructureModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee pay structures
	 * @param end the upper bound of the range of employee pay structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee pay structures
	 */
	public static List<EmployeePayStructure> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeePayStructure> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee pay structure in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee pay structure
	 * @throws NoSuchEmployeePayStructureException if a matching employee pay structure could not be found
	 */
	public static EmployeePayStructure findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeePayStructure> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePayStructureException {

		return getPersistence().findByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first employee pay structure in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee pay structure, or <code>null</code> if a matching employee pay structure could not be found
	 */
	public static EmployeePayStructure fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<EmployeePayStructure> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee pay structure in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee pay structure
	 * @throws NoSuchEmployeePayStructureException if a matching employee pay structure could not be found
	 */
	public static EmployeePayStructure findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeePayStructure> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePayStructureException {

		return getPersistence().findByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee pay structure in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee pay structure, or <code>null</code> if a matching employee pay structure could not be found
	 */
	public static EmployeePayStructure fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<EmployeePayStructure> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the employee pay structures before and after the current employee pay structure in the ordered set where employeeId = &#63;.
	 *
	 * @param employeePayStructureId the primary key of the current employee pay structure
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee pay structure
	 * @throws NoSuchEmployeePayStructureException if a employee pay structure with the primary key could not be found
	 */
	public static EmployeePayStructure[] findByEmployeeId_PrevAndNext(
			long employeePayStructureId, long employeeId,
			OrderByComparator<EmployeePayStructure> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePayStructureException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			employeePayStructureId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the employee pay structures where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of employee pay structures where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee pay structures
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Caches the employee pay structure in the entity cache if it is enabled.
	 *
	 * @param employeePayStructure the employee pay structure
	 */
	public static void cacheResult(EmployeePayStructure employeePayStructure) {
		getPersistence().cacheResult(employeePayStructure);
	}

	/**
	 * Caches the employee pay structures in the entity cache if it is enabled.
	 *
	 * @param employeePayStructures the employee pay structures
	 */
	public static void cacheResult(
		List<EmployeePayStructure> employeePayStructures) {

		getPersistence().cacheResult(employeePayStructures);
	}

	/**
	 * Creates a new employee pay structure with the primary key. Does not add the employee pay structure to the database.
	 *
	 * @param employeePayStructureId the primary key for the new employee pay structure
	 * @return the new employee pay structure
	 */
	public static EmployeePayStructure create(long employeePayStructureId) {
		return getPersistence().create(employeePayStructureId);
	}

	/**
	 * Removes the employee pay structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeePayStructureId the primary key of the employee pay structure
	 * @return the employee pay structure that was removed
	 * @throws NoSuchEmployeePayStructureException if a employee pay structure with the primary key could not be found
	 */
	public static EmployeePayStructure remove(long employeePayStructureId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePayStructureException {

		return getPersistence().remove(employeePayStructureId);
	}

	public static EmployeePayStructure updateImpl(
		EmployeePayStructure employeePayStructure) {

		return getPersistence().updateImpl(employeePayStructure);
	}

	/**
	 * Returns the employee pay structure with the primary key or throws a <code>NoSuchEmployeePayStructureException</code> if it could not be found.
	 *
	 * @param employeePayStructureId the primary key of the employee pay structure
	 * @return the employee pay structure
	 * @throws NoSuchEmployeePayStructureException if a employee pay structure with the primary key could not be found
	 */
	public static EmployeePayStructure findByPrimaryKey(
			long employeePayStructureId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePayStructureException {

		return getPersistence().findByPrimaryKey(employeePayStructureId);
	}

	/**
	 * Returns the employee pay structure with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeePayStructureId the primary key of the employee pay structure
	 * @return the employee pay structure, or <code>null</code> if a employee pay structure with the primary key could not be found
	 */
	public static EmployeePayStructure fetchByPrimaryKey(
		long employeePayStructureId) {

		return getPersistence().fetchByPrimaryKey(employeePayStructureId);
	}

	/**
	 * Returns all the employee pay structures.
	 *
	 * @return the employee pay structures
	 */
	public static List<EmployeePayStructure> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employee pay structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePayStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee pay structures
	 * @param end the upper bound of the range of employee pay structures (not inclusive)
	 * @return the range of employee pay structures
	 */
	public static List<EmployeePayStructure> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employee pay structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePayStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee pay structures
	 * @param end the upper bound of the range of employee pay structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee pay structures
	 */
	public static List<EmployeePayStructure> findAll(
		int start, int end,
		OrderByComparator<EmployeePayStructure> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee pay structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePayStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee pay structures
	 * @param end the upper bound of the range of employee pay structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee pay structures
	 */
	public static List<EmployeePayStructure> findAll(
		int start, int end,
		OrderByComparator<EmployeePayStructure> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee pay structures from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee pay structures.
	 *
	 * @return the number of employee pay structures
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeePayStructurePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeePayStructurePersistence, EmployeePayStructurePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EmployeePayStructurePersistence.class);

		ServiceTracker
			<EmployeePayStructurePersistence, EmployeePayStructurePersistence>
				serviceTracker =
					new ServiceTracker
						<EmployeePayStructurePersistence,
						 EmployeePayStructurePersistence>(
							 bundle.getBundleContext(),
							 EmployeePayStructurePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}