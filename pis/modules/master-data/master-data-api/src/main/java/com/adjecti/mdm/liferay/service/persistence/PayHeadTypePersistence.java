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

import com.adjecti.mdm.liferay.exception.NoSuchPayHeadTypeException;
import com.adjecti.mdm.liferay.model.PayHeadType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the pay head type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PayHeadTypeUtil
 * @generated
 */
@ProviderType
public interface PayHeadTypePersistence extends BasePersistence<PayHeadType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PayHeadTypeUtil} to access the pay head type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the pay head type in the entity cache if it is enabled.
	 *
	 * @param payHeadType the pay head type
	 */
	public void cacheResult(PayHeadType payHeadType);

	/**
	 * Caches the pay head types in the entity cache if it is enabled.
	 *
	 * @param payHeadTypes the pay head types
	 */
	public void cacheResult(java.util.List<PayHeadType> payHeadTypes);

	/**
	 * Creates a new pay head type with the primary key. Does not add the pay head type to the database.
	 *
	 * @param payHeadTypeId the primary key for the new pay head type
	 * @return the new pay head type
	 */
	public PayHeadType create(long payHeadTypeId);

	/**
	 * Removes the pay head type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param payHeadTypeId the primary key of the pay head type
	 * @return the pay head type that was removed
	 * @throws NoSuchPayHeadTypeException if a pay head type with the primary key could not be found
	 */
	public PayHeadType remove(long payHeadTypeId)
		throws NoSuchPayHeadTypeException;

	public PayHeadType updateImpl(PayHeadType payHeadType);

	/**
	 * Returns the pay head type with the primary key or throws a <code>NoSuchPayHeadTypeException</code> if it could not be found.
	 *
	 * @param payHeadTypeId the primary key of the pay head type
	 * @return the pay head type
	 * @throws NoSuchPayHeadTypeException if a pay head type with the primary key could not be found
	 */
	public PayHeadType findByPrimaryKey(long payHeadTypeId)
		throws NoSuchPayHeadTypeException;

	/**
	 * Returns the pay head type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param payHeadTypeId the primary key of the pay head type
	 * @return the pay head type, or <code>null</code> if a pay head type with the primary key could not be found
	 */
	public PayHeadType fetchByPrimaryKey(long payHeadTypeId);

	/**
	 * Returns all the pay head types.
	 *
	 * @return the pay head types
	 */
	public java.util.List<PayHeadType> findAll();

	/**
	 * Returns a range of all the pay head types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayHeadTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay head types
	 * @param end the upper bound of the range of pay head types (not inclusive)
	 * @return the range of pay head types
	 */
	public java.util.List<PayHeadType> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the pay head types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayHeadTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay head types
	 * @param end the upper bound of the range of pay head types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pay head types
	 */
	public java.util.List<PayHeadType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PayHeadType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the pay head types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PayHeadTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay head types
	 * @param end the upper bound of the range of pay head types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pay head types
	 */
	public java.util.List<PayHeadType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PayHeadType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the pay head types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of pay head types.
	 *
	 * @return the number of pay head types
	 */
	public int countAll();

}