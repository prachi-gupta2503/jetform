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

import com.adjecti.mdm.liferay.exception.NoSuchWorkAreaMinorException;
import com.adjecti.mdm.liferay.model.WorkAreaMinor;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the work area minor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkAreaMinorUtil
 * @generated
 */
@ProviderType
public interface WorkAreaMinorPersistence
	extends BasePersistence<WorkAreaMinor> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WorkAreaMinorUtil} to access the work area minor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the work area minors where workAreaMajorId = &#63; and deleted = &#63;.
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param deleted the deleted
	 * @return the matching work area minors
	 */
	public java.util.List<WorkAreaMinor> findByWorkAreaMajorIdAndDeleted(
		long workAreaMajorId, boolean deleted);

	/**
	 * Returns a range of all the work area minors where workAreaMajorId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMinorModelImpl</code>.
	 * </p>
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of work area minors
	 * @param end the upper bound of the range of work area minors (not inclusive)
	 * @return the range of matching work area minors
	 */
	public java.util.List<WorkAreaMinor> findByWorkAreaMajorIdAndDeleted(
		long workAreaMajorId, boolean deleted, int start, int end);

	/**
	 * Returns an ordered range of all the work area minors where workAreaMajorId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMinorModelImpl</code>.
	 * </p>
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of work area minors
	 * @param end the upper bound of the range of work area minors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work area minors
	 */
	public java.util.List<WorkAreaMinor> findByWorkAreaMajorIdAndDeleted(
		long workAreaMajorId, boolean deleted, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkAreaMinor>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work area minors where workAreaMajorId = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMinorModelImpl</code>.
	 * </p>
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param deleted the deleted
	 * @param start the lower bound of the range of work area minors
	 * @param end the upper bound of the range of work area minors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work area minors
	 */
	public java.util.List<WorkAreaMinor> findByWorkAreaMajorIdAndDeleted(
		long workAreaMajorId, boolean deleted, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkAreaMinor>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first work area minor in the ordered set where workAreaMajorId = &#63; and deleted = &#63;.
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area minor
	 * @throws NoSuchWorkAreaMinorException if a matching work area minor could not be found
	 */
	public WorkAreaMinor findByWorkAreaMajorIdAndDeleted_First(
			long workAreaMajorId, boolean deleted,
			com.liferay.portal.kernel.util.OrderByComparator<WorkAreaMinor>
				orderByComparator)
		throws NoSuchWorkAreaMinorException;

	/**
	 * Returns the first work area minor in the ordered set where workAreaMajorId = &#63; and deleted = &#63;.
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work area minor, or <code>null</code> if a matching work area minor could not be found
	 */
	public WorkAreaMinor fetchByWorkAreaMajorIdAndDeleted_First(
		long workAreaMajorId, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator<WorkAreaMinor>
			orderByComparator);

	/**
	 * Returns the last work area minor in the ordered set where workAreaMajorId = &#63; and deleted = &#63;.
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area minor
	 * @throws NoSuchWorkAreaMinorException if a matching work area minor could not be found
	 */
	public WorkAreaMinor findByWorkAreaMajorIdAndDeleted_Last(
			long workAreaMajorId, boolean deleted,
			com.liferay.portal.kernel.util.OrderByComparator<WorkAreaMinor>
				orderByComparator)
		throws NoSuchWorkAreaMinorException;

	/**
	 * Returns the last work area minor in the ordered set where workAreaMajorId = &#63; and deleted = &#63;.
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work area minor, or <code>null</code> if a matching work area minor could not be found
	 */
	public WorkAreaMinor fetchByWorkAreaMajorIdAndDeleted_Last(
		long workAreaMajorId, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator<WorkAreaMinor>
			orderByComparator);

	/**
	 * Returns the work area minors before and after the current work area minor in the ordered set where workAreaMajorId = &#63; and deleted = &#63;.
	 *
	 * @param workAreaMinorId the primary key of the current work area minor
	 * @param workAreaMajorId the work area major ID
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work area minor
	 * @throws NoSuchWorkAreaMinorException if a work area minor with the primary key could not be found
	 */
	public WorkAreaMinor[] findByWorkAreaMajorIdAndDeleted_PrevAndNext(
			long workAreaMinorId, long workAreaMajorId, boolean deleted,
			com.liferay.portal.kernel.util.OrderByComparator<WorkAreaMinor>
				orderByComparator)
		throws NoSuchWorkAreaMinorException;

	/**
	 * Removes all the work area minors where workAreaMajorId = &#63; and deleted = &#63; from the database.
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param deleted the deleted
	 */
	public void removeByWorkAreaMajorIdAndDeleted(
		long workAreaMajorId, boolean deleted);

	/**
	 * Returns the number of work area minors where workAreaMajorId = &#63; and deleted = &#63;.
	 *
	 * @param workAreaMajorId the work area major ID
	 * @param deleted the deleted
	 * @return the number of matching work area minors
	 */
	public int countByWorkAreaMajorIdAndDeleted(
		long workAreaMajorId, boolean deleted);

	/**
	 * Caches the work area minor in the entity cache if it is enabled.
	 *
	 * @param workAreaMinor the work area minor
	 */
	public void cacheResult(WorkAreaMinor workAreaMinor);

	/**
	 * Caches the work area minors in the entity cache if it is enabled.
	 *
	 * @param workAreaMinors the work area minors
	 */
	public void cacheResult(java.util.List<WorkAreaMinor> workAreaMinors);

	/**
	 * Creates a new work area minor with the primary key. Does not add the work area minor to the database.
	 *
	 * @param workAreaMinorId the primary key for the new work area minor
	 * @return the new work area minor
	 */
	public WorkAreaMinor create(long workAreaMinorId);

	/**
	 * Removes the work area minor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workAreaMinorId the primary key of the work area minor
	 * @return the work area minor that was removed
	 * @throws NoSuchWorkAreaMinorException if a work area minor with the primary key could not be found
	 */
	public WorkAreaMinor remove(long workAreaMinorId)
		throws NoSuchWorkAreaMinorException;

	public WorkAreaMinor updateImpl(WorkAreaMinor workAreaMinor);

	/**
	 * Returns the work area minor with the primary key or throws a <code>NoSuchWorkAreaMinorException</code> if it could not be found.
	 *
	 * @param workAreaMinorId the primary key of the work area minor
	 * @return the work area minor
	 * @throws NoSuchWorkAreaMinorException if a work area minor with the primary key could not be found
	 */
	public WorkAreaMinor findByPrimaryKey(long workAreaMinorId)
		throws NoSuchWorkAreaMinorException;

	/**
	 * Returns the work area minor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workAreaMinorId the primary key of the work area minor
	 * @return the work area minor, or <code>null</code> if a work area minor with the primary key could not be found
	 */
	public WorkAreaMinor fetchByPrimaryKey(long workAreaMinorId);

	/**
	 * Returns all the work area minors.
	 *
	 * @return the work area minors
	 */
	public java.util.List<WorkAreaMinor> findAll();

	/**
	 * Returns a range of all the work area minors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMinorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work area minors
	 * @param end the upper bound of the range of work area minors (not inclusive)
	 * @return the range of work area minors
	 */
	public java.util.List<WorkAreaMinor> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the work area minors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMinorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work area minors
	 * @param end the upper bound of the range of work area minors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of work area minors
	 */
	public java.util.List<WorkAreaMinor> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkAreaMinor>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work area minors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkAreaMinorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work area minors
	 * @param end the upper bound of the range of work area minors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of work area minors
	 */
	public java.util.List<WorkAreaMinor> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkAreaMinor>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the work area minors from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of work area minors.
	 *
	 * @return the number of work area minors
	 */
	public int countAll();

}