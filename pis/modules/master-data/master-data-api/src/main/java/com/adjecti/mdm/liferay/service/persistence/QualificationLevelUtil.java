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

import com.adjecti.mdm.liferay.model.QualificationLevel;

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
 * The persistence utility for the qualification level service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.QualificationLevelPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QualificationLevelPersistence
 * @generated
 */
public class QualificationLevelUtil {

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
	public static void clearCache(QualificationLevel qualificationLevel) {
		getPersistence().clearCache(qualificationLevel);
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
	public static Map<Serializable, QualificationLevel> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<QualificationLevel> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<QualificationLevel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<QualificationLevel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<QualificationLevel> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static QualificationLevel update(
		QualificationLevel qualificationLevel) {

		return getPersistence().update(qualificationLevel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static QualificationLevel update(
		QualificationLevel qualificationLevel, ServiceContext serviceContext) {

		return getPersistence().update(qualificationLevel, serviceContext);
	}

	/**
	 * Returns all the qualification levels where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching qualification levels
	 */
	public static List<QualificationLevel> findByCode(String code) {
		return getPersistence().findByCode(code);
	}

	/**
	 * Returns a range of all the qualification levels where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationLevelModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of qualification levels
	 * @param end the upper bound of the range of qualification levels (not inclusive)
	 * @return the range of matching qualification levels
	 */
	public static List<QualificationLevel> findByCode(
		String code, int start, int end) {

		return getPersistence().findByCode(code, start, end);
	}

	/**
	 * Returns an ordered range of all the qualification levels where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationLevelModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of qualification levels
	 * @param end the upper bound of the range of qualification levels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching qualification levels
	 */
	public static List<QualificationLevel> findByCode(
		String code, int start, int end,
		OrderByComparator<QualificationLevel> orderByComparator) {

		return getPersistence().findByCode(code, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the qualification levels where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationLevelModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of qualification levels
	 * @param end the upper bound of the range of qualification levels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching qualification levels
	 */
	public static List<QualificationLevel> findByCode(
		String code, int start, int end,
		OrderByComparator<QualificationLevel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCode(
			code, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first qualification level in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qualification level
	 * @throws NoSuchQualificationLevelException if a matching qualification level could not be found
	 */
	public static QualificationLevel findByCode_First(
			String code,
			OrderByComparator<QualificationLevel> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchQualificationLevelException {

		return getPersistence().findByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the first qualification level in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qualification level, or <code>null</code> if a matching qualification level could not be found
	 */
	public static QualificationLevel fetchByCode_First(
		String code, OrderByComparator<QualificationLevel> orderByComparator) {

		return getPersistence().fetchByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the last qualification level in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qualification level
	 * @throws NoSuchQualificationLevelException if a matching qualification level could not be found
	 */
	public static QualificationLevel findByCode_Last(
			String code,
			OrderByComparator<QualificationLevel> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchQualificationLevelException {

		return getPersistence().findByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the last qualification level in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qualification level, or <code>null</code> if a matching qualification level could not be found
	 */
	public static QualificationLevel fetchByCode_Last(
		String code, OrderByComparator<QualificationLevel> orderByComparator) {

		return getPersistence().fetchByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the qualification levels before and after the current qualification level in the ordered set where code = &#63;.
	 *
	 * @param qualificationLevelId the primary key of the current qualification level
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next qualification level
	 * @throws NoSuchQualificationLevelException if a qualification level with the primary key could not be found
	 */
	public static QualificationLevel[] findByCode_PrevAndNext(
			long qualificationLevelId, String code,
			OrderByComparator<QualificationLevel> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchQualificationLevelException {

		return getPersistence().findByCode_PrevAndNext(
			qualificationLevelId, code, orderByComparator);
	}

	/**
	 * Removes all the qualification levels where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public static void removeByCode(String code) {
		getPersistence().removeByCode(code);
	}

	/**
	 * Returns the number of qualification levels where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching qualification levels
	 */
	public static int countByCode(String code) {
		return getPersistence().countByCode(code);
	}

	/**
	 * Returns all the qualification levels where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching qualification levels
	 */
	public static List<QualificationLevel> findByName(String name) {
		return getPersistence().findByName(name);
	}

	/**
	 * Returns a range of all the qualification levels where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationLevelModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of qualification levels
	 * @param end the upper bound of the range of qualification levels (not inclusive)
	 * @return the range of matching qualification levels
	 */
	public static List<QualificationLevel> findByName(
		String name, int start, int end) {

		return getPersistence().findByName(name, start, end);
	}

	/**
	 * Returns an ordered range of all the qualification levels where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationLevelModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of qualification levels
	 * @param end the upper bound of the range of qualification levels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching qualification levels
	 */
	public static List<QualificationLevel> findByName(
		String name, int start, int end,
		OrderByComparator<QualificationLevel> orderByComparator) {

		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the qualification levels where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationLevelModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of qualification levels
	 * @param end the upper bound of the range of qualification levels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching qualification levels
	 */
	public static List<QualificationLevel> findByName(
		String name, int start, int end,
		OrderByComparator<QualificationLevel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByName(
			name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first qualification level in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qualification level
	 * @throws NoSuchQualificationLevelException if a matching qualification level could not be found
	 */
	public static QualificationLevel findByName_First(
			String name,
			OrderByComparator<QualificationLevel> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchQualificationLevelException {

		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	 * Returns the first qualification level in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qualification level, or <code>null</code> if a matching qualification level could not be found
	 */
	public static QualificationLevel fetchByName_First(
		String name, OrderByComparator<QualificationLevel> orderByComparator) {

		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	 * Returns the last qualification level in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qualification level
	 * @throws NoSuchQualificationLevelException if a matching qualification level could not be found
	 */
	public static QualificationLevel findByName_Last(
			String name,
			OrderByComparator<QualificationLevel> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchQualificationLevelException {

		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the last qualification level in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qualification level, or <code>null</code> if a matching qualification level could not be found
	 */
	public static QualificationLevel fetchByName_Last(
		String name, OrderByComparator<QualificationLevel> orderByComparator) {

		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the qualification levels before and after the current qualification level in the ordered set where name = &#63;.
	 *
	 * @param qualificationLevelId the primary key of the current qualification level
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next qualification level
	 * @throws NoSuchQualificationLevelException if a qualification level with the primary key could not be found
	 */
	public static QualificationLevel[] findByName_PrevAndNext(
			long qualificationLevelId, String name,
			OrderByComparator<QualificationLevel> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchQualificationLevelException {

		return getPersistence().findByName_PrevAndNext(
			qualificationLevelId, name, orderByComparator);
	}

	/**
	 * Removes all the qualification levels where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeByName(String name) {
		getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of qualification levels where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching qualification levels
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Caches the qualification level in the entity cache if it is enabled.
	 *
	 * @param qualificationLevel the qualification level
	 */
	public static void cacheResult(QualificationLevel qualificationLevel) {
		getPersistence().cacheResult(qualificationLevel);
	}

	/**
	 * Caches the qualification levels in the entity cache if it is enabled.
	 *
	 * @param qualificationLevels the qualification levels
	 */
	public static void cacheResult(
		List<QualificationLevel> qualificationLevels) {

		getPersistence().cacheResult(qualificationLevels);
	}

	/**
	 * Creates a new qualification level with the primary key. Does not add the qualification level to the database.
	 *
	 * @param qualificationLevelId the primary key for the new qualification level
	 * @return the new qualification level
	 */
	public static QualificationLevel create(long qualificationLevelId) {
		return getPersistence().create(qualificationLevelId);
	}

	/**
	 * Removes the qualification level with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param qualificationLevelId the primary key of the qualification level
	 * @return the qualification level that was removed
	 * @throws NoSuchQualificationLevelException if a qualification level with the primary key could not be found
	 */
	public static QualificationLevel remove(long qualificationLevelId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchQualificationLevelException {

		return getPersistence().remove(qualificationLevelId);
	}

	public static QualificationLevel updateImpl(
		QualificationLevel qualificationLevel) {

		return getPersistence().updateImpl(qualificationLevel);
	}

	/**
	 * Returns the qualification level with the primary key or throws a <code>NoSuchQualificationLevelException</code> if it could not be found.
	 *
	 * @param qualificationLevelId the primary key of the qualification level
	 * @return the qualification level
	 * @throws NoSuchQualificationLevelException if a qualification level with the primary key could not be found
	 */
	public static QualificationLevel findByPrimaryKey(long qualificationLevelId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchQualificationLevelException {

		return getPersistence().findByPrimaryKey(qualificationLevelId);
	}

	/**
	 * Returns the qualification level with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param qualificationLevelId the primary key of the qualification level
	 * @return the qualification level, or <code>null</code> if a qualification level with the primary key could not be found
	 */
	public static QualificationLevel fetchByPrimaryKey(
		long qualificationLevelId) {

		return getPersistence().fetchByPrimaryKey(qualificationLevelId);
	}

	/**
	 * Returns all the qualification levels.
	 *
	 * @return the qualification levels
	 */
	public static List<QualificationLevel> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the qualification levels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationLevelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of qualification levels
	 * @param end the upper bound of the range of qualification levels (not inclusive)
	 * @return the range of qualification levels
	 */
	public static List<QualificationLevel> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the qualification levels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationLevelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of qualification levels
	 * @param end the upper bound of the range of qualification levels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of qualification levels
	 */
	public static List<QualificationLevel> findAll(
		int start, int end,
		OrderByComparator<QualificationLevel> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the qualification levels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationLevelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of qualification levels
	 * @param end the upper bound of the range of qualification levels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of qualification levels
	 */
	public static List<QualificationLevel> findAll(
		int start, int end,
		OrderByComparator<QualificationLevel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the qualification levels from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of qualification levels.
	 *
	 * @return the number of qualification levels
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static QualificationLevelPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<QualificationLevelPersistence, QualificationLevelPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			QualificationLevelPersistence.class);

		ServiceTracker
			<QualificationLevelPersistence, QualificationLevelPersistence>
				serviceTracker =
					new ServiceTracker
						<QualificationLevelPersistence,
						 QualificationLevelPersistence>(
							 bundle.getBundleContext(),
							 QualificationLevelPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}