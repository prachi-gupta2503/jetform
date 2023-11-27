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
 * Provides a wrapper for {@link SampleProcessRequestLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SampleProcessRequestLocalService
 * @generated
 */
public class SampleProcessRequestLocalServiceWrapper
	implements SampleProcessRequestLocalService,
			   ServiceWrapper<SampleProcessRequestLocalService> {

	public SampleProcessRequestLocalServiceWrapper(
		SampleProcessRequestLocalService sampleProcessRequestLocalService) {

		_sampleProcessRequestLocalService = sampleProcessRequestLocalService;
	}

	/**
	 * Adds the sample process request to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SampleProcessRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sampleProcessRequest the sample process request
	 * @return the sample process request that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.SampleProcessRequest
		addSampleProcessRequest(
			com.adjecti.pis.liferay.model.SampleProcessRequest
				sampleProcessRequest) {

		return _sampleProcessRequestLocalService.addSampleProcessRequest(
			sampleProcessRequest);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sampleProcessRequestLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new sample process request with the primary key. Does not add the sample process request to the database.
	 *
	 * @param sampleProcessRequestId the primary key for the new sample process request
	 * @return the new sample process request
	 */
	@Override
	public com.adjecti.pis.liferay.model.SampleProcessRequest
		createSampleProcessRequest(long sampleProcessRequestId) {

		return _sampleProcessRequestLocalService.createSampleProcessRequest(
			sampleProcessRequestId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sampleProcessRequestLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the sample process request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SampleProcessRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sampleProcessRequestId the primary key of the sample process request
	 * @return the sample process request that was removed
	 * @throws PortalException if a sample process request with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.SampleProcessRequest
			deleteSampleProcessRequest(long sampleProcessRequestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sampleProcessRequestLocalService.deleteSampleProcessRequest(
			sampleProcessRequestId);
	}

	/**
	 * Deletes the sample process request from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SampleProcessRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sampleProcessRequest the sample process request
	 * @return the sample process request that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.SampleProcessRequest
		deleteSampleProcessRequest(
			com.adjecti.pis.liferay.model.SampleProcessRequest
				sampleProcessRequest) {

		return _sampleProcessRequestLocalService.deleteSampleProcessRequest(
			sampleProcessRequest);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _sampleProcessRequestLocalService.dynamicQuery();
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

		return _sampleProcessRequestLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.SampleProcessRequestModelImpl</code>.
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

		return _sampleProcessRequestLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.SampleProcessRequestModelImpl</code>.
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

		return _sampleProcessRequestLocalService.dynamicQuery(
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

		return _sampleProcessRequestLocalService.dynamicQueryCount(
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

		return _sampleProcessRequestLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.SampleProcessRequest
		fetchSampleProcessRequest(long sampleProcessRequestId) {

		return _sampleProcessRequestLocalService.fetchSampleProcessRequest(
			sampleProcessRequestId);
	}

	/**
	 * Returns the sample process request matching the UUID and group.
	 *
	 * @param uuid the sample process request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching sample process request, or <code>null</code> if a matching sample process request could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.SampleProcessRequest
		fetchSampleProcessRequestByUuidAndGroupId(String uuid, long groupId) {

		return _sampleProcessRequestLocalService.
			fetchSampleProcessRequestByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _sampleProcessRequestLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _sampleProcessRequestLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _sampleProcessRequestLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _sampleProcessRequestLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sampleProcessRequestLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the sample process request with the primary key.
	 *
	 * @param sampleProcessRequestId the primary key of the sample process request
	 * @return the sample process request
	 * @throws PortalException if a sample process request with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.SampleProcessRequest
			getSampleProcessRequest(long sampleProcessRequestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sampleProcessRequestLocalService.getSampleProcessRequest(
			sampleProcessRequestId);
	}

	/**
	 * Returns the sample process request matching the UUID and group.
	 *
	 * @param uuid the sample process request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching sample process request
	 * @throws PortalException if a matching sample process request could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.SampleProcessRequest
			getSampleProcessRequestByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sampleProcessRequestLocalService.
			getSampleProcessRequestByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the sample process requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.SampleProcessRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sample process requests
	 * @param end the upper bound of the range of sample process requests (not inclusive)
	 * @return the range of sample process requests
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.SampleProcessRequest>
		getSampleProcessRequests(int start, int end) {

		return _sampleProcessRequestLocalService.getSampleProcessRequests(
			start, end);
	}

	/**
	 * Returns all the sample process requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the sample process requests
	 * @param companyId the primary key of the company
	 * @return the matching sample process requests, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.SampleProcessRequest>
		getSampleProcessRequestsByUuidAndCompanyId(
			String uuid, long companyId) {

		return _sampleProcessRequestLocalService.
			getSampleProcessRequestsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of sample process requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the sample process requests
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of sample process requests
	 * @param end the upper bound of the range of sample process requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching sample process requests, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.SampleProcessRequest>
		getSampleProcessRequestsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.adjecti.pis.liferay.model.SampleProcessRequest>
					orderByComparator) {

		return _sampleProcessRequestLocalService.
			getSampleProcessRequestsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of sample process requests.
	 *
	 * @return the number of sample process requests
	 */
	@Override
	public int getSampleProcessRequestsCount() {
		return _sampleProcessRequestLocalService.
			getSampleProcessRequestsCount();
	}

	/**
	 * Updates the sample process request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SampleProcessRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sampleProcessRequest the sample process request
	 * @return the sample process request that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.SampleProcessRequest
		updateSampleProcessRequest(
			com.adjecti.pis.liferay.model.SampleProcessRequest
				sampleProcessRequest) {

		return _sampleProcessRequestLocalService.updateSampleProcessRequest(
			sampleProcessRequest);
	}

	@Override
	public SampleProcessRequestLocalService getWrappedService() {
		return _sampleProcessRequestLocalService;
	}

	@Override
	public void setWrappedService(
		SampleProcessRequestLocalService sampleProcessRequestLocalService) {

		_sampleProcessRequestLocalService = sampleProcessRequestLocalService;
	}

	private SampleProcessRequestLocalService _sampleProcessRequestLocalService;

}