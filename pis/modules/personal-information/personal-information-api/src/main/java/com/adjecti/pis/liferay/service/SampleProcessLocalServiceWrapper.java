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
 * Provides a wrapper for {@link SampleProcessLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SampleProcessLocalService
 * @generated
 */
public class SampleProcessLocalServiceWrapper
	implements SampleProcessLocalService,
			   ServiceWrapper<SampleProcessLocalService> {

	public SampleProcessLocalServiceWrapper(
		SampleProcessLocalService sampleProcessLocalService) {

		_sampleProcessLocalService = sampleProcessLocalService;
	}

	/**
	 * Adds the sample process to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SampleProcessLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sampleProcess the sample process
	 * @return the sample process that was added
	 */
	@Override
	public com.adjecti.pis.liferay.model.SampleProcess addSampleProcess(
		com.adjecti.pis.liferay.model.SampleProcess sampleProcess) {

		return _sampleProcessLocalService.addSampleProcess(sampleProcess);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sampleProcessLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new sample process with the primary key. Does not add the sample process to the database.
	 *
	 * @param sampleProcessId the primary key for the new sample process
	 * @return the new sample process
	 */
	@Override
	public com.adjecti.pis.liferay.model.SampleProcess createSampleProcess(
		long sampleProcessId) {

		return _sampleProcessLocalService.createSampleProcess(sampleProcessId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sampleProcessLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the sample process with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SampleProcessLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sampleProcessId the primary key of the sample process
	 * @return the sample process that was removed
	 * @throws PortalException if a sample process with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.SampleProcess deleteSampleProcess(
			long sampleProcessId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sampleProcessLocalService.deleteSampleProcess(sampleProcessId);
	}

	/**
	 * Deletes the sample process from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SampleProcessLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sampleProcess the sample process
	 * @return the sample process that was removed
	 */
	@Override
	public com.adjecti.pis.liferay.model.SampleProcess deleteSampleProcess(
		com.adjecti.pis.liferay.model.SampleProcess sampleProcess) {

		return _sampleProcessLocalService.deleteSampleProcess(sampleProcess);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _sampleProcessLocalService.dynamicQuery();
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

		return _sampleProcessLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.SampleProcessModelImpl</code>.
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

		return _sampleProcessLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.SampleProcessModelImpl</code>.
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

		return _sampleProcessLocalService.dynamicQuery(
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

		return _sampleProcessLocalService.dynamicQueryCount(dynamicQuery);
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

		return _sampleProcessLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.liferay.model.SampleProcess fetchSampleProcess(
		long sampleProcessId) {

		return _sampleProcessLocalService.fetchSampleProcess(sampleProcessId);
	}

	/**
	 * Returns the sample process matching the UUID and group.
	 *
	 * @param uuid the sample process's UUID
	 * @param groupId the primary key of the group
	 * @return the matching sample process, or <code>null</code> if a matching sample process could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.SampleProcess
		fetchSampleProcessByUuidAndGroupId(String uuid, long groupId) {

		return _sampleProcessLocalService.fetchSampleProcessByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _sampleProcessLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _sampleProcessLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _sampleProcessLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _sampleProcessLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sampleProcessLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the sample process with the primary key.
	 *
	 * @param sampleProcessId the primary key of the sample process
	 * @return the sample process
	 * @throws PortalException if a sample process with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.SampleProcess getSampleProcess(
			long sampleProcessId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sampleProcessLocalService.getSampleProcess(sampleProcessId);
	}

	/**
	 * Returns the sample process matching the UUID and group.
	 *
	 * @param uuid the sample process's UUID
	 * @param groupId the primary key of the group
	 * @return the matching sample process
	 * @throws PortalException if a matching sample process could not be found
	 */
	@Override
	public com.adjecti.pis.liferay.model.SampleProcess
			getSampleProcessByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sampleProcessLocalService.getSampleProcessByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the sample processes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.liferay.model.impl.SampleProcessModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sample processes
	 * @param end the upper bound of the range of sample processes (not inclusive)
	 * @return the range of sample processes
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.SampleProcess>
		getSampleProcesses(int start, int end) {

		return _sampleProcessLocalService.getSampleProcesses(start, end);
	}

	/**
	 * Returns all the sample processes matching the UUID and company.
	 *
	 * @param uuid the UUID of the sample processes
	 * @param companyId the primary key of the company
	 * @return the matching sample processes, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.SampleProcess>
		getSampleProcessesByUuidAndCompanyId(String uuid, long companyId) {

		return _sampleProcessLocalService.getSampleProcessesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of sample processes matching the UUID and company.
	 *
	 * @param uuid the UUID of the sample processes
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of sample processes
	 * @param end the upper bound of the range of sample processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching sample processes, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.adjecti.pis.liferay.model.SampleProcess>
		getSampleProcessesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.adjecti.pis.liferay.model.SampleProcess>
					orderByComparator) {

		return _sampleProcessLocalService.getSampleProcessesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of sample processes.
	 *
	 * @return the number of sample processes
	 */
	@Override
	public int getSampleProcessesCount() {
		return _sampleProcessLocalService.getSampleProcessesCount();
	}

	/**
	 * Updates the sample process in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SampleProcessLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sampleProcess the sample process
	 * @return the sample process that was updated
	 */
	@Override
	public com.adjecti.pis.liferay.model.SampleProcess updateSampleProcess(
		com.adjecti.pis.liferay.model.SampleProcess sampleProcess) {

		return _sampleProcessLocalService.updateSampleProcess(sampleProcess);
	}

	@Override
	public SampleProcessLocalService getWrappedService() {
		return _sampleProcessLocalService;
	}

	@Override
	public void setWrappedService(
		SampleProcessLocalService sampleProcessLocalService) {

		_sampleProcessLocalService = sampleProcessLocalService;
	}

	private SampleProcessLocalService _sampleProcessLocalService;

}