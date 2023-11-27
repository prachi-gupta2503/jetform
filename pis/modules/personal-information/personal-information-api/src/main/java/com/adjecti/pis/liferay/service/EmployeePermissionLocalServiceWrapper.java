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
 * Provides a wrapper for {@link EmployeePermissionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeePermissionLocalService
 * @generated
 */
public class EmployeePermissionLocalServiceWrapper
	implements EmployeePermissionLocalService,
			   ServiceWrapper<EmployeePermissionLocalService> {

	public EmployeePermissionLocalServiceWrapper(
		EmployeePermissionLocalService employeePermissionLocalService) {

		_employeePermissionLocalService = employeePermissionLocalService;
	}

	/**
	 * Adds the employee permission to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeePermissionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeePermission the employee permission
	 * @return the employee permission that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeePermission
		addEmployeePermission(
			com.adjecti.pis.liferay.model.EmployeePermission
				employeePermission) {

		return _employeePermissionLocalService.addEmployeePermission(
			employeePermission);
	}

	/**
	 * Creates a new employee permission with the primary key. Does not add the employee permission to the database.
	 *
	 * @param employeePermissionId the primary key for the new employee permission
	 * @return the new employee permission
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeePermission
		createEmployeePermission(long employeePermissionId) {

		return _employeePermissionLocalService.createEmployeePermission(
			employeePermissionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeePermissionLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the employee permission from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeePermissionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeePermission the employee permission
	 * @return the employee permission that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeePermission
		deleteEmployeePermission(
			com.adjecti.pis.liferay.model.EmployeePermission
				employeePermission) {

		return _employeePermissionLocalService.deleteEmployeePermission(
			employeePermission);
	}

	/**
	 * Deletes the employee permission with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeePermissionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeePermissionId the primary key of the employee permission
	 * @return the employee permission that was removed
	 * @throws PortalException if a employee permission with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeePermission
			deleteEmployeePermission(long employeePermissionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeePermissionLocalService.deleteEmployeePermission(
			employeePermissionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeePermissionLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeePermissionLocalService.dynamicQuery();
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

		return _employeePermissionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeePermissionModelImpl</code>.
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

		return _employeePermissionLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeePermissionModelImpl</code>.
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

		return _employeePermissionLocalService.dynamicQuery(
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

		return _employeePermissionLocalService.dynamicQueryCount(dynamicQuery);
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

		return _employeePermissionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeePermission
		fetchEmployeePermission(long employeePermissionId) {

		return _employeePermissionLocalService.fetchEmployeePermission(
			employeePermissionId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeePermissionLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the employee permission with the primary key.
	 *
	 * @param employeePermissionId the primary key of the employee permission
	 * @return the employee permission
	 * @throws PortalException if a employee permission with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeePermission
			getEmployeePermission(long employeePermissionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeePermissionLocalService.getEmployeePermission(
			employeePermissionId);
	}

	/**
	 * Returns a range of all the employee permissions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeePermissionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee permissions
	 * @param end the upper bound of the range of employee permissions (not inclusive)
	 * @return the range of employee permissions
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeePermission>
		getEmployeePermissions(int start, int end) {

		return _employeePermissionLocalService.getEmployeePermissions(
			start, end);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeePermission>
		getEmployeePermissionsByFormClassName(String formName) {

		return _employeePermissionLocalService.
			getEmployeePermissionsByFormClassName(formName);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeePermission>
		getEmployeePermissionsByJoiningProcessId(long joiningProcessId) {

		return _employeePermissionLocalService.
			getEmployeePermissionsByJoiningProcessId(joiningProcessId);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeePermission
			getEmployeePermissionsByRegistrationRequestId(
				long registrationRequestId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePermissionException {

		return _employeePermissionLocalService.
			getEmployeePermissionsByRegistrationRequestId(
				registrationRequestId);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeePermission
			getEmployeePermissionsBySingleUserOnboardingId(
				long singleUserOnboardingId)
		throws com.adjecti.pis.liferay.exception.
			NoSuchEmployeePermissionException {

		return _employeePermissionLocalService.
			getEmployeePermissionsBySingleUserOnboardingId(
				singleUserOnboardingId);
	}

	/**
	 * Returns the number of employee permissions.
	 *
	 * @return the number of employee permissions
	 */
	@Override
	public int getEmployeePermissionsCount() {
		return _employeePermissionLocalService.getEmployeePermissionsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeePermissionLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeePermissionLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeePermissionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the employee permission in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeePermissionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeePermission the employee permission
	 * @return the employee permission that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeePermission
		updateEmployeePermission(
			com.adjecti.pis.liferay.model.EmployeePermission
				employeePermission) {

		return _employeePermissionLocalService.updateEmployeePermission(
			employeePermission);
	}

	@Override
	public Object updatePermission(
			long employeePermissionId, boolean emailAccess,
			boolean digitalSigning, boolean eGovAccess, boolean pisAccess)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeePermissionLocalService.updatePermission(
			employeePermissionId, emailAccess, digitalSigning, eGovAccess,
			pisAccess);
	}

	@Override
	public EmployeePermissionLocalService getWrappedService() {
		return _employeePermissionLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeePermissionLocalService employeePermissionLocalService) {

		_employeePermissionLocalService = employeePermissionLocalService;
	}

	private EmployeePermissionLocalService _employeePermissionLocalService;

}