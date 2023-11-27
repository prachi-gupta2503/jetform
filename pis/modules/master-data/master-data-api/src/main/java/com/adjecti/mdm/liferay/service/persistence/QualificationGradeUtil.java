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

import com.adjecti.mdm.liferay.model.QualificationGrade;

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
 * The persistence utility for the qualification grade service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.QualificationGradePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QualificationGradePersistence
 * @generated
 */
public class QualificationGradeUtil {

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
	public static void clearCache(QualificationGrade qualificationGrade) {
		getPersistence().clearCache(qualificationGrade);
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
	public static Map<Serializable, QualificationGrade> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<QualificationGrade> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<QualificationGrade> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<QualificationGrade> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<QualificationGrade> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static QualificationGrade update(
		QualificationGrade qualificationGrade) {

		return getPersistence().update(qualificationGrade);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static QualificationGrade update(
		QualificationGrade qualificationGrade, ServiceContext serviceContext) {

		return getPersistence().update(qualificationGrade, serviceContext);
	}

	/**
	 * Returns all the qualification grades where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching qualification grades
	 */
	public static List<QualificationGrade> findByCode(String code) {
		return getPersistence().findByCode(code);
	}

	/**
	 * Returns a range of all the qualification grades where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationGradeModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of qualification grades
	 * @param end the upper bound of the range of qualification grades (not inclusive)
	 * @return the range of matching qualification grades
	 */
	public static List<QualificationGrade> findByCode(
		String code, int start, int end) {

		return getPersistence().findByCode(code, start, end);
	}

	/**
	 * Returns an ordered range of all the qualification grades where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationGradeModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of qualification grades
	 * @param end the upper bound of the range of qualification grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching qualification grades
	 */
	public static List<QualificationGrade> findByCode(
		String code, int start, int end,
		OrderByComparator<QualificationGrade> orderByComparator) {

		return getPersistence().findByCode(code, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the qualification grades where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationGradeModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of qualification grades
	 * @param end the upper bound of the range of qualification grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching qualification grades
	 */
	public static List<QualificationGrade> findByCode(
		String code, int start, int end,
		OrderByComparator<QualificationGrade> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCode(
			code, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first qualification grade in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qualification grade
	 * @throws NoSuchQualificationGradeException if a matching qualification grade could not be found
	 */
	public static QualificationGrade findByCode_First(
			String code,
			OrderByComparator<QualificationGrade> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchQualificationGradeException {

		return getPersistence().findByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the first qualification grade in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qualification grade, or <code>null</code> if a matching qualification grade could not be found
	 */
	public static QualificationGrade fetchByCode_First(
		String code, OrderByComparator<QualificationGrade> orderByComparator) {

		return getPersistence().fetchByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the last qualification grade in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qualification grade
	 * @throws NoSuchQualificationGradeException if a matching qualification grade could not be found
	 */
	public static QualificationGrade findByCode_Last(
			String code,
			OrderByComparator<QualificationGrade> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchQualificationGradeException {

		return getPersistence().findByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the last qualification grade in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qualification grade, or <code>null</code> if a matching qualification grade could not be found
	 */
	public static QualificationGrade fetchByCode_Last(
		String code, OrderByComparator<QualificationGrade> orderByComparator) {

		return getPersistence().fetchByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the qualification grades before and after the current qualification grade in the ordered set where code = &#63;.
	 *
	 * @param qualificationGradeId the primary key of the current qualification grade
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next qualification grade
	 * @throws NoSuchQualificationGradeException if a qualification grade with the primary key could not be found
	 */
	public static QualificationGrade[] findByCode_PrevAndNext(
			long qualificationGradeId, String code,
			OrderByComparator<QualificationGrade> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchQualificationGradeException {

		return getPersistence().findByCode_PrevAndNext(
			qualificationGradeId, code, orderByComparator);
	}

	/**
	 * Removes all the qualification grades where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public static void removeByCode(String code) {
		getPersistence().removeByCode(code);
	}

	/**
	 * Returns the number of qualification grades where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching qualification grades
	 */
	public static int countByCode(String code) {
		return getPersistence().countByCode(code);
	}

	/**
	 * Returns all the qualification grades where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching qualification grades
	 */
	public static List<QualificationGrade> findByName(String name) {
		return getPersistence().findByName(name);
	}

	/**
	 * Returns a range of all the qualification grades where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationGradeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of qualification grades
	 * @param end the upper bound of the range of qualification grades (not inclusive)
	 * @return the range of matching qualification grades
	 */
	public static List<QualificationGrade> findByName(
		String name, int start, int end) {

		return getPersistence().findByName(name, start, end);
	}

	/**
	 * Returns an ordered range of all the qualification grades where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationGradeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of qualification grades
	 * @param end the upper bound of the range of qualification grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching qualification grades
	 */
	public static List<QualificationGrade> findByName(
		String name, int start, int end,
		OrderByComparator<QualificationGrade> orderByComparator) {

		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the qualification grades where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationGradeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of qualification grades
	 * @param end the upper bound of the range of qualification grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching qualification grades
	 */
	public static List<QualificationGrade> findByName(
		String name, int start, int end,
		OrderByComparator<QualificationGrade> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByName(
			name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first qualification grade in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qualification grade
	 * @throws NoSuchQualificationGradeException if a matching qualification grade could not be found
	 */
	public static QualificationGrade findByName_First(
			String name,
			OrderByComparator<QualificationGrade> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchQualificationGradeException {

		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	 * Returns the first qualification grade in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qualification grade, or <code>null</code> if a matching qualification grade could not be found
	 */
	public static QualificationGrade fetchByName_First(
		String name, OrderByComparator<QualificationGrade> orderByComparator) {

		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	 * Returns the last qualification grade in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qualification grade
	 * @throws NoSuchQualificationGradeException if a matching qualification grade could not be found
	 */
	public static QualificationGrade findByName_Last(
			String name,
			OrderByComparator<QualificationGrade> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchQualificationGradeException {

		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the last qualification grade in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qualification grade, or <code>null</code> if a matching qualification grade could not be found
	 */
	public static QualificationGrade fetchByName_Last(
		String name, OrderByComparator<QualificationGrade> orderByComparator) {

		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the qualification grades before and after the current qualification grade in the ordered set where name = &#63;.
	 *
	 * @param qualificationGradeId the primary key of the current qualification grade
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next qualification grade
	 * @throws NoSuchQualificationGradeException if a qualification grade with the primary key could not be found
	 */
	public static QualificationGrade[] findByName_PrevAndNext(
			long qualificationGradeId, String name,
			OrderByComparator<QualificationGrade> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchQualificationGradeException {

		return getPersistence().findByName_PrevAndNext(
			qualificationGradeId, name, orderByComparator);
	}

	/**
	 * Removes all the qualification grades where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeByName(String name) {
		getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of qualification grades where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching qualification grades
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Caches the qualification grade in the entity cache if it is enabled.
	 *
	 * @param qualificationGrade the qualification grade
	 */
	public static void cacheResult(QualificationGrade qualificationGrade) {
		getPersistence().cacheResult(qualificationGrade);
	}

	/**
	 * Caches the qualification grades in the entity cache if it is enabled.
	 *
	 * @param qualificationGrades the qualification grades
	 */
	public static void cacheResult(
		List<QualificationGrade> qualificationGrades) {

		getPersistence().cacheResult(qualificationGrades);
	}

	/**
	 * Creates a new qualification grade with the primary key. Does not add the qualification grade to the database.
	 *
	 * @param qualificationGradeId the primary key for the new qualification grade
	 * @return the new qualification grade
	 */
	public static QualificationGrade create(long qualificationGradeId) {
		return getPersistence().create(qualificationGradeId);
	}

	/**
	 * Removes the qualification grade with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param qualificationGradeId the primary key of the qualification grade
	 * @return the qualification grade that was removed
	 * @throws NoSuchQualificationGradeException if a qualification grade with the primary key could not be found
	 */
	public static QualificationGrade remove(long qualificationGradeId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchQualificationGradeException {

		return getPersistence().remove(qualificationGradeId);
	}

	public static QualificationGrade updateImpl(
		QualificationGrade qualificationGrade) {

		return getPersistence().updateImpl(qualificationGrade);
	}

	/**
	 * Returns the qualification grade with the primary key or throws a <code>NoSuchQualificationGradeException</code> if it could not be found.
	 *
	 * @param qualificationGradeId the primary key of the qualification grade
	 * @return the qualification grade
	 * @throws NoSuchQualificationGradeException if a qualification grade with the primary key could not be found
	 */
	public static QualificationGrade findByPrimaryKey(long qualificationGradeId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchQualificationGradeException {

		return getPersistence().findByPrimaryKey(qualificationGradeId);
	}

	/**
	 * Returns the qualification grade with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param qualificationGradeId the primary key of the qualification grade
	 * @return the qualification grade, or <code>null</code> if a qualification grade with the primary key could not be found
	 */
	public static QualificationGrade fetchByPrimaryKey(
		long qualificationGradeId) {

		return getPersistence().fetchByPrimaryKey(qualificationGradeId);
	}

	/**
	 * Returns all the qualification grades.
	 *
	 * @return the qualification grades
	 */
	public static List<QualificationGrade> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the qualification grades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationGradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of qualification grades
	 * @param end the upper bound of the range of qualification grades (not inclusive)
	 * @return the range of qualification grades
	 */
	public static List<QualificationGrade> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the qualification grades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationGradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of qualification grades
	 * @param end the upper bound of the range of qualification grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of qualification grades
	 */
	public static List<QualificationGrade> findAll(
		int start, int end,
		OrderByComparator<QualificationGrade> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the qualification grades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationGradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of qualification grades
	 * @param end the upper bound of the range of qualification grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of qualification grades
	 */
	public static List<QualificationGrade> findAll(
		int start, int end,
		OrderByComparator<QualificationGrade> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the qualification grades from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of qualification grades.
	 *
	 * @return the number of qualification grades
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static QualificationGradePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<QualificationGradePersistence, QualificationGradePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			QualificationGradePersistence.class);

		ServiceTracker
			<QualificationGradePersistence, QualificationGradePersistence>
				serviceTracker =
					new ServiceTracker
						<QualificationGradePersistence,
						 QualificationGradePersistence>(
							 bundle.getBundleContext(),
							 QualificationGradePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}