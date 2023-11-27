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
 * Provides a wrapper for {@link PostReportingLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PostReportingLocalService
 * @generated
 */
public class PostReportingLocalServiceWrapper
	implements PostReportingLocalService,
			   ServiceWrapper<PostReportingLocalService> {

	public PostReportingLocalServiceWrapper(
		PostReportingLocalService postReportingLocalService) {

		_postReportingLocalService = postReportingLocalService;
	}

	/**
	 * Adds the post reporting to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PostReportingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param postReporting the post reporting
	 * @return the post reporting that was added
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PostReporting addPostReporting(
		com.adjecti.mdm.liferay.model.PostReporting postReporting) {

		return _postReportingLocalService.addPostReporting(postReporting);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _postReportingLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new post reporting with the primary key. Does not add the post reporting to the database.
	 *
	 * @param postReportingId the primary key for the new post reporting
	 * @return the new post reporting
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PostReporting createPostReporting(
		long postReportingId) {

		return _postReportingLocalService.createPostReporting(postReportingId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _postReportingLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the post reporting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PostReportingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param postReportingId the primary key of the post reporting
	 * @return the post reporting that was removed
	 * @throws PortalException if a post reporting with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PostReporting deletePostReporting(
			long postReportingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _postReportingLocalService.deletePostReporting(postReportingId);
	}

	/**
	 * Deletes the post reporting from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PostReportingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param postReporting the post reporting
	 * @return the post reporting that was removed
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PostReporting deletePostReporting(
		com.adjecti.mdm.liferay.model.PostReporting postReporting) {

		return _postReportingLocalService.deletePostReporting(postReporting);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _postReportingLocalService.dynamicQuery();
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

		return _postReportingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.PostReportingModelImpl</code>.
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

		return _postReportingLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.PostReportingModelImpl</code>.
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

		return _postReportingLocalService.dynamicQuery(
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

		return _postReportingLocalService.dynamicQueryCount(dynamicQuery);
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

		return _postReportingLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.mdm.liferay.model.PostReporting fetchPostReporting(
		long postReportingId) {

		return _postReportingLocalService.fetchPostReporting(postReportingId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _postReportingLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _postReportingLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _postReportingLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _postReportingLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the post reporting with the primary key.
	 *
	 * @param postReportingId the primary key of the post reporting
	 * @return the post reporting
	 * @throws PortalException if a post reporting with the primary key could not be found
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PostReporting getPostReporting(
			long postReportingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _postReportingLocalService.getPostReporting(postReportingId);
	}

	/**
	 * Returns a range of all the post reportings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.mdm.liferay.model.impl.PostReportingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of post reportings
	 * @param end the upper bound of the range of post reportings (not inclusive)
	 * @return the range of post reportings
	 */
	@Override
	public java.util.List<com.adjecti.mdm.liferay.model.PostReporting>
		getPostReportings(int start, int end) {

		return _postReportingLocalService.getPostReportings(start, end);
	}

	/**
	 * Returns the number of post reportings.
	 *
	 * @return the number of post reportings
	 */
	@Override
	public int getPostReportingsCount() {
		return _postReportingLocalService.getPostReportingsCount();
	}

	/**
	 * Updates the post reporting in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PostReportingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param postReporting the post reporting
	 * @return the post reporting that was updated
	 */
	@Override
	public com.adjecti.mdm.liferay.model.PostReporting updatePostReporting(
		com.adjecti.mdm.liferay.model.PostReporting postReporting) {

		return _postReportingLocalService.updatePostReporting(postReporting);
	}

	@Override
	public PostReportingLocalService getWrappedService() {
		return _postReportingLocalService;
	}

	@Override
	public void setWrappedService(
		PostReportingLocalService postReportingLocalService) {

		_postReportingLocalService = postReportingLocalService;
	}

	private PostReportingLocalService _postReportingLocalService;

}