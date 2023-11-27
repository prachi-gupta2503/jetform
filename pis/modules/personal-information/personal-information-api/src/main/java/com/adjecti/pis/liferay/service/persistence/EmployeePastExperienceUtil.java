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

import com.adjecti.pis.liferay.model.EmployeePastExperience;

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
 * The persistence utility for the employee past experience service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.EmployeePastExperiencePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeePastExperiencePersistence
 * @generated
 */
public class EmployeePastExperienceUtil {

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
		EmployeePastExperience employeePastExperience) {

		getPersistence().clearCache(employeePastExperience);
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
	public static Map<Serializable, EmployeePastExperience> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeePastExperience> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeePastExperience> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeePastExperience> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeePastExperience> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeePastExperience update(
		EmployeePastExperience employeePastExperience) {

		return getPersistence().update(employeePastExperience);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeePastExperience update(
		EmployeePastExperience employeePastExperience,
		ServiceContext serviceContext) {

		return getPersistence().update(employeePastExperience, serviceContext);
	}

	/**
	 * Returns all the employee past experiences where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee past experiences
	 */
	public static List<EmployeePastExperience> findByEmployeeId(
		long employeeId) {

		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns a range of all the employee past experiences where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePastExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee past experiences
	 * @param end the upper bound of the range of employee past experiences (not inclusive)
	 * @return the range of matching employee past experiences
	 */
	public static List<EmployeePastExperience> findByEmployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee past experiences where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePastExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee past experiences
	 * @param end the upper bound of the range of employee past experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee past experiences
	 */
	public static List<EmployeePastExperience> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeePastExperience> orderByComparator) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee past experiences where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePastExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee past experiences
	 * @param end the upper bound of the range of employee past experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee past experiences
	 */
	public static List<EmployeePastExperience> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeePastExperience> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee past experience in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee past experience
	 * @throws NoSuchEmployeePastExperienceException if a matching employee past experience could not be found
	 */
	public static EmployeePastExperience findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeePastExperience> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePastExperienceException {

		return getPersistence().findByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first employee past experience in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee past experience, or <code>null</code> if a matching employee past experience could not be found
	 */
	public static EmployeePastExperience fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<EmployeePastExperience> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee past experience in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee past experience
	 * @throws NoSuchEmployeePastExperienceException if a matching employee past experience could not be found
	 */
	public static EmployeePastExperience findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeePastExperience> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePastExperienceException {

		return getPersistence().findByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee past experience in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee past experience, or <code>null</code> if a matching employee past experience could not be found
	 */
	public static EmployeePastExperience fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<EmployeePastExperience> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the employee past experiences before and after the current employee past experience in the ordered set where employeeId = &#63;.
	 *
	 * @param employeePastExperienceId the primary key of the current employee past experience
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee past experience
	 * @throws NoSuchEmployeePastExperienceException if a employee past experience with the primary key could not be found
	 */
	public static EmployeePastExperience[] findByEmployeeId_PrevAndNext(
			long employeePastExperienceId, long employeeId,
			OrderByComparator<EmployeePastExperience> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePastExperienceException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			employeePastExperienceId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the employee past experiences where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of employee past experiences where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee past experiences
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Returns all the employee past experiences where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the matching employee past experiences
	 */
	public static List<EmployeePastExperience> findByJoiningProcessId(
		long joiningProcessId) {

		return getPersistence().findByJoiningProcessId(joiningProcessId);
	}

	/**
	 * Returns a range of all the employee past experiences where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePastExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of employee past experiences
	 * @param end the upper bound of the range of employee past experiences (not inclusive)
	 * @return the range of matching employee past experiences
	 */
	public static List<EmployeePastExperience> findByJoiningProcessId(
		long joiningProcessId, int start, int end) {

		return getPersistence().findByJoiningProcessId(
			joiningProcessId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee past experiences where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePastExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of employee past experiences
	 * @param end the upper bound of the range of employee past experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee past experiences
	 */
	public static List<EmployeePastExperience> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		OrderByComparator<EmployeePastExperience> orderByComparator) {

		return getPersistence().findByJoiningProcessId(
			joiningProcessId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee past experiences where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePastExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of employee past experiences
	 * @param end the upper bound of the range of employee past experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee past experiences
	 */
	public static List<EmployeePastExperience> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		OrderByComparator<EmployeePastExperience> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByJoiningProcessId(
			joiningProcessId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee past experience in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee past experience
	 * @throws NoSuchEmployeePastExperienceException if a matching employee past experience could not be found
	 */
	public static EmployeePastExperience findByJoiningProcessId_First(
			long joiningProcessId,
			OrderByComparator<EmployeePastExperience> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePastExperienceException {

		return getPersistence().findByJoiningProcessId_First(
			joiningProcessId, orderByComparator);
	}

	/**
	 * Returns the first employee past experience in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee past experience, or <code>null</code> if a matching employee past experience could not be found
	 */
	public static EmployeePastExperience fetchByJoiningProcessId_First(
		long joiningProcessId,
		OrderByComparator<EmployeePastExperience> orderByComparator) {

		return getPersistence().fetchByJoiningProcessId_First(
			joiningProcessId, orderByComparator);
	}

	/**
	 * Returns the last employee past experience in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee past experience
	 * @throws NoSuchEmployeePastExperienceException if a matching employee past experience could not be found
	 */
	public static EmployeePastExperience findByJoiningProcessId_Last(
			long joiningProcessId,
			OrderByComparator<EmployeePastExperience> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePastExperienceException {

		return getPersistence().findByJoiningProcessId_Last(
			joiningProcessId, orderByComparator);
	}

	/**
	 * Returns the last employee past experience in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee past experience, or <code>null</code> if a matching employee past experience could not be found
	 */
	public static EmployeePastExperience fetchByJoiningProcessId_Last(
		long joiningProcessId,
		OrderByComparator<EmployeePastExperience> orderByComparator) {

		return getPersistence().fetchByJoiningProcessId_Last(
			joiningProcessId, orderByComparator);
	}

	/**
	 * Returns the employee past experiences before and after the current employee past experience in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param employeePastExperienceId the primary key of the current employee past experience
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee past experience
	 * @throws NoSuchEmployeePastExperienceException if a employee past experience with the primary key could not be found
	 */
	public static EmployeePastExperience[] findByJoiningProcessId_PrevAndNext(
			long employeePastExperienceId, long joiningProcessId,
			OrderByComparator<EmployeePastExperience> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePastExperienceException {

		return getPersistence().findByJoiningProcessId_PrevAndNext(
			employeePastExperienceId, joiningProcessId, orderByComparator);
	}

	/**
	 * Removes all the employee past experiences where joiningProcessId = &#63; from the database.
	 *
	 * @param joiningProcessId the joining process ID
	 */
	public static void removeByJoiningProcessId(long joiningProcessId) {
		getPersistence().removeByJoiningProcessId(joiningProcessId);
	}

	/**
	 * Returns the number of employee past experiences where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the number of matching employee past experiences
	 */
	public static int countByJoiningProcessId(long joiningProcessId) {
		return getPersistence().countByJoiningProcessId(joiningProcessId);
	}

	/**
	 * Returns all the employee past experiences where workAreaId = &#63;.
	 *
	 * @param workAreaId the work area ID
	 * @return the matching employee past experiences
	 */
	public static List<EmployeePastExperience> findByWorkAreaId(
		long workAreaId) {

		return getPersistence().findByWorkAreaId(workAreaId);
	}

	/**
	 * Returns a range of all the employee past experiences where workAreaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePastExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param workAreaId the work area ID
	 * @param start the lower bound of the range of employee past experiences
	 * @param end the upper bound of the range of employee past experiences (not inclusive)
	 * @return the range of matching employee past experiences
	 */
	public static List<EmployeePastExperience> findByWorkAreaId(
		long workAreaId, int start, int end) {

		return getPersistence().findByWorkAreaId(workAreaId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee past experiences where workAreaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePastExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param workAreaId the work area ID
	 * @param start the lower bound of the range of employee past experiences
	 * @param end the upper bound of the range of employee past experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee past experiences
	 */
	public static List<EmployeePastExperience> findByWorkAreaId(
		long workAreaId, int start, int end,
		OrderByComparator<EmployeePastExperience> orderByComparator) {

		return getPersistence().findByWorkAreaId(
			workAreaId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee past experiences where workAreaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePastExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param workAreaId the work area ID
	 * @param start the lower bound of the range of employee past experiences
	 * @param end the upper bound of the range of employee past experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee past experiences
	 */
	public static List<EmployeePastExperience> findByWorkAreaId(
		long workAreaId, int start, int end,
		OrderByComparator<EmployeePastExperience> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByWorkAreaId(
			workAreaId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee past experience in the ordered set where workAreaId = &#63;.
	 *
	 * @param workAreaId the work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee past experience
	 * @throws NoSuchEmployeePastExperienceException if a matching employee past experience could not be found
	 */
	public static EmployeePastExperience findByWorkAreaId_First(
			long workAreaId,
			OrderByComparator<EmployeePastExperience> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePastExperienceException {

		return getPersistence().findByWorkAreaId_First(
			workAreaId, orderByComparator);
	}

	/**
	 * Returns the first employee past experience in the ordered set where workAreaId = &#63;.
	 *
	 * @param workAreaId the work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee past experience, or <code>null</code> if a matching employee past experience could not be found
	 */
	public static EmployeePastExperience fetchByWorkAreaId_First(
		long workAreaId,
		OrderByComparator<EmployeePastExperience> orderByComparator) {

		return getPersistence().fetchByWorkAreaId_First(
			workAreaId, orderByComparator);
	}

	/**
	 * Returns the last employee past experience in the ordered set where workAreaId = &#63;.
	 *
	 * @param workAreaId the work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee past experience
	 * @throws NoSuchEmployeePastExperienceException if a matching employee past experience could not be found
	 */
	public static EmployeePastExperience findByWorkAreaId_Last(
			long workAreaId,
			OrderByComparator<EmployeePastExperience> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePastExperienceException {

		return getPersistence().findByWorkAreaId_Last(
			workAreaId, orderByComparator);
	}

	/**
	 * Returns the last employee past experience in the ordered set where workAreaId = &#63;.
	 *
	 * @param workAreaId the work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee past experience, or <code>null</code> if a matching employee past experience could not be found
	 */
	public static EmployeePastExperience fetchByWorkAreaId_Last(
		long workAreaId,
		OrderByComparator<EmployeePastExperience> orderByComparator) {

		return getPersistence().fetchByWorkAreaId_Last(
			workAreaId, orderByComparator);
	}

	/**
	 * Returns the employee past experiences before and after the current employee past experience in the ordered set where workAreaId = &#63;.
	 *
	 * @param employeePastExperienceId the primary key of the current employee past experience
	 * @param workAreaId the work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee past experience
	 * @throws NoSuchEmployeePastExperienceException if a employee past experience with the primary key could not be found
	 */
	public static EmployeePastExperience[] findByWorkAreaId_PrevAndNext(
			long employeePastExperienceId, long workAreaId,
			OrderByComparator<EmployeePastExperience> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePastExperienceException {

		return getPersistence().findByWorkAreaId_PrevAndNext(
			employeePastExperienceId, workAreaId, orderByComparator);
	}

	/**
	 * Removes all the employee past experiences where workAreaId = &#63; from the database.
	 *
	 * @param workAreaId the work area ID
	 */
	public static void removeByWorkAreaId(long workAreaId) {
		getPersistence().removeByWorkAreaId(workAreaId);
	}

	/**
	 * Returns the number of employee past experiences where workAreaId = &#63;.
	 *
	 * @param workAreaId the work area ID
	 * @return the number of matching employee past experiences
	 */
	public static int countByWorkAreaId(long workAreaId) {
		return getPersistence().countByWorkAreaId(workAreaId);
	}

	/**
	 * Caches the employee past experience in the entity cache if it is enabled.
	 *
	 * @param employeePastExperience the employee past experience
	 */
	public static void cacheResult(
		EmployeePastExperience employeePastExperience) {

		getPersistence().cacheResult(employeePastExperience);
	}

	/**
	 * Caches the employee past experiences in the entity cache if it is enabled.
	 *
	 * @param employeePastExperiences the employee past experiences
	 */
	public static void cacheResult(
		List<EmployeePastExperience> employeePastExperiences) {

		getPersistence().cacheResult(employeePastExperiences);
	}

	/**
	 * Creates a new employee past experience with the primary key. Does not add the employee past experience to the database.
	 *
	 * @param employeePastExperienceId the primary key for the new employee past experience
	 * @return the new employee past experience
	 */
	public static EmployeePastExperience create(long employeePastExperienceId) {
		return getPersistence().create(employeePastExperienceId);
	}

	/**
	 * Removes the employee past experience with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeePastExperienceId the primary key of the employee past experience
	 * @return the employee past experience that was removed
	 * @throws NoSuchEmployeePastExperienceException if a employee past experience with the primary key could not be found
	 */
	public static EmployeePastExperience remove(long employeePastExperienceId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePastExperienceException {

		return getPersistence().remove(employeePastExperienceId);
	}

	public static EmployeePastExperience updateImpl(
		EmployeePastExperience employeePastExperience) {

		return getPersistence().updateImpl(employeePastExperience);
	}

	/**
	 * Returns the employee past experience with the primary key or throws a <code>NoSuchEmployeePastExperienceException</code> if it could not be found.
	 *
	 * @param employeePastExperienceId the primary key of the employee past experience
	 * @return the employee past experience
	 * @throws NoSuchEmployeePastExperienceException if a employee past experience with the primary key could not be found
	 */
	public static EmployeePastExperience findByPrimaryKey(
			long employeePastExperienceId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePastExperienceException {

		return getPersistence().findByPrimaryKey(employeePastExperienceId);
	}

	/**
	 * Returns the employee past experience with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeePastExperienceId the primary key of the employee past experience
	 * @return the employee past experience, or <code>null</code> if a employee past experience with the primary key could not be found
	 */
	public static EmployeePastExperience fetchByPrimaryKey(
		long employeePastExperienceId) {

		return getPersistence().fetchByPrimaryKey(employeePastExperienceId);
	}

	/**
	 * Returns all the employee past experiences.
	 *
	 * @return the employee past experiences
	 */
	public static List<EmployeePastExperience> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employee past experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePastExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee past experiences
	 * @param end the upper bound of the range of employee past experiences (not inclusive)
	 * @return the range of employee past experiences
	 */
	public static List<EmployeePastExperience> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employee past experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePastExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee past experiences
	 * @param end the upper bound of the range of employee past experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee past experiences
	 */
	public static List<EmployeePastExperience> findAll(
		int start, int end,
		OrderByComparator<EmployeePastExperience> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee past experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePastExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee past experiences
	 * @param end the upper bound of the range of employee past experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee past experiences
	 */
	public static List<EmployeePastExperience> findAll(
		int start, int end,
		OrderByComparator<EmployeePastExperience> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee past experiences from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee past experiences.
	 *
	 * @return the number of employee past experiences
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeePastExperiencePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeePastExperiencePersistence, EmployeePastExperiencePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EmployeePastExperiencePersistence.class);

		ServiceTracker
			<EmployeePastExperiencePersistence,
			 EmployeePastExperiencePersistence> serviceTracker =
				new ServiceTracker
					<EmployeePastExperiencePersistence,
					 EmployeePastExperiencePersistence>(
						 bundle.getBundleContext(),
						 EmployeePastExperiencePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}