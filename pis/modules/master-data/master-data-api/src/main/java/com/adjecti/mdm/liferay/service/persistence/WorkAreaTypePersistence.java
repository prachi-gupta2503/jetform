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

import com.adjecti.mdm.liferay.exception.NoSuchWorkAreaTypeException;
import com.adjecti.mdm.liferay.model.WorkAreaType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the work area type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkAreaTypeUtil
 * @generated
 */
@ProviderType
public interface WorkAreaTypePersistence extends BasePersistence<WorkAreaType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WorkAreaTypeUtil} to access the work area type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the work area types where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching work area types
	 */
	public java.util.List<WorkAreaType> findByCode(String code);

	/**
	 * Returns a range of all the work area types where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of work area types
	 * @param end the upper bound of the range of work area types (not inclusive)
	 * @return the range of matching work area types
	 */
	public java.util.List<WorkAreaType> findByCode(
		String code, int start, int end);

	/**
	 * Returns an ordered range of all the work area types where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of work area types
	 * @param end the upper bound of the range of work area types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work area types
	 */
	public java.util.List<WorkAreaType> findByCode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkAreaType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work area types where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of work area types
	 * @param end the upper bound of the range of work area types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work area types
	 */
	public java.util.List<WorkAreaType> findByCode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkAreaType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first work area type in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area type
	 * @throws NoSuchWorkAreaTypeException if a matching work area type could not be found
	 */
	public WorkAreaType findByCode_First(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator<WorkAreaType>
				orderByComparator)
		throws NoSuchWorkAreaTypeException;

	/**
	 * Returns the first work area type in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area type, or <code>null</code> if a matching work area type could not be found
	 */
	public WorkAreaType fetchByCode_First(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<WorkAreaType>
			orderByComparator);

	/**
	 * Returns the last work area type in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area type
	 * @throws NoSuchWorkAreaTypeException if a matching work area type could not be found
	 */
	public WorkAreaType findByCode_Last(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator<WorkAreaType>
				orderByComparator)
		throws NoSuchWorkAreaTypeException;

	/**
	 * Returns the last work area type in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area type, or <code>null</code> if a matching work area type could not be found
	 */
	public WorkAreaType fetchByCode_Last(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<WorkAreaType>
			orderByComparator);

	/**
	 * Returns the work area types before and after the current work area type in the ordered set where code = &#63;.
	 *
	 * @param workAreaTypeId the primary key of the current work area type
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work area type
	 * @throws NoSuchWorkAreaTypeException if a work area type with the primary key could not be found
	 */
	public WorkAreaType[] findByCode_PrevAndNext(
			long workAreaTypeId, String code,
			com.liferay.portal.kernel.util.OrderByComparator<WorkAreaType>
				orderByComparator)
		throws NoSuchWorkAreaTypeException;

	/**
	 * Removes all the work area types where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public void removeByCode(String code);

	/**
	 * Returns the number of work area types where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching work area types
	 */
	public int countByCode(String code);

	/**
	 * Returns all the work area types where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching work area types
	 */
	public java.util.List<WorkAreaType> findByName(String name);

	/**
	 * Returns a range of all the work area types where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of work area types
	 * @param end the upper bound of the range of work area types (not inclusive)
	 * @return the range of matching work area types
	 */
	public java.util.List<WorkAreaType> findByName(
		String name, int start, int end);

	/**
	 * Returns an ordered range of all the work area types where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of work area types
	 * @param end the upper bound of the range of work area types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work area types
	 */
	public java.util.List<WorkAreaType> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkAreaType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work area types where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of work area types
	 * @param end the upper bound of the range of work area types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work area types
	 */
	public java.util.List<WorkAreaType> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkAreaType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first work area type in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area type
	 * @throws NoSuchWorkAreaTypeException if a matching work area type could not be found
	 */
	public WorkAreaType findByName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<WorkAreaType>
				orderByComparator)
		throws NoSuchWorkAreaTypeException;

	/**
	 * Returns the first work area type in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area type, or <code>null</code> if a matching work area type could not be found
	 */
	public WorkAreaType fetchByName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<WorkAreaType>
			orderByComparator);

	/**
	 * Returns the last work area type in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area type
	 * @throws NoSuchWorkAreaTypeException if a matching work area type could not be found
	 */
	public WorkAreaType findByName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<WorkAreaType>
				orderByComparator)
		throws NoSuchWorkAreaTypeException;

	/**
	 * Returns the last work area type in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area type, or <code>null</code> if a matching work area type could not be found
	 */
	public WorkAreaType fetchByName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<WorkAreaType>
			orderByComparator);

	/**
	 * Returns the work area types before and after the current work area type in the ordered set where name = &#63;.
	 *
	 * @param workAreaTypeId the primary key of the current work area type
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work area type
	 * @throws NoSuchWorkAreaTypeException if a work area type with the primary key could not be found
	 */
	public WorkAreaType[] findByName_PrevAndNext(
			long workAreaTypeId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<WorkAreaType>
				orderByComparator)
		throws NoSuchWorkAreaTypeException;

	/**
	 * Removes all the work area types where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByName(String name);

	/**
	 * Returns the number of work area types where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching work area types
	 */
	public int countByName(String name);

	/**
	 * Caches the work area type in the entity cache if it is enabled.
	 *
	 * @param workAreaType the work area type
	 */
	public void cacheResult(WorkAreaType workAreaType);

	/**
	 * Caches the work area types in the entity cache if it is enabled.
	 *
	 * @param workAreaTypes the work area types
	 */
	public void cacheResult(java.util.List<WorkAreaType> workAreaTypes);

	/**
	 * Creates a new work area type with the primary key. Does not add the work area type to the database.
	 *
	 * @param workAreaTypeId the primary key for the new work area type
	 * @return the new work area type
	 */
	public WorkAreaType create(long workAreaTypeId);

	/**
	 * Removes the work area type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workAreaTypeId the primary key of the work area type
	 * @return the work area type that was removed
	 * @throws NoSuchWorkAreaTypeException if a work area type with the primary key could not be found
	 */
	public WorkAreaType remove(long workAreaTypeId)
		throws NoSuchWorkAreaTypeException;

	public WorkAreaType updateImpl(WorkAreaType workAreaType);

	/**
	 * Returns the work area type with the primary key or throws a <code>NoSuchWorkAreaTypeException</code> if it could not be found.
	 *
	 * @param workAreaTypeId the primary key of the work area type
	 * @return the work area type
	 * @throws NoSuchWorkAreaTypeException if a work area type with the primary key could not be found
	 */
	public WorkAreaType findByPrimaryKey(long workAreaTypeId)
		throws NoSuchWorkAreaTypeException;

	/**
	 * Returns the work area type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workAreaTypeId the primary key of the work area type
	 * @return the work area type, or <code>null</code> if a work area type with the primary key could not be found
	 */
	public WorkAreaType fetchByPrimaryKey(long workAreaTypeId);

	/**
	 * Returns all the work area types.
	 *
	 * @return the work area types
	 */
	public java.util.List<WorkAreaType> findAll();

	/**
	 * Returns a range of all the work area types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work area types
	 * @param end the upper bound of the range of work area types (not inclusive)
	 * @return the range of work area types
	 */
	public java.util.List<WorkAreaType> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the work area types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work area types
	 * @param end the upper bound of the range of work area types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of work area types
	 */
	public java.util.List<WorkAreaType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkAreaType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work area types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work area types
	 * @param end the upper bound of the range of work area types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of work area types
	 */
	public java.util.List<WorkAreaType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkAreaType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the work area types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of work area types.
	 *
	 * @return the number of work area types
	 */
	public int countAll();

}