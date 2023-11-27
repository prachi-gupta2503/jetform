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

import com.adjecti.pis.liferay.exception.NoSuchServiceRequestWorkflowException;
import com.adjecti.pis.liferay.model.ServiceRequestWorkflow;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the service request workflow service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServiceRequestWorkflowUtil
 * @generated
 */
@ProviderType
public interface ServiceRequestWorkflowPersistence
	extends BasePersistence<ServiceRequestWorkflow> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ServiceRequestWorkflowUtil} to access the service request workflow persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the service request workflows where serviceRequestId = &#63;.
	 *
	 * @param serviceRequestId the service request ID
	 * @return the matching service request workflows
	 */
	public java.util.List<ServiceRequestWorkflow> findByServiceRequestId(
		long serviceRequestId);

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
	public java.util.List<ServiceRequestWorkflow> findByServiceRequestId(
		long serviceRequestId, int start, int end);

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
	public java.util.List<ServiceRequestWorkflow> findByServiceRequestId(
		long serviceRequestId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequestWorkflow>
			orderByComparator);

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
	public java.util.List<ServiceRequestWorkflow> findByServiceRequestId(
		long serviceRequestId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequestWorkflow>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first service request workflow in the ordered set where serviceRequestId = &#63;.
	 *
	 * @param serviceRequestId the service request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request workflow
	 * @throws NoSuchServiceRequestWorkflowException if a matching service request workflow could not be found
	 */
	public ServiceRequestWorkflow findByServiceRequestId_First(
			long serviceRequestId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ServiceRequestWorkflow> orderByComparator)
		throws NoSuchServiceRequestWorkflowException;

	/**
	 * Returns the first service request workflow in the ordered set where serviceRequestId = &#63;.
	 *
	 * @param serviceRequestId the service request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request workflow, or <code>null</code> if a matching service request workflow could not be found
	 */
	public ServiceRequestWorkflow fetchByServiceRequestId_First(
		long serviceRequestId,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequestWorkflow>
			orderByComparator);

	/**
	 * Returns the last service request workflow in the ordered set where serviceRequestId = &#63;.
	 *
	 * @param serviceRequestId the service request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request workflow
	 * @throws NoSuchServiceRequestWorkflowException if a matching service request workflow could not be found
	 */
	public ServiceRequestWorkflow findByServiceRequestId_Last(
			long serviceRequestId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ServiceRequestWorkflow> orderByComparator)
		throws NoSuchServiceRequestWorkflowException;

	/**
	 * Returns the last service request workflow in the ordered set where serviceRequestId = &#63;.
	 *
	 * @param serviceRequestId the service request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request workflow, or <code>null</code> if a matching service request workflow could not be found
	 */
	public ServiceRequestWorkflow fetchByServiceRequestId_Last(
		long serviceRequestId,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequestWorkflow>
			orderByComparator);

	/**
	 * Returns the service request workflows before and after the current service request workflow in the ordered set where serviceRequestId = &#63;.
	 *
	 * @param serviceRequestWorkflowId the primary key of the current service request workflow
	 * @param serviceRequestId the service request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service request workflow
	 * @throws NoSuchServiceRequestWorkflowException if a service request workflow with the primary key could not be found
	 */
	public ServiceRequestWorkflow[] findByServiceRequestId_PrevAndNext(
			long serviceRequestWorkflowId, long serviceRequestId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ServiceRequestWorkflow> orderByComparator)
		throws NoSuchServiceRequestWorkflowException;

	/**
	 * Removes all the service request workflows where serviceRequestId = &#63; from the database.
	 *
	 * @param serviceRequestId the service request ID
	 */
	public void removeByServiceRequestId(long serviceRequestId);

	/**
	 * Returns the number of service request workflows where serviceRequestId = &#63;.
	 *
	 * @param serviceRequestId the service request ID
	 * @return the number of matching service request workflows
	 */
	public int countByServiceRequestId(long serviceRequestId);

	/**
	 * Returns all the service request workflows where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching service request workflows
	 */
	public java.util.List<ServiceRequestWorkflow> findByEmployeeId(
		long employeeId);

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
	public java.util.List<ServiceRequestWorkflow> findByEmployeeId(
		long employeeId, int start, int end);

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
	public java.util.List<ServiceRequestWorkflow> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequestWorkflow>
			orderByComparator);

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
	public java.util.List<ServiceRequestWorkflow> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequestWorkflow>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first service request workflow in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request workflow
	 * @throws NoSuchServiceRequestWorkflowException if a matching service request workflow could not be found
	 */
	public ServiceRequestWorkflow findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ServiceRequestWorkflow> orderByComparator)
		throws NoSuchServiceRequestWorkflowException;

	/**
	 * Returns the first service request workflow in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request workflow, or <code>null</code> if a matching service request workflow could not be found
	 */
	public ServiceRequestWorkflow fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequestWorkflow>
			orderByComparator);

	/**
	 * Returns the last service request workflow in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request workflow
	 * @throws NoSuchServiceRequestWorkflowException if a matching service request workflow could not be found
	 */
	public ServiceRequestWorkflow findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ServiceRequestWorkflow> orderByComparator)
		throws NoSuchServiceRequestWorkflowException;

	/**
	 * Returns the last service request workflow in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request workflow, or <code>null</code> if a matching service request workflow could not be found
	 */
	public ServiceRequestWorkflow fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequestWorkflow>
			orderByComparator);

	/**
	 * Returns the service request workflows before and after the current service request workflow in the ordered set where employeeId = &#63;.
	 *
	 * @param serviceRequestWorkflowId the primary key of the current service request workflow
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service request workflow
	 * @throws NoSuchServiceRequestWorkflowException if a service request workflow with the primary key could not be found
	 */
	public ServiceRequestWorkflow[] findByEmployeeId_PrevAndNext(
			long serviceRequestWorkflowId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ServiceRequestWorkflow> orderByComparator)
		throws NoSuchServiceRequestWorkflowException;

	/**
	 * Removes all the service request workflows where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of service request workflows where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching service request workflows
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Returns all the service request workflows where employeeId = &#63; and className = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param className the class name
	 * @return the matching service request workflows
	 */
	public java.util.List<ServiceRequestWorkflow> findByEmployeeIdAndClassName(
		long employeeId, String className);

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
	public java.util.List<ServiceRequestWorkflow> findByEmployeeIdAndClassName(
		long employeeId, String className, int start, int end);

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
	public java.util.List<ServiceRequestWorkflow> findByEmployeeIdAndClassName(
		long employeeId, String className, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequestWorkflow>
			orderByComparator);

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
	public java.util.List<ServiceRequestWorkflow> findByEmployeeIdAndClassName(
		long employeeId, String className, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequestWorkflow>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first service request workflow in the ordered set where employeeId = &#63; and className = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request workflow
	 * @throws NoSuchServiceRequestWorkflowException if a matching service request workflow could not be found
	 */
	public ServiceRequestWorkflow findByEmployeeIdAndClassName_First(
			long employeeId, String className,
			com.liferay.portal.kernel.util.OrderByComparator
				<ServiceRequestWorkflow> orderByComparator)
		throws NoSuchServiceRequestWorkflowException;

	/**
	 * Returns the first service request workflow in the ordered set where employeeId = &#63; and className = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request workflow, or <code>null</code> if a matching service request workflow could not be found
	 */
	public ServiceRequestWorkflow fetchByEmployeeIdAndClassName_First(
		long employeeId, String className,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequestWorkflow>
			orderByComparator);

	/**
	 * Returns the last service request workflow in the ordered set where employeeId = &#63; and className = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request workflow
	 * @throws NoSuchServiceRequestWorkflowException if a matching service request workflow could not be found
	 */
	public ServiceRequestWorkflow findByEmployeeIdAndClassName_Last(
			long employeeId, String className,
			com.liferay.portal.kernel.util.OrderByComparator
				<ServiceRequestWorkflow> orderByComparator)
		throws NoSuchServiceRequestWorkflowException;

	/**
	 * Returns the last service request workflow in the ordered set where employeeId = &#63; and className = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request workflow, or <code>null</code> if a matching service request workflow could not be found
	 */
	public ServiceRequestWorkflow fetchByEmployeeIdAndClassName_Last(
		long employeeId, String className,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequestWorkflow>
			orderByComparator);

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
	public ServiceRequestWorkflow[] findByEmployeeIdAndClassName_PrevAndNext(
			long serviceRequestWorkflowId, long employeeId, String className,
			com.liferay.portal.kernel.util.OrderByComparator
				<ServiceRequestWorkflow> orderByComparator)
		throws NoSuchServiceRequestWorkflowException;

	/**
	 * Removes all the service request workflows where employeeId = &#63; and className = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param className the class name
	 */
	public void removeByEmployeeIdAndClassName(
		long employeeId, String className);

	/**
	 * Returns the number of service request workflows where employeeId = &#63; and className = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param className the class name
	 * @return the number of matching service request workflows
	 */
	public int countByEmployeeIdAndClassName(long employeeId, String className);

	/**
	 * Caches the service request workflow in the entity cache if it is enabled.
	 *
	 * @param serviceRequestWorkflow the service request workflow
	 */
	public void cacheResult(ServiceRequestWorkflow serviceRequestWorkflow);

	/**
	 * Caches the service request workflows in the entity cache if it is enabled.
	 *
	 * @param serviceRequestWorkflows the service request workflows
	 */
	public void cacheResult(
		java.util.List<ServiceRequestWorkflow> serviceRequestWorkflows);

	/**
	 * Creates a new service request workflow with the primary key. Does not add the service request workflow to the database.
	 *
	 * @param serviceRequestWorkflowId the primary key for the new service request workflow
	 * @return the new service request workflow
	 */
	public ServiceRequestWorkflow create(long serviceRequestWorkflowId);

	/**
	 * Removes the service request workflow with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param serviceRequestWorkflowId the primary key of the service request workflow
	 * @return the service request workflow that was removed
	 * @throws NoSuchServiceRequestWorkflowException if a service request workflow with the primary key could not be found
	 */
	public ServiceRequestWorkflow remove(long serviceRequestWorkflowId)
		throws NoSuchServiceRequestWorkflowException;

	public ServiceRequestWorkflow updateImpl(
		ServiceRequestWorkflow serviceRequestWorkflow);

	/**
	 * Returns the service request workflow with the primary key or throws a <code>NoSuchServiceRequestWorkflowException</code> if it could not be found.
	 *
	 * @param serviceRequestWorkflowId the primary key of the service request workflow
	 * @return the service request workflow
	 * @throws NoSuchServiceRequestWorkflowException if a service request workflow with the primary key could not be found
	 */
	public ServiceRequestWorkflow findByPrimaryKey(
			long serviceRequestWorkflowId)
		throws NoSuchServiceRequestWorkflowException;

	/**
	 * Returns the service request workflow with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param serviceRequestWorkflowId the primary key of the service request workflow
	 * @return the service request workflow, or <code>null</code> if a service request workflow with the primary key could not be found
	 */
	public ServiceRequestWorkflow fetchByPrimaryKey(
		long serviceRequestWorkflowId);

	/**
	 * Returns all the service request workflows.
	 *
	 * @return the service request workflows
	 */
	public java.util.List<ServiceRequestWorkflow> findAll();

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
	public java.util.List<ServiceRequestWorkflow> findAll(int start, int end);

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
	public java.util.List<ServiceRequestWorkflow> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequestWorkflow>
			orderByComparator);

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
	public java.util.List<ServiceRequestWorkflow> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequestWorkflow>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the service request workflows from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of service request workflows.
	 *
	 * @return the number of service request workflows
	 */
	public int countAll();

}