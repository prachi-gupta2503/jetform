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

import com.adjecti.mdm.liferay.exception.NoSuchPostOrganizationException;
import com.adjecti.mdm.liferay.model.PostOrganization;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the post organization service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PostOrganizationUtil
 * @generated
 */
@ProviderType
public interface PostOrganizationPersistence
	extends BasePersistence<PostOrganization> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PostOrganizationUtil} to access the post organization persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the post organizations where postId = &#63;.
	 *
	 * @param postId the post ID
	 * @return the matching post organizations
	 */
	public java.util.List<PostOrganization> findByPostId(long postId);

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
	public java.util.List<PostOrganization> findByPostId(
		long postId, int start, int end);

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
	public java.util.List<PostOrganization> findByPostId(
		long postId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PostOrganization>
			orderByComparator);

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
	public java.util.List<PostOrganization> findByPostId(
		long postId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PostOrganization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first post organization in the ordered set where postId = &#63;.
	 *
	 * @param postId the post ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching post organization
	 * @throws NoSuchPostOrganizationException if a matching post organization could not be found
	 */
	public PostOrganization findByPostId_First(
			long postId,
			com.liferay.portal.kernel.util.OrderByComparator<PostOrganization>
				orderByComparator)
		throws NoSuchPostOrganizationException;

	/**
	 * Returns the first post organization in the ordered set where postId = &#63;.
	 *
	 * @param postId the post ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching post organization, or <code>null</code> if a matching post organization could not be found
	 */
	public PostOrganization fetchByPostId_First(
		long postId,
		com.liferay.portal.kernel.util.OrderByComparator<PostOrganization>
			orderByComparator);

	/**
	 * Returns the last post organization in the ordered set where postId = &#63;.
	 *
	 * @param postId the post ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching post organization
	 * @throws NoSuchPostOrganizationException if a matching post organization could not be found
	 */
	public PostOrganization findByPostId_Last(
			long postId,
			com.liferay.portal.kernel.util.OrderByComparator<PostOrganization>
				orderByComparator)
		throws NoSuchPostOrganizationException;

	/**
	 * Returns the last post organization in the ordered set where postId = &#63;.
	 *
	 * @param postId the post ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching post organization, or <code>null</code> if a matching post organization could not be found
	 */
	public PostOrganization fetchByPostId_Last(
		long postId,
		com.liferay.portal.kernel.util.OrderByComparator<PostOrganization>
			orderByComparator);

	/**
	 * Returns the post organizations before and after the current post organization in the ordered set where postId = &#63;.
	 *
	 * @param postOrganizationId the primary key of the current post organization
	 * @param postId the post ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next post organization
	 * @throws NoSuchPostOrganizationException if a post organization with the primary key could not be found
	 */
	public PostOrganization[] findByPostId_PrevAndNext(
			long postOrganizationId, long postId,
			com.liferay.portal.kernel.util.OrderByComparator<PostOrganization>
				orderByComparator)
		throws NoSuchPostOrganizationException;

	/**
	 * Removes all the post organizations where postId = &#63; from the database.
	 *
	 * @param postId the post ID
	 */
	public void removeByPostId(long postId);

	/**
	 * Returns the number of post organizations where postId = &#63;.
	 *
	 * @param postId the post ID
	 * @return the number of matching post organizations
	 */
	public int countByPostId(long postId);

	/**
	 * Returns all the post organizations where postId = &#63; and organizationId = &#63;.
	 *
	 * @param postId the post ID
	 * @param organizationId the organization ID
	 * @return the matching post organizations
	 */
	public java.util.List<PostOrganization> findByPostAndOrganizationId(
		long postId, long organizationId);

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
	public java.util.List<PostOrganization> findByPostAndOrganizationId(
		long postId, long organizationId, int start, int end);

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
	public java.util.List<PostOrganization> findByPostAndOrganizationId(
		long postId, long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PostOrganization>
			orderByComparator);

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
	public java.util.List<PostOrganization> findByPostAndOrganizationId(
		long postId, long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PostOrganization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first post organization in the ordered set where postId = &#63; and organizationId = &#63;.
	 *
	 * @param postId the post ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching post organization
	 * @throws NoSuchPostOrganizationException if a matching post organization could not be found
	 */
	public PostOrganization findByPostAndOrganizationId_First(
			long postId, long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator<PostOrganization>
				orderByComparator)
		throws NoSuchPostOrganizationException;

	/**
	 * Returns the first post organization in the ordered set where postId = &#63; and organizationId = &#63;.
	 *
	 * @param postId the post ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching post organization, or <code>null</code> if a matching post organization could not be found
	 */
	public PostOrganization fetchByPostAndOrganizationId_First(
		long postId, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<PostOrganization>
			orderByComparator);

	/**
	 * Returns the last post organization in the ordered set where postId = &#63; and organizationId = &#63;.
	 *
	 * @param postId the post ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching post organization
	 * @throws NoSuchPostOrganizationException if a matching post organization could not be found
	 */
	public PostOrganization findByPostAndOrganizationId_Last(
			long postId, long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator<PostOrganization>
				orderByComparator)
		throws NoSuchPostOrganizationException;

	/**
	 * Returns the last post organization in the ordered set where postId = &#63; and organizationId = &#63;.
	 *
	 * @param postId the post ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching post organization, or <code>null</code> if a matching post organization could not be found
	 */
	public PostOrganization fetchByPostAndOrganizationId_Last(
		long postId, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<PostOrganization>
			orderByComparator);

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
	public PostOrganization[] findByPostAndOrganizationId_PrevAndNext(
			long postOrganizationId, long postId, long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator<PostOrganization>
				orderByComparator)
		throws NoSuchPostOrganizationException;

	/**
	 * Removes all the post organizations where postId = &#63; and organizationId = &#63; from the database.
	 *
	 * @param postId the post ID
	 * @param organizationId the organization ID
	 */
	public void removeByPostAndOrganizationId(long postId, long organizationId);

	/**
	 * Returns the number of post organizations where postId = &#63; and organizationId = &#63;.
	 *
	 * @param postId the post ID
	 * @param organizationId the organization ID
	 * @return the number of matching post organizations
	 */
	public int countByPostAndOrganizationId(long postId, long organizationId);

	/**
	 * Caches the post organization in the entity cache if it is enabled.
	 *
	 * @param postOrganization the post organization
	 */
	public void cacheResult(PostOrganization postOrganization);

	/**
	 * Caches the post organizations in the entity cache if it is enabled.
	 *
	 * @param postOrganizations the post organizations
	 */
	public void cacheResult(java.util.List<PostOrganization> postOrganizations);

	/**
	 * Creates a new post organization with the primary key. Does not add the post organization to the database.
	 *
	 * @param postOrganizationId the primary key for the new post organization
	 * @return the new post organization
	 */
	public PostOrganization create(long postOrganizationId);

	/**
	 * Removes the post organization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param postOrganizationId the primary key of the post organization
	 * @return the post organization that was removed
	 * @throws NoSuchPostOrganizationException if a post organization with the primary key could not be found
	 */
	public PostOrganization remove(long postOrganizationId)
		throws NoSuchPostOrganizationException;

	public PostOrganization updateImpl(PostOrganization postOrganization);

	/**
	 * Returns the post organization with the primary key or throws a <code>NoSuchPostOrganizationException</code> if it could not be found.
	 *
	 * @param postOrganizationId the primary key of the post organization
	 * @return the post organization
	 * @throws NoSuchPostOrganizationException if a post organization with the primary key could not be found
	 */
	public PostOrganization findByPrimaryKey(long postOrganizationId)
		throws NoSuchPostOrganizationException;

	/**
	 * Returns the post organization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param postOrganizationId the primary key of the post organization
	 * @return the post organization, or <code>null</code> if a post organization with the primary key could not be found
	 */
	public PostOrganization fetchByPrimaryKey(long postOrganizationId);

	/**
	 * Returns all the post organizations.
	 *
	 * @return the post organizations
	 */
	public java.util.List<PostOrganization> findAll();

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
	public java.util.List<PostOrganization> findAll(int start, int end);

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
	public java.util.List<PostOrganization> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PostOrganization>
			orderByComparator);

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
	public java.util.List<PostOrganization> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PostOrganization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the post organizations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of post organizations.
	 *
	 * @return the number of post organizations
	 */
	public int countAll();

}