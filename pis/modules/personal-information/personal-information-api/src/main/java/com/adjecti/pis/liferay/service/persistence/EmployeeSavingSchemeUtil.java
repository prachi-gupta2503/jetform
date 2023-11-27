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

import com.adjecti.pis.liferay.model.EmployeeSavingScheme;

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
 * The persistence utility for the employee saving scheme service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.EmployeeSavingSchemePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeSavingSchemePersistence
 * @generated
 */
public class EmployeeSavingSchemeUtil {

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
	public static void clearCache(EmployeeSavingScheme employeeSavingScheme) {
		getPersistence().clearCache(employeeSavingScheme);
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
	public static Map<Serializable, EmployeeSavingScheme> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeSavingScheme> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeSavingScheme> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeSavingScheme> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeSavingScheme> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeSavingScheme update(
		EmployeeSavingScheme employeeSavingScheme) {

		return getPersistence().update(employeeSavingScheme);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeSavingScheme update(
		EmployeeSavingScheme employeeSavingScheme,
		ServiceContext serviceContext) {

		return getPersistence().update(employeeSavingScheme, serviceContext);
	}

	/**
	 * Returns all the employee saving schemes where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee saving schemes
	 */
	public static List<EmployeeSavingScheme> findByEmployeeId(long employeeId) {
		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns a range of all the employee saving schemes where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSavingSchemeModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee saving schemes
	 * @param end the upper bound of the range of employee saving schemes (not inclusive)
	 * @return the range of matching employee saving schemes
	 */
	public static List<EmployeeSavingScheme> findByEmployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee saving schemes where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSavingSchemeModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee saving schemes
	 * @param end the upper bound of the range of employee saving schemes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee saving schemes
	 */
	public static List<EmployeeSavingScheme> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeSavingScheme> orderByComparator) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee saving schemes where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSavingSchemeModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee saving schemes
	 * @param end the upper bound of the range of employee saving schemes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee saving schemes
	 */
	public static List<EmployeeSavingScheme> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeSavingScheme> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee saving scheme in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee saving scheme
	 * @throws NoSuchEmployeeSavingSchemeException if a matching employee saving scheme could not be found
	 */
	public static EmployeeSavingScheme findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeSavingScheme> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeSavingSchemeException {

		return getPersistence().findByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first employee saving scheme in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee saving scheme, or <code>null</code> if a matching employee saving scheme could not be found
	 */
	public static EmployeeSavingScheme fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<EmployeeSavingScheme> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee saving scheme in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee saving scheme
	 * @throws NoSuchEmployeeSavingSchemeException if a matching employee saving scheme could not be found
	 */
	public static EmployeeSavingScheme findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeSavingScheme> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeSavingSchemeException {

		return getPersistence().findByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee saving scheme in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee saving scheme, or <code>null</code> if a matching employee saving scheme could not be found
	 */
	public static EmployeeSavingScheme fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<EmployeeSavingScheme> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the employee saving schemes before and after the current employee saving scheme in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeSavingSchemeId the primary key of the current employee saving scheme
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee saving scheme
	 * @throws NoSuchEmployeeSavingSchemeException if a employee saving scheme with the primary key could not be found
	 */
	public static EmployeeSavingScheme[] findByEmployeeId_PrevAndNext(
			long employeeSavingSchemeId, long employeeId,
			OrderByComparator<EmployeeSavingScheme> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeSavingSchemeException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			employeeSavingSchemeId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the employee saving schemes where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of employee saving schemes where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee saving schemes
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Caches the employee saving scheme in the entity cache if it is enabled.
	 *
	 * @param employeeSavingScheme the employee saving scheme
	 */
	public static void cacheResult(EmployeeSavingScheme employeeSavingScheme) {
		getPersistence().cacheResult(employeeSavingScheme);
	}

	/**
	 * Caches the employee saving schemes in the entity cache if it is enabled.
	 *
	 * @param employeeSavingSchemes the employee saving schemes
	 */
	public static void cacheResult(
		List<EmployeeSavingScheme> employeeSavingSchemes) {

		getPersistence().cacheResult(employeeSavingSchemes);
	}

	/**
	 * Creates a new employee saving scheme with the primary key. Does not add the employee saving scheme to the database.
	 *
	 * @param employeeSavingSchemeId the primary key for the new employee saving scheme
	 * @return the new employee saving scheme
	 */
	public static EmployeeSavingScheme create(long employeeSavingSchemeId) {
		return getPersistence().create(employeeSavingSchemeId);
	}

	/**
	 * Removes the employee saving scheme with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeSavingSchemeId the primary key of the employee saving scheme
	 * @return the employee saving scheme that was removed
	 * @throws NoSuchEmployeeSavingSchemeException if a employee saving scheme with the primary key could not be found
	 */
	public static EmployeeSavingScheme remove(long employeeSavingSchemeId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeSavingSchemeException {

		return getPersistence().remove(employeeSavingSchemeId);
	}

	public static EmployeeSavingScheme updateImpl(
		EmployeeSavingScheme employeeSavingScheme) {

		return getPersistence().updateImpl(employeeSavingScheme);
	}

	/**
	 * Returns the employee saving scheme with the primary key or throws a <code>NoSuchEmployeeSavingSchemeException</code> if it could not be found.
	 *
	 * @param employeeSavingSchemeId the primary key of the employee saving scheme
	 * @return the employee saving scheme
	 * @throws NoSuchEmployeeSavingSchemeException if a employee saving scheme with the primary key could not be found
	 */
	public static EmployeeSavingScheme findByPrimaryKey(
			long employeeSavingSchemeId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeSavingSchemeException {

		return getPersistence().findByPrimaryKey(employeeSavingSchemeId);
	}

	/**
	 * Returns the employee saving scheme with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeSavingSchemeId the primary key of the employee saving scheme
	 * @return the employee saving scheme, or <code>null</code> if a employee saving scheme with the primary key could not be found
	 */
	public static EmployeeSavingScheme fetchByPrimaryKey(
		long employeeSavingSchemeId) {

		return getPersistence().fetchByPrimaryKey(employeeSavingSchemeId);
	}

	/**
	 * Returns all the employee saving schemes.
	 *
	 * @return the employee saving schemes
	 */
	public static List<EmployeeSavingScheme> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employee saving schemes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSavingSchemeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee saving schemes
	 * @param end the upper bound of the range of employee saving schemes (not inclusive)
	 * @return the range of employee saving schemes
	 */
	public static List<EmployeeSavingScheme> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employee saving schemes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSavingSchemeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee saving schemes
	 * @param end the upper bound of the range of employee saving schemes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee saving schemes
	 */
	public static List<EmployeeSavingScheme> findAll(
		int start, int end,
		OrderByComparator<EmployeeSavingScheme> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee saving schemes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeSavingSchemeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee saving schemes
	 * @param end the upper bound of the range of employee saving schemes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee saving schemes
	 */
	public static List<EmployeeSavingScheme> findAll(
		int start, int end,
		OrderByComparator<EmployeeSavingScheme> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee saving schemes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee saving schemes.
	 *
	 * @return the number of employee saving schemes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeSavingSchemePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeeSavingSchemePersistence, EmployeeSavingSchemePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EmployeeSavingSchemePersistence.class);

		ServiceTracker
			<EmployeeSavingSchemePersistence, EmployeeSavingSchemePersistence>
				serviceTracker =
					new ServiceTracker
						<EmployeeSavingSchemePersistence,
						 EmployeeSavingSchemePersistence>(
							 bundle.getBundleContext(),
							 EmployeeSavingSchemePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}