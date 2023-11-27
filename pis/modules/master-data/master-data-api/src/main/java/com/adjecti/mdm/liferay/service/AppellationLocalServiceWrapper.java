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
 * Provides a wrapper for {@link AppellationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AppellationLocalService
 * @generated
 */
public class AppellationLocalServiceWrapper
	implements AppellationLocalService,
			   ServiceWrapper<AppellationLocalService> {

	public AppellationLocalServiceWrapper(
		AppellationLocalService appellationLocalService) {

		_appellationLocalService = appellationLocalService;
	}

	/**
	 * Adds the appellation to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppellationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appellation the appellation
	 * @return the appellation that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Appellation addAppellation(
		com.adjecti.mdm.liferay.model.Appellation appellation) {

		return _appellationLocalService.addAppellation(appellation);
	}

	/**
	 * Creates a new appellation with the primary key. Does not add the appellation to the database.
	 *
	 * @param appellationId the primary key for the new appellation
	 * @return the new appellation
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Appellation createAppellation(
		long appellationId) {

		return _appellationLocalService.createAppellation(appellationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appellationLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the appellation from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppellationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appellation the appellation
	 * @return the appellation that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Appellation deleteAppellation(
		com.adjecti.mdm.liferay.model.Appellation appellation) {

		return _appellationLocalService.deleteAppellation(appellation);
	}

	/**
	 * Deletes the appellation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppellationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appellationId the primary key of the appellation
	 * @return the appellation that was removed
	 * @throws PortalException if a appellation with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Appellation deleteAppellation(
			long appellationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appellationLocalService.deleteAppellation(appellationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appellationLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _appellationLocalService.dynamicQuery();
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

		return _appellationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.AppellationModelImpl</code>.
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

		return _appellationLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.AppellationModelImpl</code>.
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

		return _appellationLocalService.dynamicQuery(
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

		return _appellationLocalService.dynamicQueryCount(dynamicQuery);
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

		return _appellationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.Appellation fetchAppellation(
		long appellationId) {

		return _appellationLocalService.fetchAppellation(appellationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _appellationLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the appellation with the primary key.
	 *
	 * @param appellationId the primary key of the appellation
	 * @return the appellation
	 * @throws PortalException if a appellation with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Appellation getAppellation(
			long appellationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appellationLocalService.getAppellation(appellationId);
	}

	/**
	 * Returns a range of all the appellations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.AppellationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of appellations
	 * @param end the upper bound of the range of appellations (not inclusive)
	 * @return the range of appellations
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.Appellation>
		getAppellations(int start, int end) {

		return _appellationLocalService.getAppellations(start, end);
	}

	/**
	 * Returns the number of appellations.
	 *
	 * @return the number of appellations
	 */
	@Override
	public int getAppellationsCount() {
		return _appellationLocalService.getAppellationsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _appellationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _appellationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _appellationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the appellation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AppellationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appellation the appellation
	 * @return the appellation that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Appellation updateAppellation(
		com.adjecti.mdm.liferay.model.Appellation appellation) {

		return _appellationLocalService.updateAppellation(appellation);
	}

	@Override
	public AppellationLocalService getWrappedService() {
		return _appellationLocalService;
	}

	@Override
	public void setWrappedService(
		AppellationLocalService appellationLocalService) {

		_appellationLocalService = appellationLocalService;
	}

	private AppellationLocalService _appellationLocalService;

}