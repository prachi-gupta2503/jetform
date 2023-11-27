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

import com.adjecti.mdm.liferay.model.OrganizationDetail;

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
 * The persistence utility for the organization detail service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.OrganizationDetailPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationDetailPersistence
 * @generated
 */
public class OrganizationDetailUtil {

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
	public static void clearCache(OrganizationDetail organizationDetail) {
		getPersistence().clearCache(organizationDetail);
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
	public static Map<Serializable, OrganizationDetail> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<OrganizationDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OrganizationDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OrganizationDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static OrganizationDetail update(
		OrganizationDetail organizationDetail) {

		return getPersistence().update(organizationDetail);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static OrganizationDetail update(
		OrganizationDetail organizationDetail, ServiceContext serviceContext) {

		return getPersistence().update(organizationDetail, serviceContext);
	}

	/**
	 * Returns all the organization details where shortName = &#63; and type = &#63;.
	 *
	 * @param shortName the short name
	 * @param type the type
	 * @return the matching organization details
	 */
	public static List<OrganizationDetail> findByShortNameAndType(
		String shortName, String type) {

		return getPersistence().findByShortNameAndType(shortName, type);
	}

	/**
	 * Returns a range of all the organization details where shortName = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param shortName the short name
	 * @param type the type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	public static List<OrganizationDetail> findByShortNameAndType(
		String shortName, String type, int start, int end) {

		return getPersistence().findByShortNameAndType(
			shortName, type, start, end);
	}

	/**
	 * Returns an ordered range of all the organization details where shortName = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param shortName the short name
	 * @param type the type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	public static List<OrganizationDetail> findByShortNameAndType(
		String shortName, String type, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().findByShortNameAndType(
			shortName, type, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the organization details where shortName = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param shortName the short name
	 * @param type the type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	public static List<OrganizationDetail> findByShortNameAndType(
		String shortName, String type, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByShortNameAndType(
			shortName, type, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first organization detail in the ordered set where shortName = &#63; and type = &#63;.
	 *
	 * @param shortName the short name
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public static OrganizationDetail findByShortNameAndType_First(
			String shortName, String type,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByShortNameAndType_First(
			shortName, type, orderByComparator);
	}

	/**
	 * Returns the first organization detail in the ordered set where shortName = &#63; and type = &#63;.
	 *
	 * @param shortName the short name
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public static OrganizationDetail fetchByShortNameAndType_First(
		String shortName, String type,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().fetchByShortNameAndType_First(
			shortName, type, orderByComparator);
	}

	/**
	 * Returns the last organization detail in the ordered set where shortName = &#63; and type = &#63;.
	 *
	 * @param shortName the short name
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public static OrganizationDetail findByShortNameAndType_Last(
			String shortName, String type,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByShortNameAndType_Last(
			shortName, type, orderByComparator);
	}

	/**
	 * Returns the last organization detail in the ordered set where shortName = &#63; and type = &#63;.
	 *
	 * @param shortName the short name
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public static OrganizationDetail fetchByShortNameAndType_Last(
		String shortName, String type,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().fetchByShortNameAndType_Last(
			shortName, type, orderByComparator);
	}

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where shortName = &#63; and type = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param shortName the short name
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	public static OrganizationDetail[] findByShortNameAndType_PrevAndNext(
			long organizationDetailId, String shortName, String type,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByShortNameAndType_PrevAndNext(
			organizationDetailId, shortName, type, orderByComparator);
	}

	/**
	 * Removes all the organization details where shortName = &#63; and type = &#63; from the database.
	 *
	 * @param shortName the short name
	 * @param type the type
	 */
	public static void removeByShortNameAndType(String shortName, String type) {
		getPersistence().removeByShortNameAndType(shortName, type);
	}

	/**
	 * Returns the number of organization details where shortName = &#63; and type = &#63;.
	 *
	 * @param shortName the short name
	 * @param type the type
	 * @return the number of matching organization details
	 */
	public static int countByShortNameAndType(String shortName, String type) {
		return getPersistence().countByShortNameAndType(shortName, type);
	}

	/**
	 * Returns all the organization details where organizationCode = &#63; and type = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param type the type
	 * @return the matching organization details
	 */
	public static List<OrganizationDetail> findByOrganizationCodeAndType(
		String organizationCode, String type) {

		return getPersistence().findByOrganizationCodeAndType(
			organizationCode, type);
	}

	/**
	 * Returns a range of all the organization details where organizationCode = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param organizationCode the organization code
	 * @param type the type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	public static List<OrganizationDetail> findByOrganizationCodeAndType(
		String organizationCode, String type, int start, int end) {

		return getPersistence().findByOrganizationCodeAndType(
			organizationCode, type, start, end);
	}

	/**
	 * Returns an ordered range of all the organization details where organizationCode = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param organizationCode the organization code
	 * @param type the type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	public static List<OrganizationDetail> findByOrganizationCodeAndType(
		String organizationCode, String type, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().findByOrganizationCodeAndType(
			organizationCode, type, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the organization details where organizationCode = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param organizationCode the organization code
	 * @param type the type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	public static List<OrganizationDetail> findByOrganizationCodeAndType(
		String organizationCode, String type, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByOrganizationCodeAndType(
			organizationCode, type, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first organization detail in the ordered set where organizationCode = &#63; and type = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public static OrganizationDetail findByOrganizationCodeAndType_First(
			String organizationCode, String type,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByOrganizationCodeAndType_First(
			organizationCode, type, orderByComparator);
	}

	/**
	 * Returns the first organization detail in the ordered set where organizationCode = &#63; and type = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public static OrganizationDetail fetchByOrganizationCodeAndType_First(
		String organizationCode, String type,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().fetchByOrganizationCodeAndType_First(
			organizationCode, type, orderByComparator);
	}

	/**
	 * Returns the last organization detail in the ordered set where organizationCode = &#63; and type = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public static OrganizationDetail findByOrganizationCodeAndType_Last(
			String organizationCode, String type,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByOrganizationCodeAndType_Last(
			organizationCode, type, orderByComparator);
	}

	/**
	 * Returns the last organization detail in the ordered set where organizationCode = &#63; and type = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public static OrganizationDetail fetchByOrganizationCodeAndType_Last(
		String organizationCode, String type,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().fetchByOrganizationCodeAndType_Last(
			organizationCode, type, orderByComparator);
	}

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where organizationCode = &#63; and type = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param organizationCode the organization code
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	public static OrganizationDetail[]
			findByOrganizationCodeAndType_PrevAndNext(
				long organizationDetailId, String organizationCode, String type,
				OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByOrganizationCodeAndType_PrevAndNext(
			organizationDetailId, organizationCode, type, orderByComparator);
	}

	/**
	 * Removes all the organization details where organizationCode = &#63; and type = &#63; from the database.
	 *
	 * @param organizationCode the organization code
	 * @param type the type
	 */
	public static void removeByOrganizationCodeAndType(
		String organizationCode, String type) {

		getPersistence().removeByOrganizationCodeAndType(
			organizationCode, type);
	}

	/**
	 * Returns the number of organization details where organizationCode = &#63; and type = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param type the type
	 * @return the number of matching organization details
	 */
	public static int countByOrganizationCodeAndType(
		String organizationCode, String type) {

		return getPersistence().countByOrganizationCodeAndType(
			organizationCode, type);
	}

	/**
	 * Returns all the organization details where unitType = &#63;.
	 *
	 * @param unitType the unit type
	 * @return the matching organization details
	 */
	public static List<OrganizationDetail> findByunitType(String unitType) {
		return getPersistence().findByunitType(unitType);
	}

	/**
	 * Returns a range of all the organization details where unitType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param unitType the unit type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	public static List<OrganizationDetail> findByunitType(
		String unitType, int start, int end) {

		return getPersistence().findByunitType(unitType, start, end);
	}

	/**
	 * Returns an ordered range of all the organization details where unitType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param unitType the unit type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	public static List<OrganizationDetail> findByunitType(
		String unitType, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().findByunitType(
			unitType, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the organization details where unitType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param unitType the unit type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	public static List<OrganizationDetail> findByunitType(
		String unitType, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByunitType(
			unitType, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first organization detail in the ordered set where unitType = &#63;.
	 *
	 * @param unitType the unit type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public static OrganizationDetail findByunitType_First(
			String unitType,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByunitType_First(
			unitType, orderByComparator);
	}

	/**
	 * Returns the first organization detail in the ordered set where unitType = &#63;.
	 *
	 * @param unitType the unit type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public static OrganizationDetail fetchByunitType_First(
		String unitType,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().fetchByunitType_First(
			unitType, orderByComparator);
	}

	/**
	 * Returns the last organization detail in the ordered set where unitType = &#63;.
	 *
	 * @param unitType the unit type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public static OrganizationDetail findByunitType_Last(
			String unitType,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByunitType_Last(
			unitType, orderByComparator);
	}

	/**
	 * Returns the last organization detail in the ordered set where unitType = &#63;.
	 *
	 * @param unitType the unit type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public static OrganizationDetail fetchByunitType_Last(
		String unitType,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().fetchByunitType_Last(
			unitType, orderByComparator);
	}

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where unitType = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param unitType the unit type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	public static OrganizationDetail[] findByunitType_PrevAndNext(
			long organizationDetailId, String unitType,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByunitType_PrevAndNext(
			organizationDetailId, unitType, orderByComparator);
	}

	/**
	 * Removes all the organization details where unitType = &#63; from the database.
	 *
	 * @param unitType the unit type
	 */
	public static void removeByunitType(String unitType) {
		getPersistence().removeByunitType(unitType);
	}

	/**
	 * Returns the number of organization details where unitType = &#63;.
	 *
	 * @param unitType the unit type
	 * @return the number of matching organization details
	 */
	public static int countByunitType(String unitType) {
		return getPersistence().countByunitType(unitType);
	}

	/**
	 * Returns all the organization details where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the matching organization details
	 */
	public static List<OrganizationDetail> findByParentId(long parentId) {
		return getPersistence().findByParentId(parentId);
	}

	/**
	 * Returns a range of all the organization details where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	public static List<OrganizationDetail> findByParentId(
		long parentId, int start, int end) {

		return getPersistence().findByParentId(parentId, start, end);
	}

	/**
	 * Returns an ordered range of all the organization details where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	public static List<OrganizationDetail> findByParentId(
		long parentId, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().findByParentId(
			parentId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the organization details where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	public static List<OrganizationDetail> findByParentId(
		long parentId, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByParentId(
			parentId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first organization detail in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public static OrganizationDetail findByParentId_First(
			long parentId,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByParentId_First(
			parentId, orderByComparator);
	}

	/**
	 * Returns the first organization detail in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public static OrganizationDetail fetchByParentId_First(
		long parentId,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().fetchByParentId_First(
			parentId, orderByComparator);
	}

	/**
	 * Returns the last organization detail in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public static OrganizationDetail findByParentId_Last(
			long parentId,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByParentId_Last(
			parentId, orderByComparator);
	}

	/**
	 * Returns the last organization detail in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public static OrganizationDetail fetchByParentId_Last(
		long parentId,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().fetchByParentId_Last(
			parentId, orderByComparator);
	}

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where parentId = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	public static OrganizationDetail[] findByParentId_PrevAndNext(
			long organizationDetailId, long parentId,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByParentId_PrevAndNext(
			organizationDetailId, parentId, orderByComparator);
	}

	/**
	 * Removes all the organization details where parentId = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 */
	public static void removeByParentId(long parentId) {
		getPersistence().removeByParentId(parentId);
	}

	/**
	 * Returns the number of organization details where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the number of matching organization details
	 */
	public static int countByParentId(long parentId) {
		return getPersistence().countByParentId(parentId);
	}

	/**
	 * Returns all the organization details where parentId = &#63; and type = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param type the type
	 * @return the matching organization details
	 */
	public static List<OrganizationDetail> findByParentIdAndType(
		long parentId, String type) {

		return getPersistence().findByParentIdAndType(parentId, type);
	}

	/**
	 * Returns a range of all the organization details where parentId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param type the type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	public static List<OrganizationDetail> findByParentIdAndType(
		long parentId, String type, int start, int end) {

		return getPersistence().findByParentIdAndType(
			parentId, type, start, end);
	}

	/**
	 * Returns an ordered range of all the organization details where parentId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param type the type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	public static List<OrganizationDetail> findByParentIdAndType(
		long parentId, String type, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().findByParentIdAndType(
			parentId, type, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the organization details where parentId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param type the type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	public static List<OrganizationDetail> findByParentIdAndType(
		long parentId, String type, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByParentIdAndType(
			parentId, type, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first organization detail in the ordered set where parentId = &#63; and type = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public static OrganizationDetail findByParentIdAndType_First(
			long parentId, String type,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByParentIdAndType_First(
			parentId, type, orderByComparator);
	}

	/**
	 * Returns the first organization detail in the ordered set where parentId = &#63; and type = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public static OrganizationDetail fetchByParentIdAndType_First(
		long parentId, String type,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().fetchByParentIdAndType_First(
			parentId, type, orderByComparator);
	}

	/**
	 * Returns the last organization detail in the ordered set where parentId = &#63; and type = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public static OrganizationDetail findByParentIdAndType_Last(
			long parentId, String type,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByParentIdAndType_Last(
			parentId, type, orderByComparator);
	}

	/**
	 * Returns the last organization detail in the ordered set where parentId = &#63; and type = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public static OrganizationDetail fetchByParentIdAndType_Last(
		long parentId, String type,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().fetchByParentIdAndType_Last(
			parentId, type, orderByComparator);
	}

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where parentId = &#63; and type = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param parentId the parent ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	public static OrganizationDetail[] findByParentIdAndType_PrevAndNext(
			long organizationDetailId, long parentId, String type,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByParentIdAndType_PrevAndNext(
			organizationDetailId, parentId, type, orderByComparator);
	}

	/**
	 * Removes all the organization details where parentId = &#63; and type = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 * @param type the type
	 */
	public static void removeByParentIdAndType(long parentId, String type) {
		getPersistence().removeByParentIdAndType(parentId, type);
	}

	/**
	 * Returns the number of organization details where parentId = &#63; and type = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param type the type
	 * @return the number of matching organization details
	 */
	public static int countByParentIdAndType(long parentId, String type) {
		return getPersistence().countByParentIdAndType(parentId, type);
	}

	/**
	 * Returns all the organization details where type = &#63; and parentId = &#63; and organizationCode = &#63;.
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @return the matching organization details
	 */
	public static List<OrganizationDetail>
		findByTypeAndParentIdAndOrganizationCode(
			String type, long parentId, String organizationCode) {

		return getPersistence().findByTypeAndParentIdAndOrganizationCode(
			type, parentId, organizationCode);
	}

	/**
	 * Returns a range of all the organization details where type = &#63; and parentId = &#63; and organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	public static List<OrganizationDetail>
		findByTypeAndParentIdAndOrganizationCode(
			String type, long parentId, String organizationCode, int start,
			int end) {

		return getPersistence().findByTypeAndParentIdAndOrganizationCode(
			type, parentId, organizationCode, start, end);
	}

	/**
	 * Returns an ordered range of all the organization details where type = &#63; and parentId = &#63; and organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	public static List<OrganizationDetail>
		findByTypeAndParentIdAndOrganizationCode(
			String type, long parentId, String organizationCode, int start,
			int end, OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().findByTypeAndParentIdAndOrganizationCode(
			type, parentId, organizationCode, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the organization details where type = &#63; and parentId = &#63; and organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	public static List<OrganizationDetail>
		findByTypeAndParentIdAndOrganizationCode(
			String type, long parentId, String organizationCode, int start,
			int end, OrderByComparator<OrganizationDetail> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByTypeAndParentIdAndOrganizationCode(
			type, parentId, organizationCode, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first organization detail in the ordered set where type = &#63; and parentId = &#63; and organizationCode = &#63;.
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public static OrganizationDetail
			findByTypeAndParentIdAndOrganizationCode_First(
				String type, long parentId, String organizationCode,
				OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByTypeAndParentIdAndOrganizationCode_First(
			type, parentId, organizationCode, orderByComparator);
	}

	/**
	 * Returns the first organization detail in the ordered set where type = &#63; and parentId = &#63; and organizationCode = &#63;.
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public static OrganizationDetail
		fetchByTypeAndParentIdAndOrganizationCode_First(
			String type, long parentId, String organizationCode,
			OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().fetchByTypeAndParentIdAndOrganizationCode_First(
			type, parentId, organizationCode, orderByComparator);
	}

	/**
	 * Returns the last organization detail in the ordered set where type = &#63; and parentId = &#63; and organizationCode = &#63;.
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public static OrganizationDetail
			findByTypeAndParentIdAndOrganizationCode_Last(
				String type, long parentId, String organizationCode,
				OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByTypeAndParentIdAndOrganizationCode_Last(
			type, parentId, organizationCode, orderByComparator);
	}

	/**
	 * Returns the last organization detail in the ordered set where type = &#63; and parentId = &#63; and organizationCode = &#63;.
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public static OrganizationDetail
		fetchByTypeAndParentIdAndOrganizationCode_Last(
			String type, long parentId, String organizationCode,
			OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().fetchByTypeAndParentIdAndOrganizationCode_Last(
			type, parentId, organizationCode, orderByComparator);
	}

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where type = &#63; and parentId = &#63; and organizationCode = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param type the type
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	public static OrganizationDetail[]
			findByTypeAndParentIdAndOrganizationCode_PrevAndNext(
				long organizationDetailId, String type, long parentId,
				String organizationCode,
				OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().
			findByTypeAndParentIdAndOrganizationCode_PrevAndNext(
				organizationDetailId, type, parentId, organizationCode,
				orderByComparator);
	}

	/**
	 * Removes all the organization details where type = &#63; and parentId = &#63; and organizationCode = &#63; from the database.
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 */
	public static void removeByTypeAndParentIdAndOrganizationCode(
		String type, long parentId, String organizationCode) {

		getPersistence().removeByTypeAndParentIdAndOrganizationCode(
			type, parentId, organizationCode);
	}

	/**
	 * Returns the number of organization details where type = &#63; and parentId = &#63; and organizationCode = &#63;.
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @return the number of matching organization details
	 */
	public static int countByTypeAndParentIdAndOrganizationCode(
		String type, long parentId, String organizationCode) {

		return getPersistence().countByTypeAndParentIdAndOrganizationCode(
			type, parentId, organizationCode);
	}

	/**
	 * Returns all the organization details where type = &#63; and parentId = &#63; and shortName = &#63;.
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @return the matching organization details
	 */
	public static List<OrganizationDetail> findByTypeAndParentIdAndShortName(
		String type, long parentId, String shortName) {

		return getPersistence().findByTypeAndParentIdAndShortName(
			type, parentId, shortName);
	}

	/**
	 * Returns a range of all the organization details where type = &#63; and parentId = &#63; and shortName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	public static List<OrganizationDetail> findByTypeAndParentIdAndShortName(
		String type, long parentId, String shortName, int start, int end) {

		return getPersistence().findByTypeAndParentIdAndShortName(
			type, parentId, shortName, start, end);
	}

	/**
	 * Returns an ordered range of all the organization details where type = &#63; and parentId = &#63; and shortName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	public static List<OrganizationDetail> findByTypeAndParentIdAndShortName(
		String type, long parentId, String shortName, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().findByTypeAndParentIdAndShortName(
			type, parentId, shortName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the organization details where type = &#63; and parentId = &#63; and shortName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	public static List<OrganizationDetail> findByTypeAndParentIdAndShortName(
		String type, long parentId, String shortName, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTypeAndParentIdAndShortName(
			type, parentId, shortName, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first organization detail in the ordered set where type = &#63; and parentId = &#63; and shortName = &#63;.
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public static OrganizationDetail findByTypeAndParentIdAndShortName_First(
			String type, long parentId, String shortName,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByTypeAndParentIdAndShortName_First(
			type, parentId, shortName, orderByComparator);
	}

	/**
	 * Returns the first organization detail in the ordered set where type = &#63; and parentId = &#63; and shortName = &#63;.
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public static OrganizationDetail fetchByTypeAndParentIdAndShortName_First(
		String type, long parentId, String shortName,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().fetchByTypeAndParentIdAndShortName_First(
			type, parentId, shortName, orderByComparator);
	}

	/**
	 * Returns the last organization detail in the ordered set where type = &#63; and parentId = &#63; and shortName = &#63;.
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public static OrganizationDetail findByTypeAndParentIdAndShortName_Last(
			String type, long parentId, String shortName,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByTypeAndParentIdAndShortName_Last(
			type, parentId, shortName, orderByComparator);
	}

	/**
	 * Returns the last organization detail in the ordered set where type = &#63; and parentId = &#63; and shortName = &#63;.
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public static OrganizationDetail fetchByTypeAndParentIdAndShortName_Last(
		String type, long parentId, String shortName,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().fetchByTypeAndParentIdAndShortName_Last(
			type, parentId, shortName, orderByComparator);
	}

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where type = &#63; and parentId = &#63; and shortName = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param type the type
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	public static OrganizationDetail[]
			findByTypeAndParentIdAndShortName_PrevAndNext(
				long organizationDetailId, String type, long parentId,
				String shortName,
				OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByTypeAndParentIdAndShortName_PrevAndNext(
			organizationDetailId, type, parentId, shortName, orderByComparator);
	}

	/**
	 * Removes all the organization details where type = &#63; and parentId = &#63; and shortName = &#63; from the database.
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param shortName the short name
	 */
	public static void removeByTypeAndParentIdAndShortName(
		String type, long parentId, String shortName) {

		getPersistence().removeByTypeAndParentIdAndShortName(
			type, parentId, shortName);
	}

	/**
	 * Returns the number of organization details where type = &#63; and parentId = &#63; and shortName = &#63;.
	 *
	 * @param type the type
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @return the number of matching organization details
	 */
	public static int countByTypeAndParentIdAndShortName(
		String type, long parentId, String shortName) {

		return getPersistence().countByTypeAndParentIdAndShortName(
			type, parentId, shortName);
	}

	/**
	 * Returns all the organization details where parentCode = &#63;.
	 *
	 * @param parentCode the parent code
	 * @return the matching organization details
	 */
	public static List<OrganizationDetail> findByParentCode(String parentCode) {
		return getPersistence().findByParentCode(parentCode);
	}

	/**
	 * Returns a range of all the organization details where parentCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentCode the parent code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	public static List<OrganizationDetail> findByParentCode(
		String parentCode, int start, int end) {

		return getPersistence().findByParentCode(parentCode, start, end);
	}

	/**
	 * Returns an ordered range of all the organization details where parentCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentCode the parent code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	public static List<OrganizationDetail> findByParentCode(
		String parentCode, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().findByParentCode(
			parentCode, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the organization details where parentCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentCode the parent code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	public static List<OrganizationDetail> findByParentCode(
		String parentCode, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByParentCode(
			parentCode, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first organization detail in the ordered set where parentCode = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public static OrganizationDetail findByParentCode_First(
			String parentCode,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByParentCode_First(
			parentCode, orderByComparator);
	}

	/**
	 * Returns the first organization detail in the ordered set where parentCode = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public static OrganizationDetail fetchByParentCode_First(
		String parentCode,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().fetchByParentCode_First(
			parentCode, orderByComparator);
	}

	/**
	 * Returns the last organization detail in the ordered set where parentCode = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public static OrganizationDetail findByParentCode_Last(
			String parentCode,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByParentCode_Last(
			parentCode, orderByComparator);
	}

	/**
	 * Returns the last organization detail in the ordered set where parentCode = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public static OrganizationDetail fetchByParentCode_Last(
		String parentCode,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().fetchByParentCode_Last(
			parentCode, orderByComparator);
	}

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where parentCode = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param parentCode the parent code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	public static OrganizationDetail[] findByParentCode_PrevAndNext(
			long organizationDetailId, String parentCode,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByParentCode_PrevAndNext(
			organizationDetailId, parentCode, orderByComparator);
	}

	/**
	 * Removes all the organization details where parentCode = &#63; from the database.
	 *
	 * @param parentCode the parent code
	 */
	public static void removeByParentCode(String parentCode) {
		getPersistence().removeByParentCode(parentCode);
	}

	/**
	 * Returns the number of organization details where parentCode = &#63;.
	 *
	 * @param parentCode the parent code
	 * @return the number of matching organization details
	 */
	public static int countByParentCode(String parentCode) {
		return getPersistence().countByParentCode(parentCode);
	}

	/**
	 * Returns the organization detail where organizationId = &#63; or throws a <code>NoSuchOrganizationDetailException</code> if it could not be found.
	 *
	 * @param organizationId the organization ID
	 * @return the matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public static OrganizationDetail findByOrganizationId(long organizationId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByOrganizationId(organizationId);
	}

	/**
	 * Returns the organization detail where organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param organizationId the organization ID
	 * @return the matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public static OrganizationDetail fetchByOrganizationId(
		long organizationId) {

		return getPersistence().fetchByOrganizationId(organizationId);
	}

	/**
	 * Returns the organization detail where organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param organizationId the organization ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public static OrganizationDetail fetchByOrganizationId(
		long organizationId, boolean useFinderCache) {

		return getPersistence().fetchByOrganizationId(
			organizationId, useFinderCache);
	}

	/**
	 * Removes the organization detail where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @return the organization detail that was removed
	 */
	public static OrganizationDetail removeByOrganizationId(long organizationId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().removeByOrganizationId(organizationId);
	}

	/**
	 * Returns the number of organization details where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching organization details
	 */
	public static int countByOrganizationId(long organizationId) {
		return getPersistence().countByOrganizationId(organizationId);
	}

	/**
	 * Returns all the organization details where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @return the matching organization details
	 */
	public static List<OrganizationDetail> findByOrganizationCode(
		String organizationCode) {

		return getPersistence().findByOrganizationCode(organizationCode);
	}

	/**
	 * Returns a range of all the organization details where organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	public static List<OrganizationDetail> findByOrganizationCode(
		String organizationCode, int start, int end) {

		return getPersistence().findByOrganizationCode(
			organizationCode, start, end);
	}

	/**
	 * Returns an ordered range of all the organization details where organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	public static List<OrganizationDetail> findByOrganizationCode(
		String organizationCode, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().findByOrganizationCode(
			organizationCode, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the organization details where organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	public static List<OrganizationDetail> findByOrganizationCode(
		String organizationCode, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByOrganizationCode(
			organizationCode, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first organization detail in the ordered set where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public static OrganizationDetail findByOrganizationCode_First(
			String organizationCode,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByOrganizationCode_First(
			organizationCode, orderByComparator);
	}

	/**
	 * Returns the first organization detail in the ordered set where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public static OrganizationDetail fetchByOrganizationCode_First(
		String organizationCode,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().fetchByOrganizationCode_First(
			organizationCode, orderByComparator);
	}

	/**
	 * Returns the last organization detail in the ordered set where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public static OrganizationDetail findByOrganizationCode_Last(
			String organizationCode,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByOrganizationCode_Last(
			organizationCode, orderByComparator);
	}

	/**
	 * Returns the last organization detail in the ordered set where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public static OrganizationDetail fetchByOrganizationCode_Last(
		String organizationCode,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().fetchByOrganizationCode_Last(
			organizationCode, orderByComparator);
	}

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where organizationCode = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	public static OrganizationDetail[] findByOrganizationCode_PrevAndNext(
			long organizationDetailId, String organizationCode,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByOrganizationCode_PrevAndNext(
			organizationDetailId, organizationCode, orderByComparator);
	}

	/**
	 * Removes all the organization details where organizationCode = &#63; from the database.
	 *
	 * @param organizationCode the organization code
	 */
	public static void removeByOrganizationCode(String organizationCode) {
		getPersistence().removeByOrganizationCode(organizationCode);
	}

	/**
	 * Returns the number of organization details where organizationCode = &#63;.
	 *
	 * @param organizationCode the organization code
	 * @return the number of matching organization details
	 */
	public static int countByOrganizationCode(String organizationCode) {
		return getPersistence().countByOrganizationCode(organizationCode);
	}

	/**
	 * Returns all the organization details where parentCode = &#63; and organizationCode = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param organizationCode the organization code
	 * @return the matching organization details
	 */
	public static List<OrganizationDetail> findByParentCodeAndOrganizationCode(
		String parentCode, String organizationCode) {

		return getPersistence().findByParentCodeAndOrganizationCode(
			parentCode, organizationCode);
	}

	/**
	 * Returns a range of all the organization details where parentCode = &#63; and organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentCode the parent code
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	public static List<OrganizationDetail> findByParentCodeAndOrganizationCode(
		String parentCode, String organizationCode, int start, int end) {

		return getPersistence().findByParentCodeAndOrganizationCode(
			parentCode, organizationCode, start, end);
	}

	/**
	 * Returns an ordered range of all the organization details where parentCode = &#63; and organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentCode the parent code
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	public static List<OrganizationDetail> findByParentCodeAndOrganizationCode(
		String parentCode, String organizationCode, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().findByParentCodeAndOrganizationCode(
			parentCode, organizationCode, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the organization details where parentCode = &#63; and organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentCode the parent code
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	public static List<OrganizationDetail> findByParentCodeAndOrganizationCode(
		String parentCode, String organizationCode, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByParentCodeAndOrganizationCode(
			parentCode, organizationCode, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first organization detail in the ordered set where parentCode = &#63; and organizationCode = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public static OrganizationDetail findByParentCodeAndOrganizationCode_First(
			String parentCode, String organizationCode,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByParentCodeAndOrganizationCode_First(
			parentCode, organizationCode, orderByComparator);
	}

	/**
	 * Returns the first organization detail in the ordered set where parentCode = &#63; and organizationCode = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public static OrganizationDetail fetchByParentCodeAndOrganizationCode_First(
		String parentCode, String organizationCode,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().fetchByParentCodeAndOrganizationCode_First(
			parentCode, organizationCode, orderByComparator);
	}

	/**
	 * Returns the last organization detail in the ordered set where parentCode = &#63; and organizationCode = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public static OrganizationDetail findByParentCodeAndOrganizationCode_Last(
			String parentCode, String organizationCode,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByParentCodeAndOrganizationCode_Last(
			parentCode, organizationCode, orderByComparator);
	}

	/**
	 * Returns the last organization detail in the ordered set where parentCode = &#63; and organizationCode = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public static OrganizationDetail fetchByParentCodeAndOrganizationCode_Last(
		String parentCode, String organizationCode,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().fetchByParentCodeAndOrganizationCode_Last(
			parentCode, organizationCode, orderByComparator);
	}

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where parentCode = &#63; and organizationCode = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param parentCode the parent code
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	public static OrganizationDetail[]
			findByParentCodeAndOrganizationCode_PrevAndNext(
				long organizationDetailId, String parentCode,
				String organizationCode,
				OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByParentCodeAndOrganizationCode_PrevAndNext(
			organizationDetailId, parentCode, organizationCode,
			orderByComparator);
	}

	/**
	 * Removes all the organization details where parentCode = &#63; and organizationCode = &#63; from the database.
	 *
	 * @param parentCode the parent code
	 * @param organizationCode the organization code
	 */
	public static void removeByParentCodeAndOrganizationCode(
		String parentCode, String organizationCode) {

		getPersistence().removeByParentCodeAndOrganizationCode(
			parentCode, organizationCode);
	}

	/**
	 * Returns the number of organization details where parentCode = &#63; and organizationCode = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param organizationCode the organization code
	 * @return the number of matching organization details
	 */
	public static int countByParentCodeAndOrganizationCode(
		String parentCode, String organizationCode) {

		return getPersistence().countByParentCodeAndOrganizationCode(
			parentCode, organizationCode);
	}

	/**
	 * Returns all the organization details where parentCode = &#63; and shortName = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param shortName the short name
	 * @return the matching organization details
	 */
	public static List<OrganizationDetail> findByParentCodeAndShortName(
		String parentCode, String shortName) {

		return getPersistence().findByParentCodeAndShortName(
			parentCode, shortName);
	}

	/**
	 * Returns a range of all the organization details where parentCode = &#63; and shortName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentCode the parent code
	 * @param shortName the short name
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	public static List<OrganizationDetail> findByParentCodeAndShortName(
		String parentCode, String shortName, int start, int end) {

		return getPersistence().findByParentCodeAndShortName(
			parentCode, shortName, start, end);
	}

	/**
	 * Returns an ordered range of all the organization details where parentCode = &#63; and shortName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentCode the parent code
	 * @param shortName the short name
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	public static List<OrganizationDetail> findByParentCodeAndShortName(
		String parentCode, String shortName, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().findByParentCodeAndShortName(
			parentCode, shortName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the organization details where parentCode = &#63; and shortName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentCode the parent code
	 * @param shortName the short name
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	public static List<OrganizationDetail> findByParentCodeAndShortName(
		String parentCode, String shortName, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByParentCodeAndShortName(
			parentCode, shortName, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first organization detail in the ordered set where parentCode = &#63; and shortName = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public static OrganizationDetail findByParentCodeAndShortName_First(
			String parentCode, String shortName,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByParentCodeAndShortName_First(
			parentCode, shortName, orderByComparator);
	}

	/**
	 * Returns the first organization detail in the ordered set where parentCode = &#63; and shortName = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public static OrganizationDetail fetchByParentCodeAndShortName_First(
		String parentCode, String shortName,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().fetchByParentCodeAndShortName_First(
			parentCode, shortName, orderByComparator);
	}

	/**
	 * Returns the last organization detail in the ordered set where parentCode = &#63; and shortName = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public static OrganizationDetail findByParentCodeAndShortName_Last(
			String parentCode, String shortName,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByParentCodeAndShortName_Last(
			parentCode, shortName, orderByComparator);
	}

	/**
	 * Returns the last organization detail in the ordered set where parentCode = &#63; and shortName = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public static OrganizationDetail fetchByParentCodeAndShortName_Last(
		String parentCode, String shortName,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().fetchByParentCodeAndShortName_Last(
			parentCode, shortName, orderByComparator);
	}

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where parentCode = &#63; and shortName = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param parentCode the parent code
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	public static OrganizationDetail[] findByParentCodeAndShortName_PrevAndNext(
			long organizationDetailId, String parentCode, String shortName,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByParentCodeAndShortName_PrevAndNext(
			organizationDetailId, parentCode, shortName, orderByComparator);
	}

	/**
	 * Removes all the organization details where parentCode = &#63; and shortName = &#63; from the database.
	 *
	 * @param parentCode the parent code
	 * @param shortName the short name
	 */
	public static void removeByParentCodeAndShortName(
		String parentCode, String shortName) {

		getPersistence().removeByParentCodeAndShortName(parentCode, shortName);
	}

	/**
	 * Returns the number of organization details where parentCode = &#63; and shortName = &#63;.
	 *
	 * @param parentCode the parent code
	 * @param shortName the short name
	 * @return the number of matching organization details
	 */
	public static int countByParentCodeAndShortName(
		String parentCode, String shortName) {

		return getPersistence().countByParentCodeAndShortName(
			parentCode, shortName);
	}

	/**
	 * Returns all the organization details where parentId = &#63; and organizationCode = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @return the matching organization details
	 */
	public static List<OrganizationDetail> findByParentIdAndOrganizationCode(
		long parentId, String organizationCode) {

		return getPersistence().findByParentIdAndOrganizationCode(
			parentId, organizationCode);
	}

	/**
	 * Returns a range of all the organization details where parentId = &#63; and organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	public static List<OrganizationDetail> findByParentIdAndOrganizationCode(
		long parentId, String organizationCode, int start, int end) {

		return getPersistence().findByParentIdAndOrganizationCode(
			parentId, organizationCode, start, end);
	}

	/**
	 * Returns an ordered range of all the organization details where parentId = &#63; and organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	public static List<OrganizationDetail> findByParentIdAndOrganizationCode(
		long parentId, String organizationCode, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().findByParentIdAndOrganizationCode(
			parentId, organizationCode, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the organization details where parentId = &#63; and organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	public static List<OrganizationDetail> findByParentIdAndOrganizationCode(
		long parentId, String organizationCode, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByParentIdAndOrganizationCode(
			parentId, organizationCode, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first organization detail in the ordered set where parentId = &#63; and organizationCode = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public static OrganizationDetail findByParentIdAndOrganizationCode_First(
			long parentId, String organizationCode,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByParentIdAndOrganizationCode_First(
			parentId, organizationCode, orderByComparator);
	}

	/**
	 * Returns the first organization detail in the ordered set where parentId = &#63; and organizationCode = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public static OrganizationDetail fetchByParentIdAndOrganizationCode_First(
		long parentId, String organizationCode,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().fetchByParentIdAndOrganizationCode_First(
			parentId, organizationCode, orderByComparator);
	}

	/**
	 * Returns the last organization detail in the ordered set where parentId = &#63; and organizationCode = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public static OrganizationDetail findByParentIdAndOrganizationCode_Last(
			long parentId, String organizationCode,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByParentIdAndOrganizationCode_Last(
			parentId, organizationCode, orderByComparator);
	}

	/**
	 * Returns the last organization detail in the ordered set where parentId = &#63; and organizationCode = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public static OrganizationDetail fetchByParentIdAndOrganizationCode_Last(
		long parentId, String organizationCode,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().fetchByParentIdAndOrganizationCode_Last(
			parentId, organizationCode, orderByComparator);
	}

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where parentId = &#63; and organizationCode = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	public static OrganizationDetail[]
			findByParentIdAndOrganizationCode_PrevAndNext(
				long organizationDetailId, long parentId,
				String organizationCode,
				OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByParentIdAndOrganizationCode_PrevAndNext(
			organizationDetailId, parentId, organizationCode,
			orderByComparator);
	}

	/**
	 * Removes all the organization details where parentId = &#63; and organizationCode = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 */
	public static void removeByParentIdAndOrganizationCode(
		long parentId, String organizationCode) {

		getPersistence().removeByParentIdAndOrganizationCode(
			parentId, organizationCode);
	}

	/**
	 * Returns the number of organization details where parentId = &#63; and organizationCode = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param organizationCode the organization code
	 * @return the number of matching organization details
	 */
	public static int countByParentIdAndOrganizationCode(
		long parentId, String organizationCode) {

		return getPersistence().countByParentIdAndOrganizationCode(
			parentId, organizationCode);
	}

	/**
	 * Returns all the organization details where parentId = &#63; and shortName = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @return the matching organization details
	 */
	public static List<OrganizationDetail> findByParentIdAndShortName(
		long parentId, String shortName) {

		return getPersistence().findByParentIdAndShortName(parentId, shortName);
	}

	/**
	 * Returns a range of all the organization details where parentId = &#63; and shortName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	public static List<OrganizationDetail> findByParentIdAndShortName(
		long parentId, String shortName, int start, int end) {

		return getPersistence().findByParentIdAndShortName(
			parentId, shortName, start, end);
	}

	/**
	 * Returns an ordered range of all the organization details where parentId = &#63; and shortName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	public static List<OrganizationDetail> findByParentIdAndShortName(
		long parentId, String shortName, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().findByParentIdAndShortName(
			parentId, shortName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the organization details where parentId = &#63; and shortName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	public static List<OrganizationDetail> findByParentIdAndShortName(
		long parentId, String shortName, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByParentIdAndShortName(
			parentId, shortName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first organization detail in the ordered set where parentId = &#63; and shortName = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public static OrganizationDetail findByParentIdAndShortName_First(
			long parentId, String shortName,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByParentIdAndShortName_First(
			parentId, shortName, orderByComparator);
	}

	/**
	 * Returns the first organization detail in the ordered set where parentId = &#63; and shortName = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public static OrganizationDetail fetchByParentIdAndShortName_First(
		long parentId, String shortName,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().fetchByParentIdAndShortName_First(
			parentId, shortName, orderByComparator);
	}

	/**
	 * Returns the last organization detail in the ordered set where parentId = &#63; and shortName = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public static OrganizationDetail findByParentIdAndShortName_Last(
			long parentId, String shortName,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByParentIdAndShortName_Last(
			parentId, shortName, orderByComparator);
	}

	/**
	 * Returns the last organization detail in the ordered set where parentId = &#63; and shortName = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public static OrganizationDetail fetchByParentIdAndShortName_Last(
		long parentId, String shortName,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().fetchByParentIdAndShortName_Last(
			parentId, shortName, orderByComparator);
	}

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where parentId = &#63; and shortName = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	public static OrganizationDetail[] findByParentIdAndShortName_PrevAndNext(
			long organizationDetailId, long parentId, String shortName,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByParentIdAndShortName_PrevAndNext(
			organizationDetailId, parentId, shortName, orderByComparator);
	}

	/**
	 * Removes all the organization details where parentId = &#63; and shortName = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 * @param shortName the short name
	 */
	public static void removeByParentIdAndShortName(
		long parentId, String shortName) {

		getPersistence().removeByParentIdAndShortName(parentId, shortName);
	}

	/**
	 * Returns the number of organization details where parentId = &#63; and shortName = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param shortName the short name
	 * @return the number of matching organization details
	 */
	public static int countByParentIdAndShortName(
		long parentId, String shortName) {

		return getPersistence().countByParentIdAndShortName(
			parentId, shortName);
	}

	/**
	 * Returns all the organization details where shortName = &#63;.
	 *
	 * @param shortName the short name
	 * @return the matching organization details
	 */
	public static List<OrganizationDetail> findByShortName(String shortName) {
		return getPersistence().findByShortName(shortName);
	}

	/**
	 * Returns a range of all the organization details where shortName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param shortName the short name
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	public static List<OrganizationDetail> findByShortName(
		String shortName, int start, int end) {

		return getPersistence().findByShortName(shortName, start, end);
	}

	/**
	 * Returns an ordered range of all the organization details where shortName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param shortName the short name
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	public static List<OrganizationDetail> findByShortName(
		String shortName, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().findByShortName(
			shortName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the organization details where shortName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param shortName the short name
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	public static List<OrganizationDetail> findByShortName(
		String shortName, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByShortName(
			shortName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first organization detail in the ordered set where shortName = &#63;.
	 *
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public static OrganizationDetail findByShortName_First(
			String shortName,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByShortName_First(
			shortName, orderByComparator);
	}

	/**
	 * Returns the first organization detail in the ordered set where shortName = &#63;.
	 *
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public static OrganizationDetail fetchByShortName_First(
		String shortName,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().fetchByShortName_First(
			shortName, orderByComparator);
	}

	/**
	 * Returns the last organization detail in the ordered set where shortName = &#63;.
	 *
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public static OrganizationDetail findByShortName_Last(
			String shortName,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByShortName_Last(
			shortName, orderByComparator);
	}

	/**
	 * Returns the last organization detail in the ordered set where shortName = &#63;.
	 *
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public static OrganizationDetail fetchByShortName_Last(
		String shortName,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().fetchByShortName_Last(
			shortName, orderByComparator);
	}

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where shortName = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param shortName the short name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	public static OrganizationDetail[] findByShortName_PrevAndNext(
			long organizationDetailId, String shortName,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByShortName_PrevAndNext(
			organizationDetailId, shortName, orderByComparator);
	}

	/**
	 * Removes all the organization details where shortName = &#63; from the database.
	 *
	 * @param shortName the short name
	 */
	public static void removeByShortName(String shortName) {
		getPersistence().removeByShortName(shortName);
	}

	/**
	 * Returns the number of organization details where shortName = &#63;.
	 *
	 * @param shortName the short name
	 * @return the number of matching organization details
	 */
	public static int countByShortName(String shortName) {
		return getPersistence().countByShortName(shortName);
	}

	/**
	 * Returns all the organization details where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching organization details
	 */
	public static List<OrganizationDetail> findByType(String type) {
		return getPersistence().findByType(type);
	}

	/**
	 * Returns a range of all the organization details where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	public static List<OrganizationDetail> findByType(
		String type, int start, int end) {

		return getPersistence().findByType(type, start, end);
	}

	/**
	 * Returns an ordered range of all the organization details where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	public static List<OrganizationDetail> findByType(
		String type, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().findByType(type, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the organization details where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	public static List<OrganizationDetail> findByType(
		String type, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByType(
			type, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first organization detail in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public static OrganizationDetail findByType_First(
			String type,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByType_First(type, orderByComparator);
	}

	/**
	 * Returns the first organization detail in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public static OrganizationDetail fetchByType_First(
		String type, OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().fetchByType_First(type, orderByComparator);
	}

	/**
	 * Returns the last organization detail in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public static OrganizationDetail findByType_Last(
			String type,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByType_Last(type, orderByComparator);
	}

	/**
	 * Returns the last organization detail in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public static OrganizationDetail fetchByType_Last(
		String type, OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().fetchByType_Last(type, orderByComparator);
	}

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where type = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	public static OrganizationDetail[] findByType_PrevAndNext(
			long organizationDetailId, String type,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByType_PrevAndNext(
			organizationDetailId, type, orderByComparator);
	}

	/**
	 * Removes all the organization details where type = &#63; from the database.
	 *
	 * @param type the type
	 */
	public static void removeByType(String type) {
		getPersistence().removeByType(type);
	}

	/**
	 * Returns the number of organization details where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching organization details
	 */
	public static int countByType(String type) {
		return getPersistence().countByType(type);
	}

	/**
	 * Returns all the organization details where type = &#63; and organizationCode = &#63;.
	 *
	 * @param type the type
	 * @param organizationCode the organization code
	 * @return the matching organization details
	 */
	public static List<OrganizationDetail> findByTypeAndOrganizationCode(
		String type, String organizationCode) {

		return getPersistence().findByTypeAndOrganizationCode(
			type, organizationCode);
	}

	/**
	 * Returns a range of all the organization details where type = &#63; and organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	public static List<OrganizationDetail> findByTypeAndOrganizationCode(
		String type, String organizationCode, int start, int end) {

		return getPersistence().findByTypeAndOrganizationCode(
			type, organizationCode, start, end);
	}

	/**
	 * Returns an ordered range of all the organization details where type = &#63; and organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	public static List<OrganizationDetail> findByTypeAndOrganizationCode(
		String type, String organizationCode, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().findByTypeAndOrganizationCode(
			type, organizationCode, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the organization details where type = &#63; and organizationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param organizationCode the organization code
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	public static List<OrganizationDetail> findByTypeAndOrganizationCode(
		String type, String organizationCode, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTypeAndOrganizationCode(
			type, organizationCode, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first organization detail in the ordered set where type = &#63; and organizationCode = &#63;.
	 *
	 * @param type the type
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public static OrganizationDetail findByTypeAndOrganizationCode_First(
			String type, String organizationCode,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByTypeAndOrganizationCode_First(
			type, organizationCode, orderByComparator);
	}

	/**
	 * Returns the first organization detail in the ordered set where type = &#63; and organizationCode = &#63;.
	 *
	 * @param type the type
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public static OrganizationDetail fetchByTypeAndOrganizationCode_First(
		String type, String organizationCode,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().fetchByTypeAndOrganizationCode_First(
			type, organizationCode, orderByComparator);
	}

	/**
	 * Returns the last organization detail in the ordered set where type = &#63; and organizationCode = &#63;.
	 *
	 * @param type the type
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public static OrganizationDetail findByTypeAndOrganizationCode_Last(
			String type, String organizationCode,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByTypeAndOrganizationCode_Last(
			type, organizationCode, orderByComparator);
	}

	/**
	 * Returns the last organization detail in the ordered set where type = &#63; and organizationCode = &#63;.
	 *
	 * @param type the type
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public static OrganizationDetail fetchByTypeAndOrganizationCode_Last(
		String type, String organizationCode,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().fetchByTypeAndOrganizationCode_Last(
			type, organizationCode, orderByComparator);
	}

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where type = &#63; and organizationCode = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param type the type
	 * @param organizationCode the organization code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	public static OrganizationDetail[]
			findByTypeAndOrganizationCode_PrevAndNext(
				long organizationDetailId, String type, String organizationCode,
				OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByTypeAndOrganizationCode_PrevAndNext(
			organizationDetailId, type, organizationCode, orderByComparator);
	}

	/**
	 * Removes all the organization details where type = &#63; and organizationCode = &#63; from the database.
	 *
	 * @param type the type
	 * @param organizationCode the organization code
	 */
	public static void removeByTypeAndOrganizationCode(
		String type, String organizationCode) {

		getPersistence().removeByTypeAndOrganizationCode(
			type, organizationCode);
	}

	/**
	 * Returns the number of organization details where type = &#63; and organizationCode = &#63;.
	 *
	 * @param type the type
	 * @param organizationCode the organization code
	 * @return the number of matching organization details
	 */
	public static int countByTypeAndOrganizationCode(
		String type, String organizationCode) {

		return getPersistence().countByTypeAndOrganizationCode(
			type, organizationCode);
	}

	/**
	 * Returns all the organization details where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @return the matching organization details
	 */
	public static List<OrganizationDetail> findByStateId(long stateId) {
		return getPersistence().findByStateId(stateId);
	}

	/**
	 * Returns a range of all the organization details where stateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param stateId the state ID
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of matching organization details
	 */
	public static List<OrganizationDetail> findByStateId(
		long stateId, int start, int end) {

		return getPersistence().findByStateId(stateId, start, end);
	}

	/**
	 * Returns an ordered range of all the organization details where stateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param stateId the state ID
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organization details
	 */
	public static List<OrganizationDetail> findByStateId(
		long stateId, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().findByStateId(
			stateId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the organization details where stateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param stateId the state ID
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organization details
	 */
	public static List<OrganizationDetail> findByStateId(
		long stateId, int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStateId(
			stateId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first organization detail in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public static OrganizationDetail findByStateId_First(
			long stateId,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByStateId_First(stateId, orderByComparator);
	}

	/**
	 * Returns the first organization detail in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public static OrganizationDetail fetchByStateId_First(
		long stateId, OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().fetchByStateId_First(
			stateId, orderByComparator);
	}

	/**
	 * Returns the last organization detail in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail
	 * @throws NoSuchOrganizationDetailException if a matching organization detail could not be found
	 */
	public static OrganizationDetail findByStateId_Last(
			long stateId,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByStateId_Last(stateId, orderByComparator);
	}

	/**
	 * Returns the last organization detail in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization detail, or <code>null</code> if a matching organization detail could not be found
	 */
	public static OrganizationDetail fetchByStateId_Last(
		long stateId, OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().fetchByStateId_Last(stateId, orderByComparator);
	}

	/**
	 * Returns the organization details before and after the current organization detail in the ordered set where stateId = &#63;.
	 *
	 * @param organizationDetailId the primary key of the current organization detail
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	public static OrganizationDetail[] findByStateId_PrevAndNext(
			long organizationDetailId, long stateId,
			OrderByComparator<OrganizationDetail> orderByComparator)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByStateId_PrevAndNext(
			organizationDetailId, stateId, orderByComparator);
	}

	/**
	 * Removes all the organization details where stateId = &#63; from the database.
	 *
	 * @param stateId the state ID
	 */
	public static void removeByStateId(long stateId) {
		getPersistence().removeByStateId(stateId);
	}

	/**
	 * Returns the number of organization details where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @return the number of matching organization details
	 */
	public static int countByStateId(long stateId) {
		return getPersistence().countByStateId(stateId);
	}

	/**
	 * Caches the organization detail in the entity cache if it is enabled.
	 *
	 * @param organizationDetail the organization detail
	 */
	public static void cacheResult(OrganizationDetail organizationDetail) {
		getPersistence().cacheResult(organizationDetail);
	}

	/**
	 * Caches the organization details in the entity cache if it is enabled.
	 *
	 * @param organizationDetails the organization details
	 */
	public static void cacheResult(
		List<OrganizationDetail> organizationDetails) {

		getPersistence().cacheResult(organizationDetails);
	}

	/**
	 * Creates a new organization detail with the primary key. Does not add the organization detail to the database.
	 *
	 * @param organizationDetailId the primary key for the new organization detail
	 * @return the new organization detail
	 */
	public static OrganizationDetail create(long organizationDetailId) {
		return getPersistence().create(organizationDetailId);
	}

	/**
	 * Removes the organization detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param organizationDetailId the primary key of the organization detail
	 * @return the organization detail that was removed
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	public static OrganizationDetail remove(long organizationDetailId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().remove(organizationDetailId);
	}

	public static OrganizationDetail updateImpl(
		OrganizationDetail organizationDetail) {

		return getPersistence().updateImpl(organizationDetail);
	}

	/**
	 * Returns the organization detail with the primary key or throws a <code>NoSuchOrganizationDetailException</code> if it could not be found.
	 *
	 * @param organizationDetailId the primary key of the organization detail
	 * @return the organization detail
	 * @throws NoSuchOrganizationDetailException if a organization detail with the primary key could not be found
	 */
	public static OrganizationDetail findByPrimaryKey(long organizationDetailId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationDetailException {

		return getPersistence().findByPrimaryKey(organizationDetailId);
	}

	/**
	 * Returns the organization detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param organizationDetailId the primary key of the organization detail
	 * @return the organization detail, or <code>null</code> if a organization detail with the primary key could not be found
	 */
	public static OrganizationDetail fetchByPrimaryKey(
		long organizationDetailId) {

		return getPersistence().fetchByPrimaryKey(organizationDetailId);
	}

	/**
	 * Returns all the organization details.
	 *
	 * @return the organization details
	 */
	public static List<OrganizationDetail> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the organization details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @return the range of organization details
	 */
	public static List<OrganizationDetail> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the organization details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of organization details
	 */
	public static List<OrganizationDetail> findAll(
		int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the organization details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization details
	 * @param end the upper bound of the range of organization details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of organization details
	 */
	public static List<OrganizationDetail> findAll(
		int start, int end,
		OrderByComparator<OrganizationDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the organization details from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of organization details.
	 *
	 * @return the number of organization details
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static OrganizationDetailPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<OrganizationDetailPersistence, OrganizationDetailPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			OrganizationDetailPersistence.class);

		ServiceTracker
			<OrganizationDetailPersistence, OrganizationDetailPersistence>
				serviceTracker =
					new ServiceTracker
						<OrganizationDetailPersistence,
						 OrganizationDetailPersistence>(
							 bundle.getBundleContext(),
							 OrganizationDetailPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}