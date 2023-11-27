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

import com.adjecti.pis.liferay.model.ServiceRequestWfStatusType;

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
 * The persistence utility for the service request wf status type service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.ServiceRequestWfStatusTypePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServiceRequestWfStatusTypePersistence
 * @generated
 */
public class ServiceRequestWfStatusTypeUtil {

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
		ServiceRequestWfStatusType serviceRequestWfStatusType) {

		getPersistence().clearCache(serviceRequestWfStatusType);
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
	public static Map<Serializable, ServiceRequestWfStatusType>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ServiceRequestWfStatusType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ServiceRequestWfStatusType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ServiceRequestWfStatusType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ServiceRequestWfStatusType> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ServiceRequestWfStatusType update(
		ServiceRequestWfStatusType serviceRequestWfStatusType) {

		return getPersistence().update(serviceRequestWfStatusType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ServiceRequestWfStatusType update(
		ServiceRequestWfStatusType serviceRequestWfStatusType,
		ServiceContext serviceContext) {

		return getPersistence().update(
			serviceRequestWfStatusType, serviceContext);
	}

	/**
	 * Caches the service request wf status type in the entity cache if it is enabled.
	 *
	 * @param serviceRequestWfStatusType the service request wf status type
	 */
	public static void cacheResult(
		ServiceRequestWfStatusType serviceRequestWfStatusType) {

		getPersistence().cacheResult(serviceRequestWfStatusType);
	}

	/**
	 * Caches the service request wf status types in the entity cache if it is enabled.
	 *
	 * @param serviceRequestWfStatusTypes the service request wf status types
	 */
	public static void cacheResult(
		List<ServiceRequestWfStatusType> serviceRequestWfStatusTypes) {

		getPersistence().cacheResult(serviceRequestWfStatusTypes);
	}

	/**
	 * Creates a new service request wf status type with the primary key. Does not add the service request wf status type to the database.
	 *
	 * @param serviceRequestWfStatusTypeId the primary key for the new service request wf status type
	 * @return the new service request wf status type
	 */
	public static ServiceRequestWfStatusType create(
		long serviceRequestWfStatusTypeId) {

		return getPersistence().create(serviceRequestWfStatusTypeId);
	}

	/**
	 * Removes the service request wf status type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param serviceRequestWfStatusTypeId the primary key of the service request wf status type
	 * @return the service request wf status type that was removed
	 * @throws NoSuchServiceRequestWfStatusTypeException if a service request wf status type with the primary key could not be found
	 */
	public static ServiceRequestWfStatusType remove(
			long serviceRequestWfStatusTypeId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchServiceRequestWfStatusTypeException {

		return getPersistence().remove(serviceRequestWfStatusTypeId);
	}

	public static ServiceRequestWfStatusType updateImpl(
		ServiceRequestWfStatusType serviceRequestWfStatusType) {

		return getPersistence().updateImpl(serviceRequestWfStatusType);
	}

	/**
	 * Returns the service request wf status type with the primary key or throws a <code>NoSuchServiceRequestWfStatusTypeException</code> if it could not be found.
	 *
	 * @param serviceRequestWfStatusTypeId the primary key of the service request wf status type
	 * @return the service request wf status type
	 * @throws NoSuchServiceRequestWfStatusTypeException if a service request wf status type with the primary key could not be found
	 */
	public static ServiceRequestWfStatusType findByPrimaryKey(
			long serviceRequestWfStatusTypeId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchServiceRequestWfStatusTypeException {

		return getPersistence().findByPrimaryKey(serviceRequestWfStatusTypeId);
	}

	/**
	 * Returns the service request wf status type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param serviceRequestWfStatusTypeId the primary key of the service request wf status type
	 * @return the service request wf status type, or <code>null</code> if a service request wf status type with the primary key could not be found
	 */
	public static ServiceRequestWfStatusType fetchByPrimaryKey(
		long serviceRequestWfStatusTypeId) {

		return getPersistence().fetchByPrimaryKey(serviceRequestWfStatusTypeId);
	}

	/**
	 * Returns all the service request wf status types.
	 *
	 * @return the service request wf status types
	 */
	public static List<ServiceRequestWfStatusType> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<ServiceRequestWfStatusType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<ServiceRequestWfStatusType> findAll(
		int start, int end,
		OrderByComparator<ServiceRequestWfStatusType> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<ServiceRequestWfStatusType> findAll(
		int start, int end,
		OrderByComparator<ServiceRequestWfStatusType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the service request wf status types from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of service request wf status types.
	 *
	 * @return the number of service request wf status types
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ServiceRequestWfStatusTypePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ServiceRequestWfStatusTypePersistence,
		 ServiceRequestWfStatusTypePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ServiceRequestWfStatusTypePersistence.class);

		ServiceTracker
			<ServiceRequestWfStatusTypePersistence,
			 ServiceRequestWfStatusTypePersistence> serviceTracker =
				new ServiceTracker
					<ServiceRequestWfStatusTypePersistence,
					 ServiceRequestWfStatusTypePersistence>(
						 bundle.getBundleContext(),
						 ServiceRequestWfStatusTypePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}