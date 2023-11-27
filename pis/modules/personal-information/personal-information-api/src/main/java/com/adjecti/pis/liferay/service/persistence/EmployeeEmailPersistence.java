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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeEmailException;
import com.adjecti.pis.liferay.model.EmployeeEmail;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee email service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeEmailUtil
 * @generated
 */
@ProviderType
public interface EmployeeEmailPersistence
	extends BasePersistence<EmployeeEmail> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeEmailUtil} to access the employee email persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee emails where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee emails
	 */
	public java.util.List<EmployeeEmail> findByEmployeeId(long employeeId);

	/**
	 * Returns a range of all the employee emails where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeEmailModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee emails
	 * @param end the upper bound of the range of employee emails (not inclusive)
	 * @return the range of matching employee emails
	 */
	public java.util.List<EmployeeEmail> findByEmployeeId(
		long employeeId, int start, int end);

	/**
	 * Returns an ordered range of all the employee emails where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeEmailModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee emails
	 * @param end the upper bound of the range of employee emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee emails
	 */
	public java.util.List<EmployeeEmail> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeEmail>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee emails where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeEmailModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee emails
	 * @param end the upper bound of the range of employee emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee emails
	 */
	public java.util.List<EmployeeEmail> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeEmail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee email in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee email
	 * @throws NoSuchEmployeeEmailException if a matching employee email could not be found
	 */
	public EmployeeEmail findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeEmail>
				orderByComparator)
		throws NoSuchEmployeeEmailException;

	/**
	 * Returns the first employee email in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee email, or <code>null</code> if a matching employee email could not be found
	 */
	public EmployeeEmail fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeEmail>
			orderByComparator);

	/**
	 * Returns the last employee email in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee email
	 * @throws NoSuchEmployeeEmailException if a matching employee email could not be found
	 */
	public EmployeeEmail findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeEmail>
				orderByComparator)
		throws NoSuchEmployeeEmailException;

	/**
	 * Returns the last employee email in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee email, or <code>null</code> if a matching employee email could not be found
	 */
	public EmployeeEmail fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeEmail>
			orderByComparator);

	/**
	 * Returns the employee emails before and after the current employee email in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeEmailId the primary key of the current employee email
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee email
	 * @throws NoSuchEmployeeEmailException if a employee email with the primary key could not be found
	 */
	public EmployeeEmail[] findByEmployeeId_PrevAndNext(
			long employeeEmailId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeEmail>
				orderByComparator)
		throws NoSuchEmployeeEmailException;

	/**
	 * Removes all the employee emails where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of employee emails where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee emails
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Caches the employee email in the entity cache if it is enabled.
	 *
	 * @param employeeEmail the employee email
	 */
	public void cacheResult(EmployeeEmail employeeEmail);

	/**
	 * Caches the employee emails in the entity cache if it is enabled.
	 *
	 * @param employeeEmails the employee emails
	 */
	public void cacheResult(java.util.List<EmployeeEmail> employeeEmails);

	/**
	 * Creates a new employee email with the primary key. Does not add the employee email to the database.
	 *
	 * @param employeeEmailId the primary key for the new employee email
	 * @return the new employee email
	 */
	public EmployeeEmail create(long employeeEmailId);

	/**
	 * Removes the employee email with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeEmailId the primary key of the employee email
	 * @return the employee email that was removed
	 * @throws NoSuchEmployeeEmailException if a employee email with the primary key could not be found
	 */
	public EmployeeEmail remove(long employeeEmailId)
		throws NoSuchEmployeeEmailException;

	public EmployeeEmail updateImpl(EmployeeEmail employeeEmail);

	/**
	 * Returns the employee email with the primary key or throws a <code>NoSuchEmployeeEmailException</code> if it could not be found.
	 *
	 * @param employeeEmailId the primary key of the employee email
	 * @return the employee email
	 * @throws NoSuchEmployeeEmailException if a employee email with the primary key could not be found
	 */
	public EmployeeEmail findByPrimaryKey(long employeeEmailId)
		throws NoSuchEmployeeEmailException;

	/**
	 * Returns the employee email with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeEmailId the primary key of the employee email
	 * @return the employee email, or <code>null</code> if a employee email with the primary key could not be found
	 */
	public EmployeeEmail fetchByPrimaryKey(long employeeEmailId);

	/**
	 * Returns all the employee emails.
	 *
	 * @return the employee emails
	 */
	public java.util.List<EmployeeEmail> findAll();

	/**
	 * Returns a range of all the employee emails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeEmailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee emails
	 * @param end the upper bound of the range of employee emails (not inclusive)
	 * @return the range of employee emails
	 */
	public java.util.List<EmployeeEmail> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee emails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeEmailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee emails
	 * @param end the upper bound of the range of employee emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee emails
	 */
	public java.util.List<EmployeeEmail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeEmail>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee emails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeEmailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee emails
	 * @param end the upper bound of the range of employee emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee emails
	 */
	public java.util.List<EmployeeEmail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeEmail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee emails from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee emails.
	 *
	 * @return the number of employee emails
	 */
	public int countAll();

}