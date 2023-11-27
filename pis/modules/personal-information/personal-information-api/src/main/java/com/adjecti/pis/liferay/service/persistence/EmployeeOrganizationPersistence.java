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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeOrganizationException;
import com.adjecti.pis.liferay.model.EmployeeOrganization;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee organization service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeOrganizationUtil
 * @generated
 */
@ProviderType
public interface EmployeeOrganizationPersistence
	extends BasePersistence<EmployeeOrganization> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeOrganizationUtil} to access the employee organization persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee organizations where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee organizations
	 */
	public java.util.List<EmployeeOrganization> findByEmployeeId(
		long employeeId);

	/**
	 * Returns a range of all the employee organizations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @return the range of matching employee organizations
	 */
	public java.util.List<EmployeeOrganization> findByEmployeeId(
		long employeeId, int start, int end);

	/**
	 * Returns an ordered range of all the employee organizations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee organizations
	 */
	public java.util.List<EmployeeOrganization> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeOrganization>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee organizations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee organizations
	 */
	public java.util.List<EmployeeOrganization> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeOrganization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee organization in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	public EmployeeOrganization findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException;

	/**
	 * Returns the first employee organization in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	public EmployeeOrganization fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeOrganization>
			orderByComparator);

	/**
	 * Returns the last employee organization in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	public EmployeeOrganization findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException;

	/**
	 * Returns the last employee organization in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	public EmployeeOrganization fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeOrganization>
			orderByComparator);

	/**
	 * Returns the employee organizations before and after the current employee organization in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeOrganizationId the primary key of the current employee organization
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee organization
	 * @throws NoSuchEmployeeOrganizationException if a employee organization with the primary key could not be found
	 */
	public EmployeeOrganization[] findByEmployeeId_PrevAndNext(
			long employeeOrganizationId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException;

	/**
	 * Removes all the employee organizations where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of employee organizations where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee organizations
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Returns all the employee organizations where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @return the matching employee organizations
	 */
	public java.util.List<EmployeeOrganization> findByPersonalNo(
		String personalNo);

	/**
	 * Returns a range of all the employee organizations where personalNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param personalNo the personal no
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @return the range of matching employee organizations
	 */
	public java.util.List<EmployeeOrganization> findByPersonalNo(
		String personalNo, int start, int end);

	/**
	 * Returns an ordered range of all the employee organizations where personalNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param personalNo the personal no
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee organizations
	 */
	public java.util.List<EmployeeOrganization> findByPersonalNo(
		String personalNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeOrganization>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee organizations where personalNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param personalNo the personal no
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee organizations
	 */
	public java.util.List<EmployeeOrganization> findByPersonalNo(
		String personalNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeOrganization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee organization in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	public EmployeeOrganization findByPersonalNo_First(
			String personalNo,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException;

	/**
	 * Returns the first employee organization in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	public EmployeeOrganization fetchByPersonalNo_First(
		String personalNo,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeOrganization>
			orderByComparator);

	/**
	 * Returns the last employee organization in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	public EmployeeOrganization findByPersonalNo_Last(
			String personalNo,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException;

	/**
	 * Returns the last employee organization in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	public EmployeeOrganization fetchByPersonalNo_Last(
		String personalNo,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeOrganization>
			orderByComparator);

	/**
	 * Returns the employee organizations before and after the current employee organization in the ordered set where personalNo = &#63;.
	 *
	 * @param employeeOrganizationId the primary key of the current employee organization
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee organization
	 * @throws NoSuchEmployeeOrganizationException if a employee organization with the primary key could not be found
	 */
	public EmployeeOrganization[] findByPersonalNo_PrevAndNext(
			long employeeOrganizationId, String personalNo,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException;

	/**
	 * Removes all the employee organizations where personalNo = &#63; from the database.
	 *
	 * @param personalNo the personal no
	 */
	public void removeByPersonalNo(String personalNo);

	/**
	 * Returns the number of employee organizations where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @return the number of matching employee organizations
	 */
	public int countByPersonalNo(String personalNo);

	/**
	 * Returns all the employee organizations where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching employee organizations
	 */
	public java.util.List<EmployeeOrganization> findByOrganizationId(
		long organizationId);

	/**
	 * Returns a range of all the employee organizations where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @return the range of matching employee organizations
	 */
	public java.util.List<EmployeeOrganization> findByOrganizationId(
		long organizationId, int start, int end);

	/**
	 * Returns an ordered range of all the employee organizations where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee organizations
	 */
	public java.util.List<EmployeeOrganization> findByOrganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeOrganization>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee organizations where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee organizations
	 */
	public java.util.List<EmployeeOrganization> findByOrganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeOrganization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee organization in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	public EmployeeOrganization findByOrganizationId_First(
			long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException;

	/**
	 * Returns the first employee organization in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	public EmployeeOrganization fetchByOrganizationId_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeOrganization>
			orderByComparator);

	/**
	 * Returns the last employee organization in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	public EmployeeOrganization findByOrganizationId_Last(
			long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException;

	/**
	 * Returns the last employee organization in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	public EmployeeOrganization fetchByOrganizationId_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeOrganization>
			orderByComparator);

	/**
	 * Returns the employee organizations before and after the current employee organization in the ordered set where organizationId = &#63;.
	 *
	 * @param employeeOrganizationId the primary key of the current employee organization
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee organization
	 * @throws NoSuchEmployeeOrganizationException if a employee organization with the primary key could not be found
	 */
	public EmployeeOrganization[] findByOrganizationId_PrevAndNext(
			long employeeOrganizationId, long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException;

	/**
	 * Removes all the employee organizations where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	public void removeByOrganizationId(long organizationId);

	/**
	 * Returns the number of employee organizations where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching employee organizations
	 */
	public int countByOrganizationId(long organizationId);

	/**
	 * Returns all the employee organizations where employeeId = &#63; and organizationId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param organizationId the organization ID
	 * @return the matching employee organizations
	 */
	public java.util.List<EmployeeOrganization>
		findByEmployeeIdAndOrganizationId(long employeeId, long organizationId);

	/**
	 * Returns a range of all the employee organizations where employeeId = &#63; and organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @return the range of matching employee organizations
	 */
	public java.util.List<EmployeeOrganization>
		findByEmployeeIdAndOrganizationId(
			long employeeId, long organizationId, int start, int end);

	/**
	 * Returns an ordered range of all the employee organizations where employeeId = &#63; and organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee organizations
	 */
	public java.util.List<EmployeeOrganization>
		findByEmployeeIdAndOrganizationId(
			long employeeId, long organizationId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeOrganization> orderByComparator);

	/**
	 * Returns an ordered range of all the employee organizations where employeeId = &#63; and organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee organizations
	 */
	public java.util.List<EmployeeOrganization>
		findByEmployeeIdAndOrganizationId(
			long employeeId, long organizationId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeOrganization> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first employee organization in the ordered set where employeeId = &#63; and organizationId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	public EmployeeOrganization findByEmployeeIdAndOrganizationId_First(
			long employeeId, long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException;

	/**
	 * Returns the first employee organization in the ordered set where employeeId = &#63; and organizationId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	public EmployeeOrganization fetchByEmployeeIdAndOrganizationId_First(
		long employeeId, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeOrganization>
			orderByComparator);

	/**
	 * Returns the last employee organization in the ordered set where employeeId = &#63; and organizationId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	public EmployeeOrganization findByEmployeeIdAndOrganizationId_Last(
			long employeeId, long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException;

	/**
	 * Returns the last employee organization in the ordered set where employeeId = &#63; and organizationId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	public EmployeeOrganization fetchByEmployeeIdAndOrganizationId_Last(
		long employeeId, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeOrganization>
			orderByComparator);

	/**
	 * Returns the employee organizations before and after the current employee organization in the ordered set where employeeId = &#63; and organizationId = &#63;.
	 *
	 * @param employeeOrganizationId the primary key of the current employee organization
	 * @param employeeId the employee ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee organization
	 * @throws NoSuchEmployeeOrganizationException if a employee organization with the primary key could not be found
	 */
	public EmployeeOrganization[] findByEmployeeIdAndOrganizationId_PrevAndNext(
			long employeeOrganizationId, long employeeId, long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException;

	/**
	 * Removes all the employee organizations where employeeId = &#63; and organizationId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param organizationId the organization ID
	 */
	public void removeByEmployeeIdAndOrganizationId(
		long employeeId, long organizationId);

	/**
	 * Returns the number of employee organizations where employeeId = &#63; and organizationId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param organizationId the organization ID
	 * @return the number of matching employee organizations
	 */
	public int countByEmployeeIdAndOrganizationId(
		long employeeId, long organizationId);

	/**
	 * Returns all the employee organizations where employeeId = &#63; and subOrganizationId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param subOrganizationId the sub organization ID
	 * @return the matching employee organizations
	 */
	public java.util.List<EmployeeOrganization>
		findByEmployeeIdAndSubOrganizationId(
			long employeeId, long subOrganizationId);

	/**
	 * Returns a range of all the employee organizations where employeeId = &#63; and subOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param subOrganizationId the sub organization ID
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @return the range of matching employee organizations
	 */
	public java.util.List<EmployeeOrganization>
		findByEmployeeIdAndSubOrganizationId(
			long employeeId, long subOrganizationId, int start, int end);

	/**
	 * Returns an ordered range of all the employee organizations where employeeId = &#63; and subOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param subOrganizationId the sub organization ID
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee organizations
	 */
	public java.util.List<EmployeeOrganization>
		findByEmployeeIdAndSubOrganizationId(
			long employeeId, long subOrganizationId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeOrganization> orderByComparator);

	/**
	 * Returns an ordered range of all the employee organizations where employeeId = &#63; and subOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param subOrganizationId the sub organization ID
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee organizations
	 */
	public java.util.List<EmployeeOrganization>
		findByEmployeeIdAndSubOrganizationId(
			long employeeId, long subOrganizationId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeOrganization> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first employee organization in the ordered set where employeeId = &#63; and subOrganizationId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	public EmployeeOrganization findByEmployeeIdAndSubOrganizationId_First(
			long employeeId, long subOrganizationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException;

	/**
	 * Returns the first employee organization in the ordered set where employeeId = &#63; and subOrganizationId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	public EmployeeOrganization fetchByEmployeeIdAndSubOrganizationId_First(
		long employeeId, long subOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeOrganization>
			orderByComparator);

	/**
	 * Returns the last employee organization in the ordered set where employeeId = &#63; and subOrganizationId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	public EmployeeOrganization findByEmployeeIdAndSubOrganizationId_Last(
			long employeeId, long subOrganizationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException;

	/**
	 * Returns the last employee organization in the ordered set where employeeId = &#63; and subOrganizationId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	public EmployeeOrganization fetchByEmployeeIdAndSubOrganizationId_Last(
		long employeeId, long subOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeOrganization>
			orderByComparator);

	/**
	 * Returns the employee organizations before and after the current employee organization in the ordered set where employeeId = &#63; and subOrganizationId = &#63;.
	 *
	 * @param employeeOrganizationId the primary key of the current employee organization
	 * @param employeeId the employee ID
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee organization
	 * @throws NoSuchEmployeeOrganizationException if a employee organization with the primary key could not be found
	 */
	public EmployeeOrganization[]
			findByEmployeeIdAndSubOrganizationId_PrevAndNext(
				long employeeOrganizationId, long employeeId,
				long subOrganizationId,
				com.liferay.portal.kernel.util.OrderByComparator
					<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException;

	/**
	 * Removes all the employee organizations where employeeId = &#63; and subOrganizationId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param subOrganizationId the sub organization ID
	 */
	public void removeByEmployeeIdAndSubOrganizationId(
		long employeeId, long subOrganizationId);

	/**
	 * Returns the number of employee organizations where employeeId = &#63; and subOrganizationId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param subOrganizationId the sub organization ID
	 * @return the number of matching employee organizations
	 */
	public int countByEmployeeIdAndSubOrganizationId(
		long employeeId, long subOrganizationId);

	/**
	 * Returns all the employee organizations where subOrganizationId = &#63; and active = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param active the active
	 * @return the matching employee organizations
	 */
	public java.util.List<EmployeeOrganization>
		findBySubOrganizationIdAndActive(
			long subOrganizationId, boolean active);

	/**
	 * Returns a range of all the employee organizations where subOrganizationId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param active the active
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @return the range of matching employee organizations
	 */
	public java.util.List<EmployeeOrganization>
		findBySubOrganizationIdAndActive(
			long subOrganizationId, boolean active, int start, int end);

	/**
	 * Returns an ordered range of all the employee organizations where subOrganizationId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param active the active
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee organizations
	 */
	public java.util.List<EmployeeOrganization>
		findBySubOrganizationIdAndActive(
			long subOrganizationId, boolean active, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeOrganization> orderByComparator);

	/**
	 * Returns an ordered range of all the employee organizations where subOrganizationId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param active the active
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee organizations
	 */
	public java.util.List<EmployeeOrganization>
		findBySubOrganizationIdAndActive(
			long subOrganizationId, boolean active, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeOrganization> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first employee organization in the ordered set where subOrganizationId = &#63; and active = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	public EmployeeOrganization findBySubOrganizationIdAndActive_First(
			long subOrganizationId, boolean active,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException;

	/**
	 * Returns the first employee organization in the ordered set where subOrganizationId = &#63; and active = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	public EmployeeOrganization fetchBySubOrganizationIdAndActive_First(
		long subOrganizationId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeOrganization>
			orderByComparator);

	/**
	 * Returns the last employee organization in the ordered set where subOrganizationId = &#63; and active = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	public EmployeeOrganization findBySubOrganizationIdAndActive_Last(
			long subOrganizationId, boolean active,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException;

	/**
	 * Returns the last employee organization in the ordered set where subOrganizationId = &#63; and active = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	public EmployeeOrganization fetchBySubOrganizationIdAndActive_Last(
		long subOrganizationId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeOrganization>
			orderByComparator);

	/**
	 * Returns the employee organizations before and after the current employee organization in the ordered set where subOrganizationId = &#63; and active = &#63;.
	 *
	 * @param employeeOrganizationId the primary key of the current employee organization
	 * @param subOrganizationId the sub organization ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee organization
	 * @throws NoSuchEmployeeOrganizationException if a employee organization with the primary key could not be found
	 */
	public EmployeeOrganization[] findBySubOrganizationIdAndActive_PrevAndNext(
			long employeeOrganizationId, long subOrganizationId, boolean active,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException;

	/**
	 * Removes all the employee organizations where subOrganizationId = &#63; and active = &#63; from the database.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param active the active
	 */
	public void removeBySubOrganizationIdAndActive(
		long subOrganizationId, boolean active);

	/**
	 * Returns the number of employee organizations where subOrganizationId = &#63; and active = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param active the active
	 * @return the number of matching employee organizations
	 */
	public int countBySubOrganizationIdAndActive(
		long subOrganizationId, boolean active);

	/**
	 * Returns all the employee organizations where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @return the matching employee organizations
	 */
	public java.util.List<EmployeeOrganization> findByOrganizationCode(
		String organizationCode);

	/**
	 * Returns a range of all the employee organizations where organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @return the range of matching employee organizations
	 */
	public java.util.List<EmployeeOrganization> findByOrganizationCode(
		String organizationCode, int start, int end);

	/**
	 * Returns an ordered range of all the employee organizations where organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee organizations
	 */
	public java.util.List<EmployeeOrganization> findByOrganizationCode(
		String organizationCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeOrganization>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee organizations where organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee organizations
	 */
	public java.util.List<EmployeeOrganization> findByOrganizationCode(
		String organizationCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeOrganization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee organization in the ordered set where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	public EmployeeOrganization findByOrganizationCode_First(
			String organizationCode,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException;

	/**
	 * Returns the first employee organization in the ordered set where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	public EmployeeOrganization fetchByOrganizationCode_First(
		String organizationCode,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeOrganization>
			orderByComparator);

	/**
	 * Returns the last employee organization in the ordered set where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	public EmployeeOrganization findByOrganizationCode_Last(
			String organizationCode,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException;

	/**
	 * Returns the last employee organization in the ordered set where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	public EmployeeOrganization fetchByOrganizationCode_Last(
		String organizationCode,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeOrganization>
			orderByComparator);

	/**
	 * Returns the employee organizations before and after the current employee organization in the ordered set where organizationCode = &#63;.
	 *
	 * @param employeeOrganizationId the primary key of the current employee organization
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee organization
	 * @throws NoSuchEmployeeOrganizationException if a employee organization with the primary key could not be found
	 */
	public EmployeeOrganization[] findByOrganizationCode_PrevAndNext(
			long employeeOrganizationId, String organizationCode,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException;

	/**
	 * Removes all the employee organizations where organizationCode = &#63; from the database.
	 *
	 * @param organizationCode the organization code
	 */
	public void removeByOrganizationCode(String organizationCode);

	/**
	 * Returns the number of employee organizations where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @return the number of matching employee organizations
	 */
	public int countByOrganizationCode(String organizationCode);

	/**
	 * Returns all the employee organizations where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @return the matching employee organizations
	 */
	public java.util.List<EmployeeOrganization> findBySubOrganizationId(
		long subOrganizationId);

	/**
	 * Returns a range of all the employee organizations where subOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @return the range of matching employee organizations
	 */
	public java.util.List<EmployeeOrganization> findBySubOrganizationId(
		long subOrganizationId, int start, int end);

	/**
	 * Returns an ordered range of all the employee organizations where subOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee organizations
	 */
	public java.util.List<EmployeeOrganization> findBySubOrganizationId(
		long subOrganizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeOrganization>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee organizations where subOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee organizations
	 */
	public java.util.List<EmployeeOrganization> findBySubOrganizationId(
		long subOrganizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeOrganization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee organization in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	public EmployeeOrganization findBySubOrganizationId_First(
			long subOrganizationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException;

	/**
	 * Returns the first employee organization in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	public EmployeeOrganization fetchBySubOrganizationId_First(
		long subOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeOrganization>
			orderByComparator);

	/**
	 * Returns the last employee organization in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	public EmployeeOrganization findBySubOrganizationId_Last(
			long subOrganizationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException;

	/**
	 * Returns the last employee organization in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	public EmployeeOrganization fetchBySubOrganizationId_Last(
		long subOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeOrganization>
			orderByComparator);

	/**
	 * Returns the employee organizations before and after the current employee organization in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param employeeOrganizationId the primary key of the current employee organization
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee organization
	 * @throws NoSuchEmployeeOrganizationException if a employee organization with the primary key could not be found
	 */
	public EmployeeOrganization[] findBySubOrganizationId_PrevAndNext(
			long employeeOrganizationId, long subOrganizationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException;

	/**
	 * Removes all the employee organizations where subOrganizationId = &#63; from the database.
	 *
	 * @param subOrganizationId the sub organization ID
	 */
	public void removeBySubOrganizationId(long subOrganizationId);

	/**
	 * Returns the number of employee organizations where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @return the number of matching employee organizations
	 */
	public int countBySubOrganizationId(long subOrganizationId);

	/**
	 * Returns all the employee organizations where subOrganizationCode = &#63;.
	 *
	 * @param subOrganizationCode the sub organization code
	 * @return the matching employee organizations
	 */
	public java.util.List<EmployeeOrganization> findBySubOrganizationCode(
		String subOrganizationCode);

	/**
	 * Returns a range of all the employee organizations where subOrganizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param subOrganizationCode the sub organization code
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @return the range of matching employee organizations
	 */
	public java.util.List<EmployeeOrganization> findBySubOrganizationCode(
		String subOrganizationCode, int start, int end);

	/**
	 * Returns an ordered range of all the employee organizations where subOrganizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param subOrganizationCode the sub organization code
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee organizations
	 */
	public java.util.List<EmployeeOrganization> findBySubOrganizationCode(
		String subOrganizationCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeOrganization>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee organizations where subOrganizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param subOrganizationCode the sub organization code
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee organizations
	 */
	public java.util.List<EmployeeOrganization> findBySubOrganizationCode(
		String subOrganizationCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeOrganization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee organization in the ordered set where subOrganizationCode = &#63;.
	 *
	 * @param subOrganizationCode the sub organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	public EmployeeOrganization findBySubOrganizationCode_First(
			String subOrganizationCode,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException;

	/**
	 * Returns the first employee organization in the ordered set where subOrganizationCode = &#63;.
	 *
	 * @param subOrganizationCode the sub organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	public EmployeeOrganization fetchBySubOrganizationCode_First(
		String subOrganizationCode,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeOrganization>
			orderByComparator);

	/**
	 * Returns the last employee organization in the ordered set where subOrganizationCode = &#63;.
	 *
	 * @param subOrganizationCode the sub organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	public EmployeeOrganization findBySubOrganizationCode_Last(
			String subOrganizationCode,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException;

	/**
	 * Returns the last employee organization in the ordered set where subOrganizationCode = &#63;.
	 *
	 * @param subOrganizationCode the sub organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	public EmployeeOrganization fetchBySubOrganizationCode_Last(
		String subOrganizationCode,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeOrganization>
			orderByComparator);

	/**
	 * Returns the employee organizations before and after the current employee organization in the ordered set where subOrganizationCode = &#63;.
	 *
	 * @param employeeOrganizationId the primary key of the current employee organization
	 * @param subOrganizationCode the sub organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee organization
	 * @throws NoSuchEmployeeOrganizationException if a employee organization with the primary key could not be found
	 */
	public EmployeeOrganization[] findBySubOrganizationCode_PrevAndNext(
			long employeeOrganizationId, String subOrganizationCode,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeOrganization> orderByComparator)
		throws NoSuchEmployeeOrganizationException;

	/**
	 * Removes all the employee organizations where subOrganizationCode = &#63; from the database.
	 *
	 * @param subOrganizationCode the sub organization code
	 */
	public void removeBySubOrganizationCode(String subOrganizationCode);

	/**
	 * Returns the number of employee organizations where subOrganizationCode = &#63;.
	 *
	 * @param subOrganizationCode the sub organization code
	 * @return the number of matching employee organizations
	 */
	public int countBySubOrganizationCode(String subOrganizationCode);

	/**
	 * Caches the employee organization in the entity cache if it is enabled.
	 *
	 * @param employeeOrganization the employee organization
	 */
	public void cacheResult(EmployeeOrganization employeeOrganization);

	/**
	 * Caches the employee organizations in the entity cache if it is enabled.
	 *
	 * @param employeeOrganizations the employee organizations
	 */
	public void cacheResult(
		java.util.List<EmployeeOrganization> employeeOrganizations);

	/**
	 * Creates a new employee organization with the primary key. Does not add the employee organization to the database.
	 *
	 * @param employeeOrganizationId the primary key for the new employee organization
	 * @return the new employee organization
	 */
	public EmployeeOrganization create(long employeeOrganizationId);

	/**
	 * Removes the employee organization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeOrganizationId the primary key of the employee organization
	 * @return the employee organization that was removed
	 * @throws NoSuchEmployeeOrganizationException if a employee organization with the primary key could not be found
	 */
	public EmployeeOrganization remove(long employeeOrganizationId)
		throws NoSuchEmployeeOrganizationException;

	public EmployeeOrganization updateImpl(
		EmployeeOrganization employeeOrganization);

	/**
	 * Returns the employee organization with the primary key or throws a <code>NoSuchEmployeeOrganizationException</code> if it could not be found.
	 *
	 * @param employeeOrganizationId the primary key of the employee organization
	 * @return the employee organization
	 * @throws NoSuchEmployeeOrganizationException if a employee organization with the primary key could not be found
	 */
	public EmployeeOrganization findByPrimaryKey(long employeeOrganizationId)
		throws NoSuchEmployeeOrganizationException;

	/**
	 * Returns the employee organization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeOrganizationId the primary key of the employee organization
	 * @return the employee organization, or <code>null</code> if a employee organization with the primary key could not be found
	 */
	public EmployeeOrganization fetchByPrimaryKey(long employeeOrganizationId);

	/**
	 * Returns all the employee organizations.
	 *
	 * @return the employee organizations
	 */
	public java.util.List<EmployeeOrganization> findAll();

	/**
	 * Returns a range of all the employee organizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @return the range of employee organizations
	 */
	public java.util.List<EmployeeOrganization> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee organizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee organizations
	 */
	public java.util.List<EmployeeOrganization> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeOrganization>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee organizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee organizations
	 */
	public java.util.List<EmployeeOrganization> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeOrganization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee organizations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee organizations.
	 *
	 * @return the number of employee organizations
	 */
	public int countAll();

}