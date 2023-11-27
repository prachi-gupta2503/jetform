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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeApplicationException;
import com.adjecti.pis.liferay.model.EmployeeApplication;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee application service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeApplicationUtil
 * @generated
 */
@ProviderType
public interface EmployeeApplicationPersistence
	extends BasePersistence<EmployeeApplication> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeApplicationUtil} to access the employee application persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee applications where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee applications
	 */
	public java.util.List<EmployeeApplication> findByEmployeeId(
		long employeeId);

	/**
	 * Returns a range of all the employee applications where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee applications
	 * @param end the upper bound of the range of employee applications (not inclusive)
	 * @return the range of matching employee applications
	 */
	public java.util.List<EmployeeApplication> findByEmployeeId(
		long employeeId, int start, int end);

	/**
	 * Returns an ordered range of all the employee applications where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee applications
	 * @param end the upper bound of the range of employee applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee applications
	 */
	public java.util.List<EmployeeApplication> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeApplication>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee applications where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee applications
	 * @param end the upper bound of the range of employee applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee applications
	 */
	public java.util.List<EmployeeApplication> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeApplication>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee application in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee application
	 * @throws NoSuchEmployeeApplicationException if a matching employee application could not be found
	 */
	public EmployeeApplication findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeApplication> orderByComparator)
		throws NoSuchEmployeeApplicationException;

	/**
	 * Returns the first employee application in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee application, or <code>null</code> if a matching employee application could not be found
	 */
	public EmployeeApplication fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeApplication>
			orderByComparator);

	/**
	 * Returns the last employee application in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee application
	 * @throws NoSuchEmployeeApplicationException if a matching employee application could not be found
	 */
	public EmployeeApplication findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeApplication> orderByComparator)
		throws NoSuchEmployeeApplicationException;

	/**
	 * Returns the last employee application in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee application, or <code>null</code> if a matching employee application could not be found
	 */
	public EmployeeApplication fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeApplication>
			orderByComparator);

	/**
	 * Returns the employee applications before and after the current employee application in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeApplicationId the primary key of the current employee application
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee application
	 * @throws NoSuchEmployeeApplicationException if a employee application with the primary key could not be found
	 */
	public EmployeeApplication[] findByEmployeeId_PrevAndNext(
			long employeeApplicationId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeApplication> orderByComparator)
		throws NoSuchEmployeeApplicationException;

	/**
	 * Removes all the employee applications where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of employee applications where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee applications
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Caches the employee application in the entity cache if it is enabled.
	 *
	 * @param employeeApplication the employee application
	 */
	public void cacheResult(EmployeeApplication employeeApplication);

	/**
	 * Caches the employee applications in the entity cache if it is enabled.
	 *
	 * @param employeeApplications the employee applications
	 */
	public void cacheResult(
		java.util.List<EmployeeApplication> employeeApplications);

	/**
	 * Creates a new employee application with the primary key. Does not add the employee application to the database.
	 *
	 * @param employeeApplicationId the primary key for the new employee application
	 * @return the new employee application
	 */
	public EmployeeApplication create(long employeeApplicationId);

	/**
	 * Removes the employee application with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeApplicationId the primary key of the employee application
	 * @return the employee application that was removed
	 * @throws NoSuchEmployeeApplicationException if a employee application with the primary key could not be found
	 */
	public EmployeeApplication remove(long employeeApplicationId)
		throws NoSuchEmployeeApplicationException;

	public EmployeeApplication updateImpl(
		EmployeeApplication employeeApplication);

	/**
	 * Returns the employee application with the primary key or throws a <code>NoSuchEmployeeApplicationException</code> if it could not be found.
	 *
	 * @param employeeApplicationId the primary key of the employee application
	 * @return the employee application
	 * @throws NoSuchEmployeeApplicationException if a employee application with the primary key could not be found
	 */
	public EmployeeApplication findByPrimaryKey(long employeeApplicationId)
		throws NoSuchEmployeeApplicationException;

	/**
	 * Returns the employee application with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeApplicationId the primary key of the employee application
	 * @return the employee application, or <code>null</code> if a employee application with the primary key could not be found
	 */
	public EmployeeApplication fetchByPrimaryKey(long employeeApplicationId);

	/**
	 * Returns all the employee applications.
	 *
	 * @return the employee applications
	 */
	public java.util.List<EmployeeApplication> findAll();

	/**
	 * Returns a range of all the employee applications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee applications
	 * @param end the upper bound of the range of employee applications (not inclusive)
	 * @return the range of employee applications
	 */
	public java.util.List<EmployeeApplication> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee applications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee applications
	 * @param end the upper bound of the range of employee applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee applications
	 */
	public java.util.List<EmployeeApplication> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeApplication>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee applications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeApplicationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee applications
	 * @param end the upper bound of the range of employee applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee applications
	 */
	public java.util.List<EmployeeApplication> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeApplication>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee applications from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee applications.
	 *
	 * @return the number of employee applications
	 */
	public int countAll();

}