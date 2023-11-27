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

package com.adjecti.pis.liferay.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ServiceRequestWorkflowLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ServiceRequestWorkflowLocalService
 * @generated
 */
public class ServiceRequestWorkflowLocalServiceWrapper
	implements ServiceRequestWorkflowLocalService,
			   ServiceWrapper<ServiceRequestWorkflowLocalService> {

	public ServiceRequestWorkflowLocalServiceWrapper(
		ServiceRequestWorkflowLocalService serviceRequestWorkflowLocalService) {

		_serviceRequestWorkflowLocalService =
			serviceRequestWorkflowLocalService;
	}

	/**
	 * Adds the service request workflow to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServiceRequestWorkflowLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param serviceRequestWorkflow the service request workflow
	 * @return the service request workflow that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.ServiceRequestWorkflow
		addServiceRequestWorkflow(
			com.adjecti.pis.liferay.model.ServiceRequestWorkflow
				serviceRequestWorkflow) {

		return _serviceRequestWorkflowLocalService.addServiceRequestWorkflow(
			serviceRequestWorkflow);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _serviceRequestWorkflowLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new service request workflow with the primary key. Does not add the service request workflow to the database.
	 *
	 * @param serviceRequestWorkflowId the primary key for the new service request workflow
	 * @return the new service request workflow
	 */
	@Override
	public com.adjecti.pis.liferay.model.ServiceRequestWorkflow
		createServiceRequestWorkflow(long serviceRequestWorkflowId) {

		return _serviceRequestWorkflowLocalService.createServiceRequestWorkflow(
			serviceRequestWorkflowId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _serviceRequestWorkflowLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the service request workflow with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServiceRequestWorkflowLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param serviceRequestWorkflowId the primary key of the service request workflow
	 * @return the service request workflow that was removed
	 * @throws PortalException if a service request workflow with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.ServiceRequestWorkflow
			deleteServiceRequestWorkflow(long serviceRequestWorkflowId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _serviceRequestWorkflowLocalService.deleteServiceRequestWorkflow(
			serviceRequestWorkflowId);
	}

	/**
	 * Deletes the service request workflow from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServiceRequestWorkflowLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param serviceRequestWorkflow the service request workflow
	 * @return the service request workflow that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.ServiceRequestWorkflow
		deleteServiceRequestWorkflow(
			com.adjecti.pis.liferay.model.ServiceRequestWorkflow
				serviceRequestWorkflow) {

		return _serviceRequestWorkflowLocalService.deleteServiceRequestWorkflow(
			serviceRequestWorkflow);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _serviceRequestWorkflowLocalService.dynamicQuery();
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

		return _serviceRequestWorkflowLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.ServiceRequestWorkflowModelImpl</code>.
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

		return _serviceRequestWorkflowLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.ServiceRequestWorkflowModelImpl</code>.
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

		return _serviceRequestWorkflowLocalService.dynamicQuery(
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

		return _serviceRequestWorkflowLocalService.dynamicQueryCount(
			dynamicQuery);
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

		return _serviceRequestWorkflowLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.ServiceRequestWorkflow
		fetchServiceRequestWorkflow(long serviceRequestWorkflowId) {

		return _serviceRequestWorkflowLocalService.fetchServiceRequestWorkflow(
			serviceRequestWorkflowId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _serviceRequestWorkflowLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _serviceRequestWorkflowLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _serviceRequestWorkflowLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _serviceRequestWorkflowLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the service request workflow with the primary key.
	 *
	 * @param serviceRequestWorkflowId the primary key of the service request workflow
	 * @return the service request workflow
	 * @throws PortalException if a service request workflow with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.ServiceRequestWorkflow
			getServiceRequestWorkflow(long serviceRequestWorkflowId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _serviceRequestWorkflowLocalService.getServiceRequestWorkflow(
			serviceRequestWorkflowId);
	}

	/**
	 * Returns a range of all the service request workflows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.ServiceRequestWorkflowModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request workflows
	 * @param end the upper bound of the range of service request workflows (not inclusive)
	 * @return the range of service request workflows
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.ServiceRequestWorkflow>
		getServiceRequestWorkflows(int start, int end) {

		return _serviceRequestWorkflowLocalService.getServiceRequestWorkflows(
			start, end);
	}

	/**
	 * Returns the number of service request workflows.
	 *
	 * @return the number of service request workflows
	 */
	@Override
	public int getServiceRequestWorkflowsCount() {
		return _serviceRequestWorkflowLocalService.
			getServiceRequestWorkflowsCount();
	}

	/**
	 * Updates the service request workflow in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServiceRequestWorkflowLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param serviceRequestWorkflow the service request workflow
	 * @return the service request workflow that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.ServiceRequestWorkflow
		updateServiceRequestWorkflow(
			com.adjecti.pis.liferay.model.ServiceRequestWorkflow
				serviceRequestWorkflow) {

		return _serviceRequestWorkflowLocalService.updateServiceRequestWorkflow(
			serviceRequestWorkflow);
	}

	@Override
	public ServiceRequestWorkflowLocalService getWrappedService() {
		return _serviceRequestWorkflowLocalService;
	}

	@Override
	public void setWrappedService(
		ServiceRequestWorkflowLocalService serviceRequestWorkflowLocalService) {

		_serviceRequestWorkflowLocalService =
			serviceRequestWorkflowLocalService;
	}

	private ServiceRequestWorkflowLocalService
		_serviceRequestWorkflowLocalService;

}