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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeSavingSchemeException;
import com.adjecti.pis.liferay.model.EmployeeSavingScheme;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee saving scheme service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeSavingSchemeUtil
 * @generated
 */
@ProviderType
public interface EmployeeSavingSchemePersistence
	extends BasePersistence<EmployeeSavingScheme> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeSavingSchemeUtil} to access the employee saving scheme persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee saving schemes where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee saving schemes
	 */
	public java.util.List<EmployeeSavingScheme> findByEmployeeId(
		long employeeId);

	/**
	 * Returns a range of all the employee saving schemes where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSavingSchemeModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee saving schemes
	 * @param end the upper bound of the range of employee saving schemes (not inclusive)
	 * @return the range of matching employee saving schemes
	 */
	public java.util.List<EmployeeSavingScheme> findByEmployeeId(
		long employeeId, int start, int end);

	/**
	 * Returns an ordered range of all the employee saving schemes where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSavingSchemeModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee saving schemes
	 * @param end the upper bound of the range of employee saving schemes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee saving schemes
	 */
	public java.util.List<EmployeeSavingScheme> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeSavingScheme>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee saving schemes where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSavingSchemeModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee saving schemes
	 * @param end the upper bound of the range of employee saving schemes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee saving schemes
	 */
	public java.util.List<EmployeeSavingScheme> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeSavingScheme>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee saving scheme in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee saving scheme
	 * @throws NoSuchEmployeeSavingSchemeException if a matching employee saving scheme could not be found
	 */
	public EmployeeSavingScheme findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeSavingScheme> orderByComparator)
		throws NoSuchEmployeeSavingSchemeException;

	/**
	 * Returns the first employee saving scheme in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee saving scheme, or <code>null</code> if a matching employee saving scheme could not be found
	 */
	public EmployeeSavingScheme fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeSavingScheme>
			orderByComparator);

	/**
	 * Returns the last employee saving scheme in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee saving scheme
	 * @throws NoSuchEmployeeSavingSchemeException if a matching employee saving scheme could not be found
	 */
	public EmployeeSavingScheme findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeSavingScheme> orderByComparator)
		throws NoSuchEmployeeSavingSchemeException;

	/**
	 * Returns the last employee saving scheme in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee saving scheme, or <code>null</code> if a matching employee saving scheme could not be found
	 */
	public EmployeeSavingScheme fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeSavingScheme>
			orderByComparator);

	/**
	 * Returns the employee saving schemes before and after the current employee saving scheme in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeSavingSchemeId the primary key of the current employee saving scheme
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee saving scheme
	 * @throws NoSuchEmployeeSavingSchemeException if a employee saving scheme with the primary key could not be found
	 */
	public EmployeeSavingScheme[] findByEmployeeId_PrevAndNext(
			long employeeSavingSchemeId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeSavingScheme> orderByComparator)
		throws NoSuchEmployeeSavingSchemeException;

	/**
	 * Removes all the employee saving schemes where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of employee saving schemes where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee saving schemes
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Caches the employee saving scheme in the entity cache if it is enabled.
	 *
	 * @param employeeSavingScheme the employee saving scheme
	 */
	public void cacheResult(EmployeeSavingScheme employeeSavingScheme);

	/**
	 * Caches the employee saving schemes in the entity cache if it is enabled.
	 *
	 * @param employeeSavingSchemes the employee saving schemes
	 */
	public void cacheResult(
		java.util.List<EmployeeSavingScheme> employeeSavingSchemes);

	/**
	 * Creates a new employee saving scheme with the primary key. Does not add the employee saving scheme to the database.
	 *
	 * @param employeeSavingSchemeId the primary key for the new employee saving scheme
	 * @return the new employee saving scheme
	 */
	public EmployeeSavingScheme create(long employeeSavingSchemeId);

	/**
	 * Removes the employee saving scheme with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeSavingSchemeId the primary key of the employee saving scheme
	 * @return the employee saving scheme that was removed
	 * @throws NoSuchEmployeeSavingSchemeException if a employee saving scheme with the primary key could not be found
	 */
	public EmployeeSavingScheme remove(long employeeSavingSchemeId)
		throws NoSuchEmployeeSavingSchemeException;

	public EmployeeSavingScheme updateImpl(
		EmployeeSavingScheme employeeSavingScheme);

	/**
	 * Returns the employee saving scheme with the primary key or throws a <code>NoSuchEmployeeSavingSchemeException</code> if it could not be found.
	 *
	 * @param employeeSavingSchemeId the primary key of the employee saving scheme
	 * @return the employee saving scheme
	 * @throws NoSuchEmployeeSavingSchemeException if a employee saving scheme with the primary key could not be found
	 */
	public EmployeeSavingScheme findByPrimaryKey(long employeeSavingSchemeId)
		throws NoSuchEmployeeSavingSchemeException;

	/**
	 * Returns the employee saving scheme with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeSavingSchemeId the primary key of the employee saving scheme
	 * @return the employee saving scheme, or <code>null</code> if a employee saving scheme with the primary key could not be found
	 */
	public EmployeeSavingScheme fetchByPrimaryKey(long employeeSavingSchemeId);

	/**
	 * Returns all the employee saving schemes.
	 *
	 * @return the employee saving schemes
	 */
	public java.util.List<EmployeeSavingScheme> findAll();

	/**
	 * Returns a range of all the employee saving schemes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSavingSchemeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee saving schemes
	 * @param end the upper bound of the range of employee saving schemes (not inclusive)
	 * @return the range of employee saving schemes
	 */
	public java.util.List<EmployeeSavingScheme> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee saving schemes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSavingSchemeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee saving schemes
	 * @param end the upper bound of the range of employee saving schemes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee saving schemes
	 */
	public java.util.List<EmployeeSavingScheme> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeSavingScheme>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee saving schemes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSavingSchemeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee saving schemes
	 * @param end the upper bound of the range of employee saving schemes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee saving schemes
	 */
	public java.util.List<EmployeeSavingScheme> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeSavingScheme>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee saving schemes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee saving schemes.
	 *
	 * @return the number of employee saving schemes
	 */
	public int countAll();

}