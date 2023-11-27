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

import com.adjecti.mdm.liferay.model.QualificationSubject;

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
 * The persistence utility for the qualification subject service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.QualificationSubjectPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QualificationSubjectPersistence
 * @generated
 */
public class QualificationSubjectUtil {

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
	public static void clearCache(QualificationSubject qualificationSubject) {
		getPersistence().clearCache(qualificationSubject);
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
	public static Map<Serializable, QualificationSubject> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<QualificationSubject> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<QualificationSubject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<QualificationSubject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<QualificationSubject> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static QualificationSubject update(
		QualificationSubject qualificationSubject) {

		return getPersistence().update(qualificationSubject);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static QualificationSubject update(
		QualificationSubject qualificationSubject,
		ServiceContext serviceContext) {

		return getPersistence().update(qualificationSubject, serviceContext);
	}

	/**
	 * Returns all the qualification subjects where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching qualification subjects
	 */
	public static List<QualificationSubject> findByCode(String code) {
		return getPersistence().findByCode(code);
	}

	/**
	 * Returns a range of all the qualification subjects where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of qualification subjects
	 * @param end the upper bound of the range of qualification subjects (not inclusive)
	 * @return the range of matching qualification subjects
	 */
	public static List<QualificationSubject> findByCode(
		String code, int start, int end) {

		return getPersistence().findByCode(code, start, end);
	}

	/**
	 * Returns an ordered range of all the qualification subjects where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of qualification subjects
	 * @param end the upper bound of the range of qualification subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching qualification subjects
	 */
	public static List<QualificationSubject> findByCode(
		String code, int start, int end,
		OrderByComparator<QualificationSubject> orderByComparator) {

		return getPersistence().findByCode(code, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the qualification subjects where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of qualification subjects
	 * @param end the upper bound of the range of qualification subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching qualification subjects
	 */
	public static List<QualificationSubject> findByCode(
		String code, int start, int end,
		OrderByComparator<QualificationSubject> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCode(
			code, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first qualification subject in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qualification subject
	 * @throws NoSuchQualificationSubjectException if a matching qualification subject could not be found
	 */
	public static QualificationSubject findByCode_First(
			String code,
			OrderByComparator<QualificationSubject> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchQualificationSubjectException {

		return getPersistence().findByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the first qualification subject in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qualification subject, or <code>null</code> if a matching qualification subject could not be found
	 */
	public static QualificationSubject fetchByCode_First(
		String code,
		OrderByComparator<QualificationSubject> orderByComparator) {

		return getPersistence().fetchByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the last qualification subject in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qualification subject
	 * @throws NoSuchQualificationSubjectException if a matching qualification subject could not be found
	 */
	public static QualificationSubject findByCode_Last(
			String code,
			OrderByComparator<QualificationSubject> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchQualificationSubjectException {

		return getPersistence().findByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the last qualification subject in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qualification subject, or <code>null</code> if a matching qualification subject could not be found
	 */
	public static QualificationSubject fetchByCode_Last(
		String code,
		OrderByComparator<QualificationSubject> orderByComparator) {

		return getPersistence().fetchByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the qualification subjects before and after the current qualification subject in the ordered set where code = &#63;.
	 *
	 * @param qualificationSubjectId the primary key of the current qualification subject
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next qualification subject
	 * @throws NoSuchQualificationSubjectException if a qualification subject with the primary key could not be found
	 */
	public static QualificationSubject[] findByCode_PrevAndNext(
			long qualificationSubjectId, String code,
			OrderByComparator<QualificationSubject> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchQualificationSubjectException {

		return getPersistence().findByCode_PrevAndNext(
			qualificationSubjectId, code, orderByComparator);
	}

	/**
	 * Removes all the qualification subjects where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public static void removeByCode(String code) {
		getPersistence().removeByCode(code);
	}

	/**
	 * Returns the number of qualification subjects where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching qualification subjects
	 */
	public static int countByCode(String code) {
		return getPersistence().countByCode(code);
	}

	/**
	 * Returns all the qualification subjects where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching qualification subjects
	 */
	public static List<QualificationSubject> findByName(String name) {
		return getPersistence().findByName(name);
	}

	/**
	 * Returns a range of all the qualification subjects where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of qualification subjects
	 * @param end the upper bound of the range of qualification subjects (not inclusive)
	 * @return the range of matching qualification subjects
	 */
	public static List<QualificationSubject> findByName(
		String name, int start, int end) {

		return getPersistence().findByName(name, start, end);
	}

	/**
	 * Returns an ordered range of all the qualification subjects where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of qualification subjects
	 * @param end the upper bound of the range of qualification subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching qualification subjects
	 */
	public static List<QualificationSubject> findByName(
		String name, int start, int end,
		OrderByComparator<QualificationSubject> orderByComparator) {

		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the qualification subjects where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of qualification subjects
	 * @param end the upper bound of the range of qualification subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching qualification subjects
	 */
	public static List<QualificationSubject> findByName(
		String name, int start, int end,
		OrderByComparator<QualificationSubject> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByName(
			name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first qualification subject in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qualification subject
	 * @throws NoSuchQualificationSubjectException if a matching qualification subject could not be found
	 */
	public static QualificationSubject findByName_First(
			String name,
			OrderByComparator<QualificationSubject> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchQualificationSubjectException {

		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	 * Returns the first qualification subject in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qualification subject, or <code>null</code> if a matching qualification subject could not be found
	 */
	public static QualificationSubject fetchByName_First(
		String name,
		OrderByComparator<QualificationSubject> orderByComparator) {

		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	 * Returns the last qualification subject in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qualification subject
	 * @throws NoSuchQualificationSubjectException if a matching qualification subject could not be found
	 */
	public static QualificationSubject findByName_Last(
			String name,
			OrderByComparator<QualificationSubject> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchQualificationSubjectException {

		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the last qualification subject in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qualification subject, or <code>null</code> if a matching qualification subject could not be found
	 */
	public static QualificationSubject fetchByName_Last(
		String name,
		OrderByComparator<QualificationSubject> orderByComparator) {

		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the qualification subjects before and after the current qualification subject in the ordered set where name = &#63;.
	 *
	 * @param qualificationSubjectId the primary key of the current qualification subject
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next qualification subject
	 * @throws NoSuchQualificationSubjectException if a qualification subject with the primary key could not be found
	 */
	public static QualificationSubject[] findByName_PrevAndNext(
			long qualificationSubjectId, String name,
			OrderByComparator<QualificationSubject> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchQualificationSubjectException {

		return getPersistence().findByName_PrevAndNext(
			qualificationSubjectId, name, orderByComparator);
	}

	/**
	 * Removes all the qualification subjects where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeByName(String name) {
		getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of qualification subjects where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching qualification subjects
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Caches the qualification subject in the entity cache if it is enabled.
	 *
	 * @param qualificationSubject the qualification subject
	 */
	public static void cacheResult(QualificationSubject qualificationSubject) {
		getPersistence().cacheResult(qualificationSubject);
	}

	/**
	 * Caches the qualification subjects in the entity cache if it is enabled.
	 *
	 * @param qualificationSubjects the qualification subjects
	 */
	public static void cacheResult(
		List<QualificationSubject> qualificationSubjects) {

		getPersistence().cacheResult(qualificationSubjects);
	}

	/**
	 * Creates a new qualification subject with the primary key. Does not add the qualification subject to the database.
	 *
	 * @param qualificationSubjectId the primary key for the new qualification subject
	 * @return the new qualification subject
	 */
	public static QualificationSubject create(long qualificationSubjectId) {
		return getPersistence().create(qualificationSubjectId);
	}

	/**
	 * Removes the qualification subject with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param qualificationSubjectId the primary key of the qualification subject
	 * @return the qualification subject that was removed
	 * @throws NoSuchQualificationSubjectException if a qualification subject with the primary key could not be found
	 */
	public static QualificationSubject remove(long qualificationSubjectId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchQualificationSubjectException {

		return getPersistence().remove(qualificationSubjectId);
	}

	public static QualificationSubject updateImpl(
		QualificationSubject qualificationSubject) {

		return getPersistence().updateImpl(qualificationSubject);
	}

	/**
	 * Returns the qualification subject with the primary key or throws a <code>NoSuchQualificationSubjectException</code> if it could not be found.
	 *
	 * @param qualificationSubjectId the primary key of the qualification subject
	 * @return the qualification subject
	 * @throws NoSuchQualificationSubjectException if a qualification subject with the primary key could not be found
	 */
	public static QualificationSubject findByPrimaryKey(
			long qualificationSubjectId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchQualificationSubjectException {

		return getPersistence().findByPrimaryKey(qualificationSubjectId);
	}

	/**
	 * Returns the qualification subject with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param qualificationSubjectId the primary key of the qualification subject
	 * @return the qualification subject, or <code>null</code> if a qualification subject with the primary key could not be found
	 */
	public static QualificationSubject fetchByPrimaryKey(
		long qualificationSubjectId) {

		return getPersistence().fetchByPrimaryKey(qualificationSubjectId);
	}

	/**
	 * Returns all the qualification subjects.
	 *
	 * @return the qualification subjects
	 */
	public static List<QualificationSubject> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the qualification subjects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of qualification subjects
	 * @param end the upper bound of the range of qualification subjects (not inclusive)
	 * @return the range of qualification subjects
	 */
	public static List<QualificationSubject> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the qualification subjects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of qualification subjects
	 * @param end the upper bound of the range of qualification subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of qualification subjects
	 */
	public static List<QualificationSubject> findAll(
		int start, int end,
		OrderByComparator<QualificationSubject> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the qualification subjects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationSubjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of qualification subjects
	 * @param end the upper bound of the range of qualification subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of qualification subjects
	 */
	public static List<QualificationSubject> findAll(
		int start, int end,
		OrderByComparator<QualificationSubject> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the qualification subjects from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of qualification subjects.
	 *
	 * @return the number of qualification subjects
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static QualificationSubjectPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<QualificationSubjectPersistence, QualificationSubjectPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			QualificationSubjectPersistence.class);

		ServiceTracker
			<QualificationSubjectPersistence, QualificationSubjectPersistence>
				serviceTracker =
					new ServiceTracker
						<QualificationSubjectPersistence,
						 QualificationSubjectPersistence>(
							 bundle.getBundleContext(),
							 QualificationSubjectPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}