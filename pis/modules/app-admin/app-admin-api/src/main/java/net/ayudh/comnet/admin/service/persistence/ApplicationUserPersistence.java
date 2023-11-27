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

package net.ayudh.comnet.admin.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import net.ayudh.comnet.admin.exception.NoSuchApplicationUserException;
import net.ayudh.comnet.admin.model.ApplicationUser;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the application user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ApplicationUserUtil
 * @generated
 */
@ProviderType
public interface ApplicationUserPersistence
	extends BasePersistence<ApplicationUser> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ApplicationUserUtil} to access the application user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the application user where employeeId = &#63; or throws a <code>NoSuchApplicationUserException</code> if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @return the matching application user
	 * @throws NoSuchApplicationUserException if a matching application user could not be found
	 */
	public ApplicationUser findByEmployeeId(long employeeId)
		throws NoSuchApplicationUserException;

	/**
	 * Returns the application user where employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @return the matching application user, or <code>null</code> if a matching application user could not be found
	 */
	public ApplicationUser fetchByEmployeeId(long employeeId);

	/**
	 * Returns the application user where employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching application user, or <code>null</code> if a matching application user could not be found
	 */
	public ApplicationUser fetchByEmployeeId(
		long employeeId, boolean useFinderCache);

	/**
	 * Removes the application user where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @return the application user that was removed
	 */
	public ApplicationUser removeByEmployeeId(long employeeId)
		throws NoSuchApplicationUserException;

	/**
	 * Returns the number of application users where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching application users
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Returns the application user where loginId = &#63; or throws a <code>NoSuchApplicationUserException</code> if it could not be found.
	 *
	 * @param loginId the login ID
	 * @return the matching application user
	 * @throws NoSuchApplicationUserException if a matching application user could not be found
	 */
	public ApplicationUser findByLoginId(String loginId)
		throws NoSuchApplicationUserException;

	/**
	 * Returns the application user where loginId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param loginId the login ID
	 * @return the matching application user, or <code>null</code> if a matching application user could not be found
	 */
	public ApplicationUser fetchByLoginId(String loginId);

	/**
	 * Returns the application user where loginId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param loginId the login ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching application user, or <code>null</code> if a matching application user could not be found
	 */
	public ApplicationUser fetchByLoginId(
		String loginId, boolean useFinderCache);

	/**
	 * Removes the application user where loginId = &#63; from the database.
	 *
	 * @param loginId the login ID
	 * @return the application user that was removed
	 */
	public ApplicationUser removeByLoginId(String loginId)
		throws NoSuchApplicationUserException;

	/**
	 * Returns the number of application users where loginId = &#63;.
	 *
	 * @param loginId the login ID
	 * @return the number of matching application users
	 */
	public int countByLoginId(String loginId);

	/**
	 * Caches the application user in the entity cache if it is enabled.
	 *
	 * @param applicationUser the application user
	 */
	public void cacheResult(ApplicationUser applicationUser);

	/**
	 * Caches the application users in the entity cache if it is enabled.
	 *
	 * @param applicationUsers the application users
	 */
	public void cacheResult(java.util.List<ApplicationUser> applicationUsers);

	/**
	 * Creates a new application user with the primary key. Does not add the application user to the database.
	 *
	 * @param applicationUserId the primary key for the new application user
	 * @return the new application user
	 */
	public ApplicationUser create(long applicationUserId);

	/**
	 * Removes the application user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param applicationUserId the primary key of the application user
	 * @return the application user that was removed
	 * @throws NoSuchApplicationUserException if a application user with the primary key could not be found
	 */
	public ApplicationUser remove(long applicationUserId)
		throws NoSuchApplicationUserException;

	public ApplicationUser updateImpl(ApplicationUser applicationUser);

	/**
	 * Returns the application user with the primary key or throws a <code>NoSuchApplicationUserException</code> if it could not be found.
	 *
	 * @param applicationUserId the primary key of the application user
	 * @return the application user
	 * @throws NoSuchApplicationUserException if a application user with the primary key could not be found
	 */
	public ApplicationUser findByPrimaryKey(long applicationUserId)
		throws NoSuchApplicationUserException;

	/**
	 * Returns the application user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param applicationUserId the primary key of the application user
	 * @return the application user, or <code>null</code> if a application user with the primary key could not be found
	 */
	public ApplicationUser fetchByPrimaryKey(long applicationUserId);

	/**
	 * Returns all the application users.
	 *
	 * @return the application users
	 */
	public java.util.List<ApplicationUser> findAll();

	/**
	 * Returns a range of all the application users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of application users
	 * @param end the upper bound of the range of application users (not inclusive)
	 * @return the range of application users
	 */
	public java.util.List<ApplicationUser> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the application users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of application users
	 * @param end the upper bound of the range of application users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of application users
	 */
	public java.util.List<ApplicationUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationUser>
			orderByComparator);

	/**
	 * Returns an ordered range of all the application users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of application users
	 * @param end the upper bound of the range of application users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of application users
	 */
	public java.util.List<ApplicationUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the application users from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of application users.
	 *
	 * @return the number of application users
	 */
	public int countAll();

}