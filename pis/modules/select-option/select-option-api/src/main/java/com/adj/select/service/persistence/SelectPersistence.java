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

package com.adj.select.service.persistence;

import com.adj.select.exception.NoSuchSelectException;
import com.adj.select.model.Select;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the select service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SelectUtil
 * @generated
 */
@ProviderType
public interface SelectPersistence extends BasePersistence<Select> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SelectUtil} to access the select persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the select in the entity cache if it is enabled.
	 *
	 * @param select the select
	 */
	public void cacheResult(Select select);

	/**
	 * Caches the selects in the entity cache if it is enabled.
	 *
	 * @param selects the selects
	 */
	public void cacheResult(java.util.List<Select> selects);

	/**
	 * Creates a new select with the primary key. Does not add the select to the database.
	 *
	 * @param idFieldName the primary key for the new select
	 * @return the new select
	 */
	public Select create(String idFieldName);

	/**
	 * Removes the select with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idFieldName the primary key of the select
	 * @return the select that was removed
	 * @throws NoSuchSelectException if a select with the primary key could not be found
	 */
	public Select remove(String idFieldName) throws NoSuchSelectException;

	public Select updateImpl(Select select);

	/**
	 * Returns the select with the primary key or throws a <code>NoSuchSelectException</code> if it could not be found.
	 *
	 * @param idFieldName the primary key of the select
	 * @return the select
	 * @throws NoSuchSelectException if a select with the primary key could not be found
	 */
	public Select findByPrimaryKey(String idFieldName)
		throws NoSuchSelectException;

	/**
	 * Returns the select with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idFieldName the primary key of the select
	 * @return the select, or <code>null</code> if a select with the primary key could not be found
	 */
	public Select fetchByPrimaryKey(String idFieldName);

	/**
	 * Returns all the selects.
	 *
	 * @return the selects
	 */
	public java.util.List<Select> findAll();

	/**
	 * Returns a range of all the selects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SelectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of selects
	 * @param end the upper bound of the range of selects (not inclusive)
	 * @return the range of selects
	 */
	public java.util.List<Select> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the selects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SelectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of selects
	 * @param end the upper bound of the range of selects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of selects
	 */
	public java.util.List<Select> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Select>
			orderByComparator);

	/**
	 * Returns an ordered range of all the selects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SelectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of selects
	 * @param end the upper bound of the range of selects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of selects
	 */
	public java.util.List<Select> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Select>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the selects from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of selects.
	 *
	 * @return the number of selects
	 */
	public int countAll();

}