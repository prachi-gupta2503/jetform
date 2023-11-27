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

import com.adjecti.mdm.liferay.model.WorkStation;

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
 * The persistence utility for the work station service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.WorkStationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkStationPersistence
 * @generated
 */
public class WorkStationUtil {

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
	public static void clearCache(WorkStation workStation) {
		getPersistence().clearCache(workStation);
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
	public static Map<Serializable, WorkStation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<WorkStation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WorkStation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WorkStation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<WorkStation> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static WorkStation update(WorkStation workStation) {
		return getPersistence().update(workStation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static WorkStation update(
		WorkStation workStation, ServiceContext serviceContext) {

		return getPersistence().update(workStation, serviceContext);
	}

	/**
	 * Returns all the work stations where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching work stations
	 */
	public static List<WorkStation> findByCode(String code) {
		return getPersistence().findByCode(code);
	}

	/**
	 * Returns a range of all the work stations where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkStationModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of work stations
	 * @param end the upper bound of the range of work stations (not inclusive)
	 * @return the range of matching work stations
	 */
	public static List<WorkStation> findByCode(
		String code, int start, int end) {

		return getPersistence().findByCode(code, start, end);
	}

	/**
	 * Returns an ordered range of all the work stations where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkStationModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of work stations
	 * @param end the upper bound of the range of work stations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work stations
	 */
	public static List<WorkStation> findByCode(
		String code, int start, int end,
		OrderByComparator<WorkStation> orderByComparator) {

		return getPersistence().findByCode(code, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work stations where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkStationModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of work stations
	 * @param end the upper bound of the range of work stations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work stations
	 */
	public static List<WorkStation> findByCode(
		String code, int start, int end,
		OrderByComparator<WorkStation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCode(
			code, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first work station in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work station
	 * @throws NoSuchWorkStationException if a matching work station could not be found
	 */
	public static WorkStation findByCode_First(
			String code, OrderByComparator<WorkStation> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkStationException {

		return getPersistence().findByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the first work station in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work station, or <code>null</code> if a matching work station could not be found
	 */
	public static WorkStation fetchByCode_First(
		String code, OrderByComparator<WorkStation> orderByComparator) {

		return getPersistence().fetchByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the last work station in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work station
	 * @throws NoSuchWorkStationException if a matching work station could not be found
	 */
	public static WorkStation findByCode_Last(
			String code, OrderByComparator<WorkStation> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkStationException {

		return getPersistence().findByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the last work station in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work station, or <code>null</code> if a matching work station could not be found
	 */
	public static WorkStation fetchByCode_Last(
		String code, OrderByComparator<WorkStation> orderByComparator) {

		return getPersistence().fetchByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the work stations before and after the current work station in the ordered set where code = &#63;.
	 *
	 * @param workStationId the primary key of the current work station
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work station
	 * @throws NoSuchWorkStationException if a work station with the primary key could not be found
	 */
	public static WorkStation[] findByCode_PrevAndNext(
			long workStationId, String code,
			OrderByComparator<WorkStation> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkStationException {

		return getPersistence().findByCode_PrevAndNext(
			workStationId, code, orderByComparator);
	}

	/**
	 * Removes all the work stations where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public static void removeByCode(String code) {
		getPersistence().removeByCode(code);
	}

	/**
	 * Returns the number of work stations where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching work stations
	 */
	public static int countByCode(String code) {
		return getPersistence().countByCode(code);
	}

	/**
	 * Returns all the work stations where deskNo = &#63;.
	 *
	 * @param deskNo the desk no
	 * @return the matching work stations
	 */
	public static List<WorkStation> findByDeskNo(String deskNo) {
		return getPersistence().findByDeskNo(deskNo);
	}

	/**
	 * Returns a range of all the work stations where deskNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkStationModelImpl</code>.
	 * </p>
	 *
	 * @param deskNo the desk no
	 * @param start the lower bound of the range of work stations
	 * @param end the upper bound of the range of work stations (not inclusive)
	 * @return the range of matching work stations
	 */
	public static List<WorkStation> findByDeskNo(
		String deskNo, int start, int end) {

		return getPersistence().findByDeskNo(deskNo, start, end);
	}

	/**
	 * Returns an ordered range of all the work stations where deskNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkStationModelImpl</code>.
	 * </p>
	 *
	 * @param deskNo the desk no
	 * @param start the lower bound of the range of work stations
	 * @param end the upper bound of the range of work stations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work stations
	 */
	public static List<WorkStation> findByDeskNo(
		String deskNo, int start, int end,
		OrderByComparator<WorkStation> orderByComparator) {

		return getPersistence().findByDeskNo(
			deskNo, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work stations where deskNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkStationModelImpl</code>.
	 * </p>
	 *
	 * @param deskNo the desk no
	 * @param start the lower bound of the range of work stations
	 * @param end the upper bound of the range of work stations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work stations
	 */
	public static List<WorkStation> findByDeskNo(
		String deskNo, int start, int end,
		OrderByComparator<WorkStation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDeskNo(
			deskNo, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first work station in the ordered set where deskNo = &#63;.
	 *
	 * @param deskNo the desk no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work station
	 * @throws NoSuchWorkStationException if a matching work station could not be found
	 */
	public static WorkStation findByDeskNo_First(
			String deskNo, OrderByComparator<WorkStation> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkStationException {

		return getPersistence().findByDeskNo_First(deskNo, orderByComparator);
	}

	/**
	 * Returns the first work station in the ordered set where deskNo = &#63;.
	 *
	 * @param deskNo the desk no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work station, or <code>null</code> if a matching work station could not be found
	 */
	public static WorkStation fetchByDeskNo_First(
		String deskNo, OrderByComparator<WorkStation> orderByComparator) {

		return getPersistence().fetchByDeskNo_First(deskNo, orderByComparator);
	}

	/**
	 * Returns the last work station in the ordered set where deskNo = &#63;.
	 *
	 * @param deskNo the desk no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work station
	 * @throws NoSuchWorkStationException if a matching work station could not be found
	 */
	public static WorkStation findByDeskNo_Last(
			String deskNo, OrderByComparator<WorkStation> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkStationException {

		return getPersistence().findByDeskNo_Last(deskNo, orderByComparator);
	}

	/**
	 * Returns the last work station in the ordered set where deskNo = &#63;.
	 *
	 * @param deskNo the desk no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work station, or <code>null</code> if a matching work station could not be found
	 */
	public static WorkStation fetchByDeskNo_Last(
		String deskNo, OrderByComparator<WorkStation> orderByComparator) {

		return getPersistence().fetchByDeskNo_Last(deskNo, orderByComparator);
	}

	/**
	 * Returns the work stations before and after the current work station in the ordered set where deskNo = &#63;.
	 *
	 * @param workStationId the primary key of the current work station
	 * @param deskNo the desk no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work station
	 * @throws NoSuchWorkStationException if a work station with the primary key could not be found
	 */
	public static WorkStation[] findByDeskNo_PrevAndNext(
			long workStationId, String deskNo,
			OrderByComparator<WorkStation> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkStationException {

		return getPersistence().findByDeskNo_PrevAndNext(
			workStationId, deskNo, orderByComparator);
	}

	/**
	 * Removes all the work stations where deskNo = &#63; from the database.
	 *
	 * @param deskNo the desk no
	 */
	public static void removeByDeskNo(String deskNo) {
		getPersistence().removeByDeskNo(deskNo);
	}

	/**
	 * Returns the number of work stations where deskNo = &#63;.
	 *
	 * @param deskNo the desk no
	 * @return the number of matching work stations
	 */
	public static int countByDeskNo(String deskNo) {
		return getPersistence().countByDeskNo(deskNo);
	}

	/**
	 * Caches the work station in the entity cache if it is enabled.
	 *
	 * @param workStation the work station
	 */
	public static void cacheResult(WorkStation workStation) {
		getPersistence().cacheResult(workStation);
	}

	/**
	 * Caches the work stations in the entity cache if it is enabled.
	 *
	 * @param workStations the work stations
	 */
	public static void cacheResult(List<WorkStation> workStations) {
		getPersistence().cacheResult(workStations);
	}

	/**
	 * Creates a new work station with the primary key. Does not add the work station to the database.
	 *
	 * @param workStationId the primary key for the new work station
	 * @return the new work station
	 */
	public static WorkStation create(long workStationId) {
		return getPersistence().create(workStationId);
	}

	/**
	 * Removes the work station with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workStationId the primary key of the work station
	 * @return the work station that was removed
	 * @throws NoSuchWorkStationException if a work station with the primary key could not be found
	 */
	public static WorkStation remove(long workStationId)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkStationException {

		return getPersistence().remove(workStationId);
	}

	public static WorkStation updateImpl(WorkStation workStation) {
		return getPersistence().updateImpl(workStation);
	}

	/**
	 * Returns the work station with the primary key or throws a <code>NoSuchWorkStationException</code> if it could not be found.
	 *
	 * @param workStationId the primary key of the work station
	 * @return the work station
	 * @throws NoSuchWorkStationException if a work station with the primary key could not be found
	 */
	public static WorkStation findByPrimaryKey(long workStationId)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkStationException {

		return getPersistence().findByPrimaryKey(workStationId);
	}

	/**
	 * Returns the work station with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workStationId the primary key of the work station
	 * @return the work station, or <code>null</code> if a work station with the primary key could not be found
	 */
	public static WorkStation fetchByPrimaryKey(long workStationId) {
		return getPersistence().fetchByPrimaryKey(workStationId);
	}

	/**
	 * Returns all the work stations.
	 *
	 * @return the work stations
	 */
	public static List<WorkStation> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the work stations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkStationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work stations
	 * @param end the upper bound of the range of work stations (not inclusive)
	 * @return the range of work stations
	 */
	public static List<WorkStation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the work stations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkStationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work stations
	 * @param end the upper bound of the range of work stations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of work stations
	 */
	public static List<WorkStation> findAll(
		int start, int end, OrderByComparator<WorkStation> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work stations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkStationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work stations
	 * @param end the upper bound of the range of work stations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of work stations
	 */
	public static List<WorkStation> findAll(
		int start, int end, OrderByComparator<WorkStation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the work stations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of work stations.
	 *
	 * @return the number of work stations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static WorkStationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<WorkStationPersistence, WorkStationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(WorkStationPersistence.class);

		ServiceTracker<WorkStationPersistence, WorkStationPersistence>
			serviceTracker =
				new ServiceTracker
					<WorkStationPersistence, WorkStationPersistence>(
						bundle.getBundleContext(), WorkStationPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}