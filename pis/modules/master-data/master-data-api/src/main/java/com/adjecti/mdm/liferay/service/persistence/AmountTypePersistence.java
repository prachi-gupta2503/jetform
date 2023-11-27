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

import com.adjecti.mdm.liferay.exception.NoSuchAmountTypeException;
import com.adjecti.mdm.liferay.model.AmountType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the amount type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AmountTypeUtil
 * @generated
 */
@ProviderType
public interface AmountTypePersistence extends BasePersistence<AmountType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AmountTypeUtil} to access the amount type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the amount type in the entity cache if it is enabled.
	 *
	 * @param amountType the amount type
	 */
	public void cacheResult(AmountType amountType);

	/**
	 * Caches the amount types in the entity cache if it is enabled.
	 *
	 * @param amountTypes the amount types
	 */
	public void cacheResult(java.util.List<AmountType> amountTypes);

	/**
	 * Creates a new amount type with the primary key. Does not add the amount type to the database.
	 *
	 * @param amountTypeId the primary key for the new amount type
	 * @return the new amount type
	 */
	public AmountType create(long amountTypeId);

	/**
	 * Removes the amount type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amountTypeId the primary key of the amount type
	 * @return the amount type that was removed
	 * @throws NoSuchAmountTypeException if a amount type with the primary key could not be found
	 */
	public AmountType remove(long amountTypeId)
		throws NoSuchAmountTypeException;

	public AmountType updateImpl(AmountType amountType);

	/**
	 * Returns the amount type with the primary key or throws a <code>NoSuchAmountTypeException</code> if it could not be found.
	 *
	 * @param amountTypeId the primary key of the amount type
	 * @return the amount type
	 * @throws NoSuchAmountTypeException if a amount type with the primary key could not be found
	 */
	public AmountType findByPrimaryKey(long amountTypeId)
		throws NoSuchAmountTypeException;

	/**
	 * Returns the amount type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param amountTypeId the primary key of the amount type
	 * @return the amount type, or <code>null</code> if a amount type with the primary key could not be found
	 */
	public AmountType fetchByPrimaryKey(long amountTypeId);

	/**
	 * Returns all the amount types.
	 *
	 * @return the amount types
	 */
	public java.util.List<AmountType> findAll();

	/**
	 * Returns a range of all the amount types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmountTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amount types
	 * @param end the upper bound of the range of amount types (not inclusive)
	 * @return the range of amount types
	 */
	public java.util.List<AmountType> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the amount types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmountTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amount types
	 * @param end the upper bound of the range of amount types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of amount types
	 */
	public java.util.List<AmountType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AmountType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the amount types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmountTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amount types
	 * @param end the upper bound of the range of amount types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of amount types
	 */
	public java.util.List<AmountType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AmountType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the amount types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of amount types.
	 *
	 * @return the number of amount types
	 */
	public int countAll();

}