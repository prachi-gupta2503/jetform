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

import com.adjecti.mdm.liferay.exception.NoSuchCourseCategoryException;
import com.adjecti.mdm.liferay.model.CourseCategory;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the course category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CourseCategoryUtil
 * @generated
 */
@ProviderType
public interface CourseCategoryPersistence
	extends BasePersistence<CourseCategory> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CourseCategoryUtil} to access the course category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the course category in the entity cache if it is enabled.
	 *
	 * @param courseCategory the course category
	 */
	public void cacheResult(CourseCategory courseCategory);

	/**
	 * Caches the course categories in the entity cache if it is enabled.
	 *
	 * @param courseCategories the course categories
	 */
	public void cacheResult(java.util.List<CourseCategory> courseCategories);

	/**
	 * Creates a new course category with the primary key. Does not add the course category to the database.
	 *
	 * @param courseCategoryId the primary key for the new course category
	 * @return the new course category
	 */
	public CourseCategory create(long courseCategoryId);

	/**
	 * Removes the course category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param courseCategoryId the primary key of the course category
	 * @return the course category that was removed
	 * @throws NoSuchCourseCategoryException if a course category with the primary key could not be found
	 */
	public CourseCategory remove(long courseCategoryId)
		throws NoSuchCourseCategoryException;

	public CourseCategory updateImpl(CourseCategory courseCategory);

	/**
	 * Returns the course category with the primary key or throws a <code>NoSuchCourseCategoryException</code> if it could not be found.
	 *
	 * @param courseCategoryId the primary key of the course category
	 * @return the course category
	 * @throws NoSuchCourseCategoryException if a course category with the primary key could not be found
	 */
	public CourseCategory findByPrimaryKey(long courseCategoryId)
		throws NoSuchCourseCategoryException;

	/**
	 * Returns the course category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param courseCategoryId the primary key of the course category
	 * @return the course category, or <code>null</code> if a course category with the primary key could not be found
	 */
	public CourseCategory fetchByPrimaryKey(long courseCategoryId);

	/**
	 * Returns all the course categories.
	 *
	 * @return the course categories
	 */
	public java.util.List<CourseCategory> findAll();

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
	public java.util.List<CourseCategory> findAll(int start, int end);

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
	public java.util.List<CourseCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CourseCategory>
			orderByComparator);

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
	public java.util.List<CourseCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CourseCategory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the course categories from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of course categories.
	 *
	 * @return the number of course categories
	 */
	public int countAll();

}