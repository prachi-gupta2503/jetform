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

import com.adjecti.mdm.liferay.exception.NoSuchOrganizationStationException;
import com.adjecti.mdm.liferay.model.OrganizationStation;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the organization station service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationStationUtil
 * @generated
 */
@ProviderType
public interface OrganizationStationPersistence
	extends BasePersistence<OrganizationStation> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OrganizationStationUtil} to access the organization station persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the organization stations where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching organization stations
	 */
	public java.util.List<OrganizationStation> findByName(String name);

	/**
	 * Returns a range of all the organization stations where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationStationModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of organization stations
	 * @param end the upper bound of the range of organization stations (not inclusive)
	 * @return the range of matching organization stations
	 */
	public java.util.List<OrganizationStation> findByName(
		String name, int start, int end);

	/**
	 * Returns an ordered range of all the organization stations where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationStationModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of organization stations
	 * @param end the upper bound of the range of organization stations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization stations
	 */
	public java.util.List<OrganizationStation> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationStation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the organization stations where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationStationModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of organization stations
	 * @param end the upper bound of the range of organization stations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization stations
	 */
	public java.util.List<OrganizationStation> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationStation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first organization station in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization station
	 * @throws NoSuchOrganizationStationException if a matching organization station could not be found
	 */
	public OrganizationStation findByName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator
				<OrganizationStation> orderByComparator)
		throws NoSuchOrganizationStationException;

	/**
	 * Returns the first organization station in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization station, or <code>null</code> if a matching organization station could not be found
	 */
	public OrganizationStation fetchByName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationStation>
			orderByComparator);

	/**
	 * Returns the last organization station in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization station
	 * @throws NoSuchOrganizationStationException if a matching organization station could not be found
	 */
	public OrganizationStation findByName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator
				<OrganizationStation> orderByComparator)
		throws NoSuchOrganizationStationException;

	/**
	 * Returns the last organization station in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization station, or <code>null</code> if a matching organization station could not be found
	 */
	public OrganizationStation fetchByName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationStation>
			orderByComparator);

	/**
	 * Returns the organization stations before and after the current organization station in the ordered set where name = &#63;.
	 *
	 * @param organizationStationId the primary key of the current organization station
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization station
	 * @throws NoSuchOrganizationStationException if a organization station with the primary key could not be found
	 */
	public OrganizationStation[] findByName_PrevAndNext(
			long organizationStationId, String name,
			com.liferay.portal.kernel.util.OrderByComparator
				<OrganizationStation> orderByComparator)
		throws NoSuchOrganizationStationException;

	/**
	 * Removes all the organization stations where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByName(String name);

	/**
	 * Returns the number of organization stations where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching organization stations
	 */
	public int countByName(String name);

	/**
	 * Caches the organization station in the entity cache if it is enabled.
	 *
	 * @param organizationStation the organization station
	 */
	public void cacheResult(OrganizationStation organizationStation);

	/**
	 * Caches the organization stations in the entity cache if it is enabled.
	 *
	 * @param organizationStations the organization stations
	 */
	public void cacheResult(
		java.util.List<OrganizationStation> organizationStations);

	/**
	 * Creates a new organization station with the primary key. Does not add the organization station to the database.
	 *
	 * @param organizationStationId the primary key for the new organization station
	 * @return the new organization station
	 */
	public OrganizationStation create(long organizationStationId);

	/**
	 * Removes the organization station with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param organizationStationId the primary key of the organization station
	 * @return the organization station that was removed
	 * @throws NoSuchOrganizationStationException if a organization station with the primary key could not be found
	 */
	public OrganizationStation remove(long organizationStationId)
		throws NoSuchOrganizationStationException;

	public OrganizationStation updateImpl(
		OrganizationStation organizationStation);

	/**
	 * Returns the organization station with the primary key or throws a <code>NoSuchOrganizationStationException</code> if it could not be found.
	 *
	 * @param organizationStationId the primary key of the organization station
	 * @return the organization station
	 * @throws NoSuchOrganizationStationException if a organization station with the primary key could not be found
	 */
	public OrganizationStation findByPrimaryKey(long organizationStationId)
		throws NoSuchOrganizationStationException;

	/**
	 * Returns the organization station with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param organizationStationId the primary key of the organization station
	 * @return the organization station, or <code>null</code> if a organization station with the primary key could not be found
	 */
	public OrganizationStation fetchByPrimaryKey(long organizationStationId);

	/**
	 * Returns all the organization stations.
	 *
	 * @return the organization stations
	 */
	public java.util.List<OrganizationStation> findAll();

	/**
	 * Returns a range of all the organization stations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationStationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization stations
	 * @param end the upper bound of the range of organization stations (not inclusive)
	 * @return the range of organization stations
	 */
	public java.util.List<OrganizationStation> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the organization stations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationStationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization stations
	 * @param end the upper bound of the range of organization stations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of organization stations
	 */
	public java.util.List<OrganizationStation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationStation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the organization stations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationStationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization stations
	 * @param end the upper bound of the range of organization stations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of organization stations
	 */
	public java.util.List<OrganizationStation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationStation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the organization stations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of organization stations.
	 *
	 * @return the number of organization stations
	 */
	public int countAll();

}