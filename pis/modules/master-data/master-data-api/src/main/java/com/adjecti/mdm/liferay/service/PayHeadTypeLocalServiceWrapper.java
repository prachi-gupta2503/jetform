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
 * Provides a wrapper for {@link PayHeadTypeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PayHeadTypeLocalService
 * @generated
 */
public class PayHeadTypeLocalServiceWrapper
	implements PayHeadTypeLocalService,
			   ServiceWrapper<PayHeadTypeLocalService> {

	public PayHeadTypeLocalServiceWrapper(
		PayHeadTypeLocalService payHeadTypeLocalService) {

		_payHeadTypeLocalService = payHeadTypeLocalService;
	}

	/**
	 * Adds the pay head type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PayHeadTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param payHeadType the pay head type
	 * @return the pay head type that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PayHeadType addPayHeadType(
		com.adjecti.mdm.liferay.model.PayHeadType payHeadType) {

		return _payHeadTypeLocalService.addPayHeadType(payHeadType);
	}

	/**
	 * Creates a new pay head type with the primary key. Does not add the pay head type to the database.
	 *
	 * @param payHeadTypeId the primary key for the new pay head type
	 * @return the new pay head type
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PayHeadType createPayHeadType(
		long payHeadTypeId) {

		return _payHeadTypeLocalService.createPayHeadType(payHeadTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _payHeadTypeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the pay head type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PayHeadTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param payHeadTypeId the primary key of the pay head type
	 * @return the pay head type that was removed
	 * @throws PortalException if a pay head type with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PayHeadType deletePayHeadType(
			long payHeadTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _payHeadTypeLocalService.deletePayHeadType(payHeadTypeId);
	}

	/**
	 * Deletes the pay head type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PayHeadTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param payHeadType the pay head type
	 * @return the pay head type that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PayHeadType deletePayHeadType(
		com.adjecti.mdm.liferay.model.PayHeadType payHeadType) {

		return _payHeadTypeLocalService.deletePayHeadType(payHeadType);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _payHeadTypeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _payHeadTypeLocalService.dynamicQuery();
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

		return _payHeadTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.PayHeadTypeModelImpl</code>.
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

		return _payHeadTypeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.PayHeadTypeModelImpl</code>.
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

		return _payHeadTypeLocalService.dynamicQuery(
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

		return _payHeadTypeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _payHeadTypeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.PayHeadType fetchPayHeadType(
		long payHeadTypeId) {

		return _payHeadTypeLocalService.fetchPayHeadType(payHeadTypeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _payHeadTypeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _payHeadTypeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _payHeadTypeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * Returns the pay head type with the primary key.
	 *
	 * @param payHeadTypeId the primary key of the pay head type
	 * @return the pay head type
	 * @throws PortalException if a pay head type with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PayHeadType getPayHeadType(
			long payHeadTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _payHeadTypeLocalService.getPayHeadType(payHeadTypeId);
	}

	/**
	 * Returns a range of all the pay head types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.PayHeadTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay head types
	 * @param end the upper bound of the range of pay head types (not inclusive)
	 * @return the range of pay head types
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.PayHeadType>
		getPayHeadTypes(int start, int end) {

		return _payHeadTypeLocalService.getPayHeadTypes(start, end);
	}

	/**
	 * Returns the number of pay head types.
	 *
	 * @return the number of pay head types
	 */
	@Override
	public int getPayHeadTypesCount() {
		return _payHeadTypeLocalService.getPayHeadTypesCount();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _payHeadTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the pay head type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PayHeadTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param payHeadType the pay head type
	 * @return the pay head type that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PayHeadType updatePayHeadType(
		com.adjecti.mdm.liferay.model.PayHeadType payHeadType) {

		return _payHeadTypeLocalService.updatePayHeadType(payHeadType);
	}

	@Override
	public PayHeadTypeLocalService getWrappedService() {
		return _payHeadTypeLocalService;
	}

	@Override
	public void setWrappedService(
		PayHeadTypeLocalService payHeadTypeLocalService) {

		_payHeadTypeLocalService = payHeadTypeLocalService;
	}

	private PayHeadTypeLocalService _payHeadTypeLocalService;

}