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

import com.adjecti.mdm.liferay.exception.NoSuchAppellationException;
import com.adjecti.mdm.liferay.model.Appellation;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the appellation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AppellationUtil
 * @generated
 */
@ProviderType
public interface AppellationPersistence extends BasePersistence<Appellation> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AppellationUtil} to access the appellation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the appellation in the entity cache if it is enabled.
	 *
	 * @param appellation the appellation
	 */
	public void cacheResult(Appellation appellation);

	/**
	 * Caches the appellations in the entity cache if it is enabled.
	 *
	 * @param appellations the appellations
	 */
	public void cacheResult(java.util.List<Appellation> appellations);

	/**
	 * Creates a new appellation with the primary key. Does not add the appellation to the database.
	 *
	 * @param appellationId the primary key for the new appellation
	 * @return the new appellation
	 */
	public Appellation create(long appellationId);

	/**
	 * Removes the appellation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appellationId the primary key of the appellation
	 * @return the appellation that was removed
	 * @throws NoSuchAppellationException if a appellation with the primary key could not be found
	 */
	public Appellation remove(long appellationId)
		throws NoSuchAppellationException;

	public Appellation updateImpl(Appellation appellation);

	/**
	 * Returns the appellation with the primary key or throws a <code>NoSuchAppellationException</code> if it could not be found.
	 *
	 * @param appellationId the primary key of the appellation
	 * @return the appellation
	 * @throws NoSuchAppellationException if a appellation with the primary key could not be found
	 */
	public Appellation findByPrimaryKey(long appellationId)
		throws NoSuchAppellationException;

	/**
	 * Returns the appellation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appellationId the primary key of the appellation
	 * @return the appellation, or <code>null</code> if a appellation with the primary key could not be found
	 */
	public Appellation fetchByPrimaryKey(long appellationId);

	/**
	 * Returns all the appellations.
	 *
	 * @return the appellations
	 */
	public java.util.List<Appellation> findAll();

	/**
	 * Returns a range of all the appellations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppellationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appellations
	 * @param end the upper bound of the range of appellations (not inclusive)
	 * @return the range of appellations
	 */
	public java.util.List<Appellation> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the appellations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppellationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appellations
	 * @param end the upper bound of the range of appellations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of appellations
	 */
	public java.util.List<Appellation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Appellation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the appellations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AppellationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appellations
	 * @param end the upper bound of the range of appellations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of appellations
	 */
	public java.util.List<Appellation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Appellation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the appellations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of appellations.
	 *
	 * @return the number of appellations
	 */
	public int countAll();

}