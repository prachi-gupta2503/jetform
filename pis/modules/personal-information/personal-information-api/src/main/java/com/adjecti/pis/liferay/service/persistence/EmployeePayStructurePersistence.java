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

import com.adjecti.pis.liferay.exception.NoSuchEmployeePayStructureException;
import com.adjecti.pis.liferay.model.EmployeePayStructure;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee pay structure service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeePayStructureUtil
 * @generated
 */
@ProviderType
public interface EmployeePayStructurePersistence
	extends BasePersistence<EmployeePayStructure> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeePayStructureUtil} to access the employee pay structure persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee pay structures where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee pay structures
	 */
	public java.util.List<EmployeePayStructure> findByEmployeeId(
		long employeeId);

	/**
	 * Returns a range of all the employee pay structures where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePayStructureModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee pay structures
	 * @param end the upper bound of the range of employee pay structures (not inclusive)
	 * @return the range of matching employee pay structures
	 */
	public java.util.List<EmployeePayStructure> findByEmployeeId(
		long employeeId, int start, int end);

	/**
	 * Returns an ordered range of all the employee pay structures where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePayStructureModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee pay structures
	 * @param end the upper bound of the range of employee pay structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee pay structures
	 */
	public java.util.List<EmployeePayStructure> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePayStructure>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee pay structures where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePayStructureModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee pay structures
	 * @param end the upper bound of the range of employee pay structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee pay structures
	 */
	public java.util.List<EmployeePayStructure> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePayStructure>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee pay structure in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee pay structure
	 * @throws NoSuchEmployeePayStructureException if a matching employee pay structure could not be found
	 */
	public EmployeePayStructure findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeePayStructure> orderByComparator)
		throws NoSuchEmployeePayStructureException;

	/**
	 * Returns the first employee pay structure in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee pay structure, or <code>null</code> if a matching employee pay structure could not be found
	 */
	public EmployeePayStructure fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePayStructure>
			orderByComparator);

	/**
	 * Returns the last employee pay structure in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee pay structure
	 * @throws NoSuchEmployeePayStructureException if a matching employee pay structure could not be found
	 */
	public EmployeePayStructure findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeePayStructure> orderByComparator)
		throws NoSuchEmployeePayStructureException;

	/**
	 * Returns the last employee pay structure in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee pay structure, or <code>null</code> if a matching employee pay structure could not be found
	 */
	public EmployeePayStructure fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePayStructure>
			orderByComparator);

	/**
	 * Returns the employee pay structures before and after the current employee pay structure in the ordered set where employeeId = &#63;.
	 *
	 * @param employeePayStructureId the primary key of the current employee pay structure
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee pay structure
	 * @throws NoSuchEmployeePayStructureException if a employee pay structure with the primary key could not be found
	 */
	public EmployeePayStructure[] findByEmployeeId_PrevAndNext(
			long employeePayStructureId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeePayStructure> orderByComparator)
		throws NoSuchEmployeePayStructureException;

	/**
	 * Removes all the employee pay structures where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of employee pay structures where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee pay structures
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Caches the employee pay structure in the entity cache if it is enabled.
	 *
	 * @param employeePayStructure the employee pay structure
	 */
	public void cacheResult(EmployeePayStructure employeePayStructure);

	/**
	 * Caches the employee pay structures in the entity cache if it is enabled.
	 *
	 * @param employeePayStructures the employee pay structures
	 */
	public void cacheResult(
		java.util.List<EmployeePayStructure> employeePayStructures);

	/**
	 * Creates a new employee pay structure with the primary key. Does not add the employee pay structure to the database.
	 *
	 * @param employeePayStructureId the primary key for the new employee pay structure
	 * @return the new employee pay structure
	 */
	public EmployeePayStructure create(long employeePayStructureId);

	/**
	 * Removes the employee pay structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeePayStructureId the primary key of the employee pay structure
	 * @return the employee pay structure that was removed
	 * @throws NoSuchEmployeePayStructureException if a employee pay structure with the primary key could not be found
	 */
	public EmployeePayStructure remove(long employeePayStructureId)
		throws NoSuchEmployeePayStructureException;

	public EmployeePayStructure updateImpl(
		EmployeePayStructure employeePayStructure);

	/**
	 * Returns the employee pay structure with the primary key or throws a <code>NoSuchEmployeePayStructureException</code> if it could not be found.
	 *
	 * @param employeePayStructureId the primary key of the employee pay structure
	 * @return the employee pay structure
	 * @throws NoSuchEmployeePayStructureException if a employee pay structure with the primary key could not be found
	 */
	public EmployeePayStructure findByPrimaryKey(long employeePayStructureId)
		throws NoSuchEmployeePayStructureException;

	/**
	 * Returns the employee pay structure with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeePayStructureId the primary key of the employee pay structure
	 * @return the employee pay structure, or <code>null</code> if a employee pay structure with the primary key could not be found
	 */
	public EmployeePayStructure fetchByPrimaryKey(long employeePayStructureId);

	/**
	 * Returns all the employee pay structures.
	 *
	 * @return the employee pay structures
	 */
	public java.util.List<EmployeePayStructure> findAll();

	/**
	 * Returns a range of all the employee pay structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePayStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee pay structures
	 * @param end the upper bound of the range of employee pay structures (not inclusive)
	 * @return the range of employee pay structures
	 */
	public java.util.List<EmployeePayStructure> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee pay structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePayStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee pay structures
	 * @param end the upper bound of the range of employee pay structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee pay structures
	 */
	public java.util.List<EmployeePayStructure> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePayStructure>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee pay structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePayStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee pay structures
	 * @param end the upper bound of the range of employee pay structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee pay structures
	 */
	public java.util.List<EmployeePayStructure> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePayStructure>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee pay structures from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee pay structures.
	 *
	 * @return the number of employee pay structures
	 */
	public int countAll();

}