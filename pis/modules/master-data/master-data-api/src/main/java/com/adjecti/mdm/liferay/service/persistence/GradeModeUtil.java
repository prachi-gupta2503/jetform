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

import com.adjecti.mdm.liferay.model.GradeMode;

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
 * The persistence utility for the grade mode service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.GradeModePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GradeModePersistence
 * @generated
 */
public class GradeModeUtil {

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
	public static void clearCache(GradeMode gradeMode) {
		getPersistence().clearCache(gradeMode);
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
	public static Map<Serializable, GradeMode> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<GradeMode> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GradeMode> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GradeMode> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<GradeMode> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static GradeMode update(GradeMode gradeMode) {
		return getPersistence().update(gradeMode);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static GradeMode update(
		GradeMode gradeMode, ServiceContext serviceContext) {

		return getPersistence().update(gradeMode, serviceContext);
	}

	/**
	 * Caches the grade mode in the entity cache if it is enabled.
	 *
	 * @param gradeMode the grade mode
	 */
	public static void cacheResult(GradeMode gradeMode) {
		getPersistence().cacheResult(gradeMode);
	}

	/**
	 * Caches the grade modes in the entity cache if it is enabled.
	 *
	 * @param gradeModes the grade modes
	 */
	public static void cacheResult(List<GradeMode> gradeModes) {
		getPersistence().cacheResult(gradeModes);
	}

	/**
	 * Creates a new grade mode with the primary key. Does not add the grade mode to the database.
	 *
	 * @param gradeModeId the primary key for the new grade mode
	 * @return the new grade mode
	 */
	public static GradeMode create(long gradeModeId) {
		return getPersistence().create(gradeModeId);
	}

	/**
	 * Removes the grade mode with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param gradeModeId the primary key of the grade mode
	 * @return the grade mode that was removed
	 * @throws NoSuchGradeModeException if a grade mode with the primary key could not be found
	 */
	public static GradeMode remove(long gradeModeId)
		throws com.adjecti.mdm.liferay.exception.NoSuchGradeModeException {

		return getPersistence().remove(gradeModeId);
	}

	public static GradeMode updateImpl(GradeMode gradeMode) {
		return getPersistence().updateImpl(gradeMode);
	}

	/**
	 * Returns the grade mode with the primary key or throws a <code>NoSuchGradeModeException</code> if it could not be found.
	 *
	 * @param gradeModeId the primary key of the grade mode
	 * @return the grade mode
	 * @throws NoSuchGradeModeException if a grade mode with the primary key could not be found
	 */
	public static GradeMode findByPrimaryKey(long gradeModeId)
		throws com.adjecti.mdm.liferay.exception.NoSuchGradeModeException {

		return getPersistence().findByPrimaryKey(gradeModeId);
	}

	/**
	 * Returns the grade mode with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param gradeModeId the primary key of the grade mode
	 * @return the grade mode, or <code>null</code> if a grade mode with the primary key could not be found
	 */
	public static GradeMode fetchByPrimaryKey(long gradeModeId) {
		return getPersistence().fetchByPrimaryKey(gradeModeId);
	}

	/**
	 * Returns all the grade modes.
	 *
	 * @return the grade modes
	 */
	public static List<GradeMode> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the grade modes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GradeModeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of grade modes
	 * @param end the upper bound of the range of grade modes (not inclusive)
	 * @return the range of grade modes
	 */
	public static List<GradeMode> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the grade modes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GradeModeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of grade modes
	 * @param end the upper bound of the range of grade modes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of grade modes
	 */
	public static List<GradeMode> findAll(
		int start, int end, OrderByComparator<GradeMode> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the grade modes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GradeModeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of grade modes
	 * @param end the upper bound of the range of grade modes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of grade modes
	 */
	public static List<GradeMode> findAll(
		int start, int end, OrderByComparator<GradeMode> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the grade modes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of grade modes.
	 *
	 * @return the number of grade modes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static GradeModePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<GradeModePersistence, GradeModePersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(GradeModePersistence.class);

		ServiceTracker<GradeModePersistence, GradeModePersistence>
			serviceTracker =
				new ServiceTracker<GradeModePersistence, GradeModePersistence>(
					bundle.getBundleContext(), GradeModePersistence.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}