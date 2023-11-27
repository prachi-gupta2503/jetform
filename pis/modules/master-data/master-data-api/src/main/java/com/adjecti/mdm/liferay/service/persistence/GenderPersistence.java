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

import com.adjecti.mdm.liferay.exception.NoSuchGenderException;
import com.adjecti.mdm.liferay.model.Gender;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the gender service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GenderUtil
 * @generated
 */
@ProviderType
public interface GenderPersistence extends BasePersistence<Gender> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GenderUtil} to access the gender persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the genders where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching genders
	 */
	public java.util.List<Gender> findByName(String name);

	/**
	 * Returns a range of all the genders where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GenderModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of genders
	 * @param end the upper bound of the range of genders (not inclusive)
	 * @return the range of matching genders
	 */
	public java.util.List<Gender> findByName(String name, int start, int end);

	/**
	 * Returns an ordered range of all the genders where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GenderModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of genders
	 * @param end the upper bound of the range of genders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching genders
	 */
	public java.util.List<Gender> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Gender>
			orderByComparator);

	/**
	 * Returns an ordered range of all the genders where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GenderModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of genders
	 * @param end the upper bound of the range of genders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching genders
	 */
	public java.util.List<Gender> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Gender>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first gender in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gender
	 * @throws NoSuchGenderException if a matching gender could not be found
	 */
	public Gender findByName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<Gender>
				orderByComparator)
		throws NoSuchGenderException;

	/**
	 * Returns the first gender in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gender, or <code>null</code> if a matching gender could not be found
	 */
	public Gender fetchByName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<Gender>
			orderByComparator);

	/**
	 * Returns the last gender in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gender
	 * @throws NoSuchGenderException if a matching gender could not be found
	 */
	public Gender findByName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<Gender>
				orderByComparator)
		throws NoSuchGenderException;

	/**
	 * Returns the last gender in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gender, or <code>null</code> if a matching gender could not be found
	 */
	public Gender fetchByName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<Gender>
			orderByComparator);

	/**
	 * Returns the genders before and after the current gender in the ordered set where name = &#63;.
	 *
	 * @param genderId the primary key of the current gender
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next gender
	 * @throws NoSuchGenderException if a gender with the primary key could not be found
	 */
	public Gender[] findByName_PrevAndNext(
			long genderId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<Gender>
				orderByComparator)
		throws NoSuchGenderException;

	/**
	 * Removes all the genders where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByName(String name);

	/**
	 * Returns the number of genders where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching genders
	 */
	public int countByName(String name);

	/**
	 * Caches the gender in the entity cache if it is enabled.
	 *
	 * @param gender the gender
	 */
	public void cacheResult(Gender gender);

	/**
	 * Caches the genders in the entity cache if it is enabled.
	 *
	 * @param genders the genders
	 */
	public void cacheResult(java.util.List<Gender> genders);

	/**
	 * Creates a new gender with the primary key. Does not add the gender to the database.
	 *
	 * @param genderId the primary key for the new gender
	 * @return the new gender
	 */
	public Gender create(long genderId);

	/**
	 * Removes the gender with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param genderId the primary key of the gender
	 * @return the gender that was removed
	 * @throws NoSuchGenderException if a gender with the primary key could not be found
	 */
	public Gender remove(long genderId) throws NoSuchGenderException;

	public Gender updateImpl(Gender gender);

	/**
	 * Returns the gender with the primary key or throws a <code>NoSuchGenderException</code> if it could not be found.
	 *
	 * @param genderId the primary key of the gender
	 * @return the gender
	 * @throws NoSuchGenderException if a gender with the primary key could not be found
	 */
	public Gender findByPrimaryKey(long genderId) throws NoSuchGenderException;

	/**
	 * Returns the gender with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param genderId the primary key of the gender
	 * @return the gender, or <code>null</code> if a gender with the primary key could not be found
	 */
	public Gender fetchByPrimaryKey(long genderId);

	/**
	 * Returns all the genders.
	 *
	 * @return the genders
	 */
	public java.util.List<Gender> findAll();

	/**
	 * Returns a range of all the genders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GenderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of genders
	 * @param end the upper bound of the range of genders (not inclusive)
	 * @return the range of genders
	 */
	public java.util.List<Gender> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the genders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GenderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of genders
	 * @param end the upper bound of the range of genders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of genders
	 */
	public java.util.List<Gender> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Gender>
			orderByComparator);

	/**
	 * Returns an ordered range of all the genders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GenderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of genders
	 * @param end the upper bound of the range of genders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of genders
	 */
	public java.util.List<Gender> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Gender>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the genders from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of genders.
	 *
	 * @return the number of genders
	 */
	public int countAll();

}