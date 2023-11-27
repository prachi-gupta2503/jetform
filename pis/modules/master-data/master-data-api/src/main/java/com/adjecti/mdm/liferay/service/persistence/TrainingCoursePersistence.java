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

import com.adjecti.mdm.liferay.exception.NoSuchTrainingCourseException;
import com.adjecti.mdm.liferay.model.TrainingCourse;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the training course service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TrainingCourseUtil
 * @generated
 */
@ProviderType
public interface TrainingCoursePersistence
	extends BasePersistence<TrainingCourse> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TrainingCourseUtil} to access the training course persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the training courses where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching training courses
	 */
	public java.util.List<TrainingCourse> findByCode(String code);

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
	public java.util.List<TrainingCourse> findByCode(
		String code, int start, int end);

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
	public java.util.List<TrainingCourse> findByCode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingCourse>
			orderByComparator);

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
	public java.util.List<TrainingCourse> findByCode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingCourse>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first training course in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training course
	 * @throws NoSuchTrainingCourseException if a matching training course could not be found
	 */
	public TrainingCourse findByCode_First(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator<TrainingCourse>
				orderByComparator)
		throws NoSuchTrainingCourseException;

	/**
	 * Returns the first training course in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training course, or <code>null</code> if a matching training course could not be found
	 */
	public TrainingCourse fetchByCode_First(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingCourse>
			orderByComparator);

	/**
	 * Returns the last training course in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training course
	 * @throws NoSuchTrainingCourseException if a matching training course could not be found
	 */
	public TrainingCourse findByCode_Last(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator<TrainingCourse>
				orderByComparator)
		throws NoSuchTrainingCourseException;

	/**
	 * Returns the last training course in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training course, or <code>null</code> if a matching training course could not be found
	 */
	public TrainingCourse fetchByCode_Last(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingCourse>
			orderByComparator);

	/**
	 * Returns the training courses before and after the current training course in the ordered set where code = &#63;.
	 *
	 * @param trainingCourseId the primary key of the current training course
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next training course
	 * @throws NoSuchTrainingCourseException if a training course with the primary key could not be found
	 */
	public TrainingCourse[] findByCode_PrevAndNext(
			long trainingCourseId, String code,
			com.liferay.portal.kernel.util.OrderByComparator<TrainingCourse>
				orderByComparator)
		throws NoSuchTrainingCourseException;

	/**
	 * Removes all the training courses where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public void removeByCode(String code);

	/**
	 * Returns the number of training courses where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching training courses
	 */
	public int countByCode(String code);

	/**
	 * Returns all the training courses where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching training courses
	 */
	public java.util.List<TrainingCourse> findByName(String name);

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
	public java.util.List<TrainingCourse> findByName(
		String name, int start, int end);

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
	public java.util.List<TrainingCourse> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingCourse>
			orderByComparator);

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
	public java.util.List<TrainingCourse> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingCourse>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first training course in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training course
	 * @throws NoSuchTrainingCourseException if a matching training course could not be found
	 */
	public TrainingCourse findByName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<TrainingCourse>
				orderByComparator)
		throws NoSuchTrainingCourseException;

	/**
	 * Returns the first training course in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching training course, or <code>null</code> if a matching training course could not be found
	 */
	public TrainingCourse fetchByName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingCourse>
			orderByComparator);

	/**
	 * Returns the last training course in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training course
	 * @throws NoSuchTrainingCourseException if a matching training course could not be found
	 */
	public TrainingCourse findByName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<TrainingCourse>
				orderByComparator)
		throws NoSuchTrainingCourseException;

	/**
	 * Returns the last training course in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching training course, or <code>null</code> if a matching training course could not be found
	 */
	public TrainingCourse fetchByName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingCourse>
			orderByComparator);

	/**
	 * Returns the training courses before and after the current training course in the ordered set where name = &#63;.
	 *
	 * @param trainingCourseId the primary key of the current training course
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next training course
	 * @throws NoSuchTrainingCourseException if a training course with the primary key could not be found
	 */
	public TrainingCourse[] findByName_PrevAndNext(
			long trainingCourseId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<TrainingCourse>
				orderByComparator)
		throws NoSuchTrainingCourseException;

	/**
	 * Removes all the training courses where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByName(String name);

	/**
	 * Returns the number of training courses where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching training courses
	 */
	public int countByName(String name);

	/**
	 * Caches the training course in the entity cache if it is enabled.
	 *
	 * @param trainingCourse the training course
	 */
	public void cacheResult(TrainingCourse trainingCourse);

	/**
	 * Caches the training courses in the entity cache if it is enabled.
	 *
	 * @param trainingCourses the training courses
	 */
	public void cacheResult(java.util.List<TrainingCourse> trainingCourses);

	/**
	 * Creates a new training course with the primary key. Does not add the training course to the database.
	 *
	 * @param trainingCourseId the primary key for the new training course
	 * @return the new training course
	 */
	public TrainingCourse create(long trainingCourseId);

	/**
	 * Removes the training course with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param trainingCourseId the primary key of the training course
	 * @return the training course that was removed
	 * @throws NoSuchTrainingCourseException if a training course with the primary key could not be found
	 */
	public TrainingCourse remove(long trainingCourseId)
		throws NoSuchTrainingCourseException;

	public TrainingCourse updateImpl(TrainingCourse trainingCourse);

	/**
	 * Returns the training course with the primary key or throws a <code>NoSuchTrainingCourseException</code> if it could not be found.
	 *
	 * @param trainingCourseId the primary key of the training course
	 * @return the training course
	 * @throws NoSuchTrainingCourseException if a training course with the primary key could not be found
	 */
	public TrainingCourse findByPrimaryKey(long trainingCourseId)
		throws NoSuchTrainingCourseException;

	/**
	 * Returns the training course with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param trainingCourseId the primary key of the training course
	 * @return the training course, or <code>null</code> if a training course with the primary key could not be found
	 */
	public TrainingCourse fetchByPrimaryKey(long trainingCourseId);

	/**
	 * Returns all the training courses.
	 *
	 * @return the training courses
	 */
	public java.util.List<TrainingCourse> findAll();

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
	public java.util.List<TrainingCourse> findAll(int start, int end);

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
	public java.util.List<TrainingCourse> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingCourse>
			orderByComparator);

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
	public java.util.List<TrainingCourse> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TrainingCourse>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the training courses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of training courses.
	 *
	 * @return the number of training courses
	 */
	public int countAll();

}