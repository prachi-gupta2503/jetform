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

import com.adjecti.mdm.liferay.exception.NoSuchDesignationException;
import com.adjecti.mdm.liferay.model.Designation;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the designation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DesignationUtil
 * @generated
 */
@ProviderType
public interface DesignationPersistence extends BasePersistence<Designation> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DesignationUtil} to access the designation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the designation where code = &#63; or throws a <code>NoSuchDesignationException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public Designation findByCode(String code)
		throws NoSuchDesignationException;

	/**
	 * Returns the designation where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public Designation fetchByCode(String code);

	/**
	 * Returns the designation where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public Designation fetchByCode(String code, boolean useFinderCache);

	/**
	 * Removes the designation where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the designation that was removed
	 */
	public Designation removeByCode(String code)
		throws NoSuchDesignationException;

	/**
	 * Returns the number of designations where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching designations
	 */
	public int countByCode(String code);

	/**
	 * Returns all the designations where name_En = &#63;.
	 *
	 * @param name_En the name_ en
	 * @return the matching designations
	 */
	public java.util.List<Designation> findByName(String name_En);

	/**
	 * Returns a range of all the designations where name_En = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param name_En the name_ en
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @return the range of matching designations
	 */
	public java.util.List<Designation> findByName(
		String name_En, int start, int end);

	/**
	 * Returns an ordered range of all the designations where name_En = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param name_En the name_ en
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching designations
	 */
	public java.util.List<Designation> findByName(
		String name_En, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the designations where name_En = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param name_En the name_ en
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching designations
	 */
	public java.util.List<Designation> findByName(
		String name_En, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first designation in the ordered set where name_En = &#63;.
	 *
	 * @param name_En the name_ en
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public Designation findByName_First(
			String name_En,
			com.liferay.portal.kernel.util.OrderByComparator<Designation>
				orderByComparator)
		throws NoSuchDesignationException;

	/**
	 * Returns the first designation in the ordered set where name_En = &#63;.
	 *
	 * @param name_En the name_ en
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public Designation fetchByName_First(
		String name_En,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator);

	/**
	 * Returns the last designation in the ordered set where name_En = &#63;.
	 *
	 * @param name_En the name_ en
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public Designation findByName_Last(
			String name_En,
			com.liferay.portal.kernel.util.OrderByComparator<Designation>
				orderByComparator)
		throws NoSuchDesignationException;

	/**
	 * Returns the last designation in the ordered set where name_En = &#63;.
	 *
	 * @param name_En the name_ en
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public Designation fetchByName_Last(
		String name_En,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator);

	/**
	 * Returns the designations before and after the current designation in the ordered set where name_En = &#63;.
	 *
	 * @param designationId the primary key of the current designation
	 * @param name_En the name_ en
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next designation
	 * @throws NoSuchDesignationException if a designation with the primary key could not be found
	 */
	public Designation[] findByName_PrevAndNext(
			long designationId, String name_En,
			com.liferay.portal.kernel.util.OrderByComparator<Designation>
				orderByComparator)
		throws NoSuchDesignationException;

	/**
	 * Removes all the designations where name_En = &#63; from the database.
	 *
	 * @param name_En the name_ en
	 */
	public void removeByName(String name_En);

	/**
	 * Returns the number of designations where name_En = &#63;.
	 *
	 * @param name_En the name_ en
	 * @return the number of matching designations
	 */
	public int countByName(String name_En);

	/**
	 * Returns all the designations where gradeId = &#63; and deleted = &#63;.
	 *
	 * @param gradeId the grade ID
	 * @param deleted the deleted
	 * @return the matching designations
	 */
	public java.util.List<Designation> findByGradeId(
		long gradeId, boolean deleted);

	/**
	 * Returns a range of all the designations where gradeId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param gradeId the grade ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @return the range of matching designations
	 */
	public java.util.List<Designation> findByGradeId(
		long gradeId, boolean deleted, int start, int end);

	/**
	 * Returns an ordered range of all the designations where gradeId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param gradeId the grade ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching designations
	 */
	public java.util.List<Designation> findByGradeId(
		long gradeId, boolean deleted, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the designations where gradeId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param gradeId the grade ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching designations
	 */
	public java.util.List<Designation> findByGradeId(
		long gradeId, boolean deleted, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first designation in the ordered set where gradeId = &#63; and deleted = &#63;.
	 *
	 * @param gradeId the grade ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public Designation findByGradeId_First(
			long gradeId, boolean deleted,
			com.liferay.portal.kernel.util.OrderByComparator<Designation>
				orderByComparator)
		throws NoSuchDesignationException;

	/**
	 * Returns the first designation in the ordered set where gradeId = &#63; and deleted = &#63;.
	 *
	 * @param gradeId the grade ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public Designation fetchByGradeId_First(
		long gradeId, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator);

	/**
	 * Returns the last designation in the ordered set where gradeId = &#63; and deleted = &#63;.
	 *
	 * @param gradeId the grade ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public Designation findByGradeId_Last(
			long gradeId, boolean deleted,
			com.liferay.portal.kernel.util.OrderByComparator<Designation>
				orderByComparator)
		throws NoSuchDesignationException;

	/**
	 * Returns the last designation in the ordered set where gradeId = &#63; and deleted = &#63;.
	 *
	 * @param gradeId the grade ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public Designation fetchByGradeId_Last(
		long gradeId, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator);

	/**
	 * Returns the designations before and after the current designation in the ordered set where gradeId = &#63; and deleted = &#63;.
	 *
	 * @param designationId the primary key of the current designation
	 * @param gradeId the grade ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next designation
	 * @throws NoSuchDesignationException if a designation with the primary key could not be found
	 */
	public Designation[] findByGradeId_PrevAndNext(
			long designationId, long gradeId, boolean deleted,
			com.liferay.portal.kernel.util.OrderByComparator<Designation>
				orderByComparator)
		throws NoSuchDesignationException;

	/**
	 * Removes all the designations where gradeId = &#63; and deleted = &#63; from the database.
	 *
	 * @param gradeId the grade ID
	 * @param deleted the deleted
	 */
	public void removeByGradeId(long gradeId, boolean deleted);

	/**
	 * Returns the number of designations where gradeId = &#63; and deleted = &#63;.
	 *
	 * @param gradeId the grade ID
	 * @param deleted the deleted
	 * @return the number of matching designations
	 */
	public int countByGradeId(long gradeId, boolean deleted);

	/**
	 * Returns all the designations where designationClassId = &#63;.
	 *
	 * @param designationClassId the designation class ID
	 * @return the matching designations
	 */
	public java.util.List<Designation> findByDesignationClassId(
		long designationClassId);

	/**
	 * Returns a range of all the designations where designationClassId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationClassId the designation class ID
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @return the range of matching designations
	 */
	public java.util.List<Designation> findByDesignationClassId(
		long designationClassId, int start, int end);

	/**
	 * Returns an ordered range of all the designations where designationClassId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationClassId the designation class ID
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching designations
	 */
	public java.util.List<Designation> findByDesignationClassId(
		long designationClassId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the designations where designationClassId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationClassId the designation class ID
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching designations
	 */
	public java.util.List<Designation> findByDesignationClassId(
		long designationClassId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first designation in the ordered set where designationClassId = &#63;.
	 *
	 * @param designationClassId the designation class ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public Designation findByDesignationClassId_First(
			long designationClassId,
			com.liferay.portal.kernel.util.OrderByComparator<Designation>
				orderByComparator)
		throws NoSuchDesignationException;

	/**
	 * Returns the first designation in the ordered set where designationClassId = &#63;.
	 *
	 * @param designationClassId the designation class ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public Designation fetchByDesignationClassId_First(
		long designationClassId,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator);

	/**
	 * Returns the last designation in the ordered set where designationClassId = &#63;.
	 *
	 * @param designationClassId the designation class ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public Designation findByDesignationClassId_Last(
			long designationClassId,
			com.liferay.portal.kernel.util.OrderByComparator<Designation>
				orderByComparator)
		throws NoSuchDesignationException;

	/**
	 * Returns the last designation in the ordered set where designationClassId = &#63;.
	 *
	 * @param designationClassId the designation class ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public Designation fetchByDesignationClassId_Last(
		long designationClassId,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator);

	/**
	 * Returns the designations before and after the current designation in the ordered set where designationClassId = &#63;.
	 *
	 * @param designationId the primary key of the current designation
	 * @param designationClassId the designation class ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next designation
	 * @throws NoSuchDesignationException if a designation with the primary key could not be found
	 */
	public Designation[] findByDesignationClassId_PrevAndNext(
			long designationId, long designationClassId,
			com.liferay.portal.kernel.util.OrderByComparator<Designation>
				orderByComparator)
		throws NoSuchDesignationException;

	/**
	 * Removes all the designations where designationClassId = &#63; from the database.
	 *
	 * @param designationClassId the designation class ID
	 */
	public void removeByDesignationClassId(long designationClassId);

	/**
	 * Returns the number of designations where designationClassId = &#63;.
	 *
	 * @param designationClassId the designation class ID
	 * @return the number of matching designations
	 */
	public int countByDesignationClassId(long designationClassId);

	/**
	 * Returns all the designations where designationGroupId = &#63;.
	 *
	 * @param designationGroupId the designation group ID
	 * @return the matching designations
	 */
	public java.util.List<Designation> findByDesignationGroupId(
		long designationGroupId);

	/**
	 * Returns a range of all the designations where designationGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationGroupId the designation group ID
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @return the range of matching designations
	 */
	public java.util.List<Designation> findByDesignationGroupId(
		long designationGroupId, int start, int end);

	/**
	 * Returns an ordered range of all the designations where designationGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationGroupId the designation group ID
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching designations
	 */
	public java.util.List<Designation> findByDesignationGroupId(
		long designationGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the designations where designationGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationGroupId the designation group ID
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching designations
	 */
	public java.util.List<Designation> findByDesignationGroupId(
		long designationGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first designation in the ordered set where designationGroupId = &#63;.
	 *
	 * @param designationGroupId the designation group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public Designation findByDesignationGroupId_First(
			long designationGroupId,
			com.liferay.portal.kernel.util.OrderByComparator<Designation>
				orderByComparator)
		throws NoSuchDesignationException;

	/**
	 * Returns the first designation in the ordered set where designationGroupId = &#63;.
	 *
	 * @param designationGroupId the designation group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public Designation fetchByDesignationGroupId_First(
		long designationGroupId,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator);

	/**
	 * Returns the last designation in the ordered set where designationGroupId = &#63;.
	 *
	 * @param designationGroupId the designation group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public Designation findByDesignationGroupId_Last(
			long designationGroupId,
			com.liferay.portal.kernel.util.OrderByComparator<Designation>
				orderByComparator)
		throws NoSuchDesignationException;

	/**
	 * Returns the last designation in the ordered set where designationGroupId = &#63;.
	 *
	 * @param designationGroupId the designation group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public Designation fetchByDesignationGroupId_Last(
		long designationGroupId,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator);

	/**
	 * Returns the designations before and after the current designation in the ordered set where designationGroupId = &#63;.
	 *
	 * @param designationId the primary key of the current designation
	 * @param designationGroupId the designation group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next designation
	 * @throws NoSuchDesignationException if a designation with the primary key could not be found
	 */
	public Designation[] findByDesignationGroupId_PrevAndNext(
			long designationId, long designationGroupId,
			com.liferay.portal.kernel.util.OrderByComparator<Designation>
				orderByComparator)
		throws NoSuchDesignationException;

	/**
	 * Removes all the designations where designationGroupId = &#63; from the database.
	 *
	 * @param designationGroupId the designation group ID
	 */
	public void removeByDesignationGroupId(long designationGroupId);

	/**
	 * Returns the number of designations where designationGroupId = &#63;.
	 *
	 * @param designationGroupId the designation group ID
	 * @return the number of matching designations
	 */
	public int countByDesignationGroupId(long designationGroupId);

	/**
	 * Returns all the designations where designationGroupId = &#63; and deleted = &#63;.
	 *
	 * @param designationGroupId the designation group ID
	 * @param deleted the deleted
	 * @return the matching designations
	 */
	public java.util.List<Designation> findByDesignationGroupIdAndDeleted(
		long designationGroupId, boolean deleted);

	/**
	 * Returns a range of all the designations where designationGroupId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationGroupId the designation group ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @return the range of matching designations
	 */
	public java.util.List<Designation> findByDesignationGroupIdAndDeleted(
		long designationGroupId, boolean deleted, int start, int end);

	/**
	 * Returns an ordered range of all the designations where designationGroupId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationGroupId the designation group ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching designations
	 */
	public java.util.List<Designation> findByDesignationGroupIdAndDeleted(
		long designationGroupId, boolean deleted, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the designations where designationGroupId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationGroupId the designation group ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching designations
	 */
	public java.util.List<Designation> findByDesignationGroupIdAndDeleted(
		long designationGroupId, boolean deleted, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first designation in the ordered set where designationGroupId = &#63; and deleted = &#63;.
	 *
	 * @param designationGroupId the designation group ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public Designation findByDesignationGroupIdAndDeleted_First(
			long designationGroupId, boolean deleted,
			com.liferay.portal.kernel.util.OrderByComparator<Designation>
				orderByComparator)
		throws NoSuchDesignationException;

	/**
	 * Returns the first designation in the ordered set where designationGroupId = &#63; and deleted = &#63;.
	 *
	 * @param designationGroupId the designation group ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public Designation fetchByDesignationGroupIdAndDeleted_First(
		long designationGroupId, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator);

	/**
	 * Returns the last designation in the ordered set where designationGroupId = &#63; and deleted = &#63;.
	 *
	 * @param designationGroupId the designation group ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public Designation findByDesignationGroupIdAndDeleted_Last(
			long designationGroupId, boolean deleted,
			com.liferay.portal.kernel.util.OrderByComparator<Designation>
				orderByComparator)
		throws NoSuchDesignationException;

	/**
	 * Returns the last designation in the ordered set where designationGroupId = &#63; and deleted = &#63;.
	 *
	 * @param designationGroupId the designation group ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public Designation fetchByDesignationGroupIdAndDeleted_Last(
		long designationGroupId, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator);

	/**
	 * Returns the designations before and after the current designation in the ordered set where designationGroupId = &#63; and deleted = &#63;.
	 *
	 * @param designationId the primary key of the current designation
	 * @param designationGroupId the designation group ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next designation
	 * @throws NoSuchDesignationException if a designation with the primary key could not be found
	 */
	public Designation[] findByDesignationGroupIdAndDeleted_PrevAndNext(
			long designationId, long designationGroupId, boolean deleted,
			com.liferay.portal.kernel.util.OrderByComparator<Designation>
				orderByComparator)
		throws NoSuchDesignationException;

	/**
	 * Removes all the designations where designationGroupId = &#63; and deleted = &#63; from the database.
	 *
	 * @param designationGroupId the designation group ID
	 * @param deleted the deleted
	 */
	public void removeByDesignationGroupIdAndDeleted(
		long designationGroupId, boolean deleted);

	/**
	 * Returns the number of designations where designationGroupId = &#63; and deleted = &#63;.
	 *
	 * @param designationGroupId the designation group ID
	 * @param deleted the deleted
	 * @return the number of matching designations
	 */
	public int countByDesignationGroupIdAndDeleted(
		long designationGroupId, boolean deleted);

	/**
	 * Returns all the designations where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching designations
	 */
	public java.util.List<Designation> findByStatus(int status);

	/**
	 * Returns a range of all the designations where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @return the range of matching designations
	 */
	public java.util.List<Designation> findByStatus(
		int status, int start, int end);

	/**
	 * Returns an ordered range of all the designations where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching designations
	 */
	public java.util.List<Designation> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the designations where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching designations
	 */
	public java.util.List<Designation> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first designation in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public Designation findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<Designation>
				orderByComparator)
		throws NoSuchDesignationException;

	/**
	 * Returns the first designation in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public Designation fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator);

	/**
	 * Returns the last designation in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public Designation findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<Designation>
				orderByComparator)
		throws NoSuchDesignationException;

	/**
	 * Returns the last designation in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public Designation fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator);

	/**
	 * Returns the designations before and after the current designation in the ordered set where status = &#63;.
	 *
	 * @param designationId the primary key of the current designation
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next designation
	 * @throws NoSuchDesignationException if a designation with the primary key could not be found
	 */
	public Designation[] findByStatus_PrevAndNext(
			long designationId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Designation>
				orderByComparator)
		throws NoSuchDesignationException;

	/**
	 * Removes all the designations where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of designations where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching designations
	 */
	public int countByStatus(int status);

	/**
	 * Returns all the designations where designationGroup = &#63; and status = &#63;.
	 *
	 * @param designationGroup the designation group
	 * @param status the status
	 * @return the matching designations
	 */
	public java.util.List<Designation> findByDesignationGroup(
		String designationGroup, int status);

	/**
	 * Returns a range of all the designations where designationGroup = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationGroup the designation group
	 * @param status the status
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @return the range of matching designations
	 */
	public java.util.List<Designation> findByDesignationGroup(
		String designationGroup, int status, int start, int end);

	/**
	 * Returns an ordered range of all the designations where designationGroup = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationGroup the designation group
	 * @param status the status
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching designations
	 */
	public java.util.List<Designation> findByDesignationGroup(
		String designationGroup, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the designations where designationGroup = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationGroup the designation group
	 * @param status the status
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching designations
	 */
	public java.util.List<Designation> findByDesignationGroup(
		String designationGroup, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first designation in the ordered set where designationGroup = &#63; and status = &#63;.
	 *
	 * @param designationGroup the designation group
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public Designation findByDesignationGroup_First(
			String designationGroup, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Designation>
				orderByComparator)
		throws NoSuchDesignationException;

	/**
	 * Returns the first designation in the ordered set where designationGroup = &#63; and status = &#63;.
	 *
	 * @param designationGroup the designation group
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public Designation fetchByDesignationGroup_First(
		String designationGroup, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator);

	/**
	 * Returns the last designation in the ordered set where designationGroup = &#63; and status = &#63;.
	 *
	 * @param designationGroup the designation group
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public Designation findByDesignationGroup_Last(
			String designationGroup, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Designation>
				orderByComparator)
		throws NoSuchDesignationException;

	/**
	 * Returns the last designation in the ordered set where designationGroup = &#63; and status = &#63;.
	 *
	 * @param designationGroup the designation group
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public Designation fetchByDesignationGroup_Last(
		String designationGroup, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator);

	/**
	 * Returns the designations before and after the current designation in the ordered set where designationGroup = &#63; and status = &#63;.
	 *
	 * @param designationId the primary key of the current designation
	 * @param designationGroup the designation group
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next designation
	 * @throws NoSuchDesignationException if a designation with the primary key could not be found
	 */
	public Designation[] findByDesignationGroup_PrevAndNext(
			long designationId, String designationGroup, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Designation>
				orderByComparator)
		throws NoSuchDesignationException;

	/**
	 * Removes all the designations where designationGroup = &#63; and status = &#63; from the database.
	 *
	 * @param designationGroup the designation group
	 * @param status the status
	 */
	public void removeByDesignationGroup(String designationGroup, int status);

	/**
	 * Returns the number of designations where designationGroup = &#63; and status = &#63;.
	 *
	 * @param designationGroup the designation group
	 * @param status the status
	 * @return the number of matching designations
	 */
	public int countByDesignationGroup(String designationGroup, int status);

	/**
	 * Caches the designation in the entity cache if it is enabled.
	 *
	 * @param designation the designation
	 */
	public void cacheResult(Designation designation);

	/**
	 * Caches the designations in the entity cache if it is enabled.
	 *
	 * @param designations the designations
	 */
	public void cacheResult(java.util.List<Designation> designations);

	/**
	 * Creates a new designation with the primary key. Does not add the designation to the database.
	 *
	 * @param designationId the primary key for the new designation
	 * @return the new designation
	 */
	public Designation create(long designationId);

	/**
	 * Removes the designation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param designationId the primary key of the designation
	 * @return the designation that was removed
	 * @throws NoSuchDesignationException if a designation with the primary key could not be found
	 */
	public Designation remove(long designationId)
		throws NoSuchDesignationException;

	public Designation updateImpl(Designation designation);

	/**
	 * Returns the designation with the primary key or throws a <code>NoSuchDesignationException</code> if it could not be found.
	 *
	 * @param designationId the primary key of the designation
	 * @return the designation
	 * @throws NoSuchDesignationException if a designation with the primary key could not be found
	 */
	public Designation findByPrimaryKey(long designationId)
		throws NoSuchDesignationException;

	/**
	 * Returns the designation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param designationId the primary key of the designation
	 * @return the designation, or <code>null</code> if a designation with the primary key could not be found
	 */
	public Designation fetchByPrimaryKey(long designationId);

	/**
	 * Returns all the designations.
	 *
	 * @return the designations
	 */
	public java.util.List<Designation> findAll();

	/**
	 * Returns a range of all the designations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @return the range of designations
	 */
	public java.util.List<Designation> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the designations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of designations
	 */
	public java.util.List<Designation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the designations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of designations
	 */
	public java.util.List<Designation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the designations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of designations.
	 *
	 * @return the number of designations
	 */
	public int countAll();

}