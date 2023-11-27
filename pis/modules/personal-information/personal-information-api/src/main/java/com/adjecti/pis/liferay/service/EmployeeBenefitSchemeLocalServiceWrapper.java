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
 * Provides a wrapper for {@link EmployeeBenefitSchemeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeBenefitSchemeLocalService
 * @generated
 */
public class EmployeeBenefitSchemeLocalServiceWrapper
	implements EmployeeBenefitSchemeLocalService,
			   ServiceWrapper<EmployeeBenefitSchemeLocalService> {

	public EmployeeBenefitSchemeLocalServiceWrapper(
		EmployeeBenefitSchemeLocalService employeeBenefitSchemeLocalService) {

		_employeeBenefitSchemeLocalService = employeeBenefitSchemeLocalService;
	}

	/**
	 * Adds the employee benefit scheme to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeBenefitSchemeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeBenefitScheme the employee benefit scheme
	 * @return the employee benefit scheme that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeBenefitScheme
		addEmployeeBenefitScheme(
			com.adjecti.pis.liferay.model.EmployeeBenefitScheme
				employeeBenefitScheme) {

		return _employeeBenefitSchemeLocalService.addEmployeeBenefitScheme(
			employeeBenefitScheme);
	}

	/**
	 * Creates a new employee benefit scheme with the primary key. Does not add the employee benefit scheme to the database.
	 *
	 * @param employeeBenefitSchemeId the primary key for the new employee benefit scheme
	 * @return the new employee benefit scheme
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeBenefitScheme
		createEmployeeBenefitScheme(long employeeBenefitSchemeId) {

		return _employeeBenefitSchemeLocalService.createEmployeeBenefitScheme(
			employeeBenefitSchemeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeBenefitSchemeLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the employee benefit scheme from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeBenefitSchemeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeBenefitScheme the employee benefit scheme
	 * @return the employee benefit scheme that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeBenefitScheme
		deleteEmployeeBenefitScheme(
			com.adjecti.pis.liferay.model.EmployeeBenefitScheme
				employeeBenefitScheme) {

		return _employeeBenefitSchemeLocalService.deleteEmployeeBenefitScheme(
			employeeBenefitScheme);
	}

	/**
	 * Deletes the employee benefit scheme with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeBenefitSchemeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeBenefitSchemeId the primary key of the employee benefit scheme
	 * @return the employee benefit scheme that was removed
	 * @throws PortalException if a employee benefit scheme with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeBenefitScheme
			deleteEmployeeBenefitScheme(long employeeBenefitSchemeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeBenefitSchemeLocalService.deleteEmployeeBenefitScheme(
			employeeBenefitSchemeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeBenefitSchemeLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeBenefitSchemeLocalService.dynamicQuery();
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

		return _employeeBenefitSchemeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeBenefitSchemeModelImpl</code>.
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

		return _employeeBenefitSchemeLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeBenefitSchemeModelImpl</code>.
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

		return _employeeBenefitSchemeLocalService.dynamicQuery(
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

		return _employeeBenefitSchemeLocalService.dynamicQueryCount(
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

		return _employeeBenefitSchemeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeeBenefitScheme
		fetchEmployeeBenefitScheme(long employeeBenefitSchemeId) {

		return _employeeBenefitSchemeLocalService.fetchEmployeeBenefitScheme(
			employeeBenefitSchemeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeBenefitSchemeLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeBenefitScheme>
		getByEmployeeId(long employeeId) {

		return _employeeBenefitSchemeLocalService.getByEmployeeId(employeeId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeBenefitScheme>
		getByPersonalNo(String personalNo) {

		return _employeeBenefitSchemeLocalService.getByPersonalNo(personalNo);
	}

	/**
	 * Returns the employee benefit scheme with the primary key.
	 *
	 * @param employeeBenefitSchemeId the primary key of the employee benefit scheme
	 * @return the employee benefit scheme
	 * @throws PortalException if a employee benefit scheme with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeBenefitScheme
			getEmployeeBenefitScheme(long employeeBenefitSchemeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeBenefitSchemeLocalService.getEmployeeBenefitScheme(
			employeeBenefitSchemeId);
	}

	/**
	 * Returns a range of all the employee benefit schemes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeeBenefitSchemeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee benefit schemes
	 * @param end the upper bound of the range of employee benefit schemes (not inclusive)
	 * @return the range of employee benefit schemes
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeeBenefitScheme>
		getEmployeeBenefitSchemes(int start, int end) {

		return _employeeBenefitSchemeLocalService.getEmployeeBenefitSchemes(
			start, end);
	}

	/**
	 * Returns the number of employee benefit schemes.
	 *
	 * @return the number of employee benefit schemes
	 */
	@Override
	public int getEmployeeBenefitSchemesCount() {
		return _employeeBenefitSchemeLocalService.
			getEmployeeBenefitSchemesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeBenefitSchemeLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeBenefitSchemeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeBenefitSchemeLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the employee benefit scheme in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeBenefitSchemeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeBenefitScheme the employee benefit scheme
	 * @return the employee benefit scheme that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeeBenefitScheme
		updateEmployeeBenefitScheme(
			com.adjecti.pis.liferay.model.EmployeeBenefitScheme
				employeeBenefitScheme) {

		return _employeeBenefitSchemeLocalService.updateEmployeeBenefitScheme(
			employeeBenefitScheme);
	}

	@Override
	public EmployeeBenefitSchemeLocalService getWrappedService() {
		return _employeeBenefitSchemeLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeBenefitSchemeLocalService employeeBenefitSchemeLocalService) {

		_employeeBenefitSchemeLocalService = employeeBenefitSchemeLocalService;
	}

	private EmployeeBenefitSchemeLocalService
		_employeeBenefitSchemeLocalService;

}