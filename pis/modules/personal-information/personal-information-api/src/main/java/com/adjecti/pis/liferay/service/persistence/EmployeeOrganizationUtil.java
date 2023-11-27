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

import com.adjecti.pis.liferay.model.EmployeeOrganization;

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
 * The persistence utility for the employee organization service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.EmployeeOrganizationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeOrganizationPersistence
 * @generated
 */
public class EmployeeOrganizationUtil {

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
	public static void clearCache(EmployeeOrganization employeeOrganization) {
		getPersistence().clearCache(employeeOrganization);
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
	public static Map<Serializable, EmployeeOrganization> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeOrganization> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeOrganization> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeOrganization> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeOrganization update(
		EmployeeOrganization employeeOrganization) {

		return getPersistence().update(employeeOrganization);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeOrganization update(
		EmployeeOrganization employeeOrganization,
		ServiceContext serviceContext) {

		return getPersistence().update(employeeOrganization, serviceContext);
	}

	/**
	 * Returns all the employee organizations where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee organizations
	 */
	public static List<EmployeeOrganization> findByEmployeeId(long employeeId) {
		return getPersistence().findByEmployeeId(employeeId);
	}

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
	public static List<EmployeeOrganization> findByEmployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

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
	public static List<EmployeeOrganization> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator);
	}

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
	public static List<EmployeeOrganization> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeOrganization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee organization in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	public static EmployeeOrganization findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeOrganizationException {

		return getPersistence().findByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first employee organization in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	public static EmployeeOrganization fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee organization in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	public static EmployeeOrganization findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeOrganizationException {

		return getPersistence().findByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee organization in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	public static EmployeeOrganization fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the employee organizations before and after the current employee organization in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeOrganizationId the primary key of the current employee organization
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee organization
	 * @throws NoSuchEmployeeOrganizationException if a employee organization with the primary key could not be found
	 */
	public static EmployeeOrganization[] findByEmployeeId_PrevAndNext(
			long employeeOrganizationId, long employeeId,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeOrganizationException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			employeeOrganizationId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the employee organizations where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of employee organizations where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee organizations
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Returns all the employee organizations where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @return the matching employee organizations
	 */
	public static List<EmployeeOrganization> findByPersonalNo(
		String personalNo) {

		return getPersistence().findByPersonalNo(personalNo);
	}

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
	public static List<EmployeeOrganization> findByPersonalNo(
		String personalNo, int start, int end) {

		return getPersistence().findByPersonalNo(personalNo, start, end);
	}

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
	public static List<EmployeeOrganization> findByPersonalNo(
		String personalNo, int start, int end,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		return getPersistence().findByPersonalNo(
			personalNo, start, end, orderByComparator);
	}

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
	public static List<EmployeeOrganization> findByPersonalNo(
		String personalNo, int start, int end,
		OrderByComparator<EmployeeOrganization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPersonalNo(
			personalNo, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee organization in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	public static EmployeeOrganization findByPersonalNo_First(
			String personalNo,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeOrganizationException {

		return getPersistence().findByPersonalNo_First(
			personalNo, orderByComparator);
	}

	/**
	 * Returns the first employee organization in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	public static EmployeeOrganization fetchByPersonalNo_First(
		String personalNo,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		return getPersistence().fetchByPersonalNo_First(
			personalNo, orderByComparator);
	}

	/**
	 * Returns the last employee organization in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	public static EmployeeOrganization findByPersonalNo_Last(
			String personalNo,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeOrganizationException {

		return getPersistence().findByPersonalNo_Last(
			personalNo, orderByComparator);
	}

	/**
	 * Returns the last employee organization in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	public static EmployeeOrganization fetchByPersonalNo_Last(
		String personalNo,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		return getPersistence().fetchByPersonalNo_Last(
			personalNo, orderByComparator);
	}

	/**
	 * Returns the employee organizations before and after the current employee organization in the ordered set where personalNo = &#63;.
	 *
	 * @param employeeOrganizationId the primary key of the current employee organization
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee organization
	 * @throws NoSuchEmployeeOrganizationException if a employee organization with the primary key could not be found
	 */
	public static EmployeeOrganization[] findByPersonalNo_PrevAndNext(
			long employeeOrganizationId, String personalNo,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeOrganizationException {

		return getPersistence().findByPersonalNo_PrevAndNext(
			employeeOrganizationId, personalNo, orderByComparator);
	}

	/**
	 * Removes all the employee organizations where personalNo = &#63; from the database.
	 *
	 * @param personalNo the personal no
	 */
	public static void removeByPersonalNo(String personalNo) {
		getPersistence().removeByPersonalNo(personalNo);
	}

	/**
	 * Returns the number of employee organizations where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @return the number of matching employee organizations
	 */
	public static int countByPersonalNo(String personalNo) {
		return getPersistence().countByPersonalNo(personalNo);
	}

	/**
	 * Returns all the employee organizations where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching employee organizations
	 */
	public static List<EmployeeOrganization> findByOrganizationId(
		long organizationId) {

		return getPersistence().findByOrganizationId(organizationId);
	}

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
	public static List<EmployeeOrganization> findByOrganizationId(
		long organizationId, int start, int end) {

		return getPersistence().findByOrganizationId(
			organizationId, start, end);
	}

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
	public static List<EmployeeOrganization> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		return getPersistence().findByOrganizationId(
			organizationId, start, end, orderByComparator);
	}

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
	public static List<EmployeeOrganization> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<EmployeeOrganization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByOrganizationId(
			organizationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee organization in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	public static EmployeeOrganization findByOrganizationId_First(
			long organizationId,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeOrganizationException {

		return getPersistence().findByOrganizationId_First(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the first employee organization in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	public static EmployeeOrganization fetchByOrganizationId_First(
		long organizationId,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		return getPersistence().fetchByOrganizationId_First(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the last employee organization in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	public static EmployeeOrganization findByOrganizationId_Last(
			long organizationId,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeOrganizationException {

		return getPersistence().findByOrganizationId_Last(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the last employee organization in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	public static EmployeeOrganization fetchByOrganizationId_Last(
		long organizationId,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		return getPersistence().fetchByOrganizationId_Last(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the employee organizations before and after the current employee organization in the ordered set where organizationId = &#63;.
	 *
	 * @param employeeOrganizationId the primary key of the current employee organization
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee organization
	 * @throws NoSuchEmployeeOrganizationException if a employee organization with the primary key could not be found
	 */
	public static EmployeeOrganization[] findByOrganizationId_PrevAndNext(
			long employeeOrganizationId, long organizationId,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeOrganizationException {

		return getPersistence().findByOrganizationId_PrevAndNext(
			employeeOrganizationId, organizationId, orderByComparator);
	}

	/**
	 * Removes all the employee organizations where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	public static void removeByOrganizationId(long organizationId) {
		getPersistence().removeByOrganizationId(organizationId);
	}

	/**
	 * Returns the number of employee organizations where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching employee organizations
	 */
	public static int countByOrganizationId(long organizationId) {
		return getPersistence().countByOrganizationId(organizationId);
	}

	/**
	 * Returns all the employee organizations where employeeId = &#63; and organizationId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param organizationId the organization ID
	 * @return the matching employee organizations
	 */
	public static List<EmployeeOrganization> findByEmployeeIdAndOrganizationId(
		long employeeId, long organizationId) {

		return getPersistence().findByEmployeeIdAndOrganizationId(
			employeeId, organizationId);
	}

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
	public static List<EmployeeOrganization> findByEmployeeIdAndOrganizationId(
		long employeeId, long organizationId, int start, int end) {

		return getPersistence().findByEmployeeIdAndOrganizationId(
			employeeId, organizationId, start, end);
	}

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
	public static List<EmployeeOrganization> findByEmployeeIdAndOrganizationId(
		long employeeId, long organizationId, int start, int end,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		return getPersistence().findByEmployeeIdAndOrganizationId(
			employeeId, organizationId, start, end, orderByComparator);
	}

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
	public static List<EmployeeOrganization> findByEmployeeIdAndOrganizationId(
		long employeeId, long organizationId, int start, int end,
		OrderByComparator<EmployeeOrganization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeIdAndOrganizationId(
			employeeId, organizationId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first employee organization in the ordered set where employeeId = &#63; and organizationId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	public static EmployeeOrganization findByEmployeeIdAndOrganizationId_First(
			long employeeId, long organizationId,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeOrganizationException {

		return getPersistence().findByEmployeeIdAndOrganizationId_First(
			employeeId, organizationId, orderByComparator);
	}

	/**
	 * Returns the first employee organization in the ordered set where employeeId = &#63; and organizationId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	public static EmployeeOrganization fetchByEmployeeIdAndOrganizationId_First(
		long employeeId, long organizationId,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		return getPersistence().fetchByEmployeeIdAndOrganizationId_First(
			employeeId, organizationId, orderByComparator);
	}

	/**
	 * Returns the last employee organization in the ordered set where employeeId = &#63; and organizationId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	public static EmployeeOrganization findByEmployeeIdAndOrganizationId_Last(
			long employeeId, long organizationId,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeOrganizationException {

		return getPersistence().findByEmployeeIdAndOrganizationId_Last(
			employeeId, organizationId, orderByComparator);
	}

	/**
	 * Returns the last employee organization in the ordered set where employeeId = &#63; and organizationId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	public static EmployeeOrganization fetchByEmployeeIdAndOrganizationId_Last(
		long employeeId, long organizationId,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		return getPersistence().fetchByEmployeeIdAndOrganizationId_Last(
			employeeId, organizationId, orderByComparator);
	}

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
	public static EmployeeOrganization[]
			findByEmployeeIdAndOrganizationId_PrevAndNext(
				long employeeOrganizationId, long employeeId,
				long organizationId,
				OrderByComparator<EmployeeOrganization> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeOrganizationException {

		return getPersistence().findByEmployeeIdAndOrganizationId_PrevAndNext(
			employeeOrganizationId, employeeId, organizationId,
			orderByComparator);
	}

	/**
	 * Removes all the employee organizations where employeeId = &#63; and organizationId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param organizationId the organization ID
	 */
	public static void removeByEmployeeIdAndOrganizationId(
		long employeeId, long organizationId) {

		getPersistence().removeByEmployeeIdAndOrganizationId(
			employeeId, organizationId);
	}

	/**
	 * Returns the number of employee organizations where employeeId = &#63; and organizationId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param organizationId the organization ID
	 * @return the number of matching employee organizations
	 */
	public static int countByEmployeeIdAndOrganizationId(
		long employeeId, long organizationId) {

		return getPersistence().countByEmployeeIdAndOrganizationId(
			employeeId, organizationId);
	}

	/**
	 * Returns all the employee organizations where employeeId = &#63; and subOrganizationId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param subOrganizationId the sub organization ID
	 * @return the matching employee organizations
	 */
	public static List<EmployeeOrganization>
		findByEmployeeIdAndSubOrganizationId(
			long employeeId, long subOrganizationId) {

		return getPersistence().findByEmployeeIdAndSubOrganizationId(
			employeeId, subOrganizationId);
	}

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
	public static List<EmployeeOrganization>
		findByEmployeeIdAndSubOrganizationId(
			long employeeId, long subOrganizationId, int start, int end) {

		return getPersistence().findByEmployeeIdAndSubOrganizationId(
			employeeId, subOrganizationId, start, end);
	}

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
	public static List<EmployeeOrganization>
		findByEmployeeIdAndSubOrganizationId(
			long employeeId, long subOrganizationId, int start, int end,
			OrderByComparator<EmployeeOrganization> orderByComparator) {

		return getPersistence().findByEmployeeIdAndSubOrganizationId(
			employeeId, subOrganizationId, start, end, orderByComparator);
	}

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
	public static List<EmployeeOrganization>
		findByEmployeeIdAndSubOrganizationId(
			long employeeId, long subOrganizationId, int start, int end,
			OrderByComparator<EmployeeOrganization> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByEmployeeIdAndSubOrganizationId(
			employeeId, subOrganizationId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first employee organization in the ordered set where employeeId = &#63; and subOrganizationId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	public static EmployeeOrganization
			findByEmployeeIdAndSubOrganizationId_First(
				long employeeId, long subOrganizationId,
				OrderByComparator<EmployeeOrganization> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeOrganizationException {

		return getPersistence().findByEmployeeIdAndSubOrganizationId_First(
			employeeId, subOrganizationId, orderByComparator);
	}

	/**
	 * Returns the first employee organization in the ordered set where employeeId = &#63; and subOrganizationId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	public static EmployeeOrganization
		fetchByEmployeeIdAndSubOrganizationId_First(
			long employeeId, long subOrganizationId,
			OrderByComparator<EmployeeOrganization> orderByComparator) {

		return getPersistence().fetchByEmployeeIdAndSubOrganizationId_First(
			employeeId, subOrganizationId, orderByComparator);
	}

	/**
	 * Returns the last employee organization in the ordered set where employeeId = &#63; and subOrganizationId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	public static EmployeeOrganization
			findByEmployeeIdAndSubOrganizationId_Last(
				long employeeId, long subOrganizationId,
				OrderByComparator<EmployeeOrganization> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeOrganizationException {

		return getPersistence().findByEmployeeIdAndSubOrganizationId_Last(
			employeeId, subOrganizationId, orderByComparator);
	}

	/**
	 * Returns the last employee organization in the ordered set where employeeId = &#63; and subOrganizationId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	public static EmployeeOrganization
		fetchByEmployeeIdAndSubOrganizationId_Last(
			long employeeId, long subOrganizationId,
			OrderByComparator<EmployeeOrganization> orderByComparator) {

		return getPersistence().fetchByEmployeeIdAndSubOrganizationId_Last(
			employeeId, subOrganizationId, orderByComparator);
	}

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
	public static EmployeeOrganization[]
			findByEmployeeIdAndSubOrganizationId_PrevAndNext(
				long employeeOrganizationId, long employeeId,
				long subOrganizationId,
				OrderByComparator<EmployeeOrganization> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeOrganizationException {

		return getPersistence().
			findByEmployeeIdAndSubOrganizationId_PrevAndNext(
				employeeOrganizationId, employeeId, subOrganizationId,
				orderByComparator);
	}

	/**
	 * Removes all the employee organizations where employeeId = &#63; and subOrganizationId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param subOrganizationId the sub organization ID
	 */
	public static void removeByEmployeeIdAndSubOrganizationId(
		long employeeId, long subOrganizationId) {

		getPersistence().removeByEmployeeIdAndSubOrganizationId(
			employeeId, subOrganizationId);
	}

	/**
	 * Returns the number of employee organizations where employeeId = &#63; and subOrganizationId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param subOrganizationId the sub organization ID
	 * @return the number of matching employee organizations
	 */
	public static int countByEmployeeIdAndSubOrganizationId(
		long employeeId, long subOrganizationId) {

		return getPersistence().countByEmployeeIdAndSubOrganizationId(
			employeeId, subOrganizationId);
	}

	/**
	 * Returns all the employee organizations where subOrganizationId = &#63; and active = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param active the active
	 * @return the matching employee organizations
	 */
	public static List<EmployeeOrganization> findBySubOrganizationIdAndActive(
		long subOrganizationId, boolean active) {

		return getPersistence().findBySubOrganizationIdAndActive(
			subOrganizationId, active);
	}

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
	public static List<EmployeeOrganization> findBySubOrganizationIdAndActive(
		long subOrganizationId, boolean active, int start, int end) {

		return getPersistence().findBySubOrganizationIdAndActive(
			subOrganizationId, active, start, end);
	}

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
	public static List<EmployeeOrganization> findBySubOrganizationIdAndActive(
		long subOrganizationId, boolean active, int start, int end,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		return getPersistence().findBySubOrganizationIdAndActive(
			subOrganizationId, active, start, end, orderByComparator);
	}

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
	public static List<EmployeeOrganization> findBySubOrganizationIdAndActive(
		long subOrganizationId, boolean active, int start, int end,
		OrderByComparator<EmployeeOrganization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySubOrganizationIdAndActive(
			subOrganizationId, active, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first employee organization in the ordered set where subOrganizationId = &#63; and active = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	public static EmployeeOrganization findBySubOrganizationIdAndActive_First(
			long subOrganizationId, boolean active,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeOrganizationException {

		return getPersistence().findBySubOrganizationIdAndActive_First(
			subOrganizationId, active, orderByComparator);
	}

	/**
	 * Returns the first employee organization in the ordered set where subOrganizationId = &#63; and active = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	public static EmployeeOrganization fetchBySubOrganizationIdAndActive_First(
		long subOrganizationId, boolean active,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		return getPersistence().fetchBySubOrganizationIdAndActive_First(
			subOrganizationId, active, orderByComparator);
	}

	/**
	 * Returns the last employee organization in the ordered set where subOrganizationId = &#63; and active = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	public static EmployeeOrganization findBySubOrganizationIdAndActive_Last(
			long subOrganizationId, boolean active,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeOrganizationException {

		return getPersistence().findBySubOrganizationIdAndActive_Last(
			subOrganizationId, active, orderByComparator);
	}

	/**
	 * Returns the last employee organization in the ordered set where subOrganizationId = &#63; and active = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	public static EmployeeOrganization fetchBySubOrganizationIdAndActive_Last(
		long subOrganizationId, boolean active,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		return getPersistence().fetchBySubOrganizationIdAndActive_Last(
			subOrganizationId, active, orderByComparator);
	}

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
	public static EmployeeOrganization[]
			findBySubOrganizationIdAndActive_PrevAndNext(
				long employeeOrganizationId, long subOrganizationId,
				boolean active,
				OrderByComparator<EmployeeOrganization> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeOrganizationException {

		return getPersistence().findBySubOrganizationIdAndActive_PrevAndNext(
			employeeOrganizationId, subOrganizationId, active,
			orderByComparator);
	}

	/**
	 * Removes all the employee organizations where subOrganizationId = &#63; and active = &#63; from the database.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param active the active
	 */
	public static void removeBySubOrganizationIdAndActive(
		long subOrganizationId, boolean active) {

		getPersistence().removeBySubOrganizationIdAndActive(
			subOrganizationId, active);
	}

	/**
	 * Returns the number of employee organizations where subOrganizationId = &#63; and active = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param active the active
	 * @return the number of matching employee organizations
	 */
	public static int countBySubOrganizationIdAndActive(
		long subOrganizationId, boolean active) {

		return getPersistence().countBySubOrganizationIdAndActive(
			subOrganizationId, active);
	}

	/**
	 * Returns all the employee organizations where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @return the matching employee organizations
	 */
	public static List<EmployeeOrganization> findByOrganizationCode(
		String organizationCode) {

		return getPersistence().findByOrganizationCode(organizationCode);
	}

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
	public static List<EmployeeOrganization> findByOrganizationCode(
		String organizationCode, int start, int end) {

		return getPersistence().findByOrganizationCode(
			organizationCode, start, end);
	}

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
	public static List<EmployeeOrganization> findByOrganizationCode(
		String organizationCode, int start, int end,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		return getPersistence().findByOrganizationCode(
			organizationCode, start, end, orderByComparator);
	}

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
	public static List<EmployeeOrganization> findByOrganizationCode(
		String organizationCode, int start, int end,
		OrderByComparator<EmployeeOrganization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByOrganizationCode(
			organizationCode, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee organization in the ordered set where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	public static EmployeeOrganization findByOrganizationCode_First(
			String organizationCode,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeOrganizationException {

		return getPersistence().findByOrganizationCode_First(
			organizationCode, orderByComparator);
	}

	/**
	 * Returns the first employee organization in the ordered set where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	public static EmployeeOrganization fetchByOrganizationCode_First(
		String organizationCode,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		return getPersistence().fetchByOrganizationCode_First(
			organizationCode, orderByComparator);
	}

	/**
	 * Returns the last employee organization in the ordered set where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	public static EmployeeOrganization findByOrganizationCode_Last(
			String organizationCode,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeOrganizationException {

		return getPersistence().findByOrganizationCode_Last(
			organizationCode, orderByComparator);
	}

	/**
	 * Returns the last employee organization in the ordered set where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	public static EmployeeOrganization fetchByOrganizationCode_Last(
		String organizationCode,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		return getPersistence().fetchByOrganizationCode_Last(
			organizationCode, orderByComparator);
	}

	/**
	 * Returns the employee organizations before and after the current employee organization in the ordered set where organizationCode = &#63;.
	 *
	 * @param employeeOrganizationId the primary key of the current employee organization
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee organization
	 * @throws NoSuchEmployeeOrganizationException if a employee organization with the primary key could not be found
	 */
	public static EmployeeOrganization[] findByOrganizationCode_PrevAndNext(
			long employeeOrganizationId, String organizationCode,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeOrganizationException {

		return getPersistence().findByOrganizationCode_PrevAndNext(
			employeeOrganizationId, organizationCode, orderByComparator);
	}

	/**
	 * Removes all the employee organizations where organizationCode = &#63; from the database.
	 *
	 * @param organizationCode the organization code
	 */
	public static void removeByOrganizationCode(String organizationCode) {
		getPersistence().removeByOrganizationCode(organizationCode);
	}

	/**
	 * Returns the number of employee organizations where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @return the number of matching employee organizations
	 */
	public static int countByOrganizationCode(String organizationCode) {
		return getPersistence().countByOrganizationCode(organizationCode);
	}

	/**
	 * Returns all the employee organizations where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @return the matching employee organizations
	 */
	public static List<EmployeeOrganization> findBySubOrganizationId(
		long subOrganizationId) {

		return getPersistence().findBySubOrganizationId(subOrganizationId);
	}

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
	public static List<EmployeeOrganization> findBySubOrganizationId(
		long subOrganizationId, int start, int end) {

		return getPersistence().findBySubOrganizationId(
			subOrganizationId, start, end);
	}

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
	public static List<EmployeeOrganization> findBySubOrganizationId(
		long subOrganizationId, int start, int end,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		return getPersistence().findBySubOrganizationId(
			subOrganizationId, start, end, orderByComparator);
	}

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
	public static List<EmployeeOrganization> findBySubOrganizationId(
		long subOrganizationId, int start, int end,
		OrderByComparator<EmployeeOrganization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySubOrganizationId(
			subOrganizationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee organization in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	public static EmployeeOrganization findBySubOrganizationId_First(
			long subOrganizationId,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeOrganizationException {

		return getPersistence().findBySubOrganizationId_First(
			subOrganizationId, orderByComparator);
	}

	/**
	 * Returns the first employee organization in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	public static EmployeeOrganization fetchBySubOrganizationId_First(
		long subOrganizationId,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		return getPersistence().fetchBySubOrganizationId_First(
			subOrganizationId, orderByComparator);
	}

	/**
	 * Returns the last employee organization in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	public static EmployeeOrganization findBySubOrganizationId_Last(
			long subOrganizationId,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeOrganizationException {

		return getPersistence().findBySubOrganizationId_Last(
			subOrganizationId, orderByComparator);
	}

	/**
	 * Returns the last employee organization in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	public static EmployeeOrganization fetchBySubOrganizationId_Last(
		long subOrganizationId,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		return getPersistence().fetchBySubOrganizationId_Last(
			subOrganizationId, orderByComparator);
	}

	/**
	 * Returns the employee organizations before and after the current employee organization in the ordered set where subOrganizationId = &#63;.
	 *
	 * @param employeeOrganizationId the primary key of the current employee organization
	 * @param subOrganizationId the sub organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee organization
	 * @throws NoSuchEmployeeOrganizationException if a employee organization with the primary key could not be found
	 */
	public static EmployeeOrganization[] findBySubOrganizationId_PrevAndNext(
			long employeeOrganizationId, long subOrganizationId,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeOrganizationException {

		return getPersistence().findBySubOrganizationId_PrevAndNext(
			employeeOrganizationId, subOrganizationId, orderByComparator);
	}

	/**
	 * Removes all the employee organizations where subOrganizationId = &#63; from the database.
	 *
	 * @param subOrganizationId the sub organization ID
	 */
	public static void removeBySubOrganizationId(long subOrganizationId) {
		getPersistence().removeBySubOrganizationId(subOrganizationId);
	}

	/**
	 * Returns the number of employee organizations where subOrganizationId = &#63;.
	 *
	 * @param subOrganizationId the sub organization ID
	 * @return the number of matching employee organizations
	 */
	public static int countBySubOrganizationId(long subOrganizationId) {
		return getPersistence().countBySubOrganizationId(subOrganizationId);
	}

	/**
	 * Returns all the employee organizations where subOrganizationCode = &#63;.
	 *
	 * @param subOrganizationCode the sub organization code
	 * @return the matching employee organizations
	 */
	public static List<EmployeeOrganization> findBySubOrganizationCode(
		String subOrganizationCode) {

		return getPersistence().findBySubOrganizationCode(subOrganizationCode);
	}

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
	public static List<EmployeeOrganization> findBySubOrganizationCode(
		String subOrganizationCode, int start, int end) {

		return getPersistence().findBySubOrganizationCode(
			subOrganizationCode, start, end);
	}

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
	public static List<EmployeeOrganization> findBySubOrganizationCode(
		String subOrganizationCode, int start, int end,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		return getPersistence().findBySubOrganizationCode(
			subOrganizationCode, start, end, orderByComparator);
	}

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
	public static List<EmployeeOrganization> findBySubOrganizationCode(
		String subOrganizationCode, int start, int end,
		OrderByComparator<EmployeeOrganization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySubOrganizationCode(
			subOrganizationCode, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee organization in the ordered set where subOrganizationCode = &#63;.
	 *
	 * @param subOrganizationCode the sub organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	public static EmployeeOrganization findBySubOrganizationCode_First(
			String subOrganizationCode,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeOrganizationException {

		return getPersistence().findBySubOrganizationCode_First(
			subOrganizationCode, orderByComparator);
	}

	/**
	 * Returns the first employee organization in the ordered set where subOrganizationCode = &#63;.
	 *
	 * @param subOrganizationCode the sub organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	public static EmployeeOrganization fetchBySubOrganizationCode_First(
		String subOrganizationCode,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		return getPersistence().fetchBySubOrganizationCode_First(
			subOrganizationCode, orderByComparator);
	}

	/**
	 * Returns the last employee organization in the ordered set where subOrganizationCode = &#63;.
	 *
	 * @param subOrganizationCode the sub organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization
	 * @throws NoSuchEmployeeOrganizationException if a matching employee organization could not be found
	 */
	public static EmployeeOrganization findBySubOrganizationCode_Last(
			String subOrganizationCode,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeOrganizationException {

		return getPersistence().findBySubOrganizationCode_Last(
			subOrganizationCode, orderByComparator);
	}

	/**
	 * Returns the last employee organization in the ordered set where subOrganizationCode = &#63;.
	 *
	 * @param subOrganizationCode the sub organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee organization, or <code>null</code> if a matching employee organization could not be found
	 */
	public static EmployeeOrganization fetchBySubOrganizationCode_Last(
		String subOrganizationCode,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		return getPersistence().fetchBySubOrganizationCode_Last(
			subOrganizationCode, orderByComparator);
	}

	/**
	 * Returns the employee organizations before and after the current employee organization in the ordered set where subOrganizationCode = &#63;.
	 *
	 * @param employeeOrganizationId the primary key of the current employee organization
	 * @param subOrganizationCode the sub organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee organization
	 * @throws NoSuchEmployeeOrganizationException if a employee organization with the primary key could not be found
	 */
	public static EmployeeOrganization[] findBySubOrganizationCode_PrevAndNext(
			long employeeOrganizationId, String subOrganizationCode,
			OrderByComparator<EmployeeOrganization> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeOrganizationException {

		return getPersistence().findBySubOrganizationCode_PrevAndNext(
			employeeOrganizationId, subOrganizationCode, orderByComparator);
	}

	/**
	 * Removes all the employee organizations where subOrganizationCode = &#63; from the database.
	 *
	 * @param subOrganizationCode the sub organization code
	 */
	public static void removeBySubOrganizationCode(String subOrganizationCode) {
		getPersistence().removeBySubOrganizationCode(subOrganizationCode);
	}

	/**
	 * Returns the number of employee organizations where subOrganizationCode = &#63;.
	 *
	 * @param subOrganizationCode the sub organization code
	 * @return the number of matching employee organizations
	 */
	public static int countBySubOrganizationCode(String subOrganizationCode) {
		return getPersistence().countBySubOrganizationCode(subOrganizationCode);
	}

	/**
	 * Caches the employee organization in the entity cache if it is enabled.
	 *
	 * @param employeeOrganization the employee organization
	 */
	public static void cacheResult(EmployeeOrganization employeeOrganization) {
		getPersistence().cacheResult(employeeOrganization);
	}

	/**
	 * Caches the employee organizations in the entity cache if it is enabled.
	 *
	 * @param employeeOrganizations the employee organizations
	 */
	public static void cacheResult(
		List<EmployeeOrganization> employeeOrganizations) {

		getPersistence().cacheResult(employeeOrganizations);
	}

	/**
	 * Creates a new employee organization with the primary key. Does not add the employee organization to the database.
	 *
	 * @param employeeOrganizationId the primary key for the new employee organization
	 * @return the new employee organization
	 */
	public static EmployeeOrganization create(long employeeOrganizationId) {
		return getPersistence().create(employeeOrganizationId);
	}

	/**
	 * Removes the employee organization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeOrganizationId the primary key of the employee organization
	 * @return the employee organization that was removed
	 * @throws NoSuchEmployeeOrganizationException if a employee organization with the primary key could not be found
	 */
	public static EmployeeOrganization remove(long employeeOrganizationId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeOrganizationException {

		return getPersistence().remove(employeeOrganizationId);
	}

	public static EmployeeOrganization updateImpl(
		EmployeeOrganization employeeOrganization) {

		return getPersistence().updateImpl(employeeOrganization);
	}

	/**
	 * Returns the employee organization with the primary key or throws a <code>NoSuchEmployeeOrganizationException</code> if it could not be found.
	 *
	 * @param employeeOrganizationId the primary key of the employee organization
	 * @return the employee organization
	 * @throws NoSuchEmployeeOrganizationException if a employee organization with the primary key could not be found
	 */
	public static EmployeeOrganization findByPrimaryKey(
			long employeeOrganizationId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeOrganizationException {

		return getPersistence().findByPrimaryKey(employeeOrganizationId);
	}

	/**
	 * Returns the employee organization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeOrganizationId the primary key of the employee organization
	 * @return the employee organization, or <code>null</code> if a employee organization with the primary key could not be found
	 */
	public static EmployeeOrganization fetchByPrimaryKey(
		long employeeOrganizationId) {

		return getPersistence().fetchByPrimaryKey(employeeOrganizationId);
	}

	/**
	 * Returns all the employee organizations.
	 *
	 * @return the employee organizations
	 */
	public static List<EmployeeOrganization> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<EmployeeOrganization> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<EmployeeOrganization> findAll(
		int start, int end,
		OrderByComparator<EmployeeOrganization> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<EmployeeOrganization> findAll(
		int start, int end,
		OrderByComparator<EmployeeOrganization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee organizations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee organizations.
	 *
	 * @return the number of employee organizations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeOrganizationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeeOrganizationPersistence, EmployeeOrganizationPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EmployeeOrganizationPersistence.class);

		ServiceTracker
			<EmployeeOrganizationPersistence, EmployeeOrganizationPersistence>
				serviceTracker =
					new ServiceTracker
						<EmployeeOrganizationPersistence,
						 EmployeeOrganizationPersistence>(
							 bundle.getBundleContext(),
							 EmployeeOrganizationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}