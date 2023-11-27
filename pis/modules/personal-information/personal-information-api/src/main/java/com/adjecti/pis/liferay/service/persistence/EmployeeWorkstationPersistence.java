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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeWorkstationException;
import com.adjecti.pis.liferay.model.EmployeeWorkstation;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee workstation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeWorkstationUtil
 * @generated
 */
@ProviderType
public interface EmployeeWorkstationPersistence
	extends BasePersistence<EmployeeWorkstation> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeWorkstationUtil} to access the employee workstation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee workstations where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee workstations
	 */
	public java.util.List<EmployeeWorkstation> findByEmployeeId(
		long employeeId);

	/**
	 * Returns a range of all the employee workstations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkstationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee workstations
	 * @param end the upper bound of the range of employee workstations (not inclusive)
	 * @return the range of matching employee workstations
	 */
	public java.util.List<EmployeeWorkstation> findByEmployeeId(
		long employeeId, int start, int end);

	/**
	 * Returns an ordered range of all the employee workstations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkstationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee workstations
	 * @param end the upper bound of the range of employee workstations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee workstations
	 */
	public java.util.List<EmployeeWorkstation> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeWorkstation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee workstations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkstationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee workstations
	 * @param end the upper bound of the range of employee workstations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee workstations
	 */
	public java.util.List<EmployeeWorkstation> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeWorkstation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee workstation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee workstation
	 * @throws NoSuchEmployeeWorkstationException if a matching employee workstation could not be found
	 */
	public EmployeeWorkstation findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeWorkstation> orderByComparator)
		throws NoSuchEmployeeWorkstationException;

	/**
	 * Returns the first employee workstation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee workstation, or <code>null</code> if a matching employee workstation could not be found
	 */
	public EmployeeWorkstation fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeWorkstation>
			orderByComparator);

	/**
	 * Returns the last employee workstation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee workstation
	 * @throws NoSuchEmployeeWorkstationException if a matching employee workstation could not be found
	 */
	public EmployeeWorkstation findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeWorkstation> orderByComparator)
		throws NoSuchEmployeeWorkstationException;

	/**
	 * Returns the last employee workstation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee workstation, or <code>null</code> if a matching employee workstation could not be found
	 */
	public EmployeeWorkstation fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeWorkstation>
			orderByComparator);

	/**
	 * Returns the employee workstations before and after the current employee workstation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeWorkstationId the primary key of the current employee workstation
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee workstation
	 * @throws NoSuchEmployeeWorkstationException if a employee workstation with the primary key could not be found
	 */
	public EmployeeWorkstation[] findByEmployeeId_PrevAndNext(
			long employeeWorkstationId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeWorkstation> orderByComparator)
		throws NoSuchEmployeeWorkstationException;

	/**
	 * Removes all the employee workstations where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of employee workstations where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee workstations
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Caches the employee workstation in the entity cache if it is enabled.
	 *
	 * @param employeeWorkstation the employee workstation
	 */
	public void cacheResult(EmployeeWorkstation employeeWorkstation);

	/**
	 * Caches the employee workstations in the entity cache if it is enabled.
	 *
	 * @param employeeWorkstations the employee workstations
	 */
	public void cacheResult(
		java.util.List<EmployeeWorkstation> employeeWorkstations);

	/**
	 * Creates a new employee workstation with the primary key. Does not add the employee workstation to the database.
	 *
	 * @param employeeWorkstationId the primary key for the new employee workstation
	 * @return the new employee workstation
	 */
	public EmployeeWorkstation create(long employeeWorkstationId);

	/**
	 * Removes the employee workstation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeWorkstationId the primary key of the employee workstation
	 * @return the employee workstation that was removed
	 * @throws NoSuchEmployeeWorkstationException if a employee workstation with the primary key could not be found
	 */
	public EmployeeWorkstation remove(long employeeWorkstationId)
		throws NoSuchEmployeeWorkstationException;

	public EmployeeWorkstation updateImpl(
		EmployeeWorkstation employeeWorkstation);

	/**
	 * Returns the employee workstation with the primary key or throws a <code>NoSuchEmployeeWorkstationException</code> if it could not be found.
	 *
	 * @param employeeWorkstationId the primary key of the employee workstation
	 * @return the employee workstation
	 * @throws NoSuchEmployeeWorkstationException if a employee workstation with the primary key could not be found
	 */
	public EmployeeWorkstation findByPrimaryKey(long employeeWorkstationId)
		throws NoSuchEmployeeWorkstationException;

	/**
	 * Returns the employee workstation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeWorkstationId the primary key of the employee workstation
	 * @return the employee workstation, or <code>null</code> if a employee workstation with the primary key could not be found
	 */
	public EmployeeWorkstation fetchByPrimaryKey(long employeeWorkstationId);

	/**
	 * Returns all the employee workstations.
	 *
	 * @return the employee workstations
	 */
	public java.util.List<EmployeeWorkstation> findAll();

	/**
	 * Returns a range of all the employee workstations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkstationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee workstations
	 * @param end the upper bound of the range of employee workstations (not inclusive)
	 * @return the range of employee workstations
	 */
	public java.util.List<EmployeeWorkstation> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee workstations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkstationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee workstations
	 * @param end the upper bound of the range of employee workstations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee workstations
	 */
	public java.util.List<EmployeeWorkstation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeWorkstation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee workstations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeWorkstationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee workstations
	 * @param end the upper bound of the range of employee workstations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee workstations
	 */
	public java.util.List<EmployeeWorkstation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeWorkstation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee workstations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee workstations.
	 *
	 * @return the number of employee workstations
	 */
	public int countAll();

}