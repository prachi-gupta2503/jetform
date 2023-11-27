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

import com.adjecti.pis.liferay.model.EmployeeTransfer;

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
 * The persistence utility for the employee transfer service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.EmployeeTransferPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeTransferPersistence
 * @generated
 */
public class EmployeeTransferUtil {

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
	public static void clearCache(EmployeeTransfer employeeTransfer) {
		getPersistence().clearCache(employeeTransfer);
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
	public static Map<Serializable, EmployeeTransfer> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeTransfer> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeTransfer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeTransfer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeTransfer> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeTransfer update(EmployeeTransfer employeeTransfer) {
		return getPersistence().update(employeeTransfer);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeTransfer update(
		EmployeeTransfer employeeTransfer, ServiceContext serviceContext) {

		return getPersistence().update(employeeTransfer, serviceContext);
	}

	/**
	 * Returns all the employee transfers where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @return the matching employee transfers
	 */
	public static List<EmployeeTransfer> findByGradeModeId(long gradeModeId) {
		return getPersistence().findByGradeModeId(gradeModeId);
	}

	/**
	 * Returns a range of all the employee transfers where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @return the range of matching employee transfers
	 */
	public static List<EmployeeTransfer> findByGradeModeId(
		long gradeModeId, int start, int end) {

		return getPersistence().findByGradeModeId(gradeModeId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee transfers where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee transfers
	 */
	public static List<EmployeeTransfer> findByGradeModeId(
		long gradeModeId, int start, int end,
		OrderByComparator<EmployeeTransfer> orderByComparator) {

		return getPersistence().findByGradeModeId(
			gradeModeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee transfers where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee transfers
	 */
	public static List<EmployeeTransfer> findByGradeModeId(
		long gradeModeId, int start, int end,
		OrderByComparator<EmployeeTransfer> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGradeModeId(
			gradeModeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee transfer in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee transfer
	 * @throws NoSuchEmployeeTransferException if a matching employee transfer could not be found
	 */
	public static EmployeeTransfer findByGradeModeId_First(
			long gradeModeId,
			OrderByComparator<EmployeeTransfer> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeTransferException {

		return getPersistence().findByGradeModeId_First(
			gradeModeId, orderByComparator);
	}

	/**
	 * Returns the first employee transfer in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee transfer, or <code>null</code> if a matching employee transfer could not be found
	 */
	public static EmployeeTransfer fetchByGradeModeId_First(
		long gradeModeId,
		OrderByComparator<EmployeeTransfer> orderByComparator) {

		return getPersistence().fetchByGradeModeId_First(
			gradeModeId, orderByComparator);
	}

	/**
	 * Returns the last employee transfer in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee transfer
	 * @throws NoSuchEmployeeTransferException if a matching employee transfer could not be found
	 */
	public static EmployeeTransfer findByGradeModeId_Last(
			long gradeModeId,
			OrderByComparator<EmployeeTransfer> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeTransferException {

		return getPersistence().findByGradeModeId_Last(
			gradeModeId, orderByComparator);
	}

	/**
	 * Returns the last employee transfer in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee transfer, or <code>null</code> if a matching employee transfer could not be found
	 */
	public static EmployeeTransfer fetchByGradeModeId_Last(
		long gradeModeId,
		OrderByComparator<EmployeeTransfer> orderByComparator) {

		return getPersistence().fetchByGradeModeId_Last(
			gradeModeId, orderByComparator);
	}

	/**
	 * Returns the employee transfers before and after the current employee transfer in the ordered set where gradeModeId = &#63;.
	 *
	 * @param employeeTransferId the primary key of the current employee transfer
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee transfer
	 * @throws NoSuchEmployeeTransferException if a employee transfer with the primary key could not be found
	 */
	public static EmployeeTransfer[] findByGradeModeId_PrevAndNext(
			long employeeTransferId, long gradeModeId,
			OrderByComparator<EmployeeTransfer> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeTransferException {

		return getPersistence().findByGradeModeId_PrevAndNext(
			employeeTransferId, gradeModeId, orderByComparator);
	}

	/**
	 * Removes all the employee transfers where gradeModeId = &#63; from the database.
	 *
	 * @param gradeModeId the grade mode ID
	 */
	public static void removeByGradeModeId(long gradeModeId) {
		getPersistence().removeByGradeModeId(gradeModeId);
	}

	/**
	 * Returns the number of employee transfers where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @return the number of matching employee transfers
	 */
	public static int countByGradeModeId(long gradeModeId) {
		return getPersistence().countByGradeModeId(gradeModeId);
	}

	/**
	 * Returns all the employee transfers where fromOrganizationId = &#63;.
	 *
	 * @param fromOrganizationId the from organization ID
	 * @return the matching employee transfers
	 */
	public static List<EmployeeTransfer> findByFromOrganizationId(
		long fromOrganizationId) {

		return getPersistence().findByFromOrganizationId(fromOrganizationId);
	}

	/**
	 * Returns a range of all the employee transfers where fromOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param fromOrganizationId the from organization ID
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @return the range of matching employee transfers
	 */
	public static List<EmployeeTransfer> findByFromOrganizationId(
		long fromOrganizationId, int start, int end) {

		return getPersistence().findByFromOrganizationId(
			fromOrganizationId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee transfers where fromOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param fromOrganizationId the from organization ID
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee transfers
	 */
	public static List<EmployeeTransfer> findByFromOrganizationId(
		long fromOrganizationId, int start, int end,
		OrderByComparator<EmployeeTransfer> orderByComparator) {

		return getPersistence().findByFromOrganizationId(
			fromOrganizationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee transfers where fromOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param fromOrganizationId the from organization ID
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee transfers
	 */
	public static List<EmployeeTransfer> findByFromOrganizationId(
		long fromOrganizationId, int start, int end,
		OrderByComparator<EmployeeTransfer> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFromOrganizationId(
			fromOrganizationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee transfer in the ordered set where fromOrganizationId = &#63;.
	 *
	 * @param fromOrganizationId the from organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee transfer
	 * @throws NoSuchEmployeeTransferException if a matching employee transfer could not be found
	 */
	public static EmployeeTransfer findByFromOrganizationId_First(
			long fromOrganizationId,
			OrderByComparator<EmployeeTransfer> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeTransferException {

		return getPersistence().findByFromOrganizationId_First(
			fromOrganizationId, orderByComparator);
	}

	/**
	 * Returns the first employee transfer in the ordered set where fromOrganizationId = &#63;.
	 *
	 * @param fromOrganizationId the from organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee transfer, or <code>null</code> if a matching employee transfer could not be found
	 */
	public static EmployeeTransfer fetchByFromOrganizationId_First(
		long fromOrganizationId,
		OrderByComparator<EmployeeTransfer> orderByComparator) {

		return getPersistence().fetchByFromOrganizationId_First(
			fromOrganizationId, orderByComparator);
	}

	/**
	 * Returns the last employee transfer in the ordered set where fromOrganizationId = &#63;.
	 *
	 * @param fromOrganizationId the from organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee transfer
	 * @throws NoSuchEmployeeTransferException if a matching employee transfer could not be found
	 */
	public static EmployeeTransfer findByFromOrganizationId_Last(
			long fromOrganizationId,
			OrderByComparator<EmployeeTransfer> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeTransferException {

		return getPersistence().findByFromOrganizationId_Last(
			fromOrganizationId, orderByComparator);
	}

	/**
	 * Returns the last employee transfer in the ordered set where fromOrganizationId = &#63;.
	 *
	 * @param fromOrganizationId the from organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee transfer, or <code>null</code> if a matching employee transfer could not be found
	 */
	public static EmployeeTransfer fetchByFromOrganizationId_Last(
		long fromOrganizationId,
		OrderByComparator<EmployeeTransfer> orderByComparator) {

		return getPersistence().fetchByFromOrganizationId_Last(
			fromOrganizationId, orderByComparator);
	}

	/**
	 * Returns the employee transfers before and after the current employee transfer in the ordered set where fromOrganizationId = &#63;.
	 *
	 * @param employeeTransferId the primary key of the current employee transfer
	 * @param fromOrganizationId the from organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee transfer
	 * @throws NoSuchEmployeeTransferException if a employee transfer with the primary key could not be found
	 */
	public static EmployeeTransfer[] findByFromOrganizationId_PrevAndNext(
			long employeeTransferId, long fromOrganizationId,
			OrderByComparator<EmployeeTransfer> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeTransferException {

		return getPersistence().findByFromOrganizationId_PrevAndNext(
			employeeTransferId, fromOrganizationId, orderByComparator);
	}

	/**
	 * Removes all the employee transfers where fromOrganizationId = &#63; from the database.
	 *
	 * @param fromOrganizationId the from organization ID
	 */
	public static void removeByFromOrganizationId(long fromOrganizationId) {
		getPersistence().removeByFromOrganizationId(fromOrganizationId);
	}

	/**
	 * Returns the number of employee transfers where fromOrganizationId = &#63;.
	 *
	 * @param fromOrganizationId the from organization ID
	 * @return the number of matching employee transfers
	 */
	public static int countByFromOrganizationId(long fromOrganizationId) {
		return getPersistence().countByFromOrganizationId(fromOrganizationId);
	}

	/**
	 * Returns all the employee transfers where toOrganizationId = &#63;.
	 *
	 * @param toOrganizationId the to organization ID
	 * @return the matching employee transfers
	 */
	public static List<EmployeeTransfer> findByToOrganizationId(
		long toOrganizationId) {

		return getPersistence().findByToOrganizationId(toOrganizationId);
	}

	/**
	 * Returns a range of all the employee transfers where toOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param toOrganizationId the to organization ID
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @return the range of matching employee transfers
	 */
	public static List<EmployeeTransfer> findByToOrganizationId(
		long toOrganizationId, int start, int end) {

		return getPersistence().findByToOrganizationId(
			toOrganizationId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee transfers where toOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param toOrganizationId the to organization ID
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee transfers
	 */
	public static List<EmployeeTransfer> findByToOrganizationId(
		long toOrganizationId, int start, int end,
		OrderByComparator<EmployeeTransfer> orderByComparator) {

		return getPersistence().findByToOrganizationId(
			toOrganizationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee transfers where toOrganizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param toOrganizationId the to organization ID
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee transfers
	 */
	public static List<EmployeeTransfer> findByToOrganizationId(
		long toOrganizationId, int start, int end,
		OrderByComparator<EmployeeTransfer> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByToOrganizationId(
			toOrganizationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee transfer in the ordered set where toOrganizationId = &#63;.
	 *
	 * @param toOrganizationId the to organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee transfer
	 * @throws NoSuchEmployeeTransferException if a matching employee transfer could not be found
	 */
	public static EmployeeTransfer findByToOrganizationId_First(
			long toOrganizationId,
			OrderByComparator<EmployeeTransfer> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeTransferException {

		return getPersistence().findByToOrganizationId_First(
			toOrganizationId, orderByComparator);
	}

	/**
	 * Returns the first employee transfer in the ordered set where toOrganizationId = &#63;.
	 *
	 * @param toOrganizationId the to organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee transfer, or <code>null</code> if a matching employee transfer could not be found
	 */
	public static EmployeeTransfer fetchByToOrganizationId_First(
		long toOrganizationId,
		OrderByComparator<EmployeeTransfer> orderByComparator) {

		return getPersistence().fetchByToOrganizationId_First(
			toOrganizationId, orderByComparator);
	}

	/**
	 * Returns the last employee transfer in the ordered set where toOrganizationId = &#63;.
	 *
	 * @param toOrganizationId the to organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee transfer
	 * @throws NoSuchEmployeeTransferException if a matching employee transfer could not be found
	 */
	public static EmployeeTransfer findByToOrganizationId_Last(
			long toOrganizationId,
			OrderByComparator<EmployeeTransfer> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeTransferException {

		return getPersistence().findByToOrganizationId_Last(
			toOrganizationId, orderByComparator);
	}

	/**
	 * Returns the last employee transfer in the ordered set where toOrganizationId = &#63;.
	 *
	 * @param toOrganizationId the to organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee transfer, or <code>null</code> if a matching employee transfer could not be found
	 */
	public static EmployeeTransfer fetchByToOrganizationId_Last(
		long toOrganizationId,
		OrderByComparator<EmployeeTransfer> orderByComparator) {

		return getPersistence().fetchByToOrganizationId_Last(
			toOrganizationId, orderByComparator);
	}

	/**
	 * Returns the employee transfers before and after the current employee transfer in the ordered set where toOrganizationId = &#63;.
	 *
	 * @param employeeTransferId the primary key of the current employee transfer
	 * @param toOrganizationId the to organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee transfer
	 * @throws NoSuchEmployeeTransferException if a employee transfer with the primary key could not be found
	 */
	public static EmployeeTransfer[] findByToOrganizationId_PrevAndNext(
			long employeeTransferId, long toOrganizationId,
			OrderByComparator<EmployeeTransfer> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeTransferException {

		return getPersistence().findByToOrganizationId_PrevAndNext(
			employeeTransferId, toOrganizationId, orderByComparator);
	}

	/**
	 * Removes all the employee transfers where toOrganizationId = &#63; from the database.
	 *
	 * @param toOrganizationId the to organization ID
	 */
	public static void removeByToOrganizationId(long toOrganizationId) {
		getPersistence().removeByToOrganizationId(toOrganizationId);
	}

	/**
	 * Returns the number of employee transfers where toOrganizationId = &#63;.
	 *
	 * @param toOrganizationId the to organization ID
	 * @return the number of matching employee transfers
	 */
	public static int countByToOrganizationId(long toOrganizationId) {
		return getPersistence().countByToOrganizationId(toOrganizationId);
	}

	/**
	 * Returns all the employee transfers where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee transfers
	 */
	public static List<EmployeeTransfer> findByEmployeeId(long employeeId) {
		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns a range of all the employee transfers where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @return the range of matching employee transfers
	 */
	public static List<EmployeeTransfer> findByEmployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee transfers where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee transfers
	 */
	public static List<EmployeeTransfer> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeTransfer> orderByComparator) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee transfers where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee transfers
	 */
	public static List<EmployeeTransfer> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeeTransfer> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee transfer in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee transfer
	 * @throws NoSuchEmployeeTransferException if a matching employee transfer could not be found
	 */
	public static EmployeeTransfer findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeeTransfer> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeTransferException {

		return getPersistence().findByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first employee transfer in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee transfer, or <code>null</code> if a matching employee transfer could not be found
	 */
	public static EmployeeTransfer fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<EmployeeTransfer> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee transfer in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee transfer
	 * @throws NoSuchEmployeeTransferException if a matching employee transfer could not be found
	 */
	public static EmployeeTransfer findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeeTransfer> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeTransferException {

		return getPersistence().findByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee transfer in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee transfer, or <code>null</code> if a matching employee transfer could not be found
	 */
	public static EmployeeTransfer fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<EmployeeTransfer> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the employee transfers before and after the current employee transfer in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeTransferId the primary key of the current employee transfer
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee transfer
	 * @throws NoSuchEmployeeTransferException if a employee transfer with the primary key could not be found
	 */
	public static EmployeeTransfer[] findByEmployeeId_PrevAndNext(
			long employeeTransferId, long employeeId,
			OrderByComparator<EmployeeTransfer> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeTransferException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			employeeTransferId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the employee transfers where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of employee transfers where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee transfers
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Caches the employee transfer in the entity cache if it is enabled.
	 *
	 * @param employeeTransfer the employee transfer
	 */
	public static void cacheResult(EmployeeTransfer employeeTransfer) {
		getPersistence().cacheResult(employeeTransfer);
	}

	/**
	 * Caches the employee transfers in the entity cache if it is enabled.
	 *
	 * @param employeeTransfers the employee transfers
	 */
	public static void cacheResult(List<EmployeeTransfer> employeeTransfers) {
		getPersistence().cacheResult(employeeTransfers);
	}

	/**
	 * Creates a new employee transfer with the primary key. Does not add the employee transfer to the database.
	 *
	 * @param employeeTransferId the primary key for the new employee transfer
	 * @return the new employee transfer
	 */
	public static EmployeeTransfer create(long employeeTransferId) {
		return getPersistence().create(employeeTransferId);
	}

	/**
	 * Removes the employee transfer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeTransferId the primary key of the employee transfer
	 * @return the employee transfer that was removed
	 * @throws NoSuchEmployeeTransferException if a employee transfer with the primary key could not be found
	 */
	public static EmployeeTransfer remove(long employeeTransferId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeTransferException {

		return getPersistence().remove(employeeTransferId);
	}

	public static EmployeeTransfer updateImpl(
		EmployeeTransfer employeeTransfer) {

		return getPersistence().updateImpl(employeeTransfer);
	}

	/**
	 * Returns the employee transfer with the primary key or throws a <code>NoSuchEmployeeTransferException</code> if it could not be found.
	 *
	 * @param employeeTransferId the primary key of the employee transfer
	 * @return the employee transfer
	 * @throws NoSuchEmployeeTransferException if a employee transfer with the primary key could not be found
	 */
	public static EmployeeTransfer findByPrimaryKey(long employeeTransferId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeeTransferException {

		return getPersistence().findByPrimaryKey(employeeTransferId);
	}

	/**
	 * Returns the employee transfer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeTransferId the primary key of the employee transfer
	 * @return the employee transfer, or <code>null</code> if a employee transfer with the primary key could not be found
	 */
	public static EmployeeTransfer fetchByPrimaryKey(long employeeTransferId) {
		return getPersistence().fetchByPrimaryKey(employeeTransferId);
	}

	/**
	 * Returns all the employee transfers.
	 *
	 * @return the employee transfers
	 */
	public static List<EmployeeTransfer> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employee transfers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @return the range of employee transfers
	 */
	public static List<EmployeeTransfer> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employee transfers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee transfers
	 */
	public static List<EmployeeTransfer> findAll(
		int start, int end,
		OrderByComparator<EmployeeTransfer> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee transfers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee transfers
	 */
	public static List<EmployeeTransfer> findAll(
		int start, int end,
		OrderByComparator<EmployeeTransfer> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee transfers from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee transfers.
	 *
	 * @return the number of employee transfers
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeTransferPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeeTransferPersistence, EmployeeTransferPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EmployeeTransferPersistence.class);

		ServiceTracker<EmployeeTransferPersistence, EmployeeTransferPersistence>
			serviceTracker =
				new ServiceTracker
					<EmployeeTransferPersistence, EmployeeTransferPersistence>(
						bundle.getBundleContext(),
						EmployeeTransferPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}