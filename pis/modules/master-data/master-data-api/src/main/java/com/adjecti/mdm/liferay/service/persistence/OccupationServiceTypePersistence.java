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

import com.adjecti.mdm.liferay.exception.NoSuchOccupationServiceTypeException;
import com.adjecti.mdm.liferay.model.OccupationServiceType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the occupation service type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OccupationServiceTypeUtil
 * @generated
 */
@ProviderType
public interface OccupationServiceTypePersistence
	extends BasePersistence<OccupationServiceType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OccupationServiceTypeUtil} to access the occupation service type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the occupation service type in the entity cache if it is enabled.
	 *
	 * @param occupationServiceType the occupation service type
	 */
	public void cacheResult(OccupationServiceType occupationServiceType);

	/**
	 * Caches the occupation service types in the entity cache if it is enabled.
	 *
	 * @param occupationServiceTypes the occupation service types
	 */
	public void cacheResult(
		java.util.List<OccupationServiceType> occupationServiceTypes);

	/**
	 * Creates a new occupation service type with the primary key. Does not add the occupation service type to the database.
	 *
	 * @param occupationServiceTypeId the primary key for the new occupation service type
	 * @return the new occupation service type
	 */
	public OccupationServiceType create(long occupationServiceTypeId);

	/**
	 * Removes the occupation service type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param occupationServiceTypeId the primary key of the occupation service type
	 * @return the occupation service type that was removed
	 * @throws NoSuchOccupationServiceTypeException if a occupation service type with the primary key could not be found
	 */
	public OccupationServiceType remove(long occupationServiceTypeId)
		throws NoSuchOccupationServiceTypeException;

	public OccupationServiceType updateImpl(
		OccupationServiceType occupationServiceType);

	/**
	 * Returns the occupation service type with the primary key or throws a <code>NoSuchOccupationServiceTypeException</code> if it could not be found.
	 *
	 * @param occupationServiceTypeId the primary key of the occupation service type
	 * @return the occupation service type
	 * @throws NoSuchOccupationServiceTypeException if a occupation service type with the primary key could not be found
	 */
	public OccupationServiceType findByPrimaryKey(long occupationServiceTypeId)
		throws NoSuchOccupationServiceTypeException;

	/**
	 * Returns the occupation service type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param occupationServiceTypeId the primary key of the occupation service type
	 * @return the occupation service type, or <code>null</code> if a occupation service type with the primary key could not be found
	 */
	public OccupationServiceType fetchByPrimaryKey(
		long occupationServiceTypeId);

	/**
	 * Returns all the occupation service types.
	 *
	 * @return the occupation service types
	 */
	public java.util.List<OccupationServiceType> findAll();

	/**
	 * Returns a range of all the occupation service types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OccupationServiceTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of occupation service types
	 * @param end the upper bound of the range of occupation service types (not inclusive)
	 * @return the range of occupation service types
	 */
	public java.util.List<OccupationServiceType> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the occupation service types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OccupationServiceTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of occupation service types
	 * @param end the upper bound of the range of occupation service types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of occupation service types
	 */
	public java.util.List<OccupationServiceType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OccupationServiceType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the occupation service types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OccupationServiceTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of occupation service types
	 * @param end the upper bound of the range of occupation service types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of occupation service types
	 */
	public java.util.List<OccupationServiceType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OccupationServiceType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the occupation service types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of occupation service types.
	 *
	 * @return the number of occupation service types
	 */
	public int countAll();

}