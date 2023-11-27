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
 * Provides a wrapper for {@link EmployeeQualificationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeQualificationLocalService
 * @generated
 */
public class EmployeeQualificationLocalServiceWrapper
	implements EmployeeQualificationLocalService,
			   ServiceWrapper<EmployeeQualificationLocalService> {

	public EmployeeQualificationLocalServiceWrapper(
		EmployeeQualificationLocalService employeeQualificationLocalService) {

		_employeeQualificationLocalService = employeeQualificationLocalService;
	}

	/**
	 * Adds the employee qualification to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeQualificationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeQualification the employee qualification
	 * @return the employee qualification that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeQualification
		addEmployeeQualification(
			com.adjecti.pis.liferay.model.EmployeeQualification
				employeeQualification) {

		return _employeeQualificationLocalService.addEmployeeQualification(
			employeeQualification);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeQualification>
			addEmployeeQualification(
				java.util.List
					<com.adjecti.pis.liferay.model.EmployeeQualification>
						empQualification)
		throws com.adjecti.pis.liferay.exception.EmployeeQualificationException,
			   com.liferay.portal.kernel.exception.PortalException {

		return _employeeQualificationLocalService.addEmployeeQualification(
			empQualification);
	}

	/**
	 * Creates a new employee qualification with the primary key. Does not add the employee qualification to the database.
	 *
	 * @param employeeQualificationId the primary key for the new employee qualification
	 * @return the new employee qualification
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeQualification
		createEmployeeQualification(long employeeQualificationId) {

		return _employeeQualificationLocalService.createEmployeeQualification(
			employeeQualificationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeQualificationLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the employee qualification from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeQualificationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeQualification the employee qualification
	 * @return the employee qualification that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeQualification
		deleteEmployeeQualification(
			com.adjecti.pis.liferay.model.EmployeeQualification
				employeeQualification) {

		return _employeeQualificationLocalService.deleteEmployeeQualification(
			employeeQualification);
	}

	/**
	 * Deletes the employee qualification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeQualificationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeQualificationId the primary key of the employee qualification
	 * @return the employee qualification that was removed
	 * @throws PortalException if a employee qualification with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeQualification
			deleteEmployeeQualification(long employeeQualificationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeQualificationLocalService.deleteEmployeeQualification(
			employeeQualificationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeQualificationLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeQualificationLocalService.dynamicQuery();
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

		return _employeeQualificationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeQualificationModelImpl</code>.
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

		return _employeeQualificationLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeQualificationModelImpl</code>.
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

		return _employeeQualificationLocalService.dynamicQuery(
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

		return _employeeQualificationLocalService.dynamicQueryCount(
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

		return _employeeQualificationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeeQualification
		fetchEmployeeQualification(long employeeQualificationId) {

		return _employeeQualificationLocalService.fetchEmployeeQualification(
			employeeQualificationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeQualificationLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the employee qualification with the primary key.
	 *
	 * @param employeeQualificationId the primary key of the employee qualification
	 * @return the employee qualification
	 * @throws PortalException if a employee qualification with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeQualification
			getEmployeeQualification(long employeeQualificationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeQualificationLocalService.getEmployeeQualification(
			employeeQualificationId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeQualification>
		getEmployeeQualificationByEmployeeId(long employeeId) {

		return _employeeQualificationLocalService.
			getEmployeeQualificationByEmployeeId(employeeId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeQualification>
		getEmployeeQualificationByPersonalNo(String personalNo) {

		return _employeeQualificationLocalService.
			getEmployeeQualificationByPersonalNo(personalNo);
	}

	@Override
	public int getEmployeeQualificationCountByEmployeeId(long employeeId) {
		return _employeeQualificationLocalService.
			getEmployeeQualificationCountByEmployeeId(employeeId);
	}

	@Override
	public int getEmployeeQualificationCountByQualificationId(
		long qualificationId) {

		return _employeeQualificationLocalService.
			getEmployeeQualificationCountByQualificationId(qualificationId);
	}

	@Override
	public int getEmployeeQualificationCountBySpecializationId(
		long specializationId) {

		return _employeeQualificationLocalService.
			getEmployeeQualificationCountBySpecializationId(specializationId);
	}

	/**
	 * Returns a range of all the employee qualifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeQualificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee qualifications
	 * @param end the upper bound of the range of employee qualifications (not inclusive)
	 * @return the range of employee qualifications
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeQualification>
		getEmployeeQualifications(int start, int end) {

		return _employeeQualificationLocalService.getEmployeeQualifications(
			start, end);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeQualification>
		getEmployeeQualificationsByJoiningProcessId(long joiningProcessId) {

		return _employeeQualificationLocalService.
			getEmployeeQualificationsByJoiningProcessId(joiningProcessId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeQualification>
		getEmployeeQualificationsByQualificationLevelId(
			long qualificationLevelId) {

		return _employeeQualificationLocalService.
			getEmployeeQualificationsByQualificationLevelId(
				qualificationLevelId);
	}

	/**
	 * Returns the number of employee qualifications.
	 *
	 * @return the number of employee qualifications
	 */
	@Override
	public int getEmployeeQualificationsCount() {
		return _employeeQualificationLocalService.
			getEmployeeQualificationsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeQualificationLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeQualificationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeQualificationLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the employee qualification in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeQualificationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeQualification the employee qualification
	 * @return the employee qualification that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeQualification
		updateEmployeeQualification(
			com.adjecti.pis.liferay.model.EmployeeQualification
				employeeQualification) {

		return _employeeQualificationLocalService.updateEmployeeQualification(
			employeeQualification);
	}

	@Override
	public EmployeeQualificationLocalService getWrappedService() {
		return _employeeQualificationLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeQualificationLocalService employeeQualificationLocalService) {

		_employeeQualificationLocalService = employeeQualificationLocalService;
	}

	private EmployeeQualificationLocalService
		_employeeQualificationLocalService;

}