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

package com.adjecti.dashboard.widget.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DashboardWidgetLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DashboardWidgetLocalService
 * @generated
 */
public class DashboardWidgetLocalServiceWrapper
	implements DashboardWidgetLocalService,
			   ServiceWrapper<DashboardWidgetLocalService> {

	public DashboardWidgetLocalServiceWrapper(
		DashboardWidgetLocalService dashboardWidgetLocalService) {

		_dashboardWidgetLocalService = dashboardWidgetLocalService;
	}

	/**
	 * Adds the dashboard widget to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DashboardWidgetLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dashboardWidget the dashboard widget
	 * @return the dashboard widget that was added
	 */
	@Override
	public com.adjecti.dashboard.widget.model.DashboardWidget
		addDashboardWidget(
			com.adjecti.dashboard.widget.model.DashboardWidget
				dashboardWidget) {

		return _dashboardWidgetLocalService.addDashboardWidget(dashboardWidget);
	}

	/**
	 * Creates a new dashboard widget with the primary key. Does not add the dashboard widget to the database.
	 *
	 * @param dashboardWidgetId the primary key for the new dashboard widget
	 * @return the new dashboard widget
	 */
	@Override
	public com.adjecti.dashboard.widget.model.DashboardWidget
		createDashboardWidget(long dashboardWidgetId) {

		return _dashboardWidgetLocalService.createDashboardWidget(
			dashboardWidgetId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dashboardWidgetLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the dashboard widget from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DashboardWidgetLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dashboardWidget the dashboard widget
	 * @return the dashboard widget that was removed
	 */
	@Override
	public com.adjecti.dashboard.widget.model.DashboardWidget
		deleteDashboardWidget(
			com.adjecti.dashboard.widget.model.DashboardWidget
				dashboardWidget) {

		return _dashboardWidgetLocalService.deleteDashboardWidget(
			dashboardWidget);
	}

	/**
	 * Deletes the dashboard widget with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DashboardWidgetLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dashboardWidgetId the primary key of the dashboard widget
	 * @return the dashboard widget that was removed
	 * @throws PortalException if a dashboard widget with the primary key could not be found
	 */
	@Override
	public com.adjecti.dashboard.widget.model.DashboardWidget
			deleteDashboardWidget(long dashboardWidgetId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dashboardWidgetLocalService.deleteDashboardWidget(
			dashboardWidgetId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dashboardWidgetLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dashboardWidgetLocalService.dynamicQuery();
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

		return _dashboardWidgetLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.dashboard.widget.model.impl.DashboardWidgetModelImpl</code>.
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

		return _dashboardWidgetLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.dashboard.widget.model.impl.DashboardWidgetModelImpl</code>.
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

		return _dashboardWidgetLocalService.dynamicQuery(
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

		return _dashboardWidgetLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dashboardWidgetLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.dashboard.widget.model.DashboardWidget
		fetchDashboardWidget(long dashboardWidgetId) {

		return _dashboardWidgetLocalService.fetchDashboardWidget(
			dashboardWidgetId);
	}

	/**
	 * Returns the dashboard widget matching the UUID and group.
	 *
	 * @param uuid the dashboard widget's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dashboard widget, or <code>null</code> if a matching dashboard widget could not be found
	 */
	@Override
	public com.adjecti.dashboard.widget.model.DashboardWidget
		fetchDashboardWidgetByUuidAndGroupId(String uuid, long groupId) {

		return _dashboardWidgetLocalService.
			fetchDashboardWidgetByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dashboardWidgetLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the dashboard widget with the primary key.
	 *
	 * @param dashboardWidgetId the primary key of the dashboard widget
	 * @return the dashboard widget
	 * @throws PortalException if a dashboard widget with the primary key could not be found
	 */
	@Override
	public com.adjecti.dashboard.widget.model.DashboardWidget
			getDashboardWidget(long dashboardWidgetId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dashboardWidgetLocalService.getDashboardWidget(
			dashboardWidgetId);
	}

	/**
	 * Returns the dashboard widget matching the UUID and group.
	 *
	 * @param uuid the dashboard widget's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dashboard widget
	 * @throws PortalException if a matching dashboard widget could not be found
	 */
	@Override
	public com.adjecti.dashboard.widget.model.DashboardWidget
			getDashboardWidgetByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dashboardWidgetLocalService.getDashboardWidgetByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the dashboard widgets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.dashboard.widget.model.impl.DashboardWidgetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dashboard widgets
	 * @param end the upper bound of the range of dashboard widgets (not inclusive)
	 * @return the range of dashboard widgets
	 */
	@Override
	public java.util.List<com.adjecti.dashboard.widget.model.DashboardWidget>
		getDashboardWidgets(int start, int end) {

		return _dashboardWidgetLocalService.getDashboardWidgets(start, end);
	}

	/**
	 * Returns all the dashboard widgets matching the UUID and company.
	 *
	 * @param uuid the UUID of the dashboard widgets
	 * @param companyId the primary key of the company
	 * @return the matching dashboard widgets, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.adjecti.dashboard.widget.model.DashboardWidget>
		getDashboardWidgetsByUuidAndCompanyId(String uuid, long companyId) {

		return _dashboardWidgetLocalService.
			getDashboardWidgetsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of dashboard widgets matching the UUID and company.
	 *
	 * @param uuid the UUID of the dashboard widgets
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of dashboard widgets
	 * @param end the upper bound of the range of dashboard widgets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching dashboard widgets, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.adjecti.dashboard.widget.model.DashboardWidget>
		getDashboardWidgetsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.adjecti.dashboard.widget.model.DashboardWidget>
					orderByComparator) {

		return _dashboardWidgetLocalService.
			getDashboardWidgetsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of dashboard widgets.
	 *
	 * @return the number of dashboard widgets
	 */
	@Override
	public int getDashboardWidgetsCount() {
		return _dashboardWidgetLocalService.getDashboardWidgetsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _dashboardWidgetLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dashboardWidgetLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dashboardWidgetLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dashboardWidgetLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the dashboard widget in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DashboardWidgetLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dashboardWidget the dashboard widget
	 * @return the dashboard widget that was updated
	 */
	@Override
	public com.adjecti.dashboard.widget.model.DashboardWidget
		updateDashboardWidget(
			com.adjecti.dashboard.widget.model.DashboardWidget
				dashboardWidget) {

		return _dashboardWidgetLocalService.updateDashboardWidget(
			dashboardWidget);
	}

	@Override
	public DashboardWidgetLocalService getWrappedService() {
		return _dashboardWidgetLocalService;
	}

	@Override
	public void setWrappedService(
		DashboardWidgetLocalService dashboardWidgetLocalService) {

		_dashboardWidgetLocalService = dashboardWidgetLocalService;
	}

	private DashboardWidgetLocalService _dashboardWidgetLocalService;

}