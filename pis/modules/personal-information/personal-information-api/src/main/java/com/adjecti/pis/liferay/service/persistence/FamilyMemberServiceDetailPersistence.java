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

import com.adjecti.pis.liferay.exception.NoSuchFamilyMemberServiceDetailException;
import com.adjecti.pis.liferay.model.FamilyMemberServiceDetail;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the family member service detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FamilyMemberServiceDetailUtil
 * @generated
 */
@ProviderType
public interface FamilyMemberServiceDetailPersistence
	extends BasePersistence<FamilyMemberServiceDetail> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FamilyMemberServiceDetailUtil} to access the family member service detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the family member service detail in the entity cache if it is enabled.
	 *
	 * @param familyMemberServiceDetail the family member service detail
	 */
	public void cacheResult(
		FamilyMemberServiceDetail familyMemberServiceDetail);

	/**
	 * Caches the family member service details in the entity cache if it is enabled.
	 *
	 * @param familyMemberServiceDetails the family member service details
	 */
	public void cacheResult(
		java.util.List<FamilyMemberServiceDetail> familyMemberServiceDetails);

	/**
	 * Creates a new family member service detail with the primary key. Does not add the family member service detail to the database.
	 *
	 * @param familyMemberServiceDetailId the primary key for the new family member service detail
	 * @return the new family member service detail
	 */
	public FamilyMemberServiceDetail create(long familyMemberServiceDetailId);

	/**
	 * Removes the family member service detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param familyMemberServiceDetailId the primary key of the family member service detail
	 * @return the family member service detail that was removed
	 * @throws NoSuchFamilyMemberServiceDetailException if a family member service detail with the primary key could not be found
	 */
	public FamilyMemberServiceDetail remove(long familyMemberServiceDetailId)
		throws NoSuchFamilyMemberServiceDetailException;

	public FamilyMemberServiceDetail updateImpl(
		FamilyMemberServiceDetail familyMemberServiceDetail);

	/**
	 * Returns the family member service detail with the primary key or throws a <code>NoSuchFamilyMemberServiceDetailException</code> if it could not be found.
	 *
	 * @param familyMemberServiceDetailId the primary key of the family member service detail
	 * @return the family member service detail
	 * @throws NoSuchFamilyMemberServiceDetailException if a family member service detail with the primary key could not be found
	 */
	public FamilyMemberServiceDetail findByPrimaryKey(
			long familyMemberServiceDetailId)
		throws NoSuchFamilyMemberServiceDetailException;

	/**
	 * Returns the family member service detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param familyMemberServiceDetailId the primary key of the family member service detail
	 * @return the family member service detail, or <code>null</code> if a family member service detail with the primary key could not be found
	 */
	public FamilyMemberServiceDetail fetchByPrimaryKey(
		long familyMemberServiceDetailId);

	/**
	 * Returns all the family member service details.
	 *
	 * @return the family member service details
	 */
	public java.util.List<FamilyMemberServiceDetail> findAll();

	/**
	 * Returns a range of all the family member service details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FamilyMemberServiceDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family member service details
	 * @param end the upper bound of the range of family member service details (not inclusive)
	 * @return the range of family member service details
	 */
	public java.util.List<FamilyMemberServiceDetail> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the family member service details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FamilyMemberServiceDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family member service details
	 * @param end the upper bound of the range of family member service details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of family member service details
	 */
	public java.util.List<FamilyMemberServiceDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<FamilyMemberServiceDetail> orderByComparator);

	/**
	 * Returns an ordered range of all the family member service details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FamilyMemberServiceDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family member service details
	 * @param end the upper bound of the range of family member service details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of family member service details
	 */
	public java.util.List<FamilyMemberServiceDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<FamilyMemberServiceDetail> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the family member service details from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of family member service details.
	 *
	 * @return the number of family member service details
	 */
	public int countAll();

}