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

import com.adjecti.pis.liferay.model.EmployeeReporting;

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
 * The persistence utility for the employee reporting service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.EmployeeReportingPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeReportingPersistence
 * @generated
 */
public class EmployeeReportingUtil {

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
	public static void clearCache(EmployeeReporting employeeReporting) {
		getPersistence().clearCache(employeeReporting);
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
	public static Map<Serializable, EmployeeReporting> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeReporting> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeReporting> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeReporting> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeReporting> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeReporting update(
		EmployeeReporting employeeReporting) {

		return getPersistence().update(employeeReporting);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeReporting update(
		EmployeeReporting employeeReporting, ServiceContext serviceContext) {

		return getPersistence().update(employeeReporting, serviceContext);
	}

	/**
	 * Returns all the employee reportings where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee reportings
	 */
	public static List<EmployeeReporting> findByEmployeeId(long employeeId) {
		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns a range of all the employee reportings where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeReportingModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee reportings
	 * @param end the upper bound of the range of employee reportings (not inclusive)
	 * @return the range of matching employee reportings
	 */
	public static List<EmployeeReporting> findByEmployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee reportings where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeReportingModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee reportings
	 * @param end the upper bound of the range of employee reportings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee reportings
	 */
	public static List<EmployeeReporting> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeReporting> orderByComparator) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee reportings where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeReportingModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee reportings
	 * @param end the upper bound of the range of employee reportings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee reportings
	 */
	public static List<EmployeeReporting> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeReporting> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee reporting in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee reporting
	 * @throws NoSuchEmployeeReportingException if a matching employee reporting could not be found
	 */
	public static EmployeeReporting findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeReporting> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeReportingException {

		return getPersistence().findByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first employee reporting in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee reporting, or <code>null</code> if a matching employee reporting could not be found
	 */
	public static EmployeeReporting fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<EmployeeReporting> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee reporting in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee reporting
	 * @throws NoSuchEmployeeReportingException if a matching employee reporting could not be found
	 */
	public static EmployeeReporting findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeReporting> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeReportingException {

		return getPersistence().findByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee reporting in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee reporting, or <code>null</code> if a matching employee reporting could not be found
	 */
	public static EmployeeReporting fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<EmployeeReporting> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the employee reportings before and after the current employee reporting in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeReportingId the primary key of the current employee reporting
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee reporting
	 * @throws NoSuchEmployeeReportingException if a employee reporting with the primary key could not be found
	 */
	public static EmployeeReporting[] findByEmployeeId_PrevAndNext(
			long employeeReportingId, long employeeId,
			OrderByComparator<EmployeeReporting> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeReportingException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			employeeReportingId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the employee reportings where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of employee reportings where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee reportings
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Returns all the employee reportings where reportingToId = &#63;.
	 *
	 * @param reportingToId the reporting to ID
	 * @return the matching employee reportings
	 */
	public static List<EmployeeReporting> findByReportingToId(
		long reportingToId) {

		return getPersistence().findByReportingToId(reportingToId);
	}

	/**
	 * Returns a range of all the employee reportings where reportingToId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeReportingModelImpl</code>.
	 * </p>
	 *
	 * @param reportingToId the reporting to ID
	 * @param start the lower bound of the range of employee reportings
	 * @param end the upper bound of the range of employee reportings (not inclusive)
	 * @return the range of matching employee reportings
	 */
	public static List<EmployeeReporting> findByReportingToId(
		long reportingToId, int start, int end) {

		return getPersistence().findByReportingToId(reportingToId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee reportings where reportingToId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeReportingModelImpl</code>.
	 * </p>
	 *
	 * @param reportingToId the reporting to ID
	 * @param start the lower bound of the range of employee reportings
	 * @param end the upper bound of the range of employee reportings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee reportings
	 */
	public static List<EmployeeReporting> findByReportingToId(
		long reportingToId, int start, int end,
		OrderByComparator<EmployeeReporting> orderByComparator) {

		return getPersistence().findByReportingToId(
			reportingToId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee reportings where reportingToId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeReportingModelImpl</code>.
	 * </p>
	 *
	 * @param reportingToId the reporting to ID
	 * @param start the lower bound of the range of employee reportings
	 * @param end the upper bound of the range of employee reportings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee reportings
	 */
	public static List<EmployeeReporting> findByReportingToId(
		long reportingToId, int start, int end,
		OrderByComparator<EmployeeReporting> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByReportingToId(
			reportingToId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee reporting in the ordered set where reportingToId = &#63;.
	 *
	 * @param reportingToId the reporting to ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee reporting
	 * @throws NoSuchEmployeeReportingException if a matching employee reporting could not be found
	 */
	public static EmployeeReporting findByReportingToId_First(
			long reportingToId,
			OrderByComparator<EmployeeReporting> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeReportingException {

		return getPersistence().findByReportingToId_First(
			reportingToId, orderByComparator);
	}

	/**
	 * Returns the first employee reporting in the ordered set where reportingToId = &#63;.
	 *
	 * @param reportingToId the reporting to ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee reporting, or <code>null</code> if a matching employee reporting could not be found
	 */
	public static EmployeeReporting fetchByReportingToId_First(
		long reportingToId,
		OrderByComparator<EmployeeReporting> orderByComparator) {

		return getPersistence().fetchByReportingToId_First(
			reportingToId, orderByComparator);
	}

	/**
	 * Returns the last employee reporting in the ordered set where reportingToId = &#63;.
	 *
	 * @param reportingToId the reporting to ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee reporting
	 * @throws NoSuchEmployeeReportingException if a matching employee reporting could not be found
	 */
	public static EmployeeReporting findByReportingToId_Last(
			long reportingToId,
			OrderByComparator<EmployeeReporting> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeReportingException {

		return getPersistence().findByReportingToId_Last(
			reportingToId, orderByComparator);
	}

	/**
	 * Returns the last employee reporting in the ordered set where reportingToId = &#63;.
	 *
	 * @param reportingToId the reporting to ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee reporting, or <code>null</code> if a matching employee reporting could not be found
	 */
	public static EmployeeReporting fetchByReportingToId_Last(
		long reportingToId,
		OrderByComparator<EmployeeReporting> orderByComparator) {

		return getPersistence().fetchByReportingToId_Last(
			reportingToId, orderByComparator);
	}

	/**
	 * Returns the employee reportings before and after the current employee reporting in the ordered set where reportingToId = &#63;.
	 *
	 * @param employeeReportingId the primary key of the current employee reporting
	 * @param reportingToId the reporting to ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee reporting
	 * @throws NoSuchEmployeeReportingException if a employee reporting with the primary key could not be found
	 */
	public static EmployeeReporting[] findByReportingToId_PrevAndNext(
			long employeeReportingId, long reportingToId,
			OrderByComparator<EmployeeReporting> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeReportingException {

		return getPersistence().findByReportingToId_PrevAndNext(
			employeeReportingId, reportingToId, orderByComparator);
	}

	/**
	 * Removes all the employee reportings where reportingToId = &#63; from the database.
	 *
	 * @param reportingToId the reporting to ID
	 */
	public static void removeByReportingToId(long reportingToId) {
		getPersistence().removeByReportingToId(reportingToId);
	}

	/**
	 * Returns the number of employee reportings where reportingToId = &#63;.
	 *
	 * @param reportingToId the reporting to ID
	 * @return the number of matching employee reportings
	 */
	public static int countByReportingToId(long reportingToId) {
		return getPersistence().countByReportingToId(reportingToId);
	}

	/**
	 * Caches the employee reporting in the entity cache if it is enabled.
	 *
	 * @param employeeReporting the employee reporting
	 */
	public static void cacheResult(EmployeeReporting employeeReporting) {
		getPersistence().cacheResult(employeeReporting);
	}

	/**
	 * Caches the employee reportings in the entity cache if it is enabled.
	 *
	 * @param employeeReportings the employee reportings
	 */
	public static void cacheResult(List<EmployeeReporting> employeeReportings) {
		getPersistence().cacheResult(employeeReportings);
	}

	/**
	 * Creates a new employee reporting with the primary key. Does not add the employee reporting to the database.
	 *
	 * @param employeeReportingId the primary key for the new employee reporting
	 * @return the new employee reporting
	 */
	public static EmployeeReporting create(long employeeReportingId) {
		return getPersistence().create(employeeReportingId);
	}

	/**
	 * Removes the employee reporting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeReportingId the primary key of the employee reporting
	 * @return the employee reporting that was removed
	 * @throws NoSuchEmployeeReportingException if a employee reporting with the primary key could not be found
	 */
	public static EmployeeReporting remove(long employeeReportingId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeReportingException {

		return getPersistence().remove(employeeReportingId);
	}

	public static EmployeeReporting updateImpl(
		EmployeeReporting employeeReporting) {

		return getPersistence().updateImpl(employeeReporting);
	}

	/**
	 * Returns the employee reporting with the primary key or throws a <code>NoSuchEmployeeReportingException</code> if it could not be found.
	 *
	 * @param employeeReportingId the primary key of the employee reporting
	 * @return the employee reporting
	 * @throws NoSuchEmployeeReportingException if a employee reporting with the primary key could not be found
	 */
	public static EmployeeReporting findByPrimaryKey(long employeeReportingId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeReportingException {

		return getPersistence().findByPrimaryKey(employeeReportingId);
	}

	/**
	 * Returns the employee reporting with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeReportingId the primary key of the employee reporting
	 * @return the employee reporting, or <code>null</code> if a employee reporting with the primary key could not be found
	 */
	public static EmployeeReporting fetchByPrimaryKey(
		long employeeReportingId) {

		return getPersistence().fetchByPrimaryKey(employeeReportingId);
	}

	/**
	 * Returns all the employee reportings.
	 *
	 * @return the employee reportings
	 */
	public static List<EmployeeReporting> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employee reportings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeReportingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee reportings
	 * @param end the upper bound of the range of employee reportings (not inclusive)
	 * @return the range of employee reportings
	 */
	public static List<EmployeeReporting> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employee reportings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeReportingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee reportings
	 * @param end the upper bound of the range of employee reportings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee reportings
	 */
	public static List<EmployeeReporting> findAll(
		int start, int end,
		OrderByComparator<EmployeeReporting> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee reportings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeReportingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee reportings
	 * @param end the upper bound of the range of employee reportings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee reportings
	 */
	public static List<EmployeeReporting> findAll(
		int start, int end,
		OrderByComparator<EmployeeReporting> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee reportings from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee reportings.
	 *
	 * @return the number of employee reportings
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeReportingPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeeReportingPersistence, EmployeeReportingPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EmployeeReportingPersistence.class);

		ServiceTracker
			<EmployeeReportingPersistence, EmployeeReportingPersistence>
				serviceTracker =
					new ServiceTracker
						<EmployeeReportingPersistence,
						 EmployeeReportingPersistence>(
							 bundle.getBundleContext(),
							 EmployeeReportingPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}