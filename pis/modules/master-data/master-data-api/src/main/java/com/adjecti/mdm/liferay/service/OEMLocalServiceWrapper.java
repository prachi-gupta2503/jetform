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
 * Provides a wrapper for {@link OEMLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see OEMLocalService
 * @generated
 */
public class OEMLocalServiceWrapper
	implements OEMLocalService, ServiceWrapper<OEMLocalService> {

	public OEMLocalServiceWrapper(OEMLocalService oemLocalService) {
		_oemLocalService = oemLocalService;
	}

	/**
	 * Adds the oem to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OEMLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param oem the oem
	 * @return the oem that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.OEM addOEM(
		com.adjecti.mdm.liferay.model.OEM oem) {

		return _oemLocalService.addOEM(oem);
	}

	/**
	 * Creates a new oem with the primary key. Does not add the oem to the database.
	 *
	 * @param oemId the primary key for the new oem
	 * @return the new oem
	 */
	@Override
	public com.adjecti.mdm.liferay.model.OEM createOEM(long oemId) {
		return _oemLocalService.createOEM(oemId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _oemLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the oem with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OEMLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param oemId the primary key of the oem
	 * @return the oem that was removed
	 * @throws PortalException if a oem with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.OEM deleteOEM(long oemId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _oemLocalService.deleteOEM(oemId);
	}

	/**
	 * Deletes the oem from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OEMLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param oem the oem
	 * @return the oem that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.OEM deleteOEM(
		com.adjecti.mdm.liferay.model.OEM oem) {

		return _oemLocalService.deleteOEM(oem);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _oemLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _oemLocalService.dynamicQuery();
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

		return _oemLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.OEMModelImpl</code>.
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

		return _oemLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.OEMModelImpl</code>.
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

		return _oemLocalService.dynamicQuery(
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

		return _oemLocalService.dynamicQueryCount(dynamicQuery);
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

		return _oemLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.OEM fetchOEM(long oemId) {
		return _oemLocalService.fetchOEM(oemId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _oemLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _oemLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the oem with the primary key.
	 *
	 * @param oemId the primary key of the oem
	 * @return the oem
	 * @throws PortalException if a oem with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.OEM getOEM(long oemId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _oemLocalService.getOEM(oemId);
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.OEM> getOEMByName(
		String name) {

		return _oemLocalService.getOEMByName(name);
	}

	/**
	 * Returns a range of all the oems.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.OEMModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of oems
	 * @param end the upper bound of the range of oems (not inclusive)
	 * @return the range of oems
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.OEM> getOEMs(
		int start, int end) {

		return _oemLocalService.getOEMs(start, end);
	}

	/**
	 * Returns the number of oems.
	 *
	 * @return the number of oems
	 */
	@Override
	public int getOEMsCount() {
		return _oemLocalService.getOEMsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _oemLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _oemLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the oem in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OEMLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param oem the oem
	 * @return the oem that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.OEM updateOEM(
		com.adjecti.mdm.liferay.model.OEM oem) {

		return _oemLocalService.updateOEM(oem);
	}

	@Override
	public OEMLocalService getWrappedService() {
		return _oemLocalService;
	}

	@Override
	public void setWrappedService(OEMLocalService oemLocalService) {
		_oemLocalService = oemLocalService;
	}

	private OEMLocalService _oemLocalService;

}