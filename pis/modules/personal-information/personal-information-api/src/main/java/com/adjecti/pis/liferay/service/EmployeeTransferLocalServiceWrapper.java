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
 * Provides a wrapper for {@link EmployeeTransferLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeTransferLocalService
 * @generated
 */
public class EmployeeTransferLocalServiceWrapper
	implements EmployeeTransferLocalService,
			   ServiceWrapper<EmployeeTransferLocalService> {

	public EmployeeTransferLocalServiceWrapper(
		EmployeeTransferLocalService employeeTransferLocalService) {

		_employeeTransferLocalService = employeeTransferLocalService;
	}

	/**
	 * Adds the employee transfer to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeTransferLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeTransfer the employee transfer
	 * @return the employee transfer that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeTransfer addEmployeeTransfer(
		com.adjecti.pis.liferay.model.EmployeeTransfer employeeTransfer) {

		return _employeeTransferLocalService.addEmployeeTransfer(
			employeeTransfer);
	}

	/**
	 * Creates a new employee transfer with the primary key. Does not add the employee transfer to the database.
	 *
	 * @param employeeTransferId the primary key for the new employee transfer
	 * @return the new employee transfer
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeTransfer
		createEmployeeTransfer(long employeeTransferId) {

		return _employeeTransferLocalService.createEmployeeTransfer(
			employeeTransferId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeTransferLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the employee transfer from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeTransferLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeTransfer the employee transfer
	 * @return the employee transfer that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeTransfer
		deleteEmployeeTransfer(
			com.adjecti.pis.liferay.model.EmployeeTransfer employeeTransfer) {

		return _employeeTransferLocalService.deleteEmployeeTransfer(
			employeeTransfer);
	}

	/**
	 * Deletes the employee transfer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeTransferLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeTransferId the primary key of the employee transfer
	 * @return the employee transfer that was removed
	 * @throws PortalException if a employee transfer with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeTransfer
			deleteEmployeeTransfer(long employeeTransferId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeTransferLocalService.deleteEmployeeTransfer(
			employeeTransferId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeTransferLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeTransferLocalService.dynamicQuery();
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

		return _employeeTransferLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeTransferModelImpl</code>.
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

		return _employeeTransferLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeTransferModelImpl</code>.
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

		return _employeeTransferLocalService.dynamicQuery(
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

		return _employeeTransferLocalService.dynamicQueryCount(dynamicQuery);
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

		return _employeeTransferLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeeTransfer fetchEmployeeTransfer(
		long employeeTransferId) {

		return _employeeTransferLocalService.fetchEmployeeTransfer(
			employeeTransferId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeTransferLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeTransfer>
		getByEmployeeId(long employeeId) {

		return _employeeTransferLocalService.getByEmployeeId(employeeId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeTransfer>
		getByFromOrganizationId(long fromOrganizationId) {

		return _employeeTransferLocalService.getByFromOrganizationId(
			fromOrganizationId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeTransfer>
		getByPersonalNo(String personalNo) {

		return _employeeTransferLocalService.getByPersonalNo(personalNo);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeTransfer>
		getByToOrganizationId(long toOrganizationId) {

		return _employeeTransferLocalService.getByToOrganizationId(
			toOrganizationId);
	}

	/**
	 * Returns the employee transfer with the primary key.
	 *
	 * @param employeeTransferId the primary key of the employee transfer
	 * @return the employee transfer
	 * @throws PortalException if a employee transfer with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeTransfer getEmployeeTransfer(
			long employeeTransferId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeTransferLocalService.getEmployeeTransfer(
			employeeTransferId);
	}

	/**
	 * Returns a range of all the employee transfers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeTransferModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee transfers
	 * @param end the upper bound of the range of employee transfers (not inclusive)
	 * @return the range of employee transfers
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeTransfer>
		getEmployeeTransfers(int start, int end) {

		return _employeeTransferLocalService.getEmployeeTransfers(start, end);
	}

	/**
	 * Returns the number of employee transfers.
	 *
	 * @return the number of employee transfers
	 */
	@Override
	public int getEmployeeTransfersCount() {
		return _employeeTransferLocalService.getEmployeeTransfersCount();
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeTransfer>
		getGradeModeByGradeModeId(long gradeModeId) {

		return _employeeTransferLocalService.getGradeModeByGradeModeId(
			gradeModeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeTransferLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeTransferLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeTransferLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the employee transfer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeTransferLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeTransfer the employee transfer
	 * @return the employee transfer that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeTransfer
		updateEmployeeTransfer(
			com.adjecti.pis.liferay.model.EmployeeTransfer employeeTransfer) {

		return _employeeTransferLocalService.updateEmployeeTransfer(
			employeeTransfer);
	}

	@Override
	public EmployeeTransferLocalService getWrappedService() {
		return _employeeTransferLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeTransferLocalService employeeTransferLocalService) {

		_employeeTransferLocalService = employeeTransferLocalService;
	}

	private EmployeeTransferLocalService _employeeTransferLocalService;

}