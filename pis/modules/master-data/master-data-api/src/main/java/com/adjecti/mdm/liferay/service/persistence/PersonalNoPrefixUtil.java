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

import com.adjecti.mdm.liferay.model.PersonalNoPrefix;

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
 * The persistence utility for the personal no prefix service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.PersonalNoPrefixPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersonalNoPrefixPersistence
 * @generated
 */
public class PersonalNoPrefixUtil {

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
	public static void clearCache(PersonalNoPrefix personalNoPrefix) {
		getPersistence().clearCache(personalNoPrefix);
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
	public static Map<Serializable, PersonalNoPrefix> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PersonalNoPrefix> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PersonalNoPrefix> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PersonalNoPrefix> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PersonalNoPrefix> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PersonalNoPrefix update(PersonalNoPrefix personalNoPrefix) {
		return getPersistence().update(personalNoPrefix);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PersonalNoPrefix update(
		PersonalNoPrefix personalNoPrefix, ServiceContext serviceContext) {

		return getPersistence().update(personalNoPrefix, serviceContext);
	}

	/**
	 * Caches the personal no prefix in the entity cache if it is enabled.
	 *
	 * @param personalNoPrefix the personal no prefix
	 */
	public static void cacheResult(PersonalNoPrefix personalNoPrefix) {
		getPersistence().cacheResult(personalNoPrefix);
	}

	/**
	 * Caches the personal no prefixes in the entity cache if it is enabled.
	 *
	 * @param personalNoPrefixes the personal no prefixes
	 */
	public static void cacheResult(List<PersonalNoPrefix> personalNoPrefixes) {
		getPersistence().cacheResult(personalNoPrefixes);
	}

	/**
	 * Creates a new personal no prefix with the primary key. Does not add the personal no prefix to the database.
	 *
	 * @param personalNoPrefixId the primary key for the new personal no prefix
	 * @return the new personal no prefix
	 */
	public static PersonalNoPrefix create(long personalNoPrefixId) {
		return getPersistence().create(personalNoPrefixId);
	}

	/**
	 * Removes the personal no prefix with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param personalNoPrefixId the primary key of the personal no prefix
	 * @return the personal no prefix that was removed
	 * @throws NoSuchPersonalNoPrefixException if a personal no prefix with the primary key could not be found
	 */
	public static PersonalNoPrefix remove(long personalNoPrefixId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchPersonalNoPrefixException {

		return getPersistence().remove(personalNoPrefixId);
	}

	public static PersonalNoPrefix updateImpl(
		PersonalNoPrefix personalNoPrefix) {

		return getPersistence().updateImpl(personalNoPrefix);
	}

	/**
	 * Returns the personal no prefix with the primary key or throws a <code>NoSuchPersonalNoPrefixException</code> if it could not be found.
	 *
	 * @param personalNoPrefixId the primary key of the personal no prefix
	 * @return the personal no prefix
	 * @throws NoSuchPersonalNoPrefixException if a personal no prefix with the primary key could not be found
	 */
	public static PersonalNoPrefix findByPrimaryKey(long personalNoPrefixId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchPersonalNoPrefixException {

		return getPersistence().findByPrimaryKey(personalNoPrefixId);
	}

	/**
	 * Returns the personal no prefix with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param personalNoPrefixId the primary key of the personal no prefix
	 * @return the personal no prefix, or <code>null</code> if a personal no prefix with the primary key could not be found
	 */
	public static PersonalNoPrefix fetchByPrimaryKey(long personalNoPrefixId) {
		return getPersistence().fetchByPrimaryKey(personalNoPrefixId);
	}

	/**
	 * Returns all the personal no prefixes.
	 *
	 * @return the personal no prefixes
	 */
	public static List<PersonalNoPrefix> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the personal no prefixes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonalNoPrefixModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of personal no prefixes
	 * @param end the upper bound of the range of personal no prefixes (not inclusive)
	 * @return the range of personal no prefixes
	 */
	public static List<PersonalNoPrefix> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the personal no prefixes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonalNoPrefixModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of personal no prefixes
	 * @param end the upper bound of the range of personal no prefixes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of personal no prefixes
	 */
	public static List<PersonalNoPrefix> findAll(
		int start, int end,
		OrderByComparator<PersonalNoPrefix> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the personal no prefixes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonalNoPrefixModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of personal no prefixes
	 * @param end the upper bound of the range of personal no prefixes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of personal no prefixes
	 */
	public static List<PersonalNoPrefix> findAll(
		int start, int end,
		OrderByComparator<PersonalNoPrefix> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the personal no prefixes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of personal no prefixes.
	 *
	 * @return the number of personal no prefixes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PersonalNoPrefixPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PersonalNoPrefixPersistence, PersonalNoPrefixPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			PersonalNoPrefixPersistence.class);

		ServiceTracker<PersonalNoPrefixPersistence, PersonalNoPrefixPersistence>
			serviceTracker =
				new ServiceTracker
					<PersonalNoPrefixPersistence, PersonalNoPrefixPersistence>(
						bundle.getBundleContext(),
						PersonalNoPrefixPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}