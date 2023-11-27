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

package com.adj.userportlet.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for UserPortlet. This utility wraps
 * <code>com.adj.userportlet.service.impl.UserPortletLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see UserPortletLocalService
 * @generated
 */
public class UserPortletLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adj.userportlet.service.impl.UserPortletLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the user portlet to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserPortletLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userPortlet the user portlet
	 * @return the user portlet that was added
	 */
	public static com.adj.userportlet.model.UserPortlet addUserPortlet(
		com.adj.userportlet.model.UserPortlet userPortlet) {

		return getService().addUserPortlet(userPortlet);
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
	 * Creates a new user portlet with the primary key. Does not add the user portlet to the database.
	 *
	 * @param id the primary key for the new user portlet
	 * @return the new user portlet
	 */
	public static com.adj.userportlet.model.UserPortlet createUserPortlet(
		long id) {

		return getService().createUserPortlet(id);
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

	/**
	 * Deletes the user portlet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserPortletLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the user portlet
	 * @return the user portlet that was removed
	 * @throws PortalException if a user portlet with the primary key could not be found
	 */
	public static com.adj.userportlet.model.UserPortlet deleteUserPortlet(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteUserPortlet(id);
	}

	/**
	 * Deletes the user portlet from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserPortletLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userPortlet the user portlet
	 * @return the user portlet that was removed
	 */
	public static com.adj.userportlet.model.UserPortlet deleteUserPortlet(
		com.adj.userportlet.model.UserPortlet userPortlet) {

		return getService().deleteUserPortlet(userPortlet);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adj.userportlet.model.impl.UserPortletModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adj.userportlet.model.impl.UserPortletModelImpl</code>.
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

	public static com.adj.userportlet.model.UserPortlet fetchUserPortlet(
		long id) {

		return getService().fetchUserPortlet(id);
	}

	/**
	 * Returns the user portlet matching the UUID and group.
	 *
	 * @param uuid the user portlet's UUID
	 * @param groupId the primary key of the group
	 * @return the matching user portlet, or <code>null</code> if a matching user portlet could not be found
	 */
	public static com.adj.userportlet.model.UserPortlet
		fetchUserPortletByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchUserPortletByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<com.liferay.portal.kernel.model.Organization>
		getAllOrganizations() {

		return getService().getAllOrganizations();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
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

	/**
	 * Returns the user portlet with the primary key.
	 *
	 * @param id the primary key of the user portlet
	 * @return the user portlet
	 * @throws PortalException if a user portlet with the primary key could not be found
	 */
	public static com.adj.userportlet.model.UserPortlet getUserPortlet(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getUserPortlet(id);
	}

	public static com.adj.userportlet.model.UserPortlet
			getuserPortletByPortletId(String portletId)
		throws com.adj.userportlet.exception.NoSuchUserPortletException {

		return getService().getuserPortletByPortletId(portletId);
	}

	/**
	 * Returns the user portlet matching the UUID and group.
	 *
	 * @param uuid the user portlet's UUID
	 * @param groupId the primary key of the group
	 * @return the matching user portlet
	 * @throws PortalException if a matching user portlet could not be found
	 */
	public static com.adj.userportlet.model.UserPortlet
			getUserPortletByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getUserPortletByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the user portlets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adj.userportlet.model.impl.UserPortletModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user portlets
	 * @param end the upper bound of the range of user portlets (not inclusive)
	 * @return the range of user portlets
	 */
	public static java.util.List<com.adj.userportlet.model.UserPortlet>
		getUserPortlets(int start, int end) {

		return getService().getUserPortlets(start, end);
	}

	/**
	 * Returns all the user portlets matching the UUID and company.
	 *
	 * @param uuid the UUID of the user portlets
	 * @param companyId the primary key of the company
	 * @return the matching user portlets, or an empty list if no matches were found
	 */
	public static java.util.List<com.adj.userportlet.model.UserPortlet>
		getUserPortletsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getUserPortletsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of user portlets matching the UUID and company.
	 *
	 * @param uuid the UUID of the user portlets
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of user portlets
	 * @param end the upper bound of the range of user portlets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching user portlets, or an empty list if no matches were found
	 */
	public static java.util.List<com.adj.userportlet.model.UserPortlet>
		getUserPortletsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.adj.userportlet.model.UserPortlet> orderByComparator) {

		return getService().getUserPortletsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of user portlets.
	 *
	 * @return the number of user portlets
	 */
	public static int getUserPortletsCount() {
		return getService().getUserPortletsCount();
	}

	/**
	 * Updates the user portlet in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserPortletLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userPortlet the user portlet
	 * @return the user portlet that was updated
	 */
	public static com.adj.userportlet.model.UserPortlet updateUserPortlet(
		com.adj.userportlet.model.UserPortlet userPortlet) {

		return getService().updateUserPortlet(userPortlet);
	}

	public static UserPortletLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<UserPortletLocalService, UserPortletLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(UserPortletLocalService.class);

		ServiceTracker<UserPortletLocalService, UserPortletLocalService>
			serviceTracker =
				new ServiceTracker
					<UserPortletLocalService, UserPortletLocalService>(
						bundle.getBundleContext(),
						UserPortletLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}