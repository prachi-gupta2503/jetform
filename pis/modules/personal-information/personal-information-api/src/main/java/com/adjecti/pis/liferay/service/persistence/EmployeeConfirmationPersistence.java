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

import com.adjecti.pis.liferay.exception.NoSuchEmployeeConfirmationException;
import com.adjecti.pis.liferay.model.EmployeeConfirmation;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee confirmation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeConfirmationUtil
 * @generated
 */
@ProviderType
public interface EmployeeConfirmationPersistence
	extends BasePersistence<EmployeeConfirmation> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeConfirmationUtil} to access the employee confirmation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee confirmations where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @return the matching employee confirmations
	 */
	public java.util.List<EmployeeConfirmation> findByGradeModeId(
		long gradeModeId);

	/**
	 * Returns a range of all the employee confirmations where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeConfirmationModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee confirmations
	 * @param end the upper bound of the range of employee confirmations (not inclusive)
	 * @return the range of matching employee confirmations
	 */
	public java.util.List<EmployeeConfirmation> findByGradeModeId(
		long gradeModeId, int start, int end);

	/**
	 * Returns an ordered range of all the employee confirmations where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeConfirmationModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee confirmations
	 * @param end the upper bound of the range of employee confirmations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee confirmations
	 */
	public java.util.List<EmployeeConfirmation> findByGradeModeId(
		long gradeModeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeConfirmation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee confirmations where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeConfirmationModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee confirmations
	 * @param end the upper bound of the range of employee confirmations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee confirmations
	 */
	public java.util.List<EmployeeConfirmation> findByGradeModeId(
		long gradeModeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeConfirmation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee confirmation in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee confirmation
	 * @throws NoSuchEmployeeConfirmationException if a matching employee confirmation could not be found
	 */
	public EmployeeConfirmation findByGradeModeId_First(
			long gradeModeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeConfirmation> orderByComparator)
		throws NoSuchEmployeeConfirmationException;

	/**
	 * Returns the first employee confirmation in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee confirmation, or <code>null</code> if a matching employee confirmation could not be found
	 */
	public EmployeeConfirmation fetchByGradeModeId_First(
		long gradeModeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeConfirmation>
			orderByComparator);

	/**
	 * Returns the last employee confirmation in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee confirmation
	 * @throws NoSuchEmployeeConfirmationException if a matching employee confirmation could not be found
	 */
	public EmployeeConfirmation findByGradeModeId_Last(
			long gradeModeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeConfirmation> orderByComparator)
		throws NoSuchEmployeeConfirmationException;

	/**
	 * Returns the last employee confirmation in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee confirmation, or <code>null</code> if a matching employee confirmation could not be found
	 */
	public EmployeeConfirmation fetchByGradeModeId_Last(
		long gradeModeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeConfirmation>
			orderByComparator);

	/**
	 * Returns the employee confirmations before and after the current employee confirmation in the ordered set where gradeModeId = &#63;.
	 *
	 * @param employeeConfirmationId the primary key of the current employee confirmation
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee confirmation
	 * @throws NoSuchEmployeeConfirmationException if a employee confirmation with the primary key could not be found
	 */
	public EmployeeConfirmation[] findByGradeModeId_PrevAndNext(
			long employeeConfirmationId, long gradeModeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeConfirmation> orderByComparator)
		throws NoSuchEmployeeConfirmationException;

	/**
	 * Removes all the employee confirmations where gradeModeId = &#63; from the database.
	 *
	 * @param gradeModeId the grade mode ID
	 */
	public void removeByGradeModeId(long gradeModeId);

	/**
	 * Returns the number of employee confirmations where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @return the number of matching employee confirmations
	 */
	public int countByGradeModeId(long gradeModeId);

	/**
	 * Returns all the employee confirmations where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee confirmations
	 */
	public java.util.List<EmployeeConfirmation> findByEmployeeId(
		long employeeId);

	/**
	 * Returns a range of all the employee confirmations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeConfirmationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee confirmations
	 * @param end the upper bound of the range of employee confirmations (not inclusive)
	 * @return the range of matching employee confirmations
	 */
	public java.util.List<EmployeeConfirmation> findByEmployeeId(
		long employeeId, int start, int end);

	/**
	 * Returns an ordered range of all the employee confirmations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeConfirmationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee confirmations
	 * @param end the upper bound of the range of employee confirmations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee confirmations
	 */
	public java.util.List<EmployeeConfirmation> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeConfirmation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee confirmations where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeConfirmationModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee confirmations
	 * @param end the upper bound of the range of employee confirmations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee confirmations
	 */
	public java.util.List<EmployeeConfirmation> findByEmployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeConfirmation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee confirmation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee confirmation
	 * @throws NoSuchEmployeeConfirmationException if a matching employee confirmation could not be found
	 */
	public EmployeeConfirmation findByEmployeeId_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeConfirmation> orderByComparator)
		throws NoSuchEmployeeConfirmationException;

	/**
	 * Returns the first employee confirmation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee confirmation, or <code>null</code> if a matching employee confirmation could not be found
	 */
	public EmployeeConfirmation fetchByEmployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeConfirmation>
			orderByComparator);

	/**
	 * Returns the last employee confirmation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee confirmation
	 * @throws NoSuchEmployeeConfirmationException if a matching employee confirmation could not be found
	 */
	public EmployeeConfirmation findByEmployeeId_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeConfirmation> orderByComparator)
		throws NoSuchEmployeeConfirmationException;

	/**
	 * Returns the last employee confirmation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee confirmation, or <code>null</code> if a matching employee confirmation could not be found
	 */
	public EmployeeConfirmation fetchByEmployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeConfirmation>
			orderByComparator);

	/**
	 * Returns the employee confirmations before and after the current employee confirmation in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeConfirmationId the primary key of the current employee confirmation
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee confirmation
	 * @throws NoSuchEmployeeConfirmationException if a employee confirmation with the primary key could not be found
	 */
	public EmployeeConfirmation[] findByEmployeeId_PrevAndNext(
			long employeeConfirmationId, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeConfirmation> orderByComparator)
		throws NoSuchEmployeeConfirmationException;

	/**
	 * Removes all the employee confirmations where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByEmployeeId(long employeeId);

	/**
	 * Returns the number of employee confirmations where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee confirmations
	 */
	public int countByEmployeeId(long employeeId);

	/**
	 * Returns all the employee confirmations where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching employee confirmations
	 */
	public java.util.List<EmployeeConfirmation> findByOrganizationId(
		long organizationId);

	/**
	 * Returns a range of all the employee confirmations where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeConfirmationModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee confirmations
	 * @param end the upper bound of the range of employee confirmations (not inclusive)
	 * @return the range of matching employee confirmations
	 */
	public java.util.List<EmployeeConfirmation> findByOrganizationId(
		long organizationId, int start, int end);

	/**
	 * Returns an ordered range of all the employee confirmations where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeConfirmationModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee confirmations
	 * @param end the upper bound of the range of employee confirmations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee confirmations
	 */
	public java.util.List<EmployeeConfirmation> findByOrganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeConfirmation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee confirmations where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeConfirmationModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee confirmations
	 * @param end the upper bound of the range of employee confirmations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee confirmations
	 */
	public java.util.List<EmployeeConfirmation> findByOrganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeConfirmation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee confirmation in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee confirmation
	 * @throws NoSuchEmployeeConfirmationException if a matching employee confirmation could not be found
	 */
	public EmployeeConfirmation findByOrganizationId_First(
			long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeConfirmation> orderByComparator)
		throws NoSuchEmployeeConfirmationException;

	/**
	 * Returns the first employee confirmation in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee confirmation, or <code>null</code> if a matching employee confirmation could not be found
	 */
	public EmployeeConfirmation fetchByOrganizationId_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeConfirmation>
			orderByComparator);

	/**
	 * Returns the last employee confirmation in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee confirmation
	 * @throws NoSuchEmployeeConfirmationException if a matching employee confirmation could not be found
	 */
	public EmployeeConfirmation findByOrganizationId_Last(
			long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeConfirmation> orderByComparator)
		throws NoSuchEmployeeConfirmationException;

	/**
	 * Returns the last employee confirmation in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee confirmation, or <code>null</code> if a matching employee confirmation could not be found
	 */
	public EmployeeConfirmation fetchByOrganizationId_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeConfirmation>
			orderByComparator);

	/**
	 * Returns the employee confirmations before and after the current employee confirmation in the ordered set where organizationId = &#63;.
	 *
	 * @param employeeConfirmationId the primary key of the current employee confirmation
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee confirmation
	 * @throws NoSuchEmployeeConfirmationException if a employee confirmation with the primary key could not be found
	 */
	public EmployeeConfirmation[] findByOrganizationId_PrevAndNext(
			long employeeConfirmationId, long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmployeeConfirmation> orderByComparator)
		throws NoSuchEmployeeConfirmationException;

	/**
	 * Removes all the employee confirmations where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	public void removeByOrganizationId(long organizationId);

	/**
	 * Returns the number of employee confirmations where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching employee confirmations
	 */
	public int countByOrganizationId(long organizationId);

	/**
	 * Caches the employee confirmation in the entity cache if it is enabled.
	 *
	 * @param employeeConfirmation the employee confirmation
	 */
	public void cacheResult(EmployeeConfirmation employeeConfirmation);

	/**
	 * Caches the employee confirmations in the entity cache if it is enabled.
	 *
	 * @param employeeConfirmations the employee confirmations
	 */
	public void cacheResult(
		java.util.List<EmployeeConfirmation> employeeConfirmations);

	/**
	 * Creates a new employee confirmation with the primary key. Does not add the employee confirmation to the database.
	 *
	 * @param employeeConfirmationId the primary key for the new employee confirmation
	 * @return the new employee confirmation
	 */
	public EmployeeConfirmation create(long employeeConfirmationId);

	/**
	 * Removes the employee confirmation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeConfirmationId the primary key of the employee confirmation
	 * @return the employee confirmation that was removed
	 * @throws NoSuchEmployeeConfirmationException if a employee confirmation with the primary key could not be found
	 */
	public EmployeeConfirmation remove(long employeeConfirmationId)
		throws NoSuchEmployeeConfirmationException;

	public EmployeeConfirmation updateImpl(
		EmployeeConfirmation employeeConfirmation);

	/**
	 * Returns the employee confirmation with the primary key or throws a <code>NoSuchEmployeeConfirmationException</code> if it could not be found.
	 *
	 * @param employeeConfirmationId the primary key of the employee confirmation
	 * @return the employee confirmation
	 * @throws NoSuchEmployeeConfirmationException if a employee confirmation with the primary key could not be found
	 */
	public EmployeeConfirmation findByPrimaryKey(long employeeConfirmationId)
		throws NoSuchEmployeeConfirmationException;

	/**
	 * Returns the employee confirmation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeConfirmationId the primary key of the employee confirmation
	 * @return the employee confirmation, or <code>null</code> if a employee confirmation with the primary key could not be found
	 */
	public EmployeeConfirmation fetchByPrimaryKey(long employeeConfirmationId);

	/**
	 * Returns all the employee confirmations.
	 *
	 * @return the employee confirmations
	 */
	public java.util.List<EmployeeConfirmation> findAll();

	/**
	 * Returns a range of all the employee confirmations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeConfirmationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee confirmations
	 * @param end the upper bound of the range of employee confirmations (not inclusive)
	 * @return the range of employee confirmations
	 */
	public java.util.List<EmployeeConfirmation> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employee confirmations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeConfirmationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee confirmations
	 * @param end the upper bound of the range of employee confirmations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee confirmations
	 */
	public java.util.List<EmployeeConfirmation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeConfirmation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employee confirmations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeConfirmationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee confirmations
	 * @param end the upper bound of the range of employee confirmations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee confirmations
	 */
	public java.util.List<EmployeeConfirmation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeConfirmation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee confirmations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee confirmations.
	 *
	 * @return the number of employee confirmations
	 */
	public int countAll();

}