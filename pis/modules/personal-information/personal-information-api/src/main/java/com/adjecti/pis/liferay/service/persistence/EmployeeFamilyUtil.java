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

import com.adjecti.pis.liferay.model.EmployeeFamily;

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
 * The persistence utility for the employee family service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.EmployeeFamilyPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeFamilyPersistence
 * @generated
 */
public class EmployeeFamilyUtil {

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
	public static void clearCache(EmployeeFamily employeeFamily) {
		getPersistence().clearCache(employeeFamily);
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
	public static Map<Serializable, EmployeeFamily> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeFamily> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeFamily> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeFamily> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeFamily> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeFamily update(EmployeeFamily employeeFamily) {
		return getPersistence().update(employeeFamily);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeFamily update(
		EmployeeFamily employeeFamily, ServiceContext serviceContext) {

		return getPersistence().update(employeeFamily, serviceContext);
	}

	/**
	 * Returns all the employee families where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee families
	 */
	public static List<EmployeeFamily> findByEmployeeId(long employeeId) {
		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns a range of all the employee families where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeFamilyModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee families
	 * @param end the upper bound of the range of employee families (not inclusive)
	 * @return the range of matching employee families
	 */
	public static List<EmployeeFamily> findByEmployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee families where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeFamilyModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee families
	 * @param end the upper bound of the range of employee families (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee families
	 */
	public static List<EmployeeFamily> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeFamily> orderByComparator) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee families where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeFamilyModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee families
	 * @param end the upper bound of the range of employee families (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee families
	 */
	public static List<EmployeeFamily> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeFamily> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee family in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee family
	 * @throws NoSuchEmployeeFamilyException if a matching employee family could not be found
	 */
	public static EmployeeFamily findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeFamily> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeFamilyException {

		return getPersistence().findByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first employee family in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee family, or <code>null</code> if a matching employee family could not be found
	 */
	public static EmployeeFamily fetchByEmployeeId_First(
		long employeeId, OrderByComparator<EmployeeFamily> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee family in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee family
	 * @throws NoSuchEmployeeFamilyException if a matching employee family could not be found
	 */
	public static EmployeeFamily findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeFamily> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeFamilyException {

		return getPersistence().findByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee family in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee family, or <code>null</code> if a matching employee family could not be found
	 */
	public static EmployeeFamily fetchByEmployeeId_Last(
		long employeeId, OrderByComparator<EmployeeFamily> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the employee families before and after the current employee family in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeFamilyId the primary key of the current employee family
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee family
	 * @throws NoSuchEmployeeFamilyException if a employee family with the primary key could not be found
	 */
	public static EmployeeFamily[] findByEmployeeId_PrevAndNext(
			long employeeFamilyId, long employeeId,
			OrderByComparator<EmployeeFamily> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeFamilyException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			employeeFamilyId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the employee families where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of employee families where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee families
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Returns all the employee families where relationId = &#63;.
	 *
	 * @param relationId the relation ID
	 * @return the matching employee families
	 */
	public static List<EmployeeFamily> findByRelationId(long relationId) {
		return getPersistence().findByRelationId(relationId);
	}

	/**
	 * Returns a range of all the employee families where relationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeFamilyModelImpl</code>.
	 * </p>
	 *
	 * @param relationId the relation ID
	 * @param start the lower bound of the range of employee families
	 * @param end the upper bound of the range of employee families (not inclusive)
	 * @return the range of matching employee families
	 */
	public static List<EmployeeFamily> findByRelationId(
		long relationId, int start, int end) {

		return getPersistence().findByRelationId(relationId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee families where relationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeFamilyModelImpl</code>.
	 * </p>
	 *
	 * @param relationId the relation ID
	 * @param start the lower bound of the range of employee families
	 * @param end the upper bound of the range of employee families (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee families
	 */
	public static List<EmployeeFamily> findByRelationId(
		long relationId, int start, int end,
		OrderByComparator<EmployeeFamily> orderByComparator) {

		return getPersistence().findByRelationId(
			relationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee families where relationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeFamilyModelImpl</code>.
	 * </p>
	 *
	 * @param relationId the relation ID
	 * @param start the lower bound of the range of employee families
	 * @param end the upper bound of the range of employee families (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee families
	 */
	public static List<EmployeeFamily> findByRelationId(
		long relationId, int start, int end,
		OrderByComparator<EmployeeFamily> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRelationId(
			relationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee family in the ordered set where relationId = &#63;.
	 *
	 * @param relationId the relation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee family
	 * @throws NoSuchEmployeeFamilyException if a matching employee family could not be found
	 */
	public static EmployeeFamily findByRelationId_First(
			long relationId,
			OrderByComparator<EmployeeFamily> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeFamilyException {

		return getPersistence().findByRelationId_First(
			relationId, orderByComparator);
	}

	/**
	 * Returns the first employee family in the ordered set where relationId = &#63;.
	 *
	 * @param relationId the relation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee family, or <code>null</code> if a matching employee family could not be found
	 */
	public static EmployeeFamily fetchByRelationId_First(
		long relationId, OrderByComparator<EmployeeFamily> orderByComparator) {

		return getPersistence().fetchByRelationId_First(
			relationId, orderByComparator);
	}

	/**
	 * Returns the last employee family in the ordered set where relationId = &#63;.
	 *
	 * @param relationId the relation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee family
	 * @throws NoSuchEmployeeFamilyException if a matching employee family could not be found
	 */
	public static EmployeeFamily findByRelationId_Last(
			long relationId,
			OrderByComparator<EmployeeFamily> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeFamilyException {

		return getPersistence().findByRelationId_Last(
			relationId, orderByComparator);
	}

	/**
	 * Returns the last employee family in the ordered set where relationId = &#63;.
	 *
	 * @param relationId the relation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee family, or <code>null</code> if a matching employee family could not be found
	 */
	public static EmployeeFamily fetchByRelationId_Last(
		long relationId, OrderByComparator<EmployeeFamily> orderByComparator) {

		return getPersistence().fetchByRelationId_Last(
			relationId, orderByComparator);
	}

	/**
	 * Returns the employee families before and after the current employee family in the ordered set where relationId = &#63;.
	 *
	 * @param employeeFamilyId the primary key of the current employee family
	 * @param relationId the relation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee family
	 * @throws NoSuchEmployeeFamilyException if a employee family with the primary key could not be found
	 */
	public static EmployeeFamily[] findByRelationId_PrevAndNext(
			long employeeFamilyId, long relationId,
			OrderByComparator<EmployeeFamily> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeFamilyException {

		return getPersistence().findByRelationId_PrevAndNext(
			employeeFamilyId, relationId, orderByComparator);
	}

	/**
	 * Removes all the employee families where relationId = &#63; from the database.
	 *
	 * @param relationId the relation ID
	 */
	public static void removeByRelationId(long relationId) {
		getPersistence().removeByRelationId(relationId);
	}

	/**
	 * Returns the number of employee families where relationId = &#63;.
	 *
	 * @param relationId the relation ID
	 * @return the number of matching employee families
	 */
	public static int countByRelationId(long relationId) {
		return getPersistence().countByRelationId(relationId);
	}

	/**
	 * Returns all the employee families where occupationId = &#63;.
	 *
	 * @param occupationId the occupation ID
	 * @return the matching employee families
	 */
	public static List<EmployeeFamily> findByOccupationId(long occupationId) {
		return getPersistence().findByOccupationId(occupationId);
	}

	/**
	 * Returns a range of all the employee families where occupationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeFamilyModelImpl</code>.
	 * </p>
	 *
	 * @param occupationId the occupation ID
	 * @param start the lower bound of the range of employee families
	 * @param end the upper bound of the range of employee families (not inclusive)
	 * @return the range of matching employee families
	 */
	public static List<EmployeeFamily> findByOccupationId(
		long occupationId, int start, int end) {

		return getPersistence().findByOccupationId(occupationId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee families where occupationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeFamilyModelImpl</code>.
	 * </p>
	 *
	 * @param occupationId the occupation ID
	 * @param start the lower bound of the range of employee families
	 * @param end the upper bound of the range of employee families (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee families
	 */
	public static List<EmployeeFamily> findByOccupationId(
		long occupationId, int start, int end,
		OrderByComparator<EmployeeFamily> orderByComparator) {

		return getPersistence().findByOccupationId(
			occupationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee families where occupationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeFamilyModelImpl</code>.
	 * </p>
	 *
	 * @param occupationId the occupation ID
	 * @param start the lower bound of the range of employee families
	 * @param end the upper bound of the range of employee families (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee families
	 */
	public static List<EmployeeFamily> findByOccupationId(
		long occupationId, int start, int end,
		OrderByComparator<EmployeeFamily> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByOccupationId(
			occupationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee family in the ordered set where occupationId = &#63;.
	 *
	 * @param occupationId the occupation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee family
	 * @throws NoSuchEmployeeFamilyException if a matching employee family could not be found
	 */
	public static EmployeeFamily findByOccupationId_First(
			long occupationId,
			OrderByComparator<EmployeeFamily> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeFamilyException {

		return getPersistence().findByOccupationId_First(
			occupationId, orderByComparator);
	}

	/**
	 * Returns the first employee family in the ordered set where occupationId = &#63;.
	 *
	 * @param occupationId the occupation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee family, or <code>null</code> if a matching employee family could not be found
	 */
	public static EmployeeFamily fetchByOccupationId_First(
		long occupationId,
		OrderByComparator<EmployeeFamily> orderByComparator) {

		return getPersistence().fetchByOccupationId_First(
			occupationId, orderByComparator);
	}

	/**
	 * Returns the last employee family in the ordered set where occupationId = &#63;.
	 *
	 * @param occupationId the occupation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee family
	 * @throws NoSuchEmployeeFamilyException if a matching employee family could not be found
	 */
	public static EmployeeFamily findByOccupationId_Last(
			long occupationId,
			OrderByComparator<EmployeeFamily> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeFamilyException {

		return getPersistence().findByOccupationId_Last(
			occupationId, orderByComparator);
	}

	/**
	 * Returns the last employee family in the ordered set where occupationId = &#63;.
	 *
	 * @param occupationId the occupation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee family, or <code>null</code> if a matching employee family could not be found
	 */
	public static EmployeeFamily fetchByOccupationId_Last(
		long occupationId,
		OrderByComparator<EmployeeFamily> orderByComparator) {

		return getPersistence().fetchByOccupationId_Last(
			occupationId, orderByComparator);
	}

	/**
	 * Returns the employee families before and after the current employee family in the ordered set where occupationId = &#63;.
	 *
	 * @param employeeFamilyId the primary key of the current employee family
	 * @param occupationId the occupation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee family
	 * @throws NoSuchEmployeeFamilyException if a employee family with the primary key could not be found
	 */
	public static EmployeeFamily[] findByOccupationId_PrevAndNext(
			long employeeFamilyId, long occupationId,
			OrderByComparator<EmployeeFamily> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeFamilyException {

		return getPersistence().findByOccupationId_PrevAndNext(
			employeeFamilyId, occupationId, orderByComparator);
	}

	/**
	 * Removes all the employee families where occupationId = &#63; from the database.
	 *
	 * @param occupationId the occupation ID
	 */
	public static void removeByOccupationId(long occupationId) {
		getPersistence().removeByOccupationId(occupationId);
	}

	/**
	 * Returns the number of employee families where occupationId = &#63;.
	 *
	 * @param occupationId the occupation ID
	 * @return the number of matching employee families
	 */
	public static int countByOccupationId(long occupationId) {
		return getPersistence().countByOccupationId(occupationId);
	}

	/**
	 * Caches the employee family in the entity cache if it is enabled.
	 *
	 * @param employeeFamily the employee family
	 */
	public static void cacheResult(EmployeeFamily employeeFamily) {
		getPersistence().cacheResult(employeeFamily);
	}

	/**
	 * Caches the employee families in the entity cache if it is enabled.
	 *
	 * @param employeeFamilies the employee families
	 */
	public static void cacheResult(List<EmployeeFamily> employeeFamilies) {
		getPersistence().cacheResult(employeeFamilies);
	}

	/**
	 * Creates a new employee family with the primary key. Does not add the employee family to the database.
	 *
	 * @param employeeFamilyId the primary key for the new employee family
	 * @return the new employee family
	 */
	public static EmployeeFamily create(long employeeFamilyId) {
		return getPersistence().create(employeeFamilyId);
	}

	/**
	 * Removes the employee family with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeFamilyId the primary key of the employee family
	 * @return the employee family that was removed
	 * @throws NoSuchEmployeeFamilyException if a employee family with the primary key could not be found
	 */
	public static EmployeeFamily remove(long employeeFamilyId)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeFamilyException {

		return getPersistence().remove(employeeFamilyId);
	}

	public static EmployeeFamily updateImpl(EmployeeFamily employeeFamily) {
		return getPersistence().updateImpl(employeeFamily);
	}

	/**
	 * Returns the employee family with the primary key or throws a <code>NoSuchEmployeeFamilyException</code> if it could not be found.
	 *
	 * @param employeeFamilyId the primary key of the employee family
	 * @return the employee family
	 * @throws NoSuchEmployeeFamilyException if a employee family with the primary key could not be found
	 */
	public static EmployeeFamily findByPrimaryKey(long employeeFamilyId)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeFamilyException {

		return getPersistence().findByPrimaryKey(employeeFamilyId);
	}

	/**
	 * Returns the employee family with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeFamilyId the primary key of the employee family
	 * @return the employee family, or <code>null</code> if a employee family with the primary key could not be found
	 */
	public static EmployeeFamily fetchByPrimaryKey(long employeeFamilyId) {
		return getPersistence().fetchByPrimaryKey(employeeFamilyId);
	}

	/**
	 * Returns all the employee families.
	 *
	 * @return the employee families
	 */
	public static List<EmployeeFamily> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employee families.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeFamilyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee families
	 * @param end the upper bound of the range of employee families (not inclusive)
	 * @return the range of employee families
	 */
	public static List<EmployeeFamily> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employee families.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeFamilyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee families
	 * @param end the upper bound of the range of employee families (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee families
	 */
	public static List<EmployeeFamily> findAll(
		int start, int end,
		OrderByComparator<EmployeeFamily> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee families.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeFamilyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee families
	 * @param end the upper bound of the range of employee families (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee families
	 */
	public static List<EmployeeFamily> findAll(
		int start, int end, OrderByComparator<EmployeeFamily> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee families from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee families.
	 *
	 * @return the number of employee families
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeFamilyPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeeFamilyPersistence, EmployeeFamilyPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EmployeeFamilyPersistence.class);

		ServiceTracker<EmployeeFamilyPersistence, EmployeeFamilyPersistence>
			serviceTracker =
				new ServiceTracker
					<EmployeeFamilyPersistence, EmployeeFamilyPersistence>(
						bundle.getBundleContext(),
						EmployeeFamilyPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}