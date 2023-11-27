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

import com.adjecti.mdm.liferay.model.TrainingCourse;

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
 * The persistence utility for the training course service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.TrainingCoursePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TrainingCoursePersistence
 * @generated
 */
public class TrainingCourseUtil {

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
	public static void clearCache(TrainingCourse trainingCourse) {
		getPersistence().clearCache(trainingCourse);
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
	public static Map<Serializable, TrainingCourse> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TrainingCourse> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TrainingCourse> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TrainingCourse> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TrainingCourse> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TrainingCourse update(TrainingCourse trainingCourse) {
		return getPersistence().update(trainingCourse);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TrainingCourse update(
		TrainingCourse trainingCourse, ServiceContext serviceContext) {

		return getPersistence().update(trainingCourse, serviceContext);
	}

	/**
	 * Returns all the training courses where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching training courses
	 */
	public static List<TrainingCourse> findByCode(String code) {
		return getPersistence().findByCode(code);
	}

	/**
	 * Returns a range of all the training courses where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingCourseModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of training courses
	 * @param end the upper bound of the range of training courses (not inclusive)
	 * @return the range of matching training courses
	 */
	public static List<TrainingCourse> findByCode(
		String code, int start, int end) {

		return getPersistence().findByCode(code, start, end);
	}

	/**
	 * Returns an ordered range of all the training courses where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingCourseModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of training courses
	 * @param end the upper bound of the range of training courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching training courses
	 */
	public static List<TrainingCourse> findByCode(
		String code, int start, int end,
		OrderByComparator<TrainingCourse> orderByComparator) {

		return getPersistence().findByCode(code, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the training courses where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingCourseModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of training courses
	 * @param end the upper bound of the range of training courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching training courses
	 */
	public static List<TrainingCourse> findByCode(
		String code, int start, int end,
		OrderByComparator<TrainingCourse> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCode(
			code, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first training course in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training course
	 * @throws NoSuchTrainingCourseException if a matching training course could not be found
	 */
	public static TrainingCourse findByCode_First(
			String code, OrderByComparator<TrainingCourse> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchTrainingCourseException {

		return getPersistence().findByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the first training course in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training course, or <code>null</code> if a matching training course could not be found
	 */
	public static TrainingCourse fetchByCode_First(
		String code, OrderByComparator<TrainingCourse> orderByComparator) {

		return getPersistence().fetchByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the last training course in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training course
	 * @throws NoSuchTrainingCourseException if a matching training course could not be found
	 */
	public static TrainingCourse findByCode_Last(
			String code, OrderByComparator<TrainingCourse> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchTrainingCourseException {

		return getPersistence().findByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the last training course in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training course, or <code>null</code> if a matching training course could not be found
	 */
	public static TrainingCourse fetchByCode_Last(
		String code, OrderByComparator<TrainingCourse> orderByComparator) {

		return getPersistence().fetchByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the training courses before and after the current training course in the ordered set where code = &#63;.
	 *
	 * @param trainingCourseId the primary key of the current training course
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next training course
	 * @throws NoSuchTrainingCourseException if a training course with the primary key could not be found
	 */
	public static TrainingCourse[] findByCode_PrevAndNext(
			long trainingCourseId, String code,
			OrderByComparator<TrainingCourse> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchTrainingCourseException {

		return getPersistence().findByCode_PrevAndNext(
			trainingCourseId, code, orderByComparator);
	}

	/**
	 * Removes all the training courses where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public static void removeByCode(String code) {
		getPersistence().removeByCode(code);
	}

	/**
	 * Returns the number of training courses where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching training courses
	 */
	public static int countByCode(String code) {
		return getPersistence().countByCode(code);
	}

	/**
	 * Returns all the training courses where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching training courses
	 */
	public static List<TrainingCourse> findByName(String name) {
		return getPersistence().findByName(name);
	}

	/**
	 * Returns a range of all the training courses where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingCourseModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of training courses
	 * @param end the upper bound of the range of training courses (not inclusive)
	 * @return the range of matching training courses
	 */
	public static List<TrainingCourse> findByName(
		String name, int start, int end) {

		return getPersistence().findByName(name, start, end);
	}

	/**
	 * Returns an ordered range of all the training courses where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingCourseModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of training courses
	 * @param end the upper bound of the range of training courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching training courses
	 */
	public static List<TrainingCourse> findByName(
		String name, int start, int end,
		OrderByComparator<TrainingCourse> orderByComparator) {

		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the training courses where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingCourseModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of training courses
	 * @param end the upper bound of the range of training courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching training courses
	 */
	public static List<TrainingCourse> findByName(
		String name, int start, int end,
		OrderByComparator<TrainingCourse> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByName(
			name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first training course in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training course
	 * @throws NoSuchTrainingCourseException if a matching training course could not be found
	 */
	public static TrainingCourse findByName_First(
			String name, OrderByComparator<TrainingCourse> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchTrainingCourseException {

		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	 * Returns the first training course in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training course, or <code>null</code> if a matching training course could not be found
	 */
	public static TrainingCourse fetchByName_First(
		String name, OrderByComparator<TrainingCourse> orderByComparator) {

		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	 * Returns the last training course in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training course
	 * @throws NoSuchTrainingCourseException if a matching training course could not be found
	 */
	public static TrainingCourse findByName_Last(
			String name, OrderByComparator<TrainingCourse> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchTrainingCourseException {

		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the last training course in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training course, or <code>null</code> if a matching training course could not be found
	 */
	public static TrainingCourse fetchByName_Last(
		String name, OrderByComparator<TrainingCourse> orderByComparator) {

		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the training courses before and after the current training course in the ordered set where name = &#63;.
	 *
	 * @param trainingCourseId the primary key of the current training course
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next training course
	 * @throws NoSuchTrainingCourseException if a training course with the primary key could not be found
	 */
	public static TrainingCourse[] findByName_PrevAndNext(
			long trainingCourseId, String name,
			OrderByComparator<TrainingCourse> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchTrainingCourseException {

		return getPersistence().findByName_PrevAndNext(
			trainingCourseId, name, orderByComparator);
	}

	/**
	 * Removes all the training courses where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeByName(String name) {
		getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of training courses where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching training courses
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Caches the training course in the entity cache if it is enabled.
	 *
	 * @param trainingCourse the training course
	 */
	public static void cacheResult(TrainingCourse trainingCourse) {
		getPersistence().cacheResult(trainingCourse);
	}

	/**
	 * Caches the training courses in the entity cache if it is enabled.
	 *
	 * @param trainingCourses the training courses
	 */
	public static void cacheResult(List<TrainingCourse> trainingCourses) {
		getPersistence().cacheResult(trainingCourses);
	}

	/**
	 * Creates a new training course with the primary key. Does not add the training course to the database.
	 *
	 * @param trainingCourseId the primary key for the new training course
	 * @return the new training course
	 */
	public static TrainingCourse create(long trainingCourseId) {
		return getPersistence().create(trainingCourseId);
	}

	/**
	 * Removes the training course with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param trainingCourseId the primary key of the training course
	 * @return the training course that was removed
	 * @throws NoSuchTrainingCourseException if a training course with the primary key could not be found
	 */
	public static TrainingCourse remove(long trainingCourseId)
		throws com.adjecti.mdm.liferay.exception.NoSuchTrainingCourseException {

		return getPersistence().remove(trainingCourseId);
	}

	public static TrainingCourse updateImpl(TrainingCourse trainingCourse) {
		return getPersistence().updateImpl(trainingCourse);
	}

	/**
	 * Returns the training course with the primary key or throws a <code>NoSuchTrainingCourseException</code> if it could not be found.
	 *
	 * @param trainingCourseId the primary key of the training course
	 * @return the training course
	 * @throws NoSuchTrainingCourseException if a training course with the primary key could not be found
	 */
	public static TrainingCourse findByPrimaryKey(long trainingCourseId)
		throws com.adjecti.mdm.liferay.exception.NoSuchTrainingCourseException {

		return getPersistence().findByPrimaryKey(trainingCourseId);
	}

	/**
	 * Returns the training course with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param trainingCourseId the primary key of the training course
	 * @return the training course, or <code>null</code> if a training course with the primary key could not be found
	 */
	public static TrainingCourse fetchByPrimaryKey(long trainingCourseId) {
		return getPersistence().fetchByPrimaryKey(trainingCourseId);
	}

	/**
	 * Returns all the training courses.
	 *
	 * @return the training courses
	 */
	public static List<TrainingCourse> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the training courses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingCourseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of training courses
	 * @param end the upper bound of the range of training courses (not inclusive)
	 * @return the range of training courses
	 */
	public static List<TrainingCourse> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the training courses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingCourseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of training courses
	 * @param end the upper bound of the range of training courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of training courses
	 */
	public static List<TrainingCourse> findAll(
		int start, int end,
		OrderByComparator<TrainingCourse> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the training courses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TrainingCourseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of training courses
	 * @param end the upper bound of the range of training courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of training courses
	 */
	public static List<TrainingCourse> findAll(
		int start, int end, OrderByComparator<TrainingCourse> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the training courses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of training courses.
	 *
	 * @return the number of training courses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TrainingCoursePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TrainingCoursePersistence, TrainingCoursePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			TrainingCoursePersistence.class);

		ServiceTracker<TrainingCoursePersistence, TrainingCoursePersistence>
			serviceTracker =
				new ServiceTracker
					<TrainingCoursePersistence, TrainingCoursePersistence>(
						bundle.getBundleContext(),
						TrainingCoursePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}