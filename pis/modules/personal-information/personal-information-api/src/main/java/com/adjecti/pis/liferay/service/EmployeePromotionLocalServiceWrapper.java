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
 * Provides a wrapper for {@link EmployeePromotionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeePromotionLocalService
 * @generated
 */
public class EmployeePromotionLocalServiceWrapper
	implements EmployeePromotionLocalService,
			   ServiceWrapper<EmployeePromotionLocalService> {

	public EmployeePromotionLocalServiceWrapper(
		EmployeePromotionLocalService employeePromotionLocalService) {

		_employeePromotionLocalService = employeePromotionLocalService;
	}

	/**
	 * Adds the employee promotion to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeePromotionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeePromotion the employee promotion
	 * @return the employee promotion that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeePromotion addEmployeePromotion(
		com.adjecti.pis.liferay.model.EmployeePromotion employeePromotion) {

		return _employeePromotionLocalService.addEmployeePromotion(
			employeePromotion);
	}

	/**
	 * Creates a new employee promotion with the primary key. Does not add the employee promotion to the database.
	 *
	 * @param employeePromotionId the primary key for the new employee promotion
	 * @return the new employee promotion
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeePromotion
		createEmployeePromotion(long employeePromotionId) {

		return _employeePromotionLocalService.createEmployeePromotion(
			employeePromotionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeePromotionLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the employee promotion from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeePromotionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeePromotion the employee promotion
	 * @return the employee promotion that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeePromotion
		deleteEmployeePromotion(
			com.adjecti.pis.liferay.model.EmployeePromotion employeePromotion) {

		return _employeePromotionLocalService.deleteEmployeePromotion(
			employeePromotion);
	}

	/**
	 * Deletes the employee promotion with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeePromotionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeePromotionId the primary key of the employee promotion
	 * @return the employee promotion that was removed
	 * @throws PortalException if a employee promotion with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeePromotion
			deleteEmployeePromotion(long employeePromotionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeePromotionLocalService.deleteEmployeePromotion(
			employeePromotionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeePromotionLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeePromotionLocalService.dynamicQuery();
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

		return _employeePromotionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeePromotionModelImpl</code>.
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

		return _employeePromotionLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeePromotionModelImpl</code>.
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

		return _employeePromotionLocalService.dynamicQuery(
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

		return _employeePromotionLocalService.dynamicQueryCount(dynamicQuery);
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

		return _employeePromotionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.EmployeePromotion
		fetchEmployeePromotion(long employeePromotionId) {

		return _employeePromotionLocalService.fetchEmployeePromotion(
			employeePromotionId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeePromotionLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeePromotion>
		getByEmployeeId(long employeeId) {

		return _employeePromotionLocalService.getByEmployeeId(employeeId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeePromotion>
		getByOrganizationId(long organizationId) {

		return _employeePromotionLocalService.getByOrganizationId(
			organizationId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeePromotion>
		getByPersonalNo(String personalNo) {

		return _employeePromotionLocalService.getByPersonalNo(personalNo);
	}

	/**
	 * Returns the employee promotion with the primary key.
	 *
	 * @param employeePromotionId the primary key of the employee promotion
	 * @return the employee promotion
	 * @throws PortalException if a employee promotion with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeePromotion getEmployeePromotion(
			long employeePromotionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeePromotionLocalService.getEmployeePromotion(
			employeePromotionId);
	}

	/**
	 * Returns a range of all the employee promotions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.EmployeePromotionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee promotions
	 * @param end the upper bound of the range of employee promotions (not inclusive)
	 * @return the range of employee promotions
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeePromotion>
		getEmployeePromotions(int start, int end) {

		return _employeePromotionLocalService.getEmployeePromotions(start, end);
	}

	/**
	 * Returns the number of employee promotions.
	 *
	 * @return the number of employee promotions
	 */
	@Override
	public int getEmployeePromotionsCount() {
		return _employeePromotionLocalService.getEmployeePromotionsCount();
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.EmployeePromotion>
		getGradeModeByGradeModeId(long gradeModeId) {

		return _employeePromotionLocalService.getGradeModeByGradeModeId(
			gradeModeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeePromotionLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeePromotionLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeePromotionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the employee promotion in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeePromotionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeePromotion the employee promotion
	 * @return the employee promotion that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.EmployeePromotion
		updateEmployeePromotion(
			com.adjecti.pis.liferay.model.EmployeePromotion employeePromotion) {

		return _employeePromotionLocalService.updateEmployeePromotion(
			employeePromotion);
	}

	@Override
	public EmployeePromotionLocalService getWrappedService() {
		return _employeePromotionLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeePromotionLocalService employeePromotionLocalService) {

		_employeePromotionLocalService = employeePromotionLocalService;
	}

	private EmployeePromotionLocalService _employeePromotionLocalService;

}