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

import com.adjecti.pis.liferay.model.OrganizationAssignment;

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
 * The persistence utility for the organization assignment service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.OrganizationAssignmentPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationAssignmentPersistence
 * @generated
 */
public class OrganizationAssignmentUtil {

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
	public static void clearCache(
		OrganizationAssignment organizationAssignment) {

		getPersistence().clearCache(organizationAssignment);
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
	public static Map<Serializable, OrganizationAssignment> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<OrganizationAssignment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OrganizationAssignment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OrganizationAssignment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<OrganizationAssignment> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static OrganizationAssignment update(
		OrganizationAssignment organizationAssignment) {

		return getPersistence().update(organizationAssignment);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static OrganizationAssignment update(
		OrganizationAssignment organizationAssignment,
		ServiceContext serviceContext) {

		return getPersistence().update(organizationAssignment, serviceContext);
	}

	/**
	 * Returns all the organization assignments where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching organization assignments
	 */
	public static List<OrganizationAssignment> findByEmployeeId(
		long employeeId) {

		return getPersistence().findByEmployeeId(employeeId);
	}

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
	public static List<OrganizationAssignment> findByEmployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

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
	public static List<OrganizationAssignment> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<OrganizationAssignment> orderByComparator) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator);
	}

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
	public static List<OrganizationAssignment> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<OrganizationAssignment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first organization assignment in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a matching organization assignment could not be found
	 */
	public static OrganizationAssignment findByEmployeeId_First(
			long employeeId,
			OrderByComparator<OrganizationAssignment> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchOrganizationAssignmentException {

		return getPersistence().findByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first organization assignment in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization assignment, or <code>null</code> if a matching organization assignment could not be found
	 */
	public static OrganizationAssignment fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<OrganizationAssignment> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last organization assignment in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a matching organization assignment could not be found
	 */
	public static OrganizationAssignment findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<OrganizationAssignment> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchOrganizationAssignmentException {

		return getPersistence().findByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last organization assignment in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization assignment, or <code>null</code> if a matching organization assignment could not be found
	 */
	public static OrganizationAssignment fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<OrganizationAssignment> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the organization assignments before and after the current organization assignment in the ordered set where employeeId = &#63;.
	 *
	 * @param organizationAssignmentId the primary key of the current organization assignment
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a organization assignment with the primary key could not be found
	 */
	public static OrganizationAssignment[] findByEmployeeId_PrevAndNext(
			long organizationAssignmentId, long employeeId,
			OrderByComparator<OrganizationAssignment> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchOrganizationAssignmentException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			organizationAssignmentId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the organization assignments where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of organization assignments where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching organization assignments
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Returns all the organization assignments where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @return the matching organization assignments
	 */
	public static List<OrganizationAssignment> findByPersonalNo(
		String personalNo) {

		return getPersistence().findByPersonalNo(personalNo);
	}

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
	public static List<OrganizationAssignment> findByPersonalNo(
		String personalNo, int start, int end) {

		return getPersistence().findByPersonalNo(personalNo, start, end);
	}

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
	public static List<OrganizationAssignment> findByPersonalNo(
		String personalNo, int start, int end,
		OrderByComparator<OrganizationAssignment> orderByComparator) {

		return getPersistence().findByPersonalNo(
			personalNo, start, end, orderByComparator);
	}

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
	public static List<OrganizationAssignment> findByPersonalNo(
		String personalNo, int start, int end,
		OrderByComparator<OrganizationAssignment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPersonalNo(
			personalNo, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first organization assignment in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a matching organization assignment could not be found
	 */
	public static OrganizationAssignment findByPersonalNo_First(
			String personalNo,
			OrderByComparator<OrganizationAssignment> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchOrganizationAssignmentException {

		return getPersistence().findByPersonalNo_First(
			personalNo, orderByComparator);
	}

	/**
	 * Returns the first organization assignment in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization assignment, or <code>null</code> if a matching organization assignment could not be found
	 */
	public static OrganizationAssignment fetchByPersonalNo_First(
		String personalNo,
		OrderByComparator<OrganizationAssignment> orderByComparator) {

		return getPersistence().fetchByPersonalNo_First(
			personalNo, orderByComparator);
	}

	/**
	 * Returns the last organization assignment in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a matching organization assignment could not be found
	 */
	public static OrganizationAssignment findByPersonalNo_Last(
			String personalNo,
			OrderByComparator<OrganizationAssignment> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchOrganizationAssignmentException {

		return getPersistence().findByPersonalNo_Last(
			personalNo, orderByComparator);
	}

	/**
	 * Returns the last organization assignment in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization assignment, or <code>null</code> if a matching organization assignment could not be found
	 */
	public static OrganizationAssignment fetchByPersonalNo_Last(
		String personalNo,
		OrderByComparator<OrganizationAssignment> orderByComparator) {

		return getPersistence().fetchByPersonalNo_Last(
			personalNo, orderByComparator);
	}

	/**
	 * Returns the organization assignments before and after the current organization assignment in the ordered set where personalNo = &#63;.
	 *
	 * @param organizationAssignmentId the primary key of the current organization assignment
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a organization assignment with the primary key could not be found
	 */
	public static OrganizationAssignment[] findByPersonalNo_PrevAndNext(
			long organizationAssignmentId, String personalNo,
			OrderByComparator<OrganizationAssignment> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchOrganizationAssignmentException {

		return getPersistence().findByPersonalNo_PrevAndNext(
			organizationAssignmentId, personalNo, orderByComparator);
	}

	/**
	 * Removes all the organization assignments where personalNo = &#63; from the database.
	 *
	 * @param personalNo the personal no
	 */
	public static void removeByPersonalNo(String personalNo) {
		getPersistence().removeByPersonalNo(personalNo);
	}

	/**
	 * Returns the number of organization assignments where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @return the number of matching organization assignments
	 */
	public static int countByPersonalNo(String personalNo) {
		return getPersistence().countByPersonalNo(personalNo);
	}

	/**
	 * Returns all the organization assignments where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching organization assignments
	 */
	public static List<OrganizationAssignment> findByOrganizationId(
		long organizationId) {

		return getPersistence().findByOrganizationId(organizationId);
	}

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
	public static List<OrganizationAssignment> findByOrganizationId(
		long organizationId, int start, int end) {

		return getPersistence().findByOrganizationId(
			organizationId, start, end);
	}

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
	public static List<OrganizationAssignment> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<OrganizationAssignment> orderByComparator) {

		return getPersistence().findByOrganizationId(
			organizationId, start, end, orderByComparator);
	}

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
	public static List<OrganizationAssignment> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<OrganizationAssignment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByOrganizationId(
			organizationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first organization assignment in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a matching organization assignment could not be found
	 */
	public static OrganizationAssignment findByOrganizationId_First(
			long organizationId,
			OrderByComparator<OrganizationAssignment> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchOrganizationAssignmentException {

		return getPersistence().findByOrganizationId_First(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the first organization assignment in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization assignment, or <code>null</code> if a matching organization assignment could not be found
	 */
	public static OrganizationAssignment fetchByOrganizationId_First(
		long organizationId,
		OrderByComparator<OrganizationAssignment> orderByComparator) {

		return getPersistence().fetchByOrganizationId_First(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the last organization assignment in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a matching organization assignment could not be found
	 */
	public static OrganizationAssignment findByOrganizationId_Last(
			long organizationId,
			OrderByComparator<OrganizationAssignment> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchOrganizationAssignmentException {

		return getPersistence().findByOrganizationId_Last(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the last organization assignment in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization assignment, or <code>null</code> if a matching organization assignment could not be found
	 */
	public static OrganizationAssignment fetchByOrganizationId_Last(
		long organizationId,
		OrderByComparator<OrganizationAssignment> orderByComparator) {

		return getPersistence().fetchByOrganizationId_Last(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the organization assignments before and after the current organization assignment in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationAssignmentId the primary key of the current organization assignment
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a organization assignment with the primary key could not be found
	 */
	public static OrganizationAssignment[] findByOrganizationId_PrevAndNext(
			long organizationAssignmentId, long organizationId,
			OrderByComparator<OrganizationAssignment> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchOrganizationAssignmentException {

		return getPersistence().findByOrganizationId_PrevAndNext(
			organizationAssignmentId, organizationId, orderByComparator);
	}

	/**
	 * Removes all the organization assignments where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	public static void removeByOrganizationId(long organizationId) {
		getPersistence().removeByOrganizationId(organizationId);
	}

	/**
	 * Returns the number of organization assignments where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching organization assignments
	 */
	public static int countByOrganizationId(long organizationId) {
		return getPersistence().countByOrganizationId(organizationId);
	}

	/**
	 * Returns all the organization assignments where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @return the matching organization assignments
	 */
	public static List<OrganizationAssignment> findByOrganizationCode(
		String organizationCode) {

		return getPersistence().findByOrganizationCode(organizationCode);
	}

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
	public static List<OrganizationAssignment> findByOrganizationCode(
		String organizationCode, int start, int end) {

		return getPersistence().findByOrganizationCode(
			organizationCode, start, end);
	}

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
	public static List<OrganizationAssignment> findByOrganizationCode(
		String organizationCode, int start, int end,
		OrderByComparator<OrganizationAssignment> orderByComparator) {

		return getPersistence().findByOrganizationCode(
			organizationCode, start, end, orderByComparator);
	}

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
	public static List<OrganizationAssignment> findByOrganizationCode(
		String organizationCode, int start, int end,
		OrderByComparator<OrganizationAssignment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByOrganizationCode(
			organizationCode, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first organization assignment in the ordered set where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a matching organization assignment could not be found
	 */
	public static OrganizationAssignment findByOrganizationCode_First(
			String organizationCode,
			OrderByComparator<OrganizationAssignment> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchOrganizationAssignmentException {

		return getPersistence().findByOrganizationCode_First(
			organizationCode, orderByComparator);
	}

	/**
	 * Returns the first organization assignment in the ordered set where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization assignment, or <code>null</code> if a matching organization assignment could not be found
	 */
	public static OrganizationAssignment fetchByOrganizationCode_First(
		String organizationCode,
		OrderByComparator<OrganizationAssignment> orderByComparator) {

		return getPersistence().fetchByOrganizationCode_First(
			organizationCode, orderByComparator);
	}

	/**
	 * Returns the last organization assignment in the ordered set where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a matching organization assignment could not be found
	 */
	public static OrganizationAssignment findByOrganizationCode_Last(
			String organizationCode,
			OrderByComparator<OrganizationAssignment> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchOrganizationAssignmentException {

		return getPersistence().findByOrganizationCode_Last(
			organizationCode, orderByComparator);
	}

	/**
	 * Returns the last organization assignment in the ordered set where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization assignment, or <code>null</code> if a matching organization assignment could not be found
	 */
	public static OrganizationAssignment fetchByOrganizationCode_Last(
		String organizationCode,
		OrderByComparator<OrganizationAssignment> orderByComparator) {

		return getPersistence().fetchByOrganizationCode_Last(
			organizationCode, orderByComparator);
	}

	/**
	 * Returns the organization assignments before and after the current organization assignment in the ordered set where organizationCode = &#63;.
	 *
	 * @param organizationAssignmentId the primary key of the current organization assignment
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a organization assignment with the primary key could not be found
	 */
	public static OrganizationAssignment[] findByOrganizationCode_PrevAndNext(
			long organizationAssignmentId, String organizationCode,
			OrderByComparator<OrganizationAssignment> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchOrganizationAssignmentException {

		return getPersistence().findByOrganizationCode_PrevAndNext(
			organizationAssignmentId, organizationCode, orderByComparator);
	}

	/**
	 * Removes all the organization assignments where organizationCode = &#63; from the database.
	 *
	 * @param organizationCode the organization code
	 */
	public static void removeByOrganizationCode(String organizationCode) {
		getPersistence().removeByOrganizationCode(organizationCode);
	}

	/**
	 * Returns the number of organization assignments where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @return the number of matching organization assignments
	 */
	public static int countByOrganizationCode(String organizationCode) {
		return getPersistence().countByOrganizationCode(organizationCode);
	}

	/**
	 * Returns all the organization assignments where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @return the matching organization assignments
	 */
	public static List<OrganizationAssignment> findBySubOrganizationId(
		long subOrganizationId) {

		return getPersistence().findBySubOrganizationId(subOrganizationId);
	}

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
	public static List<OrganizationAssignment> findBySubOrganizationId(
		long subOrganizationId, int start, int end) {

		return getPersistence().findBySubOrganizationId(
			subOrganizationId, start, end);
	}

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
	public static List<OrganizationAssignment> findBySubOrganizationId(
		long subOrganizationId, int start, int end,
		OrderByComparator<OrganizationAssignment> orderByComparator) {

		return getPersistence().findBySubOrganizationId(
			subOrganizationId, start, end, orderByComparator);
	}

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
	public static List<OrganizationAssignment> findBySubOrganizationId(
		long subOrganizationId, int start, int end,
		OrderByComparator<OrganizationAssignment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySubOrganizationId(
			subOrganizationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first organization assignment in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a matching organization assignment could not be found
	 */
	public static OrganizationAssignment findBySubOrganizationId_First(
			long subOrganizationId,
			OrderByComparator<OrganizationAssignment> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchOrganizationAssignmentException {

		return getPersistence().findBySubOrganizationId_First(
			subOrganizationId, orderByComparator);
	}

	/**
	 * Returns the first organization assignment in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization assignment, or <code>null</code> if a matching organization assignment could not be found
	 */
	public static OrganizationAssignment fetchBySubOrganizationId_First(
		long subOrganizationId,
		OrderByComparator<OrganizationAssignment> orderByComparator) {

		return getPersistence().fetchBySubOrganizationId_First(
			subOrganizationId, orderByComparator);
	}

	/**
	 * Returns the last organization assignment in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a matching organization assignment could not be found
	 */
	public static OrganizationAssignment findBySubOrganizationId_Last(
			long subOrganizationId,
			OrderByComparator<OrganizationAssignment> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchOrganizationAssignmentException {

		return getPersistence().findBySubOrganizationId_Last(
			subOrganizationId, orderByComparator);
	}

	/**
	 * Returns the last organization assignment in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization assignment, or <code>null</code> if a matching organization assignment could not be found
	 */
	public static OrganizationAssignment fetchBySubOrganizationId_Last(
		long subOrganizationId,
		OrderByComparator<OrganizationAssignment> orderByComparator) {

		return getPersistence().fetchBySubOrganizationId_Last(
			subOrganizationId, orderByComparator);
	}

	/**
	 * Returns the organization assignments before and after the current organization assignment in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param organizationAssignmentId the primary key of the current organization assignment
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a organization assignment with the primary key could not be found
	 */
	public static OrganizationAssignment[] findBySubOrganizationId_PrevAndNext(
			long organizationAssignmentId, long subOrganizationId,
			OrderByComparator<OrganizationAssignment> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchOrganizationAssignmentException {

		return getPersistence().findBySubOrganizationId_PrevAndNext(
			organizationAssignmentId, subOrganizationId, orderByComparator);
	}

	/**
	 * Removes all the organization assignments where subOrganizationId = &#63; from the database.
	 *
	 * @param subOrganizationId the sub organization ID
	 */
	public static void removeBySubOrganizationId(long subOrganizationId) {
		getPersistence().removeBySubOrganizationId(subOrganizationId);
	}

	/**
	 * Returns the number of organization assignments where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @return the number of matching organization assignments
	 */
	public static int countBySubOrganizationId(long subOrganizationId) {
		return getPersistence().countBySubOrganizationId(subOrganizationId);
	}

	/**
	 * Returns all the organization assignments where subOrganizationCode = &#63;.
	 *
	 * @param subOrganizationCode the sub organization code
	 * @return the matching organization assignments
	 */
	public static List<OrganizationAssignment> findBySubOrganizationCode(
		String subOrganizationCode) {

		return getPersistence().findBySubOrganizationCode(subOrganizationCode);
	}

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
	public static List<OrganizationAssignment> findBySubOrganizationCode(
		String subOrganizationCode, int start, int end) {

		return getPersistence().findBySubOrganizationCode(
			subOrganizationCode, start, end);
	}

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
	public static List<OrganizationAssignment> findBySubOrganizationCode(
		String subOrganizationCode, int start, int end,
		OrderByComparator<OrganizationAssignment> orderByComparator) {

		return getPersistence().findBySubOrganizationCode(
			subOrganizationCode, start, end, orderByComparator);
	}

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
	public static List<OrganizationAssignment> findBySubOrganizationCode(
		String subOrganizationCode, int start, int end,
		OrderByComparator<OrganizationAssignment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySubOrganizationCode(
			subOrganizationCode, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first organization assignment in the ordered set where subOrganizationCode = &#63;.
	 *
	 * @param subOrganizationCode the sub organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a matching organization assignment could not be found
	 */
	public static OrganizationAssignment findBySubOrganizationCode_First(
			String subOrganizationCode,
			OrderByComparator<OrganizationAssignment> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchOrganizationAssignmentException {

		return getPersistence().findBySubOrganizationCode_First(
			subOrganizationCode, orderByComparator);
	}

	/**
	 * Returns the first organization assignment in the ordered set where subOrganizationCode = &#63;.
	 *
	 * @param subOrganizationCode the sub organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization assignment, or <code>null</code> if a matching organization assignment could not be found
	 */
	public static OrganizationAssignment fetchBySubOrganizationCode_First(
		String subOrganizationCode,
		OrderByComparator<OrganizationAssignment> orderByComparator) {

		return getPersistence().fetchBySubOrganizationCode_First(
			subOrganizationCode, orderByComparator);
	}

	/**
	 * Returns the last organization assignment in the ordered set where subOrganizationCode = &#63;.
	 *
	 * @param subOrganizationCode the sub organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a matching organization assignment could not be found
	 */
	public static OrganizationAssignment findBySubOrganizationCode_Last(
			String subOrganizationCode,
			OrderByComparator<OrganizationAssignment> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchOrganizationAssignmentException {

		return getPersistence().findBySubOrganizationCode_Last(
			subOrganizationCode, orderByComparator);
	}

	/**
	 * Returns the last organization assignment in the ordered set where subOrganizationCode = &#63;.
	 *
	 * @param subOrganizationCode the sub organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization assignment, or <code>null</code> if a matching organization assignment could not be found
	 */
	public static OrganizationAssignment fetchBySubOrganizationCode_Last(
		String subOrganizationCode,
		OrderByComparator<OrganizationAssignment> orderByComparator) {

		return getPersistence().fetchBySubOrganizationCode_Last(
			subOrganizationCode, orderByComparator);
	}

	/**
	 * Returns the organization assignments before and after the current organization assignment in the ordered set where subOrganizationCode = &#63;.
	 *
	 * @param organizationAssignmentId the primary key of the current organization assignment
	 * @param subOrganizationCode the sub organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a organization assignment with the primary key could not be found
	 */
	public static OrganizationAssignment[]
			findBySubOrganizationCode_PrevAndNext(
				long organizationAssignmentId, String subOrganizationCode,
				OrderByComparator<OrganizationAssignment> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchOrganizationAssignmentException {

		return getPersistence().findBySubOrganizationCode_PrevAndNext(
			organizationAssignmentId, subOrganizationCode, orderByComparator);
	}

	/**
	 * Removes all the organization assignments where subOrganizationCode = &#63; from the database.
	 *
	 * @param subOrganizationCode the sub organization code
	 */
	public static void removeBySubOrganizationCode(String subOrganizationCode) {
		getPersistence().removeBySubOrganizationCode(subOrganizationCode);
	}

	/**
	 * Returns the number of organization assignments where subOrganizationCode = &#63;.
	 *
	 * @param subOrganizationCode the sub organization code
	 * @return the number of matching organization assignments
	 */
	public static int countBySubOrganizationCode(String subOrganizationCode) {
		return getPersistence().countBySubOrganizationCode(subOrganizationCode);
	}

	/**
	 * Caches the organization assignment in the entity cache if it is enabled.
	 *
	 * @param organizationAssignment the organization assignment
	 */
	public static void cacheResult(
		OrganizationAssignment organizationAssignment) {

		getPersistence().cacheResult(organizationAssignment);
	}

	/**
	 * Caches the organization assignments in the entity cache if it is enabled.
	 *
	 * @param organizationAssignments the organization assignments
	 */
	public static void cacheResult(
		List<OrganizationAssignment> organizationAssignments) {

		getPersistence().cacheResult(organizationAssignments);
	}

	/**
	 * Creates a new organization assignment with the primary key. Does not add the organization assignment to the database.
	 *
	 * @param organizationAssignmentId the primary key for the new organization assignment
	 * @return the new organization assignment
	 */
	public static OrganizationAssignment create(long organizationAssignmentId) {
		return getPersistence().create(organizationAssignmentId);
	}

	/**
	 * Removes the organization assignment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param organizationAssignmentId the primary key of the organization assignment
	 * @return the organization assignment that was removed
	 * @throws NoSuchOrganizationAssignmentException if a organization assignment with the primary key could not be found
	 */
	public static OrganizationAssignment remove(long organizationAssignmentId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchOrganizationAssignmentException {

		return getPersistence().remove(organizationAssignmentId);
	}

	public static OrganizationAssignment updateImpl(
		OrganizationAssignment organizationAssignment) {

		return getPersistence().updateImpl(organizationAssignment);
	}

	/**
	 * Returns the organization assignment with the primary key or throws a <code>NoSuchOrganizationAssignmentException</code> if it could not be found.
	 *
	 * @param organizationAssignmentId the primary key of the organization assignment
	 * @return the organization assignment
	 * @throws NoSuchOrganizationAssignmentException if a organization assignment with the primary key could not be found
	 */
	public static OrganizationAssignment findByPrimaryKey(
			long organizationAssignmentId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchOrganizationAssignmentException {

		return getPersistence().findByPrimaryKey(organizationAssignmentId);
	}

	/**
	 * Returns the organization assignment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param organizationAssignmentId the primary key of the organization assignment
	 * @return the organization assignment, or <code>null</code> if a organization assignment with the primary key could not be found
	 */
	public static OrganizationAssignment fetchByPrimaryKey(
		long organizationAssignmentId) {

		return getPersistence().fetchByPrimaryKey(organizationAssignmentId);
	}

	/**
	 * Returns all the organization assignments.
	 *
	 * @return the organization assignments
	 */
	public static List<OrganizationAssignment> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<OrganizationAssignment> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<OrganizationAssignment> findAll(
		int start, int end,
		OrderByComparator<OrganizationAssignment> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<OrganizationAssignment> findAll(
		int start, int end,
		OrderByComparator<OrganizationAssignment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the organization assignments from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of organization assignments.
	 *
	 * @return the number of organization assignments
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static OrganizationAssignmentPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<OrganizationAssignmentPersistence, OrganizationAssignmentPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			OrganizationAssignmentPersistence.class);

		ServiceTracker
			<OrganizationAssignmentPersistence,
			 OrganizationAssignmentPersistence> serviceTracker =
				new ServiceTracker
					<OrganizationAssignmentPersistence,
					 OrganizationAssignmentPersistence>(
						 bundle.getBundleContext(),
						 OrganizationAssignmentPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}