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
 * Provides a wrapper for {@link JoiningModeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see JoiningModeLocalService
 * @generated
 */
public class JoiningModeLocalServiceWrapper
	implements JoiningModeLocalService,
			   ServiceWrapper<JoiningModeLocalService> {

	public JoiningModeLocalServiceWrapper(
		JoiningModeLocalService joiningModeLocalService) {

		_joiningModeLocalService = joiningModeLocalService;
	}

	/**
	 * Adds the joining mode to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect JoiningModeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param joiningMode the joining mode
	 * @return the joining mode that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.JoiningMode addJoiningMode(
		com.adjecti.mdm.liferay.model.JoiningMode joiningMode) {

		return _joiningModeLocalService.addJoiningMode(joiningMode);
	}

	/**
	 * Creates a new joining mode with the primary key. Does not add the joining mode to the database.
	 *
	 * @param joiningModeId the primary key for the new joining mode
	 * @return the new joining mode
	 */
	@Override
	public com.adjecti.mdm.liferay.model.JoiningMode createJoiningMode(
		long joiningModeId) {

		return _joiningModeLocalService.createJoiningMode(joiningModeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _joiningModeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the joining mode from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect JoiningModeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param joiningMode the joining mode
	 * @return the joining mode that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.JoiningMode deleteJoiningMode(
		com.adjecti.mdm.liferay.model.JoiningMode joiningMode) {

		return _joiningModeLocalService.deleteJoiningMode(joiningMode);
	}

	/**
	 * Deletes the joining mode with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect JoiningModeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param joiningModeId the primary key of the joining mode
	 * @return the joining mode that was removed
	 * @throws PortalException if a joining mode with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.JoiningMode deleteJoiningMode(
			long joiningModeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _joiningModeLocalService.deleteJoiningMode(joiningModeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _joiningModeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _joiningModeLocalService.dynamicQuery();
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

		return _joiningModeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.JoiningModeModelImpl</code>.
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

		return _joiningModeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.JoiningModeModelImpl</code>.
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

		return _joiningModeLocalService.dynamicQuery(
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

		return _joiningModeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _joiningModeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.JoiningMode fetchJoiningMode(
		long joiningModeId) {

		return _joiningModeLocalService.fetchJoiningMode(joiningModeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _joiningModeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _joiningModeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the joining mode with the primary key.
	 *
	 * @param joiningModeId the primary key of the joining mode
	 * @return the joining mode
	 * @throws PortalException if a joining mode with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.JoiningMode getJoiningMode(
			long joiningModeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _joiningModeLocalService.getJoiningMode(joiningModeId);
	}

	/**
	 * Returns a range of all the joining modes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.JoiningModeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of joining modes
	 * @param end the upper bound of the range of joining modes (not inclusive)
	 * @return the range of joining modes
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.JoiningMode>
		getJoiningModes(int start, int end) {

		return _joiningModeLocalService.getJoiningModes(start, end);
	}

	/**
	 * Returns the number of joining modes.
	 *
	 * @return the number of joining modes
	 */
	@Override
	public int getJoiningModesCount() {
		return _joiningModeLocalService.getJoiningModesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _joiningModeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _joiningModeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the joining mode in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect JoiningModeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param joiningMode the joining mode
	 * @return the joining mode that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.JoiningMode updateJoiningMode(
		com.adjecti.mdm.liferay.model.JoiningMode joiningMode) {

		return _joiningModeLocalService.updateJoiningMode(joiningMode);
	}

	@Override
	public JoiningModeLocalService getWrappedService() {
		return _joiningModeLocalService;
	}

	@Override
	public void setWrappedService(
		JoiningModeLocalService joiningModeLocalService) {

		_joiningModeLocalService = joiningModeLocalService;
	}

	private JoiningModeLocalService _joiningModeLocalService;

}