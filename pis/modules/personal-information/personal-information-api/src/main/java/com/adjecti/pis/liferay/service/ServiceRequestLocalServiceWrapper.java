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
 * Provides a wrapper for {@link ServiceRequestLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ServiceRequestLocalService
 * @generated
 */
public class ServiceRequestLocalServiceWrapper
	implements ServiceRequestLocalService,
			   ServiceWrapper<ServiceRequestLocalService> {

	public ServiceRequestLocalServiceWrapper(
		ServiceRequestLocalService serviceRequestLocalService) {

		_serviceRequestLocalService = serviceRequestLocalService;
	}

	/**
	 * Adds the service request to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServiceRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param serviceRequest the service request
	 * @return the service request that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.ServiceRequest addServiceRequest(
		com.adjecti.pis.liferay.model.ServiceRequest serviceRequest) {

		return _serviceRequestLocalService.addServiceRequest(serviceRequest);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _serviceRequestLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new service request with the primary key. Does not add the service request to the database.
	 *
	 * @param serviceRequestId the primary key for the new service request
	 * @return the new service request
	 */
	@Override
	public com.adjecti.pis.liferay.model.ServiceRequest createServiceRequest(
		long serviceRequestId) {

		return _serviceRequestLocalService.createServiceRequest(
			serviceRequestId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _serviceRequestLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the service request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServiceRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param serviceRequestId the primary key of the service request
	 * @return the service request that was removed
	 * @throws PortalException if a service request with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.ServiceRequest deleteServiceRequest(
			long serviceRequestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _serviceRequestLocalService.deleteServiceRequest(
			serviceRequestId);
	}

	/**
	 * Deletes the service request from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServiceRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param serviceRequest the service request
	 * @return the service request that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.ServiceRequest deleteServiceRequest(
		com.adjecti.pis.liferay.model.ServiceRequest serviceRequest) {

		return _serviceRequestLocalService.deleteServiceRequest(serviceRequest);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _serviceRequestLocalService.dynamicQuery();
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

		return _serviceRequestLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.ServiceRequestModelImpl</code>.
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

		return _serviceRequestLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.ServiceRequestModelImpl</code>.
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

		return _serviceRequestLocalService.dynamicQuery(
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

		return _serviceRequestLocalService.dynamicQueryCount(dynamicQuery);
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

		return _serviceRequestLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.ServiceRequest fetchServiceRequest(
		long serviceRequestId) {

		return _serviceRequestLocalService.fetchServiceRequest(
			serviceRequestId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _serviceRequestLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.ServiceRequest>
		getByServiceRequestTypeIdAndDeleted(
			long serviceRequestTypeId, boolean deleted) {

		return _serviceRequestLocalService.getByServiceRequestTypeIdAndDeleted(
			serviceRequestTypeId, deleted);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _serviceRequestLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _serviceRequestLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _serviceRequestLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the service request with the primary key.
	 *
	 * @param serviceRequestId the primary key of the service request
	 * @return the service request
	 * @throws PortalException if a service request with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.ServiceRequest getServiceRequest(
			long serviceRequestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _serviceRequestLocalService.getServiceRequest(serviceRequestId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.ServiceRequest>
		getServiceRequestByStatus(int status) {

		return _serviceRequestLocalService.getServiceRequestByStatus(status);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.ServiceRequest>
		getServiceRequestByStatusAndOrganization(
			int status, long organizationId) {

		return _serviceRequestLocalService.
			getServiceRequestByStatusAndOrganization(status, organizationId);
	}

	/**
	 * Returns a range of all the service requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.ServiceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service requests
	 * @param end the upper bound of the range of service requests (not inclusive)
	 * @return the range of service requests
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.ServiceRequest>
		getServiceRequests(int start, int end) {

		return _serviceRequestLocalService.getServiceRequests(start, end);
	}

	/**
	 * Returns the number of service requests.
	 *
	 * @return the number of service requests
	 */
	@Override
	public int getServiceRequestsCount() {
		return _serviceRequestLocalService.getServiceRequestsCount();
	}

	/**
	 * Updates the service request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServiceRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param serviceRequest the service request
	 * @return the service request that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.ServiceRequest updateServiceRequest(
		com.adjecti.pis.liferay.model.ServiceRequest serviceRequest) {

		return _serviceRequestLocalService.updateServiceRequest(serviceRequest);
	}

	@Override
	public ServiceRequestLocalService getWrappedService() {
		return _serviceRequestLocalService;
	}

	@Override
	public void setWrappedService(
		ServiceRequestLocalService serviceRequestLocalService) {

		_serviceRequestLocalService = serviceRequestLocalService;
	}

	private ServiceRequestLocalService _serviceRequestLocalService;

}