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
 * Provides a wrapper for {@link EmployeeOrganizationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeOrganizationLocalService
 * @generated
 */
public class EmployeeOrganizationLocalServiceWrapper
	implements EmployeeOrganizationLocalService,
			   ServiceWrapper<EmployeeOrganizationLocalService> {

	public EmployeeOrganizationLocalServiceWrapper(
		EmployeeOrganizationLocalService employeeOrganizationLocalService) {

		_employeeOrganizationLocalService = employeeOrganizationLocalService;
	}

	/**
	 * Adds the employee organization to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeOrganizationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeOrganization the employee organization
	 * @return the employee organization that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeOrganization
		addEmployeeOrganization(
			com.adjecti.pis.liferay.model.EmployeeOrganization
				employeeOrganization) {

		return _employeeOrganizationLocalService.addEmployeeOrganization(
			employeeOrganization);
	}

	@Override
	public boolean beforeDeleteEmployeeOrganization(
			com.adjecti.pis.liferay.model.EmployeeOrganization entity,
			boolean logical)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeOrganizationLocalService.
			beforeDeleteEmployeeOrganization(entity, logical);
	}

	@Override
	public boolean beforeDeleteEmployeeOrganization(
			Object entity, boolean logical)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeOrganizationLocalService.
			beforeDeleteEmployeeOrganization(entity, logical);
	}

	@Override
	public boolean beforeUpdateEmployeeOrganization(
			com.adjecti.pis.liferay.model.EmployeeOrganization entity,
			java.util.Map<String, String[]> fieldValues)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeOrganizationLocalService.
			beforeUpdateEmployeeOrganization(entity, fieldValues);
	}

	@Override
	public boolean beforeUpdateEmployeeOrganization(
			Object entity, java.util.Map<String, String[]> fieldValues)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeOrganizationLocalService.
			beforeUpdateEmployeeOrganization(entity, fieldValues);
	}

	/**
	 * Creates a new employee organization with the primary key. Does not add the employee organization to the database.
	 *
	 * @param employeeOrganizationId the primary key for the new employee organization
	 * @return the new employee organization
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeOrganization
		createEmployeeOrganization(long employeeOrganizationId) {

		return _employeeOrganizationLocalService.createEmployeeOrganization(
			employeeOrganizationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeOrganizationLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the employee organization from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeOrganizationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeOrganization the employee organization
	 * @return the employee organization that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeOrganization
		deleteEmployeeOrganization(
			com.adjecti.pis.liferay.model.EmployeeOrganization
				employeeOrganization) {

		return _employeeOrganizationLocalService.deleteEmployeeOrganization(
			employeeOrganization);
	}

	/**
	 * Deletes the employee organization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeOrganizationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeOrganizationId the primary key of the employee organization
	 * @return the employee organization that was removed
	 * @throws PortalException if a employee organization with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeOrganization
			deleteEmployeeOrganization(long employeeOrganizationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeOrganizationLocalService.deleteEmployeeOrganization(
			employeeOrganizationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeOrganizationLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeOrganizationLocalService.dynamicQuery();
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

		return _employeeOrganizationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeOrganizationModelImpl</code>.
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

		return _employeeOrganizationLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeOrganizationModelImpl</code>.
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

		return _employeeOrganizationLocalService.dynamicQuery(
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

		return _employeeOrganizationLocalService.dynamicQueryCount(
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

		return _employeeOrganizationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public boolean existsEmployeeOrganization(
		long employeeId, long organizationId) {

		return _employeeOrganizationLocalService.existsEmployeeOrganization(
			employeeId, organizationId);
	}

	@Override
	public boolean existsEmployeeSubOrganization(
		long employeeId, long subOrganizationId) {

		return _employeeOrganizationLocalService.existsEmployeeSubOrganization(
			employeeId, subOrganizationId);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeeOrganization
		fetchEmployeeOrganization(long employeeOrganizationId) {

		return _employeeOrganizationLocalService.fetchEmployeeOrganization(
			employeeOrganizationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeOrganizationLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeOrganization>
		getByEmployeeIdAndOrganizationId(long employeeId, long organizationId) {

		return _employeeOrganizationLocalService.
			getByEmployeeIdAndOrganizationId(employeeId, organizationId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeOrganization>
		getByEmployeeIdAndSubOrganizationId(
			long employeeId, long subOrganizationId) {

		return _employeeOrganizationLocalService.
			getByEmployeeIdAndSubOrganizationId(employeeId, subOrganizationId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeOrganization>
		getByOrganizationId(long organizationId) {

		return _employeeOrganizationLocalService.getByOrganizationId(
			organizationId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeOrganization>
		getBySubOrganizationIdAndActive(
			long subOrganizationId, boolean active) {

		return _employeeOrganizationLocalService.
			getBySubOrganizationIdAndActive(subOrganizationId, active);
	}

	/**
	 * Returns the employee organization with the primary key.
	 *
	 * @param employeeOrganizationId the primary key of the employee organization
	 * @return the employee organization
	 * @throws PortalException if a employee organization with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeOrganization
			getEmployeeOrganization(long employeeOrganizationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeOrganizationLocalService.getEmployeeOrganization(
			employeeOrganizationId);
	}

	@Override
	public int getEmployeeOrganizationCountByEmployeeIdAndOrganizationId(
		long employeeId, long organizationId) {

		return _employeeOrganizationLocalService.
			getEmployeeOrganizationCountByEmployeeIdAndOrganizationId(
				employeeId, organizationId);
	}

	@Override
	public int getEmployeeOrganizationCountByEmployeeIdAndSubOrganizationId(
		long employeeId, long subOrganizationId) {

		return _employeeOrganizationLocalService.
			getEmployeeOrganizationCountByEmployeeIdAndSubOrganizationId(
				employeeId, subOrganizationId);
	}

	/**
	 * Returns a range of all the employee organizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee organizations
	 * @param end the upper bound of the range of employee organizations (not inclusive)
	 * @return the range of employee organizations
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeOrganization>
		getEmployeeOrganizations(int start, int end) {

		return _employeeOrganizationLocalService.getEmployeeOrganizations(
			start, end);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeOrganization>
		getEmployeeOrganizationsByEmployeeId(long employeeId) {

		return _employeeOrganizationLocalService.
			getEmployeeOrganizationsByEmployeeId(employeeId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeOrganization>
		getEmployeeOrganizationsByPersonalNo(String personalNo) {

		return _employeeOrganizationLocalService.
			getEmployeeOrganizationsByPersonalNo(personalNo);
	}

	/**
	 * Returns the number of employee organizations.
	 *
	 * @return the number of employee organizations
	 */
	@Override
	public int getEmployeeOrganizationsCount() {
		return _employeeOrganizationLocalService.
			getEmployeeOrganizationsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeOrganizationLocalService.
			getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.model.Organization>
		getNonAssignedOrganizationsOfEmployee(
			long parentId, String type, long employeeId) {

		return _employeeOrganizationLocalService.
			getNonAssignedOrganizationsOfEmployee(parentId, type, employeeId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeOrganizationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeOrganizationLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public java.util.Map<String, String> importEmployeeOrganization(
		java.util.List<java.util.Map<String, String[]>> records) {

		return _employeeOrganizationLocalService.importEmployeeOrganization(
			records);
	}

	/**
	 * Updates the employee organization in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeOrganizationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeOrganization the employee organization
	 * @return the employee organization that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeOrganization
		updateEmployeeOrganization(
			com.adjecti.pis.liferay.model.EmployeeOrganization
				employeeOrganization) {

		return _employeeOrganizationLocalService.updateEmployeeOrganization(
			employeeOrganization);
	}

	@Override
	public String updateOrganization(
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay,
		String status, long organizationId) {

		return _employeeOrganizationLocalService.updateOrganization(
			themeDisplay, status, organizationId);
	}

	@Override
	public EmployeeOrganizationLocalService getWrappedService() {
		return _employeeOrganizationLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeOrganizationLocalService employeeOrganizationLocalService) {

		_employeeOrganizationLocalService = employeeOrganizationLocalService;
	}

	private EmployeeOrganizationLocalService _employeeOrganizationLocalService;

}