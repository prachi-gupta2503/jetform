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

import com.adjecti.mdm.liferay.model.Course;

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
 * The persistence utility for the course service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.CoursePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CoursePersistence
 * @generated
 */
public class CourseUtil {

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
	public static void clearCache(Course course) {
		getPersistence().clearCache(course);
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
	public static Map<Serializable, Course> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Course> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Course> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Course> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Course> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Course update(Course course) {
		return getPersistence().update(course);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Course update(Course course, ServiceContext serviceContext) {
		return getPersistence().update(course, serviceContext);
	}

	/**
	 * Returns all the courses where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching courses
	 */
	public static List<Course> findByCode(String code) {
		return getPersistence().findByCode(code);
	}

	/**
	 * Returns a range of all the courses where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CourseModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of courses
	 * @param end the upper bound of the range of courses (not inclusive)
	 * @return the range of matching courses
	 */
	public static List<Course> findByCode(String code, int start, int end) {
		return getPersistence().findByCode(code, start, end);
	}

	/**
	 * Returns an ordered range of all the courses where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CourseModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of courses
	 * @param end the upper bound of the range of courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching courses
	 */
	public static List<Course> findByCode(
		String code, int start, int end,
		OrderByComparator<Course> orderByComparator) {

		return getPersistence().findByCode(code, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the courses where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CourseModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of courses
	 * @param end the upper bound of the range of courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching courses
	 */
	public static List<Course> findByCode(
		String code, int start, int end,
		OrderByComparator<Course> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCode(
			code, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first course in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course
	 * @throws NoSuchCourseException if a matching course could not be found
	 */
	public static Course findByCode_First(
			String code, OrderByComparator<Course> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchCourseException {

		return getPersistence().findByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the first course in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course, or <code>null</code> if a matching course could not be found
	 */
	public static Course fetchByCode_First(
		String code, OrderByComparator<Course> orderByComparator) {

		return getPersistence().fetchByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the last course in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course
	 * @throws NoSuchCourseException if a matching course could not be found
	 */
	public static Course findByCode_Last(
			String code, OrderByComparator<Course> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchCourseException {

		return getPersistence().findByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the last course in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course, or <code>null</code> if a matching course could not be found
	 */
	public static Course fetchByCode_Last(
		String code, OrderByComparator<Course> orderByComparator) {

		return getPersistence().fetchByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the courses before and after the current course in the ordered set where code = &#63;.
	 *
	 * @param courseId the primary key of the current course
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next course
	 * @throws NoSuchCourseException if a course with the primary key could not be found
	 */
	public static Course[] findByCode_PrevAndNext(
			long courseId, String code,
			OrderByComparator<Course> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchCourseException {

		return getPersistence().findByCode_PrevAndNext(
			courseId, code, orderByComparator);
	}

	/**
	 * Removes all the courses where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public static void removeByCode(String code) {
		getPersistence().removeByCode(code);
	}

	/**
	 * Returns the number of courses where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching courses
	 */
	public static int countByCode(String code) {
		return getPersistence().countByCode(code);
	}

	/**
	 * Returns all the courses where subjectOfTrainingId = &#63; and status = &#63;.
	 *
	 * @param subjectOfTrainingId the subject of training ID
	 * @param status the status
	 * @return the matching courses
	 */
	public static List<Course> findBySubjectOfTrainingIdAndStatus(
		long subjectOfTrainingId, int status) {

		return getPersistence().findBySubjectOfTrainingIdAndStatus(
			subjectOfTrainingId, status);
	}

	/**
	 * Returns a range of all the courses where subjectOfTrainingId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CourseModelImpl</code>.
	 * </p>
	 *
	 * @param subjectOfTrainingId the subject of training ID
	 * @param status the status
	 * @param start the lower bound of the range of courses
	 * @param end the upper bound of the range of courses (not inclusive)
	 * @return the range of matching courses
	 */
	public static List<Course> findBySubjectOfTrainingIdAndStatus(
		long subjectOfTrainingId, int status, int start, int end) {

		return getPersistence().findBySubjectOfTrainingIdAndStatus(
			subjectOfTrainingId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the courses where subjectOfTrainingId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CourseModelImpl</code>.
	 * </p>
	 *
	 * @param subjectOfTrainingId the subject of training ID
	 * @param status the status
	 * @param start the lower bound of the range of courses
	 * @param end the upper bound of the range of courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching courses
	 */
	public static List<Course> findBySubjectOfTrainingIdAndStatus(
		long subjectOfTrainingId, int status, int start, int end,
		OrderByComparator<Course> orderByComparator) {

		return getPersistence().findBySubjectOfTrainingIdAndStatus(
			subjectOfTrainingId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the courses where subjectOfTrainingId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CourseModelImpl</code>.
	 * </p>
	 *
	 * @param subjectOfTrainingId the subject of training ID
	 * @param status the status
	 * @param start the lower bound of the range of courses
	 * @param end the upper bound of the range of courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching courses
	 */
	public static List<Course> findBySubjectOfTrainingIdAndStatus(
		long subjectOfTrainingId, int status, int start, int end,
		OrderByComparator<Course> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBySubjectOfTrainingIdAndStatus(
			subjectOfTrainingId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first course in the ordered set where subjectOfTrainingId = &#63; and status = &#63;.
	 *
	 * @param subjectOfTrainingId the subject of training ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course
	 * @throws NoSuchCourseException if a matching course could not be found
	 */
	public static Course findBySubjectOfTrainingIdAndStatus_First(
			long subjectOfTrainingId, int status,
			OrderByComparator<Course> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchCourseException {

		return getPersistence().findBySubjectOfTrainingIdAndStatus_First(
			subjectOfTrainingId, status, orderByComparator);
	}

	/**
	 * Returns the first course in the ordered set where subjectOfTrainingId = &#63; and status = &#63;.
	 *
	 * @param subjectOfTrainingId the subject of training ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course, or <code>null</code> if a matching course could not be found
	 */
	public static Course fetchBySubjectOfTrainingIdAndStatus_First(
		long subjectOfTrainingId, int status,
		OrderByComparator<Course> orderByComparator) {

		return getPersistence().fetchBySubjectOfTrainingIdAndStatus_First(
			subjectOfTrainingId, status, orderByComparator);
	}

	/**
	 * Returns the last course in the ordered set where subjectOfTrainingId = &#63; and status = &#63;.
	 *
	 * @param subjectOfTrainingId the subject of training ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course
	 * @throws NoSuchCourseException if a matching course could not be found
	 */
	public static Course findBySubjectOfTrainingIdAndStatus_Last(
			long subjectOfTrainingId, int status,
			OrderByComparator<Course> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchCourseException {

		return getPersistence().findBySubjectOfTrainingIdAndStatus_Last(
			subjectOfTrainingId, status, orderByComparator);
	}

	/**
	 * Returns the last course in the ordered set where subjectOfTrainingId = &#63; and status = &#63;.
	 *
	 * @param subjectOfTrainingId the subject of training ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course, or <code>null</code> if a matching course could not be found
	 */
	public static Course fetchBySubjectOfTrainingIdAndStatus_Last(
		long subjectOfTrainingId, int status,
		OrderByComparator<Course> orderByComparator) {

		return getPersistence().fetchBySubjectOfTrainingIdAndStatus_Last(
			subjectOfTrainingId, status, orderByComparator);
	}

	/**
	 * Returns the courses before and after the current course in the ordered set where subjectOfTrainingId = &#63; and status = &#63;.
	 *
	 * @param courseId the primary key of the current course
	 * @param subjectOfTrainingId the subject of training ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next course
	 * @throws NoSuchCourseException if a course with the primary key could not be found
	 */
	public static Course[] findBySubjectOfTrainingIdAndStatus_PrevAndNext(
			long courseId, long subjectOfTrainingId, int status,
			OrderByComparator<Course> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchCourseException {

		return getPersistence().findBySubjectOfTrainingIdAndStatus_PrevAndNext(
			courseId, subjectOfTrainingId, status, orderByComparator);
	}

	/**
	 * Removes all the courses where subjectOfTrainingId = &#63; and status = &#63; from the database.
	 *
	 * @param subjectOfTrainingId the subject of training ID
	 * @param status the status
	 */
	public static void removeBySubjectOfTrainingIdAndStatus(
		long subjectOfTrainingId, int status) {

		getPersistence().removeBySubjectOfTrainingIdAndStatus(
			subjectOfTrainingId, status);
	}

	/**
	 * Returns the number of courses where subjectOfTrainingId = &#63; and status = &#63;.
	 *
	 * @param subjectOfTrainingId the subject of training ID
	 * @param status the status
	 * @return the number of matching courses
	 */
	public static int countBySubjectOfTrainingIdAndStatus(
		long subjectOfTrainingId, int status) {

		return getPersistence().countBySubjectOfTrainingIdAndStatus(
			subjectOfTrainingId, status);
	}

	/**
	 * Returns all the courses where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching courses
	 */
	public static List<Course> findByName(String name) {
		return getPersistence().findByName(name);
	}

	/**
	 * Returns a range of all the courses where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CourseModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of courses
	 * @param end the upper bound of the range of courses (not inclusive)
	 * @return the range of matching courses
	 */
	public static List<Course> findByName(String name, int start, int end) {
		return getPersistence().findByName(name, start, end);
	}

	/**
	 * Returns an ordered range of all the courses where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CourseModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of courses
	 * @param end the upper bound of the range of courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching courses
	 */
	public static List<Course> findByName(
		String name, int start, int end,
		OrderByComparator<Course> orderByComparator) {

		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the courses where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CourseModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of courses
	 * @param end the upper bound of the range of courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching courses
	 */
	public static List<Course> findByName(
		String name, int start, int end,
		OrderByComparator<Course> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByName(
			name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first course in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course
	 * @throws NoSuchCourseException if a matching course could not be found
	 */
	public static Course findByName_First(
			String name, OrderByComparator<Course> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchCourseException {

		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	 * Returns the first course in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course, or <code>null</code> if a matching course could not be found
	 */
	public static Course fetchByName_First(
		String name, OrderByComparator<Course> orderByComparator) {

		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	 * Returns the last course in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course
	 * @throws NoSuchCourseException if a matching course could not be found
	 */
	public static Course findByName_Last(
			String name, OrderByComparator<Course> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchCourseException {

		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the last course in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course, or <code>null</code> if a matching course could not be found
	 */
	public static Course fetchByName_Last(
		String name, OrderByComparator<Course> orderByComparator) {

		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the courses before and after the current course in the ordered set where name = &#63;.
	 *
	 * @param courseId the primary key of the current course
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next course
	 * @throws NoSuchCourseException if a course with the primary key could not be found
	 */
	public static Course[] findByName_PrevAndNext(
			long courseId, String name,
			OrderByComparator<Course> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.NoSuchCourseException {

		return getPersistence().findByName_PrevAndNext(
			courseId, name, orderByComparator);
	}

	/**
	 * Removes all the courses where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeByName(String name) {
		getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of courses where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching courses
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Caches the course in the entity cache if it is enabled.
	 *
	 * @param course the course
	 */
	public static void cacheResult(Course course) {
		getPersistence().cacheResult(course);
	}

	/**
	 * Caches the courses in the entity cache if it is enabled.
	 *
	 * @param courses the courses
	 */
	public static void cacheResult(List<Course> courses) {
		getPersistence().cacheResult(courses);
	}

	/**
	 * Creates a new course with the primary key. Does not add the course to the database.
	 *
	 * @param courseId the primary key for the new course
	 * @return the new course
	 */
	public static Course create(long courseId) {
		return getPersistence().create(courseId);
	}

	/**
	 * Removes the course with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param courseId the primary key of the course
	 * @return the course that was removed
	 * @throws NoSuchCourseException if a course with the primary key could not be found
	 */
	public static Course remove(long courseId)
		throws com.adjecti.mdm.liferay.exception.NoSuchCourseException {

		return getPersistence().remove(courseId);
	}

	public static Course updateImpl(Course course) {
		return getPersistence().updateImpl(course);
	}

	/**
	 * Returns the course with the primary key or throws a <code>NoSuchCourseException</code> if it could not be found.
	 *
	 * @param courseId the primary key of the course
	 * @return the course
	 * @throws NoSuchCourseException if a course with the primary key could not be found
	 */
	public static Course findByPrimaryKey(long courseId)
		throws com.adjecti.mdm.liferay.exception.NoSuchCourseException {

		return getPersistence().findByPrimaryKey(courseId);
	}

	/**
	 * Returns the course with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param courseId the primary key of the course
	 * @return the course, or <code>null</code> if a course with the primary key could not be found
	 */
	public static Course fetchByPrimaryKey(long courseId) {
		return getPersistence().fetchByPrimaryKey(courseId);
	}

	/**
	 * Returns all the courses.
	 *
	 * @return the courses
	 */
	public static List<Course> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the courses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CourseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of courses
	 * @param end the upper bound of the range of courses (not inclusive)
	 * @return the range of courses
	 */
	public static List<Course> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the courses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CourseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of courses
	 * @param end the upper bound of the range of courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of courses
	 */
	public static List<Course> findAll(
		int start, int end, OrderByComparator<Course> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the courses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CourseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of courses
	 * @param end the upper bound of the range of courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of courses
	 */
	public static List<Course> findAll(
		int start, int end, OrderByComparator<Course> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the courses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of courses.
	 *
	 * @return the number of courses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CoursePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CoursePersistence, CoursePersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CoursePersistence.class);

		ServiceTracker<CoursePersistence, CoursePersistence> serviceTracker =
			new ServiceTracker<CoursePersistence, CoursePersistence>(
				bundle.getBundleContext(), CoursePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}