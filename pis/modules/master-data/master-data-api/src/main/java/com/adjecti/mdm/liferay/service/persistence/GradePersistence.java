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

import com.adjecti.mdm.liferay.exception.NoSuchGradeException;
import com.adjecti.mdm.liferay.model.Grade;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the grade service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GradeUtil
 * @generated
 */
@ProviderType
public interface GradePersistence extends BasePersistence<Grade> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GradeUtil} to access the grade persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the grades where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching grades
	 */
	public java.util.List<Grade> findByName(String name);

	/**
	 * Returns a range of all the grades where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GradeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of grades
	 * @param end the upper bound of the range of grades (not inclusive)
	 * @return the range of matching grades
	 */
	public java.util.List<Grade> findByName(String name, int start, int end);

	/**
	 * Returns an ordered range of all the grades where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GradeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of grades
	 * @param end the upper bound of the range of grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching grades
	 */
	public java.util.List<Grade> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Grade>
			orderByComparator);

	/**
	 * Returns an ordered range of all the grades where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GradeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of grades
	 * @param end the upper bound of the range of grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching grades
	 */
	public java.util.List<Grade> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Grade>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first grade in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching grade
	 * @throws NoSuchGradeException if a matching grade could not be found
	 */
	public Grade findByName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<Grade>
				orderByComparator)
		throws NoSuchGradeException;

	/**
	 * Returns the first grade in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching grade, or <code>null</code> if a matching grade could not be found
	 */
	public Grade fetchByName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<Grade>
			orderByComparator);

	/**
	 * Returns the last grade in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching grade
	 * @throws NoSuchGradeException if a matching grade could not be found
	 */
	public Grade findByName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<Grade>
				orderByComparator)
		throws NoSuchGradeException;

	/**
	 * Returns the last grade in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching grade, or <code>null</code> if a matching grade could not be found
	 */
	public Grade fetchByName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<Grade>
			orderByComparator);

	/**
	 * Returns the grades before and after the current grade in the ordered set where name = &#63;.
	 *
	 * @param gradeId the primary key of the current grade
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next grade
	 * @throws NoSuchGradeException if a grade with the primary key could not be found
	 */
	public Grade[] findByName_PrevAndNext(
			long gradeId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<Grade>
				orderByComparator)
		throws NoSuchGradeException;

	/**
	 * Removes all the grades where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByName(String name);

	/**
	 * Returns the number of grades where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching grades
	 */
	public int countByName(String name);

	/**
	 * Returns the grade where code = &#63; or throws a <code>NoSuchGradeException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching grade
	 * @throws NoSuchGradeException if a matching grade could not be found
	 */
	public Grade findByCode(String code) throws NoSuchGradeException;

	/**
	 * Returns the grade where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching grade, or <code>null</code> if a matching grade could not be found
	 */
	public Grade fetchByCode(String code);

	/**
	 * Returns the grade where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching grade, or <code>null</code> if a matching grade could not be found
	 */
	public Grade fetchByCode(String code, boolean useFinderCache);

	/**
	 * Removes the grade where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the grade that was removed
	 */
	public Grade removeByCode(String code) throws NoSuchGradeException;

	/**
	 * Returns the number of grades where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching grades
	 */
	public int countByCode(String code);

	/**
	 * Caches the grade in the entity cache if it is enabled.
	 *
	 * @param grade the grade
	 */
	public void cacheResult(Grade grade);

	/**
	 * Caches the grades in the entity cache if it is enabled.
	 *
	 * @param grades the grades
	 */
	public void cacheResult(java.util.List<Grade> grades);

	/**
	 * Creates a new grade with the primary key. Does not add the grade to the database.
	 *
	 * @param gradeId the primary key for the new grade
	 * @return the new grade
	 */
	public Grade create(long gradeId);

	/**
	 * Removes the grade with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param gradeId the primary key of the grade
	 * @return the grade that was removed
	 * @throws NoSuchGradeException if a grade with the primary key could not be found
	 */
	public Grade remove(long gradeId) throws NoSuchGradeException;

	public Grade updateImpl(Grade grade);

	/**
	 * Returns the grade with the primary key or throws a <code>NoSuchGradeException</code> if it could not be found.
	 *
	 * @param gradeId the primary key of the grade
	 * @return the grade
	 * @throws NoSuchGradeException if a grade with the primary key could not be found
	 */
	public Grade findByPrimaryKey(long gradeId) throws NoSuchGradeException;

	/**
	 * Returns the grade with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param gradeId the primary key of the grade
	 * @return the grade, or <code>null</code> if a grade with the primary key could not be found
	 */
	public Grade fetchByPrimaryKey(long gradeId);

	/**
	 * Returns all the grades.
	 *
	 * @return the grades
	 */
	public java.util.List<Grade> findAll();

	/**
	 * Returns a range of all the grades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of grades
	 * @param end the upper bound of the range of grades (not inclusive)
	 * @return the range of grades
	 */
	public java.util.List<Grade> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the grades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of grades
	 * @param end the upper bound of the range of grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of grades
	 */
	public java.util.List<Grade> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Grade>
			orderByComparator);

	/**
	 * Returns an ordered range of all the grades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of grades
	 * @param end the upper bound of the range of grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of grades
	 */
	public java.util.List<Grade> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Grade>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the grades from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of grades.
	 *
	 * @return the number of grades
	 */
	public int countAll();

}