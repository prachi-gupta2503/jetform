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

import com.adjecti.pis.liferay.model.ServiceRequest;

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
 * The persistence utility for the service request service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.ServiceRequestPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServiceRequestPersistence
 * @generated
 */
public class ServiceRequestUtil {

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
	public static void clearCache(ServiceRequest serviceRequest) {
		getPersistence().clearCache(serviceRequest);
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
	public static Map<Serializable, ServiceRequest> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ServiceRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ServiceRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ServiceRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ServiceRequest> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ServiceRequest update(ServiceRequest serviceRequest) {
		return getPersistence().update(serviceRequest);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ServiceRequest update(
		ServiceRequest serviceRequest, ServiceContext serviceContext) {

		return getPersistence().update(serviceRequest, serviceContext);
	}

	/**
	 * Returns all the service requests where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching service requests
	 */
	public static List<ServiceRequest> findByEmployeeId(long employeeId) {
		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns a range of all the service requests where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of service requests
	 * @param end the upper bound of the range of service requests (not inclusive)
	 * @return the range of matching service requests
	 */
	public static List<ServiceRequest> findByEmployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the service requests where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of service requests
	 * @param end the upper bound of the range of service requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service requests
	 */
	public static List<ServiceRequest> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<ServiceRequest> orderByComparator) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the service requests where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of service requests
	 * @param end the upper bound of the range of service requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching service requests
	 */
	public static List<ServiceRequest> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<ServiceRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first service request in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request
	 * @throws NoSuchServiceRequestException if a matching service request could not be found
	 */
	public static ServiceRequest findByEmployeeId_First(
			long employeeId,
			OrderByComparator<ServiceRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchServiceRequestException {

		return getPersistence().findByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first service request in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request, or <code>null</code> if a matching service request could not be found
	 */
	public static ServiceRequest fetchByEmployeeId_First(
		long employeeId, OrderByComparator<ServiceRequest> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last service request in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request
	 * @throws NoSuchServiceRequestException if a matching service request could not be found
	 */
	public static ServiceRequest findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<ServiceRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchServiceRequestException {

		return getPersistence().findByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last service request in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request, or <code>null</code> if a matching service request could not be found
	 */
	public static ServiceRequest fetchByEmployeeId_Last(
		long employeeId, OrderByComparator<ServiceRequest> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the service requests before and after the current service request in the ordered set where employeeId = &#63;.
	 *
	 * @param serviceRequestId the primary key of the current service request
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service request
	 * @throws NoSuchServiceRequestException if a service request with the primary key could not be found
	 */
	public static ServiceRequest[] findByEmployeeId_PrevAndNext(
			long serviceRequestId, long employeeId,
			OrderByComparator<ServiceRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchServiceRequestException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			serviceRequestId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the service requests where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of service requests where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching service requests
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Returns all the service requests where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the matching service requests
	 */
	public static List<ServiceRequest> findByJoiningProcessId(
		Long joiningProcessId) {

		return getPersistence().findByJoiningProcessId(joiningProcessId);
	}

	/**
	 * Returns a range of all the service requests where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of service requests
	 * @param end the upper bound of the range of service requests (not inclusive)
	 * @return the range of matching service requests
	 */
	public static List<ServiceRequest> findByJoiningProcessId(
		Long joiningProcessId, int start, int end) {

		return getPersistence().findByJoiningProcessId(
			joiningProcessId, start, end);
	}

	/**
	 * Returns an ordered range of all the service requests where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of service requests
	 * @param end the upper bound of the range of service requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service requests
	 */
	public static List<ServiceRequest> findByJoiningProcessId(
		Long joiningProcessId, int start, int end,
		OrderByComparator<ServiceRequest> orderByComparator) {

		return getPersistence().findByJoiningProcessId(
			joiningProcessId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the service requests where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of service requests
	 * @param end the upper bound of the range of service requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching service requests
	 */
	public static List<ServiceRequest> findByJoiningProcessId(
		Long joiningProcessId, int start, int end,
		OrderByComparator<ServiceRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByJoiningProcessId(
			joiningProcessId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first service request in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request
	 * @throws NoSuchServiceRequestException if a matching service request could not be found
	 */
	public static ServiceRequest findByJoiningProcessId_First(
			Long joiningProcessId,
			OrderByComparator<ServiceRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchServiceRequestException {

		return getPersistence().findByJoiningProcessId_First(
			joiningProcessId, orderByComparator);
	}

	/**
	 * Returns the first service request in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request, or <code>null</code> if a matching service request could not be found
	 */
	public static ServiceRequest fetchByJoiningProcessId_First(
		Long joiningProcessId,
		OrderByComparator<ServiceRequest> orderByComparator) {

		return getPersistence().fetchByJoiningProcessId_First(
			joiningProcessId, orderByComparator);
	}

	/**
	 * Returns the last service request in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request
	 * @throws NoSuchServiceRequestException if a matching service request could not be found
	 */
	public static ServiceRequest findByJoiningProcessId_Last(
			Long joiningProcessId,
			OrderByComparator<ServiceRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchServiceRequestException {

		return getPersistence().findByJoiningProcessId_Last(
			joiningProcessId, orderByComparator);
	}

	/**
	 * Returns the last service request in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request, or <code>null</code> if a matching service request could not be found
	 */
	public static ServiceRequest fetchByJoiningProcessId_Last(
		Long joiningProcessId,
		OrderByComparator<ServiceRequest> orderByComparator) {

		return getPersistence().fetchByJoiningProcessId_Last(
			joiningProcessId, orderByComparator);
	}

	/**
	 * Returns the service requests before and after the current service request in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param serviceRequestId the primary key of the current service request
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service request
	 * @throws NoSuchServiceRequestException if a service request with the primary key could not be found
	 */
	public static ServiceRequest[] findByJoiningProcessId_PrevAndNext(
			long serviceRequestId, Long joiningProcessId,
			OrderByComparator<ServiceRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchServiceRequestException {

		return getPersistence().findByJoiningProcessId_PrevAndNext(
			serviceRequestId, joiningProcessId, orderByComparator);
	}

	/**
	 * Removes all the service requests where joiningProcessId = &#63; from the database.
	 *
	 * @param joiningProcessId the joining process ID
	 */
	public static void removeByJoiningProcessId(Long joiningProcessId) {
		getPersistence().removeByJoiningProcessId(joiningProcessId);
	}

	/**
	 * Returns the number of service requests where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the number of matching service requests
	 */
	public static int countByJoiningProcessId(Long joiningProcessId) {
		return getPersistence().countByJoiningProcessId(joiningProcessId);
	}

	/**
	 * Returns all the service requests where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching service requests
	 */
	public static List<ServiceRequest> findByStatus(int status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the service requests where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of service requests
	 * @param end the upper bound of the range of service requests (not inclusive)
	 * @return the range of matching service requests
	 */
	public static List<ServiceRequest> findByStatus(
		int status, int start, int end) {

		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the service requests where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of service requests
	 * @param end the upper bound of the range of service requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service requests
	 */
	public static List<ServiceRequest> findByStatus(
		int status, int start, int end,
		OrderByComparator<ServiceRequest> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the service requests where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of service requests
	 * @param end the upper bound of the range of service requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching service requests
	 */
	public static List<ServiceRequest> findByStatus(
		int status, int start, int end,
		OrderByComparator<ServiceRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first service request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request
	 * @throws NoSuchServiceRequestException if a matching service request could not be found
	 */
	public static ServiceRequest findByStatus_First(
			int status, OrderByComparator<ServiceRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchServiceRequestException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first service request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request, or <code>null</code> if a matching service request could not be found
	 */
	public static ServiceRequest fetchByStatus_First(
		int status, OrderByComparator<ServiceRequest> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last service request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request
	 * @throws NoSuchServiceRequestException if a matching service request could not be found
	 */
	public static ServiceRequest findByStatus_Last(
			int status, OrderByComparator<ServiceRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchServiceRequestException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last service request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request, or <code>null</code> if a matching service request could not be found
	 */
	public static ServiceRequest fetchByStatus_Last(
		int status, OrderByComparator<ServiceRequest> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the service requests before and after the current service request in the ordered set where status = &#63;.
	 *
	 * @param serviceRequestId the primary key of the current service request
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service request
	 * @throws NoSuchServiceRequestException if a service request with the primary key could not be found
	 */
	public static ServiceRequest[] findByStatus_PrevAndNext(
			long serviceRequestId, int status,
			OrderByComparator<ServiceRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchServiceRequestException {

		return getPersistence().findByStatus_PrevAndNext(
			serviceRequestId, status, orderByComparator);
	}

	/**
	 * Removes all the service requests where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of service requests where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching service requests
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns all the service requests where status = &#63; and organizationId = &#63;.
	 *
	 * @param status the status
	 * @param organizationId the organization ID
	 * @return the matching service requests
	 */
	public static List<ServiceRequest> findByStatusAndOrganization(
		int status, long organizationId) {

		return getPersistence().findByStatusAndOrganization(
			status, organizationId);
	}

	/**
	 * Returns a range of all the service requests where status = &#63; and organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of service requests
	 * @param end the upper bound of the range of service requests (not inclusive)
	 * @return the range of matching service requests
	 */
	public static List<ServiceRequest> findByStatusAndOrganization(
		int status, long organizationId, int start, int end) {

		return getPersistence().findByStatusAndOrganization(
			status, organizationId, start, end);
	}

	/**
	 * Returns an ordered range of all the service requests where status = &#63; and organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of service requests
	 * @param end the upper bound of the range of service requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service requests
	 */
	public static List<ServiceRequest> findByStatusAndOrganization(
		int status, long organizationId, int start, int end,
		OrderByComparator<ServiceRequest> orderByComparator) {

		return getPersistence().findByStatusAndOrganization(
			status, organizationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the service requests where status = &#63; and organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of service requests
	 * @param end the upper bound of the range of service requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching service requests
	 */
	public static List<ServiceRequest> findByStatusAndOrganization(
		int status, long organizationId, int start, int end,
		OrderByComparator<ServiceRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatusAndOrganization(
			status, organizationId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first service request in the ordered set where status = &#63; and organizationId = &#63;.
	 *
	 * @param status the status
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request
	 * @throws NoSuchServiceRequestException if a matching service request could not be found
	 */
	public static ServiceRequest findByStatusAndOrganization_First(
			int status, long organizationId,
			OrderByComparator<ServiceRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchServiceRequestException {

		return getPersistence().findByStatusAndOrganization_First(
			status, organizationId, orderByComparator);
	}

	/**
	 * Returns the first service request in the ordered set where status = &#63; and organizationId = &#63;.
	 *
	 * @param status the status
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request, or <code>null</code> if a matching service request could not be found
	 */
	public static ServiceRequest fetchByStatusAndOrganization_First(
		int status, long organizationId,
		OrderByComparator<ServiceRequest> orderByComparator) {

		return getPersistence().fetchByStatusAndOrganization_First(
			status, organizationId, orderByComparator);
	}

	/**
	 * Returns the last service request in the ordered set where status = &#63; and organizationId = &#63;.
	 *
	 * @param status the status
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request
	 * @throws NoSuchServiceRequestException if a matching service request could not be found
	 */
	public static ServiceRequest findByStatusAndOrganization_Last(
			int status, long organizationId,
			OrderByComparator<ServiceRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchServiceRequestException {

		return getPersistence().findByStatusAndOrganization_Last(
			status, organizationId, orderByComparator);
	}

	/**
	 * Returns the last service request in the ordered set where status = &#63; and organizationId = &#63;.
	 *
	 * @param status the status
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request, or <code>null</code> if a matching service request could not be found
	 */
	public static ServiceRequest fetchByStatusAndOrganization_Last(
		int status, long organizationId,
		OrderByComparator<ServiceRequest> orderByComparator) {

		return getPersistence().fetchByStatusAndOrganization_Last(
			status, organizationId, orderByComparator);
	}

	/**
	 * Returns the service requests before and after the current service request in the ordered set where status = &#63; and organizationId = &#63;.
	 *
	 * @param serviceRequestId the primary key of the current service request
	 * @param status the status
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service request
	 * @throws NoSuchServiceRequestException if a service request with the primary key could not be found
	 */
	public static ServiceRequest[] findByStatusAndOrganization_PrevAndNext(
			long serviceRequestId, int status, long organizationId,
			OrderByComparator<ServiceRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchServiceRequestException {

		return getPersistence().findByStatusAndOrganization_PrevAndNext(
			serviceRequestId, status, organizationId, orderByComparator);
	}

	/**
	 * Removes all the service requests where status = &#63; and organizationId = &#63; from the database.
	 *
	 * @param status the status
	 * @param organizationId the organization ID
	 */
	public static void removeByStatusAndOrganization(
		int status, long organizationId) {

		getPersistence().removeByStatusAndOrganization(status, organizationId);
	}

	/**
	 * Returns the number of service requests where status = &#63; and organizationId = &#63;.
	 *
	 * @param status the status
	 * @param organizationId the organization ID
	 * @return the number of matching service requests
	 */
	public static int countByStatusAndOrganization(
		int status, long organizationId) {

		return getPersistence().countByStatusAndOrganization(
			status, organizationId);
	}

	/**
	 * Returns all the service requests where serviceRequestTypeId = &#63; and deleted = &#63;.
	 *
	 * @param serviceRequestTypeId the service request type ID
	 * @param deleted the deleted
	 * @return the matching service requests
	 */
	public static List<ServiceRequest> findByServiceRequestTypeIdAndDeleted(
		long serviceRequestTypeId, boolean deleted) {

		return getPersistence().findByServiceRequestTypeIdAndDeleted(
			serviceRequestTypeId, deleted);
	}

	/**
	 * Returns a range of all the service requests where serviceRequestTypeId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param serviceRequestTypeId the service request type ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of service requests
	 * @param end the upper bound of the range of service requests (not inclusive)
	 * @return the range of matching service requests
	 */
	public static List<ServiceRequest> findByServiceRequestTypeIdAndDeleted(
		long serviceRequestTypeId, boolean deleted, int start, int end) {

		return getPersistence().findByServiceRequestTypeIdAndDeleted(
			serviceRequestTypeId, deleted, start, end);
	}

	/**
	 * Returns an ordered range of all the service requests where serviceRequestTypeId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param serviceRequestTypeId the service request type ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of service requests
	 * @param end the upper bound of the range of service requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service requests
	 */
	public static List<ServiceRequest> findByServiceRequestTypeIdAndDeleted(
		long serviceRequestTypeId, boolean deleted, int start, int end,
		OrderByComparator<ServiceRequest> orderByComparator) {

		return getPersistence().findByServiceRequestTypeIdAndDeleted(
			serviceRequestTypeId, deleted, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the service requests where serviceRequestTypeId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param serviceRequestTypeId the service request type ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of service requests
	 * @param end the upper bound of the range of service requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching service requests
	 */
	public static List<ServiceRequest> findByServiceRequestTypeIdAndDeleted(
		long serviceRequestTypeId, boolean deleted, int start, int end,
		OrderByComparator<ServiceRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByServiceRequestTypeIdAndDeleted(
			serviceRequestTypeId, deleted, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first service request in the ordered set where serviceRequestTypeId = &#63; and deleted = &#63;.
	 *
	 * @param serviceRequestTypeId the service request type ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request
	 * @throws NoSuchServiceRequestException if a matching service request could not be found
	 */
	public static ServiceRequest findByServiceRequestTypeIdAndDeleted_First(
			long serviceRequestTypeId, boolean deleted,
			OrderByComparator<ServiceRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchServiceRequestException {

		return getPersistence().findByServiceRequestTypeIdAndDeleted_First(
			serviceRequestTypeId, deleted, orderByComparator);
	}

	/**
	 * Returns the first service request in the ordered set where serviceRequestTypeId = &#63; and deleted = &#63;.
	 *
	 * @param serviceRequestTypeId the service request type ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request, or <code>null</code> if a matching service request could not be found
	 */
	public static ServiceRequest fetchByServiceRequestTypeIdAndDeleted_First(
		long serviceRequestTypeId, boolean deleted,
		OrderByComparator<ServiceRequest> orderByComparator) {

		return getPersistence().fetchByServiceRequestTypeIdAndDeleted_First(
			serviceRequestTypeId, deleted, orderByComparator);
	}

	/**
	 * Returns the last service request in the ordered set where serviceRequestTypeId = &#63; and deleted = &#63;.
	 *
	 * @param serviceRequestTypeId the service request type ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request
	 * @throws NoSuchServiceRequestException if a matching service request could not be found
	 */
	public static ServiceRequest findByServiceRequestTypeIdAndDeleted_Last(
			long serviceRequestTypeId, boolean deleted,
			OrderByComparator<ServiceRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchServiceRequestException {

		return getPersistence().findByServiceRequestTypeIdAndDeleted_Last(
			serviceRequestTypeId, deleted, orderByComparator);
	}

	/**
	 * Returns the last service request in the ordered set where serviceRequestTypeId = &#63; and deleted = &#63;.
	 *
	 * @param serviceRequestTypeId the service request type ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request, or <code>null</code> if a matching service request could not be found
	 */
	public static ServiceRequest fetchByServiceRequestTypeIdAndDeleted_Last(
		long serviceRequestTypeId, boolean deleted,
		OrderByComparator<ServiceRequest> orderByComparator) {

		return getPersistence().fetchByServiceRequestTypeIdAndDeleted_Last(
			serviceRequestTypeId, deleted, orderByComparator);
	}

	/**
	 * Returns the service requests before and after the current service request in the ordered set where serviceRequestTypeId = &#63; and deleted = &#63;.
	 *
	 * @param serviceRequestId the primary key of the current service request
	 * @param serviceRequestTypeId the service request type ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service request
	 * @throws NoSuchServiceRequestException if a service request with the primary key could not be found
	 */
	public static ServiceRequest[]
			findByServiceRequestTypeIdAndDeleted_PrevAndNext(
				long serviceRequestId, long serviceRequestTypeId,
				boolean deleted,
				OrderByComparator<ServiceRequest> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchServiceRequestException {

		return getPersistence().
			findByServiceRequestTypeIdAndDeleted_PrevAndNext(
				serviceRequestId, serviceRequestTypeId, deleted,
				orderByComparator);
	}

	/**
	 * Removes all the service requests where serviceRequestTypeId = &#63; and deleted = &#63; from the database.
	 *
	 * @param serviceRequestTypeId the service request type ID
	 * @param deleted the deleted
	 */
	public static void removeByServiceRequestTypeIdAndDeleted(
		long serviceRequestTypeId, boolean deleted) {

		getPersistence().removeByServiceRequestTypeIdAndDeleted(
			serviceRequestTypeId, deleted);
	}

	/**
	 * Returns the number of service requests where serviceRequestTypeId = &#63; and deleted = &#63;.
	 *
	 * @param serviceRequestTypeId the service request type ID
	 * @param deleted the deleted
	 * @return the number of matching service requests
	 */
	public static int countByServiceRequestTypeIdAndDeleted(
		long serviceRequestTypeId, boolean deleted) {

		return getPersistence().countByServiceRequestTypeIdAndDeleted(
			serviceRequestTypeId, deleted);
	}

	/**
	 * Caches the service request in the entity cache if it is enabled.
	 *
	 * @param serviceRequest the service request
	 */
	public static void cacheResult(ServiceRequest serviceRequest) {
		getPersistence().cacheResult(serviceRequest);
	}

	/**
	 * Caches the service requests in the entity cache if it is enabled.
	 *
	 * @param serviceRequests the service requests
	 */
	public static void cacheResult(List<ServiceRequest> serviceRequests) {
		getPersistence().cacheResult(serviceRequests);
	}

	/**
	 * Creates a new service request with the primary key. Does not add the service request to the database.
	 *
	 * @param serviceRequestId the primary key for the new service request
	 * @return the new service request
	 */
	public static ServiceRequest create(long serviceRequestId) {
		return getPersistence().create(serviceRequestId);
	}

	/**
	 * Removes the service request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param serviceRequestId the primary key of the service request
	 * @return the service request that was removed
	 * @throws NoSuchServiceRequestException if a service request with the primary key could not be found
	 */
	public static ServiceRequest remove(long serviceRequestId)
		throws com.adjecti.pis.liferay.exception.NoSuchServiceRequestException {

		return getPersistence().remove(serviceRequestId);
	}

	public static ServiceRequest updateImpl(ServiceRequest serviceRequest) {
		return getPersistence().updateImpl(serviceRequest);
	}

	/**
	 * Returns the service request with the primary key or throws a <code>NoSuchServiceRequestException</code> if it could not be found.
	 *
	 * @param serviceRequestId the primary key of the service request
	 * @return the service request
	 * @throws NoSuchServiceRequestException if a service request with the primary key could not be found
	 */
	public static ServiceRequest findByPrimaryKey(long serviceRequestId)
		throws com.adjecti.pis.liferay.exception.NoSuchServiceRequestException {

		return getPersistence().findByPrimaryKey(serviceRequestId);
	}

	/**
	 * Returns the service request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param serviceRequestId the primary key of the service request
	 * @return the service request, or <code>null</code> if a service request with the primary key could not be found
	 */
	public static ServiceRequest fetchByPrimaryKey(long serviceRequestId) {
		return getPersistence().fetchByPrimaryKey(serviceRequestId);
	}

	/**
	 * Returns all the service requests.
	 *
	 * @return the service requests
	 */
	public static List<ServiceRequest> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the service requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service requests
	 * @param end the upper bound of the range of service requests (not inclusive)
	 * @return the range of service requests
	 */
	public static List<ServiceRequest> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the service requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service requests
	 * @param end the upper bound of the range of service requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of service requests
	 */
	public static List<ServiceRequest> findAll(
		int start, int end,
		OrderByComparator<ServiceRequest> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the service requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service requests
	 * @param end the upper bound of the range of service requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of service requests
	 */
	public static List<ServiceRequest> findAll(
		int start, int end, OrderByComparator<ServiceRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the service requests from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of service requests.
	 *
	 * @return the number of service requests
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ServiceRequestPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ServiceRequestPersistence, ServiceRequestPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ServiceRequestPersistence.class);

		ServiceTracker<ServiceRequestPersistence, ServiceRequestPersistence>
			serviceTracker =
				new ServiceTracker
					<ServiceRequestPersistence, ServiceRequestPersistence>(
						bundle.getBundleContext(),
						ServiceRequestPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}