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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeBenefitSchemeException;
import com.adjecti.pis.liferay.model.EmployeeBenefitScheme;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee benefit scheme service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeBenefitSchemeUtil
 * @generated
 */
@ProviderType
public interface EmployeeBenefitSchemePersistence
	extends BasePersistence<EmployeeBenefitScheme> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeBenefitSchemeUtil} to access the employee benefit scheme persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee benefit schemes where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee benefit schemes
	 */
	public java.util.List<EmployeeBenefitScheme> findByEmployeeId(
		long employeeId);

	/**
	 * Returns a range of all the employee benefit schemes where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBenefitSchemeModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee benefit schemes
	 * @param end the upper bound of the range of employee benefit schemes (not inclusive)
	 * @return the range of matching employee benefit schemes
	 */
	public java.util.List<EmployeeBenefitScheme> findByEmployeeId(
		long employeeId, int start, int end);

	/**
	 * Returns an ordered range of all the employee benefit schemes where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBenefitSchemeModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee benefit schemes
	 * @param end the upper bound of the range of employee benefit schemes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee benefit schemes
	 */
	public java.util.List<EmployeeBenefitScheme> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeBenefitScheme>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee benefit schemes where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBenefitSchemeModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee benefit schemes
	 * @param end the upper bound of the range of employee benefit schemes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee benefit schemes
	 */
	public java.util.List<EmployeeBenefitScheme> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeBenefitScheme>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee benefit scheme in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee benefit scheme
	 * @throws NoSuchEmployeeBenefitSchemeException if a matching employee benefit scheme could not be found
	 */
	public EmployeeBenefitScheme findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeBenefitScheme> orderByComparator)
		throws NoSuchEmployeeBenefitSchemeException;

	/**
	 * Returns the first employee benefit scheme in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee benefit scheme, or <code>null</code> if a matching employee benefit scheme could not be found
	 */
	public EmployeeBenefitScheme fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeBenefitScheme>
			orderByComparator);

	/**
	 * Returns the last employee benefit scheme in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee benefit scheme
	 * @throws NoSuchEmployeeBenefitSchemeException if a matching employee benefit scheme could not be found
	 */
	public EmployeeBenefitScheme findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeBenefitScheme> orderByComparator)
		throws NoSuchEmployeeBenefitSchemeException;

	/**
	 * Returns the last employee benefit scheme in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee benefit scheme, or <code>null</code> if a matching employee benefit scheme could not be found
	 */
	public EmployeeBenefitScheme fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeBenefitScheme>
			orderByComparator);

	/**
	 * Returns the employee benefit schemes before and after the current employee benefit scheme in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeBenefitSchemeId the primary key of the current employee benefit scheme
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee benefit scheme
	 * @throws NoSuchEmployeeBenefitSchemeException if a employee benefit scheme with the primary key could not be found
	 */
	public EmployeeBenefitScheme[] findByEmployeeId_PrevAndNext(
			long employeeBenefitSchemeId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeBenefitScheme> orderByComparator)
		throws NoSuchEmployeeBenefitSchemeException;

	/**
	 * Removes all the employee benefit schemes where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of employee benefit schemes where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee benefit schemes
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Caches the employee benefit scheme in the entity cache if it is enabled.
	 *
	 * @param employeeBenefitScheme the employee benefit scheme
	 */
	public void cacheResult(EmployeeBenefitScheme employeeBenefitScheme);

	/**
	 * Caches the employee benefit schemes in the entity cache if it is enabled.
	 *
	 * @param employeeBenefitSchemes the employee benefit schemes
	 */
	public void cacheResult(
		java.util.List<EmployeeBenefitScheme> employeeBenefitSchemes);

	/**
	 * Creates a new employee benefit scheme with the primary key. Does not add the employee benefit scheme to the database.
	 *
	 * @param employeeBenefitSchemeId the primary key for the new employee benefit scheme
	 * @return the new employee benefit scheme
	 */
	public EmployeeBenefitScheme create(long employeeBenefitSchemeId);

	/**
	 * Removes the employee benefit scheme with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeBenefitSchemeId the primary key of the employee benefit scheme
	 * @return the employee benefit scheme that was removed
	 * @throws NoSuchEmployeeBenefitSchemeException if a employee benefit scheme with the primary key could not be found
	 */
	public EmployeeBenefitScheme remove(long employeeBenefitSchemeId)
		throws NoSuchEmployeeBenefitSchemeException;

	public EmployeeBenefitScheme updateImpl(
		EmployeeBenefitScheme employeeBenefitScheme);

	/**
	 * Returns the employee benefit scheme with the primary key or throws a <code>NoSuchEmployeeBenefitSchemeException</code> if it could not be found.
	 *
	 * @param employeeBenefitSchemeId the primary key of the employee benefit scheme
	 * @return the employee benefit scheme
	 * @throws NoSuchEmployeeBenefitSchemeException if a employee benefit scheme with the primary key could not be found
	 */
	public EmployeeBenefitScheme findByPrimaryKey(long employeeBenefitSchemeId)
		throws NoSuchEmployeeBenefitSchemeException;

	/**
	 * Returns the employee benefit scheme with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeBenefitSchemeId the primary key of the employee benefit scheme
	 * @return the employee benefit scheme, or <code>null</code> if a employee benefit scheme with the primary key could not be found
	 */
	public EmployeeBenefitScheme fetchByPrimaryKey(
		long employeeBenefitSchemeId);

	/**
	 * Returns all the employee benefit schemes.
	 *
	 * @return the employee benefit schemes
	 */
	public java.util.List<EmployeeBenefitScheme> findAll();

	/**
	 * Returns a range of all the employee benefit schemes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBenefitSchemeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee benefit schemes
	 * @param end the upper bound of the range of employee benefit schemes (not inclusive)
	 * @return the range of employee benefit schemes
	 */
	public java.util.List<EmployeeBenefitScheme> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee benefit schemes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBenefitSchemeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee benefit schemes
	 * @param end the upper bound of the range of employee benefit schemes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee benefit schemes
	 */
	public java.util.List<EmployeeBenefitScheme> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeBenefitScheme>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee benefit schemes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeBenefitSchemeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee benefit schemes
	 * @param end the upper bound of the range of employee benefit schemes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee benefit schemes
	 */
	public java.util.List<EmployeeBenefitScheme> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeBenefitScheme>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee benefit schemes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee benefit schemes.
	 *
	 * @return the number of employee benefit schemes
	 */
	public int countAll();

}