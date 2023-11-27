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

import com.adjecti.pis.liferay.exception.NoSuchEmployeePastExperienceException;
import com.adjecti.pis.liferay.model.EmployeePastExperience;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee past experience service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeePastExperienceUtil
 * @generated
 */
@ProviderType
public interface EmployeePastExperiencePersistence
	extends BasePersistence<EmployeePastExperience> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeePastExperienceUtil} to access the employee past experience persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee past experiences where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee past experiences
	 */
	public java.util.List<EmployeePastExperience> findByEmployeeId(
		long employeeId);

	/**
	 * Returns a range of all the employee past experiences where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePastExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee past experiences
	 * @param end the upper bound of the range of employee past experiences (not inclusive)
	 * @return the range of matching employee past experiences
	 */
	public java.util.List<EmployeePastExperience> findByEmployeeId(
		long employeeId, int start, int end);

	/**
	 * Returns an ordered range of all the employee past experiences where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePastExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee past experiences
	 * @param end the upper bound of the range of employee past experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee past experiences
	 */
	public java.util.List<EmployeePastExperience> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePastExperience>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee past experiences where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePastExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee past experiences
	 * @param end the upper bound of the range of employee past experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee past experiences
	 */
	public java.util.List<EmployeePastExperience> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePastExperience>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee past experience in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee past experience
	 * @throws NoSuchEmployeePastExperienceException if a matching employee past experience could not be found
	 */
	public EmployeePastExperience findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeePastExperience> orderByComparator)
		throws NoSuchEmployeePastExperienceException;

	/**
	 * Returns the first employee past experience in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee past experience, or <code>null</code> if a matching employee past experience could not be found
	 */
	public EmployeePastExperience fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePastExperience>
			orderByComparator);

	/**
	 * Returns the last employee past experience in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee past experience
	 * @throws NoSuchEmployeePastExperienceException if a matching employee past experience could not be found
	 */
	public EmployeePastExperience findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeePastExperience> orderByComparator)
		throws NoSuchEmployeePastExperienceException;

	/**
	 * Returns the last employee past experience in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee past experience, or <code>null</code> if a matching employee past experience could not be found
	 */
	public EmployeePastExperience fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePastExperience>
			orderByComparator);

	/**
	 * Returns the employee past experiences before and after the current employee past experience in the ordered set where employeeId = &#63;.
	 *
	 * @param employeePastExperienceId the primary key of the current employee past experience
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee past experience
	 * @throws NoSuchEmployeePastExperienceException if a employee past experience with the primary key could not be found
	 */
	public EmployeePastExperience[] findByEmployeeId_PrevAndNext(
			long employeePastExperienceId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeePastExperience> orderByComparator)
		throws NoSuchEmployeePastExperienceException;

	/**
	 * Removes all the employee past experiences where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of employee past experiences where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee past experiences
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Returns all the employee past experiences where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the matching employee past experiences
	 */
	public java.util.List<EmployeePastExperience> findByJoiningProcessId(
		long joiningProcessId);

	/**
	 * Returns a range of all the employee past experiences where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePastExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of employee past experiences
	 * @param end the upper bound of the range of employee past experiences (not inclusive)
	 * @return the range of matching employee past experiences
	 */
	public java.util.List<EmployeePastExperience> findByJoiningProcessId(
		long joiningProcessId, int start, int end);

	/**
	 * Returns an ordered range of all the employee past experiences where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePastExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of employee past experiences
	 * @param end the upper bound of the range of employee past experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee past experiences
	 */
	public java.util.List<EmployeePastExperience> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePastExperience>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee past experiences where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePastExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of employee past experiences
	 * @param end the upper bound of the range of employee past experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee past experiences
	 */
	public java.util.List<EmployeePastExperience> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePastExperience>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee past experience in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee past experience
	 * @throws NoSuchEmployeePastExperienceException if a matching employee past experience could not be found
	 */
	public EmployeePastExperience findByJoiningProcessId_First(
			long joiningProcessId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeePastExperience> orderByComparator)
		throws NoSuchEmployeePastExperienceException;

	/**
	 * Returns the first employee past experience in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee past experience, or <code>null</code> if a matching employee past experience could not be found
	 */
	public EmployeePastExperience fetchByJoiningProcessId_First(
		long joiningProcessId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePastExperience>
			orderByComparator);

	/**
	 * Returns the last employee past experience in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee past experience
	 * @throws NoSuchEmployeePastExperienceException if a matching employee past experience could not be found
	 */
	public EmployeePastExperience findByJoiningProcessId_Last(
			long joiningProcessId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeePastExperience> orderByComparator)
		throws NoSuchEmployeePastExperienceException;

	/**
	 * Returns the last employee past experience in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee past experience, or <code>null</code> if a matching employee past experience could not be found
	 */
	public EmployeePastExperience fetchByJoiningProcessId_Last(
		long joiningProcessId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePastExperience>
			orderByComparator);

	/**
	 * Returns the employee past experiences before and after the current employee past experience in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param employeePastExperienceId the primary key of the current employee past experience
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee past experience
	 * @throws NoSuchEmployeePastExperienceException if a employee past experience with the primary key could not be found
	 */
	public EmployeePastExperience[] findByJoiningProcessId_PrevAndNext(
			long employeePastExperienceId, long joiningProcessId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeePastExperience> orderByComparator)
		throws NoSuchEmployeePastExperienceException;

	/**
	 * Removes all the employee past experiences where joiningProcessId = &#63; from the database.
	 *
	 * @param joiningProcessId the joining process ID
	 */
	public void removeByJoiningProcessId(long joiningProcessId);

	/**
	 * Returns the number of employee past experiences where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the number of matching employee past experiences
	 */
	public int countByJoiningProcessId(long joiningProcessId);

	/**
	 * Returns all the employee past experiences where workAreaId = &#63;.
	 *
	 * @param workAreaId the work area ID
	 * @return the matching employee past experiences
	 */
	public java.util.List<EmployeePastExperience> findByWorkAreaId(
		long workAreaId);

	/**
	 * Returns a range of all the employee past experiences where workAreaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePastExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param workAreaId the work area ID
	 * @param start the lower bound of the range of employee past experiences
	 * @param end the upper bound of the range of employee past experiences (not inclusive)
	 * @return the range of matching employee past experiences
	 */
	public java.util.List<EmployeePastExperience> findByWorkAreaId(
		long workAreaId, int start, int end);

	/**
	 * Returns an ordered range of all the employee past experiences where workAreaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePastExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param workAreaId the work area ID
	 * @param start the lower bound of the range of employee past experiences
	 * @param end the upper bound of the range of employee past experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee past experiences
	 */
	public java.util.List<EmployeePastExperience> findByWorkAreaId(
		long workAreaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePastExperience>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee past experiences where workAreaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePastExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param workAreaId the work area ID
	 * @param start the lower bound of the range of employee past experiences
	 * @param end the upper bound of the range of employee past experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee past experiences
	 */
	public java.util.List<EmployeePastExperience> findByWorkAreaId(
		long workAreaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePastExperience>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee past experience in the ordered set where workAreaId = &#63;.
	 *
	 * @param workAreaId the work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee past experience
	 * @throws NoSuchEmployeePastExperienceException if a matching employee past experience could not be found
	 */
	public EmployeePastExperience findByWorkAreaId_First(
			long workAreaId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeePastExperience> orderByComparator)
		throws NoSuchEmployeePastExperienceException;

	/**
	 * Returns the first employee past experience in the ordered set where workAreaId = &#63;.
	 *
	 * @param workAreaId the work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee past experience, or <code>null</code> if a matching employee past experience could not be found
	 */
	public EmployeePastExperience fetchByWorkAreaId_First(
		long workAreaId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePastExperience>
			orderByComparator);

	/**
	 * Returns the last employee past experience in the ordered set where workAreaId = &#63;.
	 *
	 * @param workAreaId the work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee past experience
	 * @throws NoSuchEmployeePastExperienceException if a matching employee past experience could not be found
	 */
	public EmployeePastExperience findByWorkAreaId_Last(
			long workAreaId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeePastExperience> orderByComparator)
		throws NoSuchEmployeePastExperienceException;

	/**
	 * Returns the last employee past experience in the ordered set where workAreaId = &#63;.
	 *
	 * @param workAreaId the work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee past experience, or <code>null</code> if a matching employee past experience could not be found
	 */
	public EmployeePastExperience fetchByWorkAreaId_Last(
		long workAreaId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePastExperience>
			orderByComparator);

	/**
	 * Returns the employee past experiences before and after the current employee past experience in the ordered set where workAreaId = &#63;.
	 *
	 * @param employeePastExperienceId the primary key of the current employee past experience
	 * @param workAreaId the work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee past experience
	 * @throws NoSuchEmployeePastExperienceException if a employee past experience with the primary key could not be found
	 */
	public EmployeePastExperience[] findByWorkAreaId_PrevAndNext(
			long employeePastExperienceId, long workAreaId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeePastExperience> orderByComparator)
		throws NoSuchEmployeePastExperienceException;

	/**
	 * Removes all the employee past experiences where workAreaId = &#63; from the database.
	 *
	 * @param workAreaId the work area ID
	 */
	public void removeByWorkAreaId(long workAreaId);

	/**
	 * Returns the number of employee past experiences where workAreaId = &#63;.
	 *
	 * @param workAreaId the work area ID
	 * @return the number of matching employee past experiences
	 */
	public int countByWorkAreaId(long workAreaId);

	/**
	 * Caches the employee past experience in the entity cache if it is enabled.
	 *
	 * @param employeePastExperience the employee past experience
	 */
	public void cacheResult(EmployeePastExperience employeePastExperience);

	/**
	 * Caches the employee past experiences in the entity cache if it is enabled.
	 *
	 * @param employeePastExperiences the employee past experiences
	 */
	public void cacheResult(
		java.util.List<EmployeePastExperience> employeePastExperiences);

	/**
	 * Creates a new employee past experience with the primary key. Does not add the employee past experience to the database.
	 *
	 * @param employeePastExperienceId the primary key for the new employee past experience
	 * @return the new employee past experience
	 */
	public EmployeePastExperience create(long employeePastExperienceId);

	/**
	 * Removes the employee past experience with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeePastExperienceId the primary key of the employee past experience
	 * @return the employee past experience that was removed
	 * @throws NoSuchEmployeePastExperienceException if a employee past experience with the primary key could not be found
	 */
	public EmployeePastExperience remove(long employeePastExperienceId)
		throws NoSuchEmployeePastExperienceException;

	public EmployeePastExperience updateImpl(
		EmployeePastExperience employeePastExperience);

	/**
	 * Returns the employee past experience with the primary key or throws a <code>NoSuchEmployeePastExperienceException</code> if it could not be found.
	 *
	 * @param employeePastExperienceId the primary key of the employee past experience
	 * @return the employee past experience
	 * @throws NoSuchEmployeePastExperienceException if a employee past experience with the primary key could not be found
	 */
	public EmployeePastExperience findByPrimaryKey(
			long employeePastExperienceId)
		throws NoSuchEmployeePastExperienceException;

	/**
	 * Returns the employee past experience with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeePastExperienceId the primary key of the employee past experience
	 * @return the employee past experience, or <code>null</code> if a employee past experience with the primary key could not be found
	 */
	public EmployeePastExperience fetchByPrimaryKey(
		long employeePastExperienceId);

	/**
	 * Returns all the employee past experiences.
	 *
	 * @return the employee past experiences
	 */
	public java.util.List<EmployeePastExperience> findAll();

	/**
	 * Returns a range of all the employee past experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePastExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee past experiences
	 * @param end the upper bound of the range of employee past experiences (not inclusive)
	 * @return the range of employee past experiences
	 */
	public java.util.List<EmployeePastExperience> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee past experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePastExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee past experiences
	 * @param end the upper bound of the range of employee past experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee past experiences
	 */
	public java.util.List<EmployeePastExperience> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePastExperience>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee past experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePastExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee past experiences
	 * @param end the upper bound of the range of employee past experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee past experiences
	 */
	public java.util.List<EmployeePastExperience> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePastExperience>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee past experiences from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee past experiences.
	 *
	 * @return the number of employee past experiences
	 */
	public int countAll();

}