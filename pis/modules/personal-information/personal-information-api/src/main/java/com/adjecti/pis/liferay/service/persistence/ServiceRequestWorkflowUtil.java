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

import com.adjecti.pis.liferay.model.ServiceRequestWorkflow;

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
 * The persistence utility for the service request workflow service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.ServiceRequestWorkflowPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServiceRequestWorkflowPersistence
 * @generated
 */
public class ServiceRequestWorkflowUtil {

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
		ServiceRequestWorkflow serviceRequestWorkflow) {

		getPersistence().clearCache(serviceRequestWorkflow);
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
	public static Map<Serializable, ServiceRequestWorkflow> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ServiceRequestWorkflow> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ServiceRequestWorkflow> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ServiceRequestWorkflow> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ServiceRequestWorkflow> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ServiceRequestWorkflow update(
		ServiceRequestWorkflow serviceRequestWorkflow) {

		return getPersistence().update(serviceRequestWorkflow);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ServiceRequestWorkflow update(
		ServiceRequestWorkflow serviceRequestWorkflow,
		ServiceContext serviceContext) {

		return getPersistence().update(serviceRequestWorkflow, serviceContext);
	}

	/**
	 * Returns all the service request workflows where serviceRequestId = &#63;.
	 *
	 * @param serviceRequestId the service request ID
	 * @return the matching service request workflows
	 */
	public static List<ServiceRequestWorkflow> findByServiceRequestId(
		long serviceRequestId) {

		return getPersistence().findByServiceRequestId(serviceRequestId);
	}

	/**
	 * Returns a range of all the service request workflows where serviceRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param serviceRequestId the service request ID
	 * @param start the lower bound of the range of service request workflows
	 * @param end the upper bound of the range of service request workflows (not inclusive)
	 * @return the range of matching service request workflows
	 */
	public static List<ServiceRequestWorkflow> findByServiceRequestId(
		long serviceRequestId, int start, int end) {

		return getPersistence().findByServiceRequestId(
			serviceRequestId, start, end);
	}

	/**
	 * Returns an ordered range of all the service request workflows where serviceRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param serviceRequestId the service request ID
	 * @param start the lower bound of the range of service request workflows
	 * @param end the upper bound of the range of service request workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service request workflows
	 */
	public static List<ServiceRequestWorkflow> findByServiceRequestId(
		long serviceRequestId, int start, int end,
		OrderByComparator<ServiceRequestWorkflow> orderByComparator) {

		return getPersistence().findByServiceRequestId(
			serviceRequestId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the service request workflows where serviceRequestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param serviceRequestId the service request ID
	 * @param start the lower bound of the range of service request workflows
	 * @param end the upper bound of the range of service request workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching service request workflows
	 */
	public static List<ServiceRequestWorkflow> findByServiceRequestId(
		long serviceRequestId, int start, int end,
		OrderByComparator<ServiceRequestWorkflow> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByServiceRequestId(
			serviceRequestId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first service request workflow in the ordered set where serviceRequestId = &#63;.
	 *
	 * @param serviceRequestId the service request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request workflow
	 * @throws NoSuchServiceRequestWorkflowException if a matching service request workflow could not be found
	 */
	public static ServiceRequestWorkflow findByServiceRequestId_First(
			long serviceRequestId,
			OrderByComparator<ServiceRequestWorkflow> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchServiceRequestWorkflowException {

		return getPersistence().findByServiceRequestId_First(
			serviceRequestId, orderByComparator);
	}

	/**
	 * Returns the first service request workflow in the ordered set where serviceRequestId = &#63;.
	 *
	 * @param serviceRequestId the service request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request workflow, or <code>null</code> if a matching service request workflow could not be found
	 */
	public static ServiceRequestWorkflow fetchByServiceRequestId_First(
		long serviceRequestId,
		OrderByComparator<ServiceRequestWorkflow> orderByComparator) {

		return getPersistence().fetchByServiceRequestId_First(
			serviceRequestId, orderByComparator);
	}

	/**
	 * Returns the last service request workflow in the ordered set where serviceRequestId = &#63;.
	 *
	 * @param serviceRequestId the service request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request workflow
	 * @throws NoSuchServiceRequestWorkflowException if a matching service request workflow could not be found
	 */
	public static ServiceRequestWorkflow findByServiceRequestId_Last(
			long serviceRequestId,
			OrderByComparator<ServiceRequestWorkflow> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchServiceRequestWorkflowException {

		return getPersistence().findByServiceRequestId_Last(
			serviceRequestId, orderByComparator);
	}

	/**
	 * Returns the last service request workflow in the ordered set where serviceRequestId = &#63;.
	 *
	 * @param serviceRequestId the service request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request workflow, or <code>null</code> if a matching service request workflow could not be found
	 */
	public static ServiceRequestWorkflow fetchByServiceRequestId_Last(
		long serviceRequestId,
		OrderByComparator<ServiceRequestWorkflow> orderByComparator) {

		return getPersistence().fetchByServiceRequestId_Last(
			serviceRequestId, orderByComparator);
	}

	/**
	 * Returns the service request workflows before and after the current service request workflow in the ordered set where serviceRequestId = &#63;.
	 *
	 * @param serviceRequestWorkflowId the primary key of the current service request workflow
	 * @param serviceRequestId the service request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service request workflow
	 * @throws NoSuchServiceRequestWorkflowException if a service request workflow with the primary key could not be found
	 */
	public static ServiceRequestWorkflow[] findByServiceRequestId_PrevAndNext(
			long serviceRequestWorkflowId, long serviceRequestId,
			OrderByComparator<ServiceRequestWorkflow> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchServiceRequestWorkflowException {

		return getPersistence().findByServiceRequestId_PrevAndNext(
			serviceRequestWorkflowId, serviceRequestId, orderByComparator);
	}

	/**
	 * Removes all the service request workflows where serviceRequestId = &#63; from the database.
	 *
	 * @param serviceRequestId the service request ID
	 */
	public static void removeByServiceRequestId(long serviceRequestId) {
		getPersistence().removeByServiceRequestId(serviceRequestId);
	}

	/**
	 * Returns the number of service request workflows where serviceRequestId = &#63;.
	 *
	 * @param serviceRequestId the service request ID
	 * @return the number of matching service request workflows
	 */
	public static int countByServiceRequestId(long serviceRequestId) {
		return getPersistence().countByServiceRequestId(serviceRequestId);
	}

	/**
	 * Returns all the service request workflows where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching service request workflows
	 */
	public static List<ServiceRequestWorkflow> findByEmployeeId(
		long employeeId) {

		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns a range of all the service request workflows where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of service request workflows
	 * @param end the upper bound of the range of service request workflows (not inclusive)
	 * @return the range of matching service request workflows
	 */
	public static List<ServiceRequestWorkflow> findByEmployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the service request workflows where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of service request workflows
	 * @param end the upper bound of the range of service request workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service request workflows
	 */
	public static List<ServiceRequestWorkflow> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<ServiceRequestWorkflow> orderByComparator) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the service request workflows where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of service request workflows
	 * @param end the upper bound of the range of service request workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching service request workflows
	 */
	public static List<ServiceRequestWorkflow> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<ServiceRequestWorkflow> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first service request workflow in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request workflow
	 * @throws NoSuchServiceRequestWorkflowException if a matching service request workflow could not be found
	 */
	public static ServiceRequestWorkflow findByEmployeeId_First(
			long employeeId,
			OrderByComparator<ServiceRequestWorkflow> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchServiceRequestWorkflowException {

		return getPersistence().findByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first service request workflow in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request workflow, or <code>null</code> if a matching service request workflow could not be found
	 */
	public static ServiceRequestWorkflow fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<ServiceRequestWorkflow> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last service request workflow in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request workflow
	 * @throws NoSuchServiceRequestWorkflowException if a matching service request workflow could not be found
	 */
	public static ServiceRequestWorkflow findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<ServiceRequestWorkflow> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchServiceRequestWorkflowException {

		return getPersistence().findByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last service request workflow in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request workflow, or <code>null</code> if a matching service request workflow could not be found
	 */
	public static ServiceRequestWorkflow fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<ServiceRequestWorkflow> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the service request workflows before and after the current service request workflow in the ordered set where employeeId = &#63;.
	 *
	 * @param serviceRequestWorkflowId the primary key of the current service request workflow
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service request workflow
	 * @throws NoSuchServiceRequestWorkflowException if a service request workflow with the primary key could not be found
	 */
	public static ServiceRequestWorkflow[] findByEmployeeId_PrevAndNext(
			long serviceRequestWorkflowId, long employeeId,
			OrderByComparator<ServiceRequestWorkflow> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchServiceRequestWorkflowException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			serviceRequestWorkflowId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the service request workflows where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of service request workflows where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching service request workflows
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Returns all the service request workflows where employeeId = &#63; and className = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param className the class name
	 * @return the matching service request workflows
	 */
	public static List<ServiceRequestWorkflow> findByEmployeeIdAndClassName(
		long employeeId, String className) {

		return getPersistence().findByEmployeeIdAndClassName(
			employeeId, className);
	}

	/**
	 * Returns a range of all the service request workflows where employeeId = &#63; and className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param className the class name
	 * @param start the lower bound of the range of service request workflows
	 * @param end the upper bound of the range of service request workflows (not inclusive)
	 * @return the range of matching service request workflows
	 */
	public static List<ServiceRequestWorkflow> findByEmployeeIdAndClassName(
		long employeeId, String className, int start, int end) {

		return getPersistence().findByEmployeeIdAndClassName(
			employeeId, className, start, end);
	}

	/**
	 * Returns an ordered range of all the service request workflows where employeeId = &#63; and className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param className the class name
	 * @param start the lower bound of the range of service request workflows
	 * @param end the upper bound of the range of service request workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service request workflows
	 */
	public static List<ServiceRequestWorkflow> findByEmployeeIdAndClassName(
		long employeeId, String className, int start, int end,
		OrderByComparator<ServiceRequestWorkflow> orderByComparator) {

		return getPersistence().findByEmployeeIdAndClassName(
			employeeId, className, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the service request workflows where employeeId = &#63; and className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param className the class name
	 * @param start the lower bound of the range of service request workflows
	 * @param end the upper bound of the range of service request workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching service request workflows
	 */
	public static List<ServiceRequestWorkflow> findByEmployeeIdAndClassName(
		long employeeId, String className, int start, int end,
		OrderByComparator<ServiceRequestWorkflow> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeIdAndClassName(
			employeeId, className, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first service request workflow in the ordered set where employeeId = &#63; and className = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request workflow
	 * @throws NoSuchServiceRequestWorkflowException if a matching service request workflow could not be found
	 */
	public static ServiceRequestWorkflow findByEmployeeIdAndClassName_First(
			long employeeId, String className,
			OrderByComparator<ServiceRequestWorkflow> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchServiceRequestWorkflowException {

		return getPersistence().findByEmployeeIdAndClassName_First(
			employeeId, className, orderByComparator);
	}

	/**
	 * Returns the first service request workflow in the ordered set where employeeId = &#63; and className = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request workflow, or <code>null</code> if a matching service request workflow could not be found
	 */
	public static ServiceRequestWorkflow fetchByEmployeeIdAndClassName_First(
		long employeeId, String className,
		OrderByComparator<ServiceRequestWorkflow> orderByComparator) {

		return getPersistence().fetchByEmployeeIdAndClassName_First(
			employeeId, className, orderByComparator);
	}

	/**
	 * Returns the last service request workflow in the ordered set where employeeId = &#63; and className = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request workflow
	 * @throws NoSuchServiceRequestWorkflowException if a matching service request workflow could not be found
	 */
	public static ServiceRequestWorkflow findByEmployeeIdAndClassName_Last(
			long employeeId, String className,
			OrderByComparator<ServiceRequestWorkflow> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchServiceRequestWorkflowException {

		return getPersistence().findByEmployeeIdAndClassName_Last(
			employeeId, className, orderByComparator);
	}

	/**
	 * Returns the last service request workflow in the ordered set where employeeId = &#63; and className = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request workflow, or <code>null</code> if a matching service request workflow could not be found
	 */
	public static ServiceRequestWorkflow fetchByEmployeeIdAndClassName_Last(
		long employeeId, String className,
		OrderByComparator<ServiceRequestWorkflow> orderByComparator) {

		return getPersistence().fetchByEmployeeIdAndClassName_Last(
			employeeId, className, orderByComparator);
	}

	/**
	 * Returns the service request workflows before and after the current service request workflow in the ordered set where employeeId = &#63; and className = &#63;.
	 *
	 * @param serviceRequestWorkflowId the primary key of the current service request workflow
	 * @param employeeId the employee ID
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service request workflow
	 * @throws NoSuchServiceRequestWorkflowException if a service request workflow with the primary key could not be found
	 */
	public static ServiceRequestWorkflow[]
			findByEmployeeIdAndClassName_PrevAndNext(
				long serviceRequestWorkflowId, long employeeId,
				String className,
				OrderByComparator<ServiceRequestWorkflow> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchServiceRequestWorkflowException {

		return getPersistence().findByEmployeeIdAndClassName_PrevAndNext(
			serviceRequestWorkflowId, employeeId, className, orderByComparator);
	}

	/**
	 * Removes all the service request workflows where employeeId = &#63; and className = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param className the class name
	 */
	public static void removeByEmployeeIdAndClassName(
		long employeeId, String className) {

		getPersistence().removeByEmployeeIdAndClassName(employeeId, className);
	}

	/**
	 * Returns the number of service request workflows where employeeId = &#63; and className = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param className the class name
	 * @return the number of matching service request workflows
	 */
	public static int countByEmployeeIdAndClassName(
		long employeeId, String className) {

		return getPersistence().countByEmployeeIdAndClassName(
			employeeId, className);
	}

	/**
	 * Caches the service request workflow in the entity cache if it is enabled.
	 *
	 * @param serviceRequestWorkflow the service request workflow
	 */
	public static void cacheResult(
		ServiceRequestWorkflow serviceRequestWorkflow) {

		getPersistence().cacheResult(serviceRequestWorkflow);
	}

	/**
	 * Caches the service request workflows in the entity cache if it is enabled.
	 *
	 * @param serviceRequestWorkflows the service request workflows
	 */
	public static void cacheResult(
		List<ServiceRequestWorkflow> serviceRequestWorkflows) {

		getPersistence().cacheResult(serviceRequestWorkflows);
	}

	/**
	 * Creates a new service request workflow with the primary key. Does not add the service request workflow to the database.
	 *
	 * @param serviceRequestWorkflowId the primary key for the new service request workflow
	 * @return the new service request workflow
	 */
	public static ServiceRequestWorkflow create(long serviceRequestWorkflowId) {
		return getPersistence().create(serviceRequestWorkflowId);
	}

	/**
	 * Removes the service request workflow with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param serviceRequestWorkflowId the primary key of the service request workflow
	 * @return the service request workflow that was removed
	 * @throws NoSuchServiceRequestWorkflowException if a service request workflow with the primary key could not be found
	 */
	public static ServiceRequestWorkflow remove(long serviceRequestWorkflowId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchServiceRequestWorkflowException {

		return getPersistence().remove(serviceRequestWorkflowId);
	}

	public static ServiceRequestWorkflow updateImpl(
		ServiceRequestWorkflow serviceRequestWorkflow) {

		return getPersistence().updateImpl(serviceRequestWorkflow);
	}

	/**
	 * Returns the service request workflow with the primary key or throws a <code>NoSuchServiceRequestWorkflowException</code> if it could not be found.
	 *
	 * @param serviceRequestWorkflowId the primary key of the service request workflow
	 * @return the service request workflow
	 * @throws NoSuchServiceRequestWorkflowException if a service request workflow with the primary key could not be found
	 */
	public static ServiceRequestWorkflow findByPrimaryKey(
			long serviceRequestWorkflowId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchServiceRequestWorkflowException {

		return getPersistence().findByPrimaryKey(serviceRequestWorkflowId);
	}

	/**
	 * Returns the service request workflow with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param serviceRequestWorkflowId the primary key of the service request workflow
	 * @return the service request workflow, or <code>null</code> if a service request workflow with the primary key could not be found
	 */
	public static ServiceRequestWorkflow fetchByPrimaryKey(
		long serviceRequestWorkflowId) {

		return getPersistence().fetchByPrimaryKey(serviceRequestWorkflowId);
	}

	/**
	 * Returns all the service request workflows.
	 *
	 * @return the service request workflows
	 */
	public static List<ServiceRequestWorkflow> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the service request workflows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request workflows
	 * @param end the upper bound of the range of service request workflows (not inclusive)
	 * @return the range of service request workflows
	 */
	public static List<ServiceRequestWorkflow> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the service request workflows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request workflows
	 * @param end the upper bound of the range of service request workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of service request workflows
	 */
	public static List<ServiceRequestWorkflow> findAll(
		int start, int end,
		OrderByComparator<ServiceRequestWorkflow> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the service request workflows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request workflows
	 * @param end the upper bound of the range of service request workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of service request workflows
	 */
	public static List<ServiceRequestWorkflow> findAll(
		int start, int end,
		OrderByComparator<ServiceRequestWorkflow> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the service request workflows from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of service request workflows.
	 *
	 * @return the number of service request workflows
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ServiceRequestWorkflowPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ServiceRequestWorkflowPersistence, ServiceRequestWorkflowPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ServiceRequestWorkflowPersistence.class);

		ServiceTracker
			<ServiceRequestWorkflowPersistence,
			 ServiceRequestWorkflowPersistence> serviceTracker =
				new ServiceTracker
					<ServiceRequestWorkflowPersistence,
					 ServiceRequestWorkflowPersistence>(
						 bundle.getBundleContext(),
						 ServiceRequestWorkflowPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}