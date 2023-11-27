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
 * Provides a wrapper for {@link MonthlySalaryComponentLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MonthlySalaryComponentLocalService
 * @generated
 */
public class MonthlySalaryComponentLocalServiceWrapper
	implements MonthlySalaryComponentLocalService,
			   ServiceWrapper<MonthlySalaryComponentLocalService> {

	public MonthlySalaryComponentLocalServiceWrapper(
		MonthlySalaryComponentLocalService monthlySalaryComponentLocalService) {

		_monthlySalaryComponentLocalService =
			monthlySalaryComponentLocalService;
	}

	/**
	 * Adds the monthly salary component to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MonthlySalaryComponentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param monthlySalaryComponent the monthly salary component
	 * @return the monthly salary component that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.MonthlySalaryComponent
		addMonthlySalaryComponent(
			com.adjecti.pis.liferay.model.MonthlySalaryComponent
				monthlySalaryComponent) {

		return _monthlySalaryComponentLocalService.addMonthlySalaryComponent(
			monthlySalaryComponent);
	}

	/**
	 * Creates a new monthly salary component with the primary key. Does not add the monthly salary component to the database.
	 *
	 * @param monthlySalaryComponentId the primary key for the new monthly salary component
	 * @return the new monthly salary component
	 */
	@Override
	public com.adjecti.pis.liferay.model.MonthlySalaryComponent
		createMonthlySalaryComponent(long monthlySalaryComponentId) {

		return _monthlySalaryComponentLocalService.createMonthlySalaryComponent(
			monthlySalaryComponentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _monthlySalaryComponentLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the monthly salary component with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MonthlySalaryComponentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param monthlySalaryComponentId the primary key of the monthly salary component
	 * @return the monthly salary component that was removed
	 * @throws PortalException if a monthly salary component with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.MonthlySalaryComponent
			deleteMonthlySalaryComponent(long monthlySalaryComponentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _monthlySalaryComponentLocalService.deleteMonthlySalaryComponent(
			monthlySalaryComponentId);
	}

	/**
	 * Deletes the monthly salary component from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MonthlySalaryComponentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param monthlySalaryComponent the monthly salary component
	 * @return the monthly salary component that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.MonthlySalaryComponent
		deleteMonthlySalaryComponent(
			com.adjecti.pis.liferay.model.MonthlySalaryComponent
				monthlySalaryComponent) {

		return _monthlySalaryComponentLocalService.deleteMonthlySalaryComponent(
			monthlySalaryComponent);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _monthlySalaryComponentLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _monthlySalaryComponentLocalService.dynamicQuery();
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

		return _monthlySalaryComponentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.MonthlySalaryComponentModelImpl</code>.
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

		return _monthlySalaryComponentLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.MonthlySalaryComponentModelImpl</code>.
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

		return _monthlySalaryComponentLocalService.dynamicQuery(
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

		return _monthlySalaryComponentLocalService.dynamicQueryCount(
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

		return _monthlySalaryComponentLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.MonthlySalaryComponent
		fetchMonthlySalaryComponent(long monthlySalaryComponentId) {

		return _monthlySalaryComponentLocalService.fetchMonthlySalaryComponent(
			monthlySalaryComponentId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _monthlySalaryComponentLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _monthlySalaryComponentLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the monthly salary component with the primary key.
	 *
	 * @param monthlySalaryComponentId the primary key of the monthly salary component
	 * @return the monthly salary component
	 * @throws PortalException if a monthly salary component with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.MonthlySalaryComponent
			getMonthlySalaryComponent(long monthlySalaryComponentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _monthlySalaryComponentLocalService.getMonthlySalaryComponent(
			monthlySalaryComponentId);
	}

	/**
	 * Returns a range of all the monthly salary components.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.MonthlySalaryComponentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of monthly salary components
	 * @param end the upper bound of the range of monthly salary components (not inclusive)
	 * @return the range of monthly salary components
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.MonthlySalaryComponent>
		getMonthlySalaryComponents(int start, int end) {

		return _monthlySalaryComponentLocalService.getMonthlySalaryComponents(
			start, end);
	}

	/**
	 * Returns the number of monthly salary components.
	 *
	 * @return the number of monthly salary components
	 */
	@Override
	public int getMonthlySalaryComponentsCount() {
		return _monthlySalaryComponentLocalService.
			getMonthlySalaryComponentsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _monthlySalaryComponentLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _monthlySalaryComponentLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the monthly salary component in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MonthlySalaryComponentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param monthlySalaryComponent the monthly salary component
	 * @return the monthly salary component that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.MonthlySalaryComponent
		updateMonthlySalaryComponent(
			com.adjecti.pis.liferay.model.MonthlySalaryComponent
				monthlySalaryComponent) {

		return _monthlySalaryComponentLocalService.updateMonthlySalaryComponent(
			monthlySalaryComponent);
	}

	@Override
	public MonthlySalaryComponentLocalService getWrappedService() {
		return _monthlySalaryComponentLocalService;
	}

	@Override
	public void setWrappedService(
		MonthlySalaryComponentLocalService monthlySalaryComponentLocalService) {

		_monthlySalaryComponentLocalService =
			monthlySalaryComponentLocalService;
	}

	private MonthlySalaryComponentLocalService
		_monthlySalaryComponentLocalService;

}