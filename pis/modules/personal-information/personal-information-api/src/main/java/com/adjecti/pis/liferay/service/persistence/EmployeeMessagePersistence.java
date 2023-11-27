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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeMessageException;
import com.adjecti.pis.liferay.model.EmployeeMessage;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee message service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeMessageUtil
 * @generated
 */
@ProviderType
public interface EmployeeMessagePersistence
	extends BasePersistence<EmployeeMessage> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeMessageUtil} to access the employee message persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee messages where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee messages
	 */
	public java.util.List<EmployeeMessage> findByEmployeeId(long employeeId);

	/**
	 * Returns a range of all the employee messages where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeMessageModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee messages
	 * @param end the upper bound of the range of employee messages (not inclusive)
	 * @return the range of matching employee messages
	 */
	public java.util.List<EmployeeMessage> findByEmployeeId(
		long employeeId, int start, int end);

	/**
	 * Returns an ordered range of all the employee messages where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeMessageModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee messages
	 * @param end the upper bound of the range of employee messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee messages
	 */
	public java.util.List<EmployeeMessage> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeMessage>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee messages where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeMessageModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee messages
	 * @param end the upper bound of the range of employee messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee messages
	 */
	public java.util.List<EmployeeMessage> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeMessage>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee message in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee message
	 * @throws NoSuchEmployeeMessageException if a matching employee message could not be found
	 */
	public EmployeeMessage findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeMessage>
				orderByComparator)
		throws NoSuchEmployeeMessageException;

	/**
	 * Returns the first employee message in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee message, or <code>null</code> if a matching employee message could not be found
	 */
	public EmployeeMessage fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeMessage>
			orderByComparator);

	/**
	 * Returns the last employee message in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee message
	 * @throws NoSuchEmployeeMessageException if a matching employee message could not be found
	 */
	public EmployeeMessage findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeMessage>
				orderByComparator)
		throws NoSuchEmployeeMessageException;

	/**
	 * Returns the last employee message in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee message, or <code>null</code> if a matching employee message could not be found
	 */
	public EmployeeMessage fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeMessage>
			orderByComparator);

	/**
	 * Returns the employee messages before and after the current employee message in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeMessageId the primary key of the current employee message
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee message
	 * @throws NoSuchEmployeeMessageException if a employee message with the primary key could not be found
	 */
	public EmployeeMessage[] findByEmployeeId_PrevAndNext(
			long employeeMessageId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeMessage>
				orderByComparator)
		throws NoSuchEmployeeMessageException;

	/**
	 * Removes all the employee messages where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of employee messages where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee messages
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Caches the employee message in the entity cache if it is enabled.
	 *
	 * @param employeeMessage the employee message
	 */
	public void cacheResult(EmployeeMessage employeeMessage);

	/**
	 * Caches the employee messages in the entity cache if it is enabled.
	 *
	 * @param employeeMessages the employee messages
	 */
	public void cacheResult(java.util.List<EmployeeMessage> employeeMessages);

	/**
	 * Creates a new employee message with the primary key. Does not add the employee message to the database.
	 *
	 * @param employeeMessageId the primary key for the new employee message
	 * @return the new employee message
	 */
	public EmployeeMessage create(long employeeMessageId);

	/**
	 * Removes the employee message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeMessageId the primary key of the employee message
	 * @return the employee message that was removed
	 * @throws NoSuchEmployeeMessageException if a employee message with the primary key could not be found
	 */
	public EmployeeMessage remove(long employeeMessageId)
		throws NoSuchEmployeeMessageException;

	public EmployeeMessage updateImpl(EmployeeMessage employeeMessage);

	/**
	 * Returns the employee message with the primary key or throws a <code>NoSuchEmployeeMessageException</code> if it could not be found.
	 *
	 * @param employeeMessageId the primary key of the employee message
	 * @return the employee message
	 * @throws NoSuchEmployeeMessageException if a employee message with the primary key could not be found
	 */
	public EmployeeMessage findByPrimaryKey(long employeeMessageId)
		throws NoSuchEmployeeMessageException;

	/**
	 * Returns the employee message with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeMessageId the primary key of the employee message
	 * @return the employee message, or <code>null</code> if a employee message with the primary key could not be found
	 */
	public EmployeeMessage fetchByPrimaryKey(long employeeMessageId);

	/**
	 * Returns all the employee messages.
	 *
	 * @return the employee messages
	 */
	public java.util.List<EmployeeMessage> findAll();

	/**
	 * Returns a range of all the employee messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeMessageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee messages
	 * @param end the upper bound of the range of employee messages (not inclusive)
	 * @return the range of employee messages
	 */
	public java.util.List<EmployeeMessage> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeMessageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee messages
	 * @param end the upper bound of the range of employee messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee messages
	 */
	public java.util.List<EmployeeMessage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeMessage>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeMessageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee messages
	 * @param end the upper bound of the range of employee messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee messages
	 */
	public java.util.List<EmployeeMessage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeMessage>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee messages from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee messages.
	 *
	 * @return the number of employee messages
	 */
	public int countAll();

}