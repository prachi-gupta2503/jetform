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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for OrganizationAssignment. This utility wraps
 * <code>com.adjecti.pis.liferay.service.impl.OrganizationAssignmentLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationAssignmentLocalService
 * @generated
 */
public class OrganizationAssignmentLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.pis.liferay.service.impl.OrganizationAssignmentLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static com.adjecti.pis.liferay.model.OrganizationAssignment
		addOrganizationAssignment(
			com.adjecti.pis.liferay.model.OrganizationAssignment
				organizationAssignment) {

		return getService().addOrganizationAssignment(organizationAssignment);
	}

	/**
	 * Creates a new organization assignment with the primary key. Does not add the organization assignment to the database.
	 *
	 * @param organizationAssignmentId the primary key for the new organization assignment
	 * @return the new organization assignment
	 */
	public static com.adjecti.pis.liferay.model.OrganizationAssignment
		createOrganizationAssignment(long organizationAssignmentId) {

		return getService().createOrganizationAssignment(
			organizationAssignmentId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			createPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static com.adjecti.pis.liferay.model.OrganizationAssignment
			deleteOrganizationAssignment(long organizationAssignmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteOrganizationAssignment(
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
	public static com.adjecti.pis.liferay.model.OrganizationAssignment
		deleteOrganizationAssignment(
			com.adjecti.pis.liferay.model.OrganizationAssignment
				organizationAssignment) {

		return getService().deleteOrganizationAssignment(
			organizationAssignment);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.adjecti.pis.liferay.model.OrganizationAssignment
		fetchOrganizationAssignment(long organizationAssignmentId) {

		return getService().fetchOrganizationAssignment(
			organizationAssignmentId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the organization assignment with the primary key.
	 *
	 * @param organizationAssignmentId the primary key of the organization assignment
	 * @return the organization assignment
	 * @throws PortalException if a organization assignment with the primary key could not be found
	 */
	public static com.adjecti.pis.liferay.model.OrganizationAssignment
			getOrganizationAssignment(long organizationAssignmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getOrganizationAssignment(organizationAssignmentId);
	}

	public static java.util.List
		<com.adjecti.pis.liferay.model.OrganizationAssignment>
			getOrganizationAssignmentByEmployeeId(long employeeId) {

		return getService().getOrganizationAssignmentByEmployeeId(employeeId);
	}

	public static java.util.List
		<com.adjecti.pis.liferay.model.OrganizationAssignment>
			getOrganizationAssignmentByPersonalNo(String personalNo) {

		return getService().getOrganizationAssignmentByPersonalNo(personalNo);
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
	public static java.util.List
		<com.adjecti.pis.liferay.model.OrganizationAssignment>
			getOrganizationAssignments(int start, int end) {

		return getService().getOrganizationAssignments(start, end);
	}

	/**
	 * Returns the number of organization assignments.
	 *
	 * @return the number of organization assignments
	 */
	public static int getOrganizationAssignmentsCount() {
		return getService().getOrganizationAssignmentsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static int importOrganizationAssignment(
		java.util.List<java.util.Map<String, String[]>> records) {

		return getService().importOrganizationAssignment(records);
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
	public static com.adjecti.pis.liferay.model.OrganizationAssignment
		updateOrganizationAssignment(
			com.adjecti.pis.liferay.model.OrganizationAssignment
				organizationAssignment) {

		return getService().updateOrganizationAssignment(
			organizationAssignment);
	}

	public static OrganizationAssignmentLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<OrganizationAssignmentLocalService, OrganizationAssignmentLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			OrganizationAssignmentLocalService.class);

		ServiceTracker
			<OrganizationAssignmentLocalService,
			 OrganizationAssignmentLocalService> serviceTracker =
				new ServiceTracker
					<OrganizationAssignmentLocalService,
					 OrganizationAssignmentLocalService>(
						 bundle.getBundleContext(),
						 OrganizationAssignmentLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}