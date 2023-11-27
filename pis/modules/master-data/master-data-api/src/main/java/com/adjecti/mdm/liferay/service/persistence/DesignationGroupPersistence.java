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

import com.adjecti.mdm.liferay.exception.NoSuchDesignationGroupException;
import com.adjecti.mdm.liferay.model.DesignationGroup;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the designation group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DesignationGroupUtil
 * @generated
 */
@ProviderType
public interface DesignationGroupPersistence
	extends BasePersistence<DesignationGroup> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DesignationGroupUtil} to access the designation group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the designation group where code = &#63; or throws a <code>NoSuchDesignationGroupException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching designation group
	 * @throws NoSuchDesignationGroupException if a matching designation group could not be found
	 */
	public DesignationGroup findByCode(String code)
		throws NoSuchDesignationGroupException;

	/**
	 * Returns the designation group where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching designation group, or <code>null</code> if a matching designation group could not be found
	 */
	public DesignationGroup fetchByCode(String code);

	/**
	 * Returns the designation group where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching designation group, or <code>null</code> if a matching designation group could not be found
	 */
	public DesignationGroup fetchByCode(String code, boolean useFinderCache);

	/**
	 * Removes the designation group where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the designation group that was removed
	 */
	public DesignationGroup removeByCode(String code)
		throws NoSuchDesignationGroupException;

	/**
	 * Returns the number of designation groups where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching designation groups
	 */
	public int countByCode(String code);

	/**
	 * Caches the designation group in the entity cache if it is enabled.
	 *
	 * @param designationGroup the designation group
	 */
	public void cacheResult(DesignationGroup designationGroup);

	/**
	 * Caches the designation groups in the entity cache if it is enabled.
	 *
	 * @param designationGroups the designation groups
	 */
	public void cacheResult(java.util.List<DesignationGroup> designationGroups);

	/**
	 * Creates a new designation group with the primary key. Does not add the designation group to the database.
	 *
	 * @param designationGroupId the primary key for the new designation group
	 * @return the new designation group
	 */
	public DesignationGroup create(long designationGroupId);

	/**
	 * Removes the designation group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param designationGroupId the primary key of the designation group
	 * @return the designation group that was removed
	 * @throws NoSuchDesignationGroupException if a designation group with the primary key could not be found
	 */
	public DesignationGroup remove(long designationGroupId)
		throws NoSuchDesignationGroupException;

	public DesignationGroup updateImpl(DesignationGroup designationGroup);

	/**
	 * Returns the designation group with the primary key or throws a <code>NoSuchDesignationGroupException</code> if it could not be found.
	 *
	 * @param designationGroupId the primary key of the designation group
	 * @return the designation group
	 * @throws NoSuchDesignationGroupException if a designation group with the primary key could not be found
	 */
	public DesignationGroup findByPrimaryKey(long designationGroupId)
		throws NoSuchDesignationGroupException;

	/**
	 * Returns the designation group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param designationGroupId the primary key of the designation group
	 * @return the designation group, or <code>null</code> if a designation group with the primary key could not be found
	 */
	public DesignationGroup fetchByPrimaryKey(long designationGroupId);

	/**
	 * Returns all the designation groups.
	 *
	 * @return the designation groups
	 */
	public java.util.List<DesignationGroup> findAll();

	/**
	 * Returns a range of all the designation groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation groups
	 * @param end the upper bound of the range of designation groups (not inclusive)
	 * @return the range of designation groups
	 */
	public java.util.List<DesignationGroup> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the designation groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation groups
	 * @param end the upper bound of the range of designation groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of designation groups
	 */
	public java.util.List<DesignationGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DesignationGroup>
			orderByComparator);

	/**
	 * Returns an ordered range of all the designation groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation groups
	 * @param end the upper bound of the range of designation groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of designation groups
	 */
	public java.util.List<DesignationGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DesignationGroup>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the designation groups from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of designation groups.
	 *
	 * @return the number of designation groups
	 */
	public int countAll();

}