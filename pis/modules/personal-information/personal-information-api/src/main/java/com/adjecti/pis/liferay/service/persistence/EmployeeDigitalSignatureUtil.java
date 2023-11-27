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

import com.adjecti.pis.liferay.model.EmployeeDigitalSignature;

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
 * The persistence utility for the employee digital signature service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.EmployeeDigitalSignaturePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDigitalSignaturePersistence
 * @generated
 */
public class EmployeeDigitalSignatureUtil {

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
	public static void clearCache(
		EmployeeDigitalSignature employeeDigitalSignature) {

		getPersistence().clearCache(employeeDigitalSignature);
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
	public static Map<Serializable, EmployeeDigitalSignature>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeDigitalSignature> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeDigitalSignature> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeDigitalSignature> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeDigitalSignature> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeDigitalSignature update(
		EmployeeDigitalSignature employeeDigitalSignature) {

		return getPersistence().update(employeeDigitalSignature);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeDigitalSignature update(
		EmployeeDigitalSignature employeeDigitalSignature,
		ServiceContext serviceContext) {

		return getPersistence().update(
			employeeDigitalSignature, serviceContext);
	}

	/**
	 * Returns all the employee digital signatures where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee digital signatures
	 */
	public static List<EmployeeDigitalSignature> findByEmployeeId(
		long employeeId) {

		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns a range of all the employee digital signatures where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDigitalSignatureModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee digital signatures
	 * @param end the upper bound of the range of employee digital signatures (not inclusive)
	 * @return the range of matching employee digital signatures
	 */
	public static List<EmployeeDigitalSignature> findByEmployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee digital signatures where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDigitalSignatureModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee digital signatures
	 * @param end the upper bound of the range of employee digital signatures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee digital signatures
	 */
	public static List<EmployeeDigitalSignature> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeDigitalSignature> orderByComparator) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee digital signatures where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDigitalSignatureModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee digital signatures
	 * @param end the upper bound of the range of employee digital signatures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee digital signatures
	 */
	public static List<EmployeeDigitalSignature> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeDigitalSignature> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee digital signature in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee digital signature
	 * @throws NoSuchEmployeeDigitalSignatureException if a matching employee digital signature could not be found
	 */
	public static EmployeeDigitalSignature findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeDigitalSignature> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeDigitalSignatureException {

		return getPersistence().findByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first employee digital signature in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee digital signature, or <code>null</code> if a matching employee digital signature could not be found
	 */
	public static EmployeeDigitalSignature fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<EmployeeDigitalSignature> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee digital signature in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee digital signature
	 * @throws NoSuchEmployeeDigitalSignatureException if a matching employee digital signature could not be found
	 */
	public static EmployeeDigitalSignature findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeDigitalSignature> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeDigitalSignatureException {

		return getPersistence().findByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee digital signature in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee digital signature, or <code>null</code> if a matching employee digital signature could not be found
	 */
	public static EmployeeDigitalSignature fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<EmployeeDigitalSignature> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the employee digital signatures before and after the current employee digital signature in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeDigitalSignatureId the primary key of the current employee digital signature
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee digital signature
	 * @throws NoSuchEmployeeDigitalSignatureException if a employee digital signature with the primary key could not be found
	 */
	public static EmployeeDigitalSignature[] findByEmployeeId_PrevAndNext(
			long employeeDigitalSignatureId, long employeeId,
			OrderByComparator<EmployeeDigitalSignature> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeDigitalSignatureException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			employeeDigitalSignatureId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the employee digital signatures where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of employee digital signatures where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee digital signatures
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Returns all the employee digital signatures where cid = &#63;.
	 *
	 * @param cid the cid
	 * @return the matching employee digital signatures
	 */
	public static List<EmployeeDigitalSignature> findByCid(String cid) {
		return getPersistence().findByCid(cid);
	}

	/**
	 * Returns a range of all the employee digital signatures where cid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDigitalSignatureModelImpl</code>.
	 * </p>
	 *
	 * @param cid the cid
	 * @param start the lower bound of the range of employee digital signatures
	 * @param end the upper bound of the range of employee digital signatures (not inclusive)
	 * @return the range of matching employee digital signatures
	 */
	public static List<EmployeeDigitalSignature> findByCid(
		String cid, int start, int end) {

		return getPersistence().findByCid(cid, start, end);
	}

	/**
	 * Returns an ordered range of all the employee digital signatures where cid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDigitalSignatureModelImpl</code>.
	 * </p>
	 *
	 * @param cid the cid
	 * @param start the lower bound of the range of employee digital signatures
	 * @param end the upper bound of the range of employee digital signatures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee digital signatures
	 */
	public static List<EmployeeDigitalSignature> findByCid(
		String cid, int start, int end,
		OrderByComparator<EmployeeDigitalSignature> orderByComparator) {

		return getPersistence().findByCid(cid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee digital signatures where cid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDigitalSignatureModelImpl</code>.
	 * </p>
	 *
	 * @param cid the cid
	 * @param start the lower bound of the range of employee digital signatures
	 * @param end the upper bound of the range of employee digital signatures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee digital signatures
	 */
	public static List<EmployeeDigitalSignature> findByCid(
		String cid, int start, int end,
		OrderByComparator<EmployeeDigitalSignature> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCid(
			cid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee digital signature in the ordered set where cid = &#63;.
	 *
	 * @param cid the cid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee digital signature
	 * @throws NoSuchEmployeeDigitalSignatureException if a matching employee digital signature could not be found
	 */
	public static EmployeeDigitalSignature findByCid_First(
			String cid,
			OrderByComparator<EmployeeDigitalSignature> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeDigitalSignatureException {

		return getPersistence().findByCid_First(cid, orderByComparator);
	}

	/**
	 * Returns the first employee digital signature in the ordered set where cid = &#63;.
	 *
	 * @param cid the cid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee digital signature, or <code>null</code> if a matching employee digital signature could not be found
	 */
	public static EmployeeDigitalSignature fetchByCid_First(
		String cid,
		OrderByComparator<EmployeeDigitalSignature> orderByComparator) {

		return getPersistence().fetchByCid_First(cid, orderByComparator);
	}

	/**
	 * Returns the last employee digital signature in the ordered set where cid = &#63;.
	 *
	 * @param cid the cid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee digital signature
	 * @throws NoSuchEmployeeDigitalSignatureException if a matching employee digital signature could not be found
	 */
	public static EmployeeDigitalSignature findByCid_Last(
			String cid,
			OrderByComparator<EmployeeDigitalSignature> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeDigitalSignatureException {

		return getPersistence().findByCid_Last(cid, orderByComparator);
	}

	/**
	 * Returns the last employee digital signature in the ordered set where cid = &#63;.
	 *
	 * @param cid the cid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee digital signature, or <code>null</code> if a matching employee digital signature could not be found
	 */
	public static EmployeeDigitalSignature fetchByCid_Last(
		String cid,
		OrderByComparator<EmployeeDigitalSignature> orderByComparator) {

		return getPersistence().fetchByCid_Last(cid, orderByComparator);
	}

	/**
	 * Returns the employee digital signatures before and after the current employee digital signature in the ordered set where cid = &#63;.
	 *
	 * @param employeeDigitalSignatureId the primary key of the current employee digital signature
	 * @param cid the cid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee digital signature
	 * @throws NoSuchEmployeeDigitalSignatureException if a employee digital signature with the primary key could not be found
	 */
	public static EmployeeDigitalSignature[] findByCid_PrevAndNext(
			long employeeDigitalSignatureId, String cid,
			OrderByComparator<EmployeeDigitalSignature> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeDigitalSignatureException {

		return getPersistence().findByCid_PrevAndNext(
			employeeDigitalSignatureId, cid, orderByComparator);
	}

	/**
	 * Removes all the employee digital signatures where cid = &#63; from the database.
	 *
	 * @param cid the cid
	 */
	public static void removeByCid(String cid) {
		getPersistence().removeByCid(cid);
	}

	/**
	 * Returns the number of employee digital signatures where cid = &#63;.
	 *
	 * @param cid the cid
	 * @return the number of matching employee digital signatures
	 */
	public static int countByCid(String cid) {
		return getPersistence().countByCid(cid);
	}

	/**
	 * Caches the employee digital signature in the entity cache if it is enabled.
	 *
	 * @param employeeDigitalSignature the employee digital signature
	 */
	public static void cacheResult(
		EmployeeDigitalSignature employeeDigitalSignature) {

		getPersistence().cacheResult(employeeDigitalSignature);
	}

	/**
	 * Caches the employee digital signatures in the entity cache if it is enabled.
	 *
	 * @param employeeDigitalSignatures the employee digital signatures
	 */
	public static void cacheResult(
		List<EmployeeDigitalSignature> employeeDigitalSignatures) {

		getPersistence().cacheResult(employeeDigitalSignatures);
	}

	/**
	 * Creates a new employee digital signature with the primary key. Does not add the employee digital signature to the database.
	 *
	 * @param employeeDigitalSignatureId the primary key for the new employee digital signature
	 * @return the new employee digital signature
	 */
	public static EmployeeDigitalSignature create(
		long employeeDigitalSignatureId) {

		return getPersistence().create(employeeDigitalSignatureId);
	}

	/**
	 * Removes the employee digital signature with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeDigitalSignatureId the primary key of the employee digital signature
	 * @return the employee digital signature that was removed
	 * @throws NoSuchEmployeeDigitalSignatureException if a employee digital signature with the primary key could not be found
	 */
	public static EmployeeDigitalSignature remove(
			long employeeDigitalSignatureId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeDigitalSignatureException {

		return getPersistence().remove(employeeDigitalSignatureId);
	}

	public static EmployeeDigitalSignature updateImpl(
		EmployeeDigitalSignature employeeDigitalSignature) {

		return getPersistence().updateImpl(employeeDigitalSignature);
	}

	/**
	 * Returns the employee digital signature with the primary key or throws a <code>NoSuchEmployeeDigitalSignatureException</code> if it could not be found.
	 *
	 * @param employeeDigitalSignatureId the primary key of the employee digital signature
	 * @return the employee digital signature
	 * @throws NoSuchEmployeeDigitalSignatureException if a employee digital signature with the primary key could not be found
	 */
	public static EmployeeDigitalSignature findByPrimaryKey(
			long employeeDigitalSignatureId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeDigitalSignatureException {

		return getPersistence().findByPrimaryKey(employeeDigitalSignatureId);
	}

	/**
	 * Returns the employee digital signature with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeDigitalSignatureId the primary key of the employee digital signature
	 * @return the employee digital signature, or <code>null</code> if a employee digital signature with the primary key could not be found
	 */
	public static EmployeeDigitalSignature fetchByPrimaryKey(
		long employeeDigitalSignatureId) {

		return getPersistence().fetchByPrimaryKey(employeeDigitalSignatureId);
	}

	/**
	 * Returns all the employee digital signatures.
	 *
	 * @return the employee digital signatures
	 */
	public static List<EmployeeDigitalSignature> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employee digital signatures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDigitalSignatureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee digital signatures
	 * @param end the upper bound of the range of employee digital signatures (not inclusive)
	 * @return the range of employee digital signatures
	 */
	public static List<EmployeeDigitalSignature> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employee digital signatures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDigitalSignatureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee digital signatures
	 * @param end the upper bound of the range of employee digital signatures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee digital signatures
	 */
	public static List<EmployeeDigitalSignature> findAll(
		int start, int end,
		OrderByComparator<EmployeeDigitalSignature> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee digital signatures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDigitalSignatureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee digital signatures
	 * @param end the upper bound of the range of employee digital signatures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee digital signatures
	 */
	public static List<EmployeeDigitalSignature> findAll(
		int start, int end,
		OrderByComparator<EmployeeDigitalSignature> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee digital signatures from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee digital signatures.
	 *
	 * @return the number of employee digital signatures
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeDigitalSignaturePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeeDigitalSignaturePersistence,
		 EmployeeDigitalSignaturePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EmployeeDigitalSignaturePersistence.class);

		ServiceTracker
			<EmployeeDigitalSignaturePersistence,
			 EmployeeDigitalSignaturePersistence> serviceTracker =
				new ServiceTracker
					<EmployeeDigitalSignaturePersistence,
					 EmployeeDigitalSignaturePersistence>(
						 bundle.getBundleContext(),
						 EmployeeDigitalSignaturePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}