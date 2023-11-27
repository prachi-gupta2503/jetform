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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for ServiceRequest. This utility wraps
 * <code>com.adjecti.pis.liferay.service.impl.ServiceRequestLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ServiceRequestLocalService
 * @generated
 */
public class ServiceRequestLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.pis.liferay.service.impl.ServiceRequestLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static com.adjecti.pis.liferay.model.ServiceRequest
		addServiceRequest(
			com.adjecti.pis.liferay.model.ServiceRequest serviceRequest) {

		return getService().addServiceRequest(serviceRequest);
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
	 * Creates a new service request with the primary key. Does not add the service request to the database.
	 *
	 * @param serviceRequestId the primary key for the new service request
	 * @return the new service request
	 */
	public static com.adjecti.pis.liferay.model.ServiceRequest
		createServiceRequest(long serviceRequestId) {

		return getService().createServiceRequest(serviceRequestId);
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
	public static com.adjecti.pis.liferay.model.ServiceRequest
			deleteServiceRequest(long serviceRequestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteServiceRequest(serviceRequestId);
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
	public static com.adjecti.pis.liferay.model.ServiceRequest
		deleteServiceRequest(
			com.adjecti.pis.liferay.model.ServiceRequest serviceRequest) {

		return getService().deleteServiceRequest(serviceRequest);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.ServiceRequestModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.ServiceRequestModelImpl</code>.
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

	public static com.adjecti.pis.liferay.model.ServiceRequest
		fetchServiceRequest(long serviceRequestId) {

		return getService().fetchServiceRequest(serviceRequestId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<com.adjecti.pis.liferay.model.ServiceRequest>
		getByServiceRequestTypeIdAndDeleted(
			long serviceRequestTypeId, boolean deleted) {

		return getService().getByServiceRequestTypeIdAndDeleted(
			serviceRequestTypeId, deleted);
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
	 * Returns the service request with the primary key.
	 *
	 * @param serviceRequestId the primary key of the service request
	 * @return the service request
	 * @throws PortalException if a service request with the primary key could not be found
	 */
	public static com.adjecti.pis.liferay.model.ServiceRequest
			getServiceRequest(long serviceRequestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getServiceRequest(serviceRequestId);
	}

	public static java.util.List<com.adjecti.pis.liferay.model.ServiceRequest>
		getServiceRequestByStatus(int status) {

		return getService().getServiceRequestByStatus(status);
	}

	public static java.util.List<com.adjecti.pis.liferay.model.ServiceRequest>
		getServiceRequestByStatusAndOrganization(
			int status, long organizationId) {

		return getService().getServiceRequestByStatusAndOrganization(
			status, organizationId);
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
	public static java.util.List<com.adjecti.pis.liferay.model.ServiceRequest>
		getServiceRequests(int start, int end) {

		return getService().getServiceRequests(start, end);
	}

	/**
	 * Returns the number of service requests.
	 *
	 * @return the number of service requests
	 */
	public static int getServiceRequestsCount() {
		return getService().getServiceRequestsCount();
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
	public static com.adjecti.pis.liferay.model.ServiceRequest
		updateServiceRequest(
			com.adjecti.pis.liferay.model.ServiceRequest serviceRequest) {

		return getService().updateServiceRequest(serviceRequest);
	}

	public static ServiceRequestLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ServiceRequestLocalService, ServiceRequestLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ServiceRequestLocalService.class);

		ServiceTracker<ServiceRequestLocalService, ServiceRequestLocalService>
			serviceTracker =
				new ServiceTracker
					<ServiceRequestLocalService, ServiceRequestLocalService>(
						bundle.getBundleContext(),
						ServiceRequestLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}