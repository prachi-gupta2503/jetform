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

import com.adjecti.mdm.liferay.model.VerificationType;

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
 * The persistence utility for the verification type service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.VerificationTypePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VerificationTypePersistence
 * @generated
 */
public class VerificationTypeUtil {

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
	public static void clearCache(VerificationType verificationType) {
		getPersistence().clearCache(verificationType);
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
	public static Map<Serializable, VerificationType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<VerificationType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VerificationType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VerificationType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<VerificationType> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static VerificationType update(VerificationType verificationType) {
		return getPersistence().update(verificationType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static VerificationType update(
		VerificationType verificationType, ServiceContext serviceContext) {

		return getPersistence().update(verificationType, serviceContext);
	}

	/**
	 * Caches the verification type in the entity cache if it is enabled.
	 *
	 * @param verificationType the verification type
	 */
	public static void cacheResult(VerificationType verificationType) {
		getPersistence().cacheResult(verificationType);
	}

	/**
	 * Caches the verification types in the entity cache if it is enabled.
	 *
	 * @param verificationTypes the verification types
	 */
	public static void cacheResult(List<VerificationType> verificationTypes) {
		getPersistence().cacheResult(verificationTypes);
	}

	/**
	 * Creates a new verification type with the primary key. Does not add the verification type to the database.
	 *
	 * @param verificationTypeId the primary key for the new verification type
	 * @return the new verification type
	 */
	public static VerificationType create(long verificationTypeId) {
		return getPersistence().create(verificationTypeId);
	}

	/**
	 * Removes the verification type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param verificationTypeId the primary key of the verification type
	 * @return the verification type that was removed
	 * @throws NoSuchVerificationTypeException if a verification type with the primary key could not be found
	 */
	public static VerificationType remove(long verificationTypeId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchVerificationTypeException {

		return getPersistence().remove(verificationTypeId);
	}

	public static VerificationType updateImpl(
		VerificationType verificationType) {

		return getPersistence().updateImpl(verificationType);
	}

	/**
	 * Returns the verification type with the primary key or throws a <code>NoSuchVerificationTypeException</code> if it could not be found.
	 *
	 * @param verificationTypeId the primary key of the verification type
	 * @return the verification type
	 * @throws NoSuchVerificationTypeException if a verification type with the primary key could not be found
	 */
	public static VerificationType findByPrimaryKey(long verificationTypeId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchVerificationTypeException {

		return getPersistence().findByPrimaryKey(verificationTypeId);
	}

	/**
	 * Returns the verification type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param verificationTypeId the primary key of the verification type
	 * @return the verification type, or <code>null</code> if a verification type with the primary key could not be found
	 */
	public static VerificationType fetchByPrimaryKey(long verificationTypeId) {
		return getPersistence().fetchByPrimaryKey(verificationTypeId);
	}

	/**
	 * Returns all the verification types.
	 *
	 * @return the verification types
	 */
	public static List<VerificationType> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the verification types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of verification types
	 * @param end the upper bound of the range of verification types (not inclusive)
	 * @return the range of verification types
	 */
	public static List<VerificationType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the verification types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of verification types
	 * @param end the upper bound of the range of verification types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of verification types
	 */
	public static List<VerificationType> findAll(
		int start, int end,
		OrderByComparator<VerificationType> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the verification types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VerificationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of verification types
	 * @param end the upper bound of the range of verification types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of verification types
	 */
	public static List<VerificationType> findAll(
		int start, int end,
		OrderByComparator<VerificationType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the verification types from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of verification types.
	 *
	 * @return the number of verification types
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static VerificationTypePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<VerificationTypePersistence, VerificationTypePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			VerificationTypePersistence.class);

		ServiceTracker<VerificationTypePersistence, VerificationTypePersistence>
			serviceTracker =
				new ServiceTracker
					<VerificationTypePersistence, VerificationTypePersistence>(
						bundle.getBundleContext(),
						VerificationTypePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}