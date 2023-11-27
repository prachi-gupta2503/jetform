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
 * Provides a wrapper for {@link MonthlySalaryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MonthlySalaryLocalService
 * @generated
 */
public class MonthlySalaryLocalServiceWrapper
	implements MonthlySalaryLocalService,
			   ServiceWrapper<MonthlySalaryLocalService> {

	public MonthlySalaryLocalServiceWrapper(
		MonthlySalaryLocalService monthlySalaryLocalService) {

		_monthlySalaryLocalService = monthlySalaryLocalService;
	}

	/**
	 * Adds the monthly salary to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MonthlySalaryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param monthlySalary the monthly salary
	 * @return the monthly salary that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.MonthlySalary addMonthlySalary(
		com.adjecti.pis.liferay.model.MonthlySalary monthlySalary) {

		return _monthlySalaryLocalService.addMonthlySalary(monthlySalary);
	}

	/**
	 * Creates a new monthly salary with the primary key. Does not add the monthly salary to the database.
	 *
	 * @param monthlySalaryId the primary key for the new monthly salary
	 * @return the new monthly salary
	 */
	@Override
	public com.adjecti.pis.liferay.model.MonthlySalary createMonthlySalary(
		long monthlySalaryId) {

		return _monthlySalaryLocalService.createMonthlySalary(monthlySalaryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _monthlySalaryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the monthly salary with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MonthlySalaryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param monthlySalaryId the primary key of the monthly salary
	 * @return the monthly salary that was removed
	 * @throws PortalException if a monthly salary with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.MonthlySalary deleteMonthlySalary(
			long monthlySalaryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _monthlySalaryLocalService.deleteMonthlySalary(monthlySalaryId);
	}

	/**
	 * Deletes the monthly salary from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MonthlySalaryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param monthlySalary the monthly salary
	 * @return the monthly salary that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.MonthlySalary deleteMonthlySalary(
		com.adjecti.pis.liferay.model.MonthlySalary monthlySalary) {

		return _monthlySalaryLocalService.deleteMonthlySalary(monthlySalary);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _monthlySalaryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _monthlySalaryLocalService.dynamicQuery();
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

		return _monthlySalaryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.MonthlySalaryModelImpl</code>.
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

		return _monthlySalaryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.MonthlySalaryModelImpl</code>.
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

		return _monthlySalaryLocalService.dynamicQuery(
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

		return _monthlySalaryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _monthlySalaryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.MonthlySalary fetchMonthlySalary(
		long monthlySalaryId) {

		return _monthlySalaryLocalService.fetchMonthlySalary(monthlySalaryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _monthlySalaryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _monthlySalaryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the monthly salaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.MonthlySalaryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of monthly salaries
	 * @param end the upper bound of the range of monthly salaries (not inclusive)
	 * @return the range of monthly salaries
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.MonthlySalary>
		getMonthlySalaries(int start, int end) {

		return _monthlySalaryLocalService.getMonthlySalaries(start, end);
	}

	/**
	 * Returns the number of monthly salaries.
	 *
	 * @return the number of monthly salaries
	 */
	@Override
	public int getMonthlySalariesCount() {
		return _monthlySalaryLocalService.getMonthlySalariesCount();
	}

	/**
	 * Returns the monthly salary with the primary key.
	 *
	 * @param monthlySalaryId the primary key of the monthly salary
	 * @return the monthly salary
	 * @throws PortalException if a monthly salary with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.MonthlySalary getMonthlySalary(
			long monthlySalaryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _monthlySalaryLocalService.getMonthlySalary(monthlySalaryId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _monthlySalaryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _monthlySalaryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the monthly salary in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MonthlySalaryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param monthlySalary the monthly salary
	 * @return the monthly salary that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.MonthlySalary updateMonthlySalary(
		com.adjecti.pis.liferay.model.MonthlySalary monthlySalary) {

		return _monthlySalaryLocalService.updateMonthlySalary(monthlySalary);
	}

	@Override
	public MonthlySalaryLocalService getWrappedService() {
		return _monthlySalaryLocalService;
	}

	@Override
	public void setWrappedService(
		MonthlySalaryLocalService monthlySalaryLocalService) {

		_monthlySalaryLocalService = monthlySalaryLocalService;
	}

	private MonthlySalaryLocalService _monthlySalaryLocalService;

}