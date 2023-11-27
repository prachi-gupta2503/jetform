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
 * Provides a wrapper for {@link PostHierarchyLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PostHierarchyLocalService
 * @generated
 */
public class PostHierarchyLocalServiceWrapper
	implements PostHierarchyLocalService,
			   ServiceWrapper<PostHierarchyLocalService> {

	public PostHierarchyLocalServiceWrapper(
		PostHierarchyLocalService postHierarchyLocalService) {

		_postHierarchyLocalService = postHierarchyLocalService;
	}

	/**
	 * Adds the post hierarchy to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PostHierarchyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param postHierarchy the post hierarchy
	 * @return the post hierarchy that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PostHierarchy addPostHierarchy(
		com.adjecti.mdm.liferay.model.PostHierarchy postHierarchy) {

		return _postHierarchyLocalService.addPostHierarchy(postHierarchy);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _postHierarchyLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new post hierarchy with the primary key. Does not add the post hierarchy to the database.
	 *
	 * @param postHierarchyId the primary key for the new post hierarchy
	 * @return the new post hierarchy
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PostHierarchy createPostHierarchy(
		long postHierarchyId) {

		return _postHierarchyLocalService.createPostHierarchy(postHierarchyId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _postHierarchyLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the post hierarchy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PostHierarchyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param postHierarchyId the primary key of the post hierarchy
	 * @return the post hierarchy that was removed
	 * @throws PortalException if a post hierarchy with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PostHierarchy deletePostHierarchy(
			long postHierarchyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _postHierarchyLocalService.deletePostHierarchy(postHierarchyId);
	}

	/**
	 * Deletes the post hierarchy from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PostHierarchyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param postHierarchy the post hierarchy
	 * @return the post hierarchy that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PostHierarchy deletePostHierarchy(
		com.adjecti.mdm.liferay.model.PostHierarchy postHierarchy) {

		return _postHierarchyLocalService.deletePostHierarchy(postHierarchy);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _postHierarchyLocalService.dynamicQuery();
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

		return _postHierarchyLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.PostHierarchyModelImpl</code>.
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

		return _postHierarchyLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.PostHierarchyModelImpl</code>.
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

		return _postHierarchyLocalService.dynamicQuery(
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

		return _postHierarchyLocalService.dynamicQueryCount(dynamicQuery);
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

		return _postHierarchyLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.PostHierarchy fetchPostHierarchy(
		long postHierarchyId) {

		return _postHierarchyLocalService.fetchPostHierarchy(postHierarchyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _postHierarchyLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _postHierarchyLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _postHierarchyLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _postHierarchyLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns a range of all the post hierarchies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.PostHierarchyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of post hierarchies
	 * @param end the upper bound of the range of post hierarchies (not inclusive)
	 * @return the range of post hierarchies
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.PostHierarchy>
		getPostHierarchies(int start, int end) {

		return _postHierarchyLocalService.getPostHierarchies(start, end);
	}

	/**
	 * Returns the number of post hierarchies.
	 *
	 * @return the number of post hierarchies
	 */
	@Override
	public int getPostHierarchiesCount() {
		return _postHierarchyLocalService.getPostHierarchiesCount();
	}

	/**
	 * Returns the post hierarchy with the primary key.
	 *
	 * @param postHierarchyId the primary key of the post hierarchy
	 * @return the post hierarchy
	 * @throws PortalException if a post hierarchy with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PostHierarchy getPostHierarchy(
			long postHierarchyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _postHierarchyLocalService.getPostHierarchy(postHierarchyId);
	}

	/**
	 * Updates the post hierarchy in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PostHierarchyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param postHierarchy the post hierarchy
	 * @return the post hierarchy that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PostHierarchy updatePostHierarchy(
		com.adjecti.mdm.liferay.model.PostHierarchy postHierarchy) {

		return _postHierarchyLocalService.updatePostHierarchy(postHierarchy);
	}

	@Override
	public PostHierarchyLocalService getWrappedService() {
		return _postHierarchyLocalService;
	}

	@Override
	public void setWrappedService(
		PostHierarchyLocalService postHierarchyLocalService) {

		_postHierarchyLocalService = postHierarchyLocalService;
	}

	private PostHierarchyLocalService _postHierarchyLocalService;

}