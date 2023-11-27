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

import com.adjecti.mdm.liferay.model.OrganizationPayStructure;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the organization pay structure service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.OrganizationPayStructurePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationPayStructurePersistence
 * @generated
 */
public class OrganizationPayStructureUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(
		OrganizationPayStructure organizationPayStructure) {

		getPersistence().clearCache(organizationPayStructure);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, OrganizationPayStructure>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<OrganizationPayStructure> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OrganizationPayStructure> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OrganizationPayStructure> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<OrganizationPayStructure> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static OrganizationPayStructure update(
		OrganizationPayStructure organizationPayStructure) {

		return getPersistence().update(organizationPayStructure);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static OrganizationPayStructure update(
		OrganizationPayStructure organizationPayStructure,
		ServiceContext serviceContext) {

		return getPersistence().update(
			organizationPayStructure, serviceContext);
	}

	/**
	 * Caches the organization pay structure in the entity cache if it is enabled.
	 *
	 * @param organizationPayStructure the organization pay structure
	 */
	public static void cacheResult(
		OrganizationPayStructure organizationPayStructure) {

		getPersistence().cacheResult(organizationPayStructure);
	}

	/**
	 * Caches the organization pay structures in the entity cache if it is enabled.
	 *
	 * @param organizationPayStructures the organization pay structures
	 */
	public static void cacheResult(
		List<OrganizationPayStructure> organizationPayStructures) {

		getPersistence().cacheResult(organizationPayStructures);
	}

	/**
	 * Creates a new organization pay structure with the primary key. Does not add the organization pay structure to the database.
	 *
	 * @param organizationPayStructureId the primary key for the new organization pay structure
	 * @return the new organization pay structure
	 */
	public static OrganizationPayStructure create(
		long organizationPayStructureId) {

		return getPersistence().create(organizationPayStructureId);
	}

	/**
	 * Removes the organization pay structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param organizationPayStructureId the primary key of the organization pay structure
	 * @return the organization pay structure that was removed
	 * @throws NoSuchOrganizationPayStructureException if a organization pay structure with the primary key could not be found
	 */
	public static OrganizationPayStructure remove(
			long organizationPayStructureId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationPayStructureException {

		return getPersistence().remove(organizationPayStructureId);
	}

	public static OrganizationPayStructure updateImpl(
		OrganizationPayStructure organizationPayStructure) {

		return getPersistence().updateImpl(organizationPayStructure);
	}

	/**
	 * Returns the organization pay structure with the primary key or throws a <code>NoSuchOrganizationPayStructureException</code> if it could not be found.
	 *
	 * @param organizationPayStructureId the primary key of the organization pay structure
	 * @return the organization pay structure
	 * @throws NoSuchOrganizationPayStructureException if a organization pay structure with the primary key could not be found
	 */
	public static OrganizationPayStructure findByPrimaryKey(
			long organizationPayStructureId)
		throws com.adjecti.mdm.liferay.exception.
			NoSuchOrganizationPayStructureException {

		return getPersistence().findByPrimaryKey(organizationPayStructureId);
	}

	/**
	 * Returns the organization pay structure with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param organizationPayStructureId the primary key of the organization pay structure
	 * @return the organization pay structure, or <code>null</code> if a organization pay structure with the primary key could not be found
	 */
	public static OrganizationPayStructure fetchByPrimaryKey(
		long organizationPayStructureId) {

		return getPersistence().fetchByPrimaryKey(organizationPayStructureId);
	}

	/**
	 * Returns all the organization pay structures.
	 *
	 * @return the organization pay structures
	 */
	public static List<OrganizationPayStructure> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<OrganizationPayStructure> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<OrganizationPayStructure> findAll(
		int start, int end,
		OrderByComparator<OrganizationPayStructure> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<OrganizationPayStructure> findAll(
		int start, int end,
		OrderByComparator<OrganizationPayStructure> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the organization pay structures from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of organization pay structures.
	 *
	 * @return the number of organization pay structures
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static OrganizationPayStructurePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<OrganizationPayStructurePersistence,
		 OrganizationPayStructurePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			OrganizationPayStructurePersistence.class);

		ServiceTracker
			<OrganizationPayStructurePersistence,
			 OrganizationPayStructurePersistence> serviceTracker =
				new ServiceTracker
					<OrganizationPayStructurePersistence,
					 OrganizationPayStructurePersistence>(
						 bundle.getBundleContext(),
						 OrganizationPayStructurePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}