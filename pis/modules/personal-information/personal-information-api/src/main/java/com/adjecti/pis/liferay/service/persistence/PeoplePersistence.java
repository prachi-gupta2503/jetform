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

package com.adjecti.pis.liferay.service.persistence;

import com.adjecti.pis.liferay.exception.NoSuchPeopleException;
import com.adjecti.pis.liferay.model.People;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the people service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PeopleUtil
 * @generated
 */
@ProviderType
public interface PeoplePersistence extends BasePersistence<People> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PeopleUtil} to access the people persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the peoples where dateOfBirth = &#63;.
	 *
	 * @param dateOfBirth the date of birth
	 * @return the matching peoples
	 */
	public java.util.List<People> findByDateOfBirth(Date dateOfBirth);

	/**
	 * Returns a range of all the peoples where dateOfBirth = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param dateOfBirth the date of birth
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @return the range of matching peoples
	 */
	public java.util.List<People> findByDateOfBirth(
		Date dateOfBirth, int start, int end);

	/**
	 * Returns an ordered range of all the peoples where dateOfBirth = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param dateOfBirth the date of birth
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching peoples
	 */
	public java.util.List<People> findByDateOfBirth(
		Date dateOfBirth, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<People>
			orderByComparator);

	/**
	 * Returns an ordered range of all the peoples where dateOfBirth = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param dateOfBirth the date of birth
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching peoples
	 */
	public java.util.List<People> findByDateOfBirth(
		Date dateOfBirth, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<People>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first people in the ordered set where dateOfBirth = &#63;.
	 *
	 * @param dateOfBirth the date of birth
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	public People findByDateOfBirth_First(
			Date dateOfBirth,
			com.liferay.portal.kernel.util.OrderByComparator<People>
				orderByComparator)
		throws NoSuchPeopleException;

	/**
	 * Returns the first people in the ordered set where dateOfBirth = &#63;.
	 *
	 * @param dateOfBirth the date of birth
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people, or <code>null</code> if a matching people could not be found
	 */
	public People fetchByDateOfBirth_First(
		Date dateOfBirth,
		com.liferay.portal.kernel.util.OrderByComparator<People>
			orderByComparator);

	/**
	 * Returns the last people in the ordered set where dateOfBirth = &#63;.
	 *
	 * @param dateOfBirth the date of birth
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	public People findByDateOfBirth_Last(
			Date dateOfBirth,
			com.liferay.portal.kernel.util.OrderByComparator<People>
				orderByComparator)
		throws NoSuchPeopleException;

	/**
	 * Returns the last people in the ordered set where dateOfBirth = &#63;.
	 *
	 * @param dateOfBirth the date of birth
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people, or <code>null</code> if a matching people could not be found
	 */
	public People fetchByDateOfBirth_Last(
		Date dateOfBirth,
		com.liferay.portal.kernel.util.OrderByComparator<People>
			orderByComparator);

	/**
	 * Returns the peoples before and after the current people in the ordered set where dateOfBirth = &#63;.
	 *
	 * @param peopleId the primary key of the current people
	 * @param dateOfBirth the date of birth
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next people
	 * @throws NoSuchPeopleException if a people with the primary key could not be found
	 */
	public People[] findByDateOfBirth_PrevAndNext(
			long peopleId, Date dateOfBirth,
			com.liferay.portal.kernel.util.OrderByComparator<People>
				orderByComparator)
		throws NoSuchPeopleException;

	/**
	 * Removes all the peoples where dateOfBirth = &#63; from the database.
	 *
	 * @param dateOfBirth the date of birth
	 */
	public void removeByDateOfBirth(Date dateOfBirth);

	/**
	 * Returns the number of peoples where dateOfBirth = &#63;.
	 *
	 * @param dateOfBirth the date of birth
	 * @return the number of matching peoples
	 */
	public int countByDateOfBirth(Date dateOfBirth);

	/**
	 * Returns all the peoples where appellationId = &#63;.
	 *
	 * @param appellationId the appellation ID
	 * @return the matching peoples
	 */
	public java.util.List<People> findByAppellationId(long appellationId);

	/**
	 * Returns a range of all the peoples where appellationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param appellationId the appellation ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @return the range of matching peoples
	 */
	public java.util.List<People> findByAppellationId(
		long appellationId, int start, int end);

	/**
	 * Returns an ordered range of all the peoples where appellationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param appellationId the appellation ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching peoples
	 */
	public java.util.List<People> findByAppellationId(
		long appellationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<People>
			orderByComparator);

	/**
	 * Returns an ordered range of all the peoples where appellationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param appellationId the appellation ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching peoples
	 */
	public java.util.List<People> findByAppellationId(
		long appellationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<People>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first people in the ordered set where appellationId = &#63;.
	 *
	 * @param appellationId the appellation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	public People findByAppellationId_First(
			long appellationId,
			com.liferay.portal.kernel.util.OrderByComparator<People>
				orderByComparator)
		throws NoSuchPeopleException;

	/**
	 * Returns the first people in the ordered set where appellationId = &#63;.
	 *
	 * @param appellationId the appellation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people, or <code>null</code> if a matching people could not be found
	 */
	public People fetchByAppellationId_First(
		long appellationId,
		com.liferay.portal.kernel.util.OrderByComparator<People>
			orderByComparator);

	/**
	 * Returns the last people in the ordered set where appellationId = &#63;.
	 *
	 * @param appellationId the appellation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	public People findByAppellationId_Last(
			long appellationId,
			com.liferay.portal.kernel.util.OrderByComparator<People>
				orderByComparator)
		throws NoSuchPeopleException;

	/**
	 * Returns the last people in the ordered set where appellationId = &#63;.
	 *
	 * @param appellationId the appellation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people, or <code>null</code> if a matching people could not be found
	 */
	public People fetchByAppellationId_Last(
		long appellationId,
		com.liferay.portal.kernel.util.OrderByComparator<People>
			orderByComparator);

	/**
	 * Returns the peoples before and after the current people in the ordered set where appellationId = &#63;.
	 *
	 * @param peopleId the primary key of the current people
	 * @param appellationId the appellation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next people
	 * @throws NoSuchPeopleException if a people with the primary key could not be found
	 */
	public People[] findByAppellationId_PrevAndNext(
			long peopleId, long appellationId,
			com.liferay.portal.kernel.util.OrderByComparator<People>
				orderByComparator)
		throws NoSuchPeopleException;

	/**
	 * Removes all the peoples where appellationId = &#63; from the database.
	 *
	 * @param appellationId the appellation ID
	 */
	public void removeByAppellationId(long appellationId);

	/**
	 * Returns the number of peoples where appellationId = &#63;.
	 *
	 * @param appellationId the appellation ID
	 * @return the number of matching peoples
	 */
	public int countByAppellationId(long appellationId);

	/**
	 * Returns all the peoples where genderId = &#63;.
	 *
	 * @param genderId the gender ID
	 * @return the matching peoples
	 */
	public java.util.List<People> findByGenderId(long genderId);

	/**
	 * Returns a range of all the peoples where genderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param genderId the gender ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @return the range of matching peoples
	 */
	public java.util.List<People> findByGenderId(
		long genderId, int start, int end);

	/**
	 * Returns an ordered range of all the peoples where genderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param genderId the gender ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching peoples
	 */
	public java.util.List<People> findByGenderId(
		long genderId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<People>
			orderByComparator);

	/**
	 * Returns an ordered range of all the peoples where genderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param genderId the gender ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching peoples
	 */
	public java.util.List<People> findByGenderId(
		long genderId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<People>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first people in the ordered set where genderId = &#63;.
	 *
	 * @param genderId the gender ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	public People findByGenderId_First(
			long genderId,
			com.liferay.portal.kernel.util.OrderByComparator<People>
				orderByComparator)
		throws NoSuchPeopleException;

	/**
	 * Returns the first people in the ordered set where genderId = &#63;.
	 *
	 * @param genderId the gender ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people, or <code>null</code> if a matching people could not be found
	 */
	public People fetchByGenderId_First(
		long genderId,
		com.liferay.portal.kernel.util.OrderByComparator<People>
			orderByComparator);

	/**
	 * Returns the last people in the ordered set where genderId = &#63;.
	 *
	 * @param genderId the gender ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	public People findByGenderId_Last(
			long genderId,
			com.liferay.portal.kernel.util.OrderByComparator<People>
				orderByComparator)
		throws NoSuchPeopleException;

	/**
	 * Returns the last people in the ordered set where genderId = &#63;.
	 *
	 * @param genderId the gender ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people, or <code>null</code> if a matching people could not be found
	 */
	public People fetchByGenderId_Last(
		long genderId,
		com.liferay.portal.kernel.util.OrderByComparator<People>
			orderByComparator);

	/**
	 * Returns the peoples before and after the current people in the ordered set where genderId = &#63;.
	 *
	 * @param peopleId the primary key of the current people
	 * @param genderId the gender ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next people
	 * @throws NoSuchPeopleException if a people with the primary key could not be found
	 */
	public People[] findByGenderId_PrevAndNext(
			long peopleId, long genderId,
			com.liferay.portal.kernel.util.OrderByComparator<People>
				orderByComparator)
		throws NoSuchPeopleException;

	/**
	 * Removes all the peoples where genderId = &#63; from the database.
	 *
	 * @param genderId the gender ID
	 */
	public void removeByGenderId(long genderId);

	/**
	 * Returns the number of peoples where genderId = &#63;.
	 *
	 * @param genderId the gender ID
	 * @return the number of matching peoples
	 */
	public int countByGenderId(long genderId);

	/**
	 * Returns all the peoples where maritalStatusId = &#63;.
	 *
	 * @param maritalStatusId the marital status ID
	 * @return the matching peoples
	 */
	public java.util.List<People> findByMaritalStatusId(long maritalStatusId);

	/**
	 * Returns a range of all the peoples where maritalStatusId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param maritalStatusId the marital status ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @return the range of matching peoples
	 */
	public java.util.List<People> findByMaritalStatusId(
		long maritalStatusId, int start, int end);

	/**
	 * Returns an ordered range of all the peoples where maritalStatusId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param maritalStatusId the marital status ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching peoples
	 */
	public java.util.List<People> findByMaritalStatusId(
		long maritalStatusId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<People>
			orderByComparator);

	/**
	 * Returns an ordered range of all the peoples where maritalStatusId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param maritalStatusId the marital status ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching peoples
	 */
	public java.util.List<People> findByMaritalStatusId(
		long maritalStatusId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<People>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first people in the ordered set where maritalStatusId = &#63;.
	 *
	 * @param maritalStatusId the marital status ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	public People findByMaritalStatusId_First(
			long maritalStatusId,
			com.liferay.portal.kernel.util.OrderByComparator<People>
				orderByComparator)
		throws NoSuchPeopleException;

	/**
	 * Returns the first people in the ordered set where maritalStatusId = &#63;.
	 *
	 * @param maritalStatusId the marital status ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people, or <code>null</code> if a matching people could not be found
	 */
	public People fetchByMaritalStatusId_First(
		long maritalStatusId,
		com.liferay.portal.kernel.util.OrderByComparator<People>
			orderByComparator);

	/**
	 * Returns the last people in the ordered set where maritalStatusId = &#63;.
	 *
	 * @param maritalStatusId the marital status ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	public People findByMaritalStatusId_Last(
			long maritalStatusId,
			com.liferay.portal.kernel.util.OrderByComparator<People>
				orderByComparator)
		throws NoSuchPeopleException;

	/**
	 * Returns the last people in the ordered set where maritalStatusId = &#63;.
	 *
	 * @param maritalStatusId the marital status ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people, or <code>null</code> if a matching people could not be found
	 */
	public People fetchByMaritalStatusId_Last(
		long maritalStatusId,
		com.liferay.portal.kernel.util.OrderByComparator<People>
			orderByComparator);

	/**
	 * Returns the peoples before and after the current people in the ordered set where maritalStatusId = &#63;.
	 *
	 * @param peopleId the primary key of the current people
	 * @param maritalStatusId the marital status ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next people
	 * @throws NoSuchPeopleException if a people with the primary key could not be found
	 */
	public People[] findByMaritalStatusId_PrevAndNext(
			long peopleId, long maritalStatusId,
			com.liferay.portal.kernel.util.OrderByComparator<People>
				orderByComparator)
		throws NoSuchPeopleException;

	/**
	 * Removes all the peoples where maritalStatusId = &#63; from the database.
	 *
	 * @param maritalStatusId the marital status ID
	 */
	public void removeByMaritalStatusId(long maritalStatusId);

	/**
	 * Returns the number of peoples where maritalStatusId = &#63;.
	 *
	 * @param maritalStatusId the marital status ID
	 * @return the number of matching peoples
	 */
	public int countByMaritalStatusId(long maritalStatusId);

	/**
	 * Returns all the peoples where casteCategoryId = &#63;.
	 *
	 * @param casteCategoryId the caste category ID
	 * @return the matching peoples
	 */
	public java.util.List<People> findByCasteCategoryId(long casteCategoryId);

	/**
	 * Returns a range of all the peoples where casteCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param casteCategoryId the caste category ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @return the range of matching peoples
	 */
	public java.util.List<People> findByCasteCategoryId(
		long casteCategoryId, int start, int end);

	/**
	 * Returns an ordered range of all the peoples where casteCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param casteCategoryId the caste category ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching peoples
	 */
	public java.util.List<People> findByCasteCategoryId(
		long casteCategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<People>
			orderByComparator);

	/**
	 * Returns an ordered range of all the peoples where casteCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param casteCategoryId the caste category ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching peoples
	 */
	public java.util.List<People> findByCasteCategoryId(
		long casteCategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<People>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first people in the ordered set where casteCategoryId = &#63;.
	 *
	 * @param casteCategoryId the caste category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	public People findByCasteCategoryId_First(
			long casteCategoryId,
			com.liferay.portal.kernel.util.OrderByComparator<People>
				orderByComparator)
		throws NoSuchPeopleException;

	/**
	 * Returns the first people in the ordered set where casteCategoryId = &#63;.
	 *
	 * @param casteCategoryId the caste category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people, or <code>null</code> if a matching people could not be found
	 */
	public People fetchByCasteCategoryId_First(
		long casteCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator<People>
			orderByComparator);

	/**
	 * Returns the last people in the ordered set where casteCategoryId = &#63;.
	 *
	 * @param casteCategoryId the caste category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	public People findByCasteCategoryId_Last(
			long casteCategoryId,
			com.liferay.portal.kernel.util.OrderByComparator<People>
				orderByComparator)
		throws NoSuchPeopleException;

	/**
	 * Returns the last people in the ordered set where casteCategoryId = &#63;.
	 *
	 * @param casteCategoryId the caste category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people, or <code>null</code> if a matching people could not be found
	 */
	public People fetchByCasteCategoryId_Last(
		long casteCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator<People>
			orderByComparator);

	/**
	 * Returns the peoples before and after the current people in the ordered set where casteCategoryId = &#63;.
	 *
	 * @param peopleId the primary key of the current people
	 * @param casteCategoryId the caste category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next people
	 * @throws NoSuchPeopleException if a people with the primary key could not be found
	 */
	public People[] findByCasteCategoryId_PrevAndNext(
			long peopleId, long casteCategoryId,
			com.liferay.portal.kernel.util.OrderByComparator<People>
				orderByComparator)
		throws NoSuchPeopleException;

	/**
	 * Removes all the peoples where casteCategoryId = &#63; from the database.
	 *
	 * @param casteCategoryId the caste category ID
	 */
	public void removeByCasteCategoryId(long casteCategoryId);

	/**
	 * Returns the number of peoples where casteCategoryId = &#63;.
	 *
	 * @param casteCategoryId the caste category ID
	 * @return the number of matching peoples
	 */
	public int countByCasteCategoryId(long casteCategoryId);

	/**
	 * Returns all the peoples where bloodGroupId = &#63;.
	 *
	 * @param bloodGroupId the blood group ID
	 * @return the matching peoples
	 */
	public java.util.List<People> findByBloodGroupId(long bloodGroupId);

	/**
	 * Returns a range of all the peoples where bloodGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param bloodGroupId the blood group ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @return the range of matching peoples
	 */
	public java.util.List<People> findByBloodGroupId(
		long bloodGroupId, int start, int end);

	/**
	 * Returns an ordered range of all the peoples where bloodGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param bloodGroupId the blood group ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching peoples
	 */
	public java.util.List<People> findByBloodGroupId(
		long bloodGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<People>
			orderByComparator);

	/**
	 * Returns an ordered range of all the peoples where bloodGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param bloodGroupId the blood group ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching peoples
	 */
	public java.util.List<People> findByBloodGroupId(
		long bloodGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<People>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first people in the ordered set where bloodGroupId = &#63;.
	 *
	 * @param bloodGroupId the blood group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	public People findByBloodGroupId_First(
			long bloodGroupId,
			com.liferay.portal.kernel.util.OrderByComparator<People>
				orderByComparator)
		throws NoSuchPeopleException;

	/**
	 * Returns the first people in the ordered set where bloodGroupId = &#63;.
	 *
	 * @param bloodGroupId the blood group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people, or <code>null</code> if a matching people could not be found
	 */
	public People fetchByBloodGroupId_First(
		long bloodGroupId,
		com.liferay.portal.kernel.util.OrderByComparator<People>
			orderByComparator);

	/**
	 * Returns the last people in the ordered set where bloodGroupId = &#63;.
	 *
	 * @param bloodGroupId the blood group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	public People findByBloodGroupId_Last(
			long bloodGroupId,
			com.liferay.portal.kernel.util.OrderByComparator<People>
				orderByComparator)
		throws NoSuchPeopleException;

	/**
	 * Returns the last people in the ordered set where bloodGroupId = &#63;.
	 *
	 * @param bloodGroupId the blood group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people, or <code>null</code> if a matching people could not be found
	 */
	public People fetchByBloodGroupId_Last(
		long bloodGroupId,
		com.liferay.portal.kernel.util.OrderByComparator<People>
			orderByComparator);

	/**
	 * Returns the peoples before and after the current people in the ordered set where bloodGroupId = &#63;.
	 *
	 * @param peopleId the primary key of the current people
	 * @param bloodGroupId the blood group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next people
	 * @throws NoSuchPeopleException if a people with the primary key could not be found
	 */
	public People[] findByBloodGroupId_PrevAndNext(
			long peopleId, long bloodGroupId,
			com.liferay.portal.kernel.util.OrderByComparator<People>
				orderByComparator)
		throws NoSuchPeopleException;

	/**
	 * Removes all the peoples where bloodGroupId = &#63; from the database.
	 *
	 * @param bloodGroupId the blood group ID
	 */
	public void removeByBloodGroupId(long bloodGroupId);

	/**
	 * Returns the number of peoples where bloodGroupId = &#63;.
	 *
	 * @param bloodGroupId the blood group ID
	 * @return the number of matching peoples
	 */
	public int countByBloodGroupId(long bloodGroupId);

	/**
	 * Returns all the peoples where citizenshipId = &#63;.
	 *
	 * @param citizenshipId the citizenship ID
	 * @return the matching peoples
	 */
	public java.util.List<People> findByCitizenshipId(long citizenshipId);

	/**
	 * Returns a range of all the peoples where citizenshipId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param citizenshipId the citizenship ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @return the range of matching peoples
	 */
	public java.util.List<People> findByCitizenshipId(
		long citizenshipId, int start, int end);

	/**
	 * Returns an ordered range of all the peoples where citizenshipId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param citizenshipId the citizenship ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching peoples
	 */
	public java.util.List<People> findByCitizenshipId(
		long citizenshipId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<People>
			orderByComparator);

	/**
	 * Returns an ordered range of all the peoples where citizenshipId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param citizenshipId the citizenship ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching peoples
	 */
	public java.util.List<People> findByCitizenshipId(
		long citizenshipId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<People>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first people in the ordered set where citizenshipId = &#63;.
	 *
	 * @param citizenshipId the citizenship ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	public People findByCitizenshipId_First(
			long citizenshipId,
			com.liferay.portal.kernel.util.OrderByComparator<People>
				orderByComparator)
		throws NoSuchPeopleException;

	/**
	 * Returns the first people in the ordered set where citizenshipId = &#63;.
	 *
	 * @param citizenshipId the citizenship ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people, or <code>null</code> if a matching people could not be found
	 */
	public People fetchByCitizenshipId_First(
		long citizenshipId,
		com.liferay.portal.kernel.util.OrderByComparator<People>
			orderByComparator);

	/**
	 * Returns the last people in the ordered set where citizenshipId = &#63;.
	 *
	 * @param citizenshipId the citizenship ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	public People findByCitizenshipId_Last(
			long citizenshipId,
			com.liferay.portal.kernel.util.OrderByComparator<People>
				orderByComparator)
		throws NoSuchPeopleException;

	/**
	 * Returns the last people in the ordered set where citizenshipId = &#63;.
	 *
	 * @param citizenshipId the citizenship ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people, or <code>null</code> if a matching people could not be found
	 */
	public People fetchByCitizenshipId_Last(
		long citizenshipId,
		com.liferay.portal.kernel.util.OrderByComparator<People>
			orderByComparator);

	/**
	 * Returns the peoples before and after the current people in the ordered set where citizenshipId = &#63;.
	 *
	 * @param peopleId the primary key of the current people
	 * @param citizenshipId the citizenship ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next people
	 * @throws NoSuchPeopleException if a people with the primary key could not be found
	 */
	public People[] findByCitizenshipId_PrevAndNext(
			long peopleId, long citizenshipId,
			com.liferay.portal.kernel.util.OrderByComparator<People>
				orderByComparator)
		throws NoSuchPeopleException;

	/**
	 * Removes all the peoples where citizenshipId = &#63; from the database.
	 *
	 * @param citizenshipId the citizenship ID
	 */
	public void removeByCitizenshipId(long citizenshipId);

	/**
	 * Returns the number of peoples where citizenshipId = &#63;.
	 *
	 * @param citizenshipId the citizenship ID
	 * @return the number of matching peoples
	 */
	public int countByCitizenshipId(long citizenshipId);

	/**
	 * Returns all the peoples where phTypeId = &#63;.
	 *
	 * @param phTypeId the ph type ID
	 * @return the matching peoples
	 */
	public java.util.List<People> findByPhTypeId(long phTypeId);

	/**
	 * Returns a range of all the peoples where phTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param phTypeId the ph type ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @return the range of matching peoples
	 */
	public java.util.List<People> findByPhTypeId(
		long phTypeId, int start, int end);

	/**
	 * Returns an ordered range of all the peoples where phTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param phTypeId the ph type ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching peoples
	 */
	public java.util.List<People> findByPhTypeId(
		long phTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<People>
			orderByComparator);

	/**
	 * Returns an ordered range of all the peoples where phTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param phTypeId the ph type ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching peoples
	 */
	public java.util.List<People> findByPhTypeId(
		long phTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<People>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first people in the ordered set where phTypeId = &#63;.
	 *
	 * @param phTypeId the ph type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	public People findByPhTypeId_First(
			long phTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<People>
				orderByComparator)
		throws NoSuchPeopleException;

	/**
	 * Returns the first people in the ordered set where phTypeId = &#63;.
	 *
	 * @param phTypeId the ph type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people, or <code>null</code> if a matching people could not be found
	 */
	public People fetchByPhTypeId_First(
		long phTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<People>
			orderByComparator);

	/**
	 * Returns the last people in the ordered set where phTypeId = &#63;.
	 *
	 * @param phTypeId the ph type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	public People findByPhTypeId_Last(
			long phTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<People>
				orderByComparator)
		throws NoSuchPeopleException;

	/**
	 * Returns the last people in the ordered set where phTypeId = &#63;.
	 *
	 * @param phTypeId the ph type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people, or <code>null</code> if a matching people could not be found
	 */
	public People fetchByPhTypeId_Last(
		long phTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<People>
			orderByComparator);

	/**
	 * Returns the peoples before and after the current people in the ordered set where phTypeId = &#63;.
	 *
	 * @param peopleId the primary key of the current people
	 * @param phTypeId the ph type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next people
	 * @throws NoSuchPeopleException if a people with the primary key could not be found
	 */
	public People[] findByPhTypeId_PrevAndNext(
			long peopleId, long phTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<People>
				orderByComparator)
		throws NoSuchPeopleException;

	/**
	 * Removes all the peoples where phTypeId = &#63; from the database.
	 *
	 * @param phTypeId the ph type ID
	 */
	public void removeByPhTypeId(long phTypeId);

	/**
	 * Returns the number of peoples where phTypeId = &#63;.
	 *
	 * @param phTypeId the ph type ID
	 * @return the number of matching peoples
	 */
	public int countByPhTypeId(long phTypeId);

	/**
	 * Returns all the peoples where religionId = &#63;.
	 *
	 * @param religionId the religion ID
	 * @return the matching peoples
	 */
	public java.util.List<People> findByReligionId(long religionId);

	/**
	 * Returns a range of all the peoples where religionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param religionId the religion ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @return the range of matching peoples
	 */
	public java.util.List<People> findByReligionId(
		long religionId, int start, int end);

	/**
	 * Returns an ordered range of all the peoples where religionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param religionId the religion ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching peoples
	 */
	public java.util.List<People> findByReligionId(
		long religionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<People>
			orderByComparator);

	/**
	 * Returns an ordered range of all the peoples where religionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param religionId the religion ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching peoples
	 */
	public java.util.List<People> findByReligionId(
		long religionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<People>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first people in the ordered set where religionId = &#63;.
	 *
	 * @param religionId the religion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	public People findByReligionId_First(
			long religionId,
			com.liferay.portal.kernel.util.OrderByComparator<People>
				orderByComparator)
		throws NoSuchPeopleException;

	/**
	 * Returns the first people in the ordered set where religionId = &#63;.
	 *
	 * @param religionId the religion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people, or <code>null</code> if a matching people could not be found
	 */
	public People fetchByReligionId_First(
		long religionId,
		com.liferay.portal.kernel.util.OrderByComparator<People>
			orderByComparator);

	/**
	 * Returns the last people in the ordered set where religionId = &#63;.
	 *
	 * @param religionId the religion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	public People findByReligionId_Last(
			long religionId,
			com.liferay.portal.kernel.util.OrderByComparator<People>
				orderByComparator)
		throws NoSuchPeopleException;

	/**
	 * Returns the last people in the ordered set where religionId = &#63;.
	 *
	 * @param religionId the religion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people, or <code>null</code> if a matching people could not be found
	 */
	public People fetchByReligionId_Last(
		long religionId,
		com.liferay.portal.kernel.util.OrderByComparator<People>
			orderByComparator);

	/**
	 * Returns the peoples before and after the current people in the ordered set where religionId = &#63;.
	 *
	 * @param peopleId the primary key of the current people
	 * @param religionId the religion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next people
	 * @throws NoSuchPeopleException if a people with the primary key could not be found
	 */
	public People[] findByReligionId_PrevAndNext(
			long peopleId, long religionId,
			com.liferay.portal.kernel.util.OrderByComparator<People>
				orderByComparator)
		throws NoSuchPeopleException;

	/**
	 * Removes all the peoples where religionId = &#63; from the database.
	 *
	 * @param religionId the religion ID
	 */
	public void removeByReligionId(long religionId);

	/**
	 * Returns the number of peoples where religionId = &#63;.
	 *
	 * @param religionId the religion ID
	 * @return the number of matching peoples
	 */
	public int countByReligionId(long religionId);

	/**
	 * Returns all the peoples where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the matching peoples
	 */
	public java.util.List<People> findByJoiningProcessId(long joiningProcessId);

	/**
	 * Returns a range of all the peoples where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @return the range of matching peoples
	 */
	public java.util.List<People> findByJoiningProcessId(
		long joiningProcessId, int start, int end);

	/**
	 * Returns an ordered range of all the peoples where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching peoples
	 */
	public java.util.List<People> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<People>
			orderByComparator);

	/**
	 * Returns an ordered range of all the peoples where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching peoples
	 */
	public java.util.List<People> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<People>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first people in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	public People findByJoiningProcessId_First(
			long joiningProcessId,
			com.liferay.portal.kernel.util.OrderByComparator<People>
				orderByComparator)
		throws NoSuchPeopleException;

	/**
	 * Returns the first people in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching people, or <code>null</code> if a matching people could not be found
	 */
	public People fetchByJoiningProcessId_First(
		long joiningProcessId,
		com.liferay.portal.kernel.util.OrderByComparator<People>
			orderByComparator);

	/**
	 * Returns the last people in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people
	 * @throws NoSuchPeopleException if a matching people could not be found
	 */
	public People findByJoiningProcessId_Last(
			long joiningProcessId,
			com.liferay.portal.kernel.util.OrderByComparator<People>
				orderByComparator)
		throws NoSuchPeopleException;

	/**
	 * Returns the last people in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching people, or <code>null</code> if a matching people could not be found
	 */
	public People fetchByJoiningProcessId_Last(
		long joiningProcessId,
		com.liferay.portal.kernel.util.OrderByComparator<People>
			orderByComparator);

	/**
	 * Returns the peoples before and after the current people in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param peopleId the primary key of the current people
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next people
	 * @throws NoSuchPeopleException if a people with the primary key could not be found
	 */
	public People[] findByJoiningProcessId_PrevAndNext(
			long peopleId, long joiningProcessId,
			com.liferay.portal.kernel.util.OrderByComparator<People>
				orderByComparator)
		throws NoSuchPeopleException;

	/**
	 * Removes all the peoples where joiningProcessId = &#63; from the database.
	 *
	 * @param joiningProcessId the joining process ID
	 */
	public void removeByJoiningProcessId(long joiningProcessId);

	/**
	 * Returns the number of peoples where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the number of matching peoples
	 */
	public int countByJoiningProcessId(long joiningProcessId);

	/**
	 * Caches the people in the entity cache if it is enabled.
	 *
	 * @param people the people
	 */
	public void cacheResult(People people);

	/**
	 * Caches the peoples in the entity cache if it is enabled.
	 *
	 * @param peoples the peoples
	 */
	public void cacheResult(java.util.List<People> peoples);

	/**
	 * Creates a new people with the primary key. Does not add the people to the database.
	 *
	 * @param peopleId the primary key for the new people
	 * @return the new people
	 */
	public People create(long peopleId);

	/**
	 * Removes the people with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param peopleId the primary key of the people
	 * @return the people that was removed
	 * @throws NoSuchPeopleException if a people with the primary key could not be found
	 */
	public People remove(long peopleId) throws NoSuchPeopleException;

	public People updateImpl(People people);

	/**
	 * Returns the people with the primary key or throws a <code>NoSuchPeopleException</code> if it could not be found.
	 *
	 * @param peopleId the primary key of the people
	 * @return the people
	 * @throws NoSuchPeopleException if a people with the primary key could not be found
	 */
	public People findByPrimaryKey(long peopleId) throws NoSuchPeopleException;

	/**
	 * Returns the people with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param peopleId the primary key of the people
	 * @return the people, or <code>null</code> if a people with the primary key could not be found
	 */
	public People fetchByPrimaryKey(long peopleId);

	/**
	 * Returns all the peoples.
	 *
	 * @return the peoples
	 */
	public java.util.List<People> findAll();

	/**
	 * Returns a range of all the peoples.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @return the range of peoples
	 */
	public java.util.List<People> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the peoples.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of peoples
	 */
	public java.util.List<People> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<People>
			orderByComparator);

	/**
	 * Returns an ordered range of all the peoples.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeopleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of peoples
	 * @param end the upper bound of the range of peoples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of peoples
	 */
	public java.util.List<People> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<People>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the peoples from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of peoples.
	 *
	 * @return the number of peoples
	 */
	public int countAll();

}