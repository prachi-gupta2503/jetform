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
 * Provides a wrapper for {@link EmployeeTradeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeTradeLocalService
 * @generated
 */
public class EmployeeTradeLocalServiceWrapper
	implements EmployeeTradeLocalService,
			   ServiceWrapper<EmployeeTradeLocalService> {

	public EmployeeTradeLocalServiceWrapper(
		EmployeeTradeLocalService employeeTradeLocalService) {

		_employeeTradeLocalService = employeeTradeLocalService;
	}

	/**
	 * Adds the employee trade to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeTradeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeTrade the employee trade
	 * @return the employee trade that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeTrade addEmployeeTrade(
		com.adjecti.pis.liferay.model.EmployeeTrade employeeTrade) {

		return _employeeTradeLocalService.addEmployeeTrade(employeeTrade);
	}

	/**
	 * Creates a new employee trade with the primary key. Does not add the employee trade to the database.
	 *
	 * @param employeeTradeId the primary key for the new employee trade
	 * @return the new employee trade
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeTrade createEmployeeTrade(
		long employeeTradeId) {

		return _employeeTradeLocalService.createEmployeeTrade(employeeTradeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeTradeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the employee trade from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeTradeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeTrade the employee trade
	 * @return the employee trade that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeTrade deleteEmployeeTrade(
		com.adjecti.pis.liferay.model.EmployeeTrade employeeTrade) {

		return _employeeTradeLocalService.deleteEmployeeTrade(employeeTrade);
	}

	/**
	 * Deletes the employee trade with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeTradeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeTradeId the primary key of the employee trade
	 * @return the employee trade that was removed
	 * @throws PortalException if a employee trade with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeTrade deleteEmployeeTrade(
			long employeeTradeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeTradeLocalService.deleteEmployeeTrade(employeeTradeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeTradeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeTradeLocalService.dynamicQuery();
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

		return _employeeTradeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeTradeModelImpl</code>.
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

		return _employeeTradeLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeTradeModelImpl</code>.
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

		return _employeeTradeLocalService.dynamicQuery(
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

		return _employeeTradeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _employeeTradeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeeTrade fetchEmployeeTrade(
		long employeeTradeId) {

		return _employeeTradeLocalService.fetchEmployeeTrade(employeeTradeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeTradeLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeTrade>
		getByEmployeeId(long employeeId) {

		return _employeeTradeLocalService.getByEmployeeId(employeeId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeTrade>
		getByPersonalNo(String personalNo) {

		return _employeeTradeLocalService.getByPersonalNo(personalNo);
	}

	/**
	 * Returns the employee trade with the primary key.
	 *
	 * @param employeeTradeId the primary key of the employee trade
	 * @return the employee trade
	 * @throws PortalException if a employee trade with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeTrade getEmployeeTrade(
			long employeeTradeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeTradeLocalService.getEmployeeTrade(employeeTradeId);
	}

	/**
	 * Returns a range of all the employee trades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeTradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee trades
	 * @param end the upper bound of the range of employee trades (not inclusive)
	 * @return the range of employee trades
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeTrade>
		getEmployeeTrades(int start, int end) {

		return _employeeTradeLocalService.getEmployeeTrades(start, end);
	}

	/**
	 * Returns the number of employee trades.
	 *
	 * @return the number of employee trades
	 */
	@Override
	public int getEmployeeTradesCount() {
		return _employeeTradeLocalService.getEmployeeTradesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeTradeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeTradeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeTradeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the employee trade in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeTradeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeTrade the employee trade
	 * @return the employee trade that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeTrade updateEmployeeTrade(
		com.adjecti.pis.liferay.model.EmployeeTrade employeeTrade) {

		return _employeeTradeLocalService.updateEmployeeTrade(employeeTrade);
	}

	@Override
	public EmployeeTradeLocalService getWrappedService() {
		return _employeeTradeLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeTradeLocalService employeeTradeLocalService) {

		_employeeTradeLocalService = employeeTradeLocalService;
	}

	private EmployeeTradeLocalService _employeeTradeLocalService;

}