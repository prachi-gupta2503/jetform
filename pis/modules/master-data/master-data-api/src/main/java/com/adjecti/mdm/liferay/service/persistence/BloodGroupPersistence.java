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

import com.adjecti.mdm.liferay.exception.NoSuchBloodGroupException;
import com.adjecti.mdm.liferay.model.BloodGroup;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the blood group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BloodGroupUtil
 * @generated
 */
@ProviderType
public interface BloodGroupPersistence extends BasePersistence<BloodGroup> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BloodGroupUtil} to access the blood group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the blood group in the entity cache if it is enabled.
	 *
	 * @param bloodGroup the blood group
	 */
	public void cacheResult(BloodGroup bloodGroup);

	/**
	 * Caches the blood groups in the entity cache if it is enabled.
	 *
	 * @param bloodGroups the blood groups
	 */
	public void cacheResult(java.util.List<BloodGroup> bloodGroups);

	/**
	 * Creates a new blood group with the primary key. Does not add the blood group to the database.
	 *
	 * @param bloodGroupId the primary key for the new blood group
	 * @return the new blood group
	 */
	public BloodGroup create(long bloodGroupId);

	/**
	 * Removes the blood group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bloodGroupId the primary key of the blood group
	 * @return the blood group that was removed
	 * @throws NoSuchBloodGroupException if a blood group with the primary key could not be found
	 */
	public BloodGroup remove(long bloodGroupId)
		throws NoSuchBloodGroupException;

	public BloodGroup updateImpl(BloodGroup bloodGroup);

	/**
	 * Returns the blood group with the primary key or throws a <code>NoSuchBloodGroupException</code> if it could not be found.
	 *
	 * @param bloodGroupId the primary key of the blood group
	 * @return the blood group
	 * @throws NoSuchBloodGroupException if a blood group with the primary key could not be found
	 */
	public BloodGroup findByPrimaryKey(long bloodGroupId)
		throws NoSuchBloodGroupException;

	/**
	 * Returns the blood group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bloodGroupId the primary key of the blood group
	 * @return the blood group, or <code>null</code> if a blood group with the primary key could not be found
	 */
	public BloodGroup fetchByPrimaryKey(long bloodGroupId);

	/**
	 * Returns all the blood groups.
	 *
	 * @return the blood groups
	 */
	public java.util.List<BloodGroup> findAll();

	/**
	 * Returns a range of all the blood groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BloodGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of blood groups
	 * @param end the upper bound of the range of blood groups (not inclusive)
	 * @return the range of blood groups
	 */
	public java.util.List<BloodGroup> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the blood groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BloodGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of blood groups
	 * @param end the upper bound of the range of blood groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of blood groups
	 */
	public java.util.List<BloodGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BloodGroup>
			orderByComparator);

	/**
	 * Returns an ordered range of all the blood groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BloodGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of blood groups
	 * @param end the upper bound of the range of blood groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of blood groups
	 */
	public java.util.List<BloodGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BloodGroup>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the blood groups from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of blood groups.
	 *
	 * @return the number of blood groups
	 */
	public int countAll();

}