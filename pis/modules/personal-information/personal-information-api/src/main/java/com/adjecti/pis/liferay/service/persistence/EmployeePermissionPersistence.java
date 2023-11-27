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

import com.adjecti.pis.liferay.exception.NoSuchEmployeePermissionException;
import com.adjecti.pis.liferay.model.EmployeePermission;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee permission service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeePermissionUtil
 * @generated
 */
@ProviderType
public interface EmployeePermissionPersistence
	extends BasePersistence<EmployeePermission> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeePermissionUtil} to access the employee permission persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the employee permission where employeeId = &#63; or throws a <code>NoSuchEmployeePermissionException</code> if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee permission
	 * @throws NoSuchEmployeePermissionException if a matching employee permission could not be found
	 */
	public EmployeePermission findByEmployeeId(long employeeId)
		throws NoSuchEmployeePermissionException;

	/**
	 * Returns the employee permission where employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee permission, or <code>null</code> if a matching employee permission could not be found
	 */
	public EmployeePermission fetchByEmployeeId(long employeeId);

	/**
	 * Returns the employee permission where employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee permission, or <code>null</code> if a matching employee permission could not be found
	 */
	public EmployeePermission fetchByEmployeeId(
		long employeeId, boolean useFinderCache);

	/**
	 * Removes the employee permission where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @return the employee permission that was removed
	 */
	public EmployeePermission removeByEmployeeId(long employeeId)
		throws NoSuchEmployeePermissionException;

	/**
	 * Returns the number of employee permissions where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee permissions
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Returns all the employee permissions where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the matching employee permissions
	 */
	public java.util.List<EmployeePermission> findByJoiningProcessId(
		long joiningProcessId);

	/**
	 * Returns a range of all the employee permissions where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of employee permissions
	 * @param end the upper bound of the range of employee permissions (not inclusive)
	 * @return the range of matching employee permissions
	 */
	public java.util.List<EmployeePermission> findByJoiningProcessId(
		long joiningProcessId, int start, int end);

	/**
	 * Returns an ordered range of all the employee permissions where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of employee permissions
	 * @param end the upper bound of the range of employee permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee permissions
	 */
	public java.util.List<EmployeePermission> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePermission>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee permissions where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of employee permissions
	 * @param end the upper bound of the range of employee permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee permissions
	 */
	public java.util.List<EmployeePermission> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePermission>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee permission in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee permission
	 * @throws NoSuchEmployeePermissionException if a matching employee permission could not be found
	 */
	public EmployeePermission findByJoiningProcessId_First(
			long joiningProcessId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeePermission>
				orderByComparator)
		throws NoSuchEmployeePermissionException;

	/**
	 * Returns the first employee permission in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee permission, or <code>null</code> if a matching employee permission could not be found
	 */
	public EmployeePermission fetchByJoiningProcessId_First(
		long joiningProcessId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePermission>
			orderByComparator);

	/**
	 * Returns the last employee permission in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee permission
	 * @throws NoSuchEmployeePermissionException if a matching employee permission could not be found
	 */
	public EmployeePermission findByJoiningProcessId_Last(
			long joiningProcessId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeePermission>
				orderByComparator)
		throws NoSuchEmployeePermissionException;

	/**
	 * Returns the last employee permission in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee permission, or <code>null</code> if a matching employee permission could not be found
	 */
	public EmployeePermission fetchByJoiningProcessId_Last(
		long joiningProcessId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePermission>
			orderByComparator);

	/**
	 * Returns the employee permissions before and after the current employee permission in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param employeePermissionId the primary key of the current employee permission
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee permission
	 * @throws NoSuchEmployeePermissionException if a employee permission with the primary key could not be found
	 */
	public EmployeePermission[] findByJoiningProcessId_PrevAndNext(
			long employeePermissionId, long joiningProcessId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeePermission>
				orderByComparator)
		throws NoSuchEmployeePermissionException;

	/**
	 * Removes all the employee permissions where joiningProcessId = &#63; from the database.
	 *
	 * @param joiningProcessId the joining process ID
	 */
	public void removeByJoiningProcessId(long joiningProcessId);

	/**
	 * Returns the number of employee permissions where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the number of matching employee permissions
	 */
	public int countByJoiningProcessId(long joiningProcessId);

	/**
	 * Returns the employee permission where singleUserOnboardingId = &#63; or throws a <code>NoSuchEmployeePermissionException</code> if it could not be found.
	 *
	 * @param singleUserOnboardingId the single user onboarding ID
	 * @return the matching employee permission
	 * @throws NoSuchEmployeePermissionException if a matching employee permission could not be found
	 */
	public EmployeePermission findBySingleUserOnboardingId(
			long singleUserOnboardingId)
		throws NoSuchEmployeePermissionException;

	/**
	 * Returns the employee permission where singleUserOnboardingId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param singleUserOnboardingId the single user onboarding ID
	 * @return the matching employee permission, or <code>null</code> if a matching employee permission could not be found
	 */
	public EmployeePermission fetchBySingleUserOnboardingId(
		long singleUserOnboardingId);

	/**
	 * Returns the employee permission where singleUserOnboardingId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param singleUserOnboardingId the single user onboarding ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee permission, or <code>null</code> if a matching employee permission could not be found
	 */
	public EmployeePermission fetchBySingleUserOnboardingId(
		long singleUserOnboardingId, boolean useFinderCache);

	/**
	 * Removes the employee permission where singleUserOnboardingId = &#63; from the database.
	 *
	 * @param singleUserOnboardingId the single user onboarding ID
	 * @return the employee permission that was removed
	 */
	public EmployeePermission removeBySingleUserOnboardingId(
			long singleUserOnboardingId)
		throws NoSuchEmployeePermissionException;

	/**
	 * Returns the number of employee permissions where singleUserOnboardingId = &#63;.
	 *
	 * @param singleUserOnboardingId the single user onboarding ID
	 * @return the number of matching employee permissions
	 */
	public int countBySingleUserOnboardingId(long singleUserOnboardingId);

	/**
	 * Returns the employee permission where registrationRequestId = &#63; or throws a <code>NoSuchEmployeePermissionException</code> if it could not be found.
	 *
	 * @param registrationRequestId the registration request ID
	 * @return the matching employee permission
	 * @throws NoSuchEmployeePermissionException if a matching employee permission could not be found
	 */
	public EmployeePermission findByRegistrationRequestId(
			long registrationRequestId)
		throws NoSuchEmployeePermissionException;

	/**
	 * Returns the employee permission where registrationRequestId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param registrationRequestId the registration request ID
	 * @return the matching employee permission, or <code>null</code> if a matching employee permission could not be found
	 */
	public EmployeePermission fetchByRegistrationRequestId(
		long registrationRequestId);

	/**
	 * Returns the employee permission where registrationRequestId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param registrationRequestId the registration request ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee permission, or <code>null</code> if a matching employee permission could not be found
	 */
	public EmployeePermission fetchByRegistrationRequestId(
		long registrationRequestId, boolean useFinderCache);

	/**
	 * Removes the employee permission where registrationRequestId = &#63; from the database.
	 *
	 * @param registrationRequestId the registration request ID
	 * @return the employee permission that was removed
	 */
	public EmployeePermission removeByRegistrationRequestId(
			long registrationRequestId)
		throws NoSuchEmployeePermissionException;

	/**
	 * Returns the number of employee permissions where registrationRequestId = &#63;.
	 *
	 * @param registrationRequestId the registration request ID
	 * @return the number of matching employee permissions
	 */
	public int countByRegistrationRequestId(long registrationRequestId);

	/**
	 * Returns all the employee permissions where form = &#63;.
	 *
	 * @param form the form
	 * @return the matching employee permissions
	 */
	public java.util.List<EmployeePermission> findByFormClassName(String form);

	/**
	 * Returns a range of all the employee permissions where form = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param form the form
	 * @param start the lower bound of the range of employee permissions
	 * @param end the upper bound of the range of employee permissions (not inclusive)
	 * @return the range of matching employee permissions
	 */
	public java.util.List<EmployeePermission> findByFormClassName(
		String form, int start, int end);

	/**
	 * Returns an ordered range of all the employee permissions where form = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param form the form
	 * @param start the lower bound of the range of employee permissions
	 * @param end the upper bound of the range of employee permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee permissions
	 */
	public java.util.List<EmployeePermission> findByFormClassName(
		String form, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePermission>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee permissions where form = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param form the form
	 * @param start the lower bound of the range of employee permissions
	 * @param end the upper bound of the range of employee permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee permissions
	 */
	public java.util.List<EmployeePermission> findByFormClassName(
		String form, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePermission>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee permission in the ordered set where form = &#63;.
	 *
	 * @param form the form
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee permission
	 * @throws NoSuchEmployeePermissionException if a matching employee permission could not be found
	 */
	public EmployeePermission findByFormClassName_First(
			String form,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeePermission>
				orderByComparator)
		throws NoSuchEmployeePermissionException;

	/**
	 * Returns the first employee permission in the ordered set where form = &#63;.
	 *
	 * @param form the form
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee permission, or <code>null</code> if a matching employee permission could not be found
	 */
	public EmployeePermission fetchByFormClassName_First(
		String form,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePermission>
			orderByComparator);

	/**
	 * Returns the last employee permission in the ordered set where form = &#63;.
	 *
	 * @param form the form
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee permission
	 * @throws NoSuchEmployeePermissionException if a matching employee permission could not be found
	 */
	public EmployeePermission findByFormClassName_Last(
			String form,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeePermission>
				orderByComparator)
		throws NoSuchEmployeePermissionException;

	/**
	 * Returns the last employee permission in the ordered set where form = &#63;.
	 *
	 * @param form the form
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee permission, or <code>null</code> if a matching employee permission could not be found
	 */
	public EmployeePermission fetchByFormClassName_Last(
		String form,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePermission>
			orderByComparator);

	/**
	 * Returns the employee permissions before and after the current employee permission in the ordered set where form = &#63;.
	 *
	 * @param employeePermissionId the primary key of the current employee permission
	 * @param form the form
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee permission
	 * @throws NoSuchEmployeePermissionException if a employee permission with the primary key could not be found
	 */
	public EmployeePermission[] findByFormClassName_PrevAndNext(
			long employeePermissionId, String form,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeePermission>
				orderByComparator)
		throws NoSuchEmployeePermissionException;

	/**
	 * Removes all the employee permissions where form = &#63; from the database.
	 *
	 * @param form the form
	 */
	public void removeByFormClassName(String form);

	/**
	 * Returns the number of employee permissions where form = &#63;.
	 *
	 * @param form the form
	 * @return the number of matching employee permissions
	 */
	public int countByFormClassName(String form);

	/**
	 * Caches the employee permission in the entity cache if it is enabled.
	 *
	 * @param employeePermission the employee permission
	 */
	public void cacheResult(EmployeePermission employeePermission);

	/**
	 * Caches the employee permissions in the entity cache if it is enabled.
	 *
	 * @param employeePermissions the employee permissions
	 */
	public void cacheResult(
		java.util.List<EmployeePermission> employeePermissions);

	/**
	 * Creates a new employee permission with the primary key. Does not add the employee permission to the database.
	 *
	 * @param employeePermissionId the primary key for the new employee permission
	 * @return the new employee permission
	 */
	public EmployeePermission create(long employeePermissionId);

	/**
	 * Removes the employee permission with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeePermissionId the primary key of the employee permission
	 * @return the employee permission that was removed
	 * @throws NoSuchEmployeePermissionException if a employee permission with the primary key could not be found
	 */
	public EmployeePermission remove(long employeePermissionId)
		throws NoSuchEmployeePermissionException;

	public EmployeePermission updateImpl(EmployeePermission employeePermission);

	/**
	 * Returns the employee permission with the primary key or throws a <code>NoSuchEmployeePermissionException</code> if it could not be found.
	 *
	 * @param employeePermissionId the primary key of the employee permission
	 * @return the employee permission
	 * @throws NoSuchEmployeePermissionException if a employee permission with the primary key could not be found
	 */
	public EmployeePermission findByPrimaryKey(long employeePermissionId)
		throws NoSuchEmployeePermissionException;

	/**
	 * Returns the employee permission with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeePermissionId the primary key of the employee permission
	 * @return the employee permission, or <code>null</code> if a employee permission with the primary key could not be found
	 */
	public EmployeePermission fetchByPrimaryKey(long employeePermissionId);

	/**
	 * Returns all the employee permissions.
	 *
	 * @return the employee permissions
	 */
	public java.util.List<EmployeePermission> findAll();

	/**
	 * Returns a range of all the employee permissions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee permissions
	 * @param end the upper bound of the range of employee permissions (not inclusive)
	 * @return the range of employee permissions
	 */
	public java.util.List<EmployeePermission> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee permissions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee permissions
	 * @param end the upper bound of the range of employee permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee permissions
	 */
	public java.util.List<EmployeePermission> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePermission>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee permissions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee permissions
	 * @param end the upper bound of the range of employee permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee permissions
	 */
	public java.util.List<EmployeePermission> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePermission>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee permissions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee permissions.
	 *
	 * @return the number of employee permissions
	 */
	public int countAll();

}