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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeFamilyException;
import com.adjecti.pis.liferay.model.EmployeeFamily;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee family service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeFamilyUtil
 * @generated
 */
@ProviderType
public interface EmployeeFamilyPersistence
	extends BasePersistence<EmployeeFamily> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeFamilyUtil} to access the employee family persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee families where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee families
	 */
	public java.util.List<EmployeeFamily> findByEmployeeId(long employeeId);

	/**
	 * Returns a range of all the employee families where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeFamilyModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee families
	 * @param end the upper bound of the range of employee families (not inclusive)
	 * @return the range of matching employee families
	 */
	public java.util.List<EmployeeFamily> findByEmployeeId(
		long employeeId, int start, int end);

	/**
	 * Returns an ordered range of all the employee families where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeFamilyModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee families
	 * @param end the upper bound of the range of employee families (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee families
	 */
	public java.util.List<EmployeeFamily> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeFamily>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee families where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeFamilyModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee families
	 * @param end the upper bound of the range of employee families (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee families
	 */
	public java.util.List<EmployeeFamily> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeFamily>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee family in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee family
	 * @throws NoSuchEmployeeFamilyException if a matching employee family could not be found
	 */
	public EmployeeFamily findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeFamily>
				orderByComparator)
		throws NoSuchEmployeeFamilyException;

	/**
	 * Returns the first employee family in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee family, or <code>null</code> if a matching employee family could not be found
	 */
	public EmployeeFamily fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeFamily>
			orderByComparator);

	/**
	 * Returns the last employee family in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee family
	 * @throws NoSuchEmployeeFamilyException if a matching employee family could not be found
	 */
	public EmployeeFamily findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeFamily>
				orderByComparator)
		throws NoSuchEmployeeFamilyException;

	/**
	 * Returns the last employee family in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee family, or <code>null</code> if a matching employee family could not be found
	 */
	public EmployeeFamily fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeFamily>
			orderByComparator);

	/**
	 * Returns the employee families before and after the current employee family in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeFamilyId the primary key of the current employee family
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee family
	 * @throws NoSuchEmployeeFamilyException if a employee family with the primary key could not be found
	 */
	public EmployeeFamily[] findByEmployeeId_PrevAndNext(
			long employeeFamilyId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeFamily>
				orderByComparator)
		throws NoSuchEmployeeFamilyException;

	/**
	 * Removes all the employee families where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of employee families where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee families
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Returns all the employee families where relationId = &#63;.
	 *
	 * @param relationId the relation ID
	 * @return the matching employee families
	 */
	public java.util.List<EmployeeFamily> findByRelationId(long relationId);

	/**
	 * Returns a range of all the employee families where relationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeFamilyModelImpl</code>.
	 * </p>
	 *
	 * @param relationId the relation ID
	 * @param start the lower bound of the range of employee families
	 * @param end the upper bound of the range of employee families (not inclusive)
	 * @return the range of matching employee families
	 */
	public java.util.List<EmployeeFamily> findByRelationId(
		long relationId, int start, int end);

	/**
	 * Returns an ordered range of all the employee families where relationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeFamilyModelImpl</code>.
	 * </p>
	 *
	 * @param relationId the relation ID
	 * @param start the lower bound of the range of employee families
	 * @param end the upper bound of the range of employee families (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee families
	 */
	public java.util.List<EmployeeFamily> findByRelationId(
		long relationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeFamily>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee families where relationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeFamilyModelImpl</code>.
	 * </p>
	 *
	 * @param relationId the relation ID
	 * @param start the lower bound of the range of employee families
	 * @param end the upper bound of the range of employee families (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee families
	 */
	public java.util.List<EmployeeFamily> findByRelationId(
		long relationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeFamily>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee family in the ordered set where relationId = &#63;.
	 *
	 * @param relationId the relation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee family
	 * @throws NoSuchEmployeeFamilyException if a matching employee family could not be found
	 */
	public EmployeeFamily findByRelationId_First(
			long relationId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeFamily>
				orderByComparator)
		throws NoSuchEmployeeFamilyException;

	/**
	 * Returns the first employee family in the ordered set where relationId = &#63;.
	 *
	 * @param relationId the relation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee family, or <code>null</code> if a matching employee family could not be found
	 */
	public EmployeeFamily fetchByRelationId_First(
		long relationId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeFamily>
			orderByComparator);

	/**
	 * Returns the last employee family in the ordered set where relationId = &#63;.
	 *
	 * @param relationId the relation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee family
	 * @throws NoSuchEmployeeFamilyException if a matching employee family could not be found
	 */
	public EmployeeFamily findByRelationId_Last(
			long relationId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeFamily>
				orderByComparator)
		throws NoSuchEmployeeFamilyException;

	/**
	 * Returns the last employee family in the ordered set where relationId = &#63;.
	 *
	 * @param relationId the relation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee family, or <code>null</code> if a matching employee family could not be found
	 */
	public EmployeeFamily fetchByRelationId_Last(
		long relationId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeFamily>
			orderByComparator);

	/**
	 * Returns the employee families before and after the current employee family in the ordered set where relationId = &#63;.
	 *
	 * @param employeeFamilyId the primary key of the current employee family
	 * @param relationId the relation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee family
	 * @throws NoSuchEmployeeFamilyException if a employee family with the primary key could not be found
	 */
	public EmployeeFamily[] findByRelationId_PrevAndNext(
			long employeeFamilyId, long relationId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeFamily>
				orderByComparator)
		throws NoSuchEmployeeFamilyException;

	/**
	 * Removes all the employee families where relationId = &#63; from the database.
	 *
	 * @param relationId the relation ID
	 */
	public void removeByRelationId(long relationId);

	/**
	 * Returns the number of employee families where relationId = &#63;.
	 *
	 * @param relationId the relation ID
	 * @return the number of matching employee families
	 */
	public int countByRelationId(long relationId);

	/**
	 * Returns all the employee families where occupationId = &#63;.
	 *
	 * @param occupationId the occupation ID
	 * @return the matching employee families
	 */
	public java.util.List<EmployeeFamily> findByOccupationId(long occupationId);

	/**
	 * Returns a range of all the employee families where occupationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeFamilyModelImpl</code>.
	 * </p>
	 *
	 * @param occupationId the occupation ID
	 * @param start the lower bound of the range of employee families
	 * @param end the upper bound of the range of employee families (not inclusive)
	 * @return the range of matching employee families
	 */
	public java.util.List<EmployeeFamily> findByOccupationId(
		long occupationId, int start, int end);

	/**
	 * Returns an ordered range of all the employee families where occupationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeFamilyModelImpl</code>.
	 * </p>
	 *
	 * @param occupationId the occupation ID
	 * @param start the lower bound of the range of employee families
	 * @param end the upper bound of the range of employee families (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee families
	 */
	public java.util.List<EmployeeFamily> findByOccupationId(
		long occupationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeFamily>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee families where occupationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeFamilyModelImpl</code>.
	 * </p>
	 *
	 * @param occupationId the occupation ID
	 * @param start the lower bound of the range of employee families
	 * @param end the upper bound of the range of employee families (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee families
	 */
	public java.util.List<EmployeeFamily> findByOccupationId(
		long occupationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeFamily>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee family in the ordered set where occupationId = &#63;.
	 *
	 * @param occupationId the occupation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee family
	 * @throws NoSuchEmployeeFamilyException if a matching employee family could not be found
	 */
	public EmployeeFamily findByOccupationId_First(
			long occupationId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeFamily>
				orderByComparator)
		throws NoSuchEmployeeFamilyException;

	/**
	 * Returns the first employee family in the ordered set where occupationId = &#63;.
	 *
	 * @param occupationId the occupation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee family, or <code>null</code> if a matching employee family could not be found
	 */
	public EmployeeFamily fetchByOccupationId_First(
		long occupationId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeFamily>
			orderByComparator);

	/**
	 * Returns the last employee family in the ordered set where occupationId = &#63;.
	 *
	 * @param occupationId the occupation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee family
	 * @throws NoSuchEmployeeFamilyException if a matching employee family could not be found
	 */
	public EmployeeFamily findByOccupationId_Last(
			long occupationId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeFamily>
				orderByComparator)
		throws NoSuchEmployeeFamilyException;

	/**
	 * Returns the last employee family in the ordered set where occupationId = &#63;.
	 *
	 * @param occupationId the occupation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee family, or <code>null</code> if a matching employee family could not be found
	 */
	public EmployeeFamily fetchByOccupationId_Last(
		long occupationId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeFamily>
			orderByComparator);

	/**
	 * Returns the employee families before and after the current employee family in the ordered set where occupationId = &#63;.
	 *
	 * @param employeeFamilyId the primary key of the current employee family
	 * @param occupationId the occupation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee family
	 * @throws NoSuchEmployeeFamilyException if a employee family with the primary key could not be found
	 */
	public EmployeeFamily[] findByOccupationId_PrevAndNext(
			long employeeFamilyId, long occupationId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeFamily>
				orderByComparator)
		throws NoSuchEmployeeFamilyException;

	/**
	 * Removes all the employee families where occupationId = &#63; from the database.
	 *
	 * @param occupationId the occupation ID
	 */
	public void removeByOccupationId(long occupationId);

	/**
	 * Returns the number of employee families where occupationId = &#63;.
	 *
	 * @param occupationId the occupation ID
	 * @return the number of matching employee families
	 */
	public int countByOccupationId(long occupationId);

	/**
	 * Caches the employee family in the entity cache if it is enabled.
	 *
	 * @param employeeFamily the employee family
	 */
	public void cacheResult(EmployeeFamily employeeFamily);

	/**
	 * Caches the employee families in the entity cache if it is enabled.
	 *
	 * @param employeeFamilies the employee families
	 */
	public void cacheResult(java.util.List<EmployeeFamily> employeeFamilies);

	/**
	 * Creates a new employee family with the primary key. Does not add the employee family to the database.
	 *
	 * @param employeeFamilyId the primary key for the new employee family
	 * @return the new employee family
	 */
	public EmployeeFamily create(long employeeFamilyId);

	/**
	 * Removes the employee family with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeFamilyId the primary key of the employee family
	 * @return the employee family that was removed
	 * @throws NoSuchEmployeeFamilyException if a employee family with the primary key could not be found
	 */
	public EmployeeFamily remove(long employeeFamilyId)
		throws NoSuchEmployeeFamilyException;

	public EmployeeFamily updateImpl(EmployeeFamily employeeFamily);

	/**
	 * Returns the employee family with the primary key or throws a <code>NoSuchEmployeeFamilyException</code> if it could not be found.
	 *
	 * @param employeeFamilyId the primary key of the employee family
	 * @return the employee family
	 * @throws NoSuchEmployeeFamilyException if a employee family with the primary key could not be found
	 */
	public EmployeeFamily findByPrimaryKey(long employeeFamilyId)
		throws NoSuchEmployeeFamilyException;

	/**
	 * Returns the employee family with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeFamilyId the primary key of the employee family
	 * @return the employee family, or <code>null</code> if a employee family with the primary key could not be found
	 */
	public EmployeeFamily fetchByPrimaryKey(long employeeFamilyId);

	/**
	 * Returns all the employee families.
	 *
	 * @return the employee families
	 */
	public java.util.List<EmployeeFamily> findAll();

	/**
	 * Returns a range of all the employee families.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeFamilyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee families
	 * @param end the upper bound of the range of employee families (not inclusive)
	 * @return the range of employee families
	 */
	public java.util.List<EmployeeFamily> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee families.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeFamilyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee families
	 * @param end the upper bound of the range of employee families (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee families
	 */
	public java.util.List<EmployeeFamily> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeFamily>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee families.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeFamilyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee families
	 * @param end the upper bound of the range of employee families (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee families
	 */
	public java.util.List<EmployeeFamily> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeFamily>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee families from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee families.
	 *
	 * @return the number of employee families
	 */
	public int countAll();

}