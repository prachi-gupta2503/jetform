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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeReportingException;
import com.adjecti.pis.liferay.model.EmployeeReporting;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee reporting service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeReportingUtil
 * @generated
 */
@ProviderType
public interface EmployeeReportingPersistence
	extends BasePersistence<EmployeeReporting> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeReportingUtil} to access the employee reporting persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee reportings where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee reportings
	 */
	public java.util.List<EmployeeReporting> findByEmployeeId(long employeeId);

	/**
	 * Returns a range of all the employee reportings where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeReportingModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee reportings
	 * @param end the upper bound of the range of employee reportings (not inclusive)
	 * @return the range of matching employee reportings
	 */
	public java.util.List<EmployeeReporting> findByEmployeeId(
		long employeeId, int start, int end);

	/**
	 * Returns an ordered range of all the employee reportings where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeReportingModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee reportings
	 * @param end the upper bound of the range of employee reportings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee reportings
	 */
	public java.util.List<EmployeeReporting> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeReporting>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee reportings where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeReportingModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee reportings
	 * @param end the upper bound of the range of employee reportings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee reportings
	 */
	public java.util.List<EmployeeReporting> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeReporting>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee reporting in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee reporting
	 * @throws NoSuchEmployeeReportingException if a matching employee reporting could not be found
	 */
	public EmployeeReporting findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeReporting>
				orderByComparator)
		throws NoSuchEmployeeReportingException;

	/**
	 * Returns the first employee reporting in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee reporting, or <code>null</code> if a matching employee reporting could not be found
	 */
	public EmployeeReporting fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeReporting>
			orderByComparator);

	/**
	 * Returns the last employee reporting in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee reporting
	 * @throws NoSuchEmployeeReportingException if a matching employee reporting could not be found
	 */
	public EmployeeReporting findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeReporting>
				orderByComparator)
		throws NoSuchEmployeeReportingException;

	/**
	 * Returns the last employee reporting in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee reporting, or <code>null</code> if a matching employee reporting could not be found
	 */
	public EmployeeReporting fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeReporting>
			orderByComparator);

	/**
	 * Returns the employee reportings before and after the current employee reporting in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeReportingId the primary key of the current employee reporting
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee reporting
	 * @throws NoSuchEmployeeReportingException if a employee reporting with the primary key could not be found
	 */
	public EmployeeReporting[] findByEmployeeId_PrevAndNext(
			long employeeReportingId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeReporting>
				orderByComparator)
		throws NoSuchEmployeeReportingException;

	/**
	 * Removes all the employee reportings where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of employee reportings where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee reportings
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Returns all the employee reportings where reportingToId = &#63;.
	 *
	 * @param reportingToId the reporting to ID
	 * @return the matching employee reportings
	 */
	public java.util.List<EmployeeReporting> findByReportingToId(
		long reportingToId);

	/**
	 * Returns a range of all the employee reportings where reportingToId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeReportingModelImpl</code>.
	 * </p>
	 *
	 * @param reportingToId the reporting to ID
	 * @param start the lower bound of the range of employee reportings
	 * @param end the upper bound of the range of employee reportings (not inclusive)
	 * @return the range of matching employee reportings
	 */
	public java.util.List<EmployeeReporting> findByReportingToId(
		long reportingToId, int start, int end);

	/**
	 * Returns an ordered range of all the employee reportings where reportingToId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeReportingModelImpl</code>.
	 * </p>
	 *
	 * @param reportingToId the reporting to ID
	 * @param start the lower bound of the range of employee reportings
	 * @param end the upper bound of the range of employee reportings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee reportings
	 */
	public java.util.List<EmployeeReporting> findByReportingToId(
		long reportingToId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeReporting>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee reportings where reportingToId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeReportingModelImpl</code>.
	 * </p>
	 *
	 * @param reportingToId the reporting to ID
	 * @param start the lower bound of the range of employee reportings
	 * @param end the upper bound of the range of employee reportings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee reportings
	 */
	public java.util.List<EmployeeReporting> findByReportingToId(
		long reportingToId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeReporting>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee reporting in the ordered set where reportingToId = &#63;.
	 *
	 * @param reportingToId the reporting to ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee reporting
	 * @throws NoSuchEmployeeReportingException if a matching employee reporting could not be found
	 */
	public EmployeeReporting findByReportingToId_First(
			long reportingToId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeReporting>
				orderByComparator)
		throws NoSuchEmployeeReportingException;

	/**
	 * Returns the first employee reporting in the ordered set where reportingToId = &#63;.
	 *
	 * @param reportingToId the reporting to ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee reporting, or <code>null</code> if a matching employee reporting could not be found
	 */
	public EmployeeReporting fetchByReportingToId_First(
		long reportingToId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeReporting>
			orderByComparator);

	/**
	 * Returns the last employee reporting in the ordered set where reportingToId = &#63;.
	 *
	 * @param reportingToId the reporting to ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee reporting
	 * @throws NoSuchEmployeeReportingException if a matching employee reporting could not be found
	 */
	public EmployeeReporting findByReportingToId_Last(
			long reportingToId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeReporting>
				orderByComparator)
		throws NoSuchEmployeeReportingException;

	/**
	 * Returns the last employee reporting in the ordered set where reportingToId = &#63;.
	 *
	 * @param reportingToId the reporting to ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee reporting, or <code>null</code> if a matching employee reporting could not be found
	 */
	public EmployeeReporting fetchByReportingToId_Last(
		long reportingToId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeReporting>
			orderByComparator);

	/**
	 * Returns the employee reportings before and after the current employee reporting in the ordered set where reportingToId = &#63;.
	 *
	 * @param employeeReportingId the primary key of the current employee reporting
	 * @param reportingToId the reporting to ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee reporting
	 * @throws NoSuchEmployeeReportingException if a employee reporting with the primary key could not be found
	 */
	public EmployeeReporting[] findByReportingToId_PrevAndNext(
			long employeeReportingId, long reportingToId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeReporting>
				orderByComparator)
		throws NoSuchEmployeeReportingException;

	/**
	 * Removes all the employee reportings where reportingToId = &#63; from the database.
	 *
	 * @param reportingToId the reporting to ID
	 */
	public void removeByReportingToId(long reportingToId);

	/**
	 * Returns the number of employee reportings where reportingToId = &#63;.
	 *
	 * @param reportingToId the reporting to ID
	 * @return the number of matching employee reportings
	 */
	public int countByReportingToId(long reportingToId);

	/**
	 * Caches the employee reporting in the entity cache if it is enabled.
	 *
	 * @param employeeReporting the employee reporting
	 */
	public void cacheResult(EmployeeReporting employeeReporting);

	/**
	 * Caches the employee reportings in the entity cache if it is enabled.
	 *
	 * @param employeeReportings the employee reportings
	 */
	public void cacheResult(
		java.util.List<EmployeeReporting> employeeReportings);

	/**
	 * Creates a new employee reporting with the primary key. Does not add the employee reporting to the database.
	 *
	 * @param employeeReportingId the primary key for the new employee reporting
	 * @return the new employee reporting
	 */
	public EmployeeReporting create(long employeeReportingId);

	/**
	 * Removes the employee reporting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeReportingId the primary key of the employee reporting
	 * @return the employee reporting that was removed
	 * @throws NoSuchEmployeeReportingException if a employee reporting with the primary key could not be found
	 */
	public EmployeeReporting remove(long employeeReportingId)
		throws NoSuchEmployeeReportingException;

	public EmployeeReporting updateImpl(EmployeeReporting employeeReporting);

	/**
	 * Returns the employee reporting with the primary key or throws a <code>NoSuchEmployeeReportingException</code> if it could not be found.
	 *
	 * @param employeeReportingId the primary key of the employee reporting
	 * @return the employee reporting
	 * @throws NoSuchEmployeeReportingException if a employee reporting with the primary key could not be found
	 */
	public EmployeeReporting findByPrimaryKey(long employeeReportingId)
		throws NoSuchEmployeeReportingException;

	/**
	 * Returns the employee reporting with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeReportingId the primary key of the employee reporting
	 * @return the employee reporting, or <code>null</code> if a employee reporting with the primary key could not be found
	 */
	public EmployeeReporting fetchByPrimaryKey(long employeeReportingId);

	/**
	 * Returns all the employee reportings.
	 *
	 * @return the employee reportings
	 */
	public java.util.List<EmployeeReporting> findAll();

	/**
	 * Returns a range of all the employee reportings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeReportingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee reportings
	 * @param end the upper bound of the range of employee reportings (not inclusive)
	 * @return the range of employee reportings
	 */
	public java.util.List<EmployeeReporting> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee reportings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeReportingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee reportings
	 * @param end the upper bound of the range of employee reportings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee reportings
	 */
	public java.util.List<EmployeeReporting> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeReporting>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee reportings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeReportingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee reportings
	 * @param end the upper bound of the range of employee reportings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee reportings
	 */
	public java.util.List<EmployeeReporting> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeReporting>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee reportings from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee reportings.
	 *
	 * @return the number of employee reportings
	 */
	public int countAll();

}