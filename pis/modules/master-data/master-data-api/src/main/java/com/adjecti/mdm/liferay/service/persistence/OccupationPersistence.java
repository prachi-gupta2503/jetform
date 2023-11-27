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

import com.adjecti.mdm.liferay.exception.NoSuchOccupationException;
import com.adjecti.mdm.liferay.model.Occupation;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the occupation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OccupationUtil
 * @generated
 */
@ProviderType
public interface OccupationPersistence extends BasePersistence<Occupation> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OccupationUtil} to access the occupation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the occupation in the entity cache if it is enabled.
	 *
	 * @param occupation the occupation
	 */
	public void cacheResult(Occupation occupation);

	/**
	 * Caches the occupations in the entity cache if it is enabled.
	 *
	 * @param occupations the occupations
	 */
	public void cacheResult(java.util.List<Occupation> occupations);

	/**
	 * Creates a new occupation with the primary key. Does not add the occupation to the database.
	 *
	 * @param occupationId the primary key for the new occupation
	 * @return the new occupation
	 */
	public Occupation create(long occupationId);

	/**
	 * Removes the occupation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param occupationId the primary key of the occupation
	 * @return the occupation that was removed
	 * @throws NoSuchOccupationException if a occupation with the primary key could not be found
	 */
	public Occupation remove(long occupationId)
		throws NoSuchOccupationException;

	public Occupation updateImpl(Occupation occupation);

	/**
	 * Returns the occupation with the primary key or throws a <code>NoSuchOccupationException</code> if it could not be found.
	 *
	 * @param occupationId the primary key of the occupation
	 * @return the occupation
	 * @throws NoSuchOccupationException if a occupation with the primary key could not be found
	 */
	public Occupation findByPrimaryKey(long occupationId)
		throws NoSuchOccupationException;

	/**
	 * Returns the occupation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param occupationId the primary key of the occupation
	 * @return the occupation, or <code>null</code> if a occupation with the primary key could not be found
	 */
	public Occupation fetchByPrimaryKey(long occupationId);

	/**
	 * Returns all the occupations.
	 *
	 * @return the occupations
	 */
	public java.util.List<Occupation> findAll();

	/**
	 * Returns a range of all the occupations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OccupationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of occupations
	 * @param end the upper bound of the range of occupations (not inclusive)
	 * @return the range of occupations
	 */
	public java.util.List<Occupation> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the occupations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OccupationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of occupations
	 * @param end the upper bound of the range of occupations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of occupations
	 */
	public java.util.List<Occupation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Occupation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the occupations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OccupationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of occupations
	 * @param end the upper bound of the range of occupations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of occupations
	 */
	public java.util.List<Occupation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Occupation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the occupations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of occupations.
	 *
	 * @return the number of occupations
	 */
	public int countAll();

}