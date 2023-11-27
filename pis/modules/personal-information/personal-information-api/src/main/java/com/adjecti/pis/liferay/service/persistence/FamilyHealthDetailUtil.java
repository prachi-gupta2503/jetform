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

import com.adjecti.pis.liferay.model.FamilyHealthDetail;

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
 * The persistence utility for the family health detail service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.FamilyHealthDetailPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FamilyHealthDetailPersistence
 * @generated
 */
public class FamilyHealthDetailUtil {

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
	public static void clearCache(FamilyHealthDetail familyHealthDetail) {
		getPersistence().clearCache(familyHealthDetail);
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
	public static Map<Serializable, FamilyHealthDetail> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FamilyHealthDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FamilyHealthDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FamilyHealthDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FamilyHealthDetail> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FamilyHealthDetail update(
		FamilyHealthDetail familyHealthDetail) {

		return getPersistence().update(familyHealthDetail);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FamilyHealthDetail update(
		FamilyHealthDetail familyHealthDetail, ServiceContext serviceContext) {

		return getPersistence().update(familyHealthDetail, serviceContext);
	}

	/**
	 * Caches the family health detail in the entity cache if it is enabled.
	 *
	 * @param familyHealthDetail the family health detail
	 */
	public static void cacheResult(FamilyHealthDetail familyHealthDetail) {
		getPersistence().cacheResult(familyHealthDetail);
	}

	/**
	 * Caches the family health details in the entity cache if it is enabled.
	 *
	 * @param familyHealthDetails the family health details
	 */
	public static void cacheResult(
		List<FamilyHealthDetail> familyHealthDetails) {

		getPersistence().cacheResult(familyHealthDetails);
	}

	/**
	 * Creates a new family health detail with the primary key. Does not add the family health detail to the database.
	 *
	 * @param familyHealthDetailId the primary key for the new family health detail
	 * @return the new family health detail
	 */
	public static FamilyHealthDetail create(long familyHealthDetailId) {
		return getPersistence().create(familyHealthDetailId);
	}

	/**
	 * Removes the family health detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param familyHealthDetailId the primary key of the family health detail
	 * @return the family health detail that was removed
	 * @throws NoSuchFamilyHealthDetailException if a family health detail with the primary key could not be found
	 */
	public static FamilyHealthDetail remove(long familyHealthDetailId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchFamilyHealthDetailException {

		return getPersistence().remove(familyHealthDetailId);
	}

	public static FamilyHealthDetail updateImpl(
		FamilyHealthDetail familyHealthDetail) {

		return getPersistence().updateImpl(familyHealthDetail);
	}

	/**
	 * Returns the family health detail with the primary key or throws a <code>NoSuchFamilyHealthDetailException</code> if it could not be found.
	 *
	 * @param familyHealthDetailId the primary key of the family health detail
	 * @return the family health detail
	 * @throws NoSuchFamilyHealthDetailException if a family health detail with the primary key could not be found
	 */
	public static FamilyHealthDetail findByPrimaryKey(long familyHealthDetailId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchFamilyHealthDetailException {

		return getPersistence().findByPrimaryKey(familyHealthDetailId);
	}

	/**
	 * Returns the family health detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param familyHealthDetailId the primary key of the family health detail
	 * @return the family health detail, or <code>null</code> if a family health detail with the primary key could not be found
	 */
	public static FamilyHealthDetail fetchByPrimaryKey(
		long familyHealthDetailId) {

		return getPersistence().fetchByPrimaryKey(familyHealthDetailId);
	}

	/**
	 * Returns all the family health details.
	 *
	 * @return the family health details
	 */
	public static List<FamilyHealthDetail> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the family health details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FamilyHealthDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family health details
	 * @param end the upper bound of the range of family health details (not inclusive)
	 * @return the range of family health details
	 */
	public static List<FamilyHealthDetail> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the family health details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FamilyHealthDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family health details
	 * @param end the upper bound of the range of family health details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of family health details
	 */
	public static List<FamilyHealthDetail> findAll(
		int start, int end,
		OrderByComparator<FamilyHealthDetail> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the family health details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FamilyHealthDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family health details
	 * @param end the upper bound of the range of family health details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of family health details
	 */
	public static List<FamilyHealthDetail> findAll(
		int start, int end,
		OrderByComparator<FamilyHealthDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the family health details from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of family health details.
	 *
	 * @return the number of family health details
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FamilyHealthDetailPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<FamilyHealthDetailPersistence, FamilyHealthDetailPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			FamilyHealthDetailPersistence.class);

		ServiceTracker
			<FamilyHealthDetailPersistence, FamilyHealthDetailPersistence>
				serviceTracker =
					new ServiceTracker
						<FamilyHealthDetailPersistence,
						 FamilyHealthDetailPersistence>(
							 bundle.getBundleContext(),
							 FamilyHealthDetailPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}