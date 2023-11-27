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
 * Provides a wrapper for {@link EntityWorkflowLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EntityWorkflowLocalService
 * @generated
 */
public class EntityWorkflowLocalServiceWrapper
	implements EntityWorkflowLocalService,
			   ServiceWrapper<EntityWorkflowLocalService> {

	public EntityWorkflowLocalServiceWrapper(
		EntityWorkflowLocalService entityWorkflowLocalService) {

		_entityWorkflowLocalService = entityWorkflowLocalService;
	}

	/**
	 * Adds the entity workflow to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EntityWorkflowLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param entityWorkflow the entity workflow
	 * @return the entity workflow that was added
	 */
	@Override
	public com.adjecti.jetform.liferay.model.EntityWorkflow addEntityWorkflow(
		com.adjecti.jetform.liferay.model.EntityWorkflow entityWorkflow) {

		return _entityWorkflowLocalService.addEntityWorkflow(entityWorkflow);
	}

	@Override
	public boolean beforeUpdateEntityWorkflow(
		Object entity, java.util.Map<String, String[]> fieldValues) {

		return _entityWorkflowLocalService.beforeUpdateEntityWorkflow(
			entity, fieldValues);
	}

	/**
	 * Creates a new entity workflow with the primary key. Does not add the entity workflow to the database.
	 *
	 * @param entityWorkflowId the primary key for the new entity workflow
	 * @return the new entity workflow
	 */
	@Override
	public com.adjecti.jetform.liferay.model.EntityWorkflow
		createEntityWorkflow(long entityWorkflowId) {

		return _entityWorkflowLocalService.createEntityWorkflow(
			entityWorkflowId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _entityWorkflowLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the entity workflow from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EntityWorkflowLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param entityWorkflow the entity workflow
	 * @return the entity workflow that was removed
	 */
	@Override
	public com.adjecti.jetform.liferay.model.EntityWorkflow
		deleteEntityWorkflow(
			com.adjecti.jetform.liferay.model.EntityWorkflow entityWorkflow) {

		return _entityWorkflowLocalService.deleteEntityWorkflow(entityWorkflow);
	}

	/**
	 * Deletes the entity workflow with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EntityWorkflowLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param entityWorkflowId the primary key of the entity workflow
	 * @return the entity workflow that was removed
	 * @throws PortalException if a entity workflow with the primary key could not be found
	 */
	@Override
	public com.adjecti.jetform.liferay.model.EntityWorkflow
			deleteEntityWorkflow(long entityWorkflowId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _entityWorkflowLocalService.deleteEntityWorkflow(
			entityWorkflowId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _entityWorkflowLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _entityWorkflowLocalService.dynamicQuery();
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

		return _entityWorkflowLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.jetform.liferay.model.impl.EntityWorkflowModelImpl</code>.
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

		return _entityWorkflowLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.jetform.liferay.model.impl.EntityWorkflowModelImpl</code>.
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

		return _entityWorkflowLocalService.dynamicQuery(
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

		return _entityWorkflowLocalService.dynamicQueryCount(dynamicQuery);
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

		return _entityWorkflowLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.jetform.liferay.model.EntityWorkflow fetchEntityWorkflow(
		long entityWorkflowId) {

		return _entityWorkflowLocalService.fetchEntityWorkflow(
			entityWorkflowId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _entityWorkflowLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the entity workflow with the primary key.
	 *
	 * @param entityWorkflowId the primary key of the entity workflow
	 * @return the entity workflow
	 * @throws PortalException if a entity workflow with the primary key could not be found
	 */
	@Override
	public com.adjecti.jetform.liferay.model.EntityWorkflow getEntityWorkflow(
			long entityWorkflowId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _entityWorkflowLocalService.getEntityWorkflow(entityWorkflowId);
	}

	@Override
	public com.adjecti.jetform.liferay.model.EntityWorkflow getEntityWorkflow(
		String className, long classPK) {

		return _entityWorkflowLocalService.getEntityWorkflow(
			className, classPK);
	}

	/**
	 * Returns a range of all the entity workflows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.jetform.liferay.model.impl.EntityWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of entity workflows
	 * @param end the upper bound of the range of entity workflows (not inclusive)
	 * @return the range of entity workflows
	 */
	@Override
	public java.util.List<com.adjecti.jetform.liferay.model.EntityWorkflow>
		getEntityWorkflows(int start, int end) {

		return _entityWorkflowLocalService.getEntityWorkflows(start, end);
	}

	/**
	 * Returns the number of entity workflows.
	 *
	 * @return the number of entity workflows
	 */
	@Override
	public int getEntityWorkflowsCount() {
		return _entityWorkflowLocalService.getEntityWorkflowsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _entityWorkflowLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _entityWorkflowLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _entityWorkflowLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the entity workflow in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EntityWorkflowLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param entityWorkflow the entity workflow
	 * @return the entity workflow that was updated
	 */
	@Override
	public com.adjecti.jetform.liferay.model.EntityWorkflow
		updateEntityWorkflow(
			com.adjecti.jetform.liferay.model.EntityWorkflow entityWorkflow) {

		return _entityWorkflowLocalService.updateEntityWorkflow(entityWorkflow);
	}

	@Override
	public EntityWorkflowLocalService getWrappedService() {
		return _entityWorkflowLocalService;
	}

	@Override
	public void setWrappedService(
		EntityWorkflowLocalService entityWorkflowLocalService) {

		_entityWorkflowLocalService = entityWorkflowLocalService;
	}

	private EntityWorkflowLocalService _entityWorkflowLocalService;

}