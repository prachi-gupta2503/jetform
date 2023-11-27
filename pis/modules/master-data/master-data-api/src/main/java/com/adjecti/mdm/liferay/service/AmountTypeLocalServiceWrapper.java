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
 * Provides a wrapper for {@link AmountTypeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AmountTypeLocalService
 * @generated
 */
public class AmountTypeLocalServiceWrapper
	implements AmountTypeLocalService, ServiceWrapper<AmountTypeLocalService> {

	public AmountTypeLocalServiceWrapper(
		AmountTypeLocalService amountTypeLocalService) {

		_amountTypeLocalService = amountTypeLocalService;
	}

	/**
	 * Adds the amount type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AmountTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amountType the amount type
	 * @return the amount type that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.AmountType addAmountType(
		com.adjecti.mdm.liferay.model.AmountType amountType) {

		return _amountTypeLocalService.addAmountType(amountType);
	}

	/**
	 * Creates a new amount type with the primary key. Does not add the amount type to the database.
	 *
	 * @param amountTypeId the primary key for the new amount type
	 * @return the new amount type
	 */
	@Override
	public com.adjecti.mdm.liferay.model.AmountType createAmountType(
		long amountTypeId) {

		return _amountTypeLocalService.createAmountType(amountTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amountTypeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the amount type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AmountTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amountType the amount type
	 * @return the amount type that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.AmountType deleteAmountType(
		com.adjecti.mdm.liferay.model.AmountType amountType) {

		return _amountTypeLocalService.deleteAmountType(amountType);
	}

	/**
	 * Deletes the amount type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AmountTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amountTypeId the primary key of the amount type
	 * @return the amount type that was removed
	 * @throws PortalException if a amount type with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.AmountType deleteAmountType(
			long amountTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amountTypeLocalService.deleteAmountType(amountTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amountTypeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _amountTypeLocalService.dynamicQuery();
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

		return _amountTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.AmountTypeModelImpl</code>.
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

		return _amountTypeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.AmountTypeModelImpl</code>.
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

		return _amountTypeLocalService.dynamicQuery(
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

		return _amountTypeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _amountTypeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.AmountType fetchAmountType(
		long amountTypeId) {

		return _amountTypeLocalService.fetchAmountType(amountTypeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _amountTypeLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the amount type with the primary key.
	 *
	 * @param amountTypeId the primary key of the amount type
	 * @return the amount type
	 * @throws PortalException if a amount type with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.AmountType getAmountType(
			long amountTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amountTypeLocalService.getAmountType(amountTypeId);
	}

	/**
	 * Returns a range of all the amount types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.AmountTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amount types
	 * @param end the upper bound of the range of amount types (not inclusive)
	 * @return the range of amount types
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.AmountType>
		getAmountTypes(int start, int end) {

		return _amountTypeLocalService.getAmountTypes(start, end);
	}

	/**
	 * Returns the number of amount types.
	 *
	 * @return the number of amount types
	 */
	@Override
	public int getAmountTypesCount() {
		return _amountTypeLocalService.getAmountTypesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _amountTypeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _amountTypeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amountTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the amount type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AmountTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amountType the amount type
	 * @return the amount type that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.AmountType updateAmountType(
		com.adjecti.mdm.liferay.model.AmountType amountType) {

		return _amountTypeLocalService.updateAmountType(amountType);
	}

	@Override
	public AmountTypeLocalService getWrappedService() {
		return _amountTypeLocalService;
	}

	@Override
	public void setWrappedService(
		AmountTypeLocalService amountTypeLocalService) {

		_amountTypeLocalService = amountTypeLocalService;
	}

	private AmountTypeLocalService _amountTypeLocalService;

}