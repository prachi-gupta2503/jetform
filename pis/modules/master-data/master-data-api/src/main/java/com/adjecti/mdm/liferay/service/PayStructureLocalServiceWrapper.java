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
 * Provides a wrapper for {@link PayStructureLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PayStructureLocalService
 * @generated
 */
public class PayStructureLocalServiceWrapper
	implements PayStructureLocalService,
			   ServiceWrapper<PayStructureLocalService> {

	public PayStructureLocalServiceWrapper(
		PayStructureLocalService payStructureLocalService) {

		_payStructureLocalService = payStructureLocalService;
	}

	/**
	 * Adds the pay structure to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PayStructureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param payStructure the pay structure
	 * @return the pay structure that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PayStructure addPayStructure(
		com.adjecti.mdm.liferay.model.PayStructure payStructure) {

		return _payStructureLocalService.addPayStructure(payStructure);
	}

	/**
	 * Creates a new pay structure with the primary key. Does not add the pay structure to the database.
	 *
	 * @param payStructureId the primary key for the new pay structure
	 * @return the new pay structure
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PayStructure createPayStructure(
		long payStructureId) {

		return _payStructureLocalService.createPayStructure(payStructureId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _payStructureLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the pay structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PayStructureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param payStructureId the primary key of the pay structure
	 * @return the pay structure that was removed
	 * @throws PortalException if a pay structure with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PayStructure deletePayStructure(
			long payStructureId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _payStructureLocalService.deletePayStructure(payStructureId);
	}

	/**
	 * Deletes the pay structure from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PayStructureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param payStructure the pay structure
	 * @return the pay structure that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PayStructure deletePayStructure(
		com.adjecti.mdm.liferay.model.PayStructure payStructure) {

		return _payStructureLocalService.deletePayStructure(payStructure);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _payStructureLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _payStructureLocalService.dynamicQuery();
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

		return _payStructureLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.PayStructureModelImpl</code>.
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

		return _payStructureLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.PayStructureModelImpl</code>.
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

		return _payStructureLocalService.dynamicQuery(
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

		return _payStructureLocalService.dynamicQueryCount(dynamicQuery);
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

		return _payStructureLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.PayStructure fetchPayStructure(
		long payStructureId) {

		return _payStructureLocalService.fetchPayStructure(payStructureId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _payStructureLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _payStructureLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _payStructureLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * Returns the pay structure with the primary key.
	 *
	 * @param payStructureId the primary key of the pay structure
	 * @return the pay structure
	 * @throws PortalException if a pay structure with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PayStructure getPayStructure(
			long payStructureId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _payStructureLocalService.getPayStructure(payStructureId);
	}

	/**
	 * Returns a range of all the pay structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.PayStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay structures
	 * @param end the upper bound of the range of pay structures (not inclusive)
	 * @return the range of pay structures
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.PayStructure>
		getPayStructures(int start, int end) {

		return _payStructureLocalService.getPayStructures(start, end);
	}

	/**
	 * Returns the number of pay structures.
	 *
	 * @return the number of pay structures
	 */
	@Override
	public int getPayStructuresCount() {
		return _payStructureLocalService.getPayStructuresCount();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _payStructureLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the pay structure in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PayStructureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param payStructure the pay structure
	 * @return the pay structure that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PayStructure updatePayStructure(
		com.adjecti.mdm.liferay.model.PayStructure payStructure) {

		return _payStructureLocalService.updatePayStructure(payStructure);
	}

	@Override
	public PayStructureLocalService getWrappedService() {
		return _payStructureLocalService;
	}

	@Override
	public void setWrappedService(
		PayStructureLocalService payStructureLocalService) {

		_payStructureLocalService = payStructureLocalService;
	}

	private PayStructureLocalService _payStructureLocalService;

}