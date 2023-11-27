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

import com.adjecti.mdm.liferay.exception.NoSuchPostReportingException;
import com.adjecti.mdm.liferay.model.PostReporting;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the post reporting service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PostReportingUtil
 * @generated
 */
@ProviderType
public interface PostReportingPersistence
	extends BasePersistence<PostReporting> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PostReportingUtil} to access the post reporting persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the post reporting in the entity cache if it is enabled.
	 *
	 * @param postReporting the post reporting
	 */
	public void cacheResult(PostReporting postReporting);

	/**
	 * Caches the post reportings in the entity cache if it is enabled.
	 *
	 * @param postReportings the post reportings
	 */
	public void cacheResult(java.util.List<PostReporting> postReportings);

	/**
	 * Creates a new post reporting with the primary key. Does not add the post reporting to the database.
	 *
	 * @param postReportingId the primary key for the new post reporting
	 * @return the new post reporting
	 */
	public PostReporting create(long postReportingId);

	/**
	 * Removes the post reporting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param postReportingId the primary key of the post reporting
	 * @return the post reporting that was removed
	 * @throws NoSuchPostReportingException if a post reporting with the primary key could not be found
	 */
	public PostReporting remove(long postReportingId)
		throws NoSuchPostReportingException;

	public PostReporting updateImpl(PostReporting postReporting);

	/**
	 * Returns the post reporting with the primary key or throws a <code>NoSuchPostReportingException</code> if it could not be found.
	 *
	 * @param postReportingId the primary key of the post reporting
	 * @return the post reporting
	 * @throws NoSuchPostReportingException if a post reporting with the primary key could not be found
	 */
	public PostReporting findByPrimaryKey(long postReportingId)
		throws NoSuchPostReportingException;

	/**
	 * Returns the post reporting with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param postReportingId the primary key of the post reporting
	 * @return the post reporting, or <code>null</code> if a post reporting with the primary key could not be found
	 */
	public PostReporting fetchByPrimaryKey(long postReportingId);

	/**
	 * Returns all the post reportings.
	 *
	 * @return the post reportings
	 */
	public java.util.List<PostReporting> findAll();

	/**
	 * Returns a range of all the post reportings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostReportingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of post reportings
	 * @param end the upper bound of the range of post reportings (not inclusive)
	 * @return the range of post reportings
	 */
	public java.util.List<PostReporting> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the post reportings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostReportingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of post reportings
	 * @param end the upper bound of the range of post reportings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of post reportings
	 */
	public java.util.List<PostReporting> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PostReporting>
			orderByComparator);

	/**
	 * Returns an ordered range of all the post reportings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PostReportingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of post reportings
	 * @param end the upper bound of the range of post reportings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of post reportings
	 */
	public java.util.List<PostReporting> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PostReporting>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the post reportings from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of post reportings.
	 *
	 * @return the number of post reportings
	 */
	public int countAll();

}