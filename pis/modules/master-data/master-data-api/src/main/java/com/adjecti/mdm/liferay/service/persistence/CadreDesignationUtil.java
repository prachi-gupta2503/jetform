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

import com.adjecti.mdm.liferay.model.CadreDesignation;

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
 * The persistence utility for the cadre designation service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.CadreDesignationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CadreDesignationPersistence
 * @generated
 */
public class CadreDesignationUtil {

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
	public static void clearCache(CadreDesignation cadreDesignation) {
		getPersistence().clearCache(cadreDesignation);
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
	public static Map<Serializable, CadreDesignation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CadreDesignation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CadreDesignation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CadreDesignation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CadreDesignation> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CadreDesignation update(CadreDesignation cadreDesignation) {
		return getPersistence().update(cadreDesignation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CadreDesignation update(
		CadreDesignation cadreDesignation, ServiceContext serviceContext) {

		return getPersistence().update(cadreDesignation, serviceContext);
	}

	/**
	 * Returns all the cadre designations where cadreId = &#63;.
	 *
	 * @param cadreId the cadre ID
	 * @return the matching cadre designations
	 */
	public static List<CadreDesignation> findByCadreId(long cadreId) {
		return getPersistence().findByCadreId(cadreId);
	}

	/**
	 * Returns a range of all the cadre designations where cadreId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param cadreId the cadre ID
	 * @param start the lower bound of the range of cadre designations
	 * @param end the upper bound of the range of cadre designations (not inclusive)
	 * @return the range of matching cadre designations
	 */
	public static List<CadreDesignation> findByCadreId(
		long cadreId, int start, int end) {

		return getPersistence().findByCadreId(cadreId, start, end);
	}

	/**
	 * Returns an ordered range of all the cadre designations where cadreId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param cadreId the cadre ID
	 * @param start the lower bound of the range of cadre designations
	 * @param end the upper bound of the range of cadre designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cadre designations
	 */
	public static List<CadreDesignation> findByCadreId(
		long cadreId, int start, int end,
		OrderByComparator<CadreDesignation> orderByComparator) {

		return getPersistence().findByCadreId(
			cadreId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cadre designations where cadreId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param cadreId the cadre ID
	 * @param start the lower bound of the range of cadre designations
	 * @param end the upper bound of the range of cadre designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cadre designations
	 */
	public static List<CadreDesignation> findByCadreId(
		long cadreId, int start, int end,
		OrderByComparator<CadreDesignation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCadreId(
			cadreId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cadre designation in the ordered set where cadreId = &#63;.
	 *
	 * @param cadreId the cadre ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cadre designation
	 * @throws NoSuchCadreDesignationException if a matching cadre designation could not be found
	 */
	public static CadreDesignation findByCadreId_First(
			long cadreId, OrderByComparator<CadreDesignation> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchCadreDesignationException {

		return getPersistence().findByCadreId_First(cadreId, orderByComparator);
	}

	/**
	 * Returns the first cadre designation in the ordered set where cadreId = &#63;.
	 *
	 * @param cadreId the cadre ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cadre designation, or <code>null</code> if a matching cadre designation could not be found
	 */
	public static CadreDesignation fetchByCadreId_First(
		long cadreId, OrderByComparator<CadreDesignation> orderByComparator) {

		return getPersistence().fetchByCadreId_First(
			cadreId, orderByComparator);
	}

	/**
	 * Returns the last cadre designation in the ordered set where cadreId = &#63;.
	 *
	 * @param cadreId the cadre ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cadre designation
	 * @throws NoSuchCadreDesignationException if a matching cadre designation could not be found
	 */
	public static CadreDesignation findByCadreId_Last(
			long cadreId, OrderByComparator<CadreDesignation> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchCadreDesignationException {

		return getPersistence().findByCadreId_Last(cadreId, orderByComparator);
	}

	/**
	 * Returns the last cadre designation in the ordered set where cadreId = &#63;.
	 *
	 * @param cadreId the cadre ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cadre designation, or <code>null</code> if a matching cadre designation could not be found
	 */
	public static CadreDesignation fetchByCadreId_Last(
		long cadreId, OrderByComparator<CadreDesignation> orderByComparator) {

		return getPersistence().fetchByCadreId_Last(cadreId, orderByComparator);
	}

	/**
	 * Returns the cadre designations before and after the current cadre designation in the ordered set where cadreId = &#63;.
	 *
	 * @param cadreDesignationId the primary key of the current cadre designation
	 * @param cadreId the cadre ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cadre designation
	 * @throws NoSuchCadreDesignationException if a cadre designation with the primary key could not be found
	 */
	public static CadreDesignation[] findByCadreId_PrevAndNext(
			long cadreDesignationId, long cadreId,
			OrderByComparator<CadreDesignation> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchCadreDesignationException {

		return getPersistence().findByCadreId_PrevAndNext(
			cadreDesignationId, cadreId, orderByComparator);
	}

	/**
	 * Removes all the cadre designations where cadreId = &#63; from the database.
	 *
	 * @param cadreId the cadre ID
	 */
	public static void removeByCadreId(long cadreId) {
		getPersistence().removeByCadreId(cadreId);
	}

	/**
	 * Returns the number of cadre designations where cadreId = &#63;.
	 *
	 * @param cadreId the cadre ID
	 * @return the number of matching cadre designations
	 */
	public static int countByCadreId(long cadreId) {
		return getPersistence().countByCadreId(cadreId);
	}

	/**
	 * Returns all the cadre designations where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @return the matching cadre designations
	 */
	public static List<CadreDesignation> findByDesignationId(
		long designationId) {

		return getPersistence().findByDesignationId(designationId);
	}

	/**
	 * Returns a range of all the cadre designations where designationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationId the designation ID
	 * @param start the lower bound of the range of cadre designations
	 * @param end the upper bound of the range of cadre designations (not inclusive)
	 * @return the range of matching cadre designations
	 */
	public static List<CadreDesignation> findByDesignationId(
		long designationId, int start, int end) {

		return getPersistence().findByDesignationId(designationId, start, end);
	}

	/**
	 * Returns an ordered range of all the cadre designations where designationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationId the designation ID
	 * @param start the lower bound of the range of cadre designations
	 * @param end the upper bound of the range of cadre designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cadre designations
	 */
	public static List<CadreDesignation> findByDesignationId(
		long designationId, int start, int end,
		OrderByComparator<CadreDesignation> orderByComparator) {

		return getPersistence().findByDesignationId(
			designationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cadre designations where designationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationId the designation ID
	 * @param start the lower bound of the range of cadre designations
	 * @param end the upper bound of the range of cadre designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cadre designations
	 */
	public static List<CadreDesignation> findByDesignationId(
		long designationId, int start, int end,
		OrderByComparator<CadreDesignation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDesignationId(
			designationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cadre designation in the ordered set where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cadre designation
	 * @throws NoSuchCadreDesignationException if a matching cadre designation could not be found
	 */
	public static CadreDesignation findByDesignationId_First(
			long designationId,
			OrderByComparator<CadreDesignation> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchCadreDesignationException {

		return getPersistence().findByDesignationId_First(
			designationId, orderByComparator);
	}

	/**
	 * Returns the first cadre designation in the ordered set where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cadre designation, or <code>null</code> if a matching cadre designation could not be found
	 */
	public static CadreDesignation fetchByDesignationId_First(
		long designationId,
		OrderByComparator<CadreDesignation> orderByComparator) {

		return getPersistence().fetchByDesignationId_First(
			designationId, orderByComparator);
	}

	/**
	 * Returns the last cadre designation in the ordered set where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cadre designation
	 * @throws NoSuchCadreDesignationException if a matching cadre designation could not be found
	 */
	public static CadreDesignation findByDesignationId_Last(
			long designationId,
			OrderByComparator<CadreDesignation> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchCadreDesignationException {

		return getPersistence().findByDesignationId_Last(
			designationId, orderByComparator);
	}

	/**
	 * Returns the last cadre designation in the ordered set where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cadre designation, or <code>null</code> if a matching cadre designation could not be found
	 */
	public static CadreDesignation fetchByDesignationId_Last(
		long designationId,
		OrderByComparator<CadreDesignation> orderByComparator) {

		return getPersistence().fetchByDesignationId_Last(
			designationId, orderByComparator);
	}

	/**
	 * Returns the cadre designations before and after the current cadre designation in the ordered set where designationId = &#63;.
	 *
	 * @param cadreDesignationId the primary key of the current cadre designation
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cadre designation
	 * @throws NoSuchCadreDesignationException if a cadre designation with the primary key could not be found
	 */
	public static CadreDesignation[] findByDesignationId_PrevAndNext(
			long cadreDesignationId, long designationId,
			OrderByComparator<CadreDesignation> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchCadreDesignationException {

		return getPersistence().findByDesignationId_PrevAndNext(
			cadreDesignationId, designationId, orderByComparator);
	}

	/**
	 * Removes all the cadre designations where designationId = &#63; from the database.
	 *
	 * @param designationId the designation ID
	 */
	public static void removeByDesignationId(long designationId) {
		getPersistence().removeByDesignationId(designationId);
	}

	/**
	 * Returns the number of cadre designations where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @return the number of matching cadre designations
	 */
	public static int countByDesignationId(long designationId) {
		return getPersistence().countByDesignationId(designationId);
	}

	/**
	 * Caches the cadre designation in the entity cache if it is enabled.
	 *
	 * @param cadreDesignation the cadre designation
	 */
	public static void cacheResult(CadreDesignation cadreDesignation) {
		getPersistence().cacheResult(cadreDesignation);
	}

	/**
	 * Caches the cadre designations in the entity cache if it is enabled.
	 *
	 * @param cadreDesignations the cadre designations
	 */
	public static void cacheResult(List<CadreDesignation> cadreDesignations) {
		getPersistence().cacheResult(cadreDesignations);
	}

	/**
	 * Creates a new cadre designation with the primary key. Does not add the cadre designation to the database.
	 *
	 * @param cadreDesignationId the primary key for the new cadre designation
	 * @return the new cadre designation
	 */
	public static CadreDesignation create(long cadreDesignationId) {
		return getPersistence().create(cadreDesignationId);
	}

	/**
	 * Removes the cadre designation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cadreDesignationId the primary key of the cadre designation
	 * @return the cadre designation that was removed
	 * @throws NoSuchCadreDesignationException if a cadre designation with the primary key could not be found
	 */
	public static CadreDesignation remove(long cadreDesignationId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchCadreDesignationException {

		return getPersistence().remove(cadreDesignationId);
	}

	public static CadreDesignation updateImpl(
		CadreDesignation cadreDesignation) {

		return getPersistence().updateImpl(cadreDesignation);
	}

	/**
	 * Returns the cadre designation with the primary key or throws a <code>NoSuchCadreDesignationException</code> if it could not be found.
	 *
	 * @param cadreDesignationId the primary key of the cadre designation
	 * @return the cadre designation
	 * @throws NoSuchCadreDesignationException if a cadre designation with the primary key could not be found
	 */
	public static CadreDesignation findByPrimaryKey(long cadreDesignationId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchCadreDesignationException {

		return getPersistence().findByPrimaryKey(cadreDesignationId);
	}

	/**
	 * Returns the cadre designation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cadreDesignationId the primary key of the cadre designation
	 * @return the cadre designation, or <code>null</code> if a cadre designation with the primary key could not be found
	 */
	public static CadreDesignation fetchByPrimaryKey(long cadreDesignationId) {
		return getPersistence().fetchByPrimaryKey(cadreDesignationId);
	}

	/**
	 * Returns all the cadre designations.
	 *
	 * @return the cadre designations
	 */
	public static List<CadreDesignation> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the cadre designations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cadre designations
	 * @param end the upper bound of the range of cadre designations (not inclusive)
	 * @return the range of cadre designations
	 */
	public static List<CadreDesignation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the cadre designations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cadre designations
	 * @param end the upper bound of the range of cadre designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cadre designations
	 */
	public static List<CadreDesignation> findAll(
		int start, int end,
		OrderByComparator<CadreDesignation> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cadre designations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CadreDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cadre designations
	 * @param end the upper bound of the range of cadre designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cadre designations
	 */
	public static List<CadreDesignation> findAll(
		int start, int end,
		OrderByComparator<CadreDesignation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the cadre designations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cadre designations.
	 *
	 * @return the number of cadre designations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CadreDesignationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CadreDesignationPersistence, CadreDesignationPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CadreDesignationPersistence.class);

		ServiceTracker<CadreDesignationPersistence, CadreDesignationPersistence>
			serviceTracker =
				new ServiceTracker
					<CadreDesignationPersistence, CadreDesignationPersistence>(
						bundle.getBundleContext(),
						CadreDesignationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}