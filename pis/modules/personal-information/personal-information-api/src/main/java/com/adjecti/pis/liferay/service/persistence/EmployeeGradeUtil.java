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

import com.adjecti.pis.liferay.model.EmployeeGrade;

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
 * The persistence utility for the employee grade service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.EmployeeGradePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeGradePersistence
 * @generated
 */
public class EmployeeGradeUtil {

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
	public static void clearCache(EmployeeGrade employeeGrade) {
		getPersistence().clearCache(employeeGrade);
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
	public static Map<Serializable, EmployeeGrade> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeGrade> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeGrade> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeGrade> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeGrade> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeGrade update(EmployeeGrade employeeGrade) {
		return getPersistence().update(employeeGrade);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeGrade update(
		EmployeeGrade employeeGrade, ServiceContext serviceContext) {

		return getPersistence().update(employeeGrade, serviceContext);
	}

	/**
	 * Returns all the employee grades where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @return the matching employee grades
	 */
	public static List<EmployeeGrade> findByGradeModeId(long gradeModeId) {
		return getPersistence().findByGradeModeId(gradeModeId);
	}

	/**
	 * Returns a range of all the employee grades where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeGradeModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee grades
	 * @param end the upper bound of the range of employee grades (not inclusive)
	 * @return the range of matching employee grades
	 */
	public static List<EmployeeGrade> findByGradeModeId(
		long gradeModeId, int start, int end) {

		return getPersistence().findByGradeModeId(gradeModeId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee grades where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeGradeModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee grades
	 * @param end the upper bound of the range of employee grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee grades
	 */
	public static List<EmployeeGrade> findByGradeModeId(
		long gradeModeId, int start, int end,
		OrderByComparator<EmployeeGrade> orderByComparator) {

		return getPersistence().findByGradeModeId(
			gradeModeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee grades where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeGradeModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee grades
	 * @param end the upper bound of the range of employee grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee grades
	 */
	public static List<EmployeeGrade> findByGradeModeId(
		long gradeModeId, int start, int end,
		OrderByComparator<EmployeeGrade> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGradeModeId(
			gradeModeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee grade in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee grade
	 * @throws NoSuchEmployeeGradeException if a matching employee grade could not be found
	 */
	public static EmployeeGrade findByGradeModeId_First(
			long gradeModeId,
			OrderByComparator<EmployeeGrade> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeGradeException {

		return getPersistence().findByGradeModeId_First(
			gradeModeId, orderByComparator);
	}

	/**
	 * Returns the first employee grade in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee grade, or <code>null</code> if a matching employee grade could not be found
	 */
	public static EmployeeGrade fetchByGradeModeId_First(
		long gradeModeId, OrderByComparator<EmployeeGrade> orderByComparator) {

		return getPersistence().fetchByGradeModeId_First(
			gradeModeId, orderByComparator);
	}

	/**
	 * Returns the last employee grade in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee grade
	 * @throws NoSuchEmployeeGradeException if a matching employee grade could not be found
	 */
	public static EmployeeGrade findByGradeModeId_Last(
			long gradeModeId,
			OrderByComparator<EmployeeGrade> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeGradeException {

		return getPersistence().findByGradeModeId_Last(
			gradeModeId, orderByComparator);
	}

	/**
	 * Returns the last employee grade in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee grade, or <code>null</code> if a matching employee grade could not be found
	 */
	public static EmployeeGrade fetchByGradeModeId_Last(
		long gradeModeId, OrderByComparator<EmployeeGrade> orderByComparator) {

		return getPersistence().fetchByGradeModeId_Last(
			gradeModeId, orderByComparator);
	}

	/**
	 * Returns the employee grades before and after the current employee grade in the ordered set where gradeModeId = &#63;.
	 *
	 * @param employeeGradeId the primary key of the current employee grade
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee grade
	 * @throws NoSuchEmployeeGradeException if a employee grade with the primary key could not be found
	 */
	public static EmployeeGrade[] findByGradeModeId_PrevAndNext(
			long employeeGradeId, long gradeModeId,
			OrderByComparator<EmployeeGrade> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeGradeException {

		return getPersistence().findByGradeModeId_PrevAndNext(
			employeeGradeId, gradeModeId, orderByComparator);
	}

	/**
	 * Removes all the employee grades where gradeModeId = &#63; from the database.
	 *
	 * @param gradeModeId the grade mode ID
	 */
	public static void removeByGradeModeId(long gradeModeId) {
		getPersistence().removeByGradeModeId(gradeModeId);
	}

	/**
	 * Returns the number of employee grades where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @return the number of matching employee grades
	 */
	public static int countByGradeModeId(long gradeModeId) {
		return getPersistence().countByGradeModeId(gradeModeId);
	}

	/**
	 * Returns all the employee grades where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee grades
	 */
	public static List<EmployeeGrade> findByEmployeeId(long employeeId) {
		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns a range of all the employee grades where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeGradeModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee grades
	 * @param end the upper bound of the range of employee grades (not inclusive)
	 * @return the range of matching employee grades
	 */
	public static List<EmployeeGrade> findByEmployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee grades where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeGradeModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee grades
	 * @param end the upper bound of the range of employee grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee grades
	 */
	public static List<EmployeeGrade> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeGrade> orderByComparator) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee grades where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeGradeModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee grades
	 * @param end the upper bound of the range of employee grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee grades
	 */
	public static List<EmployeeGrade> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeGrade> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee grade in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee grade
	 * @throws NoSuchEmployeeGradeException if a matching employee grade could not be found
	 */
	public static EmployeeGrade findByEmployeeId_First(
			long employeeId, OrderByComparator<EmployeeGrade> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeGradeException {

		return getPersistence().findByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first employee grade in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee grade, or <code>null</code> if a matching employee grade could not be found
	 */
	public static EmployeeGrade fetchByEmployeeId_First(
		long employeeId, OrderByComparator<EmployeeGrade> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee grade in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee grade
	 * @throws NoSuchEmployeeGradeException if a matching employee grade could not be found
	 */
	public static EmployeeGrade findByEmployeeId_Last(
			long employeeId, OrderByComparator<EmployeeGrade> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeGradeException {

		return getPersistence().findByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee grade in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee grade, or <code>null</code> if a matching employee grade could not be found
	 */
	public static EmployeeGrade fetchByEmployeeId_Last(
		long employeeId, OrderByComparator<EmployeeGrade> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the employee grades before and after the current employee grade in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeGradeId the primary key of the current employee grade
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee grade
	 * @throws NoSuchEmployeeGradeException if a employee grade with the primary key could not be found
	 */
	public static EmployeeGrade[] findByEmployeeId_PrevAndNext(
			long employeeGradeId, long employeeId,
			OrderByComparator<EmployeeGrade> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeGradeException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			employeeGradeId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the employee grades where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of employee grades where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee grades
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Caches the employee grade in the entity cache if it is enabled.
	 *
	 * @param employeeGrade the employee grade
	 */
	public static void cacheResult(EmployeeGrade employeeGrade) {
		getPersistence().cacheResult(employeeGrade);
	}

	/**
	 * Caches the employee grades in the entity cache if it is enabled.
	 *
	 * @param employeeGrades the employee grades
	 */
	public static void cacheResult(List<EmployeeGrade> employeeGrades) {
		getPersistence().cacheResult(employeeGrades);
	}

	/**
	 * Creates a new employee grade with the primary key. Does not add the employee grade to the database.
	 *
	 * @param employeeGradeId the primary key for the new employee grade
	 * @return the new employee grade
	 */
	public static EmployeeGrade create(long employeeGradeId) {
		return getPersistence().create(employeeGradeId);
	}

	/**
	 * Removes the employee grade with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeGradeId the primary key of the employee grade
	 * @return the employee grade that was removed
	 * @throws NoSuchEmployeeGradeException if a employee grade with the primary key could not be found
	 */
	public static EmployeeGrade remove(long employeeGradeId)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeGradeException {

		return getPersistence().remove(employeeGradeId);
	}

	public static EmployeeGrade updateImpl(EmployeeGrade employeeGrade) {
		return getPersistence().updateImpl(employeeGrade);
	}

	/**
	 * Returns the employee grade with the primary key or throws a <code>NoSuchEmployeeGradeException</code> if it could not be found.
	 *
	 * @param employeeGradeId the primary key of the employee grade
	 * @return the employee grade
	 * @throws NoSuchEmployeeGradeException if a employee grade with the primary key could not be found
	 */
	public static EmployeeGrade findByPrimaryKey(long employeeGradeId)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeGradeException {

		return getPersistence().findByPrimaryKey(employeeGradeId);
	}

	/**
	 * Returns the employee grade with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeGradeId the primary key of the employee grade
	 * @return the employee grade, or <code>null</code> if a employee grade with the primary key could not be found
	 */
	public static EmployeeGrade fetchByPrimaryKey(long employeeGradeId) {
		return getPersistence().fetchByPrimaryKey(employeeGradeId);
	}

	/**
	 * Returns all the employee grades.
	 *
	 * @return the employee grades
	 */
	public static List<EmployeeGrade> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employee grades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeGradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee grades
	 * @param end the upper bound of the range of employee grades (not inclusive)
	 * @return the range of employee grades
	 */
	public static List<EmployeeGrade> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employee grades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeGradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee grades
	 * @param end the upper bound of the range of employee grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee grades
	 */
	public static List<EmployeeGrade> findAll(
		int start, int end,
		OrderByComparator<EmployeeGrade> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee grades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeGradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee grades
	 * @param end the upper bound of the range of employee grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee grades
	 */
	public static List<EmployeeGrade> findAll(
		int start, int end, OrderByComparator<EmployeeGrade> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee grades from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee grades.
	 *
	 * @return the number of employee grades
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeGradePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeeGradePersistence, EmployeeGradePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EmployeeGradePersistence.class);

		ServiceTracker<EmployeeGradePersistence, EmployeeGradePersistence>
			serviceTracker =
				new ServiceTracker
					<EmployeeGradePersistence, EmployeeGradePersistence>(
						bundle.getBundleContext(),
						EmployeeGradePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}