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
 * Provides a wrapper for {@link EmployeeProfileLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeProfileLocalService
 * @generated
 */
public class EmployeeProfileLocalServiceWrapper
	implements EmployeeProfileLocalService,
			   ServiceWrapper<EmployeeProfileLocalService> {

	public EmployeeProfileLocalServiceWrapper(
		EmployeeProfileLocalService employeeProfileLocalService) {

		_employeeProfileLocalService = employeeProfileLocalService;
	}

	/**
	 * Adds the employee profile to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeProfileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeProfile the employee profile
	 * @return the employee profile that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeProfile addEmployeeProfile(
		com.adjecti.pis.liferay.model.EmployeeProfile employeeProfile) {

		return _employeeProfileLocalService.addEmployeeProfile(employeeProfile);
	}

	/**
	 * Creates a new employee profile with the primary key. Does not add the employee profile to the database.
	 *
	 * @param employeeProfileId the primary key for the new employee profile
	 * @return the new employee profile
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeProfile createEmployeeProfile(
		long employeeProfileId) {

		return _employeeProfileLocalService.createEmployeeProfile(
			employeeProfileId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeProfileLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the employee profile from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeProfileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeProfile the employee profile
	 * @return the employee profile that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeProfile deleteEmployeeProfile(
		com.adjecti.pis.liferay.model.EmployeeProfile employeeProfile) {

		return _employeeProfileLocalService.deleteEmployeeProfile(
			employeeProfile);
	}

	/**
	 * Deletes the employee profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeProfileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeProfileId the primary key of the employee profile
	 * @return the employee profile that was removed
	 * @throws PortalException if a employee profile with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeProfile deleteEmployeeProfile(
			long employeeProfileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeProfileLocalService.deleteEmployeeProfile(
			employeeProfileId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeProfileLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeProfileLocalService.dynamicQuery();
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

		return _employeeProfileLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeProfileModelImpl</code>.
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

		return _employeeProfileLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeProfileModelImpl</code>.
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

		return _employeeProfileLocalService.dynamicQuery(
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

		return _employeeProfileLocalService.dynamicQueryCount(dynamicQuery);
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

		return _employeeProfileLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeeProfile fetchEmployeeProfile(
		long employeeProfileId) {

		return _employeeProfileLocalService.fetchEmployeeProfile(
			employeeProfileId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeProfileLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the employee profile with the primary key.
	 *
	 * @param employeeProfileId the primary key of the employee profile
	 * @return the employee profile
	 * @throws PortalException if a employee profile with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeProfile getEmployeeProfile(
			long employeeProfileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeProfileLocalService.getEmployeeProfile(
			employeeProfileId);
	}

	/**
	 * Returns a range of all the employee profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeProfileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee profiles
	 * @param end the upper bound of the range of employee profiles (not inclusive)
	 * @return the range of employee profiles
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeProfile>
		getEmployeeProfiles(int start, int end) {

		return _employeeProfileLocalService.getEmployeeProfiles(start, end);
	}

	/**
	 * Returns the number of employee profiles.
	 *
	 * @return the number of employee profiles
	 */
	@Override
	public int getEmployeeProfilesCount() {
		return _employeeProfileLocalService.getEmployeeProfilesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeProfileLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeProfileLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeProfileLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the employee profile in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeProfileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeProfile the employee profile
	 * @return the employee profile that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeProfile updateEmployeeProfile(
		com.adjecti.pis.liferay.model.EmployeeProfile employeeProfile) {

		return _employeeProfileLocalService.updateEmployeeProfile(
			employeeProfile);
	}

	@Override
	public EmployeeProfileLocalService getWrappedService() {
		return _employeeProfileLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeProfileLocalService employeeProfileLocalService) {

		_employeeProfileLocalService = employeeProfileLocalService;
	}

	private EmployeeProfileLocalService _employeeProfileLocalService;

}