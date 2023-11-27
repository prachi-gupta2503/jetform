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

import com.adjecti.mdm.liferay.exception.NoSuchPhTypeException;
import com.adjecti.mdm.liferay.model.PhType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the ph type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PhTypeUtil
 * @generated
 */
@ProviderType
public interface PhTypePersistence extends BasePersistence<PhType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PhTypeUtil} to access the ph type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the ph type in the entity cache if it is enabled.
	 *
	 * @param phType the ph type
	 */
	public void cacheResult(PhType phType);

	/**
	 * Caches the ph types in the entity cache if it is enabled.
	 *
	 * @param phTypes the ph types
	 */
	public void cacheResult(java.util.List<PhType> phTypes);

	/**
	 * Creates a new ph type with the primary key. Does not add the ph type to the database.
	 *
	 * @param phTypeId the primary key for the new ph type
	 * @return the new ph type
	 */
	public PhType create(long phTypeId);

	/**
	 * Removes the ph type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param phTypeId the primary key of the ph type
	 * @return the ph type that was removed
	 * @throws NoSuchPhTypeException if a ph type with the primary key could not be found
	 */
	public PhType remove(long phTypeId) throws NoSuchPhTypeException;

	public PhType updateImpl(PhType phType);

	/**
	 * Returns the ph type with the primary key or throws a <code>NoSuchPhTypeException</code> if it could not be found.
	 *
	 * @param phTypeId the primary key of the ph type
	 * @return the ph type
	 * @throws NoSuchPhTypeException if a ph type with the primary key could not be found
	 */
	public PhType findByPrimaryKey(long phTypeId) throws NoSuchPhTypeException;

	/**
	 * Returns the ph type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param phTypeId the primary key of the ph type
	 * @return the ph type, or <code>null</code> if a ph type with the primary key could not be found
	 */
	public PhType fetchByPrimaryKey(long phTypeId);

	/**
	 * Returns all the ph types.
	 *
	 * @return the ph types
	 */
	public java.util.List<PhType> findAll();

	/**
	 * Returns a range of all the ph types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ph types
	 * @param end the upper bound of the range of ph types (not inclusive)
	 * @return the range of ph types
	 */
	public java.util.List<PhType> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the ph types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ph types
	 * @param end the upper bound of the range of ph types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ph types
	 */
	public java.util.List<PhType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ph types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ph types
	 * @param end the upper bound of the range of ph types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ph types
	 */
	public java.util.List<PhType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the ph types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of ph types.
	 *
	 * @return the number of ph types
	 */
	public int countAll();

}