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

import com.adjecti.pis.liferay.model.EmployeeExperience;

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
 * The persistence utility for the employee experience service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.EmployeeExperiencePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeExperiencePersistence
 * @generated
 */
public class EmployeeExperienceUtil {

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
	public static void clearCache(EmployeeExperience employeeExperience) {
		getPersistence().clearCache(employeeExperience);
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
	public static Map<Serializable, EmployeeExperience> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeExperience> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeExperience> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeExperience> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeExperience> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeExperience update(
		EmployeeExperience employeeExperience) {

		return getPersistence().update(employeeExperience);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeExperience update(
		EmployeeExperience employeeExperience, ServiceContext serviceContext) {

		return getPersistence().update(employeeExperience, serviceContext);
	}

	/**
	 * Returns all the employee experiences where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee experiences
	 */
	public static List<EmployeeExperience> findByEmployeeId(long employeeId) {
		return getPersistence().findByEmployeeId(employeeId);
	}

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
	public static List<EmployeeExperience> findByEmployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

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
	public static List<EmployeeExperience> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeExperience> orderByComparator) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator);
	}

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
	public static List<EmployeeExperience> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeExperience> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee experience in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee experience
	 * @throws NoSuchEmployeeExperienceException if a matching employee experience could not be found
	 */
	public static EmployeeExperience findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeExperience> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeExperienceException {

		return getPersistence().findByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first employee experience in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	public static EmployeeExperience fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<EmployeeExperience> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee experience in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee experience
	 * @throws NoSuchEmployeeExperienceException if a matching employee experience could not be found
	 */
	public static EmployeeExperience findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeExperience> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeExperienceException {

		return getPersistence().findByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee experience in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	public static EmployeeExperience fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<EmployeeExperience> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the employee experiences before and after the current employee experience in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeExperienceId the primary key of the current employee experience
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee experience
	 * @throws NoSuchEmployeeExperienceException if a employee experience with the primary key could not be found
	 */
	public static EmployeeExperience[] findByEmployeeId_PrevAndNext(
			long employeeExperienceId, long employeeId,
			OrderByComparator<EmployeeExperience> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeExperienceException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			employeeExperienceId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the employee experiences where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of employee experiences where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee experiences
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Returns all the employee experiences where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching employee experiences
	 */
	public static List<EmployeeExperience> findByOrganizationId(
		long organizationId) {

		return getPersistence().findByOrganizationId(organizationId);
	}

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
	public static List<EmployeeExperience> findByOrganizationId(
		long organizationId, int start, int end) {

		return getPersistence().findByOrganizationId(
			organizationId, start, end);
	}

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
	public static List<EmployeeExperience> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<EmployeeExperience> orderByComparator) {

		return getPersistence().findByOrganizationId(
			organizationId, start, end, orderByComparator);
	}

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
	public static List<EmployeeExperience> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<EmployeeExperience> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByOrganizationId(
			organizationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee experience in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee experience
	 * @throws NoSuchEmployeeExperienceException if a matching employee experience could not be found
	 */
	public static EmployeeExperience findByOrganizationId_First(
			long organizationId,
			OrderByComparator<EmployeeExperience> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeExperienceException {

		return getPersistence().findByOrganizationId_First(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the first employee experience in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	public static EmployeeExperience fetchByOrganizationId_First(
		long organizationId,
		OrderByComparator<EmployeeExperience> orderByComparator) {

		return getPersistence().fetchByOrganizationId_First(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the last employee experience in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee experience
	 * @throws NoSuchEmployeeExperienceException if a matching employee experience could not be found
	 */
	public static EmployeeExperience findByOrganizationId_Last(
			long organizationId,
			OrderByComparator<EmployeeExperience> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeExperienceException {

		return getPersistence().findByOrganizationId_Last(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the last employee experience in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	public static EmployeeExperience fetchByOrganizationId_Last(
		long organizationId,
		OrderByComparator<EmployeeExperience> orderByComparator) {

		return getPersistence().fetchByOrganizationId_Last(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the employee experiences before and after the current employee experience in the ordered set where organizationId = &#63;.
	 *
	 * @param employeeExperienceId the primary key of the current employee experience
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee experience
	 * @throws NoSuchEmployeeExperienceException if a employee experience with the primary key could not be found
	 */
	public static EmployeeExperience[] findByOrganizationId_PrevAndNext(
			long employeeExperienceId, long organizationId,
			OrderByComparator<EmployeeExperience> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeExperienceException {

		return getPersistence().findByOrganizationId_PrevAndNext(
			employeeExperienceId, organizationId, orderByComparator);
	}

	/**
	 * Removes all the employee experiences where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	public static void removeByOrganizationId(long organizationId) {
		getPersistence().removeByOrganizationId(organizationId);
	}

	/**
	 * Returns the number of employee experiences where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching employee experiences
	 */
	public static int countByOrganizationId(long organizationId) {
		return getPersistence().countByOrganizationId(organizationId);
	}

	/**
	 * Returns all the employee experiences where workAreaMinorId = &#63;.
	 *
	 * @param workAreaMinorId the work area minor ID
	 * @return the matching employee experiences
	 */
	public static List<EmployeeExperience> findByWorkAreaMinorId(
		long workAreaMinorId) {

		return getPersistence().findByWorkAreaMinorId(workAreaMinorId);
	}

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
	public static List<EmployeeExperience> findByWorkAreaMinorId(
		long workAreaMinorId, int start, int end) {

		return getPersistence().findByWorkAreaMinorId(
			workAreaMinorId, start, end);
	}

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
	public static List<EmployeeExperience> findByWorkAreaMinorId(
		long workAreaMinorId, int start, int end,
		OrderByComparator<EmployeeExperience> orderByComparator) {

		return getPersistence().findByWorkAreaMinorId(
			workAreaMinorId, start, end, orderByComparator);
	}

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
	public static List<EmployeeExperience> findByWorkAreaMinorId(
		long workAreaMinorId, int start, int end,
		OrderByComparator<EmployeeExperience> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByWorkAreaMinorId(
			workAreaMinorId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee experience in the ordered set where workAreaMinorId = &#63;.
	 *
	 * @param workAreaMinorId the work area minor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee experience
	 * @throws NoSuchEmployeeExperienceException if a matching employee experience could not be found
	 */
	public static EmployeeExperience findByWorkAreaMinorId_First(
			long workAreaMinorId,
			OrderByComparator<EmployeeExperience> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeExperienceException {

		return getPersistence().findByWorkAreaMinorId_First(
			workAreaMinorId, orderByComparator);
	}

	/**
	 * Returns the first employee experience in the ordered set where workAreaMinorId = &#63;.
	 *
	 * @param workAreaMinorId the work area minor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	public static EmployeeExperience fetchByWorkAreaMinorId_First(
		long workAreaMinorId,
		OrderByComparator<EmployeeExperience> orderByComparator) {

		return getPersistence().fetchByWorkAreaMinorId_First(
			workAreaMinorId, orderByComparator);
	}

	/**
	 * Returns the last employee experience in the ordered set where workAreaMinorId = &#63;.
	 *
	 * @param workAreaMinorId the work area minor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee experience
	 * @throws NoSuchEmployeeExperienceException if a matching employee experience could not be found
	 */
	public static EmployeeExperience findByWorkAreaMinorId_Last(
			long workAreaMinorId,
			OrderByComparator<EmployeeExperience> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeExperienceException {

		return getPersistence().findByWorkAreaMinorId_Last(
			workAreaMinorId, orderByComparator);
	}

	/**
	 * Returns the last employee experience in the ordered set where workAreaMinorId = &#63;.
	 *
	 * @param workAreaMinorId the work area minor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	public static EmployeeExperience fetchByWorkAreaMinorId_Last(
		long workAreaMinorId,
		OrderByComparator<EmployeeExperience> orderByComparator) {

		return getPersistence().fetchByWorkAreaMinorId_Last(
			workAreaMinorId, orderByComparator);
	}

	/**
	 * Returns the employee experiences before and after the current employee experience in the ordered set where workAreaMinorId = &#63;.
	 *
	 * @param employeeExperienceId the primary key of the current employee experience
	 * @param workAreaMinorId the work area minor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee experience
	 * @throws NoSuchEmployeeExperienceException if a employee experience with the primary key could not be found
	 */
	public static EmployeeExperience[] findByWorkAreaMinorId_PrevAndNext(
			long employeeExperienceId, long workAreaMinorId,
			OrderByComparator<EmployeeExperience> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeExperienceException {

		return getPersistence().findByWorkAreaMinorId_PrevAndNext(
			employeeExperienceId, workAreaMinorId, orderByComparator);
	}

	/**
	 * Removes all the employee experiences where workAreaMinorId = &#63; from the database.
	 *
	 * @param workAreaMinorId the work area minor ID
	 */
	public static void removeByWorkAreaMinorId(long workAreaMinorId) {
		getPersistence().removeByWorkAreaMinorId(workAreaMinorId);
	}

	/**
	 * Returns the number of employee experiences where workAreaMinorId = &#63;.
	 *
	 * @param workAreaMinorId the work area minor ID
	 * @return the number of matching employee experiences
	 */
	public static int countByWorkAreaMinorId(long workAreaMinorId) {
		return getPersistence().countByWorkAreaMinorId(workAreaMinorId);
	}

	/**
	 * Returns all the employee experiences where workAreaId = &#63;.
	 *
	 * @param workAreaId the work area ID
	 * @return the matching employee experiences
	 */
	public static List<EmployeeExperience> findByWorkAreaId(long workAreaId) {
		return getPersistence().findByWorkAreaId(workAreaId);
	}

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
	public static List<EmployeeExperience> findByWorkAreaId(
		long workAreaId, int start, int end) {

		return getPersistence().findByWorkAreaId(workAreaId, start, end);
	}

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
	public static List<EmployeeExperience> findByWorkAreaId(
		long workAreaId, int start, int end,
		OrderByComparator<EmployeeExperience> orderByComparator) {

		return getPersistence().findByWorkAreaId(
			workAreaId, start, end, orderByComparator);
	}

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
	public static List<EmployeeExperience> findByWorkAreaId(
		long workAreaId, int start, int end,
		OrderByComparator<EmployeeExperience> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByWorkAreaId(
			workAreaId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee experience in the ordered set where workAreaId = &#63;.
	 *
	 * @param workAreaId the work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee experience
	 * @throws NoSuchEmployeeExperienceException if a matching employee experience could not be found
	 */
	public static EmployeeExperience findByWorkAreaId_First(
			long workAreaId,
			OrderByComparator<EmployeeExperience> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeExperienceException {

		return getPersistence().findByWorkAreaId_First(
			workAreaId, orderByComparator);
	}

	/**
	 * Returns the first employee experience in the ordered set where workAreaId = &#63;.
	 *
	 * @param workAreaId the work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	public static EmployeeExperience fetchByWorkAreaId_First(
		long workAreaId,
		OrderByComparator<EmployeeExperience> orderByComparator) {

		return getPersistence().fetchByWorkAreaId_First(
			workAreaId, orderByComparator);
	}

	/**
	 * Returns the last employee experience in the ordered set where workAreaId = &#63;.
	 *
	 * @param workAreaId the work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee experience
	 * @throws NoSuchEmployeeExperienceException if a matching employee experience could not be found
	 */
	public static EmployeeExperience findByWorkAreaId_Last(
			long workAreaId,
			OrderByComparator<EmployeeExperience> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeExperienceException {

		return getPersistence().findByWorkAreaId_Last(
			workAreaId, orderByComparator);
	}

	/**
	 * Returns the last employee experience in the ordered set where workAreaId = &#63;.
	 *
	 * @param workAreaId the work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee experience, or <code>null</code> if a matching employee experience could not be found
	 */
	public static EmployeeExperience fetchByWorkAreaId_Last(
		long workAreaId,
		OrderByComparator<EmployeeExperience> orderByComparator) {

		return getPersistence().fetchByWorkAreaId_Last(
			workAreaId, orderByComparator);
	}

	/**
	 * Returns the employee experiences before and after the current employee experience in the ordered set where workAreaId = &#63;.
	 *
	 * @param employeeExperienceId the primary key of the current employee experience
	 * @param workAreaId the work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee experience
	 * @throws NoSuchEmployeeExperienceException if a employee experience with the primary key could not be found
	 */
	public static EmployeeExperience[] findByWorkAreaId_PrevAndNext(
			long employeeExperienceId, long workAreaId,
			OrderByComparator<EmployeeExperience> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeExperienceException {

		return getPersistence().findByWorkAreaId_PrevAndNext(
			employeeExperienceId, workAreaId, orderByComparator);
	}

	/**
	 * Removes all the employee experiences where workAreaId = &#63; from the database.
	 *
	 * @param workAreaId the work area ID
	 */
	public static void removeByWorkAreaId(long workAreaId) {
		getPersistence().removeByWorkAreaId(workAreaId);
	}

	/**
	 * Returns the number of employee experiences where workAreaId = &#63;.
	 *
	 * @param workAreaId the work area ID
	 * @return the number of matching employee experiences
	 */
	public static int countByWorkAreaId(long workAreaId) {
		return getPersistence().countByWorkAreaId(workAreaId);
	}

	/**
	 * Caches the employee experience in the entity cache if it is enabled.
	 *
	 * @param employeeExperience the employee experience
	 */
	public static void cacheResult(EmployeeExperience employeeExperience) {
		getPersistence().cacheResult(employeeExperience);
	}

	/**
	 * Caches the employee experiences in the entity cache if it is enabled.
	 *
	 * @param employeeExperiences the employee experiences
	 */
	public static void cacheResult(
		List<EmployeeExperience> employeeExperiences) {

		getPersistence().cacheResult(employeeExperiences);
	}

	/**
	 * Creates a new employee experience with the primary key. Does not add the employee experience to the database.
	 *
	 * @param employeeExperienceId the primary key for the new employee experience
	 * @return the new employee experience
	 */
	public static EmployeeExperience create(long employeeExperienceId) {
		return getPersistence().create(employeeExperienceId);
	}

	/**
	 * Removes the employee experience with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeExperienceId the primary key of the employee experience
	 * @return the employee experience that was removed
	 * @throws NoSuchEmployeeExperienceException if a employee experience with the primary key could not be found
	 */
	public static EmployeeExperience remove(long employeeExperienceId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeExperienceException {

		return getPersistence().remove(employeeExperienceId);
	}

	public static EmployeeExperience updateImpl(
		EmployeeExperience employeeExperience) {

		return getPersistence().updateImpl(employeeExperience);
	}

	/**
	 * Returns the employee experience with the primary key or throws a <code>NoSuchEmployeeExperienceException</code> if it could not be found.
	 *
	 * @param employeeExperienceId the primary key of the employee experience
	 * @return the employee experience
	 * @throws NoSuchEmployeeExperienceException if a employee experience with the primary key could not be found
	 */
	public static EmployeeExperience findByPrimaryKey(long employeeExperienceId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeExperienceException {

		return getPersistence().findByPrimaryKey(employeeExperienceId);
	}

	/**
	 * Returns the employee experience with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeExperienceId the primary key of the employee experience
	 * @return the employee experience, or <code>null</code> if a employee experience with the primary key could not be found
	 */
	public static EmployeeExperience fetchByPrimaryKey(
		long employeeExperienceId) {

		return getPersistence().fetchByPrimaryKey(employeeExperienceId);
	}

	/**
	 * Returns all the employee experiences.
	 *
	 * @return the employee experiences
	 */
	public static List<EmployeeExperience> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<EmployeeExperience> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<EmployeeExperience> findAll(
		int start, int end,
		OrderByComparator<EmployeeExperience> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<EmployeeExperience> findAll(
		int start, int end,
		OrderByComparator<EmployeeExperience> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee experiences from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee experiences.
	 *
	 * @return the number of employee experiences
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeExperiencePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeeExperiencePersistence, EmployeeExperiencePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EmployeeExperiencePersistence.class);

		ServiceTracker
			<EmployeeExperiencePersistence, EmployeeExperiencePersistence>
				serviceTracker =
					new ServiceTracker
						<EmployeeExperiencePersistence,
						 EmployeeExperiencePersistence>(
							 bundle.getBundleContext(),
							 EmployeeExperiencePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}