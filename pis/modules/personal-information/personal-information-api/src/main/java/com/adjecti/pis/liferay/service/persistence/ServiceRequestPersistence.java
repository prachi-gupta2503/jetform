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

import com.adjecti.pis.liferay.exception.NoSuchServiceRequestException;
import com.adjecti.pis.liferay.model.ServiceRequest;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the service request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServiceRequestUtil
 * @generated
 */
@ProviderType
public interface ServiceRequestPersistence
	extends BasePersistence<ServiceRequest> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ServiceRequestUtil} to access the service request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the service requests where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching service requests
	 */
	public java.util.List<ServiceRequest> findByEmployeeId(long employeeId);

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
	public java.util.List<ServiceRequest> findByEmployeeId(
		long employeeId, int start, int end);

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
	public java.util.List<ServiceRequest> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequest>
			orderByComparator);

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
	public java.util.List<ServiceRequest> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first service request in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request
	 * @throws NoSuchServiceRequestException if a matching service request could not be found
	 */
	public ServiceRequest findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<ServiceRequest>
				orderByComparator)
		throws NoSuchServiceRequestException;

	/**
	 * Returns the first service request in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request, or <code>null</code> if a matching service request could not be found
	 */
	public ServiceRequest fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequest>
			orderByComparator);

	/**
	 * Returns the last service request in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request
	 * @throws NoSuchServiceRequestException if a matching service request could not be found
	 */
	public ServiceRequest findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<ServiceRequest>
				orderByComparator)
		throws NoSuchServiceRequestException;

	/**
	 * Returns the last service request in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request, or <code>null</code> if a matching service request could not be found
	 */
	public ServiceRequest fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequest>
			orderByComparator);

	/**
	 * Returns the service requests before and after the current service request in the ordered set where employeeId = &#63;.
	 *
	 * @param serviceRequestId the primary key of the current service request
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service request
	 * @throws NoSuchServiceRequestException if a service request with the primary key could not be found
	 */
	public ServiceRequest[] findByEmployeeId_PrevAndNext(
			long serviceRequestId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<ServiceRequest>
				orderByComparator)
		throws NoSuchServiceRequestException;

	/**
	 * Removes all the service requests where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of service requests where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching service requests
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Returns all the service requests where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the matching service requests
	 */
	public java.util.List<ServiceRequest> findByJoiningProcessId(
		Long joiningProcessId);

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
	public java.util.List<ServiceRequest> findByJoiningProcessId(
		Long joiningProcessId, int start, int end);

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
	public java.util.List<ServiceRequest> findByJoiningProcessId(
		Long joiningProcessId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequest>
			orderByComparator);

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
	public java.util.List<ServiceRequest> findByJoiningProcessId(
		Long joiningProcessId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first service request in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request
	 * @throws NoSuchServiceRequestException if a matching service request could not be found
	 */
	public ServiceRequest findByJoiningProcessId_First(
			Long joiningProcessId,
			com.liferay.portal.kernel.util.OrderByComparator<ServiceRequest>
				orderByComparator)
		throws NoSuchServiceRequestException;

	/**
	 * Returns the first service request in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request, or <code>null</code> if a matching service request could not be found
	 */
	public ServiceRequest fetchByJoiningProcessId_First(
		Long joiningProcessId,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequest>
			orderByComparator);

	/**
	 * Returns the last service request in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request
	 * @throws NoSuchServiceRequestException if a matching service request could not be found
	 */
	public ServiceRequest findByJoiningProcessId_Last(
			Long joiningProcessId,
			com.liferay.portal.kernel.util.OrderByComparator<ServiceRequest>
				orderByComparator)
		throws NoSuchServiceRequestException;

	/**
	 * Returns the last service request in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request, or <code>null</code> if a matching service request could not be found
	 */
	public ServiceRequest fetchByJoiningProcessId_Last(
		Long joiningProcessId,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequest>
			orderByComparator);

	/**
	 * Returns the service requests before and after the current service request in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param serviceRequestId the primary key of the current service request
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service request
	 * @throws NoSuchServiceRequestException if a service request with the primary key could not be found
	 */
	public ServiceRequest[] findByJoiningProcessId_PrevAndNext(
			long serviceRequestId, Long joiningProcessId,
			com.liferay.portal.kernel.util.OrderByComparator<ServiceRequest>
				orderByComparator)
		throws NoSuchServiceRequestException;

	/**
	 * Removes all the service requests where joiningProcessId = &#63; from the database.
	 *
	 * @param joiningProcessId the joining process ID
	 */
	public void removeByJoiningProcessId(Long joiningProcessId);

	/**
	 * Returns the number of service requests where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the number of matching service requests
	 */
	public int countByJoiningProcessId(Long joiningProcessId);

	/**
	 * Returns all the service requests where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching service requests
	 */
	public java.util.List<ServiceRequest> findByStatus(int status);

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
	public java.util.List<ServiceRequest> findByStatus(
		int status, int start, int end);

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
	public java.util.List<ServiceRequest> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequest>
			orderByComparator);

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
	public java.util.List<ServiceRequest> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first service request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request
	 * @throws NoSuchServiceRequestException if a matching service request could not be found
	 */
	public ServiceRequest findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<ServiceRequest>
				orderByComparator)
		throws NoSuchServiceRequestException;

	/**
	 * Returns the first service request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request, or <code>null</code> if a matching service request could not be found
	 */
	public ServiceRequest fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequest>
			orderByComparator);

	/**
	 * Returns the last service request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request
	 * @throws NoSuchServiceRequestException if a matching service request could not be found
	 */
	public ServiceRequest findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<ServiceRequest>
				orderByComparator)
		throws NoSuchServiceRequestException;

	/**
	 * Returns the last service request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request, or <code>null</code> if a matching service request could not be found
	 */
	public ServiceRequest fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequest>
			orderByComparator);

	/**
	 * Returns the service requests before and after the current service request in the ordered set where status = &#63;.
	 *
	 * @param serviceRequestId the primary key of the current service request
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service request
	 * @throws NoSuchServiceRequestException if a service request with the primary key could not be found
	 */
	public ServiceRequest[] findByStatus_PrevAndNext(
			long serviceRequestId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<ServiceRequest>
				orderByComparator)
		throws NoSuchServiceRequestException;

	/**
	 * Removes all the service requests where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of service requests where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching service requests
	 */
	public int countByStatus(int status);

	/**
	 * Returns all the service requests where status = &#63; and organizationId = &#63;.
	 *
	 * @param status the status
	 * @param organizationId the organization ID
	 * @return the matching service requests
	 */
	public java.util.List<ServiceRequest> findByStatusAndOrganization(
		int status, long organizationId);

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
	public java.util.List<ServiceRequest> findByStatusAndOrganization(
		int status, long organizationId, int start, int end);

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
	public java.util.List<ServiceRequest> findByStatusAndOrganization(
		int status, long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequest>
			orderByComparator);

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
	public java.util.List<ServiceRequest> findByStatusAndOrganization(
		int status, long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first service request in the ordered set where status = &#63; and organizationId = &#63;.
	 *
	 * @param status the status
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request
	 * @throws NoSuchServiceRequestException if a matching service request could not be found
	 */
	public ServiceRequest findByStatusAndOrganization_First(
			int status, long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator<ServiceRequest>
				orderByComparator)
		throws NoSuchServiceRequestException;

	/**
	 * Returns the first service request in the ordered set where status = &#63; and organizationId = &#63;.
	 *
	 * @param status the status
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request, or <code>null</code> if a matching service request could not be found
	 */
	public ServiceRequest fetchByStatusAndOrganization_First(
		int status, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequest>
			orderByComparator);

	/**
	 * Returns the last service request in the ordered set where status = &#63; and organizationId = &#63;.
	 *
	 * @param status the status
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request
	 * @throws NoSuchServiceRequestException if a matching service request could not be found
	 */
	public ServiceRequest findByStatusAndOrganization_Last(
			int status, long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator<ServiceRequest>
				orderByComparator)
		throws NoSuchServiceRequestException;

	/**
	 * Returns the last service request in the ordered set where status = &#63; and organizationId = &#63;.
	 *
	 * @param status the status
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request, or <code>null</code> if a matching service request could not be found
	 */
	public ServiceRequest fetchByStatusAndOrganization_Last(
		int status, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequest>
			orderByComparator);

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
	public ServiceRequest[] findByStatusAndOrganization_PrevAndNext(
			long serviceRequestId, int status, long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator<ServiceRequest>
				orderByComparator)
		throws NoSuchServiceRequestException;

	/**
	 * Removes all the service requests where status = &#63; and organizationId = &#63; from the database.
	 *
	 * @param status the status
	 * @param organizationId the organization ID
	 */
	public void removeByStatusAndOrganization(int status, long organizationId);

	/**
	 * Returns the number of service requests where status = &#63; and organizationId = &#63;.
	 *
	 * @param status the status
	 * @param organizationId the organization ID
	 * @return the number of matching service requests
	 */
	public int countByStatusAndOrganization(int status, long organizationId);

	/**
	 * Returns all the service requests where serviceRequestTypeId = &#63; and deleted = &#63;.
	 *
	 * @param serviceRequestTypeId the service request type ID
	 * @param deleted the deleted
	 * @return the matching service requests
	 */
	public java.util.List<ServiceRequest> findByServiceRequestTypeIdAndDeleted(
		long serviceRequestTypeId, boolean deleted);

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
	public java.util.List<ServiceRequest> findByServiceRequestTypeIdAndDeleted(
		long serviceRequestTypeId, boolean deleted, int start, int end);

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
	public java.util.List<ServiceRequest> findByServiceRequestTypeIdAndDeleted(
		long serviceRequestTypeId, boolean deleted, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequest>
			orderByComparator);

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
	public java.util.List<ServiceRequest> findByServiceRequestTypeIdAndDeleted(
		long serviceRequestTypeId, boolean deleted, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first service request in the ordered set where serviceRequestTypeId = &#63; and deleted = &#63;.
	 *
	 * @param serviceRequestTypeId the service request type ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request
	 * @throws NoSuchServiceRequestException if a matching service request could not be found
	 */
	public ServiceRequest findByServiceRequestTypeIdAndDeleted_First(
			long serviceRequestTypeId, boolean deleted,
			com.liferay.portal.kernel.util.OrderByComparator<ServiceRequest>
				orderByComparator)
		throws NoSuchServiceRequestException;

	/**
	 * Returns the first service request in the ordered set where serviceRequestTypeId = &#63; and deleted = &#63;.
	 *
	 * @param serviceRequestTypeId the service request type ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request, or <code>null</code> if a matching service request could not be found
	 */
	public ServiceRequest fetchByServiceRequestTypeIdAndDeleted_First(
		long serviceRequestTypeId, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequest>
			orderByComparator);

	/**
	 * Returns the last service request in the ordered set where serviceRequestTypeId = &#63; and deleted = &#63;.
	 *
	 * @param serviceRequestTypeId the service request type ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request
	 * @throws NoSuchServiceRequestException if a matching service request could not be found
	 */
	public ServiceRequest findByServiceRequestTypeIdAndDeleted_Last(
			long serviceRequestTypeId, boolean deleted,
			com.liferay.portal.kernel.util.OrderByComparator<ServiceRequest>
				orderByComparator)
		throws NoSuchServiceRequestException;

	/**
	 * Returns the last service request in the ordered set where serviceRequestTypeId = &#63; and deleted = &#63;.
	 *
	 * @param serviceRequestTypeId the service request type ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request, or <code>null</code> if a matching service request could not be found
	 */
	public ServiceRequest fetchByServiceRequestTypeIdAndDeleted_Last(
		long serviceRequestTypeId, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequest>
			orderByComparator);

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
	public ServiceRequest[] findByServiceRequestTypeIdAndDeleted_PrevAndNext(
			long serviceRequestId, long serviceRequestTypeId, boolean deleted,
			com.liferay.portal.kernel.util.OrderByComparator<ServiceRequest>
				orderByComparator)
		throws NoSuchServiceRequestException;

	/**
	 * Removes all the service requests where serviceRequestTypeId = &#63; and deleted = &#63; from the database.
	 *
	 * @param serviceRequestTypeId the service request type ID
	 * @param deleted the deleted
	 */
	public void removeByServiceRequestTypeIdAndDeleted(
		long serviceRequestTypeId, boolean deleted);

	/**
	 * Returns the number of service requests where serviceRequestTypeId = &#63; and deleted = &#63;.
	 *
	 * @param serviceRequestTypeId the service request type ID
	 * @param deleted the deleted
	 * @return the number of matching service requests
	 */
	public int countByServiceRequestTypeIdAndDeleted(
		long serviceRequestTypeId, boolean deleted);

	/**
	 * Caches the service request in the entity cache if it is enabled.
	 *
	 * @param serviceRequest the service request
	 */
	public void cacheResult(ServiceRequest serviceRequest);

	/**
	 * Caches the service requests in the entity cache if it is enabled.
	 *
	 * @param serviceRequests the service requests
	 */
	public void cacheResult(java.util.List<ServiceRequest> serviceRequests);

	/**
	 * Creates a new service request with the primary key. Does not add the service request to the database.
	 *
	 * @param serviceRequestId the primary key for the new service request
	 * @return the new service request
	 */
	public ServiceRequest create(long serviceRequestId);

	/**
	 * Removes the service request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param serviceRequestId the primary key of the service request
	 * @return the service request that was removed
	 * @throws NoSuchServiceRequestException if a service request with the primary key could not be found
	 */
	public ServiceRequest remove(long serviceRequestId)
		throws NoSuchServiceRequestException;

	public ServiceRequest updateImpl(ServiceRequest serviceRequest);

	/**
	 * Returns the service request with the primary key or throws a <code>NoSuchServiceRequestException</code> if it could not be found.
	 *
	 * @param serviceRequestId the primary key of the service request
	 * @return the service request
	 * @throws NoSuchServiceRequestException if a service request with the primary key could not be found
	 */
	public ServiceRequest findByPrimaryKey(long serviceRequestId)
		throws NoSuchServiceRequestException;

	/**
	 * Returns the service request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param serviceRequestId the primary key of the service request
	 * @return the service request, or <code>null</code> if a service request with the primary key could not be found
	 */
	public ServiceRequest fetchByPrimaryKey(long serviceRequestId);

	/**
	 * Returns all the service requests.
	 *
	 * @return the service requests
	 */
	public java.util.List<ServiceRequest> findAll();

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
	public java.util.List<ServiceRequest> findAll(int start, int end);

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
	public java.util.List<ServiceRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequest>
			orderByComparator);

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
	public java.util.List<ServiceRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the service requests from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of service requests.
	 *
	 * @return the number of service requests
	 */
	public int countAll();

}