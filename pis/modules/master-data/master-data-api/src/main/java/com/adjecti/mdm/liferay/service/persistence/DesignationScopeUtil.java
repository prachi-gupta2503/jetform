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

import com.adjecti.mdm.liferay.model.DesignationScope;

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
 * The persistence utility for the designation scope service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.DesignationScopePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DesignationScopePersistence
 * @generated
 */
public class DesignationScopeUtil {

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
	public static void clearCache(DesignationScope designationScope) {
		getPersistence().clearCache(designationScope);
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
	public static Map<Serializable, DesignationScope> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DesignationScope> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DesignationScope> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DesignationScope> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DesignationScope> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DesignationScope update(DesignationScope designationScope) {
		return getPersistence().update(designationScope);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DesignationScope update(
		DesignationScope designationScope, ServiceContext serviceContext) {

		return getPersistence().update(designationScope, serviceContext);
	}

	/**
	 * Returns all the designation scopes where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @return the matching designation scopes
	 */
	public static List<DesignationScope> findByDesignationId(
		long designationId) {

		return getPersistence().findByDesignationId(designationId);
	}

	/**
	 * Returns a range of all the designation scopes where designationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationScopeModelImpl</code>.
	 * </p>
	 *
	 * @param designationId the designation ID
	 * @param start the lower bound of the range of designation scopes
	 * @param end the upper bound of the range of designation scopes (not inclusive)
	 * @return the range of matching designation scopes
	 */
	public static List<DesignationScope> findByDesignationId(
		long designationId, int start, int end) {

		return getPersistence().findByDesignationId(designationId, start, end);
	}

	/**
	 * Returns an ordered range of all the designation scopes where designationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationScopeModelImpl</code>.
	 * </p>
	 *
	 * @param designationId the designation ID
	 * @param start the lower bound of the range of designation scopes
	 * @param end the upper bound of the range of designation scopes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching designation scopes
	 */
	public static List<DesignationScope> findByDesignationId(
		long designationId, int start, int end,
		OrderByComparator<DesignationScope> orderByComparator) {

		return getPersistence().findByDesignationId(
			designationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the designation scopes where designationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationScopeModelImpl</code>.
	 * </p>
	 *
	 * @param designationId the designation ID
	 * @param start the lower bound of the range of designation scopes
	 * @param end the upper bound of the range of designation scopes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching designation scopes
	 */
	public static List<DesignationScope> findByDesignationId(
		long designationId, int start, int end,
		OrderByComparator<DesignationScope> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDesignationId(
			designationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first designation scope in the ordered set where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation scope
	 * @throws NoSuchDesignationScopeException if a matching designation scope could not be found
	 */
	public static DesignationScope findByDesignationId_First(
			long designationId,
			OrderByComparator<DesignationScope> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchDesignationScopeException {

		return getPersistence().findByDesignationId_First(
			designationId, orderByComparator);
	}

	/**
	 * Returns the first designation scope in the ordered set where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation scope, or <code>null</code> if a matching designation scope could not be found
	 */
	public static DesignationScope fetchByDesignationId_First(
		long designationId,
		OrderByComparator<DesignationScope> orderByComparator) {

		return getPersistence().fetchByDesignationId_First(
			designationId, orderByComparator);
	}

	/**
	 * Returns the last designation scope in the ordered set where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation scope
	 * @throws NoSuchDesignationScopeException if a matching designation scope could not be found
	 */
	public static DesignationScope findByDesignationId_Last(
			long designationId,
			OrderByComparator<DesignationScope> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchDesignationScopeException {

		return getPersistence().findByDesignationId_Last(
			designationId, orderByComparator);
	}

	/**
	 * Returns the last designation scope in the ordered set where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation scope, or <code>null</code> if a matching designation scope could not be found
	 */
	public static DesignationScope fetchByDesignationId_Last(
		long designationId,
		OrderByComparator<DesignationScope> orderByComparator) {

		return getPersistence().fetchByDesignationId_Last(
			designationId, orderByComparator);
	}

	/**
	 * Returns the designation scopes before and after the current designation scope in the ordered set where designationId = &#63;.
	 *
	 * @param designationScopePK the primary key of the current designation scope
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next designation scope
	 * @throws NoSuchDesignationScopeException if a designation scope with the primary key could not be found
	 */
	public static DesignationScope[] findByDesignationId_PrevAndNext(
			DesignationScopePK designationScopePK, long designationId,
			OrderByComparator<DesignationScope> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchDesignationScopeException {

		return getPersistence().findByDesignationId_PrevAndNext(
			designationScopePK, designationId, orderByComparator);
	}

	/**
	 * Removes all the designation scopes where designationId = &#63; from the database.
	 *
	 * @param designationId the designation ID
	 */
	public static void removeByDesignationId(long designationId) {
		getPersistence().removeByDesignationId(designationId);
	}

	/**
	 * Returns the number of designation scopes where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @return the number of matching designation scopes
	 */
	public static int countByDesignationId(long designationId) {
		return getPersistence().countByDesignationId(designationId);
	}

	/**
	 * Caches the designation scope in the entity cache if it is enabled.
	 *
	 * @param designationScope the designation scope
	 */
	public static void cacheResult(DesignationScope designationScope) {
		getPersistence().cacheResult(designationScope);
	}

	/**
	 * Caches the designation scopes in the entity cache if it is enabled.
	 *
	 * @param designationScopes the designation scopes
	 */
	public static void cacheResult(List<DesignationScope> designationScopes) {
		getPersistence().cacheResult(designationScopes);
	}

	/**
	 * Creates a new designation scope with the primary key. Does not add the designation scope to the database.
	 *
	 * @param designationScopePK the primary key for the new designation scope
	 * @return the new designation scope
	 */
	public static DesignationScope create(
		DesignationScopePK designationScopePK) {

		return getPersistence().create(designationScopePK);
	}

	/**
	 * Removes the designation scope with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param designationScopePK the primary key of the designation scope
	 * @return the designation scope that was removed
	 * @throws NoSuchDesignationScopeException if a designation scope with the primary key could not be found
	 */
	public static DesignationScope remove(DesignationScopePK designationScopePK)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchDesignationScopeException {

		return getPersistence().remove(designationScopePK);
	}

	public static DesignationScope updateImpl(
		DesignationScope designationScope) {

		return getPersistence().updateImpl(designationScope);
	}

	/**
	 * Returns the designation scope with the primary key or throws a <code>NoSuchDesignationScopeException</code> if it could not be found.
	 *
	 * @param designationScopePK the primary key of the designation scope
	 * @return the designation scope
	 * @throws NoSuchDesignationScopeException if a designation scope with the primary key could not be found
	 */
	public static DesignationScope findByPrimaryKey(
			DesignationScopePK designationScopePK)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchDesignationScopeException {

		return getPersistence().findByPrimaryKey(designationScopePK);
	}

	/**
	 * Returns the designation scope with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param designationScopePK the primary key of the designation scope
	 * @return the designation scope, or <code>null</code> if a designation scope with the primary key could not be found
	 */
	public static DesignationScope fetchByPrimaryKey(
		DesignationScopePK designationScopePK) {

		return getPersistence().fetchByPrimaryKey(designationScopePK);
	}

	/**
	 * Returns all the designation scopes.
	 *
	 * @return the designation scopes
	 */
	public static List<DesignationScope> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the designation scopes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationScopeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation scopes
	 * @param end the upper bound of the range of designation scopes (not inclusive)
	 * @return the range of designation scopes
	 */
	public static List<DesignationScope> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the designation scopes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationScopeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation scopes
	 * @param end the upper bound of the range of designation scopes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of designation scopes
	 */
	public static List<DesignationScope> findAll(
		int start, int end,
		OrderByComparator<DesignationScope> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the designation scopes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationScopeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation scopes
	 * @param end the upper bound of the range of designation scopes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of designation scopes
	 */
	public static List<DesignationScope> findAll(
		int start, int end,
		OrderByComparator<DesignationScope> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the designation scopes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of designation scopes.
	 *
	 * @return the number of designation scopes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static DesignationScopePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<DesignationScopePersistence, DesignationScopePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			DesignationScopePersistence.class);

		ServiceTracker<DesignationScopePersistence, DesignationScopePersistence>
			serviceTracker =
				new ServiceTracker
					<DesignationScopePersistence, DesignationScopePersistence>(
						bundle.getBundleContext(),
						DesignationScopePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}