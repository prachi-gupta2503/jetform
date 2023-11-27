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

import com.adjecti.pis.liferay.model.FamilyServiceDetail;

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
 * The persistence utility for the family service detail service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.FamilyServiceDetailPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FamilyServiceDetailPersistence
 * @generated
 */
public class FamilyServiceDetailUtil {

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
	public static void clearCache(FamilyServiceDetail familyServiceDetail) {
		getPersistence().clearCache(familyServiceDetail);
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
	public static Map<Serializable, FamilyServiceDetail> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FamilyServiceDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FamilyServiceDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FamilyServiceDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FamilyServiceDetail> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FamilyServiceDetail update(
		FamilyServiceDetail familyServiceDetail) {

		return getPersistence().update(familyServiceDetail);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FamilyServiceDetail update(
		FamilyServiceDetail familyServiceDetail,
		ServiceContext serviceContext) {

		return getPersistence().update(familyServiceDetail, serviceContext);
	}

	/**
	 * Caches the family service detail in the entity cache if it is enabled.
	 *
	 * @param familyServiceDetail the family service detail
	 */
	public static void cacheResult(FamilyServiceDetail familyServiceDetail) {
		getPersistence().cacheResult(familyServiceDetail);
	}

	/**
	 * Caches the family service details in the entity cache if it is enabled.
	 *
	 * @param familyServiceDetails the family service details
	 */
	public static void cacheResult(
		List<FamilyServiceDetail> familyServiceDetails) {

		getPersistence().cacheResult(familyServiceDetails);
	}

	/**
	 * Creates a new family service detail with the primary key. Does not add the family service detail to the database.
	 *
	 * @param familyServiceDetailId the primary key for the new family service detail
	 * @return the new family service detail
	 */
	public static FamilyServiceDetail create(long familyServiceDetailId) {
		return getPersistence().create(familyServiceDetailId);
	}

	/**
	 * Removes the family service detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param familyServiceDetailId the primary key of the family service detail
	 * @return the family service detail that was removed
	 * @throws NoSuchFamilyServiceDetailException if a family service detail with the primary key could not be found
	 */
	public static FamilyServiceDetail remove(long familyServiceDetailId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchFamilyServiceDetailException {

		return getPersistence().remove(familyServiceDetailId);
	}

	public static FamilyServiceDetail updateImpl(
		FamilyServiceDetail familyServiceDetail) {

		return getPersistence().updateImpl(familyServiceDetail);
	}

	/**
	 * Returns the family service detail with the primary key or throws a <code>NoSuchFamilyServiceDetailException</code> if it could not be found.
	 *
	 * @param familyServiceDetailId the primary key of the family service detail
	 * @return the family service detail
	 * @throws NoSuchFamilyServiceDetailException if a family service detail with the primary key could not be found
	 */
	public static FamilyServiceDetail findByPrimaryKey(
			long familyServiceDetailId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchFamilyServiceDetailException {

		return getPersistence().findByPrimaryKey(familyServiceDetailId);
	}

	/**
	 * Returns the family service detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param familyServiceDetailId the primary key of the family service detail
	 * @return the family service detail, or <code>null</code> if a family service detail with the primary key could not be found
	 */
	public static FamilyServiceDetail fetchByPrimaryKey(
		long familyServiceDetailId) {

		return getPersistence().fetchByPrimaryKey(familyServiceDetailId);
	}

	/**
	 * Returns all the family service details.
	 *
	 * @return the family service details
	 */
	public static List<FamilyServiceDetail> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the family service details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FamilyServiceDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family service details
	 * @param end the upper bound of the range of family service details (not inclusive)
	 * @return the range of family service details
	 */
	public static List<FamilyServiceDetail> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the family service details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FamilyServiceDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family service details
	 * @param end the upper bound of the range of family service details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of family service details
	 */
	public static List<FamilyServiceDetail> findAll(
		int start, int end,
		OrderByComparator<FamilyServiceDetail> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the family service details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FamilyServiceDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family service details
	 * @param end the upper bound of the range of family service details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of family service details
	 */
	public static List<FamilyServiceDetail> findAll(
		int start, int end,
		OrderByComparator<FamilyServiceDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the family service details from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of family service details.
	 *
	 * @return the number of family service details
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FamilyServiceDetailPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<FamilyServiceDetailPersistence, FamilyServiceDetailPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			FamilyServiceDetailPersistence.class);

		ServiceTracker
			<FamilyServiceDetailPersistence, FamilyServiceDetailPersistence>
				serviceTracker =
					new ServiceTracker
						<FamilyServiceDetailPersistence,
						 FamilyServiceDetailPersistence>(
							 bundle.getBundleContext(),
							 FamilyServiceDetailPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}