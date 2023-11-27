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
 * Provides a wrapper for {@link DashboardWidgetService}.
 *
 * @author Brian Wing Shun Chan
 * @see DashboardWidgetService
 * @generated
 */
public class DashboardWidgetServiceWrapper
	implements DashboardWidgetService, ServiceWrapper<DashboardWidgetService> {

	public DashboardWidgetServiceWrapper(
		DashboardWidgetService dashboardWidgetService) {

		_dashboardWidgetService = dashboardWidgetService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dashboardWidgetService.getOSGiServiceIdentifier();
	}

	@Override
	public DashboardWidgetService getWrappedService() {
		return _dashboardWidgetService;
	}

	@Override
	public void setWrappedService(
		DashboardWidgetService dashboardWidgetService) {

		_dashboardWidgetService = dashboardWidgetService;
	}

	private DashboardWidgetService _dashboardWidgetService;

}