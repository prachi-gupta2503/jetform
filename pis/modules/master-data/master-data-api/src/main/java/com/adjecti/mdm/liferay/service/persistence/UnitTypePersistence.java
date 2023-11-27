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

import com.adjecti.mdm.liferay.exception.NoSuchUnitTypeException;
import com.adjecti.mdm.liferay.model.UnitType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the unit type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UnitTypeUtil
 * @generated
 */
@ProviderType
public interface UnitTypePersistence extends BasePersistence<UnitType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UnitTypeUtil} to access the unit type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the unit type in the entity cache if it is enabled.
	 *
	 * @param unitType the unit type
	 */
	public void cacheResult(UnitType unitType);

	/**
	 * Caches the unit types in the entity cache if it is enabled.
	 *
	 * @param unitTypes the unit types
	 */
	public void cacheResult(java.util.List<UnitType> unitTypes);

	/**
	 * Creates a new unit type with the primary key. Does not add the unit type to the database.
	 *
	 * @param unitTypeId the primary key for the new unit type
	 * @return the new unit type
	 */
	public UnitType create(long unitTypeId);

	/**
	 * Removes the unit type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param unitTypeId the primary key of the unit type
	 * @return the unit type that was removed
	 * @throws NoSuchUnitTypeException if a unit type with the primary key could not be found
	 */
	public UnitType remove(long unitTypeId) throws NoSuchUnitTypeException;

	public UnitType updateImpl(UnitType unitType);

	/**
	 * Returns the unit type with the primary key or throws a <code>NoSuchUnitTypeException</code> if it could not be found.
	 *
	 * @param unitTypeId the primary key of the unit type
	 * @return the unit type
	 * @throws NoSuchUnitTypeException if a unit type with the primary key could not be found
	 */
	public UnitType findByPrimaryKey(long unitTypeId)
		throws NoSuchUnitTypeException;

	/**
	 * Returns the unit type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param unitTypeId the primary key of the unit type
	 * @return the unit type, or <code>null</code> if a unit type with the primary key could not be found
	 */
	public UnitType fetchByPrimaryKey(long unitTypeId);

	/**
	 * Returns all the unit types.
	 *
	 * @return the unit types
	 */
	public java.util.List<UnitType> findAll();

	/**
	 * Returns a range of all the unit types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UnitTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of unit types
	 * @param end the upper bound of the range of unit types (not inclusive)
	 * @return the range of unit types
	 */
	public java.util.List<UnitType> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the unit types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UnitTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of unit types
	 * @param end the upper bound of the range of unit types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of unit types
	 */
	public java.util.List<UnitType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UnitType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the unit types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UnitTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of unit types
	 * @param end the upper bound of the range of unit types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of unit types
	 */
	public java.util.List<UnitType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UnitType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the unit types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of unit types.
	 *
	 * @return the number of unit types
	 */
	public int countAll();

}