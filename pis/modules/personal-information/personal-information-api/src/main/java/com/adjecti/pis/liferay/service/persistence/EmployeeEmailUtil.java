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

import com.adjecti.pis.liferay.model.EmployeeEmail;

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
 * The persistence utility for the employee email service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.EmployeeEmailPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeEmailPersistence
 * @generated
 */
public class EmployeeEmailUtil {

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
	public static void clearCache(EmployeeEmail employeeEmail) {
		getPersistence().clearCache(employeeEmail);
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
	public static Map<Serializable, EmployeeEmail> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeEmail> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeEmail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeEmail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeEmail> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeEmail update(EmployeeEmail employeeEmail) {
		return getPersistence().update(employeeEmail);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeEmail update(
		EmployeeEmail employeeEmail, ServiceContext serviceContext) {

		return getPersistence().update(employeeEmail, serviceContext);
	}

	/**
	 * Returns all the employee emails where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee emails
	 */
	public static List<EmployeeEmail> findByEmployeeId(long employeeId) {
		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns a range of all the employee emails where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeEmailModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee emails
	 * @param end the upper bound of the range of employee emails (not inclusive)
	 * @return the range of matching employee emails
	 */
	public static List<EmployeeEmail> findByEmployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee emails where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeEmailModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee emails
	 * @param end the upper bound of the range of employee emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee emails
	 */
	public static List<EmployeeEmail> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeEmail> orderByComparator) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee emails where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeEmailModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee emails
	 * @param end the upper bound of the range of employee emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee emails
	 */
	public static List<EmployeeEmail> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeEmail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee email in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee email
	 * @throws NoSuchEmployeeEmailException if a matching employee email could not be found
	 */
	public static EmployeeEmail findByEmployeeId_First(
			long employeeId, OrderByComparator<EmployeeEmail> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeEmailException {

		return getPersistence().findByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first employee email in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee email, or <code>null</code> if a matching employee email could not be found
	 */
	public static EmployeeEmail fetchByEmployeeId_First(
		long employeeId, OrderByComparator<EmployeeEmail> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee email in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee email
	 * @throws NoSuchEmployeeEmailException if a matching employee email could not be found
	 */
	public static EmployeeEmail findByEmployeeId_Last(
			long employeeId, OrderByComparator<EmployeeEmail> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeEmailException {

		return getPersistence().findByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee email in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee email, or <code>null</code> if a matching employee email could not be found
	 */
	public static EmployeeEmail fetchByEmployeeId_Last(
		long employeeId, OrderByComparator<EmployeeEmail> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the employee emails before and after the current employee email in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeEmailId the primary key of the current employee email
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee email
	 * @throws NoSuchEmployeeEmailException if a employee email with the primary key could not be found
	 */
	public static EmployeeEmail[] findByEmployeeId_PrevAndNext(
			long employeeEmailId, long employeeId,
			OrderByComparator<EmployeeEmail> orderByComparator)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeEmailException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			employeeEmailId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the employee emails where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of employee emails where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee emails
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Caches the employee email in the entity cache if it is enabled.
	 *
	 * @param employeeEmail the employee email
	 */
	public static void cacheResult(EmployeeEmail employeeEmail) {
		getPersistence().cacheResult(employeeEmail);
	}

	/**
	 * Caches the employee emails in the entity cache if it is enabled.
	 *
	 * @param employeeEmails the employee emails
	 */
	public static void cacheResult(List<EmployeeEmail> employeeEmails) {
		getPersistence().cacheResult(employeeEmails);
	}

	/**
	 * Creates a new employee email with the primary key. Does not add the employee email to the database.
	 *
	 * @param employeeEmailId the primary key for the new employee email
	 * @return the new employee email
	 */
	public static EmployeeEmail create(long employeeEmailId) {
		return getPersistence().create(employeeEmailId);
	}

	/**
	 * Removes the employee email with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeEmailId the primary key of the employee email
	 * @return the employee email that was removed
	 * @throws NoSuchEmployeeEmailException if a employee email with the primary key could not be found
	 */
	public static EmployeeEmail remove(long employeeEmailId)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeEmailException {

		return getPersistence().remove(employeeEmailId);
	}

	public static EmployeeEmail updateImpl(EmployeeEmail employeeEmail) {
		return getPersistence().updateImpl(employeeEmail);
	}

	/**
	 * Returns the employee email with the primary key or throws a <code>NoSuchEmployeeEmailException</code> if it could not be found.
	 *
	 * @param employeeEmailId the primary key of the employee email
	 * @return the employee email
	 * @throws NoSuchEmployeeEmailException if a employee email with the primary key could not be found
	 */
	public static EmployeeEmail findByPrimaryKey(long employeeEmailId)
		throws com.adjecti.pis.liferay.exception.NoSuchEmployeeEmailException {

		return getPersistence().findByPrimaryKey(employeeEmailId);
	}

	/**
	 * Returns the employee email with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeEmailId the primary key of the employee email
	 * @return the employee email, or <code>null</code> if a employee email with the primary key could not be found
	 */
	public static EmployeeEmail fetchByPrimaryKey(long employeeEmailId) {
		return getPersistence().fetchByPrimaryKey(employeeEmailId);
	}

	/**
	 * Returns all the employee emails.
	 *
	 * @return the employee emails
	 */
	public static List<EmployeeEmail> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employee emails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeEmailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee emails
	 * @param end the upper bound of the range of employee emails (not inclusive)
	 * @return the range of employee emails
	 */
	public static List<EmployeeEmail> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employee emails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeEmailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee emails
	 * @param end the upper bound of the range of employee emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee emails
	 */
	public static List<EmployeeEmail> findAll(
		int start, int end,
		OrderByComparator<EmployeeEmail> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee emails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeEmailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee emails
	 * @param end the upper bound of the range of employee emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee emails
	 */
	public static List<EmployeeEmail> findAll(
		int start, int end, OrderByComparator<EmployeeEmail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee emails from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee emails.
	 *
	 * @return the number of employee emails
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeEmailPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeeEmailPersistence, EmployeeEmailPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EmployeeEmailPersistence.class);

		ServiceTracker<EmployeeEmailPersistence, EmployeeEmailPersistence>
			serviceTracker =
				new ServiceTracker
					<EmployeeEmailPersistence, EmployeeEmailPersistence>(
						bundle.getBundleContext(),
						EmployeeEmailPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}