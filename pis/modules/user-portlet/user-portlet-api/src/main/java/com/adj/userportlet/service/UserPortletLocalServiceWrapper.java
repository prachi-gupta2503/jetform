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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserPortletLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserPortletLocalService
 * @generated
 */
public class UserPortletLocalServiceWrapper
	implements ServiceWrapper<UserPortletLocalService>,
			   UserPortletLocalService {

	public UserPortletLocalServiceWrapper(
		UserPortletLocalService userPortletLocalService) {

		_userPortletLocalService = userPortletLocalService;
	}

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
	@Override
	public com.adj.userportlet.model.UserPortlet addUserPortlet(
		com.adj.userportlet.model.UserPortlet userPortlet) {

		return _userPortletLocalService.addUserPortlet(userPortlet);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userPortletLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new user portlet with the primary key. Does not add the user portlet to the database.
	 *
	 * @param id the primary key for the new user portlet
	 * @return the new user portlet
	 */
	@Override
	public com.adj.userportlet.model.UserPortlet createUserPortlet(long id) {
		return _userPortletLocalService.createUserPortlet(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userPortletLocalService.deletePersistedModel(persistedModel);
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
	@Override
	public com.adj.userportlet.model.UserPortlet deleteUserPortlet(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userPortletLocalService.deleteUserPortlet(id);
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
	@Override
	public com.adj.userportlet.model.UserPortlet deleteUserPortlet(
		com.adj.userportlet.model.UserPortlet userPortlet) {

		return _userPortletLocalService.deleteUserPortlet(userPortlet);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userPortletLocalService.dynamicQuery();
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

		return _userPortletLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _userPortletLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _userPortletLocalService.dynamicQuery(
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

		return _userPortletLocalService.dynamicQueryCount(dynamicQuery);
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

		return _userPortletLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adj.userportlet.model.UserPortlet fetchUserPortlet(long id) {
		return _userPortletLocalService.fetchUserPortlet(id);
	}

	/**
	 * Returns the user portlet matching the UUID and group.
	 *
	 * @param uuid the user portlet's UUID
	 * @param groupId the primary key of the group
	 * @return the matching user portlet, or <code>null</code> if a matching user portlet could not be found
	 */
	@Override
	public com.adj.userportlet.model.UserPortlet
		fetchUserPortletByUuidAndGroupId(String uuid, long groupId) {

		return _userPortletLocalService.fetchUserPortletByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _userPortletLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.model.Organization>
		getAllOrganizations() {

		return _userPortletLocalService.getAllOrganizations();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _userPortletLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _userPortletLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userPortletLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userPortletLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the user portlet with the primary key.
	 *
	 * @param id the primary key of the user portlet
	 * @return the user portlet
	 * @throws PortalException if a user portlet with the primary key could not be found
	 */
	@Override
	public com.adj.userportlet.model.UserPortlet getUserPortlet(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userPortletLocalService.getUserPortlet(id);
	}

	@Override
	public com.adj.userportlet.model.UserPortlet getuserPortletByPortletId(
			String portletId)
		throws com.adj.userportlet.exception.NoSuchUserPortletException {

		return _userPortletLocalService.getuserPortletByPortletId(portletId);
	}

	/**
	 * Returns the user portlet matching the UUID and group.
	 *
	 * @param uuid the user portlet's UUID
	 * @param groupId the primary key of the group
	 * @return the matching user portlet
	 * @throws PortalException if a matching user portlet could not be found
	 */
	@Override
	public com.adj.userportlet.model.UserPortlet getUserPortletByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userPortletLocalService.getUserPortletByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<com.adj.userportlet.model.UserPortlet>
		getUserPortlets(int start, int end) {

		return _userPortletLocalService.getUserPortlets(start, end);
	}

	/**
	 * Returns all the user portlets matching the UUID and company.
	 *
	 * @param uuid the UUID of the user portlets
	 * @param companyId the primary key of the company
	 * @return the matching user portlets, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.adj.userportlet.model.UserPortlet>
		getUserPortletsByUuidAndCompanyId(String uuid, long companyId) {

		return _userPortletLocalService.getUserPortletsByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<com.adj.userportlet.model.UserPortlet>
		getUserPortletsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.adj.userportlet.model.UserPortlet> orderByComparator) {

		return _userPortletLocalService.getUserPortletsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of user portlets.
	 *
	 * @return the number of user portlets
	 */
	@Override
	public int getUserPortletsCount() {
		return _userPortletLocalService.getUserPortletsCount();
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
	@Override
	public com.adj.userportlet.model.UserPortlet updateUserPortlet(
		com.adj.userportlet.model.UserPortlet userPortlet) {

		return _userPortletLocalService.updateUserPortlet(userPortlet);
	}

	@Override
	public UserPortletLocalService getWrappedService() {
		return _userPortletLocalService;
	}

	@Override
	public void setWrappedService(
		UserPortletLocalService userPortletLocalService) {

		_userPortletLocalService = userPortletLocalService;
	}

	private UserPortletLocalService _userPortletLocalService;

}