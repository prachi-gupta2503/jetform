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

import com.adjecti.pis.liferay.model.EmployeeJoining;

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
 * The persistence utility for the employee joining service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.EmployeeJoiningPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeJoiningPersistence
 * @generated
 */
public class EmployeeJoiningUtil {

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
	public static void clearCache(EmployeeJoining employeeJoining) {
		getPersistence().clearCache(employeeJoining);
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
	public static Map<Serializable, EmployeeJoining> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeJoining> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeJoining> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeJoining> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeJoining> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeJoining update(EmployeeJoining employeeJoining) {
		return getPersistence().update(employeeJoining);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeJoining update(
		EmployeeJoining employeeJoining, ServiceContext serviceContext) {

		return getPersistence().update(employeeJoining, serviceContext);
	}

	/**
	 * Returns all the employee joinings where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee joinings
	 */
	public static List<EmployeeJoining> findByEmployeeId(long employeeId) {
		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns a range of all the employee joinings where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @return the range of matching employee joinings
	 */
	public static List<EmployeeJoining> findByEmployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee joinings where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee joinings
	 */
	public static List<EmployeeJoining> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeJoining> orderByComparator) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee joinings where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee joinings
	 */
	public static List<EmployeeJoining> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeJoining> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee joining in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee joining
	 * @throws NoSuchEmployeeJoiningException if a matching employee joining could not be found
	 */
	public static EmployeeJoining findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeJoining> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeJoiningException {

		return getPersistence().findByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first employee joining in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee joining, or <code>null</code> if a matching employee joining could not be found
	 */
	public static EmployeeJoining fetchByEmployeeId_First(
		long employeeId, OrderByComparator<EmployeeJoining> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee joining in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee joining
	 * @throws NoSuchEmployeeJoiningException if a matching employee joining could not be found
	 */
	public static EmployeeJoining findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeJoining> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeJoiningException {

		return getPersistence().findByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee joining in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee joining, or <code>null</code> if a matching employee joining could not be found
	 */
	public static EmployeeJoining fetchByEmployeeId_Last(
		long employeeId, OrderByComparator<EmployeeJoining> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the employee joinings before and after the current employee joining in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeJoiningId the primary key of the current employee joining
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee joining
	 * @throws NoSuchEmployeeJoiningException if a employee joining with the primary key could not be found
	 */
	public static EmployeeJoining[] findByEmployeeId_PrevAndNext(
			long employeeJoiningId, long employeeId,
			OrderByComparator<EmployeeJoining> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeJoiningException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			employeeJoiningId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the employee joinings where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of employee joinings where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee joinings
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Returns all the employee joinings where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching employee joinings
	 */
	public static List<EmployeeJoining> findByOrganizationId(
		long organizationId) {

		return getPersistence().findByOrganizationId(organizationId);
	}

	/**
	 * Returns a range of all the employee joinings where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @return the range of matching employee joinings
	 */
	public static List<EmployeeJoining> findByOrganizationId(
		long organizationId, int start, int end) {

		return getPersistence().findByOrganizationId(
			organizationId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee joinings where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee joinings
	 */
	public static List<EmployeeJoining> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<EmployeeJoining> orderByComparator) {

		return getPersistence().findByOrganizationId(
			organizationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee joinings where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee joinings
	 */
	public static List<EmployeeJoining> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<EmployeeJoining> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByOrganizationId(
			organizationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee joining in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee joining
	 * @throws NoSuchEmployeeJoiningException if a matching employee joining could not be found
	 */
	public static EmployeeJoining findByOrganizationId_First(
			long organizationId,
			OrderByComparator<EmployeeJoining> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeJoiningException {

		return getPersistence().findByOrganizationId_First(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the first employee joining in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee joining, or <code>null</code> if a matching employee joining could not be found
	 */
	public static EmployeeJoining fetchByOrganizationId_First(
		long organizationId,
		OrderByComparator<EmployeeJoining> orderByComparator) {

		return getPersistence().fetchByOrganizationId_First(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the last employee joining in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee joining
	 * @throws NoSuchEmployeeJoiningException if a matching employee joining could not be found
	 */
	public static EmployeeJoining findByOrganizationId_Last(
			long organizationId,
			OrderByComparator<EmployeeJoining> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeJoiningException {

		return getPersistence().findByOrganizationId_Last(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the last employee joining in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee joining, or <code>null</code> if a matching employee joining could not be found
	 */
	public static EmployeeJoining fetchByOrganizationId_Last(
		long organizationId,
		OrderByComparator<EmployeeJoining> orderByComparator) {

		return getPersistence().fetchByOrganizationId_Last(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the employee joinings before and after the current employee joining in the ordered set where organizationId = &#63;.
	 *
	 * @param employeeJoiningId the primary key of the current employee joining
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee joining
	 * @throws NoSuchEmployeeJoiningException if a employee joining with the primary key could not be found
	 */
	public static EmployeeJoining[] findByOrganizationId_PrevAndNext(
			long employeeJoiningId, long organizationId,
			OrderByComparator<EmployeeJoining> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeJoiningException {

		return getPersistence().findByOrganizationId_PrevAndNext(
			employeeJoiningId, organizationId, orderByComparator);
	}

	/**
	 * Removes all the employee joinings where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	public static void removeByOrganizationId(long organizationId) {
		getPersistence().removeByOrganizationId(organizationId);
	}

	/**
	 * Returns the number of employee joinings where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching employee joinings
	 */
	public static int countByOrganizationId(long organizationId) {
		return getPersistence().countByOrganizationId(organizationId);
	}

	/**
	 * Returns all the employee joinings where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the matching employee joinings
	 */
	public static List<EmployeeJoining> findByJoiningProcessId(
		long joiningProcessId) {

		return getPersistence().findByJoiningProcessId(joiningProcessId);
	}

	/**
	 * Returns a range of all the employee joinings where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @return the range of matching employee joinings
	 */
	public static List<EmployeeJoining> findByJoiningProcessId(
		long joiningProcessId, int start, int end) {

		return getPersistence().findByJoiningProcessId(
			joiningProcessId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee joinings where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee joinings
	 */
	public static List<EmployeeJoining> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		OrderByComparator<EmployeeJoining> orderByComparator) {

		return getPersistence().findByJoiningProcessId(
			joiningProcessId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee joinings where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee joinings
	 */
	public static List<EmployeeJoining> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		OrderByComparator<EmployeeJoining> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByJoiningProcessId(
			joiningProcessId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee joining in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee joining
	 * @throws NoSuchEmployeeJoiningException if a matching employee joining could not be found
	 */
	public static EmployeeJoining findByJoiningProcessId_First(
			long joiningProcessId,
			OrderByComparator<EmployeeJoining> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeJoiningException {

		return getPersistence().findByJoiningProcessId_First(
			joiningProcessId, orderByComparator);
	}

	/**
	 * Returns the first employee joining in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee joining, or <code>null</code> if a matching employee joining could not be found
	 */
	public static EmployeeJoining fetchByJoiningProcessId_First(
		long joiningProcessId,
		OrderByComparator<EmployeeJoining> orderByComparator) {

		return getPersistence().fetchByJoiningProcessId_First(
			joiningProcessId, orderByComparator);
	}

	/**
	 * Returns the last employee joining in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee joining
	 * @throws NoSuchEmployeeJoiningException if a matching employee joining could not be found
	 */
	public static EmployeeJoining findByJoiningProcessId_Last(
			long joiningProcessId,
			OrderByComparator<EmployeeJoining> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeJoiningException {

		return getPersistence().findByJoiningProcessId_Last(
			joiningProcessId, orderByComparator);
	}

	/**
	 * Returns the last employee joining in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee joining, or <code>null</code> if a matching employee joining could not be found
	 */
	public static EmployeeJoining fetchByJoiningProcessId_Last(
		long joiningProcessId,
		OrderByComparator<EmployeeJoining> orderByComparator) {

		return getPersistence().fetchByJoiningProcessId_Last(
			joiningProcessId, orderByComparator);
	}

	/**
	 * Returns the employee joinings before and after the current employee joining in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param employeeJoiningId the primary key of the current employee joining
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee joining
	 * @throws NoSuchEmployeeJoiningException if a employee joining with the primary key could not be found
	 */
	public static EmployeeJoining[] findByJoiningProcessId_PrevAndNext(
			long employeeJoiningId, long joiningProcessId,
			OrderByComparator<EmployeeJoining> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeJoiningException {

		return getPersistence().findByJoiningProcessId_PrevAndNext(
			employeeJoiningId, joiningProcessId, orderByComparator);
	}

	/**
	 * Removes all the employee joinings where joiningProcessId = &#63; from the database.
	 *
	 * @param joiningProcessId the joining process ID
	 */
	public static void removeByJoiningProcessId(long joiningProcessId) {
		getPersistence().removeByJoiningProcessId(joiningProcessId);
	}

	/**
	 * Returns the number of employee joinings where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the number of matching employee joinings
	 */
	public static int countByJoiningProcessId(long joiningProcessId) {
		return getPersistence().countByJoiningProcessId(joiningProcessId);
	}

	/**
	 * Returns all the employee joinings where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @return the matching employee joinings
	 */
	public static List<EmployeeJoining> findByGradeModeId(long gradeModeId) {
		return getPersistence().findByGradeModeId(gradeModeId);
	}

	/**
	 * Returns a range of all the employee joinings where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @return the range of matching employee joinings
	 */
	public static List<EmployeeJoining> findByGradeModeId(
		long gradeModeId, int start, int end) {

		return getPersistence().findByGradeModeId(gradeModeId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee joinings where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee joinings
	 */
	public static List<EmployeeJoining> findByGradeModeId(
		long gradeModeId, int start, int end,
		OrderByComparator<EmployeeJoining> orderByComparator) {

		return getPersistence().findByGradeModeId(
			gradeModeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee joinings where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee joinings
	 */
	public static List<EmployeeJoining> findByGradeModeId(
		long gradeModeId, int start, int end,
		OrderByComparator<EmployeeJoining> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGradeModeId(
			gradeModeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee joining in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee joining
	 * @throws NoSuchEmployeeJoiningException if a matching employee joining could not be found
	 */
	public static EmployeeJoining findByGradeModeId_First(
			long gradeModeId,
			OrderByComparator<EmployeeJoining> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeJoiningException {

		return getPersistence().findByGradeModeId_First(
			gradeModeId, orderByComparator);
	}

	/**
	 * Returns the first employee joining in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee joining, or <code>null</code> if a matching employee joining could not be found
	 */
	public static EmployeeJoining fetchByGradeModeId_First(
		long gradeModeId,
		OrderByComparator<EmployeeJoining> orderByComparator) {

		return getPersistence().fetchByGradeModeId_First(
			gradeModeId, orderByComparator);
	}

	/**
	 * Returns the last employee joining in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee joining
	 * @throws NoSuchEmployeeJoiningException if a matching employee joining could not be found
	 */
	public static EmployeeJoining findByGradeModeId_Last(
			long gradeModeId,
			OrderByComparator<EmployeeJoining> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeJoiningException {

		return getPersistence().findByGradeModeId_Last(
			gradeModeId, orderByComparator);
	}

	/**
	 * Returns the last employee joining in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee joining, or <code>null</code> if a matching employee joining could not be found
	 */
	public static EmployeeJoining fetchByGradeModeId_Last(
		long gradeModeId,
		OrderByComparator<EmployeeJoining> orderByComparator) {

		return getPersistence().fetchByGradeModeId_Last(
			gradeModeId, orderByComparator);
	}

	/**
	 * Returns the employee joinings before and after the current employee joining in the ordered set where gradeModeId = &#63;.
	 *
	 * @param employeeJoiningId the primary key of the current employee joining
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee joining
	 * @throws NoSuchEmployeeJoiningException if a employee joining with the primary key could not be found
	 */
	public static EmployeeJoining[] findByGradeModeId_PrevAndNext(
			long employeeJoiningId, long gradeModeId,
			OrderByComparator<EmployeeJoining> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeJoiningException {

		return getPersistence().findByGradeModeId_PrevAndNext(
			employeeJoiningId, gradeModeId, orderByComparator);
	}

	/**
	 * Removes all the employee joinings where gradeModeId = &#63; from the database.
	 *
	 * @param gradeModeId the grade mode ID
	 */
	public static void removeByGradeModeId(long gradeModeId) {
		getPersistence().removeByGradeModeId(gradeModeId);
	}

	/**
	 * Returns the number of employee joinings where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @return the number of matching employee joinings
	 */
	public static int countByGradeModeId(long gradeModeId) {
		return getPersistence().countByGradeModeId(gradeModeId);
	}

	/**
	 * Returns all the employee joinings where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @return the matching employee joinings
	 */
	public static List<EmployeeJoining> findBySubOrganizationId(
		long subOrganizationId) {

		return getPersistence().findBySubOrganizationId(subOrganizationId);
	}

	/**
	 * Returns a range of all the employee joinings where subOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @return the range of matching employee joinings
	 */
	public static List<EmployeeJoining> findBySubOrganizationId(
		long subOrganizationId, int start, int end) {

		return getPersistence().findBySubOrganizationId(
			subOrganizationId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee joinings where subOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee joinings
	 */
	public static List<EmployeeJoining> findBySubOrganizationId(
		long subOrganizationId, int start, int end,
		OrderByComparator<EmployeeJoining> orderByComparator) {

		return getPersistence().findBySubOrganizationId(
			subOrganizationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee joinings where subOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee joinings
	 */
	public static List<EmployeeJoining> findBySubOrganizationId(
		long subOrganizationId, int start, int end,
		OrderByComparator<EmployeeJoining> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySubOrganizationId(
			subOrganizationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee joining in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee joining
	 * @throws NoSuchEmployeeJoiningException if a matching employee joining could not be found
	 */
	public static EmployeeJoining findBySubOrganizationId_First(
			long subOrganizationId,
			OrderByComparator<EmployeeJoining> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeJoiningException {

		return getPersistence().findBySubOrganizationId_First(
			subOrganizationId, orderByComparator);
	}

	/**
	 * Returns the first employee joining in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee joining, or <code>null</code> if a matching employee joining could not be found
	 */
	public static EmployeeJoining fetchBySubOrganizationId_First(
		long subOrganizationId,
		OrderByComparator<EmployeeJoining> orderByComparator) {

		return getPersistence().fetchBySubOrganizationId_First(
			subOrganizationId, orderByComparator);
	}

	/**
	 * Returns the last employee joining in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee joining
	 * @throws NoSuchEmployeeJoiningException if a matching employee joining could not be found
	 */
	public static EmployeeJoining findBySubOrganizationId_Last(
			long subOrganizationId,
			OrderByComparator<EmployeeJoining> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeJoiningException {

		return getPersistence().findBySubOrganizationId_Last(
			subOrganizationId, orderByComparator);
	}

	/**
	 * Returns the last employee joining in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee joining, or <code>null</code> if a matching employee joining could not be found
	 */
	public static EmployeeJoining fetchBySubOrganizationId_Last(
		long subOrganizationId,
		OrderByComparator<EmployeeJoining> orderByComparator) {

		return getPersistence().fetchBySubOrganizationId_Last(
			subOrganizationId, orderByComparator);
	}

	/**
	 * Returns the employee joinings before and after the current employee joining in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param employeeJoiningId the primary key of the current employee joining
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee joining
	 * @throws NoSuchEmployeeJoiningException if a employee joining with the primary key could not be found
	 */
	public static EmployeeJoining[] findBySubOrganizationId_PrevAndNext(
			long employeeJoiningId, long subOrganizationId,
			OrderByComparator<EmployeeJoining> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeJoiningException {

		return getPersistence().findBySubOrganizationId_PrevAndNext(
			employeeJoiningId, subOrganizationId, orderByComparator);
	}

	/**
	 * Removes all the employee joinings where subOrganizationId = &#63; from the database.
	 *
	 * @param subOrganizationId the sub organization ID
	 */
	public static void removeBySubOrganizationId(long subOrganizationId) {
		getPersistence().removeBySubOrganizationId(subOrganizationId);
	}

	/**
	 * Returns the number of employee joinings where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @return the number of matching employee joinings
	 */
	public static int countBySubOrganizationId(long subOrganizationId) {
		return getPersistence().countBySubOrganizationId(subOrganizationId);
	}

	/**
	 * Caches the employee joining in the entity cache if it is enabled.
	 *
	 * @param employeeJoining the employee joining
	 */
	public static void cacheResult(EmployeeJoining employeeJoining) {
		getPersistence().cacheResult(employeeJoining);
	}

	/**
	 * Caches the employee joinings in the entity cache if it is enabled.
	 *
	 * @param employeeJoinings the employee joinings
	 */
	public static void cacheResult(List<EmployeeJoining> employeeJoinings) {
		getPersistence().cacheResult(employeeJoinings);
	}

	/**
	 * Creates a new employee joining with the primary key. Does not add the employee joining to the database.
	 *
	 * @param employeeJoiningId the primary key for the new employee joining
	 * @return the new employee joining
	 */
	public static EmployeeJoining create(long employeeJoiningId) {
		return getPersistence().create(employeeJoiningId);
	}

	/**
	 * Removes the employee joining with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeJoiningId the primary key of the employee joining
	 * @return the employee joining that was removed
	 * @throws NoSuchEmployeeJoiningException if a employee joining with the primary key could not be found
	 */
	public static EmployeeJoining remove(long employeeJoiningId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeJoiningException {

		return getPersistence().remove(employeeJoiningId);
	}

	public static EmployeeJoining updateImpl(EmployeeJoining employeeJoining) {
		return getPersistence().updateImpl(employeeJoining);
	}

	/**
	 * Returns the employee joining with the primary key or throws a <code>NoSuchEmployeeJoiningException</code> if it could not be found.
	 *
	 * @param employeeJoiningId the primary key of the employee joining
	 * @return the employee joining
	 * @throws NoSuchEmployeeJoiningException if a employee joining with the primary key could not be found
	 */
	public static EmployeeJoining findByPrimaryKey(long employeeJoiningId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeJoiningException {

		return getPersistence().findByPrimaryKey(employeeJoiningId);
	}

	/**
	 * Returns the employee joining with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeJoiningId the primary key of the employee joining
	 * @return the employee joining, or <code>null</code> if a employee joining with the primary key could not be found
	 */
	public static EmployeeJoining fetchByPrimaryKey(long employeeJoiningId) {
		return getPersistence().fetchByPrimaryKey(employeeJoiningId);
	}

	/**
	 * Returns all the employee joinings.
	 *
	 * @return the employee joinings
	 */
	public static List<EmployeeJoining> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employee joinings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @return the range of employee joinings
	 */
	public static List<EmployeeJoining> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employee joinings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee joinings
	 */
	public static List<EmployeeJoining> findAll(
		int start, int end,
		OrderByComparator<EmployeeJoining> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee joinings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee joinings
	 */
	public static List<EmployeeJoining> findAll(
		int start, int end,
		OrderByComparator<EmployeeJoining> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee joinings from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee joinings.
	 *
	 * @return the number of employee joinings
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeJoiningPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeeJoiningPersistence, EmployeeJoiningPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EmployeeJoiningPersistence.class);

		ServiceTracker<EmployeeJoiningPersistence, EmployeeJoiningPersistence>
			serviceTracker =
				new ServiceTracker
					<EmployeeJoiningPersistence, EmployeeJoiningPersistence>(
						bundle.getBundleContext(),
						EmployeeJoiningPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}