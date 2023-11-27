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

import com.adjecti.mdm.liferay.model.WorkAreaMinor;

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
 * The persistence utility for the work area minor service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.WorkAreaMinorPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkAreaMinorPersistence
 * @generated
 */
public class WorkAreaMinorUtil {

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
	public static void clearCache(WorkAreaMinor workAreaMinor) {
		getPersistence().clearCache(workAreaMinor);
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
	public static Map<Serializable, WorkAreaMinor> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<WorkAreaMinor> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WorkAreaMinor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WorkAreaMinor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<WorkAreaMinor> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static WorkAreaMinor update(WorkAreaMinor workAreaMinor) {
		return getPersistence().update(workAreaMinor);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static WorkAreaMinor update(
		WorkAreaMinor workAreaMinor, ServiceContext serviceContext) {

		return getPersistence().update(workAreaMinor, serviceContext);
	}

	/**
	 * Returns all the work area minors where workAreaMajorId = &#63; and deleted = &#63;.
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param deleted the deleted
	 * @return the matching work area minors
	 */
	public static List<WorkAreaMinor> findByWorkAreaMajorIdAndDeleted(
		long workAreaMajorId, boolean deleted) {

		return getPersistence().findByWorkAreaMajorIdAndDeleted(
			workAreaMajorId, deleted);
	}

	/**
	 * Returns a range of all the work area minors where workAreaMajorId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMinorModelImpl</code>.
	 * </p>
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of work area minors
	 * @param end the upper bound of the range of work area minors (not inclusive)
	 * @return the range of matching work area minors
	 */
	public static List<WorkAreaMinor> findByWorkAreaMajorIdAndDeleted(
		long workAreaMajorId, boolean deleted, int start, int end) {

		return getPersistence().findByWorkAreaMajorIdAndDeleted(
			workAreaMajorId, deleted, start, end);
	}

	/**
	 * Returns an ordered range of all the work area minors where workAreaMajorId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMinorModelImpl</code>.
	 * </p>
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of work area minors
	 * @param end the upper bound of the range of work area minors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work area minors
	 */
	public static List<WorkAreaMinor> findByWorkAreaMajorIdAndDeleted(
		long workAreaMajorId, boolean deleted, int start, int end,
		OrderByComparator<WorkAreaMinor> orderByComparator) {

		return getPersistence().findByWorkAreaMajorIdAndDeleted(
			workAreaMajorId, deleted, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work area minors where workAreaMajorId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMinorModelImpl</code>.
	 * </p>
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of work area minors
	 * @param end the upper bound of the range of work area minors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work area minors
	 */
	public static List<WorkAreaMinor> findByWorkAreaMajorIdAndDeleted(
		long workAreaMajorId, boolean deleted, int start, int end,
		OrderByComparator<WorkAreaMinor> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByWorkAreaMajorIdAndDeleted(
			workAreaMajorId, deleted, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first work area minor in the ordered set where workAreaMajorId = &#63; and deleted = &#63;.
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area minor
	 * @throws NoSuchWorkAreaMinorException if a matching work area minor could not be found
	 */
	public static WorkAreaMinor findByWorkAreaMajorIdAndDeleted_First(
			long workAreaMajorId, boolean deleted,
			OrderByComparator<WorkAreaMinor> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkAreaMinorException {

		return getPersistence().findByWorkAreaMajorIdAndDeleted_First(
			workAreaMajorId, deleted, orderByComparator);
	}

	/**
	 * Returns the first work area minor in the ordered set where workAreaMajorId = &#63; and deleted = &#63;.
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area minor, or <code>null</code> if a matching work area minor could not be found
	 */
	public static WorkAreaMinor fetchByWorkAreaMajorIdAndDeleted_First(
		long workAreaMajorId, boolean deleted,
		OrderByComparator<WorkAreaMinor> orderByComparator) {

		return getPersistence().fetchByWorkAreaMajorIdAndDeleted_First(
			workAreaMajorId, deleted, orderByComparator);
	}

	/**
	 * Returns the last work area minor in the ordered set where workAreaMajorId = &#63; and deleted = &#63;.
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area minor
	 * @throws NoSuchWorkAreaMinorException if a matching work area minor could not be found
	 */
	public static WorkAreaMinor findByWorkAreaMajorIdAndDeleted_Last(
			long workAreaMajorId, boolean deleted,
			OrderByComparator<WorkAreaMinor> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkAreaMinorException {

		return getPersistence().findByWorkAreaMajorIdAndDeleted_Last(
			workAreaMajorId, deleted, orderByComparator);
	}

	/**
	 * Returns the last work area minor in the ordered set where workAreaMajorId = &#63; and deleted = &#63;.
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area minor, or <code>null</code> if a matching work area minor could not be found
	 */
	public static WorkAreaMinor fetchByWorkAreaMajorIdAndDeleted_Last(
		long workAreaMajorId, boolean deleted,
		OrderByComparator<WorkAreaMinor> orderByComparator) {

		return getPersistence().fetchByWorkAreaMajorIdAndDeleted_Last(
			workAreaMajorId, deleted, orderByComparator);
	}

	/**
	 * Returns the work area minors before and after the current work area minor in the ordered set where workAreaMajorId = &#63; and deleted = &#63;.
	 *
	 * @param workAreaMinorId the primary key of the current work area minor
	 * @param workAreaMajorId the work area major ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work area minor
	 * @throws NoSuchWorkAreaMinorException if a work area minor with the primary key could not be found
	 */
	public static WorkAreaMinor[] findByWorkAreaMajorIdAndDeleted_PrevAndNext(
			long workAreaMinorId, long workAreaMajorId, boolean deleted,
			OrderByComparator<WorkAreaMinor> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkAreaMinorException {

		return getPersistence().findByWorkAreaMajorIdAndDeleted_PrevAndNext(
			workAreaMinorId, workAreaMajorId, deleted, orderByComparator);
	}

	/**
	 * Removes all the work area minors where workAreaMajorId = &#63; and deleted = &#63; from the database.
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param deleted the deleted
	 */
	public static void removeByWorkAreaMajorIdAndDeleted(
		long workAreaMajorId, boolean deleted) {

		getPersistence().removeByWorkAreaMajorIdAndDeleted(
			workAreaMajorId, deleted);
	}

	/**
	 * Returns the number of work area minors where workAreaMajorId = &#63; and deleted = &#63;.
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param deleted the deleted
	 * @return the number of matching work area minors
	 */
	public static int countByWorkAreaMajorIdAndDeleted(
		long workAreaMajorId, boolean deleted) {

		return getPersistence().countByWorkAreaMajorIdAndDeleted(
			workAreaMajorId, deleted);
	}

	/**
	 * Caches the work area minor in the entity cache if it is enabled.
	 *
	 * @param workAreaMinor the work area minor
	 */
	public static void cacheResult(WorkAreaMinor workAreaMinor) {
		getPersistence().cacheResult(workAreaMinor);
	}

	/**
	 * Caches the work area minors in the entity cache if it is enabled.
	 *
	 * @param workAreaMinors the work area minors
	 */
	public static void cacheResult(List<WorkAreaMinor> workAreaMinors) {
		getPersistence().cacheResult(workAreaMinors);
	}

	/**
	 * Creates a new work area minor with the primary key. Does not add the work area minor to the database.
	 *
	 * @param workAreaMinorId the primary key for the new work area minor
	 * @return the new work area minor
	 */
	public static WorkAreaMinor create(long workAreaMinorId) {
		return getPersistence().create(workAreaMinorId);
	}

	/**
	 * Removes the work area minor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workAreaMinorId the primary key of the work area minor
	 * @return the work area minor that was removed
	 * @throws NoSuchWorkAreaMinorException if a work area minor with the primary key could not be found
	 */
	public static WorkAreaMinor remove(long workAreaMinorId)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkAreaMinorException {

		return getPersistence().remove(workAreaMinorId);
	}

	public static WorkAreaMinor updateImpl(WorkAreaMinor workAreaMinor) {
		return getPersistence().updateImpl(workAreaMinor);
	}

	/**
	 * Returns the work area minor with the primary key or throws a <code>NoSuchWorkAreaMinorException</code> if it could not be found.
	 *
	 * @param workAreaMinorId the primary key of the work area minor
	 * @return the work area minor
	 * @throws NoSuchWorkAreaMinorException if a work area minor with the primary key could not be found
	 */
	public static WorkAreaMinor findByPrimaryKey(long workAreaMinorId)
		throws com.adjecti.mdm.liferay.exception.NoSuchWorkAreaMinorException {

		return getPersistence().findByPrimaryKey(workAreaMinorId);
	}

	/**
	 * Returns the work area minor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workAreaMinorId the primary key of the work area minor
	 * @return the work area minor, or <code>null</code> if a work area minor with the primary key could not be found
	 */
	public static WorkAreaMinor fetchByPrimaryKey(long workAreaMinorId) {
		return getPersistence().fetchByPrimaryKey(workAreaMinorId);
	}

	/**
	 * Returns all the work area minors.
	 *
	 * @return the work area minors
	 */
	public static List<WorkAreaMinor> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the work area minors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMinorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work area minors
	 * @param end the upper bound of the range of work area minors (not inclusive)
	 * @return the range of work area minors
	 */
	public static List<WorkAreaMinor> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the work area minors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMinorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work area minors
	 * @param end the upper bound of the range of work area minors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of work area minors
	 */
	public static List<WorkAreaMinor> findAll(
		int start, int end,
		OrderByComparator<WorkAreaMinor> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work area minors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMinorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work area minors
	 * @param end the upper bound of the range of work area minors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of work area minors
	 */
	public static List<WorkAreaMinor> findAll(
		int start, int end, OrderByComparator<WorkAreaMinor> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the work area minors from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of work area minors.
	 *
	 * @return the number of work area minors
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static WorkAreaMinorPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<WorkAreaMinorPersistence, WorkAreaMinorPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(WorkAreaMinorPersistence.class);

		ServiceTracker<WorkAreaMinorPersistence, WorkAreaMinorPersistence>
			serviceTracker =
				new ServiceTracker
					<WorkAreaMinorPersistence, WorkAreaMinorPersistence>(
						bundle.getBundleContext(),
						WorkAreaMinorPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}