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

package com.adjecti.mdm.liferay.service.persistence;

import com.adjecti.mdm.liferay.model.ServiceRequestType;

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
 * The persistence utility for the service request type service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.ServiceRequestTypePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServiceRequestTypePersistence
 * @generated
 */
public class ServiceRequestTypeUtil {

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
	public static void clearCache(ServiceRequestType serviceRequestType) {
		getPersistence().clearCache(serviceRequestType);
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
	public static Map<Serializable, ServiceRequestType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ServiceRequestType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ServiceRequestType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ServiceRequestType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ServiceRequestType> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ServiceRequestType update(
		ServiceRequestType serviceRequestType) {

		return getPersistence().update(serviceRequestType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ServiceRequestType update(
		ServiceRequestType serviceRequestType, ServiceContext serviceContext) {

		return getPersistence().update(serviceRequestType, serviceContext);
	}

	/**
	 * Caches the service request type in the entity cache if it is enabled.
	 *
	 * @param serviceRequestType the service request type
	 */
	public static void cacheResult(ServiceRequestType serviceRequestType) {
		getPersistence().cacheResult(serviceRequestType);
	}

	/**
	 * Caches the service request types in the entity cache if it is enabled.
	 *
	 * @param serviceRequestTypes the service request types
	 */
	public static void cacheResult(
		List<ServiceRequestType> serviceRequestTypes) {

		getPersistence().cacheResult(serviceRequestTypes);
	}

	/**
	 * Creates a new service request type with the primary key. Does not add the service request type to the database.
	 *
	 * @param serviceRequestTypeId the primary key for the new service request type
	 * @return the new service request type
	 */
	public static ServiceRequestType create(long serviceRequestTypeId) {
		return getPersistence().create(serviceRequestTypeId);
	}

	/**
	 * Removes the service request type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param serviceRequestTypeId the primary key of the service request type
	 * @return the service request type that was removed
	 * @throws NoSuchServiceRequestTypeException if a service request type with the primary key could not be found
	 */
	public static ServiceRequestType remove(long serviceRequestTypeId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchServiceRequestTypeException {

		return getPersistence().remove(serviceRequestTypeId);
	}

	public static ServiceRequestType updateImpl(
		ServiceRequestType serviceRequestType) {

		return getPersistence().updateImpl(serviceRequestType);
	}

	/**
	 * Returns the service request type with the primary key or throws a <code>NoSuchServiceRequestTypeException</code> if it could not be found.
	 *
	 * @param serviceRequestTypeId the primary key of the service request type
	 * @return the service request type
	 * @throws NoSuchServiceRequestTypeException if a service request type with the primary key could not be found
	 */
	public static ServiceRequestType findByPrimaryKey(long serviceRequestTypeId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchServiceRequestTypeException {

		return getPersistence().findByPrimaryKey(serviceRequestTypeId);
	}

	/**
	 * Returns the service request type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param serviceRequestTypeId the primary key of the service request type
	 * @return the service request type, or <code>null</code> if a service request type with the primary key could not be found
	 */
	public static ServiceRequestType fetchByPrimaryKey(
		long serviceRequestTypeId) {

		return getPersistence().fetchByPrimaryKey(serviceRequestTypeId);
	}

	/**
	 * Returns all the service request types.
	 *
	 * @return the service request types
	 */
	public static List<ServiceRequestType> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the service request types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request types
	 * @param end the upper bound of the range of service request types (not inclusive)
	 * @return the range of service request types
	 */
	public static List<ServiceRequestType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the service request types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request types
	 * @param end the upper bound of the range of service request types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of service request types
	 */
	public static List<ServiceRequestType> findAll(
		int start, int end,
		OrderByComparator<ServiceRequestType> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the service request types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request types
	 * @param end the upper bound of the range of service request types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of service request types
	 */
	public static List<ServiceRequestType> findAll(
		int start, int end,
		OrderByComparator<ServiceRequestType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the service request types from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of service request types.
	 *
	 * @return the number of service request types
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ServiceRequestTypePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ServiceRequestTypePersistence, ServiceRequestTypePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ServiceRequestTypePersistence.class);

		ServiceTracker
			<ServiceRequestTypePersistence, ServiceRequestTypePersistence>
				serviceTracker =
					new ServiceTracker
						<ServiceRequestTypePersistence,
						 ServiceRequestTypePersistence>(
							 bundle.getBundleContext(),
							 ServiceRequestTypePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}