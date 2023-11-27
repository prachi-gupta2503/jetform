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
 * Provides a wrapper for {@link DesignationGroupLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DesignationGroupLocalService
 * @generated
 */
public class DesignationGroupLocalServiceWrapper
	implements DesignationGroupLocalService,
			   ServiceWrapper<DesignationGroupLocalService> {

	public DesignationGroupLocalServiceWrapper(
		DesignationGroupLocalService designationGroupLocalService) {

		_designationGroupLocalService = designationGroupLocalService;
	}

	/**
	 * Adds the designation group to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DesignationGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param designationGroup the designation group
	 * @return the designation group that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DesignationGroup addDesignationGroup(
		com.adjecti.mdm.liferay.model.DesignationGroup designationGroup) {

		return _designationGroupLocalService.addDesignationGroup(
			designationGroup);
	}

	/**
	 * Creates a new designation group with the primary key. Does not add the designation group to the database.
	 *
	 * @param designationGroupId the primary key for the new designation group
	 * @return the new designation group
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DesignationGroup
		createDesignationGroup(long designationGroupId) {

		return _designationGroupLocalService.createDesignationGroup(
			designationGroupId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _designationGroupLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the designation group from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DesignationGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param designationGroup the designation group
	 * @return the designation group that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DesignationGroup
		deleteDesignationGroup(
			com.adjecti.mdm.liferay.model.DesignationGroup designationGroup) {

		return _designationGroupLocalService.deleteDesignationGroup(
			designationGroup);
	}

	/**
	 * Deletes the designation group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DesignationGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param designationGroupId the primary key of the designation group
	 * @return the designation group that was removed
	 * @throws PortalException if a designation group with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DesignationGroup
			deleteDesignationGroup(long designationGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _designationGroupLocalService.deleteDesignationGroup(
			designationGroupId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _designationGroupLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _designationGroupLocalService.dynamicQuery();
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

		return _designationGroupLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.DesignationGroupModelImpl</code>.
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

		return _designationGroupLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.DesignationGroupModelImpl</code>.
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

		return _designationGroupLocalService.dynamicQuery(
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

		return _designationGroupLocalService.dynamicQueryCount(dynamicQuery);
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

		return _designationGroupLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.DesignationGroup fetchDesignationGroup(
		long designationGroupId) {

		return _designationGroupLocalService.fetchDesignationGroup(
			designationGroupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _designationGroupLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the designation group with the primary key.
	 *
	 * @param designationGroupId the primary key of the designation group
	 * @return the designation group
	 * @throws PortalException if a designation group with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DesignationGroup getDesignationGroup(
			long designationGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _designationGroupLocalService.getDesignationGroup(
			designationGroupId);
	}

	/**
	 * Returns a range of all the designation groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.DesignationGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designation groups
	 * @param end the upper bound of the range of designation groups (not inclusive)
	 * @return the range of designation groups
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.DesignationGroup>
		getDesignationGroups(int start, int end) {

		return _designationGroupLocalService.getDesignationGroups(start, end);
	}

	/**
	 * Returns the number of designation groups.
	 *
	 * @return the number of designation groups
	 */
	@Override
	public int getDesignationGroupsCount() {
		return _designationGroupLocalService.getDesignationGroupsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _designationGroupLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _designationGroupLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _designationGroupLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the designation group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DesignationGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param designationGroup the designation group
	 * @return the designation group that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.DesignationGroup
		updateDesignationGroup(
			com.adjecti.mdm.liferay.model.DesignationGroup designationGroup) {

		return _designationGroupLocalService.updateDesignationGroup(
			designationGroup);
	}

	@Override
	public DesignationGroupLocalService getWrappedService() {
		return _designationGroupLocalService;
	}

	@Override
	public void setWrappedService(
		DesignationGroupLocalService designationGroupLocalService) {

		_designationGroupLocalService = designationGroupLocalService;
	}

	private DesignationGroupLocalService _designationGroupLocalService;

}