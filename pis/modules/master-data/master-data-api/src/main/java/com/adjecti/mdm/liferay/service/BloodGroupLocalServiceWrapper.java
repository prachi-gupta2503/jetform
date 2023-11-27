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
 * Provides a wrapper for {@link BloodGroupLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BloodGroupLocalService
 * @generated
 */
public class BloodGroupLocalServiceWrapper
	implements BloodGroupLocalService, ServiceWrapper<BloodGroupLocalService> {

	public BloodGroupLocalServiceWrapper(
		BloodGroupLocalService bloodGroupLocalService) {

		_bloodGroupLocalService = bloodGroupLocalService;
	}

	/**
	 * Adds the blood group to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BloodGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bloodGroup the blood group
	 * @return the blood group that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.BloodGroup addBloodGroup(
		com.adjecti.mdm.liferay.model.BloodGroup bloodGroup) {

		return _bloodGroupLocalService.addBloodGroup(bloodGroup);
	}

	/**
	 * Creates a new blood group with the primary key. Does not add the blood group to the database.
	 *
	 * @param bloodGroupId the primary key for the new blood group
	 * @return the new blood group
	 */
	@Override
	public com.adjecti.mdm.liferay.model.BloodGroup createBloodGroup(
		long bloodGroupId) {

		return _bloodGroupLocalService.createBloodGroup(bloodGroupId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bloodGroupLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the blood group from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BloodGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bloodGroup the blood group
	 * @return the blood group that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.BloodGroup deleteBloodGroup(
		com.adjecti.mdm.liferay.model.BloodGroup bloodGroup) {

		return _bloodGroupLocalService.deleteBloodGroup(bloodGroup);
	}

	/**
	 * Deletes the blood group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BloodGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bloodGroupId the primary key of the blood group
	 * @return the blood group that was removed
	 * @throws PortalException if a blood group with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.BloodGroup deleteBloodGroup(
			long bloodGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bloodGroupLocalService.deleteBloodGroup(bloodGroupId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bloodGroupLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _bloodGroupLocalService.dynamicQuery();
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

		return _bloodGroupLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.BloodGroupModelImpl</code>.
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

		return _bloodGroupLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.BloodGroupModelImpl</code>.
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

		return _bloodGroupLocalService.dynamicQuery(
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

		return _bloodGroupLocalService.dynamicQueryCount(dynamicQuery);
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

		return _bloodGroupLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.BloodGroup fetchBloodGroup(
		long bloodGroupId) {

		return _bloodGroupLocalService.fetchBloodGroup(bloodGroupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _bloodGroupLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the blood group with the primary key.
	 *
	 * @param bloodGroupId the primary key of the blood group
	 * @return the blood group
	 * @throws PortalException if a blood group with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.BloodGroup getBloodGroup(
			long bloodGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bloodGroupLocalService.getBloodGroup(bloodGroupId);
	}

	/**
	 * Returns a range of all the blood groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.BloodGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of blood groups
	 * @param end the upper bound of the range of blood groups (not inclusive)
	 * @return the range of blood groups
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.BloodGroup>
		getBloodGroups(int start, int end) {

		return _bloodGroupLocalService.getBloodGroups(start, end);
	}

	/**
	 * Returns the number of blood groups.
	 *
	 * @return the number of blood groups
	 */
	@Override
	public int getBloodGroupsCount() {
		return _bloodGroupLocalService.getBloodGroupsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _bloodGroupLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _bloodGroupLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bloodGroupLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the blood group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BloodGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bloodGroup the blood group
	 * @return the blood group that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.BloodGroup updateBloodGroup(
		com.adjecti.mdm.liferay.model.BloodGroup bloodGroup) {

		return _bloodGroupLocalService.updateBloodGroup(bloodGroup);
	}

	@Override
	public BloodGroupLocalService getWrappedService() {
		return _bloodGroupLocalService;
	}

	@Override
	public void setWrappedService(
		BloodGroupLocalService bloodGroupLocalService) {

		_bloodGroupLocalService = bloodGroupLocalService;
	}

	private BloodGroupLocalService _bloodGroupLocalService;

}