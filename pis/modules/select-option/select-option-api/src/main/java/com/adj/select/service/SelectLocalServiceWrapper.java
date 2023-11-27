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

package com.adj.select.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SelectLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SelectLocalService
 * @generated
 */
public class SelectLocalServiceWrapper
	implements SelectLocalService, ServiceWrapper<SelectLocalService> {

	public SelectLocalServiceWrapper(SelectLocalService selectLocalService) {
		_selectLocalService = selectLocalService;
	}

	/**
	 * Adds the select to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SelectLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param select the select
	 * @return the select that was added
	 */
	@Override
	public com.adj.select.model.Select addSelect(
		com.adj.select.model.Select select) {

		return _selectLocalService.addSelect(select);
	}

	/**
	 * Creates a new select with the primary key. Does not add the select to the database.
	 *
	 * @param idFieldName the primary key for the new select
	 * @return the new select
	 */
	@Override
	public com.adj.select.model.Select createSelect(String idFieldName) {
		return _selectLocalService.createSelect(idFieldName);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _selectLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the select from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SelectLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param select the select
	 * @return the select that was removed
	 */
	@Override
	public com.adj.select.model.Select deleteSelect(
		com.adj.select.model.Select select) {

		return _selectLocalService.deleteSelect(select);
	}

	/**
	 * Deletes the select with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SelectLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param idFieldName the primary key of the select
	 * @return the select that was removed
	 * @throws PortalException if a select with the primary key could not be found
	 */
	@Override
	public com.adj.select.model.Select deleteSelect(String idFieldName)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _selectLocalService.deleteSelect(idFieldName);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _selectLocalService.dynamicQuery();
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

		return _selectLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adj.select.model.impl.SelectModelImpl</code>.
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

		return _selectLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adj.select.model.impl.SelectModelImpl</code>.
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

		return _selectLocalService.dynamicQuery(
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

		return _selectLocalService.dynamicQueryCount(dynamicQuery);
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

		return _selectLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.adj.select.model.Select fetchSelect(String idFieldName) {
		return _selectLocalService.fetchSelect(idFieldName);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _selectLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _selectLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the select with the primary key.
	 *
	 * @param idFieldName the primary key of the select
	 * @return the select
	 * @throws PortalException if a select with the primary key could not be found
	 */
	@Override
	public com.adj.select.model.Select getSelect(String idFieldName)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _selectLocalService.getSelect(idFieldName);
	}

	@Override
	public java.util.List<com.adj.select.dto.SelectOptionsDTO>
			getSelectOptionsData(
				String idFieldName, String valueFieldName, String tableName)
		throws com.adj.select.exception.NoSuchSelectException {

		return _selectLocalService.getSelectOptionsData(
			idFieldName, valueFieldName, tableName);
	}

	/**
	 * Returns a range of all the selects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adj.select.model.impl.SelectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of selects
	 * @param end the upper bound of the range of selects (not inclusive)
	 * @return the range of selects
	 */
	@Override
	public java.util.List<com.adj.select.model.Select> getSelects(
		int start, int end) {

		return _selectLocalService.getSelects(start, end);
	}

	/**
	 * Returns the number of selects.
	 *
	 * @return the number of selects
	 */
	@Override
	public int getSelectsCount() {
		return _selectLocalService.getSelectsCount();
	}

	/**
	 * Updates the select in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SelectLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param select the select
	 * @return the select that was updated
	 */
	@Override
	public com.adj.select.model.Select updateSelect(
		com.adj.select.model.Select select) {

		return _selectLocalService.updateSelect(select);
	}

	@Override
	public SelectLocalService getWrappedService() {
		return _selectLocalService;
	}

	@Override
	public void setWrappedService(SelectLocalService selectLocalService) {
		_selectLocalService = selectLocalService;
	}

	private SelectLocalService _selectLocalService;

}