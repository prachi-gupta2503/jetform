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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for OrganizationHistory. This utility wraps
 * <code>com.adjecti.mdm.liferay.service.impl.OrganizationHistoryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see OrganizationHistoryLocalService
 * @generated
 */
public class OrganizationHistoryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.mdm.liferay.service.impl.OrganizationHistoryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the organization history to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OrganizationHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param organizationHistory the organization history
	 * @return the organization history that was added
	 */
	public static com.adjecti.mdm.liferay.model.OrganizationHistory
		addOrganizationHistory(
			com.adjecti.mdm.liferay.model.OrganizationHistory
				organizationHistory) {

		return getService().addOrganizationHistory(organizationHistory);
	}

	/**
	 * Creates a new organization history with the primary key. Does not add the organization history to the database.
	 *
	 * @param organizationHistoryId the primary key for the new organization history
	 * @return the new organization history
	 */
	public static com.adjecti.mdm.liferay.model.OrganizationHistory
		createOrganizationHistory(long organizationHistoryId) {

		return getService().createOrganizationHistory(organizationHistoryId);
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
	 * Deletes the organization history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OrganizationHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param organizationHistoryId the primary key of the organization history
	 * @return the organization history that was removed
	 * @throws PortalException if a organization history with the primary key could not be found
	 */
	public static com.adjecti.mdm.liferay.model.OrganizationHistory
			deleteOrganizationHistory(long organizationHistoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteOrganizationHistory(organizationHistoryId);
	}

	/**
	 * Deletes the organization history from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OrganizationHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param organizationHistory the organization history
	 * @return the organization history that was removed
	 */
	public static com.adjecti.mdm.liferay.model.OrganizationHistory
		deleteOrganizationHistory(
			com.adjecti.mdm.liferay.model.OrganizationHistory
				organizationHistory) {

		return getService().deleteOrganizationHistory(organizationHistory);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.OrganizationHistoryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.OrganizationHistoryModelImpl</code>.
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

	public static com.adjecti.mdm.liferay.model.OrganizationHistory
		fetchOrganizationHistory(long organizationHistoryId) {

		return getService().fetchOrganizationHistory(organizationHistoryId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List
		<com.adjecti.mdm.liferay.model.OrganizationHistory>
			getByPreviousOrganizationId(long organizationId) {

		return getService().getByPreviousOrganizationId(organizationId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the organization histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.OrganizationHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organization histories
	 * @param end the upper bound of the range of organization histories (not inclusive)
	 * @return the range of organization histories
	 */
	public static java.util.List
		<com.adjecti.mdm.liferay.model.OrganizationHistory>
			getOrganizationHistories(int start, int end) {

		return getService().getOrganizationHistories(start, end);
	}

	/**
	 * Returns the number of organization histories.
	 *
	 * @return the number of organization histories
	 */
	public static int getOrganizationHistoriesCount() {
		return getService().getOrganizationHistoriesCount();
	}

	/**
	 * Returns the organization history with the primary key.
	 *
	 * @param organizationHistoryId the primary key of the organization history
	 * @return the organization history
	 * @throws PortalException if a organization history with the primary key could not be found
	 */
	public static com.adjecti.mdm.liferay.model.OrganizationHistory
			getOrganizationHistory(long organizationHistoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getOrganizationHistory(organizationHistoryId);
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

	public static java.util.List
		<com.adjecti.mdm.liferay.model.OrganizationHistory>
				saveSplitOrganizationHistory(
					java.util.List<Long> organizationIds,
					long originalSectionId, String status)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().saveSplitOrganizationHistory(
			organizationIds, originalSectionId, status);
	}

	/**
	 * Updates the organization history in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OrganizationHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param organizationHistory the organization history
	 * @return the organization history that was updated
	 */
	public static com.adjecti.mdm.liferay.model.OrganizationHistory
		updateOrganizationHistory(
			com.adjecti.mdm.liferay.model.OrganizationHistory
				organizationHistory) {

		return getService().updateOrganizationHistory(organizationHistory);
	}

	public static OrganizationHistoryLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<OrganizationHistoryLocalService, OrganizationHistoryLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			OrganizationHistoryLocalService.class);

		ServiceTracker
			<OrganizationHistoryLocalService, OrganizationHistoryLocalService>
				serviceTracker =
					new ServiceTracker
						<OrganizationHistoryLocalService,
						 OrganizationHistoryLocalService>(
							 bundle.getBundleContext(),
							 OrganizationHistoryLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}