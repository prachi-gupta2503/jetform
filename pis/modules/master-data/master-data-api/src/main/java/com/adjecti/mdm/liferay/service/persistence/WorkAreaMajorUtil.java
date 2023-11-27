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

import com.adjecti.mdm.liferay.model.WorkAreaMajor;

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
 * The persistence utility for the work area major service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.WorkAreaMajorPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkAreaMajorPersistence
 * @generated
 */
public class WorkAreaMajorUtil {

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
	public static void clearCache(WorkAreaMajor workAreaMajor) {
		getPersistence().clearCache(workAreaMajor);
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
	public static Map<Serializable, WorkAreaMajor> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<WorkAreaMajor> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WorkAreaMajor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WorkAreaMajor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<WorkAreaMajor> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static WorkAreaMajor update(WorkAreaMajor workAreaMajor) {
		return getPersistence().update(workAreaMajor);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static WorkAreaMajor update(
		WorkAreaMajor workAreaMajor, ServiceContext serviceContext) {

		return getPersistence().update(workAreaMajor, serviceContext);
	}

	/**
	 * Returns all the work area majors where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching work area majors
	 */
	public static List<WorkAreaMajor> findByCode(String code) {
		return getPersistence().findByCode(code);
	}

	/**
	 * Returns a range of all the work area majors where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMajorModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of work area majors
	 * @param end the upper bound of the range of work area majors (not inclusive)
	 * @return the range of matching work area majors
	 */
	public static List<WorkAreaMajor> findByCode(
		String code, int start, int end) {

		return getPersistence().findByCode(code, start, end);
	}

	/**
	 * Returns an ordered range of all the work area majors where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMajorModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of work area majors
	 * @param end the upper bound of the range of work area majors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work area majors
	 */
	public static List<WorkAreaMajor> findByCode(
		String code, int start, int end,
		OrderByComparator<WorkAreaMajor> orderByComparator) {

		return getPersistence().findByCode(code, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work area majors where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMajorModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of work area majors
	 * @param end the upper bound of the range of work area majors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work area majors
	 */
	public static List<WorkAreaMajor> findByCode(
		String code, int start, int end,
		OrderByComparator<WorkAreaMajor> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCode(
			code, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first work area major in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area major
	 * @throws NoSuchWorkAreaMajorException if a matching work area major could not be found
	 */
	public static WorkAreaMajor findByCode_First(
			String code, OrderByComparator<WorkAreaMajor> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkAreaMajorException {

		return getPersistence().findByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the first work area major in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area major, or <code>null</code> if a matching work area major could not be found
	 */
	public static WorkAreaMajor fetchByCode_First(
		String code, OrderByComparator<WorkAreaMajor> orderByComparator) {

		return getPersistence().fetchByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the last work area major in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area major
	 * @throws NoSuchWorkAreaMajorException if a matching work area major could not be found
	 */
	public static WorkAreaMajor findByCode_Last(
			String code, OrderByComparator<WorkAreaMajor> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkAreaMajorException {

		return getPersistence().findByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the last work area major in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area major, or <code>null</code> if a matching work area major could not be found
	 */
	public static WorkAreaMajor fetchByCode_Last(
		String code, OrderByComparator<WorkAreaMajor> orderByComparator) {

		return getPersistence().fetchByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the work area majors before and after the current work area major in the ordered set where code = &#63;.
	 *
	 * @param workAreaMajorId the primary key of the current work area major
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work area major
	 * @throws NoSuchWorkAreaMajorException if a work area major with the primary key could not be found
	 */
	public static WorkAreaMajor[] findByCode_PrevAndNext(
			long workAreaMajorId, String code,
			OrderByComparator<WorkAreaMajor> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkAreaMajorException {

		return getPersistence().findByCode_PrevAndNext(
			workAreaMajorId, code, orderByComparator);
	}

	/**
	 * Removes all the work area majors where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public static void removeByCode(String code) {
		getPersistence().removeByCode(code);
	}

	/**
	 * Returns the number of work area majors where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching work area majors
	 */
	public static int countByCode(String code) {
		return getPersistence().countByCode(code);
	}

	/**
	 * Returns all the work area majors where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching work area majors
	 */
	public static List<WorkAreaMajor> findByName(String name) {
		return getPersistence().findByName(name);
	}

	/**
	 * Returns a range of all the work area majors where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMajorModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of work area majors
	 * @param end the upper bound of the range of work area majors (not inclusive)
	 * @return the range of matching work area majors
	 */
	public static List<WorkAreaMajor> findByName(
		String name, int start, int end) {

		return getPersistence().findByName(name, start, end);
	}

	/**
	 * Returns an ordered range of all the work area majors where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMajorModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of work area majors
	 * @param end the upper bound of the range of work area majors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work area majors
	 */
	public static List<WorkAreaMajor> findByName(
		String name, int start, int end,
		OrderByComparator<WorkAreaMajor> orderByComparator) {

		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work area majors where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMajorModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of work area majors
	 * @param end the upper bound of the range of work area majors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work area majors
	 */
	public static List<WorkAreaMajor> findByName(
		String name, int start, int end,
		OrderByComparator<WorkAreaMajor> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByName(
			name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first work area major in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area major
	 * @throws NoSuchWorkAreaMajorException if a matching work area major could not be found
	 */
	public static WorkAreaMajor findByName_First(
			String name, OrderByComparator<WorkAreaMajor> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkAreaMajorException {

		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	 * Returns the first work area major in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area major, or <code>null</code> if a matching work area major could not be found
	 */
	public static WorkAreaMajor fetchByName_First(
		String name, OrderByComparator<WorkAreaMajor> orderByComparator) {

		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	 * Returns the last work area major in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area major
	 * @throws NoSuchWorkAreaMajorException if a matching work area major could not be found
	 */
	public static WorkAreaMajor findByName_Last(
			String name, OrderByComparator<WorkAreaMajor> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkAreaMajorException {

		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the last work area major in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area major, or <code>null</code> if a matching work area major could not be found
	 */
	public static WorkAreaMajor fetchByName_Last(
		String name, OrderByComparator<WorkAreaMajor> orderByComparator) {

		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the work area majors before and after the current work area major in the ordered set where name = &#63;.
	 *
	 * @param workAreaMajorId the primary key of the current work area major
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work area major
	 * @throws NoSuchWorkAreaMajorException if a work area major with the primary key could not be found
	 */
	public static WorkAreaMajor[] findByName_PrevAndNext(
			long workAreaMajorId, String name,
			OrderByComparator<WorkAreaMajor> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkAreaMajorException {

		return getPersistence().findByName_PrevAndNext(
			workAreaMajorId, name, orderByComparator);
	}

	/**
	 * Removes all the work area majors where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeByName(String name) {
		getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of work area majors where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching work area majors
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Returns all the work area majors where parentWorkAreaId = &#63;.
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @return the matching work area majors
	 */
	public static List<WorkAreaMajor> findByParentWorkAreaId(
		long parentWorkAreaId) {

		return getPersistence().findByParentWorkAreaId(parentWorkAreaId);
	}

	/**
	 * Returns a range of all the work area majors where parentWorkAreaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMajorModelImpl</code>.
	 * </p>
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @param start the lower bound of the range of work area majors
	 * @param end the upper bound of the range of work area majors (not inclusive)
	 * @return the range of matching work area majors
	 */
	public static List<WorkAreaMajor> findByParentWorkAreaId(
		long parentWorkAreaId, int start, int end) {

		return getPersistence().findByParentWorkAreaId(
			parentWorkAreaId, start, end);
	}

	/**
	 * Returns an ordered range of all the work area majors where parentWorkAreaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMajorModelImpl</code>.
	 * </p>
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @param start the lower bound of the range of work area majors
	 * @param end the upper bound of the range of work area majors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work area majors
	 */
	public static List<WorkAreaMajor> findByParentWorkAreaId(
		long parentWorkAreaId, int start, int end,
		OrderByComparator<WorkAreaMajor> orderByComparator) {

		return getPersistence().findByParentWorkAreaId(
			parentWorkAreaId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work area majors where parentWorkAreaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMajorModelImpl</code>.
	 * </p>
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @param start the lower bound of the range of work area majors
	 * @param end the upper bound of the range of work area majors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work area majors
	 */
	public static List<WorkAreaMajor> findByParentWorkAreaId(
		long parentWorkAreaId, int start, int end,
		OrderByComparator<WorkAreaMajor> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByParentWorkAreaId(
			parentWorkAreaId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first work area major in the ordered set where parentWorkAreaId = &#63;.
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area major
	 * @throws NoSuchWorkAreaMajorException if a matching work area major could not be found
	 */
	public static WorkAreaMajor findByParentWorkAreaId_First(
			long parentWorkAreaId,
			OrderByComparator<WorkAreaMajor> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkAreaMajorException {

		return getPersistence().findByParentWorkAreaId_First(
			parentWorkAreaId, orderByComparator);
	}

	/**
	 * Returns the first work area major in the ordered set where parentWorkAreaId = &#63;.
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area major, or <code>null</code> if a matching work area major could not be found
	 */
	public static WorkAreaMajor fetchByParentWorkAreaId_First(
		long parentWorkAreaId,
		OrderByComparator<WorkAreaMajor> orderByComparator) {

		return getPersistence().fetchByParentWorkAreaId_First(
			parentWorkAreaId, orderByComparator);
	}

	/**
	 * Returns the last work area major in the ordered set where parentWorkAreaId = &#63;.
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area major
	 * @throws NoSuchWorkAreaMajorException if a matching work area major could not be found
	 */
	public static WorkAreaMajor findByParentWorkAreaId_Last(
			long parentWorkAreaId,
			OrderByComparator<WorkAreaMajor> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkAreaMajorException {

		return getPersistence().findByParentWorkAreaId_Last(
			parentWorkAreaId, orderByComparator);
	}

	/**
	 * Returns the last work area major in the ordered set where parentWorkAreaId = &#63;.
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area major, or <code>null</code> if a matching work area major could not be found
	 */
	public static WorkAreaMajor fetchByParentWorkAreaId_Last(
		long parentWorkAreaId,
		OrderByComparator<WorkAreaMajor> orderByComparator) {

		return getPersistence().fetchByParentWorkAreaId_Last(
			parentWorkAreaId, orderByComparator);
	}

	/**
	 * Returns the work area majors before and after the current work area major in the ordered set where parentWorkAreaId = &#63;.
	 *
	 * @param workAreaMajorId the primary key of the current work area major
	 * @param parentWorkAreaId the parent work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work area major
	 * @throws NoSuchWorkAreaMajorException if a work area major with the primary key could not be found
	 */
	public static WorkAreaMajor[] findByParentWorkAreaId_PrevAndNext(
			long workAreaMajorId, long parentWorkAreaId,
			OrderByComparator<WorkAreaMajor> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkAreaMajorException {

		return getPersistence().findByParentWorkAreaId_PrevAndNext(
			workAreaMajorId, parentWorkAreaId, orderByComparator);
	}

	/**
	 * Removes all the work area majors where parentWorkAreaId = &#63; from the database.
	 *
	 * @param parentWorkAreaId the parent work area ID
	 */
	public static void removeByParentWorkAreaId(long parentWorkAreaId) {
		getPersistence().removeByParentWorkAreaId(parentWorkAreaId);
	}

	/**
	 * Returns the number of work area majors where parentWorkAreaId = &#63;.
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @return the number of matching work area majors
	 */
	public static int countByParentWorkAreaId(long parentWorkAreaId) {
		return getPersistence().countByParentWorkAreaId(parentWorkAreaId);
	}

	/**
	 * Caches the work area major in the entity cache if it is enabled.
	 *
	 * @param workAreaMajor the work area major
	 */
	public static void cacheResult(WorkAreaMajor workAreaMajor) {
		getPersistence().cacheResult(workAreaMajor);
	}

	/**
	 * Caches the work area majors in the entity cache if it is enabled.
	 *
	 * @param workAreaMajors the work area majors
	 */
	public static void cacheResult(List<WorkAreaMajor> workAreaMajors) {
		getPersistence().cacheResult(workAreaMajors);
	}

	/**
	 * Creates a new work area major with the primary key. Does not add the work area major to the database.
	 *
	 * @param workAreaMajorId the primary key for the new work area major
	 * @return the new work area major
	 */
	public static WorkAreaMajor create(long workAreaMajorId) {
		return getPersistence().create(workAreaMajorId);
	}

	/**
	 * Removes the work area major with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workAreaMajorId the primary key of the work area major
	 * @return the work area major that was removed
	 * @throws NoSuchWorkAreaMajorException if a work area major with the primary key could not be found
	 */
	public static WorkAreaMajor remove(long workAreaMajorId)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkAreaMajorException {

		return getPersistence().remove(workAreaMajorId);
	}

	public static WorkAreaMajor updateImpl(WorkAreaMajor workAreaMajor) {
		return getPersistence().updateImpl(workAreaMajor);
	}

	/**
	 * Returns the work area major with the primary key or throws a <code>NoSuchWorkAreaMajorException</code> if it could not be found.
	 *
	 * @param workAreaMajorId the primary key of the work area major
	 * @return the work area major
	 * @throws NoSuchWorkAreaMajorException if a work area major with the primary key could not be found
	 */
	public static WorkAreaMajor findByPrimaryKey(long workAreaMajorId)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkAreaMajorException {

		return getPersistence().findByPrimaryKey(workAreaMajorId);
	}

	/**
	 * Returns the work area major with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workAreaMajorId the primary key of the work area major
	 * @return the work area major, or <code>null</code> if a work area major with the primary key could not be found
	 */
	public static WorkAreaMajor fetchByPrimaryKey(long workAreaMajorId) {
		return getPersistence().fetchByPrimaryKey(workAreaMajorId);
	}

	/**
	 * Returns all the work area majors.
	 *
	 * @return the work area majors
	 */
	public static List<WorkAreaMajor> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the work area majors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMajorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work area majors
	 * @param end the upper bound of the range of work area majors (not inclusive)
	 * @return the range of work area majors
	 */
	public static List<WorkAreaMajor> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the work area majors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMajorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work area majors
	 * @param end the upper bound of the range of work area majors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of work area majors
	 */
	public static List<WorkAreaMajor> findAll(
		int start, int end,
		OrderByComparator<WorkAreaMajor> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work area majors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMajorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work area majors
	 * @param end the upper bound of the range of work area majors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of work area majors
	 */
	public static List<WorkAreaMajor> findAll(
		int start, int end, OrderByComparator<WorkAreaMajor> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the work area majors from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of work area majors.
	 *
	 * @return the number of work area majors
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static WorkAreaMajorPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<WorkAreaMajorPersistence, WorkAreaMajorPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(WorkAreaMajorPersistence.class);

		ServiceTracker<WorkAreaMajorPersistence, WorkAreaMajorPersistence>
			serviceTracker =
				new ServiceTracker
					<WorkAreaMajorPersistence, WorkAreaMajorPersistence>(
						bundle.getBundleContext(),
						WorkAreaMajorPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}