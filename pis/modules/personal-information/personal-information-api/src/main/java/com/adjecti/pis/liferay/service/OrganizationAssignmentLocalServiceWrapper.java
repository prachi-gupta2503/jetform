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

package com.adjecti.pis.liferay.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link OrganizationAssignmentLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationAssignmentLocalService
 * @generated
 */
public class OrganizationAssignmentLocalServiceWrapper
	implements OrganizationAssignmentLocalService,
			   ServiceWrapper<OrganizationAssignmentLocalService> {

	public OrganizationAssignmentLocalServiceWrapper(
		OrganizationAssignmentLocalService organizationAssignmentLocalService) {

		_organizationAssignmentLocalService =
			organizationAssignmentLocalService;
	}

	/**
	 * Adds the organization assignment to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OrganizationAssignmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param organizationAssignment the organization assignment
	 * @return the organization assignment that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.OrganizationAssignment
		addOrganizationAssignment(
			com.adjecti.pis.liferay.model.OrganizationAssignment
				organizationAssignment) {

		return _organizationAssignmentLocalService.addOrganizationAssignment(
			organizationAssignment);
	}

	/**
	 * Creates a new organization assignment with the primary key. Does not add the organization assignment to the database.
	 *
	 * @param organizationAssignmentId the primary key for the new organization assignment
	 * @return the new organization assignment
	 */
	@Override
	public com.adjecti.pis.liferay.model.OrganizationAssignment
		createOrganizationAssignment(long organizationAssignmentId) {

		return _organizationAssignmentLocalService.createOrganizationAssignment(
			organizationAssignmentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _organizationAssignmentLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the organization assignment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OrganizationAssignmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param organizationAssignmentId the primary key of the organization assignment
	 * @return the organization assignment that was removed
	 * @throws PortalException if a organization assignment with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.OrganizationAssignment
			deleteOrganizationAssignment(long organizationAssignmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _organizationAssignmentLocalService.deleteOrganizationAssignment(
			organizationAssignmentId);
	}

	/**
	 * Deletes the organization assignment from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OrganizationAssignmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param organizationAssignment the organization assignment
	 * @return the organization assignment that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.OrganizationAssignment
		deleteOrganizationAssignment(
			com.adjecti.pis.liferay.model.OrganizationAssignment
				organizationAssignment) {

		return _organizationAssignmentLocalService.deleteOrganizationAssignment(
			organizationAssignment);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _organizationAssignmentLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _organizationAssignmentLocalService.dynamicQuery();
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

		return _organizationAssignmentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.OrganizationAssignmentModelImpl</code>.
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

		return _organizationAssignmentLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.OrganizationAssignmentModelImpl</code>.
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

		return _organizationAssignmentLocalService.dynamicQuery(
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

		return _organizationAssignmentLocalService.dynamicQueryCount(
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

		return _organizationAssignmentLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.OrganizationAssignment
		fetchOrganizationAssignment(long organizationAssignmentId) {

		return _organizationAssignmentLocalService.fetchOrganizationAssignment(
			organizationAssignmentId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _organizationAssignmentLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _organizationAssignmentLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the organization assignment with the primary key.
	 *
	 * @param organizationAssignmentId the primary key of the organization assignment
	 * @return the organization assignment
	 * @throws PortalException if a organization assignment with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.OrganizationAssignment
			getOrganizationAssignment(long organizationAssignmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _organizationAssignmentLocalService.getOrganizationAssignment(
			organizationAssignmentId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.OrganizationAssignment>
		getOrganizationAssignmentByEmployeeId(long employeeId) {

		return _organizationAssignmentLocalService.
			getOrganizationAssignmentByEmployeeId(employeeId);
	}

	@Override
	public java.util.List<com.adjecti.pis.liferay.model.OrganizationAssignment>
		getOrganizationAssignmentByPersonalNo(String personalNo) {

		return _organizationAssignmentLocalService.
			getOrganizationAssignmentByPersonalNo(personalNo);
	}

	/**
	 * Returns a range of all the organization assignments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.OrganizationAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization assignments
	 * @param end the upper bound of the range of organization assignments (not inclusive)
	 * @return the range of organization assignments
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.OrganizationAssignment>
		getOrganizationAssignments(int start, int end) {

		return _organizationAssignmentLocalService.getOrganizationAssignments(
			start, end);
	}

	/**
	 * Returns the number of organization assignments.
	 *
	 * @return the number of organization assignments
	 */
	@Override
	public int getOrganizationAssignmentsCount() {
		return _organizationAssignmentLocalService.
			getOrganizationAssignmentsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _organizationAssignmentLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _organizationAssignmentLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public int importOrganizationAssignment(
		java.util.List<java.util.Map<String, String[]>> records) {

		return _organizationAssignmentLocalService.importOrganizationAssignment(
			records);
	}

	/**
	 * Updates the organization assignment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OrganizationAssignmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param organizationAssignment the organization assignment
	 * @return the organization assignment that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.OrganizationAssignment
		updateOrganizationAssignment(
			com.adjecti.pis.liferay.model.OrganizationAssignment
				organizationAssignment) {

		return _organizationAssignmentLocalService.updateOrganizationAssignment(
			organizationAssignment);
	}

	@Override
	public OrganizationAssignmentLocalService getWrappedService() {
		return _organizationAssignmentLocalService;
	}

	@Override
	public void setWrappedService(
		OrganizationAssignmentLocalService organizationAssignmentLocalService) {

		_organizationAssignmentLocalService =
			organizationAssignmentLocalService;
	}

	private OrganizationAssignmentLocalService
		_organizationAssignmentLocalService;

}