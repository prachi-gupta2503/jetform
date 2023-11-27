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

package com.adjecti.pis.liferay.service.persistence;

import com.adjecti.pis.liferay.model.EmployeePost;

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
 * The persistence utility for the employee post service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.EmployeePostPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeePostPersistence
 * @generated
 */
public class EmployeePostUtil {

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
	public static void clearCache(EmployeePost employeePost) {
		getPersistence().clearCache(employeePost);
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
	public static Map<Serializable, EmployeePost> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeePost> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeePost> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeePost> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeePost> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeePost update(EmployeePost employeePost) {
		return getPersistence().update(employeePost);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeePost update(
		EmployeePost employeePost, ServiceContext serviceContext) {

		return getPersistence().update(employeePost, serviceContext);
	}

	/**
	 * Returns all the employee posts where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee posts
	 */
	public static List<EmployeePost> findByEmployeeId(long employeeId) {
		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns a range of all the employee posts where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePostModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee posts
	 * @param end the upper bound of the range of employee posts (not inclusive)
	 * @return the range of matching employee posts
	 */
	public static List<EmployeePost> findByEmployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee posts where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePostModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee posts
	 * @param end the upper bound of the range of employee posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee posts
	 */
	public static List<EmployeePost> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeePost> orderByComparator) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee posts where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePostModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee posts
	 * @param end the upper bound of the range of employee posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee posts
	 */
	public static List<EmployeePost> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeePost> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee post in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee post
	 * @throws NoSuchEmployeePostException if a matching employee post could not be found
	 */
	public static EmployeePost findByEmployeeId_First(
			long employeeId, OrderByComparator<EmployeePost> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeePostException {

		return getPersistence().findByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first employee post in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee post, or <code>null</code> if a matching employee post could not be found
	 */
	public static EmployeePost fetchByEmployeeId_First(
		long employeeId, OrderByComparator<EmployeePost> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee post in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee post
	 * @throws NoSuchEmployeePostException if a matching employee post could not be found
	 */
	public static EmployeePost findByEmployeeId_Last(
			long employeeId, OrderByComparator<EmployeePost> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeePostException {

		return getPersistence().findByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee post in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee post, or <code>null</code> if a matching employee post could not be found
	 */
	public static EmployeePost fetchByEmployeeId_Last(
		long employeeId, OrderByComparator<EmployeePost> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the employee posts before and after the current employee post in the ordered set where employeeId = &#63;.
	 *
	 * @param employeePostId the primary key of the current employee post
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee post
	 * @throws NoSuchEmployeePostException if a employee post with the primary key could not be found
	 */
	public static EmployeePost[] findByEmployeeId_PrevAndNext(
			long employeePostId, long employeeId,
			OrderByComparator<EmployeePost> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeePostException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			employeePostId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the employee posts where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of employee posts where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee posts
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Caches the employee post in the entity cache if it is enabled.
	 *
	 * @param employeePost the employee post
	 */
	public static void cacheResult(EmployeePost employeePost) {
		getPersistence().cacheResult(employeePost);
	}

	/**
	 * Caches the employee posts in the entity cache if it is enabled.
	 *
	 * @param employeePosts the employee posts
	 */
	public static void cacheResult(List<EmployeePost> employeePosts) {
		getPersistence().cacheResult(employeePosts);
	}

	/**
	 * Creates a new employee post with the primary key. Does not add the employee post to the database.
	 *
	 * @param employeePostId the primary key for the new employee post
	 * @return the new employee post
	 */
	public static EmployeePost create(long employeePostId) {
		return getPersistence().create(employeePostId);
	}

	/**
	 * Removes the employee post with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeePostId the primary key of the employee post
	 * @return the employee post that was removed
	 * @throws NoSuchEmployeePostException if a employee post with the primary key could not be found
	 */
	public static EmployeePost remove(long employeePostId)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeePostException {

		return getPersistence().remove(employeePostId);
	}

	public static EmployeePost updateImpl(EmployeePost employeePost) {
		return getPersistence().updateImpl(employeePost);
	}

	/**
	 * Returns the employee post with the primary key or throws a <code>NoSuchEmployeePostException</code> if it could not be found.
	 *
	 * @param employeePostId the primary key of the employee post
	 * @return the employee post
	 * @throws NoSuchEmployeePostException if a employee post with the primary key could not be found
	 */
	public static EmployeePost findByPrimaryKey(long employeePostId)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeePostException {

		return getPersistence().findByPrimaryKey(employeePostId);
	}

	/**
	 * Returns the employee post with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeePostId the primary key of the employee post
	 * @return the employee post, or <code>null</code> if a employee post with the primary key could not be found
	 */
	public static EmployeePost fetchByPrimaryKey(long employeePostId) {
		return getPersistence().fetchByPrimaryKey(employeePostId);
	}

	/**
	 * Returns all the employee posts.
	 *
	 * @return the employee posts
	 */
	public static List<EmployeePost> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employee posts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePostModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee posts
	 * @param end the upper bound of the range of employee posts (not inclusive)
	 * @return the range of employee posts
	 */
	public static List<EmployeePost> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employee posts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePostModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee posts
	 * @param end the upper bound of the range of employee posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee posts
	 */
	public static List<EmployeePost> findAll(
		int start, int end, OrderByComparator<EmployeePost> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee posts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePostModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee posts
	 * @param end the upper bound of the range of employee posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee posts
	 */
	public static List<EmployeePost> findAll(
		int start, int end, OrderByComparator<EmployeePost> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee posts from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee posts.
	 *
	 * @return the number of employee posts
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeePostPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeePostPersistence, EmployeePostPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EmployeePostPersistence.class);

		ServiceTracker<EmployeePostPersistence, EmployeePostPersistence>
			serviceTracker =
				new ServiceTracker
					<EmployeePostPersistence, EmployeePostPersistence>(
						bundle.getBundleContext(),
						EmployeePostPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}