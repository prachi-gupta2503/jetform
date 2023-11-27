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

import com.adjecti.pis.liferay.model.EmployeeVerification;

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
 * The persistence utility for the employee verification service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.EmployeeVerificationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeVerificationPersistence
 * @generated
 */
public class EmployeeVerificationUtil {

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
	public static void clearCache(EmployeeVerification employeeVerification) {
		getPersistence().clearCache(employeeVerification);
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
	public static Map<Serializable, EmployeeVerification> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeVerification> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeVerification> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeVerification> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeVerification> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeVerification update(
		EmployeeVerification employeeVerification) {

		return getPersistence().update(employeeVerification);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeVerification update(
		EmployeeVerification employeeVerification,
		ServiceContext serviceContext) {

		return getPersistence().update(employeeVerification, serviceContext);
	}

	/**
	 * Returns all the employee verifications where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee verifications
	 */
	public static List<EmployeeVerification> findByEmployeeId(long employeeId) {
		return getPersistence().findByEmployeeId(employeeId);
	}

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
	public static List<EmployeeVerification> findByEmployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

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
	public static List<EmployeeVerification> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeVerification> orderByComparator) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator);
	}

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
	public static List<EmployeeVerification> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeVerification> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee verification in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee verification
	 * @throws NoSuchEmployeeVerificationException if a matching employee verification could not be found
	 */
	public static EmployeeVerification findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeVerification> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeVerificationException {

		return getPersistence().findByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first employee verification in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee verification, or <code>null</code> if a matching employee verification could not be found
	 */
	public static EmployeeVerification fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<EmployeeVerification> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee verification in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee verification
	 * @throws NoSuchEmployeeVerificationException if a matching employee verification could not be found
	 */
	public static EmployeeVerification findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeVerification> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeVerificationException {

		return getPersistence().findByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee verification in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee verification, or <code>null</code> if a matching employee verification could not be found
	 */
	public static EmployeeVerification fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<EmployeeVerification> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the employee verifications before and after the current employee verification in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeVerificationId the primary key of the current employee verification
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee verification
	 * @throws NoSuchEmployeeVerificationException if a employee verification with the primary key could not be found
	 */
	public static EmployeeVerification[] findByEmployeeId_PrevAndNext(
			long employeeVerificationId, long employeeId,
			OrderByComparator<EmployeeVerification> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeVerificationException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			employeeVerificationId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the employee verifications where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of employee verifications where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee verifications
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Returns all the employee verifications where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the matching employee verifications
	 */
	public static List<EmployeeVerification> findByJoiningProcessId(
		long joiningProcessId) {

		return getPersistence().findByJoiningProcessId(joiningProcessId);
	}

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
	public static List<EmployeeVerification> findByJoiningProcessId(
		long joiningProcessId, int start, int end) {

		return getPersistence().findByJoiningProcessId(
			joiningProcessId, start, end);
	}

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
	public static List<EmployeeVerification> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		OrderByComparator<EmployeeVerification> orderByComparator) {

		return getPersistence().findByJoiningProcessId(
			joiningProcessId, start, end, orderByComparator);
	}

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
	public static List<EmployeeVerification> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		OrderByComparator<EmployeeVerification> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByJoiningProcessId(
			joiningProcessId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee verification in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee verification
	 * @throws NoSuchEmployeeVerificationException if a matching employee verification could not be found
	 */
	public static EmployeeVerification findByJoiningProcessId_First(
			long joiningProcessId,
			OrderByComparator<EmployeeVerification> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeVerificationException {

		return getPersistence().findByJoiningProcessId_First(
			joiningProcessId, orderByComparator);
	}

	/**
	 * Returns the first employee verification in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee verification, or <code>null</code> if a matching employee verification could not be found
	 */
	public static EmployeeVerification fetchByJoiningProcessId_First(
		long joiningProcessId,
		OrderByComparator<EmployeeVerification> orderByComparator) {

		return getPersistence().fetchByJoiningProcessId_First(
			joiningProcessId, orderByComparator);
	}

	/**
	 * Returns the last employee verification in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee verification
	 * @throws NoSuchEmployeeVerificationException if a matching employee verification could not be found
	 */
	public static EmployeeVerification findByJoiningProcessId_Last(
			long joiningProcessId,
			OrderByComparator<EmployeeVerification> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeVerificationException {

		return getPersistence().findByJoiningProcessId_Last(
			joiningProcessId, orderByComparator);
	}

	/**
	 * Returns the last employee verification in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee verification, or <code>null</code> if a matching employee verification could not be found
	 */
	public static EmployeeVerification fetchByJoiningProcessId_Last(
		long joiningProcessId,
		OrderByComparator<EmployeeVerification> orderByComparator) {

		return getPersistence().fetchByJoiningProcessId_Last(
			joiningProcessId, orderByComparator);
	}

	/**
	 * Returns the employee verifications before and after the current employee verification in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param employeeVerificationId the primary key of the current employee verification
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee verification
	 * @throws NoSuchEmployeeVerificationException if a employee verification with the primary key could not be found
	 */
	public static EmployeeVerification[] findByJoiningProcessId_PrevAndNext(
			long employeeVerificationId, long joiningProcessId,
			OrderByComparator<EmployeeVerification> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeVerificationException {

		return getPersistence().findByJoiningProcessId_PrevAndNext(
			employeeVerificationId, joiningProcessId, orderByComparator);
	}

	/**
	 * Removes all the employee verifications where joiningProcessId = &#63; from the database.
	 *
	 * @param joiningProcessId the joining process ID
	 */
	public static void removeByJoiningProcessId(long joiningProcessId) {
		getPersistence().removeByJoiningProcessId(joiningProcessId);
	}

	/**
	 * Returns the number of employee verifications where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the number of matching employee verifications
	 */
	public static int countByJoiningProcessId(long joiningProcessId) {
		return getPersistence().countByJoiningProcessId(joiningProcessId);
	}

	/**
	 * Returns all the employee verifications where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching employee verifications
	 */
	public static List<EmployeeVerification> findByOrganizationId(
		long organizationId) {

		return getPersistence().findByOrganizationId(organizationId);
	}

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
	public static List<EmployeeVerification> findByOrganizationId(
		long organizationId, int start, int end) {

		return getPersistence().findByOrganizationId(
			organizationId, start, end);
	}

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
	public static List<EmployeeVerification> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<EmployeeVerification> orderByComparator) {

		return getPersistence().findByOrganizationId(
			organizationId, start, end, orderByComparator);
	}

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
	public static List<EmployeeVerification> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<EmployeeVerification> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByOrganizationId(
			organizationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee verification in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee verification
	 * @throws NoSuchEmployeeVerificationException if a matching employee verification could not be found
	 */
	public static EmployeeVerification findByOrganizationId_First(
			long organizationId,
			OrderByComparator<EmployeeVerification> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeVerificationException {

		return getPersistence().findByOrganizationId_First(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the first employee verification in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee verification, or <code>null</code> if a matching employee verification could not be found
	 */
	public static EmployeeVerification fetchByOrganizationId_First(
		long organizationId,
		OrderByComparator<EmployeeVerification> orderByComparator) {

		return getPersistence().fetchByOrganizationId_First(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the last employee verification in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee verification
	 * @throws NoSuchEmployeeVerificationException if a matching employee verification could not be found
	 */
	public static EmployeeVerification findByOrganizationId_Last(
			long organizationId,
			OrderByComparator<EmployeeVerification> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeVerificationException {

		return getPersistence().findByOrganizationId_Last(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the last employee verification in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee verification, or <code>null</code> if a matching employee verification could not be found
	 */
	public static EmployeeVerification fetchByOrganizationId_Last(
		long organizationId,
		OrderByComparator<EmployeeVerification> orderByComparator) {

		return getPersistence().fetchByOrganizationId_Last(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the employee verifications before and after the current employee verification in the ordered set where organizationId = &#63;.
	 *
	 * @param employeeVerificationId the primary key of the current employee verification
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee verification
	 * @throws NoSuchEmployeeVerificationException if a employee verification with the primary key could not be found
	 */
	public static EmployeeVerification[] findByOrganizationId_PrevAndNext(
			long employeeVerificationId, long organizationId,
			OrderByComparator<EmployeeVerification> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeVerificationException {

		return getPersistence().findByOrganizationId_PrevAndNext(
			employeeVerificationId, organizationId, orderByComparator);
	}

	/**
	 * Removes all the employee verifications where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	public static void removeByOrganizationId(long organizationId) {
		getPersistence().removeByOrganizationId(organizationId);
	}

	/**
	 * Returns the number of employee verifications where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching employee verifications
	 */
	public static int countByOrganizationId(long organizationId) {
		return getPersistence().countByOrganizationId(organizationId);
	}

	/**
	 * Caches the employee verification in the entity cache if it is enabled.
	 *
	 * @param employeeVerification the employee verification
	 */
	public static void cacheResult(EmployeeVerification employeeVerification) {
		getPersistence().cacheResult(employeeVerification);
	}

	/**
	 * Caches the employee verifications in the entity cache if it is enabled.
	 *
	 * @param employeeVerifications the employee verifications
	 */
	public static void cacheResult(
		List<EmployeeVerification> employeeVerifications) {

		getPersistence().cacheResult(employeeVerifications);
	}

	/**
	 * Creates a new employee verification with the primary key. Does not add the employee verification to the database.
	 *
	 * @param employeeVerificationId the primary key for the new employee verification
	 * @return the new employee verification
	 */
	public static EmployeeVerification create(long employeeVerificationId) {
		return getPersistence().create(employeeVerificationId);
	}

	/**
	 * Removes the employee verification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeVerificationId the primary key of the employee verification
	 * @return the employee verification that was removed
	 * @throws NoSuchEmployeeVerificationException if a employee verification with the primary key could not be found
	 */
	public static EmployeeVerification remove(long employeeVerificationId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeVerificationException {

		return getPersistence().remove(employeeVerificationId);
	}

	public static EmployeeVerification updateImpl(
		EmployeeVerification employeeVerification) {

		return getPersistence().updateImpl(employeeVerification);
	}

	/**
	 * Returns the employee verification with the primary key or throws a <code>NoSuchEmployeeVerificationException</code> if it could not be found.
	 *
	 * @param employeeVerificationId the primary key of the employee verification
	 * @return the employee verification
	 * @throws NoSuchEmployeeVerificationException if a employee verification with the primary key could not be found
	 */
	public static EmployeeVerification findByPrimaryKey(
			long employeeVerificationId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeVerificationException {

		return getPersistence().findByPrimaryKey(employeeVerificationId);
	}

	/**
	 * Returns the employee verification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeVerificationId the primary key of the employee verification
	 * @return the employee verification, or <code>null</code> if a employee verification with the primary key could not be found
	 */
	public static EmployeeVerification fetchByPrimaryKey(
		long employeeVerificationId) {

		return getPersistence().fetchByPrimaryKey(employeeVerificationId);
	}

	/**
	 * Returns all the employee verifications.
	 *
	 * @return the employee verifications
	 */
	public static List<EmployeeVerification> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<EmployeeVerification> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<EmployeeVerification> findAll(
		int start, int end,
		OrderByComparator<EmployeeVerification> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<EmployeeVerification> findAll(
		int start, int end,
		OrderByComparator<EmployeeVerification> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee verifications from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee verifications.
	 *
	 * @return the number of employee verifications
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeVerificationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeeVerificationPersistence, EmployeeVerificationPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EmployeeVerificationPersistence.class);

		ServiceTracker
			<EmployeeVerificationPersistence, EmployeeVerificationPersistence>
				serviceTracker =
					new ServiceTracker
						<EmployeeVerificationPersistence,
						 EmployeeVerificationPersistence>(
							 bundle.getBundleContext(),
							 EmployeeVerificationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}