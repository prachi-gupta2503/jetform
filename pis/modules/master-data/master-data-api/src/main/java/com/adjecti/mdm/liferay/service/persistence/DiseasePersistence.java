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

import com.adjecti.mdm.liferay.exception.NoSuchDiseaseException;
import com.adjecti.mdm.liferay.model.Disease;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the disease service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DiseaseUtil
 * @generated
 */
@ProviderType
public interface DiseasePersistence extends BasePersistence<Disease> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DiseaseUtil} to access the disease persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the disease in the entity cache if it is enabled.
	 *
	 * @param disease the disease
	 */
	public void cacheResult(Disease disease);

	/**
	 * Caches the diseases in the entity cache if it is enabled.
	 *
	 * @param diseases the diseases
	 */
	public void cacheResult(java.util.List<Disease> diseases);

	/**
	 * Creates a new disease with the primary key. Does not add the disease to the database.
	 *
	 * @param diseaseId the primary key for the new disease
	 * @return the new disease
	 */
	public Disease create(long diseaseId);

	/**
	 * Removes the disease with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param diseaseId the primary key of the disease
	 * @return the disease that was removed
	 * @throws NoSuchDiseaseException if a disease with the primary key could not be found
	 */
	public Disease remove(long diseaseId) throws NoSuchDiseaseException;

	public Disease updateImpl(Disease disease);

	/**
	 * Returns the disease with the primary key or throws a <code>NoSuchDiseaseException</code> if it could not be found.
	 *
	 * @param diseaseId the primary key of the disease
	 * @return the disease
	 * @throws NoSuchDiseaseException if a disease with the primary key could not be found
	 */
	public Disease findByPrimaryKey(long diseaseId)
		throws NoSuchDiseaseException;

	/**
	 * Returns the disease with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param diseaseId the primary key of the disease
	 * @return the disease, or <code>null</code> if a disease with the primary key could not be found
	 */
	public Disease fetchByPrimaryKey(long diseaseId);

	/**
	 * Returns all the diseases.
	 *
	 * @return the diseases
	 */
	public java.util.List<Disease> findAll();

	/**
	 * Returns a range of all the diseases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DiseaseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of diseases
	 * @param end the upper bound of the range of diseases (not inclusive)
	 * @return the range of diseases
	 */
	public java.util.List<Disease> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the diseases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DiseaseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of diseases
	 * @param end the upper bound of the range of diseases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of diseases
	 */
	public java.util.List<Disease> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Disease>
			orderByComparator);

	/**
	 * Returns an ordered range of all the diseases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DiseaseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of diseases
	 * @param end the upper bound of the range of diseases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of diseases
	 */
	public java.util.List<Disease> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Disease>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the diseases from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of diseases.
	 *
	 * @return the number of diseases
	 */
	public int countAll();

}