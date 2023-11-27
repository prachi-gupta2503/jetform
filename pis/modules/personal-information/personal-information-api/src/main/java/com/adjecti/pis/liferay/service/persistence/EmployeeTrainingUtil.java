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

import com.adjecti.pis.liferay.model.EmployeeTraining;

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
 * The persistence utility for the employee training service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.EmployeeTrainingPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeTrainingPersistence
 * @generated
 */
public class EmployeeTrainingUtil {

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
	public static void clearCache(EmployeeTraining employeeTraining) {
		getPersistence().clearCache(employeeTraining);
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
	public static Map<Serializable, EmployeeTraining> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeTraining> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeTraining> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeTraining> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeTraining> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeTraining update(EmployeeTraining employeeTraining) {
		return getPersistence().update(employeeTraining);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeTraining update(
		EmployeeTraining employeeTraining, ServiceContext serviceContext) {

		return getPersistence().update(employeeTraining, serviceContext);
	}

	/**
	 * Returns all the employee trainings where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee trainings
	 */
	public static List<EmployeeTraining> findByEmployeeId(long employeeId) {
		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns a range of all the employee trainings where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee trainings
	 * @param end the upper bound of the range of employee trainings (not inclusive)
	 * @return the range of matching employee trainings
	 */
	public static List<EmployeeTraining> findByEmployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee trainings where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee trainings
	 * @param end the upper bound of the range of employee trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee trainings
	 */
	public static List<EmployeeTraining> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeTraining> orderByComparator) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee trainings where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee trainings
	 * @param end the upper bound of the range of employee trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee trainings
	 */
	public static List<EmployeeTraining> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeTraining> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee training in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee training
	 * @throws NoSuchEmployeeTrainingException if a matching employee training could not be found
	 */
	public static EmployeeTraining findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeTraining> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeTrainingException {

		return getPersistence().findByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first employee training in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee training, or <code>null</code> if a matching employee training could not be found
	 */
	public static EmployeeTraining fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<EmployeeTraining> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee training in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee training
	 * @throws NoSuchEmployeeTrainingException if a matching employee training could not be found
	 */
	public static EmployeeTraining findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeTraining> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeTrainingException {

		return getPersistence().findByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee training in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee training, or <code>null</code> if a matching employee training could not be found
	 */
	public static EmployeeTraining fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<EmployeeTraining> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the employee trainings before and after the current employee training in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeTrainingId the primary key of the current employee training
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee training
	 * @throws NoSuchEmployeeTrainingException if a employee training with the primary key could not be found
	 */
	public static EmployeeTraining[] findByEmployeeId_PrevAndNext(
			long employeeTrainingId, long employeeId,
			OrderByComparator<EmployeeTraining> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeTrainingException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			employeeTrainingId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the employee trainings where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of employee trainings where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee trainings
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Returns all the employee trainings where instituteId = &#63;.
	 *
	 * @param instituteId the institute ID
	 * @return the matching employee trainings
	 */
	public static List<EmployeeTraining> findByInstituteId(long instituteId) {
		return getPersistence().findByInstituteId(instituteId);
	}

	/**
	 * Returns a range of all the employee trainings where instituteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param instituteId the institute ID
	 * @param start the lower bound of the range of employee trainings
	 * @param end the upper bound of the range of employee trainings (not inclusive)
	 * @return the range of matching employee trainings
	 */
	public static List<EmployeeTraining> findByInstituteId(
		long instituteId, int start, int end) {

		return getPersistence().findByInstituteId(instituteId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee trainings where instituteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param instituteId the institute ID
	 * @param start the lower bound of the range of employee trainings
	 * @param end the upper bound of the range of employee trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee trainings
	 */
	public static List<EmployeeTraining> findByInstituteId(
		long instituteId, int start, int end,
		OrderByComparator<EmployeeTraining> orderByComparator) {

		return getPersistence().findByInstituteId(
			instituteId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee trainings where instituteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param instituteId the institute ID
	 * @param start the lower bound of the range of employee trainings
	 * @param end the upper bound of the range of employee trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee trainings
	 */
	public static List<EmployeeTraining> findByInstituteId(
		long instituteId, int start, int end,
		OrderByComparator<EmployeeTraining> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByInstituteId(
			instituteId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee training in the ordered set where instituteId = &#63;.
	 *
	 * @param instituteId the institute ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee training
	 * @throws NoSuchEmployeeTrainingException if a matching employee training could not be found
	 */
	public static EmployeeTraining findByInstituteId_First(
			long instituteId,
			OrderByComparator<EmployeeTraining> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeTrainingException {

		return getPersistence().findByInstituteId_First(
			instituteId, orderByComparator);
	}

	/**
	 * Returns the first employee training in the ordered set where instituteId = &#63;.
	 *
	 * @param instituteId the institute ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee training, or <code>null</code> if a matching employee training could not be found
	 */
	public static EmployeeTraining fetchByInstituteId_First(
		long instituteId,
		OrderByComparator<EmployeeTraining> orderByComparator) {

		return getPersistence().fetchByInstituteId_First(
			instituteId, orderByComparator);
	}

	/**
	 * Returns the last employee training in the ordered set where instituteId = &#63;.
	 *
	 * @param instituteId the institute ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee training
	 * @throws NoSuchEmployeeTrainingException if a matching employee training could not be found
	 */
	public static EmployeeTraining findByInstituteId_Last(
			long instituteId,
			OrderByComparator<EmployeeTraining> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeTrainingException {

		return getPersistence().findByInstituteId_Last(
			instituteId, orderByComparator);
	}

	/**
	 * Returns the last employee training in the ordered set where instituteId = &#63;.
	 *
	 * @param instituteId the institute ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee training, or <code>null</code> if a matching employee training could not be found
	 */
	public static EmployeeTraining fetchByInstituteId_Last(
		long instituteId,
		OrderByComparator<EmployeeTraining> orderByComparator) {

		return getPersistence().fetchByInstituteId_Last(
			instituteId, orderByComparator);
	}

	/**
	 * Returns the employee trainings before and after the current employee training in the ordered set where instituteId = &#63;.
	 *
	 * @param employeeTrainingId the primary key of the current employee training
	 * @param instituteId the institute ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee training
	 * @throws NoSuchEmployeeTrainingException if a employee training with the primary key could not be found
	 */
	public static EmployeeTraining[] findByInstituteId_PrevAndNext(
			long employeeTrainingId, long instituteId,
			OrderByComparator<EmployeeTraining> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeTrainingException {

		return getPersistence().findByInstituteId_PrevAndNext(
			employeeTrainingId, instituteId, orderByComparator);
	}

	/**
	 * Removes all the employee trainings where instituteId = &#63; from the database.
	 *
	 * @param instituteId the institute ID
	 */
	public static void removeByInstituteId(long instituteId) {
		getPersistence().removeByInstituteId(instituteId);
	}

	/**
	 * Returns the number of employee trainings where instituteId = &#63;.
	 *
	 * @param instituteId the institute ID
	 * @return the number of matching employee trainings
	 */
	public static int countByInstituteId(long instituteId) {
		return getPersistence().countByInstituteId(instituteId);
	}

	/**
	 * Returns all the employee trainings where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching employee trainings
	 */
	public static List<EmployeeTraining> findByOrganizationId(
		long organizationId) {

		return getPersistence().findByOrganizationId(organizationId);
	}

	/**
	 * Returns a range of all the employee trainings where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee trainings
	 * @param end the upper bound of the range of employee trainings (not inclusive)
	 * @return the range of matching employee trainings
	 */
	public static List<EmployeeTraining> findByOrganizationId(
		long organizationId, int start, int end) {

		return getPersistence().findByOrganizationId(
			organizationId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee trainings where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee trainings
	 * @param end the upper bound of the range of employee trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee trainings
	 */
	public static List<EmployeeTraining> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<EmployeeTraining> orderByComparator) {

		return getPersistence().findByOrganizationId(
			organizationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee trainings where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee trainings
	 * @param end the upper bound of the range of employee trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee trainings
	 */
	public static List<EmployeeTraining> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<EmployeeTraining> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByOrganizationId(
			organizationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee training in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee training
	 * @throws NoSuchEmployeeTrainingException if a matching employee training could not be found
	 */
	public static EmployeeTraining findByOrganizationId_First(
			long organizationId,
			OrderByComparator<EmployeeTraining> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeTrainingException {

		return getPersistence().findByOrganizationId_First(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the first employee training in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee training, or <code>null</code> if a matching employee training could not be found
	 */
	public static EmployeeTraining fetchByOrganizationId_First(
		long organizationId,
		OrderByComparator<EmployeeTraining> orderByComparator) {

		return getPersistence().fetchByOrganizationId_First(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the last employee training in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee training
	 * @throws NoSuchEmployeeTrainingException if a matching employee training could not be found
	 */
	public static EmployeeTraining findByOrganizationId_Last(
			long organizationId,
			OrderByComparator<EmployeeTraining> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeTrainingException {

		return getPersistence().findByOrganizationId_Last(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the last employee training in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee training, or <code>null</code> if a matching employee training could not be found
	 */
	public static EmployeeTraining fetchByOrganizationId_Last(
		long organizationId,
		OrderByComparator<EmployeeTraining> orderByComparator) {

		return getPersistence().fetchByOrganizationId_Last(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the employee trainings before and after the current employee training in the ordered set where organizationId = &#63;.
	 *
	 * @param employeeTrainingId the primary key of the current employee training
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee training
	 * @throws NoSuchEmployeeTrainingException if a employee training with the primary key could not be found
	 */
	public static EmployeeTraining[] findByOrganizationId_PrevAndNext(
			long employeeTrainingId, long organizationId,
			OrderByComparator<EmployeeTraining> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeTrainingException {

		return getPersistence().findByOrganizationId_PrevAndNext(
			employeeTrainingId, organizationId, orderByComparator);
	}

	/**
	 * Removes all the employee trainings where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	public static void removeByOrganizationId(long organizationId) {
		getPersistence().removeByOrganizationId(organizationId);
	}

	/**
	 * Returns the number of employee trainings where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching employee trainings
	 */
	public static int countByOrganizationId(long organizationId) {
		return getPersistence().countByOrganizationId(organizationId);
	}

	/**
	 * Caches the employee training in the entity cache if it is enabled.
	 *
	 * @param employeeTraining the employee training
	 */
	public static void cacheResult(EmployeeTraining employeeTraining) {
		getPersistence().cacheResult(employeeTraining);
	}

	/**
	 * Caches the employee trainings in the entity cache if it is enabled.
	 *
	 * @param employeeTrainings the employee trainings
	 */
	public static void cacheResult(List<EmployeeTraining> employeeTrainings) {
		getPersistence().cacheResult(employeeTrainings);
	}

	/**
	 * Creates a new employee training with the primary key. Does not add the employee training to the database.
	 *
	 * @param employeeTrainingId the primary key for the new employee training
	 * @return the new employee training
	 */
	public static EmployeeTraining create(long employeeTrainingId) {
		return getPersistence().create(employeeTrainingId);
	}

	/**
	 * Removes the employee training with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeTrainingId the primary key of the employee training
	 * @return the employee training that was removed
	 * @throws NoSuchEmployeeTrainingException if a employee training with the primary key could not be found
	 */
	public static EmployeeTraining remove(long employeeTrainingId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeTrainingException {

		return getPersistence().remove(employeeTrainingId);
	}

	public static EmployeeTraining updateImpl(
		EmployeeTraining employeeTraining) {

		return getPersistence().updateImpl(employeeTraining);
	}

	/**
	 * Returns the employee training with the primary key or throws a <code>NoSuchEmployeeTrainingException</code> if it could not be found.
	 *
	 * @param employeeTrainingId the primary key of the employee training
	 * @return the employee training
	 * @throws NoSuchEmployeeTrainingException if a employee training with the primary key could not be found
	 */
	public static EmployeeTraining findByPrimaryKey(long employeeTrainingId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeTrainingException {

		return getPersistence().findByPrimaryKey(employeeTrainingId);
	}

	/**
	 * Returns the employee training with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeTrainingId the primary key of the employee training
	 * @return the employee training, or <code>null</code> if a employee training with the primary key could not be found
	 */
	public static EmployeeTraining fetchByPrimaryKey(long employeeTrainingId) {
		return getPersistence().fetchByPrimaryKey(employeeTrainingId);
	}

	/**
	 * Returns all the employee trainings.
	 *
	 * @return the employee trainings
	 */
	public static List<EmployeeTraining> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employee trainings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee trainings
	 * @param end the upper bound of the range of employee trainings (not inclusive)
	 * @return the range of employee trainings
	 */
	public static List<EmployeeTraining> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employee trainings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee trainings
	 * @param end the upper bound of the range of employee trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee trainings
	 */
	public static List<EmployeeTraining> findAll(
		int start, int end,
		OrderByComparator<EmployeeTraining> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee trainings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTrainingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee trainings
	 * @param end the upper bound of the range of employee trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee trainings
	 */
	public static List<EmployeeTraining> findAll(
		int start, int end,
		OrderByComparator<EmployeeTraining> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee trainings from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee trainings.
	 *
	 * @return the number of employee trainings
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeTrainingPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeeTrainingPersistence, EmployeeTrainingPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EmployeeTrainingPersistence.class);

		ServiceTracker<EmployeeTrainingPersistence, EmployeeTrainingPersistence>
			serviceTracker =
				new ServiceTracker
					<EmployeeTrainingPersistence, EmployeeTrainingPersistence>(
						bundle.getBundleContext(),
						EmployeeTrainingPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}