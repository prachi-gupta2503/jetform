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

import com.adjecti.mdm.liferay.model.Cadre;

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
 * The persistence utility for the cadre service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.CadrePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CadrePersistence
 * @generated
 */
public class CadreUtil {

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
	public static void clearCache(Cadre cadre) {
		getPersistence().clearCache(cadre);
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
	public static Map<Serializable, Cadre> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Cadre> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Cadre> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Cadre> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Cadre> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Cadre update(Cadre cadre) {
		return getPersistence().update(cadre);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Cadre update(Cadre cadre, ServiceContext serviceContext) {
		return getPersistence().update(cadre, serviceContext);
	}

	/**
	 * Returns all the cadres where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching cadres
	 */
	public static List<Cadre> findByCode(String code) {
		return getPersistence().findByCode(code);
	}

	/**
	 * Returns a range of all the cadres where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of cadres
	 * @param end the upper bound of the range of cadres (not inclusive)
	 * @return the range of matching cadres
	 */
	public static List<Cadre> findByCode(String code, int start, int end) {
		return getPersistence().findByCode(code, start, end);
	}

	/**
	 * Returns an ordered range of all the cadres where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of cadres
	 * @param end the upper bound of the range of cadres (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cadres
	 */
	public static List<Cadre> findByCode(
		String code, int start, int end,
		OrderByComparator<Cadre> orderByComparator) {

		return getPersistence().findByCode(code, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cadres where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of cadres
	 * @param end the upper bound of the range of cadres (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cadres
	 */
	public static List<Cadre> findByCode(
		String code, int start, int end,
		OrderByComparator<Cadre> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCode(
			code, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cadre in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cadre
	 * @throws NoSuchCadreException if a matching cadre could not be found
	 */
	public static Cadre findByCode_First(
			String code, OrderByComparator<Cadre> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchCadreException {

		return getPersistence().findByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the first cadre in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cadre, or <code>null</code> if a matching cadre could not be found
	 */
	public static Cadre fetchByCode_First(
		String code, OrderByComparator<Cadre> orderByComparator) {

		return getPersistence().fetchByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the last cadre in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cadre
	 * @throws NoSuchCadreException if a matching cadre could not be found
	 */
	public static Cadre findByCode_Last(
			String code, OrderByComparator<Cadre> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchCadreException {

		return getPersistence().findByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the last cadre in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cadre, or <code>null</code> if a matching cadre could not be found
	 */
	public static Cadre fetchByCode_Last(
		String code, OrderByComparator<Cadre> orderByComparator) {

		return getPersistence().fetchByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the cadres before and after the current cadre in the ordered set where code = &#63;.
	 *
	 * @param cadreId the primary key of the current cadre
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cadre
	 * @throws NoSuchCadreException if a cadre with the primary key could not be found
	 */
	public static Cadre[] findByCode_PrevAndNext(
			long cadreId, String code,
			OrderByComparator<Cadre> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchCadreException {

		return getPersistence().findByCode_PrevAndNext(
			cadreId, code, orderByComparator);
	}

	/**
	 * Removes all the cadres where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public static void removeByCode(String code) {
		getPersistence().removeByCode(code);
	}

	/**
	 * Returns the number of cadres where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching cadres
	 */
	public static int countByCode(String code) {
		return getPersistence().countByCode(code);
	}

	/**
	 * Returns all the cadres where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching cadres
	 */
	public static List<Cadre> findByName(String name) {
		return getPersistence().findByName(name);
	}

	/**
	 * Returns a range of all the cadres where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of cadres
	 * @param end the upper bound of the range of cadres (not inclusive)
	 * @return the range of matching cadres
	 */
	public static List<Cadre> findByName(String name, int start, int end) {
		return getPersistence().findByName(name, start, end);
	}

	/**
	 * Returns an ordered range of all the cadres where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of cadres
	 * @param end the upper bound of the range of cadres (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cadres
	 */
	public static List<Cadre> findByName(
		String name, int start, int end,
		OrderByComparator<Cadre> orderByComparator) {

		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cadres where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of cadres
	 * @param end the upper bound of the range of cadres (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cadres
	 */
	public static List<Cadre> findByName(
		String name, int start, int end,
		OrderByComparator<Cadre> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByName(
			name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cadre in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cadre
	 * @throws NoSuchCadreException if a matching cadre could not be found
	 */
	public static Cadre findByName_First(
			String name, OrderByComparator<Cadre> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchCadreException {

		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	 * Returns the first cadre in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cadre, or <code>null</code> if a matching cadre could not be found
	 */
	public static Cadre fetchByName_First(
		String name, OrderByComparator<Cadre> orderByComparator) {

		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	 * Returns the last cadre in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cadre
	 * @throws NoSuchCadreException if a matching cadre could not be found
	 */
	public static Cadre findByName_Last(
			String name, OrderByComparator<Cadre> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchCadreException {

		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the last cadre in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cadre, or <code>null</code> if a matching cadre could not be found
	 */
	public static Cadre fetchByName_Last(
		String name, OrderByComparator<Cadre> orderByComparator) {

		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the cadres before and after the current cadre in the ordered set where name = &#63;.
	 *
	 * @param cadreId the primary key of the current cadre
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cadre
	 * @throws NoSuchCadreException if a cadre with the primary key could not be found
	 */
	public static Cadre[] findByName_PrevAndNext(
			long cadreId, String name,
			OrderByComparator<Cadre> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchCadreException {

		return getPersistence().findByName_PrevAndNext(
			cadreId, name, orderByComparator);
	}

	/**
	 * Removes all the cadres where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeByName(String name) {
		getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of cadres where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching cadres
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Caches the cadre in the entity cache if it is enabled.
	 *
	 * @param cadre the cadre
	 */
	public static void cacheResult(Cadre cadre) {
		getPersistence().cacheResult(cadre);
	}

	/**
	 * Caches the cadres in the entity cache if it is enabled.
	 *
	 * @param cadres the cadres
	 */
	public static void cacheResult(List<Cadre> cadres) {
		getPersistence().cacheResult(cadres);
	}

	/**
	 * Creates a new cadre with the primary key. Does not add the cadre to the database.
	 *
	 * @param cadreId the primary key for the new cadre
	 * @return the new cadre
	 */
	public static Cadre create(long cadreId) {
		return getPersistence().create(cadreId);
	}

	/**
	 * Removes the cadre with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cadreId the primary key of the cadre
	 * @return the cadre that was removed
	 * @throws NoSuchCadreException if a cadre with the primary key could not be found
	 */
	public static Cadre remove(long cadreId)
		throws com.adjecti.mdm.liferay.exception.NoSuchCadreException {

		return getPersistence().remove(cadreId);
	}

	public static Cadre updateImpl(Cadre cadre) {
		return getPersistence().updateImpl(cadre);
	}

	/**
	 * Returns the cadre with the primary key or throws a <code>NoSuchCadreException</code> if it could not be found.
	 *
	 * @param cadreId the primary key of the cadre
	 * @return the cadre
	 * @throws NoSuchCadreException if a cadre with the primary key could not be found
	 */
	public static Cadre findByPrimaryKey(long cadreId)
		throws com.adjecti.mdm.liferay.exception.NoSuchCadreException {

		return getPersistence().findByPrimaryKey(cadreId);
	}

	/**
	 * Returns the cadre with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cadreId the primary key of the cadre
	 * @return the cadre, or <code>null</code> if a cadre with the primary key could not be found
	 */
	public static Cadre fetchByPrimaryKey(long cadreId) {
		return getPersistence().fetchByPrimaryKey(cadreId);
	}

	/**
	 * Returns all the cadres.
	 *
	 * @return the cadres
	 */
	public static List<Cadre> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the cadres.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cadres
	 * @param end the upper bound of the range of cadres (not inclusive)
	 * @return the range of cadres
	 */
	public static List<Cadre> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the cadres.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cadres
	 * @param end the upper bound of the range of cadres (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cadres
	 */
	public static List<Cadre> findAll(
		int start, int end, OrderByComparator<Cadre> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cadres.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cadres
	 * @param end the upper bound of the range of cadres (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cadres
	 */
	public static List<Cadre> findAll(
		int start, int end, OrderByComparator<Cadre> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the cadres from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cadres.
	 *
	 * @return the number of cadres
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CadrePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CadrePersistence, CadrePersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CadrePersistence.class);

		ServiceTracker<CadrePersistence, CadrePersistence> serviceTracker =
			new ServiceTracker<CadrePersistence, CadrePersistence>(
				bundle.getBundleContext(), CadrePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}