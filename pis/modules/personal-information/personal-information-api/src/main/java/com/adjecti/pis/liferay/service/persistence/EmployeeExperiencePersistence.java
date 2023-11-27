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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeExperienceException;
import com.adjecti.pis.liferay.model.EmployeeExperience;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee experience service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeExperienceUtil
 * @generated
 */
@ProviderType
public interface EmployeeExperiencePersistence
	extends BasePersistence<EmployeeExperience> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeExperienceUtil} to access the employee experience persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee experiences where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee experiences
	 */
	public java.util.List<EmployeeExperience> findByEmployeeId(long employeeId);

	/**
	 * Returns a range of all the employee experiences where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @return the range of matching employee experiences
	 */
	public java.util.List<EmployeeExperience> findByEmployeeId(
		long employeeId, int start, int end);

	/**
	 * Returns an ordered range of all the employee experiences where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee experiences
	 */
	public java.util.List<EmployeeExperience> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee experiences where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee experiences
	 */
	public java.util.List<EmployeeExperience> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee experience in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee experience
	 * @throws NoSuchEmployeeExperienceException if a matching employee experience could not be found
	 */
	public EmployeeExperience findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
				orderByComparator)
		throws NoSuchEmployeeExperienceException;

	/**
	 * Returns the first employee experience in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	public EmployeeExperience fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
			orderByComparator);

	/**
	 * Returns the last employee experience in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee experience
	 * @throws NoSuchEmployeeExperienceException if a matching employee experience could not be found
	 */
	public EmployeeExperience findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
				orderByComparator)
		throws NoSuchEmployeeExperienceException;

	/**
	 * Returns the last employee experience in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	public EmployeeExperience fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
			orderByComparator);

	/**
	 * Returns the employee experiences before and after the current employee experience in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeExperienceId the primary key of the current employee experience
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee experience
	 * @throws NoSuchEmployeeExperienceException if a employee experience with the primary key could not be found
	 */
	public EmployeeExperience[] findByEmployeeId_PrevAndNext(
			long employeeExperienceId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
				orderByComparator)
		throws NoSuchEmployeeExperienceException;

	/**
	 * Removes all the employee experiences where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of employee experiences where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee experiences
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Returns all the employee experiences where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching employee experiences
	 */
	public java.util.List<EmployeeExperience> findByOrganizationId(
		long organizationId);

	/**
	 * Returns a range of all the employee experiences where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @return the range of matching employee experiences
	 */
	public java.util.List<EmployeeExperience> findByOrganizationId(
		long organizationId, int start, int end);

	/**
	 * Returns an ordered range of all the employee experiences where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee experiences
	 */
	public java.util.List<EmployeeExperience> findByOrganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee experiences where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee experiences
	 */
	public java.util.List<EmployeeExperience> findByOrganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee experience in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee experience
	 * @throws NoSuchEmployeeExperienceException if a matching employee experience could not be found
	 */
	public EmployeeExperience findByOrganizationId_First(
			long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
				orderByComparator)
		throws NoSuchEmployeeExperienceException;

	/**
	 * Returns the first employee experience in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	public EmployeeExperience fetchByOrganizationId_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
			orderByComparator);

	/**
	 * Returns the last employee experience in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee experience
	 * @throws NoSuchEmployeeExperienceException if a matching employee experience could not be found
	 */
	public EmployeeExperience findByOrganizationId_Last(
			long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
				orderByComparator)
		throws NoSuchEmployeeExperienceException;

	/**
	 * Returns the last employee experience in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	public EmployeeExperience fetchByOrganizationId_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
			orderByComparator);

	/**
	 * Returns the employee experiences before and after the current employee experience in the ordered set where organizationId = &#63;.
	 *
	 * @param employeeExperienceId the primary key of the current employee experience
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee experience
	 * @throws NoSuchEmployeeExperienceException if a employee experience with the primary key could not be found
	 */
	public EmployeeExperience[] findByOrganizationId_PrevAndNext(
			long employeeExperienceId, long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
				orderByComparator)
		throws NoSuchEmployeeExperienceException;

	/**
	 * Removes all the employee experiences where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	public void removeByOrganizationId(long organizationId);

	/**
	 * Returns the number of employee experiences where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching employee experiences
	 */
	public int countByOrganizationId(long organizationId);

	/**
	 * Returns all the employee experiences where workAreaMinorId = &#63;.
	 *
	 * @param workAreaMinorId the work area minor ID
	 * @return the matching employee experiences
	 */
	public java.util.List<EmployeeExperience> findByWorkAreaMinorId(
		long workAreaMinorId);

	/**
	 * Returns a range of all the employee experiences where workAreaMinorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param workAreaMinorId the work area minor ID
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @return the range of matching employee experiences
	 */
	public java.util.List<EmployeeExperience> findByWorkAreaMinorId(
		long workAreaMinorId, int start, int end);

	/**
	 * Returns an ordered range of all the employee experiences where workAreaMinorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param workAreaMinorId the work area minor ID
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee experiences
	 */
	public java.util.List<EmployeeExperience> findByWorkAreaMinorId(
		long workAreaMinorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee experiences where workAreaMinorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param workAreaMinorId the work area minor ID
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee experiences
	 */
	public java.util.List<EmployeeExperience> findByWorkAreaMinorId(
		long workAreaMinorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee experience in the ordered set where workAreaMinorId = &#63;.
	 *
	 * @param workAreaMinorId the work area minor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee experience
	 * @throws NoSuchEmployeeExperienceException if a matching employee experience could not be found
	 */
	public EmployeeExperience findByWorkAreaMinorId_First(
			long workAreaMinorId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
				orderByComparator)
		throws NoSuchEmployeeExperienceException;

	/**
	 * Returns the first employee experience in the ordered set where workAreaMinorId = &#63;.
	 *
	 * @param workAreaMinorId the work area minor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	public EmployeeExperience fetchByWorkAreaMinorId_First(
		long workAreaMinorId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
			orderByComparator);

	/**
	 * Returns the last employee experience in the ordered set where workAreaMinorId = &#63;.
	 *
	 * @param workAreaMinorId the work area minor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee experience
	 * @throws NoSuchEmployeeExperienceException if a matching employee experience could not be found
	 */
	public EmployeeExperience findByWorkAreaMinorId_Last(
			long workAreaMinorId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
				orderByComparator)
		throws NoSuchEmployeeExperienceException;

	/**
	 * Returns the last employee experience in the ordered set where workAreaMinorId = &#63;.
	 *
	 * @param workAreaMinorId the work area minor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	public EmployeeExperience fetchByWorkAreaMinorId_Last(
		long workAreaMinorId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
			orderByComparator);

	/**
	 * Returns the employee experiences before and after the current employee experience in the ordered set where workAreaMinorId = &#63;.
	 *
	 * @param employeeExperienceId the primary key of the current employee experience
	 * @param workAreaMinorId the work area minor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee experience
	 * @throws NoSuchEmployeeExperienceException if a employee experience with the primary key could not be found
	 */
	public EmployeeExperience[] findByWorkAreaMinorId_PrevAndNext(
			long employeeExperienceId, long workAreaMinorId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
				orderByComparator)
		throws NoSuchEmployeeExperienceException;

	/**
	 * Removes all the employee experiences where workAreaMinorId = &#63; from the database.
	 *
	 * @param workAreaMinorId the work area minor ID
	 */
	public void removeByWorkAreaMinorId(long workAreaMinorId);

	/**
	 * Returns the number of employee experiences where workAreaMinorId = &#63;.
	 *
	 * @param workAreaMinorId the work area minor ID
	 * @return the number of matching employee experiences
	 */
	public int countByWorkAreaMinorId(long workAreaMinorId);

	/**
	 * Returns all the employee experiences where workAreaId = &#63;.
	 *
	 * @param workAreaId the work area ID
	 * @return the matching employee experiences
	 */
	public java.util.List<EmployeeExperience> findByWorkAreaId(long workAreaId);

	/**
	 * Returns a range of all the employee experiences where workAreaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param workAreaId the work area ID
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @return the range of matching employee experiences
	 */
	public java.util.List<EmployeeExperience> findByWorkAreaId(
		long workAreaId, int start, int end);

	/**
	 * Returns an ordered range of all the employee experiences where workAreaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param workAreaId the work area ID
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee experiences
	 */
	public java.util.List<EmployeeExperience> findByWorkAreaId(
		long workAreaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee experiences where workAreaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param workAreaId the work area ID
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee experiences
	 */
	public java.util.List<EmployeeExperience> findByWorkAreaId(
		long workAreaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee experience in the ordered set where workAreaId = &#63;.
	 *
	 * @param workAreaId the work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee experience
	 * @throws NoSuchEmployeeExperienceException if a matching employee experience could not be found
	 */
	public EmployeeExperience findByWorkAreaId_First(
			long workAreaId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
				orderByComparator)
		throws NoSuchEmployeeExperienceException;

	/**
	 * Returns the first employee experience in the ordered set where workAreaId = &#63;.
	 *
	 * @param workAreaId the work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	public EmployeeExperience fetchByWorkAreaId_First(
		long workAreaId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
			orderByComparator);

	/**
	 * Returns the last employee experience in the ordered set where workAreaId = &#63;.
	 *
	 * @param workAreaId the work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee experience
	 * @throws NoSuchEmployeeExperienceException if a matching employee experience could not be found
	 */
	public EmployeeExperience findByWorkAreaId_Last(
			long workAreaId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
				orderByComparator)
		throws NoSuchEmployeeExperienceException;

	/**
	 * Returns the last employee experience in the ordered set where workAreaId = &#63;.
	 *
	 * @param workAreaId the work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	public EmployeeExperience fetchByWorkAreaId_Last(
		long workAreaId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
			orderByComparator);

	/**
	 * Returns the employee experiences before and after the current employee experience in the ordered set where workAreaId = &#63;.
	 *
	 * @param employeeExperienceId the primary key of the current employee experience
	 * @param workAreaId the work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee experience
	 * @throws NoSuchEmployeeExperienceException if a employee experience with the primary key could not be found
	 */
	public EmployeeExperience[] findByWorkAreaId_PrevAndNext(
			long employeeExperienceId, long workAreaId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
				orderByComparator)
		throws NoSuchEmployeeExperienceException;

	/**
	 * Removes all the employee experiences where workAreaId = &#63; from the database.
	 *
	 * @param workAreaId the work area ID
	 */
	public void removeByWorkAreaId(long workAreaId);

	/**
	 * Returns the number of employee experiences where workAreaId = &#63;.
	 *
	 * @param workAreaId the work area ID
	 * @return the number of matching employee experiences
	 */
	public int countByWorkAreaId(long workAreaId);

	/**
	 * Caches the employee experience in the entity cache if it is enabled.
	 *
	 * @param employeeExperience the employee experience
	 */
	public void cacheResult(EmployeeExperience employeeExperience);

	/**
	 * Caches the employee experiences in the entity cache if it is enabled.
	 *
	 * @param employeeExperiences the employee experiences
	 */
	public void cacheResult(
		java.util.List<EmployeeExperience> employeeExperiences);

	/**
	 * Creates a new employee experience with the primary key. Does not add the employee experience to the database.
	 *
	 * @param employeeExperienceId the primary key for the new employee experience
	 * @return the new employee experience
	 */
	public EmployeeExperience create(long employeeExperienceId);

	/**
	 * Removes the employee experience with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeExperienceId the primary key of the employee experience
	 * @return the employee experience that was removed
	 * @throws NoSuchEmployeeExperienceException if a employee experience with the primary key could not be found
	 */
	public EmployeeExperience remove(long employeeExperienceId)
		throws NoSuchEmployeeExperienceException;

	public EmployeeExperience updateImpl(EmployeeExperience employeeExperience);

	/**
	 * Returns the employee experience with the primary key or throws a <code>NoSuchEmployeeExperienceException</code> if it could not be found.
	 *
	 * @param employeeExperienceId the primary key of the employee experience
	 * @return the employee experience
	 * @throws NoSuchEmployeeExperienceException if a employee experience with the primary key could not be found
	 */
	public EmployeeExperience findByPrimaryKey(long employeeExperienceId)
		throws NoSuchEmployeeExperienceException;

	/**
	 * Returns the employee experience with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeExperienceId the primary key of the employee experience
	 * @return the employee experience, or <code>null</code> if a employee experience with the primary key could not be found
	 */
	public EmployeeExperience fetchByPrimaryKey(long employeeExperienceId);

	/**
	 * Returns all the employee experiences.
	 *
	 * @return the employee experiences
	 */
	public java.util.List<EmployeeExperience> findAll();

	/**
	 * Returns a range of all the employee experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @return the range of employee experiences
	 */
	public java.util.List<EmployeeExperience> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee experiences
	 */
	public java.util.List<EmployeeExperience> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee experiences
	 * @param end the upper bound of the range of employee experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee experiences
	 */
	public java.util.List<EmployeeExperience> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeExperience>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee experiences from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee experiences.
	 *
	 * @return the number of employee experiences
	 */
	public int countAll();

}