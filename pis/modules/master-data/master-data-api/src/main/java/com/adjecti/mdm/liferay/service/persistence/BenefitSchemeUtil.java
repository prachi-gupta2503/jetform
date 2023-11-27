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

import com.adjecti.mdm.liferay.model.BenefitScheme;

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
 * The persistence utility for the benefit scheme service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.BenefitSchemePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BenefitSchemePersistence
 * @generated
 */
public class BenefitSchemeUtil {

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
	public static void clearCache(BenefitScheme benefitScheme) {
		getPersistence().clearCache(benefitScheme);
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
	public static Map<Serializable, BenefitScheme> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<BenefitScheme> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BenefitScheme> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BenefitScheme> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<BenefitScheme> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static BenefitScheme update(BenefitScheme benefitScheme) {
		return getPersistence().update(benefitScheme);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static BenefitScheme update(
		BenefitScheme benefitScheme, ServiceContext serviceContext) {

		return getPersistence().update(benefitScheme, serviceContext);
	}

	/**
	 * Caches the benefit scheme in the entity cache if it is enabled.
	 *
	 * @param benefitScheme the benefit scheme
	 */
	public static void cacheResult(BenefitScheme benefitScheme) {
		getPersistence().cacheResult(benefitScheme);
	}

	/**
	 * Caches the benefit schemes in the entity cache if it is enabled.
	 *
	 * @param benefitSchemes the benefit schemes
	 */
	public static void cacheResult(List<BenefitScheme> benefitSchemes) {
		getPersistence().cacheResult(benefitSchemes);
	}

	/**
	 * Creates a new benefit scheme with the primary key. Does not add the benefit scheme to the database.
	 *
	 * @param benefitSchemeId the primary key for the new benefit scheme
	 * @return the new benefit scheme
	 */
	public static BenefitScheme create(long benefitSchemeId) {
		return getPersistence().create(benefitSchemeId);
	}

	/**
	 * Removes the benefit scheme with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param benefitSchemeId the primary key of the benefit scheme
	 * @return the benefit scheme that was removed
	 * @throws NoSuchBenefitSchemeException if a benefit scheme with the primary key could not be found
	 */
	public static BenefitScheme remove(long benefitSchemeId)
		throws com.adjecti.mdm.liferay.exception.NoSuchBenefitSchemeException {

		return getPersistence().remove(benefitSchemeId);
	}

	public static BenefitScheme updateImpl(BenefitScheme benefitScheme) {
		return getPersistence().updateImpl(benefitScheme);
	}

	/**
	 * Returns the benefit scheme with the primary key or throws a <code>NoSuchBenefitSchemeException</code> if it could not be found.
	 *
	 * @param benefitSchemeId the primary key of the benefit scheme
	 * @return the benefit scheme
	 * @throws NoSuchBenefitSchemeException if a benefit scheme with the primary key could not be found
	 */
	public static BenefitScheme findByPrimaryKey(long benefitSchemeId)
		throws com.adjecti.mdm.liferay.exception.NoSuchBenefitSchemeException {

		return getPersistence().findByPrimaryKey(benefitSchemeId);
	}

	/**
	 * Returns the benefit scheme with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param benefitSchemeId the primary key of the benefit scheme
	 * @return the benefit scheme, or <code>null</code> if a benefit scheme with the primary key could not be found
	 */
	public static BenefitScheme fetchByPrimaryKey(long benefitSchemeId) {
		return getPersistence().fetchByPrimaryKey(benefitSchemeId);
	}

	/**
	 * Returns all the benefit schemes.
	 *
	 * @return the benefit schemes
	 */
	public static List<BenefitScheme> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the benefit schemes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BenefitSchemeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of benefit schemes
	 * @param end the upper bound of the range of benefit schemes (not inclusive)
	 * @return the range of benefit schemes
	 */
	public static List<BenefitScheme> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the benefit schemes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BenefitSchemeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of benefit schemes
	 * @param end the upper bound of the range of benefit schemes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of benefit schemes
	 */
	public static List<BenefitScheme> findAll(
		int start, int end,
		OrderByComparator<BenefitScheme> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the benefit schemes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BenefitSchemeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of benefit schemes
	 * @param end the upper bound of the range of benefit schemes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of benefit schemes
	 */
	public static List<BenefitScheme> findAll(
		int start, int end, OrderByComparator<BenefitScheme> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the benefit schemes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of benefit schemes.
	 *
	 * @return the number of benefit schemes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BenefitSchemePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<BenefitSchemePersistence, BenefitSchemePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(BenefitSchemePersistence.class);

		ServiceTracker<BenefitSchemePersistence, BenefitSchemePersistence>
			serviceTracker =
				new ServiceTracker
					<BenefitSchemePersistence, BenefitSchemePersistence>(
						bundle.getBundleContext(),
						BenefitSchemePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}