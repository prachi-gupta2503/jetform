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
 * Provides a wrapper for {@link PayHeadLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PayHeadLocalService
 * @generated
 */
public class PayHeadLocalServiceWrapper
	implements PayHeadLocalService, ServiceWrapper<PayHeadLocalService> {

	public PayHeadLocalServiceWrapper(PayHeadLocalService payHeadLocalService) {
		_payHeadLocalService = payHeadLocalService;
	}

	/**
	 * Adds the pay head to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PayHeadLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param payHead the pay head
	 * @return the pay head that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PayHead addPayHead(
		com.adjecti.mdm.liferay.model.PayHead payHead) {

		return _payHeadLocalService.addPayHead(payHead);
	}

	/**
	 * Creates a new pay head with the primary key. Does not add the pay head to the database.
	 *
	 * @param payHeadId the primary key for the new pay head
	 * @return the new pay head
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PayHead createPayHead(long payHeadId) {
		return _payHeadLocalService.createPayHead(payHeadId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _payHeadLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the pay head with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PayHeadLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param payHeadId the primary key of the pay head
	 * @return the pay head that was removed
	 * @throws PortalException if a pay head with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PayHead deletePayHead(long payHeadId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _payHeadLocalService.deletePayHead(payHeadId);
	}

	/**
	 * Deletes the pay head from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PayHeadLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param payHead the pay head
	 * @return the pay head that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PayHead deletePayHead(
		com.adjecti.mdm.liferay.model.PayHead payHead) {

		return _payHeadLocalService.deletePayHead(payHead);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _payHeadLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _payHeadLocalService.dynamicQuery();
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

		return _payHeadLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.PayHeadModelImpl</code>.
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

		return _payHeadLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.PayHeadModelImpl</code>.
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

		return _payHeadLocalService.dynamicQuery(
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

		return _payHeadLocalService.dynamicQueryCount(dynamicQuery);
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

		return _payHeadLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.PayHead fetchPayHead(long payHeadId) {
		return _payHeadLocalService.fetchPayHead(payHeadId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _payHeadLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _payHeadLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _payHeadLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * Returns the pay head with the primary key.
	 *
	 * @param payHeadId the primary key of the pay head
	 * @return the pay head
	 * @throws PortalException if a pay head with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PayHead getPayHead(long payHeadId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _payHeadLocalService.getPayHead(payHeadId);
	}

	/**
	 * Returns a range of all the pay heads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.PayHeadModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay heads
	 * @param end the upper bound of the range of pay heads (not inclusive)
	 * @return the range of pay heads
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.PayHead> getPayHeads(
		int start, int end) {

		return _payHeadLocalService.getPayHeads(start, end);
	}

	/**
	 * Returns the number of pay heads.
	 *
	 * @return the number of pay heads
	 */
	@Override
	public int getPayHeadsCount() {
		return _payHeadLocalService.getPayHeadsCount();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _payHeadLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the pay head in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PayHeadLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param payHead the pay head
	 * @return the pay head that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PayHead updatePayHead(
		com.adjecti.mdm.liferay.model.PayHead payHead) {

		return _payHeadLocalService.updatePayHead(payHead);
	}

	@Override
	public PayHeadLocalService getWrappedService() {
		return _payHeadLocalService;
	}

	@Override
	public void setWrappedService(PayHeadLocalService payHeadLocalService) {
		_payHeadLocalService = payHeadLocalService;
	}

	private PayHeadLocalService _payHeadLocalService;

}