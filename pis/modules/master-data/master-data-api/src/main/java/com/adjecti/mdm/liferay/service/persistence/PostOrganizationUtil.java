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

import com.adjecti.mdm.liferay.model.PostOrganization;

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
 * The persistence utility for the post organization service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.PostOrganizationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PostOrganizationPersistence
 * @generated
 */
public class PostOrganizationUtil {

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
	public static void clearCache(PostOrganization postOrganization) {
		getPersistence().clearCache(postOrganization);
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
	public static Map<Serializable, PostOrganization> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PostOrganization> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PostOrganization> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PostOrganization> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PostOrganization> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PostOrganization update(PostOrganization postOrganization) {
		return getPersistence().update(postOrganization);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PostOrganization update(
		PostOrganization postOrganization, ServiceContext serviceContext) {

		return getPersistence().update(postOrganization, serviceContext);
	}

	/**
	 * Returns all the post organizations where postId = &#63;.
	 *
	 * @param postId the post ID
	 * @return the matching post organizations
	 */
	public static List<PostOrganization> findByPostId(long postId) {
		return getPersistence().findByPostId(postId);
	}

	/**
	 * Returns a range of all the post organizations where postId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param postId the post ID
	 * @param start the lower bound of the range of post organizations
	 * @param end the upper bound of the range of post organizations (not inclusive)
	 * @return the range of matching post organizations
	 */
	public static List<PostOrganization> findByPostId(
		long postId, int start, int end) {

		return getPersistence().findByPostId(postId, start, end);
	}

	/**
	 * Returns an ordered range of all the post organizations where postId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param postId the post ID
	 * @param start the lower bound of the range of post organizations
	 * @param end the upper bound of the range of post organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching post organizations
	 */
	public static List<PostOrganization> findByPostId(
		long postId, int start, int end,
		OrderByComparator<PostOrganization> orderByComparator) {

		return getPersistence().findByPostId(
			postId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the post organizations where postId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param postId the post ID
	 * @param start the lower bound of the range of post organizations
	 * @param end the upper bound of the range of post organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching post organizations
	 */
	public static List<PostOrganization> findByPostId(
		long postId, int start, int end,
		OrderByComparator<PostOrganization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPostId(
			postId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first post organization in the ordered set where postId = &#63;.
	 *
	 * @param postId the post ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching post organization
	 * @throws NoSuchPostOrganizationException if a matching post organization could not be found
	 */
	public static PostOrganization findByPostId_First(
			long postId, OrderByComparator<PostOrganization> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchPostOrganizationException {

		return getPersistence().findByPostId_First(postId, orderByComparator);
	}

	/**
	 * Returns the first post organization in the ordered set where postId = &#63;.
	 *
	 * @param postId the post ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching post organization, or <code>null</code> if a matching post organization could not be found
	 */
	public static PostOrganization fetchByPostId_First(
		long postId, OrderByComparator<PostOrganization> orderByComparator) {

		return getPersistence().fetchByPostId_First(postId, orderByComparator);
	}

	/**
	 * Returns the last post organization in the ordered set where postId = &#63;.
	 *
	 * @param postId the post ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching post organization
	 * @throws NoSuchPostOrganizationException if a matching post organization could not be found
	 */
	public static PostOrganization findByPostId_Last(
			long postId, OrderByComparator<PostOrganization> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchPostOrganizationException {

		return getPersistence().findByPostId_Last(postId, orderByComparator);
	}

	/**
	 * Returns the last post organization in the ordered set where postId = &#63;.
	 *
	 * @param postId the post ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching post organization, or <code>null</code> if a matching post organization could not be found
	 */
	public static PostOrganization fetchByPostId_Last(
		long postId, OrderByComparator<PostOrganization> orderByComparator) {

		return getPersistence().fetchByPostId_Last(postId, orderByComparator);
	}

	/**
	 * Returns the post organizations before and after the current post organization in the ordered set where postId = &#63;.
	 *
	 * @param postOrganizationId the primary key of the current post organization
	 * @param postId the post ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next post organization
	 * @throws NoSuchPostOrganizationException if a post organization with the primary key could not be found
	 */
	public static PostOrganization[] findByPostId_PrevAndNext(
			long postOrganizationId, long postId,
			OrderByComparator<PostOrganization> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchPostOrganizationException {

		return getPersistence().findByPostId_PrevAndNext(
			postOrganizationId, postId, orderByComparator);
	}

	/**
	 * Removes all the post organizations where postId = &#63; from the database.
	 *
	 * @param postId the post ID
	 */
	public static void removeByPostId(long postId) {
		getPersistence().removeByPostId(postId);
	}

	/**
	 * Returns the number of post organizations where postId = &#63;.
	 *
	 * @param postId the post ID
	 * @return the number of matching post organizations
	 */
	public static int countByPostId(long postId) {
		return getPersistence().countByPostId(postId);
	}

	/**
	 * Returns all the post organizations where postId = &#63; and organizationId = &#63;.
	 *
	 * @param postId the post ID
	 * @param organizationId the organization ID
	 * @return the matching post organizations
	 */
	public static List<PostOrganization> findByPostAndOrganizationId(
		long postId, long organizationId) {

		return getPersistence().findByPostAndOrganizationId(
			postId, organizationId);
	}

	/**
	 * Returns a range of all the post organizations where postId = &#63; and organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param postId the post ID
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of post organizations
	 * @param end the upper bound of the range of post organizations (not inclusive)
	 * @return the range of matching post organizations
	 */
	public static List<PostOrganization> findByPostAndOrganizationId(
		long postId, long organizationId, int start, int end) {

		return getPersistence().findByPostAndOrganizationId(
			postId, organizationId, start, end);
	}

	/**
	 * Returns an ordered range of all the post organizations where postId = &#63; and organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param postId the post ID
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of post organizations
	 * @param end the upper bound of the range of post organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching post organizations
	 */
	public static List<PostOrganization> findByPostAndOrganizationId(
		long postId, long organizationId, int start, int end,
		OrderByComparator<PostOrganization> orderByComparator) {

		return getPersistence().findByPostAndOrganizationId(
			postId, organizationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the post organizations where postId = &#63; and organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param postId the post ID
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of post organizations
	 * @param end the upper bound of the range of post organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching post organizations
	 */
	public static List<PostOrganization> findByPostAndOrganizationId(
		long postId, long organizationId, int start, int end,
		OrderByComparator<PostOrganization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPostAndOrganizationId(
			postId, organizationId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first post organization in the ordered set where postId = &#63; and organizationId = &#63;.
	 *
	 * @param postId the post ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching post organization
	 * @throws NoSuchPostOrganizationException if a matching post organization could not be found
	 */
	public static PostOrganization findByPostAndOrganizationId_First(
			long postId, long organizationId,
			OrderByComparator<PostOrganization> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchPostOrganizationException {

		return getPersistence().findByPostAndOrganizationId_First(
			postId, organizationId, orderByComparator);
	}

	/**
	 * Returns the first post organization in the ordered set where postId = &#63; and organizationId = &#63;.
	 *
	 * @param postId the post ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching post organization, or <code>null</code> if a matching post organization could not be found
	 */
	public static PostOrganization fetchByPostAndOrganizationId_First(
		long postId, long organizationId,
		OrderByComparator<PostOrganization> orderByComparator) {

		return getPersistence().fetchByPostAndOrganizationId_First(
			postId, organizationId, orderByComparator);
	}

	/**
	 * Returns the last post organization in the ordered set where postId = &#63; and organizationId = &#63;.
	 *
	 * @param postId the post ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching post organization
	 * @throws NoSuchPostOrganizationException if a matching post organization could not be found
	 */
	public static PostOrganization findByPostAndOrganizationId_Last(
			long postId, long organizationId,
			OrderByComparator<PostOrganization> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchPostOrganizationException {

		return getPersistence().findByPostAndOrganizationId_Last(
			postId, organizationId, orderByComparator);
	}

	/**
	 * Returns the last post organization in the ordered set where postId = &#63; and organizationId = &#63;.
	 *
	 * @param postId the post ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching post organization, or <code>null</code> if a matching post organization could not be found
	 */
	public static PostOrganization fetchByPostAndOrganizationId_Last(
		long postId, long organizationId,
		OrderByComparator<PostOrganization> orderByComparator) {

		return getPersistence().fetchByPostAndOrganizationId_Last(
			postId, organizationId, orderByComparator);
	}

	/**
	 * Returns the post organizations before and after the current post organization in the ordered set where postId = &#63; and organizationId = &#63;.
	 *
	 * @param postOrganizationId the primary key of the current post organization
	 * @param postId the post ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next post organization
	 * @throws NoSuchPostOrganizationException if a post organization with the primary key could not be found
	 */
	public static PostOrganization[] findByPostAndOrganizationId_PrevAndNext(
			long postOrganizationId, long postId, long organizationId,
			OrderByComparator<PostOrganization> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchPostOrganizationException {

		return getPersistence().findByPostAndOrganizationId_PrevAndNext(
			postOrganizationId, postId, organizationId, orderByComparator);
	}

	/**
	 * Removes all the post organizations where postId = &#63; and organizationId = &#63; from the database.
	 *
	 * @param postId the post ID
	 * @param organizationId the organization ID
	 */
	public static void removeByPostAndOrganizationId(
		long postId, long organizationId) {

		getPersistence().removeByPostAndOrganizationId(postId, organizationId);
	}

	/**
	 * Returns the number of post organizations where postId = &#63; and organizationId = &#63;.
	 *
	 * @param postId the post ID
	 * @param organizationId the organization ID
	 * @return the number of matching post organizations
	 */
	public static int countByPostAndOrganizationId(
		long postId, long organizationId) {

		return getPersistence().countByPostAndOrganizationId(
			postId, organizationId);
	}

	/**
	 * Caches the post organization in the entity cache if it is enabled.
	 *
	 * @param postOrganization the post organization
	 */
	public static void cacheResult(PostOrganization postOrganization) {
		getPersistence().cacheResult(postOrganization);
	}

	/**
	 * Caches the post organizations in the entity cache if it is enabled.
	 *
	 * @param postOrganizations the post organizations
	 */
	public static void cacheResult(List<PostOrganization> postOrganizations) {
		getPersistence().cacheResult(postOrganizations);
	}

	/**
	 * Creates a new post organization with the primary key. Does not add the post organization to the database.
	 *
	 * @param postOrganizationId the primary key for the new post organization
	 * @return the new post organization
	 */
	public static PostOrganization create(long postOrganizationId) {
		return getPersistence().create(postOrganizationId);
	}

	/**
	 * Removes the post organization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param postOrganizationId the primary key of the post organization
	 * @return the post organization that was removed
	 * @throws NoSuchPostOrganizationException if a post organization with the primary key could not be found
	 */
	public static PostOrganization remove(long postOrganizationId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchPostOrganizationException {

		return getPersistence().remove(postOrganizationId);
	}

	public static PostOrganization updateImpl(
		PostOrganization postOrganization) {

		return getPersistence().updateImpl(postOrganization);
	}

	/**
	 * Returns the post organization with the primary key or throws a <code>NoSuchPostOrganizationException</code> if it could not be found.
	 *
	 * @param postOrganizationId the primary key of the post organization
	 * @return the post organization
	 * @throws NoSuchPostOrganizationException if a post organization with the primary key could not be found
	 */
	public static PostOrganization findByPrimaryKey(long postOrganizationId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchPostOrganizationException {

		return getPersistence().findByPrimaryKey(postOrganizationId);
	}

	/**
	 * Returns the post organization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param postOrganizationId the primary key of the post organization
	 * @return the post organization, or <code>null</code> if a post organization with the primary key could not be found
	 */
	public static PostOrganization fetchByPrimaryKey(long postOrganizationId) {
		return getPersistence().fetchByPrimaryKey(postOrganizationId);
	}

	/**
	 * Returns all the post organizations.
	 *
	 * @return the post organizations
	 */
	public static List<PostOrganization> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the post organizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of post organizations
	 * @param end the upper bound of the range of post organizations (not inclusive)
	 * @return the range of post organizations
	 */
	public static List<PostOrganization> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the post organizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of post organizations
	 * @param end the upper bound of the range of post organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of post organizations
	 */
	public static List<PostOrganization> findAll(
		int start, int end,
		OrderByComparator<PostOrganization> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the post organizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of post organizations
	 * @param end the upper bound of the range of post organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of post organizations
	 */
	public static List<PostOrganization> findAll(
		int start, int end,
		OrderByComparator<PostOrganization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the post organizations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of post organizations.
	 *
	 * @return the number of post organizations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PostOrganizationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PostOrganizationPersistence, PostOrganizationPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			PostOrganizationPersistence.class);

		ServiceTracker<PostOrganizationPersistence, PostOrganizationPersistence>
			serviceTracker =
				new ServiceTracker
					<PostOrganizationPersistence, PostOrganizationPersistence>(
						bundle.getBundleContext(),
						PostOrganizationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}