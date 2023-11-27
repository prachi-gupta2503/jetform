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
 * Provides a wrapper for {@link PostOrganizationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PostOrganizationLocalService
 * @generated
 */
public class PostOrganizationLocalServiceWrapper
	implements PostOrganizationLocalService,
			   ServiceWrapper<PostOrganizationLocalService> {

	public PostOrganizationLocalServiceWrapper(
		PostOrganizationLocalService postOrganizationLocalService) {

		_postOrganizationLocalService = postOrganizationLocalService;
	}

	@Override
	public com.adjecti.mdm.liferay.model.PostOrganization addPostOrganization(
			long postId, long organizationId, boolean postBox)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _postOrganizationLocalService.addPostOrganization(
			postId, organizationId, postBox);
	}

	/**
	 * Adds the post organization to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PostOrganizationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param postOrganization the post organization
	 * @return the post organization that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PostOrganization addPostOrganization(
		com.adjecti.mdm.liferay.model.PostOrganization postOrganization) {

		return _postOrganizationLocalService.addPostOrganization(
			postOrganization);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _postOrganizationLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new post organization with the primary key. Does not add the post organization to the database.
	 *
	 * @param postOrganizationId the primary key for the new post organization
	 * @return the new post organization
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PostOrganization
		createPostOrganization(long postOrganizationId) {

		return _postOrganizationLocalService.createPostOrganization(
			postOrganizationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _postOrganizationLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the post organization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PostOrganizationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param postOrganizationId the primary key of the post organization
	 * @return the post organization that was removed
	 * @throws PortalException if a post organization with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PostOrganization
			deletePostOrganization(long postOrganizationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _postOrganizationLocalService.deletePostOrganization(
			postOrganizationId);
	}

	/**
	 * Deletes the post organization from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PostOrganizationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param postOrganization the post organization
	 * @return the post organization that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PostOrganization
		deletePostOrganization(
			com.adjecti.mdm.liferay.model.PostOrganization postOrganization) {

		return _postOrganizationLocalService.deletePostOrganization(
			postOrganization);
	}

	@Override
	public void deletePostOrganizationByPostId(long postId) {
		_postOrganizationLocalService.deletePostOrganizationByPostId(postId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _postOrganizationLocalService.dynamicQuery();
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

		return _postOrganizationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.PostOrganizationModelImpl</code>.
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

		return _postOrganizationLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.PostOrganizationModelImpl</code>.
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

		return _postOrganizationLocalService.dynamicQuery(
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

		return _postOrganizationLocalService.dynamicQueryCount(dynamicQuery);
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

		return _postOrganizationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.PostOrganization fetchPostOrganization(
		long postOrganizationId) {

		return _postOrganizationLocalService.fetchPostOrganization(
			postOrganizationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _postOrganizationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _postOrganizationLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _postOrganizationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _postOrganizationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the post organization with the primary key.
	 *
	 * @param postOrganizationId the primary key of the post organization
	 * @return the post organization
	 * @throws PortalException if a post organization with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PostOrganization getPostOrganization(
			long postOrganizationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _postOrganizationLocalService.getPostOrganization(
			postOrganizationId);
	}

	/**
	 * Returns a range of all the post organizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.PostOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of post organizations
	 * @param end the upper bound of the range of post organizations (not inclusive)
	 * @return the range of post organizations
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.PostOrganization>
		getPostOrganizations(int start, int end) {

		return _postOrganizationLocalService.getPostOrganizations(start, end);
	}

	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.PostOrganization>
		getPostOrganizationsByPostId(long postId) {

		return _postOrganizationLocalService.getPostOrganizationsByPostId(
			postId);
	}

	/**
	 * Returns the number of post organizations.
	 *
	 * @return the number of post organizations
	 */
	@Override
	public int getPostOrganizationsCount() {
		return _postOrganizationLocalService.getPostOrganizationsCount();
	}

	@Override
	public com.adjecti.mdm.liferay.model.PostOrganization
			updatePostOrganization(long postId, long[] orgIds, boolean postBox)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _postOrganizationLocalService.updatePostOrganization(
			postId, orgIds, postBox);
	}

	/**
	 * Updates the post organization in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PostOrganizationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param postOrganization the post organization
	 * @return the post organization that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PostOrganization
		updatePostOrganization(
			com.adjecti.mdm.liferay.model.PostOrganization postOrganization) {

		return _postOrganizationLocalService.updatePostOrganization(
			postOrganization);
	}

	@Override
	public PostOrganizationLocalService getWrappedService() {
		return _postOrganizationLocalService;
	}

	@Override
	public void setWrappedService(
		PostOrganizationLocalService postOrganizationLocalService) {

		_postOrganizationLocalService = postOrganizationLocalService;
	}

	private PostOrganizationLocalService _postOrganizationLocalService;

}