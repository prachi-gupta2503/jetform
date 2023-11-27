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

import com.adjecti.mdm.liferay.model.WorkArea;

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
 * The persistence utility for the work area service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.WorkAreaPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkAreaPersistence
 * @generated
 */
public class WorkAreaUtil {

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
	public static void clearCache(WorkArea workArea) {
		getPersistence().clearCache(workArea);
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
	public static Map<Serializable, WorkArea> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<WorkArea> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WorkArea> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WorkArea> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<WorkArea> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static WorkArea update(WorkArea workArea) {
		return getPersistence().update(workArea);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static WorkArea update(
		WorkArea workArea, ServiceContext serviceContext) {

		return getPersistence().update(workArea, serviceContext);
	}

	/**
	 * Returns all the work areas where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching work areas
	 */
	public static List<WorkArea> findByCode(String code) {
		return getPersistence().findByCode(code);
	}

	/**
	 * Returns a range of all the work areas where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of work areas
	 * @param end the upper bound of the range of work areas (not inclusive)
	 * @return the range of matching work areas
	 */
	public static List<WorkArea> findByCode(String code, int start, int end) {
		return getPersistence().findByCode(code, start, end);
	}

	/**
	 * Returns an ordered range of all the work areas where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of work areas
	 * @param end the upper bound of the range of work areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work areas
	 */
	public static List<WorkArea> findByCode(
		String code, int start, int end,
		OrderByComparator<WorkArea> orderByComparator) {

		return getPersistence().findByCode(code, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work areas where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of work areas
	 * @param end the upper bound of the range of work areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work areas
	 */
	public static List<WorkArea> findByCode(
		String code, int start, int end,
		OrderByComparator<WorkArea> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCode(
			code, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first work area in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area
	 * @throws NoSuchWorkAreaException if a matching work area could not be found
	 */
	public static WorkArea findByCode_First(
			String code, OrderByComparator<WorkArea> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkAreaException {

		return getPersistence().findByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the first work area in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area, or <code>null</code> if a matching work area could not be found
	 */
	public static WorkArea fetchByCode_First(
		String code, OrderByComparator<WorkArea> orderByComparator) {

		return getPersistence().fetchByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the last work area in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area
	 * @throws NoSuchWorkAreaException if a matching work area could not be found
	 */
	public static WorkArea findByCode_Last(
			String code, OrderByComparator<WorkArea> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkAreaException {

		return getPersistence().findByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the last work area in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area, or <code>null</code> if a matching work area could not be found
	 */
	public static WorkArea fetchByCode_Last(
		String code, OrderByComparator<WorkArea> orderByComparator) {

		return getPersistence().fetchByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the work areas before and after the current work area in the ordered set where code = &#63;.
	 *
	 * @param workAreaId the primary key of the current work area
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work area
	 * @throws NoSuchWorkAreaException if a work area with the primary key could not be found
	 */
	public static WorkArea[] findByCode_PrevAndNext(
			long workAreaId, String code,
			OrderByComparator<WorkArea> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkAreaException {

		return getPersistence().findByCode_PrevAndNext(
			workAreaId, code, orderByComparator);
	}

	/**
	 * Removes all the work areas where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public static void removeByCode(String code) {
		getPersistence().removeByCode(code);
	}

	/**
	 * Returns the number of work areas where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching work areas
	 */
	public static int countByCode(String code) {
		return getPersistence().countByCode(code);
	}

	/**
	 * Returns all the work areas where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching work areas
	 */
	public static List<WorkArea> findByName(String name) {
		return getPersistence().findByName(name);
	}

	/**
	 * Returns a range of all the work areas where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of work areas
	 * @param end the upper bound of the range of work areas (not inclusive)
	 * @return the range of matching work areas
	 */
	public static List<WorkArea> findByName(String name, int start, int end) {
		return getPersistence().findByName(name, start, end);
	}

	/**
	 * Returns an ordered range of all the work areas where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of work areas
	 * @param end the upper bound of the range of work areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work areas
	 */
	public static List<WorkArea> findByName(
		String name, int start, int end,
		OrderByComparator<WorkArea> orderByComparator) {

		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work areas where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of work areas
	 * @param end the upper bound of the range of work areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work areas
	 */
	public static List<WorkArea> findByName(
		String name, int start, int end,
		OrderByComparator<WorkArea> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByName(
			name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first work area in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area
	 * @throws NoSuchWorkAreaException if a matching work area could not be found
	 */
	public static WorkArea findByName_First(
			String name, OrderByComparator<WorkArea> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkAreaException {

		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	 * Returns the first work area in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area, or <code>null</code> if a matching work area could not be found
	 */
	public static WorkArea fetchByName_First(
		String name, OrderByComparator<WorkArea> orderByComparator) {

		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	 * Returns the last work area in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area
	 * @throws NoSuchWorkAreaException if a matching work area could not be found
	 */
	public static WorkArea findByName_Last(
			String name, OrderByComparator<WorkArea> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkAreaException {

		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the last work area in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area, or <code>null</code> if a matching work area could not be found
	 */
	public static WorkArea fetchByName_Last(
		String name, OrderByComparator<WorkArea> orderByComparator) {

		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the work areas before and after the current work area in the ordered set where name = &#63;.
	 *
	 * @param workAreaId the primary key of the current work area
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work area
	 * @throws NoSuchWorkAreaException if a work area with the primary key could not be found
	 */
	public static WorkArea[] findByName_PrevAndNext(
			long workAreaId, String name,
			OrderByComparator<WorkArea> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkAreaException {

		return getPersistence().findByName_PrevAndNext(
			workAreaId, name, orderByComparator);
	}

	/**
	 * Removes all the work areas where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeByName(String name) {
		getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of work areas where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching work areas
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Returns all the work areas where parentWorkAreaId = &#63;.
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @return the matching work areas
	 */
	public static List<WorkArea> findByParentWorkAreaId(long parentWorkAreaId) {
		return getPersistence().findByParentWorkAreaId(parentWorkAreaId);
	}

	/**
	 * Returns a range of all the work areas where parentWorkAreaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @param start the lower bound of the range of work areas
	 * @param end the upper bound of the range of work areas (not inclusive)
	 * @return the range of matching work areas
	 */
	public static List<WorkArea> findByParentWorkAreaId(
		long parentWorkAreaId, int start, int end) {

		return getPersistence().findByParentWorkAreaId(
			parentWorkAreaId, start, end);
	}

	/**
	 * Returns an ordered range of all the work areas where parentWorkAreaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @param start the lower bound of the range of work areas
	 * @param end the upper bound of the range of work areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work areas
	 */
	public static List<WorkArea> findByParentWorkAreaId(
		long parentWorkAreaId, int start, int end,
		OrderByComparator<WorkArea> orderByComparator) {

		return getPersistence().findByParentWorkAreaId(
			parentWorkAreaId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work areas where parentWorkAreaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @param start the lower bound of the range of work areas
	 * @param end the upper bound of the range of work areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work areas
	 */
	public static List<WorkArea> findByParentWorkAreaId(
		long parentWorkAreaId, int start, int end,
		OrderByComparator<WorkArea> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByParentWorkAreaId(
			parentWorkAreaId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first work area in the ordered set where parentWorkAreaId = &#63;.
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area
	 * @throws NoSuchWorkAreaException if a matching work area could not be found
	 */
	public static WorkArea findByParentWorkAreaId_First(
			long parentWorkAreaId,
			OrderByComparator<WorkArea> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkAreaException {

		return getPersistence().findByParentWorkAreaId_First(
			parentWorkAreaId, orderByComparator);
	}

	/**
	 * Returns the first work area in the ordered set where parentWorkAreaId = &#63;.
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area, or <code>null</code> if a matching work area could not be found
	 */
	public static WorkArea fetchByParentWorkAreaId_First(
		long parentWorkAreaId, OrderByComparator<WorkArea> orderByComparator) {

		return getPersistence().fetchByParentWorkAreaId_First(
			parentWorkAreaId, orderByComparator);
	}

	/**
	 * Returns the last work area in the ordered set where parentWorkAreaId = &#63;.
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area
	 * @throws NoSuchWorkAreaException if a matching work area could not be found
	 */
	public static WorkArea findByParentWorkAreaId_Last(
			long parentWorkAreaId,
			OrderByComparator<WorkArea> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkAreaException {

		return getPersistence().findByParentWorkAreaId_Last(
			parentWorkAreaId, orderByComparator);
	}

	/**
	 * Returns the last work area in the ordered set where parentWorkAreaId = &#63;.
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area, or <code>null</code> if a matching work area could not be found
	 */
	public static WorkArea fetchByParentWorkAreaId_Last(
		long parentWorkAreaId, OrderByComparator<WorkArea> orderByComparator) {

		return getPersistence().fetchByParentWorkAreaId_Last(
			parentWorkAreaId, orderByComparator);
	}

	/**
	 * Returns the work areas before and after the current work area in the ordered set where parentWorkAreaId = &#63;.
	 *
	 * @param workAreaId the primary key of the current work area
	 * @param parentWorkAreaId the parent work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work area
	 * @throws NoSuchWorkAreaException if a work area with the primary key could not be found
	 */
	public static WorkArea[] findByParentWorkAreaId_PrevAndNext(
			long workAreaId, long parentWorkAreaId,
			OrderByComparator<WorkArea> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkAreaException {

		return getPersistence().findByParentWorkAreaId_PrevAndNext(
			workAreaId, parentWorkAreaId, orderByComparator);
	}

	/**
	 * Removes all the work areas where parentWorkAreaId = &#63; from the database.
	 *
	 * @param parentWorkAreaId the parent work area ID
	 */
	public static void removeByParentWorkAreaId(long parentWorkAreaId) {
		getPersistence().removeByParentWorkAreaId(parentWorkAreaId);
	}

	/**
	 * Returns the number of work areas where parentWorkAreaId = &#63;.
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @return the number of matching work areas
	 */
	public static int countByParentWorkAreaId(long parentWorkAreaId) {
		return getPersistence().countByParentWorkAreaId(parentWorkAreaId);
	}

	/**
	 * Caches the work area in the entity cache if it is enabled.
	 *
	 * @param workArea the work area
	 */
	public static void cacheResult(WorkArea workArea) {
		getPersistence().cacheResult(workArea);
	}

	/**
	 * Caches the work areas in the entity cache if it is enabled.
	 *
	 * @param workAreas the work areas
	 */
	public static void cacheResult(List<WorkArea> workAreas) {
		getPersistence().cacheResult(workAreas);
	}

	/**
	 * Creates a new work area with the primary key. Does not add the work area to the database.
	 *
	 * @param workAreaId the primary key for the new work area
	 * @return the new work area
	 */
	public static WorkArea create(long workAreaId) {
		return getPersistence().create(workAreaId);
	}

	/**
	 * Removes the work area with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workAreaId the primary key of the work area
	 * @return the work area that was removed
	 * @throws NoSuchWorkAreaException if a work area with the primary key could not be found
	 */
	public static WorkArea remove(long workAreaId)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkAreaException {

		return getPersistence().remove(workAreaId);
	}

	public static WorkArea updateImpl(WorkArea workArea) {
		return getPersistence().updateImpl(workArea);
	}

	/**
	 * Returns the work area with the primary key or throws a <code>NoSuchWorkAreaException</code> if it could not be found.
	 *
	 * @param workAreaId the primary key of the work area
	 * @return the work area
	 * @throws NoSuchWorkAreaException if a work area with the primary key could not be found
	 */
	public static WorkArea findByPrimaryKey(long workAreaId)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkAreaException {

		return getPersistence().findByPrimaryKey(workAreaId);
	}

	/**
	 * Returns the work area with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workAreaId the primary key of the work area
	 * @return the work area, or <code>null</code> if a work area with the primary key could not be found
	 */
	public static WorkArea fetchByPrimaryKey(long workAreaId) {
		return getPersistence().fetchByPrimaryKey(workAreaId);
	}

	/**
	 * Returns all the work areas.
	 *
	 * @return the work areas
	 */
	public static List<WorkArea> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the work areas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work areas
	 * @param end the upper bound of the range of work areas (not inclusive)
	 * @return the range of work areas
	 */
	public static List<WorkArea> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the work areas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work areas
	 * @param end the upper bound of the range of work areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of work areas
	 */
	public static List<WorkArea> findAll(
		int start, int end, OrderByComparator<WorkArea> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work areas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work areas
	 * @param end the upper bound of the range of work areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of work areas
	 */
	public static List<WorkArea> findAll(
		int start, int end, OrderByComparator<WorkArea> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the work areas from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of work areas.
	 *
	 * @return the number of work areas
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static WorkAreaPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<WorkAreaPersistence, WorkAreaPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(WorkAreaPersistence.class);

		ServiceTracker<WorkAreaPersistence, WorkAreaPersistence>
			serviceTracker =
				new ServiceTracker<WorkAreaPersistence, WorkAreaPersistence>(
					bundle.getBundleContext(), WorkAreaPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}