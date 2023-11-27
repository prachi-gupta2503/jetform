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

import com.adjecti.pis.liferay.model.FamilyEducationDetail;

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
 * The persistence utility for the family education detail service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.FamilyEducationDetailPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FamilyEducationDetailPersistence
 * @generated
 */
public class FamilyEducationDetailUtil {

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
	public static void clearCache(FamilyEducationDetail familyEducationDetail) {
		getPersistence().clearCache(familyEducationDetail);
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
	public static Map<Serializable, FamilyEducationDetail> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FamilyEducationDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FamilyEducationDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FamilyEducationDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FamilyEducationDetail> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FamilyEducationDetail update(
		FamilyEducationDetail familyEducationDetail) {

		return getPersistence().update(familyEducationDetail);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FamilyEducationDetail update(
		FamilyEducationDetail familyEducationDetail,
		ServiceContext serviceContext) {

		return getPersistence().update(familyEducationDetail, serviceContext);
	}

	/**
	 * Caches the family education detail in the entity cache if it is enabled.
	 *
	 * @param familyEducationDetail the family education detail
	 */
	public static void cacheResult(
		FamilyEducationDetail familyEducationDetail) {

		getPersistence().cacheResult(familyEducationDetail);
	}

	/**
	 * Caches the family education details in the entity cache if it is enabled.
	 *
	 * @param familyEducationDetails the family education details
	 */
	public static void cacheResult(
		List<FamilyEducationDetail> familyEducationDetails) {

		getPersistence().cacheResult(familyEducationDetails);
	}

	/**
	 * Creates a new family education detail with the primary key. Does not add the family education detail to the database.
	 *
	 * @param familyEducationDetailId the primary key for the new family education detail
	 * @return the new family education detail
	 */
	public static FamilyEducationDetail create(long familyEducationDetailId) {
		return getPersistence().create(familyEducationDetailId);
	}

	/**
	 * Removes the family education detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param familyEducationDetailId the primary key of the family education detail
	 * @return the family education detail that was removed
	 * @throws NoSuchFamilyEducationDetailException if a family education detail with the primary key could not be found
	 */
	public static FamilyEducationDetail remove(long familyEducationDetailId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchFamilyEducationDetailException {

		return getPersistence().remove(familyEducationDetailId);
	}

	public static FamilyEducationDetail updateImpl(
		FamilyEducationDetail familyEducationDetail) {

		return getPersistence().updateImpl(familyEducationDetail);
	}

	/**
	 * Returns the family education detail with the primary key or throws a <code>NoSuchFamilyEducationDetailException</code> if it could not be found.
	 *
	 * @param familyEducationDetailId the primary key of the family education detail
	 * @return the family education detail
	 * @throws NoSuchFamilyEducationDetailException if a family education detail with the primary key could not be found
	 */
	public static FamilyEducationDetail findByPrimaryKey(
			long familyEducationDetailId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchFamilyEducationDetailException {

		return getPersistence().findByPrimaryKey(familyEducationDetailId);
	}

	/**
	 * Returns the family education detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param familyEducationDetailId the primary key of the family education detail
	 * @return the family education detail, or <code>null</code> if a family education detail with the primary key could not be found
	 */
	public static FamilyEducationDetail fetchByPrimaryKey(
		long familyEducationDetailId) {

		return getPersistence().fetchByPrimaryKey(familyEducationDetailId);
	}

	/**
	 * Returns all the family education details.
	 *
	 * @return the family education details
	 */
	public static List<FamilyEducationDetail> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the family education details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FamilyEducationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family education details
	 * @param end the upper bound of the range of family education details (not inclusive)
	 * @return the range of family education details
	 */
	public static List<FamilyEducationDetail> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the family education details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FamilyEducationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family education details
	 * @param end the upper bound of the range of family education details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of family education details
	 */
	public static List<FamilyEducationDetail> findAll(
		int start, int end,
		OrderByComparator<FamilyEducationDetail> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the family education details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FamilyEducationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family education details
	 * @param end the upper bound of the range of family education details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of family education details
	 */
	public static List<FamilyEducationDetail> findAll(
		int start, int end,
		OrderByComparator<FamilyEducationDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the family education details from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of family education details.
	 *
	 * @return the number of family education details
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FamilyEducationDetailPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<FamilyEducationDetailPersistence, FamilyEducationDetailPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			FamilyEducationDetailPersistence.class);

		ServiceTracker
			<FamilyEducationDetailPersistence, FamilyEducationDetailPersistence>
				serviceTracker =
					new ServiceTracker
						<FamilyEducationDetailPersistence,
						 FamilyEducationDetailPersistence>(
							 bundle.getBundleContext(),
							 FamilyEducationDetailPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}