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

package com.adjecti.mdm.liferay.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MasterEntityLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MasterEntityLocalService
 * @generated
 */
public class MasterEntityLocalServiceWrapper
	implements MasterEntityLocalService,
			   ServiceWrapper<MasterEntityLocalService> {

	public MasterEntityLocalServiceWrapper(
		MasterEntityLocalService masterEntityLocalService) {

		_masterEntityLocalService = masterEntityLocalService;
	}

	/**
	 * Adds the master entity to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterEntityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterEntity the master entity
	 * @return the master entity that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.MasterEntity addMasterEntity(
		com.adjecti.mdm.liferay.model.MasterEntity masterEntity) {

		return _masterEntityLocalService.addMasterEntity(masterEntity);
	}

	/**
	 * Creates a new master entity with the primary key. Does not add the master entity to the database.
	 *
	 * @param masterEntityId the primary key for the new master entity
	 * @return the new master entity
	 */
	@Override
	public com.adjecti.mdm.liferay.model.MasterEntity createMasterEntity(
		long masterEntityId) {

		return _masterEntityLocalService.createMasterEntity(masterEntityId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterEntityLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the master entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterEntityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterEntityId the primary key of the master entity
	 * @return the master entity that was removed
	 * @throws PortalException if a master entity with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.MasterEntity deleteMasterEntity(
			long masterEntityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterEntityLocalService.deleteMasterEntity(masterEntityId);
	}

	/**
	 * Deletes the master entity from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterEntityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterEntity the master entity
	 * @return the master entity that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.MasterEntity deleteMasterEntity(
		com.adjecti.mdm.liferay.model.MasterEntity masterEntity) {

		return _masterEntityLocalService.deleteMasterEntity(masterEntity);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterEntityLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _masterEntityLocalService.dynamicQuery();
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

		return _masterEntityLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.MasterEntityModelImpl</code>.
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

		return _masterEntityLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.MasterEntityModelImpl</code>.
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

		return _masterEntityLocalService.dynamicQuery(
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

		return _masterEntityLocalService.dynamicQueryCount(dynamicQuery);
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

		return _masterEntityLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.MasterEntity fetchMasterEntity(
		long masterEntityId) {

		return _masterEntityLocalService.fetchMasterEntity(masterEntityId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _masterEntityLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _masterEntityLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the master entities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.MasterEntityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master entities
	 * @param end the upper bound of the range of master entities (not inclusive)
	 * @return the range of master entities
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.MasterEntity>
		getMasterEntities(int start, int end) {

		return _masterEntityLocalService.getMasterEntities(start, end);
	}

	/**
	 * Returns the number of master entities.
	 *
	 * @return the number of master entities
	 */
	@Override
	public int getMasterEntitiesCount() {
		return _masterEntityLocalService.getMasterEntitiesCount();
	}

	/**
	 * Returns the master entity with the primary key.
	 *
	 * @param masterEntityId the primary key of the master entity
	 * @return the master entity
	 * @throws PortalException if a master entity with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.MasterEntity getMasterEntity(
			long masterEntityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterEntityLocalService.getMasterEntity(masterEntityId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _masterEntityLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _masterEntityLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the master entity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterEntityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterEntity the master entity
	 * @return the master entity that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.MasterEntity updateMasterEntity(
		com.adjecti.mdm.liferay.model.MasterEntity masterEntity) {

		return _masterEntityLocalService.updateMasterEntity(masterEntity);
	}

	@Override
	public MasterEntityLocalService getWrappedService() {
		return _masterEntityLocalService;
	}

	@Override
	public void setWrappedService(
		MasterEntityLocalService masterEntityLocalService) {

		_masterEntityLocalService = masterEntityLocalService;
	}

	private MasterEntityLocalService _masterEntityLocalService;

}