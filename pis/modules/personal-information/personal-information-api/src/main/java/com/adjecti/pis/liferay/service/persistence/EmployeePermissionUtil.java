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

import com.adjecti.pis.liferay.model.EmployeePermission;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the employee permission service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.EmployeePermissionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeePermissionPersistence
 * @generated
 */
public class EmployeePermissionUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(EmployeePermission employeePermission) {
		getPersistence().clearCache(employeePermission);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, EmployeePermission> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeePermission> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeePermission> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeePermission> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeePermission> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeePermission update(
		EmployeePermission employeePermission) {

		return getPersistence().update(employeePermission);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeePermission update(
		EmployeePermission employeePermission, ServiceContext serviceContext) {

		return getPersistence().update(employeePermission, serviceContext);
	}

	/**
	 * Returns the employee permission where employeeId = &#63; or throws a <code>NoSuchEmployeePermissionException</code> if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee permission
	 * @throws NoSuchEmployeePermissionException if a matching employee permission could not be found
	 */
	public static EmployeePermission findByEmployeeId(long employeeId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePermissionException {

		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns the employee permission where employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee permission, or <code>null</code> if a matching employee permission could not be found
	 */
	public static EmployeePermission fetchByEmployeeId(long employeeId) {
		return getPersistence().fetchByEmployeeId(employeeId);
	}

	/**
	 * Returns the employee permission where employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee permission, or <code>null</code> if a matching employee permission could not be found
	 */
	public static EmployeePermission fetchByEmployeeId(
		long employeeId, boolean useFinderCache) {

		return getPersistence().fetchByEmployeeId(employeeId, useFinderCache);
	}

	/**
	 * Removes the employee permission where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @return the employee permission that was removed
	 */
	public static EmployeePermission removeByEmployeeId(long employeeId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePermissionException {

		return getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of employee permissions where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee permissions
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Returns all the employee permissions where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the matching employee permissions
	 */
	public static List<EmployeePermission> findByJoiningProcessId(
		long joiningProcessId) {

		return getPersistence().findByJoiningProcessId(joiningProcessId);
	}

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
	public static List<EmployeePermission> findByJoiningProcessId(
		long joiningProcessId, int start, int end) {

		return getPersistence().findByJoiningProcessId(
			joiningProcessId, start, end);
	}

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
	public static List<EmployeePermission> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		OrderByComparator<EmployeePermission> orderByComparator) {

		return getPersistence().findByJoiningProcessId(
			joiningProcessId, start, end, orderByComparator);
	}

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
	public static List<EmployeePermission> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		OrderByComparator<EmployeePermission> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByJoiningProcessId(
			joiningProcessId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee permission in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee permission
	 * @throws NoSuchEmployeePermissionException if a matching employee permission could not be found
	 */
	public static EmployeePermission findByJoiningProcessId_First(
			long joiningProcessId,
			OrderByComparator<EmployeePermission> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePermissionException {

		return getPersistence().findByJoiningProcessId_First(
			joiningProcessId, orderByComparator);
	}

	/**
	 * Returns the first employee permission in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee permission, or <code>null</code> if a matching employee permission could not be found
	 */
	public static EmployeePermission fetchByJoiningProcessId_First(
		long joiningProcessId,
		OrderByComparator<EmployeePermission> orderByComparator) {

		return getPersistence().fetchByJoiningProcessId_First(
			joiningProcessId, orderByComparator);
	}

	/**
	 * Returns the last employee permission in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee permission
	 * @throws NoSuchEmployeePermissionException if a matching employee permission could not be found
	 */
	public static EmployeePermission findByJoiningProcessId_Last(
			long joiningProcessId,
			OrderByComparator<EmployeePermission> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePermissionException {

		return getPersistence().findByJoiningProcessId_Last(
			joiningProcessId, orderByComparator);
	}

	/**
	 * Returns the last employee permission in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee permission, or <code>null</code> if a matching employee permission could not be found
	 */
	public static EmployeePermission fetchByJoiningProcessId_Last(
		long joiningProcessId,
		OrderByComparator<EmployeePermission> orderByComparator) {

		return getPersistence().fetchByJoiningProcessId_Last(
			joiningProcessId, orderByComparator);
	}

	/**
	 * Returns the employee permissions before and after the current employee permission in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param employeePermissionId the primary key of the current employee permission
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee permission
	 * @throws NoSuchEmployeePermissionException if a employee permission with the primary key could not be found
	 */
	public static EmployeePermission[] findByJoiningProcessId_PrevAndNext(
			long employeePermissionId, long joiningProcessId,
			OrderByComparator<EmployeePermission> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePermissionException {

		return getPersistence().findByJoiningProcessId_PrevAndNext(
			employeePermissionId, joiningProcessId, orderByComparator);
	}

	/**
	 * Removes all the employee permissions where joiningProcessId = &#63; from the database.
	 *
	 * @param joiningProcessId the joining process ID
	 */
	public static void removeByJoiningProcessId(long joiningProcessId) {
		getPersistence().removeByJoiningProcessId(joiningProcessId);
	}

	/**
	 * Returns the number of employee permissions where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the number of matching employee permissions
	 */
	public static int countByJoiningProcessId(long joiningProcessId) {
		return getPersistence().countByJoiningProcessId(joiningProcessId);
	}

	/**
	 * Returns the employee permission where singleUserOnboardingId = &#63; or throws a <code>NoSuchEmployeePermissionException</code> if it could not be found.
	 *
	 * @param singleUserOnboardingId the single user onboarding ID
	 * @return the matching employee permission
	 * @throws NoSuchEmployeePermissionException if a matching employee permission could not be found
	 */
	public static EmployeePermission findBySingleUserOnboardingId(
			long singleUserOnboardingId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePermissionException {

		return getPersistence().findBySingleUserOnboardingId(
			singleUserOnboardingId);
	}

	/**
	 * Returns the employee permission where singleUserOnboardingId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param singleUserOnboardingId the single user onboarding ID
	 * @return the matching employee permission, or <code>null</code> if a matching employee permission could not be found
	 */
	public static EmployeePermission fetchBySingleUserOnboardingId(
		long singleUserOnboardingId) {

		return getPersistence().fetchBySingleUserOnboardingId(
			singleUserOnboardingId);
	}

	/**
	 * Returns the employee permission where singleUserOnboardingId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param singleUserOnboardingId the single user onboarding ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee permission, or <code>null</code> if a matching employee permission could not be found
	 */
	public static EmployeePermission fetchBySingleUserOnboardingId(
		long singleUserOnboardingId, boolean useFinderCache) {

		return getPersistence().fetchBySingleUserOnboardingId(
			singleUserOnboardingId, useFinderCache);
	}

	/**
	 * Removes the employee permission where singleUserOnboardingId = &#63; from the database.
	 *
	 * @param singleUserOnboardingId the single user onboarding ID
	 * @return the employee permission that was removed
	 */
	public static EmployeePermission removeBySingleUserOnboardingId(
			long singleUserOnboardingId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePermissionException {

		return getPersistence().removeBySingleUserOnboardingId(
			singleUserOnboardingId);
	}

	/**
	 * Returns the number of employee permissions where singleUserOnboardingId = &#63;.
	 *
	 * @param singleUserOnboardingId the single user onboarding ID
	 * @return the number of matching employee permissions
	 */
	public static int countBySingleUserOnboardingId(
		long singleUserOnboardingId) {

		return getPersistence().countBySingleUserOnboardingId(
			singleUserOnboardingId);
	}

	/**
	 * Returns the employee permission where registrationRequestId = &#63; or throws a <code>NoSuchEmployeePermissionException</code> if it could not be found.
	 *
	 * @param registrationRequestId the registration request ID
	 * @return the matching employee permission
	 * @throws NoSuchEmployeePermissionException if a matching employee permission could not be found
	 */
	public static EmployeePermission findByRegistrationRequestId(
			long registrationRequestId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePermissionException {

		return getPersistence().findByRegistrationRequestId(
			registrationRequestId);
	}

	/**
	 * Returns the employee permission where registrationRequestId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param registrationRequestId the registration request ID
	 * @return the matching employee permission, or <code>null</code> if a matching employee permission could not be found
	 */
	public static EmployeePermission fetchByRegistrationRequestId(
		long registrationRequestId) {

		return getPersistence().fetchByRegistrationRequestId(
			registrationRequestId);
	}

	/**
	 * Returns the employee permission where registrationRequestId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param registrationRequestId the registration request ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee permission, or <code>null</code> if a matching employee permission could not be found
	 */
	public static EmployeePermission fetchByRegistrationRequestId(
		long registrationRequestId, boolean useFinderCache) {

		return getPersistence().fetchByRegistrationRequestId(
			registrationRequestId, useFinderCache);
	}

	/**
	 * Removes the employee permission where registrationRequestId = &#63; from the database.
	 *
	 * @param registrationRequestId the registration request ID
	 * @return the employee permission that was removed
	 */
	public static EmployeePermission removeByRegistrationRequestId(
			long registrationRequestId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePermissionException {

		return getPersistence().removeByRegistrationRequestId(
			registrationRequestId);
	}

	/**
	 * Returns the number of employee permissions where registrationRequestId = &#63;.
	 *
	 * @param registrationRequestId the registration request ID
	 * @return the number of matching employee permissions
	 */
	public static int countByRegistrationRequestId(long registrationRequestId) {
		return getPersistence().countByRegistrationRequestId(
			registrationRequestId);
	}

	/**
	 * Returns all the employee permissions where form = &#63;.
	 *
	 * @param form the form
	 * @return the matching employee permissions
	 */
	public static List<EmployeePermission> findByFormClassName(String form) {
		return getPersistence().findByFormClassName(form);
	}

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
	public static List<EmployeePermission> findByFormClassName(
		String form, int start, int end) {

		return getPersistence().findByFormClassName(form, start, end);
	}

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
	public static List<EmployeePermission> findByFormClassName(
		String form, int start, int end,
		OrderByComparator<EmployeePermission> orderByComparator) {

		return getPersistence().findByFormClassName(
			form, start, end, orderByComparator);
	}

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
	public static List<EmployeePermission> findByFormClassName(
		String form, int start, int end,
		OrderByComparator<EmployeePermission> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFormClassName(
			form, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee permission in the ordered set where form = &#63;.
	 *
	 * @param form the form
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee permission
	 * @throws NoSuchEmployeePermissionException if a matching employee permission could not be found
	 */
	public static EmployeePermission findByFormClassName_First(
			String form,
			OrderByComparator<EmployeePermission> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePermissionException {

		return getPersistence().findByFormClassName_First(
			form, orderByComparator);
	}

	/**
	 * Returns the first employee permission in the ordered set where form = &#63;.
	 *
	 * @param form the form
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee permission, or <code>null</code> if a matching employee permission could not be found
	 */
	public static EmployeePermission fetchByFormClassName_First(
		String form, OrderByComparator<EmployeePermission> orderByComparator) {

		return getPersistence().fetchByFormClassName_First(
			form, orderByComparator);
	}

	/**
	 * Returns the last employee permission in the ordered set where form = &#63;.
	 *
	 * @param form the form
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee permission
	 * @throws NoSuchEmployeePermissionException if a matching employee permission could not be found
	 */
	public static EmployeePermission findByFormClassName_Last(
			String form,
			OrderByComparator<EmployeePermission> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePermissionException {

		return getPersistence().findByFormClassName_Last(
			form, orderByComparator);
	}

	/**
	 * Returns the last employee permission in the ordered set where form = &#63;.
	 *
	 * @param form the form
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee permission, or <code>null</code> if a matching employee permission could not be found
	 */
	public static EmployeePermission fetchByFormClassName_Last(
		String form, OrderByComparator<EmployeePermission> orderByComparator) {

		return getPersistence().fetchByFormClassName_Last(
			form, orderByComparator);
	}

	/**
	 * Returns the employee permissions before and after the current employee permission in the ordered set where form = &#63;.
	 *
	 * @param employeePermissionId the primary key of the current employee permission
	 * @param form the form
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee permission
	 * @throws NoSuchEmployeePermissionException if a employee permission with the primary key could not be found
	 */
	public static EmployeePermission[] findByFormClassName_PrevAndNext(
			long employeePermissionId, String form,
			OrderByComparator<EmployeePermission> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePermissionException {

		return getPersistence().findByFormClassName_PrevAndNext(
			employeePermissionId, form, orderByComparator);
	}

	/**
	 * Removes all the employee permissions where form = &#63; from the database.
	 *
	 * @param form the form
	 */
	public static void removeByFormClassName(String form) {
		getPersistence().removeByFormClassName(form);
	}

	/**
	 * Returns the number of employee permissions where form = &#63;.
	 *
	 * @param form the form
	 * @return the number of matching employee permissions
	 */
	public static int countByFormClassName(String form) {
		return getPersistence().countByFormClassName(form);
	}

	/**
	 * Caches the employee permission in the entity cache if it is enabled.
	 *
	 * @param employeePermission the employee permission
	 */
	public static void cacheResult(EmployeePermission employeePermission) {
		getPersistence().cacheResult(employeePermission);
	}

	/**
	 * Caches the employee permissions in the entity cache if it is enabled.
	 *
	 * @param employeePermissions the employee permissions
	 */
	public static void cacheResult(
		List<EmployeePermission> employeePermissions) {

		getPersistence().cacheResult(employeePermissions);
	}

	/**
	 * Creates a new employee permission with the primary key. Does not add the employee permission to the database.
	 *
	 * @param employeePermissionId the primary key for the new employee permission
	 * @return the new employee permission
	 */
	public static EmployeePermission create(long employeePermissionId) {
		return getPersistence().create(employeePermissionId);
	}

	/**
	 * Removes the employee permission with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeePermissionId the primary key of the employee permission
	 * @return the employee permission that was removed
	 * @throws NoSuchEmployeePermissionException if a employee permission with the primary key could not be found
	 */
	public static EmployeePermission remove(long employeePermissionId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePermissionException {

		return getPersistence().remove(employeePermissionId);
	}

	public static EmployeePermission updateImpl(
		EmployeePermission employeePermission) {

		return getPersistence().updateImpl(employeePermission);
	}

	/**
	 * Returns the employee permission with the primary key or throws a <code>NoSuchEmployeePermissionException</code> if it could not be found.
	 *
	 * @param employeePermissionId the primary key of the employee permission
	 * @return the employee permission
	 * @throws NoSuchEmployeePermissionException if a employee permission with the primary key could not be found
	 */
	public static EmployeePermission findByPrimaryKey(long employeePermissionId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePermissionException {

		return getPersistence().findByPrimaryKey(employeePermissionId);
	}

	/**
	 * Returns the employee permission with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeePermissionId the primary key of the employee permission
	 * @return the employee permission, or <code>null</code> if a employee permission with the primary key could not be found
	 */
	public static EmployeePermission fetchByPrimaryKey(
		long employeePermissionId) {

		return getPersistence().fetchByPrimaryKey(employeePermissionId);
	}

	/**
	 * Returns all the employee permissions.
	 *
	 * @return the employee permissions
	 */
	public static List<EmployeePermission> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<EmployeePermission> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<EmployeePermission> findAll(
		int start, int end,
		OrderByComparator<EmployeePermission> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<EmployeePermission> findAll(
		int start, int end,
		OrderByComparator<EmployeePermission> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee permissions from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee permissions.
	 *
	 * @return the number of employee permissions
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeePermissionPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeePermissionPersistence, EmployeePermissionPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EmployeePermissionPersistence.class);

		ServiceTracker
			<EmployeePermissionPersistence, EmployeePermissionPersistence>
				serviceTracker =
					new ServiceTracker
						<EmployeePermissionPersistence,
						 EmployeePermissionPersistence>(
							 bundle.getBundleContext(),
							 EmployeePermissionPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}