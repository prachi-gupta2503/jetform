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

import com.adjecti.mdm.liferay.exception.NoSuchWorkAreaException;
import com.adjecti.mdm.liferay.model.WorkArea;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the work area service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkAreaUtil
 * @generated
 */
@ProviderType
public interface WorkAreaPersistence extends BasePersistence<WorkArea> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WorkAreaUtil} to access the work area persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the work areas where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching work areas
	 */
	public java.util.List<WorkArea> findByCode(String code);

	/**
	 * Returns a range of all the work areas where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of work areas
	 * @param end the upper bound of the range of work areas (not inclusive)
	 * @return the range of matching work areas
	 */
	public java.util.List<WorkArea> findByCode(String code, int start, int end);

	/**
	 * Returns an ordered range of all the work areas where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of work areas
	 * @param end the upper bound of the range of work areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work areas
	 */
	public java.util.List<WorkArea> findByCode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkArea>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work areas where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of work areas
	 * @param end the upper bound of the range of work areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work areas
	 */
	public java.util.List<WorkArea> findByCode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkArea>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first work area in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area
	 * @throws NoSuchWorkAreaException if a matching work area could not be found
	 */
	public WorkArea findByCode_First(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator<WorkArea>
				orderByComparator)
		throws NoSuchWorkAreaException;

	/**
	 * Returns the first work area in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area, or <code>null</code> if a matching work area could not be found
	 */
	public WorkArea fetchByCode_First(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<WorkArea>
			orderByComparator);

	/**
	 * Returns the last work area in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area
	 * @throws NoSuchWorkAreaException if a matching work area could not be found
	 */
	public WorkArea findByCode_Last(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator<WorkArea>
				orderByComparator)
		throws NoSuchWorkAreaException;

	/**
	 * Returns the last work area in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area, or <code>null</code> if a matching work area could not be found
	 */
	public WorkArea fetchByCode_Last(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<WorkArea>
			orderByComparator);

	/**
	 * Returns the work areas before and after the current work area in the ordered set where code = &#63;.
	 *
	 * @param workAreaId the primary key of the current work area
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work area
	 * @throws NoSuchWorkAreaException if a work area with the primary key could not be found
	 */
	public WorkArea[] findByCode_PrevAndNext(
			long workAreaId, String code,
			com.liferay.portal.kernel.util.OrderByComparator<WorkArea>
				orderByComparator)
		throws NoSuchWorkAreaException;

	/**
	 * Removes all the work areas where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public void removeByCode(String code);

	/**
	 * Returns the number of work areas where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching work areas
	 */
	public int countByCode(String code);

	/**
	 * Returns all the work areas where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching work areas
	 */
	public java.util.List<WorkArea> findByName(String name);

	/**
	 * Returns a range of all the work areas where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of work areas
	 * @param end the upper bound of the range of work areas (not inclusive)
	 * @return the range of matching work areas
	 */
	public java.util.List<WorkArea> findByName(String name, int start, int end);

	/**
	 * Returns an ordered range of all the work areas where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of work areas
	 * @param end the upper bound of the range of work areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work areas
	 */
	public java.util.List<WorkArea> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkArea>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work areas where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of work areas
	 * @param end the upper bound of the range of work areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work areas
	 */
	public java.util.List<WorkArea> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkArea>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first work area in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area
	 * @throws NoSuchWorkAreaException if a matching work area could not be found
	 */
	public WorkArea findByName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<WorkArea>
				orderByComparator)
		throws NoSuchWorkAreaException;

	/**
	 * Returns the first work area in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area, or <code>null</code> if a matching work area could not be found
	 */
	public WorkArea fetchByName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<WorkArea>
			orderByComparator);

	/**
	 * Returns the last work area in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area
	 * @throws NoSuchWorkAreaException if a matching work area could not be found
	 */
	public WorkArea findByName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<WorkArea>
				orderByComparator)
		throws NoSuchWorkAreaException;

	/**
	 * Returns the last work area in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area, or <code>null</code> if a matching work area could not be found
	 */
	public WorkArea fetchByName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<WorkArea>
			orderByComparator);

	/**
	 * Returns the work areas before and after the current work area in the ordered set where name = &#63;.
	 *
	 * @param workAreaId the primary key of the current work area
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work area
	 * @throws NoSuchWorkAreaException if a work area with the primary key could not be found
	 */
	public WorkArea[] findByName_PrevAndNext(
			long workAreaId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<WorkArea>
				orderByComparator)
		throws NoSuchWorkAreaException;

	/**
	 * Removes all the work areas where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByName(String name);

	/**
	 * Returns the number of work areas where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching work areas
	 */
	public int countByName(String name);

	/**
	 * Returns all the work areas where parentWorkAreaId = &#63;.
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @return the matching work areas
	 */
	public java.util.List<WorkArea> findByParentWorkAreaId(
		long parentWorkAreaId);

	/**
	 * Returns a range of all the work areas where parentWorkAreaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @param start the lower bound of the range of work areas
	 * @param end the upper bound of the range of work areas (not inclusive)
	 * @return the range of matching work areas
	 */
	public java.util.List<WorkArea> findByParentWorkAreaId(
		long parentWorkAreaId, int start, int end);

	/**
	 * Returns an ordered range of all the work areas where parentWorkAreaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @param start the lower bound of the range of work areas
	 * @param end the upper bound of the range of work areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work areas
	 */
	public java.util.List<WorkArea> findByParentWorkAreaId(
		long parentWorkAreaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkArea>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work areas where parentWorkAreaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @param start the lower bound of the range of work areas
	 * @param end the upper bound of the range of work areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work areas
	 */
	public java.util.List<WorkArea> findByParentWorkAreaId(
		long parentWorkAreaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkArea>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first work area in the ordered set where parentWorkAreaId = &#63;.
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area
	 * @throws NoSuchWorkAreaException if a matching work area could not be found
	 */
	public WorkArea findByParentWorkAreaId_First(
			long parentWorkAreaId,
			com.liferay.portal.kernel.util.OrderByComparator<WorkArea>
				orderByComparator)
		throws NoSuchWorkAreaException;

	/**
	 * Returns the first work area in the ordered set where parentWorkAreaId = &#63;.
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area, or <code>null</code> if a matching work area could not be found
	 */
	public WorkArea fetchByParentWorkAreaId_First(
		long parentWorkAreaId,
		com.liferay.portal.kernel.util.OrderByComparator<WorkArea>
			orderByComparator);

	/**
	 * Returns the last work area in the ordered set where parentWorkAreaId = &#63;.
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area
	 * @throws NoSuchWorkAreaException if a matching work area could not be found
	 */
	public WorkArea findByParentWorkAreaId_Last(
			long parentWorkAreaId,
			com.liferay.portal.kernel.util.OrderByComparator<WorkArea>
				orderByComparator)
		throws NoSuchWorkAreaException;

	/**
	 * Returns the last work area in the ordered set where parentWorkAreaId = &#63;.
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area, or <code>null</code> if a matching work area could not be found
	 */
	public WorkArea fetchByParentWorkAreaId_Last(
		long parentWorkAreaId,
		com.liferay.portal.kernel.util.OrderByComparator<WorkArea>
			orderByComparator);

	/**
	 * Returns the work areas before and after the current work area in the ordered set where parentWorkAreaId = &#63;.
	 *
	 * @param workAreaId the primary key of the current work area
	 * @param parentWorkAreaId the parent work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work area
	 * @throws NoSuchWorkAreaException if a work area with the primary key could not be found
	 */
	public WorkArea[] findByParentWorkAreaId_PrevAndNext(
			long workAreaId, long parentWorkAreaId,
			com.liferay.portal.kernel.util.OrderByComparator<WorkArea>
				orderByComparator)
		throws NoSuchWorkAreaException;

	/**
	 * Removes all the work areas where parentWorkAreaId = &#63; from the database.
	 *
	 * @param parentWorkAreaId the parent work area ID
	 */
	public void removeByParentWorkAreaId(long parentWorkAreaId);

	/**
	 * Returns the number of work areas where parentWorkAreaId = &#63;.
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @return the number of matching work areas
	 */
	public int countByParentWorkAreaId(long parentWorkAreaId);

	/**
	 * Caches the work area in the entity cache if it is enabled.
	 *
	 * @param workArea the work area
	 */
	public void cacheResult(WorkArea workArea);

	/**
	 * Caches the work areas in the entity cache if it is enabled.
	 *
	 * @param workAreas the work areas
	 */
	public void cacheResult(java.util.List<WorkArea> workAreas);

	/**
	 * Creates a new work area with the primary key. Does not add the work area to the database.
	 *
	 * @param workAreaId the primary key for the new work area
	 * @return the new work area
	 */
	public WorkArea create(long workAreaId);

	/**
	 * Removes the work area with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workAreaId the primary key of the work area
	 * @return the work area that was removed
	 * @throws NoSuchWorkAreaException if a work area with the primary key could not be found
	 */
	public WorkArea remove(long workAreaId) throws NoSuchWorkAreaException;

	public WorkArea updateImpl(WorkArea workArea);

	/**
	 * Returns the work area with the primary key or throws a <code>NoSuchWorkAreaException</code> if it could not be found.
	 *
	 * @param workAreaId the primary key of the work area
	 * @return the work area
	 * @throws NoSuchWorkAreaException if a work area with the primary key could not be found
	 */
	public WorkArea findByPrimaryKey(long workAreaId)
		throws NoSuchWorkAreaException;

	/**
	 * Returns the work area with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workAreaId the primary key of the work area
	 * @return the work area, or <code>null</code> if a work area with the primary key could not be found
	 */
	public WorkArea fetchByPrimaryKey(long workAreaId);

	/**
	 * Returns all the work areas.
	 *
	 * @return the work areas
	 */
	public java.util.List<WorkArea> findAll();

	/**
	 * Returns a range of all the work areas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work areas
	 * @param end the upper bound of the range of work areas (not inclusive)
	 * @return the range of work areas
	 */
	public java.util.List<WorkArea> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the work areas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work areas
	 * @param end the upper bound of the range of work areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of work areas
	 */
	public java.util.List<WorkArea> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkArea>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work areas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work areas
	 * @param end the upper bound of the range of work areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of work areas
	 */
	public java.util.List<WorkArea> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkArea>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the work areas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of work areas.
	 *
	 * @return the number of work areas
	 */
	public int countAll();

}