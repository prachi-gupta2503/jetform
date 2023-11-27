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

package com.adjecti.noting.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link NotingLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see NotingLocalService
 * @generated
 */
public class NotingLocalServiceWrapper
	implements NotingLocalService, ServiceWrapper<NotingLocalService> {

	public NotingLocalServiceWrapper(NotingLocalService notingLocalService) {
		_notingLocalService = notingLocalService;
	}

	/**
	 * Adds the noting to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NotingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param noting the noting
	 * @return the noting that was added
	 */
	@Override
	public com.adjecti.noting.model.Noting addNoting(
		com.adjecti.noting.model.Noting noting) {

		return _notingLocalService.addNoting(noting);
	}

	@Override
	public com.adjecti.noting.model.Noting addNoting(
			String title, String content, long pdfId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _notingLocalService.addNoting(title, content, pdfId);
	}

	/**
	 * Creates a new noting with the primary key. Does not add the noting to the database.
	 *
	 * @param noteId the primary key for the new noting
	 * @return the new noting
	 */
	@Override
	public com.adjecti.noting.model.Noting createNoting(long noteId) {
		return _notingLocalService.createNoting(noteId);
	}

	/**
	 * Deletes the noting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NotingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param noteId the primary key of the noting
	 * @return the noting that was removed
	 * @throws PortalException if a noting with the primary key could not be found
	 */
	@Override
	public com.adjecti.noting.model.Noting deleteNoting(long noteId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _notingLocalService.deleteNoting(noteId);
	}

	/**
	 * Deletes the noting from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NotingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param noting the noting
	 * @return the noting that was removed
	 */
	@Override
	public com.adjecti.noting.model.Noting deleteNoting(
		com.adjecti.noting.model.Noting noting) {

		return _notingLocalService.deleteNoting(noting);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _notingLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _notingLocalService.dynamicQuery();
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

		return _notingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.noting.model.impl.NotingModelImpl</code>.
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

		return _notingLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.noting.model.impl.NotingModelImpl</code>.
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

		return _notingLocalService.dynamicQuery(
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

		return _notingLocalService.dynamicQueryCount(dynamicQuery);
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

		return _notingLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.adjecti.noting.model.Noting fetchNoting(long noteId) {
		return _notingLocalService.fetchNoting(noteId);
	}

	/**
	 * Returns the noting matching the UUID and group.
	 *
	 * @param uuid the noting's UUID
	 * @param groupId the primary key of the group
	 * @return the matching noting, or <code>null</code> if a matching noting could not be found
	 */
	@Override
	public com.adjecti.noting.model.Noting fetchNotingByUuidAndGroupId(
		String uuid, long groupId) {

		return _notingLocalService.fetchNotingByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _notingLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _notingLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _notingLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the noting with the primary key.
	 *
	 * @param noteId the primary key of the noting
	 * @return the noting
	 * @throws PortalException if a noting with the primary key could not be found
	 */
	@Override
	public com.adjecti.noting.model.Noting getNoting(long noteId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _notingLocalService.getNoting(noteId);
	}

	/**
	 * Returns the noting matching the UUID and group.
	 *
	 * @param uuid the noting's UUID
	 * @param groupId the primary key of the group
	 * @return the matching noting
	 * @throws PortalException if a matching noting could not be found
	 */
	@Override
	public com.adjecti.noting.model.Noting getNotingByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _notingLocalService.getNotingByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the notings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.noting.model.impl.NotingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of notings
	 * @param end the upper bound of the range of notings (not inclusive)
	 * @return the range of notings
	 */
	@Override
	public java.util.List<com.adjecti.noting.model.Noting> getNotings(
		int start, int end) {

		return _notingLocalService.getNotings(start, end);
	}

	/**
	 * Returns all the notings matching the UUID and company.
	 *
	 * @param uuid the UUID of the notings
	 * @param companyId the primary key of the company
	 * @return the matching notings, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.adjecti.noting.model.Noting>
		getNotingsByUuidAndCompanyId(String uuid, long companyId) {

		return _notingLocalService.getNotingsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of notings matching the UUID and company.
	 *
	 * @param uuid the UUID of the notings
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of notings
	 * @param end the upper bound of the range of notings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching notings, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.adjecti.noting.model.Noting>
		getNotingsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.adjecti.noting.model.Noting> orderByComparator) {

		return _notingLocalService.getNotingsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of notings.
	 *
	 * @return the number of notings
	 */
	@Override
	public int getNotingsCount() {
		return _notingLocalService.getNotingsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _notingLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _notingLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the noting in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NotingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param noting the noting
	 * @return the noting that was updated
	 */
	@Override
	public com.adjecti.noting.model.Noting updateNoting(
		com.adjecti.noting.model.Noting noting) {

		return _notingLocalService.updateNoting(noting);
	}

	@Override
	public NotingLocalService getWrappedService() {
		return _notingLocalService;
	}

	@Override
	public void setWrappedService(NotingLocalService notingLocalService) {
		_notingLocalService = notingLocalService;
	}

	private NotingLocalService _notingLocalService;

}