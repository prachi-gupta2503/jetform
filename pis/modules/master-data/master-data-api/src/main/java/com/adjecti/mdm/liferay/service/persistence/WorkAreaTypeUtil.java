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

package com.adjecti.mdm.liferay.service.persistence;

import com.adjecti.mdm.liferay.model.WorkAreaType;

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
 * The persistence utility for the work area type service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.WorkAreaTypePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkAreaTypePersistence
 * @generated
 */
public class WorkAreaTypeUtil {

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
	public static void clearCache(WorkAreaType workAreaType) {
		getPersistence().clearCache(workAreaType);
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
	public static Map<Serializable, WorkAreaType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<WorkAreaType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WorkAreaType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WorkAreaType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<WorkAreaType> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static WorkAreaType update(WorkAreaType workAreaType) {
		return getPersistence().update(workAreaType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static WorkAreaType update(
		WorkAreaType workAreaType, ServiceContext serviceContext) {

		return getPersistence().update(workAreaType, serviceContext);
	}

	/**
	 * Returns all the work area types where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching work area types
	 */
	public static List<WorkAreaType> findByCode(String code) {
		return getPersistence().findByCode(code);
	}

	/**
	 * Returns a range of all the work area types where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of work area types
	 * @param end the upper bound of the range of work area types (not inclusive)
	 * @return the range of matching work area types
	 */
	public static List<WorkAreaType> findByCode(
		String code, int start, int end) {

		return getPersistence().findByCode(code, start, end);
	}

	/**
	 * Returns an ordered range of all the work area types where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of work area types
	 * @param end the upper bound of the range of work area types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work area types
	 */
	public static List<WorkAreaType> findByCode(
		String code, int start, int end,
		OrderByComparator<WorkAreaType> orderByComparator) {

		return getPersistence().findByCode(code, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work area types where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of work area types
	 * @param end the upper bound of the range of work area types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work area types
	 */
	public static List<WorkAreaType> findByCode(
		String code, int start, int end,
		OrderByComparator<WorkAreaType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCode(
			code, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first work area type in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area type
	 * @throws NoSuchWorkAreaTypeException if a matching work area type could not be found
	 */
	public static WorkAreaType findByCode_First(
			String code, OrderByComparator<WorkAreaType> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkAreaTypeException {

		return getPersistence().findByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the first work area type in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area type, or <code>null</code> if a matching work area type could not be found
	 */
	public static WorkAreaType fetchByCode_First(
		String code, OrderByComparator<WorkAreaType> orderByComparator) {

		return getPersistence().fetchByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the last work area type in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area type
	 * @throws NoSuchWorkAreaTypeException if a matching work area type could not be found
	 */
	public static WorkAreaType findByCode_Last(
			String code, OrderByComparator<WorkAreaType> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkAreaTypeException {

		return getPersistence().findByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the last work area type in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area type, or <code>null</code> if a matching work area type could not be found
	 */
	public static WorkAreaType fetchByCode_Last(
		String code, OrderByComparator<WorkAreaType> orderByComparator) {

		return getPersistence().fetchByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the work area types before and after the current work area type in the ordered set where code = &#63;.
	 *
	 * @param workAreaTypeId the primary key of the current work area type
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work area type
	 * @throws NoSuchWorkAreaTypeException if a work area type with the primary key could not be found
	 */
	public static WorkAreaType[] findByCode_PrevAndNext(
			long workAreaTypeId, String code,
			OrderByComparator<WorkAreaType> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkAreaTypeException {

		return getPersistence().findByCode_PrevAndNext(
			workAreaTypeId, code, orderByComparator);
	}

	/**
	 * Removes all the work area types where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public static void removeByCode(String code) {
		getPersistence().removeByCode(code);
	}

	/**
	 * Returns the number of work area types where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching work area types
	 */
	public static int countByCode(String code) {
		return getPersistence().countByCode(code);
	}

	/**
	 * Returns all the work area types where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching work area types
	 */
	public static List<WorkAreaType> findByName(String name) {
		return getPersistence().findByName(name);
	}

	/**
	 * Returns a range of all the work area types where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of work area types
	 * @param end the upper bound of the range of work area types (not inclusive)
	 * @return the range of matching work area types
	 */
	public static List<WorkAreaType> findByName(
		String name, int start, int end) {

		return getPersistence().findByName(name, start, end);
	}

	/**
	 * Returns an ordered range of all the work area types where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of work area types
	 * @param end the upper bound of the range of work area types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work area types
	 */
	public static List<WorkAreaType> findByName(
		String name, int start, int end,
		OrderByComparator<WorkAreaType> orderByComparator) {

		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work area types where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of work area types
	 * @param end the upper bound of the range of work area types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work area types
	 */
	public static List<WorkAreaType> findByName(
		String name, int start, int end,
		OrderByComparator<WorkAreaType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByName(
			name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first work area type in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area type
	 * @throws NoSuchWorkAreaTypeException if a matching work area type could not be found
	 */
	public static WorkAreaType findByName_First(
			String name, OrderByComparator<WorkAreaType> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkAreaTypeException {

		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	 * Returns the first work area type in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area type, or <code>null</code> if a matching work area type could not be found
	 */
	public static WorkAreaType fetchByName_First(
		String name, OrderByComparator<WorkAreaType> orderByComparator) {

		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	 * Returns the last work area type in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area type
	 * @throws NoSuchWorkAreaTypeException if a matching work area type could not be found
	 */
	public static WorkAreaType findByName_Last(
			String name, OrderByComparator<WorkAreaType> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkAreaTypeException {

		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the last work area type in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area type, or <code>null</code> if a matching work area type could not be found
	 */
	public static WorkAreaType fetchByName_Last(
		String name, OrderByComparator<WorkAreaType> orderByComparator) {

		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the work area types before and after the current work area type in the ordered set where name = &#63;.
	 *
	 * @param workAreaTypeId the primary key of the current work area type
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work area type
	 * @throws NoSuchWorkAreaTypeException if a work area type with the primary key could not be found
	 */
	public static WorkAreaType[] findByName_PrevAndNext(
			long workAreaTypeId, String name,
			OrderByComparator<WorkAreaType> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkAreaTypeException {

		return getPersistence().findByName_PrevAndNext(
			workAreaTypeId, name, orderByComparator);
	}

	/**
	 * Removes all the work area types where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeByName(String name) {
		getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of work area types where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching work area types
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Caches the work area type in the entity cache if it is enabled.
	 *
	 * @param workAreaType the work area type
	 */
	public static void cacheResult(WorkAreaType workAreaType) {
		getPersistence().cacheResult(workAreaType);
	}

	/**
	 * Caches the work area types in the entity cache if it is enabled.
	 *
	 * @param workAreaTypes the work area types
	 */
	public static void cacheResult(List<WorkAreaType> workAreaTypes) {
		getPersistence().cacheResult(workAreaTypes);
	}

	/**
	 * Creates a new work area type with the primary key. Does not add the work area type to the database.
	 *
	 * @param workAreaTypeId the primary key for the new work area type
	 * @return the new work area type
	 */
	public static WorkAreaType create(long workAreaTypeId) {
		return getPersistence().create(workAreaTypeId);
	}

	/**
	 * Removes the work area type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workAreaTypeId the primary key of the work area type
	 * @return the work area type that was removed
	 * @throws NoSuchWorkAreaTypeException if a work area type with the primary key could not be found
	 */
	public static WorkAreaType remove(long workAreaTypeId)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkAreaTypeException {

		return getPersistence().remove(workAreaTypeId);
	}

	public static WorkAreaType updateImpl(WorkAreaType workAreaType) {
		return getPersistence().updateImpl(workAreaType);
	}

	/**
	 * Returns the work area type with the primary key or throws a <code>NoSuchWorkAreaTypeException</code> if it could not be found.
	 *
	 * @param workAreaTypeId the primary key of the work area type
	 * @return the work area type
	 * @throws NoSuchWorkAreaTypeException if a work area type with the primary key could not be found
	 */
	public static WorkAreaType findByPrimaryKey(long workAreaTypeId)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkAreaTypeException {

		return getPersistence().findByPrimaryKey(workAreaTypeId);
	}

	/**
	 * Returns the work area type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workAreaTypeId the primary key of the work area type
	 * @return the work area type, or <code>null</code> if a work area type with the primary key could not be found
	 */
	public static WorkAreaType fetchByPrimaryKey(long workAreaTypeId) {
		return getPersistence().fetchByPrimaryKey(workAreaTypeId);
	}

	/**
	 * Returns all the work area types.
	 *
	 * @return the work area types
	 */
	public static List<WorkAreaType> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the work area types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work area types
	 * @param end the upper bound of the range of work area types (not inclusive)
	 * @return the range of work area types
	 */
	public static List<WorkAreaType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the work area types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work area types
	 * @param end the upper bound of the range of work area types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of work area types
	 */
	public static List<WorkAreaType> findAll(
		int start, int end, OrderByComparator<WorkAreaType> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work area types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work area types
	 * @param end the upper bound of the range of work area types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of work area types
	 */
	public static List<WorkAreaType> findAll(
		int start, int end, OrderByComparator<WorkAreaType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the work area types from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of work area types.
	 *
	 * @return the number of work area types
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static WorkAreaTypePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<WorkAreaTypePersistence, WorkAreaTypePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(WorkAreaTypePersistence.class);

		ServiceTracker<WorkAreaTypePersistence, WorkAreaTypePersistence>
			serviceTracker =
				new ServiceTracker
					<WorkAreaTypePersistence, WorkAreaTypePersistence>(
						bundle.getBundleContext(),
						WorkAreaTypePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}