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

import com.adjecti.pis.liferay.exception.NoSuchEmployeePostException;
import com.adjecti.pis.liferay.model.EmployeePost;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee post service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeePostUtil
 * @generated
 */
@ProviderType
public interface EmployeePostPersistence extends BasePersistence<EmployeePost> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeePostUtil} to access the employee post persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee posts where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee posts
	 */
	public java.util.List<EmployeePost> findByEmployeeId(long employeeId);

	/**
	 * Returns a range of all the employee posts where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePostModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee posts
	 * @param end the upper bound of the range of employee posts (not inclusive)
	 * @return the range of matching employee posts
	 */
	public java.util.List<EmployeePost> findByEmployeeId(
		long employeeId, int start, int end);

	/**
	 * Returns an ordered range of all the employee posts where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePostModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee posts
	 * @param end the upper bound of the range of employee posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee posts
	 */
	public java.util.List<EmployeePost> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePost>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee posts where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePostModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee posts
	 * @param end the upper bound of the range of employee posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee posts
	 */
	public java.util.List<EmployeePost> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePost>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee post in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee post
	 * @throws NoSuchEmployeePostException if a matching employee post could not be found
	 */
	public EmployeePost findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeePost>
				orderByComparator)
		throws NoSuchEmployeePostException;

	/**
	 * Returns the first employee post in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee post, or <code>null</code> if a matching employee post could not be found
	 */
	public EmployeePost fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePost>
			orderByComparator);

	/**
	 * Returns the last employee post in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee post
	 * @throws NoSuchEmployeePostException if a matching employee post could not be found
	 */
	public EmployeePost findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeePost>
				orderByComparator)
		throws NoSuchEmployeePostException;

	/**
	 * Returns the last employee post in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee post, or <code>null</code> if a matching employee post could not be found
	 */
	public EmployeePost fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePost>
			orderByComparator);

	/**
	 * Returns the employee posts before and after the current employee post in the ordered set where employeeId = &#63;.
	 *
	 * @param employeePostId the primary key of the current employee post
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee post
	 * @throws NoSuchEmployeePostException if a employee post with the primary key could not be found
	 */
	public EmployeePost[] findByEmployeeId_PrevAndNext(
			long employeePostId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeePost>
				orderByComparator)
		throws NoSuchEmployeePostException;

	/**
	 * Removes all the employee posts where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of employee posts where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee posts
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Caches the employee post in the entity cache if it is enabled.
	 *
	 * @param employeePost the employee post
	 */
	public void cacheResult(EmployeePost employeePost);

	/**
	 * Caches the employee posts in the entity cache if it is enabled.
	 *
	 * @param employeePosts the employee posts
	 */
	public void cacheResult(java.util.List<EmployeePost> employeePosts);

	/**
	 * Creates a new employee post with the primary key. Does not add the employee post to the database.
	 *
	 * @param employeePostId the primary key for the new employee post
	 * @return the new employee post
	 */
	public EmployeePost create(long employeePostId);

	/**
	 * Removes the employee post with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeePostId the primary key of the employee post
	 * @return the employee post that was removed
	 * @throws NoSuchEmployeePostException if a employee post with the primary key could not be found
	 */
	public EmployeePost remove(long employeePostId)
		throws NoSuchEmployeePostException;

	public EmployeePost updateImpl(EmployeePost employeePost);

	/**
	 * Returns the employee post with the primary key or throws a <code>NoSuchEmployeePostException</code> if it could not be found.
	 *
	 * @param employeePostId the primary key of the employee post
	 * @return the employee post
	 * @throws NoSuchEmployeePostException if a employee post with the primary key could not be found
	 */
	public EmployeePost findByPrimaryKey(long employeePostId)
		throws NoSuchEmployeePostException;

	/**
	 * Returns the employee post with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeePostId the primary key of the employee post
	 * @return the employee post, or <code>null</code> if a employee post with the primary key could not be found
	 */
	public EmployeePost fetchByPrimaryKey(long employeePostId);

	/**
	 * Returns all the employee posts.
	 *
	 * @return the employee posts
	 */
	public java.util.List<EmployeePost> findAll();

	/**
	 * Returns a range of all the employee posts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePostModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee posts
	 * @param end the upper bound of the range of employee posts (not inclusive)
	 * @return the range of employee posts
	 */
	public java.util.List<EmployeePost> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee posts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePostModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee posts
	 * @param end the upper bound of the range of employee posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee posts
	 */
	public java.util.List<EmployeePost> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePost>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee posts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePostModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee posts
	 * @param end the upper bound of the range of employee posts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee posts
	 */
	public java.util.List<EmployeePost> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeePost>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee posts from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee posts.
	 *
	 * @return the number of employee posts
	 */
	public int countAll();

}