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

import com.adjecti.mdm.liferay.exception.NoSuchWorkStationException;
import com.adjecti.mdm.liferay.model.WorkStation;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the work station service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkStationUtil
 * @generated
 */
@ProviderType
public interface WorkStationPersistence extends BasePersistence<WorkStation> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WorkStationUtil} to access the work station persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the work stations where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching work stations
	 */
	public java.util.List<WorkStation> findByCode(String code);

	/**
	 * Returns a range of all the work stations where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkStationModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of work stations
	 * @param end the upper bound of the range of work stations (not inclusive)
	 * @return the range of matching work stations
	 */
	public java.util.List<WorkStation> findByCode(
		String code, int start, int end);

	/**
	 * Returns an ordered range of all the work stations where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkStationModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of work stations
	 * @param end the upper bound of the range of work stations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work stations
	 */
	public java.util.List<WorkStation> findByCode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkStation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work stations where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkStationModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of work stations
	 * @param end the upper bound of the range of work stations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work stations
	 */
	public java.util.List<WorkStation> findByCode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkStation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first work station in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work station
	 * @throws NoSuchWorkStationException if a matching work station could not be found
	 */
	public WorkStation findByCode_First(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator<WorkStation>
				orderByComparator)
		throws NoSuchWorkStationException;

	/**
	 * Returns the first work station in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work station, or <code>null</code> if a matching work station could not be found
	 */
	public WorkStation fetchByCode_First(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<WorkStation>
			orderByComparator);

	/**
	 * Returns the last work station in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work station
	 * @throws NoSuchWorkStationException if a matching work station could not be found
	 */
	public WorkStation findByCode_Last(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator<WorkStation>
				orderByComparator)
		throws NoSuchWorkStationException;

	/**
	 * Returns the last work station in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work station, or <code>null</code> if a matching work station could not be found
	 */
	public WorkStation fetchByCode_Last(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<WorkStation>
			orderByComparator);

	/**
	 * Returns the work stations before and after the current work station in the ordered set where code = &#63;.
	 *
	 * @param workStationId the primary key of the current work station
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work station
	 * @throws NoSuchWorkStationException if a work station with the primary key could not be found
	 */
	public WorkStation[] findByCode_PrevAndNext(
			long workStationId, String code,
			com.liferay.portal.kernel.util.OrderByComparator<WorkStation>
				orderByComparator)
		throws NoSuchWorkStationException;

	/**
	 * Removes all the work stations where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public void removeByCode(String code);

	/**
	 * Returns the number of work stations where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching work stations
	 */
	public int countByCode(String code);

	/**
	 * Returns all the work stations where deskNo = &#63;.
	 *
	 * @param deskNo the desk no
	 * @return the matching work stations
	 */
	public java.util.List<WorkStation> findByDeskNo(String deskNo);

	/**
	 * Returns a range of all the work stations where deskNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkStationModelImpl</code>.
	 * </p>
	 *
	 * @param deskNo the desk no
	 * @param start the lower bound of the range of work stations
	 * @param end the upper bound of the range of work stations (not inclusive)
	 * @return the range of matching work stations
	 */
	public java.util.List<WorkStation> findByDeskNo(
		String deskNo, int start, int end);

	/**
	 * Returns an ordered range of all the work stations where deskNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkStationModelImpl</code>.
	 * </p>
	 *
	 * @param deskNo the desk no
	 * @param start the lower bound of the range of work stations
	 * @param end the upper bound of the range of work stations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work stations
	 */
	public java.util.List<WorkStation> findByDeskNo(
		String deskNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkStation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work stations where deskNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkStationModelImpl</code>.
	 * </p>
	 *
	 * @param deskNo the desk no
	 * @param start the lower bound of the range of work stations
	 * @param end the upper bound of the range of work stations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work stations
	 */
	public java.util.List<WorkStation> findByDeskNo(
		String deskNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkStation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first work station in the ordered set where deskNo = &#63;.
	 *
	 * @param deskNo the desk no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work station
	 * @throws NoSuchWorkStationException if a matching work station could not be found
	 */
	public WorkStation findByDeskNo_First(
			String deskNo,
			com.liferay.portal.kernel.util.OrderByComparator<WorkStation>
				orderByComparator)
		throws NoSuchWorkStationException;

	/**
	 * Returns the first work station in the ordered set where deskNo = &#63;.
	 *
	 * @param deskNo the desk no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work station, or <code>null</code> if a matching work station could not be found
	 */
	public WorkStation fetchByDeskNo_First(
		String deskNo,
		com.liferay.portal.kernel.util.OrderByComparator<WorkStation>
			orderByComparator);

	/**
	 * Returns the last work station in the ordered set where deskNo = &#63;.
	 *
	 * @param deskNo the desk no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work station
	 * @throws NoSuchWorkStationException if a matching work station could not be found
	 */
	public WorkStation findByDeskNo_Last(
			String deskNo,
			com.liferay.portal.kernel.util.OrderByComparator<WorkStation>
				orderByComparator)
		throws NoSuchWorkStationException;

	/**
	 * Returns the last work station in the ordered set where deskNo = &#63;.
	 *
	 * @param deskNo the desk no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work station, or <code>null</code> if a matching work station could not be found
	 */
	public WorkStation fetchByDeskNo_Last(
		String deskNo,
		com.liferay.portal.kernel.util.OrderByComparator<WorkStation>
			orderByComparator);

	/**
	 * Returns the work stations before and after the current work station in the ordered set where deskNo = &#63;.
	 *
	 * @param workStationId the primary key of the current work station
	 * @param deskNo the desk no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work station
	 * @throws NoSuchWorkStationException if a work station with the primary key could not be found
	 */
	public WorkStation[] findByDeskNo_PrevAndNext(
			long workStationId, String deskNo,
			com.liferay.portal.kernel.util.OrderByComparator<WorkStation>
				orderByComparator)
		throws NoSuchWorkStationException;

	/**
	 * Removes all the work stations where deskNo = &#63; from the database.
	 *
	 * @param deskNo the desk no
	 */
	public void removeByDeskNo(String deskNo);

	/**
	 * Returns the number of work stations where deskNo = &#63;.
	 *
	 * @param deskNo the desk no
	 * @return the number of matching work stations
	 */
	public int countByDeskNo(String deskNo);

	/**
	 * Caches the work station in the entity cache if it is enabled.
	 *
	 * @param workStation the work station
	 */
	public void cacheResult(WorkStation workStation);

	/**
	 * Caches the work stations in the entity cache if it is enabled.
	 *
	 * @param workStations the work stations
	 */
	public void cacheResult(java.util.List<WorkStation> workStations);

	/**
	 * Creates a new work station with the primary key. Does not add the work station to the database.
	 *
	 * @param workStationId the primary key for the new work station
	 * @return the new work station
	 */
	public WorkStation create(long workStationId);

	/**
	 * Removes the work station with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workStationId the primary key of the work station
	 * @return the work station that was removed
	 * @throws NoSuchWorkStationException if a work station with the primary key could not be found
	 */
	public WorkStation remove(long workStationId)
		throws NoSuchWorkStationException;

	public WorkStation updateImpl(WorkStation workStation);

	/**
	 * Returns the work station with the primary key or throws a <code>NoSuchWorkStationException</code> if it could not be found.
	 *
	 * @param workStationId the primary key of the work station
	 * @return the work station
	 * @throws NoSuchWorkStationException if a work station with the primary key could not be found
	 */
	public WorkStation findByPrimaryKey(long workStationId)
		throws NoSuchWorkStationException;

	/**
	 * Returns the work station with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workStationId the primary key of the work station
	 * @return the work station, or <code>null</code> if a work station with the primary key could not be found
	 */
	public WorkStation fetchByPrimaryKey(long workStationId);

	/**
	 * Returns all the work stations.
	 *
	 * @return the work stations
	 */
	public java.util.List<WorkStation> findAll();

	/**
	 * Returns a range of all the work stations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkStationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work stations
	 * @param end the upper bound of the range of work stations (not inclusive)
	 * @return the range of work stations
	 */
	public java.util.List<WorkStation> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the work stations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkStationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work stations
	 * @param end the upper bound of the range of work stations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of work stations
	 */
	public java.util.List<WorkStation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkStation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work stations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkStationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work stations
	 * @param end the upper bound of the range of work stations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of work stations
	 */
	public java.util.List<WorkStation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkStation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the work stations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of work stations.
	 *
	 * @return the number of work stations
	 */
	public int countAll();

}