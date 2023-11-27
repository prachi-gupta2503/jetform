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

import com.adjecti.mdm.liferay.exception.NoSuchMaritalStatusException;
import com.adjecti.mdm.liferay.model.MaritalStatus;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the marital status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MaritalStatusUtil
 * @generated
 */
@ProviderType
public interface MaritalStatusPersistence
	extends BasePersistence<MaritalStatus> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MaritalStatusUtil} to access the marital status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the marital status in the entity cache if it is enabled.
	 *
	 * @param maritalStatus the marital status
	 */
	public void cacheResult(MaritalStatus maritalStatus);

	/**
	 * Caches the marital statuses in the entity cache if it is enabled.
	 *
	 * @param maritalStatuses the marital statuses
	 */
	public void cacheResult(java.util.List<MaritalStatus> maritalStatuses);

	/**
	 * Creates a new marital status with the primary key. Does not add the marital status to the database.
	 *
	 * @param maritalStatusId the primary key for the new marital status
	 * @return the new marital status
	 */
	public MaritalStatus create(long maritalStatusId);

	/**
	 * Removes the marital status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param maritalStatusId the primary key of the marital status
	 * @return the marital status that was removed
	 * @throws NoSuchMaritalStatusException if a marital status with the primary key could not be found
	 */
	public MaritalStatus remove(long maritalStatusId)
		throws NoSuchMaritalStatusException;

	public MaritalStatus updateImpl(MaritalStatus maritalStatus);

	/**
	 * Returns the marital status with the primary key or throws a <code>NoSuchMaritalStatusException</code> if it could not be found.
	 *
	 * @param maritalStatusId the primary key of the marital status
	 * @return the marital status
	 * @throws NoSuchMaritalStatusException if a marital status with the primary key could not be found
	 */
	public MaritalStatus findByPrimaryKey(long maritalStatusId)
		throws NoSuchMaritalStatusException;

	/**
	 * Returns the marital status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param maritalStatusId the primary key of the marital status
	 * @return the marital status, or <code>null</code> if a marital status with the primary key could not be found
	 */
	public MaritalStatus fetchByPrimaryKey(long maritalStatusId);

	/**
	 * Returns all the marital statuses.
	 *
	 * @return the marital statuses
	 */
	public java.util.List<MaritalStatus> findAll();

	/**
	 * Returns a range of all the marital statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MaritalStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of marital statuses
	 * @param end the upper bound of the range of marital statuses (not inclusive)
	 * @return the range of marital statuses
	 */
	public java.util.List<MaritalStatus> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the marital statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MaritalStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of marital statuses
	 * @param end the upper bound of the range of marital statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of marital statuses
	 */
	public java.util.List<MaritalStatus> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MaritalStatus>
			orderByComparator);

	/**
	 * Returns an ordered range of all the marital statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MaritalStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of marital statuses
	 * @param end the upper bound of the range of marital statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of marital statuses
	 */
	public java.util.List<MaritalStatus> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MaritalStatus>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the marital statuses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of marital statuses.
	 *
	 * @return the number of marital statuses
	 */
	public int countAll();

}