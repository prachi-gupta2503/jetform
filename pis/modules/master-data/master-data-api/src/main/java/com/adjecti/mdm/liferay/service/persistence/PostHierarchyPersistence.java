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

import com.adjecti.mdm.liferay.exception.NoSuchPostHierarchyException;
import com.adjecti.mdm.liferay.model.PostHierarchy;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the post hierarchy service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PostHierarchyUtil
 * @generated
 */
@ProviderType
public interface PostHierarchyPersistence
	extends BasePersistence<PostHierarchy> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PostHierarchyUtil} to access the post hierarchy persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the post hierarchy in the entity cache if it is enabled.
	 *
	 * @param postHierarchy the post hierarchy
	 */
	public void cacheResult(PostHierarchy postHierarchy);

	/**
	 * Caches the post hierarchies in the entity cache if it is enabled.
	 *
	 * @param postHierarchies the post hierarchies
	 */
	public void cacheResult(java.util.List<PostHierarchy> postHierarchies);

	/**
	 * Creates a new post hierarchy with the primary key. Does not add the post hierarchy to the database.
	 *
	 * @param postHierarchyId the primary key for the new post hierarchy
	 * @return the new post hierarchy
	 */
	public PostHierarchy create(long postHierarchyId);

	/**
	 * Removes the post hierarchy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param postHierarchyId the primary key of the post hierarchy
	 * @return the post hierarchy that was removed
	 * @throws NoSuchPostHierarchyException if a post hierarchy with the primary key could not be found
	 */
	public PostHierarchy remove(long postHierarchyId)
		throws NoSuchPostHierarchyException;

	public PostHierarchy updateImpl(PostHierarchy postHierarchy);

	/**
	 * Returns the post hierarchy with the primary key or throws a <code>NoSuchPostHierarchyException</code> if it could not be found.
	 *
	 * @param postHierarchyId the primary key of the post hierarchy
	 * @return the post hierarchy
	 * @throws NoSuchPostHierarchyException if a post hierarchy with the primary key could not be found
	 */
	public PostHierarchy findByPrimaryKey(long postHierarchyId)
		throws NoSuchPostHierarchyException;

	/**
	 * Returns the post hierarchy with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param postHierarchyId the primary key of the post hierarchy
	 * @return the post hierarchy, or <code>null</code> if a post hierarchy with the primary key could not be found
	 */
	public PostHierarchy fetchByPrimaryKey(long postHierarchyId);

	/**
	 * Returns all the post hierarchies.
	 *
	 * @return the post hierarchies
	 */
	public java.util.List<PostHierarchy> findAll();

	/**
	 * Returns a range of all the post hierarchies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostHierarchyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of post hierarchies
	 * @param end the upper bound of the range of post hierarchies (not inclusive)
	 * @return the range of post hierarchies
	 */
	public java.util.List<PostHierarchy> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the post hierarchies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostHierarchyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of post hierarchies
	 * @param end the upper bound of the range of post hierarchies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of post hierarchies
	 */
	public java.util.List<PostHierarchy> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PostHierarchy>
			orderByComparator);

	/**
	 * Returns an ordered range of all the post hierarchies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostHierarchyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of post hierarchies
	 * @param end the upper bound of the range of post hierarchies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of post hierarchies
	 */
	public java.util.List<PostHierarchy> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PostHierarchy>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the post hierarchies from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of post hierarchies.
	 *
	 * @return the number of post hierarchies
	 */
	public int countAll();

}