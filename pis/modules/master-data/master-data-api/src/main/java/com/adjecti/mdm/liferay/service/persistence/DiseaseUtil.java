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

import com.adjecti.mdm.liferay.model.Disease;

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
 * The persistence utility for the disease service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.DiseasePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DiseasePersistence
 * @generated
 */
public class DiseaseUtil {

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
	public static void clearCache(Disease disease) {
		getPersistence().clearCache(disease);
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
	public static Map<Serializable, Disease> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Disease> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Disease> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Disease> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Disease> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Disease update(Disease disease) {
		return getPersistence().update(disease);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Disease update(
		Disease disease, ServiceContext serviceContext) {

		return getPersistence().update(disease, serviceContext);
	}

	/**
	 * Caches the disease in the entity cache if it is enabled.
	 *
	 * @param disease the disease
	 */
	public static void cacheResult(Disease disease) {
		getPersistence().cacheResult(disease);
	}

	/**
	 * Caches the diseases in the entity cache if it is enabled.
	 *
	 * @param diseases the diseases
	 */
	public static void cacheResult(List<Disease> diseases) {
		getPersistence().cacheResult(diseases);
	}

	/**
	 * Creates a new disease with the primary key. Does not add the disease to the database.
	 *
	 * @param diseaseId the primary key for the new disease
	 * @return the new disease
	 */
	public static Disease create(long diseaseId) {
		return getPersistence().create(diseaseId);
	}

	/**
	 * Removes the disease with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param diseaseId the primary key of the disease
	 * @return the disease that was removed
	 * @throws NoSuchDiseaseException if a disease with the primary key could not be found
	 */
	public static Disease remove(long diseaseId)
		throws com.adjecti.mdm.liferay.exception.NoSuchDiseaseException {

		return getPersistence().remove(diseaseId);
	}

	public static Disease updateImpl(Disease disease) {
		return getPersistence().updateImpl(disease);
	}

	/**
	 * Returns the disease with the primary key or throws a <code>NoSuchDiseaseException</code> if it could not be found.
	 *
	 * @param diseaseId the primary key of the disease
	 * @return the disease
	 * @throws NoSuchDiseaseException if a disease with the primary key could not be found
	 */
	public static Disease findByPrimaryKey(long diseaseId)
		throws com.adjecti.mdm.liferay.exception.NoSuchDiseaseException {

		return getPersistence().findByPrimaryKey(diseaseId);
	}

	/**
	 * Returns the disease with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param diseaseId the primary key of the disease
	 * @return the disease, or <code>null</code> if a disease with the primary key could not be found
	 */
	public static Disease fetchByPrimaryKey(long diseaseId) {
		return getPersistence().fetchByPrimaryKey(diseaseId);
	}

	/**
	 * Returns all the diseases.
	 *
	 * @return the diseases
	 */
	public static List<Disease> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the diseases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DiseaseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of diseases
	 * @param end the upper bound of the range of diseases (not inclusive)
	 * @return the range of diseases
	 */
	public static List<Disease> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the diseases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DiseaseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of diseases
	 * @param end the upper bound of the range of diseases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of diseases
	 */
	public static List<Disease> findAll(
		int start, int end, OrderByComparator<Disease> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the diseases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DiseaseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of diseases
	 * @param end the upper bound of the range of diseases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of diseases
	 */
	public static List<Disease> findAll(
		int start, int end, OrderByComparator<Disease> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the diseases from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of diseases.
	 *
	 * @return the number of diseases
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DiseasePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DiseasePersistence, DiseasePersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(DiseasePersistence.class);

		ServiceTracker<DiseasePersistence, DiseasePersistence> serviceTracker =
			new ServiceTracker<DiseasePersistence, DiseasePersistence>(
				bundle.getBundleContext(), DiseasePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}