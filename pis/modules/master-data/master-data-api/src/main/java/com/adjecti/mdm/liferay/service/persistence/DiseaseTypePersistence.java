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

import com.adjecti.mdm.liferay.exception.NoSuchDiseaseTypeException;
import com.adjecti.mdm.liferay.model.DiseaseType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the disease type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DiseaseTypeUtil
 * @generated
 */
@ProviderType
public interface DiseaseTypePersistence extends BasePersistence<DiseaseType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DiseaseTypeUtil} to access the disease type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the disease type in the entity cache if it is enabled.
	 *
	 * @param diseaseType the disease type
	 */
	public void cacheResult(DiseaseType diseaseType);

	/**
	 * Caches the disease types in the entity cache if it is enabled.
	 *
	 * @param diseaseTypes the disease types
	 */
	public void cacheResult(java.util.List<DiseaseType> diseaseTypes);

	/**
	 * Creates a new disease type with the primary key. Does not add the disease type to the database.
	 *
	 * @param diseaseTypeId the primary key for the new disease type
	 * @return the new disease type
	 */
	public DiseaseType create(long diseaseTypeId);

	/**
	 * Removes the disease type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param diseaseTypeId the primary key of the disease type
	 * @return the disease type that was removed
	 * @throws NoSuchDiseaseTypeException if a disease type with the primary key could not be found
	 */
	public DiseaseType remove(long diseaseTypeId)
		throws NoSuchDiseaseTypeException;

	public DiseaseType updateImpl(DiseaseType diseaseType);

	/**
	 * Returns the disease type with the primary key or throws a <code>NoSuchDiseaseTypeException</code> if it could not be found.
	 *
	 * @param diseaseTypeId the primary key of the disease type
	 * @return the disease type
	 * @throws NoSuchDiseaseTypeException if a disease type with the primary key could not be found
	 */
	public DiseaseType findByPrimaryKey(long diseaseTypeId)
		throws NoSuchDiseaseTypeException;

	/**
	 * Returns the disease type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param diseaseTypeId the primary key of the disease type
	 * @return the disease type, or <code>null</code> if a disease type with the primary key could not be found
	 */
	public DiseaseType fetchByPrimaryKey(long diseaseTypeId);

	/**
	 * Returns all the disease types.
	 *
	 * @return the disease types
	 */
	public java.util.List<DiseaseType> findAll();

	/**
	 * Returns a range of all the disease types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DiseaseTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of disease types
	 * @param end the upper bound of the range of disease types (not inclusive)
	 * @return the range of disease types
	 */
	public java.util.List<DiseaseType> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the disease types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DiseaseTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of disease types
	 * @param end the upper bound of the range of disease types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of disease types
	 */
	public java.util.List<DiseaseType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DiseaseType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the disease types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DiseaseTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of disease types
	 * @param end the upper bound of the range of disease types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of disease types
	 */
	public java.util.List<DiseaseType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DiseaseType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the disease types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of disease types.
	 *
	 * @return the number of disease types
	 */
	public int countAll();

}