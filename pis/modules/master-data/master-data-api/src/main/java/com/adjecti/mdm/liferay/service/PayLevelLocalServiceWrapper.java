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

package com.adjecti.mdm.liferay.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PayLevelLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PayLevelLocalService
 * @generated
 */
public class PayLevelLocalServiceWrapper
	implements PayLevelLocalService, ServiceWrapper<PayLevelLocalService> {

	public PayLevelLocalServiceWrapper(
		PayLevelLocalService payLevelLocalService) {

		_payLevelLocalService = payLevelLocalService;
	}

	/**
	 * Adds the pay level to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PayLevelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param payLevel the pay level
	 * @return the pay level that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PayLevel addPayLevel(
		com.adjecti.mdm.liferay.model.PayLevel payLevel) {

		return _payLevelLocalService.addPayLevel(payLevel);
	}

	/**
	 * Creates a new pay level with the primary key. Does not add the pay level to the database.
	 *
	 * @param payLevelId the primary key for the new pay level
	 * @return the new pay level
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PayLevel createPayLevel(
		long payLevelId) {

		return _payLevelLocalService.createPayLevel(payLevelId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _payLevelLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the pay level with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PayLevelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param payLevelId the primary key of the pay level
	 * @return the pay level that was removed
	 * @throws PortalException if a pay level with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PayLevel deletePayLevel(
			long payLevelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _payLevelLocalService.deletePayLevel(payLevelId);
	}

	/**
	 * Deletes the pay level from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PayLevelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param payLevel the pay level
	 * @return the pay level that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PayLevel deletePayLevel(
		com.adjecti.mdm.liferay.model.PayLevel payLevel) {

		return _payLevelLocalService.deletePayLevel(payLevel);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _payLevelLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _payLevelLocalService.dynamicQuery();
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

		return _payLevelLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.PayLevelModelImpl</code>.
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

		return _payLevelLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.PayLevelModelImpl</code>.
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

		return _payLevelLocalService.dynamicQuery(
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

		return _payLevelLocalService.dynamicQueryCount(dynamicQuery);
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

		return _payLevelLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.PayLevel fetchPayLevel(
		long payLevelId) {

		return _payLevelLocalService.fetchPayLevel(payLevelId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _payLevelLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _payLevelLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _payLevelLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * Returns the pay level with the primary key.
	 *
	 * @param payLevelId the primary key of the pay level
	 * @return the pay level
	 * @throws PortalException if a pay level with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PayLevel getPayLevel(long payLevelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _payLevelLocalService.getPayLevel(payLevelId);
	}

	/**
	 * Returns a range of all the pay levels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.PayLevelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay levels
	 * @param end the upper bound of the range of pay levels (not inclusive)
	 * @return the range of pay levels
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.PayLevel> getPayLevels(
		int start, int end) {

		return _payLevelLocalService.getPayLevels(start, end);
	}

	/**
	 * Returns the number of pay levels.
	 *
	 * @return the number of pay levels
	 */
	@Override
	public int getPayLevelsCount() {
		return _payLevelLocalService.getPayLevelsCount();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _payLevelLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the pay level in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PayLevelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param payLevel the pay level
	 * @return the pay level that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PayLevel updatePayLevel(
		com.adjecti.mdm.liferay.model.PayLevel payLevel) {

		return _payLevelLocalService.updatePayLevel(payLevel);
	}

	@Override
	public PayLevelLocalService getWrappedService() {
		return _payLevelLocalService;
	}

	@Override
	public void setWrappedService(PayLevelLocalService payLevelLocalService) {
		_payLevelLocalService = payLevelLocalService;
	}

	private PayLevelLocalService _payLevelLocalService;

}