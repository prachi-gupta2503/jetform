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

package com.adjecti.pis.liferay.service.persistence;

import com.adjecti.pis.liferay.exception.NoSuchEmployeeGradeException;
import com.adjecti.pis.liferay.model.EmployeeGrade;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee grade service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeGradeUtil
 * @generated
 */
@ProviderType
public interface EmployeeGradePersistence
	extends BasePersistence<EmployeeGrade> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeGradeUtil} to access the employee grade persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee grades where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @return the matching employee grades
	 */
	public java.util.List<EmployeeGrade> findByGradeModeId(long gradeModeId);

	/**
	 * Returns a range of all the employee grades where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeGradeModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee grades
	 * @param end the upper bound of the range of employee grades (not inclusive)
	 * @return the range of matching employee grades
	 */
	public java.util.List<EmployeeGrade> findByGradeModeId(
		long gradeModeId, int start, int end);

	/**
	 * Returns an ordered range of all the employee grades where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeGradeModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee grades
	 * @param end the upper bound of the range of employee grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee grades
	 */
	public java.util.List<EmployeeGrade> findByGradeModeId(
		long gradeModeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeGrade>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee grades where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeGradeModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee grades
	 * @param end the upper bound of the range of employee grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee grades
	 */
	public java.util.List<EmployeeGrade> findByGradeModeId(
		long gradeModeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeGrade>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee grade in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee grade
	 * @throws NoSuchEmployeeGradeException if a matching employee grade could not be found
	 */
	public EmployeeGrade findByGradeModeId_First(
			long gradeModeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeGrade>
				orderByComparator)
		throws NoSuchEmployeeGradeException;

	/**
	 * Returns the first employee grade in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee grade, or <code>null</code> if a matching employee grade could not be found
	 */
	public EmployeeGrade fetchByGradeModeId_First(
		long gradeModeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeGrade>
			orderByComparator);

	/**
	 * Returns the last employee grade in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee grade
	 * @throws NoSuchEmployeeGradeException if a matching employee grade could not be found
	 */
	public EmployeeGrade findByGradeModeId_Last(
			long gradeModeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeGrade>
				orderByComparator)
		throws NoSuchEmployeeGradeException;

	/**
	 * Returns the last employee grade in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee grade, or <code>null</code> if a matching employee grade could not be found
	 */
	public EmployeeGrade fetchByGradeModeId_Last(
		long gradeModeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeGrade>
			orderByComparator);

	/**
	 * Returns the employee grades before and after the current employee grade in the ordered set where gradeModeId = &#63;.
	 *
	 * @param employeeGradeId the primary key of the current employee grade
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee grade
	 * @throws NoSuchEmployeeGradeException if a employee grade with the primary key could not be found
	 */
	public EmployeeGrade[] findByGradeModeId_PrevAndNext(
			long employeeGradeId, long gradeModeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeGrade>
				orderByComparator)
		throws NoSuchEmployeeGradeException;

	/**
	 * Removes all the employee grades where gradeModeId = &#63; from the database.
	 *
	 * @param gradeModeId the grade mode ID
	 */
	public void removeByGradeModeId(long gradeModeId);

	/**
	 * Returns the number of employee grades where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @return the number of matching employee grades
	 */
	public int countByGradeModeId(long gradeModeId);

	/**
	 * Returns all the employee grades where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee grades
	 */
	public java.util.List<EmployeeGrade> findByEmployeeId(long employeeId);

	/**
	 * Returns a range of all the employee grades where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeGradeModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee grades
	 * @param end the upper bound of the range of employee grades (not inclusive)
	 * @return the range of matching employee grades
	 */
	public java.util.List<EmployeeGrade> findByEmployeeId(
		long employeeId, int start, int end);

	/**
	 * Returns an ordered range of all the employee grades where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeGradeModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee grades
	 * @param end the upper bound of the range of employee grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee grades
	 */
	public java.util.List<EmployeeGrade> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeGrade>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee grades where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeGradeModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee grades
	 * @param end the upper bound of the range of employee grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee grades
	 */
	public java.util.List<EmployeeGrade> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeGrade>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee grade in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee grade
	 * @throws NoSuchEmployeeGradeException if a matching employee grade could not be found
	 */
	public EmployeeGrade findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeGrade>
				orderByComparator)
		throws NoSuchEmployeeGradeException;

	/**
	 * Returns the first employee grade in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee grade, or <code>null</code> if a matching employee grade could not be found
	 */
	public EmployeeGrade fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeGrade>
			orderByComparator);

	/**
	 * Returns the last employee grade in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee grade
	 * @throws NoSuchEmployeeGradeException if a matching employee grade could not be found
	 */
	public EmployeeGrade findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeGrade>
				orderByComparator)
		throws NoSuchEmployeeGradeException;

	/**
	 * Returns the last employee grade in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee grade, or <code>null</code> if a matching employee grade could not be found
	 */
	public EmployeeGrade fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeGrade>
			orderByComparator);

	/**
	 * Returns the employee grades before and after the current employee grade in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeGradeId the primary key of the current employee grade
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee grade
	 * @throws NoSuchEmployeeGradeException if a employee grade with the primary key could not be found
	 */
	public EmployeeGrade[] findByEmployeeId_PrevAndNext(
			long employeeGradeId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeGrade>
				orderByComparator)
		throws NoSuchEmployeeGradeException;

	/**
	 * Removes all the employee grades where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of employee grades where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee grades
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Caches the employee grade in the entity cache if it is enabled.
	 *
	 * @param employeeGrade the employee grade
	 */
	public void cacheResult(EmployeeGrade employeeGrade);

	/**
	 * Caches the employee grades in the entity cache if it is enabled.
	 *
	 * @param employeeGrades the employee grades
	 */
	public void cacheResult(java.util.List<EmployeeGrade> employeeGrades);

	/**
	 * Creates a new employee grade with the primary key. Does not add the employee grade to the database.
	 *
	 * @param employeeGradeId the primary key for the new employee grade
	 * @return the new employee grade
	 */
	public EmployeeGrade create(long employeeGradeId);

	/**
	 * Removes the employee grade with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeGradeId the primary key of the employee grade
	 * @return the employee grade that was removed
	 * @throws NoSuchEmployeeGradeException if a employee grade with the primary key could not be found
	 */
	public EmployeeGrade remove(long employeeGradeId)
		throws NoSuchEmployeeGradeException;

	public EmployeeGrade updateImpl(EmployeeGrade employeeGrade);

	/**
	 * Returns the employee grade with the primary key or throws a <code>NoSuchEmployeeGradeException</code> if it could not be found.
	 *
	 * @param employeeGradeId the primary key of the employee grade
	 * @return the employee grade
	 * @throws NoSuchEmployeeGradeException if a employee grade with the primary key could not be found
	 */
	public EmployeeGrade findByPrimaryKey(long employeeGradeId)
		throws NoSuchEmployeeGradeException;

	/**
	 * Returns the employee grade with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeGradeId the primary key of the employee grade
	 * @return the employee grade, or <code>null</code> if a employee grade with the primary key could not be found
	 */
	public EmployeeGrade fetchByPrimaryKey(long employeeGradeId);

	/**
	 * Returns all the employee grades.
	 *
	 * @return the employee grades
	 */
	public java.util.List<EmployeeGrade> findAll();

	/**
	 * Returns a range of all the employee grades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeGradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee grades
	 * @param end the upper bound of the range of employee grades (not inclusive)
	 * @return the range of employee grades
	 */
	public java.util.List<EmployeeGrade> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee grades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeGradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee grades
	 * @param end the upper bound of the range of employee grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee grades
	 */
	public java.util.List<EmployeeGrade> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeGrade>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee grades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeGradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee grades
	 * @param end the upper bound of the range of employee grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee grades
	 */
	public java.util.List<EmployeeGrade> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeGrade>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee grades from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee grades.
	 *
	 * @return the number of employee grades
	 */
	public int countAll();

}