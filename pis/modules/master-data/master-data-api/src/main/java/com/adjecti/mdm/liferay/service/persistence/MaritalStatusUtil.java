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

import com.adjecti.mdm.liferay.model.MaritalStatus;

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
 * The persistence utility for the marital status service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.MaritalStatusPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MaritalStatusPersistence
 * @generated
 */
public class MaritalStatusUtil {

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
	public static void clearCache(MaritalStatus maritalStatus) {
		getPersistence().clearCache(maritalStatus);
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
	public static Map<Serializable, MaritalStatus> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MaritalStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MaritalStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MaritalStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MaritalStatus> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MaritalStatus update(MaritalStatus maritalStatus) {
		return getPersistence().update(maritalStatus);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MaritalStatus update(
		MaritalStatus maritalStatus, ServiceContext serviceContext) {

		return getPersistence().update(maritalStatus, serviceContext);
	}

	/**
	 * Caches the marital status in the entity cache if it is enabled.
	 *
	 * @param maritalStatus the marital status
	 */
	public static void cacheResult(MaritalStatus maritalStatus) {
		getPersistence().cacheResult(maritalStatus);
	}

	/**
	 * Caches the marital statuses in the entity cache if it is enabled.
	 *
	 * @param maritalStatuses the marital statuses
	 */
	public static void cacheResult(List<MaritalStatus> maritalStatuses) {
		getPersistence().cacheResult(maritalStatuses);
	}

	/**
	 * Creates a new marital status with the primary key. Does not add the marital status to the database.
	 *
	 * @param maritalStatusId the primary key for the new marital status
	 * @return the new marital status
	 */
	public static MaritalStatus create(long maritalStatusId) {
		return getPersistence().create(maritalStatusId);
	}

	/**
	 * Removes the marital status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param maritalStatusId the primary key of the marital status
	 * @return the marital status that was removed
	 * @throws NoSuchMaritalStatusException if a marital status with the primary key could not be found
	 */
	public static MaritalStatus remove(long maritalStatusId)
		throws com.adjecti.mdm.liferay.exception.NoSuchMaritalStatusException {

		return getPersistence().remove(maritalStatusId);
	}

	public static MaritalStatus updateImpl(MaritalStatus maritalStatus) {
		return getPersistence().updateImpl(maritalStatus);
	}

	/**
	 * Returns the marital status with the primary key or throws a <code>NoSuchMaritalStatusException</code> if it could not be found.
	 *
	 * @param maritalStatusId the primary key of the marital status
	 * @return the marital status
	 * @throws NoSuchMaritalStatusException if a marital status with the primary key could not be found
	 */
	public static MaritalStatus findByPrimaryKey(long maritalStatusId)
		throws com.adjecti.mdm.liferay.exception.NoSuchMaritalStatusException {

		return getPersistence().findByPrimaryKey(maritalStatusId);
	}

	/**
	 * Returns the marital status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param maritalStatusId the primary key of the marital status
	 * @return the marital status, or <code>null</code> if a marital status with the primary key could not be found
	 */
	public static MaritalStatus fetchByPrimaryKey(long maritalStatusId) {
		return getPersistence().fetchByPrimaryKey(maritalStatusId);
	}

	/**
	 * Returns all the marital statuses.
	 *
	 * @return the marital statuses
	 */
	public static List<MaritalStatus> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the marital statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MaritalStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of marital statuses
	 * @param end the upper bound of the range of marital statuses (not inclusive)
	 * @return the range of marital statuses
	 */
	public static List<MaritalStatus> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the marital statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MaritalStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of marital statuses
	 * @param end the upper bound of the range of marital statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of marital statuses
	 */
	public static List<MaritalStatus> findAll(
		int start, int end,
		OrderByComparator<MaritalStatus> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the marital statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MaritalStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of marital statuses
	 * @param end the upper bound of the range of marital statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of marital statuses
	 */
	public static List<MaritalStatus> findAll(
		int start, int end, OrderByComparator<MaritalStatus> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the marital statuses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of marital statuses.
	 *
	 * @return the number of marital statuses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MaritalStatusPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<MaritalStatusPersistence, MaritalStatusPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MaritalStatusPersistence.class);

		ServiceTracker<MaritalStatusPersistence, MaritalStatusPersistence>
			serviceTracker =
				new ServiceTracker
					<MaritalStatusPersistence, MaritalStatusPersistence>(
						bundle.getBundleContext(),
						MaritalStatusPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}