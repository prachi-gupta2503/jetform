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

import com.adjecti.mdm.liferay.exception.NoSuchLevelWisePayStructureException;
import com.adjecti.mdm.liferay.model.LevelWisePayStructure;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the level wise pay structure service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LevelWisePayStructureUtil
 * @generated
 */
@ProviderType
public interface LevelWisePayStructurePersistence
	extends BasePersistence<LevelWisePayStructure> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LevelWisePayStructureUtil} to access the level wise pay structure persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the level wise pay structure in the entity cache if it is enabled.
	 *
	 * @param levelWisePayStructure the level wise pay structure
	 */
	public void cacheResult(LevelWisePayStructure levelWisePayStructure);

	/**
	 * Caches the level wise pay structures in the entity cache if it is enabled.
	 *
	 * @param levelWisePayStructures the level wise pay structures
	 */
	public void cacheResult(
		java.util.List<LevelWisePayStructure> levelWisePayStructures);

	/**
	 * Creates a new level wise pay structure with the primary key. Does not add the level wise pay structure to the database.
	 *
	 * @param levelWisePayStructureId the primary key for the new level wise pay structure
	 * @return the new level wise pay structure
	 */
	public LevelWisePayStructure create(long levelWisePayStructureId);

	/**
	 * Removes the level wise pay structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param levelWisePayStructureId the primary key of the level wise pay structure
	 * @return the level wise pay structure that was removed
	 * @throws NoSuchLevelWisePayStructureException if a level wise pay structure with the primary key could not be found
	 */
	public LevelWisePayStructure remove(long levelWisePayStructureId)
		throws NoSuchLevelWisePayStructureException;

	public LevelWisePayStructure updateImpl(
		LevelWisePayStructure levelWisePayStructure);

	/**
	 * Returns the level wise pay structure with the primary key or throws a <code>NoSuchLevelWisePayStructureException</code> if it could not be found.
	 *
	 * @param levelWisePayStructureId the primary key of the level wise pay structure
	 * @return the level wise pay structure
	 * @throws NoSuchLevelWisePayStructureException if a level wise pay structure with the primary key could not be found
	 */
	public LevelWisePayStructure findByPrimaryKey(long levelWisePayStructureId)
		throws NoSuchLevelWisePayStructureException;

	/**
	 * Returns the level wise pay structure with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param levelWisePayStructureId the primary key of the level wise pay structure
	 * @return the level wise pay structure, or <code>null</code> if a level wise pay structure with the primary key could not be found
	 */
	public LevelWisePayStructure fetchByPrimaryKey(
		long levelWisePayStructureId);

	/**
	 * Returns all the level wise pay structures.
	 *
	 * @return the level wise pay structures
	 */
	public java.util.List<LevelWisePayStructure> findAll();

	/**
	 * Returns a range of all the level wise pay structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LevelWisePayStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of level wise pay structures
	 * @param end the upper bound of the range of level wise pay structures (not inclusive)
	 * @return the range of level wise pay structures
	 */
	public java.util.List<LevelWisePayStructure> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the level wise pay structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LevelWisePayStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of level wise pay structures
	 * @param end the upper bound of the range of level wise pay structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of level wise pay structures
	 */
	public java.util.List<LevelWisePayStructure> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LevelWisePayStructure>
			orderByComparator);

	/**
	 * Returns an ordered range of all the level wise pay structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LevelWisePayStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of level wise pay structures
	 * @param end the upper bound of the range of level wise pay structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of level wise pay structures
	 */
	public java.util.List<LevelWisePayStructure> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LevelWisePayStructure>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the level wise pay structures from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of level wise pay structures.
	 *
	 * @return the number of level wise pay structures
	 */
	public int countAll();

}