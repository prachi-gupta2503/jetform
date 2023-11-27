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

import com.adjecti.mdm.liferay.model.DesignationMode;

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
 * The persistence utility for the designation mode service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.DesignationModePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DesignationModePersistence
 * @generated
 */
public class DesignationModeUtil {

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
	public static void clearCache(DesignationMode designationMode) {
		getPersistence().clearCache(designationMode);
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
	public static Map<Serializable, DesignationMode> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DesignationMode> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DesignationMode> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DesignationMode> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DesignationMode> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DesignationMode update(DesignationMode designationMode) {
		return getPersistence().update(designationMode);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DesignationMode update(
		DesignationMode designationMode, ServiceContext serviceContext) {

		return getPersistence().update(designationMode, serviceContext);
	}

	/**
	 * Returns all the designation modes where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching designation modes
	 */
	public static List<DesignationMode> findByCode(String code) {
		return getPersistence().findByCode(code);
	}

	/**
	 * Returns a range of all the designation modes where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModeModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of designation modes
	 * @param end the upper bound of the range of designation modes (not inclusive)
	 * @return the range of matching designation modes
	 */
	public static List<DesignationMode> findByCode(
		String code, int start, int end) {

		return getPersistence().findByCode(code, start, end);
	}

	/**
	 * Returns an ordered range of all the designation modes where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModeModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of designation modes
	 * @param end the upper bound of the range of designation modes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching designation modes
	 */
	public static List<DesignationMode> findByCode(
		String code, int start, int end,
		OrderByComparator<DesignationMode> orderByComparator) {

		return getPersistence().findByCode(code, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the designation modes where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModeModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of designation modes
	 * @param end the upper bound of the range of designation modes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching designation modes
	 */
	public static List<DesignationMode> findByCode(
		String code, int start, int end,
		OrderByComparator<DesignationMode> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCode(
			code, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first designation mode in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation mode
	 * @throws NoSuchDesignationModeException if a matching designation mode could not be found
	 */
	public static DesignationMode findByCode_First(
			String code, OrderByComparator<DesignationMode> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchDesignationModeException {

		return getPersistence().findByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the first designation mode in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation mode, or <code>null</code> if a matching designation mode could not be found
	 */
	public static DesignationMode fetchByCode_First(
		String code, OrderByComparator<DesignationMode> orderByComparator) {

		return getPersistence().fetchByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the last designation mode in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation mode
	 * @throws NoSuchDesignationModeException if a matching designation mode could not be found
	 */
	public static DesignationMode findByCode_Last(
			String code, OrderByComparator<DesignationMode> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchDesignationModeException {

		return getPersistence().findByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the last designation mode in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation mode, or <code>null</code> if a matching designation mode could not be found
	 */
	public static DesignationMode fetchByCode_Last(
		String code, OrderByComparator<DesignationMode> orderByComparator) {

		return getPersistence().fetchByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the designation modes before and after the current designation mode in the ordered set where code = &#63;.
	 *
	 * @param designationModeId the primary key of the current designation mode
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next designation mode
	 * @throws NoSuchDesignationModeException if a designation mode with the primary key could not be found
	 */
	public static DesignationMode[] findByCode_PrevAndNext(
			long designationModeId, String code,
			OrderByComparator<DesignationMode> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchDesignationModeException {

		return getPersistence().findByCode_PrevAndNext(
			designationModeId, code, orderByComparator);
	}

	/**
	 * Removes all the designation modes where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public static void removeByCode(String code) {
		getPersistence().removeByCode(code);
	}

	/**
	 * Returns the number of designation modes where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching designation modes
	 */
	public static int countByCode(String code) {
		return getPersistence().countByCode(code);
	}

	/**
	 * Returns all the designation modes where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching designation modes
	 */
	public static List<DesignationMode> findByName(String name) {
		return getPersistence().findByName(name);
	}

	/**
	 * Returns a range of all the designation modes where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of designation modes
	 * @param end the upper bound of the range of designation modes (not inclusive)
	 * @return the range of matching designation modes
	 */
	public static List<DesignationMode> findByName(
		String name, int start, int end) {

		return getPersistence().findByName(name, start, end);
	}

	/**
	 * Returns an ordered range of all the designation modes where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of designation modes
	 * @param end the upper bound of the range of designation modes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching designation modes
	 */
	public static List<DesignationMode> findByName(
		String name, int start, int end,
		OrderByComparator<DesignationMode> orderByComparator) {

		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the designation modes where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of designation modes
	 * @param end the upper bound of the range of designation modes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching designation modes
	 */
	public static List<DesignationMode> findByName(
		String name, int start, int end,
		OrderByComparator<DesignationMode> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByName(
			name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first designation mode in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation mode
	 * @throws NoSuchDesignationModeException if a matching designation mode could not be found
	 */
	public static DesignationMode findByName_First(
			String name, OrderByComparator<DesignationMode> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchDesignationModeException {

		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	 * Returns the first designation mode in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation mode, or <code>null</code> if a matching designation mode could not be found
	 */
	public static DesignationMode fetchByName_First(
		String name, OrderByComparator<DesignationMode> orderByComparator) {

		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	 * Returns the last designation mode in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation mode
	 * @throws NoSuchDesignationModeException if a matching designation mode could not be found
	 */
	public static DesignationMode findByName_Last(
			String name, OrderByComparator<DesignationMode> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchDesignationModeException {

		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the last designation mode in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation mode, or <code>null</code> if a matching designation mode could not be found
	 */
	public static DesignationMode fetchByName_Last(
		String name, OrderByComparator<DesignationMode> orderByComparator) {

		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the designation modes before and after the current designation mode in the ordered set where name = &#63;.
	 *
	 * @param designationModeId the primary key of the current designation mode
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next designation mode
	 * @throws NoSuchDesignationModeException if a designation mode with the primary key could not be found
	 */
	public static DesignationMode[] findByName_PrevAndNext(
			long designationModeId, String name,
			OrderByComparator<DesignationMode> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchDesignationModeException {

		return getPersistence().findByName_PrevAndNext(
			designationModeId, name, orderByComparator);
	}

	/**
	 * Removes all the designation modes where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeByName(String name) {
		getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of designation modes where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching designation modes
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Caches the designation mode in the entity cache if it is enabled.
	 *
	 * @param designationMode the designation mode
	 */
	public static void cacheResult(DesignationMode designationMode) {
		getPersistence().cacheResult(designationMode);
	}

	/**
	 * Caches the designation modes in the entity cache if it is enabled.
	 *
	 * @param designationModes the designation modes
	 */
	public static void cacheResult(List<DesignationMode> designationModes) {
		getPersistence().cacheResult(designationModes);
	}

	/**
	 * Creates a new designation mode with the primary key. Does not add the designation mode to the database.
	 *
	 * @param designationModeId the primary key for the new designation mode
	 * @return the new designation mode
	 */
	public static DesignationMode create(long designationModeId) {
		return getPersistence().create(designationModeId);
	}

	/**
	 * Removes the designation mode with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param designationModeId the primary key of the designation mode
	 * @return the designation mode that was removed
	 * @throws NoSuchDesignationModeException if a designation mode with the primary key could not be found
	 */
	public static DesignationMode remove(long designationModeId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchDesignationModeException {

		return getPersistence().remove(designationModeId);
	}

	public static DesignationMode updateImpl(DesignationMode designationMode) {
		return getPersistence().updateImpl(designationMode);
	}

	/**
	 * Returns the designation mode with the primary key or throws a <code>NoSuchDesignationModeException</code> if it could not be found.
	 *
	 * @param designationModeId the primary key of the designation mode
	 * @return the designation mode
	 * @throws NoSuchDesignationModeException if a designation mode with the primary key could not be found
	 */
	public static DesignationMode findByPrimaryKey(long designationModeId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchDesignationModeException {

		return getPersistence().findByPrimaryKey(designationModeId);
	}

	/**
	 * Returns the designation mode with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param designationModeId the primary key of the designation mode
	 * @return the designation mode, or <code>null</code> if a designation mode with the primary key could not be found
	 */
	public static DesignationMode fetchByPrimaryKey(long designationModeId) {
		return getPersistence().fetchByPrimaryKey(designationModeId);
	}

	/**
	 * Returns all the designation modes.
	 *
	 * @return the designation modes
	 */
	public static List<DesignationMode> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the designation modes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation modes
	 * @param end the upper bound of the range of designation modes (not inclusive)
	 * @return the range of designation modes
	 */
	public static List<DesignationMode> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the designation modes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation modes
	 * @param end the upper bound of the range of designation modes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of designation modes
	 */
	public static List<DesignationMode> findAll(
		int start, int end,
		OrderByComparator<DesignationMode> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the designation modes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation modes
	 * @param end the upper bound of the range of designation modes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of designation modes
	 */
	public static List<DesignationMode> findAll(
		int start, int end,
		OrderByComparator<DesignationMode> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the designation modes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of designation modes.
	 *
	 * @return the number of designation modes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DesignationModePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<DesignationModePersistence, DesignationModePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			DesignationModePersistence.class);

		ServiceTracker<DesignationModePersistence, DesignationModePersistence>
			serviceTracker =
				new ServiceTracker
					<DesignationModePersistence, DesignationModePersistence>(
						bundle.getBundleContext(),
						DesignationModePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}