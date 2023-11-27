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

import com.adjecti.mdm.liferay.exception.NoSuchFamilyRelationException;
import com.adjecti.mdm.liferay.model.FamilyRelation;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the family relation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FamilyRelationUtil
 * @generated
 */
@ProviderType
public interface FamilyRelationPersistence
	extends BasePersistence<FamilyRelation> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FamilyRelationUtil} to access the family relation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the family relation in the entity cache if it is enabled.
	 *
	 * @param familyRelation the family relation
	 */
	public void cacheResult(FamilyRelation familyRelation);

	/**
	 * Caches the family relations in the entity cache if it is enabled.
	 *
	 * @param familyRelations the family relations
	 */
	public void cacheResult(java.util.List<FamilyRelation> familyRelations);

	/**
	 * Creates a new family relation with the primary key. Does not add the family relation to the database.
	 *
	 * @param familyRelationId the primary key for the new family relation
	 * @return the new family relation
	 */
	public FamilyRelation create(long familyRelationId);

	/**
	 * Removes the family relation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param familyRelationId the primary key of the family relation
	 * @return the family relation that was removed
	 * @throws NoSuchFamilyRelationException if a family relation with the primary key could not be found
	 */
	public FamilyRelation remove(long familyRelationId)
		throws NoSuchFamilyRelationException;

	public FamilyRelation updateImpl(FamilyRelation familyRelation);

	/**
	 * Returns the family relation with the primary key or throws a <code>NoSuchFamilyRelationException</code> if it could not be found.
	 *
	 * @param familyRelationId the primary key of the family relation
	 * @return the family relation
	 * @throws NoSuchFamilyRelationException if a family relation with the primary key could not be found
	 */
	public FamilyRelation findByPrimaryKey(long familyRelationId)
		throws NoSuchFamilyRelationException;

	/**
	 * Returns the family relation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param familyRelationId the primary key of the family relation
	 * @return the family relation, or <code>null</code> if a family relation with the primary key could not be found
	 */
	public FamilyRelation fetchByPrimaryKey(long familyRelationId);

	/**
	 * Returns all the family relations.
	 *
	 * @return the family relations
	 */
	public java.util.List<FamilyRelation> findAll();

	/**
	 * Returns a range of all the family relations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FamilyRelationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family relations
	 * @param end the upper bound of the range of family relations (not inclusive)
	 * @return the range of family relations
	 */
	public java.util.List<FamilyRelation> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the family relations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FamilyRelationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family relations
	 * @param end the upper bound of the range of family relations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of family relations
	 */
	public java.util.List<FamilyRelation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FamilyRelation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the family relations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FamilyRelationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of family relations
	 * @param end the upper bound of the range of family relations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of family relations
	 */
	public java.util.List<FamilyRelation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FamilyRelation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the family relations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of family relations.
	 *
	 * @return the number of family relations
	 */
	public int countAll();

}