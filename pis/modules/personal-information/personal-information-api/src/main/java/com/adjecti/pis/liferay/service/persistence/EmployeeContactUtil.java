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

import com.adjecti.pis.liferay.model.EmployeeContact;

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
 * The persistence utility for the employee contact service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.EmployeeContactPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeContactPersistence
 * @generated
 */
public class EmployeeContactUtil {

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
	public static void clearCache(EmployeeContact employeeContact) {
		getPersistence().clearCache(employeeContact);
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
	public static Map<Serializable, EmployeeContact> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeContact> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeContact> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeContact> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeContact> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeContact update(EmployeeContact employeeContact) {
		return getPersistence().update(employeeContact);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeContact update(
		EmployeeContact employeeContact, ServiceContext serviceContext) {

		return getPersistence().update(employeeContact, serviceContext);
	}

	/**
	 * Returns all the employee contacts where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee contacts
	 */
	public static List<EmployeeContact> findByEmployeeId(long employeeId) {
		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns a range of all the employee contacts where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeContactModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee contacts
	 * @param end the upper bound of the range of employee contacts (not inclusive)
	 * @return the range of matching employee contacts
	 */
	public static List<EmployeeContact> findByEmployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee contacts where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeContactModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee contacts
	 * @param end the upper bound of the range of employee contacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee contacts
	 */
	public static List<EmployeeContact> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeContact> orderByComparator) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee contacts where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeContactModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee contacts
	 * @param end the upper bound of the range of employee contacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee contacts
	 */
	public static List<EmployeeContact> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeContact> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee contact in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee contact
	 * @throws NoSuchEmployeeContactException if a matching employee contact could not be found
	 */
	public static EmployeeContact findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeContact> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeContactException {

		return getPersistence().findByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first employee contact in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee contact, or <code>null</code> if a matching employee contact could not be found
	 */
	public static EmployeeContact fetchByEmployeeId_First(
		long employeeId, OrderByComparator<EmployeeContact> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee contact in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee contact
	 * @throws NoSuchEmployeeContactException if a matching employee contact could not be found
	 */
	public static EmployeeContact findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeContact> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeContactException {

		return getPersistence().findByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee contact in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee contact, or <code>null</code> if a matching employee contact could not be found
	 */
	public static EmployeeContact fetchByEmployeeId_Last(
		long employeeId, OrderByComparator<EmployeeContact> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the employee contacts before and after the current employee contact in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeContactId the primary key of the current employee contact
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee contact
	 * @throws NoSuchEmployeeContactException if a employee contact with the primary key could not be found
	 */
	public static EmployeeContact[] findByEmployeeId_PrevAndNext(
			long employeeContactId, long employeeId,
			OrderByComparator<EmployeeContact> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeContactException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			employeeContactId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the employee contacts where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of employee contacts where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee contacts
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Caches the employee contact in the entity cache if it is enabled.
	 *
	 * @param employeeContact the employee contact
	 */
	public static void cacheResult(EmployeeContact employeeContact) {
		getPersistence().cacheResult(employeeContact);
	}

	/**
	 * Caches the employee contacts in the entity cache if it is enabled.
	 *
	 * @param employeeContacts the employee contacts
	 */
	public static void cacheResult(List<EmployeeContact> employeeContacts) {
		getPersistence().cacheResult(employeeContacts);
	}

	/**
	 * Creates a new employee contact with the primary key. Does not add the employee contact to the database.
	 *
	 * @param employeeContactId the primary key for the new employee contact
	 * @return the new employee contact
	 */
	public static EmployeeContact create(long employeeContactId) {
		return getPersistence().create(employeeContactId);
	}

	/**
	 * Removes the employee contact with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeContactId the primary key of the employee contact
	 * @return the employee contact that was removed
	 * @throws NoSuchEmployeeContactException if a employee contact with the primary key could not be found
	 */
	public static EmployeeContact remove(long employeeContactId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeContactException {

		return getPersistence().remove(employeeContactId);
	}

	public static EmployeeContact updateImpl(EmployeeContact employeeContact) {
		return getPersistence().updateImpl(employeeContact);
	}

	/**
	 * Returns the employee contact with the primary key or throws a <code>NoSuchEmployeeContactException</code> if it could not be found.
	 *
	 * @param employeeContactId the primary key of the employee contact
	 * @return the employee contact
	 * @throws NoSuchEmployeeContactException if a employee contact with the primary key could not be found
	 */
	public static EmployeeContact findByPrimaryKey(long employeeContactId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeContactException {

		return getPersistence().findByPrimaryKey(employeeContactId);
	}

	/**
	 * Returns the employee contact with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeContactId the primary key of the employee contact
	 * @return the employee contact, or <code>null</code> if a employee contact with the primary key could not be found
	 */
	public static EmployeeContact fetchByPrimaryKey(long employeeContactId) {
		return getPersistence().fetchByPrimaryKey(employeeContactId);
	}

	/**
	 * Returns all the employee contacts.
	 *
	 * @return the employee contacts
	 */
	public static List<EmployeeContact> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employee contacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeContactModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee contacts
	 * @param end the upper bound of the range of employee contacts (not inclusive)
	 * @return the range of employee contacts
	 */
	public static List<EmployeeContact> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employee contacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeContactModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee contacts
	 * @param end the upper bound of the range of employee contacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee contacts
	 */
	public static List<EmployeeContact> findAll(
		int start, int end,
		OrderByComparator<EmployeeContact> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee contacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeContactModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee contacts
	 * @param end the upper bound of the range of employee contacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee contacts
	 */
	public static List<EmployeeContact> findAll(
		int start, int end,
		OrderByComparator<EmployeeContact> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee contacts from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee contacts.
	 *
	 * @return the number of employee contacts
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeContactPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeeContactPersistence, EmployeeContactPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EmployeeContactPersistence.class);

		ServiceTracker<EmployeeContactPersistence, EmployeeContactPersistence>
			serviceTracker =
				new ServiceTracker
					<EmployeeContactPersistence, EmployeeContactPersistence>(
						bundle.getBundleContext(),
						EmployeeContactPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}