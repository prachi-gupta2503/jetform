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

import com.adjecti.mdm.liferay.model.OrganizationStation;

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
 * The persistence utility for the organization station service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.OrganizationStationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationStationPersistence
 * @generated
 */
public class OrganizationStationUtil {

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
	public static void clearCache(OrganizationStation organizationStation) {
		getPersistence().clearCache(organizationStation);
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
	public static Map<Serializable, OrganizationStation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<OrganizationStation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OrganizationStation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OrganizationStation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<OrganizationStation> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static OrganizationStation update(
		OrganizationStation organizationStation) {

		return getPersistence().update(organizationStation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static OrganizationStation update(
		OrganizationStation organizationStation,
		ServiceContext serviceContext) {

		return getPersistence().update(organizationStation, serviceContext);
	}

	/**
	 * Returns all the organization stations where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching organization stations
	 */
	public static List<OrganizationStation> findByName(String name) {
		return getPersistence().findByName(name);
	}

	/**
	 * Returns a range of all the organization stations where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationStationModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of organization stations
	 * @param end the upper bound of the range of organization stations (not inclusive)
	 * @return the range of matching organization stations
	 */
	public static List<OrganizationStation> findByName(
		String name, int start, int end) {

		return getPersistence().findByName(name, start, end);
	}

	/**
	 * Returns an ordered range of all the organization stations where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationStationModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of organization stations
	 * @param end the upper bound of the range of organization stations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization stations
	 */
	public static List<OrganizationStation> findByName(
		String name, int start, int end,
		OrderByComparator<OrganizationStation> orderByComparator) {

		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the organization stations where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationStationModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of organization stations
	 * @param end the upper bound of the range of organization stations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization stations
	 */
	public static List<OrganizationStation> findByName(
		String name, int start, int end,
		OrderByComparator<OrganizationStation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByName(
			name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first organization station in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization station
	 * @throws NoSuchOrganizationStationException if a matching organization station could not be found
	 */
	public static OrganizationStation findByName_First(
			String name,
			OrderByComparator<OrganizationStation> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationStationException {

		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	 * Returns the first organization station in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization station, or <code>null</code> if a matching organization station could not be found
	 */
	public static OrganizationStation fetchByName_First(
		String name, OrderByComparator<OrganizationStation> orderByComparator) {

		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	 * Returns the last organization station in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization station
	 * @throws NoSuchOrganizationStationException if a matching organization station could not be found
	 */
	public static OrganizationStation findByName_Last(
			String name,
			OrderByComparator<OrganizationStation> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationStationException {

		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the last organization station in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization station, or <code>null</code> if a matching organization station could not be found
	 */
	public static OrganizationStation fetchByName_Last(
		String name, OrderByComparator<OrganizationStation> orderByComparator) {

		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the organization stations before and after the current organization station in the ordered set where name = &#63;.
	 *
	 * @param organizationStationId the primary key of the current organization station
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization station
	 * @throws NoSuchOrganizationStationException if a organization station with the primary key could not be found
	 */
	public static OrganizationStation[] findByName_PrevAndNext(
			long organizationStationId, String name,
			OrderByComparator<OrganizationStation> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationStationException {

		return getPersistence().findByName_PrevAndNext(
			organizationStationId, name, orderByComparator);
	}

	/**
	 * Removes all the organization stations where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeByName(String name) {
		getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of organization stations where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching organization stations
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Caches the organization station in the entity cache if it is enabled.
	 *
	 * @param organizationStation the organization station
	 */
	public static void cacheResult(OrganizationStation organizationStation) {
		getPersistence().cacheResult(organizationStation);
	}

	/**
	 * Caches the organization stations in the entity cache if it is enabled.
	 *
	 * @param organizationStations the organization stations
	 */
	public static void cacheResult(
		List<OrganizationStation> organizationStations) {

		getPersistence().cacheResult(organizationStations);
	}

	/**
	 * Creates a new organization station with the primary key. Does not add the organization station to the database.
	 *
	 * @param organizationStationId the primary key for the new organization station
	 * @return the new organization station
	 */
	public static OrganizationStation create(long organizationStationId) {
		return getPersistence().create(organizationStationId);
	}

	/**
	 * Removes the organization station with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param organizationStationId the primary key of the organization station
	 * @return the organization station that was removed
	 * @throws NoSuchOrganizationStationException if a organization station with the primary key could not be found
	 */
	public static OrganizationStation remove(long organizationStationId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationStationException {

		return getPersistence().remove(organizationStationId);
	}

	public static OrganizationStation updateImpl(
		OrganizationStation organizationStation) {

		return getPersistence().updateImpl(organizationStation);
	}

	/**
	 * Returns the organization station with the primary key or throws a <code>NoSuchOrganizationStationException</code> if it could not be found.
	 *
	 * @param organizationStationId the primary key of the organization station
	 * @return the organization station
	 * @throws NoSuchOrganizationStationException if a organization station with the primary key could not be found
	 */
	public static OrganizationStation findByPrimaryKey(
			long organizationStationId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationStationException {

		return getPersistence().findByPrimaryKey(organizationStationId);
	}

	/**
	 * Returns the organization station with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param organizationStationId the primary key of the organization station
	 * @return the organization station, or <code>null</code> if a organization station with the primary key could not be found
	 */
	public static OrganizationStation fetchByPrimaryKey(
		long organizationStationId) {

		return getPersistence().fetchByPrimaryKey(organizationStationId);
	}

	/**
	 * Returns all the organization stations.
	 *
	 * @return the organization stations
	 */
	public static List<OrganizationStation> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the organization stations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationStationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization stations
	 * @param end the upper bound of the range of organization stations (not inclusive)
	 * @return the range of organization stations
	 */
	public static List<OrganizationStation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the organization stations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationStationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization stations
	 * @param end the upper bound of the range of organization stations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of organization stations
	 */
	public static List<OrganizationStation> findAll(
		int start, int end,
		OrderByComparator<OrganizationStation> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the organization stations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationStationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization stations
	 * @param end the upper bound of the range of organization stations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of organization stations
	 */
	public static List<OrganizationStation> findAll(
		int start, int end,
		OrderByComparator<OrganizationStation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the organization stations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of organization stations.
	 *
	 * @return the number of organization stations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static OrganizationStationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<OrganizationStationPersistence, OrganizationStationPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			OrganizationStationPersistence.class);

		ServiceTracker
			<OrganizationStationPersistence, OrganizationStationPersistence>
				serviceTracker =
					new ServiceTracker
						<OrganizationStationPersistence,
						 OrganizationStationPersistence>(
							 bundle.getBundleContext(),
							 OrganizationStationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}