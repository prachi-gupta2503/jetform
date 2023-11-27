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
 * Provides the local service utility for SampleProcessRequest. This utility wraps
 * <code>com.adjecti.pis.liferay.service.impl.SampleProcessRequestLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SampleProcessRequestLocalService
 * @generated
 */
public class SampleProcessRequestLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.pis.liferay.service.impl.SampleProcessRequestLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static com.adjecti.pis.liferay.model.SampleProcessRequest
		addSampleProcessRequest(
			com.adjecti.pis.liferay.model.SampleProcessRequest
				sampleProcessRequest) {

		return getService().addSampleProcessRequest(sampleProcessRequest);
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
	 * Creates a new sample process request with the primary key. Does not add the sample process request to the database.
	 *
	 * @param sampleProcessRequestId the primary key for the new sample process request
	 * @return the new sample process request
	 */
	public static com.adjecti.pis.liferay.model.SampleProcessRequest
		createSampleProcessRequest(long sampleProcessRequestId) {

		return getService().createSampleProcessRequest(sampleProcessRequestId);
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
	public static com.adjecti.pis.liferay.model.SampleProcessRequest
			deleteSampleProcessRequest(long sampleProcessRequestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteSampleProcessRequest(sampleProcessRequestId);
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
	public static com.adjecti.pis.liferay.model.SampleProcessRequest
		deleteSampleProcessRequest(
			com.adjecti.pis.liferay.model.SampleProcessRequest
				sampleProcessRequest) {

		return getService().deleteSampleProcessRequest(sampleProcessRequest);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.SampleProcessRequestModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.SampleProcessRequestModelImpl</code>.
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

	public static com.adjecti.pis.liferay.model.SampleProcessRequest
		fetchSampleProcessRequest(long sampleProcessRequestId) {

		return getService().fetchSampleProcessRequest(sampleProcessRequestId);
	}

	/**
	 * Returns the sample process request matching the UUID and group.
	 *
	 * @param uuid the sample process request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching sample process request, or <code>null</code> if a matching sample process request could not be found
	 */
	public static com.adjecti.pis.liferay.model.SampleProcessRequest
		fetchSampleProcessRequestByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchSampleProcessRequestByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	 * Returns the sample process request with the primary key.
	 *
	 * @param sampleProcessRequestId the primary key of the sample process request
	 * @return the sample process request
	 * @throws PortalException if a sample process request with the primary key could not be found
	 */
	public static com.adjecti.pis.liferay.model.SampleProcessRequest
			getSampleProcessRequest(long sampleProcessRequestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getSampleProcessRequest(sampleProcessRequestId);
	}

	/**
	 * Returns the sample process request matching the UUID and group.
	 *
	 * @param uuid the sample process request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching sample process request
	 * @throws PortalException if a matching sample process request could not be found
	 */
	public static com.adjecti.pis.liferay.model.SampleProcessRequest
			getSampleProcessRequestByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getSampleProcessRequestByUuidAndGroupId(
			uuid, groupId);
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
	public static java.util.List
		<com.adjecti.pis.liferay.model.SampleProcessRequest>
			getSampleProcessRequests(int start, int end) {

		return getService().getSampleProcessRequests(start, end);
	}

	/**
	 * Returns all the sample process requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the sample process requests
	 * @param companyId the primary key of the company
	 * @return the matching sample process requests, or an empty list if no matches were found
	 */
	public static java.util.List
		<com.adjecti.pis.liferay.model.SampleProcessRequest>
			getSampleProcessRequestsByUuidAndCompanyId(
				String uuid, long companyId) {

		return getService().getSampleProcessRequestsByUuidAndCompanyId(
			uuid, companyId);
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
	public static java.util.List
		<com.adjecti.pis.liferay.model.SampleProcessRequest>
			getSampleProcessRequestsByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.adjecti.pis.liferay.model.SampleProcessRequest>
						orderByComparator) {

		return getService().getSampleProcessRequestsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of sample process requests.
	 *
	 * @return the number of sample process requests
	 */
	public static int getSampleProcessRequestsCount() {
		return getService().getSampleProcessRequestsCount();
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
	public static com.adjecti.pis.liferay.model.SampleProcessRequest
		updateSampleProcessRequest(
			com.adjecti.pis.liferay.model.SampleProcessRequest
				sampleProcessRequest) {

		return getService().updateSampleProcessRequest(sampleProcessRequest);
	}

	public static SampleProcessRequestLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<SampleProcessRequestLocalService, SampleProcessRequestLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			SampleProcessRequestLocalService.class);

		ServiceTracker
			<SampleProcessRequestLocalService, SampleProcessRequestLocalService>
				serviceTracker =
					new ServiceTracker
						<SampleProcessRequestLocalService,
						 SampleProcessRequestLocalService>(
							 bundle.getBundleContext(),
							 SampleProcessRequestLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}