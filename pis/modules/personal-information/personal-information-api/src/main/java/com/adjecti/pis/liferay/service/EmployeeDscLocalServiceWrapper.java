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
 * Provides a wrapper for {@link EmployeeDscLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDscLocalService
 * @generated
 */
public class EmployeeDscLocalServiceWrapper
	implements EmployeeDscLocalService,
			   ServiceWrapper<EmployeeDscLocalService> {

	public EmployeeDscLocalServiceWrapper(
		EmployeeDscLocalService employeeDscLocalService) {

		_employeeDscLocalService = employeeDscLocalService;
	}

	/**
	 * Adds the employee dsc to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDscLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDsc the employee dsc
	 * @return the employee dsc that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeDsc addEmployeeDsc(
		com.adjecti.pis.liferay.model.EmployeeDsc employeeDsc) {

		return _employeeDscLocalService.addEmployeeDsc(employeeDsc);
	}

	/**
	 * Creates a new employee dsc with the primary key. Does not add the employee dsc to the database.
	 *
	 * @param employeeDscId the primary key for the new employee dsc
	 * @return the new employee dsc
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeDsc createEmployeeDsc(
		long employeeDscId) {

		return _employeeDscLocalService.createEmployeeDsc(employeeDscId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDscLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the employee dsc from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDscLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDsc the employee dsc
	 * @return the employee dsc that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeDsc deleteEmployeeDsc(
		com.adjecti.pis.liferay.model.EmployeeDsc employeeDsc) {

		return _employeeDscLocalService.deleteEmployeeDsc(employeeDsc);
	}

	/**
	 * Deletes the employee dsc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDscLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDscId the primary key of the employee dsc
	 * @return the employee dsc that was removed
	 * @throws PortalException if a employee dsc with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeDsc deleteEmployeeDsc(
			long employeeDscId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDscLocalService.deleteEmployeeDsc(employeeDscId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDscLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeDscLocalService.dynamicQuery();
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

		return _employeeDscLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeDscModelImpl</code>.
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

		return _employeeDscLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeDscModelImpl</code>.
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

		return _employeeDscLocalService.dynamicQuery(
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

		return _employeeDscLocalService.dynamicQueryCount(dynamicQuery);
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

		return _employeeDscLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeeDsc fetchEmployeeDsc(
		long employeeDscId) {

		return _employeeDscLocalService.fetchEmployeeDsc(employeeDscId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeDscLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the employee dsc with the primary key.
	 *
	 * @param employeeDscId the primary key of the employee dsc
	 * @return the employee dsc
	 * @throws PortalException if a employee dsc with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeDsc getEmployeeDsc(
			long employeeDscId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDscLocalService.getEmployeeDsc(employeeDscId);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeeDsc getEmployeeDscByEmployeeId(
		long employeeId) {

		return _employeeDscLocalService.getEmployeeDscByEmployeeId(employeeId);
	}

	/**
	 * Returns a range of all the employee dscs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeDscModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee dscs
	 * @param end the upper bound of the range of employee dscs (not inclusive)
	 * @return the range of employee dscs
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeDsc>
		getEmployeeDscs(int start, int end) {

		return _employeeDscLocalService.getEmployeeDscs(start, end);
	}

	/**
	 * Returns the number of employee dscs.
	 *
	 * @return the number of employee dscs
	 */
	@Override
	public int getEmployeeDscsCount() {
		return _employeeDscLocalService.getEmployeeDscsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeDscLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeDscLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDscLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public boolean isDscReissueable(long employeeId) {
		return _employeeDscLocalService.isDscReissueable(employeeId);
	}

	@Override
	public boolean isDscRevokeable(long employeeId) {
		return _employeeDscLocalService.isDscRevokeable(employeeId);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeeDsc update(
			com.adjecti.pis.liferay.model.EmployeeDsc employeeDsc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDscLocalService.update(employeeDsc);
	}

	/**
	 * Updates the employee dsc in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDscLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDsc the employee dsc
	 * @return the employee dsc that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeDsc updateEmployeeDsc(
		com.adjecti.pis.liferay.model.EmployeeDsc employeeDsc) {

		return _employeeDscLocalService.updateEmployeeDsc(employeeDsc);
	}

	@Override
	public EmployeeDscLocalService getWrappedService() {
		return _employeeDscLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeDscLocalService employeeDscLocalService) {

		_employeeDscLocalService = employeeDscLocalService;
	}

	private EmployeeDscLocalService _employeeDscLocalService;

}