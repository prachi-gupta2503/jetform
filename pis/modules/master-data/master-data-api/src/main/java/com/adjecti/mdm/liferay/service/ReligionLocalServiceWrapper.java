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
 * Provides a wrapper for {@link ReligionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ReligionLocalService
 * @generated
 */
public class ReligionLocalServiceWrapper
	implements ReligionLocalService, ServiceWrapper<ReligionLocalService> {

	public ReligionLocalServiceWrapper(
		ReligionLocalService religionLocalService) {

		_religionLocalService = religionLocalService;
	}

	/**
	 * Adds the religion to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ReligionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param religion the religion
	 * @return the religion that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Religion addReligion(
		com.adjecti.mdm.liferay.model.Religion religion) {

		return _religionLocalService.addReligion(religion);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _religionLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new religion with the primary key. Does not add the religion to the database.
	 *
	 * @param religionId the primary key for the new religion
	 * @return the new religion
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Religion createReligion(
		long religionId) {

		return _religionLocalService.createReligion(religionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _religionLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the religion with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ReligionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param religionId the primary key of the religion
	 * @return the religion that was removed
	 * @throws PortalException if a religion with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Religion deleteReligion(
			long religionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _religionLocalService.deleteReligion(religionId);
	}

	/**
	 * Deletes the religion from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ReligionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param religion the religion
	 * @return the religion that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Religion deleteReligion(
		com.adjecti.mdm.liferay.model.Religion religion) {

		return _religionLocalService.deleteReligion(religion);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _religionLocalService.dynamicQuery();
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

		return _religionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.ReligionModelImpl</code>.
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

		return _religionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.ReligionModelImpl</code>.
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

		return _religionLocalService.dynamicQuery(
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

		return _religionLocalService.dynamicQueryCount(dynamicQuery);
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

		return _religionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.Religion fetchReligion(
		long religionId) {

		return _religionLocalService.fetchReligion(religionId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _religionLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _religionLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _religionLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _religionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the religion with the primary key.
	 *
	 * @param religionId the primary key of the religion
	 * @return the religion
	 * @throws PortalException if a religion with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Religion getReligion(long religionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _religionLocalService.getReligion(religionId);
	}

	/**
	 * Returns a range of all the religions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.ReligionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of religions
	 * @param end the upper bound of the range of religions (not inclusive)
	 * @return the range of religions
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.Religion> getReligions(
		int start, int end) {

		return _religionLocalService.getReligions(start, end);
	}

	/**
	 * Returns the number of religions.
	 *
	 * @return the number of religions
	 */
	@Override
	public int getReligionsCount() {
		return _religionLocalService.getReligionsCount();
	}

	/**
	 * Updates the religion in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ReligionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param religion the religion
	 * @return the religion that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.Religion updateReligion(
		com.adjecti.mdm.liferay.model.Religion religion) {

		return _religionLocalService.updateReligion(religion);
	}

	@Override
	public ReligionLocalService getWrappedService() {
		return _religionLocalService;
	}

	@Override
	public void setWrappedService(ReligionLocalService religionLocalService) {
		_religionLocalService = religionLocalService;
	}

	private ReligionLocalService _religionLocalService;

}