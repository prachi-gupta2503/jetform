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
 * Provides a wrapper for {@link ServiceRequestTypeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ServiceRequestTypeLocalService
 * @generated
 */
public class ServiceRequestTypeLocalServiceWrapper
	implements ServiceRequestTypeLocalService,
			   ServiceWrapper<ServiceRequestTypeLocalService> {

	public ServiceRequestTypeLocalServiceWrapper(
		ServiceRequestTypeLocalService serviceRequestTypeLocalService) {

		_serviceRequestTypeLocalService = serviceRequestTypeLocalService;
	}

	/**
	 * Adds the service request type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServiceRequestTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param serviceRequestType the service request type
	 * @return the service request type that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.ServiceRequestType
		addServiceRequestType(
			com.adjecti.mdm.liferay.model.ServiceRequestType
				serviceRequestType) {

		return _serviceRequestTypeLocalService.addServiceRequestType(
			serviceRequestType);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _serviceRequestTypeLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new service request type with the primary key. Does not add the service request type to the database.
	 *
	 * @param serviceRequestTypeId the primary key for the new service request type
	 * @return the new service request type
	 */
	@Override
	public com.adjecti.mdm.liferay.model.ServiceRequestType
		createServiceRequestType(long serviceRequestTypeId) {

		return _serviceRequestTypeLocalService.createServiceRequestType(
			serviceRequestTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _serviceRequestTypeLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the service request type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServiceRequestTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param serviceRequestTypeId the primary key of the service request type
	 * @return the service request type that was removed
	 * @throws PortalException if a service request type with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.ServiceRequestType
			deleteServiceRequestType(long serviceRequestTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _serviceRequestTypeLocalService.deleteServiceRequestType(
			serviceRequestTypeId);
	}

	/**
	 * Deletes the service request type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServiceRequestTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param serviceRequestType the service request type
	 * @return the service request type that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.ServiceRequestType
		deleteServiceRequestType(
			com.adjecti.mdm.liferay.model.ServiceRequestType
				serviceRequestType) {

		return _serviceRequestTypeLocalService.deleteServiceRequestType(
			serviceRequestType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _serviceRequestTypeLocalService.dynamicQuery();
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

		return _serviceRequestTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.ServiceRequestTypeModelImpl</code>.
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

		return _serviceRequestTypeLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.ServiceRequestTypeModelImpl</code>.
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

		return _serviceRequestTypeLocalService.dynamicQuery(
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

		return _serviceRequestTypeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _serviceRequestTypeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.ServiceRequestType
		fetchServiceRequestType(long serviceRequestTypeId) {

		return _serviceRequestTypeLocalService.fetchServiceRequestType(
			serviceRequestTypeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _serviceRequestTypeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _serviceRequestTypeLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _serviceRequestTypeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _serviceRequestTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the service request type with the primary key.
	 *
	 * @param serviceRequestTypeId the primary key of the service request type
	 * @return the service request type
	 * @throws PortalException if a service request type with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.ServiceRequestType
			getServiceRequestType(long serviceRequestTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _serviceRequestTypeLocalService.getServiceRequestType(
			serviceRequestTypeId);
	}

	/**
	 * Returns a range of all the service request types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.ServiceRequestTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request types
	 * @param end the upper bound of the range of service request types (not inclusive)
	 * @return the range of service request types
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.ServiceRequestType>
		getServiceRequestTypes(int start, int end) {

		return _serviceRequestTypeLocalService.getServiceRequestTypes(
			start, end);
	}

	/**
	 * Returns the number of service request types.
	 *
	 * @return the number of service request types
	 */
	@Override
	public int getServiceRequestTypesCount() {
		return _serviceRequestTypeLocalService.getServiceRequestTypesCount();
	}

	/**
	 * Updates the service request type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServiceRequestTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param serviceRequestType the service request type
	 * @return the service request type that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.ServiceRequestType
		updateServiceRequestType(
			com.adjecti.mdm.liferay.model.ServiceRequestType
				serviceRequestType) {

		return _serviceRequestTypeLocalService.updateServiceRequestType(
			serviceRequestType);
	}

	@Override
	public ServiceRequestTypeLocalService getWrappedService() {
		return _serviceRequestTypeLocalService;
	}

	@Override
	public void setWrappedService(
		ServiceRequestTypeLocalService serviceRequestTypeLocalService) {

		_serviceRequestTypeLocalService = serviceRequestTypeLocalService;
	}

	private ServiceRequestTypeLocalService _serviceRequestTypeLocalService;

}