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

import com.adjecti.pis.liferay.exception.NoSuchFamilyHealthDetailException;
import com.adjecti.pis.liferay.model.FamilyHealthDetail;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the family health detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FamilyHealthDetailUtil
 * @generated
 */
@ProviderType
public interface FamilyHealthDetailPersistence
	extends BasePersistence<FamilyHealthDetail> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FamilyHealthDetailUtil} to access the family health detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the family health detail in the entity cache if it is enabled.
	 *
	 * @param familyHealthDetail the family health detail
	 */
	public void cacheResult(FamilyHealthDetail familyHealthDetail);

	/**
	 * Caches the family health details in the entity cache if it is enabled.
	 *
	 * @param familyHealthDetails the family health details
	 */
	public void cacheResult(
		java.util.List<FamilyHealthDetail> familyHealthDetails);

	/**
	 * Creates a new family health detail with the primary key. Does not add the family health detail to the database.
	 *
	 * @param familyHealthDetailId the primary key for the new family health detail
	 * @return the new family health detail
	 */
	public FamilyHealthDetail create(long familyHealthDetailId);

	/**
	 * Removes the family health detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param familyHealthDetailId the primary key of the family health detail
	 * @return the family health detail that was removed
	 * @throws NoSuchFamilyHealthDetailException if a family health detail with the primary key could not be found
	 */
	public FamilyHealthDetail remove(long familyHealthDetailId)
		throws NoSuchFamilyHealthDetailException;

	public FamilyHealthDetail updateImpl(FamilyHealthDetail familyHealthDetail);

	/**
	 * Returns the family health detail with the primary key or throws a <code>NoSuchFamilyHealthDetailException</code> if it could not be found.
	 *
	 * @param familyHealthDetailId the primary key of the family health detail
	 * @return the family health detail
	 * @throws NoSuchFamilyHealthDetailException if a family health detail with the primary key could not be found
	 */
	public FamilyHealthDetail findByPrimaryKey(long familyHealthDetailId)
		throws NoSuchFamilyHealthDetailException;

	/**
	 * Returns the family health detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param familyHealthDetailId the primary key of the family health detail
	 * @return the family health detail, or <code>null</code> if a family health detail with the primary key could not be found
	 */
	public FamilyHealthDetail fetchByPrimaryKey(long familyHealthDetailId);

	/**
	 * Returns all the family health details.
	 *
	 * @return the family health details
	 */
	public java.util.List<FamilyHealthDetail> findAll();

	/**
	 * Returns a range of all the family health details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FamilyHealthDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family health details
	 * @param end the upper bound of the range of family health details (not inclusive)
	 * @return the range of family health details
	 */
	public java.util.List<FamilyHealthDetail> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the family health details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FamilyHealthDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family health details
	 * @param end the upper bound of the range of family health details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of family health details
	 */
	public java.util.List<FamilyHealthDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FamilyHealthDetail>
			orderByComparator);

	/**
	 * Returns an ordered range of all the family health details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FamilyHealthDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family health details
	 * @param end the upper bound of the range of family health details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of family health details
	 */
	public java.util.List<FamilyHealthDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FamilyHealthDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the family health details from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of family health details.
	 *
	 * @return the number of family health details
	 */
	public int countAll();

}