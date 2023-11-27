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

import net.ayudh.comnet.admin.model.ApplicationUser;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the application user service. This utility wraps <code>net.ayudh.comnet.admin.service.persistence.impl.ApplicationUserPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ApplicationUserPersistence
 * @generated
 */
public class ApplicationUserUtil {

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
	public static void clearCache(ApplicationUser applicationUser) {
		getPersistence().clearCache(applicationUser);
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
	public static Map<Serializable, ApplicationUser> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ApplicationUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ApplicationUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ApplicationUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ApplicationUser> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ApplicationUser update(ApplicationUser applicationUser) {
		return getPersistence().update(applicationUser);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ApplicationUser update(
		ApplicationUser applicationUser, ServiceContext serviceContext) {

		return getPersistence().update(applicationUser, serviceContext);
	}

	/**
	 * Returns the application user where employeeId = &#63; or throws a <code>NoSuchApplicationUserException</code> if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @return the matching application user
	 * @throws NoSuchApplicationUserException if a matching application user could not be found
	 */
	public static ApplicationUser findByEmployeeId(long employeeId)
		throws net.ayudh.comnet.admin.exception.NoSuchApplicationUserException {

		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns the application user where employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @return the matching application user, or <code>null</code> if a matching application user could not be found
	 */
	public static ApplicationUser fetchByEmployeeId(long employeeId) {
		return getPersistence().fetchByEmployeeId(employeeId);
	}

	/**
	 * Returns the application user where employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching application user, or <code>null</code> if a matching application user could not be found
	 */
	public static ApplicationUser fetchByEmployeeId(
		long employeeId, boolean useFinderCache) {

		return getPersistence().fetchByEmployeeId(employeeId, useFinderCache);
	}

	/**
	 * Removes the application user where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @return the application user that was removed
	 */
	public static ApplicationUser removeByEmployeeId(long employeeId)
		throws net.ayudh.comnet.admin.exception.NoSuchApplicationUserException {

		return getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of application users where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching application users
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Returns the application user where loginId = &#63; or throws a <code>NoSuchApplicationUserException</code> if it could not be found.
	 *
	 * @param loginId the login ID
	 * @return the matching application user
	 * @throws NoSuchApplicationUserException if a matching application user could not be found
	 */
	public static ApplicationUser findByLoginId(String loginId)
		throws net.ayudh.comnet.admin.exception.NoSuchApplicationUserException {

		return getPersistence().findByLoginId(loginId);
	}

	/**
	 * Returns the application user where loginId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param loginId the login ID
	 * @return the matching application user, or <code>null</code> if a matching application user could not be found
	 */
	public static ApplicationUser fetchByLoginId(String loginId) {
		return getPersistence().fetchByLoginId(loginId);
	}

	/**
	 * Returns the application user where loginId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param loginId the login ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching application user, or <code>null</code> if a matching application user could not be found
	 */
	public static ApplicationUser fetchByLoginId(
		String loginId, boolean useFinderCache) {

		return getPersistence().fetchByLoginId(loginId, useFinderCache);
	}

	/**
	 * Removes the application user where loginId = &#63; from the database.
	 *
	 * @param loginId the login ID
	 * @return the application user that was removed
	 */
	public static ApplicationUser removeByLoginId(String loginId)
		throws net.ayudh.comnet.admin.exception.NoSuchApplicationUserException {

		return getPersistence().removeByLoginId(loginId);
	}

	/**
	 * Returns the number of application users where loginId = &#63;.
	 *
	 * @param loginId the login ID
	 * @return the number of matching application users
	 */
	public static int countByLoginId(String loginId) {
		return getPersistence().countByLoginId(loginId);
	}

	/**
	 * Caches the application user in the entity cache if it is enabled.
	 *
	 * @param applicationUser the application user
	 */
	public static void cacheResult(ApplicationUser applicationUser) {
		getPersistence().cacheResult(applicationUser);
	}

	/**
	 * Caches the application users in the entity cache if it is enabled.
	 *
	 * @param applicationUsers the application users
	 */
	public static void cacheResult(List<ApplicationUser> applicationUsers) {
		getPersistence().cacheResult(applicationUsers);
	}

	/**
	 * Creates a new application user with the primary key. Does not add the application user to the database.
	 *
	 * @param applicationUserId the primary key for the new application user
	 * @return the new application user
	 */
	public static ApplicationUser create(long applicationUserId) {
		return getPersistence().create(applicationUserId);
	}

	/**
	 * Removes the application user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param applicationUserId the primary key of the application user
	 * @return the application user that was removed
	 * @throws NoSuchApplicationUserException if a application user with the primary key could not be found
	 */
	public static ApplicationUser remove(long applicationUserId)
		throws net.ayudh.comnet.admin.exception.NoSuchApplicationUserException {

		return getPersistence().remove(applicationUserId);
	}

	public static ApplicationUser updateImpl(ApplicationUser applicationUser) {
		return getPersistence().updateImpl(applicationUser);
	}

	/**
	 * Returns the application user with the primary key or throws a <code>NoSuchApplicationUserException</code> if it could not be found.
	 *
	 * @param applicationUserId the primary key of the application user
	 * @return the application user
	 * @throws NoSuchApplicationUserException if a application user with the primary key could not be found
	 */
	public static ApplicationUser findByPrimaryKey(long applicationUserId)
		throws net.ayudh.comnet.admin.exception.NoSuchApplicationUserException {

		return getPersistence().findByPrimaryKey(applicationUserId);
	}

	/**
	 * Returns the application user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param applicationUserId the primary key of the application user
	 * @return the application user, or <code>null</code> if a application user with the primary key could not be found
	 */
	public static ApplicationUser fetchByPrimaryKey(long applicationUserId) {
		return getPersistence().fetchByPrimaryKey(applicationUserId);
	}

	/**
	 * Returns all the application users.
	 *
	 * @return the application users
	 */
	public static List<ApplicationUser> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the application users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of application users
	 * @param end the upper bound of the range of application users (not inclusive)
	 * @return the range of application users
	 */
	public static List<ApplicationUser> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the application users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of application users
	 * @param end the upper bound of the range of application users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of application users
	 */
	public static List<ApplicationUser> findAll(
		int start, int end,
		OrderByComparator<ApplicationUser> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the application users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of application users
	 * @param end the upper bound of the range of application users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of application users
	 */
	public static List<ApplicationUser> findAll(
		int start, int end,
		OrderByComparator<ApplicationUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the application users from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of application users.
	 *
	 * @return the number of application users
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ApplicationUserPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ApplicationUserPersistence, ApplicationUserPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ApplicationUserPersistence.class);

		ServiceTracker<ApplicationUserPersistence, ApplicationUserPersistence>
			serviceTracker =
				new ServiceTracker
					<ApplicationUserPersistence, ApplicationUserPersistence>(
						bundle.getBundleContext(),
						ApplicationUserPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}