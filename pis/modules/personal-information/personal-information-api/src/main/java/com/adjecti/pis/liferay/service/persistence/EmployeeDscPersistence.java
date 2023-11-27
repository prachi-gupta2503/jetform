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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeDscException;
import com.adjecti.pis.liferay.model.EmployeeDsc;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee dsc service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDscUtil
 * @generated
 */
@ProviderType
public interface EmployeeDscPersistence extends BasePersistence<EmployeeDsc> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeDscUtil} to access the employee dsc persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee dscs where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee dscs
	 */
	public java.util.List<EmployeeDsc> findByEmployeeId(long employeeId);

	/**
	 * Returns a range of all the employee dscs where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDscModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee dscs
	 * @param end the upper bound of the range of employee dscs (not inclusive)
	 * @return the range of matching employee dscs
	 */
	public java.util.List<EmployeeDsc> findByEmployeeId(
		long employeeId, int start, int end);

	/**
	 * Returns an ordered range of all the employee dscs where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDscModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee dscs
	 * @param end the upper bound of the range of employee dscs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee dscs
	 */
	public java.util.List<EmployeeDsc> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDsc>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee dscs where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDscModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee dscs
	 * @param end the upper bound of the range of employee dscs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee dscs
	 */
	public java.util.List<EmployeeDsc> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDsc>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee dsc in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee dsc
	 * @throws NoSuchEmployeeDscException if a matching employee dsc could not be found
	 */
	public EmployeeDsc findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDsc>
				orderByComparator)
		throws NoSuchEmployeeDscException;

	/**
	 * Returns the first employee dsc in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee dsc, or <code>null</code> if a matching employee dsc could not be found
	 */
	public EmployeeDsc fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDsc>
			orderByComparator);

	/**
	 * Returns the last employee dsc in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee dsc
	 * @throws NoSuchEmployeeDscException if a matching employee dsc could not be found
	 */
	public EmployeeDsc findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDsc>
				orderByComparator)
		throws NoSuchEmployeeDscException;

	/**
	 * Returns the last employee dsc in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee dsc, or <code>null</code> if a matching employee dsc could not be found
	 */
	public EmployeeDsc fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDsc>
			orderByComparator);

	/**
	 * Returns the employee dscs before and after the current employee dsc in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeDscId the primary key of the current employee dsc
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee dsc
	 * @throws NoSuchEmployeeDscException if a employee dsc with the primary key could not be found
	 */
	public EmployeeDsc[] findByEmployeeId_PrevAndNext(
			long employeeDscId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDsc>
				orderByComparator)
		throws NoSuchEmployeeDscException;

	/**
	 * Removes all the employee dscs where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of employee dscs where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee dscs
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Returns all the employee dscs where cid = &#63;.
	 *
	 * @param cid the cid
	 * @return the matching employee dscs
	 */
	public java.util.List<EmployeeDsc> findByCid(String cid);

	/**
	 * Returns a range of all the employee dscs where cid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDscModelImpl</code>.
	 * </p>
	 *
	 * @param cid the cid
	 * @param start the lower bound of the range of employee dscs
	 * @param end the upper bound of the range of employee dscs (not inclusive)
	 * @return the range of matching employee dscs
	 */
	public java.util.List<EmployeeDsc> findByCid(
		String cid, int start, int end);

	/**
	 * Returns an ordered range of all the employee dscs where cid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDscModelImpl</code>.
	 * </p>
	 *
	 * @param cid the cid
	 * @param start the lower bound of the range of employee dscs
	 * @param end the upper bound of the range of employee dscs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee dscs
	 */
	public java.util.List<EmployeeDsc> findByCid(
		String cid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDsc>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee dscs where cid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDscModelImpl</code>.
	 * </p>
	 *
	 * @param cid the cid
	 * @param start the lower bound of the range of employee dscs
	 * @param end the upper bound of the range of employee dscs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee dscs
	 */
	public java.util.List<EmployeeDsc> findByCid(
		String cid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDsc>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee dsc in the ordered set where cid = &#63;.
	 *
	 * @param cid the cid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee dsc
	 * @throws NoSuchEmployeeDscException if a matching employee dsc could not be found
	 */
	public EmployeeDsc findByCid_First(
			String cid,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDsc>
				orderByComparator)
		throws NoSuchEmployeeDscException;

	/**
	 * Returns the first employee dsc in the ordered set where cid = &#63;.
	 *
	 * @param cid the cid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee dsc, or <code>null</code> if a matching employee dsc could not be found
	 */
	public EmployeeDsc fetchByCid_First(
		String cid,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDsc>
			orderByComparator);

	/**
	 * Returns the last employee dsc in the ordered set where cid = &#63;.
	 *
	 * @param cid the cid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee dsc
	 * @throws NoSuchEmployeeDscException if a matching employee dsc could not be found
	 */
	public EmployeeDsc findByCid_Last(
			String cid,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDsc>
				orderByComparator)
		throws NoSuchEmployeeDscException;

	/**
	 * Returns the last employee dsc in the ordered set where cid = &#63;.
	 *
	 * @param cid the cid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee dsc, or <code>null</code> if a matching employee dsc could not be found
	 */
	public EmployeeDsc fetchByCid_Last(
		String cid,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDsc>
			orderByComparator);

	/**
	 * Returns the employee dscs before and after the current employee dsc in the ordered set where cid = &#63;.
	 *
	 * @param employeeDscId the primary key of the current employee dsc
	 * @param cid the cid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee dsc
	 * @throws NoSuchEmployeeDscException if a employee dsc with the primary key could not be found
	 */
	public EmployeeDsc[] findByCid_PrevAndNext(
			long employeeDscId, String cid,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDsc>
				orderByComparator)
		throws NoSuchEmployeeDscException;

	/**
	 * Removes all the employee dscs where cid = &#63; from the database.
	 *
	 * @param cid the cid
	 */
	public void removeByCid(String cid);

	/**
	 * Returns the number of employee dscs where cid = &#63;.
	 *
	 * @param cid the cid
	 * @return the number of matching employee dscs
	 */
	public int countByCid(String cid);

	/**
	 * Caches the employee dsc in the entity cache if it is enabled.
	 *
	 * @param employeeDsc the employee dsc
	 */
	public void cacheResult(EmployeeDsc employeeDsc);

	/**
	 * Caches the employee dscs in the entity cache if it is enabled.
	 *
	 * @param employeeDscs the employee dscs
	 */
	public void cacheResult(java.util.List<EmployeeDsc> employeeDscs);

	/**
	 * Creates a new employee dsc with the primary key. Does not add the employee dsc to the database.
	 *
	 * @param employeeDscId the primary key for the new employee dsc
	 * @return the new employee dsc
	 */
	public EmployeeDsc create(long employeeDscId);

	/**
	 * Removes the employee dsc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeDscId the primary key of the employee dsc
	 * @return the employee dsc that was removed
	 * @throws NoSuchEmployeeDscException if a employee dsc with the primary key could not be found
	 */
	public EmployeeDsc remove(long employeeDscId)
		throws NoSuchEmployeeDscException;

	public EmployeeDsc updateImpl(EmployeeDsc employeeDsc);

	/**
	 * Returns the employee dsc with the primary key or throws a <code>NoSuchEmployeeDscException</code> if it could not be found.
	 *
	 * @param employeeDscId the primary key of the employee dsc
	 * @return the employee dsc
	 * @throws NoSuchEmployeeDscException if a employee dsc with the primary key could not be found
	 */
	public EmployeeDsc findByPrimaryKey(long employeeDscId)
		throws NoSuchEmployeeDscException;

	/**
	 * Returns the employee dsc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeDscId the primary key of the employee dsc
	 * @return the employee dsc, or <code>null</code> if a employee dsc with the primary key could not be found
	 */
	public EmployeeDsc fetchByPrimaryKey(long employeeDscId);

	/**
	 * Returns all the employee dscs.
	 *
	 * @return the employee dscs
	 */
	public java.util.List<EmployeeDsc> findAll();

	/**
	 * Returns a range of all the employee dscs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDscModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee dscs
	 * @param end the upper bound of the range of employee dscs (not inclusive)
	 * @return the range of employee dscs
	 */
	public java.util.List<EmployeeDsc> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee dscs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDscModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee dscs
	 * @param end the upper bound of the range of employee dscs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee dscs
	 */
	public java.util.List<EmployeeDsc> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDsc>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee dscs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDscModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee dscs
	 * @param end the upper bound of the range of employee dscs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee dscs
	 */
	public java.util.List<EmployeeDsc> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDsc>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee dscs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee dscs.
	 *
	 * @return the number of employee dscs
	 */
	public int countAll();

}