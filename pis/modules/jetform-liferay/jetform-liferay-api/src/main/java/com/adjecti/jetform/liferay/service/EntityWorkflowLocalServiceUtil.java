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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for EntityWorkflow. This utility wraps
 * <code>com.adjecti.jetform.liferay.service.impl.EntityWorkflowLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EntityWorkflowLocalService
 * @generated
 */
public class EntityWorkflowLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.jetform.liferay.service.impl.EntityWorkflowLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static com.adjecti.jetform.liferay.model.EntityWorkflow
		addEntityWorkflow(
			com.adjecti.jetform.liferay.model.EntityWorkflow entityWorkflow) {

		return getService().addEntityWorkflow(entityWorkflow);
	}

	public static boolean beforeUpdateEntityWorkflow(
		Object entity, java.util.Map<String, String[]> fieldValues) {

		return getService().beforeUpdateEntityWorkflow(entity, fieldValues);
	}

	/**
	 * Creates a new entity workflow with the primary key. Does not add the entity workflow to the database.
	 *
	 * @param entityWorkflowId the primary key for the new entity workflow
	 * @return the new entity workflow
	 */
	public static com.adjecti.jetform.liferay.model.EntityWorkflow
		createEntityWorkflow(long entityWorkflowId) {

		return getService().createEntityWorkflow(entityWorkflowId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			createPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static com.adjecti.jetform.liferay.model.EntityWorkflow
		deleteEntityWorkflow(
			com.adjecti.jetform.liferay.model.EntityWorkflow entityWorkflow) {

		return getService().deleteEntityWorkflow(entityWorkflow);
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
	public static com.adjecti.jetform.liferay.model.EntityWorkflow
			deleteEntityWorkflow(long entityWorkflowId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteEntityWorkflow(entityWorkflowId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.adjecti.jetform.liferay.model.EntityWorkflow
		fetchEntityWorkflow(long entityWorkflowId) {

		return getService().fetchEntityWorkflow(entityWorkflowId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the entity workflow with the primary key.
	 *
	 * @param entityWorkflowId the primary key of the entity workflow
	 * @return the entity workflow
	 * @throws PortalException if a entity workflow with the primary key could not be found
	 */
	public static com.adjecti.jetform.liferay.model.EntityWorkflow
			getEntityWorkflow(long entityWorkflowId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getEntityWorkflow(entityWorkflowId);
	}

	public static com.adjecti.jetform.liferay.model.EntityWorkflow
		getEntityWorkflow(String className, long classPK) {

		return getService().getEntityWorkflow(className, classPK);
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
	public static java.util.List
		<com.adjecti.jetform.liferay.model.EntityWorkflow> getEntityWorkflows(
			int start, int end) {

		return getService().getEntityWorkflows(start, end);
	}

	/**
	 * Returns the number of entity workflows.
	 *
	 * @return the number of entity workflows
	 */
	public static int getEntityWorkflowsCount() {
		return getService().getEntityWorkflowsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
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
	public static com.adjecti.jetform.liferay.model.EntityWorkflow
		updateEntityWorkflow(
			com.adjecti.jetform.liferay.model.EntityWorkflow entityWorkflow) {

		return getService().updateEntityWorkflow(entityWorkflow);
	}

	public static EntityWorkflowLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EntityWorkflowLocalService, EntityWorkflowLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EntityWorkflowLocalService.class);

		ServiceTracker<EntityWorkflowLocalService, EntityWorkflowLocalService>
			serviceTracker =
				new ServiceTracker
					<EntityWorkflowLocalService, EntityWorkflowLocalService>(
						bundle.getBundleContext(),
						EntityWorkflowLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}