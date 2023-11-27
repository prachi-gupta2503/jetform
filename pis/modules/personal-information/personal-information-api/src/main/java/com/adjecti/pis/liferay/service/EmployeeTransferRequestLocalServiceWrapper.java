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
 * Provides a wrapper for {@link EmployeeTransferRequestLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeTransferRequestLocalService
 * @generated
 */
public class EmployeeTransferRequestLocalServiceWrapper
	implements EmployeeTransferRequestLocalService,
			   ServiceWrapper<EmployeeTransferRequestLocalService> {

	public EmployeeTransferRequestLocalServiceWrapper(
		EmployeeTransferRequestLocalService
			employeeTransferRequestLocalService) {

		_employeeTransferRequestLocalService =
			employeeTransferRequestLocalService;
	}

	/**
	 * Adds the employee transfer request to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeTransferRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeTransferRequest the employee transfer request
	 * @return the employee transfer request that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeTransferRequest
		addEmployeeTransferRequest(
			com.adjecti.pis.liferay.model.EmployeeTransferRequest
				employeeTransferRequest) {

		return _employeeTransferRequestLocalService.addEmployeeTransferRequest(
			employeeTransferRequest);
	}

	/**
	 * Creates a new employee transfer request with the primary key. Does not add the employee transfer request to the database.
	 *
	 * @param employeeTransferRequestId the primary key for the new employee transfer request
	 * @return the new employee transfer request
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeTransferRequest
		createEmployeeTransferRequest(long employeeTransferRequestId) {

		return _employeeTransferRequestLocalService.
			createEmployeeTransferRequest(employeeTransferRequestId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeTransferRequestLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the employee transfer request from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeTransferRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeTransferRequest the employee transfer request
	 * @return the employee transfer request that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeTransferRequest
		deleteEmployeeTransferRequest(
			com.adjecti.pis.liferay.model.EmployeeTransferRequest
				employeeTransferRequest) {

		return _employeeTransferRequestLocalService.
			deleteEmployeeTransferRequest(employeeTransferRequest);
	}

	/**
	 * Deletes the employee transfer request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeTransferRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeTransferRequestId the primary key of the employee transfer request
	 * @return the employee transfer request that was removed
	 * @throws PortalException if a employee transfer request with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeTransferRequest
			deleteEmployeeTransferRequest(long employeeTransferRequestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeTransferRequestLocalService.
			deleteEmployeeTransferRequest(employeeTransferRequestId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeTransferRequestLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeTransferRequestLocalService.dynamicQuery();
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

		return _employeeTransferRequestLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeTransferRequestModelImpl</code>.
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

		return _employeeTransferRequestLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeTransferRequestModelImpl</code>.
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

		return _employeeTransferRequestLocalService.dynamicQuery(
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

		return _employeeTransferRequestLocalService.dynamicQueryCount(
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

		return _employeeTransferRequestLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeeTransferRequest
		fetchEmployeeTransferRequest(long employeeTransferRequestId) {

		return _employeeTransferRequestLocalService.
			fetchEmployeeTransferRequest(employeeTransferRequestId);
	}

	/**
	 * Returns the employee transfer request matching the UUID and group.
	 *
	 * @param uuid the employee transfer request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee transfer request, or <code>null</code> if a matching employee transfer request could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeTransferRequest
		fetchEmployeeTransferRequestByUuidAndGroupId(
			String uuid, long groupId) {

		return _employeeTransferRequestLocalService.
			fetchEmployeeTransferRequestByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeTransferRequestLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the employee transfer request with the primary key.
	 *
	 * @param employeeTransferRequestId the primary key of the employee transfer request
	 * @return the employee transfer request
	 * @throws PortalException if a employee transfer request with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeTransferRequest
			getEmployeeTransferRequest(long employeeTransferRequestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeTransferRequestLocalService.getEmployeeTransferRequest(
			employeeTransferRequestId);
	}

	/**
	 * Returns the employee transfer request matching the UUID and group.
	 *
	 * @param uuid the employee transfer request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee transfer request
	 * @throws PortalException if a matching employee transfer request could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeTransferRequest
			getEmployeeTransferRequestByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeTransferRequestLocalService.
			getEmployeeTransferRequestByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the employee transfer requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeTransferRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee transfer requests
	 * @param end the upper bound of the range of employee transfer requests (not inclusive)
	 * @return the range of employee transfer requests
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeTransferRequest>
		getEmployeeTransferRequests(int start, int end) {

		return _employeeTransferRequestLocalService.getEmployeeTransferRequests(
			start, end);
	}

	/**
	 * Returns all the employee transfer requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee transfer requests
	 * @param companyId the primary key of the company
	 * @return the matching employee transfer requests, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeTransferRequest>
		getEmployeeTransferRequestsByUuidAndCompanyId(
			String uuid, long companyId) {

		return _employeeTransferRequestLocalService.
			getEmployeeTransferRequestsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of employee transfer requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee transfer requests
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of employee transfer requests
	 * @param end the upper bound of the range of employee transfer requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching employee transfer requests, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeTransferRequest>
		getEmployeeTransferRequestsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.adjecti.pis.liferay.model.EmployeeTransferRequest>
					orderByComparator) {

		return _employeeTransferRequestLocalService.
			getEmployeeTransferRequestsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of employee transfer requests.
	 *
	 * @return the number of employee transfer requests
	 */
	@Override
	public int getEmployeeTransferRequestsCount() {
		return _employeeTransferRequestLocalService.
			getEmployeeTransferRequestsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _employeeTransferRequestLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeTransferRequestLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeTransferRequestLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeTransferRequestLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the employee transfer request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeTransferRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeTransferRequest the employee transfer request
	 * @return the employee transfer request that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeTransferRequest
		updateEmployeeTransferRequest(
			com.adjecti.pis.liferay.model.EmployeeTransferRequest
				employeeTransferRequest) {

		return _employeeTransferRequestLocalService.
			updateEmployeeTransferRequest(employeeTransferRequest);
	}

	@Override
	public EmployeeTransferRequestLocalService getWrappedService() {
		return _employeeTransferRequestLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeTransferRequestLocalService
			employeeTransferRequestLocalService) {

		_employeeTransferRequestLocalService =
			employeeTransferRequestLocalService;
	}

	private EmployeeTransferRequestLocalService
		_employeeTransferRequestLocalService;

}