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

import com.adjecti.mdm.liferay.model.District;

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
 * The persistence utility for the district service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.DistrictPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DistrictPersistence
 * @generated
 */
public class DistrictUtil {

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
	public static void clearCache(District district) {
		getPersistence().clearCache(district);
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
	public static Map<Serializable, District> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<District> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<District> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<District> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<District> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static District update(District district) {
		return getPersistence().update(district);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static District update(
		District district, ServiceContext serviceContext) {

		return getPersistence().update(district, serviceContext);
	}

	/**
	 * Returns all the districts where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching districts
	 */
	public static List<District> findByCode(String code) {
		return getPersistence().findByCode(code);
	}

	/**
	 * Returns a range of all the districts where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @return the range of matching districts
	 */
	public static List<District> findByCode(String code, int start, int end) {
		return getPersistence().findByCode(code, start, end);
	}

	/**
	 * Returns an ordered range of all the districts where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching districts
	 */
	public static List<District> findByCode(
		String code, int start, int end,
		OrderByComparator<District> orderByComparator) {

		return getPersistence().findByCode(code, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the districts where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching districts
	 */
	public static List<District> findByCode(
		String code, int start, int end,
		OrderByComparator<District> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCode(
			code, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first district in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	public static District findByCode_First(
			String code, OrderByComparator<District> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchDistrictException {

		return getPersistence().findByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the first district in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching district, or <code>null</code> if a matching district could not be found
	 */
	public static District fetchByCode_First(
		String code, OrderByComparator<District> orderByComparator) {

		return getPersistence().fetchByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the last district in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	public static District findByCode_Last(
			String code, OrderByComparator<District> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchDistrictException {

		return getPersistence().findByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the last district in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching district, or <code>null</code> if a matching district could not be found
	 */
	public static District fetchByCode_Last(
		String code, OrderByComparator<District> orderByComparator) {

		return getPersistence().fetchByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the districts before and after the current district in the ordered set where code = &#63;.
	 *
	 * @param districtId the primary key of the current district
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next district
	 * @throws NoSuchDistrictException if a district with the primary key could not be found
	 */
	public static District[] findByCode_PrevAndNext(
			long districtId, String code,
			OrderByComparator<District> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchDistrictException {

		return getPersistence().findByCode_PrevAndNext(
			districtId, code, orderByComparator);
	}

	/**
	 * Removes all the districts where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public static void removeByCode(String code) {
		getPersistence().removeByCode(code);
	}

	/**
	 * Returns the number of districts where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching districts
	 */
	public static int countByCode(String code) {
		return getPersistence().countByCode(code);
	}

	/**
	 * Returns all the districts where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching districts
	 */
	public static List<District> findByName(String name) {
		return getPersistence().findByName(name);
	}

	/**
	 * Returns a range of all the districts where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @return the range of matching districts
	 */
	public static List<District> findByName(String name, int start, int end) {
		return getPersistence().findByName(name, start, end);
	}

	/**
	 * Returns an ordered range of all the districts where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching districts
	 */
	public static List<District> findByName(
		String name, int start, int end,
		OrderByComparator<District> orderByComparator) {

		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the districts where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching districts
	 */
	public static List<District> findByName(
		String name, int start, int end,
		OrderByComparator<District> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByName(
			name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first district in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	public static District findByName_First(
			String name, OrderByComparator<District> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchDistrictException {

		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	 * Returns the first district in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching district, or <code>null</code> if a matching district could not be found
	 */
	public static District fetchByName_First(
		String name, OrderByComparator<District> orderByComparator) {

		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	 * Returns the last district in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	public static District findByName_Last(
			String name, OrderByComparator<District> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchDistrictException {

		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the last district in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching district, or <code>null</code> if a matching district could not be found
	 */
	public static District fetchByName_Last(
		String name, OrderByComparator<District> orderByComparator) {

		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the districts before and after the current district in the ordered set where name = &#63;.
	 *
	 * @param districtId the primary key of the current district
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next district
	 * @throws NoSuchDistrictException if a district with the primary key could not be found
	 */
	public static District[] findByName_PrevAndNext(
			long districtId, String name,
			OrderByComparator<District> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchDistrictException {

		return getPersistence().findByName_PrevAndNext(
			districtId, name, orderByComparator);
	}

	/**
	 * Removes all the districts where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeByName(String name) {
		getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of districts where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching districts
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Returns all the districts where stateId = &#63; and deleted = &#63;.
	 *
	 * @param stateId the state ID
	 * @param deleted the deleted
	 * @return the matching districts
	 */
	public static List<District> findByDistrictList(
		long stateId, boolean deleted) {

		return getPersistence().findByDistrictList(stateId, deleted);
	}

	/**
	 * Returns a range of all the districts where stateId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param stateId the state ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @return the range of matching districts
	 */
	public static List<District> findByDistrictList(
		long stateId, boolean deleted, int start, int end) {

		return getPersistence().findByDistrictList(
			stateId, deleted, start, end);
	}

	/**
	 * Returns an ordered range of all the districts where stateId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param stateId the state ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching districts
	 */
	public static List<District> findByDistrictList(
		long stateId, boolean deleted, int start, int end,
		OrderByComparator<District> orderByComparator) {

		return getPersistence().findByDistrictList(
			stateId, deleted, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the districts where stateId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param stateId the state ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching districts
	 */
	public static List<District> findByDistrictList(
		long stateId, boolean deleted, int start, int end,
		OrderByComparator<District> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByDistrictList(
			stateId, deleted, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first district in the ordered set where stateId = &#63; and deleted = &#63;.
	 *
	 * @param stateId the state ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	public static District findByDistrictList_First(
			long stateId, boolean deleted,
			OrderByComparator<District> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchDistrictException {

		return getPersistence().findByDistrictList_First(
			stateId, deleted, orderByComparator);
	}

	/**
	 * Returns the first district in the ordered set where stateId = &#63; and deleted = &#63;.
	 *
	 * @param stateId the state ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching district, or <code>null</code> if a matching district could not be found
	 */
	public static District fetchByDistrictList_First(
		long stateId, boolean deleted,
		OrderByComparator<District> orderByComparator) {

		return getPersistence().fetchByDistrictList_First(
			stateId, deleted, orderByComparator);
	}

	/**
	 * Returns the last district in the ordered set where stateId = &#63; and deleted = &#63;.
	 *
	 * @param stateId the state ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	public static District findByDistrictList_Last(
			long stateId, boolean deleted,
			OrderByComparator<District> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchDistrictException {

		return getPersistence().findByDistrictList_Last(
			stateId, deleted, orderByComparator);
	}

	/**
	 * Returns the last district in the ordered set where stateId = &#63; and deleted = &#63;.
	 *
	 * @param stateId the state ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching district, or <code>null</code> if a matching district could not be found
	 */
	public static District fetchByDistrictList_Last(
		long stateId, boolean deleted,
		OrderByComparator<District> orderByComparator) {

		return getPersistence().fetchByDistrictList_Last(
			stateId, deleted, orderByComparator);
	}

	/**
	 * Returns the districts before and after the current district in the ordered set where stateId = &#63; and deleted = &#63;.
	 *
	 * @param districtId the primary key of the current district
	 * @param stateId the state ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next district
	 * @throws NoSuchDistrictException if a district with the primary key could not be found
	 */
	public static District[] findByDistrictList_PrevAndNext(
			long districtId, long stateId, boolean deleted,
			OrderByComparator<District> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchDistrictException {

		return getPersistence().findByDistrictList_PrevAndNext(
			districtId, stateId, deleted, orderByComparator);
	}

	/**
	 * Removes all the districts where stateId = &#63; and deleted = &#63; from the database.
	 *
	 * @param stateId the state ID
	 * @param deleted the deleted
	 */
	public static void removeByDistrictList(long stateId, boolean deleted) {
		getPersistence().removeByDistrictList(stateId, deleted);
	}

	/**
	 * Returns the number of districts where stateId = &#63; and deleted = &#63;.
	 *
	 * @param stateId the state ID
	 * @param deleted the deleted
	 * @return the number of matching districts
	 */
	public static int countByDistrictList(long stateId, boolean deleted) {
		return getPersistence().countByDistrictList(stateId, deleted);
	}

	/**
	 * Returns all the districts where districtId = &#63; and deleted = &#63;.
	 *
	 * @param districtId the district ID
	 * @param deleted the deleted
	 * @return the matching districts
	 */
	public static List<District> findByDistrictIdAndDeleted(
		long districtId, boolean deleted) {

		return getPersistence().findByDistrictIdAndDeleted(districtId, deleted);
	}

	/**
	 * Returns a range of all the districts where districtId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param districtId the district ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @return the range of matching districts
	 */
	public static List<District> findByDistrictIdAndDeleted(
		long districtId, boolean deleted, int start, int end) {

		return getPersistence().findByDistrictIdAndDeleted(
			districtId, deleted, start, end);
	}

	/**
	 * Returns an ordered range of all the districts where districtId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param districtId the district ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching districts
	 */
	public static List<District> findByDistrictIdAndDeleted(
		long districtId, boolean deleted, int start, int end,
		OrderByComparator<District> orderByComparator) {

		return getPersistence().findByDistrictIdAndDeleted(
			districtId, deleted, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the districts where districtId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param districtId the district ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching districts
	 */
	public static List<District> findByDistrictIdAndDeleted(
		long districtId, boolean deleted, int start, int end,
		OrderByComparator<District> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByDistrictIdAndDeleted(
			districtId, deleted, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first district in the ordered set where districtId = &#63; and deleted = &#63;.
	 *
	 * @param districtId the district ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	public static District findByDistrictIdAndDeleted_First(
			long districtId, boolean deleted,
			OrderByComparator<District> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchDistrictException {

		return getPersistence().findByDistrictIdAndDeleted_First(
			districtId, deleted, orderByComparator);
	}

	/**
	 * Returns the first district in the ordered set where districtId = &#63; and deleted = &#63;.
	 *
	 * @param districtId the district ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching district, or <code>null</code> if a matching district could not be found
	 */
	public static District fetchByDistrictIdAndDeleted_First(
		long districtId, boolean deleted,
		OrderByComparator<District> orderByComparator) {

		return getPersistence().fetchByDistrictIdAndDeleted_First(
			districtId, deleted, orderByComparator);
	}

	/**
	 * Returns the last district in the ordered set where districtId = &#63; and deleted = &#63;.
	 *
	 * @param districtId the district ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching district
	 * @throws NoSuchDistrictException if a matching district could not be found
	 */
	public static District findByDistrictIdAndDeleted_Last(
			long districtId, boolean deleted,
			OrderByComparator<District> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchDistrictException {

		return getPersistence().findByDistrictIdAndDeleted_Last(
			districtId, deleted, orderByComparator);
	}

	/**
	 * Returns the last district in the ordered set where districtId = &#63; and deleted = &#63;.
	 *
	 * @param districtId the district ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching district, or <code>null</code> if a matching district could not be found
	 */
	public static District fetchByDistrictIdAndDeleted_Last(
		long districtId, boolean deleted,
		OrderByComparator<District> orderByComparator) {

		return getPersistence().fetchByDistrictIdAndDeleted_Last(
			districtId, deleted, orderByComparator);
	}

	/**
	 * Removes all the districts where districtId = &#63; and deleted = &#63; from the database.
	 *
	 * @param districtId the district ID
	 * @param deleted the deleted
	 */
	public static void removeByDistrictIdAndDeleted(
		long districtId, boolean deleted) {

		getPersistence().removeByDistrictIdAndDeleted(districtId, deleted);
	}

	/**
	 * Returns the number of districts where districtId = &#63; and deleted = &#63;.
	 *
	 * @param districtId the district ID
	 * @param deleted the deleted
	 * @return the number of matching districts
	 */
	public static int countByDistrictIdAndDeleted(
		long districtId, boolean deleted) {

		return getPersistence().countByDistrictIdAndDeleted(
			districtId, deleted);
	}

	/**
	 * Caches the district in the entity cache if it is enabled.
	 *
	 * @param district the district
	 */
	public static void cacheResult(District district) {
		getPersistence().cacheResult(district);
	}

	/**
	 * Caches the districts in the entity cache if it is enabled.
	 *
	 * @param districts the districts
	 */
	public static void cacheResult(List<District> districts) {
		getPersistence().cacheResult(districts);
	}

	/**
	 * Creates a new district with the primary key. Does not add the district to the database.
	 *
	 * @param districtId the primary key for the new district
	 * @return the new district
	 */
	public static District create(long districtId) {
		return getPersistence().create(districtId);
	}

	/**
	 * Removes the district with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param districtId the primary key of the district
	 * @return the district that was removed
	 * @throws NoSuchDistrictException if a district with the primary key could not be found
	 */
	public static District remove(long districtId)
		throws com.adjecti.mdm.liferay.exception.NoSuchDistrictException {

		return getPersistence().remove(districtId);
	}

	public static District updateImpl(District district) {
		return getPersistence().updateImpl(district);
	}

	/**
	 * Returns the district with the primary key or throws a <code>NoSuchDistrictException</code> if it could not be found.
	 *
	 * @param districtId the primary key of the district
	 * @return the district
	 * @throws NoSuchDistrictException if a district with the primary key could not be found
	 */
	public static District findByPrimaryKey(long districtId)
		throws com.adjecti.mdm.liferay.exception.NoSuchDistrictException {

		return getPersistence().findByPrimaryKey(districtId);
	}

	/**
	 * Returns the district with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param districtId the primary key of the district
	 * @return the district, or <code>null</code> if a district with the primary key could not be found
	 */
	public static District fetchByPrimaryKey(long districtId) {
		return getPersistence().fetchByPrimaryKey(districtId);
	}

	/**
	 * Returns all the districts.
	 *
	 * @return the districts
	 */
	public static List<District> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the districts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @return the range of districts
	 */
	public static List<District> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the districts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of districts
	 */
	public static List<District> findAll(
		int start, int end, OrderByComparator<District> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the districts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DistrictModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of districts
	 */
	public static List<District> findAll(
		int start, int end, OrderByComparator<District> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the districts from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of districts.
	 *
	 * @return the number of districts
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DistrictPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DistrictPersistence, DistrictPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(DistrictPersistence.class);

		ServiceTracker<DistrictPersistence, DistrictPersistence>
			serviceTracker =
				new ServiceTracker<DistrictPersistence, DistrictPersistence>(
					bundle.getBundleContext(), DistrictPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}