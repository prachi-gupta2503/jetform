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
 * Provides a wrapper for {@link OrganizationTypeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationTypeLocalService
 * @generated
 */
public class OrganizationTypeLocalServiceWrapper
	implements OrganizationTypeLocalService,
			   ServiceWrapper<OrganizationTypeLocalService> {

	public OrganizationTypeLocalServiceWrapper(
		OrganizationTypeLocalService organizationTypeLocalService) {

		_organizationTypeLocalService = organizationTypeLocalService;
	}

	/**
	 * Adds the organization type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OrganizationTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param organizationType the organization type
	 * @return the organization type that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.OrganizationType addOrganizationType(
		com.adjecti.mdm.liferay.model.OrganizationType organizationType) {

		return _organizationTypeLocalService.addOrganizationType(
			organizationType);
	}

	/**
	 * Creates a new organization type with the primary key. Does not add the organization type to the database.
	 *
	 * @param organizationTypeId the primary key for the new organization type
	 * @return the new organization type
	 */
	@Override
	public com.adjecti.mdm.liferay.model.OrganizationType
		createOrganizationType(long organizationTypeId) {

		return _organizationTypeLocalService.createOrganizationType(
			organizationTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _organizationTypeLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the organization type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OrganizationTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param organizationTypeId the primary key of the organization type
	 * @return the organization type that was removed
	 * @throws PortalException if a organization type with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.OrganizationType
			deleteOrganizationType(long organizationTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _organizationTypeLocalService.deleteOrganizationType(
			organizationTypeId);
	}

	/**
	 * Deletes the organization type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OrganizationTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param organizationType the organization type
	 * @return the organization type that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.OrganizationType
		deleteOrganizationType(
			com.adjecti.mdm.liferay.model.OrganizationType organizationType) {

		return _organizationTypeLocalService.deleteOrganizationType(
			organizationType);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _organizationTypeLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _organizationTypeLocalService.dynamicQuery();
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

		return _organizationTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.OrganizationTypeModelImpl</code>.
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

		return _organizationTypeLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.OrganizationTypeModelImpl</code>.
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

		return _organizationTypeLocalService.dynamicQuery(
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

		return _organizationTypeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _organizationTypeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.OrganizationType fetchOrganizationType(
		long organizationTypeId) {

		return _organizationTypeLocalService.fetchOrganizationType(
			organizationTypeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _organizationTypeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _organizationTypeLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the organization type with the primary key.
	 *
	 * @param organizationTypeId the primary key of the organization type
	 * @return the organization type
	 * @throws PortalException if a organization type with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.OrganizationType getOrganizationType(
			long organizationTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _organizationTypeLocalService.getOrganizationType(
			organizationTypeId);
	}

	/**
	 * Returns a range of all the organization types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.OrganizationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization types
	 * @param end the upper bound of the range of organization types (not inclusive)
	 * @return the range of organization types
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.OrganizationType>
		getOrganizationTypes(int start, int end) {

		return _organizationTypeLocalService.getOrganizationTypes(start, end);
	}

	/**
	 * Returns the number of organization types.
	 *
	 * @return the number of organization types
	 */
	@Override
	public int getOrganizationTypesCount() {
		return _organizationTypeLocalService.getOrganizationTypesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _organizationTypeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _organizationTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the organization type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OrganizationTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param organizationType the organization type
	 * @return the organization type that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.OrganizationType
		updateOrganizationType(
			com.adjecti.mdm.liferay.model.OrganizationType organizationType) {

		return _organizationTypeLocalService.updateOrganizationType(
			organizationType);
	}

	@Override
	public OrganizationTypeLocalService getWrappedService() {
		return _organizationTypeLocalService;
	}

	@Override
	public void setWrappedService(
		OrganizationTypeLocalService organizationTypeLocalService) {

		_organizationTypeLocalService = organizationTypeLocalService;
	}

	private OrganizationTypeLocalService _organizationTypeLocalService;

}