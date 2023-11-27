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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeDeputationException;
import com.adjecti.pis.liferay.model.EmployeeDeputation;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee deputation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDeputationUtil
 * @generated
 */
@ProviderType
public interface EmployeeDeputationPersistence
	extends BasePersistence<EmployeeDeputation> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeDeputationUtil} to access the employee deputation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee deputations where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee deputations
	 */
	public java.util.List<EmployeeDeputation> findByEmployeeId(long employeeId);

	/**
	 * Returns a range of all the employee deputations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDeputationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee deputations
	 * @param end the upper bound of the range of employee deputations (not inclusive)
	 * @return the range of matching employee deputations
	 */
	public java.util.List<EmployeeDeputation> findByEmployeeId(
		long employeeId, int start, int end);

	/**
	 * Returns an ordered range of all the employee deputations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDeputationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee deputations
	 * @param end the upper bound of the range of employee deputations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee deputations
	 */
	public java.util.List<EmployeeDeputation> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDeputation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee deputations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDeputationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee deputations
	 * @param end the upper bound of the range of employee deputations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee deputations
	 */
	public java.util.List<EmployeeDeputation> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDeputation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee deputation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee deputation
	 * @throws NoSuchEmployeeDeputationException if a matching employee deputation could not be found
	 */
	public EmployeeDeputation findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDeputation>
				orderByComparator)
		throws NoSuchEmployeeDeputationException;

	/**
	 * Returns the first employee deputation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee deputation, or <code>null</code> if a matching employee deputation could not be found
	 */
	public EmployeeDeputation fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDeputation>
			orderByComparator);

	/**
	 * Returns the last employee deputation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee deputation
	 * @throws NoSuchEmployeeDeputationException if a matching employee deputation could not be found
	 */
	public EmployeeDeputation findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDeputation>
				orderByComparator)
		throws NoSuchEmployeeDeputationException;

	/**
	 * Returns the last employee deputation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee deputation, or <code>null</code> if a matching employee deputation could not be found
	 */
	public EmployeeDeputation fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDeputation>
			orderByComparator);

	/**
	 * Returns the employee deputations before and after the current employee deputation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeDeputationId the primary key of the current employee deputation
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee deputation
	 * @throws NoSuchEmployeeDeputationException if a employee deputation with the primary key could not be found
	 */
	public EmployeeDeputation[] findByEmployeeId_PrevAndNext(
			long employeeDeputationId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDeputation>
				orderByComparator)
		throws NoSuchEmployeeDeputationException;

	/**
	 * Removes all the employee deputations where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of employee deputations where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee deputations
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Caches the employee deputation in the entity cache if it is enabled.
	 *
	 * @param employeeDeputation the employee deputation
	 */
	public void cacheResult(EmployeeDeputation employeeDeputation);

	/**
	 * Caches the employee deputations in the entity cache if it is enabled.
	 *
	 * @param employeeDeputations the employee deputations
	 */
	public void cacheResult(
		java.util.List<EmployeeDeputation> employeeDeputations);

	/**
	 * Creates a new employee deputation with the primary key. Does not add the employee deputation to the database.
	 *
	 * @param employeeDeputationId the primary key for the new employee deputation
	 * @return the new employee deputation
	 */
	public EmployeeDeputation create(long employeeDeputationId);

	/**
	 * Removes the employee deputation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeDeputationId the primary key of the employee deputation
	 * @return the employee deputation that was removed
	 * @throws NoSuchEmployeeDeputationException if a employee deputation with the primary key could not be found
	 */
	public EmployeeDeputation remove(long employeeDeputationId)
		throws NoSuchEmployeeDeputationException;

	public EmployeeDeputation updateImpl(EmployeeDeputation employeeDeputation);

	/**
	 * Returns the employee deputation with the primary key or throws a <code>NoSuchEmployeeDeputationException</code> if it could not be found.
	 *
	 * @param employeeDeputationId the primary key of the employee deputation
	 * @return the employee deputation
	 * @throws NoSuchEmployeeDeputationException if a employee deputation with the primary key could not be found
	 */
	public EmployeeDeputation findByPrimaryKey(long employeeDeputationId)
		throws NoSuchEmployeeDeputationException;

	/**
	 * Returns the employee deputation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeDeputationId the primary key of the employee deputation
	 * @return the employee deputation, or <code>null</code> if a employee deputation with the primary key could not be found
	 */
	public EmployeeDeputation fetchByPrimaryKey(long employeeDeputationId);

	/**
	 * Returns all the employee deputations.
	 *
	 * @return the employee deputations
	 */
	public java.util.List<EmployeeDeputation> findAll();

	/**
	 * Returns a range of all the employee deputations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDeputationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee deputations
	 * @param end the upper bound of the range of employee deputations (not inclusive)
	 * @return the range of employee deputations
	 */
	public java.util.List<EmployeeDeputation> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee deputations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDeputationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee deputations
	 * @param end the upper bound of the range of employee deputations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee deputations
	 */
	public java.util.List<EmployeeDeputation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDeputation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee deputations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDeputationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee deputations
	 * @param end the upper bound of the range of employee deputations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee deputations
	 */
	public java.util.List<EmployeeDeputation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDeputation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee deputations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee deputations.
	 *
	 * @return the number of employee deputations
	 */
	public int countAll();

}