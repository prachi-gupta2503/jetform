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

import com.adjecti.mdm.liferay.exception.NoSuchCasteCategoryException;
import com.adjecti.mdm.liferay.model.CasteCategory;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the caste category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CasteCategoryUtil
 * @generated
 */
@ProviderType
public interface CasteCategoryPersistence
	extends BasePersistence<CasteCategory> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CasteCategoryUtil} to access the caste category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the caste categories where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching caste categories
	 */
	public java.util.List<CasteCategory> findByName(String name);

	/**
	 * Returns a range of all the caste categories where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasteCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of caste categories
	 * @param end the upper bound of the range of caste categories (not inclusive)
	 * @return the range of matching caste categories
	 */
	public java.util.List<CasteCategory> findByName(
		String name, int start, int end);

	/**
	 * Returns an ordered range of all the caste categories where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasteCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of caste categories
	 * @param end the upper bound of the range of caste categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching caste categories
	 */
	public java.util.List<CasteCategory> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CasteCategory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the caste categories where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasteCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of caste categories
	 * @param end the upper bound of the range of caste categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching caste categories
	 */
	public java.util.List<CasteCategory> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CasteCategory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first caste category in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching caste category
	 * @throws NoSuchCasteCategoryException if a matching caste category could not be found
	 */
	public CasteCategory findByName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<CasteCategory>
				orderByComparator)
		throws NoSuchCasteCategoryException;

	/**
	 * Returns the first caste category in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching caste category, or <code>null</code> if a matching caste category could not be found
	 */
	public CasteCategory fetchByName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<CasteCategory>
			orderByComparator);

	/**
	 * Returns the last caste category in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching caste category
	 * @throws NoSuchCasteCategoryException if a matching caste category could not be found
	 */
	public CasteCategory findByName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<CasteCategory>
				orderByComparator)
		throws NoSuchCasteCategoryException;

	/**
	 * Returns the last caste category in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching caste category, or <code>null</code> if a matching caste category could not be found
	 */
	public CasteCategory fetchByName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<CasteCategory>
			orderByComparator);

	/**
	 * Returns the caste categories before and after the current caste category in the ordered set where name = &#63;.
	 *
	 * @param casteCategoryId the primary key of the current caste category
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next caste category
	 * @throws NoSuchCasteCategoryException if a caste category with the primary key could not be found
	 */
	public CasteCategory[] findByName_PrevAndNext(
			long casteCategoryId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<CasteCategory>
				orderByComparator)
		throws NoSuchCasteCategoryException;

	/**
	 * Removes all the caste categories where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByName(String name);

	/**
	 * Returns the number of caste categories where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching caste categories
	 */
	public int countByName(String name);

	/**
	 * Caches the caste category in the entity cache if it is enabled.
	 *
	 * @param casteCategory the caste category
	 */
	public void cacheResult(CasteCategory casteCategory);

	/**
	 * Caches the caste categories in the entity cache if it is enabled.
	 *
	 * @param casteCategories the caste categories
	 */
	public void cacheResult(java.util.List<CasteCategory> casteCategories);

	/**
	 * Creates a new caste category with the primary key. Does not add the caste category to the database.
	 *
	 * @param casteCategoryId the primary key for the new caste category
	 * @return the new caste category
	 */
	public CasteCategory create(long casteCategoryId);

	/**
	 * Removes the caste category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param casteCategoryId the primary key of the caste category
	 * @return the caste category that was removed
	 * @throws NoSuchCasteCategoryException if a caste category with the primary key could not be found
	 */
	public CasteCategory remove(long casteCategoryId)
		throws NoSuchCasteCategoryException;

	public CasteCategory updateImpl(CasteCategory casteCategory);

	/**
	 * Returns the caste category with the primary key or throws a <code>NoSuchCasteCategoryException</code> if it could not be found.
	 *
	 * @param casteCategoryId the primary key of the caste category
	 * @return the caste category
	 * @throws NoSuchCasteCategoryException if a caste category with the primary key could not be found
	 */
	public CasteCategory findByPrimaryKey(long casteCategoryId)
		throws NoSuchCasteCategoryException;

	/**
	 * Returns the caste category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param casteCategoryId the primary key of the caste category
	 * @return the caste category, or <code>null</code> if a caste category with the primary key could not be found
	 */
	public CasteCategory fetchByPrimaryKey(long casteCategoryId);

	/**
	 * Returns all the caste categories.
	 *
	 * @return the caste categories
	 */
	public java.util.List<CasteCategory> findAll();

	/**
	 * Returns a range of all the caste categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasteCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of caste categories
	 * @param end the upper bound of the range of caste categories (not inclusive)
	 * @return the range of caste categories
	 */
	public java.util.List<CasteCategory> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the caste categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasteCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of caste categories
	 * @param end the upper bound of the range of caste categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of caste categories
	 */
	public java.util.List<CasteCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CasteCategory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the caste categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CasteCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of caste categories
	 * @param end the upper bound of the range of caste categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of caste categories
	 */
	public java.util.List<CasteCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CasteCategory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the caste categories from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of caste categories.
	 *
	 * @return the number of caste categories
	 */
	public int countAll();

}