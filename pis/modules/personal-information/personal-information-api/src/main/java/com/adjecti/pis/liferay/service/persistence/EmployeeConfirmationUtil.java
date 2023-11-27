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

import com.adjecti.pis.liferay.model.EmployeeConfirmation;

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
 * The persistence utility for the employee confirmation service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.EmployeeConfirmationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeConfirmationPersistence
 * @generated
 */
public class EmployeeConfirmationUtil {

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
	public static void clearCache(EmployeeConfirmation employeeConfirmation) {
		getPersistence().clearCache(employeeConfirmation);
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
	public static Map<Serializable, EmployeeConfirmation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeConfirmation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeConfirmation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeConfirmation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeConfirmation> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeConfirmation update(
		EmployeeConfirmation employeeConfirmation) {

		return getPersistence().update(employeeConfirmation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeConfirmation update(
		EmployeeConfirmation employeeConfirmation,
		ServiceContext serviceContext) {

		return getPersistence().update(employeeConfirmation, serviceContext);
	}

	/**
	 * Returns all the employee confirmations where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @return the matching employee confirmations
	 */
	public static List<EmployeeConfirmation> findByGradeModeId(
		long gradeModeId) {

		return getPersistence().findByGradeModeId(gradeModeId);
	}

	/**
	 * Returns a range of all the employee confirmations where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeConfirmationModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee confirmations
	 * @param end the upper bound of the range of employee confirmations (not inclusive)
	 * @return the range of matching employee confirmations
	 */
	public static List<EmployeeConfirmation> findByGradeModeId(
		long gradeModeId, int start, int end) {

		return getPersistence().findByGradeModeId(gradeModeId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee confirmations where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeConfirmationModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee confirmations
	 * @param end the upper bound of the range of employee confirmations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee confirmations
	 */
	public static List<EmployeeConfirmation> findByGradeModeId(
		long gradeModeId, int start, int end,
		OrderByComparator<EmployeeConfirmation> orderByComparator) {

		return getPersistence().findByGradeModeId(
			gradeModeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee confirmations where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeConfirmationModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee confirmations
	 * @param end the upper bound of the range of employee confirmations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee confirmations
	 */
	public static List<EmployeeConfirmation> findByGradeModeId(
		long gradeModeId, int start, int end,
		OrderByComparator<EmployeeConfirmation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGradeModeId(
			gradeModeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee confirmation in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee confirmation
	 * @throws NoSuchEmployeeConfirmationException if a matching employee confirmation could not be found
	 */
	public static EmployeeConfirmation findByGradeModeId_First(
			long gradeModeId,
			OrderByComparator<EmployeeConfirmation> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeConfirmationException {

		return getPersistence().findByGradeModeId_First(
			gradeModeId, orderByComparator);
	}

	/**
	 * Returns the first employee confirmation in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee confirmation, or <code>null</code> if a matching employee confirmation could not be found
	 */
	public static EmployeeConfirmation fetchByGradeModeId_First(
		long gradeModeId,
		OrderByComparator<EmployeeConfirmation> orderByComparator) {

		return getPersistence().fetchByGradeModeId_First(
			gradeModeId, orderByComparator);
	}

	/**
	 * Returns the last employee confirmation in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee confirmation
	 * @throws NoSuchEmployeeConfirmationException if a matching employee confirmation could not be found
	 */
	public static EmployeeConfirmation findByGradeModeId_Last(
			long gradeModeId,
			OrderByComparator<EmployeeConfirmation> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeConfirmationException {

		return getPersistence().findByGradeModeId_Last(
			gradeModeId, orderByComparator);
	}

	/**
	 * Returns the last employee confirmation in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee confirmation, or <code>null</code> if a matching employee confirmation could not be found
	 */
	public static EmployeeConfirmation fetchByGradeModeId_Last(
		long gradeModeId,
		OrderByComparator<EmployeeConfirmation> orderByComparator) {

		return getPersistence().fetchByGradeModeId_Last(
			gradeModeId, orderByComparator);
	}

	/**
	 * Returns the employee confirmations before and after the current employee confirmation in the ordered set where gradeModeId = &#63;.
	 *
	 * @param employeeConfirmationId the primary key of the current employee confirmation
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee confirmation
	 * @throws NoSuchEmployeeConfirmationException if a employee confirmation with the primary key could not be found
	 */
	public static EmployeeConfirmation[] findByGradeModeId_PrevAndNext(
			long employeeConfirmationId, long gradeModeId,
			OrderByComparator<EmployeeConfirmation> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeConfirmationException {

		return getPersistence().findByGradeModeId_PrevAndNext(
			employeeConfirmationId, gradeModeId, orderByComparator);
	}

	/**
	 * Removes all the employee confirmations where gradeModeId = &#63; from the database.
	 *
	 * @param gradeModeId the grade mode ID
	 */
	public static void removeByGradeModeId(long gradeModeId) {
		getPersistence().removeByGradeModeId(gradeModeId);
	}

	/**
	 * Returns the number of employee confirmations where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @return the number of matching employee confirmations
	 */
	public static int countByGradeModeId(long gradeModeId) {
		return getPersistence().countByGradeModeId(gradeModeId);
	}

	/**
	 * Returns all the employee confirmations where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee confirmations
	 */
	public static List<EmployeeConfirmation> findByEmployeeId(long employeeId) {
		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns a range of all the employee confirmations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeConfirmationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee confirmations
	 * @param end the upper bound of the range of employee confirmations (not inclusive)
	 * @return the range of matching employee confirmations
	 */
	public static List<EmployeeConfirmation> findByEmployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee confirmations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeConfirmationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee confirmations
	 * @param end the upper bound of the range of employee confirmations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee confirmations
	 */
	public static List<EmployeeConfirmation> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeConfirmation> orderByComparator) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee confirmations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeConfirmationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee confirmations
	 * @param end the upper bound of the range of employee confirmations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee confirmations
	 */
	public static List<EmployeeConfirmation> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeConfirmation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee confirmation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee confirmation
	 * @throws NoSuchEmployeeConfirmationException if a matching employee confirmation could not be found
	 */
	public static EmployeeConfirmation findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeConfirmation> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeConfirmationException {

		return getPersistence().findByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first employee confirmation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee confirmation, or <code>null</code> if a matching employee confirmation could not be found
	 */
	public static EmployeeConfirmation fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<EmployeeConfirmation> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee confirmation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee confirmation
	 * @throws NoSuchEmployeeConfirmationException if a matching employee confirmation could not be found
	 */
	public static EmployeeConfirmation findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeConfirmation> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeConfirmationException {

		return getPersistence().findByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee confirmation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee confirmation, or <code>null</code> if a matching employee confirmation could not be found
	 */
	public static EmployeeConfirmation fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<EmployeeConfirmation> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the employee confirmations before and after the current employee confirmation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeConfirmationId the primary key of the current employee confirmation
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee confirmation
	 * @throws NoSuchEmployeeConfirmationException if a employee confirmation with the primary key could not be found
	 */
	public static EmployeeConfirmation[] findByEmployeeId_PrevAndNext(
			long employeeConfirmationId, long employeeId,
			OrderByComparator<EmployeeConfirmation> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeConfirmationException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			employeeConfirmationId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the employee confirmations where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of employee confirmations where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee confirmations
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Returns all the employee confirmations where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching employee confirmations
	 */
	public static List<EmployeeConfirmation> findByOrganizationId(
		long organizationId) {

		return getPersistence().findByOrganizationId(organizationId);
	}

	/**
	 * Returns a range of all the employee confirmations where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeConfirmationModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee confirmations
	 * @param end the upper bound of the range of employee confirmations (not inclusive)
	 * @return the range of matching employee confirmations
	 */
	public static List<EmployeeConfirmation> findByOrganizationId(
		long organizationId, int start, int end) {

		return getPersistence().findByOrganizationId(
			organizationId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee confirmations where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeConfirmationModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee confirmations
	 * @param end the upper bound of the range of employee confirmations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee confirmations
	 */
	public static List<EmployeeConfirmation> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<EmployeeConfirmation> orderByComparator) {

		return getPersistence().findByOrganizationId(
			organizationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee confirmations where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeConfirmationModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee confirmations
	 * @param end the upper bound of the range of employee confirmations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee confirmations
	 */
	public static List<EmployeeConfirmation> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<EmployeeConfirmation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByOrganizationId(
			organizationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee confirmation in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee confirmation
	 * @throws NoSuchEmployeeConfirmationException if a matching employee confirmation could not be found
	 */
	public static EmployeeConfirmation findByOrganizationId_First(
			long organizationId,
			OrderByComparator<EmployeeConfirmation> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeConfirmationException {

		return getPersistence().findByOrganizationId_First(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the first employee confirmation in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee confirmation, or <code>null</code> if a matching employee confirmation could not be found
	 */
	public static EmployeeConfirmation fetchByOrganizationId_First(
		long organizationId,
		OrderByComparator<EmployeeConfirmation> orderByComparator) {

		return getPersistence().fetchByOrganizationId_First(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the last employee confirmation in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee confirmation
	 * @throws NoSuchEmployeeConfirmationException if a matching employee confirmation could not be found
	 */
	public static EmployeeConfirmation findByOrganizationId_Last(
			long organizationId,
			OrderByComparator<EmployeeConfirmation> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeConfirmationException {

		return getPersistence().findByOrganizationId_Last(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the last employee confirmation in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee confirmation, or <code>null</code> if a matching employee confirmation could not be found
	 */
	public static EmployeeConfirmation fetchByOrganizationId_Last(
		long organizationId,
		OrderByComparator<EmployeeConfirmation> orderByComparator) {

		return getPersistence().fetchByOrganizationId_Last(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the employee confirmations before and after the current employee confirmation in the ordered set where organizationId = &#63;.
	 *
	 * @param employeeConfirmationId the primary key of the current employee confirmation
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee confirmation
	 * @throws NoSuchEmployeeConfirmationException if a employee confirmation with the primary key could not be found
	 */
	public static EmployeeConfirmation[] findByOrganizationId_PrevAndNext(
			long employeeConfirmationId, long organizationId,
			OrderByComparator<EmployeeConfirmation> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeConfirmationException {

		return getPersistence().findByOrganizationId_PrevAndNext(
			employeeConfirmationId, organizationId, orderByComparator);
	}

	/**
	 * Removes all the employee confirmations where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	public static void removeByOrganizationId(long organizationId) {
		getPersistence().removeByOrganizationId(organizationId);
	}

	/**
	 * Returns the number of employee confirmations where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching employee confirmations
	 */
	public static int countByOrganizationId(long organizationId) {
		return getPersistence().countByOrganizationId(organizationId);
	}

	/**
	 * Caches the employee confirmation in the entity cache if it is enabled.
	 *
	 * @param employeeConfirmation the employee confirmation
	 */
	public static void cacheResult(EmployeeConfirmation employeeConfirmation) {
		getPersistence().cacheResult(employeeConfirmation);
	}

	/**
	 * Caches the employee confirmations in the entity cache if it is enabled.
	 *
	 * @param employeeConfirmations the employee confirmations
	 */
	public static void cacheResult(
		List<EmployeeConfirmation> employeeConfirmations) {

		getPersistence().cacheResult(employeeConfirmations);
	}

	/**
	 * Creates a new employee confirmation with the primary key. Does not add the employee confirmation to the database.
	 *
	 * @param employeeConfirmationId the primary key for the new employee confirmation
	 * @return the new employee confirmation
	 */
	public static EmployeeConfirmation create(long employeeConfirmationId) {
		return getPersistence().create(employeeConfirmationId);
	}

	/**
	 * Removes the employee confirmation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeConfirmationId the primary key of the employee confirmation
	 * @return the employee confirmation that was removed
	 * @throws NoSuchEmployeeConfirmationException if a employee confirmation with the primary key could not be found
	 */
	public static EmployeeConfirmation remove(long employeeConfirmationId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeConfirmationException {

		return getPersistence().remove(employeeConfirmationId);
	}

	public static EmployeeConfirmation updateImpl(
		EmployeeConfirmation employeeConfirmation) {

		return getPersistence().updateImpl(employeeConfirmation);
	}

	/**
	 * Returns the employee confirmation with the primary key or throws a <code>NoSuchEmployeeConfirmationException</code> if it could not be found.
	 *
	 * @param employeeConfirmationId the primary key of the employee confirmation
	 * @return the employee confirmation
	 * @throws NoSuchEmployeeConfirmationException if a employee confirmation with the primary key could not be found
	 */
	public static EmployeeConfirmation findByPrimaryKey(
			long employeeConfirmationId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeConfirmationException {

		return getPersistence().findByPrimaryKey(employeeConfirmationId);
	}

	/**
	 * Returns the employee confirmation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeConfirmationId the primary key of the employee confirmation
	 * @return the employee confirmation, or <code>null</code> if a employee confirmation with the primary key could not be found
	 */
	public static EmployeeConfirmation fetchByPrimaryKey(
		long employeeConfirmationId) {

		return getPersistence().fetchByPrimaryKey(employeeConfirmationId);
	}

	/**
	 * Returns all the employee confirmations.
	 *
	 * @return the employee confirmations
	 */
	public static List<EmployeeConfirmation> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employee confirmations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeConfirmationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee confirmations
	 * @param end the upper bound of the range of employee confirmations (not inclusive)
	 * @return the range of employee confirmations
	 */
	public static List<EmployeeConfirmation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employee confirmations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeConfirmationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee confirmations
	 * @param end the upper bound of the range of employee confirmations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee confirmations
	 */
	public static List<EmployeeConfirmation> findAll(
		int start, int end,
		OrderByComparator<EmployeeConfirmation> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee confirmations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeConfirmationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee confirmations
	 * @param end the upper bound of the range of employee confirmations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee confirmations
	 */
	public static List<EmployeeConfirmation> findAll(
		int start, int end,
		OrderByComparator<EmployeeConfirmation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee confirmations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee confirmations.
	 *
	 * @return the number of employee confirmations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeConfirmationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeeConfirmationPersistence, EmployeeConfirmationPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EmployeeConfirmationPersistence.class);

		ServiceTracker
			<EmployeeConfirmationPersistence, EmployeeConfirmationPersistence>
				serviceTracker =
					new ServiceTracker
						<EmployeeConfirmationPersistence,
						 EmployeeConfirmationPersistence>(
							 bundle.getBundleContext(),
							 EmployeeConfirmationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}