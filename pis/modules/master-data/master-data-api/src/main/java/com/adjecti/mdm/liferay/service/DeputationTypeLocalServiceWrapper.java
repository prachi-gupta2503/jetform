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
 * Provides a wrapper for {@link DeputationTypeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DeputationTypeLocalService
 * @generated
 */
public class DeputationTypeLocalServiceWrapper
	implements DeputationTypeLocalService,
			   ServiceWrapper<DeputationTypeLocalService> {

	public DeputationTypeLocalServiceWrapper(
		DeputationTypeLocalService deputationTypeLocalService) {

		_deputationTypeLocalService = deputationTypeLocalService;
	}

	/**
	 * Adds the deputation type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DeputationTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param deputationType the deputation type
	 * @return the deputation type that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DeputationType addDeputationType(
		com.adjecti.mdm.liferay.model.DeputationType deputationType) {

		return _deputationTypeLocalService.addDeputationType(deputationType);
	}

	/**
	 * Creates a new deputation type with the primary key. Does not add the deputation type to the database.
	 *
	 * @param deputationTypeId the primary key for the new deputation type
	 * @return the new deputation type
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DeputationType createDeputationType(
		long deputationTypeId) {

		return _deputationTypeLocalService.createDeputationType(
			deputationTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deputationTypeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the deputation type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DeputationTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param deputationType the deputation type
	 * @return the deputation type that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DeputationType deleteDeputationType(
		com.adjecti.mdm.liferay.model.DeputationType deputationType) {

		return _deputationTypeLocalService.deleteDeputationType(deputationType);
	}

	/**
	 * Deletes the deputation type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DeputationTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param deputationTypeId the primary key of the deputation type
	 * @return the deputation type that was removed
	 * @throws PortalException if a deputation type with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DeputationType deleteDeputationType(
			long deputationTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deputationTypeLocalService.deleteDeputationType(
			deputationTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deputationTypeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _deputationTypeLocalService.dynamicQuery();
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

		return _deputationTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.DeputationTypeModelImpl</code>.
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

		return _deputationTypeLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.DeputationTypeModelImpl</code>.
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

		return _deputationTypeLocalService.dynamicQuery(
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

		return _deputationTypeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _deputationTypeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.DeputationType fetchDeputationType(
		long deputationTypeId) {

		return _deputationTypeLocalService.fetchDeputationType(
			deputationTypeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _deputationTypeLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the deputation type with the primary key.
	 *
	 * @param deputationTypeId the primary key of the deputation type
	 * @return the deputation type
	 * @throws PortalException if a deputation type with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DeputationType getDeputationType(
			long deputationTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deputationTypeLocalService.getDeputationType(deputationTypeId);
	}

	/**
	 * Returns a range of all the deputation types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.DeputationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of deputation types
	 * @param end the upper bound of the range of deputation types (not inclusive)
	 * @return the range of deputation types
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.DeputationType>
		getDeputationTypes(int start, int end) {

		return _deputationTypeLocalService.getDeputationTypes(start, end);
	}

	/**
	 * Returns the number of deputation types.
	 *
	 * @return the number of deputation types
	 */
	@Override
	public int getDeputationTypesCount() {
		return _deputationTypeLocalService.getDeputationTypesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _deputationTypeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _deputationTypeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deputationTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the deputation type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DeputationTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param deputationType the deputation type
	 * @return the deputation type that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DeputationType updateDeputationType(
		com.adjecti.mdm.liferay.model.DeputationType deputationType) {

		return _deputationTypeLocalService.updateDeputationType(deputationType);
	}

	@Override
	public DeputationTypeLocalService getWrappedService() {
		return _deputationTypeLocalService;
	}

	@Override
	public void setWrappedService(
		DeputationTypeLocalService deputationTypeLocalService) {

		_deputationTypeLocalService = deputationTypeLocalService;
	}

	private DeputationTypeLocalService _deputationTypeLocalService;

}