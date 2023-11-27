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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeTradeException;
import com.adjecti.pis.liferay.model.EmployeeTrade;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee trade service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeTradeUtil
 * @generated
 */
@ProviderType
public interface EmployeeTradePersistence
	extends BasePersistence<EmployeeTrade> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeTradeUtil} to access the employee trade persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee trades where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee trades
	 */
	public java.util.List<EmployeeTrade> findByEmployeeId(long employeeId);

	/**
	 * Returns a range of all the employee trades where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTradeModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee trades
	 * @param end the upper bound of the range of employee trades (not inclusive)
	 * @return the range of matching employee trades
	 */
	public java.util.List<EmployeeTrade> findByEmployeeId(
		long employeeId, int start, int end);

	/**
	 * Returns an ordered range of all the employee trades where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTradeModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee trades
	 * @param end the upper bound of the range of employee trades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee trades
	 */
	public java.util.List<EmployeeTrade> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeTrade>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee trades where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTradeModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee trades
	 * @param end the upper bound of the range of employee trades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee trades
	 */
	public java.util.List<EmployeeTrade> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeTrade>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee trade in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee trade
	 * @throws NoSuchEmployeeTradeException if a matching employee trade could not be found
	 */
	public EmployeeTrade findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeTrade>
				orderByComparator)
		throws NoSuchEmployeeTradeException;

	/**
	 * Returns the first employee trade in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee trade, or <code>null</code> if a matching employee trade could not be found
	 */
	public EmployeeTrade fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeTrade>
			orderByComparator);

	/**
	 * Returns the last employee trade in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee trade
	 * @throws NoSuchEmployeeTradeException if a matching employee trade could not be found
	 */
	public EmployeeTrade findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeTrade>
				orderByComparator)
		throws NoSuchEmployeeTradeException;

	/**
	 * Returns the last employee trade in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee trade, or <code>null</code> if a matching employee trade could not be found
	 */
	public EmployeeTrade fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeTrade>
			orderByComparator);

	/**
	 * Returns the employee trades before and after the current employee trade in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeTradeId the primary key of the current employee trade
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee trade
	 * @throws NoSuchEmployeeTradeException if a employee trade with the primary key could not be found
	 */
	public EmployeeTrade[] findByEmployeeId_PrevAndNext(
			long employeeTradeId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeTrade>
				orderByComparator)
		throws NoSuchEmployeeTradeException;

	/**
	 * Removes all the employee trades where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of employee trades where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee trades
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Caches the employee trade in the entity cache if it is enabled.
	 *
	 * @param employeeTrade the employee trade
	 */
	public void cacheResult(EmployeeTrade employeeTrade);

	/**
	 * Caches the employee trades in the entity cache if it is enabled.
	 *
	 * @param employeeTrades the employee trades
	 */
	public void cacheResult(java.util.List<EmployeeTrade> employeeTrades);

	/**
	 * Creates a new employee trade with the primary key. Does not add the employee trade to the database.
	 *
	 * @param employeeTradeId the primary key for the new employee trade
	 * @return the new employee trade
	 */
	public EmployeeTrade create(long employeeTradeId);

	/**
	 * Removes the employee trade with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeTradeId the primary key of the employee trade
	 * @return the employee trade that was removed
	 * @throws NoSuchEmployeeTradeException if a employee trade with the primary key could not be found
	 */
	public EmployeeTrade remove(long employeeTradeId)
		throws NoSuchEmployeeTradeException;

	public EmployeeTrade updateImpl(EmployeeTrade employeeTrade);

	/**
	 * Returns the employee trade with the primary key or throws a <code>NoSuchEmployeeTradeException</code> if it could not be found.
	 *
	 * @param employeeTradeId the primary key of the employee trade
	 * @return the employee trade
	 * @throws NoSuchEmployeeTradeException if a employee trade with the primary key could not be found
	 */
	public EmployeeTrade findByPrimaryKey(long employeeTradeId)
		throws NoSuchEmployeeTradeException;

	/**
	 * Returns the employee trade with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeTradeId the primary key of the employee trade
	 * @return the employee trade, or <code>null</code> if a employee trade with the primary key could not be found
	 */
	public EmployeeTrade fetchByPrimaryKey(long employeeTradeId);

	/**
	 * Returns all the employee trades.
	 *
	 * @return the employee trades
	 */
	public java.util.List<EmployeeTrade> findAll();

	/**
	 * Returns a range of all the employee trades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee trades
	 * @param end the upper bound of the range of employee trades (not inclusive)
	 * @return the range of employee trades
	 */
	public java.util.List<EmployeeTrade> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee trades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee trades
	 * @param end the upper bound of the range of employee trades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee trades
	 */
	public java.util.List<EmployeeTrade> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeTrade>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee trades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee trades
	 * @param end the upper bound of the range of employee trades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee trades
	 */
	public java.util.List<EmployeeTrade> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeTrade>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee trades from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee trades.
	 *
	 * @return the number of employee trades
	 */
	public int countAll();

}