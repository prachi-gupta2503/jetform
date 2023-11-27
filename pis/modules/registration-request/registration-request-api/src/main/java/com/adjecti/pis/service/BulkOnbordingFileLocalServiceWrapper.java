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

package com.adjecti.pis.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BulkOnbordingFileLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BulkOnbordingFileLocalService
 * @generated
 */
public class BulkOnbordingFileLocalServiceWrapper
	implements BulkOnbordingFileLocalService,
			   ServiceWrapper<BulkOnbordingFileLocalService> {

	public BulkOnbordingFileLocalServiceWrapper(
		BulkOnbordingFileLocalService bulkOnbordingFileLocalService) {

		_bulkOnbordingFileLocalService = bulkOnbordingFileLocalService;
	}

	/**
	 * Adds the bulk onbording file to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BulkOnbordingFileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bulkOnbordingFile the bulk onbording file
	 * @return the bulk onbording file that was added
	 */
	@Override
	public com.adjecti.pis.model.BulkOnbordingFile addBulkOnbordingFile(
		com.adjecti.pis.model.BulkOnbordingFile bulkOnbordingFile) {

		return _bulkOnbordingFileLocalService.addBulkOnbordingFile(
			bulkOnbordingFile);
	}

	/**
	 * Creates a new bulk onbording file with the primary key. Does not add the bulk onbording file to the database.
	 *
	 * @param bulkOnbordingFileId the primary key for the new bulk onbording file
	 * @return the new bulk onbording file
	 */
	@Override
	public com.adjecti.pis.model.BulkOnbordingFile createBulkOnbordingFile(
		long bulkOnbordingFileId) {

		return _bulkOnbordingFileLocalService.createBulkOnbordingFile(
			bulkOnbordingFileId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bulkOnbordingFileLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the bulk onbording file from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BulkOnbordingFileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bulkOnbordingFile the bulk onbording file
	 * @return the bulk onbording file that was removed
	 */
	@Override
	public com.adjecti.pis.model.BulkOnbordingFile deleteBulkOnbordingFile(
		com.adjecti.pis.model.BulkOnbordingFile bulkOnbordingFile) {

		return _bulkOnbordingFileLocalService.deleteBulkOnbordingFile(
			bulkOnbordingFile);
	}

	/**
	 * Deletes the bulk onbording file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BulkOnbordingFileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bulkOnbordingFileId the primary key of the bulk onbording file
	 * @return the bulk onbording file that was removed
	 * @throws PortalException if a bulk onbording file with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.model.BulkOnbordingFile deleteBulkOnbordingFile(
			long bulkOnbordingFileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bulkOnbordingFileLocalService.deleteBulkOnbordingFile(
			bulkOnbordingFileId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bulkOnbordingFileLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _bulkOnbordingFileLocalService.dynamicQuery();
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

		return _bulkOnbordingFileLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.model.impl.BulkOnbordingFileModelImpl</code>.
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

		return _bulkOnbordingFileLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.model.impl.BulkOnbordingFileModelImpl</code>.
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

		return _bulkOnbordingFileLocalService.dynamicQuery(
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

		return _bulkOnbordingFileLocalService.dynamicQueryCount(dynamicQuery);
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

		return _bulkOnbordingFileLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.pis.model.BulkOnbordingFile fetchBulkOnbordingFile(
		long bulkOnbordingFileId) {

		return _bulkOnbordingFileLocalService.fetchBulkOnbordingFile(
			bulkOnbordingFileId);
	}

	/**
	 * Returns the bulk onbording file matching the UUID and group.
	 *
	 * @param uuid the bulk onbording file's UUID
	 * @param groupId the primary key of the group
	 * @return the matching bulk onbording file, or <code>null</code> if a matching bulk onbording file could not be found
	 */
	@Override
	public com.adjecti.pis.model.BulkOnbordingFile
		fetchBulkOnbordingFileByUuidAndGroupId(String uuid, long groupId) {

		return _bulkOnbordingFileLocalService.
			fetchBulkOnbordingFileByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _bulkOnbordingFileLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.adjecti.pis.model.BulkOnbordingFile>
			getBulkOnboardingRecords(long userId, long unitId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bulkOnbordingFileLocalService.getBulkOnboardingRecords(
			userId, unitId);
	}

	@Override
	public java.util.List<com.adjecti.pis.model.BulkOnbordingFile>
			getBulkOnboardingRecordsByUserId(long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bulkOnbordingFileLocalService.getBulkOnboardingRecordsByUserId(
			userId);
	}

	/**
	 * Returns the bulk onbording file with the primary key.
	 *
	 * @param bulkOnbordingFileId the primary key of the bulk onbording file
	 * @return the bulk onbording file
	 * @throws PortalException if a bulk onbording file with the primary key could not be found
	 */
	@Override
	public com.adjecti.pis.model.BulkOnbordingFile getBulkOnbordingFile(
			long bulkOnbordingFileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bulkOnbordingFileLocalService.getBulkOnbordingFile(
			bulkOnbordingFileId);
	}

	/**
	 * Returns the bulk onbording file matching the UUID and group.
	 *
	 * @param uuid the bulk onbording file's UUID
	 * @param groupId the primary key of the group
	 * @return the matching bulk onbording file
	 * @throws PortalException if a matching bulk onbording file could not be found
	 */
	@Override
	public com.adjecti.pis.model.BulkOnbordingFile
			getBulkOnbordingFileByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bulkOnbordingFileLocalService.
			getBulkOnbordingFileByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the bulk onbording files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.pis.model.impl.BulkOnbordingFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bulk onbording files
	 * @param end the upper bound of the range of bulk onbording files (not inclusive)
	 * @return the range of bulk onbording files
	 */
	@Override
	public java.util.List<com.adjecti.pis.model.BulkOnbordingFile>
		getBulkOnbordingFiles(int start, int end) {

		return _bulkOnbordingFileLocalService.getBulkOnbordingFiles(start, end);
	}

	/**
	 * Returns all the bulk onbording files matching the UUID and company.
	 *
	 * @param uuid the UUID of the bulk onbording files
	 * @param companyId the primary key of the company
	 * @return the matching bulk onbording files, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.adjecti.pis.model.BulkOnbordingFile>
		getBulkOnbordingFilesByUuidAndCompanyId(String uuid, long companyId) {

		return _bulkOnbordingFileLocalService.
			getBulkOnbordingFilesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of bulk onbording files matching the UUID and company.
	 *
	 * @param uuid the UUID of the bulk onbording files
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of bulk onbording files
	 * @param end the upper bound of the range of bulk onbording files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching bulk onbording files, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.adjecti.pis.model.BulkOnbordingFile>
		getBulkOnbordingFilesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.adjecti.pis.model.BulkOnbordingFile> orderByComparator) {

		return _bulkOnbordingFileLocalService.
			getBulkOnbordingFilesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of bulk onbording files.
	 *
	 * @return the number of bulk onbording files
	 */
	@Override
	public int getBulkOnbordingFilesCount() {
		return _bulkOnbordingFileLocalService.getBulkOnbordingFilesCount();
	}

	@Override
	public int getBulkOnbordingFilesCount(long unitId) {
		return _bulkOnbordingFileLocalService.getBulkOnbordingFilesCount(
			unitId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _bulkOnbordingFileLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _bulkOnbordingFileLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _bulkOnbordingFileLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bulkOnbordingFileLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public int getUploadedRecordsCount(long unitId) {
		return _bulkOnbordingFileLocalService.getUploadedRecordsCount(unitId);
	}

	/**
	 * Updates the bulk onbording file in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BulkOnbordingFileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bulkOnbordingFile the bulk onbording file
	 * @return the bulk onbording file that was updated
	 */
	@Override
	public com.adjecti.pis.model.BulkOnbordingFile updateBulkOnbordingFile(
		com.adjecti.pis.model.BulkOnbordingFile bulkOnbordingFile) {

		return _bulkOnbordingFileLocalService.updateBulkOnbordingFile(
			bulkOnbordingFile);
	}

	@Override
	public BulkOnbordingFileLocalService getWrappedService() {
		return _bulkOnbordingFileLocalService;
	}

	@Override
	public void setWrappedService(
		BulkOnbordingFileLocalService bulkOnbordingFileLocalService) {

		_bulkOnbordingFileLocalService = bulkOnbordingFileLocalService;
	}

	private BulkOnbordingFileLocalService _bulkOnbordingFileLocalService;

}