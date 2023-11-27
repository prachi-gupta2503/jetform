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

import com.adjecti.mdm.liferay.exception.NoSuchDesignationModeException;
import com.adjecti.mdm.liferay.model.DesignationMode;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the designation mode service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DesignationModeUtil
 * @generated
 */
@ProviderType
public interface DesignationModePersistence
	extends BasePersistence<DesignationMode> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DesignationModeUtil} to access the designation mode persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the designation modes where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching designation modes
	 */
	public java.util.List<DesignationMode> findByCode(String code);

	/**
	 * Returns a range of all the designation modes where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModeModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of designation modes
	 * @param end the upper bound of the range of designation modes (not inclusive)
	 * @return the range of matching designation modes
	 */
	public java.util.List<DesignationMode> findByCode(
		String code, int start, int end);

	/**
	 * Returns an ordered range of all the designation modes where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModeModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of designation modes
	 * @param end the upper bound of the range of designation modes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching designation modes
	 */
	public java.util.List<DesignationMode> findByCode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DesignationMode>
			orderByComparator);

	/**
	 * Returns an ordered range of all the designation modes where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModeModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of designation modes
	 * @param end the upper bound of the range of designation modes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching designation modes
	 */
	public java.util.List<DesignationMode> findByCode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DesignationMode>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first designation mode in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation mode
	 * @throws NoSuchDesignationModeException if a matching designation mode could not be found
	 */
	public DesignationMode findByCode_First(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator<DesignationMode>
				orderByComparator)
		throws NoSuchDesignationModeException;

	/**
	 * Returns the first designation mode in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation mode, or <code>null</code> if a matching designation mode could not be found
	 */
	public DesignationMode fetchByCode_First(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<DesignationMode>
			orderByComparator);

	/**
	 * Returns the last designation mode in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation mode
	 * @throws NoSuchDesignationModeException if a matching designation mode could not be found
	 */
	public DesignationMode findByCode_Last(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator<DesignationMode>
				orderByComparator)
		throws NoSuchDesignationModeException;

	/**
	 * Returns the last designation mode in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation mode, or <code>null</code> if a matching designation mode could not be found
	 */
	public DesignationMode fetchByCode_Last(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<DesignationMode>
			orderByComparator);

	/**
	 * Returns the designation modes before and after the current designation mode in the ordered set where code = &#63;.
	 *
	 * @param designationModeId the primary key of the current designation mode
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next designation mode
	 * @throws NoSuchDesignationModeException if a designation mode with the primary key could not be found
	 */
	public DesignationMode[] findByCode_PrevAndNext(
			long designationModeId, String code,
			com.liferay.portal.kernel.util.OrderByComparator<DesignationMode>
				orderByComparator)
		throws NoSuchDesignationModeException;

	/**
	 * Removes all the designation modes where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public void removeByCode(String code);

	/**
	 * Returns the number of designation modes where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching designation modes
	 */
	public int countByCode(String code);

	/**
	 * Returns all the designation modes where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching designation modes
	 */
	public java.util.List<DesignationMode> findByName(String name);

	/**
	 * Returns a range of all the designation modes where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of designation modes
	 * @param end the upper bound of the range of designation modes (not inclusive)
	 * @return the range of matching designation modes
	 */
	public java.util.List<DesignationMode> findByName(
		String name, int start, int end);

	/**
	 * Returns an ordered range of all the designation modes where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of designation modes
	 * @param end the upper bound of the range of designation modes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching designation modes
	 */
	public java.util.List<DesignationMode> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DesignationMode>
			orderByComparator);

	/**
	 * Returns an ordered range of all the designation modes where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of designation modes
	 * @param end the upper bound of the range of designation modes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching designation modes
	 */
	public java.util.List<DesignationMode> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DesignationMode>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first designation mode in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation mode
	 * @throws NoSuchDesignationModeException if a matching designation mode could not be found
	 */
	public DesignationMode findByName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<DesignationMode>
				orderByComparator)
		throws NoSuchDesignationModeException;

	/**
	 * Returns the first designation mode in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation mode, or <code>null</code> if a matching designation mode could not be found
	 */
	public DesignationMode fetchByName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<DesignationMode>
			orderByComparator);

	/**
	 * Returns the last designation mode in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation mode
	 * @throws NoSuchDesignationModeException if a matching designation mode could not be found
	 */
	public DesignationMode findByName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<DesignationMode>
				orderByComparator)
		throws NoSuchDesignationModeException;

	/**
	 * Returns the last designation mode in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation mode, or <code>null</code> if a matching designation mode could not be found
	 */
	public DesignationMode fetchByName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<DesignationMode>
			orderByComparator);

	/**
	 * Returns the designation modes before and after the current designation mode in the ordered set where name = &#63;.
	 *
	 * @param designationModeId the primary key of the current designation mode
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next designation mode
	 * @throws NoSuchDesignationModeException if a designation mode with the primary key could not be found
	 */
	public DesignationMode[] findByName_PrevAndNext(
			long designationModeId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<DesignationMode>
				orderByComparator)
		throws NoSuchDesignationModeException;

	/**
	 * Removes all the designation modes where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByName(String name);

	/**
	 * Returns the number of designation modes where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching designation modes
	 */
	public int countByName(String name);

	/**
	 * Caches the designation mode in the entity cache if it is enabled.
	 *
	 * @param designationMode the designation mode
	 */
	public void cacheResult(DesignationMode designationMode);

	/**
	 * Caches the designation modes in the entity cache if it is enabled.
	 *
	 * @param designationModes the designation modes
	 */
	public void cacheResult(java.util.List<DesignationMode> designationModes);

	/**
	 * Creates a new designation mode with the primary key. Does not add the designation mode to the database.
	 *
	 * @param designationModeId the primary key for the new designation mode
	 * @return the new designation mode
	 */
	public DesignationMode create(long designationModeId);

	/**
	 * Removes the designation mode with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param designationModeId the primary key of the designation mode
	 * @return the designation mode that was removed
	 * @throws NoSuchDesignationModeException if a designation mode with the primary key could not be found
	 */
	public DesignationMode remove(long designationModeId)
		throws NoSuchDesignationModeException;

	public DesignationMode updateImpl(DesignationMode designationMode);

	/**
	 * Returns the designation mode with the primary key or throws a <code>NoSuchDesignationModeException</code> if it could not be found.
	 *
	 * @param designationModeId the primary key of the designation mode
	 * @return the designation mode
	 * @throws NoSuchDesignationModeException if a designation mode with the primary key could not be found
	 */
	public DesignationMode findByPrimaryKey(long designationModeId)
		throws NoSuchDesignationModeException;

	/**
	 * Returns the designation mode with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param designationModeId the primary key of the designation mode
	 * @return the designation mode, or <code>null</code> if a designation mode with the primary key could not be found
	 */
	public DesignationMode fetchByPrimaryKey(long designationModeId);

	/**
	 * Returns all the designation modes.
	 *
	 * @return the designation modes
	 */
	public java.util.List<DesignationMode> findAll();

	/**
	 * Returns a range of all the designation modes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation modes
	 * @param end the upper bound of the range of designation modes (not inclusive)
	 * @return the range of designation modes
	 */
	public java.util.List<DesignationMode> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the designation modes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation modes
	 * @param end the upper bound of the range of designation modes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of designation modes
	 */
	public java.util.List<DesignationMode> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DesignationMode>
			orderByComparator);

	/**
	 * Returns an ordered range of all the designation modes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation modes
	 * @param end the upper bound of the range of designation modes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of designation modes
	 */
	public java.util.List<DesignationMode> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DesignationMode>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the designation modes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of designation modes.
	 *
	 * @return the number of designation modes
	 */
	public int countAll();

}