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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeVerificationException;
import com.adjecti.pis.liferay.model.EmployeeVerification;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee verification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeVerificationUtil
 * @generated
 */
@ProviderType
public interface EmployeeVerificationPersistence
	extends BasePersistence<EmployeeVerification> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeVerificationUtil} to access the employee verification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee verifications where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee verifications
	 */
	public java.util.List<EmployeeVerification> findByEmployeeId(
		long employeeId);

	/**
	 * Returns a range of all the employee verifications where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee verifications
	 * @param end the upper bound of the range of employee verifications (not inclusive)
	 * @return the range of matching employee verifications
	 */
	public java.util.List<EmployeeVerification> findByEmployeeId(
		long employeeId, int start, int end);

	/**
	 * Returns an ordered range of all the employee verifications where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee verifications
	 * @param end the upper bound of the range of employee verifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee verifications
	 */
	public java.util.List<EmployeeVerification> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeVerification>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee verifications where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee verifications
	 * @param end the upper bound of the range of employee verifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee verifications
	 */
	public java.util.List<EmployeeVerification> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeVerification>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee verification in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee verification
	 * @throws NoSuchEmployeeVerificationException if a matching employee verification could not be found
	 */
	public EmployeeVerification findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeVerification> orderByComparator)
		throws NoSuchEmployeeVerificationException;

	/**
	 * Returns the first employee verification in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee verification, or <code>null</code> if a matching employee verification could not be found
	 */
	public EmployeeVerification fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeVerification>
			orderByComparator);

	/**
	 * Returns the last employee verification in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee verification
	 * @throws NoSuchEmployeeVerificationException if a matching employee verification could not be found
	 */
	public EmployeeVerification findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeVerification> orderByComparator)
		throws NoSuchEmployeeVerificationException;

	/**
	 * Returns the last employee verification in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee verification, or <code>null</code> if a matching employee verification could not be found
	 */
	public EmployeeVerification fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeVerification>
			orderByComparator);

	/**
	 * Returns the employee verifications before and after the current employee verification in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeVerificationId the primary key of the current employee verification
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee verification
	 * @throws NoSuchEmployeeVerificationException if a employee verification with the primary key could not be found
	 */
	public EmployeeVerification[] findByEmployeeId_PrevAndNext(
			long employeeVerificationId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeVerification> orderByComparator)
		throws NoSuchEmployeeVerificationException;

	/**
	 * Removes all the employee verifications where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of employee verifications where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee verifications
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Returns all the employee verifications where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the matching employee verifications
	 */
	public java.util.List<EmployeeVerification> findByJoiningProcessId(
		long joiningProcessId);

	/**
	 * Returns a range of all the employee verifications where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of employee verifications
	 * @param end the upper bound of the range of employee verifications (not inclusive)
	 * @return the range of matching employee verifications
	 */
	public java.util.List<EmployeeVerification> findByJoiningProcessId(
		long joiningProcessId, int start, int end);

	/**
	 * Returns an ordered range of all the employee verifications where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of employee verifications
	 * @param end the upper bound of the range of employee verifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee verifications
	 */
	public java.util.List<EmployeeVerification> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeVerification>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee verifications where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of employee verifications
	 * @param end the upper bound of the range of employee verifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee verifications
	 */
	public java.util.List<EmployeeVerification> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeVerification>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee verification in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee verification
	 * @throws NoSuchEmployeeVerificationException if a matching employee verification could not be found
	 */
	public EmployeeVerification findByJoiningProcessId_First(
			long joiningProcessId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeVerification> orderByComparator)
		throws NoSuchEmployeeVerificationException;

	/**
	 * Returns the first employee verification in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee verification, or <code>null</code> if a matching employee verification could not be found
	 */
	public EmployeeVerification fetchByJoiningProcessId_First(
		long joiningProcessId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeVerification>
			orderByComparator);

	/**
	 * Returns the last employee verification in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee verification
	 * @throws NoSuchEmployeeVerificationException if a matching employee verification could not be found
	 */
	public EmployeeVerification findByJoiningProcessId_Last(
			long joiningProcessId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeVerification> orderByComparator)
		throws NoSuchEmployeeVerificationException;

	/**
	 * Returns the last employee verification in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee verification, or <code>null</code> if a matching employee verification could not be found
	 */
	public EmployeeVerification fetchByJoiningProcessId_Last(
		long joiningProcessId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeVerification>
			orderByComparator);

	/**
	 * Returns the employee verifications before and after the current employee verification in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param employeeVerificationId the primary key of the current employee verification
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee verification
	 * @throws NoSuchEmployeeVerificationException if a employee verification with the primary key could not be found
	 */
	public EmployeeVerification[] findByJoiningProcessId_PrevAndNext(
			long employeeVerificationId, long joiningProcessId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeVerification> orderByComparator)
		throws NoSuchEmployeeVerificationException;

	/**
	 * Removes all the employee verifications where joiningProcessId = &#63; from the database.
	 *
	 * @param joiningProcessId the joining process ID
	 */
	public void removeByJoiningProcessId(long joiningProcessId);

	/**
	 * Returns the number of employee verifications where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the number of matching employee verifications
	 */
	public int countByJoiningProcessId(long joiningProcessId);

	/**
	 * Returns all the employee verifications where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching employee verifications
	 */
	public java.util.List<EmployeeVerification> findByOrganizationId(
		long organizationId);

	/**
	 * Returns a range of all the employee verifications where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee verifications
	 * @param end the upper bound of the range of employee verifications (not inclusive)
	 * @return the range of matching employee verifications
	 */
	public java.util.List<EmployeeVerification> findByOrganizationId(
		long organizationId, int start, int end);

	/**
	 * Returns an ordered range of all the employee verifications where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee verifications
	 * @param end the upper bound of the range of employee verifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee verifications
	 */
	public java.util.List<EmployeeVerification> findByOrganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeVerification>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee verifications where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee verifications
	 * @param end the upper bound of the range of employee verifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee verifications
	 */
	public java.util.List<EmployeeVerification> findByOrganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeVerification>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee verification in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee verification
	 * @throws NoSuchEmployeeVerificationException if a matching employee verification could not be found
	 */
	public EmployeeVerification findByOrganizationId_First(
			long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeVerification> orderByComparator)
		throws NoSuchEmployeeVerificationException;

	/**
	 * Returns the first employee verification in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee verification, or <code>null</code> if a matching employee verification could not be found
	 */
	public EmployeeVerification fetchByOrganizationId_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeVerification>
			orderByComparator);

	/**
	 * Returns the last employee verification in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee verification
	 * @throws NoSuchEmployeeVerificationException if a matching employee verification could not be found
	 */
	public EmployeeVerification findByOrganizationId_Last(
			long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeVerification> orderByComparator)
		throws NoSuchEmployeeVerificationException;

	/**
	 * Returns the last employee verification in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee verification, or <code>null</code> if a matching employee verification could not be found
	 */
	public EmployeeVerification fetchByOrganizationId_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeVerification>
			orderByComparator);

	/**
	 * Returns the employee verifications before and after the current employee verification in the ordered set where organizationId = &#63;.
	 *
	 * @param employeeVerificationId the primary key of the current employee verification
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee verification
	 * @throws NoSuchEmployeeVerificationException if a employee verification with the primary key could not be found
	 */
	public EmployeeVerification[] findByOrganizationId_PrevAndNext(
			long employeeVerificationId, long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeVerification> orderByComparator)
		throws NoSuchEmployeeVerificationException;

	/**
	 * Removes all the employee verifications where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	public void removeByOrganizationId(long organizationId);

	/**
	 * Returns the number of employee verifications where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching employee verifications
	 */
	public int countByOrganizationId(long organizationId);

	/**
	 * Caches the employee verification in the entity cache if it is enabled.
	 *
	 * @param employeeVerification the employee verification
	 */
	public void cacheResult(EmployeeVerification employeeVerification);

	/**
	 * Caches the employee verifications in the entity cache if it is enabled.
	 *
	 * @param employeeVerifications the employee verifications
	 */
	public void cacheResult(
		java.util.List<EmployeeVerification> employeeVerifications);

	/**
	 * Creates a new employee verification with the primary key. Does not add the employee verification to the database.
	 *
	 * @param employeeVerificationId the primary key for the new employee verification
	 * @return the new employee verification
	 */
	public EmployeeVerification create(long employeeVerificationId);

	/**
	 * Removes the employee verification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeVerificationId the primary key of the employee verification
	 * @return the employee verification that was removed
	 * @throws NoSuchEmployeeVerificationException if a employee verification with the primary key could not be found
	 */
	public EmployeeVerification remove(long employeeVerificationId)
		throws NoSuchEmployeeVerificationException;

	public EmployeeVerification updateImpl(
		EmployeeVerification employeeVerification);

	/**
	 * Returns the employee verification with the primary key or throws a <code>NoSuchEmployeeVerificationException</code> if it could not be found.
	 *
	 * @param employeeVerificationId the primary key of the employee verification
	 * @return the employee verification
	 * @throws NoSuchEmployeeVerificationException if a employee verification with the primary key could not be found
	 */
	public EmployeeVerification findByPrimaryKey(long employeeVerificationId)
		throws NoSuchEmployeeVerificationException;

	/**
	 * Returns the employee verification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeVerificationId the primary key of the employee verification
	 * @return the employee verification, or <code>null</code> if a employee verification with the primary key could not be found
	 */
	public EmployeeVerification fetchByPrimaryKey(long employeeVerificationId);

	/**
	 * Returns all the employee verifications.
	 *
	 * @return the employee verifications
	 */
	public java.util.List<EmployeeVerification> findAll();

	/**
	 * Returns a range of all the employee verifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee verifications
	 * @param end the upper bound of the range of employee verifications (not inclusive)
	 * @return the range of employee verifications
	 */
	public java.util.List<EmployeeVerification> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee verifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee verifications
	 * @param end the upper bound of the range of employee verifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee verifications
	 */
	public java.util.List<EmployeeVerification> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeVerification>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee verifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee verifications
	 * @param end the upper bound of the range of employee verifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee verifications
	 */
	public java.util.List<EmployeeVerification> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeVerification>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee verifications from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee verifications.
	 *
	 * @return the number of employee verifications
	 */
	public int countAll();

}