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

import com.adjecti.pis.liferay.model.Employee;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the employee service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.EmployeePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeePersistence
 * @generated
 */
public class EmployeeUtil {

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
	public static void clearCache(Employee employee) {
		getPersistence().clearCache(employee);
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
	public static Map<Serializable, Employee> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Employee> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Employee> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Employee> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Employee update(Employee employee) {
		return getPersistence().update(employee);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Employee update(
		Employee employee, ServiceContext serviceContext) {

		return getPersistence().update(employee, serviceContext);
	}

	/**
	 * Returns all the employees where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employees
	 */
	public static List<Employee> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the employees where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 */
	public static List<Employee> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the employees where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employees where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Employee> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByUuid_First(
			String uuid, OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first employee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByUuid_First(
		String uuid, OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByUuid_Last(
			String uuid, OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByUuid_Last(
		String uuid, OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the employees before and after the current employee in the ordered set where uuid = &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
	public static Employee[] findByUuid_PrevAndNext(
			long employeeId, String uuid,
			OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByUuid_PrevAndNext(
			employeeId, uuid, orderByComparator);
	}

	/**
	 * Removes all the employees where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of employees where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employees
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the employee where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmployeeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByUUID_G(String uuid, long groupId)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the employee where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the employee where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the employee where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee that was removed
	 */
	public static Employee removeByUUID_G(String uuid, long groupId)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of employees where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employees
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the employees where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employees
	 */
	public static List<Employee> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the employees where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 */
	public static List<Employee> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the employees where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employees where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Employee> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first employee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the employees before and after the current employee in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
	public static Employee[] findByUuid_C_PrevAndNext(
			long employeeId, String uuid, long companyId,
			OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByUuid_C_PrevAndNext(
			employeeId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the employees where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of employees where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employees
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the employees where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching employees
	 */
	public static List<Employee> findByOrganizationId(long organizationId) {
		return getPersistence().findByOrganizationId(organizationId);
	}

	/**
	 * Returns a range of all the employees where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 */
	public static List<Employee> findByOrganizationId(
		long organizationId, int start, int end) {

		return getPersistence().findByOrganizationId(
			organizationId, start, end);
	}

	/**
	 * Returns an ordered range of all the employees where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().findByOrganizationId(
			organizationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employees where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<Employee> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByOrganizationId(
			organizationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByOrganizationId_First(
			long organizationId, OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByOrganizationId_First(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the first employee in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByOrganizationId_First(
		long organizationId, OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByOrganizationId_First(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByOrganizationId_Last(
			long organizationId, OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByOrganizationId_Last(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByOrganizationId_Last(
		long organizationId, OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByOrganizationId_Last(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the employees before and after the current employee in the ordered set where organizationId = &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
	public static Employee[] findByOrganizationId_PrevAndNext(
			long employeeId, long organizationId,
			OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByOrganizationId_PrevAndNext(
			employeeId, organizationId, orderByComparator);
	}

	/**
	 * Removes all the employees where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	public static void removeByOrganizationId(long organizationId) {
		getPersistence().removeByOrganizationId(organizationId);
	}

	/**
	 * Returns the number of employees where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching employees
	 */
	public static int countByOrganizationId(long organizationId) {
		return getPersistence().countByOrganizationId(organizationId);
	}

	/**
	 * Returns all the employees where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @return the matching employees
	 */
	public static List<Employee> findBySubOrganizationId(
		long subOrganizationId) {

		return getPersistence().findBySubOrganizationId(subOrganizationId);
	}

	/**
	 * Returns a range of all the employees where subOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 */
	public static List<Employee> findBySubOrganizationId(
		long subOrganizationId, int start, int end) {

		return getPersistence().findBySubOrganizationId(
			subOrganizationId, start, end);
	}

	/**
	 * Returns an ordered range of all the employees where subOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findBySubOrganizationId(
		long subOrganizationId, int start, int end,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().findBySubOrganizationId(
			subOrganizationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employees where subOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findBySubOrganizationId(
		long subOrganizationId, int start, int end,
		OrderByComparator<Employee> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBySubOrganizationId(
			subOrganizationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findBySubOrganizationId_First(
			long subOrganizationId,
			OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findBySubOrganizationId_First(
			subOrganizationId, orderByComparator);
	}

	/**
	 * Returns the first employee in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchBySubOrganizationId_First(
		long subOrganizationId, OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchBySubOrganizationId_First(
			subOrganizationId, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findBySubOrganizationId_Last(
			long subOrganizationId,
			OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findBySubOrganizationId_Last(
			subOrganizationId, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchBySubOrganizationId_Last(
		long subOrganizationId, OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchBySubOrganizationId_Last(
			subOrganizationId, orderByComparator);
	}

	/**
	 * Returns the employees before and after the current employee in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
	public static Employee[] findBySubOrganizationId_PrevAndNext(
			long employeeId, long subOrganizationId,
			OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findBySubOrganizationId_PrevAndNext(
			employeeId, subOrganizationId, orderByComparator);
	}

	/**
	 * Removes all the employees where subOrganizationId = &#63; from the database.
	 *
	 * @param subOrganizationId the sub organization ID
	 */
	public static void removeBySubOrganizationId(long subOrganizationId) {
		getPersistence().removeBySubOrganizationId(subOrganizationId);
	}

	/**
	 * Returns the number of employees where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @return the number of matching employees
	 */
	public static int countBySubOrganizationId(long subOrganizationId) {
		return getPersistence().countBySubOrganizationId(subOrganizationId);
	}

	/**
	 * Returns the employee where peopleId = &#63; or throws a <code>NoSuchEmployeeException</code> if it could not be found.
	 *
	 * @param peopleId the people ID
	 * @return the matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByPeopleId(long peopleId)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByPeopleId(peopleId);
	}

	/**
	 * Returns the employee where peopleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param peopleId the people ID
	 * @return the matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByPeopleId(long peopleId) {
		return getPersistence().fetchByPeopleId(peopleId);
	}

	/**
	 * Returns the employee where peopleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param peopleId the people ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByPeopleId(
		long peopleId, boolean useFinderCache) {

		return getPersistence().fetchByPeopleId(peopleId, useFinderCache);
	}

	/**
	 * Removes the employee where peopleId = &#63; from the database.
	 *
	 * @param peopleId the people ID
	 * @return the employee that was removed
	 */
	public static Employee removeByPeopleId(long peopleId)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().removeByPeopleId(peopleId);
	}

	/**
	 * Returns the number of employees where peopleId = &#63;.
	 *
	 * @param peopleId the people ID
	 * @return the number of matching employees
	 */
	public static int countByPeopleId(long peopleId) {
		return getPersistence().countByPeopleId(peopleId);
	}

	/**
	 * Returns all the employees where retirementDate = &#63;.
	 *
	 * @param retirementDate the retirement date
	 * @return the matching employees
	 */
	public static List<Employee> findByRetirementDate(Date retirementDate) {
		return getPersistence().findByRetirementDate(retirementDate);
	}

	/**
	 * Returns a range of all the employees where retirementDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param retirementDate the retirement date
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 */
	public static List<Employee> findByRetirementDate(
		Date retirementDate, int start, int end) {

		return getPersistence().findByRetirementDate(
			retirementDate, start, end);
	}

	/**
	 * Returns an ordered range of all the employees where retirementDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param retirementDate the retirement date
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByRetirementDate(
		Date retirementDate, int start, int end,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().findByRetirementDate(
			retirementDate, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employees where retirementDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param retirementDate the retirement date
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByRetirementDate(
		Date retirementDate, int start, int end,
		OrderByComparator<Employee> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByRetirementDate(
			retirementDate, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee in the ordered set where retirementDate = &#63;.
	 *
	 * @param retirementDate the retirement date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByRetirementDate_First(
			Date retirementDate, OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByRetirementDate_First(
			retirementDate, orderByComparator);
	}

	/**
	 * Returns the first employee in the ordered set where retirementDate = &#63;.
	 *
	 * @param retirementDate the retirement date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByRetirementDate_First(
		Date retirementDate, OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByRetirementDate_First(
			retirementDate, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where retirementDate = &#63;.
	 *
	 * @param retirementDate the retirement date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByRetirementDate_Last(
			Date retirementDate, OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByRetirementDate_Last(
			retirementDate, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where retirementDate = &#63;.
	 *
	 * @param retirementDate the retirement date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByRetirementDate_Last(
		Date retirementDate, OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByRetirementDate_Last(
			retirementDate, orderByComparator);
	}

	/**
	 * Returns the employees before and after the current employee in the ordered set where retirementDate = &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param retirementDate the retirement date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
	public static Employee[] findByRetirementDate_PrevAndNext(
			long employeeId, Date retirementDate,
			OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByRetirementDate_PrevAndNext(
			employeeId, retirementDate, orderByComparator);
	}

	/**
	 * Removes all the employees where retirementDate = &#63; from the database.
	 *
	 * @param retirementDate the retirement date
	 */
	public static void removeByRetirementDate(Date retirementDate) {
		getPersistence().removeByRetirementDate(retirementDate);
	}

	/**
	 * Returns the number of employees where retirementDate = &#63;.
	 *
	 * @param retirementDate the retirement date
	 * @return the number of matching employees
	 */
	public static int countByRetirementDate(Date retirementDate) {
		return getPersistence().countByRetirementDate(retirementDate);
	}

	/**
	 * Returns all the employees where organizationId = &#63; and designationGroupId = &#63; and tradeId = &#63; and gradeId = &#63; and designationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param designationGroupId the designation group ID
	 * @param tradeId the trade ID
	 * @param gradeId the grade ID
	 * @param designationId the designation ID
	 * @return the matching employees
	 */
	public static List<Employee>
		findByorgAndTradeAndGradeAndDesignationAndGroupId(
			long organizationId, long designationGroupId, long tradeId,
			long gradeId, long designationId) {

		return getPersistence().
			findByorgAndTradeAndGradeAndDesignationAndGroupId(
				organizationId, designationGroupId, tradeId, gradeId,
				designationId);
	}

	/**
	 * Returns a range of all the employees where organizationId = &#63; and designationGroupId = &#63; and tradeId = &#63; and gradeId = &#63; and designationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param designationGroupId the designation group ID
	 * @param tradeId the trade ID
	 * @param gradeId the grade ID
	 * @param designationId the designation ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 */
	public static List<Employee>
		findByorgAndTradeAndGradeAndDesignationAndGroupId(
			long organizationId, long designationGroupId, long tradeId,
			long gradeId, long designationId, int start, int end) {

		return getPersistence().
			findByorgAndTradeAndGradeAndDesignationAndGroupId(
				organizationId, designationGroupId, tradeId, gradeId,
				designationId, start, end);
	}

	/**
	 * Returns an ordered range of all the employees where organizationId = &#63; and designationGroupId = &#63; and tradeId = &#63; and gradeId = &#63; and designationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param designationGroupId the designation group ID
	 * @param tradeId the trade ID
	 * @param gradeId the grade ID
	 * @param designationId the designation ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 */
	public static List<Employee>
		findByorgAndTradeAndGradeAndDesignationAndGroupId(
			long organizationId, long designationGroupId, long tradeId,
			long gradeId, long designationId, int start, int end,
			OrderByComparator<Employee> orderByComparator) {

		return getPersistence().
			findByorgAndTradeAndGradeAndDesignationAndGroupId(
				organizationId, designationGroupId, tradeId, gradeId,
				designationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employees where organizationId = &#63; and designationGroupId = &#63; and tradeId = &#63; and gradeId = &#63; and designationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param designationGroupId the designation group ID
	 * @param tradeId the trade ID
	 * @param gradeId the grade ID
	 * @param designationId the designation ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employees
	 */
	public static List<Employee>
		findByorgAndTradeAndGradeAndDesignationAndGroupId(
			long organizationId, long designationGroupId, long tradeId,
			long gradeId, long designationId, int start, int end,
			OrderByComparator<Employee> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().
			findByorgAndTradeAndGradeAndDesignationAndGroupId(
				organizationId, designationGroupId, tradeId, gradeId,
				designationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee in the ordered set where organizationId = &#63; and designationGroupId = &#63; and tradeId = &#63; and gradeId = &#63; and designationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param designationGroupId the designation group ID
	 * @param tradeId the trade ID
	 * @param gradeId the grade ID
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee
			findByorgAndTradeAndGradeAndDesignationAndGroupId_First(
				long organizationId, long designationGroupId, long tradeId,
				long gradeId, long designationId,
				OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().
			findByorgAndTradeAndGradeAndDesignationAndGroupId_First(
				organizationId, designationGroupId, tradeId, gradeId,
				designationId, orderByComparator);
	}

	/**
	 * Returns the first employee in the ordered set where organizationId = &#63; and designationGroupId = &#63; and tradeId = &#63; and gradeId = &#63; and designationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param designationGroupId the designation group ID
	 * @param tradeId the trade ID
	 * @param gradeId the grade ID
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee
		fetchByorgAndTradeAndGradeAndDesignationAndGroupId_First(
			long organizationId, long designationGroupId, long tradeId,
			long gradeId, long designationId,
			OrderByComparator<Employee> orderByComparator) {

		return getPersistence().
			fetchByorgAndTradeAndGradeAndDesignationAndGroupId_First(
				organizationId, designationGroupId, tradeId, gradeId,
				designationId, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where organizationId = &#63; and designationGroupId = &#63; and tradeId = &#63; and gradeId = &#63; and designationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param designationGroupId the designation group ID
	 * @param tradeId the trade ID
	 * @param gradeId the grade ID
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee
			findByorgAndTradeAndGradeAndDesignationAndGroupId_Last(
				long organizationId, long designationGroupId, long tradeId,
				long gradeId, long designationId,
				OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().
			findByorgAndTradeAndGradeAndDesignationAndGroupId_Last(
				organizationId, designationGroupId, tradeId, gradeId,
				designationId, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where organizationId = &#63; and designationGroupId = &#63; and tradeId = &#63; and gradeId = &#63; and designationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param designationGroupId the designation group ID
	 * @param tradeId the trade ID
	 * @param gradeId the grade ID
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee
		fetchByorgAndTradeAndGradeAndDesignationAndGroupId_Last(
			long organizationId, long designationGroupId, long tradeId,
			long gradeId, long designationId,
			OrderByComparator<Employee> orderByComparator) {

		return getPersistence().
			fetchByorgAndTradeAndGradeAndDesignationAndGroupId_Last(
				organizationId, designationGroupId, tradeId, gradeId,
				designationId, orderByComparator);
	}

	/**
	 * Returns the employees before and after the current employee in the ordered set where organizationId = &#63; and designationGroupId = &#63; and tradeId = &#63; and gradeId = &#63; and designationId = &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param organizationId the organization ID
	 * @param designationGroupId the designation group ID
	 * @param tradeId the trade ID
	 * @param gradeId the grade ID
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
	public static Employee[]
			findByorgAndTradeAndGradeAndDesignationAndGroupId_PrevAndNext(
				long employeeId, long organizationId, long designationGroupId,
				long tradeId, long gradeId, long designationId,
				OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().
			findByorgAndTradeAndGradeAndDesignationAndGroupId_PrevAndNext(
				employeeId, organizationId, designationGroupId, tradeId,
				gradeId, designationId, orderByComparator);
	}

	/**
	 * Removes all the employees where organizationId = &#63; and designationGroupId = &#63; and tradeId = &#63; and gradeId = &#63; and designationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @param designationGroupId the designation group ID
	 * @param tradeId the trade ID
	 * @param gradeId the grade ID
	 * @param designationId the designation ID
	 */
	public static void removeByorgAndTradeAndGradeAndDesignationAndGroupId(
		long organizationId, long designationGroupId, long tradeId,
		long gradeId, long designationId) {

		getPersistence().removeByorgAndTradeAndGradeAndDesignationAndGroupId(
			organizationId, designationGroupId, tradeId, gradeId,
			designationId);
	}

	/**
	 * Returns the number of employees where organizationId = &#63; and designationGroupId = &#63; and tradeId = &#63; and gradeId = &#63; and designationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param designationGroupId the designation group ID
	 * @param tradeId the trade ID
	 * @param gradeId the grade ID
	 * @param designationId the designation ID
	 * @return the number of matching employees
	 */
	public static int countByorgAndTradeAndGradeAndDesignationAndGroupId(
		long organizationId, long designationGroupId, long tradeId,
		long gradeId, long designationId) {

		return getPersistence().
			countByorgAndTradeAndGradeAndDesignationAndGroupId(
				organizationId, designationGroupId, tradeId, gradeId,
				designationId);
	}

	/**
	 * Returns all the employees where groupId = &#63; and tradeId = &#63; and gradeId = &#63; and designationId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param tradeId the trade ID
	 * @param gradeId the grade ID
	 * @param designationId the designation ID
	 * @return the matching employees
	 */
	public static List<Employee> findBytradeAndGradeAndDesignationAndGroupId(
		long groupId, long tradeId, long gradeId, long designationId) {

		return getPersistence().findBytradeAndGradeAndDesignationAndGroupId(
			groupId, tradeId, gradeId, designationId);
	}

	/**
	 * Returns a range of all the employees where groupId = &#63; and tradeId = &#63; and gradeId = &#63; and designationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param tradeId the trade ID
	 * @param gradeId the grade ID
	 * @param designationId the designation ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 */
	public static List<Employee> findBytradeAndGradeAndDesignationAndGroupId(
		long groupId, long tradeId, long gradeId, long designationId, int start,
		int end) {

		return getPersistence().findBytradeAndGradeAndDesignationAndGroupId(
			groupId, tradeId, gradeId, designationId, start, end);
	}

	/**
	 * Returns an ordered range of all the employees where groupId = &#63; and tradeId = &#63; and gradeId = &#63; and designationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param tradeId the trade ID
	 * @param gradeId the grade ID
	 * @param designationId the designation ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findBytradeAndGradeAndDesignationAndGroupId(
		long groupId, long tradeId, long gradeId, long designationId, int start,
		int end, OrderByComparator<Employee> orderByComparator) {

		return getPersistence().findBytradeAndGradeAndDesignationAndGroupId(
			groupId, tradeId, gradeId, designationId, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employees where groupId = &#63; and tradeId = &#63; and gradeId = &#63; and designationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param tradeId the trade ID
	 * @param gradeId the grade ID
	 * @param designationId the designation ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findBytradeAndGradeAndDesignationAndGroupId(
		long groupId, long tradeId, long gradeId, long designationId, int start,
		int end, OrderByComparator<Employee> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBytradeAndGradeAndDesignationAndGroupId(
			groupId, tradeId, gradeId, designationId, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee in the ordered set where groupId = &#63; and tradeId = &#63; and gradeId = &#63; and designationId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param tradeId the trade ID
	 * @param gradeId the grade ID
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findBytradeAndGradeAndDesignationAndGroupId_First(
			long groupId, long tradeId, long gradeId, long designationId,
			OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().
			findBytradeAndGradeAndDesignationAndGroupId_First(
				groupId, tradeId, gradeId, designationId, orderByComparator);
	}

	/**
	 * Returns the first employee in the ordered set where groupId = &#63; and tradeId = &#63; and gradeId = &#63; and designationId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param tradeId the trade ID
	 * @param gradeId the grade ID
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchBytradeAndGradeAndDesignationAndGroupId_First(
		long groupId, long tradeId, long gradeId, long designationId,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().
			fetchBytradeAndGradeAndDesignationAndGroupId_First(
				groupId, tradeId, gradeId, designationId, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where groupId = &#63; and tradeId = &#63; and gradeId = &#63; and designationId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param tradeId the trade ID
	 * @param gradeId the grade ID
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findBytradeAndGradeAndDesignationAndGroupId_Last(
			long groupId, long tradeId, long gradeId, long designationId,
			OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().
			findBytradeAndGradeAndDesignationAndGroupId_Last(
				groupId, tradeId, gradeId, designationId, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where groupId = &#63; and tradeId = &#63; and gradeId = &#63; and designationId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param tradeId the trade ID
	 * @param gradeId the grade ID
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchBytradeAndGradeAndDesignationAndGroupId_Last(
		long groupId, long tradeId, long gradeId, long designationId,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().
			fetchBytradeAndGradeAndDesignationAndGroupId_Last(
				groupId, tradeId, gradeId, designationId, orderByComparator);
	}

	/**
	 * Returns the employees before and after the current employee in the ordered set where groupId = &#63; and tradeId = &#63; and gradeId = &#63; and designationId = &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param groupId the group ID
	 * @param tradeId the trade ID
	 * @param gradeId the grade ID
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
	public static Employee[]
			findBytradeAndGradeAndDesignationAndGroupId_PrevAndNext(
				long employeeId, long groupId, long tradeId, long gradeId,
				long designationId,
				OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().
			findBytradeAndGradeAndDesignationAndGroupId_PrevAndNext(
				employeeId, groupId, tradeId, gradeId, designationId,
				orderByComparator);
	}

	/**
	 * Removes all the employees where groupId = &#63; and tradeId = &#63; and gradeId = &#63; and designationId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param tradeId the trade ID
	 * @param gradeId the grade ID
	 * @param designationId the designation ID
	 */
	public static void removeBytradeAndGradeAndDesignationAndGroupId(
		long groupId, long tradeId, long gradeId, long designationId) {

		getPersistence().removeBytradeAndGradeAndDesignationAndGroupId(
			groupId, tradeId, gradeId, designationId);
	}

	/**
	 * Returns the number of employees where groupId = &#63; and tradeId = &#63; and gradeId = &#63; and designationId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param tradeId the trade ID
	 * @param gradeId the grade ID
	 * @param designationId the designation ID
	 * @return the number of matching employees
	 */
	public static int countBytradeAndGradeAndDesignationAndGroupId(
		long groupId, long tradeId, long gradeId, long designationId) {

		return getPersistence().countBytradeAndGradeAndDesignationAndGroupId(
			groupId, tradeId, gradeId, designationId);
	}

	/**
	 * Returns the employee where employeeId = &#63; or throws a <code>NoSuchEmployeeException</code> if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByEmployeeId(long employeeId)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns the employee where employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByEmployeeId(long employeeId) {
		return getPersistence().fetchByEmployeeId(employeeId);
	}

	/**
	 * Returns the employee where employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByEmployeeId(
		long employeeId, boolean useFinderCache) {

		return getPersistence().fetchByEmployeeId(employeeId, useFinderCache);
	}

	/**
	 * Removes the employee where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @return the employee that was removed
	 */
	public static Employee removeByEmployeeId(long employeeId)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of employees where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employees
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Returns the employee where personalNo = &#63; or throws a <code>NoSuchEmployeeException</code> if it could not be found.
	 *
	 * @param personalNo the personal no
	 * @return the matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByPersonalNo(String personalNo)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByPersonalNo(personalNo);
	}

	/**
	 * Returns the employee where personalNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param personalNo the personal no
	 * @return the matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByPersonalNo(String personalNo) {
		return getPersistence().fetchByPersonalNo(personalNo);
	}

	/**
	 * Returns the employee where personalNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param personalNo the personal no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByPersonalNo(
		String personalNo, boolean useFinderCache) {

		return getPersistence().fetchByPersonalNo(personalNo, useFinderCache);
	}

	/**
	 * Removes the employee where personalNo = &#63; from the database.
	 *
	 * @param personalNo the personal no
	 * @return the employee that was removed
	 */
	public static Employee removeByPersonalNo(String personalNo)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().removeByPersonalNo(personalNo);
	}

	/**
	 * Returns the number of employees where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @return the number of matching employees
	 */
	public static int countByPersonalNo(String personalNo) {
		return getPersistence().countByPersonalNo(personalNo);
	}

	/**
	 * Returns all the employees where organizationId = &#63; and personalNo = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param personalNo the personal no
	 * @return the matching employees
	 */
	public static List<Employee> findByOrganizationIdAndPersonalNo(
		long organizationId, String personalNo) {

		return getPersistence().findByOrganizationIdAndPersonalNo(
			organizationId, personalNo);
	}

	/**
	 * Returns a range of all the employees where organizationId = &#63; and personalNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param personalNo the personal no
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 */
	public static List<Employee> findByOrganizationIdAndPersonalNo(
		long organizationId, String personalNo, int start, int end) {

		return getPersistence().findByOrganizationIdAndPersonalNo(
			organizationId, personalNo, start, end);
	}

	/**
	 * Returns an ordered range of all the employees where organizationId = &#63; and personalNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param personalNo the personal no
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByOrganizationIdAndPersonalNo(
		long organizationId, String personalNo, int start, int end,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().findByOrganizationIdAndPersonalNo(
			organizationId, personalNo, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employees where organizationId = &#63; and personalNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param personalNo the personal no
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByOrganizationIdAndPersonalNo(
		long organizationId, String personalNo, int start, int end,
		OrderByComparator<Employee> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByOrganizationIdAndPersonalNo(
			organizationId, personalNo, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first employee in the ordered set where organizationId = &#63; and personalNo = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByOrganizationIdAndPersonalNo_First(
			long organizationId, String personalNo,
			OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByOrganizationIdAndPersonalNo_First(
			organizationId, personalNo, orderByComparator);
	}

	/**
	 * Returns the first employee in the ordered set where organizationId = &#63; and personalNo = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByOrganizationIdAndPersonalNo_First(
		long organizationId, String personalNo,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByOrganizationIdAndPersonalNo_First(
			organizationId, personalNo, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where organizationId = &#63; and personalNo = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByOrganizationIdAndPersonalNo_Last(
			long organizationId, String personalNo,
			OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByOrganizationIdAndPersonalNo_Last(
			organizationId, personalNo, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where organizationId = &#63; and personalNo = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByOrganizationIdAndPersonalNo_Last(
		long organizationId, String personalNo,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByOrganizationIdAndPersonalNo_Last(
			organizationId, personalNo, orderByComparator);
	}

	/**
	 * Returns the employees before and after the current employee in the ordered set where organizationId = &#63; and personalNo = &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param organizationId the organization ID
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
	public static Employee[] findByOrganizationIdAndPersonalNo_PrevAndNext(
			long employeeId, long organizationId, String personalNo,
			OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByOrganizationIdAndPersonalNo_PrevAndNext(
			employeeId, organizationId, personalNo, orderByComparator);
	}

	/**
	 * Removes all the employees where organizationId = &#63; and personalNo = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @param personalNo the personal no
	 */
	public static void removeByOrganizationIdAndPersonalNo(
		long organizationId, String personalNo) {

		getPersistence().removeByOrganizationIdAndPersonalNo(
			organizationId, personalNo);
	}

	/**
	 * Returns the number of employees where organizationId = &#63; and personalNo = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param personalNo the personal no
	 * @return the number of matching employees
	 */
	public static int countByOrganizationIdAndPersonalNo(
		long organizationId, String personalNo) {

		return getPersistence().countByOrganizationIdAndPersonalNo(
			organizationId, personalNo);
	}

	/**
	 * Returns all the employees where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching employees
	 */
	public static List<Employee> findByStatus(int status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the employees where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 */
	public static List<Employee> findByStatus(int status, int start, int end) {
		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the employees where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByStatus(
		int status, int start, int end,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employees where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByStatus(
		int status, int start, int end,
		OrderByComparator<Employee> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByStatus_First(
			int status, OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first employee in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByStatus_First(
		int status, OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByStatus_Last(
			int status, OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByStatus_Last(
		int status, OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the employees before and after the current employee in the ordered set where status = &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
	public static Employee[] findByStatus_PrevAndNext(
			long employeeId, int status,
			OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByStatus_PrevAndNext(
			employeeId, status, orderByComparator);
	}

	/**
	 * Removes all the employees where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of employees where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching employees
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns all the employees where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching employees
	 */
	public static List<Employee> findByGroupIdAndStatus(
		long groupId, int status) {

		return getPersistence().findByGroupIdAndStatus(groupId, status);
	}

	/**
	 * Returns a range of all the employees where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 */
	public static List<Employee> findByGroupIdAndStatus(
		long groupId, int status, int start, int end) {

		return getPersistence().findByGroupIdAndStatus(
			groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the employees where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByGroupIdAndStatus(
		long groupId, int status, int start, int end,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().findByGroupIdAndStatus(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employees where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByGroupIdAndStatus(
		long groupId, int status, int start, int end,
		OrderByComparator<Employee> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupIdAndStatus(
			groupId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByGroupIdAndStatus_First(
			long groupId, int status,
			OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByGroupIdAndStatus_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the first employee in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByGroupIdAndStatus_First(
		long groupId, int status,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByGroupIdAndStatus_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByGroupIdAndStatus_Last(
			long groupId, int status,
			OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByGroupIdAndStatus_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByGroupIdAndStatus_Last(
		long groupId, int status,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByGroupIdAndStatus_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the employees before and after the current employee in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
	public static Employee[] findByGroupIdAndStatus_PrevAndNext(
			long employeeId, long groupId, int status,
			OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByGroupIdAndStatus_PrevAndNext(
			employeeId, groupId, status, orderByComparator);
	}

	/**
	 * Removes all the employees where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByGroupIdAndStatus(long groupId, int status) {
		getPersistence().removeByGroupIdAndStatus(groupId, status);
	}

	/**
	 * Returns the number of employees where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching employees
	 */
	public static int countByGroupIdAndStatus(long groupId, int status) {
		return getPersistence().countByGroupIdAndStatus(groupId, status);
	}

	/**
	 * Returns all the employees where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching employees
	 */
	public static List<Employee> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the employees where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 */
	public static List<Employee> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the employees where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employees where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Employee> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByGroupId_First(
			long groupId, OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first employee in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByGroupId_First(
		long groupId, OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByGroupId_Last(
			long groupId, OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByGroupId_Last(
		long groupId, OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the employees before and after the current employee in the ordered set where groupId = &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
	public static Employee[] findByGroupId_PrevAndNext(
			long employeeId, long groupId,
			OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByGroupId_PrevAndNext(
			employeeId, groupId, orderByComparator);
	}

	/**
	 * Removes all the employees where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of employees where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching employees
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the employees where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching employees
	 */
	public static List<Employee> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the employees where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 */
	public static List<Employee> findByUserId(long userId, int start, int end) {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the employees where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByUserId(
		long userId, int start, int end,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employees where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByUserId(
		long userId, int start, int end,
		OrderByComparator<Employee> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByUserId_First(
			long userId, OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first employee in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByUserId_First(
		long userId, OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByUserId_Last(
			long userId, OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByUserId_Last(
		long userId, OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the employees before and after the current employee in the ordered set where userId = &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
	public static Employee[] findByUserId_PrevAndNext(
			long employeeId, long userId,
			OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByUserId_PrevAndNext(
			employeeId, userId, orderByComparator);
	}

	/**
	 * Removes all the employees where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of employees where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching employees
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Returns all the employees where emailId = &#63;.
	 *
	 * @param emailId the email ID
	 * @return the matching employees
	 */
	public static List<Employee> findByEmailId(String emailId) {
		return getPersistence().findByEmailId(emailId);
	}

	/**
	 * Returns a range of all the employees where emailId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param emailId the email ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 */
	public static List<Employee> findByEmailId(
		String emailId, int start, int end) {

		return getPersistence().findByEmailId(emailId, start, end);
	}

	/**
	 * Returns an ordered range of all the employees where emailId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param emailId the email ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByEmailId(
		String emailId, int start, int end,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().findByEmailId(
			emailId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employees where emailId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param emailId the email ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByEmailId(
		String emailId, int start, int end,
		OrderByComparator<Employee> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByEmailId(
			emailId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee in the ordered set where emailId = &#63;.
	 *
	 * @param emailId the email ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByEmailId_First(
			String emailId, OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByEmailId_First(emailId, orderByComparator);
	}

	/**
	 * Returns the first employee in the ordered set where emailId = &#63;.
	 *
	 * @param emailId the email ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByEmailId_First(
		String emailId, OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByEmailId_First(
			emailId, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where emailId = &#63;.
	 *
	 * @param emailId the email ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByEmailId_Last(
			String emailId, OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByEmailId_Last(emailId, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where emailId = &#63;.
	 *
	 * @param emailId the email ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByEmailId_Last(
		String emailId, OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByEmailId_Last(emailId, orderByComparator);
	}

	/**
	 * Returns the employees before and after the current employee in the ordered set where emailId = &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param emailId the email ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
	public static Employee[] findByEmailId_PrevAndNext(
			long employeeId, String emailId,
			OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByEmailId_PrevAndNext(
			employeeId, emailId, orderByComparator);
	}

	/**
	 * Removes all the employees where emailId = &#63; from the database.
	 *
	 * @param emailId the email ID
	 */
	public static void removeByEmailId(String emailId) {
		getPersistence().removeByEmailId(emailId);
	}

	/**
	 * Returns the number of employees where emailId = &#63;.
	 *
	 * @param emailId the email ID
	 * @return the number of matching employees
	 */
	public static int countByEmailId(String emailId) {
		return getPersistence().countByEmailId(emailId);
	}

	/**
	 * Returns all the employees where loginId = &#63;.
	 *
	 * @param loginId the login ID
	 * @return the matching employees
	 */
	public static List<Employee> findByLoginId(String loginId) {
		return getPersistence().findByLoginId(loginId);
	}

	/**
	 * Returns a range of all the employees where loginId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param loginId the login ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 */
	public static List<Employee> findByLoginId(
		String loginId, int start, int end) {

		return getPersistence().findByLoginId(loginId, start, end);
	}

	/**
	 * Returns an ordered range of all the employees where loginId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param loginId the login ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByLoginId(
		String loginId, int start, int end,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().findByLoginId(
			loginId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employees where loginId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param loginId the login ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByLoginId(
		String loginId, int start, int end,
		OrderByComparator<Employee> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByLoginId(
			loginId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee in the ordered set where loginId = &#63;.
	 *
	 * @param loginId the login ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByLoginId_First(
			String loginId, OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByLoginId_First(loginId, orderByComparator);
	}

	/**
	 * Returns the first employee in the ordered set where loginId = &#63;.
	 *
	 * @param loginId the login ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByLoginId_First(
		String loginId, OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByLoginId_First(
			loginId, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where loginId = &#63;.
	 *
	 * @param loginId the login ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByLoginId_Last(
			String loginId, OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByLoginId_Last(loginId, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where loginId = &#63;.
	 *
	 * @param loginId the login ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByLoginId_Last(
		String loginId, OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByLoginId_Last(loginId, orderByComparator);
	}

	/**
	 * Returns the employees before and after the current employee in the ordered set where loginId = &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param loginId the login ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
	public static Employee[] findByLoginId_PrevAndNext(
			long employeeId, String loginId,
			OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByLoginId_PrevAndNext(
			employeeId, loginId, orderByComparator);
	}

	/**
	 * Removes all the employees where loginId = &#63; from the database.
	 *
	 * @param loginId the login ID
	 */
	public static void removeByLoginId(String loginId) {
		getPersistence().removeByLoginId(loginId);
	}

	/**
	 * Returns the number of employees where loginId = &#63;.
	 *
	 * @param loginId the login ID
	 * @return the number of matching employees
	 */
	public static int countByLoginId(String loginId) {
		return getPersistence().countByLoginId(loginId);
	}

	/**
	 * Returns all the employees where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @return the matching employees
	 */
	public static List<Employee> findByDesignationId(long designationId) {
		return getPersistence().findByDesignationId(designationId);
	}

	/**
	 * Returns a range of all the employees where designationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param designationId the designation ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 */
	public static List<Employee> findByDesignationId(
		long designationId, int start, int end) {

		return getPersistence().findByDesignationId(designationId, start, end);
	}

	/**
	 * Returns an ordered range of all the employees where designationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param designationId the designation ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByDesignationId(
		long designationId, int start, int end,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().findByDesignationId(
			designationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employees where designationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param designationId the designation ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByDesignationId(
		long designationId, int start, int end,
		OrderByComparator<Employee> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByDesignationId(
			designationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee in the ordered set where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByDesignationId_First(
			long designationId, OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByDesignationId_First(
			designationId, orderByComparator);
	}

	/**
	 * Returns the first employee in the ordered set where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByDesignationId_First(
		long designationId, OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByDesignationId_First(
			designationId, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByDesignationId_Last(
			long designationId, OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByDesignationId_Last(
			designationId, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByDesignationId_Last(
		long designationId, OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByDesignationId_Last(
			designationId, orderByComparator);
	}

	/**
	 * Returns the employees before and after the current employee in the ordered set where designationId = &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
	public static Employee[] findByDesignationId_PrevAndNext(
			long employeeId, long designationId,
			OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByDesignationId_PrevAndNext(
			employeeId, designationId, orderByComparator);
	}

	/**
	 * Removes all the employees where designationId = &#63; from the database.
	 *
	 * @param designationId the designation ID
	 */
	public static void removeByDesignationId(long designationId) {
		getPersistence().removeByDesignationId(designationId);
	}

	/**
	 * Returns the number of employees where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @return the number of matching employees
	 */
	public static int countByDesignationId(long designationId) {
		return getPersistence().countByDesignationId(designationId);
	}

	/**
	 * Returns all the employees where tradeId = &#63;.
	 *
	 * @param tradeId the trade ID
	 * @return the matching employees
	 */
	public static List<Employee> findByTradeId(long tradeId) {
		return getPersistence().findByTradeId(tradeId);
	}

	/**
	 * Returns a range of all the employees where tradeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param tradeId the trade ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 */
	public static List<Employee> findByTradeId(
		long tradeId, int start, int end) {

		return getPersistence().findByTradeId(tradeId, start, end);
	}

	/**
	 * Returns an ordered range of all the employees where tradeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param tradeId the trade ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByTradeId(
		long tradeId, int start, int end,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().findByTradeId(
			tradeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employees where tradeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param tradeId the trade ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByTradeId(
		long tradeId, int start, int end,
		OrderByComparator<Employee> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByTradeId(
			tradeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee in the ordered set where tradeId = &#63;.
	 *
	 * @param tradeId the trade ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByTradeId_First(
			long tradeId, OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByTradeId_First(tradeId, orderByComparator);
	}

	/**
	 * Returns the first employee in the ordered set where tradeId = &#63;.
	 *
	 * @param tradeId the trade ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByTradeId_First(
		long tradeId, OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByTradeId_First(
			tradeId, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where tradeId = &#63;.
	 *
	 * @param tradeId the trade ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByTradeId_Last(
			long tradeId, OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByTradeId_Last(tradeId, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where tradeId = &#63;.
	 *
	 * @param tradeId the trade ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByTradeId_Last(
		long tradeId, OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByTradeId_Last(tradeId, orderByComparator);
	}

	/**
	 * Returns the employees before and after the current employee in the ordered set where tradeId = &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param tradeId the trade ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
	public static Employee[] findByTradeId_PrevAndNext(
			long employeeId, long tradeId,
			OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByTradeId_PrevAndNext(
			employeeId, tradeId, orderByComparator);
	}

	/**
	 * Removes all the employees where tradeId = &#63; from the database.
	 *
	 * @param tradeId the trade ID
	 */
	public static void removeByTradeId(long tradeId) {
		getPersistence().removeByTradeId(tradeId);
	}

	/**
	 * Returns the number of employees where tradeId = &#63;.
	 *
	 * @param tradeId the trade ID
	 * @return the number of matching employees
	 */
	public static int countByTradeId(long tradeId) {
		return getPersistence().countByTradeId(tradeId);
	}

	/**
	 * Returns all the employees where gradeId = &#63;.
	 *
	 * @param gradeId the grade ID
	 * @return the matching employees
	 */
	public static List<Employee> findByGradeId(long gradeId) {
		return getPersistence().findByGradeId(gradeId);
	}

	/**
	 * Returns a range of all the employees where gradeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param gradeId the grade ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 */
	public static List<Employee> findByGradeId(
		long gradeId, int start, int end) {

		return getPersistence().findByGradeId(gradeId, start, end);
	}

	/**
	 * Returns an ordered range of all the employees where gradeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param gradeId the grade ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByGradeId(
		long gradeId, int start, int end,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().findByGradeId(
			gradeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employees where gradeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param gradeId the grade ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByGradeId(
		long gradeId, int start, int end,
		OrderByComparator<Employee> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGradeId(
			gradeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee in the ordered set where gradeId = &#63;.
	 *
	 * @param gradeId the grade ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByGradeId_First(
			long gradeId, OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByGradeId_First(gradeId, orderByComparator);
	}

	/**
	 * Returns the first employee in the ordered set where gradeId = &#63;.
	 *
	 * @param gradeId the grade ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByGradeId_First(
		long gradeId, OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByGradeId_First(
			gradeId, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where gradeId = &#63;.
	 *
	 * @param gradeId the grade ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByGradeId_Last(
			long gradeId, OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByGradeId_Last(gradeId, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where gradeId = &#63;.
	 *
	 * @param gradeId the grade ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByGradeId_Last(
		long gradeId, OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByGradeId_Last(gradeId, orderByComparator);
	}

	/**
	 * Returns the employees before and after the current employee in the ordered set where gradeId = &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param gradeId the grade ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
	public static Employee[] findByGradeId_PrevAndNext(
			long employeeId, long gradeId,
			OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByGradeId_PrevAndNext(
			employeeId, gradeId, orderByComparator);
	}

	/**
	 * Removes all the employees where gradeId = &#63; from the database.
	 *
	 * @param gradeId the grade ID
	 */
	public static void removeByGradeId(long gradeId) {
		getPersistence().removeByGradeId(gradeId);
	}

	/**
	 * Returns the number of employees where gradeId = &#63;.
	 *
	 * @param gradeId the grade ID
	 * @return the number of matching employees
	 */
	public static int countByGradeId(long gradeId) {
		return getPersistence().countByGradeId(gradeId);
	}

	/**
	 * Returns all the employees where cadreId = &#63;.
	 *
	 * @param cadreId the cadre ID
	 * @return the matching employees
	 */
	public static List<Employee> findByCadreId(long cadreId) {
		return getPersistence().findByCadreId(cadreId);
	}

	/**
	 * Returns a range of all the employees where cadreId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param cadreId the cadre ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 */
	public static List<Employee> findByCadreId(
		long cadreId, int start, int end) {

		return getPersistence().findByCadreId(cadreId, start, end);
	}

	/**
	 * Returns an ordered range of all the employees where cadreId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param cadreId the cadre ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByCadreId(
		long cadreId, int start, int end,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().findByCadreId(
			cadreId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employees where cadreId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param cadreId the cadre ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByCadreId(
		long cadreId, int start, int end,
		OrderByComparator<Employee> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCadreId(
			cadreId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee in the ordered set where cadreId = &#63;.
	 *
	 * @param cadreId the cadre ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByCadreId_First(
			long cadreId, OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByCadreId_First(cadreId, orderByComparator);
	}

	/**
	 * Returns the first employee in the ordered set where cadreId = &#63;.
	 *
	 * @param cadreId the cadre ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByCadreId_First(
		long cadreId, OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByCadreId_First(
			cadreId, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where cadreId = &#63;.
	 *
	 * @param cadreId the cadre ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByCadreId_Last(
			long cadreId, OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByCadreId_Last(cadreId, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where cadreId = &#63;.
	 *
	 * @param cadreId the cadre ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByCadreId_Last(
		long cadreId, OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByCadreId_Last(cadreId, orderByComparator);
	}

	/**
	 * Returns the employees before and after the current employee in the ordered set where cadreId = &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param cadreId the cadre ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
	public static Employee[] findByCadreId_PrevAndNext(
			long employeeId, long cadreId,
			OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByCadreId_PrevAndNext(
			employeeId, cadreId, orderByComparator);
	}

	/**
	 * Removes all the employees where cadreId = &#63; from the database.
	 *
	 * @param cadreId the cadre ID
	 */
	public static void removeByCadreId(long cadreId) {
		getPersistence().removeByCadreId(cadreId);
	}

	/**
	 * Returns the number of employees where cadreId = &#63;.
	 *
	 * @param cadreId the cadre ID
	 * @return the number of matching employees
	 */
	public static int countByCadreId(long cadreId) {
		return getPersistence().countByCadreId(cadreId);
	}

	/**
	 * Returns all the employees where designationGroupId = &#63;.
	 *
	 * @param designationGroupId the designation group ID
	 * @return the matching employees
	 */
	public static List<Employee> findByDesignationGroupId(
		long designationGroupId) {

		return getPersistence().findByDesignationGroupId(designationGroupId);
	}

	/**
	 * Returns a range of all the employees where designationGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param designationGroupId the designation group ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 */
	public static List<Employee> findByDesignationGroupId(
		long designationGroupId, int start, int end) {

		return getPersistence().findByDesignationGroupId(
			designationGroupId, start, end);
	}

	/**
	 * Returns an ordered range of all the employees where designationGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param designationGroupId the designation group ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByDesignationGroupId(
		long designationGroupId, int start, int end,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().findByDesignationGroupId(
			designationGroupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employees where designationGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param designationGroupId the designation group ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByDesignationGroupId(
		long designationGroupId, int start, int end,
		OrderByComparator<Employee> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByDesignationGroupId(
			designationGroupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee in the ordered set where designationGroupId = &#63;.
	 *
	 * @param designationGroupId the designation group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByDesignationGroupId_First(
			long designationGroupId,
			OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByDesignationGroupId_First(
			designationGroupId, orderByComparator);
	}

	/**
	 * Returns the first employee in the ordered set where designationGroupId = &#63;.
	 *
	 * @param designationGroupId the designation group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByDesignationGroupId_First(
		long designationGroupId,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByDesignationGroupId_First(
			designationGroupId, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where designationGroupId = &#63;.
	 *
	 * @param designationGroupId the designation group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByDesignationGroupId_Last(
			long designationGroupId,
			OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByDesignationGroupId_Last(
			designationGroupId, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where designationGroupId = &#63;.
	 *
	 * @param designationGroupId the designation group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByDesignationGroupId_Last(
		long designationGroupId,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByDesignationGroupId_Last(
			designationGroupId, orderByComparator);
	}

	/**
	 * Returns the employees before and after the current employee in the ordered set where designationGroupId = &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param designationGroupId the designation group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
	public static Employee[] findByDesignationGroupId_PrevAndNext(
			long employeeId, long designationGroupId,
			OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByDesignationGroupId_PrevAndNext(
			employeeId, designationGroupId, orderByComparator);
	}

	/**
	 * Removes all the employees where designationGroupId = &#63; from the database.
	 *
	 * @param designationGroupId the designation group ID
	 */
	public static void removeByDesignationGroupId(long designationGroupId) {
		getPersistence().removeByDesignationGroupId(designationGroupId);
	}

	/**
	 * Returns the number of employees where designationGroupId = &#63;.
	 *
	 * @param designationGroupId the designation group ID
	 * @return the number of matching employees
	 */
	public static int countByDesignationGroupId(long designationGroupId) {
		return getPersistence().countByDesignationGroupId(designationGroupId);
	}

	/**
	 * Returns all the employees where gradeId = &#63; and status = &#63;.
	 *
	 * @param gradeId the grade ID
	 * @param status the status
	 * @return the matching employees
	 */
	public static List<Employee> findByGradeIdAndStatus(
		long gradeId, int status) {

		return getPersistence().findByGradeIdAndStatus(gradeId, status);
	}

	/**
	 * Returns a range of all the employees where gradeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param gradeId the grade ID
	 * @param status the status
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 */
	public static List<Employee> findByGradeIdAndStatus(
		long gradeId, int status, int start, int end) {

		return getPersistence().findByGradeIdAndStatus(
			gradeId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the employees where gradeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param gradeId the grade ID
	 * @param status the status
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByGradeIdAndStatus(
		long gradeId, int status, int start, int end,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().findByGradeIdAndStatus(
			gradeId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employees where gradeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param gradeId the grade ID
	 * @param status the status
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByGradeIdAndStatus(
		long gradeId, int status, int start, int end,
		OrderByComparator<Employee> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGradeIdAndStatus(
			gradeId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee in the ordered set where gradeId = &#63; and status = &#63;.
	 *
	 * @param gradeId the grade ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByGradeIdAndStatus_First(
			long gradeId, int status,
			OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByGradeIdAndStatus_First(
			gradeId, status, orderByComparator);
	}

	/**
	 * Returns the first employee in the ordered set where gradeId = &#63; and status = &#63;.
	 *
	 * @param gradeId the grade ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByGradeIdAndStatus_First(
		long gradeId, int status,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByGradeIdAndStatus_First(
			gradeId, status, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where gradeId = &#63; and status = &#63;.
	 *
	 * @param gradeId the grade ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByGradeIdAndStatus_Last(
			long gradeId, int status,
			OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByGradeIdAndStatus_Last(
			gradeId, status, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where gradeId = &#63; and status = &#63;.
	 *
	 * @param gradeId the grade ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByGradeIdAndStatus_Last(
		long gradeId, int status,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByGradeIdAndStatus_Last(
			gradeId, status, orderByComparator);
	}

	/**
	 * Returns the employees before and after the current employee in the ordered set where gradeId = &#63; and status = &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param gradeId the grade ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
	public static Employee[] findByGradeIdAndStatus_PrevAndNext(
			long employeeId, long gradeId, int status,
			OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByGradeIdAndStatus_PrevAndNext(
			employeeId, gradeId, status, orderByComparator);
	}

	/**
	 * Removes all the employees where gradeId = &#63; and status = &#63; from the database.
	 *
	 * @param gradeId the grade ID
	 * @param status the status
	 */
	public static void removeByGradeIdAndStatus(long gradeId, int status) {
		getPersistence().removeByGradeIdAndStatus(gradeId, status);
	}

	/**
	 * Returns the number of employees where gradeId = &#63; and status = &#63;.
	 *
	 * @param gradeId the grade ID
	 * @param status the status
	 * @return the number of matching employees
	 */
	public static int countByGradeIdAndStatus(long gradeId, int status) {
		return getPersistence().countByGradeIdAndStatus(gradeId, status);
	}

	/**
	 * Returns all the employees where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching employees
	 */
	public static List<Employee> findByGroupIdAndStatusList(
		long groupId, int status) {

		return getPersistence().findByGroupIdAndStatusList(groupId, status);
	}

	/**
	 * Returns a range of all the employees where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 */
	public static List<Employee> findByGroupIdAndStatusList(
		long groupId, int status, int start, int end) {

		return getPersistence().findByGroupIdAndStatusList(
			groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the employees where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByGroupIdAndStatusList(
		long groupId, int status, int start, int end,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().findByGroupIdAndStatusList(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employees where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByGroupIdAndStatusList(
		long groupId, int status, int start, int end,
		OrderByComparator<Employee> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupIdAndStatusList(
			groupId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByGroupIdAndStatusList_First(
			long groupId, int status,
			OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByGroupIdAndStatusList_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the first employee in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByGroupIdAndStatusList_First(
		long groupId, int status,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByGroupIdAndStatusList_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByGroupIdAndStatusList_Last(
			long groupId, int status,
			OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByGroupIdAndStatusList_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByGroupIdAndStatusList_Last(
		long groupId, int status,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByGroupIdAndStatusList_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the employees before and after the current employee in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
	public static Employee[] findByGroupIdAndStatusList_PrevAndNext(
			long employeeId, long groupId, int status,
			OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByGroupIdAndStatusList_PrevAndNext(
			employeeId, groupId, status, orderByComparator);
	}

	/**
	 * Returns all the employees where groupId = any &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param groupIds the group IDs
	 * @param statuses the statuses
	 * @return the matching employees
	 */
	public static List<Employee> findByGroupIdAndStatusList(
		long[] groupIds, int[] statuses) {

		return getPersistence().findByGroupIdAndStatusList(groupIds, statuses);
	}

	/**
	 * Returns a range of all the employees where groupId = any &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param groupIds the group IDs
	 * @param statuses the statuses
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 */
	public static List<Employee> findByGroupIdAndStatusList(
		long[] groupIds, int[] statuses, int start, int end) {

		return getPersistence().findByGroupIdAndStatusList(
			groupIds, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the employees where groupId = any &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param groupIds the group IDs
	 * @param statuses the statuses
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByGroupIdAndStatusList(
		long[] groupIds, int[] statuses, int start, int end,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().findByGroupIdAndStatusList(
			groupIds, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employees where groupId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByGroupIdAndStatusList(
		long[] groupIds, int[] statuses, int start, int end,
		OrderByComparator<Employee> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupIdAndStatusList(
			groupIds, statuses, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employees where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByGroupIdAndStatusList(long groupId, int status) {
		getPersistence().removeByGroupIdAndStatusList(groupId, status);
	}

	/**
	 * Returns the number of employees where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching employees
	 */
	public static int countByGroupIdAndStatusList(long groupId, int status) {
		return getPersistence().countByGroupIdAndStatusList(groupId, status);
	}

	/**
	 * Returns the number of employees where groupId = any &#63; and status = any &#63;.
	 *
	 * @param groupIds the group IDs
	 * @param statuses the statuses
	 * @return the number of matching employees
	 */
	public static int countByGroupIdAndStatusList(
		long[] groupIds, int[] statuses) {

		return getPersistence().countByGroupIdAndStatusList(groupIds, statuses);
	}

	/**
	 * Returns all the employees where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching employees
	 */
	public static List<Employee> findByGroupIds(long groupId) {
		return getPersistence().findByGroupIds(groupId);
	}

	/**
	 * Returns a range of all the employees where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 */
	public static List<Employee> findByGroupIds(
		long groupId, int start, int end) {

		return getPersistence().findByGroupIds(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the employees where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByGroupIds(
		long groupId, int start, int end,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().findByGroupIds(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employees where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByGroupIds(
		long groupId, int start, int end,
		OrderByComparator<Employee> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupIds(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByGroupIds_First(
			long groupId, OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByGroupIds_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the first employee in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByGroupIds_First(
		long groupId, OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByGroupIds_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByGroupIds_Last(
			long groupId, OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByGroupIds_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByGroupIds_Last(
		long groupId, OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByGroupIds_Last(
			groupId, orderByComparator);
	}

	/**
	 * Returns the employees before and after the current employee in the ordered set where groupId = &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
	public static Employee[] findByGroupIds_PrevAndNext(
			long employeeId, long groupId,
			OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByGroupIds_PrevAndNext(
			employeeId, groupId, orderByComparator);
	}

	/**
	 * Returns all the employees where groupId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param groupIds the group IDs
	 * @return the matching employees
	 */
	public static List<Employee> findByGroupIds(long[] groupIds) {
		return getPersistence().findByGroupIds(groupIds);
	}

	/**
	 * Returns a range of all the employees where groupId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param groupIds the group IDs
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 */
	public static List<Employee> findByGroupIds(
		long[] groupIds, int start, int end) {

		return getPersistence().findByGroupIds(groupIds, start, end);
	}

	/**
	 * Returns an ordered range of all the employees where groupId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param groupIds the group IDs
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByGroupIds(
		long[] groupIds, int start, int end,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().findByGroupIds(
			groupIds, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employees where groupId = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByGroupIds(
		long[] groupIds, int start, int end,
		OrderByComparator<Employee> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupIds(
			groupIds, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employees where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupIds(long groupId) {
		getPersistence().removeByGroupIds(groupId);
	}

	/**
	 * Returns the number of employees where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching employees
	 */
	public static int countByGroupIds(long groupId) {
		return getPersistence().countByGroupIds(groupId);
	}

	/**
	 * Returns the number of employees where groupId = any &#63;.
	 *
	 * @param groupIds the group IDs
	 * @return the number of matching employees
	 */
	public static int countByGroupIds(long[] groupIds) {
		return getPersistence().countByGroupIds(groupIds);
	}

	/**
	 * Returns all the employees where gpfNpsNo = &#63;.
	 *
	 * @param gpfNpsNo the gpf nps no
	 * @return the matching employees
	 */
	public static List<Employee> findByGpfNpsNo(String gpfNpsNo) {
		return getPersistence().findByGpfNpsNo(gpfNpsNo);
	}

	/**
	 * Returns a range of all the employees where gpfNpsNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param gpfNpsNo the gpf nps no
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 */
	public static List<Employee> findByGpfNpsNo(
		String gpfNpsNo, int start, int end) {

		return getPersistence().findByGpfNpsNo(gpfNpsNo, start, end);
	}

	/**
	 * Returns an ordered range of all the employees where gpfNpsNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param gpfNpsNo the gpf nps no
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByGpfNpsNo(
		String gpfNpsNo, int start, int end,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().findByGpfNpsNo(
			gpfNpsNo, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employees where gpfNpsNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param gpfNpsNo the gpf nps no
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByGpfNpsNo(
		String gpfNpsNo, int start, int end,
		OrderByComparator<Employee> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGpfNpsNo(
			gpfNpsNo, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee in the ordered set where gpfNpsNo = &#63;.
	 *
	 * @param gpfNpsNo the gpf nps no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByGpfNpsNo_First(
			String gpfNpsNo, OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByGpfNpsNo_First(
			gpfNpsNo, orderByComparator);
	}

	/**
	 * Returns the first employee in the ordered set where gpfNpsNo = &#63;.
	 *
	 * @param gpfNpsNo the gpf nps no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByGpfNpsNo_First(
		String gpfNpsNo, OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByGpfNpsNo_First(
			gpfNpsNo, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where gpfNpsNo = &#63;.
	 *
	 * @param gpfNpsNo the gpf nps no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByGpfNpsNo_Last(
			String gpfNpsNo, OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByGpfNpsNo_Last(
			gpfNpsNo, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where gpfNpsNo = &#63;.
	 *
	 * @param gpfNpsNo the gpf nps no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByGpfNpsNo_Last(
		String gpfNpsNo, OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByGpfNpsNo_Last(
			gpfNpsNo, orderByComparator);
	}

	/**
	 * Returns the employees before and after the current employee in the ordered set where gpfNpsNo = &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param gpfNpsNo the gpf nps no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
	public static Employee[] findByGpfNpsNo_PrevAndNext(
			long employeeId, String gpfNpsNo,
			OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByGpfNpsNo_PrevAndNext(
			employeeId, gpfNpsNo, orderByComparator);
	}

	/**
	 * Removes all the employees where gpfNpsNo = &#63; from the database.
	 *
	 * @param gpfNpsNo the gpf nps no
	 */
	public static void removeByGpfNpsNo(String gpfNpsNo) {
		getPersistence().removeByGpfNpsNo(gpfNpsNo);
	}

	/**
	 * Returns the number of employees where gpfNpsNo = &#63;.
	 *
	 * @param gpfNpsNo the gpf nps no
	 * @return the number of matching employees
	 */
	public static int countByGpfNpsNo(String gpfNpsNo) {
		return getPersistence().countByGpfNpsNo(gpfNpsNo);
	}

	/**
	 * Returns all the employees where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the matching employees
	 */
	public static List<Employee> findByJoiningProcessId(long joiningProcessId) {
		return getPersistence().findByJoiningProcessId(joiningProcessId);
	}

	/**
	 * Returns a range of all the employees where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 */
	public static List<Employee> findByJoiningProcessId(
		long joiningProcessId, int start, int end) {

		return getPersistence().findByJoiningProcessId(
			joiningProcessId, start, end);
	}

	/**
	 * Returns an ordered range of all the employees where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().findByJoiningProcessId(
			joiningProcessId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employees where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		OrderByComparator<Employee> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByJoiningProcessId(
			joiningProcessId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByJoiningProcessId_First(
			long joiningProcessId,
			OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByJoiningProcessId_First(
			joiningProcessId, orderByComparator);
	}

	/**
	 * Returns the first employee in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByJoiningProcessId_First(
		long joiningProcessId, OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByJoiningProcessId_First(
			joiningProcessId, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByJoiningProcessId_Last(
			long joiningProcessId,
			OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByJoiningProcessId_Last(
			joiningProcessId, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByJoiningProcessId_Last(
		long joiningProcessId, OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByJoiningProcessId_Last(
			joiningProcessId, orderByComparator);
	}

	/**
	 * Returns the employees before and after the current employee in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
	public static Employee[] findByJoiningProcessId_PrevAndNext(
			long employeeId, long joiningProcessId,
			OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByJoiningProcessId_PrevAndNext(
			employeeId, joiningProcessId, orderByComparator);
	}

	/**
	 * Removes all the employees where joiningProcessId = &#63; from the database.
	 *
	 * @param joiningProcessId the joining process ID
	 */
	public static void removeByJoiningProcessId(long joiningProcessId) {
		getPersistence().removeByJoiningProcessId(joiningProcessId);
	}

	/**
	 * Returns the number of employees where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the number of matching employees
	 */
	public static int countByJoiningProcessId(long joiningProcessId) {
		return getPersistence().countByJoiningProcessId(joiningProcessId);
	}

	/**
	 * Returns all the employees where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @return the matching employees
	 */
	public static List<Employee> findByGradeModeId(long gradeModeId) {
		return getPersistence().findByGradeModeId(gradeModeId);
	}

	/**
	 * Returns a range of all the employees where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 */
	public static List<Employee> findByGradeModeId(
		long gradeModeId, int start, int end) {

		return getPersistence().findByGradeModeId(gradeModeId, start, end);
	}

	/**
	 * Returns an ordered range of all the employees where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByGradeModeId(
		long gradeModeId, int start, int end,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().findByGradeModeId(
			gradeModeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employees where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByGradeModeId(
		long gradeModeId, int start, int end,
		OrderByComparator<Employee> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGradeModeId(
			gradeModeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByGradeModeId_First(
			long gradeModeId, OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByGradeModeId_First(
			gradeModeId, orderByComparator);
	}

	/**
	 * Returns the first employee in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByGradeModeId_First(
		long gradeModeId, OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByGradeModeId_First(
			gradeModeId, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByGradeModeId_Last(
			long gradeModeId, OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByGradeModeId_Last(
			gradeModeId, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByGradeModeId_Last(
		long gradeModeId, OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByGradeModeId_Last(
			gradeModeId, orderByComparator);
	}

	/**
	 * Returns the employees before and after the current employee in the ordered set where gradeModeId = &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
	public static Employee[] findByGradeModeId_PrevAndNext(
			long employeeId, long gradeModeId,
			OrderByComparator<Employee> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByGradeModeId_PrevAndNext(
			employeeId, gradeModeId, orderByComparator);
	}

	/**
	 * Removes all the employees where gradeModeId = &#63; from the database.
	 *
	 * @param gradeModeId the grade mode ID
	 */
	public static void removeByGradeModeId(long gradeModeId) {
		getPersistence().removeByGradeModeId(gradeModeId);
	}

	/**
	 * Returns the number of employees where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @return the number of matching employees
	 */
	public static int countByGradeModeId(long gradeModeId) {
		return getPersistence().countByGradeModeId(gradeModeId);
	}

	/**
	 * Caches the employee in the entity cache if it is enabled.
	 *
	 * @param employee the employee
	 */
	public static void cacheResult(Employee employee) {
		getPersistence().cacheResult(employee);
	}

	/**
	 * Caches the employees in the entity cache if it is enabled.
	 *
	 * @param employees the employees
	 */
	public static void cacheResult(List<Employee> employees) {
		getPersistence().cacheResult(employees);
	}

	/**
	 * Creates a new employee with the primary key. Does not add the employee to the database.
	 *
	 * @param employeeId the primary key for the new employee
	 * @return the new employee
	 */
	public static Employee create(long employeeId) {
		return getPersistence().create(employeeId);
	}

	/**
	 * Removes the employee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeId the primary key of the employee
	 * @return the employee that was removed
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
	public static Employee remove(long employeeId)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().remove(employeeId);
	}

	public static Employee updateImpl(Employee employee) {
		return getPersistence().updateImpl(employee);
	}

	/**
	 * Returns the employee with the primary key or throws a <code>NoSuchEmployeeException</code> if it could not be found.
	 *
	 * @param employeeId the primary key of the employee
	 * @return the employee
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
	public static Employee findByPrimaryKey(long employeeId)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeException {

		return getPersistence().findByPrimaryKey(employeeId);
	}

	/**
	 * Returns the employee with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeId the primary key of the employee
	 * @return the employee, or <code>null</code> if a employee with the primary key could not be found
	 */
	public static Employee fetchByPrimaryKey(long employeeId) {
		return getPersistence().fetchByPrimaryKey(employeeId);
	}

	/**
	 * Returns all the employees.
	 *
	 * @return the employees
	 */
	public static List<Employee> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of employees
	 */
	public static List<Employee> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employees
	 */
	public static List<Employee> findAll(
		int start, int end, OrderByComparator<Employee> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employees
	 */
	public static List<Employee> findAll(
		int start, int end, OrderByComparator<Employee> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employees from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employees.
	 *
	 * @return the number of employees
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EmployeePersistence, EmployeePersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EmployeePersistence.class);

		ServiceTracker<EmployeePersistence, EmployeePersistence>
			serviceTracker =
				new ServiceTracker<EmployeePersistence, EmployeePersistence>(
					bundle.getBundleContext(), EmployeePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}