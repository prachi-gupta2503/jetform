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

import com.adjecti.mdm.liferay.exception.NoSuchWorkAreaMajorException;
import com.adjecti.mdm.liferay.model.WorkAreaMajor;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the work area major service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkAreaMajorUtil
 * @generated
 */
@ProviderType
public interface WorkAreaMajorPersistence
	extends BasePersistence<WorkAreaMajor> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WorkAreaMajorUtil} to access the work area major persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the work area majors where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching work area majors
	 */
	public java.util.List<WorkAreaMajor> findByCode(String code);

	/**
	 * Returns a range of all the work area majors where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMajorModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of work area majors
	 * @param end the upper bound of the range of work area majors (not inclusive)
	 * @return the range of matching work area majors
	 */
	public java.util.List<WorkAreaMajor> findByCode(
		String code, int start, int end);

	/**
	 * Returns an ordered range of all the work area majors where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMajorModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of work area majors
	 * @param end the upper bound of the range of work area majors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work area majors
	 */
	public java.util.List<WorkAreaMajor> findByCode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkAreaMajor>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work area majors where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMajorModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of work area majors
	 * @param end the upper bound of the range of work area majors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work area majors
	 */
	public java.util.List<WorkAreaMajor> findByCode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkAreaMajor>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first work area major in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area major
	 * @throws NoSuchWorkAreaMajorException if a matching work area major could not be found
	 */
	public WorkAreaMajor findByCode_First(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator<WorkAreaMajor>
				orderByComparator)
		throws NoSuchWorkAreaMajorException;

	/**
	 * Returns the first work area major in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area major, or <code>null</code> if a matching work area major could not be found
	 */
	public WorkAreaMajor fetchByCode_First(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<WorkAreaMajor>
			orderByComparator);

	/**
	 * Returns the last work area major in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area major
	 * @throws NoSuchWorkAreaMajorException if a matching work area major could not be found
	 */
	public WorkAreaMajor findByCode_Last(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator<WorkAreaMajor>
				orderByComparator)
		throws NoSuchWorkAreaMajorException;

	/**
	 * Returns the last work area major in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area major, or <code>null</code> if a matching work area major could not be found
	 */
	public WorkAreaMajor fetchByCode_Last(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<WorkAreaMajor>
			orderByComparator);

	/**
	 * Returns the work area majors before and after the current work area major in the ordered set where code = &#63;.
	 *
	 * @param workAreaMajorId the primary key of the current work area major
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work area major
	 * @throws NoSuchWorkAreaMajorException if a work area major with the primary key could not be found
	 */
	public WorkAreaMajor[] findByCode_PrevAndNext(
			long workAreaMajorId, String code,
			com.liferay.portal.kernel.util.OrderByComparator<WorkAreaMajor>
				orderByComparator)
		throws NoSuchWorkAreaMajorException;

	/**
	 * Removes all the work area majors where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public void removeByCode(String code);

	/**
	 * Returns the number of work area majors where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching work area majors
	 */
	public int countByCode(String code);

	/**
	 * Returns all the work area majors where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching work area majors
	 */
	public java.util.List<WorkAreaMajor> findByName(String name);

	/**
	 * Returns a range of all the work area majors where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMajorModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of work area majors
	 * @param end the upper bound of the range of work area majors (not inclusive)
	 * @return the range of matching work area majors
	 */
	public java.util.List<WorkAreaMajor> findByName(
		String name, int start, int end);

	/**
	 * Returns an ordered range of all the work area majors where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMajorModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of work area majors
	 * @param end the upper bound of the range of work area majors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work area majors
	 */
	public java.util.List<WorkAreaMajor> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkAreaMajor>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work area majors where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMajorModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of work area majors
	 * @param end the upper bound of the range of work area majors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work area majors
	 */
	public java.util.List<WorkAreaMajor> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkAreaMajor>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first work area major in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area major
	 * @throws NoSuchWorkAreaMajorException if a matching work area major could not be found
	 */
	public WorkAreaMajor findByName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<WorkAreaMajor>
				orderByComparator)
		throws NoSuchWorkAreaMajorException;

	/**
	 * Returns the first work area major in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area major, or <code>null</code> if a matching work area major could not be found
	 */
	public WorkAreaMajor fetchByName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<WorkAreaMajor>
			orderByComparator);

	/**
	 * Returns the last work area major in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area major
	 * @throws NoSuchWorkAreaMajorException if a matching work area major could not be found
	 */
	public WorkAreaMajor findByName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<WorkAreaMajor>
				orderByComparator)
		throws NoSuchWorkAreaMajorException;

	/**
	 * Returns the last work area major in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area major, or <code>null</code> if a matching work area major could not be found
	 */
	public WorkAreaMajor fetchByName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<WorkAreaMajor>
			orderByComparator);

	/**
	 * Returns the work area majors before and after the current work area major in the ordered set where name = &#63;.
	 *
	 * @param workAreaMajorId the primary key of the current work area major
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work area major
	 * @throws NoSuchWorkAreaMajorException if a work area major with the primary key could not be found
	 */
	public WorkAreaMajor[] findByName_PrevAndNext(
			long workAreaMajorId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<WorkAreaMajor>
				orderByComparator)
		throws NoSuchWorkAreaMajorException;

	/**
	 * Removes all the work area majors where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByName(String name);

	/**
	 * Returns the number of work area majors where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching work area majors
	 */
	public int countByName(String name);

	/**
	 * Returns all the work area majors where parentWorkAreaId = &#63;.
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @return the matching work area majors
	 */
	public java.util.List<WorkAreaMajor> findByParentWorkAreaId(
		long parentWorkAreaId);

	/**
	 * Returns a range of all the work area majors where parentWorkAreaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMajorModelImpl</code>.
	 * </p>
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @param start the lower bound of the range of work area majors
	 * @param end the upper bound of the range of work area majors (not inclusive)
	 * @return the range of matching work area majors
	 */
	public java.util.List<WorkAreaMajor> findByParentWorkAreaId(
		long parentWorkAreaId, int start, int end);

	/**
	 * Returns an ordered range of all the work area majors where parentWorkAreaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMajorModelImpl</code>.
	 * </p>
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @param start the lower bound of the range of work area majors
	 * @param end the upper bound of the range of work area majors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work area majors
	 */
	public java.util.List<WorkAreaMajor> findByParentWorkAreaId(
		long parentWorkAreaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkAreaMajor>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work area majors where parentWorkAreaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMajorModelImpl</code>.
	 * </p>
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @param start the lower bound of the range of work area majors
	 * @param end the upper bound of the range of work area majors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work area majors
	 */
	public java.util.List<WorkAreaMajor> findByParentWorkAreaId(
		long parentWorkAreaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkAreaMajor>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first work area major in the ordered set where parentWorkAreaId = &#63;.
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area major
	 * @throws NoSuchWorkAreaMajorException if a matching work area major could not be found
	 */
	public WorkAreaMajor findByParentWorkAreaId_First(
			long parentWorkAreaId,
			com.liferay.portal.kernel.util.OrderByComparator<WorkAreaMajor>
				orderByComparator)
		throws NoSuchWorkAreaMajorException;

	/**
	 * Returns the first work area major in the ordered set where parentWorkAreaId = &#63;.
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area major, or <code>null</code> if a matching work area major could not be found
	 */
	public WorkAreaMajor fetchByParentWorkAreaId_First(
		long parentWorkAreaId,
		com.liferay.portal.kernel.util.OrderByComparator<WorkAreaMajor>
			orderByComparator);

	/**
	 * Returns the last work area major in the ordered set where parentWorkAreaId = &#63;.
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area major
	 * @throws NoSuchWorkAreaMajorException if a matching work area major could not be found
	 */
	public WorkAreaMajor findByParentWorkAreaId_Last(
			long parentWorkAreaId,
			com.liferay.portal.kernel.util.OrderByComparator<WorkAreaMajor>
				orderByComparator)
		throws NoSuchWorkAreaMajorException;

	/**
	 * Returns the last work area major in the ordered set where parentWorkAreaId = &#63;.
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area major, or <code>null</code> if a matching work area major could not be found
	 */
	public WorkAreaMajor fetchByParentWorkAreaId_Last(
		long parentWorkAreaId,
		com.liferay.portal.kernel.util.OrderByComparator<WorkAreaMajor>
			orderByComparator);

	/**
	 * Returns the work area majors before and after the current work area major in the ordered set where parentWorkAreaId = &#63;.
	 *
	 * @param workAreaMajorId the primary key of the current work area major
	 * @param parentWorkAreaId the parent work area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work area major
	 * @throws NoSuchWorkAreaMajorException if a work area major with the primary key could not be found
	 */
	public WorkAreaMajor[] findByParentWorkAreaId_PrevAndNext(
			long workAreaMajorId, long parentWorkAreaId,
			com.liferay.portal.kernel.util.OrderByComparator<WorkAreaMajor>
				orderByComparator)
		throws NoSuchWorkAreaMajorException;

	/**
	 * Removes all the work area majors where parentWorkAreaId = &#63; from the database.
	 *
	 * @param parentWorkAreaId the parent work area ID
	 */
	public void removeByParentWorkAreaId(long parentWorkAreaId);

	/**
	 * Returns the number of work area majors where parentWorkAreaId = &#63;.
	 *
	 * @param parentWorkAreaId the parent work area ID
	 * @return the number of matching work area majors
	 */
	public int countByParentWorkAreaId(long parentWorkAreaId);

	/**
	 * Caches the work area major in the entity cache if it is enabled.
	 *
	 * @param workAreaMajor the work area major
	 */
	public void cacheResult(WorkAreaMajor workAreaMajor);

	/**
	 * Caches the work area majors in the entity cache if it is enabled.
	 *
	 * @param workAreaMajors the work area majors
	 */
	public void cacheResult(java.util.List<WorkAreaMajor> workAreaMajors);

	/**
	 * Creates a new work area major with the primary key. Does not add the work area major to the database.
	 *
	 * @param workAreaMajorId the primary key for the new work area major
	 * @return the new work area major
	 */
	public WorkAreaMajor create(long workAreaMajorId);

	/**
	 * Removes the work area major with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workAreaMajorId the primary key of the work area major
	 * @return the work area major that was removed
	 * @throws NoSuchWorkAreaMajorException if a work area major with the primary key could not be found
	 */
	public WorkAreaMajor remove(long workAreaMajorId)
		throws NoSuchWorkAreaMajorException;

	public WorkAreaMajor updateImpl(WorkAreaMajor workAreaMajor);

	/**
	 * Returns the work area major with the primary key or throws a <code>NoSuchWorkAreaMajorException</code> if it could not be found.
	 *
	 * @param workAreaMajorId the primary key of the work area major
	 * @return the work area major
	 * @throws NoSuchWorkAreaMajorException if a work area major with the primary key could not be found
	 */
	public WorkAreaMajor findByPrimaryKey(long workAreaMajorId)
		throws NoSuchWorkAreaMajorException;

	/**
	 * Returns the work area major with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workAreaMajorId the primary key of the work area major
	 * @return the work area major, or <code>null</code> if a work area major with the primary key could not be found
	 */
	public WorkAreaMajor fetchByPrimaryKey(long workAreaMajorId);

	/**
	 * Returns all the work area majors.
	 *
	 * @return the work area majors
	 */
	public java.util.List<WorkAreaMajor> findAll();

	/**
	 * Returns a range of all the work area majors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMajorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work area majors
	 * @param end the upper bound of the range of work area majors (not inclusive)
	 * @return the range of work area majors
	 */
	public java.util.List<WorkAreaMajor> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the work area majors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMajorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work area majors
	 * @param end the upper bound of the range of work area majors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of work area majors
	 */
	public java.util.List<WorkAreaMajor> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkAreaMajor>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work area majors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMajorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work area majors
	 * @param end the upper bound of the range of work area majors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of work area majors
	 */
	public java.util.List<WorkAreaMajor> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkAreaMajor>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the work area majors from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of work area majors.
	 *
	 * @return the number of work area majors
	 */
	public int countAll();

}