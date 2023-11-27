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
 * Provides a wrapper for {@link JoiningProcessRequestLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see JoiningProcessRequestLocalService
 * @generated
 */
public class JoiningProcessRequestLocalServiceWrapper
	implements JoiningProcessRequestLocalService,
			   ServiceWrapper<JoiningProcessRequestLocalService> {

	public JoiningProcessRequestLocalServiceWrapper(
		JoiningProcessRequestLocalService joiningProcessRequestLocalService) {

		_joiningProcessRequestLocalService = joiningProcessRequestLocalService;
	}

	/**
	 * Adds the joining process request to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect JoiningProcessRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param joiningProcessRequest the joining process request
	 * @return the joining process request that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.JoiningProcessRequest
		addJoiningProcessRequest(
			com.adjecti.pis.liferay.model.JoiningProcessRequest
				joiningProcessRequest) {

		return _joiningProcessRequestLocalService.addJoiningProcessRequest(
			joiningProcessRequest);
	}

	/**
	 * Creates a new joining process request with the primary key. Does not add the joining process request to the database.
	 *
	 * @param joiningProcessRequestId the primary key for the new joining process request
	 * @return the new joining process request
	 */
	@Override
	public com.adjecti.pis.liferay.model.JoiningProcessRequest
		createJoiningProcessRequest(long joiningProcessRequestId) {

		return _joiningProcessRequestLocalService.createJoiningProcessRequest(
			joiningProcessRequestId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _joiningProcessRequestLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the joining process request from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect JoiningProcessRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param joiningProcessRequest the joining process request
	 * @return the joining process request that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.JoiningProcessRequest
		deleteJoiningProcessRequest(
			com.adjecti.pis.liferay.model.JoiningProcessRequest
				joiningProcessRequest) {

		return _joiningProcessRequestLocalService.deleteJoiningProcessRequest(
			joiningProcessRequest);
	}

	/**
	 * Deletes the joining process request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect JoiningProcessRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param joiningProcessRequestId the primary key of the joining process request
	 * @return the joining process request that was removed
	 * @throws PortalException if a joining process request with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.JoiningProcessRequest
			deleteJoiningProcessRequest(long joiningProcessRequestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _joiningProcessRequestLocalService.deleteJoiningProcessRequest(
			joiningProcessRequestId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _joiningProcessRequestLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _joiningProcessRequestLocalService.dynamicQuery();
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

		return _joiningProcessRequestLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.JoiningProcessRequestModelImpl</code>.
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

		return _joiningProcessRequestLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.JoiningProcessRequestModelImpl</code>.
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

		return _joiningProcessRequestLocalService.dynamicQuery(
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

		return _joiningProcessRequestLocalService.dynamicQueryCount(
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

		return _joiningProcessRequestLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.JoiningProcessRequest
		fetchJoiningProcessRequest(long joiningProcessRequestId) {

		return _joiningProcessRequestLocalService.fetchJoiningProcessRequest(
			joiningProcessRequestId);
	}

	/**
	 * Returns the joining process request matching the UUID and group.
	 *
	 * @param uuid the joining process request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching joining process request, or <code>null</code> if a matching joining process request could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.JoiningProcessRequest
		fetchJoiningProcessRequestByUuidAndGroupId(String uuid, long groupId) {

		return _joiningProcessRequestLocalService.
			fetchJoiningProcessRequestByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _joiningProcessRequestLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _joiningProcessRequestLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _joiningProcessRequestLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the joining process request with the primary key.
	 *
	 * @param joiningProcessRequestId the primary key of the joining process request
	 * @return the joining process request
	 * @throws PortalException if a joining process request with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.JoiningProcessRequest
			getJoiningProcessRequest(long joiningProcessRequestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _joiningProcessRequestLocalService.getJoiningProcessRequest(
			joiningProcessRequestId);
	}

	/**
	 * Returns the joining process request matching the UUID and group.
	 *
	 * @param uuid the joining process request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching joining process request
	 * @throws PortalException if a matching joining process request could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.JoiningProcessRequest
			getJoiningProcessRequestByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _joiningProcessRequestLocalService.
			getJoiningProcessRequestByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the joining process requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.JoiningProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of joining process requests
	 * @param end the upper bound of the range of joining process requests (not inclusive)
	 * @return the range of joining process requests
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.JoiningProcessRequest>
		getJoiningProcessRequests(int start, int end) {

		return _joiningProcessRequestLocalService.getJoiningProcessRequests(
			start, end);
	}

	/**
	 * Returns all the joining process requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the joining process requests
	 * @param companyId the primary key of the company
	 * @return the matching joining process requests, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.JoiningProcessRequest>
		getJoiningProcessRequestsByUuidAndCompanyId(
			String uuid, long companyId) {

		return _joiningProcessRequestLocalService.
			getJoiningProcessRequestsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of joining process requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the joining process requests
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of joining process requests
	 * @param end the upper bound of the range of joining process requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching joining process requests, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.JoiningProcessRequest>
		getJoiningProcessRequestsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.adjecti.pis.liferay.model.JoiningProcessRequest>
					orderByComparator) {

		return _joiningProcessRequestLocalService.
			getJoiningProcessRequestsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of joining process requests.
	 *
	 * @return the number of joining process requests
	 */
	@Override
	public int getJoiningProcessRequestsCount() {
		return _joiningProcessRequestLocalService.
			getJoiningProcessRequestsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _joiningProcessRequestLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _joiningProcessRequestLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the joining process request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect JoiningProcessRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param joiningProcessRequest the joining process request
	 * @return the joining process request that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.JoiningProcessRequest
		updateJoiningProcessRequest(
			com.adjecti.pis.liferay.model.JoiningProcessRequest
				joiningProcessRequest) {

		return _joiningProcessRequestLocalService.updateJoiningProcessRequest(
			joiningProcessRequest);
	}

	@Override
	public JoiningProcessRequestLocalService getWrappedService() {
		return _joiningProcessRequestLocalService;
	}

	@Override
	public void setWrappedService(
		JoiningProcessRequestLocalService joiningProcessRequestLocalService) {

		_joiningProcessRequestLocalService = joiningProcessRequestLocalService;
	}

	private JoiningProcessRequestLocalService
		_joiningProcessRequestLocalService;

}