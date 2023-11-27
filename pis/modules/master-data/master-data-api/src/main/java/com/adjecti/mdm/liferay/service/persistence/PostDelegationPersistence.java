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

import com.adjecti.mdm.liferay.exception.NoSuchPostDelegationException;
import com.adjecti.mdm.liferay.model.PostDelegation;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the post delegation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PostDelegationUtil
 * @generated
 */
@ProviderType
public interface PostDelegationPersistence
	extends BasePersistence<PostDelegation> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PostDelegationUtil} to access the post delegation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the post delegation in the entity cache if it is enabled.
	 *
	 * @param postDelegation the post delegation
	 */
	public void cacheResult(PostDelegation postDelegation);

	/**
	 * Caches the post delegations in the entity cache if it is enabled.
	 *
	 * @param postDelegations the post delegations
	 */
	public void cacheResult(java.util.List<PostDelegation> postDelegations);

	/**
	 * Creates a new post delegation with the primary key. Does not add the post delegation to the database.
	 *
	 * @param postDelegationId the primary key for the new post delegation
	 * @return the new post delegation
	 */
	public PostDelegation create(long postDelegationId);

	/**
	 * Removes the post delegation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param postDelegationId the primary key of the post delegation
	 * @return the post delegation that was removed
	 * @throws NoSuchPostDelegationException if a post delegation with the primary key could not be found
	 */
	public PostDelegation remove(long postDelegationId)
		throws NoSuchPostDelegationException;

	public PostDelegation updateImpl(PostDelegation postDelegation);

	/**
	 * Returns the post delegation with the primary key or throws a <code>NoSuchPostDelegationException</code> if it could not be found.
	 *
	 * @param postDelegationId the primary key of the post delegation
	 * @return the post delegation
	 * @throws NoSuchPostDelegationException if a post delegation with the primary key could not be found
	 */
	public PostDelegation findByPrimaryKey(long postDelegationId)
		throws NoSuchPostDelegationException;

	/**
	 * Returns the post delegation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param postDelegationId the primary key of the post delegation
	 * @return the post delegation, or <code>null</code> if a post delegation with the primary key could not be found
	 */
	public PostDelegation fetchByPrimaryKey(long postDelegationId);

	/**
	 * Returns all the post delegations.
	 *
	 * @return the post delegations
	 */
	public java.util.List<PostDelegation> findAll();

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
	public java.util.List<PostDelegation> findAll(int start, int end);

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
	public java.util.List<PostDelegation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PostDelegation>
			orderByComparator);

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
	public java.util.List<PostDelegation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PostDelegation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the post delegations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of post delegations.
	 *
	 * @return the number of post delegations
	 */
	public int countAll();

}