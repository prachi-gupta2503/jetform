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

package net.ayudh.comnet.admin.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import net.ayudh.comnet.admin.model.ApplicationAccess;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the application access service. This utility wraps <code>net.ayudh.comnet.admin.service.persistence.impl.ApplicationAccessPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ApplicationAccessPersistence
 * @generated
 */
public class ApplicationAccessUtil {

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
	public static void clearCache(ApplicationAccess applicationAccess) {
		getPersistence().clearCache(applicationAccess);
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
	public static Map<Serializable, ApplicationAccess> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ApplicationAccess> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ApplicationAccess> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ApplicationAccess> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ApplicationAccess> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ApplicationAccess update(
		ApplicationAccess applicationAccess) {

		return getPersistence().update(applicationAccess);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ApplicationAccess update(
		ApplicationAccess applicationAccess, ServiceContext serviceContext) {

		return getPersistence().update(applicationAccess, serviceContext);
	}

	/**
	 * Returns all the application accesses where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching application accesses
	 */
	public static List<ApplicationAccess> findByEmployeeId(long employeeId) {
		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns a range of all the application accesses where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationAccessModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of application accesses
	 * @param end the upper bound of the range of application accesses (not inclusive)
	 * @return the range of matching application accesses
	 */
	public static List<ApplicationAccess> findByEmployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the application accesses where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationAccessModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of application accesses
	 * @param end the upper bound of the range of application accesses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching application accesses
	 */
	public static List<ApplicationAccess> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<ApplicationAccess> orderByComparator) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the application accesses where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationAccessModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of application accesses
	 * @param end the upper bound of the range of application accesses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching application accesses
	 */
	public static List<ApplicationAccess> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<ApplicationAccess> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first application access in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching application access
	 * @throws NoSuchApplicationAccessException if a matching application access could not be found
	 */
	public static ApplicationAccess findByEmployeeId_First(
			long employeeId,
			OrderByComparator<ApplicationAccess> orderByComparator)
		throws net.ayudh.comnet.admin.exception.
			NoSuchApplicationAccessException {

		return getPersistence().findByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first application access in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching application access, or <code>null</code> if a matching application access could not be found
	 */
	public static ApplicationAccess fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<ApplicationAccess> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last application access in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching application access
	 * @throws NoSuchApplicationAccessException if a matching application access could not be found
	 */
	public static ApplicationAccess findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<ApplicationAccess> orderByComparator)
		throws net.ayudh.comnet.admin.exception.
			NoSuchApplicationAccessException {

		return getPersistence().findByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last application access in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching application access, or <code>null</code> if a matching application access could not be found
	 */
	public static ApplicationAccess fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<ApplicationAccess> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the application accesses before and after the current application access in the ordered set where employeeId = &#63;.
	 *
	 * @param applicationAccessId the primary key of the current application access
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next application access
	 * @throws NoSuchApplicationAccessException if a application access with the primary key could not be found
	 */
	public static ApplicationAccess[] findByEmployeeId_PrevAndNext(
			long applicationAccessId, long employeeId,
			OrderByComparator<ApplicationAccess> orderByComparator)
		throws net.ayudh.comnet.admin.exception.
			NoSuchApplicationAccessException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			applicationAccessId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the application accesses where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of application accesses where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching application accesses
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Returns all the application accesses where applicationId = &#63;.
	 *
	 * @param applicationId the application ID
	 * @return the matching application accesses
	 */
	public static List<ApplicationAccess> findByApplicationId(
		long applicationId) {

		return getPersistence().findByApplicationId(applicationId);
	}

	/**
	 * Returns a range of all the application accesses where applicationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationAccessModelImpl</code>.
	 * </p>
	 *
	 * @param applicationId the application ID
	 * @param start the lower bound of the range of application accesses
	 * @param end the upper bound of the range of application accesses (not inclusive)
	 * @return the range of matching application accesses
	 */
	public static List<ApplicationAccess> findByApplicationId(
		long applicationId, int start, int end) {

		return getPersistence().findByApplicationId(applicationId, start, end);
	}

	/**
	 * Returns an ordered range of all the application accesses where applicationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationAccessModelImpl</code>.
	 * </p>
	 *
	 * @param applicationId the application ID
	 * @param start the lower bound of the range of application accesses
	 * @param end the upper bound of the range of application accesses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching application accesses
	 */
	public static List<ApplicationAccess> findByApplicationId(
		long applicationId, int start, int end,
		OrderByComparator<ApplicationAccess> orderByComparator) {

		return getPersistence().findByApplicationId(
			applicationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the application accesses where applicationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationAccessModelImpl</code>.
	 * </p>
	 *
	 * @param applicationId the application ID
	 * @param start the lower bound of the range of application accesses
	 * @param end the upper bound of the range of application accesses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching application accesses
	 */
	public static List<ApplicationAccess> findByApplicationId(
		long applicationId, int start, int end,
		OrderByComparator<ApplicationAccess> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByApplicationId(
			applicationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first application access in the ordered set where applicationId = &#63;.
	 *
	 * @param applicationId the application ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching application access
	 * @throws NoSuchApplicationAccessException if a matching application access could not be found
	 */
	public static ApplicationAccess findByApplicationId_First(
			long applicationId,
			OrderByComparator<ApplicationAccess> orderByComparator)
		throws net.ayudh.comnet.admin.exception.
			NoSuchApplicationAccessException {

		return getPersistence().findByApplicationId_First(
			applicationId, orderByComparator);
	}

	/**
	 * Returns the first application access in the ordered set where applicationId = &#63;.
	 *
	 * @param applicationId the application ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching application access, or <code>null</code> if a matching application access could not be found
	 */
	public static ApplicationAccess fetchByApplicationId_First(
		long applicationId,
		OrderByComparator<ApplicationAccess> orderByComparator) {

		return getPersistence().fetchByApplicationId_First(
			applicationId, orderByComparator);
	}

	/**
	 * Returns the last application access in the ordered set where applicationId = &#63;.
	 *
	 * @param applicationId the application ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching application access
	 * @throws NoSuchApplicationAccessException if a matching application access could not be found
	 */
	public static ApplicationAccess findByApplicationId_Last(
			long applicationId,
			OrderByComparator<ApplicationAccess> orderByComparator)
		throws net.ayudh.comnet.admin.exception.
			NoSuchApplicationAccessException {

		return getPersistence().findByApplicationId_Last(
			applicationId, orderByComparator);
	}

	/**
	 * Returns the last application access in the ordered set where applicationId = &#63;.
	 *
	 * @param applicationId the application ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching application access, or <code>null</code> if a matching application access could not be found
	 */
	public static ApplicationAccess fetchByApplicationId_Last(
		long applicationId,
		OrderByComparator<ApplicationAccess> orderByComparator) {

		return getPersistence().fetchByApplicationId_Last(
			applicationId, orderByComparator);
	}

	/**
	 * Returns the application accesses before and after the current application access in the ordered set where applicationId = &#63;.
	 *
	 * @param applicationAccessId the primary key of the current application access
	 * @param applicationId the application ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next application access
	 * @throws NoSuchApplicationAccessException if a application access with the primary key could not be found
	 */
	public static ApplicationAccess[] findByApplicationId_PrevAndNext(
			long applicationAccessId, long applicationId,
			OrderByComparator<ApplicationAccess> orderByComparator)
		throws net.ayudh.comnet.admin.exception.
			NoSuchApplicationAccessException {

		return getPersistence().findByApplicationId_PrevAndNext(
			applicationAccessId, applicationId, orderByComparator);
	}

	/**
	 * Removes all the application accesses where applicationId = &#63; from the database.
	 *
	 * @param applicationId the application ID
	 */
	public static void removeByApplicationId(long applicationId) {
		getPersistence().removeByApplicationId(applicationId);
	}

	/**
	 * Returns the number of application accesses where applicationId = &#63;.
	 *
	 * @param applicationId the application ID
	 * @return the number of matching application accesses
	 */
	public static int countByApplicationId(long applicationId) {
		return getPersistence().countByApplicationId(applicationId);
	}

	/**
	 * Caches the application access in the entity cache if it is enabled.
	 *
	 * @param applicationAccess the application access
	 */
	public static void cacheResult(ApplicationAccess applicationAccess) {
		getPersistence().cacheResult(applicationAccess);
	}

	/**
	 * Caches the application accesses in the entity cache if it is enabled.
	 *
	 * @param applicationAccesses the application accesses
	 */
	public static void cacheResult(
		List<ApplicationAccess> applicationAccesses) {

		getPersistence().cacheResult(applicationAccesses);
	}

	/**
	 * Creates a new application access with the primary key. Does not add the application access to the database.
	 *
	 * @param applicationAccessId the primary key for the new application access
	 * @return the new application access
	 */
	public static ApplicationAccess create(long applicationAccessId) {
		return getPersistence().create(applicationAccessId);
	}

	/**
	 * Removes the application access with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param applicationAccessId the primary key of the application access
	 * @return the application access that was removed
	 * @throws NoSuchApplicationAccessException if a application access with the primary key could not be found
	 */
	public static ApplicationAccess remove(long applicationAccessId)
		throws net.ayudh.comnet.admin.exception.
			NoSuchApplicationAccessException {

		return getPersistence().remove(applicationAccessId);
	}

	public static ApplicationAccess updateImpl(
		ApplicationAccess applicationAccess) {

		return getPersistence().updateImpl(applicationAccess);
	}

	/**
	 * Returns the application access with the primary key or throws a <code>NoSuchApplicationAccessException</code> if it could not be found.
	 *
	 * @param applicationAccessId the primary key of the application access
	 * @return the application access
	 * @throws NoSuchApplicationAccessException if a application access with the primary key could not be found
	 */
	public static ApplicationAccess findByPrimaryKey(long applicationAccessId)
		throws net.ayudh.comnet.admin.exception.
			NoSuchApplicationAccessException {

		return getPersistence().findByPrimaryKey(applicationAccessId);
	}

	/**
	 * Returns the application access with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param applicationAccessId the primary key of the application access
	 * @return the application access, or <code>null</code> if a application access with the primary key could not be found
	 */
	public static ApplicationAccess fetchByPrimaryKey(
		long applicationAccessId) {

		return getPersistence().fetchByPrimaryKey(applicationAccessId);
	}

	/**
	 * Returns all the application accesses.
	 *
	 * @return the application accesses
	 */
	public static List<ApplicationAccess> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the application accesses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationAccessModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of application accesses
	 * @param end the upper bound of the range of application accesses (not inclusive)
	 * @return the range of application accesses
	 */
	public static List<ApplicationAccess> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the application accesses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationAccessModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of application accesses
	 * @param end the upper bound of the range of application accesses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of application accesses
	 */
	public static List<ApplicationAccess> findAll(
		int start, int end,
		OrderByComparator<ApplicationAccess> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the application accesses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationAccessModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of application accesses
	 * @param end the upper bound of the range of application accesses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of application accesses
	 */
	public static List<ApplicationAccess> findAll(
		int start, int end,
		OrderByComparator<ApplicationAccess> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the application accesses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of application accesses.
	 *
	 * @return the number of application accesses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ApplicationAccessPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ApplicationAccessPersistence, ApplicationAccessPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ApplicationAccessPersistence.class);

		ServiceTracker
			<ApplicationAccessPersistence, ApplicationAccessPersistence>
				serviceTracker =
					new ServiceTracker
						<ApplicationAccessPersistence,
						 ApplicationAccessPersistence>(
							 bundle.getBundleContext(),
							 ApplicationAccessPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}