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

import com.adjecti.mdm.liferay.model.CourseCategory;

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
 * The persistence utility for the course category service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.CourseCategoryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CourseCategoryPersistence
 * @generated
 */
public class CourseCategoryUtil {

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
	public static void clearCache(CourseCategory courseCategory) {
		getPersistence().clearCache(courseCategory);
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
	public static Map<Serializable, CourseCategory> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CourseCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CourseCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CourseCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CourseCategory> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CourseCategory update(CourseCategory courseCategory) {
		return getPersistence().update(courseCategory);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CourseCategory update(
		CourseCategory courseCategory, ServiceContext serviceContext) {

		return getPersistence().update(courseCategory, serviceContext);
	}

	/**
	 * Caches the course category in the entity cache if it is enabled.
	 *
	 * @param courseCategory the course category
	 */
	public static void cacheResult(CourseCategory courseCategory) {
		getPersistence().cacheResult(courseCategory);
	}

	/**
	 * Caches the course categories in the entity cache if it is enabled.
	 *
	 * @param courseCategories the course categories
	 */
	public static void cacheResult(List<CourseCategory> courseCategories) {
		getPersistence().cacheResult(courseCategories);
	}

	/**
	 * Creates a new course category with the primary key. Does not add the course category to the database.
	 *
	 * @param courseCategoryId the primary key for the new course category
	 * @return the new course category
	 */
	public static CourseCategory create(long courseCategoryId) {
		return getPersistence().create(courseCategoryId);
	}

	/**
	 * Removes the course category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param courseCategoryId the primary key of the course category
	 * @return the course category that was removed
	 * @throws NoSuchCourseCategoryException if a course category with the primary key could not be found
	 */
	public static CourseCategory remove(long courseCategoryId)
		throws com.adjecti.mdm.liferay.exception.NoSuchCourseCategoryException {

		return getPersistence().remove(courseCategoryId);
	}

	public static CourseCategory updateImpl(CourseCategory courseCategory) {
		return getPersistence().updateImpl(courseCategory);
	}

	/**
	 * Returns the course category with the primary key or throws a <code>NoSuchCourseCategoryException</code> if it could not be found.
	 *
	 * @param courseCategoryId the primary key of the course category
	 * @return the course category
	 * @throws NoSuchCourseCategoryException if a course category with the primary key could not be found
	 */
	public static CourseCategory findByPrimaryKey(long courseCategoryId)
		throws com.adjecti.mdm.liferay.exception.NoSuchCourseCategoryException {

		return getPersistence().findByPrimaryKey(courseCategoryId);
	}

	/**
	 * Returns the course category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param courseCategoryId the primary key of the course category
	 * @return the course category, or <code>null</code> if a course category with the primary key could not be found
	 */
	public static CourseCategory fetchByPrimaryKey(long courseCategoryId) {
		return getPersistence().fetchByPrimaryKey(courseCategoryId);
	}

	/**
	 * Returns all the course categories.
	 *
	 * @return the course categories
	 */
	public static List<CourseCategory> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the course categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CourseCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of course categories
	 * @param end the upper bound of the range of course categories (not inclusive)
	 * @return the range of course categories
	 */
	public static List<CourseCategory> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the course categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CourseCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of course categories
	 * @param end the upper bound of the range of course categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of course categories
	 */
	public static List<CourseCategory> findAll(
		int start, int end,
		OrderByComparator<CourseCategory> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the course categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CourseCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of course categories
	 * @param end the upper bound of the range of course categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of course categories
	 */
	public static List<CourseCategory> findAll(
		int start, int end, OrderByComparator<CourseCategory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the course categories from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of course categories.
	 *
	 * @return the number of course categories
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CourseCategoryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CourseCategoryPersistence, CourseCategoryPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CourseCategoryPersistence.class);

		ServiceTracker<CourseCategoryPersistence, CourseCategoryPersistence>
			serviceTracker =
				new ServiceTracker
					<CourseCategoryPersistence, CourseCategoryPersistence>(
						bundle.getBundleContext(),
						CourseCategoryPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}