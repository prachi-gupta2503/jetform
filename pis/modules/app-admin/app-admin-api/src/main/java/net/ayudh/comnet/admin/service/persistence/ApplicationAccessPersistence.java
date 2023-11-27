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

import net.ayudh.comnet.admin.exception.NoSuchApplicationAccessException;
import net.ayudh.comnet.admin.model.ApplicationAccess;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the application access service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ApplicationAccessUtil
 * @generated
 */
@ProviderType
public interface ApplicationAccessPersistence
	extends BasePersistence<ApplicationAccess> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ApplicationAccessUtil} to access the application access persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the application accesses where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching application accesses
	 */
	public java.util.List<ApplicationAccess> findByEmployeeId(long employeeId);

	/**
	 * Returns a range of all the application accesses where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationAccessModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of application accesses
	 * @param end the upper bound of the range of application accesses (not inclusive)
	 * @return the range of matching application accesses
	 */
	public java.util.List<ApplicationAccess> findByEmployeeId(
		long employeeId, int start, int end);

	/**
	 * Returns an ordered range of all the application accesses where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationAccessModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of application accesses
	 * @param end the upper bound of the range of application accesses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching application accesses
	 */
	public java.util.List<ApplicationAccess> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationAccess>
			orderByComparator);

	/**
	 * Returns an ordered range of all the application accesses where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationAccessModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of application accesses
	 * @param end the upper bound of the range of application accesses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching application accesses
	 */
	public java.util.List<ApplicationAccess> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationAccess>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first application access in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching application access
	 * @throws NoSuchApplicationAccessException if a matching application access could not be found
	 */
	public ApplicationAccess findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<ApplicationAccess>
				orderByComparator)
		throws NoSuchApplicationAccessException;

	/**
	 * Returns the first application access in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching application access, or <code>null</code> if a matching application access could not be found
	 */
	public ApplicationAccess fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationAccess>
			orderByComparator);

	/**
	 * Returns the last application access in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching application access
	 * @throws NoSuchApplicationAccessException if a matching application access could not be found
	 */
	public ApplicationAccess findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<ApplicationAccess>
				orderByComparator)
		throws NoSuchApplicationAccessException;

	/**
	 * Returns the last application access in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching application access, or <code>null</code> if a matching application access could not be found
	 */
	public ApplicationAccess fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationAccess>
			orderByComparator);

	/**
	 * Returns the application accesses before and after the current application access in the ordered set where employeeId = &#63;.
	 *
	 * @param applicationAccessId the primary key of the current application access
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next application access
	 * @throws NoSuchApplicationAccessException if a application access with the primary key could not be found
	 */
	public ApplicationAccess[] findByEmployeeId_PrevAndNext(
			long applicationAccessId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<ApplicationAccess>
				orderByComparator)
		throws NoSuchApplicationAccessException;

	/**
	 * Removes all the application accesses where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of application accesses where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching application accesses
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Returns all the application accesses where applicationId = &#63;.
	 *
	 * @param applicationId the application ID
	 * @return the matching application accesses
	 */
	public java.util.List<ApplicationAccess> findByApplicationId(
		long applicationId);

	/**
	 * Returns a range of all the application accesses where applicationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationAccessModelImpl</code>.
	 * </p>
	 *
	 * @param applicationId the application ID
	 * @param start the lower bound of the range of application accesses
	 * @param end the upper bound of the range of application accesses (not inclusive)
	 * @return the range of matching application accesses
	 */
	public java.util.List<ApplicationAccess> findByApplicationId(
		long applicationId, int start, int end);

	/**
	 * Returns an ordered range of all the application accesses where applicationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationAccessModelImpl</code>.
	 * </p>
	 *
	 * @param applicationId the application ID
	 * @param start the lower bound of the range of application accesses
	 * @param end the upper bound of the range of application accesses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching application accesses
	 */
	public java.util.List<ApplicationAccess> findByApplicationId(
		long applicationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationAccess>
			orderByComparator);

	/**
	 * Returns an ordered range of all the application accesses where applicationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationAccessModelImpl</code>.
	 * </p>
	 *
	 * @param applicationId the application ID
	 * @param start the lower bound of the range of application accesses
	 * @param end the upper bound of the range of application accesses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching application accesses
	 */
	public java.util.List<ApplicationAccess> findByApplicationId(
		long applicationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationAccess>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first application access in the ordered set where applicationId = &#63;.
	 *
	 * @param applicationId the application ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching application access
	 * @throws NoSuchApplicationAccessException if a matching application access could not be found
	 */
	public ApplicationAccess findByApplicationId_First(
			long applicationId,
			com.liferay.portal.kernel.util.OrderByComparator<ApplicationAccess>
				orderByComparator)
		throws NoSuchApplicationAccessException;

	/**
	 * Returns the first application access in the ordered set where applicationId = &#63;.
	 *
	 * @param applicationId the application ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching application access, or <code>null</code> if a matching application access could not be found
	 */
	public ApplicationAccess fetchByApplicationId_First(
		long applicationId,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationAccess>
			orderByComparator);

	/**
	 * Returns the last application access in the ordered set where applicationId = &#63;.
	 *
	 * @param applicationId the application ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching application access
	 * @throws NoSuchApplicationAccessException if a matching application access could not be found
	 */
	public ApplicationAccess findByApplicationId_Last(
			long applicationId,
			com.liferay.portal.kernel.util.OrderByComparator<ApplicationAccess>
				orderByComparator)
		throws NoSuchApplicationAccessException;

	/**
	 * Returns the last application access in the ordered set where applicationId = &#63;.
	 *
	 * @param applicationId the application ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching application access, or <code>null</code> if a matching application access could not be found
	 */
	public ApplicationAccess fetchByApplicationId_Last(
		long applicationId,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationAccess>
			orderByComparator);

	/**
	 * Returns the application accesses before and after the current application access in the ordered set where applicationId = &#63;.
	 *
	 * @param applicationAccessId the primary key of the current application access
	 * @param applicationId the application ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next application access
	 * @throws NoSuchApplicationAccessException if a application access with the primary key could not be found
	 */
	public ApplicationAccess[] findByApplicationId_PrevAndNext(
			long applicationAccessId, long applicationId,
			com.liferay.portal.kernel.util.OrderByComparator<ApplicationAccess>
				orderByComparator)
		throws NoSuchApplicationAccessException;

	/**
	 * Removes all the application accesses where applicationId = &#63; from the database.
	 *
	 * @param applicationId the application ID
	 */
	public void removeByApplicationId(long applicationId);

	/**
	 * Returns the number of application accesses where applicationId = &#63;.
	 *
	 * @param applicationId the application ID
	 * @return the number of matching application accesses
	 */
	public int countByApplicationId(long applicationId);

	/**
	 * Caches the application access in the entity cache if it is enabled.
	 *
	 * @param applicationAccess the application access
	 */
	public void cacheResult(ApplicationAccess applicationAccess);

	/**
	 * Caches the application accesses in the entity cache if it is enabled.
	 *
	 * @param applicationAccesses the application accesses
	 */
	public void cacheResult(
		java.util.List<ApplicationAccess> applicationAccesses);

	/**
	 * Creates a new application access with the primary key. Does not add the application access to the database.
	 *
	 * @param applicationAccessId the primary key for the new application access
	 * @return the new application access
	 */
	public ApplicationAccess create(long applicationAccessId);

	/**
	 * Removes the application access with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param applicationAccessId the primary key of the application access
	 * @return the application access that was removed
	 * @throws NoSuchApplicationAccessException if a application access with the primary key could not be found
	 */
	public ApplicationAccess remove(long applicationAccessId)
		throws NoSuchApplicationAccessException;

	public ApplicationAccess updateImpl(ApplicationAccess applicationAccess);

	/**
	 * Returns the application access with the primary key or throws a <code>NoSuchApplicationAccessException</code> if it could not be found.
	 *
	 * @param applicationAccessId the primary key of the application access
	 * @return the application access
	 * @throws NoSuchApplicationAccessException if a application access with the primary key could not be found
	 */
	public ApplicationAccess findByPrimaryKey(long applicationAccessId)
		throws NoSuchApplicationAccessException;

	/**
	 * Returns the application access with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param applicationAccessId the primary key of the application access
	 * @return the application access, or <code>null</code> if a application access with the primary key could not be found
	 */
	public ApplicationAccess fetchByPrimaryKey(long applicationAccessId);

	/**
	 * Returns all the application accesses.
	 *
	 * @return the application accesses
	 */
	public java.util.List<ApplicationAccess> findAll();

	/**
	 * Returns a range of all the application accesses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationAccessModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of application accesses
	 * @param end the upper bound of the range of application accesses (not inclusive)
	 * @return the range of application accesses
	 */
	public java.util.List<ApplicationAccess> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the application accesses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationAccessModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of application accesses
	 * @param end the upper bound of the range of application accesses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of application accesses
	 */
	public java.util.List<ApplicationAccess> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationAccess>
			orderByComparator);

	/**
	 * Returns an ordered range of all the application accesses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApplicationAccessModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of application accesses
	 * @param end the upper bound of the range of application accesses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of application accesses
	 */
	public java.util.List<ApplicationAccess> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationAccess>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the application accesses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of application accesses.
	 *
	 * @return the number of application accesses
	 */
	public int countAll();

}