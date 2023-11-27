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

package com.adjecti.noting.service.persistence;

import com.adjecti.noting.exception.NoSuchNotingException;
import com.adjecti.noting.model.Noting;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the noting service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NotingUtil
 * @generated
 */
@ProviderType
public interface NotingPersistence extends BasePersistence<Noting> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NotingUtil} to access the noting persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the notings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching notings
	 */
	public java.util.List<Noting> findByUuid(String uuid);

	/**
	 * Returns a range of all the notings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of notings
	 * @param end the upper bound of the range of notings (not inclusive)
	 * @return the range of matching notings
	 */
	public java.util.List<Noting> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the notings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of notings
	 * @param end the upper bound of the range of notings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notings
	 */
	public java.util.List<Noting> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Noting>
			orderByComparator);

	/**
	 * Returns an ordered range of all the notings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of notings
	 * @param end the upper bound of the range of notings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching notings
	 */
	public java.util.List<Noting> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Noting>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first noting in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching noting
	 * @throws NoSuchNotingException if a matching noting could not be found
	 */
	public Noting findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Noting>
				orderByComparator)
		throws NoSuchNotingException;

	/**
	 * Returns the first noting in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching noting, or <code>null</code> if a matching noting could not be found
	 */
	public Noting fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Noting>
			orderByComparator);

	/**
	 * Returns the last noting in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching noting
	 * @throws NoSuchNotingException if a matching noting could not be found
	 */
	public Noting findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Noting>
				orderByComparator)
		throws NoSuchNotingException;

	/**
	 * Returns the last noting in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching noting, or <code>null</code> if a matching noting could not be found
	 */
	public Noting fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Noting>
			orderByComparator);

	/**
	 * Returns the notings before and after the current noting in the ordered set where uuid = &#63;.
	 *
	 * @param noteId the primary key of the current noting
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next noting
	 * @throws NoSuchNotingException if a noting with the primary key could not be found
	 */
	public Noting[] findByUuid_PrevAndNext(
			long noteId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Noting>
				orderByComparator)
		throws NoSuchNotingException;

	/**
	 * Removes all the notings where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of notings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching notings
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the noting where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchNotingException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching noting
	 * @throws NoSuchNotingException if a matching noting could not be found
	 */
	public Noting findByUUID_G(String uuid, long groupId)
		throws NoSuchNotingException;

	/**
	 * Returns the noting where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching noting, or <code>null</code> if a matching noting could not be found
	 */
	public Noting fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the noting where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching noting, or <code>null</code> if a matching noting could not be found
	 */
	public Noting fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the noting where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the noting that was removed
	 */
	public Noting removeByUUID_G(String uuid, long groupId)
		throws NoSuchNotingException;

	/**
	 * Returns the number of notings where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching notings
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the notings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching notings
	 */
	public java.util.List<Noting> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the notings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of notings
	 * @param end the upper bound of the range of notings (not inclusive)
	 * @return the range of matching notings
	 */
	public java.util.List<Noting> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the notings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of notings
	 * @param end the upper bound of the range of notings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notings
	 */
	public java.util.List<Noting> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Noting>
			orderByComparator);

	/**
	 * Returns an ordered range of all the notings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of notings
	 * @param end the upper bound of the range of notings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching notings
	 */
	public java.util.List<Noting> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Noting>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first noting in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching noting
	 * @throws NoSuchNotingException if a matching noting could not be found
	 */
	public Noting findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Noting>
				orderByComparator)
		throws NoSuchNotingException;

	/**
	 * Returns the first noting in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching noting, or <code>null</code> if a matching noting could not be found
	 */
	public Noting fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Noting>
			orderByComparator);

	/**
	 * Returns the last noting in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching noting
	 * @throws NoSuchNotingException if a matching noting could not be found
	 */
	public Noting findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Noting>
				orderByComparator)
		throws NoSuchNotingException;

	/**
	 * Returns the last noting in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching noting, or <code>null</code> if a matching noting could not be found
	 */
	public Noting fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Noting>
			orderByComparator);

	/**
	 * Returns the notings before and after the current noting in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param noteId the primary key of the current noting
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next noting
	 * @throws NoSuchNotingException if a noting with the primary key could not be found
	 */
	public Noting[] findByUuid_C_PrevAndNext(
			long noteId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Noting>
				orderByComparator)
		throws NoSuchNotingException;

	/**
	 * Removes all the notings where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of notings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching notings
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the noting in the entity cache if it is enabled.
	 *
	 * @param noting the noting
	 */
	public void cacheResult(Noting noting);

	/**
	 * Caches the notings in the entity cache if it is enabled.
	 *
	 * @param notings the notings
	 */
	public void cacheResult(java.util.List<Noting> notings);

	/**
	 * Creates a new noting with the primary key. Does not add the noting to the database.
	 *
	 * @param noteId the primary key for the new noting
	 * @return the new noting
	 */
	public Noting create(long noteId);

	/**
	 * Removes the noting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param noteId the primary key of the noting
	 * @return the noting that was removed
	 * @throws NoSuchNotingException if a noting with the primary key could not be found
	 */
	public Noting remove(long noteId) throws NoSuchNotingException;

	public Noting updateImpl(Noting noting);

	/**
	 * Returns the noting with the primary key or throws a <code>NoSuchNotingException</code> if it could not be found.
	 *
	 * @param noteId the primary key of the noting
	 * @return the noting
	 * @throws NoSuchNotingException if a noting with the primary key could not be found
	 */
	public Noting findByPrimaryKey(long noteId) throws NoSuchNotingException;

	/**
	 * Returns the noting with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param noteId the primary key of the noting
	 * @return the noting, or <code>null</code> if a noting with the primary key could not be found
	 */
	public Noting fetchByPrimaryKey(long noteId);

	/**
	 * Returns all the notings.
	 *
	 * @return the notings
	 */
	public java.util.List<Noting> findAll();

	/**
	 * Returns a range of all the notings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of notings
	 * @param end the upper bound of the range of notings (not inclusive)
	 * @return the range of notings
	 */
	public java.util.List<Noting> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the notings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of notings
	 * @param end the upper bound of the range of notings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of notings
	 */
	public java.util.List<Noting> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Noting>
			orderByComparator);

	/**
	 * Returns an ordered range of all the notings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of notings
	 * @param end the upper bound of the range of notings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of notings
	 */
	public java.util.List<Noting> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Noting>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the notings from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of notings.
	 *
	 * @return the number of notings
	 */
	public int countAll();

}