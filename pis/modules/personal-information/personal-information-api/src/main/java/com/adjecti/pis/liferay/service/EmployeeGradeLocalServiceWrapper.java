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
 * Provides a wrapper for {@link EmployeeGradeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeGradeLocalService
 * @generated
 */
public class EmployeeGradeLocalServiceWrapper
	implements EmployeeGradeLocalService,
			   ServiceWrapper<EmployeeGradeLocalService> {

	public EmployeeGradeLocalServiceWrapper(
		EmployeeGradeLocalService employeeGradeLocalService) {

		_employeeGradeLocalService = employeeGradeLocalService;
	}

	/**
	 * Adds the employee grade to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeGradeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeGrade the employee grade
	 * @return the employee grade that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeGrade addEmployeeGrade(
		com.adjecti.pis.liferay.model.EmployeeGrade employeeGrade) {

		return _employeeGradeLocalService.addEmployeeGrade(employeeGrade);
	}

	/**
	 * Creates a new employee grade with the primary key. Does not add the employee grade to the database.
	 *
	 * @param employeeGradeId the primary key for the new employee grade
	 * @return the new employee grade
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeGrade createEmployeeGrade(
		long employeeGradeId) {

		return _employeeGradeLocalService.createEmployeeGrade(employeeGradeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeGradeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the employee grade from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeGradeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeGrade the employee grade
	 * @return the employee grade that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeGrade deleteEmployeeGrade(
		com.adjecti.pis.liferay.model.EmployeeGrade employeeGrade) {

		return _employeeGradeLocalService.deleteEmployeeGrade(employeeGrade);
	}

	/**
	 * Deletes the employee grade with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeGradeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeGradeId the primary key of the employee grade
	 * @return the employee grade that was removed
	 * @throws PortalException if a employee grade with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeGrade deleteEmployeeGrade(
			long employeeGradeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeGradeLocalService.deleteEmployeeGrade(employeeGradeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeGradeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeGradeLocalService.dynamicQuery();
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

		return _employeeGradeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeGradeModelImpl</code>.
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

		return _employeeGradeLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeGradeModelImpl</code>.
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

		return _employeeGradeLocalService.dynamicQuery(
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

		return _employeeGradeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _employeeGradeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeeGrade fetchEmployeeGrade(
		long employeeGradeId) {

		return _employeeGradeLocalService.fetchEmployeeGrade(employeeGradeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeGradeLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeGrade>
		getByEmployeeId(long employeeId) {

		return _employeeGradeLocalService.getByEmployeeId(employeeId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeGrade>
		getByPersonalNo(String personalNo) {

		return _employeeGradeLocalService.getByPersonalNo(personalNo);
	}

	/**
	 * Returns the employee grade with the primary key.
	 *
	 * @param employeeGradeId the primary key of the employee grade
	 * @return the employee grade
	 * @throws PortalException if a employee grade with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeGrade getEmployeeGrade(
			long employeeGradeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeGradeLocalService.getEmployeeGrade(employeeGradeId);
	}

	/**
	 * Returns a range of all the employee grades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeGradeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee grades
	 * @param end the upper bound of the range of employee grades (not inclusive)
	 * @return the range of employee grades
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeGrade>
		getEmployeeGrades(int start, int end) {

		return _employeeGradeLocalService.getEmployeeGrades(start, end);
	}

	/**
	 * Returns the number of employee grades.
	 *
	 * @return the number of employee grades
	 */
	@Override
	public int getEmployeeGradesCount() {
		return _employeeGradeLocalService.getEmployeeGradesCount();
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeGrade>
		getGradeModeByGradeModeId(long gradeModeId) {

		return _employeeGradeLocalService.getGradeModeByGradeModeId(
			gradeModeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeGradeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeGradeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeGradeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the employee grade in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeGradeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeGrade the employee grade
	 * @return the employee grade that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeGrade updateEmployeeGrade(
		com.adjecti.pis.liferay.model.EmployeeGrade employeeGrade) {

		return _employeeGradeLocalService.updateEmployeeGrade(employeeGrade);
	}

	@Override
	public EmployeeGradeLocalService getWrappedService() {
		return _employeeGradeLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeGradeLocalService employeeGradeLocalService) {

		_employeeGradeLocalService = employeeGradeLocalService;
	}

	private EmployeeGradeLocalService _employeeGradeLocalService;

}