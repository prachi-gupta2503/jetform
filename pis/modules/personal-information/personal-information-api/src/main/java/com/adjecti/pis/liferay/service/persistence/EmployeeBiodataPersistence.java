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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeBiodataException;
import com.adjecti.pis.liferay.model.EmployeeBiodata;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee biodata service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeBiodataUtil
 * @generated
 */
@ProviderType
public interface EmployeeBiodataPersistence
	extends BasePersistence<EmployeeBiodata> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeBiodataUtil} to access the employee biodata persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee biodatas where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee biodatas
	 */
	public java.util.List<EmployeeBiodata> findByEmployeeId(long employeeId);

	/**
	 * Returns a range of all the employee biodatas where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBiodataModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee biodatas
	 * @param end the upper bound of the range of employee biodatas (not inclusive)
	 * @return the range of matching employee biodatas
	 */
	public java.util.List<EmployeeBiodata> findByEmployeeId(
		long employeeId, int start, int end);

	/**
	 * Returns an ordered range of all the employee biodatas where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBiodataModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee biodatas
	 * @param end the upper bound of the range of employee biodatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee biodatas
	 */
	public java.util.List<EmployeeBiodata> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeBiodata>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee biodatas where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBiodataModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee biodatas
	 * @param end the upper bound of the range of employee biodatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee biodatas
	 */
	public java.util.List<EmployeeBiodata> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeBiodata>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee biodata in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee biodata
	 * @throws NoSuchEmployeeBiodataException if a matching employee biodata could not be found
	 */
	public EmployeeBiodata findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeBiodata>
				orderByComparator)
		throws NoSuchEmployeeBiodataException;

	/**
	 * Returns the first employee biodata in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee biodata, or <code>null</code> if a matching employee biodata could not be found
	 */
	public EmployeeBiodata fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeBiodata>
			orderByComparator);

	/**
	 * Returns the last employee biodata in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee biodata
	 * @throws NoSuchEmployeeBiodataException if a matching employee biodata could not be found
	 */
	public EmployeeBiodata findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeBiodata>
				orderByComparator)
		throws NoSuchEmployeeBiodataException;

	/**
	 * Returns the last employee biodata in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee biodata, or <code>null</code> if a matching employee biodata could not be found
	 */
	public EmployeeBiodata fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeBiodata>
			orderByComparator);

	/**
	 * Returns the employee biodatas before and after the current employee biodata in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeBiodataId the primary key of the current employee biodata
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee biodata
	 * @throws NoSuchEmployeeBiodataException if a employee biodata with the primary key could not be found
	 */
	public EmployeeBiodata[] findByEmployeeId_PrevAndNext(
			long employeeBiodataId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeBiodata>
				orderByComparator)
		throws NoSuchEmployeeBiodataException;

	/**
	 * Removes all the employee biodatas where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of employee biodatas where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee biodatas
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Caches the employee biodata in the entity cache if it is enabled.
	 *
	 * @param employeeBiodata the employee biodata
	 */
	public void cacheResult(EmployeeBiodata employeeBiodata);

	/**
	 * Caches the employee biodatas in the entity cache if it is enabled.
	 *
	 * @param employeeBiodatas the employee biodatas
	 */
	public void cacheResult(java.util.List<EmployeeBiodata> employeeBiodatas);

	/**
	 * Creates a new employee biodata with the primary key. Does not add the employee biodata to the database.
	 *
	 * @param employeeBiodataId the primary key for the new employee biodata
	 * @return the new employee biodata
	 */
	public EmployeeBiodata create(long employeeBiodataId);

	/**
	 * Removes the employee biodata with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeBiodataId the primary key of the employee biodata
	 * @return the employee biodata that was removed
	 * @throws NoSuchEmployeeBiodataException if a employee biodata with the primary key could not be found
	 */
	public EmployeeBiodata remove(long employeeBiodataId)
		throws NoSuchEmployeeBiodataException;

	public EmployeeBiodata updateImpl(EmployeeBiodata employeeBiodata);

	/**
	 * Returns the employee biodata with the primary key or throws a <code>NoSuchEmployeeBiodataException</code> if it could not be found.
	 *
	 * @param employeeBiodataId the primary key of the employee biodata
	 * @return the employee biodata
	 * @throws NoSuchEmployeeBiodataException if a employee biodata with the primary key could not be found
	 */
	public EmployeeBiodata findByPrimaryKey(long employeeBiodataId)
		throws NoSuchEmployeeBiodataException;

	/**
	 * Returns the employee biodata with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeBiodataId the primary key of the employee biodata
	 * @return the employee biodata, or <code>null</code> if a employee biodata with the primary key could not be found
	 */
	public EmployeeBiodata fetchByPrimaryKey(long employeeBiodataId);

	/**
	 * Returns all the employee biodatas.
	 *
	 * @return the employee biodatas
	 */
	public java.util.List<EmployeeBiodata> findAll();

	/**
	 * Returns a range of all the employee biodatas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBiodataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee biodatas
	 * @param end the upper bound of the range of employee biodatas (not inclusive)
	 * @return the range of employee biodatas
	 */
	public java.util.List<EmployeeBiodata> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee biodatas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBiodataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee biodatas
	 * @param end the upper bound of the range of employee biodatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee biodatas
	 */
	public java.util.List<EmployeeBiodata> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeBiodata>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee biodatas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBiodataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee biodatas
	 * @param end the upper bound of the range of employee biodatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee biodatas
	 */
	public java.util.List<EmployeeBiodata> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeBiodata>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee biodatas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee biodatas.
	 *
	 * @return the number of employee biodatas
	 */
	public int countAll();

}