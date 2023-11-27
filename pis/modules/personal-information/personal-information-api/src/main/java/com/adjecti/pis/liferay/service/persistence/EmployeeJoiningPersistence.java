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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeJoiningException;
import com.adjecti.pis.liferay.model.EmployeeJoining;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee joining service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeJoiningUtil
 * @generated
 */
@ProviderType
public interface EmployeeJoiningPersistence
	extends BasePersistence<EmployeeJoining> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeJoiningUtil} to access the employee joining persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee joinings where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee joinings
	 */
	public java.util.List<EmployeeJoining> findByEmployeeId(long employeeId);

	/**
	 * Returns a range of all the employee joinings where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @return the range of matching employee joinings
	 */
	public java.util.List<EmployeeJoining> findByEmployeeId(
		long employeeId, int start, int end);

	/**
	 * Returns an ordered range of all the employee joinings where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee joinings
	 */
	public java.util.List<EmployeeJoining> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeJoining>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee joinings where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee joinings
	 */
	public java.util.List<EmployeeJoining> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeJoining>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee joining in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee joining
	 * @throws NoSuchEmployeeJoiningException if a matching employee joining could not be found
	 */
	public EmployeeJoining findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeJoining>
				orderByComparator)
		throws NoSuchEmployeeJoiningException;

	/**
	 * Returns the first employee joining in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee joining, or <code>null</code> if a matching employee joining could not be found
	 */
	public EmployeeJoining fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeJoining>
			orderByComparator);

	/**
	 * Returns the last employee joining in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee joining
	 * @throws NoSuchEmployeeJoiningException if a matching employee joining could not be found
	 */
	public EmployeeJoining findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeJoining>
				orderByComparator)
		throws NoSuchEmployeeJoiningException;

	/**
	 * Returns the last employee joining in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee joining, or <code>null</code> if a matching employee joining could not be found
	 */
	public EmployeeJoining fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeJoining>
			orderByComparator);

	/**
	 * Returns the employee joinings before and after the current employee joining in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeJoiningId the primary key of the current employee joining
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee joining
	 * @throws NoSuchEmployeeJoiningException if a employee joining with the primary key could not be found
	 */
	public EmployeeJoining[] findByEmployeeId_PrevAndNext(
			long employeeJoiningId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeJoining>
				orderByComparator)
		throws NoSuchEmployeeJoiningException;

	/**
	 * Removes all the employee joinings where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of employee joinings where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee joinings
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Returns all the employee joinings where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching employee joinings
	 */
	public java.util.List<EmployeeJoining> findByOrganizationId(
		long organizationId);

	/**
	 * Returns a range of all the employee joinings where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @return the range of matching employee joinings
	 */
	public java.util.List<EmployeeJoining> findByOrganizationId(
		long organizationId, int start, int end);

	/**
	 * Returns an ordered range of all the employee joinings where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee joinings
	 */
	public java.util.List<EmployeeJoining> findByOrganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeJoining>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee joinings where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee joinings
	 */
	public java.util.List<EmployeeJoining> findByOrganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeJoining>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee joining in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee joining
	 * @throws NoSuchEmployeeJoiningException if a matching employee joining could not be found
	 */
	public EmployeeJoining findByOrganizationId_First(
			long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeJoining>
				orderByComparator)
		throws NoSuchEmployeeJoiningException;

	/**
	 * Returns the first employee joining in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee joining, or <code>null</code> if a matching employee joining could not be found
	 */
	public EmployeeJoining fetchByOrganizationId_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeJoining>
			orderByComparator);

	/**
	 * Returns the last employee joining in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee joining
	 * @throws NoSuchEmployeeJoiningException if a matching employee joining could not be found
	 */
	public EmployeeJoining findByOrganizationId_Last(
			long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeJoining>
				orderByComparator)
		throws NoSuchEmployeeJoiningException;

	/**
	 * Returns the last employee joining in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee joining, or <code>null</code> if a matching employee joining could not be found
	 */
	public EmployeeJoining fetchByOrganizationId_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeJoining>
			orderByComparator);

	/**
	 * Returns the employee joinings before and after the current employee joining in the ordered set where organizationId = &#63;.
	 *
	 * @param employeeJoiningId the primary key of the current employee joining
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee joining
	 * @throws NoSuchEmployeeJoiningException if a employee joining with the primary key could not be found
	 */
	public EmployeeJoining[] findByOrganizationId_PrevAndNext(
			long employeeJoiningId, long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeJoining>
				orderByComparator)
		throws NoSuchEmployeeJoiningException;

	/**
	 * Removes all the employee joinings where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	public void removeByOrganizationId(long organizationId);

	/**
	 * Returns the number of employee joinings where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching employee joinings
	 */
	public int countByOrganizationId(long organizationId);

	/**
	 * Returns all the employee joinings where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the matching employee joinings
	 */
	public java.util.List<EmployeeJoining> findByJoiningProcessId(
		long joiningProcessId);

	/**
	 * Returns a range of all the employee joinings where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @return the range of matching employee joinings
	 */
	public java.util.List<EmployeeJoining> findByJoiningProcessId(
		long joiningProcessId, int start, int end);

	/**
	 * Returns an ordered range of all the employee joinings where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee joinings
	 */
	public java.util.List<EmployeeJoining> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeJoining>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee joinings where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee joinings
	 */
	public java.util.List<EmployeeJoining> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeJoining>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee joining in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee joining
	 * @throws NoSuchEmployeeJoiningException if a matching employee joining could not be found
	 */
	public EmployeeJoining findByJoiningProcessId_First(
			long joiningProcessId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeJoining>
				orderByComparator)
		throws NoSuchEmployeeJoiningException;

	/**
	 * Returns the first employee joining in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee joining, or <code>null</code> if a matching employee joining could not be found
	 */
	public EmployeeJoining fetchByJoiningProcessId_First(
		long joiningProcessId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeJoining>
			orderByComparator);

	/**
	 * Returns the last employee joining in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee joining
	 * @throws NoSuchEmployeeJoiningException if a matching employee joining could not be found
	 */
	public EmployeeJoining findByJoiningProcessId_Last(
			long joiningProcessId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeJoining>
				orderByComparator)
		throws NoSuchEmployeeJoiningException;

	/**
	 * Returns the last employee joining in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee joining, or <code>null</code> if a matching employee joining could not be found
	 */
	public EmployeeJoining fetchByJoiningProcessId_Last(
		long joiningProcessId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeJoining>
			orderByComparator);

	/**
	 * Returns the employee joinings before and after the current employee joining in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param employeeJoiningId the primary key of the current employee joining
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee joining
	 * @throws NoSuchEmployeeJoiningException if a employee joining with the primary key could not be found
	 */
	public EmployeeJoining[] findByJoiningProcessId_PrevAndNext(
			long employeeJoiningId, long joiningProcessId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeJoining>
				orderByComparator)
		throws NoSuchEmployeeJoiningException;

	/**
	 * Removes all the employee joinings where joiningProcessId = &#63; from the database.
	 *
	 * @param joiningProcessId the joining process ID
	 */
	public void removeByJoiningProcessId(long joiningProcessId);

	/**
	 * Returns the number of employee joinings where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the number of matching employee joinings
	 */
	public int countByJoiningProcessId(long joiningProcessId);

	/**
	 * Returns all the employee joinings where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @return the matching employee joinings
	 */
	public java.util.List<EmployeeJoining> findByGradeModeId(long gradeModeId);

	/**
	 * Returns a range of all the employee joinings where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @return the range of matching employee joinings
	 */
	public java.util.List<EmployeeJoining> findByGradeModeId(
		long gradeModeId, int start, int end);

	/**
	 * Returns an ordered range of all the employee joinings where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee joinings
	 */
	public java.util.List<EmployeeJoining> findByGradeModeId(
		long gradeModeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeJoining>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee joinings where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee joinings
	 */
	public java.util.List<EmployeeJoining> findByGradeModeId(
		long gradeModeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeJoining>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee joining in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee joining
	 * @throws NoSuchEmployeeJoiningException if a matching employee joining could not be found
	 */
	public EmployeeJoining findByGradeModeId_First(
			long gradeModeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeJoining>
				orderByComparator)
		throws NoSuchEmployeeJoiningException;

	/**
	 * Returns the first employee joining in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee joining, or <code>null</code> if a matching employee joining could not be found
	 */
	public EmployeeJoining fetchByGradeModeId_First(
		long gradeModeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeJoining>
			orderByComparator);

	/**
	 * Returns the last employee joining in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee joining
	 * @throws NoSuchEmployeeJoiningException if a matching employee joining could not be found
	 */
	public EmployeeJoining findByGradeModeId_Last(
			long gradeModeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeJoining>
				orderByComparator)
		throws NoSuchEmployeeJoiningException;

	/**
	 * Returns the last employee joining in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee joining, or <code>null</code> if a matching employee joining could not be found
	 */
	public EmployeeJoining fetchByGradeModeId_Last(
		long gradeModeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeJoining>
			orderByComparator);

	/**
	 * Returns the employee joinings before and after the current employee joining in the ordered set where gradeModeId = &#63;.
	 *
	 * @param employeeJoiningId the primary key of the current employee joining
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee joining
	 * @throws NoSuchEmployeeJoiningException if a employee joining with the primary key could not be found
	 */
	public EmployeeJoining[] findByGradeModeId_PrevAndNext(
			long employeeJoiningId, long gradeModeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeJoining>
				orderByComparator)
		throws NoSuchEmployeeJoiningException;

	/**
	 * Removes all the employee joinings where gradeModeId = &#63; from the database.
	 *
	 * @param gradeModeId the grade mode ID
	 */
	public void removeByGradeModeId(long gradeModeId);

	/**
	 * Returns the number of employee joinings where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @return the number of matching employee joinings
	 */
	public int countByGradeModeId(long gradeModeId);

	/**
	 * Returns all the employee joinings where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @return the matching employee joinings
	 */
	public java.util.List<EmployeeJoining> findBySubOrganizationId(
		long subOrganizationId);

	/**
	 * Returns a range of all the employee joinings where subOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @return the range of matching employee joinings
	 */
	public java.util.List<EmployeeJoining> findBySubOrganizationId(
		long subOrganizationId, int start, int end);

	/**
	 * Returns an ordered range of all the employee joinings where subOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee joinings
	 */
	public java.util.List<EmployeeJoining> findBySubOrganizationId(
		long subOrganizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeJoining>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee joinings where subOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee joinings
	 */
	public java.util.List<EmployeeJoining> findBySubOrganizationId(
		long subOrganizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeJoining>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee joining in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee joining
	 * @throws NoSuchEmployeeJoiningException if a matching employee joining could not be found
	 */
	public EmployeeJoining findBySubOrganizationId_First(
			long subOrganizationId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeJoining>
				orderByComparator)
		throws NoSuchEmployeeJoiningException;

	/**
	 * Returns the first employee joining in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee joining, or <code>null</code> if a matching employee joining could not be found
	 */
	public EmployeeJoining fetchBySubOrganizationId_First(
		long subOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeJoining>
			orderByComparator);

	/**
	 * Returns the last employee joining in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee joining
	 * @throws NoSuchEmployeeJoiningException if a matching employee joining could not be found
	 */
	public EmployeeJoining findBySubOrganizationId_Last(
			long subOrganizationId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeJoining>
				orderByComparator)
		throws NoSuchEmployeeJoiningException;

	/**
	 * Returns the last employee joining in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee joining, or <code>null</code> if a matching employee joining could not be found
	 */
	public EmployeeJoining fetchBySubOrganizationId_Last(
		long subOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeJoining>
			orderByComparator);

	/**
	 * Returns the employee joinings before and after the current employee joining in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param employeeJoiningId the primary key of the current employee joining
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee joining
	 * @throws NoSuchEmployeeJoiningException if a employee joining with the primary key could not be found
	 */
	public EmployeeJoining[] findBySubOrganizationId_PrevAndNext(
			long employeeJoiningId, long subOrganizationId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeJoining>
				orderByComparator)
		throws NoSuchEmployeeJoiningException;

	/**
	 * Removes all the employee joinings where subOrganizationId = &#63; from the database.
	 *
	 * @param subOrganizationId the sub organization ID
	 */
	public void removeBySubOrganizationId(long subOrganizationId);

	/**
	 * Returns the number of employee joinings where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @return the number of matching employee joinings
	 */
	public int countBySubOrganizationId(long subOrganizationId);

	/**
	 * Caches the employee joining in the entity cache if it is enabled.
	 *
	 * @param employeeJoining the employee joining
	 */
	public void cacheResult(EmployeeJoining employeeJoining);

	/**
	 * Caches the employee joinings in the entity cache if it is enabled.
	 *
	 * @param employeeJoinings the employee joinings
	 */
	public void cacheResult(java.util.List<EmployeeJoining> employeeJoinings);

	/**
	 * Creates a new employee joining with the primary key. Does not add the employee joining to the database.
	 *
	 * @param employeeJoiningId the primary key for the new employee joining
	 * @return the new employee joining
	 */
	public EmployeeJoining create(long employeeJoiningId);

	/**
	 * Removes the employee joining with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeJoiningId the primary key of the employee joining
	 * @return the employee joining that was removed
	 * @throws NoSuchEmployeeJoiningException if a employee joining with the primary key could not be found
	 */
	public EmployeeJoining remove(long employeeJoiningId)
		throws NoSuchEmployeeJoiningException;

	public EmployeeJoining updateImpl(EmployeeJoining employeeJoining);

	/**
	 * Returns the employee joining with the primary key or throws a <code>NoSuchEmployeeJoiningException</code> if it could not be found.
	 *
	 * @param employeeJoiningId the primary key of the employee joining
	 * @return the employee joining
	 * @throws NoSuchEmployeeJoiningException if a employee joining with the primary key could not be found
	 */
	public EmployeeJoining findByPrimaryKey(long employeeJoiningId)
		throws NoSuchEmployeeJoiningException;

	/**
	 * Returns the employee joining with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeJoiningId the primary key of the employee joining
	 * @return the employee joining, or <code>null</code> if a employee joining with the primary key could not be found
	 */
	public EmployeeJoining fetchByPrimaryKey(long employeeJoiningId);

	/**
	 * Returns all the employee joinings.
	 *
	 * @return the employee joinings
	 */
	public java.util.List<EmployeeJoining> findAll();

	/**
	 * Returns a range of all the employee joinings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @return the range of employee joinings
	 */
	public java.util.List<EmployeeJoining> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee joinings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee joinings
	 */
	public java.util.List<EmployeeJoining> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeJoining>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee joinings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee joinings
	 */
	public java.util.List<EmployeeJoining> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeJoining>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee joinings from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee joinings.
	 *
	 * @return the number of employee joinings
	 */
	public int countAll();

}