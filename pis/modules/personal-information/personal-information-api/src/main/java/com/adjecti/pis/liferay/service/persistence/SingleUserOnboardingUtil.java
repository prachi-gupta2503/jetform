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

import com.adjecti.pis.liferay.model.SingleUserOnboarding;

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
 * The persistence utility for the single user onboarding service. This utility wraps <code>com.adjecti.pis.liferay.service.persistence.impl.SingleUserOnboardingPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SingleUserOnboardingPersistence
 * @generated
 */
public class SingleUserOnboardingUtil {

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
	public static void clearCache(SingleUserOnboarding singleUserOnboarding) {
		getPersistence().clearCache(singleUserOnboarding);
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
	public static Map<Serializable, SingleUserOnboarding> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SingleUserOnboarding> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SingleUserOnboarding> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SingleUserOnboarding> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SingleUserOnboarding update(
		SingleUserOnboarding singleUserOnboarding) {

		return getPersistence().update(singleUserOnboarding);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SingleUserOnboarding update(
		SingleUserOnboarding singleUserOnboarding,
		ServiceContext serviceContext) {

		return getPersistence().update(singleUserOnboarding, serviceContext);
	}

	/**
	 * Returns all the single user onboardings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the single user onboardings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first single user onboarding in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding findByUuid_First(
			String uuid,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first single user onboarding in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding fetchByUuid_First(
		String uuid,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last single user onboarding in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding findByUuid_Last(
			String uuid,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last single user onboarding in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding fetchByUuid_Last(
		String uuid,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where uuid = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	public static SingleUserOnboarding[] findByUuid_PrevAndNext(
			long singleUserRegistrationId, String uuid,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByUuid_PrevAndNext(
			singleUserRegistrationId, uuid, orderByComparator);
	}

	/**
	 * Removes all the single user onboardings where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of single user onboardings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching single user onboardings
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the single user onboarding where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSingleUserOnboardingException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding findByUUID_G(String uuid, long groupId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the single user onboarding where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the single user onboarding where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the single user onboarding where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the single user onboarding that was removed
	 */
	public static SingleUserOnboarding removeByUUID_G(String uuid, long groupId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of single user onboardings where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching single user onboardings
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the single user onboardings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the single user onboardings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first single user onboarding in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first single user onboarding in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last single user onboarding in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last single user onboarding in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	public static SingleUserOnboarding[] findByUuid_C_PrevAndNext(
			long singleUserRegistrationId, String uuid, long companyId,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByUuid_C_PrevAndNext(
			singleUserRegistrationId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the single user onboardings where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of single user onboardings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching single user onboardings
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the single user onboardings where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByStatus(int status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the single user onboardings where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByStatus(
		int status, int start, int end) {

		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByStatus(
		int status, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByStatus(
		int status, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first single user onboarding in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding findByStatus_First(
			int status,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first single user onboarding in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding fetchByStatus_First(
		int status, OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last single user onboarding in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding findByStatus_Last(
			int status,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last single user onboarding in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding fetchByStatus_Last(
		int status, OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where status = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	public static SingleUserOnboarding[] findByStatus_PrevAndNext(
			long singleUserRegistrationId, int status,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByStatus_PrevAndNext(
			singleUserRegistrationId, status, orderByComparator);
	}

	/**
	 * Removes all the single user onboardings where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of single user onboardings where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching single user onboardings
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns all the single user onboardings where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @return the matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUnitId(long unitId) {
		return getPersistence().findByUnitId(unitId);
	}

	/**
	 * Returns a range of all the single user onboardings where unitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUnitId(
		long unitId, int start, int end) {

		return getPersistence().findByUnitId(unitId, start, end);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where unitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUnitId(
		long unitId, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().findByUnitId(
			unitId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where unitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUnitId(
		long unitId, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUnitId(
			unitId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first single user onboarding in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding findByUnitId_First(
			long unitId,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByUnitId_First(unitId, orderByComparator);
	}

	/**
	 * Returns the first single user onboarding in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding fetchByUnitId_First(
		long unitId,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().fetchByUnitId_First(unitId, orderByComparator);
	}

	/**
	 * Returns the last single user onboarding in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding findByUnitId_Last(
			long unitId,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByUnitId_Last(unitId, orderByComparator);
	}

	/**
	 * Returns the last single user onboarding in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding fetchByUnitId_Last(
		long unitId,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().fetchByUnitId_Last(unitId, orderByComparator);
	}

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where unitId = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	public static SingleUserOnboarding[] findByUnitId_PrevAndNext(
			long singleUserRegistrationId, long unitId,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByUnitId_PrevAndNext(
			singleUserRegistrationId, unitId, orderByComparator);
	}

	/**
	 * Removes all the single user onboardings where unitId = &#63; from the database.
	 *
	 * @param unitId the unit ID
	 */
	public static void removeByUnitId(long unitId) {
		getPersistence().removeByUnitId(unitId);
	}

	/**
	 * Returns the number of single user onboardings where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @return the number of matching single user onboardings
	 */
	public static int countByUnitId(long unitId) {
		return getPersistence().countByUnitId(unitId);
	}

	/**
	 * Returns all the single user onboardings where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @return the matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUnitIdAndStatus(
		long unitId, int status) {

		return getPersistence().findByUnitIdAndStatus(unitId, status);
	}

	/**
	 * Returns a range of all the single user onboardings where unitId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUnitIdAndStatus(
		long unitId, int status, int start, int end) {

		return getPersistence().findByUnitIdAndStatus(
			unitId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where unitId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUnitIdAndStatus(
		long unitId, int status, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().findByUnitIdAndStatus(
			unitId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where unitId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUnitIdAndStatus(
		long unitId, int status, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUnitIdAndStatus(
			unitId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first single user onboarding in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding findByUnitIdAndStatus_First(
			long unitId, int status,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByUnitIdAndStatus_First(
			unitId, status, orderByComparator);
	}

	/**
	 * Returns the first single user onboarding in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding fetchByUnitIdAndStatus_First(
		long unitId, int status,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().fetchByUnitIdAndStatus_First(
			unitId, status, orderByComparator);
	}

	/**
	 * Returns the last single user onboarding in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding findByUnitIdAndStatus_Last(
			long unitId, int status,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByUnitIdAndStatus_Last(
			unitId, status, orderByComparator);
	}

	/**
	 * Returns the last single user onboarding in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding fetchByUnitIdAndStatus_Last(
		long unitId, int status,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().fetchByUnitIdAndStatus_Last(
			unitId, status, orderByComparator);
	}

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	public static SingleUserOnboarding[] findByUnitIdAndStatus_PrevAndNext(
			long singleUserRegistrationId, long unitId, int status,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByUnitIdAndStatus_PrevAndNext(
			singleUserRegistrationId, unitId, status, orderByComparator);
	}

	/**
	 * Removes all the single user onboardings where unitId = &#63; and status = &#63; from the database.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 */
	public static void removeByUnitIdAndStatus(long unitId, int status) {
		getPersistence().removeByUnitIdAndStatus(unitId, status);
	}

	/**
	 * Returns the number of single user onboardings where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @return the number of matching single user onboardings
	 */
	public static int countByUnitIdAndStatus(long unitId, int status) {
		return getPersistence().countByUnitIdAndStatus(unitId, status);
	}

	/**
	 * Returns all the single user onboardings where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @return the matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUnitIdsAndStatusList(
		long unitId, int status) {

		return getPersistence().findByUnitIdsAndStatusList(unitId, status);
	}

	/**
	 * Returns a range of all the single user onboardings where unitId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUnitIdsAndStatusList(
		long unitId, int status, int start, int end) {

		return getPersistence().findByUnitIdsAndStatusList(
			unitId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where unitId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUnitIdsAndStatusList(
		long unitId, int status, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().findByUnitIdsAndStatusList(
			unitId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where unitId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUnitIdsAndStatusList(
		long unitId, int status, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUnitIdsAndStatusList(
			unitId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first single user onboarding in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding findByUnitIdsAndStatusList_First(
			long unitId, int status,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByUnitIdsAndStatusList_First(
			unitId, status, orderByComparator);
	}

	/**
	 * Returns the first single user onboarding in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding fetchByUnitIdsAndStatusList_First(
		long unitId, int status,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().fetchByUnitIdsAndStatusList_First(
			unitId, status, orderByComparator);
	}

	/**
	 * Returns the last single user onboarding in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding findByUnitIdsAndStatusList_Last(
			long unitId, int status,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByUnitIdsAndStatusList_Last(
			unitId, status, orderByComparator);
	}

	/**
	 * Returns the last single user onboarding in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding fetchByUnitIdsAndStatusList_Last(
		long unitId, int status,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().fetchByUnitIdsAndStatusList_Last(
			unitId, status, orderByComparator);
	}

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	public static SingleUserOnboarding[] findByUnitIdsAndStatusList_PrevAndNext(
			long singleUserRegistrationId, long unitId, int status,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByUnitIdsAndStatusList_PrevAndNext(
			singleUserRegistrationId, unitId, status, orderByComparator);
	}

	/**
	 * Returns all the single user onboardings where unitId = any &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unitIds the unit IDs
	 * @param statuses the statuses
	 * @return the matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUnitIdsAndStatusList(
		long[] unitIds, int[] statuses) {

		return getPersistence().findByUnitIdsAndStatusList(unitIds, statuses);
	}

	/**
	 * Returns a range of all the single user onboardings where unitId = any &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unitIds the unit IDs
	 * @param statuses the statuses
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUnitIdsAndStatusList(
		long[] unitIds, int[] statuses, int start, int end) {

		return getPersistence().findByUnitIdsAndStatusList(
			unitIds, statuses, start, end);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where unitId = any &#63; and status = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unitIds the unit IDs
	 * @param statuses the statuses
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUnitIdsAndStatusList(
		long[] unitIds, int[] statuses, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().findByUnitIdsAndStatusList(
			unitIds, statuses, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where unitId = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUnitIdsAndStatusList(
		long[] unitIds, int[] statuses, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUnitIdsAndStatusList(
			unitIds, statuses, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the single user onboardings where unitId = &#63; and status = &#63; from the database.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 */
	public static void removeByUnitIdsAndStatusList(long unitId, int status) {
		getPersistence().removeByUnitIdsAndStatusList(unitId, status);
	}

	/**
	 * Returns the number of single user onboardings where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @return the number of matching single user onboardings
	 */
	public static int countByUnitIdsAndStatusList(long unitId, int status) {
		return getPersistence().countByUnitIdsAndStatusList(unitId, status);
	}

	/**
	 * Returns the number of single user onboardings where unitId = any &#63; and status = any &#63;.
	 *
	 * @param unitIds the unit IDs
	 * @param statuses the statuses
	 * @return the number of matching single user onboardings
	 */
	public static int countByUnitIdsAndStatusList(
		long[] unitIds, int[] statuses) {

		return getPersistence().countByUnitIdsAndStatusList(unitIds, statuses);
	}

	/**
	 * Returns all the single user onboardings where unitId = &#63; and state = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @return the matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUnitIdAndState(
		long unitId, String state) {

		return getPersistence().findByUnitIdAndState(unitId, state);
	}

	/**
	 * Returns a range of all the single user onboardings where unitId = &#63; and state = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUnitIdAndState(
		long unitId, String state, int start, int end) {

		return getPersistence().findByUnitIdAndState(unitId, state, start, end);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where unitId = &#63; and state = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUnitIdAndState(
		long unitId, String state, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().findByUnitIdAndState(
			unitId, state, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where unitId = &#63; and state = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUnitIdAndState(
		long unitId, String state, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUnitIdAndState(
			unitId, state, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first single user onboarding in the ordered set where unitId = &#63; and state = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding findByUnitIdAndState_First(
			long unitId, String state,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByUnitIdAndState_First(
			unitId, state, orderByComparator);
	}

	/**
	 * Returns the first single user onboarding in the ordered set where unitId = &#63; and state = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding fetchByUnitIdAndState_First(
		long unitId, String state,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().fetchByUnitIdAndState_First(
			unitId, state, orderByComparator);
	}

	/**
	 * Returns the last single user onboarding in the ordered set where unitId = &#63; and state = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding findByUnitIdAndState_Last(
			long unitId, String state,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByUnitIdAndState_Last(
			unitId, state, orderByComparator);
	}

	/**
	 * Returns the last single user onboarding in the ordered set where unitId = &#63; and state = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding fetchByUnitIdAndState_Last(
		long unitId, String state,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().fetchByUnitIdAndState_Last(
			unitId, state, orderByComparator);
	}

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where unitId = &#63; and state = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param unitId the unit ID
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	public static SingleUserOnboarding[] findByUnitIdAndState_PrevAndNext(
			long singleUserRegistrationId, long unitId, String state,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByUnitIdAndState_PrevAndNext(
			singleUserRegistrationId, unitId, state, orderByComparator);
	}

	/**
	 * Removes all the single user onboardings where unitId = &#63; and state = &#63; from the database.
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 */
	public static void removeByUnitIdAndState(long unitId, String state) {
		getPersistence().removeByUnitIdAndState(unitId, state);
	}

	/**
	 * Returns the number of single user onboardings where unitId = &#63; and state = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @return the number of matching single user onboardings
	 */
	public static int countByUnitIdAndState(long unitId, String state) {
		return getPersistence().countByUnitIdAndState(unitId, state);
	}

	/**
	 * Returns all the single user onboardings where unit = &#63;.
	 *
	 * @param unit the unit
	 * @return the matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUnit(String unit) {
		return getPersistence().findByUnit(unit);
	}

	/**
	 * Returns a range of all the single user onboardings where unit = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unit the unit
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUnit(
		String unit, int start, int end) {

		return getPersistence().findByUnit(unit, start, end);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where unit = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unit the unit
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUnit(
		String unit, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().findByUnit(unit, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where unit = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unit the unit
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUnit(
		String unit, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUnit(
			unit, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first single user onboarding in the ordered set where unit = &#63;.
	 *
	 * @param unit the unit
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding findByUnit_First(
			String unit,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByUnit_First(unit, orderByComparator);
	}

	/**
	 * Returns the first single user onboarding in the ordered set where unit = &#63;.
	 *
	 * @param unit the unit
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding fetchByUnit_First(
		String unit,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().fetchByUnit_First(unit, orderByComparator);
	}

	/**
	 * Returns the last single user onboarding in the ordered set where unit = &#63;.
	 *
	 * @param unit the unit
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding findByUnit_Last(
			String unit,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByUnit_Last(unit, orderByComparator);
	}

	/**
	 * Returns the last single user onboarding in the ordered set where unit = &#63;.
	 *
	 * @param unit the unit
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding fetchByUnit_Last(
		String unit,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().fetchByUnit_Last(unit, orderByComparator);
	}

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where unit = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param unit the unit
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	public static SingleUserOnboarding[] findByUnit_PrevAndNext(
			long singleUserRegistrationId, String unit,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByUnit_PrevAndNext(
			singleUserRegistrationId, unit, orderByComparator);
	}

	/**
	 * Removes all the single user onboardings where unit = &#63; from the database.
	 *
	 * @param unit the unit
	 */
	public static void removeByUnit(String unit) {
		getPersistence().removeByUnit(unit);
	}

	/**
	 * Returns the number of single user onboardings where unit = &#63;.
	 *
	 * @param unit the unit
	 * @return the number of matching single user onboardings
	 */
	public static int countByUnit(String unit) {
		return getPersistence().countByUnit(unit);
	}

	/**
	 * Returns all the single user onboardings where unit = &#63; and status = &#63;.
	 *
	 * @param unit the unit
	 * @param status the status
	 * @return the matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUnitAndStatus(
		String unit, int status) {

		return getPersistence().findByUnitAndStatus(unit, status);
	}

	/**
	 * Returns a range of all the single user onboardings where unit = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unit the unit
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUnitAndStatus(
		String unit, int status, int start, int end) {

		return getPersistence().findByUnitAndStatus(unit, status, start, end);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where unit = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unit the unit
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUnitAndStatus(
		String unit, int status, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().findByUnitAndStatus(
			unit, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where unit = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unit the unit
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUnitAndStatus(
		String unit, int status, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUnitAndStatus(
			unit, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first single user onboarding in the ordered set where unit = &#63; and status = &#63;.
	 *
	 * @param unit the unit
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding findByUnitAndStatus_First(
			String unit, int status,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByUnitAndStatus_First(
			unit, status, orderByComparator);
	}

	/**
	 * Returns the first single user onboarding in the ordered set where unit = &#63; and status = &#63;.
	 *
	 * @param unit the unit
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding fetchByUnitAndStatus_First(
		String unit, int status,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().fetchByUnitAndStatus_First(
			unit, status, orderByComparator);
	}

	/**
	 * Returns the last single user onboarding in the ordered set where unit = &#63; and status = &#63;.
	 *
	 * @param unit the unit
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding findByUnitAndStatus_Last(
			String unit, int status,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByUnitAndStatus_Last(
			unit, status, orderByComparator);
	}

	/**
	 * Returns the last single user onboarding in the ordered set where unit = &#63; and status = &#63;.
	 *
	 * @param unit the unit
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding fetchByUnitAndStatus_Last(
		String unit, int status,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().fetchByUnitAndStatus_Last(
			unit, status, orderByComparator);
	}

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where unit = &#63; and status = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param unit the unit
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	public static SingleUserOnboarding[] findByUnitAndStatus_PrevAndNext(
			long singleUserRegistrationId, String unit, int status,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByUnitAndStatus_PrevAndNext(
			singleUserRegistrationId, unit, status, orderByComparator);
	}

	/**
	 * Removes all the single user onboardings where unit = &#63; and status = &#63; from the database.
	 *
	 * @param unit the unit
	 * @param status the status
	 */
	public static void removeByUnitAndStatus(String unit, int status) {
		getPersistence().removeByUnitAndStatus(unit, status);
	}

	/**
	 * Returns the number of single user onboardings where unit = &#63; and status = &#63;.
	 *
	 * @param unit the unit
	 * @param status the status
	 * @return the number of matching single user onboardings
	 */
	public static int countByUnitAndStatus(String unit, int status) {
		return getPersistence().countByUnitAndStatus(unit, status);
	}

	/**
	 * Returns all the single user onboardings where unit = &#63; and state = &#63;.
	 *
	 * @param unit the unit
	 * @param state the state
	 * @return the matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUnitAndState(
		String unit, String state) {

		return getPersistence().findByUnitAndState(unit, state);
	}

	/**
	 * Returns a range of all the single user onboardings where unit = &#63; and state = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unit the unit
	 * @param state the state
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUnitAndState(
		String unit, String state, int start, int end) {

		return getPersistence().findByUnitAndState(unit, state, start, end);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where unit = &#63; and state = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unit the unit
	 * @param state the state
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUnitAndState(
		String unit, String state, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().findByUnitAndState(
			unit, state, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where unit = &#63; and state = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param unit the unit
	 * @param state the state
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUnitAndState(
		String unit, String state, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUnitAndState(
			unit, state, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first single user onboarding in the ordered set where unit = &#63; and state = &#63;.
	 *
	 * @param unit the unit
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding findByUnitAndState_First(
			String unit, String state,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByUnitAndState_First(
			unit, state, orderByComparator);
	}

	/**
	 * Returns the first single user onboarding in the ordered set where unit = &#63; and state = &#63;.
	 *
	 * @param unit the unit
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding fetchByUnitAndState_First(
		String unit, String state,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().fetchByUnitAndState_First(
			unit, state, orderByComparator);
	}

	/**
	 * Returns the last single user onboarding in the ordered set where unit = &#63; and state = &#63;.
	 *
	 * @param unit the unit
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding findByUnitAndState_Last(
			String unit, String state,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByUnitAndState_Last(
			unit, state, orderByComparator);
	}

	/**
	 * Returns the last single user onboarding in the ordered set where unit = &#63; and state = &#63;.
	 *
	 * @param unit the unit
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding fetchByUnitAndState_Last(
		String unit, String state,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().fetchByUnitAndState_Last(
			unit, state, orderByComparator);
	}

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where unit = &#63; and state = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param unit the unit
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	public static SingleUserOnboarding[] findByUnitAndState_PrevAndNext(
			long singleUserRegistrationId, String unit, String state,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByUnitAndState_PrevAndNext(
			singleUserRegistrationId, unit, state, orderByComparator);
	}

	/**
	 * Removes all the single user onboardings where unit = &#63; and state = &#63; from the database.
	 *
	 * @param unit the unit
	 * @param state the state
	 */
	public static void removeByUnitAndState(String unit, String state) {
		getPersistence().removeByUnitAndState(unit, state);
	}

	/**
	 * Returns the number of single user onboardings where unit = &#63; and state = &#63;.
	 *
	 * @param unit the unit
	 * @param state the state
	 * @return the number of matching single user onboardings
	 */
	public static int countByUnitAndState(String unit, String state) {
		return getPersistence().countByUnitAndState(unit, state);
	}

	/**
	 * Returns all the single user onboardings where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByG_S(
		long groupId, int status) {

		return getPersistence().findByG_S(groupId, status);
	}

	/**
	 * Returns a range of all the single user onboardings where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().findByG_S(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first single user onboarding in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding findByG_S_First(
			long groupId, int status,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the first single user onboarding in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().fetchByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last single user onboarding in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding findByG_S_Last(
			long groupId, int status,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last single user onboarding in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().fetchByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	public static SingleUserOnboarding[] findByG_S_PrevAndNext(
			long singleUserRegistrationId, long groupId, int status,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByG_S_PrevAndNext(
			singleUserRegistrationId, groupId, status, orderByComparator);
	}

	/**
	 * Removes all the single user onboardings where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByG_S(long groupId, int status) {
		getPersistence().removeByG_S(groupId, status);
	}

	/**
	 * Returns the number of single user onboardings where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching single user onboardings
	 */
	public static int countByG_S(long groupId, int status) {
		return getPersistence().countByG_S(groupId, status);
	}

	/**
	 * Returns all the single user onboardings where sectionId = &#63; and status = &#63;.
	 *
	 * @param sectionId the section ID
	 * @param status the status
	 * @return the matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findBySectionAndStatus(
		long sectionId, int status) {

		return getPersistence().findBySectionAndStatus(sectionId, status);
	}

	/**
	 * Returns a range of all the single user onboardings where sectionId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param sectionId the section ID
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findBySectionAndStatus(
		long sectionId, int status, int start, int end) {

		return getPersistence().findBySectionAndStatus(
			sectionId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where sectionId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param sectionId the section ID
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findBySectionAndStatus(
		long sectionId, int status, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().findBySectionAndStatus(
			sectionId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where sectionId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param sectionId the section ID
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findBySectionAndStatus(
		long sectionId, int status, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySectionAndStatus(
			sectionId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first single user onboarding in the ordered set where sectionId = &#63; and status = &#63;.
	 *
	 * @param sectionId the section ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding findBySectionAndStatus_First(
			long sectionId, int status,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findBySectionAndStatus_First(
			sectionId, status, orderByComparator);
	}

	/**
	 * Returns the first single user onboarding in the ordered set where sectionId = &#63; and status = &#63;.
	 *
	 * @param sectionId the section ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding fetchBySectionAndStatus_First(
		long sectionId, int status,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().fetchBySectionAndStatus_First(
			sectionId, status, orderByComparator);
	}

	/**
	 * Returns the last single user onboarding in the ordered set where sectionId = &#63; and status = &#63;.
	 *
	 * @param sectionId the section ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding findBySectionAndStatus_Last(
			long sectionId, int status,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findBySectionAndStatus_Last(
			sectionId, status, orderByComparator);
	}

	/**
	 * Returns the last single user onboarding in the ordered set where sectionId = &#63; and status = &#63;.
	 *
	 * @param sectionId the section ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding fetchBySectionAndStatus_Last(
		long sectionId, int status,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().fetchBySectionAndStatus_Last(
			sectionId, status, orderByComparator);
	}

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where sectionId = &#63; and status = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param sectionId the section ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	public static SingleUserOnboarding[] findBySectionAndStatus_PrevAndNext(
			long singleUserRegistrationId, long sectionId, int status,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findBySectionAndStatus_PrevAndNext(
			singleUserRegistrationId, sectionId, status, orderByComparator);
	}

	/**
	 * Removes all the single user onboardings where sectionId = &#63; and status = &#63; from the database.
	 *
	 * @param sectionId the section ID
	 * @param status the status
	 */
	public static void removeBySectionAndStatus(long sectionId, int status) {
		getPersistence().removeBySectionAndStatus(sectionId, status);
	}

	/**
	 * Returns the number of single user onboardings where sectionId = &#63; and status = &#63;.
	 *
	 * @param sectionId the section ID
	 * @param status the status
	 * @return the number of matching single user onboardings
	 */
	public static int countBySectionAndStatus(long sectionId, int status) {
		return getPersistence().countBySectionAndStatus(sectionId, status);
	}

	/**
	 * Returns all the single user onboardings where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the single user onboardings where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first single user onboarding in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding findByGroupId_First(
			long groupId,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first single user onboarding in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding fetchByGroupId_First(
		long groupId,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last single user onboarding in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding findByGroupId_Last(
			long groupId,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last single user onboarding in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding fetchByGroupId_Last(
		long groupId,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where groupId = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	public static SingleUserOnboarding[] findByGroupId_PrevAndNext(
			long singleUserRegistrationId, long groupId,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByGroupId_PrevAndNext(
			singleUserRegistrationId, groupId, orderByComparator);
	}

	/**
	 * Removes all the single user onboardings where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of single user onboardings where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching single user onboardings
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the single user onboardings where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the single user onboardings where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUserId(
		long userId, int start, int end) {

		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUserId(
		long userId, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByUserId(
		long userId, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first single user onboarding in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding findByUserId_First(
			long userId,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first single user onboarding in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding fetchByUserId_First(
		long userId,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last single user onboarding in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding findByUserId_Last(
			long userId,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last single user onboarding in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding fetchByUserId_Last(
		long userId,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where userId = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	public static SingleUserOnboarding[] findByUserId_PrevAndNext(
			long singleUserRegistrationId, long userId,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByUserId_PrevAndNext(
			singleUserRegistrationId, userId, orderByComparator);
	}

	/**
	 * Removes all the single user onboardings where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of single user onboardings where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching single user onboardings
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Returns all the single user onboardings where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @return the matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByPersonalNo(long personalNo) {
		return getPersistence().findByPersonalNo(personalNo);
	}

	/**
	 * Returns a range of all the single user onboardings where personalNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param personalNo the personal no
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByPersonalNo(
		long personalNo, int start, int end) {

		return getPersistence().findByPersonalNo(personalNo, start, end);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where personalNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param personalNo the personal no
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByPersonalNo(
		long personalNo, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().findByPersonalNo(
			personalNo, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where personalNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param personalNo the personal no
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByPersonalNo(
		long personalNo, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPersonalNo(
			personalNo, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first single user onboarding in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding findByPersonalNo_First(
			long personalNo,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByPersonalNo_First(
			personalNo, orderByComparator);
	}

	/**
	 * Returns the first single user onboarding in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding fetchByPersonalNo_First(
		long personalNo,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().fetchByPersonalNo_First(
			personalNo, orderByComparator);
	}

	/**
	 * Returns the last single user onboarding in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding findByPersonalNo_Last(
			long personalNo,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByPersonalNo_Last(
			personalNo, orderByComparator);
	}

	/**
	 * Returns the last single user onboarding in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding fetchByPersonalNo_Last(
		long personalNo,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().fetchByPersonalNo_Last(
			personalNo, orderByComparator);
	}

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where personalNo = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	public static SingleUserOnboarding[] findByPersonalNo_PrevAndNext(
			long singleUserRegistrationId, long personalNo,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByPersonalNo_PrevAndNext(
			singleUserRegistrationId, personalNo, orderByComparator);
	}

	/**
	 * Removes all the single user onboardings where personalNo = &#63; from the database.
	 *
	 * @param personalNo the personal no
	 */
	public static void removeByPersonalNo(long personalNo) {
		getPersistence().removeByPersonalNo(personalNo);
	}

	/**
	 * Returns the number of single user onboardings where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @return the number of matching single user onboardings
	 */
	public static int countByPersonalNo(long personalNo) {
		return getPersistence().countByPersonalNo(personalNo);
	}

	/**
	 * Returns all the single user onboardings where recordNo = &#63;.
	 *
	 * @param recordNo the record no
	 * @return the matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByRecordNo(long recordNo) {
		return getPersistence().findByRecordNo(recordNo);
	}

	/**
	 * Returns a range of all the single user onboardings where recordNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param recordNo the record no
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByRecordNo(
		long recordNo, int start, int end) {

		return getPersistence().findByRecordNo(recordNo, start, end);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where recordNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param recordNo the record no
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByRecordNo(
		long recordNo, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().findByRecordNo(
			recordNo, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where recordNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param recordNo the record no
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByRecordNo(
		long recordNo, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRecordNo(
			recordNo, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first single user onboarding in the ordered set where recordNo = &#63;.
	 *
	 * @param recordNo the record no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding findByRecordNo_First(
			long recordNo,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByRecordNo_First(
			recordNo, orderByComparator);
	}

	/**
	 * Returns the first single user onboarding in the ordered set where recordNo = &#63;.
	 *
	 * @param recordNo the record no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding fetchByRecordNo_First(
		long recordNo,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().fetchByRecordNo_First(
			recordNo, orderByComparator);
	}

	/**
	 * Returns the last single user onboarding in the ordered set where recordNo = &#63;.
	 *
	 * @param recordNo the record no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding findByRecordNo_Last(
			long recordNo,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByRecordNo_Last(
			recordNo, orderByComparator);
	}

	/**
	 * Returns the last single user onboarding in the ordered set where recordNo = &#63;.
	 *
	 * @param recordNo the record no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding fetchByRecordNo_Last(
		long recordNo,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().fetchByRecordNo_Last(
			recordNo, orderByComparator);
	}

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where recordNo = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param recordNo the record no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	public static SingleUserOnboarding[] findByRecordNo_PrevAndNext(
			long singleUserRegistrationId, long recordNo,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByRecordNo_PrevAndNext(
			singleUserRegistrationId, recordNo, orderByComparator);
	}

	/**
	 * Removes all the single user onboardings where recordNo = &#63; from the database.
	 *
	 * @param recordNo the record no
	 */
	public static void removeByRecordNo(long recordNo) {
		getPersistence().removeByRecordNo(recordNo);
	}

	/**
	 * Returns the number of single user onboardings where recordNo = &#63;.
	 *
	 * @param recordNo the record no
	 * @return the number of matching single user onboardings
	 */
	public static int countByRecordNo(long recordNo) {
		return getPersistence().countByRecordNo(recordNo);
	}

	/**
	 * Returns all the single user onboardings where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByEmailAddress(
		String emailAddress) {

		return getPersistence().findByEmailAddress(emailAddress);
	}

	/**
	 * Returns a range of all the single user onboardings where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByEmailAddress(
		String emailAddress, int start, int end) {

		return getPersistence().findByEmailAddress(emailAddress, start, end);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByEmailAddress(
		String emailAddress, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().findByEmailAddress(
			emailAddress, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByEmailAddress(
		String emailAddress, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmailAddress(
			emailAddress, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first single user onboarding in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding findByEmailAddress_First(
			String emailAddress,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByEmailAddress_First(
			emailAddress, orderByComparator);
	}

	/**
	 * Returns the first single user onboarding in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding fetchByEmailAddress_First(
		String emailAddress,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().fetchByEmailAddress_First(
			emailAddress, orderByComparator);
	}

	/**
	 * Returns the last single user onboarding in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding findByEmailAddress_Last(
			String emailAddress,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByEmailAddress_Last(
			emailAddress, orderByComparator);
	}

	/**
	 * Returns the last single user onboarding in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding fetchByEmailAddress_Last(
		String emailAddress,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().fetchByEmailAddress_Last(
			emailAddress, orderByComparator);
	}

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where emailAddress = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	public static SingleUserOnboarding[] findByEmailAddress_PrevAndNext(
			long singleUserRegistrationId, String emailAddress,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByEmailAddress_PrevAndNext(
			singleUserRegistrationId, emailAddress, orderByComparator);
	}

	/**
	 * Removes all the single user onboardings where emailAddress = &#63; from the database.
	 *
	 * @param emailAddress the email address
	 */
	public static void removeByEmailAddress(String emailAddress) {
		getPersistence().removeByEmailAddress(emailAddress);
	}

	/**
	 * Returns the number of single user onboardings where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the number of matching single user onboardings
	 */
	public static int countByEmailAddress(String emailAddress) {
		return getPersistence().countByEmailAddress(emailAddress);
	}

	/**
	 * Returns all the single user onboardings where loginId = &#63; and status = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @return the matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByLoginIdAndStatus(
		String loginId, int status) {

		return getPersistence().findByLoginIdAndStatus(loginId, status);
	}

	/**
	 * Returns a range of all the single user onboardings where loginId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByLoginIdAndStatus(
		String loginId, int status, int start, int end) {

		return getPersistence().findByLoginIdAndStatus(
			loginId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where loginId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByLoginIdAndStatus(
		String loginId, int status, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().findByLoginIdAndStatus(
			loginId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where loginId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding> findByLoginIdAndStatus(
		String loginId, int status, int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByLoginIdAndStatus(
			loginId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first single user onboarding in the ordered set where loginId = &#63; and status = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding findByLoginIdAndStatus_First(
			String loginId, int status,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByLoginIdAndStatus_First(
			loginId, status, orderByComparator);
	}

	/**
	 * Returns the first single user onboarding in the ordered set where loginId = &#63; and status = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding fetchByLoginIdAndStatus_First(
		String loginId, int status,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().fetchByLoginIdAndStatus_First(
			loginId, status, orderByComparator);
	}

	/**
	 * Returns the last single user onboarding in the ordered set where loginId = &#63; and status = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding findByLoginIdAndStatus_Last(
			String loginId, int status,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByLoginIdAndStatus_Last(
			loginId, status, orderByComparator);
	}

	/**
	 * Returns the last single user onboarding in the ordered set where loginId = &#63; and status = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding fetchByLoginIdAndStatus_Last(
		String loginId, int status,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().fetchByLoginIdAndStatus_Last(
			loginId, status, orderByComparator);
	}

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where loginId = &#63; and status = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param loginId the login ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	public static SingleUserOnboarding[] findByLoginIdAndStatus_PrevAndNext(
			long singleUserRegistrationId, String loginId, int status,
			OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByLoginIdAndStatus_PrevAndNext(
			singleUserRegistrationId, loginId, status, orderByComparator);
	}

	/**
	 * Removes all the single user onboardings where loginId = &#63; and status = &#63; from the database.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 */
	public static void removeByLoginIdAndStatus(String loginId, int status) {
		getPersistence().removeByLoginIdAndStatus(loginId, status);
	}

	/**
	 * Returns the number of single user onboardings where loginId = &#63; and status = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @return the number of matching single user onboardings
	 */
	public static int countByLoginIdAndStatus(String loginId, int status) {
		return getPersistence().countByLoginIdAndStatus(loginId, status);
	}

	/**
	 * Returns all the single user onboardings where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @return the matching single user onboardings
	 */
	public static List<SingleUserOnboarding>
		findByLoginIdStatusStateAndIdamUserCreated(
			String loginId, int status, String state, boolean idamUserCreated) {

		return getPersistence().findByLoginIdStatusStateAndIdamUserCreated(
			loginId, status, state, idamUserCreated);
	}

	/**
	 * Returns a range of all the single user onboardings where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding>
		findByLoginIdStatusStateAndIdamUserCreated(
			String loginId, int status, String state, boolean idamUserCreated,
			int start, int end) {

		return getPersistence().findByLoginIdStatusStateAndIdamUserCreated(
			loginId, status, state, idamUserCreated, start, end);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding>
		findByLoginIdStatusStateAndIdamUserCreated(
			String loginId, int status, String state, boolean idamUserCreated,
			int start, int end,
			OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().findByLoginIdStatusStateAndIdamUserCreated(
			loginId, status, state, idamUserCreated, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the single user onboardings where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching single user onboardings
	 */
	public static List<SingleUserOnboarding>
		findByLoginIdStatusStateAndIdamUserCreated(
			String loginId, int status, String state, boolean idamUserCreated,
			int start, int end,
			OrderByComparator<SingleUserOnboarding> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByLoginIdStatusStateAndIdamUserCreated(
			loginId, status, state, idamUserCreated, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first single user onboarding in the ordered set where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding
			findByLoginIdStatusStateAndIdamUserCreated_First(
				String loginId, int status, String state,
				boolean idamUserCreated,
				OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().
			findByLoginIdStatusStateAndIdamUserCreated_First(
				loginId, status, state, idamUserCreated, orderByComparator);
	}

	/**
	 * Returns the first single user onboarding in the ordered set where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding
		fetchByLoginIdStatusStateAndIdamUserCreated_First(
			String loginId, int status, String state, boolean idamUserCreated,
			OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().
			fetchByLoginIdStatusStateAndIdamUserCreated_First(
				loginId, status, state, idamUserCreated, orderByComparator);
	}

	/**
	 * Returns the last single user onboarding in the ordered set where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding
			findByLoginIdStatusStateAndIdamUserCreated_Last(
				String loginId, int status, String state,
				boolean idamUserCreated,
				OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByLoginIdStatusStateAndIdamUserCreated_Last(
			loginId, status, state, idamUserCreated, orderByComparator);
	}

	/**
	 * Returns the last single user onboarding in the ordered set where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public static SingleUserOnboarding
		fetchByLoginIdStatusStateAndIdamUserCreated_Last(
			String loginId, int status, String state, boolean idamUserCreated,
			OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().
			fetchByLoginIdStatusStateAndIdamUserCreated_Last(
				loginId, status, state, idamUserCreated, orderByComparator);
	}

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	public static SingleUserOnboarding[]
			findByLoginIdStatusStateAndIdamUserCreated_PrevAndNext(
				long singleUserRegistrationId, String loginId, int status,
				String state, boolean idamUserCreated,
				OrderByComparator<SingleUserOnboarding> orderByComparator)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().
			findByLoginIdStatusStateAndIdamUserCreated_PrevAndNext(
				singleUserRegistrationId, loginId, status, state,
				idamUserCreated, orderByComparator);
	}

	/**
	 * Removes all the single user onboardings where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63; from the database.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 */
	public static void removeByLoginIdStatusStateAndIdamUserCreated(
		String loginId, int status, String state, boolean idamUserCreated) {

		getPersistence().removeByLoginIdStatusStateAndIdamUserCreated(
			loginId, status, state, idamUserCreated);
	}

	/**
	 * Returns the number of single user onboardings where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @return the number of matching single user onboardings
	 */
	public static int countByLoginIdStatusStateAndIdamUserCreated(
		String loginId, int status, String state, boolean idamUserCreated) {

		return getPersistence().countByLoginIdStatusStateAndIdamUserCreated(
			loginId, status, state, idamUserCreated);
	}

	/**
	 * Caches the single user onboarding in the entity cache if it is enabled.
	 *
	 * @param singleUserOnboarding the single user onboarding
	 */
	public static void cacheResult(SingleUserOnboarding singleUserOnboarding) {
		getPersistence().cacheResult(singleUserOnboarding);
	}

	/**
	 * Caches the single user onboardings in the entity cache if it is enabled.
	 *
	 * @param singleUserOnboardings the single user onboardings
	 */
	public static void cacheResult(
		List<SingleUserOnboarding> singleUserOnboardings) {

		getPersistence().cacheResult(singleUserOnboardings);
	}

	/**
	 * Creates a new single user onboarding with the primary key. Does not add the single user onboarding to the database.
	 *
	 * @param singleUserRegistrationId the primary key for the new single user onboarding
	 * @return the new single user onboarding
	 */
	public static SingleUserOnboarding create(long singleUserRegistrationId) {
		return getPersistence().create(singleUserRegistrationId);
	}

	/**
	 * Removes the single user onboarding with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param singleUserRegistrationId the primary key of the single user onboarding
	 * @return the single user onboarding that was removed
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	public static SingleUserOnboarding remove(long singleUserRegistrationId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().remove(singleUserRegistrationId);
	}

	public static SingleUserOnboarding updateImpl(
		SingleUserOnboarding singleUserOnboarding) {

		return getPersistence().updateImpl(singleUserOnboarding);
	}

	/**
	 * Returns the single user onboarding with the primary key or throws a <code>NoSuchSingleUserOnboardingException</code> if it could not be found.
	 *
	 * @param singleUserRegistrationId the primary key of the single user onboarding
	 * @return the single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	public static SingleUserOnboarding findByPrimaryKey(
			long singleUserRegistrationId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchSingleUserOnboardingException {

		return getPersistence().findByPrimaryKey(singleUserRegistrationId);
	}

	/**
	 * Returns the single user onboarding with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param singleUserRegistrationId the primary key of the single user onboarding
	 * @return the single user onboarding, or <code>null</code> if a single user onboarding with the primary key could not be found
	 */
	public static SingleUserOnboarding fetchByPrimaryKey(
		long singleUserRegistrationId) {

		return getPersistence().fetchByPrimaryKey(singleUserRegistrationId);
	}

	/**
	 * Returns all the single user onboardings.
	 *
	 * @return the single user onboardings
	 */
	public static List<SingleUserOnboarding> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the single user onboardings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @return the range of single user onboardings
	 */
	public static List<SingleUserOnboarding> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the single user onboardings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of single user onboardings
	 */
	public static List<SingleUserOnboarding> findAll(
		int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the single user onboardings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SingleUserOnboardingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of single user onboardings
	 * @param end the upper bound of the range of single user onboardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of single user onboardings
	 */
	public static List<SingleUserOnboarding> findAll(
		int start, int end,
		OrderByComparator<SingleUserOnboarding> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the single user onboardings from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of single user onboardings.
	 *
	 * @return the number of single user onboardings
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SingleUserOnboardingPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<SingleUserOnboardingPersistence, SingleUserOnboardingPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			SingleUserOnboardingPersistence.class);

		ServiceTracker
			<SingleUserOnboardingPersistence, SingleUserOnboardingPersistence>
				serviceTracker =
					new ServiceTracker
						<SingleUserOnboardingPersistence,
						 SingleUserOnboardingPersistence>(
							 bundle.getBundleContext(),
							 SingleUserOnboardingPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}