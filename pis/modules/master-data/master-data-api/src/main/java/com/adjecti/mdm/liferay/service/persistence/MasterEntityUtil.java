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

import com.adjecti.mdm.liferay.model.MasterEntity;

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
 * The persistence utility for the master entity service. This utility wraps <code>com.adjecti.mdm.liferay.service.persistence.impl.MasterEntityPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MasterEntityPersistence
 * @generated
 */
public class MasterEntityUtil {

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
	public static void clearCache(MasterEntity masterEntity) {
		getPersistence().clearCache(masterEntity);
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
	public static Map<Serializable, MasterEntity> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MasterEntity> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MasterEntity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MasterEntity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MasterEntity> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MasterEntity update(MasterEntity masterEntity) {
		return getPersistence().update(masterEntity);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MasterEntity update(
		MasterEntity masterEntity, ServiceContext serviceContext) {

		return getPersistence().update(masterEntity, serviceContext);
	}

	/**
	 * Caches the master entity in the entity cache if it is enabled.
	 *
	 * @param masterEntity the master entity
	 */
	public static void cacheResult(MasterEntity masterEntity) {
		getPersistence().cacheResult(masterEntity);
	}

	/**
	 * Caches the master entities in the entity cache if it is enabled.
	 *
	 * @param masterEntities the master entities
	 */
	public static void cacheResult(List<MasterEntity> masterEntities) {
		getPersistence().cacheResult(masterEntities);
	}

	/**
	 * Creates a new master entity with the primary key. Does not add the master entity to the database.
	 *
	 * @param masterEntityId the primary key for the new master entity
	 * @return the new master entity
	 */
	public static MasterEntity create(long masterEntityId) {
		return getPersistence().create(masterEntityId);
	}

	/**
	 * Removes the master entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param masterEntityId the primary key of the master entity
	 * @return the master entity that was removed
	 * @throws NoSuchMasterEntityException if a master entity with the primary key could not be found
	 */
	public static MasterEntity remove(long masterEntityId)
		throws com.adjecti.mdm.liferay.exception.NoSuchMasterEntityException {

		return getPersistence().remove(masterEntityId);
	}

	public static MasterEntity updateImpl(MasterEntity masterEntity) {
		return getPersistence().updateImpl(masterEntity);
	}

	/**
	 * Returns the master entity with the primary key or throws a <code>NoSuchMasterEntityException</code> if it could not be found.
	 *
	 * @param masterEntityId the primary key of the master entity
	 * @return the master entity
	 * @throws NoSuchMasterEntityException if a master entity with the primary key could not be found
	 */
	public static MasterEntity findByPrimaryKey(long masterEntityId)
		throws com.adjecti.mdm.liferay.exception.NoSuchMasterEntityException {

		return getPersistence().findByPrimaryKey(masterEntityId);
	}

	/**
	 * Returns the master entity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param masterEntityId the primary key of the master entity
	 * @return the master entity, or <code>null</code> if a master entity with the primary key could not be found
	 */
	public static MasterEntity fetchByPrimaryKey(long masterEntityId) {
		return getPersistence().fetchByPrimaryKey(masterEntityId);
	}

	/**
	 * Returns all the master entities.
	 *
	 * @return the master entities
	 */
	public static List<MasterEntity> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the master entities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterEntityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master entities
	 * @param end the upper bound of the range of master entities (not inclusive)
	 * @return the range of master entities
	 */
	public static List<MasterEntity> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the master entities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterEntityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master entities
	 * @param end the upper bound of the range of master entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of master entities
	 */
	public static List<MasterEntity> findAll(
		int start, int end, OrderByComparator<MasterEntity> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the master entities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterEntityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master entities
	 * @param end the upper bound of the range of master entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of master entities
	 */
	public static List<MasterEntity> findAll(
		int start, int end, OrderByComparator<MasterEntity> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the master entities from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of master entities.
	 *
	 * @return the number of master entities
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MasterEntityPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<MasterEntityPersistence, MasterEntityPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MasterEntityPersistence.class);

		ServiceTracker<MasterEntityPersistence, MasterEntityPersistence>
			serviceTracker =
				new ServiceTracker
					<MasterEntityPersistence, MasterEntityPersistence>(
						bundle.getBundleContext(),
						MasterEntityPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}