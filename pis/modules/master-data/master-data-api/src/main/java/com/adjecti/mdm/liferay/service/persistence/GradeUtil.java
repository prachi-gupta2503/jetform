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

import com.adjecti.mdm.liferay.model.Grade;

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
 * The persistence utility for the grade service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.GradePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GradePersistence
 * @generated
 */
public class GradeUtil {

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
	public static void clearCache(Grade grade) {
		getPersistence().clearCache(grade);
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
	public static Map<Serializable, Grade> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Grade> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Grade> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Grade> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Grade> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Grade update(Grade grade) {
		return getPersistence().update(grade);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Grade update(Grade grade, ServiceContext serviceContext) {
		return getPersistence().update(grade, serviceContext);
	}

	/**
	 * Returns all the grades where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching grades
	 */
	public static List<Grade> findByName(String name) {
		return getPersistence().findByName(name);
	}

	/**
	 * Returns a range of all the grades where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GradeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of grades
	 * @param end the upper bound of the range of grades (not inclusive)
	 * @return the range of matching grades
	 */
	public static List<Grade> findByName(String name, int start, int end) {
		return getPersistence().findByName(name, start, end);
	}

	/**
	 * Returns an ordered range of all the grades where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GradeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of grades
	 * @param end the upper bound of the range of grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching grades
	 */
	public static List<Grade> findByName(
		String name, int start, int end,
		OrderByComparator<Grade> orderByComparator) {

		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the grades where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GradeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of grades
	 * @param end the upper bound of the range of grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching grades
	 */
	public static List<Grade> findByName(
		String name, int start, int end,
		OrderByComparator<Grade> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByName(
			name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first grade in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching grade
	 * @throws NoSuchGradeException if a matching grade could not be found
	 */
	public static Grade findByName_First(
			String name, OrderByComparator<Grade> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchGradeException {

		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	 * Returns the first grade in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching grade, or <code>null</code> if a matching grade could not be found
	 */
	public static Grade fetchByName_First(
		String name, OrderByComparator<Grade> orderByComparator) {

		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	 * Returns the last grade in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching grade
	 * @throws NoSuchGradeException if a matching grade could not be found
	 */
	public static Grade findByName_Last(
			String name, OrderByComparator<Grade> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchGradeException {

		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the last grade in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching grade, or <code>null</code> if a matching grade could not be found
	 */
	public static Grade fetchByName_Last(
		String name, OrderByComparator<Grade> orderByComparator) {

		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the grades before and after the current grade in the ordered set where name = &#63;.
	 *
	 * @param gradeId the primary key of the current grade
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next grade
	 * @throws NoSuchGradeException if a grade with the primary key could not be found
	 */
	public static Grade[] findByName_PrevAndNext(
			long gradeId, String name,
			OrderByComparator<Grade> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchGradeException {

		return getPersistence().findByName_PrevAndNext(
			gradeId, name, orderByComparator);
	}

	/**
	 * Removes all the grades where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeByName(String name) {
		getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of grades where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching grades
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Returns the grade where code = &#63; or throws a <code>NoSuchGradeException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching grade
	 * @throws NoSuchGradeException if a matching grade could not be found
	 */
	public static Grade findByCode(String code)
		throws com.adjecti.mdm.liferay.exception.NoSuchGradeException {

		return getPersistence().findByCode(code);
	}

	/**
	 * Returns the grade where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching grade, or <code>null</code> if a matching grade could not be found
	 */
	public static Grade fetchByCode(String code) {
		return getPersistence().fetchByCode(code);
	}

	/**
	 * Returns the grade where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching grade, or <code>null</code> if a matching grade could not be found
	 */
	public static Grade fetchByCode(String code, boolean useFinderCache) {
		return getPersistence().fetchByCode(code, useFinderCache);
	}

	/**
	 * Removes the grade where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the grade that was removed
	 */
	public static Grade removeByCode(String code)
		throws com.adjecti.mdm.liferay.exception.NoSuchGradeException {

		return getPersistence().removeByCode(code);
	}

	/**
	 * Returns the number of grades where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching grades
	 */
	public static int countByCode(String code) {
		return getPersistence().countByCode(code);
	}

	/**
	 * Caches the grade in the entity cache if it is enabled.
	 *
	 * @param grade the grade
	 */
	public static void cacheResult(Grade grade) {
		getPersistence().cacheResult(grade);
	}

	/**
	 * Caches the grades in the entity cache if it is enabled.
	 *
	 * @param grades the grades
	 */
	public static void cacheResult(List<Grade> grades) {
		getPersistence().cacheResult(grades);
	}

	/**
	 * Creates a new grade with the primary key. Does not add the grade to the database.
	 *
	 * @param gradeId the primary key for the new grade
	 * @return the new grade
	 */
	public static Grade create(long gradeId) {
		return getPersistence().create(gradeId);
	}

	/**
	 * Removes the grade with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param gradeId the primary key of the grade
	 * @return the grade that was removed
	 * @throws NoSuchGradeException if a grade with the primary key could not be found
	 */
	public static Grade remove(long gradeId)
		throws com.adjecti.mdm.liferay.exception.NoSuchGradeException {

		return getPersistence().remove(gradeId);
	}

	public static Grade updateImpl(Grade grade) {
		return getPersistence().updateImpl(grade);
	}

	/**
	 * Returns the grade with the primary key or throws a <code>NoSuchGradeException</code> if it could not be found.
	 *
	 * @param gradeId the primary key of the grade
	 * @return the grade
	 * @throws NoSuchGradeException if a grade with the primary key could not be found
	 */
	public static Grade findByPrimaryKey(long gradeId)
		throws com.adjecti.mdm.liferay.exception.NoSuchGradeException {

		return getPersistence().findByPrimaryKey(gradeId);
	}

	/**
	 * Returns the grade with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param gradeId the primary key of the grade
	 * @return the grade, or <code>null</code> if a grade with the primary key could not be found
	 */
	public static Grade fetchByPrimaryKey(long gradeId) {
		return getPersistence().fetchByPrimaryKey(gradeId);
	}

	/**
	 * Returns all the grades.
	 *
	 * @return the grades
	 */
	public static List<Grade> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the grades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of grades
	 * @param end the upper bound of the range of grades (not inclusive)
	 * @return the range of grades
	 */
	public static List<Grade> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the grades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of grades
	 * @param end the upper bound of the range of grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of grades
	 */
	public static List<Grade> findAll(
		int start, int end, OrderByComparator<Grade> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the grades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of grades
	 * @param end the upper bound of the range of grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of grades
	 */
	public static List<Grade> findAll(
		int start, int end, OrderByComparator<Grade> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the grades from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of grades.
	 *
	 * @return the number of grades
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static GradePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<GradePersistence, GradePersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(GradePersistence.class);

		ServiceTracker<GradePersistence, GradePersistence> serviceTracker =
			new ServiceTracker<GradePersistence, GradePersistence>(
				bundle.getBundleContext(), GradePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}