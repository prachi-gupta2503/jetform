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

import com.adjecti.mdm.liferay.exception.NoSuchDeputationTypeException;
import com.adjecti.mdm.liferay.model.DeputationType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the deputation type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DeputationTypeUtil
 * @generated
 */
@ProviderType
public interface DeputationTypePersistence
	extends BasePersistence<DeputationType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DeputationTypeUtil} to access the deputation type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the deputation type in the entity cache if it is enabled.
	 *
	 * @param deputationType the deputation type
	 */
	public void cacheResult(DeputationType deputationType);

	/**
	 * Caches the deputation types in the entity cache if it is enabled.
	 *
	 * @param deputationTypes the deputation types
	 */
	public void cacheResult(java.util.List<DeputationType> deputationTypes);

	/**
	 * Creates a new deputation type with the primary key. Does not add the deputation type to the database.
	 *
	 * @param deputationTypeId the primary key for the new deputation type
	 * @return the new deputation type
	 */
	public DeputationType create(long deputationTypeId);

	/**
	 * Removes the deputation type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param deputationTypeId the primary key of the deputation type
	 * @return the deputation type that was removed
	 * @throws NoSuchDeputationTypeException if a deputation type with the primary key could not be found
	 */
	public DeputationType remove(long deputationTypeId)
		throws NoSuchDeputationTypeException;

	public DeputationType updateImpl(DeputationType deputationType);

	/**
	 * Returns the deputation type with the primary key or throws a <code>NoSuchDeputationTypeException</code> if it could not be found.
	 *
	 * @param deputationTypeId the primary key of the deputation type
	 * @return the deputation type
	 * @throws NoSuchDeputationTypeException if a deputation type with the primary key could not be found
	 */
	public DeputationType findByPrimaryKey(long deputationTypeId)
		throws NoSuchDeputationTypeException;

	/**
	 * Returns the deputation type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param deputationTypeId the primary key of the deputation type
	 * @return the deputation type, or <code>null</code> if a deputation type with the primary key could not be found
	 */
	public DeputationType fetchByPrimaryKey(long deputationTypeId);

	/**
	 * Returns all the deputation types.
	 *
	 * @return the deputation types
	 */
	public java.util.List<DeputationType> findAll();

	/**
	 * Returns a range of all the deputation types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeputationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of deputation types
	 * @param end the upper bound of the range of deputation types (not inclusive)
	 * @return the range of deputation types
	 */
	public java.util.List<DeputationType> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the deputation types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeputationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of deputation types
	 * @param end the upper bound of the range of deputation types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of deputation types
	 */
	public java.util.List<DeputationType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DeputationType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the deputation types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeputationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of deputation types
	 * @param end the upper bound of the range of deputation types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of deputation types
	 */
	public java.util.List<DeputationType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DeputationType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the deputation types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of deputation types.
	 *
	 * @return the number of deputation types
	 */
	public int countAll();

}