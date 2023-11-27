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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeDesignationException;
import com.adjecti.pis.liferay.model.EmployeeDesignation;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee designation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDesignationUtil
 * @generated
 */
@ProviderType
public interface EmployeeDesignationPersistence
	extends BasePersistence<EmployeeDesignation> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeDesignationUtil} to access the employee designation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee designations where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee designations
	 */
	public java.util.List<EmployeeDesignation> findByEmployeeId(
		long employeeId);

	/**
	 * Returns a range of all the employee designations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee designations
	 * @param end the upper bound of the range of employee designations (not inclusive)
	 * @return the range of matching employee designations
	 */
	public java.util.List<EmployeeDesignation> findByEmployeeId(
		long employeeId, int start, int end);

	/**
	 * Returns an ordered range of all the employee designations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee designations
	 * @param end the upper bound of the range of employee designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee designations
	 */
	public java.util.List<EmployeeDesignation> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDesignation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee designations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee designations
	 * @param end the upper bound of the range of employee designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee designations
	 */
	public java.util.List<EmployeeDesignation> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDesignation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee designation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee designation
	 * @throws NoSuchEmployeeDesignationException if a matching employee designation could not be found
	 */
	public EmployeeDesignation findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeDesignation> orderByComparator)
		throws NoSuchEmployeeDesignationException;

	/**
	 * Returns the first employee designation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee designation, or <code>null</code> if a matching employee designation could not be found
	 */
	public EmployeeDesignation fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDesignation>
			orderByComparator);

	/**
	 * Returns the last employee designation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee designation
	 * @throws NoSuchEmployeeDesignationException if a matching employee designation could not be found
	 */
	public EmployeeDesignation findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeDesignation> orderByComparator)
		throws NoSuchEmployeeDesignationException;

	/**
	 * Returns the last employee designation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee designation, or <code>null</code> if a matching employee designation could not be found
	 */
	public EmployeeDesignation fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDesignation>
			orderByComparator);

	/**
	 * Returns the employee designations before and after the current employee designation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeDesignationId the primary key of the current employee designation
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee designation
	 * @throws NoSuchEmployeeDesignationException if a employee designation with the primary key could not be found
	 */
	public EmployeeDesignation[] findByEmployeeId_PrevAndNext(
			long employeeDesignationId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeDesignation> orderByComparator)
		throws NoSuchEmployeeDesignationException;

	/**
	 * Removes all the employee designations where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of employee designations where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee designations
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Caches the employee designation in the entity cache if it is enabled.
	 *
	 * @param employeeDesignation the employee designation
	 */
	public void cacheResult(EmployeeDesignation employeeDesignation);

	/**
	 * Caches the employee designations in the entity cache if it is enabled.
	 *
	 * @param employeeDesignations the employee designations
	 */
	public void cacheResult(
		java.util.List<EmployeeDesignation> employeeDesignations);

	/**
	 * Creates a new employee designation with the primary key. Does not add the employee designation to the database.
	 *
	 * @param employeeDesignationId the primary key for the new employee designation
	 * @return the new employee designation
	 */
	public EmployeeDesignation create(long employeeDesignationId);

	/**
	 * Removes the employee designation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeDesignationId the primary key of the employee designation
	 * @return the employee designation that was removed
	 * @throws NoSuchEmployeeDesignationException if a employee designation with the primary key could not be found
	 */
	public EmployeeDesignation remove(long employeeDesignationId)
		throws NoSuchEmployeeDesignationException;

	public EmployeeDesignation updateImpl(
		EmployeeDesignation employeeDesignation);

	/**
	 * Returns the employee designation with the primary key or throws a <code>NoSuchEmployeeDesignationException</code> if it could not be found.
	 *
	 * @param employeeDesignationId the primary key of the employee designation
	 * @return the employee designation
	 * @throws NoSuchEmployeeDesignationException if a employee designation with the primary key could not be found
	 */
	public EmployeeDesignation findByPrimaryKey(long employeeDesignationId)
		throws NoSuchEmployeeDesignationException;

	/**
	 * Returns the employee designation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeDesignationId the primary key of the employee designation
	 * @return the employee designation, or <code>null</code> if a employee designation with the primary key could not be found
	 */
	public EmployeeDesignation fetchByPrimaryKey(long employeeDesignationId);

	/**
	 * Returns all the employee designations.
	 *
	 * @return the employee designations
	 */
	public java.util.List<EmployeeDesignation> findAll();

	/**
	 * Returns a range of all the employee designations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee designations
	 * @param end the upper bound of the range of employee designations (not inclusive)
	 * @return the range of employee designations
	 */
	public java.util.List<EmployeeDesignation> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee designations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee designations
	 * @param end the upper bound of the range of employee designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee designations
	 */
	public java.util.List<EmployeeDesignation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDesignation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee designations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDesignationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee designations
	 * @param end the upper bound of the range of employee designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee designations
	 */
	public java.util.List<EmployeeDesignation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDesignation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee designations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee designations.
	 *
	 * @return the number of employee designations
	 */
	public int countAll();

}