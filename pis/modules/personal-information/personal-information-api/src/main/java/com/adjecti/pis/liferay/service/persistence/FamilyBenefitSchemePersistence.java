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

import com.adjecti.pis.liferay.exception.NoSuchFamilyBenefitSchemeException;
import com.adjecti.pis.liferay.model.FamilyBenefitScheme;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the family benefit scheme service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FamilyBenefitSchemeUtil
 * @generated
 */
@ProviderType
public interface FamilyBenefitSchemePersistence
	extends BasePersistence<FamilyBenefitScheme> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FamilyBenefitSchemeUtil} to access the family benefit scheme persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the family benefit scheme in the entity cache if it is enabled.
	 *
	 * @param familyBenefitScheme the family benefit scheme
	 */
	public void cacheResult(FamilyBenefitScheme familyBenefitScheme);

	/**
	 * Caches the family benefit schemes in the entity cache if it is enabled.
	 *
	 * @param familyBenefitSchemes the family benefit schemes
	 */
	public void cacheResult(
		java.util.List<FamilyBenefitScheme> familyBenefitSchemes);

	/**
	 * Creates a new family benefit scheme with the primary key. Does not add the family benefit scheme to the database.
	 *
	 * @param familyBenefitSchemeId the primary key for the new family benefit scheme
	 * @return the new family benefit scheme
	 */
	public FamilyBenefitScheme create(long familyBenefitSchemeId);

	/**
	 * Removes the family benefit scheme with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param familyBenefitSchemeId the primary key of the family benefit scheme
	 * @return the family benefit scheme that was removed
	 * @throws NoSuchFamilyBenefitSchemeException if a family benefit scheme with the primary key could not be found
	 */
	public FamilyBenefitScheme remove(long familyBenefitSchemeId)
		throws NoSuchFamilyBenefitSchemeException;

	public FamilyBenefitScheme updateImpl(
		FamilyBenefitScheme familyBenefitScheme);

	/**
	 * Returns the family benefit scheme with the primary key or throws a <code>NoSuchFamilyBenefitSchemeException</code> if it could not be found.
	 *
	 * @param familyBenefitSchemeId the primary key of the family benefit scheme
	 * @return the family benefit scheme
	 * @throws NoSuchFamilyBenefitSchemeException if a family benefit scheme with the primary key could not be found
	 */
	public FamilyBenefitScheme findByPrimaryKey(long familyBenefitSchemeId)
		throws NoSuchFamilyBenefitSchemeException;

	/**
	 * Returns the family benefit scheme with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param familyBenefitSchemeId the primary key of the family benefit scheme
	 * @return the family benefit scheme, or <code>null</code> if a family benefit scheme with the primary key could not be found
	 */
	public FamilyBenefitScheme fetchByPrimaryKey(long familyBenefitSchemeId);

	/**
	 * Returns all the family benefit schemes.
	 *
	 * @return the family benefit schemes
	 */
	public java.util.List<FamilyBenefitScheme> findAll();

	/**
	 * Returns a range of all the family benefit schemes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FamilyBenefitSchemeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family benefit schemes
	 * @param end the upper bound of the range of family benefit schemes (not inclusive)
	 * @return the range of family benefit schemes
	 */
	public java.util.List<FamilyBenefitScheme> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the family benefit schemes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FamilyBenefitSchemeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family benefit schemes
	 * @param end the upper bound of the range of family benefit schemes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of family benefit schemes
	 */
	public java.util.List<FamilyBenefitScheme> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FamilyBenefitScheme>
			orderByComparator);

	/**
	 * Returns an ordered range of all the family benefit schemes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FamilyBenefitSchemeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family benefit schemes
	 * @param end the upper bound of the range of family benefit schemes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of family benefit schemes
	 */
	public java.util.List<FamilyBenefitScheme> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FamilyBenefitScheme>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the family benefit schemes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of family benefit schemes.
	 *
	 * @return the number of family benefit schemes
	 */
	public int countAll();

}