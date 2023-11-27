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

import com.adjecti.mdm.liferay.exception.NoSuchQualificationGradeException;
import com.adjecti.mdm.liferay.model.QualificationGrade;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the qualification grade service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QualificationGradeUtil
 * @generated
 */
@ProviderType
public interface QualificationGradePersistence
	extends BasePersistence<QualificationGrade> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link QualificationGradeUtil} to access the qualification grade persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the qualification grades where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching qualification grades
	 */
	public java.util.List<QualificationGrade> findByCode(String code);

	/**
	 * Returns a range of all the qualification grades where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationGradeModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of qualification grades
	 * @param end the upper bound of the range of qualification grades (not inclusive)
	 * @return the range of matching qualification grades
	 */
	public java.util.List<QualificationGrade> findByCode(
		String code, int start, int end);

	/**
	 * Returns an ordered range of all the qualification grades where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationGradeModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of qualification grades
	 * @param end the upper bound of the range of qualification grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching qualification grades
	 */
	public java.util.List<QualificationGrade> findByCode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QualificationGrade>
			orderByComparator);

	/**
	 * Returns an ordered range of all the qualification grades where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationGradeModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of qualification grades
	 * @param end the upper bound of the range of qualification grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching qualification grades
	 */
	public java.util.List<QualificationGrade> findByCode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QualificationGrade>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first qualification grade in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qualification grade
	 * @throws NoSuchQualificationGradeException if a matching qualification grade could not be found
	 */
	public QualificationGrade findByCode_First(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator<QualificationGrade>
				orderByComparator)
		throws NoSuchQualificationGradeException;

	/**
	 * Returns the first qualification grade in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qualification grade, or <code>null</code> if a matching qualification grade could not be found
	 */
	public QualificationGrade fetchByCode_First(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<QualificationGrade>
			orderByComparator);

	/**
	 * Returns the last qualification grade in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qualification grade
	 * @throws NoSuchQualificationGradeException if a matching qualification grade could not be found
	 */
	public QualificationGrade findByCode_Last(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator<QualificationGrade>
				orderByComparator)
		throws NoSuchQualificationGradeException;

	/**
	 * Returns the last qualification grade in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qualification grade, or <code>null</code> if a matching qualification grade could not be found
	 */
	public QualificationGrade fetchByCode_Last(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<QualificationGrade>
			orderByComparator);

	/**
	 * Returns the qualification grades before and after the current qualification grade in the ordered set where code = &#63;.
	 *
	 * @param qualificationGradeId the primary key of the current qualification grade
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next qualification grade
	 * @throws NoSuchQualificationGradeException if a qualification grade with the primary key could not be found
	 */
	public QualificationGrade[] findByCode_PrevAndNext(
			long qualificationGradeId, String code,
			com.liferay.portal.kernel.util.OrderByComparator<QualificationGrade>
				orderByComparator)
		throws NoSuchQualificationGradeException;

	/**
	 * Removes all the qualification grades where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public void removeByCode(String code);

	/**
	 * Returns the number of qualification grades where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching qualification grades
	 */
	public int countByCode(String code);

	/**
	 * Returns all the qualification grades where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching qualification grades
	 */
	public java.util.List<QualificationGrade> findByName(String name);

	/**
	 * Returns a range of all the qualification grades where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationGradeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of qualification grades
	 * @param end the upper bound of the range of qualification grades (not inclusive)
	 * @return the range of matching qualification grades
	 */
	public java.util.List<QualificationGrade> findByName(
		String name, int start, int end);

	/**
	 * Returns an ordered range of all the qualification grades where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationGradeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of qualification grades
	 * @param end the upper bound of the range of qualification grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching qualification grades
	 */
	public java.util.List<QualificationGrade> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QualificationGrade>
			orderByComparator);

	/**
	 * Returns an ordered range of all the qualification grades where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationGradeModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of qualification grades
	 * @param end the upper bound of the range of qualification grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching qualification grades
	 */
	public java.util.List<QualificationGrade> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QualificationGrade>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first qualification grade in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qualification grade
	 * @throws NoSuchQualificationGradeException if a matching qualification grade could not be found
	 */
	public QualificationGrade findByName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<QualificationGrade>
				orderByComparator)
		throws NoSuchQualificationGradeException;

	/**
	 * Returns the first qualification grade in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching qualification grade, or <code>null</code> if a matching qualification grade could not be found
	 */
	public QualificationGrade fetchByName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<QualificationGrade>
			orderByComparator);

	/**
	 * Returns the last qualification grade in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qualification grade
	 * @throws NoSuchQualificationGradeException if a matching qualification grade could not be found
	 */
	public QualificationGrade findByName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<QualificationGrade>
				orderByComparator)
		throws NoSuchQualificationGradeException;

	/**
	 * Returns the last qualification grade in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching qualification grade, or <code>null</code> if a matching qualification grade could not be found
	 */
	public QualificationGrade fetchByName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<QualificationGrade>
			orderByComparator);

	/**
	 * Returns the qualification grades before and after the current qualification grade in the ordered set where name = &#63;.
	 *
	 * @param qualificationGradeId the primary key of the current qualification grade
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next qualification grade
	 * @throws NoSuchQualificationGradeException if a qualification grade with the primary key could not be found
	 */
	public QualificationGrade[] findByName_PrevAndNext(
			long qualificationGradeId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<QualificationGrade>
				orderByComparator)
		throws NoSuchQualificationGradeException;

	/**
	 * Removes all the qualification grades where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByName(String name);

	/**
	 * Returns the number of qualification grades where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching qualification grades
	 */
	public int countByName(String name);

	/**
	 * Caches the qualification grade in the entity cache if it is enabled.
	 *
	 * @param qualificationGrade the qualification grade
	 */
	public void cacheResult(QualificationGrade qualificationGrade);

	/**
	 * Caches the qualification grades in the entity cache if it is enabled.
	 *
	 * @param qualificationGrades the qualification grades
	 */
	public void cacheResult(
		java.util.List<QualificationGrade> qualificationGrades);

	/**
	 * Creates a new qualification grade with the primary key. Does not add the qualification grade to the database.
	 *
	 * @param qualificationGradeId the primary key for the new qualification grade
	 * @return the new qualification grade
	 */
	public QualificationGrade create(long qualificationGradeId);

	/**
	 * Removes the qualification grade with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param qualificationGradeId the primary key of the qualification grade
	 * @return the qualification grade that was removed
	 * @throws NoSuchQualificationGradeException if a qualification grade with the primary key could not be found
	 */
	public QualificationGrade remove(long qualificationGradeId)
		throws NoSuchQualificationGradeException;

	public QualificationGrade updateImpl(QualificationGrade qualificationGrade);

	/**
	 * Returns the qualification grade with the primary key or throws a <code>NoSuchQualificationGradeException</code> if it could not be found.
	 *
	 * @param qualificationGradeId the primary key of the qualification grade
	 * @return the qualification grade
	 * @throws NoSuchQualificationGradeException if a qualification grade with the primary key could not be found
	 */
	public QualificationGrade findByPrimaryKey(long qualificationGradeId)
		throws NoSuchQualificationGradeException;

	/**
	 * Returns the qualification grade with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param qualificationGradeId the primary key of the qualification grade
	 * @return the qualification grade, or <code>null</code> if a qualification grade with the primary key could not be found
	 */
	public QualificationGrade fetchByPrimaryKey(long qualificationGradeId);

	/**
	 * Returns all the qualification grades.
	 *
	 * @return the qualification grades
	 */
	public java.util.List<QualificationGrade> findAll();

	/**
	 * Returns a range of all the qualification grades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationGradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of qualification grades
	 * @param end the upper bound of the range of qualification grades (not inclusive)
	 * @return the range of qualification grades
	 */
	public java.util.List<QualificationGrade> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the qualification grades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationGradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of qualification grades
	 * @param end the upper bound of the range of qualification grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of qualification grades
	 */
	public java.util.List<QualificationGrade> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QualificationGrade>
			orderByComparator);

	/**
	 * Returns an ordered range of all the qualification grades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QualificationGradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of qualification grades
	 * @param end the upper bound of the range of qualification grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of qualification grades
	 */
	public java.util.List<QualificationGrade> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QualificationGrade>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the qualification grades from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of qualification grades.
	 *
	 * @return the number of qualification grades
	 */
	public int countAll();

}