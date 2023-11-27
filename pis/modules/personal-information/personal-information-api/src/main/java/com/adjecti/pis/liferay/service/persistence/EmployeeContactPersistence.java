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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeContactException;
import com.adjecti.pis.liferay.model.EmployeeContact;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee contact service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeContactUtil
 * @generated
 */
@ProviderType
public interface EmployeeContactPersistence
	extends BasePersistence<EmployeeContact> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeContactUtil} to access the employee contact persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee contacts where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee contacts
	 */
	public java.util.List<EmployeeContact> findByEmployeeId(long employeeId);

	/**
	 * Returns a range of all the employee contacts where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeContactModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee contacts
	 * @param end the upper bound of the range of employee contacts (not inclusive)
	 * @return the range of matching employee contacts
	 */
	public java.util.List<EmployeeContact> findByEmployeeId(
		long employeeId, int start, int end);

	/**
	 * Returns an ordered range of all the employee contacts where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeContactModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee contacts
	 * @param end the upper bound of the range of employee contacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee contacts
	 */
	public java.util.List<EmployeeContact> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeContact>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee contacts where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeContactModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee contacts
	 * @param end the upper bound of the range of employee contacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee contacts
	 */
	public java.util.List<EmployeeContact> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeContact>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee contact in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee contact
	 * @throws NoSuchEmployeeContactException if a matching employee contact could not be found
	 */
	public EmployeeContact findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeContact>
				orderByComparator)
		throws NoSuchEmployeeContactException;

	/**
	 * Returns the first employee contact in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee contact, or <code>null</code> if a matching employee contact could not be found
	 */
	public EmployeeContact fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeContact>
			orderByComparator);

	/**
	 * Returns the last employee contact in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee contact
	 * @throws NoSuchEmployeeContactException if a matching employee contact could not be found
	 */
	public EmployeeContact findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeContact>
				orderByComparator)
		throws NoSuchEmployeeContactException;

	/**
	 * Returns the last employee contact in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee contact, or <code>null</code> if a matching employee contact could not be found
	 */
	public EmployeeContact fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeContact>
			orderByComparator);

	/**
	 * Returns the employee contacts before and after the current employee contact in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeContactId the primary key of the current employee contact
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee contact
	 * @throws NoSuchEmployeeContactException if a employee contact with the primary key could not be found
	 */
	public EmployeeContact[] findByEmployeeId_PrevAndNext(
			long employeeContactId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeContact>
				orderByComparator)
		throws NoSuchEmployeeContactException;

	/**
	 * Removes all the employee contacts where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of employee contacts where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee contacts
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Caches the employee contact in the entity cache if it is enabled.
	 *
	 * @param employeeContact the employee contact
	 */
	public void cacheResult(EmployeeContact employeeContact);

	/**
	 * Caches the employee contacts in the entity cache if it is enabled.
	 *
	 * @param employeeContacts the employee contacts
	 */
	public void cacheResult(java.util.List<EmployeeContact> employeeContacts);

	/**
	 * Creates a new employee contact with the primary key. Does not add the employee contact to the database.
	 *
	 * @param employeeContactId the primary key for the new employee contact
	 * @return the new employee contact
	 */
	public EmployeeContact create(long employeeContactId);

	/**
	 * Removes the employee contact with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeContactId the primary key of the employee contact
	 * @return the employee contact that was removed
	 * @throws NoSuchEmployeeContactException if a employee contact with the primary key could not be found
	 */
	public EmployeeContact remove(long employeeContactId)
		throws NoSuchEmployeeContactException;

	public EmployeeContact updateImpl(EmployeeContact employeeContact);

	/**
	 * Returns the employee contact with the primary key or throws a <code>NoSuchEmployeeContactException</code> if it could not be found.
	 *
	 * @param employeeContactId the primary key of the employee contact
	 * @return the employee contact
	 * @throws NoSuchEmployeeContactException if a employee contact with the primary key could not be found
	 */
	public EmployeeContact findByPrimaryKey(long employeeContactId)
		throws NoSuchEmployeeContactException;

	/**
	 * Returns the employee contact with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeContactId the primary key of the employee contact
	 * @return the employee contact, or <code>null</code> if a employee contact with the primary key could not be found
	 */
	public EmployeeContact fetchByPrimaryKey(long employeeContactId);

	/**
	 * Returns all the employee contacts.
	 *
	 * @return the employee contacts
	 */
	public java.util.List<EmployeeContact> findAll();

	/**
	 * Returns a range of all the employee contacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeContactModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee contacts
	 * @param end the upper bound of the range of employee contacts (not inclusive)
	 * @return the range of employee contacts
	 */
	public java.util.List<EmployeeContact> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee contacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeContactModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee contacts
	 * @param end the upper bound of the range of employee contacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee contacts
	 */
	public java.util.List<EmployeeContact> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeContact>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee contacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeContactModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee contacts
	 * @param end the upper bound of the range of employee contacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee contacts
	 */
	public java.util.List<EmployeeContact> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeContact>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee contacts from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee contacts.
	 *
	 * @return the number of employee contacts
	 */
	public int countAll();

}