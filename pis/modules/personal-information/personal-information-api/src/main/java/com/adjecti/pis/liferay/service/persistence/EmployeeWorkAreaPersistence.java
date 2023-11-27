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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeWorkAreaException;
import com.adjecti.pis.liferay.model.EmployeeWorkArea;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee work area service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeWorkAreaUtil
 * @generated
 */
@ProviderType
public interface EmployeeWorkAreaPersistence
	extends BasePersistence<EmployeeWorkArea> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeWorkAreaUtil} to access the employee work area persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee work areas where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee work areas
	 */
	public java.util.List<EmployeeWorkArea> findByEmployeeId(long employeeId);

	/**
	 * Returns a range of all the employee work areas where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee work areas
	 * @param end the upper bound of the range of employee work areas (not inclusive)
	 * @return the range of matching employee work areas
	 */
	public java.util.List<EmployeeWorkArea> findByEmployeeId(
		long employeeId, int start, int end);

	/**
	 * Returns an ordered range of all the employee work areas where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee work areas
	 * @param end the upper bound of the range of employee work areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee work areas
	 */
	public java.util.List<EmployeeWorkArea> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeWorkArea>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee work areas where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee work areas
	 * @param end the upper bound of the range of employee work areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee work areas
	 */
	public java.util.List<EmployeeWorkArea> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeWorkArea>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee work area in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee work area
	 * @throws NoSuchEmployeeWorkAreaException if a matching employee work area could not be found
	 */
	public EmployeeWorkArea findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeWorkArea>
				orderByComparator)
		throws NoSuchEmployeeWorkAreaException;

	/**
	 * Returns the first employee work area in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee work area, or <code>null</code> if a matching employee work area could not be found
	 */
	public EmployeeWorkArea fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeWorkArea>
			orderByComparator);

	/**
	 * Returns the last employee work area in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee work area
	 * @throws NoSuchEmployeeWorkAreaException if a matching employee work area could not be found
	 */
	public EmployeeWorkArea findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeWorkArea>
				orderByComparator)
		throws NoSuchEmployeeWorkAreaException;

	/**
	 * Returns the last employee work area in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee work area, or <code>null</code> if a matching employee work area could not be found
	 */
	public EmployeeWorkArea fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeWorkArea>
			orderByComparator);

	/**
	 * Returns the employee work areas before and after the current employee work area in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeWorkAreaId the primary key of the current employee work area
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee work area
	 * @throws NoSuchEmployeeWorkAreaException if a employee work area with the primary key could not be found
	 */
	public EmployeeWorkArea[] findByEmployeeId_PrevAndNext(
			long employeeWorkAreaId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeWorkArea>
				orderByComparator)
		throws NoSuchEmployeeWorkAreaException;

	/**
	 * Removes all the employee work areas where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of employee work areas where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee work areas
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Returns all the employee work areas where workAreaMajorId = &#63;.
	 *
	 * @param workAreaMajorId the work area major ID
	 * @return the matching employee work areas
	 */
	public java.util.List<EmployeeWorkArea> findByWorkAreaMajorId(
		long workAreaMajorId);

	/**
	 * Returns a range of all the employee work areas where workAreaMajorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param start the lower bound of the range of employee work areas
	 * @param end the upper bound of the range of employee work areas (not inclusive)
	 * @return the range of matching employee work areas
	 */
	public java.util.List<EmployeeWorkArea> findByWorkAreaMajorId(
		long workAreaMajorId, int start, int end);

	/**
	 * Returns an ordered range of all the employee work areas where workAreaMajorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param start the lower bound of the range of employee work areas
	 * @param end the upper bound of the range of employee work areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee work areas
	 */
	public java.util.List<EmployeeWorkArea> findByWorkAreaMajorId(
		long workAreaMajorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeWorkArea>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee work areas where workAreaMajorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param start the lower bound of the range of employee work areas
	 * @param end the upper bound of the range of employee work areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee work areas
	 */
	public java.util.List<EmployeeWorkArea> findByWorkAreaMajorId(
		long workAreaMajorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeWorkArea>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee work area in the ordered set where workAreaMajorId = &#63;.
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee work area
	 * @throws NoSuchEmployeeWorkAreaException if a matching employee work area could not be found
	 */
	public EmployeeWorkArea findByWorkAreaMajorId_First(
			long workAreaMajorId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeWorkArea>
				orderByComparator)
		throws NoSuchEmployeeWorkAreaException;

	/**
	 * Returns the first employee work area in the ordered set where workAreaMajorId = &#63;.
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee work area, or <code>null</code> if a matching employee work area could not be found
	 */
	public EmployeeWorkArea fetchByWorkAreaMajorId_First(
		long workAreaMajorId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeWorkArea>
			orderByComparator);

	/**
	 * Returns the last employee work area in the ordered set where workAreaMajorId = &#63;.
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee work area
	 * @throws NoSuchEmployeeWorkAreaException if a matching employee work area could not be found
	 */
	public EmployeeWorkArea findByWorkAreaMajorId_Last(
			long workAreaMajorId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeWorkArea>
				orderByComparator)
		throws NoSuchEmployeeWorkAreaException;

	/**
	 * Returns the last employee work area in the ordered set where workAreaMajorId = &#63;.
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee work area, or <code>null</code> if a matching employee work area could not be found
	 */
	public EmployeeWorkArea fetchByWorkAreaMajorId_Last(
		long workAreaMajorId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeWorkArea>
			orderByComparator);

	/**
	 * Returns the employee work areas before and after the current employee work area in the ordered set where workAreaMajorId = &#63;.
	 *
	 * @param employeeWorkAreaId the primary key of the current employee work area
	 * @param workAreaMajorId the work area major ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee work area
	 * @throws NoSuchEmployeeWorkAreaException if a employee work area with the primary key could not be found
	 */
	public EmployeeWorkArea[] findByWorkAreaMajorId_PrevAndNext(
			long employeeWorkAreaId, long workAreaMajorId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeWorkArea>
				orderByComparator)
		throws NoSuchEmployeeWorkAreaException;

	/**
	 * Removes all the employee work areas where workAreaMajorId = &#63; from the database.
	 *
	 * @param workAreaMajorId the work area major ID
	 */
	public void removeByWorkAreaMajorId(long workAreaMajorId);

	/**
	 * Returns the number of employee work areas where workAreaMajorId = &#63;.
	 *
	 * @param workAreaMajorId the work area major ID
	 * @return the number of matching employee work areas
	 */
	public int countByWorkAreaMajorId(long workAreaMajorId);

	/**
	 * Caches the employee work area in the entity cache if it is enabled.
	 *
	 * @param employeeWorkArea the employee work area
	 */
	public void cacheResult(EmployeeWorkArea employeeWorkArea);

	/**
	 * Caches the employee work areas in the entity cache if it is enabled.
	 *
	 * @param employeeWorkAreas the employee work areas
	 */
	public void cacheResult(java.util.List<EmployeeWorkArea> employeeWorkAreas);

	/**
	 * Creates a new employee work area with the primary key. Does not add the employee work area to the database.
	 *
	 * @param employeeWorkAreaId the primary key for the new employee work area
	 * @return the new employee work area
	 */
	public EmployeeWorkArea create(long employeeWorkAreaId);

	/**
	 * Removes the employee work area with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeWorkAreaId the primary key of the employee work area
	 * @return the employee work area that was removed
	 * @throws NoSuchEmployeeWorkAreaException if a employee work area with the primary key could not be found
	 */
	public EmployeeWorkArea remove(long employeeWorkAreaId)
		throws NoSuchEmployeeWorkAreaException;

	public EmployeeWorkArea updateImpl(EmployeeWorkArea employeeWorkArea);

	/**
	 * Returns the employee work area with the primary key or throws a <code>NoSuchEmployeeWorkAreaException</code> if it could not be found.
	 *
	 * @param employeeWorkAreaId the primary key of the employee work area
	 * @return the employee work area
	 * @throws NoSuchEmployeeWorkAreaException if a employee work area with the primary key could not be found
	 */
	public EmployeeWorkArea findByPrimaryKey(long employeeWorkAreaId)
		throws NoSuchEmployeeWorkAreaException;

	/**
	 * Returns the employee work area with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeWorkAreaId the primary key of the employee work area
	 * @return the employee work area, or <code>null</code> if a employee work area with the primary key could not be found
	 */
	public EmployeeWorkArea fetchByPrimaryKey(long employeeWorkAreaId);

	/**
	 * Returns all the employee work areas.
	 *
	 * @return the employee work areas
	 */
	public java.util.List<EmployeeWorkArea> findAll();

	/**
	 * Returns a range of all the employee work areas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee work areas
	 * @param end the upper bound of the range of employee work areas (not inclusive)
	 * @return the range of employee work areas
	 */
	public java.util.List<EmployeeWorkArea> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee work areas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee work areas
	 * @param end the upper bound of the range of employee work areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee work areas
	 */
	public java.util.List<EmployeeWorkArea> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeWorkArea>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee work areas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkAreaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee work areas
	 * @param end the upper bound of the range of employee work areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee work areas
	 */
	public java.util.List<EmployeeWorkArea> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeWorkArea>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee work areas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee work areas.
	 *
	 * @return the number of employee work areas
	 */
	public int countAll();

}