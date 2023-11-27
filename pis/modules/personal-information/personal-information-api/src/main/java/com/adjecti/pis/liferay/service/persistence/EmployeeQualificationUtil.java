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

import com.adjecti.pis.liferay.model.EmployeeQualification;

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
 * The persistence utility for the employee qualification service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.EmployeeQualificationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeQualificationPersistence
 * @generated
 */
public class EmployeeQualificationUtil {

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
	public static void clearCache(EmployeeQualification employeeQualification) {
		getPersistence().clearCache(employeeQualification);
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
	public static Map<Serializable, EmployeeQualification> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeQualification> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeQualification> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeQualification> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeQualification> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeQualification update(
		EmployeeQualification employeeQualification) {

		return getPersistence().update(employeeQualification);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeQualification update(
		EmployeeQualification employeeQualification,
		ServiceContext serviceContext) {

		return getPersistence().update(employeeQualification, serviceContext);
	}

	/**
	 * Returns all the employee qualifications where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee qualifications
	 */
	public static List<EmployeeQualification> findByEmployeeId(
		long employeeId) {

		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns a range of all the employee qualifications where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @return the range of matching employee qualifications
	 */
	public static List<EmployeeQualification> findByEmployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee qualifications where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee qualifications
	 */
	public static List<EmployeeQualification> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeQualification> orderByComparator) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee qualifications where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee qualifications
	 */
	public static List<EmployeeQualification> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeQualification> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee qualification in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee qualification
	 * @throws NoSuchEmployeeQualificationException if a matching employee qualification could not be found
	 */
	public static EmployeeQualification findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeQualification> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeQualificationException {

		return getPersistence().findByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first employee qualification in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee qualification, or <code>null</code> if a matching employee qualification could not be found
	 */
	public static EmployeeQualification fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<EmployeeQualification> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee qualification in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee qualification
	 * @throws NoSuchEmployeeQualificationException if a matching employee qualification could not be found
	 */
	public static EmployeeQualification findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeQualification> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeQualificationException {

		return getPersistence().findByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee qualification in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee qualification, or <code>null</code> if a matching employee qualification could not be found
	 */
	public static EmployeeQualification fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<EmployeeQualification> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the employee qualifications before and after the current employee qualification in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeQualificationId the primary key of the current employee qualification
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee qualification
	 * @throws NoSuchEmployeeQualificationException if a employee qualification with the primary key could not be found
	 */
	public static EmployeeQualification[] findByEmployeeId_PrevAndNext(
			long employeeQualificationId, long employeeId,
			OrderByComparator<EmployeeQualification> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeQualificationException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			employeeQualificationId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the employee qualifications where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of employee qualifications where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee qualifications
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Returns all the employee qualifications where qualificationId = &#63;.
	 *
	 * @param qualificationId the qualification ID
	 * @return the matching employee qualifications
	 */
	public static List<EmployeeQualification> findByQualificationId(
		long qualificationId) {

		return getPersistence().findByQualificationId(qualificationId);
	}

	/**
	 * Returns a range of all the employee qualifications where qualificationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param qualificationId the qualification ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @return the range of matching employee qualifications
	 */
	public static List<EmployeeQualification> findByQualificationId(
		long qualificationId, int start, int end) {

		return getPersistence().findByQualificationId(
			qualificationId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee qualifications where qualificationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param qualificationId the qualification ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee qualifications
	 */
	public static List<EmployeeQualification> findByQualificationId(
		long qualificationId, int start, int end,
		OrderByComparator<EmployeeQualification> orderByComparator) {

		return getPersistence().findByQualificationId(
			qualificationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee qualifications where qualificationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param qualificationId the qualification ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee qualifications
	 */
	public static List<EmployeeQualification> findByQualificationId(
		long qualificationId, int start, int end,
		OrderByComparator<EmployeeQualification> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByQualificationId(
			qualificationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee qualification in the ordered set where qualificationId = &#63;.
	 *
	 * @param qualificationId the qualification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee qualification
	 * @throws NoSuchEmployeeQualificationException if a matching employee qualification could not be found
	 */
	public static EmployeeQualification findByQualificationId_First(
			long qualificationId,
			OrderByComparator<EmployeeQualification> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeQualificationException {

		return getPersistence().findByQualificationId_First(
			qualificationId, orderByComparator);
	}

	/**
	 * Returns the first employee qualification in the ordered set where qualificationId = &#63;.
	 *
	 * @param qualificationId the qualification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee qualification, or <code>null</code> if a matching employee qualification could not be found
	 */
	public static EmployeeQualification fetchByQualificationId_First(
		long qualificationId,
		OrderByComparator<EmployeeQualification> orderByComparator) {

		return getPersistence().fetchByQualificationId_First(
			qualificationId, orderByComparator);
	}

	/**
	 * Returns the last employee qualification in the ordered set where qualificationId = &#63;.
	 *
	 * @param qualificationId the qualification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee qualification
	 * @throws NoSuchEmployeeQualificationException if a matching employee qualification could not be found
	 */
	public static EmployeeQualification findByQualificationId_Last(
			long qualificationId,
			OrderByComparator<EmployeeQualification> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeQualificationException {

		return getPersistence().findByQualificationId_Last(
			qualificationId, orderByComparator);
	}

	/**
	 * Returns the last employee qualification in the ordered set where qualificationId = &#63;.
	 *
	 * @param qualificationId the qualification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee qualification, or <code>null</code> if a matching employee qualification could not be found
	 */
	public static EmployeeQualification fetchByQualificationId_Last(
		long qualificationId,
		OrderByComparator<EmployeeQualification> orderByComparator) {

		return getPersistence().fetchByQualificationId_Last(
			qualificationId, orderByComparator);
	}

	/**
	 * Returns the employee qualifications before and after the current employee qualification in the ordered set where qualificationId = &#63;.
	 *
	 * @param employeeQualificationId the primary key of the current employee qualification
	 * @param qualificationId the qualification ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee qualification
	 * @throws NoSuchEmployeeQualificationException if a employee qualification with the primary key could not be found
	 */
	public static EmployeeQualification[] findByQualificationId_PrevAndNext(
			long employeeQualificationId, long qualificationId,
			OrderByComparator<EmployeeQualification> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeQualificationException {

		return getPersistence().findByQualificationId_PrevAndNext(
			employeeQualificationId, qualificationId, orderByComparator);
	}

	/**
	 * Removes all the employee qualifications where qualificationId = &#63; from the database.
	 *
	 * @param qualificationId the qualification ID
	 */
	public static void removeByQualificationId(long qualificationId) {
		getPersistence().removeByQualificationId(qualificationId);
	}

	/**
	 * Returns the number of employee qualifications where qualificationId = &#63;.
	 *
	 * @param qualificationId the qualification ID
	 * @return the number of matching employee qualifications
	 */
	public static int countByQualificationId(long qualificationId) {
		return getPersistence().countByQualificationId(qualificationId);
	}

	/**
	 * Returns all the employee qualifications where specializationId = &#63;.
	 *
	 * @param specializationId the specialization ID
	 * @return the matching employee qualifications
	 */
	public static List<EmployeeQualification> findBySpecializationId(
		long specializationId) {

		return getPersistence().findBySpecializationId(specializationId);
	}

	/**
	 * Returns a range of all the employee qualifications where specializationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param specializationId the specialization ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @return the range of matching employee qualifications
	 */
	public static List<EmployeeQualification> findBySpecializationId(
		long specializationId, int start, int end) {

		return getPersistence().findBySpecializationId(
			specializationId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee qualifications where specializationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param specializationId the specialization ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee qualifications
	 */
	public static List<EmployeeQualification> findBySpecializationId(
		long specializationId, int start, int end,
		OrderByComparator<EmployeeQualification> orderByComparator) {

		return getPersistence().findBySpecializationId(
			specializationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee qualifications where specializationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param specializationId the specialization ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee qualifications
	 */
	public static List<EmployeeQualification> findBySpecializationId(
		long specializationId, int start, int end,
		OrderByComparator<EmployeeQualification> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySpecializationId(
			specializationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee qualification in the ordered set where specializationId = &#63;.
	 *
	 * @param specializationId the specialization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee qualification
	 * @throws NoSuchEmployeeQualificationException if a matching employee qualification could not be found
	 */
	public static EmployeeQualification findBySpecializationId_First(
			long specializationId,
			OrderByComparator<EmployeeQualification> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeQualificationException {

		return getPersistence().findBySpecializationId_First(
			specializationId, orderByComparator);
	}

	/**
	 * Returns the first employee qualification in the ordered set where specializationId = &#63;.
	 *
	 * @param specializationId the specialization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee qualification, or <code>null</code> if a matching employee qualification could not be found
	 */
	public static EmployeeQualification fetchBySpecializationId_First(
		long specializationId,
		OrderByComparator<EmployeeQualification> orderByComparator) {

		return getPersistence().fetchBySpecializationId_First(
			specializationId, orderByComparator);
	}

	/**
	 * Returns the last employee qualification in the ordered set where specializationId = &#63;.
	 *
	 * @param specializationId the specialization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee qualification
	 * @throws NoSuchEmployeeQualificationException if a matching employee qualification could not be found
	 */
	public static EmployeeQualification findBySpecializationId_Last(
			long specializationId,
			OrderByComparator<EmployeeQualification> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeQualificationException {

		return getPersistence().findBySpecializationId_Last(
			specializationId, orderByComparator);
	}

	/**
	 * Returns the last employee qualification in the ordered set where specializationId = &#63;.
	 *
	 * @param specializationId the specialization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee qualification, or <code>null</code> if a matching employee qualification could not be found
	 */
	public static EmployeeQualification fetchBySpecializationId_Last(
		long specializationId,
		OrderByComparator<EmployeeQualification> orderByComparator) {

		return getPersistence().fetchBySpecializationId_Last(
			specializationId, orderByComparator);
	}

	/**
	 * Returns the employee qualifications before and after the current employee qualification in the ordered set where specializationId = &#63;.
	 *
	 * @param employeeQualificationId the primary key of the current employee qualification
	 * @param specializationId the specialization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee qualification
	 * @throws NoSuchEmployeeQualificationException if a employee qualification with the primary key could not be found
	 */
	public static EmployeeQualification[] findBySpecializationId_PrevAndNext(
			long employeeQualificationId, long specializationId,
			OrderByComparator<EmployeeQualification> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeQualificationException {

		return getPersistence().findBySpecializationId_PrevAndNext(
			employeeQualificationId, specializationId, orderByComparator);
	}

	/**
	 * Removes all the employee qualifications where specializationId = &#63; from the database.
	 *
	 * @param specializationId the specialization ID
	 */
	public static void removeBySpecializationId(long specializationId) {
		getPersistence().removeBySpecializationId(specializationId);
	}

	/**
	 * Returns the number of employee qualifications where specializationId = &#63;.
	 *
	 * @param specializationId the specialization ID
	 * @return the number of matching employee qualifications
	 */
	public static int countBySpecializationId(long specializationId) {
		return getPersistence().countBySpecializationId(specializationId);
	}

	/**
	 * Returns all the employee qualifications where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the matching employee qualifications
	 */
	public static List<EmployeeQualification> findByJoiningProcessId(
		long joiningProcessId) {

		return getPersistence().findByJoiningProcessId(joiningProcessId);
	}

	/**
	 * Returns a range of all the employee qualifications where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @return the range of matching employee qualifications
	 */
	public static List<EmployeeQualification> findByJoiningProcessId(
		long joiningProcessId, int start, int end) {

		return getPersistence().findByJoiningProcessId(
			joiningProcessId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee qualifications where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee qualifications
	 */
	public static List<EmployeeQualification> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		OrderByComparator<EmployeeQualification> orderByComparator) {

		return getPersistence().findByJoiningProcessId(
			joiningProcessId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee qualifications where joiningProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param joiningProcessId the joining process ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee qualifications
	 */
	public static List<EmployeeQualification> findByJoiningProcessId(
		long joiningProcessId, int start, int end,
		OrderByComparator<EmployeeQualification> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByJoiningProcessId(
			joiningProcessId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee qualification in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee qualification
	 * @throws NoSuchEmployeeQualificationException if a matching employee qualification could not be found
	 */
	public static EmployeeQualification findByJoiningProcessId_First(
			long joiningProcessId,
			OrderByComparator<EmployeeQualification> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeQualificationException {

		return getPersistence().findByJoiningProcessId_First(
			joiningProcessId, orderByComparator);
	}

	/**
	 * Returns the first employee qualification in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee qualification, or <code>null</code> if a matching employee qualification could not be found
	 */
	public static EmployeeQualification fetchByJoiningProcessId_First(
		long joiningProcessId,
		OrderByComparator<EmployeeQualification> orderByComparator) {

		return getPersistence().fetchByJoiningProcessId_First(
			joiningProcessId, orderByComparator);
	}

	/**
	 * Returns the last employee qualification in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee qualification
	 * @throws NoSuchEmployeeQualificationException if a matching employee qualification could not be found
	 */
	public static EmployeeQualification findByJoiningProcessId_Last(
			long joiningProcessId,
			OrderByComparator<EmployeeQualification> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeQualificationException {

		return getPersistence().findByJoiningProcessId_Last(
			joiningProcessId, orderByComparator);
	}

	/**
	 * Returns the last employee qualification in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee qualification, or <code>null</code> if a matching employee qualification could not be found
	 */
	public static EmployeeQualification fetchByJoiningProcessId_Last(
		long joiningProcessId,
		OrderByComparator<EmployeeQualification> orderByComparator) {

		return getPersistence().fetchByJoiningProcessId_Last(
			joiningProcessId, orderByComparator);
	}

	/**
	 * Returns the employee qualifications before and after the current employee qualification in the ordered set where joiningProcessId = &#63;.
	 *
	 * @param employeeQualificationId the primary key of the current employee qualification
	 * @param joiningProcessId the joining process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee qualification
	 * @throws NoSuchEmployeeQualificationException if a employee qualification with the primary key could not be found
	 */
	public static EmployeeQualification[] findByJoiningProcessId_PrevAndNext(
			long employeeQualificationId, long joiningProcessId,
			OrderByComparator<EmployeeQualification> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeQualificationException {

		return getPersistence().findByJoiningProcessId_PrevAndNext(
			employeeQualificationId, joiningProcessId, orderByComparator);
	}

	/**
	 * Removes all the employee qualifications where joiningProcessId = &#63; from the database.
	 *
	 * @param joiningProcessId the joining process ID
	 */
	public static void removeByJoiningProcessId(long joiningProcessId) {
		getPersistence().removeByJoiningProcessId(joiningProcessId);
	}

	/**
	 * Returns the number of employee qualifications where joiningProcessId = &#63;.
	 *
	 * @param joiningProcessId the joining process ID
	 * @return the number of matching employee qualifications
	 */
	public static int countByJoiningProcessId(long joiningProcessId) {
		return getPersistence().countByJoiningProcessId(joiningProcessId);
	}

	/**
	 * Returns all the employee qualifications where levelId = &#63;.
	 *
	 * @param levelId the level ID
	 * @return the matching employee qualifications
	 */
	public static List<EmployeeQualification> findByQualificationLevelId(
		long levelId) {

		return getPersistence().findByQualificationLevelId(levelId);
	}

	/**
	 * Returns a range of all the employee qualifications where levelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param levelId the level ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @return the range of matching employee qualifications
	 */
	public static List<EmployeeQualification> findByQualificationLevelId(
		long levelId, int start, int end) {

		return getPersistence().findByQualificationLevelId(levelId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee qualifications where levelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param levelId the level ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee qualifications
	 */
	public static List<EmployeeQualification> findByQualificationLevelId(
		long levelId, int start, int end,
		OrderByComparator<EmployeeQualification> orderByComparator) {

		return getPersistence().findByQualificationLevelId(
			levelId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee qualifications where levelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param levelId the level ID
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee qualifications
	 */
	public static List<EmployeeQualification> findByQualificationLevelId(
		long levelId, int start, int end,
		OrderByComparator<EmployeeQualification> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByQualificationLevelId(
			levelId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee qualification in the ordered set where levelId = &#63;.
	 *
	 * @param levelId the level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee qualification
	 * @throws NoSuchEmployeeQualificationException if a matching employee qualification could not be found
	 */
	public static EmployeeQualification findByQualificationLevelId_First(
			long levelId,
			OrderByComparator<EmployeeQualification> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeQualificationException {

		return getPersistence().findByQualificationLevelId_First(
			levelId, orderByComparator);
	}

	/**
	 * Returns the first employee qualification in the ordered set where levelId = &#63;.
	 *
	 * @param levelId the level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee qualification, or <code>null</code> if a matching employee qualification could not be found
	 */
	public static EmployeeQualification fetchByQualificationLevelId_First(
		long levelId,
		OrderByComparator<EmployeeQualification> orderByComparator) {

		return getPersistence().fetchByQualificationLevelId_First(
			levelId, orderByComparator);
	}

	/**
	 * Returns the last employee qualification in the ordered set where levelId = &#63;.
	 *
	 * @param levelId the level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee qualification
	 * @throws NoSuchEmployeeQualificationException if a matching employee qualification could not be found
	 */
	public static EmployeeQualification findByQualificationLevelId_Last(
			long levelId,
			OrderByComparator<EmployeeQualification> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeQualificationException {

		return getPersistence().findByQualificationLevelId_Last(
			levelId, orderByComparator);
	}

	/**
	 * Returns the last employee qualification in the ordered set where levelId = &#63;.
	 *
	 * @param levelId the level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee qualification, or <code>null</code> if a matching employee qualification could not be found
	 */
	public static EmployeeQualification fetchByQualificationLevelId_Last(
		long levelId,
		OrderByComparator<EmployeeQualification> orderByComparator) {

		return getPersistence().fetchByQualificationLevelId_Last(
			levelId, orderByComparator);
	}

	/**
	 * Returns the employee qualifications before and after the current employee qualification in the ordered set where levelId = &#63;.
	 *
	 * @param employeeQualificationId the primary key of the current employee qualification
	 * @param levelId the level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee qualification
	 * @throws NoSuchEmployeeQualificationException if a employee qualification with the primary key could not be found
	 */
	public static EmployeeQualification[]
			findByQualificationLevelId_PrevAndNext(
				long employeeQualificationId, long levelId,
				OrderByComparator<EmployeeQualification> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeQualificationException {

		return getPersistence().findByQualificationLevelId_PrevAndNext(
			employeeQualificationId, levelId, orderByComparator);
	}

	/**
	 * Removes all the employee qualifications where levelId = &#63; from the database.
	 *
	 * @param levelId the level ID
	 */
	public static void removeByQualificationLevelId(long levelId) {
		getPersistence().removeByQualificationLevelId(levelId);
	}

	/**
	 * Returns the number of employee qualifications where levelId = &#63;.
	 *
	 * @param levelId the level ID
	 * @return the number of matching employee qualifications
	 */
	public static int countByQualificationLevelId(long levelId) {
		return getPersistence().countByQualificationLevelId(levelId);
	}

	/**
	 * Caches the employee qualification in the entity cache if it is enabled.
	 *
	 * @param employeeQualification the employee qualification
	 */
	public static void cacheResult(
		EmployeeQualification employeeQualification) {

		getPersistence().cacheResult(employeeQualification);
	}

	/**
	 * Caches the employee qualifications in the entity cache if it is enabled.
	 *
	 * @param employeeQualifications the employee qualifications
	 */
	public static void cacheResult(
		List<EmployeeQualification> employeeQualifications) {

		getPersistence().cacheResult(employeeQualifications);
	}

	/**
	 * Creates a new employee qualification with the primary key. Does not add the employee qualification to the database.
	 *
	 * @param employeeQualificationId the primary key for the new employee qualification
	 * @return the new employee qualification
	 */
	public static EmployeeQualification create(long employeeQualificationId) {
		return getPersistence().create(employeeQualificationId);
	}

	/**
	 * Removes the employee qualification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeQualificationId the primary key of the employee qualification
	 * @return the employee qualification that was removed
	 * @throws NoSuchEmployeeQualificationException if a employee qualification with the primary key could not be found
	 */
	public static EmployeeQualification remove(long employeeQualificationId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeQualificationException {

		return getPersistence().remove(employeeQualificationId);
	}

	public static EmployeeQualification updateImpl(
		EmployeeQualification employeeQualification) {

		return getPersistence().updateImpl(employeeQualification);
	}

	/**
	 * Returns the employee qualification with the primary key or throws a <code>NoSuchEmployeeQualificationException</code> if it could not be found.
	 *
	 * @param employeeQualificationId the primary key of the employee qualification
	 * @return the employee qualification
	 * @throws NoSuchEmployeeQualificationException if a employee qualification with the primary key could not be found
	 */
	public static EmployeeQualification findByPrimaryKey(
			long employeeQualificationId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeQualificationException {

		return getPersistence().findByPrimaryKey(employeeQualificationId);
	}

	/**
	 * Returns the employee qualification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeQualificationId the primary key of the employee qualification
	 * @return the employee qualification, or <code>null</code> if a employee qualification with the primary key could not be found
	 */
	public static EmployeeQualification fetchByPrimaryKey(
		long employeeQualificationId) {

		return getPersistence().fetchByPrimaryKey(employeeQualificationId);
	}

	/**
	 * Returns all the employee qualifications.
	 *
	 * @return the employee qualifications
	 */
	public static List<EmployeeQualification> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employee qualifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @return the range of employee qualifications
	 */
	public static List<EmployeeQualification> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employee qualifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee qualifications
	 */
	public static List<EmployeeQualification> findAll(
		int start, int end,
		OrderByComparator<EmployeeQualification> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee qualifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee qualifications
	 */
	public static List<EmployeeQualification> findAll(
		int start, int end,
		OrderByComparator<EmployeeQualification> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee qualifications from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee qualifications.
	 *
	 * @return the number of employee qualifications
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeQualificationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeeQualificationPersistence, EmployeeQualificationPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EmployeeQualificationPersistence.class);

		ServiceTracker
			<EmployeeQualificationPersistence, EmployeeQualificationPersistence>
				serviceTracker =
					new ServiceTracker
						<EmployeeQualificationPersistence,
						 EmployeeQualificationPersistence>(
							 bundle.getBundleContext(),
							 EmployeeQualificationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}