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
 * Provides a wrapper for {@link OrganizationPayStructureLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationPayStructureLocalService
 * @generated
 */
public class OrganizationPayStructureLocalServiceWrapper
	implements OrganizationPayStructureLocalService,
			   ServiceWrapper<OrganizationPayStructureLocalService> {

	public OrganizationPayStructureLocalServiceWrapper(
		OrganizationPayStructureLocalService
			organizationPayStructureLocalService) {

		_organizationPayStructureLocalService =
			organizationPayStructureLocalService;
	}

	/**
	 * Adds the organization pay structure to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OrganizationPayStructureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param organizationPayStructure the organization pay structure
	 * @return the organization pay structure that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.OrganizationPayStructure
		addOrganizationPayStructure(
			com.adjecti.mdm.liferay.model.OrganizationPayStructure
				organizationPayStructure) {

		return _organizationPayStructureLocalService.
			addOrganizationPayStructure(organizationPayStructure);
	}

	/**
	 * Creates a new organization pay structure with the primary key. Does not add the organization pay structure to the database.
	 *
	 * @param organizationPayStructureId the primary key for the new organization pay structure
	 * @return the new organization pay structure
	 */
	@Override
	public com.adjecti.mdm.liferay.model.OrganizationPayStructure
		createOrganizationPayStructure(long organizationPayStructureId) {

		return _organizationPayStructureLocalService.
			createOrganizationPayStructure(organizationPayStructureId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _organizationPayStructureLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the organization pay structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OrganizationPayStructureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param organizationPayStructureId the primary key of the organization pay structure
	 * @return the organization pay structure that was removed
	 * @throws PortalException if a organization pay structure with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.OrganizationPayStructure
			deleteOrganizationPayStructure(long organizationPayStructureId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _organizationPayStructureLocalService.
			deleteOrganizationPayStructure(organizationPayStructureId);
	}

	/**
	 * Deletes the organization pay structure from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OrganizationPayStructureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param organizationPayStructure the organization pay structure
	 * @return the organization pay structure that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.OrganizationPayStructure
		deleteOrganizationPayStructure(
			com.adjecti.mdm.liferay.model.OrganizationPayStructure
				organizationPayStructure) {

		return _organizationPayStructureLocalService.
			deleteOrganizationPayStructure(organizationPayStructure);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _organizationPayStructureLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _organizationPayStructureLocalService.dynamicQuery();
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

		return _organizationPayStructureLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.OrganizationPayStructureModelImpl</code>.
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

		return _organizationPayStructureLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.OrganizationPayStructureModelImpl</code>.
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

		return _organizationPayStructureLocalService.dynamicQuery(
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

		return _organizationPayStructureLocalService.dynamicQueryCount(
			dynamicQuery);
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

		return _organizationPayStructureLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.OrganizationPayStructure
		fetchOrganizationPayStructure(long organizationPayStructureId) {

		return _organizationPayStructureLocalService.
			fetchOrganizationPayStructure(organizationPayStructureId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _organizationPayStructureLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _organizationPayStructureLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the organization pay structure with the primary key.
	 *
	 * @param organizationPayStructureId the primary key of the organization pay structure
	 * @return the organization pay structure
	 * @throws PortalException if a organization pay structure with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.OrganizationPayStructure
			getOrganizationPayStructure(long organizationPayStructureId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _organizationPayStructureLocalService.
			getOrganizationPayStructure(organizationPayStructureId);
	}

	/**
	 * Returns a range of all the organization pay structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.OrganizationPayStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization pay structures
	 * @param end the upper bound of the range of organization pay structures (not inclusive)
	 * @return the range of organization pay structures
	 */
	@Override
	public java.util.List
		<com.adjecti.mdm.liferay.model.OrganizationPayStructure>
			getOrganizationPayStructures(int start, int end) {

		return _organizationPayStructureLocalService.
			getOrganizationPayStructures(start, end);
	}

	/**
	 * Returns the number of organization pay structures.
	 *
	 * @return the number of organization pay structures
	 */
	@Override
	public int getOrganizationPayStructuresCount() {
		return _organizationPayStructureLocalService.
			getOrganizationPayStructuresCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _organizationPayStructureLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _organizationPayStructureLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the organization pay structure in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OrganizationPayStructureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param organizationPayStructure the organization pay structure
	 * @return the organization pay structure that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.OrganizationPayStructure
		updateOrganizationPayStructure(
			com.adjecti.mdm.liferay.model.OrganizationPayStructure
				organizationPayStructure) {

		return _organizationPayStructureLocalService.
			updateOrganizationPayStructure(organizationPayStructure);
	}

	@Override
	public OrganizationPayStructureLocalService getWrappedService() {
		return _organizationPayStructureLocalService;
	}

	@Override
	public void setWrappedService(
		OrganizationPayStructureLocalService
			organizationPayStructureLocalService) {

		_organizationPayStructureLocalService =
			organizationPayStructureLocalService;
	}

	private OrganizationPayStructureLocalService
		_organizationPayStructureLocalService;

}