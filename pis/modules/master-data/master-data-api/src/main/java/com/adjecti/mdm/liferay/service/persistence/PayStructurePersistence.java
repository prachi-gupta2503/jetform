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

import com.adjecti.mdm.liferay.exception.NoSuchPayStructureException;
import com.adjecti.mdm.liferay.model.PayStructure;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the pay structure service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PayStructureUtil
 * @generated
 */
@ProviderType
public interface PayStructurePersistence extends BasePersistence<PayStructure> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PayStructureUtil} to access the pay structure persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the pay structure in the entity cache if it is enabled.
	 *
	 * @param payStructure the pay structure
	 */
	public void cacheResult(PayStructure payStructure);

	/**
	 * Caches the pay structures in the entity cache if it is enabled.
	 *
	 * @param payStructures the pay structures
	 */
	public void cacheResult(java.util.List<PayStructure> payStructures);

	/**
	 * Creates a new pay structure with the primary key. Does not add the pay structure to the database.
	 *
	 * @param payStructureId the primary key for the new pay structure
	 * @return the new pay structure
	 */
	public PayStructure create(long payStructureId);

	/**
	 * Removes the pay structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param payStructureId the primary key of the pay structure
	 * @return the pay structure that was removed
	 * @throws NoSuchPayStructureException if a pay structure with the primary key could not be found
	 */
	public PayStructure remove(long payStructureId)
		throws NoSuchPayStructureException;

	public PayStructure updateImpl(PayStructure payStructure);

	/**
	 * Returns the pay structure with the primary key or throws a <code>NoSuchPayStructureException</code> if it could not be found.
	 *
	 * @param payStructureId the primary key of the pay structure
	 * @return the pay structure
	 * @throws NoSuchPayStructureException if a pay structure with the primary key could not be found
	 */
	public PayStructure findByPrimaryKey(long payStructureId)
		throws NoSuchPayStructureException;

	/**
	 * Returns the pay structure with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param payStructureId the primary key of the pay structure
	 * @return the pay structure, or <code>null</code> if a pay structure with the primary key could not be found
	 */
	public PayStructure fetchByPrimaryKey(long payStructureId);

	/**
	 * Returns all the pay structures.
	 *
	 * @return the pay structures
	 */
	public java.util.List<PayStructure> findAll();

	/**
	 * Returns a range of all the pay structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay structures
	 * @param end the upper bound of the range of pay structures (not inclusive)
	 * @return the range of pay structures
	 */
	public java.util.List<PayStructure> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the pay structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay structures
	 * @param end the upper bound of the range of pay structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pay structures
	 */
	public java.util.List<PayStructure> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PayStructure>
			orderByComparator);

	/**
	 * Returns an ordered range of all the pay structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay structures
	 * @param end the upper bound of the range of pay structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pay structures
	 */
	public java.util.List<PayStructure> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PayStructure>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the pay structures from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of pay structures.
	 *
	 * @return the number of pay structures
	 */
	public int countAll();

}