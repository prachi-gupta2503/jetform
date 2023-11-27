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

package com.adjecti.jetform.liferay.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ImportMasterEntityLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ImportMasterEntityLocalService
 * @generated
 */
public class ImportMasterEntityLocalServiceWrapper
	implements ImportMasterEntityLocalService,
			   ServiceWrapper<ImportMasterEntityLocalService> {

	public ImportMasterEntityLocalServiceWrapper(
		ImportMasterEntityLocalService importMasterEntityLocalService) {

		_importMasterEntityLocalService = importMasterEntityLocalService;
	}

	/**
	 * Adds the import master entity to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ImportMasterEntityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param importMasterEntity the import master entity
	 * @return the import master entity that was added
	 */
	@Override
	public com.adjecti.jetform.liferay.model.ImportMasterEntity
		addImportMasterEntity(
			com.adjecti.jetform.liferay.model.ImportMasterEntity
				importMasterEntity) {

		return _importMasterEntityLocalService.addImportMasterEntity(
			importMasterEntity);
	}

	/**
	 * Creates a new import master entity with the primary key. Does not add the import master entity to the database.
	 *
	 * @param importMasterEntityId the primary key for the new import master entity
	 * @return the new import master entity
	 */
	@Override
	public com.adjecti.jetform.liferay.model.ImportMasterEntity
		createImportMasterEntity(long importMasterEntityId) {

		return _importMasterEntityLocalService.createImportMasterEntity(
			importMasterEntityId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _importMasterEntityLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the import master entity from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ImportMasterEntityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param importMasterEntity the import master entity
	 * @return the import master entity that was removed
	 */
	@Override
	public com.adjecti.jetform.liferay.model.ImportMasterEntity
		deleteImportMasterEntity(
			com.adjecti.jetform.liferay.model.ImportMasterEntity
				importMasterEntity) {

		return _importMasterEntityLocalService.deleteImportMasterEntity(
			importMasterEntity);
	}

	/**
	 * Deletes the import master entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ImportMasterEntityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param importMasterEntityId the primary key of the import master entity
	 * @return the import master entity that was removed
	 * @throws PortalException if a import master entity with the primary key could not be found
	 */
	@Override
	public com.adjecti.jetform.liferay.model.ImportMasterEntity
			deleteImportMasterEntity(long importMasterEntityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _importMasterEntityLocalService.deleteImportMasterEntity(
			importMasterEntityId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _importMasterEntityLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _importMasterEntityLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _importMasterEntityLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.jetform.liferay.model.impl.ImportMasterEntityModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _importMasterEntityLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.jetform.liferay.model.impl.ImportMasterEntityModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _importMasterEntityLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _importMasterEntityLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _importMasterEntityLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.jetform.liferay.model.ImportMasterEntity
		fetchImportMasterEntity(long importMasterEntityId) {

		return _importMasterEntityLocalService.fetchImportMasterEntity(
			importMasterEntityId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _importMasterEntityLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the import master entities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.jetform.liferay.model.impl.ImportMasterEntityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of import master entities
	 * @param end the upper bound of the range of import master entities (not inclusive)
	 * @return the range of import master entities
	 */
	@Override
	public java.util.List<com.adjecti.jetform.liferay.model.ImportMasterEntity>
		getImportMasterEntities(int start, int end) {

		return _importMasterEntityLocalService.getImportMasterEntities(
			start, end);
	}

	/**
	 * Returns the number of import master entities.
	 *
	 * @return the number of import master entities
	 */
	@Override
	public int getImportMasterEntitiesCount() {
		return _importMasterEntityLocalService.getImportMasterEntitiesCount();
	}

	/**
	 * Returns the import master entity with the primary key.
	 *
	 * @param importMasterEntityId the primary key of the import master entity
	 * @return the import master entity
	 * @throws PortalException if a import master entity with the primary key could not be found
	 */
	@Override
	public com.adjecti.jetform.liferay.model.ImportMasterEntity
			getImportMasterEntity(long importMasterEntityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _importMasterEntityLocalService.getImportMasterEntity(
			importMasterEntityId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _importMasterEntityLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _importMasterEntityLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _importMasterEntityLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the import master entity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ImportMasterEntityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param importMasterEntity the import master entity
	 * @return the import master entity that was updated
	 */
	@Override
	public com.adjecti.jetform.liferay.model.ImportMasterEntity
		updateImportMasterEntity(
			com.adjecti.jetform.liferay.model.ImportMasterEntity
				importMasterEntity) {

		return _importMasterEntityLocalService.updateImportMasterEntity(
			importMasterEntity);
	}

	@Override
	public ImportMasterEntityLocalService getWrappedService() {
		return _importMasterEntityLocalService;
	}

	@Override
	public void setWrappedService(
		ImportMasterEntityLocalService importMasterEntityLocalService) {

		_importMasterEntityLocalService = importMasterEntityLocalService;
	}

	private ImportMasterEntityLocalService _importMasterEntityLocalService;

}