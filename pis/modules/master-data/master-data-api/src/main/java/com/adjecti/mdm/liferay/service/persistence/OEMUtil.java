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

import com.adjecti.mdm.liferay.model.OEM;

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
 * The persistence utility for the oem service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.OEMPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OEMPersistence
 * @generated
 */
public class OEMUtil {

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
	public static void clearCache(OEM oem) {
		getPersistence().clearCache(oem);
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
	public static Map<Serializable, OEM> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<OEM> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OEM> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OEM> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<OEM> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static OEM update(OEM oem) {
		return getPersistence().update(oem);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static OEM update(OEM oem, ServiceContext serviceContext) {
		return getPersistence().update(oem, serviceContext);
	}

	/**
	 * Returns all the oems where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching oems
	 */
	public static List<OEM> findByCode(String code) {
		return getPersistence().findByCode(code);
	}

	/**
	 * Returns a range of all the oems where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OEMModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of oems
	 * @param end the upper bound of the range of oems (not inclusive)
	 * @return the range of matching oems
	 */
	public static List<OEM> findByCode(String code, int start, int end) {
		return getPersistence().findByCode(code, start, end);
	}

	/**
	 * Returns an ordered range of all the oems where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OEMModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of oems
	 * @param end the upper bound of the range of oems (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching oems
	 */
	public static List<OEM> findByCode(
		String code, int start, int end,
		OrderByComparator<OEM> orderByComparator) {

		return getPersistence().findByCode(code, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the oems where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OEMModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of oems
	 * @param end the upper bound of the range of oems (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching oems
	 */
	public static List<OEM> findByCode(
		String code, int start, int end,
		OrderByComparator<OEM> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCode(
			code, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first oem in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching oem
	 * @throws NoSuchOEMException if a matching oem could not be found
	 */
	public static OEM findByCode_First(
			String code, OrderByComparator<OEM> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchOEMException {

		return getPersistence().findByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the first oem in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching oem, or <code>null</code> if a matching oem could not be found
	 */
	public static OEM fetchByCode_First(
		String code, OrderByComparator<OEM> orderByComparator) {

		return getPersistence().fetchByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the last oem in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching oem
	 * @throws NoSuchOEMException if a matching oem could not be found
	 */
	public static OEM findByCode_Last(
			String code, OrderByComparator<OEM> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchOEMException {

		return getPersistence().findByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the last oem in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching oem, or <code>null</code> if a matching oem could not be found
	 */
	public static OEM fetchByCode_Last(
		String code, OrderByComparator<OEM> orderByComparator) {

		return getPersistence().fetchByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the oems before and after the current oem in the ordered set where code = &#63;.
	 *
	 * @param oemId the primary key of the current oem
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next oem
	 * @throws NoSuchOEMException if a oem with the primary key could not be found
	 */
	public static OEM[] findByCode_PrevAndNext(
			long oemId, String code, OrderByComparator<OEM> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchOEMException {

		return getPersistence().findByCode_PrevAndNext(
			oemId, code, orderByComparator);
	}

	/**
	 * Removes all the oems where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public static void removeByCode(String code) {
		getPersistence().removeByCode(code);
	}

	/**
	 * Returns the number of oems where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching oems
	 */
	public static int countByCode(String code) {
		return getPersistence().countByCode(code);
	}

	/**
	 * Returns all the oems where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching oems
	 */
	public static List<OEM> findByName(String name) {
		return getPersistence().findByName(name);
	}

	/**
	 * Returns a range of all the oems where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OEMModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of oems
	 * @param end the upper bound of the range of oems (not inclusive)
	 * @return the range of matching oems
	 */
	public static List<OEM> findByName(String name, int start, int end) {
		return getPersistence().findByName(name, start, end);
	}

	/**
	 * Returns an ordered range of all the oems where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OEMModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of oems
	 * @param end the upper bound of the range of oems (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching oems
	 */
	public static List<OEM> findByName(
		String name, int start, int end,
		OrderByComparator<OEM> orderByComparator) {

		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the oems where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OEMModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of oems
	 * @param end the upper bound of the range of oems (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching oems
	 */
	public static List<OEM> findByName(
		String name, int start, int end,
		OrderByComparator<OEM> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByName(
			name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first oem in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching oem
	 * @throws NoSuchOEMException if a matching oem could not be found
	 */
	public static OEM findByName_First(
			String name, OrderByComparator<OEM> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchOEMException {

		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	 * Returns the first oem in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching oem, or <code>null</code> if a matching oem could not be found
	 */
	public static OEM fetchByName_First(
		String name, OrderByComparator<OEM> orderByComparator) {

		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	 * Returns the last oem in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching oem
	 * @throws NoSuchOEMException if a matching oem could not be found
	 */
	public static OEM findByName_Last(
			String name, OrderByComparator<OEM> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchOEMException {

		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the last oem in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching oem, or <code>null</code> if a matching oem could not be found
	 */
	public static OEM fetchByName_Last(
		String name, OrderByComparator<OEM> orderByComparator) {

		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the oems before and after the current oem in the ordered set where name = &#63;.
	 *
	 * @param oemId the primary key of the current oem
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next oem
	 * @throws NoSuchOEMException if a oem with the primary key could not be found
	 */
	public static OEM[] findByName_PrevAndNext(
			long oemId, String name, OrderByComparator<OEM> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchOEMException {

		return getPersistence().findByName_PrevAndNext(
			oemId, name, orderByComparator);
	}

	/**
	 * Removes all the oems where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeByName(String name) {
		getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of oems where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching oems
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Caches the oem in the entity cache if it is enabled.
	 *
	 * @param oem the oem
	 */
	public static void cacheResult(OEM oem) {
		getPersistence().cacheResult(oem);
	}

	/**
	 * Caches the oems in the entity cache if it is enabled.
	 *
	 * @param oems the oems
	 */
	public static void cacheResult(List<OEM> oems) {
		getPersistence().cacheResult(oems);
	}

	/**
	 * Creates a new oem with the primary key. Does not add the oem to the database.
	 *
	 * @param oemId the primary key for the new oem
	 * @return the new oem
	 */
	public static OEM create(long oemId) {
		return getPersistence().create(oemId);
	}

	/**
	 * Removes the oem with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param oemId the primary key of the oem
	 * @return the oem that was removed
	 * @throws NoSuchOEMException if a oem with the primary key could not be found
	 */
	public static OEM remove(long oemId)
		throws com.adjecti.mdm.liferay.exception.NoSuchOEMException {

		return getPersistence().remove(oemId);
	}

	public static OEM updateImpl(OEM oem) {
		return getPersistence().updateImpl(oem);
	}

	/**
	 * Returns the oem with the primary key or throws a <code>NoSuchOEMException</code> if it could not be found.
	 *
	 * @param oemId the primary key of the oem
	 * @return the oem
	 * @throws NoSuchOEMException if a oem with the primary key could not be found
	 */
	public static OEM findByPrimaryKey(long oemId)
		throws com.adjecti.mdm.liferay.exception.NoSuchOEMException {

		return getPersistence().findByPrimaryKey(oemId);
	}

	/**
	 * Returns the oem with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param oemId the primary key of the oem
	 * @return the oem, or <code>null</code> if a oem with the primary key could not be found
	 */
	public static OEM fetchByPrimaryKey(long oemId) {
		return getPersistence().fetchByPrimaryKey(oemId);
	}

	/**
	 * Returns all the oems.
	 *
	 * @return the oems
	 */
	public static List<OEM> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the oems.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OEMModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of oems
	 * @param end the upper bound of the range of oems (not inclusive)
	 * @return the range of oems
	 */
	public static List<OEM> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the oems.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OEMModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of oems
	 * @param end the upper bound of the range of oems (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of oems
	 */
	public static List<OEM> findAll(
		int start, int end, OrderByComparator<OEM> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the oems.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OEMModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of oems
	 * @param end the upper bound of the range of oems (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of oems
	 */
	public static List<OEM> findAll(
		int start, int end, OrderByComparator<OEM> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the oems from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of oems.
	 *
	 * @return the number of oems
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static OEMPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<OEMPersistence, OEMPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(OEMPersistence.class);

		ServiceTracker<OEMPersistence, OEMPersistence> serviceTracker =
			new ServiceTracker<OEMPersistence, OEMPersistence>(
				bundle.getBundleContext(), OEMPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}