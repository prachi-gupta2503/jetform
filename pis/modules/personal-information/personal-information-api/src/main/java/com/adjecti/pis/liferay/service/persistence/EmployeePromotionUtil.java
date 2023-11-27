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

import com.adjecti.pis.liferay.model.EmployeePromotion;

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
 * The persistence utility for the employee promotion service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.EmployeePromotionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeePromotionPersistence
 * @generated
 */
public class EmployeePromotionUtil {

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
	public static void clearCache(EmployeePromotion employeePromotion) {
		getPersistence().clearCache(employeePromotion);
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
	public static Map<Serializable, EmployeePromotion> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeePromotion> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeePromotion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeePromotion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeePromotion> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeePromotion update(
		EmployeePromotion employeePromotion) {

		return getPersistence().update(employeePromotion);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeePromotion update(
		EmployeePromotion employeePromotion, ServiceContext serviceContext) {

		return getPersistence().update(employeePromotion, serviceContext);
	}

	/**
	 * Returns all the employee promotions where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @return the matching employee promotions
	 */
	public static List<EmployeePromotion> findByGradeModeId(long gradeModeId) {
		return getPersistence().findByGradeModeId(gradeModeId);
	}

	/**
	 * Returns a range of all the employee promotions where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee promotions
	 * @param end the upper bound of the range of employee promotions (not inclusive)
	 * @return the range of matching employee promotions
	 */
	public static List<EmployeePromotion> findByGradeModeId(
		long gradeModeId, int start, int end) {

		return getPersistence().findByGradeModeId(gradeModeId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee promotions where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee promotions
	 * @param end the upper bound of the range of employee promotions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee promotions
	 */
	public static List<EmployeePromotion> findByGradeModeId(
		long gradeModeId, int start, int end,
		OrderByComparator<EmployeePromotion> orderByComparator) {

		return getPersistence().findByGradeModeId(
			gradeModeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee promotions where gradeModeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionModelImpl</code>.
	 * </p>
	 *
	 * @param gradeModeId the grade mode ID
	 * @param start the lower bound of the range of employee promotions
	 * @param end the upper bound of the range of employee promotions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee promotions
	 */
	public static List<EmployeePromotion> findByGradeModeId(
		long gradeModeId, int start, int end,
		OrderByComparator<EmployeePromotion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGradeModeId(
			gradeModeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee promotion in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee promotion
	 * @throws NoSuchEmployeePromotionException if a matching employee promotion could not be found
	 */
	public static EmployeePromotion findByGradeModeId_First(
			long gradeModeId,
			OrderByComparator<EmployeePromotion> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePromotionException {

		return getPersistence().findByGradeModeId_First(
			gradeModeId, orderByComparator);
	}

	/**
	 * Returns the first employee promotion in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee promotion, or <code>null</code> if a matching employee promotion could not be found
	 */
	public static EmployeePromotion fetchByGradeModeId_First(
		long gradeModeId,
		OrderByComparator<EmployeePromotion> orderByComparator) {

		return getPersistence().fetchByGradeModeId_First(
			gradeModeId, orderByComparator);
	}

	/**
	 * Returns the last employee promotion in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee promotion
	 * @throws NoSuchEmployeePromotionException if a matching employee promotion could not be found
	 */
	public static EmployeePromotion findByGradeModeId_Last(
			long gradeModeId,
			OrderByComparator<EmployeePromotion> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePromotionException {

		return getPersistence().findByGradeModeId_Last(
			gradeModeId, orderByComparator);
	}

	/**
	 * Returns the last employee promotion in the ordered set where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee promotion, or <code>null</code> if a matching employee promotion could not be found
	 */
	public static EmployeePromotion fetchByGradeModeId_Last(
		long gradeModeId,
		OrderByComparator<EmployeePromotion> orderByComparator) {

		return getPersistence().fetchByGradeModeId_Last(
			gradeModeId, orderByComparator);
	}

	/**
	 * Returns the employee promotions before and after the current employee promotion in the ordered set where gradeModeId = &#63;.
	 *
	 * @param employeePromotionId the primary key of the current employee promotion
	 * @param gradeModeId the grade mode ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee promotion
	 * @throws NoSuchEmployeePromotionException if a employee promotion with the primary key could not be found
	 */
	public static EmployeePromotion[] findByGradeModeId_PrevAndNext(
			long employeePromotionId, long gradeModeId,
			OrderByComparator<EmployeePromotion> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePromotionException {

		return getPersistence().findByGradeModeId_PrevAndNext(
			employeePromotionId, gradeModeId, orderByComparator);
	}

	/**
	 * Removes all the employee promotions where gradeModeId = &#63; from the database.
	 *
	 * @param gradeModeId the grade mode ID
	 */
	public static void removeByGradeModeId(long gradeModeId) {
		getPersistence().removeByGradeModeId(gradeModeId);
	}

	/**
	 * Returns the number of employee promotions where gradeModeId = &#63;.
	 *
	 * @param gradeModeId the grade mode ID
	 * @return the number of matching employee promotions
	 */
	public static int countByGradeModeId(long gradeModeId) {
		return getPersistence().countByGradeModeId(gradeModeId);
	}

	/**
	 * Returns all the employee promotions where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employee promotions
	 */
	public static List<EmployeePromotion> findByEmployeeId(long employeeId) {
		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	 * Returns a range of all the employee promotions where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee promotions
	 * @param end the upper bound of the range of employee promotions (not inclusive)
	 * @return the range of matching employee promotions
	 */
	public static List<EmployeePromotion> findByEmployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeId(employeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee promotions where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee promotions
	 * @param end the upper bound of the range of employee promotions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee promotions
	 */
	public static List<EmployeePromotion> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeePromotion> orderByComparator) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee promotions where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employee promotions
	 * @param end the upper bound of the range of employee promotions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee promotions
	 */
	public static List<EmployeePromotion> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<EmployeePromotion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee promotion in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee promotion
	 * @throws NoSuchEmployeePromotionException if a matching employee promotion could not be found
	 */
	public static EmployeePromotion findByEmployeeId_First(
			long employeeId,
			OrderByComparator<EmployeePromotion> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePromotionException {

		return getPersistence().findByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first employee promotion in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee promotion, or <code>null</code> if a matching employee promotion could not be found
	 */
	public static EmployeePromotion fetchByEmployeeId_First(
		long employeeId,
		OrderByComparator<EmployeePromotion> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee promotion in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee promotion
	 * @throws NoSuchEmployeePromotionException if a matching employee promotion could not be found
	 */
	public static EmployeePromotion findByEmployeeId_Last(
			long employeeId,
			OrderByComparator<EmployeePromotion> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePromotionException {

		return getPersistence().findByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee promotion in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee promotion, or <code>null</code> if a matching employee promotion could not be found
	 */
	public static EmployeePromotion fetchByEmployeeId_Last(
		long employeeId,
		OrderByComparator<EmployeePromotion> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the employee promotions before and after the current employee promotion in the ordered set where employeeId = &#63;.
	 *
	 * @param employeePromotionId the primary key of the current employee promotion
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee promotion
	 * @throws NoSuchEmployeePromotionException if a employee promotion with the primary key could not be found
	 */
	public static EmployeePromotion[] findByEmployeeId_PrevAndNext(
			long employeePromotionId, long employeeId,
			OrderByComparator<EmployeePromotion> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePromotionException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			employeePromotionId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the employee promotions where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of employee promotions where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employee promotions
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Returns all the employee promotions where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching employee promotions
	 */
	public static List<EmployeePromotion> findByOrganizationId(
		long organizationId) {

		return getPersistence().findByOrganizationId(organizationId);
	}

	/**
	 * Returns a range of all the employee promotions where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee promotions
	 * @param end the upper bound of the range of employee promotions (not inclusive)
	 * @return the range of matching employee promotions
	 */
	public static List<EmployeePromotion> findByOrganizationId(
		long organizationId, int start, int end) {

		return getPersistence().findByOrganizationId(
			organizationId, start, end);
	}

	/**
	 * Returns an ordered range of all the employee promotions where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee promotions
	 * @param end the upper bound of the range of employee promotions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee promotions
	 */
	public static List<EmployeePromotion> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<EmployeePromotion> orderByComparator) {

		return getPersistence().findByOrganizationId(
			organizationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee promotions where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee promotions
	 * @param end the upper bound of the range of employee promotions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee promotions
	 */
	public static List<EmployeePromotion> findByOrganizationId(
		long organizationId, int start, int end,
		OrderByComparator<EmployeePromotion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByOrganizationId(
			organizationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee promotion in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee promotion
	 * @throws NoSuchEmployeePromotionException if a matching employee promotion could not be found
	 */
	public static EmployeePromotion findByOrganizationId_First(
			long organizationId,
			OrderByComparator<EmployeePromotion> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePromotionException {

		return getPersistence().findByOrganizationId_First(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the first employee promotion in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee promotion, or <code>null</code> if a matching employee promotion could not be found
	 */
	public static EmployeePromotion fetchByOrganizationId_First(
		long organizationId,
		OrderByComparator<EmployeePromotion> orderByComparator) {

		return getPersistence().fetchByOrganizationId_First(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the last employee promotion in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee promotion
	 * @throws NoSuchEmployeePromotionException if a matching employee promotion could not be found
	 */
	public static EmployeePromotion findByOrganizationId_Last(
			long organizationId,
			OrderByComparator<EmployeePromotion> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePromotionException {

		return getPersistence().findByOrganizationId_Last(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the last employee promotion in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee promotion, or <code>null</code> if a matching employee promotion could not be found
	 */
	public static EmployeePromotion fetchByOrganizationId_Last(
		long organizationId,
		OrderByComparator<EmployeePromotion> orderByComparator) {

		return getPersistence().fetchByOrganizationId_Last(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the employee promotions before and after the current employee promotion in the ordered set where organizationId = &#63;.
	 *
	 * @param employeePromotionId the primary key of the current employee promotion
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee promotion
	 * @throws NoSuchEmployeePromotionException if a employee promotion with the primary key could not be found
	 */
	public static EmployeePromotion[] findByOrganizationId_PrevAndNext(
			long employeePromotionId, long organizationId,
			OrderByComparator<EmployeePromotion> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePromotionException {

		return getPersistence().findByOrganizationId_PrevAndNext(
			employeePromotionId, organizationId, orderByComparator);
	}

	/**
	 * Removes all the employee promotions where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	public static void removeByOrganizationId(long organizationId) {
		getPersistence().removeByOrganizationId(organizationId);
	}

	/**
	 * Returns the number of employee promotions where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching employee promotions
	 */
	public static int countByOrganizationId(long organizationId) {
		return getPersistence().countByOrganizationId(organizationId);
	}

	/**
	 * Caches the employee promotion in the entity cache if it is enabled.
	 *
	 * @param employeePromotion the employee promotion
	 */
	public static void cacheResult(EmployeePromotion employeePromotion) {
		getPersistence().cacheResult(employeePromotion);
	}

	/**
	 * Caches the employee promotions in the entity cache if it is enabled.
	 *
	 * @param employeePromotions the employee promotions
	 */
	public static void cacheResult(List<EmployeePromotion> employeePromotions) {
		getPersistence().cacheResult(employeePromotions);
	}

	/**
	 * Creates a new employee promotion with the primary key. Does not add the employee promotion to the database.
	 *
	 * @param employeePromotionId the primary key for the new employee promotion
	 * @return the new employee promotion
	 */
	public static EmployeePromotion create(long employeePromotionId) {
		return getPersistence().create(employeePromotionId);
	}

	/**
	 * Removes the employee promotion with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeePromotionId the primary key of the employee promotion
	 * @return the employee promotion that was removed
	 * @throws NoSuchEmployeePromotionException if a employee promotion with the primary key could not be found
	 */
	public static EmployeePromotion remove(long employeePromotionId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePromotionException {

		return getPersistence().remove(employeePromotionId);
	}

	public static EmployeePromotion updateImpl(
		EmployeePromotion employeePromotion) {

		return getPersistence().updateImpl(employeePromotion);
	}

	/**
	 * Returns the employee promotion with the primary key or throws a <code>NoSuchEmployeePromotionException</code> if it could not be found.
	 *
	 * @param employeePromotionId the primary key of the employee promotion
	 * @return the employee promotion
	 * @throws NoSuchEmployeePromotionException if a employee promotion with the primary key could not be found
	 */
	public static EmployeePromotion findByPrimaryKey(long employeePromotionId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePromotionException {

		return getPersistence().findByPrimaryKey(employeePromotionId);
	}

	/**
	 * Returns the employee promotion with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeePromotionId the primary key of the employee promotion
	 * @return the employee promotion, or <code>null</code> if a employee promotion with the primary key could not be found
	 */
	public static EmployeePromotion fetchByPrimaryKey(
		long employeePromotionId) {

		return getPersistence().fetchByPrimaryKey(employeePromotionId);
	}

	/**
	 * Returns all the employee promotions.
	 *
	 * @return the employee promotions
	 */
	public static List<EmployeePromotion> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employee promotions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee promotions
	 * @param end the upper bound of the range of employee promotions (not inclusive)
	 * @return the range of employee promotions
	 */
	public static List<EmployeePromotion> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employee promotions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee promotions
	 * @param end the upper bound of the range of employee promotions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee promotions
	 */
	public static List<EmployeePromotion> findAll(
		int start, int end,
		OrderByComparator<EmployeePromotion> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee promotions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeePromotionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee promotions
	 * @param end the upper bound of the range of employee promotions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee promotions
	 */
	public static List<EmployeePromotion> findAll(
		int start, int end,
		OrderByComparator<EmployeePromotion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee promotions from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee promotions.
	 *
	 * @return the number of employee promotions
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeePromotionPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EmployeePromotionPersistence, EmployeePromotionPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EmployeePromotionPersistence.class);

		ServiceTracker
			<EmployeePromotionPersistence, EmployeePromotionPersistence>
				serviceTracker =
					new ServiceTracker
						<EmployeePromotionPersistence,
						 EmployeePromotionPersistence>(
							 bundle.getBundleContext(),
							 EmployeePromotionPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}