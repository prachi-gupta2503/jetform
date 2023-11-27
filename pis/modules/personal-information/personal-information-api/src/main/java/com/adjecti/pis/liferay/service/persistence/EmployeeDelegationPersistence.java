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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeDelegationException;
import com.adjecti.pis.liferay.model.EmployeeDelegation;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee delegation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDelegationUtil
 * @generated
 */
@ProviderType
public interface EmployeeDelegationPersistence
	extends BasePersistence<EmployeeDelegation> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeDelegationUtil} to access the employee delegation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee delegations where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee delegations
	 */
	public java.util.List<EmployeeDelegation> findByEmployeeId(long employeeId);

	/**
	 * Returns a range of all the employee delegations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDelegationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee delegations
	 * @param end the upper bound of the range of employee delegations (not inclusive)
	 * @return the range of matching employee delegations
	 */
	public java.util.List<EmployeeDelegation> findByEmployeeId(
		long employeeId, int start, int end);

	/**
	 * Returns an ordered range of all the employee delegations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDelegationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee delegations
	 * @param end the upper bound of the range of employee delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee delegations
	 */
	public java.util.List<EmployeeDelegation> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDelegation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee delegations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDelegationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee delegations
	 * @param end the upper bound of the range of employee delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee delegations
	 */
	public java.util.List<EmployeeDelegation> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDelegation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee delegation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee delegation
	 * @throws NoSuchEmployeeDelegationException if a matching employee delegation could not be found
	 */
	public EmployeeDelegation findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDelegation>
				orderByComparator)
		throws NoSuchEmployeeDelegationException;

	/**
	 * Returns the first employee delegation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee delegation, or <code>null</code> if a matching employee delegation could not be found
	 */
	public EmployeeDelegation fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDelegation>
			orderByComparator);

	/**
	 * Returns the last employee delegation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee delegation
	 * @throws NoSuchEmployeeDelegationException if a matching employee delegation could not be found
	 */
	public EmployeeDelegation findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDelegation>
				orderByComparator)
		throws NoSuchEmployeeDelegationException;

	/**
	 * Returns the last employee delegation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee delegation, or <code>null</code> if a matching employee delegation could not be found
	 */
	public EmployeeDelegation fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDelegation>
			orderByComparator);

	/**
	 * Returns the employee delegations before and after the current employee delegation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeDelegationId the primary key of the current employee delegation
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee delegation
	 * @throws NoSuchEmployeeDelegationException if a employee delegation with the primary key could not be found
	 */
	public EmployeeDelegation[] findByEmployeeId_PrevAndNext(
			long employeeDelegationId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDelegation>
				orderByComparator)
		throws NoSuchEmployeeDelegationException;

	/**
	 * Removes all the employee delegations where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of employee delegations where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee delegations
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Caches the employee delegation in the entity cache if it is enabled.
	 *
	 * @param employeeDelegation the employee delegation
	 */
	public void cacheResult(EmployeeDelegation employeeDelegation);

	/**
	 * Caches the employee delegations in the entity cache if it is enabled.
	 *
	 * @param employeeDelegations the employee delegations
	 */
	public void cacheResult(
		java.util.List<EmployeeDelegation> employeeDelegations);

	/**
	 * Creates a new employee delegation with the primary key. Does not add the employee delegation to the database.
	 *
	 * @param employeeDelegationId the primary key for the new employee delegation
	 * @return the new employee delegation
	 */
	public EmployeeDelegation create(long employeeDelegationId);

	/**
	 * Removes the employee delegation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeDelegationId the primary key of the employee delegation
	 * @return the employee delegation that was removed
	 * @throws NoSuchEmployeeDelegationException if a employee delegation with the primary key could not be found
	 */
	public EmployeeDelegation remove(long employeeDelegationId)
		throws NoSuchEmployeeDelegationException;

	public EmployeeDelegation updateImpl(EmployeeDelegation employeeDelegation);

	/**
	 * Returns the employee delegation with the primary key or throws a <code>NoSuchEmployeeDelegationException</code> if it could not be found.
	 *
	 * @param employeeDelegationId the primary key of the employee delegation
	 * @return the employee delegation
	 * @throws NoSuchEmployeeDelegationException if a employee delegation with the primary key could not be found
	 */
	public EmployeeDelegation findByPrimaryKey(long employeeDelegationId)
		throws NoSuchEmployeeDelegationException;

	/**
	 * Returns the employee delegation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeDelegationId the primary key of the employee delegation
	 * @return the employee delegation, or <code>null</code> if a employee delegation with the primary key could not be found
	 */
	public EmployeeDelegation fetchByPrimaryKey(long employeeDelegationId);

	/**
	 * Returns all the employee delegations.
	 *
	 * @return the employee delegations
	 */
	public java.util.List<EmployeeDelegation> findAll();

	/**
	 * Returns a range of all the employee delegations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDelegationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee delegations
	 * @param end the upper bound of the range of employee delegations (not inclusive)
	 * @return the range of employee delegations
	 */
	public java.util.List<EmployeeDelegation> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee delegations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDelegationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee delegations
	 * @param end the upper bound of the range of employee delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee delegations
	 */
	public java.util.List<EmployeeDelegation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDelegation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee delegations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDelegationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee delegations
	 * @param end the upper bound of the range of employee delegations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee delegations
	 */
	public java.util.List<EmployeeDelegation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDelegation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee delegations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee delegations.
	 *
	 * @return the number of employee delegations
	 */
	public int countAll();

}