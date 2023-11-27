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

import com.adjecti.pis.liferay.model.EmployeeMessage;

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
 * The persistence utility for the employee message service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.EmployeeMessagePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeMessagePersistence
 * @generated
 */
public class EmployeeMessageUtil {

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
	public static void clearCache(EmployeeMessage employeeMessage) {
		getPersistence().clearCache(employeeMessage);
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
	public static Map<Serializable, EmployeeMessage> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeMessage> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeMessage update(EmployeeMessage employeeMessage) {
		return getPersistence().update(employeeMessage);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeMessage update(
		EmployeeMessage employeeMessage, ServiceContext serviceContext) {

		return getPersistence().update(employeeMessage, serviceContext);
	}

	/**
	 * Returns all the employee messages where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee messages
	 */
	public static List<EmployeeMessage> findByEmployeeId(long employeeId) {
		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns a range of all the employee messages where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeMessageModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee messages
	 * @param end the upper bound of the range of employee messages (not inclusive)
	 * @return the range of matching employee messages
	 */
	public static List<EmployeeMessage> findByEmployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee messages where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeMessageModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee messages
	 * @param end the upper bound of the range of employee messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee messages
	 */
	public static List<EmployeeMessage> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeMessage> orderByComparator) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee messages where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeMessageModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee messages
	 * @param end the upper bound of the range of employee messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee messages
	 */
	public static List<EmployeeMessage> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeMessage> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee message in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee message
	 * @throws NoSuchEmployeeMessageException if a matching employee message could not be found
	 */
	public static EmployeeMessage findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeMessage> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeMessageException {

		return getPersistence().findByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first employee message in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee message, or <code>null</code> if a matching employee message could not be found
	 */
	public static EmployeeMessage fetchByEmployeeId_First(
		long employeeId, OrderByComparator<EmployeeMessage> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee message in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee message
	 * @throws NoSuchEmployeeMessageException if a matching employee message could not be found
	 */
	public static EmployeeMessage findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeMessage> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeMessageException {

		return getPersistence().findByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee message in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee message, or <code>null</code> if a matching employee message could not be found
	 */
	public static EmployeeMessage fetchByEmployeeId_Last(
		long employeeId, OrderByComparator<EmployeeMessage> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the employee messages before and after the current employee message in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeMessageId the primary key of the current employee message
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee message
	 * @throws NoSuchEmployeeMessageException if a employee message with the primary key could not be found
	 */
	public static EmployeeMessage[] findByEmployeeId_PrevAndNext(
			long employeeMessageId, long employeeId,
			OrderByComparator<EmployeeMessage> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeMessageException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			employeeMessageId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the employee messages where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of employee messages where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee messages
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Caches the employee message in the entity cache if it is enabled.
	 *
	 * @param employeeMessage the employee message
	 */
	public static void cacheResult(EmployeeMessage employeeMessage) {
		getPersistence().cacheResult(employeeMessage);
	}

	/**
	 * Caches the employee messages in the entity cache if it is enabled.
	 *
	 * @param employeeMessages the employee messages
	 */
	public static void cacheResult(List<EmployeeMessage> employeeMessages) {
		getPersistence().cacheResult(employeeMessages);
	}

	/**
	 * Creates a new employee message with the primary key. Does not add the employee message to the database.
	 *
	 * @param employeeMessageId the primary key for the new employee message
	 * @return the new employee message
	 */
	public static EmployeeMessage create(long employeeMessageId) {
		return getPersistence().create(employeeMessageId);
	}

	/**
	 * Removes the employee message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeMessageId the primary key of the employee message
	 * @return the employee message that was removed
	 * @throws NoSuchEmployeeMessageException if a employee message with the primary key could not be found
	 */
	public static EmployeeMessage remove(long employeeMessageId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeMessageException {

		return getPersistence().remove(employeeMessageId);
	}

	public static EmployeeMessage updateImpl(EmployeeMessage employeeMessage) {
		return getPersistence().updateImpl(employeeMessage);
	}

	/**
	 * Returns the employee message with the primary key or throws a <code>NoSuchEmployeeMessageException</code> if it could not be found.
	 *
	 * @param employeeMessageId the primary key of the employee message
	 * @return the employee message
	 * @throws NoSuchEmployeeMessageException if a employee message with the primary key could not be found
	 */
	public static EmployeeMessage findByPrimaryKey(long employeeMessageId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeMessageException {

		return getPersistence().findByPrimaryKey(employeeMessageId);
	}

	/**
	 * Returns the employee message with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeMessageId the primary key of the employee message
	 * @return the employee message, or <code>null</code> if a employee message with the primary key could not be found
	 */
	public static EmployeeMessage fetchByPrimaryKey(long employeeMessageId) {
		return getPersistence().fetchByPrimaryKey(employeeMessageId);
	}

	/**
	 * Returns all the employee messages.
	 *
	 * @return the employee messages
	 */
	public static List<EmployeeMessage> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employee messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeMessageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee messages
	 * @param end the upper bound of the range of employee messages (not inclusive)
	 * @return the range of employee messages
	 */
	public static List<EmployeeMessage> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employee messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeMessageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee messages
	 * @param end the upper bound of the range of employee messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee messages
	 */
	public static List<EmployeeMessage> findAll(
		int start, int end,
		OrderByComparator<EmployeeMessage> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeMessageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee messages
	 * @param end the upper bound of the range of employee messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee messages
	 */
	public static List<EmployeeMessage> findAll(
		int start, int end,
		OrderByComparator<EmployeeMessage> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee messages from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee messages.
	 *
	 * @return the number of employee messages
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeMessagePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeeMessagePersistence, EmployeeMessagePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EmployeeMessagePersistence.class);

		ServiceTracker<EmployeeMessagePersistence, EmployeeMessagePersistence>
			serviceTracker =
				new ServiceTracker
					<EmployeeMessagePersistence, EmployeeMessagePersistence>(
						bundle.getBundleContext(),
						EmployeeMessagePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}