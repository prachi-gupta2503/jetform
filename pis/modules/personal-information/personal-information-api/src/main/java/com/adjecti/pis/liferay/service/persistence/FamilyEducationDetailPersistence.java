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

import com.adjecti.pis.liferay.exception.NoSuchFamilyEducationDetailException;
import com.adjecti.pis.liferay.model.FamilyEducationDetail;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the family education detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FamilyEducationDetailUtil
 * @generated
 */
@ProviderType
public interface FamilyEducationDetailPersistence
	extends BasePersistence<FamilyEducationDetail> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FamilyEducationDetailUtil} to access the family education detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the family education detail in the entity cache if it is enabled.
	 *
	 * @param familyEducationDetail the family education detail
	 */
	public void cacheResult(FamilyEducationDetail familyEducationDetail);

	/**
	 * Caches the family education details in the entity cache if it is enabled.
	 *
	 * @param familyEducationDetails the family education details
	 */
	public void cacheResult(
		java.util.List<FamilyEducationDetail> familyEducationDetails);

	/**
	 * Creates a new family education detail with the primary key. Does not add the family education detail to the database.
	 *
	 * @param familyEducationDetailId the primary key for the new family education detail
	 * @return the new family education detail
	 */
	public FamilyEducationDetail create(long familyEducationDetailId);

	/**
	 * Removes the family education detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param familyEducationDetailId the primary key of the family education detail
	 * @return the family education detail that was removed
	 * @throws NoSuchFamilyEducationDetailException if a family education detail with the primary key could not be found
	 */
	public FamilyEducationDetail remove(long familyEducationDetailId)
		throws NoSuchFamilyEducationDetailException;

	public FamilyEducationDetail updateImpl(
		FamilyEducationDetail familyEducationDetail);

	/**
	 * Returns the family education detail with the primary key or throws a <code>NoSuchFamilyEducationDetailException</code> if it could not be found.
	 *
	 * @param familyEducationDetailId the primary key of the family education detail
	 * @return the family education detail
	 * @throws NoSuchFamilyEducationDetailException if a family education detail with the primary key could not be found
	 */
	public FamilyEducationDetail findByPrimaryKey(long familyEducationDetailId)
		throws NoSuchFamilyEducationDetailException;

	/**
	 * Returns the family education detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param familyEducationDetailId the primary key of the family education detail
	 * @return the family education detail, or <code>null</code> if a family education detail with the primary key could not be found
	 */
	public FamilyEducationDetail fetchByPrimaryKey(
		long familyEducationDetailId);

	/**
	 * Returns all the family education details.
	 *
	 * @return the family education details
	 */
	public java.util.List<FamilyEducationDetail> findAll();

	/**
	 * Returns a range of all the family education details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FamilyEducationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family education details
	 * @param end the upper bound of the range of family education details (not inclusive)
	 * @return the range of family education details
	 */
	public java.util.List<FamilyEducationDetail> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the family education details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FamilyEducationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family education details
	 * @param end the upper bound of the range of family education details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of family education details
	 */
	public java.util.List<FamilyEducationDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FamilyEducationDetail>
			orderByComparator);

	/**
	 * Returns an ordered range of all the family education details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FamilyEducationDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family education details
	 * @param end the upper bound of the range of family education details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of family education details
	 */
	public java.util.List<FamilyEducationDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FamilyEducationDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the family education details from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of family education details.
	 *
	 * @return the number of family education details
	 */
	public int countAll();

}