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

import com.adjecti.mdm.liferay.model.OrganizationHistory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the organization history service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.OrganizationHistoryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationHistoryPersistence
 * @generated
 */
public class OrganizationHistoryUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(OrganizationHistory organizationHistory) {
		getPersistence().clearCache(organizationHistory);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, OrganizationHistory> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<OrganizationHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OrganizationHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OrganizationHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<OrganizationHistory> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static OrganizationHistory update(
		OrganizationHistory organizationHistory) {

		return getPersistence().update(organizationHistory);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static OrganizationHistory update(
		OrganizationHistory organizationHistory,
		ServiceContext serviceContext) {

		return getPersistence().update(organizationHistory, serviceContext);
	}

	/**
	 * Returns all the organization histories where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching organization histories
	 */
	public static List<OrganizationHistory> findByOrganizationId(
		long organizationId) {

		return getPersistence().findByOrganizationId(organizationId);
	}

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
	public static List<OrganizationHistory> findByOrganizationId(
		long organizationId, int start, int end) {

		return getPersistence().findByOrganizationId(
			organizationId, start, end);
	}

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
	public static List<OrganizationHistory> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<OrganizationHistory> orderByComparator) {

		return getPersistence().findByOrganizationId(
			organizationId, start, end, orderByComparator);
	}

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
	public static List<OrganizationHistory> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<OrganizationHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByOrganizationId(
			organizationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first organization history in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization history
	 * @throws NoSuchOrganizationHistoryException if a matching organization history could not be found
	 */
	public static OrganizationHistory findByOrganizationId_First(
			long organizationId,
			OrderByComparator<OrganizationHistory> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationHistoryException {

		return getPersistence().findByOrganizationId_First(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the first organization history in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization history, or <code>null</code> if a matching organization history could not be found
	 */
	public static OrganizationHistory fetchByOrganizationId_First(
		long organizationId,
		OrderByComparator<OrganizationHistory> orderByComparator) {

		return getPersistence().fetchByOrganizationId_First(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the last organization history in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization history
	 * @throws NoSuchOrganizationHistoryException if a matching organization history could not be found
	 */
	public static OrganizationHistory findByOrganizationId_Last(
			long organizationId,
			OrderByComparator<OrganizationHistory> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationHistoryException {

		return getPersistence().findByOrganizationId_Last(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the last organization history in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization history, or <code>null</code> if a matching organization history could not be found
	 */
	public static OrganizationHistory fetchByOrganizationId_Last(
		long organizationId,
		OrderByComparator<OrganizationHistory> orderByComparator) {

		return getPersistence().fetchByOrganizationId_Last(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the organization histories before and after the current organization history in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationHistoryId the primary key of the current organization history
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization history
	 * @throws NoSuchOrganizationHistoryException if a organization history with the primary key could not be found
	 */
	public static OrganizationHistory[] findByOrganizationId_PrevAndNext(
			long organizationHistoryId, long organizationId,
			OrderByComparator<OrganizationHistory> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationHistoryException {

		return getPersistence().findByOrganizationId_PrevAndNext(
			organizationHistoryId, organizationId, orderByComparator);
	}

	/**
	 * Removes all the organization histories where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	public static void removeByOrganizationId(long organizationId) {
		getPersistence().removeByOrganizationId(organizationId);
	}

	/**
	 * Returns the number of organization histories where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching organization histories
	 */
	public static int countByOrganizationId(long organizationId) {
		return getPersistence().countByOrganizationId(organizationId);
	}

	/**
	 * Returns all the organization histories where previousOrganizationId = &#63;.
	 *
	 * @param previousOrganizationId the previous organization ID
	 * @return the matching organization histories
	 */
	public static List<OrganizationHistory> findByPreviousOrganizationId(
		long previousOrganizationId) {

		return getPersistence().findByPreviousOrganizationId(
			previousOrganizationId);
	}

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
	public static List<OrganizationHistory> findByPreviousOrganizationId(
		long previousOrganizationId, int start, int end) {

		return getPersistence().findByPreviousOrganizationId(
			previousOrganizationId, start, end);
	}

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
	public static List<OrganizationHistory> findByPreviousOrganizationId(
		long previousOrganizationId, int start, int end,
		OrderByComparator<OrganizationHistory> orderByComparator) {

		return getPersistence().findByPreviousOrganizationId(
			previousOrganizationId, start, end, orderByComparator);
	}

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
	public static List<OrganizationHistory> findByPreviousOrganizationId(
		long previousOrganizationId, int start, int end,
		OrderByComparator<OrganizationHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPreviousOrganizationId(
			previousOrganizationId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first organization history in the ordered set where previousOrganizationId = &#63;.
	 *
	 * @param previousOrganizationId the previous organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization history
	 * @throws NoSuchOrganizationHistoryException if a matching organization history could not be found
	 */
	public static OrganizationHistory findByPreviousOrganizationId_First(
			long previousOrganizationId,
			OrderByComparator<OrganizationHistory> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationHistoryException {

		return getPersistence().findByPreviousOrganizationId_First(
			previousOrganizationId, orderByComparator);
	}

	/**
	 * Returns the first organization history in the ordered set where previousOrganizationId = &#63;.
	 *
	 * @param previousOrganizationId the previous organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization history, or <code>null</code> if a matching organization history could not be found
	 */
	public static OrganizationHistory fetchByPreviousOrganizationId_First(
		long previousOrganizationId,
		OrderByComparator<OrganizationHistory> orderByComparator) {

		return getPersistence().fetchByPreviousOrganizationId_First(
			previousOrganizationId, orderByComparator);
	}

	/**
	 * Returns the last organization history in the ordered set where previousOrganizationId = &#63;.
	 *
	 * @param previousOrganizationId the previous organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization history
	 * @throws NoSuchOrganizationHistoryException if a matching organization history could not be found
	 */
	public static OrganizationHistory findByPreviousOrganizationId_Last(
			long previousOrganizationId,
			OrderByComparator<OrganizationHistory> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationHistoryException {

		return getPersistence().findByPreviousOrganizationId_Last(
			previousOrganizationId, orderByComparator);
	}

	/**
	 * Returns the last organization history in the ordered set where previousOrganizationId = &#63;.
	 *
	 * @param previousOrganizationId the previous organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization history, or <code>null</code> if a matching organization history could not be found
	 */
	public static OrganizationHistory fetchByPreviousOrganizationId_Last(
		long previousOrganizationId,
		OrderByComparator<OrganizationHistory> orderByComparator) {

		return getPersistence().fetchByPreviousOrganizationId_Last(
			previousOrganizationId, orderByComparator);
	}

	/**
	 * Returns the organization histories before and after the current organization history in the ordered set where previousOrganizationId = &#63;.
	 *
	 * @param organizationHistoryId the primary key of the current organization history
	 * @param previousOrganizationId the previous organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization history
	 * @throws NoSuchOrganizationHistoryException if a organization history with the primary key could not be found
	 */
	public static OrganizationHistory[]
			findByPreviousOrganizationId_PrevAndNext(
				long organizationHistoryId, long previousOrganizationId,
				OrderByComparator<OrganizationHistory> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationHistoryException {

		return getPersistence().findByPreviousOrganizationId_PrevAndNext(
			organizationHistoryId, previousOrganizationId, orderByComparator);
	}

	/**
	 * Removes all the organization histories where previousOrganizationId = &#63; from the database.
	 *
	 * @param previousOrganizationId the previous organization ID
	 */
	public static void removeByPreviousOrganizationId(
		long previousOrganizationId) {

		getPersistence().removeByPreviousOrganizationId(previousOrganizationId);
	}

	/**
	 * Returns the number of organization histories where previousOrganizationId = &#63;.
	 *
	 * @param previousOrganizationId the previous organization ID
	 * @return the number of matching organization histories
	 */
	public static int countByPreviousOrganizationId(
		long previousOrganizationId) {

		return getPersistence().countByPreviousOrganizationId(
			previousOrganizationId);
	}

	/**
	 * Caches the organization history in the entity cache if it is enabled.
	 *
	 * @param organizationHistory the organization history
	 */
	public static void cacheResult(OrganizationHistory organizationHistory) {
		getPersistence().cacheResult(organizationHistory);
	}

	/**
	 * Caches the organization histories in the entity cache if it is enabled.
	 *
	 * @param organizationHistories the organization histories
	 */
	public static void cacheResult(
		List<OrganizationHistory> organizationHistories) {

		getPersistence().cacheResult(organizationHistories);
	}

	/**
	 * Creates a new organization history with the primary key. Does not add the organization history to the database.
	 *
	 * @param organizationHistoryId the primary key for the new organization history
	 * @return the new organization history
	 */
	public static OrganizationHistory create(long organizationHistoryId) {
		return getPersistence().create(organizationHistoryId);
	}

	/**
	 * Removes the organization history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param organizationHistoryId the primary key of the organization history
	 * @return the organization history that was removed
	 * @throws NoSuchOrganizationHistoryException if a organization history with the primary key could not be found
	 */
	public static OrganizationHistory remove(long organizationHistoryId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationHistoryException {

		return getPersistence().remove(organizationHistoryId);
	}

	public static OrganizationHistory updateImpl(
		OrganizationHistory organizationHistory) {

		return getPersistence().updateImpl(organizationHistory);
	}

	/**
	 * Returns the organization history with the primary key or throws a <code>NoSuchOrganizationHistoryException</code> if it could not be found.
	 *
	 * @param organizationHistoryId the primary key of the organization history
	 * @return the organization history
	 * @throws NoSuchOrganizationHistoryException if a organization history with the primary key could not be found
	 */
	public static OrganizationHistory findByPrimaryKey(
			long organizationHistoryId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationHistoryException {

		return getPersistence().findByPrimaryKey(organizationHistoryId);
	}

	/**
	 * Returns the organization history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param organizationHistoryId the primary key of the organization history
	 * @return the organization history, or <code>null</code> if a organization history with the primary key could not be found
	 */
	public static OrganizationHistory fetchByPrimaryKey(
		long organizationHistoryId) {

		return getPersistence().fetchByPrimaryKey(organizationHistoryId);
	}

	/**
	 * Returns all the organization histories.
	 *
	 * @return the organization histories
	 */
	public static List<OrganizationHistory> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<OrganizationHistory> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<OrganizationHistory> findAll(
		int start, int end,
		OrderByComparator<OrganizationHistory> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<OrganizationHistory> findAll(
		int start, int end,
		OrderByComparator<OrganizationHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the organization histories from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of organization histories.
	 *
	 * @return the number of organization histories
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static OrganizationHistoryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<OrganizationHistoryPersistence, OrganizationHistoryPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			OrganizationHistoryPersistence.class);

		ServiceTracker
			<OrganizationHistoryPersistence, OrganizationHistoryPersistence>
				serviceTracker =
					new ServiceTracker
						<OrganizationHistoryPersistence,
						 OrganizationHistoryPersistence>(
							 bundle.getBundleContext(),
							 OrganizationHistoryPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}