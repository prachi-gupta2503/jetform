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
 * Provides a wrapper for {@link ServiceRequestWfStatusTypeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ServiceRequestWfStatusTypeLocalService
 * @generated
 */
public class ServiceRequestWfStatusTypeLocalServiceWrapper
	implements ServiceRequestWfStatusTypeLocalService,
			   ServiceWrapper<ServiceRequestWfStatusTypeLocalService> {

	public ServiceRequestWfStatusTypeLocalServiceWrapper(
		ServiceRequestWfStatusTypeLocalService
			serviceRequestWfStatusTypeLocalService) {

		_serviceRequestWfStatusTypeLocalService =
			serviceRequestWfStatusTypeLocalService;
	}

	/**
	 * Adds the service request wf status type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServiceRequestWfStatusTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param serviceRequestWfStatusType the service request wf status type
	 * @return the service request wf status type that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.ServiceRequestWfStatusType
		addServiceRequestWfStatusType(
			com.adjecti.pis.liferay.model.ServiceRequestWfStatusType
				serviceRequestWfStatusType) {

		return _serviceRequestWfStatusTypeLocalService.
			addServiceRequestWfStatusType(serviceRequestWfStatusType);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _serviceRequestWfStatusTypeLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new service request wf status type with the primary key. Does not add the service request wf status type to the database.
	 *
	 * @param serviceRequestWfStatusTypeId the primary key for the new service request wf status type
	 * @return the new service request wf status type
	 */
	@Override
	public com.adjecti.pis.liferay.model.ServiceRequestWfStatusType
		createServiceRequestWfStatusType(long serviceRequestWfStatusTypeId) {

		return _serviceRequestWfStatusTypeLocalService.
			createServiceRequestWfStatusType(serviceRequestWfStatusTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _serviceRequestWfStatusTypeLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the service request wf status type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServiceRequestWfStatusTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param serviceRequestWfStatusTypeId the primary key of the service request wf status type
	 * @return the service request wf status type that was removed
	 * @throws PortalException if a service request wf status type with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.ServiceRequestWfStatusType
			deleteServiceRequestWfStatusType(long serviceRequestWfStatusTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _serviceRequestWfStatusTypeLocalService.
			deleteServiceRequestWfStatusType(serviceRequestWfStatusTypeId);
	}

	/**
	 * Deletes the service request wf status type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServiceRequestWfStatusTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param serviceRequestWfStatusType the service request wf status type
	 * @return the service request wf status type that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.ServiceRequestWfStatusType
		deleteServiceRequestWfStatusType(
			com.adjecti.pis.liferay.model.ServiceRequestWfStatusType
				serviceRequestWfStatusType) {

		return _serviceRequestWfStatusTypeLocalService.
			deleteServiceRequestWfStatusType(serviceRequestWfStatusType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _serviceRequestWfStatusTypeLocalService.dynamicQuery();
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

		return _serviceRequestWfStatusTypeLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.ServiceRequestWfStatusTypeModelImpl</code>.
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

		return _serviceRequestWfStatusTypeLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.ServiceRequestWfStatusTypeModelImpl</code>.
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

		return _serviceRequestWfStatusTypeLocalService.dynamicQuery(
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

		return _serviceRequestWfStatusTypeLocalService.dynamicQueryCount(
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

		return _serviceRequestWfStatusTypeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.ServiceRequestWfStatusType
		fetchServiceRequestWfStatusType(long serviceRequestWfStatusTypeId) {

		return _serviceRequestWfStatusTypeLocalService.
			fetchServiceRequestWfStatusType(serviceRequestWfStatusTypeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _serviceRequestWfStatusTypeLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _serviceRequestWfStatusTypeLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _serviceRequestWfStatusTypeLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _serviceRequestWfStatusTypeLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the service request wf status type with the primary key.
	 *
	 * @param serviceRequestWfStatusTypeId the primary key of the service request wf status type
	 * @return the service request wf status type
	 * @throws PortalException if a service request wf status type with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.ServiceRequestWfStatusType
			getServiceRequestWfStatusType(long serviceRequestWfStatusTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _serviceRequestWfStatusTypeLocalService.
			getServiceRequestWfStatusType(serviceRequestWfStatusTypeId);
	}

	/**
	 * Returns a range of all the service request wf status types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.ServiceRequestWfStatusTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request wf status types
	 * @param end the upper bound of the range of service request wf status types (not inclusive)
	 * @return the range of service request wf status types
	 */
	@Override
	public java.util.List
		<com.adjecti.pis.liferay.model.ServiceRequestWfStatusType>
			getServiceRequestWfStatusTypes(int start, int end) {

		return _serviceRequestWfStatusTypeLocalService.
			getServiceRequestWfStatusTypes(start, end);
	}

	/**
	 * Returns the number of service request wf status types.
	 *
	 * @return the number of service request wf status types
	 */
	@Override
	public int getServiceRequestWfStatusTypesCount() {
		return _serviceRequestWfStatusTypeLocalService.
			getServiceRequestWfStatusTypesCount();
	}

	/**
	 * Updates the service request wf status type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServiceRequestWfStatusTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param serviceRequestWfStatusType the service request wf status type
	 * @return the service request wf status type that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.ServiceRequestWfStatusType
		updateServiceRequestWfStatusType(
			com.adjecti.pis.liferay.model.ServiceRequestWfStatusType
				serviceRequestWfStatusType) {

		return _serviceRequestWfStatusTypeLocalService.
			updateServiceRequestWfStatusType(serviceRequestWfStatusType);
	}

	@Override
	public ServiceRequestWfStatusTypeLocalService getWrappedService() {
		return _serviceRequestWfStatusTypeLocalService;
	}

	@Override
	public void setWrappedService(
		ServiceRequestWfStatusTypeLocalService
			serviceRequestWfStatusTypeLocalService) {

		_serviceRequestWfStatusTypeLocalService =
			serviceRequestWfStatusTypeLocalService;
	}

	private ServiceRequestWfStatusTypeLocalService
		_serviceRequestWfStatusTypeLocalService;

}