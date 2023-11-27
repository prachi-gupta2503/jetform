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
 * Provides a wrapper for {@link EmployeeJoiningLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeJoiningLocalService
 * @generated
 */
public class EmployeeJoiningLocalServiceWrapper
	implements EmployeeJoiningLocalService,
			   ServiceWrapper<EmployeeJoiningLocalService> {

	public EmployeeJoiningLocalServiceWrapper(
		EmployeeJoiningLocalService employeeJoiningLocalService) {

		_employeeJoiningLocalService = employeeJoiningLocalService;
	}

	/**
	 * Adds the employee joining to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeJoiningLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeJoining the employee joining
	 * @return the employee joining that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeJoining addEmployeeJoining(
		com.adjecti.pis.liferay.model.EmployeeJoining employeeJoining) {

		return _employeeJoiningLocalService.addEmployeeJoining(employeeJoining);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeeJoining
			addEmployeeJoiningDetails(
				com.adjecti.pis.liferay.model.EmployeeJoining
					employeeJoiningData)
		throws com.adjecti.pis.liferay.exception.EmployeeJoiningException,
			   com.liferay.portal.kernel.exception.PortalException {

		return _employeeJoiningLocalService.addEmployeeJoiningDetails(
			employeeJoiningData);
	}

	/**
	 * Creates a new employee joining with the primary key. Does not add the employee joining to the database.
	 *
	 * @param employeeJoiningId the primary key for the new employee joining
	 * @return the new employee joining
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeJoining createEmployeeJoining(
		long employeeJoiningId) {

		return _employeeJoiningLocalService.createEmployeeJoining(
			employeeJoiningId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeJoiningLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the employee joining from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeJoiningLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeJoining the employee joining
	 * @return the employee joining that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeJoining deleteEmployeeJoining(
		com.adjecti.pis.liferay.model.EmployeeJoining employeeJoining) {

		return _employeeJoiningLocalService.deleteEmployeeJoining(
			employeeJoining);
	}

	/**
	 * Deletes the employee joining with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeJoiningLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeJoiningId the primary key of the employee joining
	 * @return the employee joining that was removed
	 * @throws PortalException if a employee joining with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeJoining deleteEmployeeJoining(
			long employeeJoiningId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeJoiningLocalService.deleteEmployeeJoining(
			employeeJoiningId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeJoiningLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeJoiningLocalService.dynamicQuery();
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

		return _employeeJoiningLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeJoiningModelImpl</code>.
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

		return _employeeJoiningLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeJoiningModelImpl</code>.
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

		return _employeeJoiningLocalService.dynamicQuery(
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

		return _employeeJoiningLocalService.dynamicQueryCount(dynamicQuery);
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

		return _employeeJoiningLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeeJoining fetchEmployeeJoining(
		long employeeJoiningId) {

		return _employeeJoiningLocalService.fetchEmployeeJoining(
			employeeJoiningId);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeeJoining findByjoiningProcessId(
		long joiningProcessId) {

		return _employeeJoiningLocalService.findByjoiningProcessId(
			joiningProcessId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeJoining>
		findByOrganizationID(long organizationId) {

		return _employeeJoiningLocalService.findByOrganizationID(
			organizationId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeJoining>
		findBySubOrganizationId(long subOrganizationId) {

		return _employeeJoiningLocalService.findBySubOrganizationId(
			subOrganizationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeJoiningLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeJoining>
		getByPersonalNo(String personalNo) {

		return _employeeJoiningLocalService.getByPersonalNo(personalNo);
	}

	/**
	 * Returns the employee joining with the primary key.
	 *
	 * @param employeeJoiningId the primary key of the employee joining
	 * @return the employee joining
	 * @throws PortalException if a employee joining with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeJoining getEmployeeJoining(
			long employeeJoiningId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeJoiningLocalService.getEmployeeJoining(
			employeeJoiningId);
	}

	/**
	 * Returns a range of all the employee joinings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeJoiningModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee joinings
	 * @param end the upper bound of the range of employee joinings (not inclusive)
	 * @return the range of employee joinings
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeJoining>
		getEmployeeJoinings(int start, int end) {

		return _employeeJoiningLocalService.getEmployeeJoinings(start, end);
	}

	/**
	 * Returns the number of employee joinings.
	 *
	 * @return the number of employee joinings
	 */
	@Override
	public int getEmployeeJoiningsCount() {
		return _employeeJoiningLocalService.getEmployeeJoiningsCount();
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeJoining>
		getGradeModeByGradeModeId(long gradeModeId) {

		return _employeeJoiningLocalService.getGradeModeByGradeModeId(
			gradeModeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeJoiningLocalService.
			getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeJoining>
		getJoiningByEmployeeId(long employeeId) {

		return _employeeJoiningLocalService.getJoiningByEmployeeId(employeeId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeJoiningLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeJoiningLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeJoining>
		searchEmployeeJoining(
			long organizationId, long tradeId, long gradeId,
			long designationId) {

		return _employeeJoiningLocalService.searchEmployeeJoining(
			organizationId, tradeId, gradeId, designationId);
	}

	/**
	 * Updates the employee joining in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeJoiningLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeJoining the employee joining
	 * @return the employee joining that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeJoining updateEmployeeJoining(
		com.adjecti.pis.liferay.model.EmployeeJoining employeeJoining) {

		return _employeeJoiningLocalService.updateEmployeeJoining(
			employeeJoining);
	}

	@Override
	public EmployeeJoiningLocalService getWrappedService() {
		return _employeeJoiningLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeJoiningLocalService employeeJoiningLocalService) {

		_employeeJoiningLocalService = employeeJoiningLocalService;
	}

	private EmployeeJoiningLocalService _employeeJoiningLocalService;

}