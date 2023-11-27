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

import com.adjecti.pis.liferay.exception.NoSuchServiceRequestWfStatusTypeException;
import com.adjecti.pis.liferay.model.ServiceRequestWfStatusType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the service request wf status type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServiceRequestWfStatusTypeUtil
 * @generated
 */
@ProviderType
public interface ServiceRequestWfStatusTypePersistence
	extends BasePersistence<ServiceRequestWfStatusType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ServiceRequestWfStatusTypeUtil} to access the service request wf status type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the service request wf status type in the entity cache if it is enabled.
	 *
	 * @param serviceRequestWfStatusType the service request wf status type
	 */
	public void cacheResult(
		ServiceRequestWfStatusType serviceRequestWfStatusType);

	/**
	 * Caches the service request wf status types in the entity cache if it is enabled.
	 *
	 * @param serviceRequestWfStatusTypes the service request wf status types
	 */
	public void cacheResult(
		java.util.List<ServiceRequestWfStatusType> serviceRequestWfStatusTypes);

	/**
	 * Creates a new service request wf status type with the primary key. Does not add the service request wf status type to the database.
	 *
	 * @param serviceRequestWfStatusTypeId the primary key for the new service request wf status type
	 * @return the new service request wf status type
	 */
	public ServiceRequestWfStatusType create(long serviceRequestWfStatusTypeId);

	/**
	 * Removes the service request wf status type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param serviceRequestWfStatusTypeId the primary key of the service request wf status type
	 * @return the service request wf status type that was removed
	 * @throws NoSuchServiceRequestWfStatusTypeException if a service request wf status type with the primary key could not be found
	 */
	public ServiceRequestWfStatusType remove(long serviceRequestWfStatusTypeId)
		throws NoSuchServiceRequestWfStatusTypeException;

	public ServiceRequestWfStatusType updateImpl(
		ServiceRequestWfStatusType serviceRequestWfStatusType);

	/**
	 * Returns the service request wf status type with the primary key or throws a <code>NoSuchServiceRequestWfStatusTypeException</code> if it could not be found.
	 *
	 * @param serviceRequestWfStatusTypeId the primary key of the service request wf status type
	 * @return the service request wf status type
	 * @throws NoSuchServiceRequestWfStatusTypeException if a service request wf status type with the primary key could not be found
	 */
	public ServiceRequestWfStatusType findByPrimaryKey(
			long serviceRequestWfStatusTypeId)
		throws NoSuchServiceRequestWfStatusTypeException;

	/**
	 * Returns the service request wf status type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param serviceRequestWfStatusTypeId the primary key of the service request wf status type
	 * @return the service request wf status type, or <code>null</code> if a service request wf status type with the primary key could not be found
	 */
	public ServiceRequestWfStatusType fetchByPrimaryKey(
		long serviceRequestWfStatusTypeId);

	/**
	 * Returns all the service request wf status types.
	 *
	 * @return the service request wf status types
	 */
	public java.util.List<ServiceRequestWfStatusType> findAll();

	/**
	 * Returns a range of all the service request wf status types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestWfStatusTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request wf status types
	 * @param end the upper bound of the range of service request wf status types (not inclusive)
	 * @return the range of service request wf status types
	 */
	public java.util.List<ServiceRequestWfStatusType> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the service request wf status types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestWfStatusTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request wf status types
	 * @param end the upper bound of the range of service request wf status types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of service request wf status types
	 */
	public java.util.List<ServiceRequestWfStatusType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ServiceRequestWfStatusType> orderByComparator);

	/**
	 * Returns an ordered range of all the service request wf status types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestWfStatusTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request wf status types
	 * @param end the upper bound of the range of service request wf status types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of service request wf status types
	 */
	public java.util.List<ServiceRequestWfStatusType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<ServiceRequestWfStatusType> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the service request wf status types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of service request wf status types.
	 *
	 * @return the number of service request wf status types
	 */
	public int countAll();

}