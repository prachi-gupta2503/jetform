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

import com.adjecti.pis.liferay.exception.NoSuchOrganizationAssignmentException;
import com.adjecti.pis.liferay.model.OrganizationAssignment;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the organization assignment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationAssignmentUtil
 * @generated
 */
@ProviderType
public interface OrganizationAssignmentPersistence
	extends BasePersistence<OrganizationAssignment> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OrganizationAssignmentUtil} to access the organization assignment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the organization assignments where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching organization assignments
	 */
	public java.util.List<OrganizationAssignment> findByEmployeeId(
		long employeeId);

	/**
	 * Returns a range of all the organization assignments where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @return the range of matching organization assignments
	 */
	public java.util.List<OrganizationAssignment> findByEmployeeId(
		long employeeId, int start, int end);

	/**
	 * Returns an ordered range of all the organization assignments where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization assignments
	 */
	public java.util.List<OrganizationAssignment> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationAssignment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the organization assignments where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization assignments
	 */
	public java.util.List<OrganizationAssignment> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationAssignment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first organization assignment in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a matching organization assignment could not be found
	 */
	public OrganizationAssignment findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<OrganizationAssignment> orderByComparator)
		throws NoSuchOrganizationAssignmentException;

	/**
	 * Returns the first organization assignment in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization assignment, or <code>null</code> if a matching organization assignment could not be found
	 */
	public OrganizationAssignment fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationAssignment>
			orderByComparator);

	/**
	 * Returns the last organization assignment in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a matching organization assignment could not be found
	 */
	public OrganizationAssignment findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<OrganizationAssignment> orderByComparator)
		throws NoSuchOrganizationAssignmentException;

	/**
	 * Returns the last organization assignment in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization assignment, or <code>null</code> if a matching organization assignment could not be found
	 */
	public OrganizationAssignment fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationAssignment>
			orderByComparator);

	/**
	 * Returns the organization assignments before and after the current organization assignment in the ordered set where employeeId = &#63;.
	 *
	 * @param organizationAssignmentId the primary key of the current organization assignment
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a organization assignment with the primary key could not be found
	 */
	public OrganizationAssignment[] findByEmployeeId_PrevAndNext(
			long organizationAssignmentId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<OrganizationAssignment> orderByComparator)
		throws NoSuchOrganizationAssignmentException;

	/**
	 * Removes all the organization assignments where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of organization assignments where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching organization assignments
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Returns all the organization assignments where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @return the matching organization assignments
	 */
	public java.util.List<OrganizationAssignment> findByPersonalNo(
		String personalNo);

	/**
	 * Returns a range of all the organization assignments where personalNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param personalNo the personal no
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @return the range of matching organization assignments
	 */
	public java.util.List<OrganizationAssignment> findByPersonalNo(
		String personalNo, int start, int end);

	/**
	 * Returns an ordered range of all the organization assignments where personalNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param personalNo the personal no
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization assignments
	 */
	public java.util.List<OrganizationAssignment> findByPersonalNo(
		String personalNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationAssignment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the organization assignments where personalNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param personalNo the personal no
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization assignments
	 */
	public java.util.List<OrganizationAssignment> findByPersonalNo(
		String personalNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationAssignment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first organization assignment in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a matching organization assignment could not be found
	 */
	public OrganizationAssignment findByPersonalNo_First(
			String personalNo,
			com.liferay.portal.kernel.util.OrderByComparator
				<OrganizationAssignment> orderByComparator)
		throws NoSuchOrganizationAssignmentException;

	/**
	 * Returns the first organization assignment in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization assignment, or <code>null</code> if a matching organization assignment could not be found
	 */
	public OrganizationAssignment fetchByPersonalNo_First(
		String personalNo,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationAssignment>
			orderByComparator);

	/**
	 * Returns the last organization assignment in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a matching organization assignment could not be found
	 */
	public OrganizationAssignment findByPersonalNo_Last(
			String personalNo,
			com.liferay.portal.kernel.util.OrderByComparator
				<OrganizationAssignment> orderByComparator)
		throws NoSuchOrganizationAssignmentException;

	/**
	 * Returns the last organization assignment in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization assignment, or <code>null</code> if a matching organization assignment could not be found
	 */
	public OrganizationAssignment fetchByPersonalNo_Last(
		String personalNo,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationAssignment>
			orderByComparator);

	/**
	 * Returns the organization assignments before and after the current organization assignment in the ordered set where personalNo = &#63;.
	 *
	 * @param organizationAssignmentId the primary key of the current organization assignment
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a organization assignment with the primary key could not be found
	 */
	public OrganizationAssignment[] findByPersonalNo_PrevAndNext(
			long organizationAssignmentId, String personalNo,
			com.liferay.portal.kernel.util.OrderByComparator
				<OrganizationAssignment> orderByComparator)
		throws NoSuchOrganizationAssignmentException;

	/**
	 * Removes all the organization assignments where personalNo = &#63; from the database.
	 *
	 * @param personalNo the personal no
	 */
	public void removeByPersonalNo(String personalNo);

	/**
	 * Returns the number of organization assignments where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @return the number of matching organization assignments
	 */
	public int countByPersonalNo(String personalNo);

	/**
	 * Returns all the organization assignments where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching organization assignments
	 */
	public java.util.List<OrganizationAssignment> findByOrganizationId(
		long organizationId);

	/**
	 * Returns a range of all the organization assignments where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @return the range of matching organization assignments
	 */
	public java.util.List<OrganizationAssignment> findByOrganizationId(
		long organizationId, int start, int end);

	/**
	 * Returns an ordered range of all the organization assignments where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization assignments
	 */
	public java.util.List<OrganizationAssignment> findByOrganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationAssignment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the organization assignments where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization assignments
	 */
	public java.util.List<OrganizationAssignment> findByOrganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationAssignment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first organization assignment in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a matching organization assignment could not be found
	 */
	public OrganizationAssignment findByOrganizationId_First(
			long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<OrganizationAssignment> orderByComparator)
		throws NoSuchOrganizationAssignmentException;

	/**
	 * Returns the first organization assignment in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization assignment, or <code>null</code> if a matching organization assignment could not be found
	 */
	public OrganizationAssignment fetchByOrganizationId_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationAssignment>
			orderByComparator);

	/**
	 * Returns the last organization assignment in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a matching organization assignment could not be found
	 */
	public OrganizationAssignment findByOrganizationId_Last(
			long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<OrganizationAssignment> orderByComparator)
		throws NoSuchOrganizationAssignmentException;

	/**
	 * Returns the last organization assignment in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization assignment, or <code>null</code> if a matching organization assignment could not be found
	 */
	public OrganizationAssignment fetchByOrganizationId_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationAssignment>
			orderByComparator);

	/**
	 * Returns the organization assignments before and after the current organization assignment in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationAssignmentId the primary key of the current organization assignment
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a organization assignment with the primary key could not be found
	 */
	public OrganizationAssignment[] findByOrganizationId_PrevAndNext(
			long organizationAssignmentId, long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<OrganizationAssignment> orderByComparator)
		throws NoSuchOrganizationAssignmentException;

	/**
	 * Removes all the organization assignments where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	public void removeByOrganizationId(long organizationId);

	/**
	 * Returns the number of organization assignments where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching organization assignments
	 */
	public int countByOrganizationId(long organizationId);

	/**
	 * Returns all the organization assignments where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @return the matching organization assignments
	 */
	public java.util.List<OrganizationAssignment> findByOrganizationCode(
		String organizationCode);

	/**
	 * Returns a range of all the organization assignments where organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @return the range of matching organization assignments
	 */
	public java.util.List<OrganizationAssignment> findByOrganizationCode(
		String organizationCode, int start, int end);

	/**
	 * Returns an ordered range of all the organization assignments where organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization assignments
	 */
	public java.util.List<OrganizationAssignment> findByOrganizationCode(
		String organizationCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationAssignment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the organization assignments where organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization assignments
	 */
	public java.util.List<OrganizationAssignment> findByOrganizationCode(
		String organizationCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationAssignment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first organization assignment in the ordered set where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a matching organization assignment could not be found
	 */
	public OrganizationAssignment findByOrganizationCode_First(
			String organizationCode,
			com.liferay.portal.kernel.util.OrderByComparator
				<OrganizationAssignment> orderByComparator)
		throws NoSuchOrganizationAssignmentException;

	/**
	 * Returns the first organization assignment in the ordered set where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization assignment, or <code>null</code> if a matching organization assignment could not be found
	 */
	public OrganizationAssignment fetchByOrganizationCode_First(
		String organizationCode,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationAssignment>
			orderByComparator);

	/**
	 * Returns the last organization assignment in the ordered set where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a matching organization assignment could not be found
	 */
	public OrganizationAssignment findByOrganizationCode_Last(
			String organizationCode,
			com.liferay.portal.kernel.util.OrderByComparator
				<OrganizationAssignment> orderByComparator)
		throws NoSuchOrganizationAssignmentException;

	/**
	 * Returns the last organization assignment in the ordered set where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization assignment, or <code>null</code> if a matching organization assignment could not be found
	 */
	public OrganizationAssignment fetchByOrganizationCode_Last(
		String organizationCode,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationAssignment>
			orderByComparator);

	/**
	 * Returns the organization assignments before and after the current organization assignment in the ordered set where organizationCode = &#63;.
	 *
	 * @param organizationAssignmentId the primary key of the current organization assignment
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a organization assignment with the primary key could not be found
	 */
	public OrganizationAssignment[] findByOrganizationCode_PrevAndNext(
			long organizationAssignmentId, String organizationCode,
			com.liferay.portal.kernel.util.OrderByComparator
				<OrganizationAssignment> orderByComparator)
		throws NoSuchOrganizationAssignmentException;

	/**
	 * Removes all the organization assignments where organizationCode = &#63; from the database.
	 *
	 * @param organizationCode the organization code
	 */
	public void removeByOrganizationCode(String organizationCode);

	/**
	 * Returns the number of organization assignments where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @return the number of matching organization assignments
	 */
	public int countByOrganizationCode(String organizationCode);

	/**
	 * Returns all the organization assignments where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @return the matching organization assignments
	 */
	public java.util.List<OrganizationAssignment> findBySubOrganizationId(
		long subOrganizationId);

	/**
	 * Returns a range of all the organization assignments where subOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @return the range of matching organization assignments
	 */
	public java.util.List<OrganizationAssignment> findBySubOrganizationId(
		long subOrganizationId, int start, int end);

	/**
	 * Returns an ordered range of all the organization assignments where subOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization assignments
	 */
	public java.util.List<OrganizationAssignment> findBySubOrganizationId(
		long subOrganizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationAssignment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the organization assignments where subOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization assignments
	 */
	public java.util.List<OrganizationAssignment> findBySubOrganizationId(
		long subOrganizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationAssignment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first organization assignment in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a matching organization assignment could not be found
	 */
	public OrganizationAssignment findBySubOrganizationId_First(
			long subOrganizationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<OrganizationAssignment> orderByComparator)
		throws NoSuchOrganizationAssignmentException;

	/**
	 * Returns the first organization assignment in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization assignment, or <code>null</code> if a matching organization assignment could not be found
	 */
	public OrganizationAssignment fetchBySubOrganizationId_First(
		long subOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationAssignment>
			orderByComparator);

	/**
	 * Returns the last organization assignment in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a matching organization assignment could not be found
	 */
	public OrganizationAssignment findBySubOrganizationId_Last(
			long subOrganizationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<OrganizationAssignment> orderByComparator)
		throws NoSuchOrganizationAssignmentException;

	/**
	 * Returns the last organization assignment in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization assignment, or <code>null</code> if a matching organization assignment could not be found
	 */
	public OrganizationAssignment fetchBySubOrganizationId_Last(
		long subOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationAssignment>
			orderByComparator);

	/**
	 * Returns the organization assignments before and after the current organization assignment in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param organizationAssignmentId the primary key of the current organization assignment
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a organization assignment with the primary key could not be found
	 */
	public OrganizationAssignment[] findBySubOrganizationId_PrevAndNext(
			long organizationAssignmentId, long subOrganizationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<OrganizationAssignment> orderByComparator)
		throws NoSuchOrganizationAssignmentException;

	/**
	 * Removes all the organization assignments where subOrganizationId = &#63; from the database.
	 *
	 * @param subOrganizationId the sub organization ID
	 */
	public void removeBySubOrganizationId(long subOrganizationId);

	/**
	 * Returns the number of organization assignments where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @return the number of matching organization assignments
	 */
	public int countBySubOrganizationId(long subOrganizationId);

	/**
	 * Returns all the organization assignments where subOrganizationCode = &#63;.
	 *
	 * @param subOrganizationCode the sub organization code
	 * @return the matching organization assignments
	 */
	public java.util.List<OrganizationAssignment> findBySubOrganizationCode(
		String subOrganizationCode);

	/**
	 * Returns a range of all the organization assignments where subOrganizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param subOrganizationCode the sub organization code
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @return the range of matching organization assignments
	 */
	public java.util.List<OrganizationAssignment> findBySubOrganizationCode(
		String subOrganizationCode, int start, int end);

	/**
	 * Returns an ordered range of all the organization assignments where subOrganizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param subOrganizationCode the sub organization code
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization assignments
	 */
	public java.util.List<OrganizationAssignment> findBySubOrganizationCode(
		String subOrganizationCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationAssignment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the organization assignments where subOrganizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param subOrganizationCode the sub organization code
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization assignments
	 */
	public java.util.List<OrganizationAssignment> findBySubOrganizationCode(
		String subOrganizationCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationAssignment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first organization assignment in the ordered set where subOrganizationCode = &#63;.
	 *
	 * @param subOrganizationCode the sub organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a matching organization assignment could not be found
	 */
	public OrganizationAssignment findBySubOrganizationCode_First(
			String subOrganizationCode,
			com.liferay.portal.kernel.util.OrderByComparator
				<OrganizationAssignment> orderByComparator)
		throws NoSuchOrganizationAssignmentException;

	/**
	 * Returns the first organization assignment in the ordered set where subOrganizationCode = &#63;.
	 *
	 * @param subOrganizationCode the sub organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization assignment, or <code>null</code> if a matching organization assignment could not be found
	 */
	public OrganizationAssignment fetchBySubOrganizationCode_First(
		String subOrganizationCode,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationAssignment>
			orderByComparator);

	/**
	 * Returns the last organization assignment in the ordered set where subOrganizationCode = &#63;.
	 *
	 * @param subOrganizationCode the sub organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a matching organization assignment could not be found
	 */
	public OrganizationAssignment findBySubOrganizationCode_Last(
			String subOrganizationCode,
			com.liferay.portal.kernel.util.OrderByComparator
				<OrganizationAssignment> orderByComparator)
		throws NoSuchOrganizationAssignmentException;

	/**
	 * Returns the last organization assignment in the ordered set where subOrganizationCode = &#63;.
	 *
	 * @param subOrganizationCode the sub organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization assignment, or <code>null</code> if a matching organization assignment could not be found
	 */
	public OrganizationAssignment fetchBySubOrganizationCode_Last(
		String subOrganizationCode,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationAssignment>
			orderByComparator);

	/**
	 * Returns the organization assignments before and after the current organization assignment in the ordered set where subOrganizationCode = &#63;.
	 *
	 * @param organizationAssignmentId the primary key of the current organization assignment
	 * @param subOrganizationCode the sub organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a organization assignment with the primary key could not be found
	 */
	public OrganizationAssignment[] findBySubOrganizationCode_PrevAndNext(
			long organizationAssignmentId, String subOrganizationCode,
			com.liferay.portal.kernel.util.OrderByComparator
				<OrganizationAssignment> orderByComparator)
		throws NoSuchOrganizationAssignmentException;

	/**
	 * Removes all the organization assignments where subOrganizationCode = &#63; from the database.
	 *
	 * @param subOrganizationCode the sub organization code
	 */
	public void removeBySubOrganizationCode(String subOrganizationCode);

	/**
	 * Returns the number of organization assignments where subOrganizationCode = &#63;.
	 *
	 * @param subOrganizationCode the sub organization code
	 * @return the number of matching organization assignments
	 */
	public int countBySubOrganizationCode(String subOrganizationCode);

	/**
	 * Caches the organization assignment in the entity cache if it is enabled.
	 *
	 * @param organizationAssignment the organization assignment
	 */
	public void cacheResult(OrganizationAssignment organizationAssignment);

	/**
	 * Caches the organization assignments in the entity cache if it is enabled.
	 *
	 * @param organizationAssignments the organization assignments
	 */
	public void cacheResult(
		java.util.List<OrganizationAssignment> organizationAssignments);

	/**
	 * Creates a new organization assignment with the primary key. Does not add the organization assignment to the database.
	 *
	 * @param organizationAssignmentId the primary key for the new organization assignment
	 * @return the new organization assignment
	 */
	public OrganizationAssignment create(long organizationAssignmentId);

	/**
	 * Removes the organization assignment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param organizationAssignmentId the primary key of the organization assignment
	 * @return the organization assignment that was removed
	 * @throws NoSuchOrganizationAssignmentException if a organization assignment with the primary key could not be found
	 */
	public OrganizationAssignment remove(long organizationAssignmentId)
		throws NoSuchOrganizationAssignmentException;

	public OrganizationAssignment updateImpl(
		OrganizationAssignment organizationAssignment);

	/**
	 * Returns the organization assignment with the primary key or throws a <code>NoSuchOrganizationAssignmentException</code> if it could not be found.
	 *
	 * @param organizationAssignmentId the primary key of the organization assignment
	 * @return the organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a organization assignment with the primary key could not be found
	 */
	public OrganizationAssignment findByPrimaryKey(
			long organizationAssignmentId)
		throws NoSuchOrganizationAssignmentException;

	/**
	 * Returns the organization assignment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param organizationAssignmentId the primary key of the organization assignment
	 * @return the organization assignment, or <code>null</code> if a organization assignment with the primary key could not be found
	 */
	public OrganizationAssignment fetchByPrimaryKey(
		long organizationAssignmentId);

	/**
	 * Returns all the organization assignments.
	 *
	 * @return the organization assignments
	 */
	public java.util.List<OrganizationAssignment> findAll();

	/**
	 * Returns a range of all the organization assignments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @return the range of organization assignments
	 */
	public java.util.List<OrganizationAssignment> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the organization assignments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of organization assignments
	 */
	public java.util.List<OrganizationAssignment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationAssignment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the organization assignments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of organization assignments
	 */
	public java.util.List<OrganizationAssignment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationAssignment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the organization assignments from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of organization assignments.
	 *
	 * @return the number of organization assignments
	 */
	public int countAll();

}