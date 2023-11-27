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

import com.adjecti.mdm.liferay.exception.NoSuchOrganizationHistoryException;
import com.adjecti.mdm.liferay.model.OrganizationHistory;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the organization history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationHistoryUtil
 * @generated
 */
@ProviderType
public interface OrganizationHistoryPersistence
	extends BasePersistence<OrganizationHistory> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OrganizationHistoryUtil} to access the organization history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the organization histories where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching organization histories
	 */
	public java.util.List<OrganizationHistory> findByOrganizationId(
		long organizationId);

	/**
	 * Returns a range of all the organization histories where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of organization histories
	 * @param end the upper bound of the range of organization histories (not inclusive)
	 * @return the range of matching organization histories
	 */
	public java.util.List<OrganizationHistory> findByOrganizationId(
		long organizationId, int start, int end);

	/**
	 * Returns an ordered range of all the organization histories where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of organization histories
	 * @param end the upper bound of the range of organization histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization histories
	 */
	public java.util.List<OrganizationHistory> findByOrganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationHistory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the organization histories where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of organization histories
	 * @param end the upper bound of the range of organization histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization histories
	 */
	public java.util.List<OrganizationHistory> findByOrganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first organization history in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization history
	 * @throws NoSuchOrganizationHistoryException if a matching organization history could not be found
	 */
	public OrganizationHistory findByOrganizationId_First(
			long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<OrganizationHistory> orderByComparator)
		throws NoSuchOrganizationHistoryException;

	/**
	 * Returns the first organization history in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization history, or <code>null</code> if a matching organization history could not be found
	 */
	public OrganizationHistory fetchByOrganizationId_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationHistory>
			orderByComparator);

	/**
	 * Returns the last organization history in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization history
	 * @throws NoSuchOrganizationHistoryException if a matching organization history could not be found
	 */
	public OrganizationHistory findByOrganizationId_Last(
			long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<OrganizationHistory> orderByComparator)
		throws NoSuchOrganizationHistoryException;

	/**
	 * Returns the last organization history in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization history, or <code>null</code> if a matching organization history could not be found
	 */
	public OrganizationHistory fetchByOrganizationId_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationHistory>
			orderByComparator);

	/**
	 * Returns the organization histories before and after the current organization history in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationHistoryId the primary key of the current organization history
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization history
	 * @throws NoSuchOrganizationHistoryException if a organization history with the primary key could not be found
	 */
	public OrganizationHistory[] findByOrganizationId_PrevAndNext(
			long organizationHistoryId, long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<OrganizationHistory> orderByComparator)
		throws NoSuchOrganizationHistoryException;

	/**
	 * Removes all the organization histories where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	public void removeByOrganizationId(long organizationId);

	/**
	 * Returns the number of organization histories where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching organization histories
	 */
	public int countByOrganizationId(long organizationId);

	/**
	 * Returns all the organization histories where previousOrganizationId = &#63;.
	 *
	 * @param previousOrganizationId the previous organization ID
	 * @return the matching organization histories
	 */
	public java.util.List<OrganizationHistory> findByPreviousOrganizationId(
		long previousOrganizationId);

	/**
	 * Returns a range of all the organization histories where previousOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param previousOrganizationId the previous organization ID
	 * @param start the lower bound of the range of organization histories
	 * @param end the upper bound of the range of organization histories (not inclusive)
	 * @return the range of matching organization histories
	 */
	public java.util.List<OrganizationHistory> findByPreviousOrganizationId(
		long previousOrganizationId, int start, int end);

	/**
	 * Returns an ordered range of all the organization histories where previousOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param previousOrganizationId the previous organization ID
	 * @param start the lower bound of the range of organization histories
	 * @param end the upper bound of the range of organization histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization histories
	 */
	public java.util.List<OrganizationHistory> findByPreviousOrganizationId(
		long previousOrganizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationHistory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the organization histories where previousOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param previousOrganizationId the previous organization ID
	 * @param start the lower bound of the range of organization histories
	 * @param end the upper bound of the range of organization histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization histories
	 */
	public java.util.List<OrganizationHistory> findByPreviousOrganizationId(
		long previousOrganizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first organization history in the ordered set where previousOrganizationId = &#63;.
	 *
	 * @param previousOrganizationId the previous organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization history
	 * @throws NoSuchOrganizationHistoryException if a matching organization history could not be found
	 */
	public OrganizationHistory findByPreviousOrganizationId_First(
			long previousOrganizationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<OrganizationHistory> orderByComparator)
		throws NoSuchOrganizationHistoryException;

	/**
	 * Returns the first organization history in the ordered set where previousOrganizationId = &#63;.
	 *
	 * @param previousOrganizationId the previous organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization history, or <code>null</code> if a matching organization history could not be found
	 */
	public OrganizationHistory fetchByPreviousOrganizationId_First(
		long previousOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationHistory>
			orderByComparator);

	/**
	 * Returns the last organization history in the ordered set where previousOrganizationId = &#63;.
	 *
	 * @param previousOrganizationId the previous organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization history
	 * @throws NoSuchOrganizationHistoryException if a matching organization history could not be found
	 */
	public OrganizationHistory findByPreviousOrganizationId_Last(
			long previousOrganizationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<OrganizationHistory> orderByComparator)
		throws NoSuchOrganizationHistoryException;

	/**
	 * Returns the last organization history in the ordered set where previousOrganizationId = &#63;.
	 *
	 * @param previousOrganizationId the previous organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization history, or <code>null</code> if a matching organization history could not be found
	 */
	public OrganizationHistory fetchByPreviousOrganizationId_Last(
		long previousOrganizationId,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationHistory>
			orderByComparator);

	/**
	 * Returns the organization histories before and after the current organization history in the ordered set where previousOrganizationId = &#63;.
	 *
	 * @param organizationHistoryId the primary key of the current organization history
	 * @param previousOrganizationId the previous organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization history
	 * @throws NoSuchOrganizationHistoryException if a organization history with the primary key could not be found
	 */
	public OrganizationHistory[] findByPreviousOrganizationId_PrevAndNext(
			long organizationHistoryId, long previousOrganizationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<OrganizationHistory> orderByComparator)
		throws NoSuchOrganizationHistoryException;

	/**
	 * Removes all the organization histories where previousOrganizationId = &#63; from the database.
	 *
	 * @param previousOrganizationId the previous organization ID
	 */
	public void removeByPreviousOrganizationId(long previousOrganizationId);

	/**
	 * Returns the number of organization histories where previousOrganizationId = &#63;.
	 *
	 * @param previousOrganizationId the previous organization ID
	 * @return the number of matching organization histories
	 */
	public int countByPreviousOrganizationId(long previousOrganizationId);

	/**
	 * Caches the organization history in the entity cache if it is enabled.
	 *
	 * @param organizationHistory the organization history
	 */
	public void cacheResult(OrganizationHistory organizationHistory);

	/**
	 * Caches the organization histories in the entity cache if it is enabled.
	 *
	 * @param organizationHistories the organization histories
	 */
	public void cacheResult(
		java.util.List<OrganizationHistory> organizationHistories);

	/**
	 * Creates a new organization history with the primary key. Does not add the organization history to the database.
	 *
	 * @param organizationHistoryId the primary key for the new organization history
	 * @return the new organization history
	 */
	public OrganizationHistory create(long organizationHistoryId);

	/**
	 * Removes the organization history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param organizationHistoryId the primary key of the organization history
	 * @return the organization history that was removed
	 * @throws NoSuchOrganizationHistoryException if a organization history with the primary key could not be found
	 */
	public OrganizationHistory remove(long organizationHistoryId)
		throws NoSuchOrganizationHistoryException;

	public OrganizationHistory updateImpl(
		OrganizationHistory organizationHistory);

	/**
	 * Returns the organization history with the primary key or throws a <code>NoSuchOrganizationHistoryException</code> if it could not be found.
	 *
	 * @param organizationHistoryId the primary key of the organization history
	 * @return the organization history
	 * @throws NoSuchOrganizationHistoryException if a organization history with the primary key could not be found
	 */
	public OrganizationHistory findByPrimaryKey(long organizationHistoryId)
		throws NoSuchOrganizationHistoryException;

	/**
	 * Returns the organization history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param organizationHistoryId the primary key of the organization history
	 * @return the organization history, or <code>null</code> if a organization history with the primary key could not be found
	 */
	public OrganizationHistory fetchByPrimaryKey(long organizationHistoryId);

	/**
	 * Returns all the organization histories.
	 *
	 * @return the organization histories
	 */
	public java.util.List<OrganizationHistory> findAll();

	/**
	 * Returns a range of all the organization histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization histories
	 * @param end the upper bound of the range of organization histories (not inclusive)
	 * @return the range of organization histories
	 */
	public java.util.List<OrganizationHistory> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the organization histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization histories
	 * @param end the upper bound of the range of organization histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of organization histories
	 */
	public java.util.List<OrganizationHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationHistory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the organization histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization histories
	 * @param end the upper bound of the range of organization histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of organization histories
	 */
	public java.util.List<OrganizationHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OrganizationHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the organization histories from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of organization histories.
	 *
	 * @return the number of organization histories
	 */
	public int countAll();

}