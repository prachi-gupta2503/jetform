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
 * Provides a wrapper for {@link DesignationModeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DesignationModeLocalService
 * @generated
 */
public class DesignationModeLocalServiceWrapper
	implements DesignationModeLocalService,
			   ServiceWrapper<DesignationModeLocalService> {

	public DesignationModeLocalServiceWrapper(
		DesignationModeLocalService designationModeLocalService) {

		_designationModeLocalService = designationModeLocalService;
	}

	/**
	 * Adds the designation mode to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DesignationModeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param designationMode the designation mode
	 * @return the designation mode that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DesignationMode addDesignationMode(
		com.adjecti.mdm.liferay.model.DesignationMode designationMode) {

		return _designationModeLocalService.addDesignationMode(designationMode);
	}

	/**
	 * Creates a new designation mode with the primary key. Does not add the designation mode to the database.
	 *
	 * @param designationModeId the primary key for the new designation mode
	 * @return the new designation mode
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DesignationMode createDesignationMode(
		long designationModeId) {

		return _designationModeLocalService.createDesignationMode(
			designationModeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _designationModeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the designation mode from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DesignationModeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param designationMode the designation mode
	 * @return the designation mode that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DesignationMode deleteDesignationMode(
		com.adjecti.mdm.liferay.model.DesignationMode designationMode) {

		return _designationModeLocalService.deleteDesignationMode(
			designationMode);
	}

	/**
	 * Deletes the designation mode with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DesignationModeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param designationModeId the primary key of the designation mode
	 * @return the designation mode that was removed
	 * @throws PortalException if a designation mode with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DesignationMode deleteDesignationMode(
			long designationModeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _designationModeLocalService.deleteDesignationMode(
			designationModeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _designationModeLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _designationModeLocalService.dynamicQuery();
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

		return _designationModeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.DesignationModeModelImpl</code>.
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

		return _designationModeLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.DesignationModeModelImpl</code>.
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

		return _designationModeLocalService.dynamicQuery(
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

		return _designationModeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _designationModeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.DesignationMode fetchDesignationMode(
		long designationModeId) {

		return _designationModeLocalService.fetchDesignationMode(
			designationModeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _designationModeLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the designation mode with the primary key.
	 *
	 * @param designationModeId the primary key of the designation mode
	 * @return the designation mode
	 * @throws PortalException if a designation mode with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DesignationMode getDesignationMode(
			long designationModeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _designationModeLocalService.getDesignationMode(
			designationModeId);
	}

	/**
	 * Returns a range of all the designation modes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.DesignationModeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation modes
	 * @param end the upper bound of the range of designation modes (not inclusive)
	 * @return the range of designation modes
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.DesignationMode>
		getDesignationModes(int start, int end) {

		return _designationModeLocalService.getDesignationModes(start, end);
	}

	/**
	 * Returns the number of designation modes.
	 *
	 * @return the number of designation modes
	 */
	@Override
	public int getDesignationModesCount() {
		return _designationModeLocalService.getDesignationModesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _designationModeLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _designationModeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _designationModeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the designation mode in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DesignationModeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param designationMode the designation mode
	 * @return the designation mode that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DesignationMode updateDesignationMode(
		com.adjecti.mdm.liferay.model.DesignationMode designationMode) {

		return _designationModeLocalService.updateDesignationMode(
			designationMode);
	}

	@Override
	public DesignationModeLocalService getWrappedService() {
		return _designationModeLocalService;
	}

	@Override
	public void setWrappedService(
		DesignationModeLocalService designationModeLocalService) {

		_designationModeLocalService = designationModeLocalService;
	}

	private DesignationModeLocalService _designationModeLocalService;

}