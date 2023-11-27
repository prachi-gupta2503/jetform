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

import com.adjecti.mdm.liferay.model.PostDelegation;

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
 * The persistence utility for the post delegation service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.PostDelegationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PostDelegationPersistence
 * @generated
 */
public class PostDelegationUtil {

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
	public static void clearCache(PostDelegation postDelegation) {
		getPersistence().clearCache(postDelegation);
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
	public static Map<Serializable, PostDelegation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PostDelegation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PostDelegation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PostDelegation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PostDelegation> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PostDelegation update(PostDelegation postDelegation) {
		return getPersistence().update(postDelegation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PostDelegation update(
		PostDelegation postDelegation, ServiceContext serviceContext) {

		return getPersistence().update(postDelegation, serviceContext);
	}

	/**
	 * Caches the post delegation in the entity cache if it is enabled.
	 *
	 * @param postDelegation the post delegation
	 */
	public static void cacheResult(PostDelegation postDelegation) {
		getPersistence().cacheResult(postDelegation);
	}

	/**
	 * Caches the post delegations in the entity cache if it is enabled.
	 *
	 * @param postDelegations the post delegations
	 */
	public static void cacheResult(List<PostDelegation> postDelegations) {
		getPersistence().cacheResult(postDelegations);
	}

	/**
	 * Creates a new post delegation with the primary key. Does not add the post delegation to the database.
	 *
	 * @param postDelegationId the primary key for the new post delegation
	 * @return the new post delegation
	 */
	public static PostDelegation create(long postDelegationId) {
		return getPersistence().create(postDelegationId);
	}

	/**
	 * Removes the post delegation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param postDelegationId the primary key of the post delegation
	 * @return the post delegation that was removed
	 * @throws NoSuchPostDelegationException if a post delegation with the primary key could not be found
	 */
	public static PostDelegation remove(long postDelegationId)
		throws com.adjecti.mdm.liferay.exception.NoSuchPostDelegationException {

		return getPersistence().remove(postDelegationId);
	}

	public static PostDelegation updateImpl(PostDelegation postDelegation) {
		return getPersistence().updateImpl(postDelegation);
	}

	/**
	 * Returns the post delegation with the primary key or throws a <code>NoSuchPostDelegationException</code> if it could not be found.
	 *
	 * @param postDelegationId the primary key of the post delegation
	 * @return the post delegation
	 * @throws NoSuchPostDelegationException if a post delegation with the primary key could not be found
	 */
	public static PostDelegation findByPrimaryKey(long postDelegationId)
		throws com.adjecti.mdm.liferay.exception.NoSuchPostDelegationException {

		return getPersistence().findByPrimaryKey(postDelegationId);
	}

	/**
	 * Returns the post delegation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param postDelegationId the primary key of the post delegation
	 * @return the post delegation, or <code>null</code> if a post delegation with the primary key could not be found
	 */
	public static PostDelegation fetchByPrimaryKey(long postDelegationId) {
		return getPersistence().fetchByPrimaryKey(postDelegationId);
	}

	/**
	 * Returns all the post delegations.
	 *
	 * @return the post delegations
	 */
	public static List<PostDelegation> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the post delegations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostDelegationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of post delegations
	 * @param end the upper bound of the range of post delegations (not inclusive)
	 * @return the range of post delegations
	 */
	public static List<PostDelegation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the post delegations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostDelegationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of post delegations
	 * @param end the upper bound of the range of post delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of post delegations
	 */
	public static List<PostDelegation> findAll(
		int start, int end,
		OrderByComparator<PostDelegation> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the post delegations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostDelegationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of post delegations
	 * @param end the upper bound of the range of post delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of post delegations
	 */
	public static List<PostDelegation> findAll(
		int start, int end, OrderByComparator<PostDelegation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the post delegations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of post delegations.
	 *
	 * @return the number of post delegations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PostDelegationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PostDelegationPersistence, PostDelegationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			PostDelegationPersistence.class);

		ServiceTracker<PostDelegationPersistence, PostDelegationPersistence>
			serviceTracker =
				new ServiceTracker
					<PostDelegationPersistence, PostDelegationPersistence>(
						bundle.getBundleContext(),
						PostDelegationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}