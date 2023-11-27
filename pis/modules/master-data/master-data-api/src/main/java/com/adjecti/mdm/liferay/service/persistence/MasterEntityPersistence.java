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

import com.adjecti.mdm.liferay.exception.NoSuchMasterEntityException;
import com.adjecti.mdm.liferay.model.MasterEntity;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the master entity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MasterEntityUtil
 * @generated
 */
@ProviderType
public interface MasterEntityPersistence extends BasePersistence<MasterEntity> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MasterEntityUtil} to access the master entity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the master entity in the entity cache if it is enabled.
	 *
	 * @param masterEntity the master entity
	 */
	public void cacheResult(MasterEntity masterEntity);

	/**
	 * Caches the master entities in the entity cache if it is enabled.
	 *
	 * @param masterEntities the master entities
	 */
	public void cacheResult(java.util.List<MasterEntity> masterEntities);

	/**
	 * Creates a new master entity with the primary key. Does not add the master entity to the database.
	 *
	 * @param masterEntityId the primary key for the new master entity
	 * @return the new master entity
	 */
	public MasterEntity create(long masterEntityId);

	/**
	 * Removes the master entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param masterEntityId the primary key of the master entity
	 * @return the master entity that was removed
	 * @throws NoSuchMasterEntityException if a master entity with the primary key could not be found
	 */
	public MasterEntity remove(long masterEntityId)
		throws NoSuchMasterEntityException;

	public MasterEntity updateImpl(MasterEntity masterEntity);

	/**
	 * Returns the master entity with the primary key or throws a <code>NoSuchMasterEntityException</code> if it could not be found.
	 *
	 * @param masterEntityId the primary key of the master entity
	 * @return the master entity
	 * @throws NoSuchMasterEntityException if a master entity with the primary key could not be found
	 */
	public MasterEntity findByPrimaryKey(long masterEntityId)
		throws NoSuchMasterEntityException;

	/**
	 * Returns the master entity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param masterEntityId the primary key of the master entity
	 * @return the master entity, or <code>null</code> if a master entity with the primary key could not be found
	 */
	public MasterEntity fetchByPrimaryKey(long masterEntityId);

	/**
	 * Returns all the master entities.
	 *
	 * @return the master entities
	 */
	public java.util.List<MasterEntity> findAll();

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
	public java.util.List<MasterEntity> findAll(int start, int end);

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
	public java.util.List<MasterEntity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterEntity>
			orderByComparator);

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
	public java.util.List<MasterEntity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterEntity>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the master entities from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of master entities.
	 *
	 * @return the number of master entities
	 */
	public int countAll();

}