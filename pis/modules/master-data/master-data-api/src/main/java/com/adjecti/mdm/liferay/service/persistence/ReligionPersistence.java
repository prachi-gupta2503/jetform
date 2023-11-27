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

import com.adjecti.mdm.liferay.exception.NoSuchReligionException;
import com.adjecti.mdm.liferay.model.Religion;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the religion service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReligionUtil
 * @generated
 */
@ProviderType
public interface ReligionPersistence extends BasePersistence<Religion> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ReligionUtil} to access the religion persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the religions where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching religions
	 */
	public java.util.List<Religion> findByCode(String code);

	/**
	 * Returns a range of all the religions where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReligionModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of religions
	 * @param end the upper bound of the range of religions (not inclusive)
	 * @return the range of matching religions
	 */
	public java.util.List<Religion> findByCode(String code, int start, int end);

	/**
	 * Returns an ordered range of all the religions where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReligionModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of religions
	 * @param end the upper bound of the range of religions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching religions
	 */
	public java.util.List<Religion> findByCode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Religion>
			orderByComparator);

	/**
	 * Returns an ordered range of all the religions where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReligionModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of religions
	 * @param end the upper bound of the range of religions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching religions
	 */
	public java.util.List<Religion> findByCode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Religion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first religion in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching religion
	 * @throws NoSuchReligionException if a matching religion could not be found
	 */
	public Religion findByCode_First(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator<Religion>
				orderByComparator)
		throws NoSuchReligionException;

	/**
	 * Returns the first religion in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching religion, or <code>null</code> if a matching religion could not be found
	 */
	public Religion fetchByCode_First(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<Religion>
			orderByComparator);

	/**
	 * Returns the last religion in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching religion
	 * @throws NoSuchReligionException if a matching religion could not be found
	 */
	public Religion findByCode_Last(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator<Religion>
				orderByComparator)
		throws NoSuchReligionException;

	/**
	 * Returns the last religion in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching religion, or <code>null</code> if a matching religion could not be found
	 */
	public Religion fetchByCode_Last(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<Religion>
			orderByComparator);

	/**
	 * Returns the religions before and after the current religion in the ordered set where code = &#63;.
	 *
	 * @param religionId the primary key of the current religion
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next religion
	 * @throws NoSuchReligionException if a religion with the primary key could not be found
	 */
	public Religion[] findByCode_PrevAndNext(
			long religionId, String code,
			com.liferay.portal.kernel.util.OrderByComparator<Religion>
				orderByComparator)
		throws NoSuchReligionException;

	/**
	 * Removes all the religions where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public void removeByCode(String code);

	/**
	 * Returns the number of religions where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching religions
	 */
	public int countByCode(String code);

	/**
	 * Returns all the religions where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching religions
	 */
	public java.util.List<Religion> findByName(String name);

	/**
	 * Returns a range of all the religions where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReligionModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of religions
	 * @param end the upper bound of the range of religions (not inclusive)
	 * @return the range of matching religions
	 */
	public java.util.List<Religion> findByName(String name, int start, int end);

	/**
	 * Returns an ordered range of all the religions where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReligionModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of religions
	 * @param end the upper bound of the range of religions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching religions
	 */
	public java.util.List<Religion> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Religion>
			orderByComparator);

	/**
	 * Returns an ordered range of all the religions where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReligionModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of religions
	 * @param end the upper bound of the range of religions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching religions
	 */
	public java.util.List<Religion> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Religion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first religion in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching religion
	 * @throws NoSuchReligionException if a matching religion could not be found
	 */
	public Religion findByName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<Religion>
				orderByComparator)
		throws NoSuchReligionException;

	/**
	 * Returns the first religion in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching religion, or <code>null</code> if a matching religion could not be found
	 */
	public Religion fetchByName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<Religion>
			orderByComparator);

	/**
	 * Returns the last religion in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching religion
	 * @throws NoSuchReligionException if a matching religion could not be found
	 */
	public Religion findByName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<Religion>
				orderByComparator)
		throws NoSuchReligionException;

	/**
	 * Returns the last religion in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching religion, or <code>null</code> if a matching religion could not be found
	 */
	public Religion fetchByName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<Religion>
			orderByComparator);

	/**
	 * Returns the religions before and after the current religion in the ordered set where name = &#63;.
	 *
	 * @param religionId the primary key of the current religion
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next religion
	 * @throws NoSuchReligionException if a religion with the primary key could not be found
	 */
	public Religion[] findByName_PrevAndNext(
			long religionId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<Religion>
				orderByComparator)
		throws NoSuchReligionException;

	/**
	 * Removes all the religions where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByName(String name);

	/**
	 * Returns the number of religions where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching religions
	 */
	public int countByName(String name);

	/**
	 * Caches the religion in the entity cache if it is enabled.
	 *
	 * @param religion the religion
	 */
	public void cacheResult(Religion religion);

	/**
	 * Caches the religions in the entity cache if it is enabled.
	 *
	 * @param religions the religions
	 */
	public void cacheResult(java.util.List<Religion> religions);

	/**
	 * Creates a new religion with the primary key. Does not add the religion to the database.
	 *
	 * @param religionId the primary key for the new religion
	 * @return the new religion
	 */
	public Religion create(long religionId);

	/**
	 * Removes the religion with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param religionId the primary key of the religion
	 * @return the religion that was removed
	 * @throws NoSuchReligionException if a religion with the primary key could not be found
	 */
	public Religion remove(long religionId) throws NoSuchReligionException;

	public Religion updateImpl(Religion religion);

	/**
	 * Returns the religion with the primary key or throws a <code>NoSuchReligionException</code> if it could not be found.
	 *
	 * @param religionId the primary key of the religion
	 * @return the religion
	 * @throws NoSuchReligionException if a religion with the primary key could not be found
	 */
	public Religion findByPrimaryKey(long religionId)
		throws NoSuchReligionException;

	/**
	 * Returns the religion with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param religionId the primary key of the religion
	 * @return the religion, or <code>null</code> if a religion with the primary key could not be found
	 */
	public Religion fetchByPrimaryKey(long religionId);

	/**
	 * Returns all the religions.
	 *
	 * @return the religions
	 */
	public java.util.List<Religion> findAll();

	/**
	 * Returns a range of all the religions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReligionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of religions
	 * @param end the upper bound of the range of religions (not inclusive)
	 * @return the range of religions
	 */
	public java.util.List<Religion> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the religions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReligionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of religions
	 * @param end the upper bound of the range of religions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of religions
	 */
	public java.util.List<Religion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Religion>
			orderByComparator);

	/**
	 * Returns an ordered range of all the religions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReligionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of religions
	 * @param end the upper bound of the range of religions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of religions
	 */
	public java.util.List<Religion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Religion>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the religions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of religions.
	 *
	 * @return the number of religions
	 */
	public int countAll();

}