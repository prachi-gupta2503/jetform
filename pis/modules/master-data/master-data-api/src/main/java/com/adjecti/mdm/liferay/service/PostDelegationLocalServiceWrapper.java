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
 * Provides a wrapper for {@link PostDelegationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PostDelegationLocalService
 * @generated
 */
public class PostDelegationLocalServiceWrapper
	implements PostDelegationLocalService,
			   ServiceWrapper<PostDelegationLocalService> {

	public PostDelegationLocalServiceWrapper(
		PostDelegationLocalService postDelegationLocalService) {

		_postDelegationLocalService = postDelegationLocalService;
	}

	/**
	 * Adds the post delegation to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PostDelegationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param postDelegation the post delegation
	 * @return the post delegation that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PostDelegation addPostDelegation(
		com.adjecti.mdm.liferay.model.PostDelegation postDelegation) {

		return _postDelegationLocalService.addPostDelegation(postDelegation);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _postDelegationLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new post delegation with the primary key. Does not add the post delegation to the database.
	 *
	 * @param postDelegationId the primary key for the new post delegation
	 * @return the new post delegation
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PostDelegation createPostDelegation(
		long postDelegationId) {

		return _postDelegationLocalService.createPostDelegation(
			postDelegationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _postDelegationLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the post delegation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PostDelegationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param postDelegationId the primary key of the post delegation
	 * @return the post delegation that was removed
	 * @throws PortalException if a post delegation with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PostDelegation deletePostDelegation(
			long postDelegationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _postDelegationLocalService.deletePostDelegation(
			postDelegationId);
	}

	/**
	 * Deletes the post delegation from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PostDelegationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param postDelegation the post delegation
	 * @return the post delegation that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PostDelegation deletePostDelegation(
		com.adjecti.mdm.liferay.model.PostDelegation postDelegation) {

		return _postDelegationLocalService.deletePostDelegation(postDelegation);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _postDelegationLocalService.dynamicQuery();
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

		return _postDelegationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.PostDelegationModelImpl</code>.
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

		return _postDelegationLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.PostDelegationModelImpl</code>.
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

		return _postDelegationLocalService.dynamicQuery(
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

		return _postDelegationLocalService.dynamicQueryCount(dynamicQuery);
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

		return _postDelegationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.PostDelegation fetchPostDelegation(
		long postDelegationId) {

		return _postDelegationLocalService.fetchPostDelegation(
			postDelegationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _postDelegationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _postDelegationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _postDelegationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _postDelegationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the post delegation with the primary key.
	 *
	 * @param postDelegationId the primary key of the post delegation
	 * @return the post delegation
	 * @throws PortalException if a post delegation with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PostDelegation getPostDelegation(
			long postDelegationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _postDelegationLocalService.getPostDelegation(postDelegationId);
	}

	/**
	 * Returns a range of all the post delegations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.PostDelegationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of post delegations
	 * @param end the upper bound of the range of post delegations (not inclusive)
	 * @return the range of post delegations
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.PostDelegation>
		getPostDelegations(int start, int end) {

		return _postDelegationLocalService.getPostDelegations(start, end);
	}

	/**
	 * Returns the number of post delegations.
	 *
	 * @return the number of post delegations
	 */
	@Override
	public int getPostDelegationsCount() {
		return _postDelegationLocalService.getPostDelegationsCount();
	}

	/**
	 * Updates the post delegation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PostDelegationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param postDelegation the post delegation
	 * @return the post delegation that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PostDelegation updatePostDelegation(
		com.adjecti.mdm.liferay.model.PostDelegation postDelegation) {

		return _postDelegationLocalService.updatePostDelegation(postDelegation);
	}

	@Override
	public PostDelegationLocalService getWrappedService() {
		return _postDelegationLocalService;
	}

	@Override
	public void setWrappedService(
		PostDelegationLocalService postDelegationLocalService) {

		_postDelegationLocalService = postDelegationLocalService;
	}

	private PostDelegationLocalService _postDelegationLocalService;

}