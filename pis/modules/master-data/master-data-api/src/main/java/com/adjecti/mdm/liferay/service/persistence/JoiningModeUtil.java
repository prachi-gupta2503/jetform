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

import com.adjecti.mdm.liferay.model.JoiningMode;

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
 * The persistence utility for the joining mode service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.JoiningModePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JoiningModePersistence
 * @generated
 */
public class JoiningModeUtil {

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
	public static void clearCache(JoiningMode joiningMode) {
		getPersistence().clearCache(joiningMode);
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
	public static Map<Serializable, JoiningMode> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<JoiningMode> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<JoiningMode> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<JoiningMode> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<JoiningMode> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static JoiningMode update(JoiningMode joiningMode) {
		return getPersistence().update(joiningMode);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static JoiningMode update(
		JoiningMode joiningMode, ServiceContext serviceContext) {

		return getPersistence().update(joiningMode, serviceContext);
	}

	/**
	 * Caches the joining mode in the entity cache if it is enabled.
	 *
	 * @param joiningMode the joining mode
	 */
	public static void cacheResult(JoiningMode joiningMode) {
		getPersistence().cacheResult(joiningMode);
	}

	/**
	 * Caches the joining modes in the entity cache if it is enabled.
	 *
	 * @param joiningModes the joining modes
	 */
	public static void cacheResult(List<JoiningMode> joiningModes) {
		getPersistence().cacheResult(joiningModes);
	}

	/**
	 * Creates a new joining mode with the primary key. Does not add the joining mode to the database.
	 *
	 * @param joiningModeId the primary key for the new joining mode
	 * @return the new joining mode
	 */
	public static JoiningMode create(long joiningModeId) {
		return getPersistence().create(joiningModeId);
	}

	/**
	 * Removes the joining mode with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param joiningModeId the primary key of the joining mode
	 * @return the joining mode that was removed
	 * @throws NoSuchJoiningModeException if a joining mode with the primary key could not be found
	 */
	public static JoiningMode remove(long joiningModeId)
		throws com.adjecti.mdm.liferay.exception.NoSuchJoiningModeException {

		return getPersistence().remove(joiningModeId);
	}

	public static JoiningMode updateImpl(JoiningMode joiningMode) {
		return getPersistence().updateImpl(joiningMode);
	}

	/**
	 * Returns the joining mode with the primary key or throws a <code>NoSuchJoiningModeException</code> if it could not be found.
	 *
	 * @param joiningModeId the primary key of the joining mode
	 * @return the joining mode
	 * @throws NoSuchJoiningModeException if a joining mode with the primary key could not be found
	 */
	public static JoiningMode findByPrimaryKey(long joiningModeId)
		throws com.adjecti.mdm.liferay.exception.NoSuchJoiningModeException {

		return getPersistence().findByPrimaryKey(joiningModeId);
	}

	/**
	 * Returns the joining mode with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param joiningModeId the primary key of the joining mode
	 * @return the joining mode, or <code>null</code> if a joining mode with the primary key could not be found
	 */
	public static JoiningMode fetchByPrimaryKey(long joiningModeId) {
		return getPersistence().fetchByPrimaryKey(joiningModeId);
	}

	/**
	 * Returns all the joining modes.
	 *
	 * @return the joining modes
	 */
	public static List<JoiningMode> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the joining modes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningModeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of joining modes
	 * @param end the upper bound of the range of joining modes (not inclusive)
	 * @return the range of joining modes
	 */
	public static List<JoiningMode> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the joining modes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningModeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of joining modes
	 * @param end the upper bound of the range of joining modes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of joining modes
	 */
	public static List<JoiningMode> findAll(
		int start, int end, OrderByComparator<JoiningMode> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the joining modes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JoiningModeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of joining modes
	 * @param end the upper bound of the range of joining modes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of joining modes
	 */
	public static List<JoiningMode> findAll(
		int start, int end, OrderByComparator<JoiningMode> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the joining modes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of joining modes.
	 *
	 * @return the number of joining modes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static JoiningModePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<JoiningModePersistence, JoiningModePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(JoiningModePersistence.class);

		ServiceTracker<JoiningModePersistence, JoiningModePersistence>
			serviceTracker =
				new ServiceTracker
					<JoiningModePersistence, JoiningModePersistence>(
						bundle.getBundleContext(), JoiningModePersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}