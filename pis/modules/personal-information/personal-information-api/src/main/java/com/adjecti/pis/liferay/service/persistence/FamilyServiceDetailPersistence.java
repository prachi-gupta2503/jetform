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

import com.adjecti.pis.liferay.exception.NoSuchFamilyServiceDetailException;
import com.adjecti.pis.liferay.model.FamilyServiceDetail;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the family service detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FamilyServiceDetailUtil
 * @generated
 */
@ProviderType
public interface FamilyServiceDetailPersistence
	extends BasePersistence<FamilyServiceDetail> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FamilyServiceDetailUtil} to access the family service detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the family service detail in the entity cache if it is enabled.
	 *
	 * @param familyServiceDetail the family service detail
	 */
	public void cacheResult(FamilyServiceDetail familyServiceDetail);

	/**
	 * Caches the family service details in the entity cache if it is enabled.
	 *
	 * @param familyServiceDetails the family service details
	 */
	public void cacheResult(
		java.util.List<FamilyServiceDetail> familyServiceDetails);

	/**
	 * Creates a new family service detail with the primary key. Does not add the family service detail to the database.
	 *
	 * @param familyServiceDetailId the primary key for the new family service detail
	 * @return the new family service detail
	 */
	public FamilyServiceDetail create(long familyServiceDetailId);

	/**
	 * Removes the family service detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param familyServiceDetailId the primary key of the family service detail
	 * @return the family service detail that was removed
	 * @throws NoSuchFamilyServiceDetailException if a family service detail with the primary key could not be found
	 */
	public FamilyServiceDetail remove(long familyServiceDetailId)
		throws NoSuchFamilyServiceDetailException;

	public FamilyServiceDetail updateImpl(
		FamilyServiceDetail familyServiceDetail);

	/**
	 * Returns the family service detail with the primary key or throws a <code>NoSuchFamilyServiceDetailException</code> if it could not be found.
	 *
	 * @param familyServiceDetailId the primary key of the family service detail
	 * @return the family service detail
	 * @throws NoSuchFamilyServiceDetailException if a family service detail with the primary key could not be found
	 */
	public FamilyServiceDetail findByPrimaryKey(long familyServiceDetailId)
		throws NoSuchFamilyServiceDetailException;

	/**
	 * Returns the family service detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param familyServiceDetailId the primary key of the family service detail
	 * @return the family service detail, or <code>null</code> if a family service detail with the primary key could not be found
	 */
	public FamilyServiceDetail fetchByPrimaryKey(long familyServiceDetailId);

	/**
	 * Returns all the family service details.
	 *
	 * @return the family service details
	 */
	public java.util.List<FamilyServiceDetail> findAll();

	/**
	 * Returns a range of all the family service details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FamilyServiceDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family service details
	 * @param end the upper bound of the range of family service details (not inclusive)
	 * @return the range of family service details
	 */
	public java.util.List<FamilyServiceDetail> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the family service details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FamilyServiceDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family service details
	 * @param end the upper bound of the range of family service details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of family service details
	 */
	public java.util.List<FamilyServiceDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FamilyServiceDetail>
			orderByComparator);

	/**
	 * Returns an ordered range of all the family service details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FamilyServiceDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family service details
	 * @param end the upper bound of the range of family service details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of family service details
	 */
	public java.util.List<FamilyServiceDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FamilyServiceDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the family service details from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of family service details.
	 *
	 * @return the number of family service details
	 */
	public int countAll();

}