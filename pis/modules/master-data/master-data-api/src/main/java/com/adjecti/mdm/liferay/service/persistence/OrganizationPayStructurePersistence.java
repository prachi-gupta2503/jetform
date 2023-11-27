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

import com.adjecti.mdm.liferay.exception.NoSuchOrganizationPayStructureException;
import com.adjecti.mdm.liferay.model.OrganizationPayStructure;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the organization pay structure service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationPayStructureUtil
 * @generated
 */
@ProviderType
public interface OrganizationPayStructurePersistence
	extends BasePersistence<OrganizationPayStructure> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OrganizationPayStructureUtil} to access the organization pay structure persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the organization pay structure in the entity cache if it is enabled.
	 *
	 * @param organizationPayStructure the organization pay structure
	 */
	public void cacheResult(OrganizationPayStructure organizationPayStructure);

	/**
	 * Caches the organization pay structures in the entity cache if it is enabled.
	 *
	 * @param organizationPayStructures the organization pay structures
	 */
	public void cacheResult(
		java.util.List<OrganizationPayStructure> organizationPayStructures);

	/**
	 * Creates a new organization pay structure with the primary key. Does not add the organization pay structure to the database.
	 *
	 * @param organizationPayStructureId the primary key for the new organization pay structure
	 * @return the new organization pay structure
	 */
	public OrganizationPayStructure create(long organizationPayStructureId);

	/**
	 * Removes the organization pay structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param organizationPayStructureId the primary key of the organization pay structure
	 * @return the organization pay structure that was removed
	 * @throws NoSuchOrganizationPayStructureException if a organization pay structure with the primary key could not be found
	 */
	public OrganizationPayStructure remove(long organizationPayStructureId)
		throws NoSuchOrganizationPayStructureException;

	public OrganizationPayStructure updateImpl(
		OrganizationPayStructure organizationPayStructure);

	/**
	 * Returns the organization pay structure with the primary key or throws a <code>NoSuchOrganizationPayStructureException</code> if it could not be found.
	 *
	 * @param organizationPayStructureId the primary key of the organization pay structure
	 * @return the organization pay structure
	 * @throws NoSuchOrganizationPayStructureException if a organization pay structure with the primary key could not be found
	 */
	public OrganizationPayStructure findByPrimaryKey(
			long organizationPayStructureId)
		throws NoSuchOrganizationPayStructureException;

	/**
	 * Returns the organization pay structure with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param organizationPayStructureId the primary key of the organization pay structure
	 * @return the organization pay structure, or <code>null</code> if a organization pay structure with the primary key could not be found
	 */
	public OrganizationPayStructure fetchByPrimaryKey(
		long organizationPayStructureId);

	/**
	 * Returns all the organization pay structures.
	 *
	 * @return the organization pay structures
	 */
	public java.util.List<OrganizationPayStructure> findAll();

	/**
	 * Returns a range of all the organization pay structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationPayStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization pay structures
	 * @param end the upper bound of the range of organization pay structures (not inclusive)
	 * @return the range of organization pay structures
	 */
	public java.util.List<OrganizationPayStructure> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the organization pay structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationPayStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization pay structures
	 * @param end the upper bound of the range of organization pay structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of organization pay structures
	 */
	public java.util.List<OrganizationPayStructure> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<OrganizationPayStructure> orderByComparator);

	/**
	 * Returns an ordered range of all the organization pay structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OrganizationPayStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization pay structures
	 * @param end the upper bound of the range of organization pay structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of organization pay structures
	 */
	public java.util.List<OrganizationPayStructure> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<OrganizationPayStructure> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the organization pay structures from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of organization pay structures.
	 *
	 * @return the number of organization pay structures
	 */
	public int countAll();

}