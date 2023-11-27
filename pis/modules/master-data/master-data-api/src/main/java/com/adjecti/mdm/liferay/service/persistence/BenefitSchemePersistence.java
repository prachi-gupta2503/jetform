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

import com.adjecti.mdm.liferay.exception.NoSuchBenefitSchemeException;
import com.adjecti.mdm.liferay.model.BenefitScheme;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the benefit scheme service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BenefitSchemeUtil
 * @generated
 */
@ProviderType
public interface BenefitSchemePersistence
	extends BasePersistence<BenefitScheme> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BenefitSchemeUtil} to access the benefit scheme persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the benefit scheme in the entity cache if it is enabled.
	 *
	 * @param benefitScheme the benefit scheme
	 */
	public void cacheResult(BenefitScheme benefitScheme);

	/**
	 * Caches the benefit schemes in the entity cache if it is enabled.
	 *
	 * @param benefitSchemes the benefit schemes
	 */
	public void cacheResult(java.util.List<BenefitScheme> benefitSchemes);

	/**
	 * Creates a new benefit scheme with the primary key. Does not add the benefit scheme to the database.
	 *
	 * @param benefitSchemeId the primary key for the new benefit scheme
	 * @return the new benefit scheme
	 */
	public BenefitScheme create(long benefitSchemeId);

	/**
	 * Removes the benefit scheme with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param benefitSchemeId the primary key of the benefit scheme
	 * @return the benefit scheme that was removed
	 * @throws NoSuchBenefitSchemeException if a benefit scheme with the primary key could not be found
	 */
	public BenefitScheme remove(long benefitSchemeId)
		throws NoSuchBenefitSchemeException;

	public BenefitScheme updateImpl(BenefitScheme benefitScheme);

	/**
	 * Returns the benefit scheme with the primary key or throws a <code>NoSuchBenefitSchemeException</code> if it could not be found.
	 *
	 * @param benefitSchemeId the primary key of the benefit scheme
	 * @return the benefit scheme
	 * @throws NoSuchBenefitSchemeException if a benefit scheme with the primary key could not be found
	 */
	public BenefitScheme findByPrimaryKey(long benefitSchemeId)
		throws NoSuchBenefitSchemeException;

	/**
	 * Returns the benefit scheme with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param benefitSchemeId the primary key of the benefit scheme
	 * @return the benefit scheme, or <code>null</code> if a benefit scheme with the primary key could not be found
	 */
	public BenefitScheme fetchByPrimaryKey(long benefitSchemeId);

	/**
	 * Returns all the benefit schemes.
	 *
	 * @return the benefit schemes
	 */
	public java.util.List<BenefitScheme> findAll();

	/**
	 * Returns a range of all the benefit schemes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BenefitSchemeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of benefit schemes
	 * @param end the upper bound of the range of benefit schemes (not inclusive)
	 * @return the range of benefit schemes
	 */
	public java.util.List<BenefitScheme> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the benefit schemes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BenefitSchemeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of benefit schemes
	 * @param end the upper bound of the range of benefit schemes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of benefit schemes
	 */
	public java.util.List<BenefitScheme> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BenefitScheme>
			orderByComparator);

	/**
	 * Returns an ordered range of all the benefit schemes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BenefitSchemeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of benefit schemes
	 * @param end the upper bound of the range of benefit schemes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of benefit schemes
	 */
	public java.util.List<BenefitScheme> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BenefitScheme>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the benefit schemes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of benefit schemes.
	 *
	 * @return the number of benefit schemes
	 */
	public int countAll();

}