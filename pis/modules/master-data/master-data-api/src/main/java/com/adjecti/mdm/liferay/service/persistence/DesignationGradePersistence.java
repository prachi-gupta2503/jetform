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

import com.adjecti.mdm.liferay.exception.NoSuchDesignationGradeException;
import com.adjecti.mdm.liferay.model.DesignationGrade;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the designation grade service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DesignationGradeUtil
 * @generated
 */
@ProviderType
public interface DesignationGradePersistence
	extends BasePersistence<DesignationGrade> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DesignationGradeUtil} to access the designation grade persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the designation grade in the entity cache if it is enabled.
	 *
	 * @param designationGrade the designation grade
	 */
	public void cacheResult(DesignationGrade designationGrade);

	/**
	 * Caches the designation grades in the entity cache if it is enabled.
	 *
	 * @param designationGrades the designation grades
	 */
	public void cacheResult(java.util.List<DesignationGrade> designationGrades);

	/**
	 * Creates a new designation grade with the primary key. Does not add the designation grade to the database.
	 *
	 * @param designationGradeId the primary key for the new designation grade
	 * @return the new designation grade
	 */
	public DesignationGrade create(long designationGradeId);

	/**
	 * Removes the designation grade with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param designationGradeId the primary key of the designation grade
	 * @return the designation grade that was removed
	 * @throws NoSuchDesignationGradeException if a designation grade with the primary key could not be found
	 */
	public DesignationGrade remove(long designationGradeId)
		throws NoSuchDesignationGradeException;

	public DesignationGrade updateImpl(DesignationGrade designationGrade);

	/**
	 * Returns the designation grade with the primary key or throws a <code>NoSuchDesignationGradeException</code> if it could not be found.
	 *
	 * @param designationGradeId the primary key of the designation grade
	 * @return the designation grade
	 * @throws NoSuchDesignationGradeException if a designation grade with the primary key could not be found
	 */
	public DesignationGrade findByPrimaryKey(long designationGradeId)
		throws NoSuchDesignationGradeException;

	/**
	 * Returns the designation grade with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param designationGradeId the primary key of the designation grade
	 * @return the designation grade, or <code>null</code> if a designation grade with the primary key could not be found
	 */
	public DesignationGrade fetchByPrimaryKey(long designationGradeId);

	/**
	 * Returns all the designation grades.
	 *
	 * @return the designation grades
	 */
	public java.util.List<DesignationGrade> findAll();

	/**
	 * Returns a range of all the designation grades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationGradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation grades
	 * @param end the upper bound of the range of designation grades (not inclusive)
	 * @return the range of designation grades
	 */
	public java.util.List<DesignationGrade> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the designation grades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationGradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation grades
	 * @param end the upper bound of the range of designation grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of designation grades
	 */
	public java.util.List<DesignationGrade> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DesignationGrade>
			orderByComparator);

	/**
	 * Returns an ordered range of all the designation grades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationGradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation grades
	 * @param end the upper bound of the range of designation grades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of designation grades
	 */
	public java.util.List<DesignationGrade> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DesignationGrade>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the designation grades from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of designation grades.
	 *
	 * @return the number of designation grades
	 */
	public int countAll();

}