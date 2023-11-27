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
 * Provides a wrapper for {@link EmployeeBiodataLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeBiodataLocalService
 * @generated
 */
public class EmployeeBiodataLocalServiceWrapper
	implements EmployeeBiodataLocalService,
			   ServiceWrapper<EmployeeBiodataLocalService> {

	public EmployeeBiodataLocalServiceWrapper(
		EmployeeBiodataLocalService employeeBiodataLocalService) {

		_employeeBiodataLocalService = employeeBiodataLocalService;
	}

	/**
	 * Adds the employee biodata to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeBiodataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeBiodata the employee biodata
	 * @return the employee biodata that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeBiodata addEmployeeBiodata(
		com.adjecti.pis.liferay.model.EmployeeBiodata employeeBiodata) {

		return _employeeBiodataLocalService.addEmployeeBiodata(employeeBiodata);
	}

	/**
	 * Creates a new employee biodata with the primary key. Does not add the employee biodata to the database.
	 *
	 * @param employeeBiodataId the primary key for the new employee biodata
	 * @return the new employee biodata
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeBiodata createEmployeeBiodata(
		long employeeBiodataId) {

		return _employeeBiodataLocalService.createEmployeeBiodata(
			employeeBiodataId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeBiodataLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the employee biodata from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeBiodataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeBiodata the employee biodata
	 * @return the employee biodata that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeBiodata deleteEmployeeBiodata(
		com.adjecti.pis.liferay.model.EmployeeBiodata employeeBiodata) {

		return _employeeBiodataLocalService.deleteEmployeeBiodata(
			employeeBiodata);
	}

	/**
	 * Deletes the employee biodata with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeBiodataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeBiodataId the primary key of the employee biodata
	 * @return the employee biodata that was removed
	 * @throws PortalException if a employee biodata with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeBiodata deleteEmployeeBiodata(
			long employeeBiodataId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeBiodataLocalService.deleteEmployeeBiodata(
			employeeBiodataId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeBiodataLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeBiodataLocalService.dynamicQuery();
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

		return _employeeBiodataLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeBiodataModelImpl</code>.
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

		return _employeeBiodataLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeBiodataModelImpl</code>.
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

		return _employeeBiodataLocalService.dynamicQuery(
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

		return _employeeBiodataLocalService.dynamicQueryCount(dynamicQuery);
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

		return _employeeBiodataLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeeBiodata fetchEmployeeBiodata(
		long employeeBiodataId) {

		return _employeeBiodataLocalService.fetchEmployeeBiodata(
			employeeBiodataId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeBiodataLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the employee biodata with the primary key.
	 *
	 * @param employeeBiodataId the primary key of the employee biodata
	 * @return the employee biodata
	 * @throws PortalException if a employee biodata with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeBiodata getEmployeeBiodata(
			long employeeBiodataId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeBiodataLocalService.getEmployeeBiodata(
			employeeBiodataId);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeeBiodata
		getEmployeeBiodataByEmployeeId(long employeeId) {

		return _employeeBiodataLocalService.getEmployeeBiodataByEmployeeId(
			employeeId);
	}

	/**
	 * Returns a range of all the employee biodatas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeBiodataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee biodatas
	 * @param end the upper bound of the range of employee biodatas (not inclusive)
	 * @return the range of employee biodatas
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeBiodata>
		getEmployeeBiodatas(int start, int end) {

		return _employeeBiodataLocalService.getEmployeeBiodatas(start, end);
	}

	/**
	 * Returns the number of employee biodatas.
	 *
	 * @return the number of employee biodatas
	 */
	@Override
	public int getEmployeeBiodatasCount() {
		return _employeeBiodataLocalService.getEmployeeBiodatasCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeBiodataLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeBiodataLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeBiodataLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the employee biodata in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeBiodataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeBiodata the employee biodata
	 * @return the employee biodata that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeBiodata updateEmployeeBiodata(
		com.adjecti.pis.liferay.model.EmployeeBiodata employeeBiodata) {

		return _employeeBiodataLocalService.updateEmployeeBiodata(
			employeeBiodata);
	}

	@Override
	public EmployeeBiodataLocalService getWrappedService() {
		return _employeeBiodataLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeBiodataLocalService employeeBiodataLocalService) {

		_employeeBiodataLocalService = employeeBiodataLocalService;
	}

	private EmployeeBiodataLocalService _employeeBiodataLocalService;

}