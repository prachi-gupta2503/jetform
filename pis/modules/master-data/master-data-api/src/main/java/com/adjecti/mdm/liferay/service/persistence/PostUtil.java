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

import com.adjecti.mdm.liferay.model.Post;

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
 * The persistence utility for the post service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.PostPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PostPersistence
 * @generated
 */
public class PostUtil {

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
	public static void clearCache(Post post) {
		getPersistence().clearCache(post);
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
	public static Map<Serializable, Post> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Post> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Post> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Post> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Post> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Post update(Post post) {
		return getPersistence().update(post);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Post update(Post post, ServiceContext serviceContext) {
		return getPersistence().update(post, serviceContext);
	}

	/**
	 * Returns all the posts where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching posts
	 */
	public static List<Post> findByCode(String code) {
		return getPersistence().findByCode(code);
	}

	/**
	 * Returns a range of all the posts where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of posts
	 * @param end the upper bound of the range of posts (not inclusive)
	 * @return the range of matching posts
	 */
	public static List<Post> findByCode(String code, int start, int end) {
		return getPersistence().findByCode(code, start, end);
	}

	/**
	 * Returns an ordered range of all the posts where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of posts
	 * @param end the upper bound of the range of posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching posts
	 */
	public static List<Post> findByCode(
		String code, int start, int end,
		OrderByComparator<Post> orderByComparator) {

		return getPersistence().findByCode(code, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the posts where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of posts
	 * @param end the upper bound of the range of posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching posts
	 */
	public static List<Post> findByCode(
		String code, int start, int end,
		OrderByComparator<Post> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCode(
			code, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first post in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching post
	 * @throws NoSuchPostException if a matching post could not be found
	 */
	public static Post findByCode_First(
			String code, OrderByComparator<Post> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchPostException {

		return getPersistence().findByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the first post in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching post, or <code>null</code> if a matching post could not be found
	 */
	public static Post fetchByCode_First(
		String code, OrderByComparator<Post> orderByComparator) {

		return getPersistence().fetchByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the last post in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching post
	 * @throws NoSuchPostException if a matching post could not be found
	 */
	public static Post findByCode_Last(
			String code, OrderByComparator<Post> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchPostException {

		return getPersistence().findByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the last post in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching post, or <code>null</code> if a matching post could not be found
	 */
	public static Post fetchByCode_Last(
		String code, OrderByComparator<Post> orderByComparator) {

		return getPersistence().fetchByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the posts before and after the current post in the ordered set where code = &#63;.
	 *
	 * @param postId the primary key of the current post
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next post
	 * @throws NoSuchPostException if a post with the primary key could not be found
	 */
	public static Post[] findByCode_PrevAndNext(
			long postId, String code, OrderByComparator<Post> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchPostException {

		return getPersistence().findByCode_PrevAndNext(
			postId, code, orderByComparator);
	}

	/**
	 * Removes all the posts where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public static void removeByCode(String code) {
		getPersistence().removeByCode(code);
	}

	/**
	 * Returns the number of posts where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching posts
	 */
	public static int countByCode(String code) {
		return getPersistence().countByCode(code);
	}

	/**
	 * Returns all the posts where name_En = &#63;.
	 *
	 * @param name_En the name_ en
	 * @return the matching posts
	 */
	public static List<Post> findByName(String name_En) {
		return getPersistence().findByName(name_En);
	}

	/**
	 * Returns a range of all the posts where name_En = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostModelImpl</code>.
	 * </p>
	 *
	 * @param name_En the name_ en
	 * @param start the lower bound of the range of posts
	 * @param end the upper bound of the range of posts (not inclusive)
	 * @return the range of matching posts
	 */
	public static List<Post> findByName(String name_En, int start, int end) {
		return getPersistence().findByName(name_En, start, end);
	}

	/**
	 * Returns an ordered range of all the posts where name_En = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostModelImpl</code>.
	 * </p>
	 *
	 * @param name_En the name_ en
	 * @param start the lower bound of the range of posts
	 * @param end the upper bound of the range of posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching posts
	 */
	public static List<Post> findByName(
		String name_En, int start, int end,
		OrderByComparator<Post> orderByComparator) {

		return getPersistence().findByName(
			name_En, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the posts where name_En = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostModelImpl</code>.
	 * </p>
	 *
	 * @param name_En the name_ en
	 * @param start the lower bound of the range of posts
	 * @param end the upper bound of the range of posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching posts
	 */
	public static List<Post> findByName(
		String name_En, int start, int end,
		OrderByComparator<Post> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByName(
			name_En, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first post in the ordered set where name_En = &#63;.
	 *
	 * @param name_En the name_ en
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching post
	 * @throws NoSuchPostException if a matching post could not be found
	 */
	public static Post findByName_First(
			String name_En, OrderByComparator<Post> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchPostException {

		return getPersistence().findByName_First(name_En, orderByComparator);
	}

	/**
	 * Returns the first post in the ordered set where name_En = &#63;.
	 *
	 * @param name_En the name_ en
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching post, or <code>null</code> if a matching post could not be found
	 */
	public static Post fetchByName_First(
		String name_En, OrderByComparator<Post> orderByComparator) {

		return getPersistence().fetchByName_First(name_En, orderByComparator);
	}

	/**
	 * Returns the last post in the ordered set where name_En = &#63;.
	 *
	 * @param name_En the name_ en
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching post
	 * @throws NoSuchPostException if a matching post could not be found
	 */
	public static Post findByName_Last(
			String name_En, OrderByComparator<Post> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchPostException {

		return getPersistence().findByName_Last(name_En, orderByComparator);
	}

	/**
	 * Returns the last post in the ordered set where name_En = &#63;.
	 *
	 * @param name_En the name_ en
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching post, or <code>null</code> if a matching post could not be found
	 */
	public static Post fetchByName_Last(
		String name_En, OrderByComparator<Post> orderByComparator) {

		return getPersistence().fetchByName_Last(name_En, orderByComparator);
	}

	/**
	 * Returns the posts before and after the current post in the ordered set where name_En = &#63;.
	 *
	 * @param postId the primary key of the current post
	 * @param name_En the name_ en
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next post
	 * @throws NoSuchPostException if a post with the primary key could not be found
	 */
	public static Post[] findByName_PrevAndNext(
			long postId, String name_En,
			OrderByComparator<Post> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchPostException {

		return getPersistence().findByName_PrevAndNext(
			postId, name_En, orderByComparator);
	}

	/**
	 * Removes all the posts where name_En = &#63; from the database.
	 *
	 * @param name_En the name_ en
	 */
	public static void removeByName(String name_En) {
		getPersistence().removeByName(name_En);
	}

	/**
	 * Returns the number of posts where name_En = &#63;.
	 *
	 * @param name_En the name_ en
	 * @return the number of matching posts
	 */
	public static int countByName(String name_En) {
		return getPersistence().countByName(name_En);
	}

	/**
	 * Caches the post in the entity cache if it is enabled.
	 *
	 * @param post the post
	 */
	public static void cacheResult(Post post) {
		getPersistence().cacheResult(post);
	}

	/**
	 * Caches the posts in the entity cache if it is enabled.
	 *
	 * @param posts the posts
	 */
	public static void cacheResult(List<Post> posts) {
		getPersistence().cacheResult(posts);
	}

	/**
	 * Creates a new post with the primary key. Does not add the post to the database.
	 *
	 * @param postId the primary key for the new post
	 * @return the new post
	 */
	public static Post create(long postId) {
		return getPersistence().create(postId);
	}

	/**
	 * Removes the post with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param postId the primary key of the post
	 * @return the post that was removed
	 * @throws NoSuchPostException if a post with the primary key could not be found
	 */
	public static Post remove(long postId)
		throws com.adjecti.mdm.liferay.exception.NoSuchPostException {

		return getPersistence().remove(postId);
	}

	public static Post updateImpl(Post post) {
		return getPersistence().updateImpl(post);
	}

	/**
	 * Returns the post with the primary key or throws a <code>NoSuchPostException</code> if it could not be found.
	 *
	 * @param postId the primary key of the post
	 * @return the post
	 * @throws NoSuchPostException if a post with the primary key could not be found
	 */
	public static Post findByPrimaryKey(long postId)
		throws com.adjecti.mdm.liferay.exception.NoSuchPostException {

		return getPersistence().findByPrimaryKey(postId);
	}

	/**
	 * Returns the post with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param postId the primary key of the post
	 * @return the post, or <code>null</code> if a post with the primary key could not be found
	 */
	public static Post fetchByPrimaryKey(long postId) {
		return getPersistence().fetchByPrimaryKey(postId);
	}

	/**
	 * Returns all the posts.
	 *
	 * @return the posts
	 */
	public static List<Post> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the posts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of posts
	 * @param end the upper bound of the range of posts (not inclusive)
	 * @return the range of posts
	 */
	public static List<Post> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the posts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of posts
	 * @param end the upper bound of the range of posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of posts
	 */
	public static List<Post> findAll(
		int start, int end, OrderByComparator<Post> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the posts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of posts
	 * @param end the upper bound of the range of posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of posts
	 */
	public static List<Post> findAll(
		int start, int end, OrderByComparator<Post> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the posts from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of posts.
	 *
	 * @return the number of posts
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PostPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PostPersistence, PostPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PostPersistence.class);

		ServiceTracker<PostPersistence, PostPersistence> serviceTracker =
			new ServiceTracker<PostPersistence, PostPersistence>(
				bundle.getBundleContext(), PostPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}