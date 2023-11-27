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

import com.adjecti.mdm.liferay.exception.NoSuchOEMException;
import com.adjecti.mdm.liferay.model.OEM;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the oem service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OEMUtil
 * @generated
 */
@ProviderType
public interface OEMPersistence extends BasePersistence<OEM> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OEMUtil} to access the oem persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the oems where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching oems
	 */
	public java.util.List<OEM> findByCode(String code);

	/**
	 * Returns a range of all the oems where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OEMModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of oems
	 * @param end the upper bound of the range of oems (not inclusive)
	 * @return the range of matching oems
	 */
	public java.util.List<OEM> findByCode(String code, int start, int end);

	/**
	 * Returns an ordered range of all the oems where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OEMModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of oems
	 * @param end the upper bound of the range of oems (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching oems
	 */
	public java.util.List<OEM> findByCode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OEM>
			orderByComparator);

	/**
	 * Returns an ordered range of all the oems where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OEMModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of oems
	 * @param end the upper bound of the range of oems (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching oems
	 */
	public java.util.List<OEM> findByCode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OEM> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first oem in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching oem
	 * @throws NoSuchOEMException if a matching oem could not be found
	 */
	public OEM findByCode_First(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator<OEM>
				orderByComparator)
		throws NoSuchOEMException;

	/**
	 * Returns the first oem in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching oem, or <code>null</code> if a matching oem could not be found
	 */
	public OEM fetchByCode_First(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<OEM>
			orderByComparator);

	/**
	 * Returns the last oem in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching oem
	 * @throws NoSuchOEMException if a matching oem could not be found
	 */
	public OEM findByCode_Last(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator<OEM>
				orderByComparator)
		throws NoSuchOEMException;

	/**
	 * Returns the last oem in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching oem, or <code>null</code> if a matching oem could not be found
	 */
	public OEM fetchByCode_Last(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<OEM>
			orderByComparator);

	/**
	 * Returns the oems before and after the current oem in the ordered set where code = &#63;.
	 *
	 * @param oemId the primary key of the current oem
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next oem
	 * @throws NoSuchOEMException if a oem with the primary key could not be found
	 */
	public OEM[] findByCode_PrevAndNext(
			long oemId, String code,
			com.liferay.portal.kernel.util.OrderByComparator<OEM>
				orderByComparator)
		throws NoSuchOEMException;

	/**
	 * Removes all the oems where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public void removeByCode(String code);

	/**
	 * Returns the number of oems where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching oems
	 */
	public int countByCode(String code);

	/**
	 * Returns all the oems where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching oems
	 */
	public java.util.List<OEM> findByName(String name);

	/**
	 * Returns a range of all the oems where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OEMModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of oems
	 * @param end the upper bound of the range of oems (not inclusive)
	 * @return the range of matching oems
	 */
	public java.util.List<OEM> findByName(String name, int start, int end);

	/**
	 * Returns an ordered range of all the oems where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OEMModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of oems
	 * @param end the upper bound of the range of oems (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching oems
	 */
	public java.util.List<OEM> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OEM>
			orderByComparator);

	/**
	 * Returns an ordered range of all the oems where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OEMModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of oems
	 * @param end the upper bound of the range of oems (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching oems
	 */
	public java.util.List<OEM> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OEM> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first oem in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching oem
	 * @throws NoSuchOEMException if a matching oem could not be found
	 */
	public OEM findByName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<OEM>
				orderByComparator)
		throws NoSuchOEMException;

	/**
	 * Returns the first oem in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching oem, or <code>null</code> if a matching oem could not be found
	 */
	public OEM fetchByName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<OEM>
			orderByComparator);

	/**
	 * Returns the last oem in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching oem
	 * @throws NoSuchOEMException if a matching oem could not be found
	 */
	public OEM findByName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<OEM>
				orderByComparator)
		throws NoSuchOEMException;

	/**
	 * Returns the last oem in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching oem, or <code>null</code> if a matching oem could not be found
	 */
	public OEM fetchByName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<OEM>
			orderByComparator);

	/**
	 * Returns the oems before and after the current oem in the ordered set where name = &#63;.
	 *
	 * @param oemId the primary key of the current oem
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next oem
	 * @throws NoSuchOEMException if a oem with the primary key could not be found
	 */
	public OEM[] findByName_PrevAndNext(
			long oemId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<OEM>
				orderByComparator)
		throws NoSuchOEMException;

	/**
	 * Removes all the oems where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByName(String name);

	/**
	 * Returns the number of oems where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching oems
	 */
	public int countByName(String name);

	/**
	 * Caches the oem in the entity cache if it is enabled.
	 *
	 * @param oem the oem
	 */
	public void cacheResult(OEM oem);

	/**
	 * Caches the oems in the entity cache if it is enabled.
	 *
	 * @param oems the oems
	 */
	public void cacheResult(java.util.List<OEM> oems);

	/**
	 * Creates a new oem with the primary key. Does not add the oem to the database.
	 *
	 * @param oemId the primary key for the new oem
	 * @return the new oem
	 */
	public OEM create(long oemId);

	/**
	 * Removes the oem with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param oemId the primary key of the oem
	 * @return the oem that was removed
	 * @throws NoSuchOEMException if a oem with the primary key could not be found
	 */
	public OEM remove(long oemId) throws NoSuchOEMException;

	public OEM updateImpl(OEM oem);

	/**
	 * Returns the oem with the primary key or throws a <code>NoSuchOEMException</code> if it could not be found.
	 *
	 * @param oemId the primary key of the oem
	 * @return the oem
	 * @throws NoSuchOEMException if a oem with the primary key could not be found
	 */
	public OEM findByPrimaryKey(long oemId) throws NoSuchOEMException;

	/**
	 * Returns the oem with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param oemId the primary key of the oem
	 * @return the oem, or <code>null</code> if a oem with the primary key could not be found
	 */
	public OEM fetchByPrimaryKey(long oemId);

	/**
	 * Returns all the oems.
	 *
	 * @return the oems
	 */
	public java.util.List<OEM> findAll();

	/**
	 * Returns a range of all the oems.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OEMModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of oems
	 * @param end the upper bound of the range of oems (not inclusive)
	 * @return the range of oems
	 */
	public java.util.List<OEM> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the oems.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OEMModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of oems
	 * @param end the upper bound of the range of oems (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of oems
	 */
	public java.util.List<OEM> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OEM>
			orderByComparator);

	/**
	 * Returns an ordered range of all the oems.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OEMModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of oems
	 * @param end the upper bound of the range of oems (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of oems
	 */
	public java.util.List<OEM> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OEM> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the oems from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of oems.
	 *
	 * @return the number of oems
	 */
	public int countAll();

}