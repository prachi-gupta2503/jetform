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

package com.adjecti.jetform.liferay.service.persistence;

import com.adjecti.jetform.liferay.exception.NoSuchImportMasterEntityException;
import com.adjecti.jetform.liferay.model.ImportMasterEntity;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the import master entity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ImportMasterEntityUtil
 * @generated
 */
@ProviderType
public interface ImportMasterEntityPersistence
	extends BasePersistence<ImportMasterEntity> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ImportMasterEntityUtil} to access the import master entity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the import master entity in the entity cache if it is enabled.
	 *
	 * @param importMasterEntity the import master entity
	 */
	public void cacheResult(ImportMasterEntity importMasterEntity);

	/**
	 * Caches the import master entities in the entity cache if it is enabled.
	 *
	 * @param importMasterEntities the import master entities
	 */
	public void cacheResult(
		java.util.List<ImportMasterEntity> importMasterEntities);

	/**
	 * Creates a new import master entity with the primary key. Does not add the import master entity to the database.
	 *
	 * @param importMasterEntityId the primary key for the new import master entity
	 * @return the new import master entity
	 */
	public ImportMasterEntity create(long importMasterEntityId);

	/**
	 * Removes the import master entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param importMasterEntityId the primary key of the import master entity
	 * @return the import master entity that was removed
	 * @throws NoSuchImportMasterEntityException if a import master entity with the primary key could not be found
	 */
	public ImportMasterEntity remove(long importMasterEntityId)
		throws NoSuchImportMasterEntityException;

	public ImportMasterEntity updateImpl(ImportMasterEntity importMasterEntity);

	/**
	 * Returns the import master entity with the primary key or throws a <code>NoSuchImportMasterEntityException</code> if it could not be found.
	 *
	 * @param importMasterEntityId the primary key of the import master entity
	 * @return the import master entity
	 * @throws NoSuchImportMasterEntityException if a import master entity with the primary key could not be found
	 */
	public ImportMasterEntity findByPrimaryKey(long importMasterEntityId)
		throws NoSuchImportMasterEntityException;

	/**
	 * Returns the import master entity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param importMasterEntityId the primary key of the import master entity
	 * @return the import master entity, or <code>null</code> if a import master entity with the primary key could not be found
	 */
	public ImportMasterEntity fetchByPrimaryKey(long importMasterEntityId);

	/**
	 * Returns all the import master entities.
	 *
	 * @return the import master entities
	 */
	public java.util.List<ImportMasterEntity> findAll();

	/**
	 * Returns a range of all the import master entities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportMasterEntityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of import master entities
	 * @param end the upper bound of the range of import master entities (not inclusive)
	 * @return the range of import master entities
	 */
	public java.util.List<ImportMasterEntity> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the import master entities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportMasterEntityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of import master entities
	 * @param end the upper bound of the range of import master entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of import master entities
	 */
	public java.util.List<ImportMasterEntity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMasterEntity>
			orderByComparator);

	/**
	 * Returns an ordered range of all the import master entities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportMasterEntityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of import master entities
	 * @param end the upper bound of the range of import master entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of import master entities
	 */
	public java.util.List<ImportMasterEntity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMasterEntity>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the import master entities from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of import master entities.
	 *
	 * @return the number of import master entities
	 */
	public int countAll();

}