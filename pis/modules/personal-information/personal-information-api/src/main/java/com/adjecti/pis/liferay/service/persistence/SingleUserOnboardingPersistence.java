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

import com.adjecti.pis.liferay.exception.NoSuchSingleUserOnboardingException;
import com.adjecti.pis.liferay.model.SingleUserOnboarding;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the single user onboarding service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SingleUserOnboardingUtil
 * @generated
 */
@ProviderType
public interface SingleUserOnboardingPersistence
	extends BasePersistence<SingleUserOnboarding> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SingleUserOnboardingUtil} to access the single user onboarding persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the single user onboardings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching single user onboardings
	 */
	public java.util.List<SingleUserOnboarding> findByUuid(String uuid);

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
	public java.util.List<SingleUserOnboarding> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<SingleUserOnboarding> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

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
	public java.util.List<SingleUserOnboarding> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first single user onboarding in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Returns the first single user onboarding in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

	/**
	 * Returns the last single user onboarding in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Returns the last single user onboarding in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where uuid = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	public SingleUserOnboarding[] findByUuid_PrevAndNext(
			long singleUserRegistrationId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Removes all the single user onboardings where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of single user onboardings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching single user onboardings
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the single user onboarding where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSingleUserOnboardingException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding findByUUID_G(String uuid, long groupId)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Returns the single user onboarding where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the single user onboarding where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the single user onboarding where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the single user onboarding that was removed
	 */
	public SingleUserOnboarding removeByUUID_G(String uuid, long groupId)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Returns the number of single user onboardings where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching single user onboardings
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the single user onboardings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching single user onboardings
	 */
	public java.util.List<SingleUserOnboarding> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<SingleUserOnboarding> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<SingleUserOnboarding> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

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
	public java.util.List<SingleUserOnboarding> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first single user onboarding in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Returns the first single user onboarding in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

	/**
	 * Returns the last single user onboarding in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Returns the last single user onboarding in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

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
	public SingleUserOnboarding[] findByUuid_C_PrevAndNext(
			long singleUserRegistrationId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Removes all the single user onboardings where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of single user onboardings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching single user onboardings
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the single user onboardings where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching single user onboardings
	 */
	public java.util.List<SingleUserOnboarding> findByStatus(int status);

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
	public java.util.List<SingleUserOnboarding> findByStatus(
		int status, int start, int end);

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
	public java.util.List<SingleUserOnboarding> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

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
	public java.util.List<SingleUserOnboarding> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first single user onboarding in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Returns the first single user onboarding in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

	/**
	 * Returns the last single user onboarding in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Returns the last single user onboarding in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where status = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	public SingleUserOnboarding[] findByStatus_PrevAndNext(
			long singleUserRegistrationId, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Removes all the single user onboardings where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of single user onboardings where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching single user onboardings
	 */
	public int countByStatus(int status);

	/**
	 * Returns all the single user onboardings where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @return the matching single user onboardings
	 */
	public java.util.List<SingleUserOnboarding> findByUnitId(long unitId);

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
	public java.util.List<SingleUserOnboarding> findByUnitId(
		long unitId, int start, int end);

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
	public java.util.List<SingleUserOnboarding> findByUnitId(
		long unitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

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
	public java.util.List<SingleUserOnboarding> findByUnitId(
		long unitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first single user onboarding in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding findByUnitId_First(
			long unitId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Returns the first single user onboarding in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding fetchByUnitId_First(
		long unitId,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

	/**
	 * Returns the last single user onboarding in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding findByUnitId_Last(
			long unitId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Returns the last single user onboarding in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding fetchByUnitId_Last(
		long unitId,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where unitId = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	public SingleUserOnboarding[] findByUnitId_PrevAndNext(
			long singleUserRegistrationId, long unitId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Removes all the single user onboardings where unitId = &#63; from the database.
	 *
	 * @param unitId the unit ID
	 */
	public void removeByUnitId(long unitId);

	/**
	 * Returns the number of single user onboardings where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @return the number of matching single user onboardings
	 */
	public int countByUnitId(long unitId);

	/**
	 * Returns all the single user onboardings where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @return the matching single user onboardings
	 */
	public java.util.List<SingleUserOnboarding> findByUnitIdAndStatus(
		long unitId, int status);

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
	public java.util.List<SingleUserOnboarding> findByUnitIdAndStatus(
		long unitId, int status, int start, int end);

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
	public java.util.List<SingleUserOnboarding> findByUnitIdAndStatus(
		long unitId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

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
	public java.util.List<SingleUserOnboarding> findByUnitIdAndStatus(
		long unitId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first single user onboarding in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding findByUnitIdAndStatus_First(
			long unitId, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Returns the first single user onboarding in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding fetchByUnitIdAndStatus_First(
		long unitId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

	/**
	 * Returns the last single user onboarding in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding findByUnitIdAndStatus_Last(
			long unitId, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Returns the last single user onboarding in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding fetchByUnitIdAndStatus_Last(
		long unitId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

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
	public SingleUserOnboarding[] findByUnitIdAndStatus_PrevAndNext(
			long singleUserRegistrationId, long unitId, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Removes all the single user onboardings where unitId = &#63; and status = &#63; from the database.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 */
	public void removeByUnitIdAndStatus(long unitId, int status);

	/**
	 * Returns the number of single user onboardings where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @return the number of matching single user onboardings
	 */
	public int countByUnitIdAndStatus(long unitId, int status);

	/**
	 * Returns all the single user onboardings where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @return the matching single user onboardings
	 */
	public java.util.List<SingleUserOnboarding> findByUnitIdsAndStatusList(
		long unitId, int status);

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
	public java.util.List<SingleUserOnboarding> findByUnitIdsAndStatusList(
		long unitId, int status, int start, int end);

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
	public java.util.List<SingleUserOnboarding> findByUnitIdsAndStatusList(
		long unitId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

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
	public java.util.List<SingleUserOnboarding> findByUnitIdsAndStatusList(
		long unitId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first single user onboarding in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding findByUnitIdsAndStatusList_First(
			long unitId, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Returns the first single user onboarding in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding fetchByUnitIdsAndStatusList_First(
		long unitId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

	/**
	 * Returns the last single user onboarding in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding findByUnitIdsAndStatusList_Last(
			long unitId, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Returns the last single user onboarding in the ordered set where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding fetchByUnitIdsAndStatusList_Last(
		long unitId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

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
	public SingleUserOnboarding[] findByUnitIdsAndStatusList_PrevAndNext(
			long singleUserRegistrationId, long unitId, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

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
	public java.util.List<SingleUserOnboarding> findByUnitIdsAndStatusList(
		long[] unitIds, int[] statuses);

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
	public java.util.List<SingleUserOnboarding> findByUnitIdsAndStatusList(
		long[] unitIds, int[] statuses, int start, int end);

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
	public java.util.List<SingleUserOnboarding> findByUnitIdsAndStatusList(
		long[] unitIds, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

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
	public java.util.List<SingleUserOnboarding> findByUnitIdsAndStatusList(
		long[] unitIds, int[] statuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the single user onboardings where unitId = &#63; and status = &#63; from the database.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 */
	public void removeByUnitIdsAndStatusList(long unitId, int status);

	/**
	 * Returns the number of single user onboardings where unitId = &#63; and status = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param status the status
	 * @return the number of matching single user onboardings
	 */
	public int countByUnitIdsAndStatusList(long unitId, int status);

	/**
	 * Returns the number of single user onboardings where unitId = any &#63; and status = any &#63;.
	 *
	 * @param unitIds the unit IDs
	 * @param statuses the statuses
	 * @return the number of matching single user onboardings
	 */
	public int countByUnitIdsAndStatusList(long[] unitIds, int[] statuses);

	/**
	 * Returns all the single user onboardings where unitId = &#63; and state = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @return the matching single user onboardings
	 */
	public java.util.List<SingleUserOnboarding> findByUnitIdAndState(
		long unitId, String state);

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
	public java.util.List<SingleUserOnboarding> findByUnitIdAndState(
		long unitId, String state, int start, int end);

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
	public java.util.List<SingleUserOnboarding> findByUnitIdAndState(
		long unitId, String state, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

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
	public java.util.List<SingleUserOnboarding> findByUnitIdAndState(
		long unitId, String state, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first single user onboarding in the ordered set where unitId = &#63; and state = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding findByUnitIdAndState_First(
			long unitId, String state,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Returns the first single user onboarding in the ordered set where unitId = &#63; and state = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding fetchByUnitIdAndState_First(
		long unitId, String state,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

	/**
	 * Returns the last single user onboarding in the ordered set where unitId = &#63; and state = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding findByUnitIdAndState_Last(
			long unitId, String state,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Returns the last single user onboarding in the ordered set where unitId = &#63; and state = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding fetchByUnitIdAndState_Last(
		long unitId, String state,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

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
	public SingleUserOnboarding[] findByUnitIdAndState_PrevAndNext(
			long singleUserRegistrationId, long unitId, String state,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Removes all the single user onboardings where unitId = &#63; and state = &#63; from the database.
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 */
	public void removeByUnitIdAndState(long unitId, String state);

	/**
	 * Returns the number of single user onboardings where unitId = &#63; and state = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param state the state
	 * @return the number of matching single user onboardings
	 */
	public int countByUnitIdAndState(long unitId, String state);

	/**
	 * Returns all the single user onboardings where unit = &#63;.
	 *
	 * @param unit the unit
	 * @return the matching single user onboardings
	 */
	public java.util.List<SingleUserOnboarding> findByUnit(String unit);

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
	public java.util.List<SingleUserOnboarding> findByUnit(
		String unit, int start, int end);

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
	public java.util.List<SingleUserOnboarding> findByUnit(
		String unit, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

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
	public java.util.List<SingleUserOnboarding> findByUnit(
		String unit, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first single user onboarding in the ordered set where unit = &#63;.
	 *
	 * @param unit the unit
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding findByUnit_First(
			String unit,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Returns the first single user onboarding in the ordered set where unit = &#63;.
	 *
	 * @param unit the unit
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding fetchByUnit_First(
		String unit,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

	/**
	 * Returns the last single user onboarding in the ordered set where unit = &#63;.
	 *
	 * @param unit the unit
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding findByUnit_Last(
			String unit,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Returns the last single user onboarding in the ordered set where unit = &#63;.
	 *
	 * @param unit the unit
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding fetchByUnit_Last(
		String unit,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where unit = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param unit the unit
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	public SingleUserOnboarding[] findByUnit_PrevAndNext(
			long singleUserRegistrationId, String unit,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Removes all the single user onboardings where unit = &#63; from the database.
	 *
	 * @param unit the unit
	 */
	public void removeByUnit(String unit);

	/**
	 * Returns the number of single user onboardings where unit = &#63;.
	 *
	 * @param unit the unit
	 * @return the number of matching single user onboardings
	 */
	public int countByUnit(String unit);

	/**
	 * Returns all the single user onboardings where unit = &#63; and status = &#63;.
	 *
	 * @param unit the unit
	 * @param status the status
	 * @return the matching single user onboardings
	 */
	public java.util.List<SingleUserOnboarding> findByUnitAndStatus(
		String unit, int status);

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
	public java.util.List<SingleUserOnboarding> findByUnitAndStatus(
		String unit, int status, int start, int end);

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
	public java.util.List<SingleUserOnboarding> findByUnitAndStatus(
		String unit, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

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
	public java.util.List<SingleUserOnboarding> findByUnitAndStatus(
		String unit, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first single user onboarding in the ordered set where unit = &#63; and status = &#63;.
	 *
	 * @param unit the unit
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding findByUnitAndStatus_First(
			String unit, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Returns the first single user onboarding in the ordered set where unit = &#63; and status = &#63;.
	 *
	 * @param unit the unit
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding fetchByUnitAndStatus_First(
		String unit, int status,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

	/**
	 * Returns the last single user onboarding in the ordered set where unit = &#63; and status = &#63;.
	 *
	 * @param unit the unit
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding findByUnitAndStatus_Last(
			String unit, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Returns the last single user onboarding in the ordered set where unit = &#63; and status = &#63;.
	 *
	 * @param unit the unit
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding fetchByUnitAndStatus_Last(
		String unit, int status,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

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
	public SingleUserOnboarding[] findByUnitAndStatus_PrevAndNext(
			long singleUserRegistrationId, String unit, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Removes all the single user onboardings where unit = &#63; and status = &#63; from the database.
	 *
	 * @param unit the unit
	 * @param status the status
	 */
	public void removeByUnitAndStatus(String unit, int status);

	/**
	 * Returns the number of single user onboardings where unit = &#63; and status = &#63;.
	 *
	 * @param unit the unit
	 * @param status the status
	 * @return the number of matching single user onboardings
	 */
	public int countByUnitAndStatus(String unit, int status);

	/**
	 * Returns all the single user onboardings where unit = &#63; and state = &#63;.
	 *
	 * @param unit the unit
	 * @param state the state
	 * @return the matching single user onboardings
	 */
	public java.util.List<SingleUserOnboarding> findByUnitAndState(
		String unit, String state);

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
	public java.util.List<SingleUserOnboarding> findByUnitAndState(
		String unit, String state, int start, int end);

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
	public java.util.List<SingleUserOnboarding> findByUnitAndState(
		String unit, String state, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

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
	public java.util.List<SingleUserOnboarding> findByUnitAndState(
		String unit, String state, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first single user onboarding in the ordered set where unit = &#63; and state = &#63;.
	 *
	 * @param unit the unit
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding findByUnitAndState_First(
			String unit, String state,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Returns the first single user onboarding in the ordered set where unit = &#63; and state = &#63;.
	 *
	 * @param unit the unit
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding fetchByUnitAndState_First(
		String unit, String state,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

	/**
	 * Returns the last single user onboarding in the ordered set where unit = &#63; and state = &#63;.
	 *
	 * @param unit the unit
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding findByUnitAndState_Last(
			String unit, String state,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Returns the last single user onboarding in the ordered set where unit = &#63; and state = &#63;.
	 *
	 * @param unit the unit
	 * @param state the state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding fetchByUnitAndState_Last(
		String unit, String state,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

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
	public SingleUserOnboarding[] findByUnitAndState_PrevAndNext(
			long singleUserRegistrationId, String unit, String state,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Removes all the single user onboardings where unit = &#63; and state = &#63; from the database.
	 *
	 * @param unit the unit
	 * @param state the state
	 */
	public void removeByUnitAndState(String unit, String state);

	/**
	 * Returns the number of single user onboardings where unit = &#63; and state = &#63;.
	 *
	 * @param unit the unit
	 * @param state the state
	 * @return the number of matching single user onboardings
	 */
	public int countByUnitAndState(String unit, String state);

	/**
	 * Returns all the single user onboardings where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching single user onboardings
	 */
	public java.util.List<SingleUserOnboarding> findByG_S(
		long groupId, int status);

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
	public java.util.List<SingleUserOnboarding> findByG_S(
		long groupId, int status, int start, int end);

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
	public java.util.List<SingleUserOnboarding> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

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
	public java.util.List<SingleUserOnboarding> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first single user onboarding in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding findByG_S_First(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Returns the first single user onboarding in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding fetchByG_S_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

	/**
	 * Returns the last single user onboarding in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding findByG_S_Last(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Returns the last single user onboarding in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding fetchByG_S_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

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
	public SingleUserOnboarding[] findByG_S_PrevAndNext(
			long singleUserRegistrationId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Removes all the single user onboardings where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public void removeByG_S(long groupId, int status);

	/**
	 * Returns the number of single user onboardings where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching single user onboardings
	 */
	public int countByG_S(long groupId, int status);

	/**
	 * Returns all the single user onboardings where sectionId = &#63; and status = &#63;.
	 *
	 * @param sectionId the section ID
	 * @param status the status
	 * @return the matching single user onboardings
	 */
	public java.util.List<SingleUserOnboarding> findBySectionAndStatus(
		long sectionId, int status);

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
	public java.util.List<SingleUserOnboarding> findBySectionAndStatus(
		long sectionId, int status, int start, int end);

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
	public java.util.List<SingleUserOnboarding> findBySectionAndStatus(
		long sectionId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

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
	public java.util.List<SingleUserOnboarding> findBySectionAndStatus(
		long sectionId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first single user onboarding in the ordered set where sectionId = &#63; and status = &#63;.
	 *
	 * @param sectionId the section ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding findBySectionAndStatus_First(
			long sectionId, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Returns the first single user onboarding in the ordered set where sectionId = &#63; and status = &#63;.
	 *
	 * @param sectionId the section ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding fetchBySectionAndStatus_First(
		long sectionId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

	/**
	 * Returns the last single user onboarding in the ordered set where sectionId = &#63; and status = &#63;.
	 *
	 * @param sectionId the section ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding findBySectionAndStatus_Last(
			long sectionId, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Returns the last single user onboarding in the ordered set where sectionId = &#63; and status = &#63;.
	 *
	 * @param sectionId the section ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding fetchBySectionAndStatus_Last(
		long sectionId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

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
	public SingleUserOnboarding[] findBySectionAndStatus_PrevAndNext(
			long singleUserRegistrationId, long sectionId, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Removes all the single user onboardings where sectionId = &#63; and status = &#63; from the database.
	 *
	 * @param sectionId the section ID
	 * @param status the status
	 */
	public void removeBySectionAndStatus(long sectionId, int status);

	/**
	 * Returns the number of single user onboardings where sectionId = &#63; and status = &#63;.
	 *
	 * @param sectionId the section ID
	 * @param status the status
	 * @return the number of matching single user onboardings
	 */
	public int countBySectionAndStatus(long sectionId, int status);

	/**
	 * Returns all the single user onboardings where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching single user onboardings
	 */
	public java.util.List<SingleUserOnboarding> findByGroupId(long groupId);

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
	public java.util.List<SingleUserOnboarding> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<SingleUserOnboarding> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

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
	public java.util.List<SingleUserOnboarding> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first single user onboarding in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Returns the first single user onboarding in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

	/**
	 * Returns the last single user onboarding in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Returns the last single user onboarding in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where groupId = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	public SingleUserOnboarding[] findByGroupId_PrevAndNext(
			long singleUserRegistrationId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Removes all the single user onboardings where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of single user onboardings where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching single user onboardings
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the single user onboardings where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching single user onboardings
	 */
	public java.util.List<SingleUserOnboarding> findByUserId(long userId);

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
	public java.util.List<SingleUserOnboarding> findByUserId(
		long userId, int start, int end);

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
	public java.util.List<SingleUserOnboarding> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

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
	public java.util.List<SingleUserOnboarding> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first single user onboarding in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Returns the first single user onboarding in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

	/**
	 * Returns the last single user onboarding in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Returns the last single user onboarding in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where userId = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	public SingleUserOnboarding[] findByUserId_PrevAndNext(
			long singleUserRegistrationId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Removes all the single user onboardings where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of single user onboardings where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching single user onboardings
	 */
	public int countByUserId(long userId);

	/**
	 * Returns all the single user onboardings where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @return the matching single user onboardings
	 */
	public java.util.List<SingleUserOnboarding> findByPersonalNo(
		long personalNo);

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
	public java.util.List<SingleUserOnboarding> findByPersonalNo(
		long personalNo, int start, int end);

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
	public java.util.List<SingleUserOnboarding> findByPersonalNo(
		long personalNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

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
	public java.util.List<SingleUserOnboarding> findByPersonalNo(
		long personalNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first single user onboarding in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding findByPersonalNo_First(
			long personalNo,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Returns the first single user onboarding in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding fetchByPersonalNo_First(
		long personalNo,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

	/**
	 * Returns the last single user onboarding in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding findByPersonalNo_Last(
			long personalNo,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Returns the last single user onboarding in the ordered set where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding fetchByPersonalNo_Last(
		long personalNo,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where personalNo = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param personalNo the personal no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	public SingleUserOnboarding[] findByPersonalNo_PrevAndNext(
			long singleUserRegistrationId, long personalNo,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Removes all the single user onboardings where personalNo = &#63; from the database.
	 *
	 * @param personalNo the personal no
	 */
	public void removeByPersonalNo(long personalNo);

	/**
	 * Returns the number of single user onboardings where personalNo = &#63;.
	 *
	 * @param personalNo the personal no
	 * @return the number of matching single user onboardings
	 */
	public int countByPersonalNo(long personalNo);

	/**
	 * Returns all the single user onboardings where recordNo = &#63;.
	 *
	 * @param recordNo the record no
	 * @return the matching single user onboardings
	 */
	public java.util.List<SingleUserOnboarding> findByRecordNo(long recordNo);

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
	public java.util.List<SingleUserOnboarding> findByRecordNo(
		long recordNo, int start, int end);

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
	public java.util.List<SingleUserOnboarding> findByRecordNo(
		long recordNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

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
	public java.util.List<SingleUserOnboarding> findByRecordNo(
		long recordNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first single user onboarding in the ordered set where recordNo = &#63;.
	 *
	 * @param recordNo the record no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding findByRecordNo_First(
			long recordNo,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Returns the first single user onboarding in the ordered set where recordNo = &#63;.
	 *
	 * @param recordNo the record no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding fetchByRecordNo_First(
		long recordNo,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

	/**
	 * Returns the last single user onboarding in the ordered set where recordNo = &#63;.
	 *
	 * @param recordNo the record no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding findByRecordNo_Last(
			long recordNo,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Returns the last single user onboarding in the ordered set where recordNo = &#63;.
	 *
	 * @param recordNo the record no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding fetchByRecordNo_Last(
		long recordNo,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where recordNo = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param recordNo the record no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	public SingleUserOnboarding[] findByRecordNo_PrevAndNext(
			long singleUserRegistrationId, long recordNo,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Removes all the single user onboardings where recordNo = &#63; from the database.
	 *
	 * @param recordNo the record no
	 */
	public void removeByRecordNo(long recordNo);

	/**
	 * Returns the number of single user onboardings where recordNo = &#63;.
	 *
	 * @param recordNo the record no
	 * @return the number of matching single user onboardings
	 */
	public int countByRecordNo(long recordNo);

	/**
	 * Returns all the single user onboardings where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the matching single user onboardings
	 */
	public java.util.List<SingleUserOnboarding> findByEmailAddress(
		String emailAddress);

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
	public java.util.List<SingleUserOnboarding> findByEmailAddress(
		String emailAddress, int start, int end);

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
	public java.util.List<SingleUserOnboarding> findByEmailAddress(
		String emailAddress, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

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
	public java.util.List<SingleUserOnboarding> findByEmailAddress(
		String emailAddress, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first single user onboarding in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding findByEmailAddress_First(
			String emailAddress,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Returns the first single user onboarding in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding fetchByEmailAddress_First(
		String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

	/**
	 * Returns the last single user onboarding in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding findByEmailAddress_Last(
			String emailAddress,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Returns the last single user onboarding in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding fetchByEmailAddress_Last(
		String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

	/**
	 * Returns the single user onboardings before and after the current single user onboarding in the ordered set where emailAddress = &#63;.
	 *
	 * @param singleUserRegistrationId the primary key of the current single user onboarding
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	public SingleUserOnboarding[] findByEmailAddress_PrevAndNext(
			long singleUserRegistrationId, String emailAddress,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Removes all the single user onboardings where emailAddress = &#63; from the database.
	 *
	 * @param emailAddress the email address
	 */
	public void removeByEmailAddress(String emailAddress);

	/**
	 * Returns the number of single user onboardings where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the number of matching single user onboardings
	 */
	public int countByEmailAddress(String emailAddress);

	/**
	 * Returns all the single user onboardings where loginId = &#63; and status = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @return the matching single user onboardings
	 */
	public java.util.List<SingleUserOnboarding> findByLoginIdAndStatus(
		String loginId, int status);

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
	public java.util.List<SingleUserOnboarding> findByLoginIdAndStatus(
		String loginId, int status, int start, int end);

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
	public java.util.List<SingleUserOnboarding> findByLoginIdAndStatus(
		String loginId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

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
	public java.util.List<SingleUserOnboarding> findByLoginIdAndStatus(
		String loginId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first single user onboarding in the ordered set where loginId = &#63; and status = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding findByLoginIdAndStatus_First(
			String loginId, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Returns the first single user onboarding in the ordered set where loginId = &#63; and status = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding fetchByLoginIdAndStatus_First(
		String loginId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

	/**
	 * Returns the last single user onboarding in the ordered set where loginId = &#63; and status = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding findByLoginIdAndStatus_Last(
			String loginId, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Returns the last single user onboarding in the ordered set where loginId = &#63; and status = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching single user onboarding, or <code>null</code> if a matching single user onboarding could not be found
	 */
	public SingleUserOnboarding fetchByLoginIdAndStatus_Last(
		String loginId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

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
	public SingleUserOnboarding[] findByLoginIdAndStatus_PrevAndNext(
			long singleUserRegistrationId, String loginId, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Removes all the single user onboardings where loginId = &#63; and status = &#63; from the database.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 */
	public void removeByLoginIdAndStatus(String loginId, int status);

	/**
	 * Returns the number of single user onboardings where loginId = &#63; and status = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @return the number of matching single user onboardings
	 */
	public int countByLoginIdAndStatus(String loginId, int status);

	/**
	 * Returns all the single user onboardings where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @return the matching single user onboardings
	 */
	public java.util.List<SingleUserOnboarding>
		findByLoginIdStatusStateAndIdamUserCreated(
			String loginId, int status, String state, boolean idamUserCreated);

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
	public java.util.List<SingleUserOnboarding>
		findByLoginIdStatusStateAndIdamUserCreated(
			String loginId, int status, String state, boolean idamUserCreated,
			int start, int end);

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
	public java.util.List<SingleUserOnboarding>
		findByLoginIdStatusStateAndIdamUserCreated(
			String loginId, int status, String state, boolean idamUserCreated,
			int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator);

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
	public java.util.List<SingleUserOnboarding>
		findByLoginIdStatusStateAndIdamUserCreated(
			String loginId, int status, String state, boolean idamUserCreated,
			int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator,
			boolean useFinderCache);

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
	public SingleUserOnboarding
			findByLoginIdStatusStateAndIdamUserCreated_First(
				String loginId, int status, String state,
				boolean idamUserCreated,
				com.liferay.portal.kernel.util.OrderByComparator
					<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

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
	public SingleUserOnboarding
		fetchByLoginIdStatusStateAndIdamUserCreated_First(
			String loginId, int status, String state, boolean idamUserCreated,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator);

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
	public SingleUserOnboarding findByLoginIdStatusStateAndIdamUserCreated_Last(
			String loginId, int status, String state, boolean idamUserCreated,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

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
	public SingleUserOnboarding
		fetchByLoginIdStatusStateAndIdamUserCreated_Last(
			String loginId, int status, String state, boolean idamUserCreated,
			com.liferay.portal.kernel.util.OrderByComparator
				<SingleUserOnboarding> orderByComparator);

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
	public SingleUserOnboarding[]
			findByLoginIdStatusStateAndIdamUserCreated_PrevAndNext(
				long singleUserRegistrationId, String loginId, int status,
				String state, boolean idamUserCreated,
				com.liferay.portal.kernel.util.OrderByComparator
					<SingleUserOnboarding> orderByComparator)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Removes all the single user onboardings where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63; from the database.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 */
	public void removeByLoginIdStatusStateAndIdamUserCreated(
		String loginId, int status, String state, boolean idamUserCreated);

	/**
	 * Returns the number of single user onboardings where loginId = &#63; and status = &#63; and state = &#63; and idamUserCreated = &#63;.
	 *
	 * @param loginId the login ID
	 * @param status the status
	 * @param state the state
	 * @param idamUserCreated the idam user created
	 * @return the number of matching single user onboardings
	 */
	public int countByLoginIdStatusStateAndIdamUserCreated(
		String loginId, int status, String state, boolean idamUserCreated);

	/**
	 * Caches the single user onboarding in the entity cache if it is enabled.
	 *
	 * @param singleUserOnboarding the single user onboarding
	 */
	public void cacheResult(SingleUserOnboarding singleUserOnboarding);

	/**
	 * Caches the single user onboardings in the entity cache if it is enabled.
	 *
	 * @param singleUserOnboardings the single user onboardings
	 */
	public void cacheResult(
		java.util.List<SingleUserOnboarding> singleUserOnboardings);

	/**
	 * Creates a new single user onboarding with the primary key. Does not add the single user onboarding to the database.
	 *
	 * @param singleUserRegistrationId the primary key for the new single user onboarding
	 * @return the new single user onboarding
	 */
	public SingleUserOnboarding create(long singleUserRegistrationId);

	/**
	 * Removes the single user onboarding with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param singleUserRegistrationId the primary key of the single user onboarding
	 * @return the single user onboarding that was removed
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	public SingleUserOnboarding remove(long singleUserRegistrationId)
		throws NoSuchSingleUserOnboardingException;

	public SingleUserOnboarding updateImpl(
		SingleUserOnboarding singleUserOnboarding);

	/**
	 * Returns the single user onboarding with the primary key or throws a <code>NoSuchSingleUserOnboardingException</code> if it could not be found.
	 *
	 * @param singleUserRegistrationId the primary key of the single user onboarding
	 * @return the single user onboarding
	 * @throws NoSuchSingleUserOnboardingException if a single user onboarding with the primary key could not be found
	 */
	public SingleUserOnboarding findByPrimaryKey(long singleUserRegistrationId)
		throws NoSuchSingleUserOnboardingException;

	/**
	 * Returns the single user onboarding with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param singleUserRegistrationId the primary key of the single user onboarding
	 * @return the single user onboarding, or <code>null</code> if a single user onboarding with the primary key could not be found
	 */
	public SingleUserOnboarding fetchByPrimaryKey(
		long singleUserRegistrationId);

	/**
	 * Returns all the single user onboardings.
	 *
	 * @return the single user onboardings
	 */
	public java.util.List<SingleUserOnboarding> findAll();

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
	public java.util.List<SingleUserOnboarding> findAll(int start, int end);

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
	public java.util.List<SingleUserOnboarding> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator);

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
	public java.util.List<SingleUserOnboarding> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SingleUserOnboarding>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the single user onboardings from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of single user onboardings.
	 *
	 * @return the number of single user onboardings
	 */
	public int countAll();

}