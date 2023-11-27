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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeProfileException;
import com.adjecti.pis.liferay.model.EmployeeProfile;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee profile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeProfileUtil
 * @generated
 */
@ProviderType
public interface EmployeeProfilePersistence
	extends BasePersistence<EmployeeProfile> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeProfileUtil} to access the employee profile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the employee profile in the entity cache if it is enabled.
	 *
	 * @param employeeProfile the employee profile
	 */
	public void cacheResult(EmployeeProfile employeeProfile);

	/**
	 * Caches the employee profiles in the entity cache if it is enabled.
	 *
	 * @param employeeProfiles the employee profiles
	 */
	public void cacheResult(java.util.List<EmployeeProfile> employeeProfiles);

	/**
	 * Creates a new employee profile with the primary key. Does not add the employee profile to the database.
	 *
	 * @param employeeProfileId the primary key for the new employee profile
	 * @return the new employee profile
	 */
	public EmployeeProfile create(long employeeProfileId);

	/**
	 * Removes the employee profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeProfileId the primary key of the employee profile
	 * @return the employee profile that was removed
	 * @throws NoSuchEmployeeProfileException if a employee profile with the primary key could not be found
	 */
	public EmployeeProfile remove(long employeeProfileId)
		throws NoSuchEmployeeProfileException;

	public EmployeeProfile updateImpl(EmployeeProfile employeeProfile);

	/**
	 * Returns the employee profile with the primary key or throws a <code>NoSuchEmployeeProfileException</code> if it could not be found.
	 *
	 * @param employeeProfileId the primary key of the employee profile
	 * @return the employee profile
	 * @throws NoSuchEmployeeProfileException if a employee profile with the primary key could not be found
	 */
	public EmployeeProfile findByPrimaryKey(long employeeProfileId)
		throws NoSuchEmployeeProfileException;

	/**
	 * Returns the employee profile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeProfileId the primary key of the employee profile
	 * @return the employee profile, or <code>null</code> if a employee profile with the primary key could not be found
	 */
	public EmployeeProfile fetchByPrimaryKey(long employeeProfileId);

	/**
	 * Returns all the employee profiles.
	 *
	 * @return the employee profiles
	 */
	public java.util.List<EmployeeProfile> findAll();

	/**
	 * Returns a range of all the employee profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeProfileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee profiles
	 * @param end the upper bound of the range of employee profiles (not inclusive)
	 * @return the range of employee profiles
	 */
	public java.util.List<EmployeeProfile> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeProfileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee profiles
	 * @param end the upper bound of the range of employee profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee profiles
	 */
	public java.util.List<EmployeeProfile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeProfile>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeProfileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee profiles
	 * @param end the upper bound of the range of employee profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee profiles
	 */
	public java.util.List<EmployeeProfile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeProfile>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee profiles from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee profiles.
	 *
	 * @return the number of employee profiles
	 */
	public int countAll();

}